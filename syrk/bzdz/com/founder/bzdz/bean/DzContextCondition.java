package com.founder.bzdz.bean;
/**
 * @类名: DzContextCondition 
 * @描述: 地址检索传入参数
 * @作者: zhang_guoliang@founder.com 
 * @日期: 2015-4-13 上午10:06:29 
 */
public class DzContextCondition implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private String id;
	private String fxjdm;
	private String pcsdm;
	private String zrqdm;
	private String xzqh;
	private String jlxdm;
	private String searchKey;
	private String queryExpression;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFxjdm() {
		return fxjdm;
	}
	public void setFxjdm(String fxjdm) {
		this.fxjdm = fxjdm;
	}
	public String getPcsdm() {
		return pcsdm;
	}
	public void setPcsdm(String pcsdm) {
		this.pcsdm = pcsdm;
	}
	public String getZrqdm() {
		return zrqdm;
	}
	public void setZrqdm(String zrqdm) {
		this.zrqdm = zrqdm;
	}
	public String getXzqh() {
		return xzqh;
	}
	public void setXzqh(String xzqh) {
		this.xzqh = xzqh;
	}
	public String getJlxdm() {
		return jlxdm;
	}
	public void setJlxdm(String jlxdm) {
		this.jlxdm = jlxdm;
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