package com.founder.sydw.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;
@DBInfoAnnotation(tableName = "DW_DWCFXXB", pk = "id")
public class Dwcfxxb extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@FieldDesc("ID")
	private String id;
	@FieldDesc("单位ID")
	private String dwid;
	@FieldDesc("案件编号")
	private String ajbh;
	@FieldDesc("行政处罚决定书字号")
	private String xzcfjdszh;
	@FieldDesc("处罚类型代码")
	private String cflxdm;
	@FieldDesc("处罚日期")
	private String cfrq;
	@FieldDesc("处罚日期-至")
	private String cfrqz;
	@FieldDesc("处罚情况")
	private String cfqk;
	@FieldDesc("经办单位ID")
	private String jbdwid;
	@FieldDesc("经办单位")
	private String jbdw;
	@FieldDesc("经办人ID")
	private String jbrid;
	@FieldDesc("经办人")
	private String jbr;
	@FieldDesc("备注")
	private String bz;
	@FieldDesc("处罚结果")
	private String cfjg;
	@FieldDesc("单位名称")
	private String dwmc;
	@FieldDesc("单位类型代码")
	private String dwlbdm;
	public String getCfjg() {
		return cfjg;
	}
	public void setCfjg(String cfjg) {
		this.cfjg = cfjg;
	}
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
	public String getAjbh() {
		return ajbh;
	}
	public void setAjbh(String ajbh) {
		this.ajbh = ajbh;
	}
	public String getXzcfjdszh() {
		return xzcfjdszh;
	}
	public void setXzcfjdszh(String xzcfjdszh) {
		this.xzcfjdszh = xzcfjdszh;
	}
	public String getCflxdm() {
		return cflxdm;
	}
	public void setCflxdm(String cflxdm) {
		this.cflxdm = cflxdm;
	}
	public String getCfrq() {
		return cfrq;
	}
	public void setCfrq(String cfrq) {
		this.cfrq = cfrq;
	}
	public String getCfqk() {
		return cfqk;
	}
	public void setCfqk(String cfqk) {
		this.cfqk = cfqk;
	}
	public String getJbdwid() {
		return jbdwid;
	}
	public void setJbdwid(String jbdwid) {
		this.jbdwid = jbdwid;
	}
	public String getJbdw() {
		return jbdw;
	}
	public void setJbdw(String jbdw) {
		this.jbdw = jbdw;
	}
	public String getJbrid() {
		return jbrid;
	}
	public void setJbrid(String jbrid) {
		this.jbrid = jbrid;
	}
	public String getJbr() {
		return jbr;
	}
	public void setJbr(String jbr) {
		this.jbr = jbr;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	public String getDwmc() {
		return dwmc;
	}
	public void setDwmc(String dwmc) {
		this.dwmc = dwmc;
	}
	public String getDwlbdm() {
		return dwlbdm;
	}
	public void setDwlbdm(String dwlbdm) {
		this.dwlbdm = dwlbdm;
	}
	public String getCfrqz() {
		return cfrqz;
	}
	public void setCfrqz(String cfrqz) {
		this.cfrqz = cfrqz;
	}
}
