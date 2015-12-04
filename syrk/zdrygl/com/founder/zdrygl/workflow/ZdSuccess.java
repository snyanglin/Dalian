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
import com.founder.zdrygl.core.model.Zdry;



/**
 * ****************************************************************************
 * @Package:      [com.founder.zdrygl.workflow.BmjsWorkflow.java]  
 * @ClassName:    [WorkReject]   
 * @Description:  [列撤管流程审批拒绝通用实现类]   
 * @Author:       [he_minxi@founder.com.cn]  
 * @CreateDate:   [2015年8月4日 下午3:14:40]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015年8月4日 下午3:14:40，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */

@Component
public class ZdSuccess implements JavaDelegate{


	@Autowired
	public ZdryAbstractFactory zdryFactory;
	@Override
	public void execute(DelegateExecution arg0) throws Exception {
		
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		SessionBean sessionBean=(SessionBean)WebUtils.getSessionAttribute(request, AppConst.USER_SESSION);
		
		String zdrylx = (String) arg0.getVariable("zdrylx");
		ZdryZb zdryzb = (ZdryZb) arg0.getVariable("zdryzb");
		Zdry zdrylbdx = (Zdry) arg0.getVariable("zdrylbdx");
		//sessionBean.getExtendMap().put("xglbm", xglbm);
		String sszrqdm = (String)  arg0.getVariable("sszrqdm");
		//String yglbm = (String)  arg0.getVariable("yglbm");
		if(sszrqdm != null){
			zdryzb.setGxzrqdm(sszrqdm);
		}
		
		String xglbm=(String) arg0.getVariable("xglbm");
		if(xglbm!=null){
			zdryzb.setGlbm(xglbm);
			zdryzb.setGxbm(xglbm);
		}

		String xgxpcsdm = (String)  arg0.getVariable("xgxpcsdm");
		if(xgxpcsdm != null){
			zdryzb.setGxpcsdm(xgxpcsdm);
		}
		
		ZdryService zdryService = zdryFactory.createZdryService(zdrylx, zdryzb, zdrylbdx);
		
		
		/*
		String zdryid=(String) arg0.getVariable("zdryid");
		String zdryxm=(String) arg0.getVariable("xm");
		
		String ywsqrId=(String) arg0.getVariable("applyUserId");
		String ywsqr=(String) arg0.getVariable("sqrName");*/
		//String sfcj=(String) arg0.getVariable("sfcj");
		
		
		/*sessionBean.getExtendMap().put("xgxpcsdm", (String)  arg0.getVariable("xgxpcsdm"));
		sessionBean.getExtendMap().put("ygxpcsdm", (String)  arg0.getVariable("ygxpcsdm"));
		sessionBean.getExtendMap().put("yglbm", yglbm);*/
		zdryService.zdSuccess(sessionBean);
		
	}
	
	
}
