package com.founder.syrkgl.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

/**
 * @类名: RyJwryrczfb
 * @描述: 境外人员日常走访表
 * @作者: zhang_guoliang@founder.com
 * @日期: 2015-6-26 上午9:22:36
 */
@DBInfoAnnotation(tableName = "RY_JWRYRCZFB", pk = "id")
public class RyJwryrczfb extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 4286467121387632358L;
	@FieldDesc("ID")
	private String id;
	@FieldDesc("人员ID")
	private String ryid;
	@FieldDesc("证件种类")
	private String cyzjdm;
	@FieldDesc("证件号码")
	private String zjhm;
	@FieldDesc("外文姓")
	private String wwx;
	@FieldDesc("外文名")
	private String wwm;
	@FieldDesc("中文姓名")
	private String xm;
	@FieldDesc("居住地_管辖单位代码")
	private String jzd_gxdwdm;
	@FieldDesc("居住地_管辖单位名称")
	private String jzd_gxdwmc;
	@FieldDesc("工作地_管辖单位代码")
	private String gzd_gxdwdm;
	@FieldDesc("工作地_管辖单位名称")
	private String gzd_gxdwmc;
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
	@FieldDesc("数据状态(0未核实、1已核实)")
	private String zt;
	@FieldDesc("走访结果")
	private String zfjg;
	@FieldDesc("走访时间")
	private String zfsj;
	@FieldDesc("走访人")
	private String zfr;
	@FieldDesc("走访人ID")
	private String zfrid;
	@FieldDesc("走访单位")
	private String zfdw;
	@FieldDesc("走访单位ID")
	private String zfdwid;
	// 责任区代码
	private String zrqdm;
	// 派出所代码
	private String pcsdm;
	// 分县局代码
	private String fxjdm;

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

	public String getWwx() {
		return wwx;
	}

	public void setWwx(String wwx) {
		this.wwx = wwx;
	}

	public String getWwm() {
		return wwm;
	}

	public void setWwm(String wwm) {
		this.wwm = wwm;
	}

	public String getXm() {
		return xm;
	}

	public void setXm(String xm) {
		this.xm = xm;
	}

	public String getJzd_gxdwdm() {
		return jzd_gxdwdm;
	}

	public void setJzd_gxdwdm(String jzd_gxdwdm) {
		this.jzd_gxdwdm = jzd_gxdwdm;
	}

	public String getJzd_gxdwmc() {
		return jzd_gxdwmc;
	}

	public void setJzd_gxdwmc(String jzd_gxdwmc) {
		this.jzd_gxdwmc = jzd_gxdwmc;
	}

	public String getGzd_gxdwdm() {
		return gzd_gxdwdm;
	}

	public void setGzd_gxdwdm(String gzd_gxdwdm) {
		this.gzd_gxdwdm = gzd_gxdwdm;
	}

	public String getGzd_gxdwmc() {
		return gzd_gxdwmc;
	}

	public void setGzd_gxdwmc(String gzd_gxdwmc) {
		this.gzd_gxdwmc = gzd_gxdwmc;
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

	public String getZt() {
		return zt;
	}

	public void setZt(String zt) {
		this.zt = zt;
	}

	public String getZfjg() {
		return zfjg;
	}

	public void setZfjg(String zfjg) {
		this.zfjg = zfjg;
	}

	public String getZfsj() {
		return zfsj;
	}

	public void setZfsj(String zfsj) {
		this.zfsj = zfsj;
	}

	public String getZfr() {
		return zfr;
	}

	public void setZfr(String zfr) {
		this.zfr = zfr;
	}

	public String getZfrid() {
		return zfrid;
	}

	public void setZfrid(String zfrid) {
		this.zfrid = zfrid;
	}

	public String getZfdw() {
		return zfdw;
	}

	public void setZfdw(String zfdw) {
		this.zfdw = zfdw;
	}

	public String getZfdwid() {
		return zfdwid;
	}

	public void setZfdwid(String zfdwid) {
		this.zfdwid = zfdwid;
	}

	public String getZrqdm() {
		return zrqdm;
	}

	public void setZrqdm(String zrqdm) {
		this.zrqdm = zrqdm;
	}

	public String getPcsdm() {
		return pcsdm;
	}

	public void setPcsdm(String pcsdm) {
		this.pcsdm = pcsdm;
	}

	public String getFxjdm() {
		return fxjdm;
	}

	public void setFxjdm(String fxjdm) {
		this.fxjdm = fxjdm;
	}
}
