package com.founder.sydw_dl.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;
@DBInfoAnnotation(tableName = "DW_YHFLCXXB", pk = "id")
public class Dwyhflcxxb extends BaseEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@FieldDesc("ID")
	private String id;
	@FieldDesc("单位ID")
	private String dwid;
	@FieldDesc("分理处名称")
	private String flcmc;
	@FieldDesc("地址-经营地址代码")
	private String dz_jydzdm;
	@FieldDesc("地址-经营地址行政区划代码")
	private String dz_jydzxzqhdm;
	@FieldDesc("地址-经营地址详址")
	private String dz_jydzxz;
	@FieldDesc("分理处联系电话")
	private String flclxdh;
	@FieldDesc("负责人ID")
	private String fzrid;
	@FieldDesc("负责人常用证件代码")
	private String fzrcyzjdm;
	@FieldDesc("负责人证件号码")
	private String fzrzjhm;
	@FieldDesc("负责人")
	private String fzr;
	@FieldDesc("负责人职务")
	private String fzrzw;
	@FieldDesc("负责人联系电话")
	private String fzrlxdh;
	public String getFzrid() {
		return fzrid;
	}
	public void setFzrid(String fzrid) {
		this.fzrid = fzrid;
	}
	public String getFzrzjhm() {
		return fzrzjhm;
	}
	public void setFzrzjhm(String fzrzjhm) {
		this.fzrzjhm = fzrzjhm;
	}
	public String getFzr() {
		return fzr;
	}
	public void setFzr(String fzr) {
		this.fzr = fzr;
	}
	public String getFzrzw() {
		return fzrzw;
	}
	public void setFzrzw(String fzrzw) {
		this.fzrzw = fzrzw;
	}
	public String getFzrlxdh() {
		return fzrlxdh;
	}
	public void setFzrlxdh(String fzrlxdh) {
		this.fzrlxdh = fzrlxdh;
	}
	@FieldDesc("主营")
	private String zy;
	@FieldDesc("副营")
	private String fy;
	@FieldDesc("备注")
	private String bz;
	@FieldDesc("地址-经营地址门楼牌代码")
	private String dz_jydzmlpdm;
	@FieldDesc("地址-经营地址门楼牌详址")
	private String dz_jydzmlpxz;
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
	public String getFlcmc() {
		return flcmc;
	}
	public void setFlcmc(String flcmc) {
		this.flcmc = flcmc;
	}
	public String getDz_jydzdm() {
		return dz_jydzdm;
	}
	public void setDz_jydzdm(String dz_jydzdm) {
		this.dz_jydzdm = dz_jydzdm;
	}
	public String getDz_jydzxzqhdm() {
		return dz_jydzxzqhdm;
	}
	public void setDz_jydzxzqhdm(String dz_jydzxzqhdm) {
		this.dz_jydzxzqhdm = dz_jydzxzqhdm;
	}
	public String getDz_jydzxz() {
		return dz_jydzxz;
	}
	public void setDz_jydzxz(String dz_jydzxz) {
		this.dz_jydzxz = dz_jydzxz;
	}
	public String getFlclxdh() {
		return flclxdh;
	}
	public void setFlclxdh(String flclxdh) {
		this.flclxdh = flclxdh;
	}
	
	public String getFzrcyzjdm() {
		return fzrcyzjdm;
	}
	public void setFzrcyzjdm(String fzrcyzjdm) {
		this.fzrcyzjdm = fzrcyzjdm;
	}
	public String getZy() {
		return zy;
	}
	public void setZy(String zy) {
		this.zy = zy;
	}
	public String getFy() {
		return fy;
	}
	public void setFy(String fy) {
		this.fy = fy;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	public String getDz_jydzmlpdm() {
		return dz_jydzmlpdm;
	}
	public void setDz_jydzmlpdm(String dz_jydzmlpdm) {
		this.dz_jydzmlpdm = dz_jydzmlpdm;
	}
	public String getDz_jydzmlpxz() {
		return dz_jydzmlpxz;
	}
	public void setDz_jydzmlpxz(String dz_jydzmlpxz) {
		this.dz_jydzmlpxz = dz_jydzmlpxz;
	}
	
	
	

}
