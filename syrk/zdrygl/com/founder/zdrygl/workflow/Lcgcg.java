package com.founder.zdrygl.workflow;

import javax.servlet.http.HttpServletRequest;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.util.WebUtils;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.components.AppConst;
import com.founder.zdrygl.base.model.ZdryZb;
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
public class Lcgcg implements JavaDelegate {

	@Autowired
	public ZdryAbstractFactory zdryFactory;

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		/*
		 * String zdryxm = (String) execution.getVariable("xm"); String zdryId =
		 * (String) execution.getVariable("zdryId"); String ywsqrId = (String)
		 * execution.getVariable("applyUserId"); String cghZdryId = (String)
		 * execution.getVariable("cghZdryId");
		 */
		String sqlxdm = (String) execution.getVariable("sqlxdm");
		// String spyj= (String) execution.getVariable("spyj");
		String zdrylx = (String) execution.getVariable("zdrylx");
		ZdryZb zdryzb = (ZdryZb) execution.getVariable("zdryzb");
		Zdry zdrylbdx = (Zdry) execution.getVariable("zdrylbdx");
		
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes()).getRequest();
		SessionBean sessionBean = (SessionBean) WebUtils.getSessionAttribute(
				request, AppConst.USER_SESSION);
		/*
		 * String spr = sessionBean.getUserId(); String spbm =
		 * sessionBean.getUserOrgCode();
		 */

		if ("01".equals(sqlxdm)){
//			ZdryService zdryService = zdryFactory.createZdryService(zdrylx, zdryzb, zdrylbdx);
//
//			zdryService.lgSuccess(sessionBean);
			ZdryService zdryService = zdryFactory.createZdryService(zdrylx);
			ZOBean entity = new ZOBean(zdryzb, zdrylbdx);
			zdryService.lgSuccess(sessionBean,entity);
		}else if ("02".equals(sqlxdm)){
			ZdryService zdryService = zdryFactory.createZdryService(zdrylx, zdryzb, zdrylbdx);
			zdryService.cgSuccess(sessionBean);
		}else if ("04".equals(sqlxdm)) {// 请假
			String qjId = (String) execution.getVariable("qjId");
			// zdryService.qjSuccess(sessionBean);
		}
	}

}
