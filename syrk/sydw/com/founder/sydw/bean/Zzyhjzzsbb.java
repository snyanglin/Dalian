package com.founder.sydw.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;
@DBInfoAnnotation(tableName = "DW_ZZYHJZZSBB", pk = "id")
public class Zzyhjzzsbb extends  BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@FieldDesc("ID")
	private String id;
	@FieldDesc("单位ID")
	private String dwid;
	@FieldDesc("自助设备类别代码")
	private String zzsblbdm;
	@FieldDesc("安装_日期")
	private String az_rq;
	@FieldDesc("安装地点")
	private String azdd;
	@FieldDesc("监控情况")
	private String jkqk;
	@FieldDesc("责任人_人员ID")
	private String zrr_ryid;
	@FieldDesc("责任人_常用证件代码")
	private String zrr_cyzjdm;
	@FieldDesc("责任人_证件号码")
	private String zrr_zjhm;
	@FieldDesc("责任人_姓名")
	private String zrr_xm;
	@FieldDesc("责任人_职务名称")
	private String zrr_zwmc;
	@FieldDesc("责任人_联系电话")
	private String zrr_lxdh;
	@FieldDesc("备注")
	private String bz;
	
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
	public String getZzsblbdm() {
		return zzsblbdm;
	}
	public void setZzsblbdm(String zzsblbdm) {
		this.zzsblbdm = zzsblbdm;
	}
	public String getAz_rq() {
		return az_rq;
	}
	public void setAz_rq(String az_rq) {
		this.az_rq = az_rq;
	}
	public String getAzdd() {
		return azdd;
	}
	public void setAzdd(String azdd) {
		this.azdd = azdd;
	}
	public String getJkqk() {
		return jkqk;
	}
	public void setJkqk(String jkqk) {
		this.jkqk = jkqk;
	}
	public String getZrr_ryid() {
		return zrr_ryid;
	}
	public void setZrr_ryid(String zrr_ryid) {
		this.zrr_ryid = zrr_ryid;
	}
	public String getZrr_cyzjdm() {
		return zrr_cyzjdm;
	}
	public void setZrr_cyzjdm(String zrr_cyzjdm) {
		this.zrr_cyzjdm = zrr_cyzjdm;
	}
	public String getZrr_zjhm() {
		return zrr_zjhm;
	}
	public void setZrr_zjhm(String zrr_zjhm) {
		this.zrr_zjhm = zrr_zjhm;
	}
	public String getZrr_xm() {
		return zrr_xm;
	}
	public void setZrr_xm(String zrr_xm) {
		this.zrr_xm = zrr_xm;
	}
	public String getZrr_zwmc() {
		return zrr_zwmc;
	}
	public void setZrr_zwmc(String zrr_zwmc) {
		this.zrr_zwmc = zrr_zwmc;
	}
	public String getZrr_lxdh() {
		return zrr_lxdh;
	}
	public void setZrr_lxdh(String zrr_lxdh) {
		this.zrr_lxdh = zrr_lxdh;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	
}
