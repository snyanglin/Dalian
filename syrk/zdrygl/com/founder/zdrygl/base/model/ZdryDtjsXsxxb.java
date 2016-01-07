package com.founder.zdrygl.base.model;

import java.io.Serializable;
import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

/**
 * ****************************************************************************
 * @Package:      [com.founder.zdrygl.bean.ZdryDtjsXsxxb.java]  
 * @ClassName:    [ZdryDtjsXsxxb]   
 * @Description:  [重点人员 动态记实 写实信息 表]   
 * @Author:       [zhang.hai@founder.com.cn]  
 * @CreateDate:   [2015年8月13日 下午7:08:00]   
 * @UpdateUser:   [ZhangHai(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015年8月13日 下午7:08:00，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@DBInfoAnnotation(tableName = "ZDRY_DTJS_XSXXB", pk = "id")
public class ZdryDtjsXsxxb extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@FieldDesc("ID")
	private String id;
	@FieldDesc("证件号码")
	private String zdry_zjhm;
	@FieldDesc("核实时间")
	private String hssj;
	@FieldDesc("在籍状态")
	private String zjzt;
	@FieldDesc("离开时间")
	private String lksj;
	@FieldDesc("去往省市")
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
	@FieldDesc("工作单位id")
	private String gzdwid;
	@FieldDesc("工作单位名称")
	private String gzdwmc;
	@FieldDesc("工作单位详址")
	private String gzdwxz;
	@FieldDesc("管辖单位代码")
	private String gxdwdm;
	@FieldDesc("管辖单位名称")
	private String gxdwmc;
	@FieldDesc("核实情况描述")
	private String hsqkms;
	@FieldDesc("人员类别信息")
	private String rylbxx;
	@FieldDesc("采集实际")
	private String cjsj;
	@FieldDesc("修改实际")
	private String xgsj;
	@FieldDesc("填写人单位代码")
	private String txrdwdm;
	@FieldDesc("填写人单位名称")
	private String txrdwmc;
	@FieldDesc("填写人id")
	private String txrid;
	@FieldDesc("填写人名称")
	private String txrmc;
	@FieldDesc("直系亲属信息")
	private String zxqsxx;
	@FieldDesc("虚拟身份信息")
	private String xnsfxx;
	@FieldDesc("是否见到本人")
	private String sfjdbr;
	@FieldDesc("填写人身份证号")
	private String txrsfzh;
	@FieldDesc("在控类型")
	private String zklx;
	@FieldDesc("约见周期")
	private String yjzq;
	@FieldDesc("核实地行政区划代码")
	private String hsd_xzqhdm;
	@FieldDesc("核实地门楼牌代码")
	private String hsd_mlpdm;
	@FieldDesc("核实地地址详址")
	private String hsd_dzxz;
	@FieldDesc("核实地门楼牌详址")
	private String hsd_mlpxz;
	@FieldDesc("核实地地址id")
	private String hsd_dzid;
	@FieldDesc("居住地行政区划代码")
	private String jzd_xzqhdm;
	@FieldDesc("居住地门楼牌代码")
	private String jzd_mlpdm;
	@FieldDesc("居住地门楼牌详址")
    private String jzd_mlpxz;
	
	@FieldDesc("居住地地址id")
	private String jzd_dzid;
	@FieldDesc("居住地地址详址")
	private String jzd_dzxz;
	
	
	private String zdryid;
	
	
	
	public String getZdryid() {
		return zdryid;
	}
	public void setZdryid(String zdryid) {
		this.zdryid = zdryid;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public String getGzdwid() {
		return gzdwid;
	}
	public void setGzdwid(String gzdwid) {
		this.gzdwid = gzdwid;
	}
	public String getGzdwmc() {
		return gzdwmc;
	}
	public void setGzdwmc(String gzdwmc) {
		this.gzdwmc = gzdwmc;
	}
	public String getGzdwxz() {
		return gzdwxz;
	}
	public void setGzdwxz(String gzdwxz) {
		this.gzdwxz = gzdwxz;
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
	public String getHsd_xzqhdm() {
		return hsd_xzqhdm;
	}
	public void setHsd_xzqhdm(String hsd_xzqhdm) {
		this.hsd_xzqhdm = hsd_xzqhdm;
	}
	public String getHsd_mlpdm() {
		return hsd_mlpdm;
	}
	public void setHsd_mlpdm(String hsd_mlpdm) {
		this.hsd_mlpdm = hsd_mlpdm;
	}
	public String getHsd_dzxz() {
		return hsd_dzxz;
	}
	public void setHsd_dzxz(String hsd_dzxz) {
		this.hsd_dzxz = hsd_dzxz;
	}
	public String getHsd_mlpxz() {
		return hsd_mlpxz;
	}
	public void setHsd_mlpxz(String hsd_mlpxz) {
		this.hsd_mlpxz = hsd_mlpxz;
	}
	public String getHsd_dzid() {
		return hsd_dzid;
	}
	public void setHsd_dzid(String hsd_dzid) {
		this.hsd_dzid = hsd_dzid;
	}
	public String getJzd_xzqhdm() {
		return jzd_xzqhdm;
	}
	public void setJzd_xzqhdm(String jzd_xzqhdm) {
		this.jzd_xzqhdm = jzd_xzqhdm;
	}
	public String getJzd_mlpdm() {
		return jzd_mlpdm;
	}
	public void setJzd_mlpdm(String jzd_mlpdm) {
		this.jzd_mlpdm = jzd_mlpdm;
	}
	public String getJzd_mlpxz() {
		return jzd_mlpxz;
	}
	public void setJzd_mlpxz(String jzd_mlpxz) {
		this.jzd_mlpxz = jzd_mlpxz;
	}
	public String getJzd_dzid() {
		return jzd_dzid;
	}
	public void setJzd_dzid(String jzd_dzid) {
		this.jzd_dzid = jzd_dzid;
	}
	public String getJzd_dzxz() {
		return jzd_dzxz;
	}
	public void setJzd_dzxz(String jzd_dzxz) {
		this.jzd_dzxz = jzd_dzxz;
	}

	
}
