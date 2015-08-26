package com.founder.sydw.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

@DBInfoAnnotation(tableName = "DW_JDCXLXXB", pk = "id")
public class Jdcxlxxb extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@FieldDesc("ID")
	private String id;
	@FieldDesc("单位ID")
	private String dwid;
	@FieldDesc("是否专修店代码")
	private String sfzxddm;
	@FieldDesc("是否连锁店代码")
	private String sflsddm;
	@FieldDesc("修理范围")
	private String xlfw;
	@FieldDesc("备注")
	private String bz;
	@FieldDesc("是否备案代码")
	private String sfbadm;
	@FieldDesc("备案_单位名称")
	private String ba_dwmc;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDwid() {
		return dwid;
	}
	public void setDwid(String dwid) {
		this.dwid = dwid;
	}
	public String getSfzxddm() {
		return sfzxddm;
	}
	public void setSfzxddm(String sfzxddm) {
		this.sfzxddm = sfzxddm;
	}
	public String getSflsddm() {
		return sflsddm;
	}
	public void setSflsddm(String sflsddm) {
		this.sflsddm = sflsddm;
	}
	public String getXlfw() {
		return xlfw;
	}
	public void setXlfw(String xlfw) {
		this.xlfw = xlfw;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	public String getSfbadm() {
		return sfbadm;
	}
	public void setSfbadm(String sfbadm) {
		this.sfbadm = sfbadm;
	}
	/**
	 * @return the ba_dwmc
	 */
	public String getBa_dwmc() {
		return ba_dwmc;
	}
	/**
	 * @param baDwmc the ba_dwmc to set
	 */
	public void setBa_dwmc(String baDwmc) {
		ba_dwmc = baDwmc;
	}
	
	
}
