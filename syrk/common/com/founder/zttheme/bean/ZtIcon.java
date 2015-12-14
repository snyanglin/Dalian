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

@DBInfoAnnotation(tableName = "ZT_ICON", pk = "id")
public class ZtIcon extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;
    
    @FieldDesc("主键")
    private Long id;
	@FieldDesc("图标路径")
	private String iconurl;
	@FieldDesc("图标类型")
	private String icontype;
	@FieldDesc("classname属性名")
	private String classname;
	@FieldDesc("菜单ID")
	private Long menuid;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getIconurl() {
		return iconurl;
	}
	public void setIconurl(String iconurl) {
		this.iconurl = iconurl;
	}
	public String getIcontype() {
		return icontype;
	}
	public void setIcontype(String icontype) {
		this.icontype = icontype;
	}
	public Long getMenuid() {
		return menuid;
	}
	public void setMenuid(Long menuid) {
		this.menuid = menuid;
	}
	public String getClassname() {
		return classname;
	}
	public void setClassname(String classname) {
		this.classname = classname;
	}
    
	
	
}
