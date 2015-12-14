package com.founder.sydw_dl.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;
@DBInfoAnnotation(tableName = "DW_ZYBWXXB", pk = "id")
public class DwzybwXxb extends BaseEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@FieldDesc("ID")
	private String id;
	@FieldDesc("单位ID")
	private String dwid;
	@FieldDesc("部位名称")
	private String zybwmc;
	@FieldDesc("部位位置")
	private String zybwwz;
	@FieldDesc("值班电话")
	private String zbdh;
	@FieldDesc("物防设施情况")
	private String wfssqk;
	@FieldDesc("技防设施情况")
	private String jfssqk;
	@FieldDesc("确定时间")
	private String qdsj;
	@FieldDesc("确定理由依据")
	private String qdlyyj;
	@FieldDesc("重要部位描述")
	private String zybwms;
	@FieldDesc("负责人员ID")
	private String fzr_ryid;
	@FieldDesc("负责人常用证件代码")
	private String fzr_cyzjdm;
	@FieldDesc("负责人证件号码")
	private String fzr_zjhm;
	@FieldDesc("负责人姓名")
	private String fzr_xm;
	@FieldDesc("负责人性别代码")
	private String fzr_xbdm;
	@FieldDesc("负责人职务")
	private String fzr_zwmc;
	@FieldDesc("负责人联系电话")
	private String fzr_lxdh;
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
	public String getZybwmc() {
		return zybwmc;
	}
	public void setZybwmc(String zybwmc) {
		this.zybwmc = zybwmc;
	}
	public String getZybwwz() {
		return zybwwz;
	}
	public void setZybwwz(String zybwwz) {
		this.zybwwz = zybwwz;
	}
	public String getZbdh() {
		return zbdh;
	}
	public void setZbdh(String zbdh) {
		this.zbdh = zbdh;
	}
	public String getWfssqk() {
		return wfssqk;
	}
	public void setWfssqk(String wfssqk) {
		this.wfssqk = wfssqk;
	}
	public String getJfssqk() {
		return jfssqk;
	}
	public void setJfssqk(String jfssqk) {
		this.jfssqk = jfssqk;
	}
	public String getQdsj() {
		return qdsj;
	}
	public void setQdsj(String qdsj) {
		this.qdsj = qdsj;
	}
	public String getQdlyyj() {
		return qdlyyj;
	}
	public void setQdlyyj(String qdlyyj) {
		this.qdlyyj = qdlyyj;
	}
	public String getFzr_ryid() {
		return fzr_ryid;
	}
	public void setFzr_ryid(String fzr_ryid) {
		this.fzr_ryid = fzr_ryid;
	}
	public String getFzr_cyzjdm() {
		return fzr_cyzjdm;
	}
	public void setFzr_cyzjdm(String fzr_cyzjdm) {
		this.fzr_cyzjdm = fzr_cyzjdm;
	}
	public String getFzr_zjhm() {
		return fzr_zjhm;
	}
	public void setFzr_zjhm(String fzr_zjhm) {
		this.fzr_zjhm = fzr_zjhm;
	}
	public String getFzr_xm() {
		return fzr_xm;
	}
	public void setFzr_xm(String fzr_xm) {
		this.fzr_xm = fzr_xm;
	}
	public String getFzr_xbdm() {
		return fzr_xbdm;
	}
	public void setFzr_xbdm(String fzr_xbdm) {
		this.fzr_xbdm = fzr_xbdm;
	}
	public String getFzr_zwmc() {
		return fzr_zwmc;
	}
	public void setFzr_zwmc(String fzr_zwmc) {
		this.fzr_zwmc = fzr_zwmc;
	}
	public String getFzr_lxdh() {
		return fzr_lxdh;
	}
	public void setFzr_lxdh(String fzr_lxdh) {
		this.fzr_lxdh = fzr_lxdh;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	public String getZybwms() {
		return zybwms;
	}
	public void setZybwms(String zybwms) {
		this.zybwms = zybwms;
	}
	
}
