package com.founder.qbld.bean;

import java.io.Serializable;
import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

/**
 * ****************************************************************************
 * @Package:      [com.founder.qbld.bean.Ryxsb.java]  
 * @ClassName:    [Ryxsb]   
 * @Description:  [人员写实表]   
 * @Author:       [yu_sun@founder.com.cn]  
 * @CreateDate:   [2015-5-5 上午9:15:24]   
 * @UpdateUser:   [founder(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-5-5 上午9:15:24，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@DBInfoAnnotation(tableName = "QBLD_SK_ZDRY_XSXX", pk = "id")
public class Ryxsb extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@FieldDesc("ID")
	private String id;
	@FieldDesc("写实信息编号")
	private String xsxxbh;
	@FieldDesc("重点人员证件号码")
	private String zdry_zjhm;
	@FieldDesc("核实时间")
	private String hssj;
	@FieldDesc("核实地点区划")
	private String hsddqh;
	@FieldDesc("核实地点名称")
	private String hsddmc;
	@FieldDesc("核实地点祥址")
	private String hsddxz;
	@FieldDesc("在籍状态")
	private String zjzt;
	@FieldDesc("离开时间")
	private String lksj;
	@FieldDesc("前往省市")
	private String qwss;
	@FieldDesc("在控状态")
	private String zkzt;
	@FieldDesc("危险级别")
	private String wxjb;
	@FieldDesc("主要意向")
	private String zyyx;
	@FieldDesc("职业")
	private String zy;
	@FieldDesc("实际收入")
	private String sjsr;
	@FieldDesc("经济来源")
	private String jjly;
	@FieldDesc("工作单位")
	private String gzdw;
	@FieldDesc("工作单位祥址")
	private String gzdwxz;
	@FieldDesc("居住地区划")
	private String jzdqh;
	@FieldDesc("管辖单位代码")
	private String gxdwdm;
	@FieldDesc("管辖单位名称")
	private String gxdwmc;
	@FieldDesc("居住地祥址")
	private String jzdxz;
	@FieldDesc("核实情况描述")
	private String hsqkms;
	@FieldDesc("人员类别信息")
	private String rylbxx;
	@FieldDesc("采集时间")
	private String cjsj;
	@FieldDesc("修改时间")
	private String xgsj;
	@FieldDesc("填写人单位代码")
	private String txrdwdm;
	@FieldDesc("填写人单位名称")
	private String txrdwmc;
	@FieldDesc("填写人ID")
	private String txrid;
	@FieldDesc("填写人名称")
	private String txrmc;
	@FieldDesc("ZXQSXX")
	private String zxqsxx;
	@FieldDesc("XNSFXX")
	private String xnsfxx;
	@FieldDesc("是否见到本人")
	private String sfjdbr;
	@FieldDesc("填写人身份证号")
	private String txrsfzh;
	@FieldDesc("在控类型")
	private String zklx;
	@FieldDesc("YJZQ")
	private String yjzq;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getXsxxbh() {
		return xsxxbh;
	}
	public void setXsxxbh(String xsxxbh) {
		this.xsxxbh = xsxxbh;
	}
	public String getZdry_zjhm() {
		return zdry_zjhm;
	}
	public void setZdry_zjhm(String zdry_zjhm) {
		this.zdry_zjhm = zdry_zjhm;
	}
	public String getHssj() {
		return hssj;
	}
	public void setHssj(String hssj) {
		this.hssj = hssj;
	}
	public String getHsddqh() {
		return hsddqh;
	}
	public void setHsddqh(String hsddqh) {
		this.hsddqh = hsddqh;
	}
	public String getHsddmc() {
		return hsddmc;
	}
	public void setHsddmc(String hsddmc) {
		this.hsddmc = hsddmc;
	}
	public String getHsddxz() {
		return hsddxz;
	}
	public void setHsddxz(String hsddxz) {
		this.hsddxz = hsddxz;
	}
	public String getZjzt() {
		return zjzt;
	}
	public void setZjzt(String zjzt) {
		this.zjzt = zjzt;
	}
	public String getLksj() {
		return lksj;
	}
	public void setLksj(String lksj) {
		this.lksj = lksj;
	}
	public String getQwss() {
		return qwss;
	}
	public void setQwss(String qwss) {
		this.qwss = qwss;
	}
	public String getZkzt() {
		return zkzt;
	}
	public void setZkzt(String zkzt) {
		this.zkzt = zkzt;
	}
	public String getWxjb() {
		return wxjb;
	}
	public void setWxjb(String wxjb) {
		this.wxjb = wxjb;
	}
	public String getZyyx() {
		return zyyx;
	}
	public void setZyyx(String zyyx) {
		this.zyyx = zyyx;
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
	public String getJzdqh() {
		return jzdqh;
	}
	public void setJzdqh(String jzdqh) {
		this.jzdqh = jzdqh;
	}
	public String getGxdwdm() {
		return gxdwdm;
	}
	public void setGxdwdm(String gxdwdm) {
		this.gxdwdm = gxdwdm;
	}
	public String getGxdwmc() {
		return gxdwmc;
	}
	public void setGxdwmc(String gxdwmc) {
		this.gxdwmc = gxdwmc;
	}
	public String getJzdxz() {
		return jzdxz;
	}
	public void setJzdxz(String jzdxz) {
		this.jzdxz = jzdxz;
	}
	public String getHsqkms() {
		return hsqkms;
	}
	public void setHsqkms(String hsqkms) {
		this.hsqkms = hsqkms;
	}
	public String getRylbxx() {
		return rylbxx;
	}
	public void setRylbxx(String rylbxx) {
		this.rylbxx = rylbxx;
	}
	public String getCjsj() {
		return cjsj;
	}
	public void setCjsj(String cjsj) {
		this.cjsj = cjsj;
	}
	public String getXgsj() {
		return xgsj;
	}
	public void setXgsj(String xgsj) {
		this.xgsj = xgsj;
	}
	public String getTxrdwdm() {
		return txrdwdm;
	}
	public void setTxrdwdm(String txrdwdm) {
		this.txrdwdm = txrdwdm;
	}
	public String getTxrdwmc() {
		return txrdwmc;
	}
	public void setTxrdwmc(String txrdwmc) {
		this.txrdwmc = txrdwmc;
	}
	public String getTxrid() {
		return txrid;
	}
	public void setTxrid(String txrid) {
		this.txrid = txrid;
	}
	public String getTxrmc() {
		return txrmc;
	}
	public void setTxrmc(String txrmc) {
		this.txrmc = txrmc;
	}
	public String getZxqsxx() {
		return zxqsxx;
	}
	public void setZxqsxx(String zxqsxx) {
		this.zxqsxx = zxqsxx;
	}
	public String getXnsfxx() {
		return xnsfxx;
	}
	public void setXnsfxx(String xnsfxx) {
		this.xnsfxx = xnsfxx;
	}
	public String getSfjdbr() {
		return sfjdbr;
	}
	public void setSfjdbr(String sfjdbr) {
		this.sfjdbr = sfjdbr;
	}
	public String getTxrsfzh() {
		return txrsfzh;
	}
	public void setTxrsfzh(String txrsfzh) {
		this.txrsfzh = txrsfzh;
	}
	public String getZklx() {
		return zklx;
	}
	public void setZklx(String zklx) {
		this.zklx = zklx;
	}
	public String getYjzq() {
		return yjzq;
	}
	public void setYjzq(String yjzq) {
		this.yjzq = yjzq;
	}
	
}
