package com.founder.zdrygl.base.model;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;
import com.founder.zdrygl.core.model.Zdry;

/**
 * ****************************************************************************
 * @Package:      [com.founder.zdrygl.base.model.ZdryZdryzb.java]  
 * @ClassName:    [ZdryZdryzb]   
 * @Description:  [重点人员总表]   
 * @Author:       [zhang.hai@founder.com.cn]  
 * @CreateDate:   [2015年9月22日 下午2:24:21]   
 * @UpdateUser:   [ZhangHai(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015年9月22日 下午2:24:21，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@DBInfoAnnotation(tableName = "ZDRY_ZDRYZB", pk = "id")
public class ZdryZb extends BaseEntity implements Serializable, Zdry{
	private static final long serialVersionUID = 1L;
	
	@FieldDesc("证件种类") private String cyzjdm;
	@FieldDesc("证件号码") private String zjhm;
	@FieldDesc("姓名") private String xm;
	@FieldDesc("性别代码") private String xbdm;
	@FieldDesc("民族代码") private String mzdm;
	@FieldDesc("出生日期") private String csrq;
	@FieldDesc("籍贯省市县代码") private String jgssxdm;
	@FieldDesc("户籍地_行政区划代码") private String hjd_xzqhdm;
	@FieldDesc("户籍地_门楼牌代码") private String hjd_mlpdm;
	@FieldDesc("户籍地_门楼牌详址") private String hjd_mlpxz;
	@FieldDesc("户籍地_地址ID") private String hjd_dzid;
	@FieldDesc("户籍地_地址详址") private String hjd_dzxz;
	@FieldDesc("居住地_行政区划代码") private String jzd_xzqhdm;
	@FieldDesc("居住地_门楼牌代码") private String jzd_mlpdm;
	@FieldDesc("居住地_门楼牌详址") private String jzd_mlpxz;
	@FieldDesc("居住地_地址ID") private String jzd_dzid;
	@FieldDesc("居住地_地址详址") private String jzd_dzxz;
	@FieldDesc("居住地_坐标X") private String jzd_zbx;
	@FieldDesc("居住地_坐标Y") private String jzd_zby;
	@FieldDesc("管辖分局代码") private String gxfjdm;
	@FieldDesc("管辖派出所代码") private String gxpcsdm;
	@FieldDesc("管辖责任区代码") private String gxzrqdm;
	@FieldDesc("备注") private String bz;
	@FieldDesc("采集时间") private String xt_cjsj;
	@FieldDesc("录入时间") private String xt_lrsj;
	@FieldDesc("录入人姓名") private String xt_lrrxm;
	@FieldDesc("录入人ID") private String xt_lrrid;
	@FieldDesc("录入人部门") private String xt_lrrbm;
	@FieldDesc("录入人部门ID") private String xt_lrrbmid;
	@FieldDesc("录入IP") private String xt_lrip;
	@FieldDesc("最后修改时间") private String xt_zhxgsj;
	@FieldDesc("最后修改人姓名") private String xt_zhxgrxm;
	@FieldDesc("最后修改人ID") private String xt_zhxgrid;
	@FieldDesc("最后修改人部门") private String xt_zhxgrbm;
	@FieldDesc("最后修改人部门ID") private String xt_zhxgrbmid;
	@FieldDesc("最后修改IP") private String xt_zhxgip;
	@FieldDesc("注销标志") private String xt_zxbz;
	@FieldDesc("注销原因") private String xt_zxyy;
	@FieldDesc("重点人员ID") private String id;
	@FieldDesc("人员ID") private String ryid;
	@FieldDesc("重点人员类别") private String zdrylb;
	@FieldDesc("实有人口总表ID") private String syrkid;
	@FieldDesc("重点人员管理类型代码") private String zdrygllxdm;
	@FieldDesc("管理状态") private String glzt;
	@FieldDesc("主要问题及现实表现") private String zywtjxsbx;
	@FieldDesc("管理部门") private String glbm;
	@FieldDesc("查询部门") private String cxbm;
	
	
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
	public String getJgssxdm() {
		return jgssxdm;
	}
	public void setJgssxdm(String jgssxdm) {
		this.jgssxdm = jgssxdm;
	}
	public String getHjd_xzqhdm() {
		return hjd_xzqhdm;
	}
	public void setHjd_xzqhdm(String hjd_xzqhdm) {
		this.hjd_xzqhdm = hjd_xzqhdm;
	}
	public String getHjd_mlpdm() {
		return hjd_mlpdm;
	}
	public void setHjd_mlpdm(String hjd_mlpdm) {
		this.hjd_mlpdm = hjd_mlpdm;
	}
	public String getHjd_mlpxz() {
		return hjd_mlpxz;
	}
	public void setHjd_mlpxz(String hjd_mlpxz) {
		this.hjd_mlpxz = hjd_mlpxz;
	}
	public String getHjd_dzid() {
		return hjd_dzid;
	}
	public void setHjd_dzid(String hjd_dzid) {
		this.hjd_dzid = hjd_dzid;
	}
	public String getHjd_dzxz() {
		return hjd_dzxz;
	}
	public void setHjd_dzxz(String hjd_dzxz) {
		this.hjd_dzxz = hjd_dzxz;
	}
	public String getJzd_xzqhdm() {
		return jzd_xzqhdm;
	}
	public void setJzd_xzqhdm(String jzd_xzqhdm) {
		this.jzd_xzqhdm = jzd_xzqhdm;
	}
	public String getJzd_mlpdm() {
		return jzd_mlpdm;
	}
	public void setJzd_mlpdm(String jzd_mlpdm) {
		this.jzd_mlpdm = jzd_mlpdm;
	}
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
	public String getJzd_dzxz() {
		return jzd_dzxz;
	}
	public void setJzd_dzxz(String jzd_dzxz) {
		this.jzd_dzxz = jzd_dzxz;
	}
	public String getJzd_zbx() {
		return jzd_zbx;
	}
	public void setJzd_zbx(String jzd_zbx) {
		this.jzd_zbx = jzd_zbx;
	}
	public String getJzd_zby() {
		return jzd_zby;
	}
	public void setJzd_zby(String jzd_zby) {
		this.jzd_zby = jzd_zby;
	}
	public String getGxfjdm() {
		return gxfjdm;
	}
	public void setGxfjdm(String gxfjdm) {
		this.gxfjdm = gxfjdm;
	}
	public String getGxpcsdm() {
		return gxpcsdm;
	}
	public void setGxpcsdm(String gxpcsdm) {
		this.gxpcsdm = gxpcsdm;
	}
	public String getGxzrqdm() {
		return gxzrqdm;
	}
	public void setGxzrqdm(String gxzrqdm) {
		this.gxzrqdm = gxzrqdm;
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
	public String getZdrylb() {
		return zdrylb;
	}
	public void setZdrylb(String zdrylb) {
		this.zdrylb = zdrylb;
	}
	public String getSyrkid() {
		return syrkid;
	}
	public void setSyrkid(String syrkid) {
		this.syrkid = syrkid;
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
	public String getZywtjxsbx() {
		return zywtjxsbx;
	}
	public void setZywtjxsbx(String zywtjxsbx) {
		this.zywtjxsbx = zywtjxsbx;
	}
	public String getGlbm() {
		return glbm;
	}
	public void setGlbm(String glbm) {
		this.glbm = glbm;
	}
	public String getCxbm() {
		return cxbm;
	}
	public void setCxbm(String cxbm) {
		this.cxbm = cxbm;
	}

	
}
