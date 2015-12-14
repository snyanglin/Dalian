package com.founder.dbrw.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

@DBInfoAnnotation(tableName = "DBRW_DBRWB", pk = "id")
public class DbrwDbrwb extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@FieldDesc("督办任务ID")
	private String id;
	@FieldDesc("督办模型ID")
	private String dbmxid;
	@FieldDesc("督办任务级别代码")
	private String dbrwjbdm;
	@FieldDesc("督办任务发起分县局代码")
	private String dbrwfqfxjdm;
	@FieldDesc("督办任务发起派出所代码")
	private String dbrwfqpcsdm;
	@FieldDesc("督办任务发起单位代码")
	private String dbrwfqdwdm;
	@FieldDesc("任务发起时间")
	private String rwfqsj;
	@FieldDesc("任务开始时间")
	private String rwkssj;
	@FieldDesc("任务结束时间")
	private String rwjssj;
	@FieldDesc("任务标题")
	private String rwbt;
	@FieldDesc("任务说明")
	private String rwsm;
	@FieldDesc("任务数据总量")
	private Long rwsjzl;
	@FieldDesc("任务完成情况")
	private String rwwcqk;
	@FieldDesc("任务状态")
	private String rwzt;
	@FieldDesc("完成时间")
	private String wcsj;
	@FieldDesc("备注")
	private String bz;

	private String sfwcdm;
	private String dbsjx1;
	private String dbsjx9;

	private String dbrwfqpcsmc;
	private String dbrwfqdwmc;

	/**
	 * @return the dbsjx1
	 */
	public String getDbsjx1() {
		return dbsjx1;
	}

	/**
	 * @param dbsjx1
	 *            the dbsjx1 to set
	 */
	public void setDbsjx1(String dbsjx1) {
		this.dbsjx1 = dbsjx1;
	}

	/**
	 * @return the dbsjx9
	 */
	public String getDbsjx9() {
		return dbsjx9;
	}

	/**
	 * @param dbsjx9
	 *            the dbsjx9 to set
	 */
	public void setDbsjx9(String dbsjx9) {
		this.dbsjx9 = dbsjx9;
	}

	public String getSfwcdm() {
		return sfwcdm;
	}

	public void setSfwcdm(String sfwcdm) {
		this.sfwcdm = sfwcdm;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDbmxid() {
		return dbmxid;
	}

	public void setDbmxid(String dbmxid) {
		this.dbmxid = dbmxid;
	}

	public String getDbrwjbdm() {
		return dbrwjbdm;
	}

	public void setDbrwjbdm(String dbrwjbdm) {
		this.dbrwjbdm = dbrwjbdm;
	}

	public String getDbrwfqfxjdm() {
		return dbrwfqfxjdm;
	}

	public void setDbrwfqfxjdm(String dbrwfqfxjdm) {
		this.dbrwfqfxjdm = dbrwfqfxjdm;
	}

	public String getDbrwfqpcsdm() {
		return dbrwfqpcsdm;
	}

	public void setDbrwfqpcsdm(String dbrwfqpcsdm) {
		this.dbrwfqpcsdm = dbrwfqpcsdm;
	}

	public String getDbrwfqdwdm() {
		return dbrwfqdwdm;
	}

	public void setDbrwfqdwdm(String dbrwfqdwdm) {
		this.dbrwfqdwdm = dbrwfqdwdm;
	}

	public String getRwfqsj() {
		return rwfqsj;
	}

	public void setRwfqsj(String rwfqsj) {
		this.rwfqsj = rwfqsj;
	}

	public String getRwkssj() {
		return rwkssj;
	}

	public void setRwkssj(String rwkssj) {
		this.rwkssj = rwkssj;
	}

	public String getRwjssj() {
		return rwjssj;
	}

	public void setRwjssj(String rwjssj) {
		this.rwjssj = rwjssj;
	}

	public String getRwbt() {
		return rwbt;
	}

	public void setRwbt(String rwbt) {
		this.rwbt = rwbt;
	}

	public String getRwsm() {
		return rwsm;
	}

	public void setRwsm(String rwsm) {
		this.rwsm = rwsm;
	}

	public Long getRwsjzl() {
		return rwsjzl;
	}

	public void setRwsjzl(Long rwsjzl) {
		this.rwsjzl = rwsjzl;
	}

	public String getRwwcqk() {
		return rwwcqk;
	}

	public void setRwwcqk(String rwwcqk) {
		this.rwwcqk = rwwcqk;
	}

	public String getRwzt() {
		return rwzt;
	}

	public void setRwzt(String rwzt) {
		this.rwzt = rwzt;
	}

	public String getWcsj() {
		return wcsj;
	}

	public void setWcsj(String wcsj) {
		this.wcsj = wcsj;
	}

	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

	public String getDbrwfqpcsmc() {
		return dbrwfqpcsmc;
	}

	public void setDbrwfqpcsmc(String dbrwfqpcsmc) {
		this.dbrwfqpcsmc = dbrwfqpcsmc;
	}

	public String getDbrwfqdwmc() {
		return dbrwfqdwmc;
	}

	public void setDbrwfqdwmc(String dbrwfqdwmc) {
		this.dbrwfqdwmc = dbrwfqdwmc;
	}

}
