package com.founder.spsxt.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;


public class Spview extends BaseEntity implements Serializable {
	
	
//摄像头查询页面使用
	private static final long serialVersionUID = 1L;
	@FieldDesc("ID")
	private String id;
	@FieldDesc("条码")
	private String tm;
	private String dwmc;
	@FieldDesc("摄像头所属监控系统") 
	private String jkxtBm;
	@FieldDesc("纬度") 
	private String wd;
	@FieldDesc("安装部位")  
	private String azbw;
	@FieldDesc("朝向") 
	private String cx;
	@FieldDesc("经度")                    
	private String jd;
	private String dwlx;               
	private String hyname;
	private String meaning;
	
	private String jkxtMc;
	@FieldDesc("点位监控角度")            
	private String jkjd;
	@FieldDesc("高清标清")    
	private String sb_gqbq;
	@FieldDesc("枪机球机")    
	private String sb_qjqj;
	@FieldDesc("室内室外")    
	private String sb_snsw;
	@FieldDesc("夜视非夜视")  
	private String sb_ys;   
	private String qymc;
	
	@FieldDesc("建设单位编码") 
	private String dwbm;	
	private String pic_location;//照片存放路径
	
	/*
	private String xt_cjsj;
	private String xt_lrsj;
	private String xt_lrrxm;
	private String xt_lrrid;
	private String xt_lrrbm;
	private String xt_lrrbmid;
	private String xt_lrip;
	private String xt_zhxgsj;
	private String xt_zhxgrxm;
	private String xt_zhxgrid;
	private String xt_zhxgrbm;
	private String xt_zhxgrbmid;
	private String xt_zhxgip;
	private String xt_zxbz;
	private String xt_zxyy;
	*/
	public String getMeaning() {
		return meaning;
	}
	public void setMeaning(String meaning) {
		this.meaning = meaning;
	}	
	public String getDwbm() {
		return dwbm;
	}
	public void setDwbm(String dwbm) {
		this.dwbm = dwbm;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getWd() {
		return wd;
	}
	public void setWd(String wd) {
		this.wd = wd;
	}
	public String getAzbw() {
		return azbw;
	}
	public void setAzbw(String azbw) {
		this.azbw = azbw;
	}
	public String getCx() {
		return cx;
	}
	public void setCx(String cx) {
		this.cx = cx;
	}
	public String getJd() {
		return jd;
	}
	public void setJd(String jd) {
		this.jd = jd;
	}
	public String getDwmc() {
		return dwmc;
	}
	public void setDwmc(String dwmc) {
		this.dwmc = dwmc;
	}

	public String getJkjd() {
		return jkjd;
	}
	public void setJkjd(String jkjd) {
		this.jkjd = jkjd;
	}
	public String getSb_gqbq() {
		return sb_gqbq;
	}
	public void setSb_gqbq(String sb_gqbq) {
		this.sb_gqbq = sb_gqbq;
	}
	public String getSb_qjqj() {
		return sb_qjqj;
	}
	public void setSb_qjqj(String sb_qjqj) {
		this.sb_qjqj = sb_qjqj;
	}
	public String getSb_snsw() {
		return sb_snsw;
	}
	public void setSb_snsw(String sb_snsw) {
		this.sb_snsw = sb_snsw;
	}
	public String getSb_ys() {
		return sb_ys;
	}
	public void setSb_ys(String sb_ys) {
		this.sb_ys = sb_ys;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTm() {
		return tm;
	}
	public void setTm(String tm) {
		this.tm = tm;
	}
	public String getJkxtBm() {
		return jkxtBm;
	}
	public void setJkxtBm(String jkxtBm) {
		this.jkxtBm = jkxtBm;
	}
	public String getDwlx() {
		return dwlx;
	}
	public void setDwlx(String dwlx) {
		this.dwlx = dwlx;
	}
	public String getHyname() {
		return hyname;
	}
	public void setHyname(String hyname) {
		this.hyname = hyname;
	}
	public String getJkxtMc() {
		return jkxtMc;
	}
	public void setJkxtMc(String jkxtMc) {
		this.jkxtMc = jkxtMc;
	}
	public String getQymc() {
		return qymc;
	}
	public void setQymc(String qymc) {
		this.qymc = qymc;
	}
	public String getPic_location() {
		return pic_location;
	}
	public void setPic_location(String pic_location) {
		this.pic_location = pic_location;
	}
}