package com.founder.zdrygl.workflow.listener;

import javax.annotation.Resource;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.ExecutionListener;
import org.activiti.engine.impl.RepositoryServiceImpl;
import org.activiti.engine.impl.persistence.entity.ExecutionEntity;
import org.activiti.engine.impl.persistence.entity.ProcessDefinitionEntity;
import org.activiti.engine.impl.persistence.entity.TaskEntity;
import org.activiti.engine.impl.pvm.process.ActivityImpl;
import org.activiti.engine.impl.pvm.process.ProcessDefinitionImpl;
import org.springframework.beans.factory.annotation.Autowired;

import com.founder.workflow.util.ctrl.TaskFlowControlService;
import com.founder.workflow.util.ctrl.TaskFlowControlServiceFactory;
import com.founder.workflow.util.ctrl.impl.DefaultTaskFlowControlService;

/**
 * ****************************************************************************
 * 
 * @Package: 
 *           [com.founder.activiti.demo.javaDelegate.gateway.WorkRejectListener.java
 *           ]
 * @ClassName: [WorkRejectListener]
 * @Description: [任务被拒绝后跳转]
 * @Author: [huang_jifei@founder.com.cn]
 * @CreateDate: [2015年10月29日 下午2:42:51]
 * @UpdateUser: [huangjifei(如多次修改保留历史记录，增加修改记录)]
 * @UpdateDate: [2015年10月29日 下午2:42:51，(如多次修改保留历史记录，增加修改记录)]
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]
 * @Version: [v1.0]
 */
public abstract class WorkRejectListener implements ExecutionListener {
	private static final long serialVersionUID = 4762766874049379336L;
	private String executionId;
	private String activityId;
	protected DelegateExecution globalExecution;
	protected String targetTaskDefinitionKey;
	//@Resource(name="TaskFlowControlServiceFactory")
	//TaskFlowControlServiceFactory _taskFlowControlServiceFactory;

	@Override
	public void notify(DelegateExecution execution) throws Exception {
		globalExecution = execution;
		executionId = (String) execution.getId();
		activityId = (String) execution.getCurrentActivityId();
		//TODO:
		//TaskFlowControlService tfcs = _taskFlowControlServiceFactory.create(execution.getProcessInstanceId());
		//defineJumpRule();
		//tfcs.moveTo(targetTaskDefinitionKey);

	}

	/**
	 * 
	 * @Title: defineJumpRule
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public abstract void defineJumpRule();

}
