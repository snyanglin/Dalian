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

@DBInfoAnnotation(tableName = "ZT_THEME", pk = "id")
public class ZtTheme extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@FieldDesc("主键")
	private Long id;
	@FieldDesc("名称")
	private String mc;
	@FieldDesc("预览图")
	private String ylt;
	@FieldDesc("主题样式文件名")
	private String css;
	@FieldDesc("主题js文件名")
	private String js;
	
	private String page1;//临时字段
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMc() {
		return mc;
	}
	public void setMc(String mc) {
		this.mc = mc;
	}
	public String getYlt() {
		return ylt;
	}
	public void setYlt(String ylt) {
		this.ylt = ylt;
	}
	public String getCss() {
		return css;
	}
	public void setCss(String css) {
		this.css = css;
	}
	public String getJs() {
		return js;
	}
	public void setJs(String js) {
		this.js = js;
	}
	public String getPage1() {
		return page1;
	}
	public void setPage1(String page1) {
		this.page1 = page1;
	}
	
    
	
	
}
