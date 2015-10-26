package com.founder.zdrygl.base.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.founder.framework.annotation.RestfulAnnotation;
import com.founder.framework.base.controller.BaseController;
import com.founder.framework.operationLog.service.OperationLogService;
import com.founder.framework.utils.DateTimeHelper;

/**
 * ****************************************************************************
 * @Package:      [com.founder.zdrygl.base.controller.LogController.java]  
 * @ClassName:    [LogController]   
 * @Description:  [日志查询控制器]   
 * @Author:       [zhang.hai@founder.com.cn]  
 * @CreateDate:   [2015年10月10日 上午10:32:12]   
 * @UpdateUser:   [ZhangHai(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015年10月10日 上午10:32:12，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Controller
@RequestMapping("log")
public class LogController extends BaseController {			
	
	@Resource(name = "operationLogService")
	private OperationLogService operationLogService;				
	
	/**
	 * 
	 * @Title: countTrs
	 * @Description: TODO(通过日志统计交易)
	 * @param @return    设定文件
	 * @return List    返回类型
	 * @throw
	 */
	@RestfulAnnotation(serverId="3")
	@RequestMapping(value = "/countTrs", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody List countTrs(){		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		Date date=new Date();
		String endDate=sdf.format(date);
		String startDate=sdf.format(DateTimeHelper.addSeconds(date,-60));
		List list=new LinkedList();
		//1、按操作成功失败统计：OPERATE_RESULT  0=失败  1=成功
		List<String> resultList=new ArrayList<String>(2);
		resultList.add("0");
		resultList.add("1");
		operationLogService.countByResult(list,startDate,endDate,resultList);
		//2、按操作类型统计：OPERATE_TYPE   1=查询 2=新增  3=修改 4=注销
		List<String> typeList=new ArrayList<String>(4);
		typeList.add("1");
		typeList.add("2");
		typeList.add("3");
		typeList.add("4");
		operationLogService.countByType(list,startDate,endDate,typeList);
		//3、按模块名称统计：MODNAME
		List<String> modList=new ArrayList<String>(4);
		modList.add("重点人员管理");
		modList.add("重点人员查询服务");
		modList.add("实有人口信息");
		modList.add("实有人口编辑");
		operationLogService.countByMod(list,startDate,endDate,modList,4);
		//4、按单位统计：ORGANIZATION
		List<String> orgList=new ArrayList<String>(4);
		orgList.add("祥和责任区");
		orgList.add("红旗派出所");
		orgList.add("甘井子分局");
		orgList.add("莲花山责任区");
		operationLogService.countByOrg(list,startDate,endDate,orgList,4);
		
		return list;			
	}		
}
