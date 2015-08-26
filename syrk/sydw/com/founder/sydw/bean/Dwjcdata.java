/**********************************************************************   
 * <p>文件名：Dwjcdata.java </p>
 * <p>文件描述：单位检查项
 * @project_name：sydw
 * @author	yu_guangli@founder.com.cn 
 * @date 2015-6-6 下午12:07:03 
 * @history
 * @department：研发部
 *
 */
package com.founder.sydw.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;
/**
 * @描述: 单位检查项
 * @作者:yu_guangli@founder.com 
 * @日期： 2015-6-5 下午1:28:39 
 * @throws
 */
@DBInfoAnnotation(tableName = "DW_DWJC_DATA", pk = "id")
public class Dwjcdata extends BaseEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@FieldDesc("ID")
	private String id;
	@FieldDesc("检查ID")
	private String jcid;
	@FieldDesc("显示内容")
	private String name;
	@FieldDesc("默认选中值：0为是，1为否")
	private String def;
	@FieldDesc("备注")
	private String bz;
	@FieldDesc("单位治安检查 子表检查类型——主键 ID")
	private String typeid;
	@FieldDesc("检查项ID（配置）")
	private String dataid;
	@FieldDesc("显示多个内容")
	private String[] names;
	@FieldDesc("多个默认")
	private String[] defs;
	@FieldDesc("排序")
	private String px;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDef() {
		return def;
	}
	public void setDef(String def) {
		this.def = def;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	public String getTypeid() {
		return typeid;
	}
	public void setTypeid(String typeid) {
		this.typeid = typeid;
	}
	public String getDataid() {
		return dataid;
	}
	public void setDataid(String dataid) {
		this.dataid = dataid;
	}
	public String getJcid() {
		return jcid;
	}
	public void setJcid(String jcid) {
		this.jcid = jcid;
	}
	public String[] getNames() {
		return names;
	}
	public void setNames(String[] names) {
		this.names = names;
	}
	public String[] getDefs() {
		return defs;
	}
	public void setDefs(String[] defs) {
		this.defs = defs;
	}
	public String getPx() {
		return px;
	}
	public void setPx(String px) {
		this.px = px;
	}
}
