package com.founder.spsxt.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

//NVR基本信息
@DBInfoAnnotation(tableName = "JF_NVRJBXX", pk = "id")
public class NvrInfo extends BaseEntity implements Serializable{
	
	private static final long serialVersionUID = -1L;	
	
	@FieldDesc("id")private String id ;//主键		
		
	@FieldDesc("sbip")private String sbIp ;//设备Ip
	@FieldDesc("sbmc")private String sbMc ;//设备名称
	@FieldDesc("ccsc")private long ccsc ;//存储时长
	
	@FieldDesc("pt_id")private String pt_id ;//关联‘平台表’外键

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSbIp() {
		return sbIp;
	}

	public void setSbIp(String sbIp) {
		this.sbIp = sbIp;
	}

	public String getSbMc() {
		return sbMc;
	}

	public void setSbMc(String sbMc) {
		this.sbMc = sbMc;
	}

	public long getCcsc() {
		return ccsc;
	}

	public void setCcsc(long ccsc) {
		this.ccsc = ccsc;
	}

	public String getPt_id() {
		return pt_id;
	}

	public void setPt_id(String pt_id) {
		this.pt_id = pt_id;
	}
	
}
