package com.founder.zdrygl.workflow.exception;

public class BaseWorkflowException extends Exception {

	private String exceptionDesc;
	
	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 */
	private static final long serialVersionUID = -6158424616405052748L;
	public BaseWorkflowException(){
		super();
	}
	public BaseWorkflowException(String desc){
		this.exceptionDesc = desc;
	}
	public String getExceptionDesc() {
		return exceptionDesc;
	}
	public void setExceptionDesc(String exceptionDesc) {
		this.exceptionDesc = exceptionDesc;
	}
	@Override
	public String toString() {
		return "BaseWorkflowException [exceptionDesc=" + exceptionDesc + "]";
	}
	
}
