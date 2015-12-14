package com.founder.gzjk.vo;

public class GzjkSydw {

	private String id;  //主键
	
	private String dwdm; //单位代码
	
	private String dwmc; //单位名称
	
	private String glbmdm;//管理部门代码
	
	private String glbmmc;//管理部门名称
	
	private String dzdm; //地址代码
	
	private String dzqc; //地址全称
	
	private String bdlx;  //变动类型 
	
	private String zxbz;  //注销标志
	
	private String zhxgsj;  //最后修改时间
	
	private String xtczsj;  //时间
	
	private String zby;  //坐标Y
	
	private String zbx;  //坐标X
	
	private String isNew; //是否为最新数据
	
	private String ssbmid;  //所属部门 ID

	public String getSsbmid() {
		return ssbmid;
	}

	public void setSsbmid(String ssbmid) {
		this.ssbmid = ssbmid;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDwdm() {
		return dwdm;
	}

	public void setDwdm(String dwdm) {
		this.dwdm = dwdm;
	}

	public String getDwmc() {
		return dwmc;
	}

	public void setDwmc(String dwmc) {
		this.dwmc = dwmc;
	}

	public String getGlbmdm() {
		return glbmdm;
	}

	public void setGlbmdm(String glbmdm) {
		this.glbmdm = glbmdm;
	}

	public String getGlbmmc() {
		return glbmmc;
	}

	public void setGlbmmc(String glbmmc) {
		this.glbmmc = glbmmc;
	}

	public String getDzdm() {
		return dzdm;
	}

	public void setDzdm(String dzdm) {
		this.dzdm = dzdm;
	}

	public String getDzqc() {
		return dzqc;
	}

	public void setDzqc(String dzqc) {
		this.dzqc = dzqc;
	}

	public String getBdlx() {
		return bdlx;
	}

	public void setBdlx(String bdlx) {
		this.bdlx = bdlx;
	}

	public String getZxbz() {
		return zxbz;
	}

	public void setZxbz(String zxbz) {
		this.zxbz = zxbz;
	}

	public String getZhxgsj() {
		return zhxgsj;
	}

	public void setZhxgsj(String zhxgsj) {
		this.zhxgsj = zhxgsj;
	}

	public String getXtczsj() {
		return xtczsj;
	}

	public void setXtczsj(String xtczsj) {
		this.xtczsj = xtczsj;
	}

	public String getZby() {
		return zby;
	}

	public void setZby(String zby) {
		this.zby = zby;
	}

	public String getZbx() {
		return zbx;
	}

	public void setZbx(String zbx) {
		this.zbx = zbx;
	}

	public String getIsNew() {
		return isNew;
	}

	public void setIsNew(String isNew) {
		this.isNew = isNew;
	}
}
