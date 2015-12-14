package com.founder.sqjw.bean;
import java.io.Serializable;
import com.founder.framework.base.entity.BaseEntity;
/**
 * @类名: LogInfo 
 * @描述:(类描述) 
 * @作者: zhang_guoliang@founder.com 
 * @日期: 2014-7-14 下午10:57:56 
 */
public class LogInfo extends BaseEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	private String numid;
	private String userid;
	private String organization;
	private String username;
	private String terminalid;
	private String operatetime;
	private String operatecondition;
	private String operateresult;
	private String modname;
	private String funcname;
	private String operatetype;
	private String tablename;
	private String tablepk;
	private String operatecontent;
	public String getNumid() {
		return numid;
	}
	public void setNumid(String numid) {
		this.numid = numid;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getOrganization() {
		return organization;
	}
	public void setOrganization(String organization) {
		this.organization = organization;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getTerminalid() {
		return terminalid;
	}
	public void setTerminalid(String terminalid) {
		this.terminalid = terminalid;
	}
	public String getOperatetime() {
		return operatetime;
	}
	public void setOperatetime(String operatetime) {
		this.operatetime = operatetime;
	}
	public String getOperatecondition() {
		return operatecondition;
	}
	public void setOperatecondition(String operatecondition) {
		this.operatecondition = operatecondition;
	}
	public String getOperateresult() {
		return operateresult;
	}
	public void setOperateresult(String operateresult) {
		this.operateresult = operateresult;
	}
	public String getModname() {
		return modname;
	}
	public void setModname(String modname) {
		this.modname = modname;
	}
	public String getFuncname() {
		return funcname;
	}
	public void setFuncname(String funcname) {
		this.funcname = funcname;
	}
	public String getOperatetype() {
		return operatetype;
	}
	public void setOperatetype(String operatetype) {
		this.operatetype = operatetype;
	}
	public String getTablename() {
		return tablename;
	}
	public void setTablename(String tablename) {
		this.tablename = tablename;
	}
	public String getTablepk() {
		return tablepk;
	}
	public void setTablepk(String tablepk) {
		this.tablepk = tablepk;
	}
	public String getOperatecontent() {
		return operatecontent;
	}
	public void setOperatecontent(String operatecontent) {
		this.operatecontent = operatecontent;
	}
}