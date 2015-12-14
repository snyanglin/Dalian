package com.founder.zdrygl.workflow.dalian;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import com.founder.workflow.bean.BaseWorkFlowBean;
import com.founder.workflow.service.activiti.lisener.WorkflowDelegate;
/**
 * ****************************************************************************
 * @Package:      [com.founder.activiti.demo.workflow.dalian.JgdxqjFail.java]  
 * @ClassName:    [JgdxqjFail]   
 * @Description:  [一句话描述该类的功能]   
 * @Author:       [huang_jifei@founder.com.cn]  
 * @CreateDate:   [2015年12月7日 下午4:17:43]   
 * @UpdateUser:   [huangjifei(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015年12月7日 下午4:17:43，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Component
public class JgdxqjFail extends WorkflowDelegate {
	Log log = LogFactory.getLog(this.getClass());

	@Override
	public void doBusiness(BaseWorkFlowBean arg0) {
		Map<String,Object> variables = arg0.getProcessVariables();
		String zdrylx = (String) variables.get("zdrylx");
		log.debug("请假失败 ");
	}
	
	
}
