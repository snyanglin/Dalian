package com.founder.yjjb.bean;

import java.util.List;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

/**
 * 案件信息表</br>
 * 存放案件的基本信息
 * @author yuhongyu
 * @since 2014-11-18
 * @version 1.0
 */
@DBInfoAnnotation(tableName = "YJJB_AJXXB", pk = "id")
public class Ajxxb extends BaseEntity  {

	@FieldDesc("主键")
	private String	id;

	@FieldDesc("案件编号")
	private String	ajbh;

	@FieldDesc("案件名称")
	private String	ajmc;

	@FieldDesc("案件类型:0-刑事案件 1-治安案件 2-特殊案件")
	private String	ajlx;

	@FieldDesc("案件状态:0-受案 1-立案 2-破案")
	private String	ajzt;

	@FieldDesc("办案单位")
	private String	badw;

	@FieldDesc("受理分站站代码")
	private String	slfzdm;
	
	@FieldDesc("受理站代码")
	private String	slzdm;
	
	@FieldDesc("受理中心代码")
	private String	slzxdm;
	
	@FieldDesc("受案简要信息")
	private String	sajyxx;

	@FieldDesc("立案简要信息")
	private String	lajyxx;

	@FieldDesc("破案简要信息")
	private String	pajyxx;

	@FieldDesc("处罚简要信息")
	private String	cfjyxx;
	
	@FieldDesc("受理时间")
	private String	slsj;

	@FieldDesc("采集时间")
	private String	xt_cjsj;

	@FieldDesc("录入时间")
	private String	xt_lrsj;

	@FieldDesc("录入人姓名")
	private String	xt_lrrxm;

	@FieldDesc("录入人ID")
	private String	xt_lrrid;

	@FieldDesc("录入人部门")
	private String	xt_lrrbm;

	@FieldDesc("录入人部门ID")
	private String	xt_lrrbmid;

	@FieldDesc("录入IP")
	private String	xt_lrip;

	@FieldDesc("最后修改时间")
	private String	xt_zhxgsj;

	@FieldDesc("最后修改人姓名")
	private String	xt_zhxgrxm;

	@FieldDesc("最后修改人ID")
	private String	xt_zhxgrid;

	@FieldDesc("最后修改人部门")
	private String	xt_zhxgrbm;

	@FieldDesc("最后修改人部门ID")
	private String	xt_zhxgrbmid;

	@FieldDesc("最后修改IP")
	private String	xt_zhxgip;

	@FieldDesc("注销标志")
	private String	xt_zxbz;

	@FieldDesc("注销原因")
	private String	xt_zxyy;
	
	@FieldDesc("线索编号")
	private String	xsbh;
	
	@FieldDesc("简要信息")
	private String	jyxx;
	
	@FieldDesc("附件名称")
	private List<String> fjmc;
	
	@FieldDesc("附件id")
	private List<String> fjid;
	
	@FieldDesc("附件描述")
	private List<String> fjms;
	
	@FieldDesc("附件类型")
	private List<String> fjlx;
	
	@FieldDesc("附件ver")
	private List<String> fjVersion;
	
	
	//查询用
	@FieldDesc("接报开始时间")
	private String starttime;
	
	@FieldDesc("接报结束时间")
	private String endtime;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAjbh() {
		return ajbh;
	}

	public void setAjbh(String ajbh) {
		this.ajbh = ajbh;
	}

	public String getAjlx() {
		return ajlx;
	}

	public void setAjlx(String ajlx) {
		this.ajlx = ajlx;
	}

	public String getAjzt() {
		return ajzt;
	}

	public void setAjzt(String ajzt) {
		this.ajzt = ajzt;
	}

	public String getBadw() {
		return badw;
	}

	public void setBadw(String badw) {
		this.badw = badw;
	}

	public String getSlfzdm() {
		return slfzdm;
	}

	public void setSlfzdm(String slfzdm) {
		this.slfzdm = slfzdm;
	}

	public String getSlzdm() {
		return slzdm;
	}

	public void setSlzdm(String slzdm) {
		this.slzdm = slzdm;
	}

	public String getSlzxdm() {
		return slzxdm;
	}

	public void setSlzxdm(String slzxdm) {
		this.slzxdm = slzxdm;
	}

	public String getSajyxx() {
		return sajyxx;
	}

	public void setSajyxx(String sajyxx) {
		this.sajyxx = sajyxx;
	}

	public String getLajyxx() {
		return lajyxx;
	}

	public void setLajyxx(String lajyxx) {
		this.lajyxx = lajyxx;
	}

	public String getPajyxx() {
		return pajyxx;
	}

	public void setPajyxx(String pajyxx) {
		this.pajyxx = pajyxx;
	}

	public String getCfjyxx() {
		return cfjyxx;
	}

	public void setCfjyxx(String cfjyxx) {
		this.cfjyxx = cfjyxx;
	}

	public String getXt_cjsj() {
		return xt_cjsj;
	}

	public void setXt_cjsj(String xtCjsj) {
		xt_cjsj = xtCjsj;
	}

