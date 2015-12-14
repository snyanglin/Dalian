package com.founder.tzgg.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;
@DBInfoAnnotation(tableName = "SYS_TZGGB", pk = "id")
public class Sys_Tzggb extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@FieldDesc("通知公告ID")
	private String id;
	@FieldDesc("公告标题")
	private String ggbt;
	@FieldDesc("公告内容")
	private String ggnr;
	@FieldDesc("发送人")
	private String fsr;
	@FieldDesc("发送人ID")
	private String fsrid;
	@FieldDesc("发送部门")
	private String fsbm;
	@FieldDesc("发送部门ID")
	private String fsbmid;
	@FieldDesc("发送时间")
	private String fssj;
	@FieldDesc("发布状态代码")
	private String fbztdm;
	@FieldDesc("备注")
	private String bz;
	
	private String startDate;
	private String endDate;
	//接收部门子表
	private String tzggid;
	//接收部门
	private String jsbm;
	//接收部门id
	private String jsbmid;
	
	private String ljym;
	private String zjtk;
	private String tzgglx;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getGgbt() {
		return ggbt;
	}
	public void setGgbt(String ggbt) {
		this.ggbt = ggbt;
	}
	public String getGgnr() {
		return ggnr;
	}
	public void setGgnr(String ggnr) {
		this.ggnr = ggnr;
	}
	public String getFsr() {
		return fsr;
	}
	public void setFsr(String fsr) {
		this.fsr = fsr;
	}
	public String getFsrid() {
		return fsrid;
	}
	public void setFsrid(String fsrid) {
		this.fsrid = fsrid;
	}
	public String getFsbm() {
		return fsbm;
	}
	public void setFsbm(String fsbm) {
		this.fsbm = fsbm;
	}
	public String getFsbmid() {
		return fsbmid;
	}
	public void setFsbmid(String fsbmid) {
		this.fsbmid = fsbmid;
	}
	public String getFssj() {
		return fssj;
	}
	public void setFssj(String fssj) {
		this.fssj = fssj;
	}
	public String getFbztdm() {
		return fbztdm;
	}
	public void setFbztdm(String fbztdm) {
		this.fbztdm = fbztdm;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getTzggid() {
		return tzggid;
	}
	public void setTzggid(String tzggid) {
		this.tzggid = tzggid;
	}
	public String getJsbm() {
		return jsbm;
	}
	public void setJsbm(String jsbm) {
		this.jsbm = jsbm;
	}
	public String getJsbmid() {
		return jsbmid;
	}
	public void setJsbmid(String jsbmid) {
		this.jsbmid = jsbmid;
	}
	public String getLjym() {
		return ljym;
	}
	public void setLjym(String ljym) {
		this.ljym = ljym;
	}
	public String getZjtk() {
		return zjtk;
	}
	public void setZjtk(String zjtk) {
		this.zjtk = zjtk;
	}
	public String getTzgglx() {
		return tzgglx;
	}
	public void setTzgglx(String tzgglx) {
		this.tzgglx = tzgglx;
	}
    
	
	 
}
