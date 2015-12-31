package com.founder.zdrygl.workflow;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.founder.framework.exception.BussinessException;
import com.founder.framework.organization.department.bean.OrgOrganization;
import com.founder.framework.organization.department.service.OrgOrganizationService;
import com.founder.framework.organization.position.service.OrgPositionService;
import com.founder.workflow.bean.BaseWorkFlowBean;
import com.founder.workflow.service.activiti.lisener.WorkflowDelegate;



/**
 * ****************************************************************************
 * @Package:      [com.founder.zdrygl.workflow.Zdrylxjs.java]  
 * @ClassName:    [Zaywjs]   
 * @Description:  [治安人员类型业务计算]   
 * @Author:       [he_minxi@founder.com.cn]  
 * @CreateDate:   [2015年8月4日 上午11:21:07]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015年8月4日 上午11:21:07，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */

@Component
public class Zlywjs extends WorkflowDelegate{
	@Resource(name = "orgOrganizationService")
	private OrgOrganizationService orgOrganizationService;
	
	@Resource(name = "orgPositionService")
	private OrgPositionService orgPositionService;

	@Override
	public void doBusiness(BaseWorkFlowBean arg0) {
		Map<String,Object> variables = arg0.getProcessVariables();
		try {
			String lrrzrq=(String) variables.get("lrrzrq");
			OrgOrganization orgOrganization =new OrgOrganization();	
			orgOrganization =orgOrganizationService.queryUpOrgByLevel(lrrzrq,"32");	
			String fsxOrgCode =orgOrganization.getOrgcode();//  得到本名等级为三级，派出所部门code
			String taskParameter=fsxOrgCode+"_"+orgPositionService.queryByPosid("SZ").getId().toString();   //部门code+所长岗位ID
			setLocalVariable("sz", taskParameter);
			setLocalVariable("approvalMethod", "szzlApproval");
		
		} catch(BussinessException aa){
			 throw  new BussinessException("重点人员转类出错");//抛出异常  
		}

	}

	@Override
	public void sendMsgByType(BaseWorkFlowBean bwf, String msgType) {
		// TODO Auto-generated method stub
		
	}
	
	
}
