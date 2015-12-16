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
public class ZdFail extends WorkflowDelegate{

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
		
		/*String yjzd_dzid 	= (String)  variables.get("yjzd_dzid");
		String yjzd_dzxz 	= (String)  variables.get("yjzd_dzxz");
		String yjzd_mlpdm 	= (String)  variables.get("yjzd_mlpdm");
		String yjzd_mlpxz 	= (String)  variables.get("yjzd_mlpxz");
		String yjzd_xzqhdm 	= (String)  variables.get("yjzd_xzqhdm");
		String yjzd_zbx 	= (String)  variables.get("yjzd_zbx");
		String yjzd_zby 	= (String)  variables.get("yjzd_zby");
		String yglbm 		= (String)  variables.get("yglbm");
		String ygxpcsdm		= (String)  variables.get("ygxpcsdm");
		String yzrqdm 		= (String)  variables.get("yzrqdm");//原责任区代码
		
		if(yjzd_dzid != null){
			zdryzb.setJzd_dzid(yjzd_dzid);
		}
		if(yjzd_dzxz != null){
			zdryzb.setJzd_dzxz(yjzd_dzxz);
		}
		if(yjzd_mlpdm != null){
			zdryzb.setJzd_mlpdm(yjzd_mlpdm);
		}
		if(yjzd_mlpxz != null){
			zdryzb.setJzd_mlpxz(yjzd_mlpxz);
		}
		if(yjzd_xzqhdm != null){
			zdryzb.setJzd_xzqhdm(yjzd_xzqhdm);
		}
		if(yjzd_zbx != null){
			zdryzb.setJzd_zbx(yjzd_zbx);
		}
		if(yjzd_zby != null){
			zdryzb.setJzd_zby(yjzd_zby);
		}
		if(yglbm != null){
			zdryzb.setGlbm(yglbm);
		}
		if(ygxpcsdm != null){
			zdryzb.setGxpcsdm(ygxpcsdm);
		}
		if(yzrqdm != null ){
			zdryzb.setGxzrqdm(yzrqdm);
		}
		 */
		ZdryService zdryService = zdryFactory.createZdryService(zdrylx);
		zdryService.zdFail(sessionBean,entity);
	}
	
	
}
