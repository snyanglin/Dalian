package com.founder.drools.base.zdry.model;

import java.io.Serializable;

/**
 * 重口业务操作信息
 * <br>是否可转类，单列管（及单列管的列管角色）/双列管信息
 * 
 * @author guo_tianlin@founder.com.cn
 *
 */
public class ZdryGlOperationInfoBean implements Serializable{

	private static final long serialVersionUID = -6081289034750292489L;

	/** 重点人员管理类型代码 */
	private String zdryGllxdm;
	
	/** 是否可转类 */
	private boolean sfZl = false;
	
	/**
	 * 列管类型：<br>
	 * <ul>
	 * 		<li>1：单列管</li>
	 * 		<li>2：双列管</li>
	 * </ul>
	 */
	private String lglx = "1";
	
	/**
	 * 列管角色：<br>
	 * <ul>
	 * 		<li>hjd：户籍地</li>
	 * 		<li>xzd：现住地</li>
	 * </ul>
	 */
	private String lgjs ;
	
	public String getLglx() {
		return lglx;
	}

	public void setLglx(String lglx) {
		this.lglx = lglx;
	}

	public boolean isSfZl() {
		return sfZl;
	}

	public void setSfZl(boolean sfZl) {
		this.sfZl = sfZl;
	}

	public String getZdryGllxdm() {
		return zdryGllxdm;
	}

	public void setZdryGllxdm(String zdryGllxdm) {
		this.zdryGllxdm = zdryGllxdm;
	}

	public String getLgjs() {
		return lgjs;
	}

	public void setLgjs(String lgjs) {
		this.lgjs = lgjs;
	}

}
