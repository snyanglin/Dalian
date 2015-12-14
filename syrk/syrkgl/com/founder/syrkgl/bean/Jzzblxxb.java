package com.founder.syrkgl.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

@DBInfoAnnotation(tableName = "RY_JZZBLXXB", pk = "id")
public class Jzzblxxb extends BaseEntity implements Serializable{
    
	private static final long serialVersionUID = 1L;
	@FieldDesc("ID")
	private String id;
	@FieldDesc("实有人口ID")
	private String syrkid;
	@FieldDesc("人员ID")
	private String ryid;
	@FieldDesc("居住证_编号")
	private String jzz_bh;
	@FieldDesc("打印_编号")
	private String dy_bh;
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
	@FieldDesc("户籍地_地址详址")
	private String hjd_dzxz;
	@FieldDesc("居住地_地址详址")
	private String jzd_dzxz;
	@FieldDesc("办理_分局代码")
	private String bl_fjdm;
	@FieldDesc("办理_分局名称")
	private String bl_fjmc;
	@FieldDesc("办理_派出所代码")
	private String bl_pcsdm;
	@FieldDesc("办理_派出所名称")
	private String bl_pcsmc;
	@FieldDesc("办理_责任区代码")
	private String bl_zrqdm;
	@FieldDesc("办理_责任区名称")
	private String bl_zrqmc;
	@FieldDesc("办理人_ID")
	private String blr_id;
	@FieldDesc("办理人_姓名")
	private String blr_xm;
	@FieldDesc("居住证办理日期")
	private String jzzblrq;
	@FieldDesc("居住证_签发日期")
	private String jzz_qfrq;
	@FieldDesc("有效期截止日期")
	private String yxq_jzrq;
	@FieldDesc("居住证_有效期代码")
	private String jzz_yxqdm;
	@FieldDesc("居住证_办理状态代码")
	private String jzz_blztdm;
	@FieldDesc("居住证_领取方式代码")
	private String jzz_lqfsdm;
	@FieldDesc("居住证_领取日期")
	private String jzz_lqrq;
	@FieldDesc("居住证_快递地址")
	private String jzz_kddz;
	@FieldDesc("居住证_快递收件人")
	private String jzz_kdsjr;
	@FieldDesc("居住证_快递联系电话")
	private String jzz_kdlxdh;
	@FieldDesc("居住证_快递公司")
	private String jzz_kdgs;
	@FieldDesc("居住证_快递单号")
	private String jzz_kddh;
	@FieldDesc("制证人_姓名")
	private String zzr_xm;
	@FieldDesc("制证人_ID")
	private String zzr_id;
	@FieldDesc("备注")
	private String bz;
	
	//自定义查询条件
	private String nb_orgcode;
	
