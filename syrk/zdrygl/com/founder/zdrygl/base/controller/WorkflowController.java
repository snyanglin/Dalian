package com.founder.zdrygl.base.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.founder.framework.base.controller.BaseController;
import com.founder.zdrygl.base.service.WorkflowService;
import com.founder.zdrygl.workflow.utils.WorkflowUtil;

/**
 * ****************************************************************************
 * @Package:      [com.founder.zdrygl.base.controller.WorkflowController.java]  
 * @ClassName:    [WorkflowController]   
 * @Description:  [提供workflow相关的功能]   
 * @Author:       [huang_jifei@founder.com.cn]  
 * @CreateDate:   [2015年12月23日 上午11:24:08]   
 * @UpdateUser:   [huangjifei(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015年12月23日 上午11:24:08，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Controller
@RequestMapping("wf")
public class WorkflowController extends BaseController {			
	
	@Resource(name = "workflowService")
	private WorkflowService workflowService;				
	
	@RequestMapping(value = "/getProcDefId/{businessType}/{zdrygllxdm}", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody String getProcDefId(@PathVariable String businessType,@PathVariable String zdrygllxdm){
		String suffixName = "zalcg";
		suffixName = workflowService.getSuffixNameByZdryLxdm(businessType,zdrygllxdm);
		String procDefKey = WorkflowUtil.buildWorkflowKey(suffixName);
		return procDefKey;			
	}	
	
}
