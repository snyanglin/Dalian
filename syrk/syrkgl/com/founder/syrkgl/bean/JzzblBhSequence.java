package com.founder.syrkgl.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;

@DBInfoAnnotation(tableName = "RY_JZZBLBHSEQUENCE", pk = "code")
public class JzzblBhSequence implements Serializable{
    
	private static final long serialVersionUID = 1L;
	
	@FieldDesc("序列查询编码")
	private String code;
	
	@FieldDesc("序列号")
	private Long sequence;
	
	@FieldDesc("版本号")
	private Long version;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Long getVersion() {
		return version;
	}
	public void setVersion(Long version) {
		this.version = version;
	}
	public Long getSequence() {
		return sequence;
	}
	public void setSequence(Long sequence) {
		this.sequence = sequence;
	}
	
}
