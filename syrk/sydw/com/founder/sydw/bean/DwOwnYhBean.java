package com.founder.sydw.bean;

import java.io.Serializable;
import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

/******************************************************************************
 * @Package:      [com.founder.sydw.bean.DwOwnYhBean.java]  
 * @ClassName:    [DwOwnYhBean]   
 * @Description:  [一句话描述该类的功能]   
 * @Author:       [star]  
 * @CreateDate:   [2015-6-5 下午1:54:56]   
 * @UpdateUser:   [star(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-6-5 下午1:54:56，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 */
@DBInfoAnnotation(tableName = "DW_DWYHXXB", pk = "id")
public class DwOwnYhBean extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * 时间：2015，4.14
	 * 人：star
	 * 内容：单位_烟花信息表
	 */
	@FieldDesc("ID")
	private String id;
	@FieldDesc("单位ID")
	private String dwid;
	@FieldDesc("备案机关")
	private String bajg;
	@FieldDesc("是否配送")
	private String sfps;
	@FieldDesc("作业人数")
	private String zyry;
	@FieldDesc("产品质量检验信息")
	private String cpzljyxx;
	@FieldDesc("备注")
	private String bz;
	@FieldDesc("许可证类型")
	private String xkzlx;
	@FieldDesc("发证机关")
	private String fzjg;
	@FieldDesc("发证日期")
	private String fzrq;
	@FieldDesc("有效截止日期")
	private String yxjzrq;
	@FieldDesc("库房名称")
	private String kfmc;
	@FieldDesc("库房类别")
	private String kflb;
	@FieldDesc("危险等级")
	private String wxdj;
	@FieldDesc("总建筑面积")
	private String zjzmj;
	@FieldDesc("回收间建筑面积")
	private String hsjjzmj;
	@FieldDesc("生产区建筑面积")
	private String scqjzmj;
	@FieldDesc("经营面积")
	private String jymj;
	@FieldDesc("涉药库房面积")
	private String sykfmj;
	@FieldDesc("核定库存量")
	private String hdkcl;
	@FieldDesc("查看")
	private String ck;
	@FieldDesc("燃放规模等级")
	private String yfgmdjdm;
	@FieldDesc("许可证编号")
	private String xkzbh;
	
	@FieldDesc("采集时间")
	private String xt_cjsj;
	@FieldDesc("录入时间")
	private String xt_lrsj;
	@FieldDesc("录入人姓名")
	private String xt_lrrxm;
	@FieldDesc("录入人ID")
	private String xt_lrrid;
	@FieldDesc("录入人部门")
	private String xt_lrrbm;
	@FieldDesc("录入人部门ID")
	private String xt_lrrbmid;
	@FieldDesc("录入IP")
	private String xt_lrip;
	@FieldDesc("最后修改时间")
	private String xt_zhxgsj;
	@FieldDesc("最后修改人姓名")
	private String xt_zhxgrxm;
	@FieldDesc("最后修改人ID")
	private String xt_zhxgrid;
	@FieldDesc("最后修改人部门")
	private String xt_zhxgrbm;
	@FieldDesc("最后修改人部门ID")
	private String xt_zhxgrbmid;
	@FieldDesc("最后修改IP")
	private String xt_zhxgip;
	@FieldDesc("注销标志")
	private String xt_zxbz;
	@FieldDesc("注销原因")
	private String xt_zxyy;

	public String getYfgmdjdm() {
		return yfgmdjdm;
	}
	public void setYfgmdjdm(String yfgmdjdm) {
		this.yfgmdjdm = yfgmdjdm;
	}
	public String getXkzbh() {
		return xkzbh;
	}
	public void setXkzbh(String xkzbh) {
		this.xkzbh = xkzbh;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDwid() {
		return dwid;
	}
	public void setDwid(String dwid) {
		this.dwid = dwid;
	}
	public String getBajg() {
		return bajg;
	}
	public void setBajg(String bajg) {
		this.bajg = bajg;
	}
	public String getSfps() {
		return sfps;
	}
	public void setSfps(String sfps) {
		this.sfps = sfps;
	}
	public String getZyry() {
		return zyry;
	}
	public void setZyry(String zyry) {
		this.zyry = zyry;
	}
	public String getCpzljyxx() {
		return cpzljyxx;
	}
	public void setCpzljyxx(String cpzljyxx) {
		this.cpzljyxx = cpzljyxx;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	public String getXkzlx() {
		return xkzlx;
	}
	public void setXkzlx(String xkzlx) {
		this.xkzlx = xkzlx;
	}
	public String getFzjg() {
		return fzjg;
	}
	public void setFzjg(String fzjg) {
		this.fzjg = fzjg;
	}
	public String getFzrq() {
		return fzrq;
	}
	public void setFzrq(String fzrq) {
		this.fzrq = fzrq;
	}
	public String getYxjzrq() {
		return yxjzrq;
	}
	public void setYxjzrq(String yxjzrq) {
		this.yxjzrq = yxjzrq;
	}
	public String getKfmc() {
		return kfmc;
	}
	public void setKfmc(String kfmc) {
		this.kfmc = kfmc;
	}
	public String getKflb() {
		return kflb;
	}
	public void setKflb(String kflb) {
		this.kflb = kflb;
	}
	public String getWxdj() {
		return wxdj;
	}
	public void setWxdj(String wxdj) {
		this.wxdj = wxdj;
	}
	public String getZjzmj() {
		return zjzmj;
	}
	public void setZjzmj(String zjzmj) {
		this.zjzmj = zjzmj;
	}
	public String getHsjjzmj() {
		return hsjjzmj;
	}
	public void setHsjjzmj(String hsjjzmj) {
		this.hsjjzmj = hsjjzmj;
	}
	public String getScqjzmj() {
		return scqjzmj;
	}
	public void setScqjzmj(String scqjzmj) {
		this.scqjzmj = scqjzmj;
	}
	public String getJymj() {
		return jymj;
	}
	public void setJymj(String jymj) {
		this.jymj = jymj;
	}
	public String getSykfmj() {
		return sykfmj;
	}
	public void setSykfmj(String sykfmj) {
		this.sykfmj = sykfmj;
	}
	public String getHdkcl() {
		return hdkcl;
	}
	public void setHdkcl(String hdkcl) {
		this.hdkcl = hdkcl;
	}
	public String getCk() {
		return ck;
	}
	public void setCk(String ck) {
		this.ck = ck;
	}

	public String getXt_cjsj() {
		return xt_cjsj;
	}
	public void setXt_cjsj(String xt_cjsj) {
		this.xt_cjsj = xt_cjsj;
	}
	public String getXt_lrsj() {
		return xt_lrsj;
	}
	public void setXt_lrsj(String xt_lrsj) {
		this.xt_lrsj = xt_lrsj;
	}
	public String getXt_lrrxm() {
		return xt_lrrxm;
	}
	public void setXt_lrrxm(String xt_lrrxm) {
		this.xt_lrrxm = xt_lrrxm;
	}
	public String getXt_lrrid() {
		return xt_lrrid;
	}
	public void setXt_lrrid(String xt_lrrid) {
		this.xt_lrrid = xt_lrrid;
	}
	public String getXt_lrrbm() {
		return xt_lrrbm;
	}
	public void setXt_lrrbm(String xt_lrrbm) {
		this.xt_lrrbm = xt_lrrbm;
	}
	public String getXt_lrrbmid() {
		return xt_lrrbmid;
	}
	public void setXt_lrrbmid(String xt_lrrbmid) {
		this.xt_lrrbmid = xt_lrrbmid;
	}
	public String getXt_lrip() {
		return xt_lrip;
	}
	public void setXt_lrip(String xt_lrip) {
		this.xt_lrip = xt_lrip;
	}
	public String getXt_zhxgsj() {
		return xt_zhxgsj;
	}
	public void setXt_zhxgsj(String xt_zhxgsj) {
		this.xt_zhxgsj = xt_zhxgsj;
	}
	public String getXt_zhxgrxm() {
		return xt_zhxgrxm;
	}
	public void setXt_zhxgrxm(String xt_zhxgrxm) {
		this.xt_zhxgrxm = xt_zhxgrxm;
	}
	public String getXt_zhxgrid() {
		return xt_zhxgrid;
	}
	public void setXt_zhxgrid(String xt_zhxgrid) {
		this.xt_zhxgrid = xt_zhxgrid;
	}
	public String getXt_zhxgrbm() {
		return xt_zhxgrbm;
	}
	public void setXt_zhxgrbm(String xt_zhxgrbm) {
		this.xt_zhxgrbm = xt_zhxgrbm;
	}
	public String getXt_zhxgrbmid() {
		return xt_zhxgrbmid;
	}
	public void setXt_zhxgrbmid(String xt_zhxgrbmid) {
		this.xt_zhxgrbmid = xt_zhxgrbmid;
	}
	public String getXt_zhxgip() {
		return xt_zhxgip;
	}
	public void setXt_zhxgip(String xt_zhxgip) {
		this.xt_zhxgip = xt_zhxgip;
	}
	public String getXt_zxbz() {
		return xt_zxbz;
	}
	public void setXt_zxbz(String xt_zxbz) {
		this.xt_zxbz = xt_zxbz;
	}
	public String getXt_zxyy() {
		return xt_zxyy;
	}
	public void setXt_zxyy(String xt_zxyy) {
		this.xt_zxyy = xt_zxyy;
	} 
}