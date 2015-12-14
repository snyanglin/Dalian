package com.founder.yjjb.vo;

import com.founder.yjjb.bean.Ajxxb;
import com.founder.yjjb.bean.Jbjlspb;
import com.founder.yjjb.bean.Jbjlxxb;
import com.founder.yjjb.bean.Jlxxb;
import com.founder.yjjb.bean.Xsjbxxb;

/**
 * 举报奖励打印信息</br>
 * 举报奖励相关的信息:线索，案件，申请，审批</br>
 * 由奖励申请表（jlxxb）的申请编号,可以在举报奖励申请表（jbjlxxb）中得到对应的线索和案件信息
 * 由奖励申请表（jlxxb）的申请编号,可以再举报奖励审批表（jbjlspb）中得到对应的审批信息
 * @author dangkp
 * @since 2014-12-05
 * @version 1.0
 */
public class JbjlVO {
	
	// 奖励信息表
	private Jlxxb jlxxb;
	
	// 举报奖励信息表
	private Jbjlxxb jbjlxxb;
	
	// 线索信息
	private Xsjbxxb xsjbxxb;
	
	// 案件信息
	private Ajxxb ajxxb;
	
	// 线索案件关系表
	// private Xsajgxb xsajgxb;
	
	// 举报奖励审批表
	private Jbjlspb jbjlspb;

	public Xsjbxxb getXsjbxxb() {
		return xsjbxxb;
	}

	public void setXsjbxxb(Xsjbxxb xsjbxxb) {
		this.xsjbxxb = xsjbxxb;
	}

	public Ajxxb getAjxxb() {
		return ajxxb;
	}

	public void setAjxxb(Ajxxb ajxxb) {
		this.ajxxb = ajxxb;
	}

	public Jlxxb getJlxxb() {
		return jlxxb;
	}

	public void setJlxxb(Jlxxb jlxxb) {
		this.jlxxb = jlxxb;
	}

	public Jbjlxxb getJbjlxxb() {
		return jbjlxxb;
	}

	public void setJbjlxxb(Jbjlxxb jbjlxxb) {
		this.jbjlxxb = jbjlxxb;
	}

	public Jbjlspb getJbjlspb() {
		return jbjlspb;
	}

	public void setJbjlspb(Jbjlspb jbjlspb) {
		this.jbjlspb = jbjlspb;
	}
}
