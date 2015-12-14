package com.founder.dbrw.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

@DBInfoAnnotation(tableName = "DBRW_DBRWSJMXB", pk = "id")
public class DbrwDbrwsjmxb extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@FieldDesc("督办任务数据明细ID")
	private String id;
	@FieldDesc("督办任务ID")
	private String dbrwid;
	@FieldDesc("督办数据ID")
	private String dbsjid;
	@FieldDesc("督办数据项1")
	private String dbsjx1;
	@FieldDesc("督办数据项2")
	private String dbsjx2;
	@FieldDesc("督办数据项3")
	private String dbsjx3;
	@FieldDesc("督办数据项4")
	private String dbsjx4;
	@FieldDesc("督办数据项5")
	private String dbsjx5;
	@FieldDesc("督办数据项6")
	private String dbsjx6;
	@FieldDesc("督办数据项7")
	private String dbsjx7;
	@FieldDesc("督办数据项8")
	private String dbsjx8;
	@FieldDesc("督办数据项9")
	private String dbsjx9;
	@FieldDesc("督办数据项10")
	private String dbsjx10;
	@FieldDesc("所属责任区代码")
	private String sszrqdm;
	@FieldDesc("所属派出所代码")
	private String sspcsdm;
	@FieldDesc("所属分县局代码")
	private String ssfxjdm;
	@FieldDesc("数据处理时间")
	private String sjclsj;
	@FieldDesc("数据处理人")
	private String sjclr;
	@FieldDesc("数据处理人ID")
	private String sjclrid;
	@FieldDesc("督办反馈类型代码")
	private String dbfklxdm;
	@FieldDesc("督办反馈内容")
	private String dbfknr;
	@FieldDesc("是否完成代码")
	private String sfwcdm;
	@FieldDesc("提交时间")
	private String tjsj;
	@FieldDesc("备注")
	private String bz;
	@FieldDesc("督办反馈内容1")
	private String dbfknr1;
	@FieldDesc("数据ＵＲＬ")
	private String dataurl;
	@FieldDesc("新增业务数据量")
	private Long xzywsjl;
	@FieldDesc("注销业务数据量")
	private Long zxywsjl;
	
	private String sszrqmc;

	public String getSszrqmc() {
		return sszrqmc;
	}

	public void setSszrqmc(String sszrqmc) {
		this.sszrqmc = sszrqmc;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDbfknr1() {
		return dbfknr1;
	}

	public void setDbfknr1(String dbfknr1) {
		this.dbfknr1 = dbfknr1;
	}

	public String getDataurl() {
		return dataurl;
	}

	public void setDataurl(String dataurl) {
		this.dataurl = dataurl;
	}

	public Long getXzywsjl() {
		return xzywsjl;
	}

	public void setXzywsjl(Long xzywsjl) {
		this.xzywsjl = xzywsjl;
	}

	public Long getZxywsjl() {
		return zxywsjl;
	}

	public void setZxywsjl(Long zxywsjl) {
		this.zxywsjl = zxywsjl;
	}

	public String getDbrwid() {
		return dbrwid;
	}

	public void setDbrwid(String dbrwid) {
		this.dbrwid = dbrwid;
	}

	public String getDbsjid() {
		return dbsjid;
	}

	public void setDbsjid(String dbsjid) {
		this.dbsjid = dbsjid;
	}

	public String getDbsjx1() {
		return dbsjx1;
	}

	public void setDbsjx1(String dbsjx1) {
		this.dbsjx1 = dbsjx1;
	}

	public String getDbsjx2() {
		return dbsjx2;
	}

	public void setDbsjx2(String dbsjx2) {
		this.dbsjx2 = dbsjx2;
	}

	public String getDbsjx3() {
		return dbsjx3;
	}

	public void setDbsjx3(String dbsjx3) {
		this.dbsjx3 = dbsjx3;
	}

	public String getDbsjx4() {
		return dbsjx4;
	}

	public void setDbsjx4(String dbsjx4) {
		this.dbsjx4 = dbsjx4;
	}

	public String getDbsjx5() {
		return dbsjx5;
	}

	public void setDbsjx5(String dbsjx5) {
		this.dbsjx5 = dbsjx5;
	}

	public String getDbsjx6() {
		return dbsjx6;
	}

	public void setDbsjx6(String dbsjx6) {
		this.dbsjx6 = dbsjx6;
	}

	public String getDbsjx7() {
		return dbsjx7;
	}

	public void setDbsjx7(String dbsjx7) {
		this.dbsjx7 = dbsjx7;
	}

	public String getDbsjx8() {
		return dbsjx8;
	}

	public void setDbsjx8(String dbsjx8) {
		this.dbsjx8 = dbsjx8;
	}

	public String getDbsjx9() {
		return dbsjx9;
	}

	public void setDbsjx9(String dbsjx9) {
		this.dbsjx9 = dbsjx9;
	}

	public String getDbsjx10() {
		return dbsjx10;
	}

	public void setDbsjx10(String dbsjx10) {
		this.dbsjx10 = dbsjx10;
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

	public String getSjclsj() {
		return sjclsj;
	}

	public void setSjclsj(String sjclsj) {
		this.sjclsj = sjclsj;
	}

	public String getSjclr() {
		return sjclr;
	}

	public void setSjclr(String sjclr) {
		this.sjclr = sjclr;
	}

	public String getSjclrid() {
		return sjclrid;
	}

	public void setSjclrid(String sjclrid) {
		this.sjclrid = sjclrid;
	}

	public String getDbfklxdm() {
		return dbfklxdm;
	}

	public void setDbfklxdm(String dbfklxdm) {
		this.dbfklxdm = dbfklxdm;
	}

	public String getDbfknr() {
		return dbfknr;
	}

	public void setDbfknr(String dbfknr) {
		this.dbfknr = dbfknr;
	}

	public String getSfwcdm() {
		return sfwcdm;
	}

	public void setSfwcdm(String sfwcdm) {
		this.sfwcdm = sfwcdm;
	}

	public String getTjsj() {
		return tjsj;
	}

	public void setTjsj(String tjsj) {
		this.tjsj = tjsj;
	}

	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

}
