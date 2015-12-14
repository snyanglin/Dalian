package com.founder.shhxxcj.bean;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;

@DBInfoAnnotation(tableName = "HOUSES", pk = "id")
public class Houses {

	@FieldDesc("编号")
	private String id;
	@FieldDesc("企业编号")
	private String enterpriseid;
	@FieldDesc("创建时间")
	private String createdate;
	@FieldDesc("最后修改时间")
	private String lastchangedat;
	@FieldDesc("录入警综时间")
	private String accessdate;
	@FieldDesc("企业名称")
	private String entname;
	@FieldDesc("录入单位所属派出所")
	private String pcscode;
	@FieldDesc("录入单位所属分局代")
	private String fenjucode;
	@FieldDesc("房屋所在地分局")
	private String fwszdfjcode;
	@FieldDesc("房屋所在地派出所")
	private String fwszdpcscod;
	@FieldDesc("房主证件类别")
	private String fzzjlb;
	@FieldDesc("房主证件号码")
	private String fzzjhm;
	@FieldDesc("房主身份证号")
	private String fzsfzh;
	@FieldDesc("房主姓名")
	private String xm;
	@FieldDesc("性别")
	private String xb;
	@FieldDesc("民族")
	private String mz;
	@FieldDesc("户籍地址")
	private String hjdz;
	@FieldDesc("出生日期")
	private String csrq;
	@FieldDesc("房主单位")
	private String fzdw;
	@FieldDesc("房屋地址")
	private String fwdz;
	@FieldDesc("房屋省市县")
	private String fwssx;
	@FieldDesc("房屋详址")
	private String fwxz;
	@FieldDesc("房主现地址")
	private String fzxdz;
	@FieldDesc("房主住宅电话")
	private String fzzzdh;
	@FieldDesc("房主移动电话")
	private String fzyddh;
	@FieldDesc("产权性质")
	private String cqxz;
	@FieldDesc("房屋结构")
	private String fwjg;
	@FieldDesc("房屋间数")
	private String fwjs;
	@FieldDesc("房屋等级")
	private String fwdj;
	@FieldDesc("居住人数")
	private String jzrs;
	@FieldDesc("房屋用途")
	private String fwyt;
	@FieldDesc("房屋面积")
	private String fwmj;
	@FieldDesc("出租日期")
	private String czrq;
	@FieldDesc("是否签订保证书")
	private String sfqdbzs;
	@FieldDesc("房屋产权号")
	private String fwcqh;
	@FieldDesc("租金")
	private String zj;
	@FieldDesc("备案编号")
	private String babh;
	@FieldDesc("备注")
	private String bz;
	@FieldDesc("状态 0 正常 1注销")
	private Long status;
	@FieldDesc("核实状态0 正常 1注销")
	private String hszt;
	@FieldDesc("层户地址ID")
	private String bzdzid;
	@FieldDesc("所属责任区ID")
	private String ss4jbmdm;
	@FieldDesc("实有房屋ID")
	private String syfwid;
	
