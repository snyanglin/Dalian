/**********************************************************************   
 * <p>文件名：ZakhJbxxCjVO.java </p>
 * <p>文件描述：治安考核-基本信息采集视图类
 * @project_name：syrk
 * @author wu.w@founder.com.cn 
 * @date 2015-4-17 上午8:57:29 
 * @history
 * @department：研发部
 *
*/
package com.founder.zakh.vo;

/******************************************************************************
 * @Package:      [com.founder.zakh.vo.ZakhJbxxCjVO.java]  
 * @ClassName:    [ZakhJbxxCjVO]   
 * @Description:  [治安考核-基本信息采集视图类]   
 * @Author:       [wu.w@founder.com.cn]  
 * @CreateDate:   [2015-4-17 上午8:57:29]   
 * @UpdateUser:   [Way(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-4-17 上午8:57:29，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 */

public class ZakhJbxxCjVO {
	/** 考核信息id */
	private long id;
	/** 责任区id */
	private String orgId;
	/** 责任区名称 */
	private String orgName;
	/** 考核标准 */
	private int cl;
	/** 新增数 */
	private int add;
	/** 注销数 */
	private int del;
	/** 周 */
	private int week;
	/** 周-开始日期 */
	private String weekBtime;
	/** 周-结束日期 */
	private String weekEtime;
	/** 统计时间 */
	private String countTime;
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * @return the orgId
	 */
	public String getOrgId() {
		return orgId;
	}
	/**
	 * @param orgId the orgId to set
	 */
	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}
	/**
	 * @return the orgName
	 */
	public String getOrgName() {
		return orgName;
	}
	/**
	 * @param orgName the orgName to set
	 */
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	/**
	 * @return the cl
	 */
	public int getCl() {
		return cl;
	}
	/**
	 * @param cl the cl to set
	 */
	public void setCl(int cl) {
		this.cl = cl;
	}
	/**
	 * @return the add
	 */
	public int getAdd() {
		return add;
	}
	/**
	 * @param add the add to set
	 */
	public void setAdd(int add) {
		this.add = add;
	}
	/**
	 * @return the del
	 */
	public int getDel() {
		return del;
	}
	/**
	 * @param del the del to set
	 */
	public void setDel(int del) {
		this.del = del;
	}
	/**
	 * @return the week
	 */
	public int getWeek() {
		return week;
	}
	/**
	 * @param week the week to set
	 */
	public void setWeek(int week) {
		this.week = week;
	}
	/**
	 * @return the weekBtime
	 */
	public String getWeekBtime() {
		return weekBtime;
	}
	/**
	 * @param weekBtime the weekBtime to set
	 */
	public void setWeekBtime(String weekBtime) {
		this.weekBtime = weekBtime;
	}
	/**
	 * @return the weekEtime
	 */
	public String getWeekEtime() {
		return weekEtime;
	}
	/**
	 * @param weekEtime the weekEtime to set
	 */
	public void setWeekEtime(String weekEtime) {
		this.weekEtime = weekEtime;
	}
	/**
	 * @return the countTime
	 */
	public String getCountTime() {
		return countTime;
	}
	/**
	 * @param countTime the countTime to set
	 */
	public void setCountTime(String countTime) {
		this.countTime = countTime;
	}
}
