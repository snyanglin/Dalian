package com.founder.sydw_dl.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;
@DBInfoAnnotation(tableName = "DW_JZDWXXB", pk = "id")
public class Jzdwxxb extends BaseEntity implements Serializable {

	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 */
	private static final long serialVersionUID = 1L;
	
	@FieldDesc("主键")
	private String id;
	@FieldDesc("单位id")
	private String dwid;
	@FieldDesc("数据录入人员姓名")
	private String sjlrryxm;
	@FieldDesc("数据录入人员电话")
	private String sjlrrydh;
	@FieldDesc("业务量")
	private String ywl;
	@FieldDesc("业务量单位")
	private String ywldw;
	@FieldDesc("派送范围")
	private String psfw;
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
	public String getSjlrryxm() {
		return sjlrryxm;
	}
	public void setSjlrryxm(String sjlrryxm) {
		this.sjlrryxm = sjlrryxm;
	}
	public String getSjlrrydh() {
		return sjlrrydh;
	}
	public void setSjlrrydh(String sjlrrydh) {
		this.sjlrrydh = sjlrrydh;
	}
	public String getYwl() {
		return ywl;
	}
	public void setYwl(String ywl) {
		this.ywl = ywl;
	}
	public String getYwldw() {
		return ywldw;
	}
	public void setYwldw(String ywldw) {
		this.ywldw = ywldw;
	}
	public String getPsfw() {
		return psfw;
	}
	public void setPsfw(String psfw) {
		this.psfw = psfw;
	}

	
	
}
