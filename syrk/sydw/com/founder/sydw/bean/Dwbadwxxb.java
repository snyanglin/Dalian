/**********************************************************************   
 * <p>文件名：Dwbadwxxb.java </p>
 * <p>文件描述：保安单位 
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
@DBInfoAnnotation(tableName = "DW_BADWXXB", pk = "id")
public class Dwbadwxxb extends BaseEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@FieldDesc("ID")
	private String id;
	@FieldDesc("单位ID")private String dwid;
	@FieldDesc("保安主管部门名称")
	private String bazgbmmc;
	@FieldDesc("保安负责人姓名")
	private String bafzrxm;
	@FieldDesc("保安负责人公民身份号码")
	private String bafzrsfzh;
	@FieldDesc("保安负责人职务")
	private String bafzrzw;
	@FieldDesc("保安负责人联系电话")
	private String bafzrlxdm;
	@FieldDesc("服务区域名称")
	private String fwqymc;
	@FieldDesc("服务区域省市县（区）")
	private String fwqyssx;
	@FieldDesc("服务区域详址")
	private String fwqyxz;
	@FieldDesc("服务区域负责人姓名")
	private String fwqyfzrxm;
	@FieldDesc("服务区域负责人公民身份号码")
	private String fwqyfzrsfzh;
	@FieldDesc("服务区域负责人职务")
	private String fwqyfzrzw;
	@FieldDesc("服务区域负责人联系电话")
	private String fwqyfzrlxdm;
	@FieldDesc("保安服务类型")
	private String bafwlxdm;
	@FieldDesc("受理备案公安机关")
	private String slbagajg;
	@FieldDesc("受理备案公安机关ID")
	private String slbagajgid;
	@FieldDesc("备案日期")
	private String barq;
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
	public String getBazgbmmc() {
		return bazgbmmc;
	}
	public void setBazgbmmc(String bazgbmmc) {
		this.bazgbmmc = bazgbmmc;
	}
	public String getBafzrxm() {
		return bafzrxm;
	}
	public void setBafzrxm(String bafzrxm) {
		this.bafzrxm = bafzrxm;
	}
	public String getBafzrsfzh() {
		return bafzrsfzh;
	}
	public void setBafzrsfzh(String bafzrsfzh) {
		this.bafzrsfzh = bafzrsfzh;
	}
	public String getBafzrzw() {
		return bafzrzw;
	}
	public void setBafzrzw(String bafzrzw) {
		this.bafzrzw = bafzrzw;
	}
	public String getBafzrlxdm() {
		return bafzrlxdm;
	}
	public void setBafzrlxdm(String bafzrlxdm) {
		this.bafzrlxdm = bafzrlxdm;
	}
	public String getFwqymc() {
		return fwqymc;
	}
	public void setFwqymc(String fwqymc) {
		this.fwqymc = fwqymc;
	}
	public String getFwqyssx() {
		return fwqyssx;
	}
	public void setFwqyssx(String fwqyssx) {
		this.fwqyssx = fwqyssx;
	}
	public String getFwqyxz() {
		return fwqyxz;
	}
	public void setFwqyxz(String fwqyxz) {
		this.fwqyxz = fwqyxz;
	}
	public String getFwqyfzrxm() {
		return fwqyfzrxm;
	}
	public void setFwqyfzrxm(String fwqyfzrxm) {
		this.fwqyfzrxm = fwqyfzrxm;
	}
	public String getFwqyfzrsfzh() {
		return fwqyfzrsfzh;
	}
	public void setFwqyfzrsfzh(String fwqyfzrsfzh) {
		this.fwqyfzrsfzh = fwqyfzrsfzh;
	}
	public String getFwqyfzrzw() {
		return fwqyfzrzw;
	}
	public void setFwqyfzrzw(String fwqyfzrzw) {
		this.fwqyfzrzw = fwqyfzrzw;
	}
	public String getFwqyfzrlxdm() {
		return fwqyfzrlxdm;
	}
	public void setFwqyfzrlxdm(String fwqyfzrlxdm) {
		this.fwqyfzrlxdm = fwqyfzrlxdm;
	}
	public String getBafwlxdm() {
		return bafwlxdm;
	}
	public void setBafwlxdm(String bafwlxdm) {
		this.bafwlxdm = bafwlxdm;
	}
	public String getSlbagajg() {
		return slbagajg;
	}
	public void setSlbagajg(String slbagajg) {
		this.slbagajg = slbagajg;
	}
	public String getBarq() {
		return barq;
	}
	public void setBarq(String barq) {
		this.barq = barq;
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
	public String getSlbagajgid() {
		return slbagajgid;
	}
	public void setSlbagajgid(String slbagajgid) {
		this.slbagajgid = slbagajgid;
	}
}
