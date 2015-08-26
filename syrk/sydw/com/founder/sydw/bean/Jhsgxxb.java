package com.founder.sydw.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;
@DBInfoAnnotation(tableName = "DW_JHSGXXB", pk = "id")
public class Jhsgxxb  extends  BaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@FieldDesc("ID")
	private String id;
	@FieldDesc("单位ID")
	private String dwid;
	@FieldDesc("申请报告号")
	private String sqbgh;
	@FieldDesc("资信证明")
	private String zxzm;
	@FieldDesc("经营场所使用证明")
	private String jycssyzm;
	@FieldDesc("备注")
	private String bz;
		
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
	public String getSqbgh() {
		return sqbgh;
	}
	public void setSqbgh(String sqbgh) {
		this.sqbgh = sqbgh;
	}
	public String getZxzm() {
		return zxzm;
	}
	public void setZxzm(String zxzm) {
		this.zxzm = zxzm;
	}
	public String getJycssyzm() {
		return jycssyzm;
	}
	public void setJycssyzm(String jycssyzm) {
		this.jycssyzm = jycssyzm;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	
	

}
