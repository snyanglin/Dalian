package com.founder.zafffwqz.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

@DBInfoAnnotation(tableName = "FWQZ_CSZMB", pk = "id")
public class Cszmb extends BaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@FieldDesc("出生证明ID")
	private String id;
	@FieldDesc("证明接收单位")
	private String zmjsdw;
	@FieldDesc("人员ID")
	private String ryid;
	@FieldDesc("公民身份号码")
	private String gmsfhm;
	@FieldDesc("姓名")
	private String xm;
	@FieldDesc("性别代码")
	private String xbdm;
	@FieldDesc("出生日期")
	private String csrq;
	@FieldDesc("出生地")
	private String csd;
	@FieldDesc("地址-居住地址代码")
	private String dz_jzdzdm;
	@FieldDesc("地址-居住地址省市县代码")
	private String dz_jzdzssxdm;
	@FieldDesc("地址-居住地址详址")
	private String dz_jzdzxz;
	@FieldDesc("生父姓名")
	private String sfxm;
	@FieldDesc("生父姓名")
	private String smxm;
	@FieldDesc("开具日期")
	private String kjrq;
	@FieldDesc("证明开具单位ID")
	private String zmkjdwid;
	@FieldDesc("证明开具单位")
	private String zmkjdw;
	@FieldDesc("证明开具人ID")
	private String zmkjrid;
	@FieldDesc("证明开具人")
	private String zmkjr;
	@FieldDesc("备注")
	private String bz;
	@FieldDesc("地址-居住地址门楼牌代码")
	private String dz_jzdzmlpdm;
	@FieldDesc("地址-居住地址门楼牌详址")
	private String dz_jzdzmlpxz;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getZmjsdw() {
		return zmjsdw;
	}
	public void setZmjsdw(String zmjsdw) {
		this.zmjsdw = zmjsdw;
	}
	public String getRyid() {
		return ryid;
	}
	public void setRyid(String ryid) {
		this.ryid = ryid;
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
	public String getXbdm() {
		return xbdm;
	}
	public void setXbdm(String xbdm) {
		this.xbdm = xbdm;
	}
	public String getCsrq() {
		return csrq;
	}
	public void setCsrq(String csrq) {
		this.csrq = csrq;
	}
	public String getCsd() {
		return csd;
	}
	public void setCsd(String csd) {
		this.csd = csd;
	}
	public String getDz_jzdzdm() {
		return dz_jzdzdm;
	}
	public void setDz_jzdzdm(String dz_jzdzdm) {
		this.dz_jzdzdm = dz_jzdzdm;
	}
	public String getDz_jzdzssxdm() {
		return dz_jzdzssxdm;
	}
	public void setDz_jzdzssxdm(String dz_jzdzssxdm) {
		this.dz_jzdzssxdm = dz_jzdzssxdm;
	}
	public String getDz_jzdzxz() {
		return dz_jzdzxz;
	}
	public void setDz_jzdzxz(String dz_jzdzxz) {
		this.dz_jzdzxz = dz_jzdzxz;
	}
	public String getSfxm() {
		return sfxm;
	}
	public void setSfxm(String sfxm) {
		this.sfxm = sfxm;
	}
	public String getSmxm() {
		return smxm;
	}
	public void setSmxm(String smxm) {
		this.smxm = smxm;
	}
	public String getKjrq() {
		return kjrq;
	}
	public void setKjrq(String kjrq) {
		this.kjrq = kjrq;
	}
	public String getZmkjdwid() {
		return zmkjdwid;
	}
	public void setZmkjdwid(String zmkjdwid) {
		this.zmkjdwid = zmkjdwid;
	}
	public String getZmkjdw() {
		return zmkjdw;
	}
	public void setZmkjdw(String zmkjdw) {
		this.zmkjdw = zmkjdw;
	}
	public String getZmkjrid() {
		return zmkjrid;
	}
	public void setZmkjrid(String zmkjrid) {
		this.zmkjrid = zmkjrid;
	}
	public String getZmkjr() {
		return zmkjr;
	}
	public void setZmkjr(String zmkjr) {
		this.zmkjr = zmkjr;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	public String getDz_jzdzmlpdm() {
		return dz_jzdzmlpdm;
	}
	public void setDz_jzdzmlpdm(String dz_jzdzmlpdm) {
		this.dz_jzdzmlpdm = dz_jzdzmlpdm;
	}
	public String getDz_jzdzmlpxz() {
		return dz_jzdzmlpxz;
	}
	public void setDz_jzdzmlpxz(String dz_jzdzmlpxz) {
		this.dz_jzdzmlpxz = dz_jzdzmlpxz;
	}
	
	
	
}
