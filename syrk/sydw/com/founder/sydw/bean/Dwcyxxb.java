package com.founder.sydw.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;
@DBInfoAnnotation(tableName = "DW_CYXXB", pk = "id")
public class Dwcyxxb extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@FieldDesc("ID")
	private String id;
	@FieldDesc("抽查次数信息表id")
	private String xfdwcccsxxbid;
	@FieldDesc("抽查次数")
	private String cccs;
	@FieldDesc("检查类别")
	private String jclb;
	@FieldDesc("采集时间")
	private String xt_cjsj;
	@FieldDesc("录入时间")
	private String xt_lrsj;
	@FieldDesc("录入人姓名")
	private String xt_lrrxm;
	@FieldDesc("录入人ID")
	private String xt_lrrid;
	@FieldDesc("录入人部门")
	private String xt_lrrbm;
	@FieldDesc("录入人部门ID")
	private String xt_lrrbmid;
	@FieldDesc("录入IP")
	private String xt_lrip;
	@FieldDesc("最后修改时间")
	private String xt_zhxgsj;
	@FieldDesc("最后修改人姓名")
	private String xt_zhxgrxm;
	@FieldDesc("最后修改人ID")
	private String xt_zhxgrid;
	@FieldDesc("最后修改人部门")
	private String xt_zhxgrbm;
	@FieldDesc("最后修改人部门ID")
	private String xt_zhxgrbmid;
	@FieldDesc("最后修改IP")
	private String xt_zhxgip;
	@FieldDesc("注销标志")
	private String xt_zxbz;
	@FieldDesc("注销原因")
	private String xt_zxyy;
	@FieldDesc("抽查时间开始")
	private String ccsjks;
	@FieldDesc("抽查时间结束")
	private String ccsjjs;
	@FieldDesc("重点单位数量")
	private String zddwzs;
	@FieldDesc("一般单位总数")
	private String ybdwzs;
	@FieldDesc("其他单位总数")
	private String qtdwzs;
	@FieldDesc("九小场所总数")
	private String jxcszs;
	@FieldDesc("抽查方式")
	private String ccfs;
	
	@FieldDesc("百分比")
	private String bfb;
	@FieldDesc("抽查总数")
	private String zs;
	@FieldDesc("抽查关键字")
	private String gjz;
	@FieldDesc("多少家")
	private String jia;
	@FieldDesc("监管单位类别")
	private String jgdwlb;
	@FieldDesc("分县局")
	private String glfxjid;
	@FieldDesc("派出所")
	private String glpcsid;
	@FieldDesc("责任区")
	private String glbmid;
	
	@FieldDesc("排序字段")
	private String sort;
	@FieldDesc("排序方式")
	private String order;
	@FieldDesc("抽查组合")
	private String cdan;
	@FieldDesc("非重点单位")
	private String fzddw;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getXfdwcccsxxbid() {
		return xfdwcccsxxbid;
	}
	public void setXfdwcccsxxbid(String xfdwcccsxxbid) {
		this.xfdwcccsxxbid = xfdwcccsxxbid;
	}
	public String getCccs() {
		return cccs;
	}
	public void setCccs(String cccs) {
		this.cccs = cccs;
	}
	public String getJclb() {
		return jclb;
	}
	public void setJclb(String jclb) {
		this.jclb = jclb;
	}
	public String getXt_cjsj() {
		return xt_cjsj;
	}
	public void setXt_cjsj(String xt_cjsj) {
		this.xt_cjsj = xt_cjsj;
	}
	public String getXt_lrsj() {
		return xt_lrsj;
	}
	public void setXt_lrsj(String xt_lrsj) {
		this.xt_lrsj = xt_lrsj;
	}
	public String getXt_lrrxm() {
		return xt_lrrxm;
	}
	public void setXt_lrrxm(String xt_lrrxm) {
		this.xt_lrrxm = xt_lrrxm;
	}
	public String getXt_lrrid() {
		return xt_lrrid;
	}
	public void setXt_lrrid(String xt_lrrid) {
		this.xt_lrrid = xt_lrrid;
	}
	public String getXt_lrrbm() {
		return xt_lrrbm;
	}
	public void setXt_lrrbm(String xt_lrrbm) {
		this.xt_lrrbm = xt_lrrbm;
	}
	public String getXt_lrrbmid() {
		return xt_lrrbmid;
	}
	public void setXt_lrrbmid(String xt_lrrbmid) {
		this.xt_lrrbmid = xt_lrrbmid;
	}
	public String getXt_lrip() {
		return xt_lrip;
	}
	public void setXt_lrip(String xt_lrip) {
		this.xt_lrip = xt_lrip;
	}
	public String getXt_zhxgsj() {
		return xt_zhxgsj;
	}
	public void setXt_zhxgsj(String xt_zhxgsj) {
		this.xt_zhxgsj = xt_zhxgsj;
	}
	public String getXt_zhxgrxm() {
		return xt_zhxgrxm;
	}
	public void setXt_zhxgrxm(String xt_zhxgrxm) {
		this.xt_zhxgrxm = xt_zhxgrxm;
	}
	public String getXt_zhxgrid() {
		return xt_zhxgrid;
	}
	public void setXt_zhxgrid(String xt_zhxgrid) {
		this.xt_zhxgrid = xt_zhxgrid;
	}
	public String getXt_zhxgrbm() {
		return xt_zhxgrbm;
	}
	public void setXt_zhxgrbm(String xt_zhxgrbm) {
		this.xt_zhxgrbm = xt_zhxgrbm;
	}
	public String getXt_zhxgrbmid() {
		return xt_zhxgrbmid;
	}
	public void setXt_zhxgrbmid(String xt_zhxgrbmid) {
		this.xt_zhxgrbmid = xt_zhxgrbmid;
	}
	public String getXt_zhxgip() {
		return xt_zhxgip;
	}
	public void setXt_zhxgip(String xt_zhxgip) {
		this.xt_zhxgip = xt_zhxgip;
	}
	public String getXt_zxbz() {
		return xt_zxbz;
	}
	public void setXt_zxbz(String xt_zxbz) {
		this.xt_zxbz = xt_zxbz;
	}
	public String getXt_zxyy() {
		return xt_zxyy;
	}
	public void setXt_zxyy(String xt_zxyy) {
		this.xt_zxyy = xt_zxyy;
	}
	public String getCcsjks() {
		return ccsjks;
	}
	public void setCcsjks(String ccsjks) {
		this.ccsjks = ccsjks;
	}
	public String getCcsjjs() {
		return ccsjjs;
	}
	public void setCcsjjs(String ccsjjs) {
		this.ccsjjs = ccsjjs;
	}
	public String getZddwzs() {
		return zddwzs;
	}
	public void setZddwzs(String zddwzs) {
		this.zddwzs = zddwzs;
	}
	public String getYbdwzs() {
		return ybdwzs;
	}
	public void setYbdwzs(String ybdwzs) {
		this.ybdwzs = ybdwzs;
	}
	public String getQtdwzs() {
		return qtdwzs;
	}
	public void setQtdwzs(String qtdwzs) {
		this.qtdwzs = qtdwzs;
	}
	public String getJxcszs() {
		return jxcszs;
	}
	public void setJxcszs(String jxcszs) {
		this.jxcszs = jxcszs;
	}
	public String getCcfs() {
		return ccfs;
	}
	public void setCcfs(String ccfs) {
		this.ccfs = ccfs;
	}
	public String getBfb() {
		return bfb;
	}
	public void setBfb(String bfb) {
		this.bfb = bfb;
	}
	public String getZs() {
		return zs;
	}
	public void setZs(String zs) {
		this.zs = zs;
	}
	public String getGjz() {
		return gjz;
	}
	public void setGjz(String gjz) {
		this.gjz = gjz;
	}
	public String getJia() {
		return jia;
	}
	public void setJia(String jia) {
		this.jia = jia;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	public String getJgdwlb() {
		return jgdwlb;
	}
	public void setJgdwlb(String jgdwlb) {
		this.jgdwlb = jgdwlb;
	}
	public String getGlfxjid() {
		return glfxjid;
	}
	public void setGlfxjid(String glfxjid) {
		this.glfxjid = glfxjid;
	}
	public String getGlpcsid() {
		return glpcsid;
	}
	public void setGlpcsid(String glpcsid) {
		this.glpcsid = glpcsid;
	}
	public String getGlbmid() {
		return glbmid;
	}
	public void setGlbmid(String glbmid) {
		this.glbmid = glbmid;
	}
	public String getCdan() {
		return cdan;
	}
	public void setCdan(String cdan) {
		this.cdan = cdan;
	}
	public String getFzddw() {
		return fzddw;
	}
	public void setFzddw(String fzddw) {
		this.fzddw = fzddw;
	}
}
