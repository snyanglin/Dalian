package com.founder.zdry.bean;

import java.io.Serializable;

import com.founder.framework.annotation.FieldDesc;

/******************************************************************************
 * @Package: [com.founder.syrk.bean.Sjzdlcg.java]
 * @ClassName: [Sjzdlcg]
 * @Description: 上级指定列撤管
 * @Author: [xu_wenjun@founder.com.cn]
 * @CreateDate: [2015-1-28 上午11:07:16]
 * @UpdateUser: [Administrator(如多次修改保留历史记录，增加修改记录)]
 * @UpdateDate: [2015-1-28 上午11:07:16，(如多次修改保留历史记录，增加修改记录)]
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]
 * @Version: [v1.0]
 */

public class Sjzdlcg implements Serializable {

	private static final long serialVersionUID = 1L;
	
	//非业务表字段，grid查询使用
	@FieldDesc("人员id")private String ryid;
		
	//非业务表字段，grid查询使用
	@FieldDesc("姓名")private String xm;
	@FieldDesc("公民身份号码")private String gmsfhm;
	@FieldDesc("性别代码")private String xbdm;
	@FieldDesc("民族代码")private String mzdm;
	@FieldDesc("出生日期")private String csrq;
	@FieldDesc("婚姻状况")private String hyzkdm;
	@FieldDesc("政治面貌")private String zzmmdm;
	@FieldDesc("现居住地址")private String dz_jzdzxz;
	@FieldDesc("重点人员类型词条")private String zdrylxct;
	@FieldDesc("所属派出所")private String sspcs;
	
	//非业务表字段，subGrid查询使用
	@FieldDesc("审批日期")private String sprq;
	@FieldDesc("审批人")private String spr;
	@FieldDesc("指定部门词条")private String zdbmct;
	
	//非业务表字段，传递地址使用
	private String jzdzzbid;
	private String dzdm;
	private String dzxz;
	private String pcsdm;
	private String zrqdm;
	private String pcs;
	private String zrq;
	private String gxmj;
	private String gxmjlxdh;
	private String checked;
	
	//非业务表字段，传递列撤管参数使用
	private String zdlcglbdm;
	private String dzdmStr;
	private String jzdzzbidStr;
	private String lcgidStr;
	
	public String getRyid() {
		return ryid;
	}
	public String getJzdzzbid() {
		return jzdzzbid;
	}

	public void setJzdzzbid(String jzdzzbid) {
		this.jzdzzbid = jzdzzbid;
	}

	public String getDzdm() {
		return dzdm;
	}
	public void setDzdm(String dzdm) {
		this.dzdm = dzdm;
	}
	public String getDzxz() {
		return dzxz;
	}
	public void setDzxz(String dzxz) {
		this.dzxz = dzxz;
	}
	public String getPcsdm() {
		return pcsdm;
	}
	public void setPcsdm(String pcsdm) {
		this.pcsdm = pcsdm;
	}
	public String getZrqdm() {
		return zrqdm;
	}
	public void setZrqdm(String zrqdm) {
		this.zrqdm = zrqdm;
	}
	public String getPcs() {
		return pcs;
	}
	public void setPcs(String pcs) {
		this.pcs = pcs;
	}
	public String getZrq() {
		return zrq;
	}
	public void setZrq(String zrq) {
		this.zrq = zrq;
	}
	public String getGxmj() {
		return gxmj;
	}
	public void setGxmj(String gxmj) {
		this.gxmj = gxmj;
	}
	public String getGxmjlxdh() {
		return gxmjlxdh;
	}
	public void setGxmjlxdh(String gxmjlxdh) {
		this.gxmjlxdh = gxmjlxdh;
	}
	public String getChecked() {
		return checked;
	}
	public void setChecked(String checked) {
		this.checked = checked;
	}
	public String getZdlcglbdm() {
		return zdlcglbdm;
	}
	public void setZdlcglbdm(String zdlcglbdm) {
		this.zdlcglbdm = zdlcglbdm;
	}
	public String getDzdmStr() {
		return dzdmStr;
	}
	public void setDzdmStr(String dzdmStr) {
		this.dzdmStr = dzdmStr;
	}
	public String getJzdzzbidStr() {
		return jzdzzbidStr;
	}
	public void setJzdzzbidStr(String jzdzzbidStr) {
		this.jzdzzbidStr = jzdzzbidStr;
	}
	public void setRyid(String ryid) {
		this.ryid = ryid;
	}
	public String getXm() {
		return xm;
	}
	public void setXm(String xm) {
		this.xm = xm;
	}
	public String getGmsfhm() {
		return gmsfhm;
	}
	public void setGmsfhm(String gmsfhm) {
		this.gmsfhm = gmsfhm;
	}
	public String getXbdm() {
		return xbdm;
	}
	public void setXbdm(String xbdm) {
		this.xbdm = xbdm;
	}
	public String getMzdm() {
		return mzdm;
	}
	public void setMzdm(String mzdm) {
		this.mzdm = mzdm;
	}
	public String getCsrq() {
		return csrq;
	}
	public void setCsrq(String csrq) {
		this.csrq = csrq;
	}
	public String getHyzkdm() {
		return hyzkdm;
	}
	public void setHyzkdm(String hyzkdm) {
		this.hyzkdm = hyzkdm;
	}
	public String getZzmmdm() {
		return zzmmdm;
	}
	public void setZzmmdm(String zzmmdm) {
		this.zzmmdm = zzmmdm;
	}
	public String getDz_jzdzxz() {
		return dz_jzdzxz;
	}
	public void setDz_jzdzxz(String dz_jzdzxz) {
		this.dz_jzdzxz = dz_jzdzxz;
	}
	public String getZdrylxct() {
		return zdrylxct;
	}
	public void setZdrylxct(String zdrylxct) {
		this.zdrylxct = zdrylxct;
	}
	public String getSspcs() {
		return sspcs;
	}
	public void setSspcs(String sspcs) {
		this.sspcs = sspcs;
	}
	public String getSprq() {
		return sprq;
	}
	public void setSprq(String sprq) {
		this.sprq = sprq;
	}
	public String getSpr() {
		return spr;
	}
	public void setSpr(String spr) {
		this.spr = spr;
	}
	public String getZdbmct() {
		return zdbmct;
	}
	public void setZdbmct(String zdbmct) {
		this.zdbmct = zdbmct;
	}
	public String getLcgidStr() {
		return lcgidStr;
	}
	public void setLcgidStr(String lcgidStr) {
		this.lcgidStr = lcgidStr;
	}
	
}
