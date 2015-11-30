package com.founder.zdrygl.workflow.listener;

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
	@Autowired
	ProcessEngine _processEngine;

	@Override
	public void notify(DelegateExecution execution) throws Exception {
		globalExecution = execution;
		executionId = (String) execution.getId();
		activityId = (String) execution.getCurrentActivityId();
		/*
		 * TaskServiceImpl taskServiceImpl = (TaskServiceImpl) execution
		 * .getEngineServices().getTaskService(); // define which step is jumped
		 * taskServiceImpl.getCommandExecutor().execute( new
		 * JumpTaskCmd(executionId, activityId));
		 */
		defineJumpRule();
		jump();

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

	/**
	 * 跳转至指定活动节点
	 * 
	 * @param targetTaskDefinitionKey
	 * @throws Exception
	 */
	public void jump() throws Exception {
		TaskEntity currentTask = (TaskEntity) globalExecution
				.getEngineServices().getTaskService().createTaskQuery()
				.processInstanceId(globalExecution.getProcessInstanceId())
				.singleResult();
		jump(currentTask, targetTaskDefinitionKey);
	}

	/**
	 * 
	 * @param currentTaskEntity
	 *            当前任务节点
	 * @param targetTaskDefinitionKey
	 *            目标任务节点（在模型定义里面的节点名称）
	 * @throws Exception
	 */
	private void jump(final TaskEntity currentTask,
			String targetTaskDefinitionKey) throws Exception {
		final ActivityImpl pointActivity = getActivity(
				globalExecution.getProcessDefinitionId(),
				targetTaskDefinitionKey);
		final ActivityImpl currentActivity = getActivity(
				globalExecution.getProcessDefinitionId(), this.activityId);
		final ExecutionEntity executionEntity = (ExecutionEntity) globalExecution
				.getEngineServices().getRuntimeService().createExecutionQuery()
				.executionId(globalExecution.getId()).singleResult();

		//final TaskService taskService = globalExecution.getEngineServices().getTaskService();
		globalExecution.setVariable("hjdmj", "210204000000_59642604");
		globalExecution.setVariable("businessType", "0");
		globalExecution.setVariable("approvalMethod", "mjApproval");
		DefaultTaskFlowControlService dtfcService = new DefaultTaskFlowControlService(_processEngine);
		dtfcService.moveTo(currentTask, pointActivity);
		// 包装一个Command对象
		/*((TaskServiceImpl) globalExecution.getEngineServices().getTaskService())
				.getCommandExecutor().execute(new Command<java.lang.Void>() {
					@Override
					public Void execute(CommandContext commandContext) {
						// 创建新任务
						executionEntity.setActivity(pointActivity);
						executionEntity.executeActivity(pointActivity);
						// 删除当前的任务 // 不能删除当前正在执行的任务，所以要先清除掉关联
						executionEntity.removeTask(currentTask);
						currentTask.setExecutionId(null);
						taskService.saveTask(currentTask);
						taskService.deleteTask(currentTask.getId(), true);
						// 清空当前流向
						List<PvmTransition> oriPvmTransitionList = processCoreServiceImpl.clearTransition(currentActivity);

						// 创建新流向
						TransitionImpl newTransition = currentActivity.createOutgoingTransition();
						// 设置新流向的目标节点
						newTransition.setDestination(pointActivity);
						// 执行转向任务
						taskService.complete(currentTask.getId(),globalExecution.getVariables());
						// 删除目标节点新流入
						pointActivity.getIncomingTransitions().remove(newTransition);

						// 还原以前流向
						processCoreServiceImpl.restoreTransition(currentActivity, oriPvmTransitionList);
						
						ExecutionEntity execution = commandContext.getExecutionEntityManager().findExecutionById(_executionId);
						execution.setActivity(_activity);
						execution.performOperation(AtomicOperation.TRANSITION_CREATE_SCOPE);

						return null;
					}
				});*/
	}

	public ActivityImpl getActivity(String processDefId,
			String targetTaskDefinitionKey) {
		ProcessDefinitionEntity pde = (ProcessDefinitionEntity) ((RepositoryServiceImpl) globalExecution
				.getEngineServices().getRepositoryService())
				.getDeployedProcessDefinition(processDefId);
		return ((ProcessDefinitionImpl) pde)
				.findActivity(targetTaskDefinitionKey);
	}
}
