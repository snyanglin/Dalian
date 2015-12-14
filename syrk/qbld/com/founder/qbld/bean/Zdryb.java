package com.founder.qbld.bean;

import java.io.Serializable;
import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

/**
 * ****************************************************************************
 * @Package:      [com.founder.qbld.bean.Zdryb.java]  
 * @ClassName:    [Zdryb]   
 * @Description:  [重点人员信息表]   
 * @Author:       [yu_sun@founder.com.cn]  
 * @CreateDate:   [2015-6-8 上午9:42:00]   
 * @UpdateUser:   [founder(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-6-8 上午9:42:00，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@DBInfoAnnotation(tableName = "QBLD_ZDRY_GAB", pk = "objectid")
public class Zdryb extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	private String createdateB;
	private String createdateE;
	
	private String xssjB;
	private String xssjE;
	private String xssj;
	
	@FieldDesc("OBJECTID")
	private String objectid;
	@FieldDesc("部级重点人员编号")
	private String bjzdrybh;
	@FieldDesc("姓名")
	private String xm;
	@FieldDesc("姓名拼音")
	private String xmpy;
	@FieldDesc("外文姓名")
	private String wwxm;
	@FieldDesc("性别")
	private String xb;
	@FieldDesc("出生日期")
	private String csrq;
	@FieldDesc("国级")
	private String gj;
	@FieldDesc("身份证号")
	private String sfzh;
	@FieldDesc("其他证件号码")
	private String qtzjhm;
	@FieldDesc("民族")
	private String mz;
	@FieldDesc("籍贯")
	private String jg;
	@FieldDesc("户籍地区划")
	private String hjdqh;
	@FieldDesc("户籍地详址")
	private String hjdxz;
	@FieldDesc("户籍地派出所")
	private String hjdpcs;
	@FieldDesc("户籍地派出所代码")
	private String hjdpcsdm;
	@FieldDesc("行政地区划代码")
	private String xzdqh;
	@FieldDesc("现住地详址")
	private String xzdxz;
	@FieldDesc("现住地派出所")
	private String xzdpcs;
	@FieldDesc("现住地派出所代码")
	private String xzdpcsdm;
	@FieldDesc("管辖单位")
	private String gxdw;
	@FieldDesc("管辖单位机构代码")
	private String gxdwjgdm;
	@FieldDesc("立案单位代码")
	private String ladw;
	@FieldDesc("立案单位机构代码")
	private String ladwjgdm;
	@FieldDesc("ZJLASJ")
	private String zjlasj;
	@FieldDesc("NRBJZDRYKSJ")
	private String nrbjzdryksj;
	@FieldDesc("ZDRYLBBJ")
	private String zdrylbbj;
	@FieldDesc("ZDRYXL")
	private String zdryxl;
	@FieldDesc("YXX")
	private String yxx;
	@FieldDesc("JLXZSJ")
	private String jlxzsj;
	@FieldDesc("JLCXSJ")
	private String jlcxsj;
	@FieldDesc("JLBGSJ")
	private String jlbgsj;
	@FieldDesc("CREATEDATE")
	private String createdate;
	@FieldDesc("ETLDATE")
	private String etldate;
	@FieldDesc("SFZH18")
	private String sfzh18;
	
	public String getXssjB() {
		return xssjB;
	}
	public void setXssjB(String xssjB) {
		this.xssjB = xssjB;
	}
	public String getXssjE() {
		return xssjE;
	}
	public void setXssjE(String xssjE) {
		this.xssjE = xssjE;
	}
	public String getXssj() {
		return xssj;
	}
	public void setXssj(String xssj) {
		this.xssj = xssj;
	}
	public String getCreatedateB() {
		return createdateB;
	}
	public void setCreatedateB(String createdateB) {
		this.createdateB = createdateB;
	}
	public String getCreatedateE() {
		return createdateE;
	}
	public void setCreatedateE(String createdateE) {
		this.createdateE = createdateE;
	}
	public String getObjectid() {
		return objectid;
	}
	public void setObjectid(String objectid) {
		this.objectid = objectid;
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
	public String getXmpy() {
		return xmpy;
	}
	public void setXmpy(String xmpy) {
		this.xmpy = xmpy;
	}
	public String getWwxm() {
		return wwxm;
	}
	public void setWwxm(String wwxm) {
		this.wwxm = wwxm;
	}
	public String getXb() {
		return xb;
	}
	public void setXb(String xb) {
		this.xb = xb;
	}
	public String getCsrq() {
		return csrq;
	}
	public void setCsrq(String csrq) {
		this.csrq = csrq;
	}
	public String getGj() {
		return gj;
	}
	public void setGj(String gj) {
		this.gj = gj;
	}
	public String getSfzh() {
		return sfzh;
	}
	public void setSfzh(String sfzh) {
		this.sfzh = sfzh;
	}
	public String getQtzjhm() {
		return qtzjhm;
	}
	public void setQtzjhm(String qtzjhm) {
		this.qtzjhm = qtzjhm;
	}
	public String getMz() {
		return mz;
	}
	public void setMz(String mz) {
		this.mz = mz;
	}
	public String getJg() {
		return jg;
	}
	public void setJg(String jg) {
		this.jg = jg;
	}
	public String getHjdqh() {
		return hjdqh;
	}
	public void setHjdqh(String hjdqh) {
		this.hjdqh = hjdqh;
	}
	public String getHjdxz() {
		return hjdxz;
	}
	public void setHjdxz(String hjdxz) {
		this.hjdxz = hjdxz;
	}
	public String getHjdpcs() {
		return hjdpcs;
	}
	public void setHjdpcs(String hjdpcs) {
		this.hjdpcs = hjdpcs;
	}
	public String getHjdpcsdm() {
		return hjdpcsdm;
	}
	public void setHjdpcsdm(String hjdpcsdm) {
		this.hjdpcsdm = hjdpcsdm;
	}
	public String getXzdqh() {
		return xzdqh;
	}
	public void setXzdqh(String xzdqh) {
		this.xzdqh = xzdqh;
	}
	public String getXzdxz() {
		return xzdxz;
	}
	public void setXzdxz(String xzdxz) {
		this.xzdxz = xzdxz;
	}
	public String getXzdpcs() {
		return xzdpcs;
	}
	public void setXzdpcs(String xzdpcs) {
		this.xzdpcs = xzdpcs;
	}
	public String getXzdpcsdm() {
		return xzdpcsdm;
	}
	public void setXzdpcsdm(String xzdpcsdm) {
		this.xzdpcsdm = xzdpcsdm;
	}
	public String getGxdw() {
		return gxdw;
	}
	public void setGxdw(String gxdw) {
		this.gxdw = gxdw;
	}
	public String getGxdwjgdm() {
		return gxdwjgdm;
	}
	public void setGxdwjgdm(String gxdwjgdm) {
		this.gxdwjgdm = gxdwjgdm;
	}
	public String getLadw() {
		return ladw;
	}
	public void setLadw(String ladw) {
		this.ladw = ladw;
	}
	public String getLadwjgdm() {
		return ladwjgdm;
	}
	public void setLadwjgdm(String ladwjgdm) {
		this.ladwjgdm = ladwjgdm;
	}
	public String getZjlasj() {
		return zjlasj;
	}
	public void setZjlasj(String zjlasj) {
		this.zjlasj = zjlasj;
	}
	public String getNrbjzdryksj() {
		return nrbjzdryksj;
	}
	public void setNrbjzdryksj(String nrbjzdryksj) {
		this.nrbjzdryksj = nrbjzdryksj;
	}
	public String getZdrylbbj() {
		return zdrylbbj;
	}
	public void setZdrylbbj(String zdrylbbj) {
		this.zdrylbbj = zdrylbbj;
	}
	public String getZdryxl() {
		return zdryxl;
	}
	public void setZdryxl(String zdryxl) {
		this.zdryxl = zdryxl;
	}
	public String getYxx() {
		return yxx;
	}
	public void setYxx(String yxx) {
		this.yxx = yxx;
	}
	public String getJlxzsj() {
		return jlxzsj;
	}
	public void setJlxzsj(String jlxzsj) {
		this.jlxzsj = jlxzsj;
	}
	public String getJlcxsj() {
		return jlcxsj;
	}
	public void setJlcxsj(String jlcxsj) {
		this.jlcxsj = jlcxsj;
	}
	public String getJlbgsj() {
		return jlbgsj;
	}
	public void setJlbgsj(String jlbgsj) {
		this.jlbgsj = jlbgsj;
	}
	public String getCreatedate() {
		return createdate;
	}
	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}
	public String getEtldate() {
		return etldate;
	}
	public void setEtldate(String etldate) {
		this.etldate = etldate;
	}
	public String getSfzh18() {
		return sfzh18;
	}
	public void setSfzh18(String sfzh18) {
		this.sfzh18 = sfzh18;
	}

}
