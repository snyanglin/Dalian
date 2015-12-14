package com.founder.zafffwqz.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;


/******************************************************************************
 * @Package:      [com.founder.zafffwqz.bean.DxqzxhdDxhdjbxxb.java]  
 * @ClassName:    [DxqzxhdDxhdjbxxb]   
 * @Description:  [大型活动基本信息表]   
 * @Author:       [xuhaibo@founder.com.cn]  
 * @CreateDate:   [2015-5-14 中午12:50:47]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-5-14 中午12:50:47，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 */
@DBInfoAnnotation(tableName = "DXQZXHD_DXHDJBXXB", pk = "id")
public class DxqzxhdDxhdjbxxb extends BaseEntity implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@FieldDesc("活动ID")
	private String hdid;
	@FieldDesc("活动类型代码")
	private String hdlxdm;
	@FieldDesc("活动性质代码")
	private String hdxzdm;
	@FieldDesc("活动名称")
	private String hdmc;
	@FieldDesc("活动场次")
	private String hdcc;
	@FieldDesc("每场次预计人数代码")
	private String mccyjrsdm;
	@FieldDesc("额定容量")
	private String edrl;
	@FieldDesc("拟发售票数")
	private String nfsps;
	@FieldDesc("地址-活动地点省市县代码")
	private String dz_hdddssxdm;
	@FieldDesc("地址-活动地点门楼牌代码")
	private String dz_hdddmlpdm;
	@FieldDesc("地址-活动地点门楼牌详址")
	private String dz_hdddlpxz;
	@FieldDesc("DZ_HDDDDZDM")
	private String dz_hddddzdm;
	@FieldDesc("地址-活动地点详址")
	private String dz_hdddxz;
	@FieldDesc("地址-活动地点详址补充说明")
	private String dz_hdddxzbcsm;
	@FieldDesc("场地面积")
	private String cdmj;
	@FieldDesc("活动路线")
	private String hdlx;
	@FieldDesc("里程")
	private Long lc;
	@FieldDesc("活动开始时间")
	private String hdkssj;
	@FieldDesc("活动结束时间")
	private String hdjssj;
	@FieldDesc("活动主要内容")
	private String hdzynr;
	@FieldDesc("处理结果代码")
	private String cljgdm;
	@FieldDesc("备注")
	private String bz;
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
	public String getHdid() {
		return hdid;
	}
	public void setHdid(String hdid) {
		this.hdid = hdid;
	}
	public String getHdlxdm() {
		return hdlxdm;
	}
	public void setHdlxdm(String hdlxdm) {
		this.hdlxdm = hdlxdm;
	}
	public String getHdxzdm() {
		return hdxzdm;
	}
	public void setHdxzdm(String hdxzdm) {
		this.hdxzdm = hdxzdm;
	}
	public String getHdmc() {
		return hdmc;
	}
	public void setHdmc(String hdmc) {
		this.hdmc = hdmc;
	}
	public String getHdcc() {
		return hdcc;
	}
	public void setHdcc(String hdcc) {
		this.hdcc = hdcc;
	}
	public String getMccyjrsdm() {
		return mccyjrsdm;
	}
	public void setMccyjrsdm(String mccyjrsdm) {
		this.mccyjrsdm = mccyjrsdm;
	}
	public String getEdrl() {
		return edrl;
	}
	public void setEdrl(String edrl) {
		this.edrl = edrl;
	}
	public String getNfsps() {
		return nfsps;
	}
	public void setNfsps(String nfsps) {
		this.nfsps = nfsps;
	}
	public String getDz_hdddssxdm() {
		return dz_hdddssxdm;
	}
	public void setDz_hdddssxdm(String dz_hdddssxdm) {
		this.dz_hdddssxdm = dz_hdddssxdm;
	}
	public String getDz_hdddmlpdm() {
		return dz_hdddmlpdm;
	}
	public void setDz_hdddmlpdm(String dz_hdddmlpdm) {
		this.dz_hdddmlpdm = dz_hdddmlpdm;
	}
	public String getDz_hdddlpxz() {
		return dz_hdddlpxz;
	}
	public void setDz_hdddlpxz(String dz_hdddlpxz) {
		this.dz_hdddlpxz = dz_hdddlpxz;
	}
	public String getDz_hddddzdm() {
		return dz_hddddzdm;
	}
	public void setDz_hddddzdm(String dz_hddddzdm) {
		this.dz_hddddzdm = dz_hddddzdm;
	}
	public String getDz_hdddxz() {
		return dz_hdddxz;
	}
	public void setDz_hdddxz(String dz_hdddxz) {
		this.dz_hdddxz = dz_hdddxz;
	}
	public String getDz_hdddxzbcsm() {
		return dz_hdddxzbcsm;
	}
	public void setDz_hdddxzbcsm(String dz_hdddxzbcsm) {
		this.dz_hdddxzbcsm = dz_hdddxzbcsm;
	}
	public String getCdmj() {
		return cdmj;
	}
	public void setCdmj(String cdmj) {
		this.cdmj = cdmj;
	}
	public String getHdlx() {
		return hdlx;
	}
	public void setHdlx(String hdlx) {
		this.hdlx = hdlx;
	}
	public Long getLc() {
		return lc;
	}
	public void setLc(Long lc) {
		this.lc = lc;
	}
	public String getHdkssj() {
		return hdkssj;
	}
	public void setHdkssj(String hdkssj) {
		this.hdkssj = hdkssj;
	}
	public String getHdjssj() {
		return hdjssj;
	}
	public void setHdjssj(String hdjssj) {
		this.hdjssj = hdjssj;
	}
	public String getHdzynr() {
		return hdzynr;
	}
	public void setHdzynr(String hdzynr) {
		this.hdzynr = hdzynr;
	}
	public String getCljgdm() {
		return cljgdm;
	}
	public void setCljgdm(String cljgdm) {
		this.cljgdm = cljgdm;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	
}
