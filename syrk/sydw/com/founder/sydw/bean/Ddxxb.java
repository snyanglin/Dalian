package com.founder.sydw.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

@DBInfoAnnotation(tableName = "DW_DDXXB", pk = "id")
public class Ddxxb extends BaseEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@FieldDesc("典当ID")
	private String id;
	@FieldDesc("单位ID")
	private String dwid;
	@FieldDesc("经营许可证号")
	private String jyxkzh;
	@FieldDesc("设立申请书编号")
	private String slsqsbh;
	@FieldDesc("资信证明号")
	private String zxzmh;
	@FieldDesc("有无分支机构代码")
	private String ywfzjgdm;
	@FieldDesc("有无收当国家统收代码")
	private String ywsdgjtsdm;
	@FieldDesc("专营")
	private String zy;
	@FieldDesc("专卖物品权")
	private String zmwpq;
	@FieldDesc("典当_建筑物结构类型代码")
	private String dd_jzwjglxdm;
	@FieldDesc("备注")
	private String bz;
	
	
	
	
	
	/**
	 * @return the dd_jzwjglxdm
	 */
	public String getDd_jzwjglxdm() {
		return dd_jzwjglxdm;
	}
	/**
	 * @param ddJzwjglxdm the dd_jzwjglxdm to set
	 */
	public void setDd_jzwjglxdm(String ddJzwjglxdm) {
		dd_jzwjglxdm = ddJzwjglxdm;
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
	public String getJyxkzh() {
		return jyxkzh;
	}
	public void setJyxkzh(String jyxkzh) {
		this.jyxkzh = jyxkzh;
	}
	public String getSlsqsbh() {
		return slsqsbh;
	}
	public void setSlsqsbh(String slsqsbh) {
		this.slsqsbh = slsqsbh;
	}
	public String getZxzmh() {
		return zxzmh;
	}
	public void setZxzmh(String zxzmh) {
		this.zxzmh = zxzmh;
	}
	public String getYwfzjgdm() {
		return ywfzjgdm;
	}
	public void setYwfzjgdm(String ywfzjgdm) {
		this.ywfzjgdm = ywfzjgdm;
	}
	public String getYwsdgjtsdm() {
		return ywsdgjtsdm;
	}
	public void setYwsdgjtsdm(String ywsdgjtsdm) {
		this.ywsdgjtsdm = ywsdgjtsdm;
	}
	public String getZy() {
		return zy;
	}
	public void setZy(String zy) {
		this.zy = zy;
	}
	public String getZmwpq() {
		return zmwpq;
	}
	public void setZmwpq(String zmwpq) {
		this.zmwpq = zmwpq;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}

}
