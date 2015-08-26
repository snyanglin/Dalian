package com.founder.gzjk.bean;

import java.io.Serializable;

import com.founder.framework.base.entity.BaseEntity;
public class Gzdt extends BaseEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String xz;//新增 
	private String xg;//修改 
	private String zx;//注销
	private String ywlb;//业务类别 1.人口 2.单位 3.房屋 4.重点人员 5.标准地址
	private String dwdm;//单位代码
	private String currentDay;//今天日期
	private String syrkCount;//实有人口总数
	private String syfwCount;//实有房屋总数
	private String sydwCount;//实有单位总数
	private String bzdzCount;//标准地址总数
	private String zdryCount;//重点人员总数
	public String getXz() {
		return xz;
	}
	public void setXz(String xz) {
		this.xz = xz;
	}
	public String getXg() {
		return xg;
	}
	public void setXg(String xg) {
		this.xg = xg;
	}
	public String getZx() {
		return zx;
	}
	public void setZx(String zx) {
		this.zx = zx;
	}
	public String getYwlb() {
		return ywlb;
	}
	public void setYwlb(String ywlb) {
		this.ywlb = ywlb;
	}
	public String getDwdm() {
		return dwdm;
	}
	public void setDwdm(String dwdm) {
		this.dwdm = dwdm;
	}
	public String getCurrentDay() {
		return currentDay;
	}
	public void setCurrentDay(String currentDay) {
		this.currentDay = currentDay;
	}
	public String getSyrkCount() {
		return syrkCount;
	}
	public void setSyrkCount(String syrkCount) {
		this.syrkCount = syrkCount;
	}
	public String getSyfwCount() {
		return syfwCount;
	}
	public void setSyfwCount(String syfwCount) {
		this.syfwCount = syfwCount;
	}
	public String getSydwCount() {
		return sydwCount;
	}
	public void setSydwCount(String sydwCount) {
		this.sydwCount = sydwCount;
	}
	public String getBzdzCount() {
		return bzdzCount;
	}
	public void setBzdzCount(String bzdzCount) {
		this.bzdzCount = bzdzCount;
	}
	public String getZdryCount() {
		return zdryCount;
	}
	public void setZdryCount(String zdryCount) {
		this.zdryCount = zdryCount;
	}
	
	
	
	
}
