/**********************************************************************   
 * <p>文件名：Dwjctype.java </p>
 * <p>文件描述：单位检查大类
 * @project_name：sydw
 * @author	yu_guangli@founder.com.cn 
 * @date 2015-6-6 下午12:07:03 
 * @history
 * @department：研发部
 *
 */
package com.founder.sydw.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;
/**
 * @描述: 单位检查类目
 * @作者:yu_guangli@founder.com 
 * @日期： 2015-6-5 下午1:28:39 
 * @throws
 */
@DBInfoAnnotation(tableName = "DW_DWJC_TYPE", pk = "id")
public class Dwjctype extends BaseEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@FieldDesc("ID")
	private String id;
	@FieldDesc("显示内容")
	private String name;
	@FieldDesc("实有单位类型")
	private String sydwlx;
	@FieldDesc("检查ID")
	private String jcid;
	@FieldDesc("检查类型ID")
	private String typeid;
	@FieldDesc("显示多个内容")
	private String[] names;
	@FieldDesc("业务类别代码")
	private String ywlbdm;
	@FieldDesc("排序")
	private String px;
	private List<Dwjcdata> list = new ArrayList<Dwjcdata>();
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
	public String getSydwlx() {
		return sydwlx;
	}
	public void setSydwlx(String sydwlx) {
		this.sydwlx = sydwlx;
	}
	public List<Dwjcdata> getList() {
		return list;
	}
	public void setList(List<Dwjcdata> list) {
		this.list = list;
	}
	public String getJcid() {
		return jcid;
	}
	public void setJcid(String jcid) {
		this.jcid = jcid;
	}
	public String getTypeid() {
		return typeid;
	}
	public void setTypeid(String typeid) {
		this.typeid = typeid;
	}
	public String[] getNames() {
		return names;
	}
	public void setNames(String[] names) {
		this.names = names;
	}
	public String getYwlbdm() {
		return ywlbdm;
	}
	public void setYwlbdm(String ywlbdm) {
		this.ywlbdm = ywlbdm;
	}
	public String getPx() {
		return px;
	}
	public void setPx(String px) {
		this.px = px;
	}
}
