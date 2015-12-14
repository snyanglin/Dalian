package com.founder.gzjk.event.entity;


public class EventObject {
	
	private String ryid;
	
	private String type;

	private String orgCode;

	public String getRyid() {
		return ryid;
	}

	public void setRyid(String ryid) {
		this.ryid = ryid;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public EventObject(String ryid, String type,String orgCode) {
		this.ryid = ryid;
		this.type = type;
		this.orgCode = orgCode;
	}
	
	public EventObject(String ryid, String type) {
		this.ryid = ryid;
		this.type = type;
	}

	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}
    
	
}
