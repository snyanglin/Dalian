package com.founder.qbld.bean;

import java.io.Serializable;
import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

/**
 * ****************************************************************************
 * @Package:      [com.founder.qbld.bean.CkyjQsxxb.java]  
 * @ClassName:    [CkyjQsxxb]   
 * @Description:  [常控预警签收信息表]   
 * @Author:       [yu_sun@founder.com.cn]  
 * @CreateDate:   [2015-4-13 上午9:59:20]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-4-13 上午9:59:20，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@DBInfoAnnotation(tableName = "QBLD_CK_YJQSB", pk = "yjxxbh")
public class CkyjxxQsb extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@FieldDesc("情报联动唯一编号")
	private String ldxxbh;
	@FieldDesc("预警信息编号")
	private String yjxxbh;
	@FieldDesc("签收常控预警情报信息的时间，采用格式YYYYMMDDhhmmss，24小时格式")
	private String qssj;
	@FieldDesc("签收人身份证号,采用GA/Z 02 D1000")
	private String qsrsfzh;
	@FieldDesc("签收人姓名")
	private String qsrxm;
	@FieldDesc("采签收单位,用GA/Z 02 D3006")
	private String qsdw;
	@FieldDesc("签收单位机构代码,采用GA/Z 02 D3000")
	private String qsdwjgdm;
	@FieldDesc("入库时间")
	private String rksj;
	@FieldDesc("修改时间")
	private String xgsj;
	@FieldDesc("接口反馈时间")
	private String jkfksj;
	@FieldDesc("接口反馈状态 '0' 未反馈 '1' 已反馈")
	private String jkfkzt;
	
	public String getLdxxbh() {
		return ldxxbh;
	}
	public void setLdxxbh(String ldxxbh) {
		this.ldxxbh = ldxxbh;
	}
	public String getYjxxbh() {
		return yjxxbh;
	}
	public void setYjxxbh(String yjxxbh) {
		this.yjxxbh = yjxxbh;
	}
	public String getQssj() {
		return qssj;
	}
	public void setQssj(String qssj) {
		this.qssj = qssj;
	}
	public String getQsrsfzh() {
		return qsrsfzh;
	}
	public void setQsrsfzh(String qsrsfzh) {
		this.qsrsfzh = qsrsfzh;
	}
	public String getQsrxm() {
		return qsrxm;
	}
	public void setQsrxm(String qsrxm) {
		this.qsrxm = qsrxm;
	}
	public String getQsdw() {
		return qsdw;
	}
	public void setQsdw(String qsdw) {
		this.qsdw = qsdw;
	}
	public String getQsdwjgdm() {
		return qsdwjgdm;
	}
	public void setQsdwjgdm(String qsdwjgdm) {
		this.qsdwjgdm = qsdwjgdm;
	}
	public String getRksj() {
		return rksj;
	}
	public void setRksj(String rksj) {
		this.rksj = rksj;
	}
	public String getXgsj() {
		return xgsj;
	}
	public void setXgsj(String xgsj) {
		this.xgsj = xgsj;
	}
	public String getJkfksj() {
		return jkfksj;
	}
	public void setJkfksj(String jkfksj) {
		this.jkfksj = jkfksj;
	}
	public String getJkfkzt() {
		return jkfkzt;
	}
	public void setJkfkzt(String jkfkzt) {
		this.jkfkzt = jkfkzt;
	}

}
