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
import com.founder.zdrygl.workflow.utils.ZdryZbUtil;



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
		ZdryService zdryService = null;
		Map<String,Object> variables = arg0.getProcessVariables();
		String zdrylx = (String) variables.get("zdrylx");
		ZdryZb zdryzb = (ZdryZb) variables.get("zdryZb");
		Zdry zdrylbdx = (Zdry) variables.get("zdrylbdx");
		Zdrycx zdrycx = (Zdrycx) variables.get("zdrycx");
		
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		SessionBean sessionBean=(SessionBean)WebUtils.getSessionAttribute(request, AppConst.USER_SESSION);
		String sqlxdm=(String) variables.get("sqlxdm");//申请类型
		
		//add sp reason
		zdryzb.setXt_zxyy("审批未通过");
		ZdryZbUtil.setXtZxyy(zdrylbdx, "审批未通过");
		
		ZOBean entity = new ZOBean(zdryzb, zdrylbdx);
		entity.setZdrycx(zdrycx);
		
		if(sqlxdm.equals("01")){//列管
			zdryService = zdryFactory.createZdryService(zdrylx);
			Boolean isSzObj 	= (Boolean) variables.get("isSz");
			String isJdbm 	= (isSzObj==true?new Boolean(false):new Boolean(true)).toString();
			sessionBean.getExtendMap().put("isJdbm", isJdbm);
			Object orgCodeObj = variables.get("sqrOrgId");
			if(orgCodeObj != null){
				sessionBean.getExtendMap().put("sqrOrgId", orgCodeObj.toString());
			}
			zdryService.lgFail(sessionBean,entity);
		}else if(sqlxdm.equals("02")){//撤管
			zdryService = zdryFactory.createZdryService(zdrycx.getZdrygllxdm());
			zdryService.cgFail(sessionBean,entity);
		}else if(sqlxdm.equals("04")){//请假
		}
	}

	@Override
	public void sendMsgByType(BaseWorkFlowBean bwf, String msgType) {
		// TODO Auto-generated method stub
		
	}
	
	
}
