/**********************************************************************   
 * <p>文件名：ZakhJbxxCjBean.java </p>
 * <p>文件描述：治安考核-基本信息采集bean
 * @project_name：syrk
 * @author wu.w@founder.com.cn 
 * @date 2015-4-17 上午8:51:58 
 * @history
 * @department：研发部
 *
*/
package com.founder.zakh.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

/******************************************************************************
 * @Package:      [com.founder.zakh.bean.ZakhJbxxCjBean.java]  
 * @ClassName:    [ZakhJbxxCjBean]   
 * @Description:  [治安考核-基本信息采集bean]   
 * @Author:       [wu.w@founder.com.cn]  
 * @CreateDate:   [2015-4-17 上午8:51:58]   
 * @UpdateUser:   [Way(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-4-17 上午8:51:58，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 */

@SuppressWarnings("serial")
@DBInfoAnnotation(tableName = "KH_JBXXCJB", pk = "id")
public class ZakhJbxxCjBean extends BaseEntity implements Serializable  {
	@FieldDesc("主键id")
	private String id;
	@FieldDesc("责任区id")
	private String orgid;
	@FieldDesc("责任区名称")
	private String orgname;
	@FieldDesc("考核常量")
	private String cl;
	@FieldDesc("新增数量")
	private String addnum="0";
	@FieldDesc("注销数量")
	private String delnum="0";
	@FieldDesc("考核详细信息")
	private String cjxx;
	@FieldDesc("考核周 ")
	private String week;
	@FieldDesc("周开始日期")
	private String weekbtime;
	@FieldDesc("周结束日期")
	private String weeketime;
	@FieldDesc("考核日期")
	private String counttime;
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the orgid
	 */
	public String getOrgid() {
		return orgid;
	}
	/**
	 * @param orgid the orgid to set
	 */
	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}
	/**
	 * @return the orgname
	 */
	public String getOrgname() {
		return orgname;
	}
	/**
	 * @param orgname the orgname to set
	 */
	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}
	/**
	 * @return the cl
	 */
	public String getCl() {
		return cl;
	}
	/**
	 * @param cl the cl to set
	 */
	public void setCl(String cl) {
		this.cl = cl;
	}
	/**
	 * @return the addnum
	 */
	public String getAddnum() {
		return addnum;
	}
	/**
	 * @param addnum the addnum to set
	 */
	public void setAddnum(String addnum) {
		this.addnum = addnum;
	}
	/**
	 * @return the delnum
	 */
	public String getDelnum() {
		return delnum;
	}
	/**
	 * @param delnum the delnum to set
	 */
	public void setDelnum(String delnum) {
		this.delnum = delnum;
	}
	/**
	 * @return the cjxx
	 */
	public String getCjxx() {
		return cjxx;
	}
	/**
	 * @param cjxx the cjxx to set
	 */
	public void setCjxx(String cjxx) {
		this.cjxx = cjxx;
	}
	/**
	 * @return the week
	 */
	public String getWeek() {
		return week;
	}
	/**
	 * @param week the week to set
	 */
	public void setWeek(String week) {
		this.week = week;
	}
	/**
	 * @return the weekbtime
	 */
	public String getWeekbtime() {
		return weekbtime;
	}
	/**
	 * @param weekbtime the weekbtime to set
	 */
	public void setWeekbtime(String weekbtime) {
		this.weekbtime = weekbtime;
	}
	/**
	 * @return the weeketime
	 */
	public String getWeeketime() {
		return weeketime;
	}
	/**
	 * @param weeketime the weeketime to set
	 */
	public void setWeeketime(String weeketime) {
		this.weeketime = weeketime;
	}
	/**
	 * @return the counttime
	 */
	public String getCounttime() {
		return counttime;
	}
	/**
	 * @param counttime the counttime to set
	 */
	public void setCounttime(String counttime) {
		this.counttime = counttime;
	}
}
