/**********************************************************************   
 * <p>文件名：Dwbacyqkxxb.java </p>
 * <p>文件描述：TODO(描述该文件做什么) 
 * @project_name：syrk
 * @author liang_lihe@founder.com.cn 
 * @date 2015-7-8 下午4:04:00 
 * @history
 * @department：研发部
 *
*/
package com.founder.sydw.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

/******************************************************************************
 * @Package:      [com.founder.sydw.bean.Dwbacyqkxxb.java]  
 * @ClassName:    [Dwbacyqkxxb]   
 * @Description:  [一句话描述该类的功能]   
 * @Author:       [liang_lihe@founder.com.cn]  
 * @CreateDate:   [2015-7-8 下午4:04:00]   
 * @UpdateUser:   [lk(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-7-8 下午4:04:00，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 */
@DBInfoAnnotation(tableName = "DW_DWBAYCYQK", pk = "id")
public class Dwbacyqkxxb extends BaseEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@FieldDesc("保安员从业信息ID")
	private String id;
	@FieldDesc("单位序号")
	private String dwxh;
	@FieldDesc("保安员编码")
	private String baybm;
	@FieldDesc("是否签订劳动合同")
    private String sfqdldht;
	@FieldDesc("缴纳社保险种")
    private String jnsbxz;
	@FieldDesc("是否重点岗位")
    private String sfzdgw;
	@FieldDesc("是否个人会员")
    private String sfgrhy;
	@FieldDesc("着装情况")
    private String zzqk;
	@FieldDesc("入职日期")
    private String rzrq;
	@FieldDesc("离职日期")
    private String lzrq;
	@FieldDesc("离职原因")
    private String lzyy;
	@FieldDesc("因公伤亡情况")
    private String ygswqk;
	@FieldDesc("保安从业信息编码")
	private String bacyxxbm;
	@FieldDesc("填报人")
    private String tbr;
	@FieldDesc("填报时间")
    private String tbsj;  
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
	@FieldDesc("所属地市公安机关代码")
	private String ssdsgajgdm;
	@FieldDesc("所属地市公安机关代码ID")
	private String ssdsgajgdmid;
	@FieldDesc("单位名称")
	private String dwmc;
	@FieldDesc("保安员证编号")
	private String bayzbh;
	
	
	public String getBayzbh() {
		return bayzbh;
	}
	public void setBayzbh(String bayzbh) {
		this.bayzbh = bayzbh;
	}
	public String getSsdsgajgdmid() {
		return ssdsgajgdmid;
	}
	public void setSsdsgajgdmid(String ssdsgajgdmid) {
		this.ssdsgajgdmid = ssdsgajgdmid;
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
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBacyxxbm() {
		return bacyxxbm;
	}
	public void setBacyxxbm(String bacyxxbm) {
		this.bacyxxbm = bacyxxbm;
	}
	public String getDwxh() {
		return dwxh;
	}
	public void setDwxh(String dwxh) {
		this.dwxh = dwxh;
	}
	public String getBaybm() {
		return baybm;
	}
	public void setBaybm(String baybm) {
		this.baybm = baybm;
	}
	public String getSfqdldht() {
		return sfqdldht;
	}
	public void setSfqdldht(String sfqdldht) {
		this.sfqdldht = sfqdldht;
	}
	public String getJnsbxz() {
		return jnsbxz;
	}
	public void setJnsbxz(String jnsbxz) {
		this.jnsbxz = jnsbxz;
	}
	public String getSfzdgw() {
		return sfzdgw;
	}
	public void setSfzdgw(String sfzdgw) {
		this.sfzdgw = sfzdgw;
	}
	public String getSfgrhy() {
		return sfgrhy;
	}
	public void setSfgrhy(String sfgrhy) {
		this.sfgrhy = sfgrhy;
	}
	public String getZzqk() {
		return zzqk;
	}
	public void setZzqk(String zzqk) {
		this.zzqk = zzqk;
	}
	public String getRzrq() {
		return rzrq;
	}
	public void setRzrq(String rzrq) {
		this.rzrq = rzrq;
	}
	public String getLzrq() {
		return lzrq;
	}
	public void setLzrq(String lzrq) {
		this.lzrq = lzrq;
	}
	public String getLzyy() {
		return lzyy;
	}
	public void setLzyy(String lzyy) {
		this.lzyy = lzyy;
	}
	public String getYgswqk() {
		return ygswqk;
	}
	public void setYgswqk(String ygswqk) {
		this.ygswqk = ygswqk;
	}
	public String getTbr() {
		return tbr;
	}
	public void setTbr(String tbr) {
		this.tbr = tbr;
	}
	public String getTbsj() {
		return tbsj;
	}
	public void setTbsj(String tbsj) {
		this.tbsj = tbsj;
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

	public String getSsdsgajgdm() {
		return ssdsgajgdm;
	}
	public void setSsdsgajgdm(String ssdsgajgdm) {
		this.ssdsgajgdm = ssdsgajgdm;
	}
	public String getDwmc() {
		return dwmc;
	}
	public void setDwmc(String dwmc) {
		this.dwmc = dwmc;
	}
	
	
	
}