	public String getSyfwid() {
		return syfwid;
	}
	public void setSyfwid(String syfwid) {
		this.syfwid = syfwid;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEnterpriseid() {
		return enterpriseid;
	}
	public void setEnterpriseid(String enterpriseid) {
		this.enterpriseid = enterpriseid;
	}
	public String getCreatedate() {
		return createdate;
	}
	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}
	public String getLastchangedat() {
		return lastchangedat;
	}
	public void setLastchangedat(String lastchangedat) {
		this.lastchangedat = lastchangedat;
	}
	public String getAccessdate() {
		return accessdate;
	}
	public void setAccessdate(String accessdate) {
		this.accessdate = accessdate;
	}
	public String getEntname() {
		return entname;
	}
	public void setEntname(String entname) {
		this.entname = entname;
	}
	public String getPcscode() {
		return pcscode;
	}
	public void setPcscode(String pcscode) {
		this.pcscode = pcscode;
	}
	public String getFenjucode() {
		return fenjucode;
	}
	public void setFenjucode(String fenjucode) {
		this.fenjucode = fenjucode;
	}
	public String getFwszdfjcode() {
		return fwszdfjcode;
	}
	public void setFwszdfjcode(String fwszdfjcode) {
		this.fwszdfjcode = fwszdfjcode;
	}
	public String getFwszdpcscod() {
		return fwszdpcscod;
	}
	public void setFwszdpcscod(String fwszdpcscod) {
		this.fwszdpcscod = fwszdpcscod;
	}
	public String getFzzjlb() {
		return fzzjlb;
	}
	public void setFzzjlb(String fzzjlb) {
		this.fzzjlb = fzzjlb;
	}
	public String getFzzjhm() {
		return fzzjhm;
	}
	public void setFzzjhm(String fzzjhm) {
		this.fzzjhm = fzzjhm;
	}
	public String getFzsfzh() {
		return fzsfzh;
	}
	public void setFzsfzh(String fzsfzh) {
		this.fzsfzh = fzsfzh;
	}
	public String getXm() {
		return xm;
	}
	public void setXm(String xm) {
		this.xm = xm;
	}
	public String getXb() {
		return xb;
	}
	public void setXb(String xb) {
		this.xb = xb;
	}
	public String getMz() {
		return mz;
	}
	public void setMz(String mz) {
		this.mz = mz;
	}
	public String getHjdz() {
		return hjdz;
	}
	public void setHjdz(String hjdz) {
		this.hjdz = hjdz;
	}
	public String getCsrq() {
		return csrq;
	}
	public void setCsrq(String csrq) {
		this.csrq = csrq;
	}
	public String getFzdw() {
		return fzdw;
	}
	public void setFzdw(String fzdw) {
		this.fzdw = fzdw;
	}
	public String getFwdz() {
		return fwdz;
	}
	public void setFwdz(String fwdz) {
		this.fwdz = fwdz;
	}
	public String getFwssx() {
		return fwssx;
	}
	public void setFwssx(String fwssx) {
		this.fwssx = fwssx;
	}
	public String getFwxz() {
		return fwxz;
	}
	public void setFwxz(String fwxz) {
		this.fwxz = fwxz;
	}
	public String getFzxdz() {
		return fzxdz;
	}
	public void setFzxdz(String fzxdz) {
		this.fzxdz = fzxdz;
	}
	public String getFzzzdh() {
		return fzzzdh;
	}
	public void setFzzzdh(String fzzzdh) {
		this.fzzzdh = fzzzdh;
	}
	public String getFzyddh() {
		return fzyddh;
	}
	public void setFzyddh(String fzyddh) {
		this.fzyddh = fzyddh;
	}
	public String getCqxz() {
		return cqxz;
	}
	public void setCqxz(String cqxz) {
		this.cqxz = cqxz;
	}
	public String getFwjg() {
		return fwjg;
	}
	public void setFwjg(String fwjg) {
		this.fwjg = fwjg;
	}
	public String getFwjs() {
		return fwjs;
	}
	public void setFwjs(String fwjs) {
		this.fwjs = fwjs;
	}
	public String getFwdj() {
		return fwdj;
	}
	public void setFwdj(String fwdj) {
		this.fwdj = fwdj;
	}
	public String getJzrs() {
		return jzrs;
	}
	public void setJzrs(String jzrs) {
		this.jzrs = jzrs;
	}
	public String getFwyt() {
		return fwyt;
	}
	public void setFwyt(String fwyt) {
		this.fwyt = fwyt;
	}
	public String getFwmj() {
		return fwmj;
	}
	public void setFwmj(String fwmj) {
		this.fwmj = fwmj;
	}
	public String getCzrq() {
		return czrq;
	}
	public void setCzrq(String czrq) {
		this.czrq = czrq;
	}
	public String getSfqdbzs() {
		return sfqdbzs;
	}
	public void setSfqdbzs(String sfqdbzs) {
		this.sfqdbzs = sfqdbzs;
	}
	public String getFwcqh() {
		return fwcqh;
	}
	public void setFwcqh(String fwcqh) {
		this.fwcqh = fwcqh;
	}
	public String getZj() {
		return zj;
	}
	public void setZj(String zj) {
		this.zj = zj;
	}
	public String getBabh() {
		return babh;
	}
	public void setBabh(String babh) {
		this.babh = babh;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	public Long getStatus() {
		return status;
	}
	public void setStatus(Long status) {
		this.status = status;
	}
	public String getHszt() {
		return hszt;
	}
	public void setHszt(String hszt) {
		this.hszt = hszt;
	}
	public String getBzdzid() {
		return bzdzid;
	}
	public void setBzdzid(String bzdzid) {
		this.bzdzid = bzdzid;
	}
	public String getSs4jbmdm() {
		return ss4jbmdm;
	}
	public void setSs4jbmdm(String ss4jbmdm) {
		this.ss4jbmdm = ss4jbmdm;
	}
	
	
	
	

}
