package com.founder.syrkgl.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;


/******************************************************************************
 * @Package:      [com.founder.syrkgl.bean.RyRyhykxxb.java]  
 * @ClassName:    [RyRyhykxxb]   
 * @Description:  [人员会员卡信息表]   
 * @Author:       [congrihong@founder.com.cn]  
 * @CreateDate:   [2015-4-8 下午3:50:47]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-4-8 下午3:50:47，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 */
@DBInfoAnnotation(tableName = "RY_RYHYKXXB", pk = "id")
public class RyRyhykxxb extends BaseEntity implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@FieldDesc("人员会员卡ID")
	private String id;
	@FieldDesc("人员ID")
	private String ryid;
	@FieldDesc("发卡单位ID")
	private String fkdwid;
	@FieldDesc("发卡单位名称")
	private String fkdwmc;
	@FieldDesc("会员卡_卡号")
	private String hyk_kh;
	@FieldDesc("会员卡_获取时间")
	private String hyk_hqsj;
	@FieldDesc("会员卡_有效期截止日期")
	private String hyk_yxqjzrq;
	@FieldDesc("会员卡_消费方式代码")
	private String hyk_xffsdm;
	@FieldDesc("会员卡_原价值（元）")
	private String hyk_yjz;
	@FieldDesc("会员卡_现价值（元）")
	private String hyk_xjz;
	@FieldDesc("会员卡_注册人")
	private String hyk_zcr;
	@FieldDesc("是否实名代码")
	private String sfsmdm;
	@FieldDesc("备注")
	private String bz;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRyid() {
		return ryid;
	}
	public void setRyid(String ryid) {
		this.ryid = ryid;
	}
	public String getFkdwid() {
		return fkdwid;
	}
	public void setFkdwid(String fkdwid) {
		this.fkdwid = fkdwid;
	}
	public String getFkdwmc() {
		return fkdwmc;
	}
	public void setFkdwmc(String fkdwmc) {
		this.fkdwmc = fkdwmc;
	}
	public String getHyk_kh() {
		return hyk_kh;
	}
	public void setHyk_kh(String hyk_kh) {
		this.hyk_kh = hyk_kh;
	}
	public String getHyk_hqsj() {
		return hyk_hqsj;
	}
	public void setHyk_hqsj(String hyk_hqsj) {
		this.hyk_hqsj = hyk_hqsj;
	}
	public String getHyk_yxqjzrq() {
		return hyk_yxqjzrq;
	}
	public void setHyk_yxqjzrq(String hyk_yxqjzrq) {
		this.hyk_yxqjzrq = hyk_yxqjzrq;
	}
	public String getHyk_xffsdm() {
		return hyk_xffsdm;
	}
	public void setHyk_xffsdm(String hyk_xffsdm) {
		this.hyk_xffsdm = hyk_xffsdm;
	}

	
	
	public String getHyk_yjz() {
		return hyk_yjz;
	}
	public void setHyk_yjz(String hyk_yjz) {
		this.hyk_yjz = hyk_yjz;
	}
	public String getHyk_xjz() {
		return hyk_xjz;
	}
	public void setHyk_xjz(String hyk_xjz) {
		this.hyk_xjz = hyk_xjz;
	}
	public String getHyk_zcr() {
		return hyk_zcr;
	}
	public void setHyk_zcr(String hyk_zcr) {
		this.hyk_zcr = hyk_zcr;
	}
	public String getSfsmdm() {
		return sfsmdm;
	}
	public void setSfsmdm(String sfsmdm) {
		this.sfsmdm = sfsmdm;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}


	
}
