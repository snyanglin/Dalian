package com.founder.service.requestservice;

/**
 * 全国在逃人员
 * 
 * @author redstorm
 * @version 2014-7-8
 * 
 */

public class ZtryResult implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 身份证号
	 */
	private String SFZH = "";

	/**
	 * 姓名
	 */
	private String XM = "";

	/**
	 * 性别
	 */
	private String XB = "";

	/**
	 * 出生日期
	 */
	private String CSRQ = "";

	/**
	 * 户籍地省市县（区）
	 */
	private String HJDSSXQ = "";

	/**
	 * 现住详细地址
	 */
	private String XZXXDZ = "";

	/**
	 * 现住省市县（区）
	 */
	private String XZSSXQ = "";

	/**
	 * 汉语口音
	 */
	private String HYKY = "";

	/**
	 * 案件编号
	 */
	private String AJBH = "";

	/**
	 * 案件类别
	 */
	private String AJLB = "";

	/**
	 * 人员编号 T+行政区划(6)+科所队编码(3)+年度(4)+月(2)+顺序号(4)
	 */
	private String RYBH = "";

	/**
	 * 逃跑日期
	 */
	private String TPRQ = "";

	/**
	 * 身高
	 */
	private String SG = "";

	/**
	 * 联系人电话
	 */
	private String LXRDH = "";

	/**
	 * 立案单位省市县（区）
	 */
	private String LASSXQ = "";

	/**
	 * 立案单位名称
	 */
	private String LADWMC = "";

	/**
	 * 简要案情
	 */
	private String JYAQ = "";

	/**
	 * 国内通缉编号
	 */
	private String GNTJBH = "";

	/**
	 * 督捕级别
	 */
	private String DBJB = "";

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

	public String getHJDSSXQ() {
		return HJDSSXQ;
	}

	public void setHJDSSXQ(String hJDSSXQ) {
		HJDSSXQ = hJDSSXQ;
	}

	public String getXZXXDZ() {
		return XZXXDZ;
	}

	public void setXZXXDZ(String xZXXDZ) {
		XZXXDZ = xZXXDZ;
	}

	public String getXZSSXQ() {
		return XZSSXQ;
	}

	public void setXZSSXQ(String xZSSXQ) {
		XZSSXQ = xZSSXQ;
	}

	public String getHYKY() {
		return HYKY;
	}

	public void setHYKY(String hYKY) {
		HYKY = hYKY;
	}

	public String getAJBH() {
		return AJBH;
	}

	public void setAJBH(String aJBH) {
		AJBH = aJBH;
	}

	public String getAJLB() {
		return AJLB;
	}

	public void setAJLB(String aJLB) {
		AJLB = aJLB;
	}

	public String getRYBH() {
		return RYBH;
	}

	public void setRYBH(String rYBH) {
		RYBH = rYBH;
	}

	public String getTPRQ() {
		return TPRQ;
	}

	public void setTPRQ(String tPRQ) {
		TPRQ = tPRQ;
	}

	public String getSG() {
		return SG;
	}

	public void setSG(String sG) {
		SG = sG;
	}

	public String getLXRDH() {
		return LXRDH;
	}

	public void setLXRDH(String lXRDH) {
		LXRDH = lXRDH;
	}

	public String getLASSXQ() {
		return LASSXQ;
	}

	public void setLASSXQ(String lASSXQ) {
		LASSXQ = lASSXQ;
	}

	public String getLADWMC() {
		return LADWMC;
	}

	public void setLADWMC(String lADWMC) {
		LADWMC = lADWMC;
	}

	public String getJYAQ() {
		return JYAQ;
	}

	public void setJYAQ(String jYAQ) {
		JYAQ = jYAQ;
	}

	public String getGNTJBH() {
		return GNTJBH;
	}

	public void setGNTJBH(String gNTJBH) {
		GNTJBH = gNTJBH;
	}

	public String getDBJB() {
		return DBJB;
	}

	public void setDBJB(String dBJB) {
		DBJB = dBJB;
	}

}
