package com.founder.zdry.vo;

import java.io.Serializable;

/**
 * ****************************************************************************
 * @Package:      [com.founder.zdry.vo.ZdrygnVO.java]  
 * @ClassName:    [ZdrygnVO]   
 * @Description:  [重点人员编辑页面 功能展示VO]   
 * @Author:       [weiwen]  
 * @CreateDate:   [2015-3-13 下午6:05:19]   
 * @UpdateUser:   [weiwen]   
 * @UpdateDate:   [2015-3-13 下午6:05:19，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
public class ZdrygnVO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;
	private String syrklx;
	private String zdrylx;
	private String px;
	private String gnid;
	private String gnbh;
	private String gnmc;
	private String gnanmc;
	private String gnanurl;
	private String gnlxdm;
	private String gndybm;
	private String bctsxx;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSyrklx() {
		return syrklx;
	}
	public void setSyrklx(String syrklx) {
		this.syrklx = syrklx;
	}
	public String getZdrylx() {
		return zdrylx;
	}
	public void setZdrylx(String zdrylx) {
		this.zdrylx = zdrylx;
	}
	public String getPx() {
		return px;
	}
	public void setPx(String px) {
		this.px = px;
	}
	public String getGnid() {
		return gnid;
	}
	public void setGnid(String gnid) {
		this.gnid = gnid;
	}
	public String getGnbh() {
		return gnbh;
	}
	public void setGnbh(String gnbh) {
		this.gnbh = gnbh;
	}
	public String getGnmc() {
		return gnmc;
	}
	public void setGnmc(String gnmc) {
		this.gnmc = gnmc;
	}
	public String getGnanmc() {
		return gnanmc;
	}
	public void setGnanmc(String gnanmc) {
		this.gnanmc = gnanmc;
	}
	public String getGnanurl() {
		return gnanurl;
	}
	public void setGnanurl(String gnanurl) {
		this.gnanurl = gnanurl;
	}
	public String getGnlxdm() {
		return gnlxdm;
	}
	public void setGnlxdm(String gnlxdm) {
		this.gnlxdm = gnlxdm;
	}
	public String getGndybm() {
		return gndybm;
	}
	public void setGndybm(String gndybm) {
		this.gndybm = gndybm;
	}
	public String getBctsxx() {
		return bctsxx;
	}
	public void setBctsxx(String bctsxx) {
		this.bctsxx = bctsxx;
	}

}
