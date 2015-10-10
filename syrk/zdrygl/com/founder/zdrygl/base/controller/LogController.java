package com.founder.zdrygl.base.controller;

import java.util.List;

import javax.annotation.Resource;

import logDev.OperationLogServiceDev;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.founder.framework.annotation.RestfulAnnotation;
import com.founder.framework.base.controller.BaseController;
import com.founder.framework.entity.OperationLog;
import com.founder.syrkgl.bean.RyRyjbxxb;
import com.founder.syrkgl.bean.SyrkSyrkxxzb;
import com.founder.zdrygl.base.service.DataApplyService;

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
	
	@Resource(name = "operationLogServiceDev")
	private OperationLogServiceDev operationLogService;
		
	/**
	 * 
	 * @Title: queryOperationLogById
	 * @Description: TODO(通过主键NUM_ID查询单条日志记录)
	 * @param @param num_id
	 * @param @return    设定文件
	 * @return OperationLog    返回类型
	 * @throw
	 */
	@RequestMapping(value = "/queryOperationLogById", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody OperationLog queryOperationLogById(String num_id){			
		return operationLogService.queryOperationLogById(num_id);
	}
	
	/**
	 * 
	 * @Title: queryOperationLogListByEntity
	 * @Description: TODO(通过日志对象查询list)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return List<OperationLog>    返回类型
	 * @throw
	 */
	@RequestMapping(value = "/queryOperationLogListByEntity", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody List<OperationLog> queryOperationLogListByEntity(OperationLog entity){			
		return operationLogService.queryOperationLogListByEntity(entity);
	}
	
	/**
	 * 
	 * @Title: countOperationLogByType
	 * @Description: TODO(通过日志类型和时间段统计数量)
	 * @param @param operate_type
	 * @param @param startDate(例如：>=20140805135647)
	 * @param @param endDate(例如：<20150805135647)
	 * @param @return    设定文件
	 * @return int    返回类型
	 * @throw
	 */
	@RequestMapping(value = "/countOperationLogByType", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody int countOperationLogByType(String operate_type,String startDate,String endDate){			
		return operationLogService.countOperationLogByType(operate_type,startDate,endDate);
	}
}
