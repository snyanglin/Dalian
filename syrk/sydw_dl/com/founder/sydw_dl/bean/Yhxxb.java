package com.founder.sydw_dl.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;
@DBInfoAnnotation(tableName = "DW_YHXXB", pk = "id")
public class Yhxxb extends  BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@FieldDesc("ID")
	private String id;
	@FieldDesc("单位ID")
	private String dwid;
	@FieldDesc("银行类别代码")
	private String yhlbdm;
	@FieldDesc("银行级别代码")
	private String yhjbdm;
	@FieldDesc("银行所有制")
	private String yhsyz;
	@FieldDesc("是否有金库代码")
	private String sfyjkdm;
	@FieldDesc("风险等级")
	private String fxdj;
	@FieldDesc("金库分类代码")
	private String jkfldm;
	@FieldDesc("枪支数量")
	private Long qzsl;
	@FieldDesc("安全防范合格证编号")
	private String aqffhgzbh;
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
	public String getYhlbdm() {
		return yhlbdm;
	}
	public void setYhlbdm(String yhlbdm) {
		this.yhlbdm = yhlbdm;
	}
	public String getYhjbdm() {
		return yhjbdm;
	}
	public void setYhjbdm(String yhjbdm) {
		this.yhjbdm = yhjbdm;
	}
	public String getYhsyz() {
		return yhsyz;
	}
	public void setYhsyz(String yhsyz) {
		this.yhsyz = yhsyz;
	}
	public String getSfyjkdm() {
		return sfyjkdm;
	}
	public void setSfyjkdm(String sfyjkdm) {
		this.sfyjkdm = sfyjkdm;
	}
	public Long getQzsl() {
		return qzsl;
	}
	public void setQzsl(Long qzsl) {
		this.qzsl = qzsl;
	}
	public String getAqffhgzbh() {
		return aqffhgzbh;
	}
	public void setAqffhgzbh(String aqffhgzbh) {
		this.aqffhgzbh = aqffhgzbh;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	public String getFxdj() {
		return fxdj;
	}
	public void setFxdj(String fxdj) {
		this.fxdj = fxdj;
	}
	public String getJkfldm() {
		return jkfldm;
	}
	public void setJkfldm(String jkfldm) {
		this.jkfldm = jkfldm;
	}
	
}
