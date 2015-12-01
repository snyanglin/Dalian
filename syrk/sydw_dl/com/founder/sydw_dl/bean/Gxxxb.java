package com.founder.sydw_dl.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

@DBInfoAnnotation(tableName = "DW_GXXXB", pk = "id")
public class Gxxxb extends  BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@FieldDesc("ID")
	private String id;
	@FieldDesc("单位ID")
	private String dwid;
	@FieldDesc("高校学生_人数")
	private Long gxxs_rs;
	@FieldDesc("教师_人数")
	private Long js_rs;
	@FieldDesc("外籍学生_人数")
	private Long wjxs_rs;
	@FieldDesc("少数民族学生_人数")
	private Long ssmzxs_rs;
	@FieldDesc("外籍教师_人数")
	private Long wjjs_rs;
	@FieldDesc("化学实验室数量")
	private Long hxsyssl;
	@FieldDesc("有无化学危险品代码")
	private String ywhxwxpdm;
	@FieldDesc("管理化学危险品责任人")
	private String glhxwxpzrr;
	@FieldDesc("责任人联系电话")
	private String zrr_lxdh;
	@FieldDesc("化学危险品种类及数量情况")
	private String hxwxpzljslqk;
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
	public Long getGxxs_rs() {
		return gxxs_rs;
	}
	public void setGxxs_rs(Long gxxs_rs) {
		this.gxxs_rs = gxxs_rs;
	}
	public Long getJs_rs() {
		return js_rs;
	}
	public void setJs_rs(Long js_rs) {
		this.js_rs = js_rs;
	}
	public Long getWjxs_rs() {
		return wjxs_rs;
	}
	public void setWjxs_rs(Long wjxs_rs) {
		this.wjxs_rs = wjxs_rs;
	}
	public Long getSsmzxs_rs() {
		return ssmzxs_rs;
	}
	public void setSsmzxs_rs(Long ssmzxs_rs) {
		this.ssmzxs_rs = ssmzxs_rs;
	}
	public Long getWjjs_rs() {
		return wjjs_rs;
	}
	public void setWjjs_rs(Long wjjs_rs) {
		this.wjjs_rs = wjjs_rs;
	}
	public Long getHxsyssl() {
		return hxsyssl;
	}
	public void setHxsyssl(Long hxsyssl) {
		this.hxsyssl = hxsyssl;
	}
	public String getYwhxwxpdm() {
		return ywhxwxpdm;
	}
	public void setYwhxwxpdm(String ywhxwxpdm) {
		this.ywhxwxpdm = ywhxwxpdm;
	}
	public String getGlhxwxpzrr() {
		return glhxwxpzrr;
	}
	public void setGlhxwxpzrr(String glhxwxpzrr) {
		this.glhxwxpzrr = glhxwxpzrr;
	}
	public String getZrr_lxdh() {
		return zrr_lxdh;
	}
	public void setZrr_lxdh(String zrr_lxdh) {
		this.zrr_lxdh = zrr_lxdh;
	}
	public String getHxwxpzljslqk() {
		return hxwxpzljslqk;
	}
	public void setHxwxpzljslqk(String hxwxpzljslqk) {
		this.hxwxpzljslqk = hxwxpzljslqk;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}

}
