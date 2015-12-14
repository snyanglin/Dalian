package com.founder.bzdz.vo;
import java.io.Serializable;
import com.founder.framework.base.entity.BaseEntity;
/**
 * @类名: DmxxbVO 
 * @描述: 地名信息表VO
 * @作者: zhang_guoliang@founder.com 
 * @日期: 2014-12-10 下午3:36:23 
 */
public class DmxxbVO extends BaseEntity implements Serializable{
	private static final long serialVersionUID = 7842089922401419193L;
	private String dmid;
	private String dmdm;
	private String dmmc;
	private String olddmmc;
	private String dmlx;
	private String dlst;
	private String dmpy;
	private String dmwb;
	private String bz;
	private String xzqhdm;
	private String xzqhmc;
	private String zrqdm;
	private String pcsdm;
	private String fxjdm;
	private String xzqh;
	private String gxdw;
	private DmxxbVO[] dmxzqhbArray;
	private DmxxbVO[] dmzzjgbArray;
	private String dmxzqhid;
	private String dmzzjgid;
	//空间查询VO
	private int objectid;
	private String coords;
	private String name;
	private String pcsmc;
	public int getObjectid() {
		return objectid;
	}
	public void setObjectid(int objectid) {
		this.objectid = objectid;
	}
	public String getCoords() {
		return coords;
	}
	public void setCoords(String coords) {
		this.coords = coords;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPcsmc() {
		return pcsmc;
	}
	public void setPcsmc(String pcsmc) {
		this.pcsmc = pcsmc;
	}
	public String getOlddmmc() {
		return olddmmc;
	}
	public void setOlddmmc(String olddmmc) {
		this.olddmmc = olddmmc;
	}
	public String getXzqhmc() {
		return xzqhmc;
	}
	public void setXzqhmc(String xzqhmc) {
		this.xzqhmc = xzqhmc;
	}
	public String getDmxzqhid() {
		return dmxzqhid;
	}
	public void setDmxzqhid(String dmxzqhid) {
		this.dmxzqhid = dmxzqhid;
	}
	public String getDmzzjgid() {
		return dmzzjgid;
	}
	public void setDmzzjgid(String dmzzjgid) {
		this.dmzzjgid = dmzzjgid;
	}
	public DmxxbVO[] getDmxzqhbArray() {
		return dmxzqhbArray;
	}
	public void setDmxzqhbArray(DmxxbVO[] dmxzqhbArray) {
		this.dmxzqhbArray = dmxzqhbArray;
	}
	public DmxxbVO[] getDmzzjgbArray() {
		return dmzzjgbArray;
	}
	public void setDmzzjgbArray(DmxxbVO[] dmzzjgbArray) {
		this.dmzzjgbArray = dmzzjgbArray;
	}
	public String getXzqh() {
		return xzqh;
	}
	public void setXzqh(String xzqh) {
		this.xzqh = xzqh;
	}
	public String getGxdw() {
		return gxdw;
	}
	public void setGxdw(String gxdw) {
		this.gxdw = gxdw;
	}
	public String getDmid() {
		return dmid;
	}
	public void setDmid(String dmid) {
		this.dmid = dmid;
	}
	public String getDmdm() {
		return dmdm;
	}
	public void setDmdm(String dmdm) {
		this.dmdm = dmdm;
	}
	public String getDmmc() {
		//全文检索需将字母转为大写
		if(dmmc!=null&&!"".equals(dmmc)){
			dmmc = dmmc.toUpperCase();
		}
		return dmmc;
	}
	public void setDmmc(String dmmc) {
		//全文检索需将字母转为大写
		if(dmmc!=null&&!"".equals(dmmc)){
			dmmc = dmmc.toUpperCase();
		}
		this.dmmc = dmmc;
	}
	public String getDmlx() {
		return dmlx;
	}
	public void setDmlx(String dmlx) {
		this.dmlx = dmlx;
	}
	public String getDlst() {
		return dlst;
	}
	public void setDlst(String dlst) {
		this.dlst = dlst;
	}
	public String getDmpy() {
		return dmpy;
	}
	public void setDmpy(String dmpy) {
		this.dmpy = dmpy;
	}
	public String getDmwb() {
		return dmwb;
	}
	public void setDmwb(String dmwb) {
		this.dmwb = dmwb;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	public String getXzqhdm() {
		return xzqhdm;
	}
	public void setXzqhdm(String xzqhdm) {
		this.xzqhdm = xzqhdm;
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