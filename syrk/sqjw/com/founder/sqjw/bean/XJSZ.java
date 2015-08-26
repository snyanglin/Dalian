package com.founder.sqjw.bean;
import java.io.Serializable;
import com.founder.framework.base.entity.BaseEntity;
/**
 * @类名: XJSZ 
 * @描述:(类描述) 
 * @日期: 2014-12-15 下午10:57:56 
 */
public class XJSZ extends BaseEntity implements Serializable{
	private static final long serialVersionUID = 1L;

	private String id;
	private String userid;
	private String pro;
	private String sfxz;
	private String type;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSfxz() {
		return sfxz;
	}
	public void setSfxz(String sfxz) {
		this.sfxz = sfxz;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPro() {
		return pro;
	}
	public void setPro(String pro) {
		this.pro = pro;
	}
	
	
	
}