package com.founder.dbrw.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

@DBInfoAnnotation(tableName = "DBRW_DDBRWSJMXB", pk = "id")
public class DbrwDdbrwsjmxb extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@FieldDesc("待督办任务数据明细ID")
	private String id;
	@FieldDesc("待督办任务ID")
	private String ddbrwid;
	@FieldDesc("待督办数据ID")
	private String ddbsjid;
	@FieldDesc("待督办数据项1")
	private String ddbsjx1;
	@FieldDesc("待督办数据项2")
	private String ddbsjx2;
	@FieldDesc("待督办数据项3")
	private String ddbsjx3;
	@FieldDesc("待督办数据项4")
	private String ddbsjx4;
	@FieldDesc("待督办数据项5")
	private String ddbsjx5;
	@FieldDesc("待督办数据项6")
	private String ddbsjx6;
	@FieldDesc("待督办数据项7")
	private String ddbsjx7;
	@FieldDesc("待督办数据项8")
	private String ddbsjx8;
	@FieldDesc("待督办数据项9")
	private String ddbsjx9;
	@FieldDesc("待督办数据项10")
	private String ddbsjx10;
	@FieldDesc("所属责任区代码")
	private String sszrqdm;
	@FieldDesc("所属派出所代码")
	private String sspcsdm;
	@FieldDesc("所属分县局代码")
	private String ssfxjdm;
	@FieldDesc("备注")
	private String bz;
	@FieldDesc("数据ＵＲＬ")
	private String dataurl;
	
	private String sszrqmc;
	private String dbfknr;

	public String getDbfknr() {
		return dbfknr;
	}

	public void setDbfknr(String dbfknr) {
		this.dbfknr = dbfknr;
	}

	public String getSszrqmc() {
		return sszrqmc;
	}

	public void setSszrqmc(String sszrqmc) {
		this.sszrqmc = sszrqmc;
	}

	public String getDataurl() {
		return dataurl;
	}

	public void setDataurl(String dataurl) {
		this.dataurl = dataurl;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDdbrwid() {
		return ddbrwid;
	}

	public void setDdbrwid(String ddbrwid) {
		this.ddbrwid = ddbrwid;
	}

	public String getDdbsjid() {
		return ddbsjid;
	}

	public void setDdbsjid(String ddbsjid) {
		this.ddbsjid = ddbsjid;
	}

	public String getDdbsjx1() {
		return ddbsjx1;
	}

	public void setDdbsjx1(String ddbsjx1) {
		this.ddbsjx1 = ddbsjx1;
	}

	public String getDdbsjx2() {
		return ddbsjx2;
	}

	public void setDdbsjx2(String ddbsjx2) {
		this.ddbsjx2 = ddbsjx2;
	}

	public String getDdbsjx3() {
		return ddbsjx3;
	}

	public void setDdbsjx3(String ddbsjx3) {
		this.ddbsjx3 = ddbsjx3;
	}

	public String getDdbsjx4() {
		return ddbsjx4;
	}

	public void setDdbsjx4(String ddbsjx4) {
		this.ddbsjx4 = ddbsjx4;
	}

	public String getDdbsjx5() {
		return ddbsjx5;
	}

	public void setDdbsjx5(String ddbsjx5) {
		this.ddbsjx5 = ddbsjx5;
	}

	public String getDdbsjx6() {
		return ddbsjx6;
	}

	public void setDdbsjx6(String ddbsjx6) {
		this.ddbsjx6 = ddbsjx6;
	}

	public String getDdbsjx7() {
		return ddbsjx7;
	}

	public void setDdbsjx7(String ddbsjx7) {
		this.ddbsjx7 = ddbsjx7;
	}

	public String getDdbsjx8() {
		return ddbsjx8;
	}

	public void setDdbsjx8(String ddbsjx8) {
		this.ddbsjx8 = ddbsjx8;
	}

	public String getDdbsjx9() {
		return ddbsjx9;
	}

	public void setDdbsjx9(String ddbsjx9) {
		this.ddbsjx9 = ddbsjx9;
	}

	public String getDdbsjx10() {
		return ddbsjx10;
	}

	public void setDdbsjx10(String ddbsjx10) {
		this.ddbsjx10 = ddbsjx10;
	}

	public String getSszrqdm() {
		return sszrqdm;
	}

	public void setSszrqdm(String sszrqdm) {
		this.sszrqdm = sszrqdm;
	}

	public String getSspcsdm() {
		return sspcsdm;
	}

	public void setSspcsdm(String sspcsdm) {
		this.sspcsdm = sspcsdm;
	}

	public String getSsfxjdm() {
		return ssfxjdm;
	}

	public void setSsfxjdm(String ssfxjdm) {
		this.ssfxjdm = ssfxjdm;
	}

	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

}
