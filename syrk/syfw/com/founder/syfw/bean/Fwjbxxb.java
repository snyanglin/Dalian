package com.founder.syfw.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

@DBInfoAnnotation(tableName = "SYFW_FWJBXXB", pk = "id")
public class Fwjbxxb extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 8604498880793313183L;
	@FieldDesc("房屋ID")
	private String id;
	@FieldDesc("房屋类别代码")
	private String fwlbdm;
	@FieldDesc("房屋产权性质种类代码")
	private String fwcqxzzldm;
	@FieldDesc("房屋用途代码")
	private String fwytdm;
	@FieldDesc("房屋间数")
	private Long fwjs;
	@FieldDesc("房屋面积_面积（平方米）")
	private Double fwmj_mjpfm;
	@FieldDesc("房屋产权证号")
	private String fwcqzh;
	@FieldDesc("房主_人员ID")
	private String fz_ryid;
	@FieldDesc("房主_证件种类")
	private String fz_cyzjdm;
	@FieldDesc("房主_证件号码")
	private String fz_zjhm;
	@FieldDesc("房主_姓名")
	private String fz_xm;
	@FieldDesc("房主_外文姓")
	private String fz_wwx;
	@FieldDesc("房主_外文名")
	private String fz_wwm;
	@FieldDesc("房主_联系电话")
	private String fz_lxdh;
	@FieldDesc("托管人_人员ID")
	private String tgr_ryid;
	@FieldDesc("托管人_证件种类")
	private String tgr_cyzjdm;
	@FieldDesc("托管人_证件号码")
	private String tgr_zjhm;
	@FieldDesc("托管人_姓名")
	private String tgr_xm;
	@FieldDesc("托管人_外文姓")
	private String tgr_wwx;
	@FieldDesc("托管人_外文名")
	private String tgr_wwm;
	@FieldDesc("托管人_联系电话")
	private String tgr_lxdh;
	@FieldDesc("托管人_与房主关系_人员关系代码")
	private String tgr_yfzgx_rygxdm;
	@FieldDesc("房屋所属单位_单位ID")
	private String fwssdw_dwid;
	@FieldDesc("房屋所属单位_单位名称")
	private String fwssdw_dwmc;
	@FieldDesc("房屋地址_地址ID")
	private String fwdz_dzid;
	@FieldDesc("房屋地址_行政区划代码")
	private String fwdz_xzqhdm;
	@FieldDesc("房屋地址_地址详址")
	private String fwdz_dzxz;
	@FieldDesc("房屋地址_门楼牌代码")
	private String fwdz_mlpdm;
	@FieldDesc("房屋地址_门楼牌详址")
	private String fwdz_mlpxz;
	@FieldDesc("房屋地址_坐标X")
	private String fwdz_zbx;
	@FieldDesc("房屋地址_坐标Y")
	private String fwdz_zby;
	@FieldDesc("是否出租房屋")
	private String sfczfw;
	@FieldDesc("所属2级部门代码")
	private String ss2jbmdm;
	@FieldDesc("所属3级部门代码")
	private String ss3jbmdm;
	@FieldDesc("所属4级部门代码")
	private String ss4jbmdm;
	
	@FieldDesc("备注")
	
	private String jzd_dzid;
	private String jzd_mlpdm;
	private String jzd_mlpxz;
	private String jzd_xzqhdm;
	private String jzd_dzxz;
	private String dyh_shmc;
	
	public String getDyh_shmc() {
		return dyh_shmc;
	}
	public void setDyh_shmc(String dyh_shmc) {
		this.dyh_shmc = dyh_shmc;
	}
	public String getJzd_mlpdm() {
		return jzd_mlpdm;
	}
	public void setJzd_mlpdm(String jzd_mlpdm) {
		this.jzd_mlpdm = jzd_mlpdm;
	}
	public String getJzd_xzqhdm() {
		return jzd_xzqhdm;
	}
	public void setJzd_xzqhdm(String jzd_xzqhdm) {
		this.jzd_xzqhdm = jzd_xzqhdm;
	}
	public String getJzd_dzxz() {
		return jzd_dzxz;
	}
	public void setJzd_dzxz(String jzd_dzxz) {
		this.jzd_dzxz = jzd_dzxz;
	}
	private String bz;
	/**实有人口居住地址子表统计*/
	private String jzrs;
	
	public String getJzd_mlpxz() {
		return jzd_mlpxz;
	}
	public void setJzd_mlpxz(String jzd_mlpxz) {
		this.jzd_mlpxz = jzd_mlpxz;
	}
	public String getJzd_dzid() {
		return jzd_dzid;
	}
	public void setJzd_dzid(String jzd_dzid) {
		this.jzd_dzid = jzd_dzid;
	}
	public String getJzrs() {
		return jzrs;
	}
	public void setJzrs(String jzrs) {
		this.jzrs = jzrs;
	}
	public String getFwssdw_dwmc() {
		return fwssdw_dwmc;
	}
	public void setFwssdw_dwmc(String fwssdw_dwmc) {
		this.fwssdw_dwmc = fwssdw_dwmc;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFwlbdm() {
		return fwlbdm;
	}
	public void setFwlbdm(String fwlbdm) {
		this.fwlbdm = fwlbdm;
	}
	public String getFwcqxzzldm() {
		return fwcqxzzldm;
	}
	public void setFwcqxzzldm(String fwcqxzzldm) {
		this.fwcqxzzldm = fwcqxzzldm;
	}
	public String getFwytdm() {
		return fwytdm;
	}
	public void setFwytdm(String fwytdm) {
		this.fwytdm = fwytdm;
	}
	public Long getFwjs() {
		return fwjs;
	}
	public void setFwjs(Long fwjs) {
		this.fwjs = fwjs;
	}
	
	public Double getFwmj_mjpfm() {
		return fwmj_mjpfm;
	}
	public void setFwmj_mjpfm(Double fwmj_mjpfm) {
		this.fwmj_mjpfm = fwmj_mjpfm;
	}
	public String getFwcqzh() {
		return fwcqzh;
	}
	public void setFwcqzh(String fwcqzh) {
		this.fwcqzh = fwcqzh;
	}
	public String getFz_ryid() {
		return fz_ryid;
	}
	public void setFz_ryid(String fz_ryid) {
		this.fz_ryid = fz_ryid;
	}
	public String getFz_cyzjdm() {
		return fz_cyzjdm;
	}
	public void setFz_cyzjdm(String fz_cyzjdm) {
		this.fz_cyzjdm = fz_cyzjdm;
	}
	public String getFz_zjhm() {
		return fz_zjhm;
	}
	public void setFz_zjhm(String fz_zjhm) {
		this.fz_zjhm = fz_zjhm;
	}
	public String getFz_xm() {
		return fz_xm;
	}
	public void setFz_xm(String fz_xm) {
		this.fz_xm = fz_xm;
	}
	public String getFz_wwx() {
		return fz_wwx;
	}
	public void setFz_wwx(String fz_wwx) {
		this.fz_wwx = fz_wwx;
	}
	public String getFz_wwm() {
		return fz_wwm;
	}
	public void setFz_wwm(String fz_wwm) {
		this.fz_wwm = fz_wwm;
	}
	public String getFz_lxdh() {
		return fz_lxdh;
	}
	public void setFz_lxdh(String fz_lxdh) {
		this.fz_lxdh = fz_lxdh;
	}
	public String getTgr_ryid() {
		return tgr_ryid;
	}
	public void setTgr_ryid(String tgr_ryid) {
		this.tgr_ryid = tgr_ryid;
	}
	public String getTgr_cyzjdm() {
		return tgr_cyzjdm;
	}
	public void setTgr_cyzjdm(String tgr_cyzjdm) {
		this.tgr_cyzjdm = tgr_cyzjdm;
	}
	public String getTgr_zjhm() {
		return tgr_zjhm;
	}
	public void setTgr_zjhm(String tgr_zjhm) {
		this.tgr_zjhm = tgr_zjhm;
	}
	public String getTgr_xm() {
		return tgr_xm;
	}
	public void setTgr_xm(String tgr_xm) {
		this.tgr_xm = tgr_xm;
	}
	public String getTgr_wwx() {
		return tgr_wwx;
	}
	public void setTgr_wwx(String tgr_wwx) {
		this.tgr_wwx = tgr_wwx;
	}
	public String getTgr_wwm() {
		return tgr_wwm;
	}
	public void setTgr_wwm(String tgr_wwm) {
		this.tgr_wwm = tgr_wwm;
	}
	public String getTgr_lxdh() {
		return tgr_lxdh;
	}
	public void setTgr_lxdh(String tgr_lxdh) {
		this.tgr_lxdh = tgr_lxdh;
	}
	public String getTgr_yfzgx_rygxdm() {
		return tgr_yfzgx_rygxdm;
	}
	public void setTgr_yfzgx_rygxdm(String tgr_yfzgx_rygxdm) {
		this.tgr_yfzgx_rygxdm = tgr_yfzgx_rygxdm;
	}
	public String getFwssdw_dwid() {
		return fwssdw_dwid;
	}
	public void setFwssdw_dwid(String fwssdw_dwid) {
		this.fwssdw_dwid = fwssdw_dwid;
	}
	public String getSfczfw() {
		return sfczfw;
	}
	public void setSfczfw(String sfczfw) {
		this.sfczfw = sfczfw;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	public String getSs2jbmdm() {
		return ss2jbmdm;
	}
	public void setSs2jbmdm(String ss2jbmdm) {
		this.ss2jbmdm = ss2jbmdm;
	}
	public String getSs3jbmdm() {
		return ss3jbmdm;
	}
	public void setSs3jbmdm(String ss3jbmdm) {
		this.ss3jbmdm = ss3jbmdm;
	}
	public String getSs4jbmdm() {
		return ss4jbmdm;
	}
	public void setSs4jbmdm(String ss4jbmdm) {
		this.ss4jbmdm = ss4jbmdm;
	}
	public String getFwdz_dzid() {
		return fwdz_dzid;
	}
	public void setFwdz_dzid(String fwdz_dzid) {
		this.fwdz_dzid = fwdz_dzid;
	}
	public String getFwdz_xzqhdm() {
		return fwdz_xzqhdm;
	}
	public void setFwdz_xzqhdm(String fwdz_xzqhdm) {
		this.fwdz_xzqhdm = fwdz_xzqhdm;
	}
	public String getFwdz_dzxz() {
		return fwdz_dzxz;
	}
	public void setFwdz_dzxz(String fwdz_dzxz) {
		this.fwdz_dzxz = fwdz_dzxz;
	}
	public String getFwdz_mlpdm() {
		return fwdz_mlpdm;
	}
	public void setFwdz_mlpdm(String fwdz_mlpdm) {
		this.fwdz_mlpdm = fwdz_mlpdm;
	}
	public String getFwdz_mlpxz() {
		return fwdz_mlpxz;
	}
	public void setFwdz_mlpxz(String fwdz_mlpxz) {
		this.fwdz_mlpxz = fwdz_mlpxz;
	}
	public String getFwdz_zbx() {
		return fwdz_zbx;
	}
	public void setFwdz_zbx(String fwdz_zbx) {
		this.fwdz_zbx = fwdz_zbx;
	}
	public String getFwdz_zby() {
		return fwdz_zby;
	}
	public void setFwdz_zby(String fwdz_zby) {
		this.fwdz_zby = fwdz_zby;
	}
}
