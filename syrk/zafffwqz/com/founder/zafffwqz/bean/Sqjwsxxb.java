package com.founder.zafffwqz.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

@DBInfoAnnotation(tableName = "ZAFF_SQJWSXXB", pk = "id")
public class Sqjwsxxb extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@FieldDesc("社区警务室信息ID")
	private String id;
	@FieldDesc("警务室名称")
	private String jwsmc;
	@FieldDesc("警务室类别")
	private String jwslb;
	@FieldDesc("警务室电话")
	private String jwsdh;
	@FieldDesc("警务室面积")
	private Float jwsmj;
	@FieldDesc("是否独立代码")
	private String sfdldm;
	@FieldDesc("民警人数")
	private Long mjrs;
	@FieldDesc("办公用品配置")
	private String bgyppz;
	@FieldDesc("计算机台数")
	private Long jsjts;
	@FieldDesc("连接公安网台数")
	private Long ljgawts;
	@FieldDesc("备注")
	private String bz;
	
	
	@FieldDesc("警务室地址代码")
	private String dz_jwsdzdm;
	@FieldDesc("警务室地址省市县代码")
	private String dz_jwsdzssxdm;
	@FieldDesc("警务室地址详址")
	private String dz_jwsdzxz;	
	@FieldDesc("警务室地址门楼牌代码")
	private String dz_jwsdzmlpdm;
	@FieldDesc("警务室地址门楼牌详址")
	private String dz_jwsdzmlpxz;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getJwsmc() {
		return jwsmc;
	}
	public void setJwsmc(String jwsmc) {
		this.jwsmc = jwsmc;
	}
	public String getJwslb() {
		return jwslb;
	}
	public void setJwslb(String jwslb) {
		this.jwslb = jwslb;
	}
	public String getJwsdh() {
		return jwsdh;
	}
	public void setJwsdh(String jwsdh) {
		this.jwsdh = jwsdh;
	}
	public Float getJwsmj() {
		return jwsmj;
	}
	public void setJwsmj(Float jwsmj) {
		this.jwsmj = jwsmj;
	}
	public String getSfdldm() {
		return sfdldm;
	}
	public void setSfdldm(String sfdldm) {
		this.sfdldm = sfdldm;
	}
	public Long getMjrs() {
		return mjrs;
	}
	public void setMjrs(Long mjrs) {
		this.mjrs = mjrs;
	}
	public String getBgyppz() {
		return bgyppz;
	}
	public void setBgyppz(String bgyppz) {
		this.bgyppz = bgyppz;
	}
	public Long getJsjts() {
		return jsjts;
	}
	public void setJsjts(Long jsjts) {
		this.jsjts = jsjts;
	}
	public Long getLjgawts() {
		return ljgawts;
	}
	public void setLjgawts(Long ljgawts) {
		this.ljgawts = ljgawts;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	public String getDz_jwsdzdm() {
		return dz_jwsdzdm;
	}
	public void setDz_jwsdzdm(String dz_jwsdzdm) {
		this.dz_jwsdzdm = dz_jwsdzdm;
	}
	public String getDz_jwsdzssxdm() {
		return dz_jwsdzssxdm;
	}
	public void setDz_jwsdzssxdm(String dz_jwsdzssxdm) {
		this.dz_jwsdzssxdm = dz_jwsdzssxdm;
	}
	public String getDz_jwsdzxz() {
		return dz_jwsdzxz;
	}
	public void setDz_jwsdzxz(String dz_jwsdzxz) {
		this.dz_jwsdzxz = dz_jwsdzxz;
	}
	public String getDz_jwsdzmlpdm() {
		return dz_jwsdzmlpdm;
	}
	public void setDz_jwsdzmlpdm(String dz_jwsdzmlpdm) {
		this.dz_jwsdzmlpdm = dz_jwsdzmlpdm;
	}
	public String getDz_jwsdzmlpxz() {
		return dz_jwsdzmlpxz;
	}
	public void setDz_jwsdzmlpxz(String dz_jwsdzmlpxz) {
		this.dz_jwsdzmlpxz = dz_jwsdzmlpxz;
	}
	
	
}
