package com.founder.zafffwqz.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;


@DBInfoAnnotation(tableName = "ZAFF_GZJSXXB", pk = "id")
public class Gzjsxxb  extends BaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@FieldDesc("工作纪实ID")
	private String id;
	@FieldDesc("社区ID")
	private String sqid;
	@FieldDesc("社区警务室ID")
	private String sqjwsid;
	@FieldDesc("工作纪实种类代码")
	private String gzjszldm;
	@FieldDesc("工作纪实汇报时间")
	private String gzjshbsj;
	@FieldDesc("工作纪实汇报地点")
	private String gzjshbdd;
	@FieldDesc("工作纪实内容")
	private String gzjsnr;
	@FieldDesc("备注")
	private String bz;
	@FieldDesc("工作纪实简要描述 (全文检索使用)    限100字")
	private String gzjsjyms;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSqid() {
		return sqid;
	}
	public void setSqid(String sqid) {
		this.sqid = sqid;
	}
	public String getSqjwsid() {
		return sqjwsid;
	}
	public void setSqjwsid(String sqjwsid) {
		this.sqjwsid = sqjwsid;
	}
	public String getGzjszldm() {
		return gzjszldm;
	}
	public void setGzjszldm(String gzjszldm) {
		this.gzjszldm = gzjszldm;
	}
	public String getGzjshbsj() {
		return gzjshbsj;
	}
	public void setGzjshbsj(String gzjshbsj) {
		this.gzjshbsj = gzjshbsj;
	}
	public String getGzjshbdd() {
		return gzjshbdd;
	}
	public void setGzjshbdd(String gzjshbdd) {
		this.gzjshbdd = gzjshbdd;
	}
	public String getGzjsnr() {
		return gzjsnr;
	}
	public void setGzjsnr(String gzjsnr) {
		this.gzjsnr = gzjsnr;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	public String getGzjsjyms() {
		return gzjsjyms;
	}
	public void setGzjsjyms(String gzjsjyms) {
		this.gzjsjyms = gzjsjyms;
	}
	
}
