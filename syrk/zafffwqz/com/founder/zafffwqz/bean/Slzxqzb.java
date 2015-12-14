package com.founder.zafffwqz.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;
@DBInfoAnnotation(tableName = "FWQZ_SLZXQZB", pk = "id")
public class Slzxqzb extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@FieldDesc("受理咨询求助ID")
	private String id;
	@FieldDesc("咨询求助时间")
	private String zxqzsj;
	@FieldDesc("咨询求助内容")
	private String zxqznr;
	@FieldDesc("解答解决方式")
	private String jdjjfs;
	@FieldDesc("解答单位ID")
	private String jddwid;
	@FieldDesc("解答单位")
	private String jddw;
	@FieldDesc("解答人ID")
	private String jdrid;
	@FieldDesc("解答人")
	private String jdr;
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
	public String getZxqzsj() {
		return zxqzsj;
	}
	public void setZxqzsj(String zxqzsj) {
		this.zxqzsj = zxqzsj;
	}
	public String getZxqznr() {
		return zxqznr;
	}
	public void setZxqznr(String zxqznr) {
		this.zxqznr = zxqznr;
	}
	public String getJdjjfs() {
		return jdjjfs;
	}
	public void setJdjjfs(String jdjjfs) {
		this.jdjjfs = jdjjfs;
	}
	public String getJddwid() {
		return jddwid;
	}
	public void setJddwid(String jddwid) {
		this.jddwid = jddwid;
	}
	public String getJddw() {
		return jddw;
	}
	public void setJddw(String jddw) {
		this.jddw = jddw;
	}
	public String getJdrid() {
		return jdrid;
	}
	public void setJdrid(String jdrid) {
		this.jdrid = jdrid;
	}
	public String getJdr() {
		return jdr;
	}
	public void setJdr(String jdr) {
		this.jdr = jdr;
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
