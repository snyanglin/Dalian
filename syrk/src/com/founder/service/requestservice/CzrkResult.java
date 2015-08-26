package com.founder.service.requestservice;

/**
 * 全国常住人口
 * 
 * @author redstorm
 * @version 2014-7-8
 * 
 */

public class CzrkResult implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 公民身份号码
	 */
	private String SFZH = "";

	/**
	 * 姓名
	 */
	private String XM = "";

	/**
	 * 曾用名
	 */
	private String CYM = "";

	/**
	 * 性别
	 */
	private String XB = "";

	/**
	 * 出生日期
	 */
	private String CSRQ = "";

	/**
	 * 户籍地住址省市县区
	 */
	private String ZZSSX = "";

	/**
	 * 户籍地住址详址
	 */
	private String ZZXZ = "";

	/**
	 * 籍贯所属市县区
	 */
	private String JGSSX = "";

	/**
	 * 民族
	 */
	private String MZ = "";

	/**
	 * 文化程度
	 */
	private String WHCD = "";

	/**
	 * 婚姻状况
	 */
	private String HYZK = "";

	/**
	 * 职业
	 */
	private String ZY = "";

	/**
	 * 人员照片
	 */
	private String XP = "";

	public String getSFZH() {
		return SFZH;
	}

	public void setSFZH(String sFZH) {
		SFZH = sFZH;
	}

	public String getXM() {
		return XM;
	}

	public void setXM(String xM) {
		XM = xM;
	}

	public String getCYM() {
		return CYM;
	}

	public void setCYM(String cYM) {
		CYM = cYM;
	}

	public String getXB() {
		return XB;
	}

	public void setXB(String xB) {
		XB = xB;
	}

	public String getCSRQ() {
		return CSRQ;
	}

	public void setCSRQ(String cSRQ) {
		CSRQ = cSRQ;
	}

	public String getZZSSX() {
		return ZZSSX;
	}

	public void setZZSSX(String zZSSX) {
		ZZSSX = zZSSX;
	}

	public String getZZXZ() {
		return ZZXZ;
	}

	public void setZZXZ(String zZXZ) {
		ZZXZ = zZXZ;
	}

	public String getJGSSX() {
		return JGSSX;
	}

	public void setJGSSX(String jGSSX) {
		JGSSX = jGSSX;
	}

	public String getMZ() {
		return MZ;
	}

	public void setMZ(String mZ) {
		MZ = mZ;
	}

	public String getWHCD() {
		return WHCD;
	}

	public void setWHCD(String wHCD) {
		WHCD = wHCD;
	}

	public String getHYZK() {
		return HYZK;
	}

	public void setHYZK(String hYZK) {
		HYZK = hYZK;
	}

	public String getZY() {
		return ZY;
	}

	public void setZY(String zY) {
		ZY = zY;
	}

	public String getXP() {
		return XP;
	}

	public void setXP(String xP) {
		XP = xP;
	}

}
