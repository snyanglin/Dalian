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
public class ZdFail implements JavaDelegate{

	@Autowired
	public ZdryAbstractFactory zdryFactory;
	@Override
	public void execute(DelegateExecution arg0) throws Exception {
		// TODO Auto-generated method stub
		String zdrylx = (String) arg0.getVariable("zdrylx");
		ZdryZb zdryzb = (ZdryZb) arg0.getVariable("zdryzb");
		Zdry zdrylbdx = (Zdry) arg0.getVariable("zdrylbdx");
		ZdryService zdryService = zdryFactory.createZdryService(zdrylx, zdryzb, zdrylbdx);
		
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		SessionBean sessionBean=(SessionBean)WebUtils.getSessionAttribute(request, AppConst.USER_SESSION);

		String yjzd_dzid = (String)  arg0.getVariable("yjzd_dzid");
		String yjzd_dzxz = (String)  arg0.getVariable("yjzd_dzxz");
		String yjzd_mlpdm = (String)  arg0.getVariable("yjzd_mlpdm");
		String yjzd_mlpxz = (String)  arg0.getVariable("yjzd_mlpxz");
		String yjzd_xzqhdm = (String)  arg0.getVariable("yjzd_xzqhdm");
		String yjzd_zbx = (String)  arg0.getVariable("yjzd_zbx");
		String yjzd_zby = (String)  arg0.getVariable("yjzd_zby");
		String yglbm = (String)  arg0.getVariable("yglbm");
		String ryid = (String)  arg0.getVariable("ryid");
		sessionBean.getExtendMap().put("yglbm", yglbm);		
		sessionBean.getExtendMap().put("yjzd_dzid", yjzd_dzid);
		sessionBean.getExtendMap().put("yjzd_dzxz", yjzd_dzxz);		
		sessionBean.getExtendMap().put("yjzd_mlpdm", yjzd_mlpdm);
		sessionBean.getExtendMap().put("yjzd_mlpxz", yjzd_mlpxz);	
		sessionBean.getExtendMap().put("yjzd_xzqhdm", yjzd_xzqhdm);		
		sessionBean.getExtendMap().put("yjzd_zbx", yjzd_zbx);	
		sessionBean.getExtendMap().put("yjzd_zby", yjzd_zby);
		sessionBean.getExtendMap().put("ryid", ryid);
		sessionBean.getExtendMap().put("xgxpcsdm", (String)  arg0.getVariable("xgxpcsdm"));
		sessionBean.getExtendMap().put("ygxpcsdm", (String)  arg0.getVariable("ygxpcsdm"));
		String yzrqdm = (String)  arg0.getVariable("yzrqdm");//原责任区代码
		sessionBean.getExtendMap().put("yzrqdm", yzrqdm);
		
		/*String zdryid=(String) arg0.getVariable("zdryid");
		String zdryxm=(String) arg0.getVariable("xm");
		
		String ywsqrId=(String) arg0.getVariable("applyUserId");
		String ywsqr=(String) arg0.getVariable("sqrName");
		String sfcj=(String) arg0.getVariable("sfcj");
		String yglbm=(String) arg0.getVariable("ygxzrqdm");
		String xglbm=(String) arg0.getVariable("sszrqdm");
		
		String spr=sessionBean.getUserId();
		String spbm=sessionBean.getUserOrgCode();*/
		zdryService.zdFail(sessionBean);
	}
	
	
}
