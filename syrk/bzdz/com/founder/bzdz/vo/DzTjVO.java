package com.founder.bzdz.vo;
import java.io.Serializable;
/**
 * @类名: DzTjVO 
 * @描述: 地址统计VO
 * @作者: zhang_guoliang@founder.com 
 * @日期: 2015-5-12 下午4:25:16 
 */
public class DzTjVO implements Serializable{
	private static final long serialVersionUID = -8201716579172654113L;
	private String orgcode;
	private String orgname;
	private String orglevel;
	private String gxzrq;
	private String gxpcs;
	private String gxsxj;
	private String redio;
	private String kssj;
	private String jssj;
	private String xjdz;
	private String zxdz;
	private String yxdz;
	private String order;
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	public String getKssj() {
		return kssj;
	}
	public void setKssj(String kssj) {
		this.kssj = kssj;
	}
	public String getJssj() {
		return jssj;
	}
	public void setJssj(String jssj) {
		this.jssj = jssj;
	}
	public String getOrgname() {
		return orgname;
	}
	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}
	public String getOrgcode() {
		return orgcode;
	}
	public void setOrgcode(String orgcode) {
		this.orgcode = orgcode;
	}
	public String getOrglevel() {
		return orglevel;
	}
	public void setOrglevel(String orglevel) {
		this.orglevel = orglevel;
	}
	public String getGxzrq() {
		return gxzrq;
	}
	public void setGxzrq(String gxzrq) {
		this.gxzrq = gxzrq;
	}
	public String getGxpcs() {
		return gxpcs;
	}
	public void setGxpcs(String gxpcs) {
		this.gxpcs = gxpcs;
	}
	public String getGxsxj() {
		return gxsxj;
	}
	public void setGxsxj(String gxsxj) {
		this.gxsxj = gxsxj;
	}
	public String getRedio() {
		return redio;
	}
	public void setRedio(String redio) {
		this.redio = redio;
	}
	public String getXjdz() {
		return xjdz;
	}
	public void setXjdz(String xjdz) {
		this.xjdz = xjdz;
	}
	public String getZxdz() {
		return zxdz;
	}
	public void setZxdz(String zxdz) {
		this.zxdz = zxdz;
	}
	public String getYxdz() {
		return yxdz;
	}
	public void setYxdz(String yxdz) {
		this.yxdz = yxdz;
	}
}