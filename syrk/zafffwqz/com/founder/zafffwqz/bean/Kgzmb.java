package com.founder.zafffwqz.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;
@DBInfoAnnotation(tableName = "FWQZ_KGZMB", pk = "id")
public class Kgzmb  extends BaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@FieldDesc("空挂证明ID")
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
	@FieldDesc("地址-户籍地址代码")
	private String dz_hjdzdm;
	@FieldDesc("地址-户籍地址省市县代码")
	private String dz_hjdzssxdm;
	@FieldDesc("地址-户籍地址门楼牌代码")
	private String dz_hjdzmlpdm;
	@FieldDesc("地址-户籍地址门楼牌详址")
	private String dz_hjdzmlpxz;
	@FieldDesc("地址-户籍地址详址")
	private String dz_hjdzxz;
	@FieldDesc("是否外地居住代码")
	private String sfwdjzdm;
	@FieldDesc("地址-居住地址代码")
	private String dz_jzdzdm;
	@FieldDesc("地址-居住地址省市县代码")
	private String dz_jzdzssxdm;
	@FieldDesc("地址-居住地址门楼牌代码")
	private String dz_jzdzmlpdm;
	@FieldDesc("地址-居住地址门楼牌详址")
	private String dz_jzdzmlpxz;
	@FieldDesc("地址-居住地址详址")
	private String dz_jzdzxz;
	@FieldDesc("实有人口登记时间")
	private String syrkdjsj;
	@FieldDesc("实有人口类型代码")
	private String syrklxdm;
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
	public String getDz_hjdzdm() {
		return dz_hjdzdm;
	}
	public void setDz_hjdzdm(String dz_hjdzdm) {
		this.dz_hjdzdm = dz_hjdzdm;
	}
	public String getDz_hjdzssxdm() {
		return dz_hjdzssxdm;
	}
	public void setDz_hjdzssxdm(String dz_hjdzssxdm) {
		this.dz_hjdzssxdm = dz_hjdzssxdm;
	}
	public String getDz_hjdzmlpdm() {
		return dz_hjdzmlpdm;
	}
	public void setDz_hjdzmlpdm(String dz_hjdzmlpdm) {
		this.dz_hjdzmlpdm = dz_hjdzmlpdm;
	}
	public String getDz_hjdzmlpxz() {
		return dz_hjdzmlpxz;
	}
	public void setDz_hjdzmlpxz(String dz_hjdzmlpxz) {
		this.dz_hjdzmlpxz = dz_hjdzmlpxz;
	}
	public String getDz_hjdzxz() {
		return dz_hjdzxz;
	}
	public void setDz_hjdzxz(String dz_hjdzxz) {
		this.dz_hjdzxz = dz_hjdzxz;
	}
	public String getSfwdjzdm() {
		return sfwdjzdm;
	}
	public void setSfwdjzdm(String sfwdjzdm) {
		this.sfwdjzdm = sfwdjzdm;
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
	public String getDz_jzdzxz() {
		return dz_jzdzxz;
	}
	public void setDz_jzdzxz(String dz_jzdzxz) {
		this.dz_jzdzxz = dz_jzdzxz;
	}
	public String getSyrkdjsj() {
		return syrkdjsj;
	}
	public void setSyrkdjsj(String syrkdjsj) {
		this.syrkdjsj = syrkdjsj;
	}
	public String getSyrklxdm() {
		return syrklxdm;
	}
	public void setSyrklxdm(String syrklxdm) {
		this.syrklxdm = syrklxdm;
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
	
	
}
