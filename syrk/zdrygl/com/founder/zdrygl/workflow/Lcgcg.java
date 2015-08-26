package com.founder.zdrygl.workflow;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.util.WebUtils;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.components.AppConst;
import com.founder.zdrygl.until.ZdryUntil;

/**
 * ****************************************************************************
 * @Package:      [com.founder.zdrygl.workflow.Lcgcg.java]  
 * @ClassName:    [Lcgcg]   
 * @Description:  [列撤管成功]   
 * @Author:       [wei.wen@founder.com.cn]  
 * @CreateDate:   [2015年8月14日 下午3:51:29]   
 * @UpdateUser:   [wei.wen@founder.com.cn(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015年8月14日 下午3:51:29，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Component
public class Lcgcg implements JavaDelegate {
	
	@Resource(name="ZdryUntil")
	private ZdryUntil zdryUntil;

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		String zdryxm = (String) execution.getVariable("xm");
		String zdryId = (String) execution.getVariable("zdryId");
		String ywsqrId = (String) execution.getVariable("applyUserId");
		String cghZdryId = (String) execution.getVariable("cghZdryId");
		String sqlxdm = (String) execution.getVariable("sqlxdm");
		
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		SessionBean sessionBean=(SessionBean)WebUtils.getSessionAttribute(request, AppConst.USER_SESSION);
		String spr = sessionBean.getUserId();
		String spbm = sessionBean.getUserOrgCode();
		
		if("01".equals(sqlxdm))
			zdryUntil.lgSuccess(zdryId, zdryxm, ywsqrId, spr, spbm, cghZdryId);
		else if("02".equals(sqlxdm))
			zdryUntil.cgSuccess(zdryId, zdryxm, ywsqrId, spr, spbm, cghZdryId);
	}

}
