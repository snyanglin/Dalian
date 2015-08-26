/**********************************************************************   
 * <p>文件名：Dwjfdwxxb.java </p>
 * <p>文件描述：技防单位信息
 * @project_name：sydw
 * @author	yu_guangli@founder.com.cn 
 * @date 2015-6-6 下午12:07:03 
 * @history
 * @department：研发部
 *
 */
package com.founder.sydw.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;
@DBInfoAnnotation(tableName = "DW_JFDWXXB", pk = "id")
public class Dwjfdwxxb extends BaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@FieldDesc("ID")
	private String id;
	@FieldDesc("单位ID")
	private String dwid;
	@FieldDesc("有无监控")
	private String spjk_ywjkdm;
	@FieldDesc("监控范围")
	private String spjk_jkfwdm;
	@FieldDesc("点位数量")
	private String spjk_dwsl;
	@FieldDesc("摄像头分类")
	private String spjk_sxtfldm;
	@FieldDesc("存储时间")
	private String spjk_cxsj;
	@FieldDesc("有无监控室")
	private String spjk_ywjksdm;
	@FieldDesc("联系人姓名")
	private String spjk_lxrxm;
	@FieldDesc("联系人联系方式")
	private String spjk_lxrlxfs;
	@FieldDesc("有无 入侵报警")
	private String rqbj_ywrqbjdm;
	@FieldDesc("布防范围")
	private String rqbj_bffwdm;
	@FieldDesc("数量")
	private String rqbj_sl;
	@FieldDesc("入侵检测方式")
	private String rqbj_rqjcfs;
	@FieldDesc("是否与公安机关联网")
	private String rqbj_sfygajglwdm;
	@FieldDesc("联系人姓名")
	private String rqbj_lxrxm;
	@FieldDesc("联系人联系方式")
	private String rqbj_lxrlxfs;
	@FieldDesc("有无出入口")
	private String crkkz_ywcrkdm;
	@FieldDesc("布防范围")
	private String crkkz_bffwdm;
	@FieldDesc("数量")
	private String crkkz_sl;
	@FieldDesc("控制方式")
	private String crkkz_kzfs;
	@FieldDesc("存储时间")
	private String crkkz_cxsj;
	@FieldDesc("联系人 姓名")
	private String crkkz_lxrxm;
	@FieldDesc("联系人联系方式")
	private String crkkz_lxrlxfs;
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
	@FieldDesc("录入标识   0：系统新增   1：从其他系统抽取     默认：0")
	private String xt_lrbz;
	@FieldDesc("核实时间")
	private String xt_hssj;
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
	public String getSpjk_ywjkdm() {
		return spjk_ywjkdm;
	}
	public void setSpjk_ywjkdm(String spjk_ywjkdm) {
		this.spjk_ywjkdm = spjk_ywjkdm;
	}
	public String getSpjk_jkfwdm() {
		return spjk_jkfwdm;
	}
	public void setSpjk_jkfwdm(String spjk_jkfwdm) {
		this.spjk_jkfwdm = spjk_jkfwdm;
	}
	public String getSpjk_dwsl() {
		return spjk_dwsl;
	}
	public void setSpjk_dwsl(String spjk_dwsl) {
		this.spjk_dwsl = spjk_dwsl;
	}
	public String getSpjk_sxtfldm() {
		return spjk_sxtfldm;
	}
	public void setSpjk_sxtfldm(String spjk_sxtfldm) {
		this.spjk_sxtfldm = spjk_sxtfldm;
	}
	public String getSpjk_cxsj() {
		return spjk_cxsj;
	}
	public void setSpjk_cxsj(String spjk_cxsj) {
		this.spjk_cxsj = spjk_cxsj;
	}
	public String getSpjk_ywjksdm() {
		return spjk_ywjksdm;
	}
	public void setSpjk_ywjksdm(String spjk_ywjksdm) {
		this.spjk_ywjksdm = spjk_ywjksdm;
	}
	public String getSpjk_lxrxm() {
		return spjk_lxrxm;
	}
	public void setSpjk_lxrxm(String spjk_lxrxm) {
		this.spjk_lxrxm = spjk_lxrxm;
	}
	public String getSpjk_lxrlxfs() {
		return spjk_lxrlxfs;
	}
	public void setSpjk_lxrlxfs(String spjk_lxrlxfs) {
		this.spjk_lxrlxfs = spjk_lxrlxfs;
	}
	public String getRqbj_ywrqbjdm() {
		return rqbj_ywrqbjdm;
	}
	public void setRqbj_ywrqbjdm(String rqbj_ywrqbjdm) {
		this.rqbj_ywrqbjdm = rqbj_ywrqbjdm;
	}
	public String getRqbj_bffwdm() {
		return rqbj_bffwdm;
	}
	public void setRqbj_bffwdm(String rqbj_bffwdm) {
		this.rqbj_bffwdm = rqbj_bffwdm;
	}
	public String getRqbj_sl() {
		return rqbj_sl;
	}
	public void setRqbj_sl(String rqbj_sl) {
		this.rqbj_sl = rqbj_sl;
	}
	public String getRqbj_rqjcfs() {
		return rqbj_rqjcfs;
	}
	public void setRqbj_rqjcfs(String rqbj_rqjcfs) {
		this.rqbj_rqjcfs = rqbj_rqjcfs;
	}
	public String getRqbj_sfygajglwdm() {
		return rqbj_sfygajglwdm;
	}
	public void setRqbj_sfygajglwdm(String rqbj_sfygajglwdm) {
		this.rqbj_sfygajglwdm = rqbj_sfygajglwdm;
	}
	public String getRqbj_lxrxm() {
		return rqbj_lxrxm;
	}
	public void setRqbj_lxrxm(String rqbj_lxrxm) {
		this.rqbj_lxrxm = rqbj_lxrxm;
	}
	public String getRqbj_lxrlxfs() {
		return rqbj_lxrlxfs;
	}
	public void setRqbj_lxrlxfs(String rqbj_lxrlxfs) {
		this.rqbj_lxrlxfs = rqbj_lxrlxfs;
	}
	public String getCrkkz_ywcrkdm() {
		return crkkz_ywcrkdm;
	}
	public void setCrkkz_ywcrkdm(String crkkz_ywcrkdm) {
		this.crkkz_ywcrkdm = crkkz_ywcrkdm;
	}
	public String getCrkkz_bffwdm() {
		return crkkz_bffwdm;
	}
	public void setCrkkz_bffwdm(String crkkz_bffwdm) {
		this.crkkz_bffwdm = crkkz_bffwdm;
	}
	public String getCrkkz_sl() {
		return crkkz_sl;
	}
	public void setCrkkz_sl(String crkkz_sl) {
		this.crkkz_sl = crkkz_sl;
	}
	public String getCrkkz_kzfs() {
		return crkkz_kzfs;
	}
	public void setCrkkz_kzfs(String crkkz_kzfs) {
		this.crkkz_kzfs = crkkz_kzfs;
	}
	public String getCrkkz_cxsj() {
		return crkkz_cxsj;
	}
	public void setCrkkz_cxsj(String crkkz_cxsj) {
		this.crkkz_cxsj = crkkz_cxsj;
	}
	public String getCrkkz_lxrxm() {
		return crkkz_lxrxm;
	}
	public void setCrkkz_lxrxm(String crkkz_lxrxm) {
		this.crkkz_lxrxm = crkkz_lxrxm;
	}
	public String getCrkkz_lxrlxfs() {
		return crkkz_lxrlxfs;
	}
	public void setCrkkz_lxrlxfs(String crkkz_lxrlxfs) {
		this.crkkz_lxrlxfs = crkkz_lxrlxfs;
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
	public String getXt_lrbz() {
		return xt_lrbz;
	}
	public void setXt_lrbz(String xt_lrbz) {
		this.xt_lrbz = xt_lrbz;
	}
	public String getXt_hssj() {
		return xt_hssj;
	}
	public void setXt_hssj(String xt_hssj) {
		this.xt_hssj = xt_hssj;
	}
}
