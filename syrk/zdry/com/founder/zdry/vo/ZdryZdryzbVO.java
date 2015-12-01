package com.founder.zdry.vo;

import java.io.Serializable;

import com.founder.framework.annotation.FieldDesc;

/**
 * ****************************************************************************
 * @Package:      [com.founder.zdry.vo.ZdryZdryzbVO.java]  
 * @ClassName:    [ZdryZdryzbVO]   
 * @Description:  [重点人员总表VO]   
 * @Author:       [weiwen]  
 * @CreateDate:   [2015-3-15 下午4:20:13]   
 * @UpdateUser:   [weiwen]   
 * @UpdateDate:   [2015-3-15 下午4:20:13，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
public class ZdryZdryzbVO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;
	private String ryid;
	private String syrkid;
	private String cyzjdm;
	private String zjhm;
	private String xm;
	private String xbdm;
	private String mzdm;
	private String csrq;
	private String lxdh;
	private String dz_hjdzssxdm;
	private String dz_hjdzmlpdm;
	private String dz_hjdzmlpxz;
	private String dz_hjdzdm;
	private String dz_hjdzxz;
	private String dz_jzdzssxdm;
	private String dz_jzdzmlpdm;
	private String dz_jzdzmlpxz;
	private String dz_jzdzdm;
	private String dz_jzdzxz;
	private String zdrygllxdm;
	private String glzt;
	private String zdlgbmid;
	private String zdlgbmmc;
	private String sfsjsp;
	private String sfjm;
	private String sfzkdm;
	private String ssfxjdm;
	private String sspcsdm;
	private String sszrqdm;
	private String zywtjxsbx;
	
	private String jgbmdm;
	private String jgbmmc;
	private String zbx;
	private String zby;
	
	
	private String ygxzrqdm;
	private String ygxpcsdm;
	@FieldDesc("查询类型")
	private String type;
	@FieldDesc("半径")
	private String mapRadius;
	@FieldDesc("坐标值")
	private String zbz;
	private int srid;
	
	
	
	
	
	public String getSfsjsp() {
		return sfsjsp;
	}
	public void setSfsjsp(String sfsjsp) {
		this.sfsjsp = sfsjsp;
	}
	public int getSrid() {
		return srid;
	}
	public void setSrid(int srid) {
		this.srid = srid;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getMapRadius() {
		return mapRadius;
	}
	public void setMapRadius(String mapRadius) {
		this.mapRadius = mapRadius;
	}
	public String getZbz() {
		return zbz;
	}
	public void setZbz(String zbz) {
		this.zbz = zbz;
	}
	public String getYgxzrqdm() {
		return ygxzrqdm;
	}
	public void setYgxzrqdm(String ygxzrqdm) {
		this.ygxzrqdm = ygxzrqdm;
	}
	public String getYgxpcsdm() {
		return ygxpcsdm;
	}
	public void setYgxpcsdm(String ygxpcsdm) {
		this.ygxpcsdm = ygxpcsdm;
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
	public String getZywtjxsbx() {
		return zywtjxsbx;
	}
	public void setZywtjxsbx(String zywtjxsbx) {
		this.zywtjxsbx = zywtjxsbx;
	}
	public String getJgbmdm() {
		return jgbmdm;
	}
	public void setJgbmdm(String jgbmdm) {
		this.jgbmdm = jgbmdm;
	}
	public String getJgbmmc() {
		return jgbmmc;
	}
	public void setJgbmmc(String jgbmmc) {
		this.jgbmmc = jgbmmc;
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