	public String getXt_lrsj() {
		return xt_lrsj;
	}

	public void setXt_lrsj(String xtLrsj) {
		xt_lrsj = xtLrsj;
	}

	public String getXt_lrrxm() {
		return xt_lrrxm;
	}

	public void setXt_lrrxm(String xtLrrxm) {
		xt_lrrxm = xtLrrxm;
	}

	public String getXt_lrrid() {
		return xt_lrrid;
	}

	public void setXt_lrrid(String xtLrrid) {
		xt_lrrid = xtLrrid;
	}

	public String getXt_lrrbm() {
		return xt_lrrbm;
	}

	public void setXt_lrrbm(String xtLrrbm) {
		xt_lrrbm = xtLrrbm;
	}

	public String getXt_lrrbmid() {
		return xt_lrrbmid;
	}

	public void setXt_lrrbmid(String xtLrrbmid) {
		xt_lrrbmid = xtLrrbmid;
	}

	public String getXt_lrip() {
		return xt_lrip;
	}

	public void setXt_lrip(String xtLrip) {
		xt_lrip = xtLrip;
	}

	public String getXt_zhxgsj() {
		return xt_zhxgsj;
	}

	public void setXt_zhxgsj(String xtZhxgsj) {
		xt_zhxgsj = xtZhxgsj;
	}

	public String getXt_zhxgrxm() {
		return xt_zhxgrxm;
	}

	public void setXt_zhxgrxm(String xtZhxgrxm) {
		xt_zhxgrxm = xtZhxgrxm;
	}

	public String getXt_zhxgrid() {
		return xt_zhxgrid;
	}

	public void setXt_zhxgrid(String xtZhxgrid) {
		xt_zhxgrid = xtZhxgrid;
	}

	public String getXt_zhxgrbm() {
		return xt_zhxgrbm;
	}

	public void setXt_zhxgrbm(String xtZhxgrbm) {
		xt_zhxgrbm = xtZhxgrbm;
	}

	public String getXt_zhxgrbmid() {
		return xt_zhxgrbmid;
	}

	public void setXt_zhxgrbmid(String xtZhxgrbmid) {
		xt_zhxgrbmid = xtZhxgrbmid;
	}

	public String getXt_zhxgip() {
		return xt_zhxgip;
	}

	public void setXt_zhxgip(String xtZhxgip) {
		xt_zhxgip = xtZhxgip;
	}

	public String getXt_zxbz() {
		return xt_zxbz;
	}

	public void setXt_zxbz(String xtZxbz) {
		xt_zxbz = xtZxbz;
	}

	public String getXt_zxyy() {
		return xt_zxyy;
	}

	public void setXt_zxyy(String xtZxyy) {
		xt_zxyy = xtZxyy;
	}

	public void setAjmc(String ajmc) {
		this.ajmc = ajmc;
	}

	public String getAjmc() {
		return ajmc;
	}

	public void setXsbh(String xsbh) {
		this.xsbh = xsbh;
	}

	public String getXsbh() {
		return xsbh;
	}

	public void setJyxx(String jyxx) {
		this.jyxx = jyxx;
	}

	public String getJyxx() {
		return jyxx;
	}

	/**
	 * @return the fjmc
	 */
	public List<String> getFjmc() {
		return fjmc;
	}

	/**
	 * @param fjmc the fjmc to set
	 */
	public void setFjmc(List<String> fjmc) {
		this.fjmc = fjmc;
	}

	/**
	 * @return the fjid
	 */
	public List<String> getFjid() {
		return fjid;
	}

	/**
	 * @param fjid the fjid to set
	 */
	public void setFjid(List<String> fjid) {
		this.fjid = fjid;
	}

	/**
	 * @return the fjms
	 */
	public List<String> getFjms() {
		return fjms;
	}

	/**
	 * @param fjms the fjms to set
	 */
	public void setFjms(List<String> fjms) {
		this.fjms = fjms;
	}

	/**
	 * @return the slsj
	 */
	public String getSlsj() {
		return slsj;
	}

	/**
	 * @param slsj the slsj to set
	 */
	public void setSlsj(String slsj) {
		this.slsj = slsj;
	}

	/**
	 * @return the starttime
	 */
	public String getStarttime() {
		return starttime;
	}

	/**
	 * @param starttime the starttime to set
	 */
	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	/**
	 * @return the endtime
	 */
	public String getEndtime() {
		return endtime;
	}

	/**
	 * @param endtime the endtime to set
	 */
	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

	/**
	 * @return the fjlx
	 */
	public List<String> getFjlx() {
		return fjlx;
	}

	/**
	 * @param fjlx the fjlx to set
	 */
	public void setFjlx(List<String> fjlx) {
		this.fjlx = fjlx;
	}

	/**
	 * @return the fjVersion
	 */
	public List<String> getFjVersion() {
		return fjVersion;
	}

	/**
	 * @param fjVersion the fjVersion to set
	 */
	public void setFjVersion(List<String> fjVersion) {
		this.fjVersion = fjVersion;
	}

}