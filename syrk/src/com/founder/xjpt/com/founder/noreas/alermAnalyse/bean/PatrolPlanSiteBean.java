package com.founder.xjpt.com.founder.noreas.alermAnalyse.bean;

public class PatrolPlanSiteBean {
	private String id;
	private String name;
	private String sn;
	private String x;
	private String y;
	private String time;
	private String perId;
	private String perName;
	//0 – 漏巡；1 – 已巡；2 – 早到； 3 – 迟到
	private String status;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSn() {
		return sn;
	}
	public void setSn(String sn) {
		this.sn = sn;
	}
	public String getX() {
		return x;
	}
	public void setX(String x) {
		this.x = x;
	}
	public String getY() {
		return y;
	}
	public void setY(String y) {
		this.y = y;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getPerId() {
		return perId;
	}
	public void setPerId(String perId) {
		this.perId = perId;
	}
	public String getPerName() {
		return perName;
	}
	public void setPerName(String perName) {
		this.perName = perName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
