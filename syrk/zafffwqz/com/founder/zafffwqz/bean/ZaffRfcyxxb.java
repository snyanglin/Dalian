package com.founder.zafffwqz.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;
@DBInfoAnnotation(tableName = "ZAFF_RFCYXXZB", pk = "id")
public class ZaffRfcyxxb extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@FieldDesc("人防ID")
	private String id;
	@FieldDesc("人员ID")
	private String ryid;
	//后期修改过的字段
	@FieldDesc("常用证件代码")
	private String cyzjdm;	
	@FieldDesc("证件号码")
	private String zjhm;	
	@FieldDesc("姓名")
	private String xm;
	//-----------
	
	@FieldDesc("出生日期")
	private String csrq;
	@FieldDesc("性别代码")
	private String xbdm;
	
	@FieldDesc("地址_居住地址代码")
	private String dz_jzdzdm;
	@FieldDesc("地址_居住地址省市县代码")
	private String dz_jzdzssxdm;
	@FieldDesc("地址_居住地址详址")
	private String dz_jzdzxz;
	@FieldDesc("地址_居住地址门楼牌代码")
	private String dz_jzdzmlpdm;
	@FieldDesc("地址_居住地址门楼牌详址")
	private String dz_jzdzmlpxz;
	
	@FieldDesc("备注")
	private String bz;
	@FieldDesc("人防Id")
	private String rfid;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRyid() {
		return ryid;
	}
	public void setRyid(String ryid) {
		this.ryid = ryid;
	}
	public String getCsrq() {
		return csrq;
	}
	public void setCsrq(String csrq) {
		this.csrq = csrq;
	}
	public String getXbdm() {
		return xbdm;
	}
	public void setXbdm(String xbdm) {
		this.xbdm = xbdm;
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
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	public String getRfid() {
		return rfid;
	}
	public void setRfid(String rfid) {
		this.rfid = rfid;
	}
	public String getCyzjdm() {
		return cyzjdm;
	}
	public void setCyzjdm(String cyzjdm) {
		this.cyzjdm = cyzjdm;
	}
	public String getZjhm() {
		return zjhm;
	}
	public void setZjhm(String zjhm) {
		this.zjhm = zjhm;
	}
	public String getXm() {
		return xm;
	}
	public void setXm(String xm) {
		this.xm = xm;
	}
	
	
}
