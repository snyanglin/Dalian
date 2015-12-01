package com.founder.shhxxcj.bean;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;


/******************************************************************************
 * @Package:      [com.founder.shhxxcj.bean.EmEnterprises.java]  
 * @ClassName:    [EmEnterprises]   
 * @Description:  [用工单位企业信息表]   
 * @Author:       [cong_rihong@founder.com.cn]  
 * @CreateDate:   [2015-11-20 下午12:28:57]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-11-20 下午12:28:57，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 */
@DBInfoAnnotation(tableName = "EmEnterprises", pk = "id")
public class EmEnterprises {

	@FieldDesc("ID")
	private String id;
	@FieldDesc("DWMC")
	private String dwmc;
	@FieldDesc("YYZZBH")
	private String yyzzbh;
	@FieldDesc("JYXZ")
	private String jyxz;
	@FieldDesc("LXDH")
	private String lxdh;
	@FieldDesc("ZZJGDM")
	private String zzjgdm;
	@FieldDesc("KYRQ")
	private String kyrq;
	@FieldDesc("JYMJ")
	private String jymj;
	@FieldDesc("YYZZQS")
	private String yyzzqs;
	@FieldDesc("YYZZJZ")
	private String yyzzjz;
	@FieldDesc("DWDZ")
	private String dwdz;
	@FieldDesc("JYFW")
	private String jyfw;
	@FieldDesc("PHOTO")
	private String photo;
	@FieldDesc("PCSNAME")
	private String pcsname;
	@FieldDesc("FENJUCODE")
	private String fenjucode;
	@FieldDesc("FENJUNAME")
	private String fenjuname;
	@FieldDesc("CREATEDATE")
	private String createdate;
	@FieldDesc("LASTDATE")
	private String lastdate;
	@FieldDesc("USERID")
	private String userid;
	@FieldDesc("USERNAME")
	private String username;
	@FieldDesc("DWSS")
	private String dwss;
	@FieldDesc("DWLB")
	private String dwlb;
	@FieldDesc("POLICERNAME")
	private String policername;
	@FieldDesc("核实状态（0未核实 1已核实）")
	private String hszt;
	@FieldDesc("层户地址id")
	private String bzdzid;
	@FieldDesc("所属责任区代码")
	private String ss4jbmdm;
	@FieldDesc("实有单位id")
	private String sydwid;
	@FieldDesc("所在派出所代码")
	private String pcscode;

	/**
	 * 数据库不存在此字段（核实单位的时候 如果不是标准地址 则用此字段显示）
	 */
	private String bzdzmc;
	
	
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDwmc() {
		return dwmc;
	}
	public void setDwmc(String dwmc) {
		this.dwmc = dwmc;
	}
	public String getYyzzbh() {
		return yyzzbh;
	}
	public void setYyzzbh(String yyzzbh) {
		this.yyzzbh = yyzzbh;
	}
	public String getJyxz() {
		return jyxz;
	}
	public void setJyxz(String jyxz) {
		this.jyxz = jyxz;
	}
	public String getLxdh() {
		return lxdh;
	}
	public void setLxdh(String lxdh) {
		this.lxdh = lxdh;
	}
	public String getZzjgdm() {
		return zzjgdm;
	}
	public void setZzjgdm(String zzjgdm) {
		this.zzjgdm = zzjgdm;
	}
	public String getKyrq() {
		return kyrq;
	}
	public void setKyrq(String kyrq) {
		this.kyrq = kyrq;
	}
	public String getJymj() {
		return jymj;
	}
	public void setJymj(String jymj) {
		this.jymj = jymj;
	}
	public String getYyzzqs() {
		return yyzzqs;
	}
	public void setYyzzqs(String yyzzqs) {
		this.yyzzqs = yyzzqs;
	}
	public String getYyzzjz() {
		return yyzzjz;
	}
	public void setYyzzjz(String yyzzjz) {
		this.yyzzjz = yyzzjz;
	}
	public String getDwdz() {
		return dwdz;
	}
	public void setDwdz(String dwdz) {
		this.dwdz = dwdz;
	}
	public String getJyfw() {
		return jyfw;
	}
	public void setJyfw(String jyfw) {
		this.jyfw = jyfw;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getPcsname() {
		return pcsname;
	}
	public void setPcsname(String pcsname) {
		this.pcsname = pcsname;
	}
	public String getFenjucode() {
		return fenjucode;
	}
	public void setFenjucode(String fenjucode) {
		this.fenjucode = fenjucode;
	}
	public String getFenjuname() {
		return fenjuname;
	}
	public void setFenjuname(String fenjuname) {
		this.fenjuname = fenjuname;
	}
	public String getCreatedate() {
		return createdate;
	}
	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}
	public String getLastdate() {
		return lastdate;
	}
	public void setLastdate(String lastdate) {
		this.lastdate = lastdate;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getDwss() {
		return dwss;
	}
	public void setDwss(String dwss) {
		this.dwss = dwss;
	}
	public String getDwlb() {
		return dwlb;
	}
	public void setDwlb(String dwlb) {
		this.dwlb = dwlb;
	}
	public String getPolicername() {
		return policername;
	}
	public void setPolicername(String policername) {
		this.policername = policername;
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
	public String getSydwid() {
		return sydwid;
	}
	public void setSydwid(String sydwid) {
		this.sydwid = sydwid;
	}
	public String getPcscode() {
		return pcscode;
	}
	public void setPcscode(String pcscode) {
		this.pcscode = pcscode;
	}
	public String getBzdzmc() {
		return bzdzmc;
	}
	public void setBzdzmc(String bzdzmc) {
		this.bzdzmc = bzdzmc;
	}
	
}
