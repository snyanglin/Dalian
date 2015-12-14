package com.founder.sqjw.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

/**
 * @类名: Tjgzjl
 * @描述: 工作记录统计表
 * @作者: zhang_guoliang@founder.com
 * @日期: 2014-7-10 下午8:47:27
 * 
 */
@DBInfoAnnotation(tableName = "TJ_GZJLNEW")
public class Tjgzjl extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	@FieldDesc("分局代码")
	private String fjdm;
	@FieldDesc("分局名称")
	private String fjmc;
	@FieldDesc("派出所代码")
	private String pcsdm;
	@FieldDesc("派出所名称")
	private String pcsmc;
	@FieldDesc("社区代码")
	private String sqdm;
	@FieldDesc("社区名称")
	private String sqmc;
	@FieldDesc("责任区代码")
	private String zrqdm;
	@FieldDesc("责任区名称")
	private String zrqmc;
	@FieldDesc("日")
	private Long day;
	@FieldDesc("周")
	private Long week;
	@FieldDesc("月")
	private Long month;
	@FieldDesc("年")
	private Long year;
	@FieldDesc("类型")
	private String lx;
	@FieldDesc("类型名称")
	private String lxmc;
	@FieldDesc("日期")
	private String today;
	public String getFjdm() {
		return fjdm;
	}
	public void setFjdm(String fjdm) {
		this.fjdm = fjdm;
	}
	public String getFjmc() {
		return fjmc;
	}
	public void setFjmc(String fjmc) {
		this.fjmc = fjmc;
	}
	public String getPcsdm() {
		return pcsdm;
	}
	public void setPcsdm(String pcsdm) {
		this.pcsdm = pcsdm;
	}
	public String getPcsmc() {
		return pcsmc;
	}
	public void setPcsmc(String pcsmc) {
		this.pcsmc = pcsmc;
	}
	public String getSqdm() {
		return sqdm;
	}
	public void setSqdm(String sqdm) {
		this.sqdm = sqdm;
	}
	public String getSqmc() {
		return sqmc;
	}
	public void setSqmc(String sqmc) {
		this.sqmc = sqmc;
	}
	public String getZrqdm() {
		return zrqdm;
	}
	public void setZrqdm(String zrqdm) {
		this.zrqdm = zrqdm;
	}
	public String getZrqmc() {
		return zrqmc;
	}
	public void setZrqmc(String zrqmc) {
		this.zrqmc = zrqmc;
	}
	public Long getDay() {
		return day;
	}
	public void setDay(Long day) {
		this.day = day;
	}
	public Long getWeek() {
		return week;
	}
	public void setWeek(Long week) {
		this.week = week;
	}
	public Long getMonth() {
		return month;
	}
	public void setMonth(Long month) {
		this.month = month;
	}
	public Long getYear() {
		return year;
	}
	public void setYear(Long year) {
		this.year = year;
	}
	public String getLx() {
		return lx;
	}
	public void setLx(String lx) {
		this.lx = lx;
	}
	public String getLxmc() {
		return lxmc;
	}
	public void setLxmc(String lxmc) {
		this.lxmc = lxmc;
	}
	public String getToday() {
		return today;
	}
	public void setToday(String today) {
		this.today = today;
	}
}