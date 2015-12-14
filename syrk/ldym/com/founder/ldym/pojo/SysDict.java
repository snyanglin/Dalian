package com.founder.ldym.pojo;

import com.founder.framework.base.entity.BaseEntity;


/**
 * 
 * <p>标题：字典</p>
 * <p>描述：对应数据表T_SYS_DICT</p>
 * <p>Copyright：Copyright(c) 2014 founder</p>
 * <p>日期：2014-3-11</p>
 * @author	yi_chu
 */
public class SysDict extends BaseEntity implements java.io.Serializable {

	private static final long serialVersionUID = 8184833696244640268L;
	
	/**
	 * 主键
	 */
	private Long PId;
	
	/**
	 * 字典编号
	 */
	private String zdbh;
	
	/**
	 * 字典名称
	 */
	private String zdmc;
	
	/**
	 * 字典代码
	 */
	private String dm;
	
	/**
	 * 字典词条
	 */
	private String ct;
	
	/**
	 * 字典拼音
	 */
	private String py;
	
	/**
	 * 字典五笔
	 */
	private String wb;
	
	/**
	 * 备注
	 */
	private String bz;
	
	/**
	 * 树层级
	 */
	private String treeLevel;
	
	/**
	 * 父级字典代码
	 */
	private String parentDm;
	
	/**
	 * 是否树叶子节点（1：是；0：否。）
	 */
	private Integer isTreeLeaf;
	
	public Long getPId() {
		return this.PId;
	}

	public void setPId(Long PId) {
		this.PId = PId;
	}

	public String getZdbh() {
		return this.zdbh;
	}

	public void setZdbh(String zdbh) {
		this.zdbh = zdbh;
	}

	public String getZdmc() {
		return this.zdmc;
	}

	public void setZdmc(String zdmc) {
		this.zdmc = zdmc;
	}

	public String getDm() {
		return this.dm;
	}

	public void setDm(String dm) {
		this.dm = dm;
	}

	public String getCt() {
		return this.ct;
	}

	public void setCt(String ct) {
		this.ct = ct;
	}

	public String getPy() {
		return this.py;
	}

	public void setPy(String py) {
		this.py = py;
	}

	public String getWb() {
		return this.wb;
	}

	public void setWb(String wb) {
		this.wb = wb;
	}

	public String getBz() {
		return this.bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

	public String getTreeLevel() {
		return treeLevel;
	}

	public void setTreeLevel(String treeLevel) {
		this.treeLevel = treeLevel;
	}

	public String getParentDm() {
		return parentDm;
	}

	public void setParentDm(String parentDm) {
		this.parentDm = parentDm;
	}

	public Integer getIsTreeLeaf() {
		return isTreeLeaf;
	}

	public void setIsTreeLeaf(Integer isTreeLeaf) {
		this.isTreeLeaf = isTreeLeaf;
	}

}