package com.founder.zdrygl.workflow.dalian;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.founder.framework.exception.BussinessException;
import com.founder.framework.organization.department.bean.OrgOrganization;
import com.founder.framework.organization.department.service.OrgOrganizationService;
import com.founder.framework.organization.position.service.OrgPositionService;
import com.founder.workflow.bean.BaseWorkFlowBean;
import com.founder.workflow.service.activiti.lisener.WorkflowDelegate;
import com.founder.zdrygl.base.model.ZdryZb;
import com.founder.zdrygl.base.service.ZdryInfoQueryService;
import com.founder.zdrygl.base.service.wf.WfywEnum;
import com.founder.zdrygl.core.utils.SpringContextHolder;
import com.founder.zdrygl.workflow.exception.BaseWorkflowException;
import com.founder.zdrygl.workflow.utils.WorkflowUtil;

/**
 * ****************************************************************************
 * @Package:      [com.founder.zdrygl.workflow.dalian.DlZdywjs.java]  
 * @ClassName:    [DlZdywjs]   
 * @Description:  [大连转递业务计算]   
 * @Author:       [huang_jifei@founder.com.cn]  
 * @CreateDate:   [2015年12月24日 上午9:53:01]   
 * @UpdateUser:   [huangjifei(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015年12月24日 上午9:53:01，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Component
public class DlZdywjs extends WorkflowDelegate {

	@Resource(name = "orgOrganizationService")
	private OrgOrganizationService orgOrganizationService;

	@Resource(name = "orgPositionService")
	private OrgPositionService orgPositionService;

	@Resource(name = "zdryQueryService")
	private ZdryInfoQueryService zdryQueryService;
	
	@Resource(name="workflowUtil")
	private WorkflowUtil workflowUtil;
	@Override
	public void doBusiness(BaseWorkFlowBean arg0) {
		Map<String,Object> variables = arg0.getProcessVariables();
		String nextTaskOwner = null;
		try {
			ZdryZb zdrycx = (ZdryZb) variables.get("zdrycx");
			String zdrygllxdm = (String) variables.get("zdrylx");
			String sszrqdm = (String) variables.get("sszrqdm");//ygxzrqdm
			
			OrgOrganization orgOrganization = new OrgOrganization();
			String current_jzd_zrqdm = zdrycx.getGxzrqdm();// 重点人员原居住责任区
			String target_jzd_zrqdm = sszrqdm;// 重点人员新居住地责任区;
			
			//设定流程新责任区负责人
			OrgOrganization targetOrgOrganization = orgOrganizationService.queryByOrgcode(sszrqdm);
			String beanId = WorkflowUtil.buildWorkflowKey(WfywEnum.ZD.getValue());
			LinkedHashMap<String,String> wfParams = SpringContextHolder.getBean(beanId);
			String taskParameter = targetOrgOrganization.getOrgcode() + "_"
					+ orgPositionService.queryByPosid(wfParams.get("spgwL1")).getId().toString(); // 责任区部门code+民警岗位ID
			setLocalVariable("spmj", taskParameter);
			setVariable("xglbm", targetOrgOrganization.getOrgcode());
			setVariable("yglbm",orgOrganizationService.queryByOrgcode(zdrycx.getGxzrqdm()).getOrgcode());

			//设定转递裁决人员:
			orgOrganization = orgOrganizationService.queryUpOrgByLevel(current_jzd_zrqdm, "32");
			OrgOrganization newOrgOrganization = orgOrganizationService.queryUpOrgByLevel(target_jzd_zrqdm, "32");
			nextTaskOwner = workflowUtil.camZazdTaskOwner("30", "DDZ");
			setVariable("gtld", nextTaskOwner);
			
			// set Other parameters
			setLocalVariable("businessType", "0");
			setLocalVariable("approvalMethod", "zdmjApproval");
			setLocalVariable("org", targetOrgOrganization);
			setLocalVariable("isZdryLg", "0");//TODO:测试用，默认为非上级指定列管人员
			setVariable("xgxpcsdm", newOrgOrganization.getOrgcode());
			setVariable("ygxpcsdm", orgOrganization.getOrgcode());
		} catch (BussinessException aa) {

			throw new BussinessException("未找到该重点人员户籍地址信息，请补充");// 抛出异常
		} catch (BaseWorkflowException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 
	 * @Title: notifyAllPersons
	 * @Description: TODO(通知双方民警及所长)
	 * @param     设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public void notifyAllPersons(){
		System.out.println("### 通知双方民警及所长");
	}
	/**
	 * 
	 * @Title: notifyCsxfbm
	 * @Description: TODO(通知初始下发部门)
	 * @param     设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public void notifyCsxfbm(){
		System.out.println("### 通知初始下发部门");
		
	}
	/**
	 * 
	 * @Title: notifyYxqsqmj
	 * @Description: TODO(通知原辖区社区民警)
	 * @param     设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public void notifyYxqsqmj(){
		System.out.println("### 通知原辖区社区民警");
		
	}
	/**
	 * 
	 * @Title: notifyCjry
	 * @Description: 通知共同领导裁决
	 * @param     设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public void notifyCjry(){
		System.out.println("### 通知共同领导裁决人员");
		
	}
}
