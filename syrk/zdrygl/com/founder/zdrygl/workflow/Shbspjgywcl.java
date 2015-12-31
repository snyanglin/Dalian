package com.founder.zdrygl.workflow;

import java.util.Map;

import javax.annotation.Resource;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import com.founder.framework.organization.department.service.OrgOrganizationService;
import com.founder.workflow.bean.BaseWorkFlowBean;
import com.founder.workflow.service.activiti.lisener.WorkflowDelegate;

/**
 * ****************************************************************************
 * 
 * @Package: [com.founder.zdrygl.until.Userbmjs.java]
 * @ClassName: [Userbmjs]
 * @Description: [涉环保审批结果业务处理]
 * @Author: [cong_rihong@founder.com.cn]
 * @CreateDate: [2015年8月11日 上午11:07:19]
 * @UpdateUser: [Administrator(如多次修改保留历史记录，增加修改记录)]
 * @UpdateDate: [2015年8月11日 上午11:07:19，(如多次修改保留历史记录，增加修改记录)]
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]
 * @Version: [v1.0]
 */
@Component
public class Shbspjgywcl extends WorkflowDelegate {
	@Resource(name = "orgOrganizationService")
	private OrgOrganizationService orgOrganizationService;

//	@Resource
//	private ZdryZdryzbService zdryZdryzbService;
//	@Resource
//	private ZdryShbzdryxxbService zdryShbzdryxxbService;

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		
	}

@Override
public void doBusiness(BaseWorkFlowBean arg0) {
	Map<String,Object> variables = arg0.getProcessVariables();
	String zdrylx = (String) variables.get("zdrylx");
	// 如果是涉环保重点人员
	if ("07".equals(zdrylx)) {
//		String spLevel = (String) execution.getVariable("splevel");
//		boolean spjg = (Boolean) execution.getVariable("approved");
//		String zdryId = (String) execution.getVariable("zdryId");
//		SessionBean sessionBean = (SessionBean) execution
//				.getVariable("sessionBean");
//		String sqlxdm = (String) execution.getVariable("sqlxdm");
//		if ("01".equals(sqlxdm)) {
//			if (false==spjg) {
//				// 1、修改业务数据
//				ZdryZdryzb zb = this.zdryZdryzbService.queryById(zdryId);
//				zb.setXt_zxbz("1");
//				this.zdryZdryzbService.update(zb, sessionBean);
//				ZdryShbzdryxxb shb = this.zdryShbzdryxxbService
//						.queryById(zdryId);
//				shb.setXt_zxbz("1");
//
//				this.zdryShbzdryxxbService.update(shb, sessionBean);
//				// 2 发消息
//			}
//
//			else if (true==spjg) {
//				// 一级同意 发消息通知
//				if ("1".equals(spLevel)) {
//
//				}
//				// 二级审批同意，修改业务表数据 发消息
//				else if ("2".equals(spLevel)) {
//					ZdryZdryzb zb = this.zdryZdryzbService
//							.queryById(zdryId);
//					zb.setGlzt("2");
//					this.zdryZdryzbService.update(zb, sessionBean);
//	
//				}
//			}
//		}else if ("02".equals(sqlxdm)) {//撤管
//			if("false".equals(spjg)){
//				//1、处理业务数据
//				ZdryZdryzb zb = this.zdryZdryzbService.queryById(zdryId);
//				zb.setGlzt("2");
//				this.zdryZdryzbService.update(zb, sessionBean);
//				//2、发消息
//			}else if("true".equals(spjg)){
//				if("1".equals(spLevel)){
//					//发消息
//					
//					
//				}else if("2".equals(spLevel)){
//					
//					ZdryZdryzb zb = this.zdryZdryzbService.queryById(zdryId);
//					zb.setGlzt("4");//设置成已撤管
//					zb.setXt_zxbz("1");
//					this.zdryZdryzbService.update(zb, sessionBean);
//					ZdryShbzdryxxb shb = this.zdryShbzdryxxbService
//							.queryById(zdryId);
//					shb.setXt_zxbz("1");
//
//					this.zdryShbzdryxxbService.update(shb, sessionBean);
//				}
//				
//			}
//		
//		
//		}

	}

}

@Override
public void sendMsgByType(BaseWorkFlowBean bwf, String msgType) {
	// TODO Auto-generated method stub
	
}

}
