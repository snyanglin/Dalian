package com.founder.zafffwqz.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;
@DBInfoAnnotation(tableName = "FWQZ_QSGXZM_QSGXRZB", pk = "id")
public class Qsgxrzb extends BaseEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@FieldDesc("亲属关系证明-亲属关系人子表ID")private String id;
	@FieldDesc("亲属关系证明ID")private String qsgxid;
	@FieldDesc("与本人关系代码")private String ybrgxdm;
	@FieldDesc("人员ID")private String ryid;
	@FieldDesc("公民身份号码")private String gmsfhm;
	@FieldDesc("姓名")private String xm;
	@FieldDesc("出生日期")private String csrq;
	@FieldDesc("地址-居住地址代码")private String dz_jzdzdm;
	@FieldDesc("地址-居住地址省市县代码")private String dz_jzdzssxdm;
	@FieldDesc("地址-居住地址详址")private String dz_jzdzxz;
	@FieldDesc("备注")private String bz;
	@FieldDesc("地址-居住地址门楼牌代码")private String dz_jzdzmlpdm;
	@FieldDesc("地址-居住地址门楼牌详址")private String dz_jzdzmlpxz;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getQsgxid() {
		return qsgxid;
	}
	public void setQsgxid(String qsgxid) {
		this.qsgxid = qsgxid;
	}
	public String getYbrgxdm() {
		return ybrgxdm;
	}
	public void setYbrgxdm(String ybrgxdm) {
		this.ybrgxdm = ybrgxdm;
	}
	public String getRyid() {
		return ryid;
	}
	public void setRyid(String ryid) {
		this.ryid = ryid;
	}
	public String getGmsfhm() {
		return gmsfhm;
	}
	public void setGmsfhm(String gmsfhm) {
		this.gmsfhm = gmsfhm;
	}
	public String getXm() {
		return xm;
	}
	public void setXm(String xm) {
		this.xm = xm;
	}
	public String getCsrq() {
		return csrq;
	}
	public void setCsrq(String csrq) {
		this.csrq = csrq;
	}
	public String getDz_jzdzdm() {
		return dz_jzdzdm;
	}
	public void setDz_jzdzdm(String dz_jzdzdm) {
		this.dz_jzdzdm = dz_jzdzdm;
	}
	public String getDz_jzdzssxdm() {
		return dz_jzdzssxdm;
	}
	public void setDz_jzdzssxdm(String dz_jzdzssxdm) {
		this.dz_jzdzssxdm = dz_jzdzssxdm;
	}
	public String getDz_jzdzxz() {
		return dz_jzdzxz;
	}
	public void setDz_jzdzxz(String dz_jzdzxz) {
		this.dz_jzdzxz = dz_jzdzxz;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	public String getDz_jzdzmlpdm() {
		return dz_jzdzmlpdm;
	}
	public void setDz_jzdzmlpdm(String dz_jzdzmlpdm) {
		this.dz_jzdzmlpdm = dz_jzdzmlpdm;
	}
	public String getDz_jzdzmlpxz() {
		return dz_jzdzmlpxz;
	}
	public void setDz_jzdzmlpxz(String dz_jzdzmlpxz) {
		this.dz_jzdzmlpxz = dz_jzdzmlpxz;
	}
}
