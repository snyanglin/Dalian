package com.founder.service.attachment.bean;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

@DBInfoAnnotation(tableName = "ZPFJ_FJXXB", pk = "id")
public class ZpfjFjxxb extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@FieldDesc("ID")
	private String id;
	@FieldDesc("文件名称")
	private String wjmc;
	@FieldDesc("文件后辍类型")
	private String wjhzlx;
	@FieldDesc("文件")
	private byte[] wj;
	@FieldDesc("文件大小")
	private Long wjdx;
	@FieldDesc("文件大小说明")
	private String wjdxsm;
	@FieldDesc("文件下载次数")
	private Long wjxzcs;
	@FieldDesc("来源描述")
	private String lyms;
	@FieldDesc("来源ID")
	private String lyid;
	@FieldDesc("来源表名")
	private String lybm;
	@FieldDesc("文件描述")
	private String wjms;
	@FieldDesc("备注")
	private String bz;
	private Map<String,String> uploadFile = new HashMap<String,String>();
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getWjmc() {
		return wjmc;
	}

	public void setWjmc(String wjmc) {
		this.wjmc = wjmc;
	}

	public String getWjhzlx() {
		return wjhzlx;
	}

	public void setWjhzlx(String wjhzlx) {
		this.wjhzlx = wjhzlx;
	}

	public byte[] getWj() {
		return wj;
	}

	public void setWj(byte[] wj) {
		this.wj = wj;
	}

	public Long getWjdx() {
		return wjdx;
	}

	public void setWjdx(Long wjdx) {
		this.wjdx = wjdx;
	}

	public String getWjdxsm() {
		return wjdxsm;
	}

	public void setWjdxsm(String wjdxsm) {
		this.wjdxsm = wjdxsm;
	}

	public Long getWjxzcs() {
		return wjxzcs;
	}

	public void setWjxzcs(Long wjxzcs) {
		this.wjxzcs = wjxzcs;
	}

	public String getLyms() {
		return lyms;
	}

	public void setLyms(String lyms) {
		this.lyms = lyms;
	}

	public String getLyid() {
		return lyid;
	}

	public void setLyid(String lyid) {
		this.lyid = lyid;
	}

	public String getLybm() {
		return lybm;
	}

	public void setLybm(String lybm) {
		this.lybm = lybm;
	}

	public String getWjms() {
		return wjms;
	}

	public void setWjms(String wjms) {
		this.wjms = wjms;
	}

	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

	public Map<String, String> getUploadFile() {
		return uploadFile;
	}

	public void setUploadFile(Map<String, String> uploadFile) {
		this.uploadFile = uploadFile;
	}
}
