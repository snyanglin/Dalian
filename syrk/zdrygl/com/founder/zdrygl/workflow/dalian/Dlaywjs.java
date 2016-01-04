package com.founder.zdrygl.workflow.dalian;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.util.WebUtils;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.components.AppConst;
import com.founder.framework.exception.BussinessException;
import com.founder.framework.organization.department.bean.OrgOrganization;
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
 * 
 * @Package: [com.founder.zdrygl.workflow.Zdrylxjs.java]
 * @ClassName: [Zaywjs]
 * @Description: [治安人员类型业务计算]
 * @Author: [he_minxi@founder.com.cn]
 * @CreateDate: [2015年8月4日 上午11:21:07]
 * @UpdateUser: [Administrator(如多次修改保留历史记录，增加修改记录)]
 * @UpdateDate: [2015年8月4日 上午11:21:07，(如多次修改保留历史记录，增加修改记录)]
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]
 * @Version: [v1.0]
 */

@Component
public class Dlaywjs extends WorkflowDelegate{
	Log log = LogFactory.getLog(this.getClass());
	
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
		Map<String, Object> variables = arg0.getProcessVariables();
		try {
			String zdrygllxdm = (String) variables.get("zdrylx");
			String zdryId = (String) variables.get("zdryId");
			OrgOrganization orgOrganization = new OrgOrganization();
			ZdryZb zdryZb = (ZdryZb) zdryQueryService.queryById(zdryId);
			/*
			 * 01 监管对象(sqjz) 02 重点人口(zdrk) 03 其他重点管理对象(zdrk) 04 肇事肇祸精神病人(zszh)
			 * 05 轻微滋事精神病人(zszh) 06 非正常上访重点人员(sgaf) 07 纳入视线对象（无流程）(nrsx) 08
			 * 一般关注对象(不持久 化 )
			 */
			LinkedHashMap<String,String> wfParams = workflowUtil.getWorkflowParamBean(WfywEnum.ZALCG);
			String taskOwner = null;
			String variableKey = "sz";
			if (zdrygllxdm.equals("04") || zdrygllxdm.equals("05")
					|| zdrygllxdm.equals("06")) {
				variableKey = "zazd";
				taskOwner = workflowUtil.camZazdTaskOwner(wfParams.get("spgwL1_zazd_lv"),wfParams.get("spgwL1_zazd"));
				HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
				SessionBean sessionBean=(SessionBean)WebUtils.getSessionAttribute(request, AppConst.USER_SESSION);
				setVariable("sqrOrgId",sessionBean.getUserOrgId());
				setVariable("isSz",false);
			} else {
				taskOwner = workflowUtil.camSzTaskOwner(zdryZb, wfParams.get("spgwL1_sz_lv"), wfParams.get("spgwL1_sz"));
				setVariable("isSz",true);
			}
			if(taskOwner == null){
				throw new BaseWorkflowException("没有对应的组织或岗位。");
			}
			setLocalVariable(variableKey, taskOwner);
			setLocalVariable("businessType", "1");
			setLocalVariable("org", orgOrganization);
			setLocalVariable("approvalMethod", "szApproval");


		} catch (BussinessException aa) {
			throw new BussinessException("未找到该重点人员户籍地址信息，请补充");// 抛出异常
		} catch (BaseWorkflowException e) {
			e.printStackTrace();
		}

	}
	
	/**
	 * 消息标题：重点人员列管审批
消息内容：[社区民警辖区]民警[社区民警姓名]提交[重点人员管理类型][重点人员姓名]的列管申请，请审批。

	 * @Title: notifySzSign
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param     设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public void notifySzSign(){
		
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
		System.out.println("### 通知双方民警及所长:" );
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
		System.out.println("### 通知初始下发部门:" );
		
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
		System.out.println("### 通知原辖区社区民警:" );
		
	}
	/**
	 * 
	 * @Title: notifySz
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param     设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public void notifySz(){
		System.out.println("### 通知所长 :" );
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
		System.out.println("### 通知治安支队:" );
	}
	/**
	 * 
	 * @Title: notifyJzdxq
	 * @Description: 通知实有人口其他居住地辖区
	 * @param     设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public void notifyOtherJzdxq(){
		System.out.println("### 通知实有人口其他居住地辖区:" );
	}

	@Override
	public void sendMsgByType(BaseWorkFlowBean bwf, String msgType) {
		// TODO Auto-generated method stub
		
	}
	
	
}
