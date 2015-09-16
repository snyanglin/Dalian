package com.founder.sydw.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

@DBInfoAnnotation(tableName = "DW_XQJBXXB", pk = "id")
public class Dwxqxxb extends BaseEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@FieldDesc("ID")
	private String id;
	@FieldDesc("小区名称")
	private String xqmc;
	@FieldDesc("小区负责人")
	private String xqfzr;
	@FieldDesc("物业名称")
	private String wymc;
	@FieldDesc("物业联系电话")
	private String wylxdh;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getXqmc() {
		return xqmc;
	}
	public void setXqmc(String xqmc) {
		this.xqmc = xqmc;
	}
	public String getXqfzr() {
		return xqfzr;
	}
	public void setXqfzr(String xqfzr) {
		this.xqfzr = xqfzr;
	}
	public String getWymc() {
		return wymc;
	}
	public void setWymc(String wymc) {
		this.wymc = wymc;
	}
	public String getWylxdh() {
		return wylxdh;
	}
	public void setWylxdh(String wylxdh) {
		this.wylxdh = wylxdh;
	}
	
	
}
