package com.founder.zafffwqz.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;
@DBInfoAnnotation(tableName = "FWQZ_ZAFFXCB", pk = "id")
public class Zaffxcb extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	@FieldDesc("治安防范宣传ID")
	private String id;
	@FieldDesc("宣传时间")
	private String xcsj;
	@FieldDesc("宣传内容")
	private String xcnr;
	@FieldDesc("宣传形式")
	private String xcxs;
	@FieldDesc("宣传单位ID")
	private String xcdwid;
	@FieldDesc("宣传单位")
	private String xcdw;
	@FieldDesc("宣传人ID")
	private String xcrid;
	@FieldDesc("宣传人")
	private String xcr;
	@FieldDesc("备注")
	private String bz;
	private String startDate;
	private String endDate;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getXcsj() {
		return xcsj;
	}
	public void setXcsj(String xcsj) {
		this.xcsj = xcsj;
	}
	public String getXcnr() {
		return xcnr;
	}
	public void setXcnr(String xcnr) {
		this.xcnr = xcnr;
	}
	public String getXcxs() {
		return xcxs;
	}
	public void setXcxs(String xcxs) {
		this.xcxs = xcxs;
	}
	public String getXcdwid() {
		return xcdwid;
	}
	public void setXcdwid(String xcdwid) {
		this.xcdwid = xcdwid;
	}
	public String getXcdw() {
		return xcdw;
	}
	public void setXcdw(String xcdw) {
		this.xcdw = xcdw;
	}
	public String getXcrid() {
		return xcrid;
	}
	public void setXcrid(String xcrid) {
		this.xcrid = xcrid;
	}
	public String getXcr() {
		return xcr;
	}
	public void setXcr(String xcr) {
		this.xcr = xcr;
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
	
	
}
