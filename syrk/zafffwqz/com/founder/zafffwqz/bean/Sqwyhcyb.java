package com.founder.zafffwqz.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

@DBInfoAnnotation(tableName = "ZAFF_SQWYHCYB", pk = "id")
public class Sqwyhcyb extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@FieldDesc("社区委员会成员ID")
	private String id;
	@FieldDesc("社区ID")
	private String sqid;
	@FieldDesc("社区警务室ID")
	private String sqjwsid;
	@FieldDesc("常用证件代码")
	private String cyzjdm;
	@FieldDesc("证件号码")
	private String zjhm;
	@FieldDesc("姓名")
	private String xm;
	@FieldDesc("性别代码")
	private String xbdm;
	@FieldDesc("文化程度代码")
	private String whcddm;
	@FieldDesc("政治面貌代码")
	private String zzmmdm;
	@FieldDesc("联系电话")
	private String lxdh;
	
	@FieldDesc("家庭住址代码")
	private String dz_jtzzdm;
	@FieldDesc("家庭住址省市县代码")
	private String dz_jtzzssxdm;
	@FieldDesc("家庭住址详址")
	private String dz_jtzzxz;
	@FieldDesc("家庭住址门楼牌代码")
	private String dz_jtzzmlpdm;
	@FieldDesc("家庭住址门楼牌详址")
	private String dz_jtzzmlpxz;
	
	@FieldDesc("备注")
	private String bz;
	@FieldDesc("人员ID")
	private String ryid;
	//增加字段
	private String zw;
	private String fggzms;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSqid() {
		return sqid;
	}
	public void setSqid(String sqid) {
		this.sqid = sqid;
	}
	public String getSqjwsid() {
		return sqjwsid;
	}
	public void setSqjwsid(String sqjwsid) {
		this.sqjwsid = sqjwsid;
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
	public String getXbdm() {
		return xbdm;
	}
	public void setXbdm(String xbdm) {
		this.xbdm = xbdm;
	}
	public String getWhcddm() {
		return whcddm;
	}
	public void setWhcddm(String whcddm) {
		this.whcddm = whcddm;
	}
	public String getZzmmdm() {
		return zzmmdm;
	}
	public void setZzmmdm(String zzmmdm) {
		this.zzmmdm = zzmmdm;
	}
	public String getLxdh() {
		return lxdh;
	}
	public void setLxdh(String lxdh) {
		this.lxdh = lxdh;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	public String getRyid() {
		return ryid;
	}
	public void setRyid(String ryid) {
		this.ryid = ryid;
	}
	public String getZw() {
		return zw;
	}
	public void setZw(String zw) {
		this.zw = zw;
	}
	public String getFggzms() {
		return fggzms;
	}
	public void setFggzms(String fggzms) {
		this.fggzms = fggzms;
	}
	public String getDz_jtzzdm() {
		return dz_jtzzdm;
	}
	public void setDz_jtzzdm(String dz_jtzzdm) {
		this.dz_jtzzdm = dz_jtzzdm;
	}
	public String getDz_jtzzssxdm() {
		return dz_jtzzssxdm;
	}
	public void setDz_jtzzssxdm(String dz_jtzzssxdm) {
		this.dz_jtzzssxdm = dz_jtzzssxdm;
	}
	public String getDz_jtzzxz() {
		return dz_jtzzxz;
	}
	public void setDz_jtzzxz(String dz_jtzzxz) {
		this.dz_jtzzxz = dz_jtzzxz;
	}
	public String getDz_jtzzmlpdm() {
		return dz_jtzzmlpdm;
	}
	public void setDz_jtzzmlpdm(String dz_jtzzmlpdm) {
		this.dz_jtzzmlpdm = dz_jtzzmlpdm;
	}
	public String getDz_jtzzmlpxz() {
		return dz_jtzzmlpxz;
	}
	public void setDz_jtzzmlpxz(String dz_jtzzmlpxz) {
		this.dz_jtzzmlpxz = dz_jtzzmlpxz;
	}

	
}
