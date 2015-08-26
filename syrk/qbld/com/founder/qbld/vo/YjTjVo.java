package com.founder.qbld.vo;

import java.io.Serializable;

/**
 * ****************************************************************************
 * @Package:      [com.founder.qbld.vo.CkyjTjVo.java]  
 * @ClassName:    [CkyjTjVo]   
 * @Description:  [预警统计Vo]   
 * @Author:       [yu_sun@founder.com.cn]  
 * @CreateDate:   [2015-4-20 下午2:23:10]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-4-20 下午2:23:10，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
public class YjTjVo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String orgcode;
	
	//常控预警待签
	private String ckyjDq;
	//常控预警待返
	private String ckyjDf;
	//预警指令待签
	private String yjzlDq;
	//预警指令待返
	private String yjzlDf;
	//临空预警待签
	private String lkyjDq;
	//临空预警待返
	private String lkyjDf;
	//临控预警指令待返
	private String lkyjzlDf;
	//临控预警指令待签
	private String lkyjzlDq;
	
	public String getLkyjzlDf() {
		return lkyjzlDf;
	}
	public void setLkyjzlDf(String lkyjzlDf) {
		this.lkyjzlDf = lkyjzlDf;
	}
	public String getLkyjzlDq() {
		return lkyjzlDq;
	}
	public void setLkyjzlDq(String lkyjzlDq) {
		this.lkyjzlDq = lkyjzlDq;
	}
	public String getOrgcode() {
		return orgcode;
	}
	public void setOrgcode(String orgcode) {
		this.orgcode = orgcode;
	}
	public String getCkyjDq() {
		return ckyjDq;
	}
	public void setCkyjDq(String ckyjDq) {
		this.ckyjDq = ckyjDq;
	}
	public String getCkyjDf() {
		return ckyjDf;
	}
	public void setCkyjDf(String ckyjDf) {
		this.ckyjDf = ckyjDf;
	}
	public String getYjzlDq() {
		return yjzlDq;
	}
	public void setYjzlDq(String yjzlDq) {
		this.yjzlDq = yjzlDq;
	}
	public String getYjzlDf() {
		return yjzlDf;
	}
	public void setYjzlDf(String yjzlDf) {
		this.yjzlDf = yjzlDf;
	}
	public String getLkyjDq() {
		return lkyjDq;
	}
	public void setLkyjDq(String lkyjDq) {
		this.lkyjDq = lkyjDq;
	}
	public String getLkyjDf() {
		return lkyjDf;
	}
	public void setLkyjDf(String lkyjDf) {
		this.lkyjDf = lkyjDf;
	}
}
