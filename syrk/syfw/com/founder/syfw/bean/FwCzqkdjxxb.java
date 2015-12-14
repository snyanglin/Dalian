package com.founder.syfw.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

@DBInfoAnnotation(tableName = "SYFW_CZQKDJXXB", pk = "id")
public class FwCzqkdjxxb extends BaseEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@FieldDesc("承租情况ID")
	private String id;
	@FieldDesc("出租房屋ID")
	private String czfwid;
	
	@FieldDesc("承租人_人员ID")
	private String chzr_ryid;
	@FieldDesc("承租人_姓名")
	private String chzr_xm;
	@FieldDesc("承租人_证件种类")
	private String chzr_cyzjdm;
	@FieldDesc("承租人_证件号码")
	private String chzr_zjhm;
	@FieldDesc("承租人_外文姓")
	private String chzr_wwx;
	@FieldDesc("承租人_外文名")
	private String chzr_wwm;
	@FieldDesc("承租人_性别")
	private String chzr_xb;
	@FieldDesc("承租人_民族代码")
	private String chzr_mzdm;
	@FieldDesc("承租人_出生日期")
	private String chzr_csrq;
	@FieldDesc("承租人_职业")
	private String chzr_zy;
	@FieldDesc("承租人_职业类别")
	private String chzr_zylbdm;
	@FieldDesc("承租人_服务处所")
	private String chzr_fwcs;
	@FieldDesc("承租人_联系电话")
	private String chzr_lxdh;
	@FieldDesc("承租人_与房主关系_人员关系")
	private String chzr_yfzgx_rygxdm;
	@FieldDesc("承租人_与托管人关系_人员关系")
	private String chzr_ytgrgx_rygxdm;
	@FieldDesc("房屋承租情况代码")
	private String fwczqkdm;
	@FieldDesc("起租日期")
	private String qzrq;
	@FieldDesc("停租日期")
	private String tzrq;
	@FieldDesc("备注")
	private String bz;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCzfwid() {
		return czfwid;
	}
	public void setCzfwid(String czfwid) {
		this.czfwid = czfwid;
	}
	public String getChzr_ryid() {
		return chzr_ryid;
	}
	public void setChzr_ryid(String chzr_ryid) {
		this.chzr_ryid = chzr_ryid;
	}
	public String getChzr_xm() {
		return chzr_xm;
	}
	public void setChzr_xm(String chzr_xm) {
		this.chzr_xm = chzr_xm;
	}
	public String getChzr_cyzjdm() {
		return chzr_cyzjdm;
	}
	public void setChzr_cyzjdm(String chzr_cyzjdm) {
		this.chzr_cyzjdm = chzr_cyzjdm;
	}
	public String getChzr_zjhm() {
		return chzr_zjhm;
	}
	public void setChzr_zjhm(String chzr_zjhm) {
		this.chzr_zjhm = chzr_zjhm;
	}
	public String getChzr_wwx() {
		return chzr_wwx;
	}
	public void setChzr_wwx(String chzr_wwx) {
		this.chzr_wwx = chzr_wwx;
	}
	public String getChzr_wwm() {
		return chzr_wwm;
	}
	public void setChzr_wwm(String chzr_wwm) {
		this.chzr_wwm = chzr_wwm;
	}
	public String getChzr_xb() {
		return chzr_xb;
	}
	public void setChzr_xb(String chzr_xb) {
		this.chzr_xb = chzr_xb;
	}
	public String getChzr_mzdm() {
		return chzr_mzdm;
	}
	public void setChzr_mzdm(String chzr_mzdm) {
		this.chzr_mzdm = chzr_mzdm;
	}
	public String getChzr_csrq() {
		return chzr_csrq;
	}
	public void setChzr_csrq(String chzr_csrq) {
		this.chzr_csrq = chzr_csrq;
	}
	public String getChzr_zy() {
		return chzr_zy;
	}
	public void setChzr_zy(String chzr_zy) {
		this.chzr_zy = chzr_zy;
	}
	public String getChzr_zylbdm() {
		return chzr_zylbdm;
	}
	public void setChzr_zylbdm(String chzr_zylbdm) {
		this.chzr_zylbdm = chzr_zylbdm;
	}
	public String getChzr_fwcs() {
		return chzr_fwcs;
	}
	public void setChzr_fwcs(String chzr_fwcs) {
		this.chzr_fwcs = chzr_fwcs;
	}
	public String getChzr_lxdh() {
		return chzr_lxdh;
	}
	public void setChzr_lxdh(String chzr_lxdh) {
		this.chzr_lxdh = chzr_lxdh;
	}
	public String getChzr_yfzgx_rygxdm() {
		return chzr_yfzgx_rygxdm;
	}
	public void setChzr_yfzgx_rygxdm(String chzr_yfzgx_rygxdm) {
		this.chzr_yfzgx_rygxdm = chzr_yfzgx_rygxdm;
	}
	public String getChzr_ytgrgx_rygxdm() {
		return chzr_ytgrgx_rygxdm;
	}
	public void setChzr_ytgrgx_rygxdm(String chzr_ytgrgx_rygxdm) {
		this.chzr_ytgrgx_rygxdm = chzr_ytgrgx_rygxdm;
	}
	public String getFwczqkdm() {
		return fwczqkdm;
	}
	public void setFwczqkdm(String fwczqkdm) {
		this.fwczqkdm = fwczqkdm;
	}
	public String getQzrq() {
		return qzrq;
	}
	public void setQzrq(String qzrq) {
		this.qzrq = qzrq;
	}
	public String getTzrq() {
		return tzrq;
	}
	public void setTzrq(String tzrq) {
		this.tzrq = tzrq;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	
	
	
	

}
