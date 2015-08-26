package com.founder.service.attachment.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

@DBInfoAnnotation(tableName = "ZPFJ_PTRYZPGLB", pk = "id")
public class ZpfjPtryzpglb extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	@FieldDesc("主键")
	private String id;
	@FieldDesc("人员ID")
	private String ryid;
	@FieldDesc("照片ID")
	private String zpid;
	@FieldDesc("来源描述")
	private String lyms;
	@FieldDesc("来源ID")
	private String lyid;
	@FieldDesc("来源表名")
	private String lybm;
	@FieldDesc("备注")
	private String bz;
	private String zjhm;
	private String cyzjdm;
	private String uploadFile;
	public String getCyzjdm() {
		return cyzjdm;
	}

	public void setCyzjdm(String cyzjdm) {
		this.cyzjdm = cyzjdm;
	}

	public String getZjhm() {
		return zjhm;
	}

	public void setZjhm(String zjhm) {
		this.zjhm = zjhm;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRyid() {
		return ryid;
	}

	public void setRyid(String ryid) {
		this.ryid = ryid;
	}

	public String getZpid() {
		return zpid;
	}

	public void setZpid(String zpid) {
		this.zpid = zpid;
	}

	public String getLyms() {
		return lyms;
	}

	public void setLyms(String lyms) {
		this.lyms = lyms;
	}

	public String getLyid() {
		return lyid;
	}

	public void setLyid(String lyid) {
		this.lyid = lyid;
	}

	public String getLybm() {
		return lybm;
	}

	public void setLybm(String lybm) {
		this.lybm = lybm;
	}

	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

	public String getUploadFile() {
		return uploadFile;
	}

	public void setUploadFile(String uploadFile) {
		this.uploadFile = uploadFile;
	}

}