package com.founder.zafffwqz.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

@DBInfoAnnotation(tableName = "ZAFF_GZJSDMTXXB", pk = "id")
public class Gzjsdmtxxb  extends BaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@FieldDesc("多媒体信息ID")
	private String id;
	@FieldDesc("工作纪实ID")
	private String gzjsid;
	@FieldDesc("工作纪实现场照片")
	private byte[] gzjsxczp;
	@FieldDesc("备注")
	private String bz;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getGzjsid() {
		return gzjsid;
	}
	public void setGzjsid(String gzjsid) {
		this.gzjsid = gzjsid;
	}
	public byte[] getGzjsxczp() {
		return gzjsxczp;
	}
	public void setGzjsxczp(byte[] gzjsxczp) {
		this.gzjsxczp = gzjsxczp;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	

}
