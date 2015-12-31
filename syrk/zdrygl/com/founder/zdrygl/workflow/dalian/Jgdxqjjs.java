package com.founder.zdrygl.workflow.dalian;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import com.founder.framework.exception.BussinessException;
import com.founder.framework.organization.department.service.OrgOrganizationService;
import com.founder.framework.organization.position.service.OrgPositionService;
import com.founder.workflow.bean.BaseWorkFlowBean;
import com.founder.workflow.service.activiti.lisener.WorkflowDelegate;
import com.founder.zdrygl.base.model.ZdryZb;
import com.founder.zdrygl.base.service.ZdryInfoQueryService;
import com.founder.zdrygl.base.service.wf.WfywEnum;
import com.founder.zdrygl.workflow.exception.BaseWorkflowException;
import com.founder.zdrygl.workflow.utils.WorkflowUtil;
/**
 * ****************************************************************************
 * @Package:      [com.founder.activiti.demo.workflow.dalian.Jgdxqjjs.java]  
 * @ClassName:    [Jgdxqjjs]   
 * @Description:  [一句话描述该类的功能]   
 * @Author:       [huang_jifei@founder.com.cn]  
 * @CreateDate:   [2015年12月7日 下午4:14:13]   
 * @UpdateUser:   [huangjifei(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015年12月7日 下午4:14:13，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Component
public class Jgdxqjjs extends WorkflowDelegate{
	
	Log log = LogFactory.getLog(this.getClass());
	@Resource(name = "orgOrganizationService")
	private OrgOrganizationService orgOrganizationService;

	@Resource(name = "orgPositionService")
	private OrgPositionService orgPositionService;

	@Resource(name="workflowUtil")
	private WorkflowUtil workflowUtil;

	@Resource(name = "zdryQueryService")
	private ZdryInfoQueryService zdryQueryService;

	@Override
	public void doBusiness(BaseWorkFlowBean arg0) {
		Map<String, Object> variables = arg0.getProcessVariables();
		try {
			String zdryId = (String) variables.get("zdryId");
			ZdryZb zdryZb = (ZdryZb) zdryQueryService.queryById(zdryId);
			
			LinkedHashMap<String,String> wfParams = workflowUtil.getWorkflowParamBean(WfywEnum.JGDXQJ);
			String taskOwner = workflowUtil.camSzTaskOwner(zdryZb,wfParams.get("spgwL1_lv"),wfParams.get("spgwL1"));
			if(taskOwner == null){
				throw new BaseWorkflowException("没有对应的组织或岗位。");
			}
			setLocalVariable("sz", taskOwner);
			setLocalVariable("approvalMethod", "szApproval");

		} catch (BussinessException aa) {
			throw new BussinessException("未找到该重点人员户籍地址信息，请补充");// 抛出异常
		} catch (BaseWorkflowException e) {
			e.printStackTrace();
		} catch(Exception ee){
			ee.printStackTrace();
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
	 * @Title: notifyCsxfbm
	 * @Description: 通知所长
	 * @param     设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public void notifySz(){
		System.out.println("### 通知所长");
		
	}
	/**
	 * 
	 * @Title: notifyZazd
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param     设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public void notifyZazd(){
		System.out.println("### 通知治安支队:");
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
	 * @Title: qjSuccess
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param     设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public void qjSuccess(){
		System.out.println("### 请假成功");
	}
	/**
	 * 
	 * @Title: qjFail
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param     设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public void qjFail(){
		System.out.println("### 请假失败");
	}
	@Override
	public void sendMsgByType(BaseWorkFlowBean bwf, String msgType) {
		// TODO Auto-generated method stub
		
	}
	
}
