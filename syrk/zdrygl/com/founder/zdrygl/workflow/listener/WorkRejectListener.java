package com.founder.zdrygl.workflow.listener;


import com.founder.workflow.bean.BaseWorkFlowBean;
import com.founder.workflow.service.activiti.lisener.WorkflowDelegate;

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
public abstract class WorkRejectListener extends WorkflowDelegate {
	private static final long serialVersionUID = 4762766874049379336L;
	private String executionId;
	private String activityId;
	protected String targetTaskDefinitionKey;
	@Override
	public void doBusiness(BaseWorkFlowBean arg0) {
		executionId = (String) arg0.getId();
		activityId = (String) arg0.getCurrentActivityId();
		/*
		 * TaskServiceImpl taskServiceImpl = (TaskServiceImpl) execution
		 * .getEngineServices().getTaskService(); // define which step is jumped
		 * taskServiceImpl.getCommandExecutor().execute( new
		 * JumpTaskCmd(executionId, activityId));
		 */
		boolean isJumped = (boolean) arg0.getProcessVariables().get("isJumped");
		if(isJumped){
			defineJumpRule(arg0);
			//jump();
		}
	}
	/**
	 * @param arg0 
	 * 
	 * @Title: defineJumpRule
	 * @Description: define which task will be jumped to
	 * @param     设定文件
	 * @return void    返回类型
	 * @throws
	 */
	abstract void defineJumpRule(BaseWorkFlowBean arg0);
	
	
}
