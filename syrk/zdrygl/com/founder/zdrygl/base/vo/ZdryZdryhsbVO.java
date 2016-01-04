package com.founder.zdrygl.base.vo;

import java.io.Serializable;
import com.founder.framework.annotation.FieldDesc;

/***
 * ****************************************************************************
 *
 * @Package: [com.founder.zdrygl.bean]
 * @ClassName: ZdryZdryhsb
 * @Description: [一句话描述该类的功能]
 * @Author: [zhoulijun@founder.com.cn]
 * @CreateDate:  2015-12-15 04:46:24
 * @UpdateUser: [Administrator(如多次修改保留历史记录，增加修改记录)]
 * @UpdateDate: [ 2015-12-15 04:46:24，(如多次修改保留历史记录，增加修改记录)]
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]
 * @Version: [v1.0]
 */


public class ZdryZdryhsbVO  implements Serializable {

	private static final long serialVersionUID = 3904875445049446414L;
	@FieldDesc("重点人员核实ID") private String id;
	@FieldDesc("数据来源") private String sjly;
	@FieldDesc("来源ID") private String lyid;
	@FieldDesc("所属派出所") private String sspcs;
	@FieldDesc("核实状态") private String hszt;
	@FieldDesc("重点人员管理类型代码") private String zdrygllxdm;
	@FieldDesc("重点人员类别代码") private String zdrylbdm;
	@FieldDesc("证件种类") private String cyzjdm;
	@FieldDesc("证件号码") private String zjhm;
	@FieldDesc("姓名") private String xm;
	@FieldDesc("性别代码") private String xbdm;
	@FieldDesc("民族代码") private String mzdm;
	@FieldDesc("出生日期") private String csrq;
	@FieldDesc("地址-户籍地址省市县代码") private String dz_hjdzssxdm;
	@FieldDesc("地址-户籍地址门楼牌代码") private String dz_hjdzmlpdm;
	@FieldDesc("地址-户籍地址门楼牌详址") private String dz_hjdzmlpxz;
	@FieldDesc("地址-户籍地址代码") private String dz_hjdzdm;
	@FieldDesc("地址-户籍地址详址") private String dz_hjdzxz;
	@FieldDesc("地址-居住地址省市县代码") private String dz_jzdzssxdm;
	@FieldDesc("地址-居住地址门楼牌代码") private String dz_jzdzmlpdm;
	@FieldDesc("地址-居住地址门楼牌详址") private String dz_jzdzmlpxz;
	@FieldDesc("地址-居住地址代码") private String dz_jzdzdm;
	@FieldDesc("地址-居住地址详址") private String dz_jzdzxz;
	@FieldDesc("涉案人员专长代码") private String saryzcdm;
	@FieldDesc("汉语口音代码") private String hykydm;
	@FieldDesc("本人笔迹采集代码") private String brbjcjdm;
	@FieldDesc("指纹采集代码") private String zwcjdm;
	@FieldDesc("经常活动地区") private String jchddq;
	@FieldDesc("信息采集依据代码") private String xxcjyjdm;
	@FieldDesc("列管_申请人") private String lg_sqr;
	@FieldDesc("列管_申请人ID") private String lg_sqrid;
	@FieldDesc("列管_申请日期") private String lg_sqrq;
	@FieldDesc("列管_审批人") private String lg_spr;
	@FieldDesc("列管_审批人ID") private String lg_sprid;
	@FieldDesc("列管_审批日期") private String lg_sprq;
	@FieldDesc("列管_审批意见") private String lg_spyj;
	@FieldDesc("监管对象_监管类别代码") private String jgdx_jglbdm;
	@FieldDesc("监管对象_监管单位机构代码") private String jgdx_jgdwjgdm;
	@FieldDesc("监管对象_监管单位名称") private String jgdx_jgdwmc;
	@FieldDesc("监管对象_判决机关名称") private String jgdx_pjjgmc;
	@FieldDesc("重点人口_管理方法代码") private String zdrk_glffdm;
	@FieldDesc("重点人口_列管来源代码") private String zdrk_lglydm;
	@FieldDesc("采集时间")
	private String xt_cjsj;
	@FieldDesc("录入时间")
	private String xt_lrsj;
	@FieldDesc("录入人姓名")
	private String xt_lrrxm;
	@FieldDesc("录入人ID")
	private String xt_lrrid;
	@FieldDesc("录入人部门")
	private String xt_lrrbm;
	@FieldDesc("录入人部门ID")
	private String xt_lrrbmid;
	@FieldDesc("录入IP")
	private String xt_lrip;
	@FieldDesc("最后修改时间")
	private String xt_zhxgsj;
	@FieldDesc("最后修改人姓名")
	private String xt_zhxgrxm;
	@FieldDesc("最后修改人ID")
	private String xt_zhxgrid;
	@FieldDesc("最后修改人部门")
	private String xt_zhxgrbm;
	@FieldDesc("最后修改人部门ID")
	private String xt_zhxgrbmid;
	@FieldDesc("最后修改IP")
	private String xt_zhxgip;
	@FieldDesc("注销标志")
	private String xt_zxbz;
	@FieldDesc("注销原因")
	private String xt_zxyy;
	@FieldDesc("下发部门代码")
	private String xfbmdm;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSjly() {
		return sjly;
	}

