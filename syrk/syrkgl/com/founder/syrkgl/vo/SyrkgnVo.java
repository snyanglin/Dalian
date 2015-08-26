package com.founder.syrkgl.vo;

import java.io.Serializable;
/***
 * ****************************************************************************
 * @Package:      [com.founder.syrkgl.vo.SyrkgnVo.java]  
 * @ClassName:    [SyrkgnVo]   
 * @Description:  [一句话描述该类的功能]   
 * @Author:       [wu_chunhui@founder.com.cn]  
 * @CreateDate:   [2015-4-27 下午6:13:05]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-4-27 下午6:13:05，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
public class SyrkgnVo implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id;
	private String syrklx;
	private String px;
	private String gnid;
	private String gnbh;
	private String gnmc;
	private String gnanmc;
	private String gnanurl;
	private String gnlxdm;
	private String gndybm;
	private String bctsxx;
	private String dkfs;

	public String getDkfs() {
		return dkfs;
	}

	public void setDkfs(String dkfs) {
		this.dkfs = dkfs;
	}

	public String getBctsxx() {
		return bctsxx;
	}

	public void setBctsxx(String bctsxx) {
		this.bctsxx = bctsxx;
	}

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

}
