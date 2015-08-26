/**********************************************************************   
 * <p>文件名：ZakhZzjgBean.java </p>
 * <p>文件描述：治安考核-组织机构bean 
 * @project_name：syrk
 * @author liu_shuai@founder.com.cn 
 * @date 2015-4-13 上午9:59:20 
 * @history
 * @department：研发部
 *
*/
package com.founder.zakh.bean;
import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;
/**
 * ****************************************************************************
 * @Package:      [com.founder.zakh.bean.ZakhZzjgBean.java]  
 * @ClassName:    [ZakhZzjgBean]   
 * @Description:  [组织机构BEAN]   
 * @Author:       [liu_shuai@founder.com.cn]  
 * @CreateDate:   [2015-4-13 上午9:59:20]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-4-13 上午9:59:20，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@DBInfoAnnotation(tableName = "org_organization", pk = "id")
public class ZakhZzjgBean extends BaseEntity {
	@FieldDesc("主键")
	private Long id;
	@FieldDesc("部门代码")
	private String orgcode;
	@FieldDesc("部门名称")
	private String orgname;
	@FieldDesc("部门类型")
	private String orgtype;
	@FieldDesc("部门等级")
	private String orglevel;
	@FieldDesc("部门业务类型")
	private String orgbiztype;
	@FieldDesc("部门顺序号")
	private Long orderno;
	@FieldDesc("上级部门主键")
	private Long parentid;
	@FieldDesc("上级部门ORGCODE树结点路径")
	private String parenttreepath;
	@FieldDesc("部门名称拼音")
	private String orgnamepy;
	@FieldDesc("部门名称五笔")
	private String orgnamewb;
	@FieldDesc("部门简称")
	private String orgjc;
	@FieldDesc("部门全称")
	private String orgqc;
	@FieldDesc("部门地址")
	private String address;
	@FieldDesc("部门电话")
	private String linktel;
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the orgcode
	 */
	public String getOrgcode() {
		return orgcode;
	}
	/**
	 * @param orgcode the orgcode to set
	 */
	public void setOrgcode(String orgcode) {
		this.orgcode = orgcode;
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
	 * @return the orgtype
	 */
	public String getOrgtype() {
		return orgtype;
	}
	/**
	 * @param orgtype the orgtype to set
	 */
	public void setOrgtype(String orgtype) {
		this.orgtype = orgtype;
	}
	/**
	 * @return the orglevel
	 */
	public String getOrglevel() {
		return orglevel;
	}
	/**
	 * @param orglevel the orglevel to set
	 */
	public void setOrglevel(String orglevel) {
		this.orglevel = orglevel;
	}
	/**
	 * @return the orgbiztype
	 */
	public String getOrgbiztype() {
		return orgbiztype;
	}
	/**
	 * @param orgbiztype the orgbiztype to set
	 */
	public void setOrgbiztype(String orgbiztype) {
		this.orgbiztype = orgbiztype;
	}
	/**
	 * @return the orderno
	 */
	public Long getOrderno() {
		return orderno;
	}
	/**
	 * @param orderno the orderno to set
	 */
	public void setOrderno(Long orderno) {
		this.orderno = orderno;
	}
	/**
	 * @return the parentid
	 */
	public Long getParentid() {
		return parentid;
	}
	/**
	 * @param parentid the parentid to set
	 */
	public void setParentid(Long parentid) {
		this.parentid = parentid;
	}
	/**
	 * @return the parenttreepath
	 */
	public String getParenttreepath() {
		return parenttreepath;
	}
	/**
	 * @param parenttreepath the parenttreepath to set
	 */
	public void setParenttreepath(String parenttreepath) {
		this.parenttreepath = parenttreepath;
	}
	/**
	 * @return the orgnamepy
	 */
	public String getOrgnamepy() {
		return orgnamepy;
	}
	/**
	 * @param orgnamepy the orgnamepy to set
	 */
	public void setOrgnamepy(String orgnamepy) {
		this.orgnamepy = orgnamepy;
	}
	/**
	 * @return the orgnamewb
	 */
	public String getOrgnamewb() {
		return orgnamewb;
	}
	/**
	 * @param orgnamewb the orgnamewb to set
	 */
	public void setOrgnamewb(String orgnamewb) {
		this.orgnamewb = orgnamewb;
	}
	/**
	 * @return the orgjc
	 */
	public String getOrgjc() {
		return orgjc;
	}
	/**
	 * @param orgjc the orgjc to set
	 */
	public void setOrgjc(String orgjc) {
		this.orgjc = orgjc;
	}
	/**
	 * @return the orgqc
	 */
	public String getOrgqc() {
		return orgqc;
	}
	/**
	 * @param orgqc the orgqc to set
	 */
	public void setOrgqc(String orgqc) {
		this.orgqc = orgqc;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the linktel
	 */
	public String getLinktel() {
		return linktel;
	}
	/**
	 * @param linktel the linktel to set
	 */
	public void setLinktel(String linktel) {
		this.linktel = linktel;
	}

}
