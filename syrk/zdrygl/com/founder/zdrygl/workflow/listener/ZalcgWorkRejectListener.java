package com.founder.zdrygl.workflow.listener;

import java.util.Map;

import org.springframework.stereotype.Component;
import com.founder.workflow.bean.BaseWorkFlowBean;
/**
 * ****************************************************************************
 * @Package:      [com.founder.zdrygl.workflow.listener.ZalcgWorkRejectListener.java]  
 * @ClassName:    [ZalcgWorkRejectListener]   
 * @Description:  [一句话描述该类的功能]   
 * @Author:       [huang_jifei@founder.com.cn]  
 * @CreateDate:   [2015年12月4日 下午2:41:42]   
 * @UpdateUser:   [huangjifei(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015年12月4日 下午2:41:42，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Component("zalcgWorkRejectListener")
public class ZalcgWorkRejectListener extends WorkRejectListener {
	private static final long serialVersionUID = 3110470832214029532L;

	@Override
	void defineJumpRule(BaseWorkFlowBean arg0) {
		Map<String,Object> variables = arg0.getProcessVariables();
		String szApprovedType = (String) variables.get("szApprovedType");
		targetTaskDefinitionKey = (String) variables.get("targetTaskDefinitionKey");
		if(szApprovedType.trim().equals("0")){
			//确定启动的task前一个活动 TODO:
			targetTaskDefinitionKey = "usertask6";//"usertask6";//"exclusivegateway5";
			
		}
	}
	
}
