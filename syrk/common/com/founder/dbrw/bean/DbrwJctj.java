package com.founder.dbrw.bean;

import java.io.Serializable;

import com.founder.framework.base.entity.BaseEntity;

public class DbrwJctj extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	private String fqrbmid;
	private String fqrbm;
	private String yearsum_fq;
	private String monthsum_fq;
	private String yearsum_cl;
	private String monthsum_cl;
	/**
	 * @return the fqrbmid
	 */
	public String getFqrbmid() {
		return fqrbmid;
	}
	/**
	 * @param fqrbmid the fqrbmid to set
	 */
	public void setFqrbmid(String fqrbmid) {
		this.fqrbmid = fqrbmid;
	}
	/**
	 * @return the fqrbm
	 */
	public String getFqrbm() {
		return fqrbm;
	}
	/**
	 * @param fqrbm the fqrbm to set
	 */
	public void setFqrbm(String fqrbm) {
		this.fqrbm = fqrbm;
	}
	/**
	 * @return the yearsum_fq
	 */
	public String getYearsum_fq() {
		return yearsum_fq;
	}
	/**
	 * @param yearsum_fq the yearsum_fq to set
	 */
	public void setYearsum_fq(String yearsum_fq) {
		this.yearsum_fq = yearsum_fq;
	}
	/**
	 * @return the monthsum_fq
	 */
	public String getMonthsum_fq() {
		return monthsum_fq;
	}
	/**
	 * @param monthsum_fq the monthsum_fq to set
	 */
	public void setMonthsum_fq(String monthsum_fq) {
		this.monthsum_fq = monthsum_fq;
	}
	/**
	 * @return the yearsum_cl
	 */
	public String getYearsum_cl() {
		return yearsum_cl;
	}
	/**
	 * @param yearsum_cl the yearsum_cl to set
	 */
	public void setYearsum_cl(String yearsum_cl) {
		this.yearsum_cl = yearsum_cl;
	}
	/**
	 * @return the monthsum_cl
	 */
	public String getMonthsum_cl() {
		return monthsum_cl;
	}
	/**
	 * @param monthsum_cl the monthsum_cl to set
	 */
	public void setMonthsum_cl(String monthsum_cl) {
		this.monthsum_cl = monthsum_cl;
	}
	
	
}
