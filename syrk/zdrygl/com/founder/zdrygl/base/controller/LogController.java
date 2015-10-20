package com.founder.zdrygl.base.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.founder.framework.annotation.RestfulAnnotation;
import com.founder.framework.base.controller.BaseController;
import com.founder.framework.operationLog.service.OperationLogService;

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
		
		return operationLogService.countTrs();
	}		
}
