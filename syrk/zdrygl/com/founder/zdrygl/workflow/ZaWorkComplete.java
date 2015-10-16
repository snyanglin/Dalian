package com.founder.zdrygl.workflow;

import javax.annotation.Resource;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;



/**
 * ****************************************************************************
 * @Package:      [com.founder.zdrygl.workflow.BmjsWorkflow.java]  
 * @ClassName:    [BmjsWorkflow]   
 * @Description:  [一句话描述该类的功能]   
 * @Author:       [he_minxi@founder.com.cn]  
 * @CreateDate:   [2015年8月4日 下午3:14:40]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015年8月4日 下午3:14:40，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */

@Component
public class ZaWorkComplete implements JavaDelegate{

	
	
	@Override
	public void execute(DelegateExecution arg0) throws Exception {
		// TODO Auto-generated method stub
				
	
	
		//String userId=(String) arg0.getVariable("userId");//重点人员ID
		

		//HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
	//	SessionBean sessionBean=(SessionBean)WebUtils.getSessionAttribute(request, AppConst.USER_SESSION);
	//	ZdryZdryzb zdryZdryzb=zdryZdryzbService.queryById(userId);
		
		
	//	zdryZdryzb.setGlzt("2");  //流程结束， 变更重点人员总表状态为结束状态
		
	//	zdryZdryzb.setXt_zxbz("");//流程结束， 变更重点人员总表注销标识
	//	zdryZdryzbService.update(zdryZdryzb, sessionBean);
		System.out.print("21212SSSSSSSSSSSSSSSSSSS");
	}
	
	
}
