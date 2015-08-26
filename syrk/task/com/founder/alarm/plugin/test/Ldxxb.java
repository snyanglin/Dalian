package com.founder.alarm.plugin.test;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

@DBInfoAnnotation(tableName = "DW_LDXXB", pk = "id")
public class Ldxxb extends BaseEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@FieldDesc("旅店ID")
	private String id;
	@FieldDesc("单位ID")
	private String dwid;
	@FieldDesc("旅馆编码")
	private String lgbm;
	@FieldDesc("星级")
	private String xj;
	@FieldDesc("栋数")
	private Long ds;
	@FieldDesc("楼层数")
	private Long lcs;
	@FieldDesc("客房数")
	private Long kefs;
	@FieldDesc("床位数")
	private Long cws;
	@FieldDesc("是否涉外代码")
	private String sfswdm;
	@FieldDesc("附属娱乐项目")
	private String fsylxm;
	@FieldDesc("附属服务项目")
	private String fsfwxm;
	@FieldDesc("经营状态代码")
	private String jyztdm;
	@FieldDesc("经营期")
	private String jyq;
	@FieldDesc("库房数")
	private Long kufs;
	@FieldDesc("库房门窗数")
	private Long kfmcs;
	@FieldDesc("库房有无防盗门代码")
	private String kfywfdmdm;
	@FieldDesc("有无人值宿代码")
	private String ywrzsrdm;
	@FieldDesc("更值人口数")
	private Long gzrs;
	@FieldDesc("有无电子监控设备代码")
	private String ywdzjksbdm;
	@FieldDesc("有无闭路电视监控设备代码")
	private String ywbldsjksb;
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
	public String getLgbm() {
		return lgbm;
	}
	public void setLgbm(String lgbm) {
		this.lgbm = lgbm;
	}
	public String getXj() {
		return xj;
	}
	public void setXj(String xj) {
		this.xj = xj;
	}
	public Long getDs() {
		return ds;
	}
	public void setDs(Long ds) {
		this.ds = ds;
	}
	public Long getLcs() {
		return lcs;
	}
	public void setLcs(Long lcs) {
		this.lcs = lcs;
	}
	public Long getKefs() {
		return kefs;
	}
	public void setKefs(Long kefs) {
		this.kefs = kefs;
	}
	public Long getCws() {
		return cws;
	}
	public void setCws(Long cws) {
		this.cws = cws;
	}
	public String getSfswdm() {
		return sfswdm;
	}
	public void setSfswdm(String sfswdm) {
		this.sfswdm = sfswdm;
	}
	public String getFsylxm() {
		return fsylxm;
	}
	public void setFsylxm(String fsylxm) {
		this.fsylxm = fsylxm;
	}
	public String getFsfwxm() {
		return fsfwxm;
	}
	public void setFsfwxm(String fsfwxm) {
		this.fsfwxm = fsfwxm;
	}
	public String getJyztdm() {
		return jyztdm;
	}
	public void setJyztdm(String jyztdm) {
		this.jyztdm = jyztdm;
	}
	public String getJyq() {
		return jyq;
	}
	public void setJyq(String jyq) {
		this.jyq = jyq;
	}
	public Long getKufs() {
		return kufs;
	}
	public void setKufs(Long kufs) {
		this.kufs = kufs;
	}
	public Long getKfmcs() {
		return kfmcs;
	}
	public void setKfmcs(Long kfmcs) {
		this.kfmcs = kfmcs;
	}
	public String getKfywfdmdm() {
		return kfywfdmdm;
	}
	public void setKfywfdmdm(String kfywfdmdm) {
		this.kfywfdmdm = kfywfdmdm;
	}
	public String getYwrzsrdm() {
		return ywrzsrdm;
	}
	public void setYwrzsrdm(String ywrzsrdm) {
		this.ywrzsrdm = ywrzsrdm;
	}
	public Long getGzrs() {
		return gzrs;
	}
	public void setGzrs(Long gzrs) {
		this.gzrs = gzrs;
	}
	public String getYwdzjksbdm() {
		return ywdzjksbdm;
	}
	public void setYwdzjksbdm(String ywdzjksbdm) {
		this.ywdzjksbdm = ywdzjksbdm;
	}
	public String getYwbldsjksb() {
		return ywbldsjksb;
	}
	public void setYwbldsjksb(String ywbldsjksb) {
		this.ywbldsjksb = ywbldsjksb;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}

}
