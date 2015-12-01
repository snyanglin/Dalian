package com.founder.zdry.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

/***
 * ****************************************************************************
 * 
 * @Package: [com.founder.zdry.bean.Lczywblb.java]
 * @ClassName: [Lczywblb]
 * @Description: [一句话描述该类的功能]
 * @Author: [wu_chunhui@founder.com.cn]
 * @CreateDate: [2015-3-11 下午6:08:08]
 * @UpdateUser: [Administrator(如多次修改保留历史记录，增加修改记录)]
 * @UpdateDate: [2015-3-11 下午6:08:08，(如多次修改保留历史记录，增加修改记录)]
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]
 * @Version: [v1.0]
 */
@DBInfoAnnotation(tableName = "ZDRY_LCZYWBLB", pk = "id")
public class ZdryLczywblb extends BaseEntity implements Serializable {
	public static final String NORMALTYPE = "normal";// 正常列撤
	public static final String NOAPPROVALTYPE = "noApproval";// 上级指定和核实列撤
	public static final String AFTERCGTYPE = "aftercgtype";//撤管后在列管,列管不走审批流程
	// 业务类型
	public static final String YWLX_LG = "1";// 列管
	public static final String YWLX_CG = "2";// 撤管
	public static final String YWLX_ZDFQ = "3";// 转递发起
	public static final String YWLX_ZDJS = "4";// 转递接收
	public static final String YWLX_ZDCJ = "5";// 转递裁决
	// 处理结果
	public static final String YWCLJG_CLZ = "0";// 处理中
	public static final String YWCLJG_CG = "1";// 成功
	public static final String YWCLJG_SB = "2";// 失败

	private static final long serialVersionUID = 1L;
	@FieldDesc("业务办理ID")
	private String id;
	@FieldDesc("重点人口总表ID")
	private String zdryid;
	@FieldDesc("实有人口总表ID")
	private String syrkid;
	@FieldDesc("前序业务ID")
	private String qxywid;
	@FieldDesc("业务类型")
	private String ywlx;
	@FieldDesc("所属责任区代码")
	private String sszrqdm;
	@FieldDesc("所属派出所代码")
	private String sspcsdm;
	@FieldDesc("地址-居住地址门楼牌代码")
	private String dz_jzdzmlpdm;
	@FieldDesc("地址-居住地址门楼牌详址")
	private String dz_jzdzmlpxz;
	@FieldDesc("地址-居住地址代码")
	private String dz_jzdzdm;
	@FieldDesc("地址-居住地址详址")
	private String dz_jzdzxz;
	@FieldDesc("业务办理人_姓名")
	private String ywblr_xm;
	@FieldDesc("业务办理人_ID")
	private String ywblr_id;
	@FieldDesc("业务发起原因")
	private String ywfqyy;
	@FieldDesc("业务处理时间")
	private String ywclsj;
	@FieldDesc("业务处理结果")
	private String ywcljg;
	@FieldDesc("备注")
	private String bz;

	public String getDz_jzdzmlpdm() {
		return dz_jzdzmlpdm;
	}

	public void setDz_jzdzmlpdm(String dz_jzdzmlpdm) {
		this.dz_jzdzmlpdm = dz_jzdzmlpdm;
	}

	public String getDz_jzdzmlpxz() {
		return dz_jzdzmlpxz;
	}

	public void setDz_jzdzmlpxz(String dz_jzdzmlpxz) {
		this.dz_jzdzmlpxz = dz_jzdzmlpxz;
	}

	public String getDz_jzdzdm() {
		return dz_jzdzdm;
	}

	public void setDz_jzdzdm(String dz_jzdzdm) {
		this.dz_jzdzdm = dz_jzdzdm;
	}

	public String getDz_jzdzxz() {
		return dz_jzdzxz;
	}

	public void setDz_jzdzxz(String dz_jzdzxz) {
		this.dz_jzdzxz = dz_jzdzxz;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getZdryid() {
		return zdryid;
	}

	public void setZdryid(String zdryid) {
		this.zdryid = zdryid;
	}

	public String getSyrkid() {
		return syrkid;
	}

	public void setSyrkid(String syrkid) {
		this.syrkid = syrkid;
	}

	public String getQxywid() {
		return qxywid;
	}

	public void setQxywid(String qxywid) {
		this.qxywid = qxywid;
	}

	public String getYwlx() {
		return ywlx;
	}

	public void setYwlx(String ywlx) {
		this.ywlx = ywlx;
	}

	public String getSszrqdm() {
		return sszrqdm;
	}

	public void setSszrqdm(String sszrqdm) {
		this.sszrqdm = sszrqdm;
	}

	public String getSspcsdm() {
		return sspcsdm;
	}

	public void setSspcsdm(String sspcsdm) {
		this.sspcsdm = sspcsdm;
	}

	public String getYwblr_xm() {
		return ywblr_xm;
	}

	public void setYwblr_xm(String ywblr_xm) {
		this.ywblr_xm = ywblr_xm;
	}

	public String getYwblr_id() {
		return ywblr_id;
	}

	public void setYwblr_id(String ywblr_id) {
		this.ywblr_id = ywblr_id;
	}

	public String getYwfqyy() {
		return ywfqyy;
	}

	public void setYwfqyy(String ywfqyy) {
		this.ywfqyy = ywfqyy;
	}

	public String getYwclsj() {
		return ywclsj;
	}

	public void setYwclsj(String ywclsj) {
		this.ywclsj = ywclsj;
	}

	public String getYwcljg() {
		return ywcljg;
	}

	public void setYwcljg(String ywcljg) {
		this.ywcljg = ywcljg;
	}

	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

}
