package com.founder.zdrygl.workflow.dalian;

import java.util.Map;

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
public class DlWorkReject extends WorkflowDelegate {
	@Autowired
	public ZdryAbstractFactory zdryFactory;

	@Override
	public void doBusiness(BaseWorkFlowBean arg0) {
		Map<String,Object> variables = arg0.getProcessVariables();
		
		String zdrylx = (String) variables.get("zdrylx");
		ZdryZb zdryzb = (ZdryZb) variables.get("zdryzb");
		Zdry zdrylbdx = (Zdry) variables.get("zdrylbdx");
		ZdryService zdryService = zdryFactory.createZdryService(zdrylx, zdryzb, zdrylbdx);
		
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		SessionBean sessionBean=(SessionBean)WebUtils.getSessionAttribute(request, AppConst.USER_SESSION);
		
		String sqlxdm=(String) variables.get("sqlxdm");//申请类型
		/*String zdryId=(String) arg0.getVariable("zdryId");
		String zdryxm=(String) arg0.getVariable("xm");
		String ywsqrId=(String) arg0.getVariable("applyUserId");
		String cghZdryId=(String) arg0.getVariable("cghZdryId");
		String spyj=(String) arg0.getVariable("spyj");
		String spr=sessionBean.getUserId();
		String spbm=sessionBean.getUserOrgCode();*/
		
		if(sqlxdm.equals("01")){//列管
			zdryService.lgFail(sessionBean);
		}
		if(sqlxdm.equals("02")){//撤管
			zdryService.cgFail(sessionBean);
		}
		if(sqlxdm.equals("04")){//请假
			//String qjId=(String) arg0.getVariable("qjId");			
			//zdryUntil.qjFail(qjId,sessionBean.getUserName(),spr,sessionBean.getRemoteAddr(),spyj);
		}
	}
	
	
}
