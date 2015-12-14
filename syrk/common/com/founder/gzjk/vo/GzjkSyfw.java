package com.founder.gzjk.vo;

public class GzjkSyfw {

	private String id;  //主键
	
	private String fwmc; //房屋名称
	private String fwlxdm; //房屋性质
	private String fwlx; //房屋性质
	
	private String dzdm; //地址代码
	private String dz_fwdzxz; //地址全称
	private String dzqc; //地址全称
	
	private String sfczfdm;//是否出租房
	
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
    
	public String getDzqc() {
		return dzqc;
	}

	public void setDzqc(String dzqc) {
		this.dzqc = dzqc;
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

	public String getFwmc() {
		return fwmc;
	}

	public void setFwmc(String fwmc) {
		this.fwmc = fwmc;
	}

	

	public String getFwlxdm() {
		return fwlxdm;
	}

	public void setFwlxdm(String fwlxdm) {
		this.fwlxdm = fwlxdm;
	}

	public String getDz_fwdzxz() {
		return dz_fwdzxz;
	}

	public void setDz_fwdzxz(String dzFwdzxz) {
		dz_fwdzxz = dzFwdzxz;
	}

	public String getDzdm() {
		return dzdm;
	}

	public void setDzdm(String dzdm) {
		this.dzdm = dzdm;
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

	public String getSfczfdm() {
		return sfczfdm;
	}

	public void setSfczfdm(String sfczfdm) {
		this.sfczfdm = sfczfdm;
	}

	public String getFwlx() {
		return fwlx;
	}

	public void setFwlx(String fwlx) {
		this.fwlx = fwlx;
	}
	
	

}
