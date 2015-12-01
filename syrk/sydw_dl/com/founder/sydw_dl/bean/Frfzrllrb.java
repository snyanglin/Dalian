package com.founder.sydw_dl.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;
@DBInfoAnnotation(tableName = "DW_FRFZRLLRB", pk = "id",logQueryField="dwid")
public class Frfzrllrb extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 6009630414671904788L;

	@FieldDesc("ID")private String id;
	@FieldDesc("单位ID")private String dwid;
	@FieldDesc("人员ID")private String ryid;
	@FieldDesc("常用证件代码")private String cyzjdm;
	@FieldDesc("证件号码")private String zjhm;
	@FieldDesc("姓名")private String xm;
	@FieldDesc("出生日期")private String csrq;
	@FieldDesc("性别代码")private String xbdm;
	@FieldDesc("民族代码")private String mzdm;
	@FieldDesc("国籍代码")private String gjdm;
	@FieldDesc("联系电话")private String lxdh;
	@FieldDesc("地址-居住地址代码")private String dz_xjzdzdm;
	@FieldDesc("地址-居住地址省市县代码")private String dz_xjzdzssxdm;
	@FieldDesc("地址-居住地址详址")private String dz_xjzdzxz;
	@FieldDesc("地址-居住地门楼牌代码")private String dz_xjzdmlpdm;
	@FieldDesc("地址-居住地门楼牌详址")private String dz_xjzdmlpxz;
	@FieldDesc("地址-户籍地址代码")private String dz_hjdzdm;
	@FieldDesc("地址-户籍地址省市县代码")private String dz_hjdzssxdm;
	@FieldDesc("地址-户籍地址详址")private String dz_hjdzxz;
	@FieldDesc("地址-户籍地门楼牌代码")private String dz_hjdmlpdm;
	@FieldDesc("地址-户籍地门楼牌详址")private String dz_hjdmlpxz;
	@FieldDesc("职务")private String zw;
	@FieldDesc("单位人员类型代码")private String dwrylxdm;
	@FieldDesc("是否在公司任职代码")private String sfzgsrzdm;
	@FieldDesc("紧急联系人_人员ID")private String jjlxr_ryid;
	@FieldDesc("紧急联系人_常用证件代码")private String jjlxr_cyzjdm;
	@FieldDesc("紧急联系人_证件号码")private String jjlxr_zjhm;
	@FieldDesc("紧急联系人_姓名")private String jjlxr_xm;
	@FieldDesc("紧急联系人_性别代码")private String jjlxr_xbdm;
	@FieldDesc("紧急联系人_联系电话")private String jjlxr_lxdh;
	@FieldDesc("备注")private String bz;
	@FieldDesc("采集时间")private String xt_cjsj;
	@FieldDesc("录入时间")private String xt_lrsj;
	@FieldDesc("录入人姓名")private String xt_lrrxm;
	@FieldDesc("录入人ID")private String xt_lrrid;
	@FieldDesc("录入人部门")private String xt_lrrbm;
	@FieldDesc("录入人部门ID")private String xt_lrrbmid;
	@FieldDesc("录入IP")private String xt_lrip;
	@FieldDesc("最后修改时间")private String xt_zhxgsj;
	@FieldDesc("最后修改人姓名")private String xt_zhxgrxm;
	@FieldDesc("最后修改人ID")private String xt_zhxgrid;
	@FieldDesc("最后修改人部门")private String xt_zhxgrbm;
	@FieldDesc("最后修改人部门ID")private String xt_zhxgrbmid;
	@FieldDesc("最后修改IP")private String xt_zhxgip;
	@FieldDesc("注销标志")private String xt_zxbz;
	@FieldDesc("注销原因")private String xt_zxyy;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDwid() {
		return dwid;
	}
	public void setDwid(String dwid) {
		this.dwid = dwid;
	}
	public String getRyid() {
		return ryid;
	}
	public void setRyid(String ryid) {
		this.ryid = ryid;
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
	public String getCsrq() {
		return csrq;
	}
	public void setCsrq(String csrq) {
		this.csrq = csrq;
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
	public String getGjdm() {
		return gjdm;
	}
	public void setGjdm(String gjdm) {
		this.gjdm = gjdm;
	}
	public String getLxdh() {
		return lxdh;
	}
	public void setLxdh(String lxdh) {
		this.lxdh = lxdh;
	}
	public String getDz_xjzdzdm() {
		return dz_xjzdzdm;
	}
	public void setDz_xjzdzdm(String dz_xjzdzdm) {
		this.dz_xjzdzdm = dz_xjzdzdm;
	}
	public String getDz_xjzdzssxdm() {
		return dz_xjzdzssxdm;
	}
	public void setDz_xjzdzssxdm(String dz_xjzdzssxdm) {
		this.dz_xjzdzssxdm = dz_xjzdzssxdm;
	}
	public String getDz_xjzdzxz() {
		return dz_xjzdzxz;
	}
	public void setDz_xjzdzxz(String dz_xjzdzxz) {
		this.dz_xjzdzxz = dz_xjzdzxz;
	}
	public String getDz_xjzdmlpdm() {
		return dz_xjzdmlpdm;
	}
	public void setDz_xjzdmlpdm(String dz_xjzdmlpdm) {
		this.dz_xjzdmlpdm = dz_xjzdmlpdm;
	}
	public String getDz_xjzdmlpxz() {
		return dz_xjzdmlpxz;
	}
	public void setDz_xjzdmlpxz(String dz_xjzdmlpxz) {
		this.dz_xjzdmlpxz = dz_xjzdmlpxz;
	}
	public String getDz_hjdzdm() {
		return dz_hjdzdm;
	}
	public void setDz_hjdzdm(String dz_hjdzdm) {
		this.dz_hjdzdm = dz_hjdzdm;
	}
	public String getDz_hjdzssxdm() {
		return dz_hjdzssxdm;
	}
	public void setDz_hjdzssxdm(String dz_hjdzssxdm) {
		this.dz_hjdzssxdm = dz_hjdzssxdm;
	}
	public String getDz_hjdzxz() {
		return dz_hjdzxz;
	}
	public void setDz_hjdzxz(String dz_hjdzxz) {
		this.dz_hjdzxz = dz_hjdzxz;
	}
	public String getDz_hjdmlpdm() {
		return dz_hjdmlpdm;
	}
	public void setDz_hjdmlpdm(String dz_hjdmlpdm) {
		this.dz_hjdmlpdm = dz_hjdmlpdm;
	}
	public String getDz_hjdmlpxz() {
		return dz_hjdmlpxz;
	}
	public void setDz_hjdmlpxz(String dz_hjdmlpxz) {
		this.dz_hjdmlpxz = dz_hjdmlpxz;
	}
	public String getZw() {
		return zw;
	}
	public void setZw(String zw) {
		this.zw = zw;
	}
	public String getDwrylxdm() {
		return dwrylxdm;
	}
	public void setDwrylxdm(String dwrylxdm) {
		this.dwrylxdm = dwrylxdm;
	}
	public String getSfzgsrzdm() {
		return sfzgsrzdm;
	}
	public void setSfzgsrzdm(String sfzgsrzdm) {
		this.sfzgsrzdm = sfzgsrzdm;
	}
	public String getJjlxr_ryid() {
		return jjlxr_ryid;
	}
	public void setJjlxr_ryid(String jjlxr_ryid) {
		this.jjlxr_ryid = jjlxr_ryid;
	}
	public String getJjlxr_cyzjdm() {
		return jjlxr_cyzjdm;
	}
	public void setJjlxr_cyzjdm(String jjlxr_cyzjdm) {
		this.jjlxr_cyzjdm = jjlxr_cyzjdm;
	}
	public String getJjlxr_zjhm() {
		return jjlxr_zjhm;
	}
	public void setJjlxr_zjhm(String jjlxr_zjhm) {
		this.jjlxr_zjhm = jjlxr_zjhm;
	}
	public String getJjlxr_xm() {
		return jjlxr_xm;
	}
	public void setJjlxr_xm(String jjlxr_xm) {
		this.jjlxr_xm = jjlxr_xm;
	}
	public String getJjlxr_xbdm() {
		return jjlxr_xbdm;
	}
	public void setJjlxr_xbdm(String jjlxr_xbdm) {
		this.jjlxr_xbdm = jjlxr_xbdm;
	}
	public String getJjlxr_lxdh() {
		return jjlxr_lxdh;
	}
	public void setJjlxr_lxdh(String jjlxr_lxdh) {
		this.jjlxr_lxdh = jjlxr_lxdh;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	public String getXt_cjsj() {
		return xt_cjsj;
	}
	public void setXt_cjsj(String xt_cjsj) {
		this.xt_cjsj = xt_cjsj;
	}
	public String getXt_lrsj() {
		return xt_lrsj;
	}
	public void setXt_lrsj(String xt_lrsj) {
		this.xt_lrsj = xt_lrsj;
	}
	public String getXt_lrrxm() {
		return xt_lrrxm;
	}
	public void setXt_lrrxm(String xt_lrrxm) {
		this.xt_lrrxm = xt_lrrxm;
	}
	public String getXt_lrrid() {
		return xt_lrrid;
	}
	public void setXt_lrrid(String xt_lrrid) {
		this.xt_lrrid = xt_lrrid;
	}
	public String getXt_lrrbm() {
		return xt_lrrbm;
	}
	public void setXt_lrrbm(String xt_lrrbm) {
		this.xt_lrrbm = xt_lrrbm;
	}
	public String getXt_lrrbmid() {
		return xt_lrrbmid;
	}
	public void setXt_lrrbmid(String xt_lrrbmid) {
		this.xt_lrrbmid = xt_lrrbmid;
	}
	public String getXt_lrip() {
		return xt_lrip;
	}
	public void setXt_lrip(String xt_lrip) {
		this.xt_lrip = xt_lrip;
	}
	public String getXt_zhxgsj() {
		return xt_zhxgsj;
	}
	public void setXt_zhxgsj(String xt_zhxgsj) {
		this.xt_zhxgsj = xt_zhxgsj;
	}
	public String getXt_zhxgrxm() {
		return xt_zhxgrxm;
	}
	public void setXt_zhxgrxm(String xt_zhxgrxm) {
		this.xt_zhxgrxm = xt_zhxgrxm;
	}
	public String getXt_zhxgrid() {
		return xt_zhxgrid;
	}
	public void setXt_zhxgrid(String xt_zhxgrid) {
		this.xt_zhxgrid = xt_zhxgrid;
	}
	public String getXt_zhxgrbm() {
		return xt_zhxgrbm;
	}
	public void setXt_zhxgrbm(String xt_zhxgrbm) {
		this.xt_zhxgrbm = xt_zhxgrbm;
	}
	public String getXt_zhxgrbmid() {
		return xt_zhxgrbmid;
	}
	public void setXt_zhxgrbmid(String xt_zhxgrbmid) {
		this.xt_zhxgrbmid = xt_zhxgrbmid;
	}
	public String getXt_zhxgip() {
		return xt_zhxgip;
	}
	public void setXt_zhxgip(String xt_zhxgip) {
		this.xt_zhxgip = xt_zhxgip;
	}
	public String getXt_zxbz() {
		return xt_zxbz;
	}
	public void setXt_zxbz(String xt_zxbz) {
		this.xt_zxbz = xt_zxbz;
	}
	public String getXt_zxyy() {
		return xt_zxyy;
	}
	public void setXt_zxyy(String xt_zxyy) {
		this.xt_zxyy = xt_zxyy;
	}

}
