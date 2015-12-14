package com.founder.service.attachment.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

@DBInfoAnnotation(tableName = "ZPFJ_PTRYZPXXB", pk = "id")
public class ZpfjPtryzpxxb extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@FieldDesc("照片ID")
	private String id;
	@FieldDesc("照片")
	private byte[] zp;
	@FieldDesc("照片缩略图")
	private byte[] zpslt;
	@FieldDesc("备注")
	private String bz;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public byte[] getZp() {
		return zp;
	}

	public void setZp(byte[] zp) {
		this.zp = zp;
	}

	public byte[] getZpslt() {
		return zpslt;
	}

	public void setZpslt(byte[] zpslt) {
		this.zpslt = zpslt;
	}

	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

}
