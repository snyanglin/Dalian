package com.founder.zdrygl.workflow;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.founder.framework.organization.department.bean.OrgOrganization;
import com.founder.framework.organization.department.service.OrgOrganizationService;
import com.founder.framework.organization.position.service.OrgPositionService;
import com.founder.workflow.bean.BaseWorkFlowBean;
import com.founder.workflow.service.activiti.lisener.WorkflowDelegate;

/**
 * ****************************************************************************
 * @Package:      [com.founder.zdrygl.until.Userbmjs.java]  
 * @ClassName:    [Userbmjs]   
 * @Description:  [动态计算审批人]   
 * @Author:       [cong_rihong@founder.com.cn]  
 * @CreateDate:   [2015年8月11日 上午11:07:19]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015年8月11日 上午11:07:19，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Component
public class Sgafywjs extends WorkflowDelegate {
	@Resource(name = "orgOrganizationService")
	private OrgOrganizationService orgOrganizationService;
	@Resource
	private OrgPositionService orgPositionService;

	@Override
	public void doBusiness(BaseWorkFlowBean arg0) {
		Map<String,Object> variables = arg0.getProcessVariables();
		//String zdrylx = (String) variables.get("zdrylx");
		String sqrOrgCode = (String) variables.get("sqrOrgCode");
		OrgOrganization orgOrganization = orgOrganizationService.queryUpOrgByLevel(sqrOrgCode, "32");
		String fsxOrgCode = orgOrganization.getOrgcode();// 得到本名等级为三级，派出所部门code
		String taskParameter = fsxOrgCode + "_"
				+ orgPositionService.queryByPosid("SZ").getId().toString(); // 部门code+所长岗位ID
		variables.put("approvalMethod", "sgafApproval");
		variables.put("szsp", taskParameter);

	}

	@Override
	public void sendMsgByType(BaseWorkFlowBean bwf, String msgType) {
		// TODO Auto-generated method stub
		
	}
	

}