	public void setSjly(String sjly) {
		this.sjly = sjly;
	}

	public String getLyid() {
		return lyid;
	}

	public void setLyid(String lyid) {
		this.lyid = lyid;
	}

	public String getSspcs() {
		return sspcs;
	}

	public void setSspcs(String sspcs) {
		this.sspcs = sspcs;
	}

	public String getHszt() {
		return hszt;
	}

	public void setHszt(String hszt) {
		this.hszt = hszt;
	}

	public String getZdrygllxdm() {
		return zdrygllxdm;
	}

	public void setZdrygllxdm(String zdrygllxdm) {
		this.zdrygllxdm = zdrygllxdm;
	}

	public String getZdrylbdm() {
		return zdrylbdm;
	}

	public void setZdrylbdm(String zdrylbdm) {
		this.zdrylbdm = zdrylbdm;
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

	public String getSaryzcdm() {
		return saryzcdm;
	}

	public void setSaryzcdm(String saryzcdm) {
		this.saryzcdm = saryzcdm;
	}

	public String getHykydm() {
		return hykydm;
	}

	public void setHykydm(String hykydm) {
		this.hykydm = hykydm;
	}

	public String getBrbjcjdm() {
		return brbjcjdm;
	}

	public void setBrbjcjdm(String brbjcjdm) {
		this.brbjcjdm = brbjcjdm;
	}

	public String getZwcjdm() {
		return zwcjdm;
	}

	public void setZwcjdm(String zwcjdm) {
		this.zwcjdm = zwcjdm;
	}

	public String getJchddq() {
		return jchddq;
	}

	public void setJchddq(String jchddq) {
		this.jchddq = jchddq;
	}

	public String getXxcjyjdm() {
		return xxcjyjdm;
	}

	public void setXxcjyjdm(String xxcjyjdm) {
		this.xxcjyjdm = xxcjyjdm;
	}

	public String getLg_sqr() {
		return lg_sqr;
	}

	public void setLg_sqr(String lg_sqr) {
		this.lg_sqr = lg_sqr;
	}

	public String getLg_sqrid() {
		return lg_sqrid;
	}

	public void setLg_sqrid(String lg_sqrid) {
		this.lg_sqrid = lg_sqrid;
	}

	public String getLg_sqrq() {
		return lg_sqrq;
	}

	public void setLg_sqrq(String lg_sqrq) {
		this.lg_sqrq = lg_sqrq;
	}

	public String getLg_spr() {
		return lg_spr;
	}

	public void setLg_spr(String lg_spr) {
		this.lg_spr = lg_spr;
	}

	public String getLg_sprid() {
		return lg_sprid;
	}

	public void setLg_sprid(String lg_sprid) {
		this.lg_sprid = lg_sprid;
	}

	public String getLg_sprq() {
		return lg_sprq;
	}

	public void setLg_sprq(String lg_sprq) {
		this.lg_sprq = lg_sprq;
	}

	public String getLg_spyj() {
		return lg_spyj;
	}

	public void setLg_spyj(String lg_spyj) {
		this.lg_spyj = lg_spyj;
	}

	public String getJgdx_jglbdm() {
		return jgdx_jglbdm;
	}

	public void setJgdx_jglbdm(String jgdx_jglbdm) {
		this.jgdx_jglbdm = jgdx_jglbdm;
	}

	public String getJgdx_jgdwjgdm() {
		return jgdx_jgdwjgdm;
	}

	public void setJgdx_jgdwjgdm(String jgdx_jgdwjgdm) {
		this.jgdx_jgdwjgdm = jgdx_jgdwjgdm;
	}

	public String getJgdx_jgdwmc() {
		return jgdx_jgdwmc;
	}

	public void setJgdx_jgdwmc(String jgdx_jgdwmc) {
		this.jgdx_jgdwmc = jgdx_jgdwmc;
	}

	public String getJgdx_pjjgmc() {
		return jgdx_pjjgmc;
	}

	public void setJgdx_pjjgmc(String jgdx_pjjgmc) {
		this.jgdx_pjjgmc = jgdx_pjjgmc;
	}

	public String getZdrk_glffdm() {
		return zdrk_glffdm;
	}

	public void setZdrk_glffdm(String zdrk_glffdm) {
		this.zdrk_glffdm = zdrk_glffdm;
	}

	public String getZdrk_lglydm() {
		return zdrk_lglydm;
	}

	public void setZdrk_lglydm(String zdrk_lglydm) {
		this.zdrk_lglydm = zdrk_lglydm;
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

	public String getXfbmdm() {
		return xfbmdm;
	}

	public void setXfbmdm(String xfbmdm) {
		this.xfbmdm = xfbmdm;
	}
}

