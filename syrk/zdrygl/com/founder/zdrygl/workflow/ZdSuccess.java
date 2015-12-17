package com.founder.zdrygl.workflow;

import java.util.Date;
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
		
		ZdryZb zdryzb = (ZdryZb) variables.get("zdryZb");
		Zdry zdrylbdx = (Zdry) variables.get("zdrylbdx");
		ZOBean entity = new ZOBean(zdryzb, zdrylbdx);
		Zdrycx zdrycx = (Zdrycx) variables.get("zdrycx");
		entity.setZdrycx(zdrycx);
		String sszrqdm = (String)  variables.get("sszrqdm");
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
		//变更录入人信息:为下次转递提供正确的原辖区民警信息
		String xt_lrsj = (String) variables.get("xt_lrsj");
		if(xt_lrsj!=null) zdryzb.setXt_lrsj(xt_lrsj);
		String xt_lrrxm = (String) variables.get("xt_lrrxm");
		if(xt_lrrxm!=null) zdryzb.setXt_lrrxm(xt_lrrxm);
		String xt_lrrid = (String) variables.get("xt_lrrid");
		if(xt_lrrid!=null) zdryzb.setXt_lrrid(xt_lrrid);
		String xt_lrrbm = (String) variables.get("xt_lrrbm");
		if(xt_lrrbm!=null) zdryzb.setXt_lrrbm(xt_lrrbm);
		Long xt_lrrbmid = (Long) variables.get("xt_lrrbmid");
		if(xt_lrrbmid!=null) zdryzb.setXt_lrrbmid(String.valueOf(xt_lrrbmid));
		String xt_lrip = (String) variables.get("xt_lrip");
		if(xt_lrip!=null) zdryzb.setXt_lrip(xt_lrip);
		
		ZdryService zdryService = zdryFactory.createZdryService(zdrylx);
		zdryService.zdSuccess(sessionBean,entity);
	}
	
	
}
