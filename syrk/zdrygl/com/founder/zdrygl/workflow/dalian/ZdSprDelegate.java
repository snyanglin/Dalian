package com.founder.zdrygl.workflow.dalian;

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
	}

}
