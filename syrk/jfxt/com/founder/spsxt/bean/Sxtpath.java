package com.founder.spsxt.bean;

import java.io.Serializable;

import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

public class Sxtpath extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	private String path;
	private String msg;
	
	//2015.03.30
	@FieldDesc("照片")
	private byte[] fj;
	
	
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	//2015.03.30
	public byte[] getZp() {
		return fj;
	}

	public void setZp(byte[] fj) {
		this.fj = fj;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
