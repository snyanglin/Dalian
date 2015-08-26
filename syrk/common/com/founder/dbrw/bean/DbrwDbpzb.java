package com.founder.dbrw.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

@DBInfoAnnotation(tableName = "DBRW_DBPZB", pk = "id")
public class DbrwDbpzb extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@FieldDesc("督办配置表ID")
	private String id;
	@FieldDesc("督办模型编号")
	private String dbmxbh;
	@FieldDesc("督办模型名称")
	private String dbmxmc;
	@FieldDesc("督办数据间隔周期")
	private Long dbsjjgzq;
	@FieldDesc("督办数据项标题名")
	private String dbsjxbtm;
	@FieldDesc("督办数据项数量")
	private Long dbsjxsl;
	@FieldDesc("督办模型级别")
	private String dbmxjb;
	@FieldDesc("备注")
	private String bz;
	@FieldDesc("督办数据项标题比例")
	private String dbsjxbtbl;
	@FieldDesc("查看详细标题字段")
	private String ckxxbtzd;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDbmxbh() {
		return dbmxbh;
	}

	public void setDbmxbh(String dbmxbh) {
		this.dbmxbh = dbmxbh;
	}

	public String getDbmxmc() {
		return dbmxmc;
	}

	public void setDbmxmc(String dbmxmc) {
		this.dbmxmc = dbmxmc;
	}

	public Long getDbsjjgzq() {
		return dbsjjgzq;
	}

	public void setDbsjjgzq(Long dbsjjgzq) {
		this.dbsjjgzq = dbsjjgzq;
	}

	public String getDbsjxbtm() {
		return dbsjxbtm;
	}

	public void setDbsjxbtm(String dbsjxbtm) {
		this.dbsjxbtm = dbsjxbtm;
	}

	public Long getDbsjxsl() {
		return dbsjxsl;
	}

	public void setDbsjxsl(Long dbsjxsl) {
		this.dbsjxsl = dbsjxsl;
	}

	public String getDbmxjb() {
		return dbmxjb;
	}

	public void setDbmxjb(String dbmxjb) {
		this.dbmxjb = dbmxjb;
	}

	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

	public String getDbsjxbtbl() {
		return dbsjxbtbl;
	}

	public void setDbsjxbtbl(String dbsjxbtbl) {
		this.dbsjxbtbl = dbsjxbtbl;
	}

	public String getCkxxbtzd() {
		return ckxxbtzd;
	}

	public void setCkxxbtzd(String ckxxbtzd) {
		this.ckxxbtzd = ckxxbtzd;
	}

}
