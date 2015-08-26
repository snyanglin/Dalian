package com.founder.zafffwqz.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;
@DBInfoAnnotation(tableName = "FWQZ_KTHB", pk = "id")
public class Kthb extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@FieldDesc("恳谈会ID")
	private String id;
	@FieldDesc("召开时间")
	private String zksj;
	@FieldDesc("组织人单位ID")
	private String zzrdwid;
	@FieldDesc("组织人单位")
	private String zzrdw;
	@FieldDesc("组织人ID")
	private String zzrid;
	@FieldDesc("组织人")
	private String zzr;
	@FieldDesc("与会人")
	private String yhr;
	@FieldDesc("会议内容")
	private String hynr;
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
	public String getZksj() {
		return zksj;
	}
	public void setZksj(String zksj) {
		this.zksj = zksj;
	}
	public String getZzrdwid() {
		return zzrdwid;
	}
	public void setZzrdwid(String zzrdwid) {
		this.zzrdwid = zzrdwid;
	}
	public String getZzrdw() {
		return zzrdw;
	}
	public void setZzrdw(String zzrdw) {
		this.zzrdw = zzrdw;
	}
	public String getZzrid() {
		return zzrid;
	}
	public void setZzrid(String zzrid) {
		this.zzrid = zzrid;
	}
	public String getZzr() {
		return zzr;
	}
	public void setZzr(String zzr) {
		this.zzr = zzr;
	}
	public String getYhr() {
		return yhr;
	}
	public void setYhr(String yhr) {
		this.yhr = yhr;
	}
	public String getHynr() {
		return hynr;
	}
	public void setHynr(String hynr) {
		this.hynr = hynr;
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
