package com.founder.zdrygl.workflow;

import javax.annotation.Resource;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import com.founder.bzdz.service.DzService;
import com.founder.bzdz.vo.BzdzxxbVO;
import com.founder.framework.exception.BussinessException;
import com.founder.framework.organization.department.bean.OrgOrganization;
import com.founder.framework.organization.department.service.OrgOrganizationService;
import com.founder.framework.organization.position.service.OrgPositionService;
import com.founder.syrkgl.service.SyrkSyrkxxzbService;
import com.founder.zdrygl.service.ZdryZdryzbService;



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
public class Zlywjs implements JavaDelegate{


	
	@Resource(name = "orgOrganizationService")
	private OrgOrganizationService orgOrganizationService;
	
	@Resource(name = "orgPositionService")
	private OrgPositionService orgPositionService;
	

	@Resource(name = "dzService")
	private DzService dzService;
	

	@Resource(name = "zdryZdryzbService")
	private ZdryZdryzbService zdryZdryzbService;
	 
	@Resource(name = "syrkSyrkxxzbService")
	private SyrkSyrkxxzbService syrkSyrkxxzbService;
	
	@Override
	public void execute(DelegateExecution arg0) throws BussinessException {
				
		
		try {
		
			String lrrzrq=(String) arg0.getVariable("lrrzrq");
			OrgOrganization orgOrganization =new OrgOrganization();	
			orgOrganization =orgOrganizationService.queryUpOrgByLevel(lrrzrq,"32");	
			String fsxOrgCode =orgOrganization.getOrgcode();//  得到本名等级为三级，派出所部门code
			String taskParameter=fsxOrgCode+"_"+orgPositionService.queryByPosid("SZ").getId().toString();   //部门code+所长岗位ID
			arg0.setVariableLocal("sz", taskParameter);
			arg0.setVariableLocal("approvalMethod", "szzlApproval");
		
		} catch(BussinessException aa){
			
			 throw  new BussinessException("重点人员转类出错");//抛出异常  
		}

		
		
		
		
	}
	
	
}
