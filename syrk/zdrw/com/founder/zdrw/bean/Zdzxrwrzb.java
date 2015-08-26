package com.founder.zdrw.bean;

import java.io.Serializable;

/**
 * 自动执行任务日志表
 * @author 李承龙
 * 
 */
public class Zdzxrwrzb implements Serializable{
	private static final long serialVersionUID = 1L;
	private String id;				//自动执行任务日志ID
	private String zdzxrwid;		//自动执行任务ID
	private String rwmc;			//任务名称
	private String rwzxkssj;		//任务执行开始时间
	private String rwzxwcsj;		//任务执行完成时间
	private Long rwzxsc;			//任务执行时长
	private String rwzxff;			//任务执行方法
	private String sfzxcg;			//是否执行成功
	private String zxqk;			//执行情况
	private String bz;				//备注
	private String xt_cjsj;			//采集时间
	private String xt_lrsj;			//录入时间
	private String xt_lrrxm;		//录入人姓名
	private String xt_lrrid;		//录入人ID
	private String xt_lrrbm;		//录入人部门
	private String xt_lrrbmid;		//录入人部门ID
	private String xt_lrip;			//录入IP
	private String xt_zhxgsj;		//最后修改时间
	private String xt_zhxgrxm;		//最后修改人姓名
	private String xt_zhxgrid;		//最后修改人ID
	private String xt_zhxgrbm;		//最后修改人部门
	private String xt_zhxgrbmid;	//最后修改人部门ID
	private String xt_zhxgip;		//最后修改IP
	private String xt_zxbz;			//注销标志
	private String xt_zxyy;			//注销原因
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getZdzxrwid() {
		return zdzxrwid;
	}
	public void setZdzxrwid(String zdzxrwid) {
		this.zdzxrwid = zdzxrwid;
	}
	public String getRwmc() {
		return rwmc;
	}
	public void setRwmc(String rwmc) {
		this.rwmc = rwmc;
	}
	public String getRwzxkssj() {
		return rwzxkssj;
	}
	public void setRwzxkssj(String rwzxkssj) {
		this.rwzxkssj = rwzxkssj;
	}
	public String getRwzxwcsj() {
		return rwzxwcsj;
	}
	public void setRwzxwcsj(String rwzxwcsj) {
		this.rwzxwcsj = rwzxwcsj;
	}
	public Long getRwzxsc() {
		return rwzxsc;
	}
	public void setRwzxsc(Long rwzxsc) {
		this.rwzxsc = rwzxsc;
	}
	public String getRwzxff() {
		return rwzxff;
	}
	public void setRwzxff(String rwzxff) {
		this.rwzxff = rwzxff;
	}
	public String getSfzxcg() {
		return sfzxcg;
	}
	public void setSfzxcg(String sfzxcg) {
		this.sfzxcg = sfzxcg;
	}
	public String getZxqk() {
		return zxqk;
	}
	public void setZxqk(String zxqk) {
		this.zxqk = zxqk;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
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
}
