package com.founder.sydw.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

@DBInfoAnnotation(tableName = "DW_CYRYXXB", pk = "id")
public class Cyryxxb extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@FieldDesc("ID")
	private String id;
	@FieldDesc("单位ID")
	private String dwid;
	@FieldDesc("人员ID")
	private String ryid;
	@FieldDesc("常用证件代码")
	private String cyzjdm;
	@FieldDesc("证件号码")
	private String zjhm;
	@FieldDesc("姓名")
	private String xm;
	@FieldDesc("性别代码")
	private String xbdm;
	@FieldDesc("出生日期")
	private String csrq;
	@FieldDesc("民族代码")
	private String mzdm;
	@FieldDesc("文化程度代码")
	private String whcddm;
	@FieldDesc("国籍代码")
	private String gjdm;
	@FieldDesc("联系电话")
	private String lxdh;
	@FieldDesc("地址-居住地址代码")
	private String dz_xzzdm;
	@FieldDesc("地址-居住地址行政区划代码")
	private String dz_xzzxzqhdm;
	@FieldDesc("地址-居住地址详址")
	private String dz_xzzxz;
	@FieldDesc("地址-户籍地代码")
	private String dz_hjddm;
	@FieldDesc("地址-户籍地行政区划代码")
	private String dz_hjdxzqhdm;
	@FieldDesc("地址-户籍地详址")
	private String dz_hjdxz;
	@FieldDesc("聘用日期")
	private String pyrq;
	@FieldDesc("所在部门名称")
	private String szbmmc;
	@FieldDesc("职业类别代码")
	private String zylbdm;
	@FieldDesc("职务名称")
	private String zwmc;
	@FieldDesc("简历")
	private String jl;
	@FieldDesc("劳务性质")
	private String lwxz;
	@FieldDesc("所属劳务公司ID")
	private String sslwgsid;
	@FieldDesc("所属劳务公司名称")
	private String sslwgsmc;
	@FieldDesc("紧急情况联系人ID")
	private String jjlxr_ryid;
	@FieldDesc("紧急情况联系人常用证件代码")
	private String jjlxr_cyzjdm;
	@FieldDesc("紧急情况联系人证件号码")
	private String jjlxr_zjhm;
	@FieldDesc("紧急情况联系人姓名")
	private String jjlxr_xm;
	@FieldDesc("紧急情况联系人性别代码")
	private String jjlxr_xbdm;
	@FieldDesc("紧急情况联系人电话")
	private String jjlxr_lxdh;
	@FieldDesc("与从业人员关系代码")
	private String ycyrygxdm;
	@FieldDesc("是否离职代码")
	private String sflzdm;
	@FieldDesc("离职日期")
	private String lz_rq;
	@FieldDesc("离职原因")
	private String lzyy;
	@FieldDesc("离职去向")
	private String lzqx;
	@FieldDesc("是否有上岗证代码")
	private String sfysgzdm;
	@FieldDesc("上岗证件种类")
	private String sgzjzl;
	@FieldDesc("上岗证件号码")
	private String sgzjhm;
	@FieldDesc("上岗证件级别")
	private String sgzjjb;
	@FieldDesc("上岗证件取得时间")
	private String sgzjqdsj;
	@FieldDesc("上岗证有效期")
	private String sgzyxq;
	@FieldDesc("上岗证发证机关")
	private String sgzfzjg;
	@FieldDesc("备注")
	private String bz;
	@FieldDesc("地址-居住地门楼牌代码")
	private String dz_xzzdmlpdm;
	@FieldDesc("地址-居住地门楼牌详址")
	private String dz_xzzdmlpxz;
	@FieldDesc("地址-户籍地门楼牌代码")
	private String dz_hjdmlpdm;
	@FieldDesc("地址-户籍地门楼牌详址")
	private String dz_hjdmlpxz;
	@FieldDesc("是否在职培训代码")
	private String sfzzpxdm;
	public String getSfzzpxdm() {
		return sfzzpxdm;
	}

	public void setSfzzpxdm(String sfzzpxdm) {
		this.sfzzpxdm = sfzzpxdm;
	}

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

	public String getXbdm() {
		return xbdm;
	}

	public void setXbdm(String xbdm) {
		this.xbdm = xbdm;
	}

	public String getCsrq() {
		return csrq;
	}

	public void setCsrq(String csrq) {
		this.csrq = csrq;
	}

	public String getMzdm() {
		return mzdm;
	}

	public void setMzdm(String mzdm) {
		this.mzdm = mzdm;
	}

	public String getWhcddm() {
		return whcddm;
	}

	public void setWhcddm(String whcddm) {
		this.whcddm = whcddm;
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

	public String getDz_xzzdm() {
		return dz_xzzdm;
	}

	public void setDz_xzzdm(String dz_xzzdm) {
		this.dz_xzzdm = dz_xzzdm;
	}

	public String getDz_xzzxzqhdm() {
		return dz_xzzxzqhdm;
	}

	public void setDz_xzzxzqhdm(String dz_xzzxzqhdm) {
		this.dz_xzzxzqhdm = dz_xzzxzqhdm;
	}

	public String getDz_xzzxz() {
		return dz_xzzxz;
	}

	public void setDz_xzzxz(String dz_xzzxz) {
		this.dz_xzzxz = dz_xzzxz;
	}

	public String getDz_hjddm() {
		return dz_hjddm;
	}

	public void setDz_hjddm(String dz_hjddm) {
		this.dz_hjddm = dz_hjddm;
	}

	public String getDz_hjdxzqhdm() {
		return dz_hjdxzqhdm;
	}

	public void setDz_hjdxzqhdm(String dz_hjdxzqhdm) {
		this.dz_hjdxzqhdm = dz_hjdxzqhdm;
	}

	public String getDz_hjdxz() {
		return dz_hjdxz;
	}

	public void setDz_hjdxz(String dz_hjdxz) {
		this.dz_hjdxz = dz_hjdxz;
	}

	public String getPyrq() {
		return pyrq;
	}

	public void setPyrq(String pyrq) {
		this.pyrq = pyrq;
	}

	public String getSzbmmc() {
		return szbmmc;
	}

	public void setSzbmmc(String szbmmc) {
		this.szbmmc = szbmmc;
	}

	public String getZylbdm() {
		return zylbdm;
	}

	public void setZylbdm(String zylbdm) {
		this.zylbdm = zylbdm;
	}

	public String getJl() {
		return jl;
	}

	public void setJl(String jl) {
		this.jl = jl;
	}

	public String getLwxz() {
		return lwxz;
	}

	public void setLwxz(String lwxz) {
		this.lwxz = lwxz;
	}

	public String getSslwgsid() {
		return sslwgsid;
	}

	public void setSslwgsid(String sslwgsid) {
		this.sslwgsid = sslwgsid;
	}

	public String getSslwgsmc() {
		return sslwgsmc;
	}

	public void setSslwgsmc(String sslwgsmc) {
		this.sslwgsmc = sslwgsmc;
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

	public String getYcyrygxdm() {
		return ycyrygxdm;
	}

	public void setYcyrygxdm(String ycyrygxdm) {
		this.ycyrygxdm = ycyrygxdm;
	}

	public String getSflzdm() {
		return sflzdm;
	}

	public void setSflzdm(String sflzdm) {
		this.sflzdm = sflzdm;
	}

	public String getLz_rq() {
		return lz_rq;
	}

	public void setLz_rq(String lz_rq) {
		this.lz_rq = lz_rq;
	}

	public String getLzyy() {
		return lzyy;
	}

	public void setLzyy(String lzyy) {
		this.lzyy = lzyy;
	}

	public String getLzqx() {
		return lzqx;
	}

	public void setLzqx(String lzqx) {
		this.lzqx = lzqx;
	}

	public String getSfysgzdm() {
		return sfysgzdm;
	}

	public void setSfysgzdm(String sfysgzdm) {
		this.sfysgzdm = sfysgzdm;
	}

	

	public String getSgzjzl() {
		return sgzjzl;
	}

	public void setSgzjzl(String sgzjzl) {
		this.sgzjzl = sgzjzl;
	}

	public String getZwmc() {
		return zwmc;
	}

	public void setZwmc(String zwmc) {
		this.zwmc = zwmc;
	}

	public String getSgzjhm() {
		return sgzjhm;
	}

	public void setSgzjhm(String sgzjhm) {
		this.sgzjhm = sgzjhm;
	}

	public String getSgzjjb() {
		return sgzjjb;
	}

	public void setSgzjjb(String sgzjjb) {
		this.sgzjjb = sgzjjb;
	}

	public String getSgzjqdsj() {
		return sgzjqdsj;
	}

	public void setSgzjqdsj(String sgzjqdsj) {
		this.sgzjqdsj = sgzjqdsj;
	}

	public String getSgzyxq() {
		return sgzyxq;
	}

	public void setSgzyxq(String sgzyxq) {
		this.sgzyxq = sgzyxq;
	}

	public String getSgzfzjg() {
		return sgzfzjg;
	}

	public void setSgzfzjg(String sgzfzjg) {
		this.sgzfzjg = sgzfzjg;
	}


	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

	public String getDz_xzzdmlpdm() {
		return dz_xzzdmlpdm;
	}

	public void setDz_xzzdmlpdm(String dz_xzzdmlpdm) {
		this.dz_xzzdmlpdm = dz_xzzdmlpdm;
	}

	public String getDz_xzzdmlpxz() {
		return dz_xzzdmlpxz;
	}

	public void setDz_xzzdmlpxz(String dz_xzzdmlpxz) {
		this.dz_xzzdmlpxz = dz_xzzdmlpxz;
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

}
