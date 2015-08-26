package com.founder.xjpt.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.base.entity.BaseEntity;

@DBInfoAnnotation(tableName = "XJ_SJXXB", pk = "id")
public class Xj_sjxxb extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String id;
	private String fqsj;
	private String jssj;
	private String sjlx;
	private String sjbh;
	private String sjmc;
	private String cflx;
	private String cfr;
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
	public String getSjlx() {
		return sjlx;
	}
	public void setSjlx(String sjlx) {
		this.sjlx = sjlx;
	}
	public String getSjbh() {
		return sjbh;
	}
	public void setSjbh(String sjbh) {
		this.sjbh = sjbh;
	}
	public String getSjmc() {
		return sjmc;
	}
	public void setSjmc(String sjmc) {
		this.sjmc = sjmc;
	}
	public String getCflx() {
		return cflx;
	}
	public void setCflx(String cflx) {
		this.cflx = cflx;
	}
	public String getCfr() {
		return cfr;
	}
	public void setCfr(String cfr) {
		this.cfr = cfr;
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
