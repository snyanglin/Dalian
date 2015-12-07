package com.founder.zdrygl.workflow;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.founder.framework.exception.BussinessException;
import com.founder.workflow.bean.BaseWorkFlowBean;
import com.founder.workflow.service.activiti.lisener.WorkflowDelegate;
/**
 * ****************************************************************************
 * @Package:      [com.founder.activiti.demo.workflow.dalian.JgdxqjSuccess.java]  
 * @ClassName:    [JgdxqjSuccess]   
 * @Description:  [一句话描述该类的功能]   
 * @Author:       [huang_jifei@founder.com.cn]  
 * @CreateDate:   [2015年12月7日 下午4:16:33]   
 * @UpdateUser:   [huangjifei(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015年12月7日 下午4:16:33，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Component
public class JgdxqjSuccess extends WorkflowDelegate{

	@Override
	public void doBusiness(BaseWorkFlowBean arg0) {
		Map<String,Object> variables = arg0.getProcessVariables();
		try {
			String lrrzrq=(String) variables.get("lrrzrq");
			setLocalVariable("approvalMethod", "szzlApproval");
		
		} catch(BussinessException aa){
			 throw  new BussinessException("重点人员请假出错");//抛出异常  
		}

	}

}
