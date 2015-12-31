package com.founder.zdrygl.workflow.dalian;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.util.WebUtils;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.components.AppConst;
import com.founder.workflow.bean.BaseWorkFlowBean;
import com.founder.workflow.service.activiti.lisener.WorkflowDelegate;
import com.founder.zdrygl.base.model.ZdryZb;
import com.founder.zdrygl.base.model.Zdrycx;
import com.founder.zdrygl.core.factory.ZdryAbstractFactory;
import com.founder.zdrygl.core.inteface.ZdryService;
import com.founder.zdrygl.core.model.ZOBean;
import com.founder.zdrygl.core.model.Zdry;

/**
 * ****************************************************************************
 * 
 * @Package: [com.founder.zdrygl.workflow.Lcgcg.java]
 * @ClassName: [Lcgcg]
 * @Description: [列撤管成功]
 * @Author: [wei.wen@founder.com.cn]
 * @CreateDate: [2015年8月14日 下午3:51:29]
 * @UpdateUser: [wei.wen@founder.com.cn(如多次修改保留历史记录，增加修改记录)]
 * @UpdateDate: [2015年8月14日 下午3:51:29，(如多次修改保留历史记录，增加修改记录)]
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]
 * @Version: [v1.0]
 */
@Component
public class DlLcgcg  extends WorkflowDelegate {

	@Autowired
	public ZdryAbstractFactory zdryFactory;

	@Override
	public void doBusiness(BaseWorkFlowBean arg0) {
		Map<String,Object> variables = arg0.getProcessVariables();
		String sqlxdm = (String) variables.get("sqlxdm");
		String zdrylx = (String) variables.get("zdrylx");
		ZdryService zdryService = zdryFactory.createZdryService(zdrylx);
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes()).getRequest();
		SessionBean sessionBean = (SessionBean) WebUtils.getSessionAttribute(
				request, AppConst.USER_SESSION);
		/*
		 * String spr = sessionBean.getUserId(); 
		 * String spbm =sessionBean.getUserOrgCode();
		 */

		ZdryZb zdryzb = (ZdryZb) variables.get("zdryZb");
		Zdry zdrylbdx = (Zdry) variables.get("zdrylbdx");
		ZOBean entity = new ZOBean(zdryzb, zdrylbdx);
		Zdrycx zdrycx = (Zdrycx) variables.get("zdrycx");
		entity.setZdrycx(zdrycx);
		if ("01".equals(sqlxdm)){
			zdryService.lgSuccess(sessionBean,entity);
		}else if ("02".equals(sqlxdm))
			zdryService.cgSuccess(sessionBean,entity);
		else if ("04".equals(sqlxdm)) {// 请假
		}
	}

	@Override
	public void sendMsgByType(BaseWorkFlowBean bwf, String msgType) {
		// TODO Auto-generated method stub
		
	}

}
