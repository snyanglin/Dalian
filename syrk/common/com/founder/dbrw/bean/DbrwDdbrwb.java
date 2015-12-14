package com.founder.dbrw.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

@DBInfoAnnotation(tableName = "DBRW_DDBRWB", pk = "id")
public class DbrwDdbrwb extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@FieldDesc("待督办任务ID")
	private String id;
	@FieldDesc("督办模型ID")
	private String dbmxid;
	@FieldDesc("待督办任务级别代码")
	private String dbrwjbdm;
	@FieldDesc("督办任务发起分县局代码")
	private String dbrwfqfxjdm;
	@FieldDesc("督办任务发起派出所代码")
	private String dbrwfqpcsdm;
	@FieldDesc("待督办任务生成时间")
	private String ddbrwscsj;
	@FieldDesc("任务标题")
	private String rwbt;
	@FieldDesc("任务数据总量")
	private Long rwsjzl;
	@FieldDesc("备注")
	private String bz;

	private String ywfl = "0"; // 业务分类，确定ddbsjx1是否为传入的条件
	private String ddbsjx1;
	private String ddbsjx2;
	private String ddbsjx3;
	private String ddbsjx4;
	private String ddbsjx5;
	private String ddbsjx6;
	private String ddbsjx7;
	private String ddbsjx8;
	private String ddbsjx9;
	private String dbzt;
	private String sszrqdm;

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

	public String getDdbrwscsj() {
		return ddbrwscsj;
	}

	public void setDdbrwscsj(String ddbrwscsj) {
		this.ddbrwscsj = ddbrwscsj;
	}

	public String getRwbt() {
		return rwbt;
	}

	public void setRwbt(String rwbt) {
		this.rwbt = rwbt;
	}

	public Long getRwsjzl() {
		return rwsjzl;
	}

	public void setRwsjzl(Long rwsjzl) {
		this.rwsjzl = rwsjzl;
	}

	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

	public String getYwfl() {
		return ywfl;
	}

	public void setYwfl(String ywfl) {
		this.ywfl = ywfl;
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

	public String getDbzt() {
		return dbzt;
	}

	public void setDbzt(String dbzt) {
		this.dbzt = dbzt;
	}

	public String getSszrqdm() {
		return sszrqdm;
	}

	public void setSszrqdm(String sszrqdm) {
		this.sszrqdm = sszrqdm;
	}

}
