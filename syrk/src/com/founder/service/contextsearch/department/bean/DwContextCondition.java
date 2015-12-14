package com.founder.service.contextsearch.department.bean;

public class DwContextCondition implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private String glpcsid;
	private String glfxjid;
	private String xt_zxbz;
	private String searchKey;
	private String queryExpression;

	public String getGlpcsid() {
		return glpcsid;
	}

	public void setGlpcsid(String glpcsid) {
		this.glpcsid = glpcsid;
	}

	public String getGlfxjid() {
		return glfxjid;
	}

	public void setGlfxjid(String glfxjid) {
		this.glfxjid = glfxjid;
	}

	public String getXt_zxbz() {
		return xt_zxbz;
	}

	public void setXt_zxbz(String xtZxbz) {
		xt_zxbz = xtZxbz;
	}

	public String getSearchKey() {
		return searchKey;
	}

	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}

	public String getQueryExpression() {
		return queryExpression;
	}

	public void setQueryExpression(String queryExpression) {
		this.queryExpression = queryExpression;
	}

}
