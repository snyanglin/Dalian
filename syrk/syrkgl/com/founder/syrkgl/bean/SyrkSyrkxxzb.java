package com.founder.syrkgl.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

/******************************************************************************
 * @Package: [com.founder.syrkgl.bean.SyrkSyrkxxzb.java]
 * @ClassName: [SyrkSyrkxxzb]
 * @Description: [实有人口信息总表]
 * @Author: [hongguanjun]
 * @CreateDate: [2015-4-2 下午3:04:52]
 * @UpdateUser: [hongguanjun(如多次修改保留历史记录，增加修改记录)]
 * @UpdateDate: [2015-4-2 下午3:04:52，(如多次修改保留历史记录，增加修改记录)]
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]
 * @Version: [v1.0]
 */
@DBInfoAnnotation(tableName = "SYRK_SYRKXXZB", pk = "id")
public class SyrkSyrkxxzb extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	//gem
	private String age;
	
	@FieldDesc("实有人口ID")
	private String id;
	@FieldDesc("人员ID")
	private String ryid;
	@FieldDesc("实有人口业务类型代码")
	private String syrkywlxdm;
	@FieldDesc("证件种类")
	private String cyzjdm;
	@FieldDesc("证件号码")
	private String zjhm;
	@FieldDesc("姓名")
	private String xm;
	@FieldDesc("外文姓")
	private String wwx;
	@FieldDesc("外文名")
	private String wwm;
	@FieldDesc("性别代码")
	private String xbdm;
	@FieldDesc("民族代码")
	private String mzdm;
	@FieldDesc("出生日期")
	private String csrq;
	@FieldDesc("籍贯省市县代码")
	private String jgssxdm;
	@FieldDesc("户籍地_行政区划代码")
	private String hjd_xzqhdm;
	@FieldDesc("户籍地_门楼牌代码")
	private String hjd_mlpdm;
	@FieldDesc("户籍地_门楼牌详址")
	private String hjd_mlpxz;
	@FieldDesc("户籍地_地址ID")
	private String hjd_dzid;
	@FieldDesc("户籍地_地址详址")
	private String hjd_dzxz;
	@FieldDesc("居住地_行政区划代码")
	private String jzd_xzqhdm;
	@FieldDesc("居住地_门楼牌代码")
	private String jzd_mlpdm;
	@FieldDesc("居住地_门楼牌详址")
	private String jzd_mlpxz;
	@FieldDesc("居住地_地址ID")
	private String jzd_dzid;
	@FieldDesc("居住地_地址详址")
	private String jzd_dzxz;
	@FieldDesc("居住地_坐标X")
	private String jzd_zbx;
	@FieldDesc("居住地_坐标Y")
	private String jzd_zby;
	@FieldDesc("管辖分局代码")
	private String gxfjdm;
	@FieldDesc("管辖派出所代码")
	private String gxpcsdm;
	@FieldDesc("管辖责任区代码")
	private String gxzrqdm;
	@FieldDesc("管辖责任区名称")
	private String gxzrqmc;
	
	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	// 搜索查询关键字
	private String searchbox;
	// 空间查询坐标值
	private String drawZbz;
	// 空间查询类型
	// drawCircle 设置当前地图操作状态为绘制圆形状态
	// drawRect 设置当前地图操作状态为绘制矩形状态
	// drawPolygon 设置当前地图操作状态为绘制多边形状态
	private String drawType;
	// 空间查询半径弧度值
	private String drawRadius;
	// 地图图层ID
	private int drawSrid;

	public String getDrawRadius() {
		return drawRadius;
	}

	public void setDrawRadius(String drawRadius) {
		this.drawRadius = drawRadius;
	}

	public int getDrawSrid() {
		return drawSrid;
	}

	public void setDrawSrid(int drawSrid) {
		this.drawSrid = drawSrid;
	}

	public String getDrawZbz() {
		return drawZbz;
	}

	public void setDrawZbz(String drawZbz) {
		this.drawZbz = drawZbz;
	}

	public String getDrawType() {
		return drawType;
	}

	public void setDrawType(String drawType) {
		this.drawType = drawType;
	}

	public String getSearchbox() {
		return searchbox;
	}

	public void setSearchbox(String searchbox) {
		this.searchbox = searchbox;
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

	public String getSyrkywlxdm() {
		return syrkywlxdm;
	}

	public void setSyrkywlxdm(String syrkywlxdm) {
		this.syrkywlxdm = syrkywlxdm;
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

	public String getGxzrqmc() {
		return gxzrqmc;
	}

	public void setGxzrqmc(String gxzrqmc) {
		this.gxzrqmc = gxzrqmc;
	}
	
}
