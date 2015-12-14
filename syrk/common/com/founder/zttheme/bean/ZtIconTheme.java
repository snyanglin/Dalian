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

@DBInfoAnnotation(tableName = "ZT_ICON_THEME", pk = "id")
public class ZtIconTheme extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@FieldDesc("主键")
	private Long id;
	@FieldDesc("主题ID")
	private Long themeid;
	@FieldDesc("图标ID")
	private Long iconid;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getThemeid() {
		return themeid;
	}
	public void setThemeid(Long themeid) {
		this.themeid = themeid;
	}
	public Long getIconid() {
		return iconid;
	}
	public void setIconid(Long iconid) {
		this.iconid = iconid;
	}
    
	
	
}
