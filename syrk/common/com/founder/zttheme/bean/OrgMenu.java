package com.founder.zttheme.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

/**
 * 
 * 主题类<br>
 * 
 * @author redstorm
 * @version 2014-7-18
 * 
 */

@DBInfoAnnotation(tableName = "ORG_MENU", pk = "id")
public class OrgMenu extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;
    
	@FieldDesc("主键")
	private Long id;
	@FieldDesc("菜单名称")
	private String menuname;
	@FieldDesc("菜单类型")
	private String menutype;
	@FieldDesc("菜单级别")
	private String menulevel;
	@FieldDesc("菜单URL")
	private String menuurl;
	@FieldDesc("菜单打开方式")
	private String menuopenmode;
	@FieldDesc("菜单顺序号")
	private Long orderno;
	@FieldDesc("上级菜单主键")
	private Long parentid;
	@FieldDesc("备注")
	private String bz;
	@FieldDesc("菜单图片")
	private String menuimg;
	@FieldDesc("菜单系统ID(ORG_MENUSYSTEM.ID)")
	private Long systemid;
	@FieldDesc("菜单图标样式")
	private String menuicon;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMenuname() {
		return menuname;
	}
	public void setMenuname(String menuname) {
		this.menuname = menuname;
	}
	public String getMenutype() {
		return menutype;
	}
	public void setMenutype(String menutype) {
		this.menutype = menutype;
	}
	public String getMenulevel() {
		return menulevel;
	}
	public void setMenulevel(String menulevel) {
		this.menulevel = menulevel;
	}
	public String getMenuurl() {
		return menuurl;
	}
	public void setMenuurl(String menuurl) {
		this.menuurl = menuurl;
	}
	public String getMenuopenmode() {
		return menuopenmode;
	}
	public void setMenuopenmode(String menuopenmode) {
		this.menuopenmode = menuopenmode;
	}
	public Long getOrderno() {
		return orderno;
	}
	public void setOrderno(Long orderno) {
		this.orderno = orderno;
	}
	public Long getParentid() {
		return parentid;
	}
	public void setParentid(Long parentid) {
		this.parentid = parentid;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	public String getMenuimg() {
		return menuimg;
	}
	public void setMenuimg(String menuimg) {
		this.menuimg = menuimg;
	}
	public Long getSystemid() {
		return systemid;
	}
	public void setSystemid(Long systemid) {
		this.systemid = systemid;
	}
	public String getMenuicon() {
		return menuicon;
	}
	public void setMenuicon(String menuicon) {
		this.menuicon = menuicon;
	}
	
	
}
