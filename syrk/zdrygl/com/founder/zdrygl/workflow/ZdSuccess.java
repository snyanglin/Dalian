package com.founder.zdrygl.workflow;

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
public class ZdSuccess extends WorkflowDelegate{


	@Autowired
	public ZdryAbstractFactory zdryFactory;
	@Override
	public void doBusiness(BaseWorkFlowBean arg0) {
		Map<String,Object> variables = arg0.getProcessVariables();
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		SessionBean sessionBean=(SessionBean)WebUtils.getSessionAttribute(request, AppConst.USER_SESSION);
		
		String zdrylx = (String) variables.get("zdrylx");
		ZdryZb zdryzb = (ZdryZb) variables.get("zdryzb");
		Zdry zdrylbdx = (Zdry) variables.get("zdrylbdx");
		//sessionBean.getExtendMap().put("xglbm", xglbm);
		String sszrqdm = (String)  variables.get("sszrqdm");
		//String yglbm = (String)  variables.get("yglbm");
		if(sszrqdm != null){
			zdryzb.setGxzrqdm(sszrqdm);
		}
		
		String xglbm=(String) variables.get("xglbm");
		if(xglbm!=null){
			zdryzb.setGlbm(xglbm);
			zdryzb.setGxbm(xglbm);
		}

		String xgxpcsdm = (String)  variables.get("xgxpcsdm");
		if(xgxpcsdm != null){
			zdryzb.setGxpcsdm(xgxpcsdm);
		}
		
		ZdryService zdryService = zdryFactory.createZdryService(zdrylx, zdryzb, zdrylbdx);
		
		
		/*
		String zdryid=(String) variables.get("zdryid");
		String zdryxm=(String) variables.get("xm");
		
		String ywsqrId=(String) variables.get("applyUserId");
		String ywsqr=(String) variables.get("sqrName");*/
		//String sfcj=(String) variables.get("sfcj");
		
		
		/*sessionBean.getExtendMap().put("xgxpcsdm", (String)  variables.get("xgxpcsdm"));
		sessionBean.getExtendMap().put("ygxpcsdm", (String)  variables.get("ygxpcsdm"));
		sessionBean.getExtendMap().put("yglbm", yglbm);*/
		zdryService.zdSuccess(sessionBean);
	}
	
	
}
