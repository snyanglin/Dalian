package com.founder.sydw_dl.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

@DBInfoAnnotation(tableName = "DW_JDHXPZZXXB", pk = "id")
public class Jdhxpzzxxb extends BaseEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@FieldDesc("ID")
	private String id;
	@FieldDesc("单位ID")
	private String dwid;
	@FieldDesc("资质证件名称")
	private String zzzjmc;
	@FieldDesc("资质证件编号")
	private String zzzjbh;
	@FieldDesc("资质证件批准机关")
	private String zzzjpzjg;
	@FieldDesc("资质证件_签发日期")
	private String qfrq;
	@FieldDesc("资质证件_截止时间")
	private String jzrq;
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
	public String getZzzjmc() {
		return zzzjmc;
	}
	public void setZzzjmc(String zzzjmc) {
		this.zzzjmc = zzzjmc;
	}
	public String getZzzjbh() {
		return zzzjbh;
	}
	public void setZzzjbh(String zzzjbh) {
		this.zzzjbh = zzzjbh;
	}
	public String getZzzjpzjg() {
		return zzzjpzjg;
	}
	public void setZzzjpzjg(String zzzjpzjg) {
		this.zzzjpzjg = zzzjpzjg;
	}
	
	
	/**
	 * @return the qfrq
	 */
	public String getQfrq() {
		return qfrq;
	}
	/**
	 * @param qfrq the qfrq to set
	 */
	public void setQfrq(String qfrq) {
		this.qfrq = qfrq;
	}
	/**
	 * @return the jzrq
	 */
	public String getJzrq() {
		return jzrq;
	}
	/**
	 * @param jzrq the jzrq to set
	 */
	public void setJzrq(String jzrq) {
		this.jzrq = jzrq;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
}
