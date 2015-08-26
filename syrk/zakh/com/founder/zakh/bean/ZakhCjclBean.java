/**********************************************************************   
 * <p>文件名：ZakhCjclBean.java </p>
 * <p>文件描述：治安考核-基本信息采集常量bean 
 * @project_name：syrk
 * @author wu.w@founder.com.cn 
 * @date 2015-4-17 上午8:53:06 
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
 * @Package:      [com.founder.zakh.bean.ZakhCjclBean.java]  
 * @ClassName:    [ZakhCjclBean]   
 * @Description:  [治安考核-基本信息采集常量bean]   
 * @Author:       [wu.w@founder.com.cn]  
 * @CreateDate:   [2015-4-17 上午8:53:06]   
 * @UpdateUser:   [Way(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-4-17 上午8:53:06，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 */
@SuppressWarnings("serial")
@DBInfoAnnotation(tableName = "KH_CJCL", pk = "orgid")
public class ZakhCjclBean extends BaseEntity implements Serializable {
	@FieldDesc("组织机构id")
	private String orgid;
	@FieldDesc("组织机构名称")
	private String orgname;
	@FieldDesc("考核常量 ")
	private String cl;
	@FieldDesc("更新常量人员ID")
	private String upduser;
	@FieldDesc("更新常量日期")
	private String upddate;
	@FieldDesc("ORGCODE树结点路径")
	private String orgtreepath;
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
	 * @return the upduser
	 */
	public String getUpduser() {
		return upduser;
	}
	/**
	 * @param upduser the upduser to set
	 */
	public void setUpduser(String upduser) {
		this.upduser = upduser;
	}
	/**
	 * @return the upddate
	 */
	public String getUpddate() {
		return upddate;
	}
	/**
	 * @param upddate the upddate to set
	 */
	public void setUpddate(String upddate) {
		this.upddate = upddate;
	}
	/**
	 * @return the orgtreepath
	 */
	public String getOrgtreepath() {
		return orgtreepath;
	}
	/**
	 * @param orgtreepath the orgtreepath to set
	 */
	public void setOrgtreepath(String orgtreepath) {
		this.orgtreepath = orgtreepath;
	}
}
