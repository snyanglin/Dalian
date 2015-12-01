package com.founder.sydw_dl.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

@DBInfoAnnotation(tableName = "DW_YYSSXXB", pk = "id")
public class Yyssxxb extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@FieldDesc("ID")
	private String id;
	@FieldDesc("单位ID")
	private String dwid;
	@FieldDesc("设备名称")
	private String sbmc;
	@FieldDesc("设备用途")
	private String sbyt;
	@FieldDesc("数量")
	private Long sbsl;
	@FieldDesc("购买时间")
	private String sbgm_rq;
	@FieldDesc("状态")
	private String sbzt;
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

	public String getSbmc() {
		return sbmc;
	}

	public void setSbmc(String sbmc) {
		this.sbmc = sbmc;
	}

	public String getSbyt() {
		return sbyt;
	}

	public void setSbyt(String sbyt) {
		this.sbyt = sbyt;
	}

	

	public Long getSbsl() {
		return sbsl;
	}

	public void setSbsl(Long sbsl) {
		this.sbsl = sbsl;
	}

	public String getSbgm_rq() {
		return sbgm_rq;
	}

	public void setSbgm_rq(String sbgm_rq) {
		this.sbgm_rq = sbgm_rq;
	}

	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

	public String getSbzt() {
		return sbzt;
	}

	public void setSbzt(String sbzt) {
		this.sbzt = sbzt;
	}
    
	
	
}
