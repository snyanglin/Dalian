package com.founder.jzym.bean;
import java.io.Serializable;
import com.founder.framework.base.entity.BaseEntity;

public class Sf extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String cons;
	private String consFd;
	private String consLow;
	private String consHeigh;
	private String orgcode;
	private String dateType;
	private String dateValue;
	public String getCons() {
		return cons;
	}
	public void setCons(String cons) {
		this.cons = cons;
	}
	public String getConsFd() {
		return consFd;
	}
	public void setConsFd(String consFd) {
		this.consFd = consFd;
	}
	public String getConsLow() {
		return consLow;
	}
	public void setConsLow(String consLow) {
		this.consLow = consLow;
	}
	public String getConsHeigh() {
		return consHeigh;
	}
	public void setConsHeigh(String consHeigh) {
		this.consHeigh = consHeigh;
	}
	
	public String getOrgcode() {
		return orgcode;
	}
	public void setOrgcode(String orgcode) {
		this.orgcode = orgcode;
	}
	public String getDateType() {
		return dateType;
	}
	public void setDateType(String dateType) {
		this.dateType = dateType;
	}
	public String getDateValue() {
		return dateValue;
	}
	public void setDateValue(String dateValue) {
		this.dateValue = dateValue;
	}
	
	
}
