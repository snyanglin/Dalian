package com.founder.sqjw.vo;
/**
 * @类名: SyrkVO 
 * @描述: 实有人口VO 
 * @作者: zhang_guoliang@founder.com 
 * @日期: 2014-8-16 下午5:20:09 
 */
public class SyrkVO {
	private String id;    //实有人口ID
	private String gmsfhm;//身份号码
	private String xm;    //姓名
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getGmsfhm() {
		return gmsfhm;
	}
	public void setGmsfhm(String gmsfhm) {
		this.gmsfhm = gmsfhm;
	}
	public String getXm() {
		return xm;
	}
	public void setXm(String xm) {
		this.xm = xm;
	}
}