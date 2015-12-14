package com.founder.zttheme.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

@DBInfoAnnotation(tableName = "org_user_menu", pk = "id")
public class OrgUserMenuBean extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@FieldDesc("主键")
	private Long id;
	@FieldDesc("人员ID")
	private Long userid;
	@FieldDesc("菜单ID")
	private Long menuid;
	@FieldDesc("菜单顺序号")
	private Long orderno;
	@FieldDesc("最后修改时间")
	private String xt_zhxgsj;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getUserid() {
		return userid;
	}
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	public Long getMenuid() {
		return menuid;
	}
	public void setMenuid(Long menuid) {
		this.menuid = menuid;
	}
	public Long getOrderno() {
		return orderno;
	}
	public void setOrderno(Long orderno) {
		this.orderno = orderno;
	}
	public String getXt_zhxgsj() {
		return xt_zhxgsj;
	}
	public void setXt_zhxgsj(String xt_zhxgsj) {
		this.xt_zhxgsj = xt_zhxgsj;
	}
	
	
	
}
