package com.founder.zdrygl.base.model;

import java.io.Serializable;
import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

/**
 * ****************************************************************************
 * @Package:      [com.founder.qbld.bean.Shgxrb.java]  
 * @ClassName:    [Shgxrb]   
 * @Description:  [社会关系人表]   
 * @Author:       [yu_sun@founder.com.cn]  
 * @CreateDate:   [2015-6-4 上午10:11:58]   
 * @UpdateUser:   [founder(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-6-4 上午10:11:58，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@DBInfoAnnotation(tableName = "ZDRY_DTJS_SHGXRYXX", pk = "OBJECTID")
public class ZdryDtjsShgxrxxb extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@FieldDesc("名族") private String mz;
	@FieldDesc("性别") private String xb;
	@FieldDesc("关系类型") private String gx;
	@FieldDesc("国籍") private String gj;
	@FieldDesc("户籍区划") private String hjqh;
	@FieldDesc("户籍地派出所代码") private String hjdpcsdm;
	@FieldDesc("户籍地派出所") private String hjdpcs;
	@FieldDesc("户籍地祥址") private String hjdxz;
	@FieldDesc("现住地区划") private String xzdqh;
	@FieldDesc("管辖单位代码") private String gxdwdm;
	@FieldDesc("管辖单位") private String gxdw;
	@FieldDesc("现住地祥址") private String xzdxz;
	@FieldDesc("重点人员类别标记") private String zdrylbbj;
	@FieldDesc("重点人员细类") private String zdryxl;
	@FieldDesc("曾用名") private String cym;
	@FieldDesc("绰号") private String ch;
	@FieldDesc("政治面貌") private String zzmm;
	@FieldDesc("宗教信仰") private String zjxy;
	@FieldDesc("出生日期") private String csrq;
	@FieldDesc("婚姻状况") private String hyzk;
	@FieldDesc("文化程度") private String whcd;
	@FieldDesc("身高") private String sg;
	@FieldDesc("体重") private String tz;
	@FieldDesc("足长") private String zc;
	@FieldDesc("鞋号mm") private String xh;
	@FieldDesc("口音") private String ky;
	@FieldDesc("特长") private String tc;
	@FieldDesc("兴趣爱好") private String xqah;
	@FieldDesc("体貌特征") private String tmtz;
	@FieldDesc("特殊标记") private String tsbj;
	@FieldDesc("DNA") private String dna;
	@FieldDesc("血型") private String xx;
	@FieldDesc("指纹编号") private String zwbh;
	@FieldDesc("职业") private String zy;
	@FieldDesc("实际收入") private String sjsr;
	@FieldDesc("经济来源") private String jjly;
	@FieldDesc("工作单位区划") private String gzdwqh;
	@FieldDesc("工作单位") private String gzdw;
	@FieldDesc("工作单位祥址") private String gzdwxz;
	@FieldDesc("联系方式") private String lxfs;
	@FieldDesc("填报单位代码") private String tbdwdm;
	@FieldDesc("填报单位名称") private String tbdwmc;
	@FieldDesc("填报人ID") private String tbrid;
	@FieldDesc("填报人姓名") private String tbrxm;
	@FieldDesc("入库时间") private String rksj;
	@FieldDesc("修改时间") private String xgsj;
	@FieldDesc("状态") private String status;
	@FieldDesc("社会关系人编号") private String shgxrbh;
	@FieldDesc("null") private String objectid;
	@FieldDesc("重点人证件号码") private String zdry_zjhm;
	@FieldDesc("证件类型") private String zjlx;
	@FieldDesc("证件号码") private String zjhm;
	@FieldDesc("部级重点人员编号") private String bjzdrybh;
	@FieldDesc("省级重点人员编号") private String sjzdrybh;
	@FieldDesc("姓名") private String xm;
	@FieldDesc("姓名拼音") private String xmpy;
	public String getMz() {
		return mz;
	}
	public void setMz(String mz) {
		this.mz = mz;
	}
	public String getXb() {
		return xb;
	}
	public void setXb(String xb) {
		this.xb = xb;
	}
	public String getGx() {
		return gx;
	}
	public void setGx(String gx) {
		this.gx = gx;
	}
	public String getGj() {
		return gj;
	}
	public void setGj(String gj) {
		this.gj = gj;
	}
	public String getHjqh() {
		return hjqh;
	}
	public void setHjqh(String hjqh) {
		this.hjqh = hjqh;
	}
	public String getHjdpcsdm() {
		return hjdpcsdm;
	}
	public void setHjdpcsdm(String hjdpcsdm) {
		this.hjdpcsdm = hjdpcsdm;
	}
	public String getHjdpcs() {
		return hjdpcs;
	}
	public void setHjdpcs(String hjdpcs) {
		this.hjdpcs = hjdpcs;
	}
	public String getHjdxz() {
		return hjdxz;
	}
	public void setHjdxz(String hjdxz) {
		this.hjdxz = hjdxz;
	}
	public String getXzdqh() {
		return xzdqh;
	}
	public void setXzdqh(String xzdqh) {
		this.xzdqh = xzdqh;
	}
	public String getGxdwdm() {
		return gxdwdm;
	}
	public void setGxdwdm(String gxdwdm) {
		this.gxdwdm = gxdwdm;
	}
	public String getGxdw() {
		return gxdw;
	}
	public void setGxdw(String gxdw) {
		this.gxdw = gxdw;
	}
	public String getXzdxz() {
		return xzdxz;
	}
	public void setXzdxz(String xzdxz) {
		this.xzdxz = xzdxz;
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
	public String getCym() {
		return cym;
	}
	public void setCym(String cym) {
		this.cym = cym;
	}
	public String getCh() {
		return ch;
	}
	public void setCh(String ch) {
		this.ch = ch;
	}
	public String getZzmm() {
		return zzmm;
	}
	public void setZzmm(String zzmm) {
		this.zzmm = zzmm;
	}
	public String getZjxy() {
		return zjxy;
	}
	public void setZjxy(String zjxy) {
		this.zjxy = zjxy;
	}
	public String getCsrq() {
		return csrq;
	}
	public void setCsrq(String csrq) {
		this.csrq = csrq;
	}
	public String getHyzk() {
		return hyzk;
	}
	public void setHyzk(String hyzk) {
		this.hyzk = hyzk;
	}
	public String getWhcd() {
		return whcd;
	}
	public void setWhcd(String whcd) {
		this.whcd = whcd;
	}
	public String getSg() {
		return sg;
	}
	public void setSg(String sg) {
		this.sg = sg;
	}
	public String getTz() {
		return tz;
	}
	public void setTz(String tz) {
		this.tz = tz;
	}
	public String getZc() {
		return zc;
	}
	public void setZc(String zc) {
		this.zc = zc;
	}
	public String getXh() {
		return xh;
	}
	public void setXh(String xh) {
		this.xh = xh;
	}
	public String getKy() {
		return ky;
	}
	public void setKy(String ky) {
		this.ky = ky;
	}
	public String getTc() {
		return tc;
	}
	public void setTc(String tc) {
		this.tc = tc;
	}
	public String getXqah() {
		return xqah;
	}
	public void setXqah(String xqah) {
		this.xqah = xqah;
	}
	public String getTmtz() {
		return tmtz;
	}
	public void setTmtz(String tmtz) {
		this.tmtz = tmtz;
	}
	public String getTsbj() {
		return tsbj;
	}
	public void setTsbj(String tsbj) {
		this.tsbj = tsbj;
	}
	public String getDna() {
		return dna;
	}
	public void setDna(String dna) {
		this.dna = dna;
	}
	public String getXx() {
		return xx;
	}
	public void setXx(String xx) {
		this.xx = xx;
	}
	public String getZwbh() {
		return zwbh;
	}
	public void setZwbh(String zwbh) {
		this.zwbh = zwbh;
	}
	public String getZy() {
		return zy;
	}
	public void setZy(String zy) {
		this.zy = zy;
	}
	public String getSjsr() {
		return sjsr;
	}
	public void setSjsr(String sjsr) {
		this.sjsr = sjsr;
	}
	public String getJjly() {
		return jjly;
	}
	public void setJjly(String jjly) {
		this.jjly = jjly;
	}
	public String getGzdwqh() {
		return gzdwqh;
	}
	public void setGzdwqh(String gzdwqh) {
		this.gzdwqh = gzdwqh;
	}
	public String getGzdw() {
		return gzdw;
	}
	public void setGzdw(String gzdw) {
		this.gzdw = gzdw;
	}
	public String getGzdwxz() {
		return gzdwxz;
	}
	public void setGzdwxz(String gzdwxz) {
		this.gzdwxz = gzdwxz;
	}
	public String getLxfs() {
		return lxfs;
	}
	public void setLxfs(String lxfs) {
		this.lxfs = lxfs;
	}
	public String getTbdwdm() {
		return tbdwdm;
	}
	public void setTbdwdm(String tbdwdm) {
		this.tbdwdm = tbdwdm;
	}
	public String getTbdwmc() {
		return tbdwmc;
	}
	public void setTbdwmc(String tbdwmc) {
		this.tbdwmc = tbdwmc;
	}
	public String getTbrid() {
		return tbrid;
	}
	public void setTbrid(String tbrid) {
		this.tbrid = tbrid;
	}
	public String getTbrxm() {
		return tbrxm;
	}
	public void setTbrxm(String tbrxm) {
		this.tbrxm = tbrxm;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getShgxrbh() {
		return shgxrbh;
	}
	public void setShgxrbh(String shgxrbh) {
		this.shgxrbh = shgxrbh;
	}
	public String getObjectid() {
		return objectid;
	}
	public void setObjectid(String objectid) {
		this.objectid = objectid;
	}
	public String getZdry_zjhm() {
		return zdry_zjhm;
	}
	public void setZdry_zjhm(String zdry_zjhm) {
		this.zdry_zjhm = zdry_zjhm;
	}
	public String getZjlx() {
		return zjlx;
	}
	public void setZjlx(String zjlx) {
		this.zjlx = zjlx;
	}
	public String getZjhm() {
		return zjhm;
	}
	public void setZjhm(String zjhm) {
		this.zjhm = zjhm;
	}
	public String getBjzdrybh() {
		return bjzdrybh;
	}
	public void setBjzdrybh(String bjzdrybh) {
		this.bjzdrybh = bjzdrybh;
	}
	public String getSjzdrybh() {
		return sjzdrybh;
	}
	public void setSjzdrybh(String sjzdrybh) {
		this.sjzdrybh = sjzdrybh;
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

	
}
