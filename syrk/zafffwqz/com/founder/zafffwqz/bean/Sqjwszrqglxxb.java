package com.founder.zafffwqz.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

@DBInfoAnnotation(tableName = "ZAFF_SQJWSZRQGLXXB", pk = "id")
public class Sqjwszrqglxxb extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@FieldDesc("关联id")
	private String id;
	@FieldDesc("社区警务室ID")
	private String sqjwsid;
	@FieldDesc("责任区代码")
	private String zrqdm;
	@FieldDesc("备注")
	private String bz;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSqjwsid() {
		return sqjwsid;
	}
	public void setSqjwsid(String sqjwsid) {
		this.sqjwsid = sqjwsid;
	}
	public String getZrqdm() {
		return zrqdm;
	}
	public void setZrqdm(String zrqdm) {
		this.zrqdm = zrqdm;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}

}
