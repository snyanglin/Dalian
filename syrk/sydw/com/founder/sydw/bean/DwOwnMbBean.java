package com.founder.sydw.bean;

import java.io.Serializable;
import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

/******************************************************************************
 * @Package:      [com.founder.sydw.bean.DwOwnMbBean.java]  
 * @ClassName:    [DwOwnMbBean]   
 * @Description:  [一句话描述该类的功能]   
 * @Author:       [star]  
 * @CreateDate:   [2015-6-5 下午1:42:08]   
 * @UpdateUser:   [star(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-6-5 下午1:42:08，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 */
@DBInfoAnnotation(tableName = "DW_DWMBXXB", pk = "id")
public class DwOwnMbBean extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * 时间：2015，4.23
	 * 人：star
	 * 内容：民爆施工项目业绩表
	 */
	@FieldDesc("ID")
	private String id;
	@FieldDesc("单位ID")
	private String dwid;
	@FieldDesc("爆破作业单位许可证类型")
	private String bpzydwxkzlxdm;
	@FieldDesc("企业代号")
	private String qydh;
	@FieldDesc("作业地点")
	private String zydd;
	@FieldDesc("技术负责人姓名")
	private String  jsfzrxm;
	@FieldDesc("治安保卫负责人姓名")
	private String  zabwfzrxm;
	@FieldDesc("技术负责人公民身份号码")
	private String jsfzrgmsfzhm;
	@FieldDesc("治安保卫负责人公民身份号码")
	private String zabwfzrgmsfzhm;	
	@FieldDesc("技术负责人联系电话")
	private String jsfzrlxdh;	
	@FieldDesc("治安保卫负责人联系电话")
	private String zabwfzrlxdh;
	@FieldDesc("注册资金")
	private String zczj;
	@FieldDesc("净资产")
	private String jzc;
	@FieldDesc("专用设备净值（万元）")
	private String zysbjz;
	@FieldDesc("银行账号")
	private String yhzh;
	@FieldDesc("申请资质等级")
	private String sqzzdj;
	@FieldDesc("申请从业范围")
	private String sqcyfw;
	@FieldDesc("申请日期")
	private String sqrq;
	@FieldDesc("证件签发日期")
	private String zjqfrq;
	@FieldDesc("采矿许可证编号")
	private String ckxkzbh; 
	@FieldDesc("采矿许可证有效期")
	private String ckxkzyxq;
	@FieldDesc("煤炭生产许可证编号")
	private String mtscxkzbh; 
	@FieldDesc("煤炭生产许可证有效期")
	private String mtscxkzyxq;
	@FieldDesc("安全生产许可证编号")
	private String aqscxkzbh;
	@FieldDesc("安全生产许可证有效期")
	private String aqscxkzyxq;
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

	public String getBpzydwxkzlxdm() {
		return bpzydwxkzlxdm;
	}
	public void setBpzydwxkzlxdm(String bpzydwxkzlxdm) {
		this.bpzydwxkzlxdm = bpzydwxkzlxdm;
	}
	public String getQydh() {
		return qydh;
	}
	public void setQydh(String qydh) {
		this.qydh = qydh;
	}
	public String getZydd() {
		return zydd;
	}
	public void setZydd(String zydd) {
		this.zydd = zydd;
	}
	public String getJsfzrxm() {
		return jsfzrxm;
	}
	public void setJsfzrxm(String jsfzrxm) {
		this.jsfzrxm = jsfzrxm;
	}
	public String getZabwfzrxm() {
		return zabwfzrxm;
	}
	public void setZabwfzrxm(String zabwfzrxm) {
		this.zabwfzrxm = zabwfzrxm;
	}
	public String getJsfzrgmsfzhm() {
		return jsfzrgmsfzhm;
	}
	public void setJsfzrgmsfzhm(String jsfzrgmsfzhm) {
		this.jsfzrgmsfzhm = jsfzrgmsfzhm;
	}
	public String getZabwfzrgmsfzhm() {
		return zabwfzrgmsfzhm;
	}
	public void setZabwfzrgmsfzhm(String zabwfzrgmsfzhm) {
		this.zabwfzrgmsfzhm = zabwfzrgmsfzhm;
	}
	public String getJsfzrlxdh() {
		return jsfzrlxdh;
	}
	public void setJsfzrlxdh(String jsfzrlxdh) {
		this.jsfzrlxdh = jsfzrlxdh;
	}
	public String getZabwfzrlxdh() {
		return zabwfzrlxdh;
	}
	public void setZabwfzrlxdh(String zabwfzrlxdh) {
		this.zabwfzrlxdh = zabwfzrlxdh;
	}
	public String getZczj() {
		return zczj;
	}
	public void setZczj(String zczj) {
		this.zczj = zczj;
	}
	public String getJzc() {
		return jzc;
	}
	public void setJzc(String jzc) {
		this.jzc = jzc;
	}
	public String getZysbjz() {
		return zysbjz;
	}
	public void setZysbjz(String zysbjz) {
		this.zysbjz = zysbjz;
	}
	public String getYhzh() {
		return yhzh;
	}
	public void setYhzh(String yhzh) {
		this.yhzh = yhzh;
	}
	public String getSqzzdj() {
		return sqzzdj;
	}
	public void setSqzzdj(String sqzzdj) {
		this.sqzzdj = sqzzdj;
	}
	public String getSqcyfw() {
		return sqcyfw;
	}
	public void setSqcyfw(String sqcyfw) {
		this.sqcyfw = sqcyfw;
	}
	public String getSqrq() {
		return sqrq;
	}
	public void setSqrq(String sqrq) {
		this.sqrq = sqrq;
	}
	public String getZjqfrq() {
		return zjqfrq;
	}
	public void setZjqfrq(String zjqfrq) {
		this.zjqfrq = zjqfrq;
	}
	public String getCkxkzbh() {
		return ckxkzbh;
	}
	public void setCkxkzbh(String ckxkzbh) {
		this.ckxkzbh = ckxkzbh;
	}
	public String getCkxkzyxq() {
		return ckxkzyxq;
	}
	public void setCkxkzyxq(String ckxkzyxq) {
		this.ckxkzyxq = ckxkzyxq;
	}
	public String getMtscxkzbh() {
		return mtscxkzbh;
	}
	public void setMtscxkzbh(String mtscxkzbh) {
		this.mtscxkzbh = mtscxkzbh;
	}
	public String getMtscxkzyxq() {
		return mtscxkzyxq;
	}
	public void setMtscxkzyxq(String mtscxkzyxq) {
		this.mtscxkzyxq = mtscxkzyxq;
	}
	public String getAqscxkzbh() {
		return aqscxkzbh;
	}
	public void setAqscxkzbh(String aqscxkzbh) {
		this.aqscxkzbh = aqscxkzbh;
	}
	public String getAqscxkzyxq() {
		return aqscxkzyxq;
	}
	public void setAqscxkzyxq(String aqscxkzyxq) {
		this.aqscxkzyxq = aqscxkzyxq;
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