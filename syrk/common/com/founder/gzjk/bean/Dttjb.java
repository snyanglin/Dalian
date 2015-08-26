package com.founder.gzjk.bean;

import java.io.Serializable;

import com.founder.framework.base.entity.BaseEntity;

public class Dttjb  extends BaseEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String orgcode;
	private String orgname;
	private String rk_cnt;
	private String dw_cnt;
	private String fw_cnt;
	private String zdry_cnt;
	private String dt;
	private String bzdz_cnt;
	public String getOrgcode() {
		return orgcode;
	}
	public void setOrgcode(String orgcode) {
		this.orgcode = orgcode;
	}
	public String getOrgname() {
		return orgname;
	}
	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}
	public String getRk_cnt() {
		return rk_cnt;
	}
	public void setRk_cnt(String rk_cnt) {
		this.rk_cnt = rk_cnt;
	}
	public String getDw_cnt() {
		return dw_cnt;
	}
	public void setDw_cnt(String dw_cnt) {
		this.dw_cnt = dw_cnt;
	}
	public String getFw_cnt() {
		return fw_cnt;
	}
	public void setFw_cnt(String fw_cnt) {
		this.fw_cnt = fw_cnt;
	}
	public String getZdry_cnt() {
		return zdry_cnt;
	}
	public void setZdry_cnt(String zdry_cnt) {
		this.zdry_cnt = zdry_cnt;
	}
	public String getDt() {
		return dt;
	}
	public void setDt(String dt) {
		this.dt = dt;
	}
	public String getBzdz_cnt() {
		return bzdz_cnt;
	}
	public void setBzdz_cnt(String bzdz_cnt) {
		this.bzdz_cnt = bzdz_cnt;
	}

	
	

}
