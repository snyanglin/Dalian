package com.founder.sydw.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;
/**
 * ****************************************************************************
 * @Package:      [com.founder.sydw.bean.Dwzdhzyhzgtzs.java]  
 * @ClassName:    [Dwzdhzyhzgtzs]   
 * @Description:  单位重大火灾隐患整改通知书
 * @Author:       [yu_guangli@founder.com.cn]  
 * @CreateDate:   [2015-6-24 下午1:36:19]   
 * @UpdateUser:   [yuguangli(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-6-24 下午1:36:19，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@DBInfoAnnotation(tableName = "DW_ZDHZYHZGTZS", pk = "id")
public class Dwzdhzyhzgtzs extends BaseEntity implements Serializable {

	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 */
	private static final long serialVersionUID = 1L;
	@FieldDesc("主键")
	private String id;
	@FieldDesc("检查ID")
	private String jcid;
	@FieldDesc("单位ID")
	private String dwid;
	@FieldDesc("公文号")
	private String gwh;
	@FieldDesc("消号")
	private String xxh;
	@FieldDesc("编号")
	private String bh;
	@FieldDesc("序号")
	private String xh;
	@FieldDesc("火灾隐患代码")
	private String hzyhdm;
	@FieldDesc("火灾隐患内容")
	private String hzyhnr;
	@FieldDesc("被检查单位负责人签名")
	private String dwfzrqm;
	@FieldDesc("被检查单位负责人签名日期")
	private String dwfzrqmrq;
	@FieldDesc("单位名称")
	private String dwmc;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getJcid() {
		return jcid;
	}
	public void setJcid(String jcid) {
		this.jcid = jcid;
	}
	public String getDwid() {
		return dwid;
	}
	public void setDwid(String dwid) {
		this.dwid = dwid;
	}
	public String getGwh() {
		return gwh;
	}
	public void setGwh(String gwh) {
		this.gwh = gwh;
	}
	public String getXxh() {
		return xxh;
	}
	public void setXxh(String xxh) {
		this.xxh = xxh;
	}
	public String getBh() {
		return bh;
	}
	public void setBh(String bh) {
		this.bh = bh;
	}
	public String getXh() {
		return xh;
	}
	public void setXh(String xh) {
		this.xh = xh;
	}
	public String getHzyhdm() {
		return hzyhdm;
	}
	public void setHzyhdm(String hzyhdm) {
		this.hzyhdm = hzyhdm;
	}
	public String getHzyhnr() {
		return hzyhnr;
	}
	public void setHzyhnr(String hzyhnr) {
		this.hzyhnr = hzyhnr;
	}
	public String getDwfzrqm() {
		return dwfzrqm;
	}
	public void setDwfzrqm(String dwfzrqm) {
		this.dwfzrqm = dwfzrqm;
	}
	public String getDwfzrqmrq() {
		return dwfzrqmrq;
	}
	public void setDwfzrqmrq(String dwfzrqmrq) {
		this.dwfzrqmrq = dwfzrqmrq;
	}
	public String getDwmc() {
		return dwmc;
	}
	public void setDwmc(String dwmc) {
		this.dwmc = dwmc;
	}
}
