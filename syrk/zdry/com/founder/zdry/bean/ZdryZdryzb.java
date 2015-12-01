package com.founder.zdry.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;

/***
 * ****************************************************************************
 * 
 * @Package: [com.founder.zdry.bean.Zdyzb.java]
 * @ClassName: [Zdyzb]
 * @Description: [一句话描述该类的功能]
 * @Author: [wu_chunhui@founder.com.cn]
 * @CreateDate: [2015-3-11 下午5:39:52]
 * @UpdateUser: [Administrator(如多次修改保留历史记录，增加修改记录)]
 * @UpdateDate: [2015-3-11 下午5:39:52，(如多次修改保留历史记录，增加修改记录)]
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]
 * @Version: [v1.0]
 */
@DBInfoAnnotation(tableName = "ZDRY_ZDRYZB", pk = "id")
public class ZdryZdryzb extends QueryBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	@FieldDesc("重点人员ID")
	private String id;
	@FieldDesc("人员ID")
	private String ryid;
	@FieldDesc("实有人口总表ID")
	private String syrkid;
	@FieldDesc("证件种类")
	private String cyzjdm;
	@FieldDesc("证件号码")
	private String zjhm;
	@FieldDesc("姓名")
	private String xm;
	@FieldDesc("性别代码")
	private String xbdm;
	@FieldDesc("民族代码")
	private String mzdm;
	@FieldDesc("出生日期")
	private String csrq;
	@FieldDesc("联系电话")
	private String lxdh;
	@FieldDesc("地址-户籍地址省市县代码")
	private String dz_hjdzssxdm;
	@FieldDesc("地址-户籍地址门楼牌代码")
	private String dz_hjdzmlpdm;
	@FieldDesc("地址-户籍地址门楼牌详址")
	private String dz_hjdzmlpxz;
	@FieldDesc("地址-户籍地址代码")
	private String dz_hjdzdm;
	@FieldDesc("地址-户籍地址详址")
	private String dz_hjdzxz;
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
	@FieldDesc("重点人员管理类型代码")
	private String zdrygllxdm;
	@FieldDesc("管理状态")
	private String glzt;
	@FieldDesc("指定列管部门ID")
	private String zdlgbmid;
	@FieldDesc("指定列管部门名称")
	private String zdlgbmmc;
	@FieldDesc("是否加密")
	private String sfjm;
	@FieldDesc("是否在控代码")
	private String sfzkdm;
	@FieldDesc("所属分县局代码")
	private String ssfxjdm;
	@FieldDesc("所属派出所代码")
	private String sspcsdm;
	@FieldDesc("所属责任区代码")
	private String sszrqdm;
	@FieldDesc("主要问题及现实表现")
	private String zywtjxsbx;	
	@FieldDesc("籍贯省市县（区）代码")
	private String jgssxdm;
	@FieldDesc("户籍地所属县级公安机关代码")
	private String hjd_ssxjgajgdm;
	@FieldDesc("户籍地所属派出所代码")
	private String hjd_sspcsdm;
	@FieldDesc("户籍地所属社区")
	private String hjd_sssq;
	@FieldDesc("居住地所在地市代码")
	private String jzd_szdsdm;
	
	

	
	public String getJgssxdm() {
		return jgssxdm;
	}

	public void setJgssxdm(String jgssxdm) {
		this.jgssxdm = jgssxdm;
	}

	public String getHjd_ssxjgajgdm() {
		return hjd_ssxjgajgdm;
	}

	public void setHjd_ssxjgajgdm(String hjd_ssxjgajgdm) {
		this.hjd_ssxjgajgdm = hjd_ssxjgajgdm;
	}

	public String getHjd_sspcsdm() {
		return hjd_sspcsdm;
	}

	public void setHjd_sspcsdm(String hjd_sspcsdm) {
		this.hjd_sspcsdm = hjd_sspcsdm;
	}

	public String getHjd_sssq() {
		return hjd_sssq;
	}

	public void setHjd_sssq(String hjd_sssq) {
		this.hjd_sssq = hjd_sssq;
	}

	public String getJzd_szdsdm() {
		return jzd_szdsdm;
	}

	public void setJzd_szdsdm(String jzd_szdsdm) {
		this.jzd_szdsdm = jzd_szdsdm;
	}

	public String getZywtjxsbx() {
		return zywtjxsbx;
	}

	public void setZywtjxsbx(String zywtjxsbx) {
		this.zywtjxsbx = zywtjxsbx;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRyid() {
		return ryid;
	}

	public void setRyid(String ryid) {
		this.ryid = ryid;
	}

	public String getSyrkid() {
		return syrkid;
	}

	public void setSyrkid(String syrkid) {
		this.syrkid = syrkid;
	}

	public String getCyzjdm() {
		return cyzjdm;
	}

	public void setCyzjdm(String cyzjdm) {
		this.cyzjdm = cyzjdm;
	}

	public String getZjhm() {
		return zjhm;
	}

	public void setZjhm(String zjhm) {
		this.zjhm = zjhm;
	}

	public String getXm() {
		return xm;
	}

	public void setXm(String xm) {
		this.xm = xm;
	}

	public String getXbdm() {
		return xbdm;
	}

	public void setXbdm(String xbdm) {
		this.xbdm = xbdm;
	}

	public String getMzdm() {
		return mzdm;
	}

	public void setMzdm(String mzdm) {
		this.mzdm = mzdm;
	}

	public String getCsrq() {
		return csrq;
	}

	public void setCsrq(String csrq) {
		this.csrq = csrq;
	}

	public String getLxdh() {
		return lxdh;
	}

	public void setLxdh(String lxdh) {
		this.lxdh = lxdh;
	}

	public String getDz_hjdzssxdm() {
		return dz_hjdzssxdm;
	}

	public void setDz_hjdzssxdm(String dz_hjdzssxdm) {
		this.dz_hjdzssxdm = dz_hjdzssxdm;
	}

	public String getDz_hjdzmlpdm() {
		return dz_hjdzmlpdm;
	}

	public void setDz_hjdzmlpdm(String dz_hjdzmlpdm) {
		this.dz_hjdzmlpdm = dz_hjdzmlpdm;
	}

	public String getDz_hjdzmlpxz() {
		return dz_hjdzmlpxz;
	}

	public void setDz_hjdzmlpxz(String dz_hjdzmlpxz) {
		this.dz_hjdzmlpxz = dz_hjdzmlpxz;
	}

	public String getDz_hjdzdm() {
		return dz_hjdzdm;
	}

	public void setDz_hjdzdm(String dz_hjdzdm) {
		this.dz_hjdzdm = dz_hjdzdm;
	}

	public String getDz_hjdzxz() {
		return dz_hjdzxz;
	}

	public void setDz_hjdzxz(String dz_hjdzxz) {
		this.dz_hjdzxz = dz_hjdzxz;
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

	public String getZdrygllxdm() {
		return zdrygllxdm;
	}

	public void setZdrygllxdm(String zdrygllxdm) {
		this.zdrygllxdm = zdrygllxdm;
	}

	public String getGlzt() {
		return glzt;
	}

	public void setGlzt(String glzt) {
		this.glzt = glzt;
	}

	public String getZdlgbmid() {
		return zdlgbmid;
	}

	public void setZdlgbmid(String zdlgbmid) {
		this.zdlgbmid = zdlgbmid;
	}

	public String getZdlgbmmc() {
		return zdlgbmmc;
	}

	public void setZdlgbmmc(String zdlgbmmc) {
		this.zdlgbmmc = zdlgbmmc;
	}

	public String getSfjm() {
		return sfjm;
	}

	public void setSfjm(String sfjm) {
		this.sfjm = sfjm;
	}

	public String getSfzkdm() {
		return sfzkdm;
	}

	public void setSfzkdm(String sfzkdm) {
		this.sfzkdm = sfzkdm;
	}

	public String getSsfxjdm() {
		return ssfxjdm;
	}

	public void setSsfxjdm(String ssfxjdm) {
		this.ssfxjdm = ssfxjdm;
	}

	public String getSspcsdm() {
		return sspcsdm;
	}

	public void setSspcsdm(String sspcsdm) {
		this.sspcsdm = sspcsdm;
	}

	public String getSszrqdm() {
		return sszrqdm;
	}

	public void setSszrqdm(String sszrqdm) {
		this.sszrqdm = sszrqdm;
	}

}
