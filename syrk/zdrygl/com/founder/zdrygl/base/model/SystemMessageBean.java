package com.founder.zdrygl.base.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.founder.framework.base.entity.SessionBean;

public class SystemMessageBean implements Serializable {

	private static final long serialVersionUID = -1344277087391402800L;

	private boolean sendAble = false;

	private String title;

	private String context;

	private String messageType = "user";
	
	private List<String> userIds = new ArrayList<String>();
	
	private List<String> orgIds = new ArrayList<String>();
	
	private ZdryZb zdryzb;
	
	private SessionBean sessionBean;
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public List<String> getUserIds() {
		return userIds;
	}

	public void setUserIds(List<String> userIds) {
		this.userIds = userIds;
	}

	public boolean isSendAble() {
		return sendAble;
	}

	public void setSendAble(boolean sendAble) {
		this.sendAble = sendAble;
	}

	public ZdryZb getZdryzb() {
		return zdryzb;
	}

	public void setZdryzb(ZdryZb zdryzb) {
		this.zdryzb = zdryzb;
	}

	public SessionBean getSessionBean() {
		return sessionBean;
	}

	public void setSessionBean(SessionBean sessionBean) {
		this.sessionBean = sessionBean;
	}

	public List<String> getOrgIds() {
		return orgIds;
	}

	public void setOrgIds(List<String> orgIds) {
		this.orgIds = orgIds;
	}

	public String getMessageType() {
		return messageType;
	}

	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}
	
}
