package com.founder.zdrygl.workflow.listener;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.util.WebUtils;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.components.AppConst;
import com.founder.framework.organization.department.service.OrgOrganizationService;
import com.founder.framework.organization.position.service.OrgPositionService;

/**
 * 
 * @author heminxi
 *
 */
@Component
public class szApprovalTaskListener implements JavaDelegate {

	@Resource(name = "orgOrganizationService")
	private OrgOrganizationService orgOrganizationService;
	
	@Resource(name = "orgPositionService")
	private OrgPositionService orgPositionService;
		
	@Override
	public void execute(DelegateExecution paramDelegateExecution)
			throws Exception {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes()).getRequest();
		SessionBean sessionBean = (SessionBean) WebUtils.getSessionAttribute(
				request, AppConst.USER_SESSION);
    	String posid= (String) paramDelegateExecution.getVariable("posid");
    	String szApprovedType= (String) paramDelegateExecution.getVariable("szApprovedType");
    	String sporgcode= sessionBean.getUserOrgCode();//(String) paramDelegateExecution.getVariable("sporgcode");
    	String orgposid= (String) paramDelegateExecution.getVariable("orgposid");
    	String nextSpUserId= (String) paramDelegateExecution.getVariable("nextSpUserId");
    	//如果不同意
    	if(szApprovedType.trim().equals("0")){
    		return;
    	}
    	
    	if((posid == null || posid.trim().equals(""))
    			&& (orgposid == null || orgposid.trim().equals(""))){
    		paramDelegateExecution.setVariable("szApprovedType", "1"); 
    	}else if(nextSpUserId == null || nextSpUserId.trim().equals("")){
    		//assign task to position
    		String taskParameter=sporgcode+"_"+orgPositionService.queryByPosid(posid).getId().toString();   //部门code+所长岗位ID
    		paramDelegateExecution.setVariable("fxjzg", taskParameter);
    		paramDelegateExecution.setVariable("szApprovedType", "2"); 
    		paramDelegateExecution.setVariable("approvalMethod", "fxjzgApproval");
    	}else{
    		//精确到人
    		paramDelegateExecution.setVariable("fxjzg", nextSpUserId);
    		paramDelegateExecution.setVariable("szApprovedType", "2"); 
    		paramDelegateExecution.setVariable("approvalMethod", "fxjzgApproval");
    	}
    	  
	}
}
