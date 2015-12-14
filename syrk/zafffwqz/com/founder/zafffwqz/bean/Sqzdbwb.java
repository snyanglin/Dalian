package com.founder.zafffwqz.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

@DBInfoAnnotation(tableName = "ZAFF_SQZDBWB", pk = "id")
public class Sqzdbwb extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@FieldDesc("社区重点部位ID")
	private String id;
	@FieldDesc("社区ID")
	private String sqid;
	@FieldDesc("重点部位名称")
	private String zdbwmc;

	@FieldDesc("确定日期")
	private String qdrq;
	@FieldDesc("部位描述")
	private String bwms;
	@FieldDesc("社区警务室ID")
	private String sqjwsid;	
	@FieldDesc("备注")
	private String bz;
	
	//后期修改的
	@FieldDesc("地址_重点部位类型代码")
	private String dz_zdbwlxdm;	
	@FieldDesc("重点部位地址代码")
	private String dz_zdbwdzdm;
	@FieldDesc("重点部位省市县代码")
	private String dz_zdbwssxdm;
	@FieldDesc("重点部位详址")
	private String dz_zdbwxz;
	@FieldDesc("重点部位门楼牌代码")
	private String dz_zdbwmlpdm;
	@FieldDesc("重点部位门楼牌详址")
	private String dz_zdbwmlpxz;
	


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSqjwsid() {
		return sqjwsid;
	}

	public void setSqjwsid(String sqjwsid) {
		this.sqjwsid = sqjwsid;
	}

	public String getSqid() {
		return sqid;
	}

	public void setSqid(String sqid) {
		this.sqid = sqid;
	}

	public String getZdbwmc() {
		return zdbwmc;
	}

	public void setZdbwmc(String zdbwmc) {
		this.zdbwmc = zdbwmc;
	}


	public String getQdrq() {
		return qdrq;
	}

	public void setQdrq(String qdrq) {
		this.qdrq = qdrq;
	}

	public String getBwms() {
		return bwms;
	}

	public void setBwms(String bwms) {
		this.bwms = bwms;
	}

	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

	

	public String getDz_zdbwlxdm() {
		return dz_zdbwlxdm;
	}

	public void setDz_zdbwlxdm(String dz_zdbwlxdm) {
		this.dz_zdbwlxdm = dz_zdbwlxdm;
	}

	public String getDz_zdbwdzdm() {
		return dz_zdbwdzdm;
	}

	public void setDz_zdbwdzdm(String dz_zdbwdzdm) {
		this.dz_zdbwdzdm = dz_zdbwdzdm;
	}

	public String getDz_zdbwssxdm() {
		return dz_zdbwssxdm;
	}

	public void setDz_zdbwssxdm(String dz_zdbwssxdm) {
		this.dz_zdbwssxdm = dz_zdbwssxdm;
	}

	public String getDz_zdbwxz() {
		return dz_zdbwxz;
	}

	public void setDz_zdbwxz(String dz_zdbwxz) {
		this.dz_zdbwxz = dz_zdbwxz;
	}

	public String getDz_zdbwmlpdm() {
		return dz_zdbwmlpdm;
	}

	public void setDz_zdbwmlpdm(String dz_zdbwmlpdm) {
		this.dz_zdbwmlpdm = dz_zdbwmlpdm;
	}

	public String getDz_zdbwmlpxz() {
		return dz_zdbwmlpxz;
	}

	public void setDz_zdbwmlpxz(String dz_zdbwmlpxz) {
		this.dz_zdbwmlpxz = dz_zdbwmlpxz;
	}


}
