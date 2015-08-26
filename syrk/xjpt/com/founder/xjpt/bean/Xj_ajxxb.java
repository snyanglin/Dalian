package com.founder.xjpt.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.base.entity.BaseEntity;

@DBInfoAnnotation(tableName = "XJ_AJXXB", pk = "id")
public class Xj_ajxxb extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String id;
	private String fqsj;
	private String jssj;
	private String zab;
	private String ajmc;
	private String sfkf;
	private String faxz;
	private String jyaq;
	private String ajbh;
	private String fasj;
	private String gxzrqdm;
	private String gxpcsdm;
	private String gxfxjdm;
	// 地图查询使用字段
	private String zbz;
	private String zbx;
	private String zby;
	
	public String getFasj() {
		return fasj;
	}
	public void setFasj(String fasj) {
		this.fasj = fasj;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
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
	
	public String getZab() {
		return zab;
	}
	public void setZab(String zab) {
		this.zab = zab;
	}
	public String getAjmc() {
		return ajmc;
	}
	public void setAjmc(String ajmc) {
		this.ajmc = ajmc;
	}
	public String getSfkf() {
		return sfkf;
	}
	public void setSfkf(String sfkf) {
		this.sfkf = sfkf;
	}
	
	public String getFaxz() {
		return faxz;
	}
	public void setFaxz(String faxz) {
		this.faxz = faxz;
	}
	public String getJyaq() {
		return jyaq;
	}
	public void setJyaq(String jyaq) {
		this.jyaq = jyaq;
	}
	public String getAjbh() {
		return ajbh;
	}
	public void setAjbh(String ajbh) {
		this.ajbh = ajbh;
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
	
	
	
	
}
