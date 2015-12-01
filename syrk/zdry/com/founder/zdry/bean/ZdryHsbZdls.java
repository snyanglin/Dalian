package com.founder.zdry.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

/***
 * ****************************************************************************
 * 
 * @Package: [com.founder.zdry.bean.ZdryHsbZdls.java]
 * @ClassName: [ZdryHsbZdls]
 * @Description: []
 * @Author: [wu_chunhui@founder.com.cn]
 * @CreateDate: [2015-3-17 下午7:01:55]
 * @UpdateUser: [Administrator(如多次修改保留历史记录，增加修改记录)]
 * @UpdateDate: [2015-3-17 下午7:01:55，(如多次修改保留历史记录，增加修改记录)]
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]
 * @Version: [v1.0]
 */
@DBInfoAnnotation(tableName = "ZDRY_ZDRYHSB_ZDLS", pk = "id")
public class ZdryHsbZdls extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@FieldDesc("主键")
	private String id;
	@FieldDesc("重点人员核实ID")
	private String hsid;
	@FieldDesc("原所属派出所")
	private String ysspcs;
	@FieldDesc("原地址-居住地址省市县代码")
	private String ydz_jzdzssxdm;
	@FieldDesc("原地址-居住地址门楼牌代码")
	private String ydz_jzdzmlpdm;
	@FieldDesc("原地址-居住地址门楼牌详址")
	private String ydz_jzdzmlpxz;
	@FieldDesc("原地址-居住地址代码")
	private String ydz_jzdzdm;
	@FieldDesc("原地址-居住地址详址")
	private String ydz_jzdzxz;
	@FieldDesc("所属派出所")
	private String sspcs;
	@FieldDesc("地址-居住地址省市县代码")
	private String dz_jzdzssxdm;
	@FieldDesc("地址-居住地址门楼牌代码")
	private String dz_jzdzmlpdm;
	@FieldDesc("地址-居住地址门楼牌详址")
	private String dz_jzdzmlpxz;
	@FieldDesc("地址-居住地址代码")
	private String dz_jzdzdm;
	@FieldDesc("地址-居住地址详址")
	private String dz_jzdzxz;

	private String sszrq;

	private String xm;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getHsid() {
		return hsid;
	}

	public void setHsid(String hsid) {
		this.hsid = hsid;
	}

	public String getYsspcs() {
		return ysspcs;
	}

	public void setYsspcs(String ysspcs) {
		this.ysspcs = ysspcs;
	}

	public String getYdz_jzdzssxdm() {
		return ydz_jzdzssxdm;
	}

	public void setYdz_jzdzssxdm(String ydz_jzdzssxdm) {
		this.ydz_jzdzssxdm = ydz_jzdzssxdm;
	}

	public String getYdz_jzdzmlpdm() {
		return ydz_jzdzmlpdm;
	}

	public void setYdz_jzdzmlpdm(String ydz_jzdzmlpdm) {
		this.ydz_jzdzmlpdm = ydz_jzdzmlpdm;
	}

	public String getYdz_jzdzmlpxz() {
		return ydz_jzdzmlpxz;
	}

	public void setYdz_jzdzmlpxz(String ydz_jzdzmlpxz) {
		this.ydz_jzdzmlpxz = ydz_jzdzmlpxz;
	}

	public String getYdz_jzdzdm() {
		return ydz_jzdzdm;
	}

	public void setYdz_jzdzdm(String ydz_jzdzdm) {
		this.ydz_jzdzdm = ydz_jzdzdm;
	}

	public String getYdz_jzdzxz() {
		return ydz_jzdzxz;
	}

	public void setYdz_jzdzxz(String ydz_jzdzxz) {
		this.ydz_jzdzxz = ydz_jzdzxz;
	}

	public String getSspcs() {
		return sspcs;
	}

	public void setSspcs(String sspcs) {
		this.sspcs = sspcs;
	}

	public String getDz_jzdzssxdm() {
		return dz_jzdzssxdm;
	}

	public void setDz_jzdzssxdm(String dz_jzdzssxdm) {
		this.dz_jzdzssxdm = dz_jzdzssxdm;
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

	public String getDz_jzdzdm() {
		return dz_jzdzdm;
	}

	public void setDz_jzdzdm(String dz_jzdzdm) {
		this.dz_jzdzdm = dz_jzdzdm;
	}

	public String getDz_jzdzxz() {
		return dz_jzdzxz;
	}

	public void setDz_jzdzxz(String dz_jzdzxz) {
		this.dz_jzdzxz = dz_jzdzxz;
	}

	public String getSszrq() {
		return sszrq;
	}

	public String getXm() {
		return xm;
	}

	public void setXm(String xm) {
		this.xm = xm;
	}

	public void setSszrq(String sszrq) {
		this.sszrq = sszrq;
	}

}
