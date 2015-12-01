package com.founder.shhxxcj.bean;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;

@DBInfoAnnotation(tableName = "Enterprises", pk = "id")
public class Enterprises {

	@FieldDesc("Id主键")
	private String id;
	@FieldDesc("注册名称")
	private String zcmc;
	@FieldDesc("实际经营名称")
	private String sjjymc;
	@FieldDesc("办公电话")
	private String lxdh;
	@FieldDesc("组织机构代码")
	private String zzjgdm;
	@FieldDesc("注册资金")
	private String zczj;
	@FieldDesc("注册地址")
	private String zcdz;
	@FieldDesc("所在分局代码")
	private Long fenjucode;
	@FieldDesc("所在派出所代码")
	private String pcscode;
	@FieldDesc("企业性质")
	private String qyxz;
	@FieldDesc("经营状态")
	private String jyzt;
	@FieldDesc("实际经营地址")
	private String jydz;
	@FieldDesc("法定代表人")
	private String fddbr;
	@FieldDesc("负责人")
	private String sjjyrxm;
	@FieldDesc("实际经营人手机")
	private String sjjyrsj;
	@FieldDesc("经营项目 主营")
	private String jyxmzy;
	@FieldDesc("从业人员总数")
	private Long cyryzs;
	@FieldDesc("状态-备用项")
	private String status;
	@FieldDesc("比中数")
	private Long bzs;
	@FieldDesc("比对总数")
	private Long bds;
	@FieldDesc("年采集量")
	private Long year;
	@FieldDesc("月采集量")
	private Long month;
	@FieldDesc("日采集量")
	private Long day;
	@FieldDesc("创建时间")
	private String createdate;
	@FieldDesc("企业类型")
	private String enttype;
	@FieldDesc("营业执照编号")
	private String yyzzbh;
	@FieldDesc("营业执照起始日期")
	private String yyzzqs;
	@FieldDesc("营业执照截止日期")
	private String yyzzjz;
	@FieldDesc("经营范围")
	private String jyfw;
	@FieldDesc("开业日期")
	private String kyrq;
	@FieldDesc("经营面积")
	private String jymj;
	@FieldDesc("核实状态")
	private String hszt;
	@FieldDesc("标准地址id")
	private String bzdzid;
	@FieldDesc("责任区代码")
	private String ss4jbmdm;
	@FieldDesc("实有单位id")
	private String sydwid;
	
	/**
	 * 数据库不存在此字段（核实单位的时候 如果不是标准地址 则用此字段显示）
	 */
	private String bzdzmc;
	
	
	
	
	public String getBzdzmc() {
		return bzdzmc;
	}
	public void setBzdzmc(String bzdzmc) {
		this.bzdzmc = bzdzmc;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getZcmc() {
		return zcmc;
	}
	public void setZcmc(String zcmc) {
		this.zcmc = zcmc;
	}
	public String getSjjymc() {
		return sjjymc;
	}
	public void setSjjymc(String sjjymc) {
		this.sjjymc = sjjymc;
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
	public String getZczj() {
		return zczj;
	}
	public void setZczj(String zczj) {
		this.zczj = zczj;
	}
	public String getZcdz() {
		return zcdz;
	}
	public void setZcdz(String zcdz) {
		this.zcdz = zcdz;
	}
	public Long getFenjucode() {
		return fenjucode;
	}
	public void setFenjucode(Long fenjucode) {
		this.fenjucode = fenjucode;
	}
	public String getPcscode() {
		return pcscode;
	}
	public void setPcscode(String pcscode) {
		this.pcscode = pcscode;
	}
	public String getQyxz() {
		return qyxz;
	}
	public void setQyxz(String qyxz) {
		this.qyxz = qyxz;
	}
	public String getJyzt() {
		return jyzt;
	}
	public void setJyzt(String jyzt) {
		this.jyzt = jyzt;
	}
	public String getJydz() {
		return jydz;
	}
	public void setJydz(String jydz) {
		this.jydz = jydz;
	}
	public String getFddbr() {
		return fddbr;
	}
	public void setFddbr(String fddbr) {
		this.fddbr = fddbr;
	}
	public String getSjjyrxm() {
		return sjjyrxm;
	}
	public void setSjjyrxm(String sjjyrxm) {
		this.sjjyrxm = sjjyrxm;
	}
	public String getSjjyrsj() {
		return sjjyrsj;
	}
	public void setSjjyrsj(String sjjyrsj) {
		this.sjjyrsj = sjjyrsj;
	}
	public String getJyxmzy() {
		return jyxmzy;
	}
	public void setJyxmzy(String jyxmzy) {
		this.jyxmzy = jyxmzy;
	}
	public Long getCyryzs() {
		return cyryzs;
	}
	public void setCyryzs(Long cyryzs) {
		this.cyryzs = cyryzs;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Long getBzs() {
		return bzs;
	}
	public void setBzs(Long bzs) {
		this.bzs = bzs;
	}
	public Long getBds() {
		return bds;
	}
	public void setBds(Long bds) {
		this.bds = bds;
	}
	public Long getYear() {
		return year;
	}
	public void setYear(Long year) {
		this.year = year;
	}
	public Long getMonth() {
		return month;
	}
	public void setMonth(Long month) {
		this.month = month;
	}
	public Long getDay() {
		return day;
	}
	public void setDay(Long day) {
		this.day = day;
	}
	public String getCreatedate() {
		return createdate;
	}
	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}
	public String getEnttype() {
		return enttype;
	}
	public void setEnttype(String enttype) {
		this.enttype = enttype;
	}
	public String getYyzzbh() {
		return yyzzbh;
	}
	public void setYyzzbh(String yyzzbh) {
		this.yyzzbh = yyzzbh;
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
	public String getJyfw() {
		return jyfw;
	}
	public void setJyfw(String jyfw) {
		this.jyfw = jyfw;
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

	
}