	public String getNb_orgcode() {
		return nb_orgcode;
	}
	public void setNb_orgcode(String nbOrgcode) {
		nb_orgcode = nbOrgcode;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	public String getDy_bh() {
		return dy_bh;
	}
	public void setDy_bh(String dy_bh) {
		this.dy_bh = dy_bh;
	}
	private String jzzbljsrq;
	public String getId() {
		return id;
	}
	public void setId(String id) {
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
	public String getJzz_bh() {
		return jzz_bh;
	}
	public void setJzz_bh(String jzz_bh) {
		this.jzz_bh = jzz_bh;
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
	public String getHjd_dzxz() {
		return hjd_dzxz;
	}
	public void setHjd_dzxz(String hjd_dzxz) {
		this.hjd_dzxz = hjd_dzxz;
	}
	public String getJzd_dzxz() {
		return jzd_dzxz;
	}
	public void setJzd_dzxz(String jzd_dzxz) {
		this.jzd_dzxz = jzd_dzxz;
	}
	public String getBl_fjdm() {
		return bl_fjdm;
	}
	public void setBl_fjdm(String bl_fjdm) {
		this.bl_fjdm = bl_fjdm;
	}
	public String getBl_fjmc() {
		return bl_fjmc;
	}
	public void setBl_fjmc(String bl_fjmc) {
		this.bl_fjmc = bl_fjmc;
	}
	public String getBl_pcsdm() {
		return bl_pcsdm;
	}
	public void setBl_pcsdm(String bl_pcsdm) {
		this.bl_pcsdm = bl_pcsdm;
	}
	public String getBl_pcsmc() {
		return bl_pcsmc;
	}
	public void setBl_pcsmc(String bl_pcsmc) {
		this.bl_pcsmc = bl_pcsmc;
	}
	public String getBl_zrqdm() {
		return bl_zrqdm;
	}
	public void setBl_zrqdm(String bl_zrqdm) {
		this.bl_zrqdm = bl_zrqdm;
	}
	public String getBl_zrqmc() {
		return bl_zrqmc;
	}
	public void setBl_zrqmc(String bl_zrqmc) {
		this.bl_zrqmc = bl_zrqmc;
	}
	public String getBlr_id() {
		return blr_id;
	}
	public void setBlr_id(String blr_id) {
		this.blr_id = blr_id;
	}
	public String getBlr_xm() {
		return blr_xm;
	}
	public void setBlr_xm(String blr_xm) {
		this.blr_xm = blr_xm;
	}
	public String getJzzblrq() {
		return jzzblrq;
	}
	public void setJzzblrq(String jzzblrq) {
		this.jzzblrq = jzzblrq;
	}
	public String getJzz_qfrq() {
		return jzz_qfrq;
	}
	public void setJzz_qfrq(String jzz_qfrq) {
		this.jzz_qfrq = jzz_qfrq;
	}
	public String getYxq_jzrq() {
		return yxq_jzrq;
	}
	public void setYxq_jzrq(String yxq_jzrq) {
		this.yxq_jzrq = yxq_jzrq;
	}
	public String getJzz_yxqdm() {
		return jzz_yxqdm;
	}
	public void setJzz_yxqdm(String jzz_yxqdm) {
		this.jzz_yxqdm = jzz_yxqdm;
	}
	public String getJzz_blztdm() {
		return jzz_blztdm;
	}
	public void setJzz_blztdm(String jzz_blztdm) {
		this.jzz_blztdm = jzz_blztdm;
	}
	public String getJzz_lqfsdm() {
		return jzz_lqfsdm;
	}
	public void setJzz_lqfsdm(String jzz_lqfsdm) {
		this.jzz_lqfsdm = jzz_lqfsdm;
	}
	public String getJzz_lqrq() {
		return jzz_lqrq;
	}
	public void setJzz_lqrq(String jzz_lqrq) {
		this.jzz_lqrq = jzz_lqrq;
	}
	public String getJzz_kddz() {
		return jzz_kddz;
	}
	public void setJzz_kddz(String jzz_kddz) {
		this.jzz_kddz = jzz_kddz;
	}
	public String getJzz_kdsjr() {
		return jzz_kdsjr;
	}
	public void setJzz_kdsjr(String jzz_kdsjr) {
		this.jzz_kdsjr = jzz_kdsjr;
	}
	public String getJzz_kdlxdh() {
		return jzz_kdlxdh;
	}
	public void setJzz_kdlxdh(String jzz_kdlxdh) {
		this.jzz_kdlxdh = jzz_kdlxdh;
	}
	public String getJzz_kdgs() {
		return jzz_kdgs;
	}
	public void setJzz_kdgs(String jzz_kdgs) {
		this.jzz_kdgs = jzz_kdgs;
	}
	public String getJzz_kddh() {
		return jzz_kddh;
	}
	public void setJzz_kddh(String jzz_kddh) {
		this.jzz_kddh = jzz_kddh;
	}
	public String getZzr_xm() {
		return zzr_xm;
	}
	public void setZzr_xm(String zzr_xm) {
		this.zzr_xm = zzr_xm;
	}
	public String getZzr_id() {
		return zzr_id;
	}
	public void setZzr_id(String zzr_id) {
		this.zzr_id = zzr_id;
	}
	public String getJzzbljsrq() {
		return jzzbljsrq;
	}
	public void setJzzbljsrq(String jzzbljsrq) {
		this.jzzbljsrq = jzzbljsrq;
	}
	
	
	
	
}
