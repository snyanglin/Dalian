package com.founder.zakh.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;




/******************************************************************************
 * @Package:      [com.founder.zakh.bean.Khfstjb.java]  
 * @ClassName:    [Khfstjb]   
 * @Description:  [考核分数统计表]   
 * @Author:       [cong_rihong@founder.com.cn]  
 * @CreateDate:   [2015-6-1 下午5:46:19]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-6-1 下午5:46:19，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 */
@SuppressWarnings("serial")
@DBInfoAnnotation(tableName = "KH_KHFSTJB", pk = "id")
public class Khfstjb extends BaseEntity implements Serializable{
	@FieldDesc("ID")
	private String id;
	@FieldDesc("组织机构代码")
	private String zzjgdm;
	@FieldDesc("组织机构名称")
	private String zzjgname;
	@FieldDesc("组织机构等级")
	private String zzjgdj;
	@FieldDesc("考核年份")
	private String year;
	@FieldDesc("考核周")
	private String week;
	@FieldDesc("考核周开始日期")
	private String weekStartDate;
	@FieldDesc("考核周结束日期")
	private String weekEndDate;
	@FieldDesc("基础信息扣分值")
	private Double jcxxkf;
	@FieldDesc("基础信息扣分合计")
	private Double jcxxkfhj;
	@FieldDesc("基础信息考核得分")
	private Double jcxxkhdf;
	@FieldDesc("基础信息考核总分")
	private Double jcxxkhzf;
	@FieldDesc("重点人口扣分值")
	private Double zdrkkf;
	@FieldDesc("重点人员扣分合计")
	private Double zdrkkfhj;
	@FieldDesc("重点人口考核得分")
	private Double zdrkkhdf;
	@FieldDesc("重点人口考核总分")
	private Double zdrkkhzf;
	@FieldDesc("治安防范扣分值")
	private Double zaffkf;
	@FieldDesc("治安防范扣分合计")
	private Double zaffkfhj;
	@FieldDesc("治安防范考核得分")
	private Double zaffkhdf;
	@FieldDesc("治安防范考核总分")
	private Double zaffkhzf;
	@FieldDesc("备注")
	private String bz;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getZzjgdm() {
		return zzjgdm;
	}
	public void setZzjgdm(String zzjgdm) {
		this.zzjgdm = zzjgdm;
	}
	public String getZzjgname() {
		return zzjgname;
	}
	public void setZzjgname(String zzjgname) {
		this.zzjgname = zzjgname;
	}
	public String getZzjgdj() {
		return zzjgdj;
	}
	public void setZzjgdj(String zzjgdj) {
		this.zzjgdj = zzjgdj;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getWeek() {
		return week;
	}
	public void setWeek(String week) {
		this.week = week;
	}

	public Double getJcxxkf() {
		return jcxxkf;
	}
	public void setJcxxkf(Double jcxxkf) {
		this.jcxxkf = jcxxkf;
	}
	public Double getJcxxkfhj() {
		return jcxxkfhj;
	}
	public void setJcxxkfhj(Double jcxxkfhj) {
		this.jcxxkfhj = jcxxkfhj;
	}
	public Double getJcxxkhdf() {
		return jcxxkhdf;
	}
	public void setJcxxkhdf(Double jcxxkhdf) {
		this.jcxxkhdf = jcxxkhdf;
	}
	public Double getJcxxkhzf() {
		return jcxxkhzf;
	}
	public void setJcxxkhzf(Double jcxxkhzf) {
		this.jcxxkhzf = jcxxkhzf;
	}
	public Double getZdrkkf() {
		return zdrkkf;
	}
	public void setZdrkkf(Double zdrkkf) {
		this.zdrkkf = zdrkkf;
	}
	public Double getZdrkkfhj() {
		return zdrkkfhj;
	}
	public void setZdrkkfhj(Double zdrkkfhj) {
		this.zdrkkfhj = zdrkkfhj;
	}
	public Double getZdrkkhdf() {
		return zdrkkhdf;
	}
	public void setZdrkkhdf(Double zdrkkhdf) {
		this.zdrkkhdf = zdrkkhdf;
	}
	public Double getZdrkkhzf() {
		return zdrkkhzf;
	}
	public void setZdrkkhzf(Double zdrkkhzf) {
		this.zdrkkhzf = zdrkkhzf;
	}
	public Double getZaffkf() {
		return zaffkf;
	}
	public void setZaffkf(Double zaffkf) {
		this.zaffkf = zaffkf;
	}
	public Double getZaffkfhj() {
		return zaffkfhj;
	}
	public void setZaffkfhj(Double zaffkfhj) {
		this.zaffkfhj = zaffkfhj;
	}
	public Double getZaffkhdf() {
		return zaffkhdf;
	}
	public void setZaffkhdf(Double zaffkhdf) {
		this.zaffkhdf = zaffkhdf;
	}
	public Double getZaffkhzf() {
		return zaffkhzf;
	}
	public void setZaffkhzf(Double zaffkhzf) {
		this.zaffkhzf = zaffkhzf;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	public String getWeekStartDate() {
		return weekStartDate;
	}
	public void setWeekStartDate(String weekStartDate) {
		this.weekStartDate = weekStartDate;
	}
	public String getWeekEndDate() {
		return weekEndDate;
	}
	public void setWeekEndDate(String weekEndDate) {
		this.weekEndDate = weekEndDate;
	}
	
}
