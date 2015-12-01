package com.founder.xjpt.com.founder.noreas.alermAnalyse.bean;

import java.util.List;

public class PatrolLineBean {
	private String id;
	private String name;
	private String orgId;
	private List<PatrolSiteBean> sites;
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
	public String getOrgId() {
		return orgId;
	}
	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}
	public List<PatrolSiteBean> getSites() {
		return sites;
	}
	public void setSites(List<PatrolSiteBean> sites) {
		this.sites = sites;
	}
}
