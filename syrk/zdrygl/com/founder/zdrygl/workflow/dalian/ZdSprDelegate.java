package com.founder.zdrygl.workflow.dalian;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.util.WebUtils;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.components.AppConst;
import com.founder.workflow.bean.BaseWorkFlowBean;
import com.founder.workflow.service.activiti.lisener.WorkflowDelegate;
import com.founder.zdrygl.base.model.ZdryZb;

@Component
public class ZdSprDelegate extends WorkflowDelegate {

	@Override
	public void doBusiness(BaseWorkFlowBean arg0) {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		SessionBean sessionBean=(SessionBean)WebUtils.getSessionAttribute(request, AppConst.USER_SESSION);
		Map<String,Object> variables = arg0.getProcessVariables();
		ZdryZb zdryzb = (ZdryZb) variables.get("zdryZb");
		//为裁决后发送信息准备接受民警
		zdryzb.setXt_zhxgrid(sessionBean.getUserId());
		zdryzb.setXt_zhxgrxm(sessionBean.getUserName());
		//为变更录入人提供信息支持：提供新辖区民警信息，转递成功后新辖区民警覆盖老数据（录入人相关信息 ）
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		this.setLocalVariable("xt_lrsj", formatter.format(new Date()));//录入时间
		this.setLocalVariable("xt_lrrxm", sessionBean.getUserName());//录入人姓名
		this.setLocalVariable("xt_lrrid", sessionBean.getUserId());//录入人ID
		this.setLocalVariable("xt_lrrbm", sessionBean.getUserOrgCode());//录入人部门
		this.setLocalVariable("xt_lrrbmid", sessionBean.getUserOrgId());//录入人部门ID
		this.setLocalVariable("xt_lrip", sessionBean.getRemoteAddr());//录入IP
	}

	@Override
	public void sendMsgByType(BaseWorkFlowBean bwf, String msgType) {
		// TODO Auto-generated method stub
		
	}

}
