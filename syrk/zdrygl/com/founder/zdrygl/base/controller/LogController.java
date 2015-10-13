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
	
	@RequestMapping(value = "/countTrs", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody List countTrs(){		
		
		return operationLogService.countTrs();
	}		
}
