package com.founder.zdrygl.base.model;

import java.io.Serializable;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;
import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.zdrygl.core.model.Zdry;

/***
 * ****************************************************************************
 *
 * @Package: [com.founder.zdrygl.bean]
 * @ClassName: ZdryZdryhsb
 * @Description: [一句话描述该类的功能]
 * @Author: [zhoulijun@founder.com.cn]
 * @CreateDate:  2015-12-16 02:33:39
 * @UpdateUser: [Administrator(如多次修改保留历史记录，增加修改记录)]
 * @UpdateDate: [ 2015-12-16 02:33:39，(如多次修改保留历史记录，增加修改记录)]
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]
 * @Version: [v1.0]
 */


@DBInfoAnnotation(tableName = "ZDRY_ZDRYHSB", pk = "id")
public class ZdryZdryhsb extends BaseEntity implements Serializable,Zdry{
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
   @FieldDesc("下发部门代码") private String xfbmdm ;

	private String syrkid;
	private String ryid;

	public ZdryZdryhsb(){
	}

	public ZdryZdryhsb(String id){
		this.id = id;
	}

	public String getSyrkid() {
		return syrkid;
	}

	public void setSyrkid(String syrkid) {
		this.syrkid = syrkid;
	}

	public String getRyid() {
		return ryid;
	}

	public void setRyid(String ryid) {
		this.ryid = ryid;
	}

	public void setId(String value) {
		this.id = value;
	}
	
	public String getId() {
		return this.id;
	}
	public void setSjly(String value) {
		this.sjly = value;
	}
	
	public String getSjly() {
		return this.sjly;
	}
	public void setLyid(String value) {
		this.lyid = value;
	}
	
	public String getLyid() {
		return this.lyid;
	}
	public void setSspcs(String value) {
		this.sspcs = value;
	}
	
	public String getSspcs() {
		return this.sspcs;
	}
	public void setHszt(String value) {
		this.hszt = value;
	}
	
	public String getHszt() {
		return this.hszt;
	}
	public void setZdrygllxdm(String value) {
		this.zdrygllxdm = value;
	}
	
	public String getZdrygllxdm() {
		return this.zdrygllxdm;
	}
	public void setZdrylbdm(String value) {
		this.zdrylbdm = value;
	}
	
	public String getZdrylbdm() {
		return this.zdrylbdm;
	}
	public void setCyzjdm(String value) {
		this.cyzjdm = value;
	}
	
	public String getCyzjdm() {
		return this.cyzjdm;
	}
	public void setZjhm(String value) {
		this.zjhm = value;
	}
	
	public String getZjhm() {
		return this.zjhm;
	}
	public void setXm(String value) {
		this.xm = value;
	}
	
	public String getXm() {
		return this.xm;
	}
	public void setXbdm(String value) {
		this.xbdm = value;
	}
	
	public String getXbdm() {
		return this.xbdm;
	}
	public void setMzdm(String value) {
		this.mzdm = value;
	}
	
	public String getMzdm() {
		return this.mzdm;
	}
	public void setCsrq(String value) {
		this.csrq = value;
	}
	
	public String getCsrq() {
		return this.csrq;
	}
	public void setDz_hjdzssxdm(String value) {
		this.dz_hjdzssxdm = value;
	}
	
	public String getDz_hjdzssxdm() {
		return this.dz_hjdzssxdm;
	}
	public void setDz_hjdzmlpdm(String value) {
		this.dz_hjdzmlpdm = value;
	}
	
	public String getDz_hjdzmlpdm() {
		return this.dz_hjdzmlpdm;
	}
	public void setDz_hjdzmlpxz(String value) {
		this.dz_hjdzmlpxz = value;
	}
	
	public String getDz_hjdzmlpxz() {
		return this.dz_hjdzmlpxz;
	}
	public void setDz_hjdzdm(String value) {
		this.dz_hjdzdm = value;
	}
	
	public String getDz_hjdzdm() {
		return this.dz_hjdzdm;
	}
	public void setDz_hjdzxz(String value) {
		this.dz_hjdzxz = value;
	}
	
	public String getDz_hjdzxz() {
		return this.dz_hjdzxz;
	}
	public void setDz_jzdzssxdm(String value) {
		this.dz_jzdzssxdm = value;
	}
	
