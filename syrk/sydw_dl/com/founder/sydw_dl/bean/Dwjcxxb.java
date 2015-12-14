package com.founder.sydw_dl.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;
@DBInfoAnnotation(tableName = "DW_DWJCXXB", pk = "id")
public class Dwjcxxb extends BaseEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@FieldDesc("ID")
	private String id;
	@FieldDesc("单位ID")
	private String dwid;
	@FieldDesc("检查时间")
	private String jcsj;
	@FieldDesc("检查单位ID")
	private String jcdwid;
	@FieldDesc("检查单位")
	private String jcdw;
	@FieldDesc("检查情况")
	private String jcqk;
	@FieldDesc("检查结果")
	private String jcjg;
	@FieldDesc("整改通知书或裁决书号")
	private String zgtzshcjsh;
	@FieldDesc("整改通知书名称")
	private String zgtzsmc;
	@FieldDesc("整改或处罚意见")
	private String zghcfyj;
	@FieldDesc("单位负责人")
	private String dwfzr;
	@FieldDesc("检查人员")
	private String jcry;
	@FieldDesc("清查项目")
	private String qcxm;
	@FieldDesc("清查结果")
	private String qcjg;
	@FieldDesc("现场负责人")
	private String xcfzr;
	@FieldDesc("备注")
	private String bz;
	@FieldDesc("检查项目")
	private String jcxm;
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
	public String getJcsj() {
		return jcsj;
	}
	public void setJcsj(String jcsj) {
		this.jcsj = jcsj;
	}
	public String getJcdwid() {
		return jcdwid;
	}
	public void setJcdwid(String jcdwid) {
		this.jcdwid = jcdwid;
	}
	public String getJcdw() {
		return jcdw;
	}
	public void setJcdw(String jcdw) {
		this.jcdw = jcdw;
	}
	public String getJcqk() {
		return jcqk;
	}
	public void setJcqk(String jcqk) {
		this.jcqk = jcqk;
	}
	public String getJcjg() {
		return jcjg;
	}
	public void setJcjg(String jcjg) {
		this.jcjg = jcjg;
	}
	public String getZgtzshcjsh() {
		return zgtzshcjsh;
	}
	public void setZgtzshcjsh(String zgtzshcjsh) {
		this.zgtzshcjsh = zgtzshcjsh;
	}
	public String getZgtzsmc() {
		return zgtzsmc;
	}
	public void setZgtzsmc(String zgtzsmc) {
		this.zgtzsmc = zgtzsmc;
	}
	
	public String getZghcfyj() {
		return zghcfyj;
	}
	public void setZghcfyj(String zghcfyj) {
		this.zghcfyj = zghcfyj;
	}
	public String getDwfzr() {
		return dwfzr;
	}
	public void setDwfzr(String dwfzr) {
		this.dwfzr = dwfzr;
	}
	public String getJcry() {
		return jcry;
	}
	public void setJcry(String jcry) {
		this.jcry = jcry;
	}
	public String getQcxm() {
		return qcxm;
	}
	public void setQcxm(String qcxm) {
		this.qcxm = qcxm;
	}
	public String getQcjg() {
		return qcjg;
	}
	public void setQcjg(String qcjg) {
		this.qcjg = qcjg;
	}
	public String getXcfzr() {
		return xcfzr;
	}
	public void setXcfzr(String xcfzr) {
		this.xcfzr = xcfzr;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	public String getJcxm() {
		return jcxm;
	}
	public void setJcxm(String jcxm) {
		this.jcxm = jcxm;
	}
	
}
