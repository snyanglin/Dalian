package com.founder.service.activitytrace.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

@DBInfoAnnotation(tableName = "RK_RYHDGJB", pk = "id")
public class RkRyhdgjb extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@FieldDesc("人员活动轨迹ID")
	private String id;
	@FieldDesc("人员ID")
	private String ryid;
	@FieldDesc("轨迹类型代码")
	private String gjlxdm;
	@FieldDesc("轨迹地点")
	private String gjdd;
	@FieldDesc("轨迹起始时间")
	private String gjkssj;
	@FieldDesc("轨迹结束时间")
	private String gjjssj;
	@FieldDesc("轨迹说明")
	private String gjsm;
	@FieldDesc("备注")
	private String bz;
	@FieldDesc("证件号码")
	private String zjhm;

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

	public String getGjlxdm() {
		return gjlxdm;
	}

	public void setGjlxdm(String gjlxdm) {
		this.gjlxdm = gjlxdm;
	}

	public String getGjdd() {
		return gjdd;
	}

	public void setGjdd(String gjdd) {
		this.gjdd = gjdd;
	}

	public String getGjkssj() {
		return gjkssj;
	}

	public void setGjkssj(String gjkssj) {
		this.gjkssj = gjkssj;
	}

	public String getGjjssj() {
		return gjjssj;
	}

	public void setGjjssj(String gjjssj) {
		this.gjjssj = gjjssj;
	}

	public String getGjsm() {
		return gjsm;
	}

	public void setGjsm(String gjsm) {
		this.gjsm = gjsm;
	}

	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

	public String getZjhm() {
		return zjhm;
	}

	public void setZjhm(String zjhm) {
		this.zjhm = zjhm;
	}

}
