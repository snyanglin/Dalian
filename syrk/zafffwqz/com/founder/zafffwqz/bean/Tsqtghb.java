package com.founder.zafffwqz.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;
@DBInfoAnnotation(tableName = "FWQZ_TSQTGHB", pk = "id")
public class Tsqtghb extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@FieldDesc("特殊群体关怀表ID")
	private String id;
	@FieldDesc("特殊群体类型代码")
	private String tsqtlxdm;
	@FieldDesc("关怀时间")
	private String ghsj;
	@FieldDesc("关怀措施")
	private String ghcs;
	@FieldDesc("取得效果")
	private String qdxg;
	@FieldDesc("关怀人单位ID")
	private String ghrdwid;
	@FieldDesc("关怀人单位")
	private String ghrdw;
	@FieldDesc("关怀人ID")
	private String ghrid;
	@FieldDesc("关怀人")
	private String ghr;
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
	public String getTsqtlxdm() {
		return tsqtlxdm;
	}
	public void setTsqtlxdm(String tsqtlxdm) {
		this.tsqtlxdm = tsqtlxdm;
	}
	public String getGhsj() {
		return ghsj;
	}
	public void setGhsj(String ghsj) {
		this.ghsj = ghsj;
	}
	public String getGhcs() {
		return ghcs;
	}
	public void setGhcs(String ghcs) {
		this.ghcs = ghcs;
	}
	public String getQdxg() {
		return qdxg;
	}
	public void setQdxg(String qdxg) {
		this.qdxg = qdxg;
	}
	public String getGhrdwid() {
		return ghrdwid;
	}
	public void setGhrdwid(String ghrdwid) {
		this.ghrdwid = ghrdwid;
	}
	public String getGhrdw() {
		return ghrdw;
	}
	public void setGhrdw(String ghrdw) {
		this.ghrdw = ghrdw;
	}
	public String getGhrid() {
		return ghrid;
	}
	public void setGhrid(String ghrid) {
		this.ghrid = ghrid;
	}
	public String getGhr() {
		return ghr;
	}
	public void setGhr(String ghr) {
		this.ghr = ghr;
	}
	
	
}
