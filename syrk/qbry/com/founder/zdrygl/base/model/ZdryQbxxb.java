package com.founder.zdrygl.base.model;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;
import com.founder.zdrygl.core.model.Zdry;

/**
 * ****************************************************************************
 * @Package:      [com.founder.zdrygl.base.model.ZdryQbxxb.java]  
 * @ClassName:    [ZdryQbxxb]   
 * @Description:  [重点人员情报信息表]   
 * @Author:       [zhang.hai@founder.com.cn]  
 * @CreateDate:   [2015年12月25日 上午10:06:06]   
 * @UpdateUser:   [ZhangHai(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015年12月25日 上午10:06:06，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@DBInfoAnnotation(tableName = "ZDRY_QBRYXXB", pk = "ID")
public class ZdryQbxxb extends BaseEntity implements Serializable, Zdry {

	private static final long serialVersionUID = 1L;

	@FieldDesc("情报人员ID") private String id;
	@FieldDesc("部级重点人员编号") private String bjzdrybh;
	@FieldDesc("姓名") private String xm;
	@FieldDesc("姓名拼音") private String xmhypy;
	@FieldDesc("外文姓名") private String wwxm;
	@FieldDesc("性别") private String xbdm;
	@FieldDesc("出生日期") private String csrq;
	@FieldDesc("国籍") private String gjdm;
	@FieldDesc("身份证号") private String gmsfhm;
	@FieldDesc("其他证件号码") private String qtzjhm;
	@FieldDesc("民族") private String mzdm;
	@FieldDesc("籍贯") private String jgssxdm;
	@FieldDesc("户籍地") private String hjd;
	@FieldDesc("现住地") private String xzd;
	@FieldDesc("现住地派出所名称") private String xzdpcsmc;
	@FieldDesc("现住地派出所代码") private String xzdpcsdm;
	@FieldDesc("居住地") private String jzd;
	@FieldDesc("管辖单位") private String gxdwmc;
	@FieldDesc("管辖单位机构代码") private String gxdwdm;
	@FieldDesc("立案单位") private String ladwmc;
	@FieldDesc("立案单位机构代码") private String ladwdm;
	@FieldDesc("立案时间") private String lasj;
	@FieldDesc("部级重点人员入库时间") private String bjzdryrksj;
	@FieldDesc("情报人员类别（小类）") private String zdrylb;
	@FieldDesc("情报人员管理类型代码（大类）") private String zdrygllxdm;
	@FieldDesc("有效性") private String yxx;
	@FieldDesc("ETL时间") private String etldate;	
	@FieldDesc("实有人口ID") private String syrkid;
	@FieldDesc("情报人员所属支队") private String qbzd;
	@FieldDesc("情报人员所属支队名称") private String qbzdmc;
	@FieldDesc("情报人员所属大队") private String qbdd;
	@FieldDesc("情报人员所属大队名称") private String qbddmc;
	@FieldDesc("情报人员所属派出所") private String qbpcs;
	@FieldDesc("情报人员所属派出所名称") private String qbpcsmc;
	@FieldDesc("情报人员所属责任区") private String qbzrq;
	@FieldDesc("情报人员所属责任区名称") private String qbzrqmc;
	@FieldDesc("当前级别") private String dqjb;
	@FieldDesc("管理状态") private String glzt;
	@FieldDesc("备注") private String bz;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBjzdrybh() {
		return bjzdrybh;
	}
	public void setBjzdrybh(String bjzdrybh) {
		this.bjzdrybh = bjzdrybh;
	}
	public String getXm() {
		return xm;
	}
	public void setXm(String xm) {
		this.xm = xm;
	}
	public String getXmhypy() {
		return xmhypy;
	}
	public void setXmhypy(String xmhypy) {
		this.xmhypy = xmhypy;
	}
	public String getWwxm() {
		return wwxm;
	}
	public void setWwxm(String wwxm) {
		this.wwxm = wwxm;
	}
	public String getXbdm() {
		return xbdm;
	}
	public void setXbdm(String xbdm) {
		this.xbdm = xbdm;
	}
	public String getCsrq() {
		return csrq;
	}
	public void setCsrq(String csrq) {
		this.csrq = csrq;
	}
	public String getGjdm() {
		return gjdm;
	}
	public void setGjdm(String gjdm) {
		this.gjdm = gjdm;
	}
	public String getGmsfhm() {
		return gmsfhm;
	}
	public void setGmsfhm(String gmsfhm) {
		this.gmsfhm = gmsfhm;
	}
	public String getQtzjhm() {
		return qtzjhm;
	}
	public void setQtzjhm(String qtzjhm) {
		this.qtzjhm = qtzjhm;
	}
	public String getMzdm() {
		return mzdm;
	}
	public void setMzdm(String mzdm) {
		this.mzdm = mzdm;
	}
	public String getJgssxdm() {
		return jgssxdm;
	}
	public void setJgssxdm(String jgssxdm) {
		this.jgssxdm = jgssxdm;
	}
	public String getHjd() {
		return hjd;
	}
	public void setHjd(String hjd) {
		this.hjd = hjd;
	}
	public String getXzd() {
		return xzd;
	}
	public void setXzd(String xzd) {
		this.xzd = xzd;
	}
	public String getXzdpcsmc() {
		return xzdpcsmc;
	}
	public void setXzdpcsmc(String xzdpcsmc) {
		this.xzdpcsmc = xzdpcsmc;
	}
	public String getXzdpcsdm() {
		return xzdpcsdm;
	}
	public void setXzdpcsdm(String xzdpcsdm) {
		this.xzdpcsdm = xzdpcsdm;
	}
	public String getJzd() {
		return jzd;
	}
	public void setJzd(String jzd) {
		this.jzd = jzd;
	}
	public String getGxdwmc() {
		return gxdwmc;
	}
	public void setGxdwmc(String gxdwmc) {
		this.gxdwmc = gxdwmc;
	}
	public String getGxdwdm() {
		return gxdwdm;
	}
	public void setGxdwdm(String gxdwdm) {
		this.gxdwdm = gxdwdm;
	}
	public String getLadwmc() {
		return ladwmc;
	}
	public void setLadwmc(String ladwmc) {
		this.ladwmc = ladwmc;
	}
	public String getLadwdm() {
		return ladwdm;
	}
	public void setLadwdm(String ladwdm) {
		this.ladwdm = ladwdm;
	}
	public String getLasj() {
		return lasj;
	}
	public void setLasj(String lasj) {
		this.lasj = lasj;
	}
	public String getBjzdryrksj() {
		return bjzdryrksj;
	}
	public void setBjzdryrksj(String bjzdryrksj) {
		this.bjzdryrksj = bjzdryrksj;
	}
	public String getZdrylb() {
		return zdrylb;
	}
	public void setZdrylb(String zdrylb) {
		this.zdrylb = zdrylb;
	}
	public String getZdrygllxdm() {
		return zdrygllxdm;
	}
	public void setZdrygllxdm(String zdrygllxdm) {
		this.zdrygllxdm = zdrygllxdm;
	}
	public String getYxx() {
		return yxx;
	}
	public void setYxx(String yxx) {
		this.yxx = yxx;
	}
	public String getEtldate() {
		return etldate;
	}
	public void setEtldate(String etldate) {
		this.etldate = etldate;
	}

	public String getSyrkid() {
		return syrkid;
	}
	public void setSyrkid(String syrkid) {
		this.syrkid = syrkid;
	}
	public String getQbzd() {
		return qbzd;
	}
	public void setQbzd(String qbzd) {
		this.qbzd = qbzd;
	}
	public String getQbdd() {
		return qbdd;
	}
	public void setQbdd(String qbdd) {
		this.qbdd = qbdd;
	}
	public String getQbpcs() {
		return qbpcs;
	}
	public void setQbpcs(String qbpcs) {
		this.qbpcs = qbpcs;
	}
	public String getQbzrq() {
		return qbzrq;
	}
	public void setQbzrq(String qbzrq) {
		this.qbzrq = qbzrq;
	}
	public String getDqjb() {
		return dqjb;
	}
	public void setDqjb(String dqjb) {
		this.dqjb = dqjb;
	}
	public String getGlzt() {
		return glzt;
	}
	public void setGlzt(String glzt) {
		this.glzt = glzt;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	public String getQbzdmc() {
		return qbzdmc;
	}
	public void setQbzdmc(String qbzdmc) {
		this.qbzdmc = qbzdmc;
	}
	public String getQbddmc() {
		return qbddmc;
	}
	public void setQbddmc(String qbddmc) {
		this.qbddmc = qbddmc;
	}
	public String getQbpcsmc() {
		return qbpcsmc;
	}
	public void setQbpcsmc(String qbpcsmc) {
		this.qbpcsmc = qbpcsmc;
	}
	public String getQbzrqmc() {
		return qbzrqmc;
	}
	public void setQbzrqmc(String qbzrqmc) {
		this.qbzrqmc = qbzrqmc;
	}
	
	
}
