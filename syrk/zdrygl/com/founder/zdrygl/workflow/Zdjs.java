package com.founder.zdrygl.workflow;

import java.util.Map;

import javax.annotation.Resource;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import com.founder.bzdz.service.DzService;
import com.founder.framework.organization.department.service.OrgOrganizationService;
import com.founder.framework.organization.position.service.OrgPositionService;
import com.founder.syrkgl.service.SyrkSyrkxxzbService;
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
@Deprecated
@Component
public class Zdjs extends WorkflowDelegate{

	@Resource(name = "orgPositionService")
	private OrgPositionService orgPositionService;

	@Override
	public void doBusiness(BaseWorkFlowBean arg0) {
		Map<String,Object> variables = arg0.getProcessVariables();
		String sszrqdm=(String) variables.get("sszrqdm");
		String taskParameter=sszrqdm+"_"+orgPositionService.queryByPosid("ZRQMJ").getId().toString()+"_ZDJS";   //责任区部门code+民警岗位ID
		setLocalVariable("zrqmj", taskParameter);
	
	}

	@Override
	public void sendMsgByType(BaseWorkFlowBean bwf, String msgType) {
		// TODO Auto-generated method stub
		
	}
	
	
}
