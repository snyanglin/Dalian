package com.founder.zafffwqz.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

@DBInfoAnnotation(tableName = "ZAFF_ZAZZRYXXB", pk = "id")
public class Zazzryxxb extends BaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@FieldDesc("治安组织人员ID")
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
	@FieldDesc("联系方式")
	private String lxfs;
	@FieldDesc("人员来源")
	private String ryly;
	@FieldDesc("组织内职务")
	private String zznzw;
	@FieldDesc("参加时间")
	private String cjsj;
	@FieldDesc("备注")
	private String bz;
	@FieldDesc("人员ID")
	private String ryid;
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
	public String getLxfs() {
		return lxfs;
	}
	public void setLxfs(String lxfs) {
		this.lxfs = lxfs;
	}
	public String getRyly() {
		return ryly;
	}
	public void setRyly(String ryly) {
		this.ryly = ryly;
	}
	public String getZznzw() {
		return zznzw;
	}
	public void setZznzw(String zznzw) {
		this.zznzw = zznzw;
	}
	public String getCjsj() {
		return cjsj;
	}
	public void setCjsj(String cjsj) {
		this.cjsj = cjsj;
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
	
}
