package com.founder.qbld.bean;

import java.io.Serializable;
import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

/**
 * ****************************************************************************
 * @Package:      [com.founder.qbld.bean.LkyjzlQsb.java]  
 * @ClassName:    [LkyjzlQsb]   
 * @Description:  [临控预警指令表]   
 * @Author:       [yu_sun@founder.com.cn]  
 * @CreateDate:   [2015-6-8 上午9:41:35]   
 * @UpdateUser:   [founder(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-6-8 上午9:41:35，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@DBInfoAnnotation(tableName = "QBLD_LK_ZLQSB", pk = "lkzlbh")
public class LkyjzlQsb extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@FieldDesc("情报联动唯一编号")
	private String ldxxbh;
	@FieldDesc("采用GA XXX.2中的重点人员临控指令类型代码")
	private String lkzllx;
	@FieldDesc("所签收反馈的重点人员临控指令编号，采用GA XXX.2中的重点人员临控指令编号编码方法")
	private String lkzlbh;
	@FieldDesc("签收预警信息的时间，采用格式YYYYMMDDhhmmss，24小时格式")
	private String qssj;
	@FieldDesc("签收人身份证号,采用GA/Z 02 D1000")
	private String qsrsfzh;
	@FieldDesc("签收人姓名,采用GA/Z 02 D1001")
	private String qsrxm;
	@FieldDesc("签收人所属公安机关，采用GA/Z 02 D3006")
	private String qsdw;
	@FieldDesc("签收单位机构代码,采用GA/Z 02 D3000")
	private String qsdwjgdm;
	@FieldDesc("接口发送状态， ‘0’发送成功；‘1’发送失败")
	private String fszt;
	@FieldDesc("接口调用状态码")
	private String code;
	
	public String getFszt() {
		return fszt;
	}
	public void setFszt(String fszt) {
		this.fszt = fszt;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getLdxxbh() {
		return ldxxbh;
	}
	public void setLdxxbh(String ldxxbh) {
		this.ldxxbh = ldxxbh;
	}
	public String getLkzllx() {
		return lkzllx;
	}
	public void setLkzllx(String lkzllx) {
		this.lkzllx = lkzllx;
	}
	public String getLkzlbh() {
		return lkzlbh;
	}
	public void setLkzlbh(String lkzlbh) {
		this.lkzlbh = lkzlbh;
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

}
