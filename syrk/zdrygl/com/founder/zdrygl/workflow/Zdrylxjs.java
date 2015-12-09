package com.founder.zdrygl.workflow;

import java.util.Map;

import javax.annotation.Resource;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import com.founder.framework.organization.department.bean.OrgOrganization;
import com.founder.framework.organization.department.service.OrgOrganizationService;
import com.founder.framework.organization.position.service.OrgPositionService;
import com.founder.workflow.bean.BaseWorkFlowBean;
import com.founder.workflow.service.activiti.lisener.WorkflowDelegate;



/**
 * ****************************************************************************
 * @Package:      [com.founder.zdrygl.workflow.Zdrylxjs.java]  
 * @ClassName:    [Zdrylxjs]   
 * @Description:  [一句话描述该类的功能]   
 * @Author:       [he_minxi@founder.com.cn]  
 * @CreateDate:   [2015年8月4日 上午11:21:07]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015年8月4日 上午11:21:07，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */

@Component
public class Zdrylxjs extends WorkflowDelegate{

	
	@Resource(name = "orgOrganizationService")
	private OrgOrganizationService orgOrganizationService;
	
	@Resource(name = "orgPositionService")
	private OrgPositionService orgPositionService;

	@Override
	public void doBusiness(BaseWorkFlowBean arg0) {
		Map<String,Object> variables = arg0.getProcessVariables();
		String zdrylx = null;
		String zdrygllxdm = (String) variables.get("zdrylx");

		if (zdrygllxdm.equals("XXXXXX")) { // 一般管理对象

			zdrylx = "3";
		}
		else if (zdrygllxdm.equals("04")) {
			// ZdryGzb zdryGzb =zdryGzbDao.queryByZdrylx(zdrygllxdm);

			// if(zdryGzb.getZgbm().equals("XXXX")){//治安

			// zdrylx="3";
			// }
			// else

			// {//环保 提交到副局长审批

			String lrrzrq = (String) variables.get("lrrzrq");
			OrgOrganization orgOrganization = new OrgOrganization();
			orgOrganization = orgOrganizationService.queryUpOrgByLevel(lrrzrq,
					"21");
			String fsxOrgCode = orgOrganization.getOrgcode();// 得到本名等级为二级分市县公安局部门code
			String taskParameter = fsxOrgCode + "_"
					+ orgPositionService.queryByPosid("FJZ").getId().toString(); // 部门code+副局长岗位ID
			setLocalVariable("fzj", taskParameter);
			setLocalVariable("approvalMethod", "updatezdryApproval");

			zdrylx = "2";
		}
		// arg0.setVariableLocal("zdrylx", zdrylx);
		setVariable("zdrylx", zdrylx);
	}
	
	
}
