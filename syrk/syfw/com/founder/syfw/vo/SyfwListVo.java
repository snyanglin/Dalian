package com.founder.syfw.vo;

import com.founder.framework.base.entity.BaseEntity;

public class SyfwListVo extends BaseEntity {
 
	private String id;
	private String fwlbdm;
	private String sfczfw;
	private String fwdz_dzxz;
	private String ss4jbmdm;
	private String fwytdm;
	
	private String fz_zjhm;
	private String fz_xm;
	private String tgr_zjhm;
	private String tgr_xm;
	private String fwssdw_dwmc;
	private String fwdz_zbx;
	private String fwdz_zby;
	//地图查询的相关字段
	private String zbx;
	private String zby;
	private String mapRadius;
	private String zbz;
	//空间查询坐标值
    private String drawZbz;
	//空间查询类型
    //   drawCircle  设置当前地图操作状态为绘制圆形状态
    //	 drawRect    设置当前地图操作状态为绘制矩形状态
    //   drawPolygon 设置当前地图操作状态为绘制多边形状态
	private String drawType;
	//空间查询半径弧度值
    private String drawRadius;
	//地图图层ID
	private int drawSrid;
	//标准地址表的一些信息
	private String sfcj;
	private String dzqc;
	private String dzqcpy;
	private String jzwid;
	private String bzdzid;
	private String condition;
	
	
	public String getFwytdm() {
		return fwytdm;
	}
	public void setFwytdm(String fwytdm) {
		this.fwytdm = fwytdm;
	}
	public String getFz_zjhm() {
		return fz_zjhm;
	}
	public void setFz_zjhm(String fz_zjhm) {
		this.fz_zjhm = fz_zjhm;
	}
	public String getTgr_zjhm() {
		return tgr_zjhm;
	}
	public void setTgr_zjhm(String tgr_zjhm) {
		this.tgr_zjhm = tgr_zjhm;
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
	public String getTgr_xm() {
		return tgr_xm;
	}
	public void setTgr_xm(String tgr_xm) {
		this.tgr_xm = tgr_xm;
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
	public String getFz_xm() {
		return fz_xm;
	}
	public void setFz_xm(String fz_xm) {
		this.fz_xm = fz_xm;
	}
	public String getSfczfw() {
		return sfczfw;
	}
	public void setSfczfw(String sfczfw) {
		this.sfczfw = sfczfw;
	}
	
	public String getFwdz_dzxz() {
		return fwdz_dzxz;
	}
	public void setFwdz_dzxz(String fwdz_dzxz) {
		this.fwdz_dzxz = fwdz_dzxz;
	}
	public String getSs4jbmdm() {
		return ss4jbmdm;
	}
	public void setSs4jbmdm(String ss4jbmdm) {
		this.ss4jbmdm = ss4jbmdm;
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
	public String getSfcj() {
		return sfcj;
	}
	public void setSfcj(String sfcj) {
		this.sfcj = sfcj;
	}
	public String getDzqc() {
		return dzqc;
	}
	public void setDzqc(String dzqc) {
		this.dzqc = dzqc;
	}
	public String getDzqcpy() {
		return dzqcpy;
	}
	public void setDzqcpy(String dzqcpy) {
		this.dzqcpy = dzqcpy;
	}
	public String getJzwid() {
		return jzwid;
	}
	public void setJzwid(String jzwid) {
		this.jzwid = jzwid;
	}
	public String getBzdzid() {
		return bzdzid;
	}
	public void setBzdzid(String bzdzid) {
		this.bzdzid = bzdzid;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	
}
