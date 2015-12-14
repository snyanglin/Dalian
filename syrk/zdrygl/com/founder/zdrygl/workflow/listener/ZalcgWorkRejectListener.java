package com.founder.zdrygl.workflow.listener;

import org.springframework.stereotype.Component;

@Component("zalcgWorkRejectListener")
public class ZalcgWorkRejectListener extends WorkRejectListener {
	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 */
	private static final long serialVersionUID = 3110470832214029532L;
	@Override
	public void defineJumpRule() {
		String szApprovedType = (String) globalExecution.getVariable("szApprovedType");
		if(szApprovedType.trim().equals("0")){
			//确定启动的task前一个活动
			targetTaskDefinitionKey = "usertask6";//"usertask6";//"exclusivegateway5";
			
		}
	}
}