	public String getDz_jzdzssxdm() {
		return this.dz_jzdzssxdm;
	}
	public void setDz_jzdzmlpdm(String value) {
		this.dz_jzdzmlpdm = value;
	}
	
	public String getDz_jzdzmlpdm() {
		return this.dz_jzdzmlpdm;
	}
	public void setDz_jzdzmlpxz(String value) {
		this.dz_jzdzmlpxz = value;
	}
	
	public String getDz_jzdzmlpxz() {
		return this.dz_jzdzmlpxz;
	}
	public void setDz_jzdzdm(String value) {
		this.dz_jzdzdm = value;
	}
	
	public String getDz_jzdzdm() {
		return this.dz_jzdzdm;
	}
	public void setDz_jzdzxz(String value) {
		this.dz_jzdzxz = value;
	}
	
	public String getDz_jzdzxz() {
		return this.dz_jzdzxz;
	}
	public void setSaryzcdm(String value) {
		this.saryzcdm = value;
	}
	
	public String getSaryzcdm() {
		return this.saryzcdm;
	}
	public void setHykydm(String value) {
		this.hykydm = value;
	}
	
	public String getHykydm() {
		return this.hykydm;
	}
	public void setBrbjcjdm(String value) {
		this.brbjcjdm = value;
	}
	
	public String getBrbjcjdm() {
		return this.brbjcjdm;
	}
	public void setZwcjdm(String value) {
		this.zwcjdm = value;
	}
	
	public String getZwcjdm() {
		return this.zwcjdm;
	}
	public void setJchddq(String value) {
		this.jchddq = value;
	}
	
	public String getJchddq() {
		return this.jchddq;
	}
	public void setXxcjyjdm(String value) {
		this.xxcjyjdm = value;
	}
	
	public String getXxcjyjdm() {
		return this.xxcjyjdm;
	}
	public void setLg_sqr(String value) {
		this.lg_sqr = value;
	}
	
	public String getLg_sqr() {
		return this.lg_sqr;
	}
	public void setLg_sqrid(String value) {
		this.lg_sqrid = value;
	}
	
	public String getLg_sqrid() {
		return this.lg_sqrid;
	}
	public void setLg_sqrq(String value) {
		this.lg_sqrq = value;
	}
	
	public String getLg_sqrq() {
		return this.lg_sqrq;
	}
	public void setLg_spr(String value) {
		this.lg_spr = value;
	}
	
	public String getLg_spr() {
		return this.lg_spr;
	}
	public void setLg_sprid(String value) {
		this.lg_sprid = value;
	}
	
	public String getLg_sprid() {
		return this.lg_sprid;
	}
	public void setLg_sprq(String value) {
		this.lg_sprq = value;
	}
	
	public String getLg_sprq() {
		return this.lg_sprq;
	}
	public void setLg_spyj(String value) {
		this.lg_spyj = value;
	}
	
	public String getLg_spyj() {
		return this.lg_spyj;
	}
	public void setJgdx_jglbdm(String value) {
		this.jgdx_jglbdm = value;
	}
	
	public String getJgdx_jglbdm() {
		return this.jgdx_jglbdm;
	}
	public void setJgdx_jgdwjgdm(String value) {
		this.jgdx_jgdwjgdm = value;
	}
	
	public String getJgdx_jgdwjgdm() {
		return this.jgdx_jgdwjgdm;
	}
	public void setJgdx_jgdwmc(String value) {
		this.jgdx_jgdwmc = value;
	}
	
	public String getJgdx_jgdwmc() {
		return this.jgdx_jgdwmc;
	}
	public void setJgdx_pjjgmc(String value) {
		this.jgdx_pjjgmc = value;
	}
	
	public String getJgdx_pjjgmc() {
		return this.jgdx_pjjgmc;
	}
	public void setZdrk_glffdm(String value) {
		this.zdrk_glffdm = value;
	}
	
	public String getZdrk_glffdm() {
		return this.zdrk_glffdm;
	}
	public void setZdrk_lglydm(String value) {
		this.zdrk_lglydm = value;
	}
	
	public String getZdrk_lglydm() {
		return this.zdrk_lglydm;
	}

	public String getXfbmdm() {
		return xfbmdm;
	}

	public void setXfbmdm(String xfbmdm) {
		this.xfbmdm = xfbmdm;
	}
}

