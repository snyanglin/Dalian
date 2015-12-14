package com.founder.gzjk.event.entity;

import com.founder.framework.base.entity.SessionBean;

public class EventObjectTemp {
	
	private String id;
	
	private String type; //create|delete
	
	private String businessType; //syrk|zdry|sydw|cyry|syfw(syrw+czfw)
	
	private SessionBean sessionBean;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public String getBusinessType() {
		return businessType;
	}

	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}

	
	public SessionBean getSessionBean() {
		return sessionBean;
	}

	public void setSessionBean(SessionBean sessionBean) {
		this.sessionBean = sessionBean;
	}

	public EventObjectTemp(String id, String type, String businessType, SessionBean sessionBean) {
		this.id = id;
		this.type = type;
		this.businessType = businessType;
		this.sessionBean = sessionBean;
	}
	
}
