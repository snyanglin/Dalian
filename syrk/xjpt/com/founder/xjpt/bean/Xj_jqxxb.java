package com.founder.xjpt.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.base.entity.BaseEntity;

@DBInfoAnnotation(tableName = "XJ_JQXXB", pk = "id")
public class Xj_jqxxb extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String id;
	private String jqbh;
	private String jjsj;
	private String cjfs;
	private String jqlb;
	private String jqfsdz;
	private String jyjq;
	private String fqsj;
	private String jssj;
	private String gxzrqdm;
	private String gxpcsdm;
	private String gxfxjdm;
	// 地图查询使用字段
	private String zbz;
	private String zbx;
	private String zby;
	
	
	
	public String getFqsj() {
		return fqsj;
	}
	public void setFqsj(String fqsj) {
		this.fqsj = fqsj;
	}
	public String getJssj() {
		return jssj;
	}
	public void setJssj(String jssj) {
		this.jssj = jssj;
	}
	public String getZbx() {
		return zbx;
	}
	public void setZbx(String zbx) {
		this.zbx = zbx;
	}
	public String getZby() {
		return zby;
	}
	public void setZby(String zby) {
		this.zby = zby;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getGxfxjdm() {
		return gxfxjdm;
	}
	public void setGxfxjdm(String gxfxjdm) {
		this.gxfxjdm = gxfxjdm;
	}
	
	public String getZbz() {
		return zbz;
	}
	public void setZbz(String zbz) {
		this.zbz = zbz;
	}
	public String getGxzrqdm() {
		return gxzrqdm;
	}
	public void setGxzrqdm(String gxzrqdm) {
		this.gxzrqdm = gxzrqdm;
	}
	public String getGxpcsdm() {
		return gxpcsdm;
	}
	public void setGxpcsdm(String gxpcsdm) {
		this.gxpcsdm = gxpcsdm;
	}
	public String getJqbh() {
		return jqbh;
	}
	public void setJqbh(String jqbh) {
		this.jqbh = jqbh;
	}
	public String getJjsj() {
		return jjsj;
	}
	public void setJjsj(String jjsj) {
		this.jjsj = jjsj;
	}
	public String getCjfs() {
		return cjfs;
	}
	public void setCjfs(String cjfs) {
		this.cjfs = cjfs;
	}
	public String getJqlb() {
		return jqlb;
	}
	public void setJqlb(String jqlb) {
		this.jqlb = jqlb;
	}
	public String getJqfsdz() {
		return jqfsdz;
	}
	public void setJqfsdz(String jqfsdz) {
		this.jqfsdz = jqfsdz;
	}
	public String getJyjq() {
		return jyjq;
	}
	public void setJyjq(String jyjq) {
		this.jyjq = jyjq;
	}
	
	

}
