/**********************************************************************   
 * <p>文件名：RuleYwxtgzrwlsjlb.java </p>
 * <p>文件描述：TODO(描述该文件做什么) 
 * @project_name：syrk
 * @author wu_chunhui@founder.com.cn 
 * @date 2014-11-3 下午9:33:38 
 * @history
 * @department：研发部
 *
*/
package com.founder.dbrw.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

/******************************************************************************
 * @Package:      [com.founder.dbrw.bean.RuleYwxtgzrwlsjlb.java]  
 * @ClassName:    [RuleYwxtgzrwlsjlb]   
 * @Description:  [业务协同规则任务历史记录表]   
 * @Author:       [wu_chunhui@founder.com.cn]  
 * @CreateDate:   [2014-11-3 下午9:33:38]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2014-11-3 下午9:33:38，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 */
@DBInfoAnnotation(tableName = "RULE_YWXTGZRWB", pk = "id")
public class RuleYwxtgzrwlsjlb extends BaseEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@FieldDesc("业务协同执行记录ID")private String id;
	@FieldDesc("业务协同任务ID")private String ywxtrwid;
	@FieldDesc("业务ID")private String ywid;
	@FieldDesc("业务名称")private String ywmc;
	@FieldDesc("业务协同规则任务名称")private String ywxtgzrwmc;
	@FieldDesc("协同规则ID")private String xtgzid;
	@FieldDesc("协同规则名称")private String xtgzmc;
	@FieldDesc("协同规则执行方法")private String xtgzzxff;
	@FieldDesc("业务信息查看URL")private String ywxxckurl;
	@FieldDesc("业务协同任务描述")private String ywxtrwms;
	@FieldDesc("发起时间")private String fqsj;
	@FieldDesc("发起人部门ID")private String fqrbmid;
	@FieldDesc("发起人部门")private String fqrbm;
	@FieldDesc("发起人ID")private String fqrid;
	@FieldDesc("发起人")private String fqr;
	@FieldDesc("任务处理时间")private String rwclsj;
	@FieldDesc("任务处理人部门ID")private String rwclrbmid;
	@FieldDesc("任务处理人部门")private String rwclrbm;
	@FieldDesc("任务处理人ID")private String rwclrid;
	@FieldDesc("任务处理人")private String rwclr;
	@FieldDesc("任务处理结果代码")private String rwcljgdm;
	@FieldDesc("任务处理说明")private String rwclsm;
	@FieldDesc("任务处理执行方法")private String rwclzxff;
	@FieldDesc("裁决时间")private String cjsj;
	@FieldDesc("裁决人部门ID")private String cjrbmid;
	@FieldDesc("裁决人部门")private String cjrbm;
	@FieldDesc("裁决人ID")private String cjrid;
	@FieldDesc("裁决人")private String cjr;
	@FieldDesc("裁决结果代码")private String cjjgdm;
	@FieldDesc("裁决执行方法")private String cjzxff;
	@FieldDesc("协同任务状态代码")private String ywrwztdm;
	@FieldDesc("执行状态")private String zxzt;
	@FieldDesc("备注")private String bz;
	@FieldDesc("采集时间")private String xt_cjsj;
	@FieldDesc("录入时间")private String xt_lrsj;
	@FieldDesc("录入人姓名")private String xt_lrrxm;
	@FieldDesc("录入人ID")private String xt_lrrid;
	@FieldDesc("录入人部门")private String xt_lrrbm;
	@FieldDesc("录入人部门ID")private String xt_lrrbmid;
	@FieldDesc("录入IP")private String xt_lrip;
	@FieldDesc("最后修改时间")private String xt_zhxgsj;
	@FieldDesc("最后修改人姓名")private String xt_zhxgrxm;
	@FieldDesc("最后修改人ID")private String xt_zhxgrid;
	@FieldDesc("最后修改人部门")private String xt_zhxgrbm;
	@FieldDesc("最后修改人部门ID")private String xt_zhxgrbmid;
	@FieldDesc("最后修改IP")private String xt_zhxgip;
	@FieldDesc("注销标志")private String xt_zxbz;
	@FieldDesc("注销原因")private String xt_zxyy;
	
	private String jssj;
	
	public String getJssj() {
		return jssj;
	}
	public void setJssj(String jssj) {
		this.jssj = jssj;
	}
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the ywxtrwid
	 */
	public String getYwxtrwid() {
		return ywxtrwid;
	}
	/**
	 * @param ywxtrwid the ywxtrwid to set
	 */
	public void setYwxtrwid(String ywxtrwid) {
		this.ywxtrwid = ywxtrwid;
	}
	/**
	 * @return the ywid
	 */
	public String getYwid() {
		return ywid;
	}
	/**
	 * @param ywid the ywid to set
	 */
	public void setYwid(String ywid) {
		this.ywid = ywid;
	}
	/**
	 * @return the ywmc
	 */
	public String getYwmc() {
		return ywmc;
	}
	/**
	 * @param ywmc the ywmc to set
	 */
	public void setYwmc(String ywmc) {
		this.ywmc = ywmc;
	}
	/**
	 * @return the ywxtgzrwmc
	 */
	public String getYwxtgzrwmc() {
		return ywxtgzrwmc;
	}
	/**
	 * @param ywxtgzrwmc the ywxtgzrwmc to set
	 */
	public void setYwxtgzrwmc(String ywxtgzrwmc) {
		this.ywxtgzrwmc = ywxtgzrwmc;
	}
	/**
	 * @return the xtgzid
	 */
	public String getXtgzid() {
		return xtgzid;
	}
	/**
	 * @param xtgzid the xtgzid to set
	 */
	public void setXtgzid(String xtgzid) {
		this.xtgzid = xtgzid;
	}
	/**
	 * @return the xtgzmc
	 */
	public String getXtgzmc() {
		return xtgzmc;
	}
	/**
	 * @param xtgzmc the xtgzmc to set
	 */
	public void setXtgzmc(String xtgzmc) {
		this.xtgzmc = xtgzmc;
	}
	/**
	 * @return the xtgzzxff
	 */
	public String getXtgzzxff() {
		return xtgzzxff;
	}
	/**
	 * @param xtgzzxff the xtgzzxff to set
	 */
	public void setXtgzzxff(String xtgzzxff) {
		this.xtgzzxff = xtgzzxff;
	}
	/**
	 * @return the ywxxckurl
	 */
	public String getYwxxckurl() {
		return ywxxckurl;
	}
	/**
	 * @param ywxxckurl the ywxxckurl to set
	 */
	public void setYwxxckurl(String ywxxckurl) {
		this.ywxxckurl = ywxxckurl;
	}
	/**
	 * @return the ywxtrwms
	 */
	public String getYwxtrwms() {
		return ywxtrwms;
	}
	/**
	 * @param ywxtrwms the ywxtrwms to set
	 */
	public void setYwxtrwms(String ywxtrwms) {
		this.ywxtrwms = ywxtrwms;
	}
	/**
	 * @return the fqsj
	 */
	public String getFqsj() {
		return fqsj;
	}
	/**
	 * @param fqsj the fqsj to set
	 */
	public void setFqsj(String fqsj) {
		this.fqsj = fqsj;
	}
	/**
	 * @return the fqrbmid
	 */
	public String getFqrbmid() {
		return fqrbmid;
	}
	/**
	 * @param fqrbmid the fqrbmid to set
	 */
	public void setFqrbmid(String fqrbmid) {
		this.fqrbmid = fqrbmid;
	}
	/**
	 * @return the fqrbm
	 */
	public String getFqrbm() {
		return fqrbm;
	}
	/**
	 * @param fqrbm the fqrbm to set
	 */
	public void setFqrbm(String fqrbm) {
		this.fqrbm = fqrbm;
	}
	/**
	 * @return the fqrid
	 */
	public String getFqrid() {
		return fqrid;
	}
	/**
	 * @param fqrid the fqrid to set
	 */
	public void setFqrid(String fqrid) {
		this.fqrid = fqrid;
	}
	/**
	 * @return the fqr
	 */
	public String getFqr() {
		return fqr;
	}
	/**
	 * @param fqr the fqr to set
	 */
	public void setFqr(String fqr) {
		this.fqr = fqr;
	}
	/**
	 * @return the rwclsj
	 */
	public String getRwclsj() {
		return rwclsj;
	}
	/**
	 * @param rwclsj the rwclsj to set
	 */
	public void setRwclsj(String rwclsj) {
		this.rwclsj = rwclsj;
	}
	/**
	 * @return the rwclrbmid
	 */
	public String getRwclrbmid() {
		return rwclrbmid;
	}
	/**
	 * @param rwclrbmid the rwclrbmid to set
	 */
	public void setRwclrbmid(String rwclrbmid) {
		this.rwclrbmid = rwclrbmid;
	}
	/**
	 * @return the rwclrbm
	 */
	public String getRwclrbm() {
		return rwclrbm;
	}
	/**
	 * @param rwclrbm the rwclrbm to set
	 */
	public void setRwclrbm(String rwclrbm) {
		this.rwclrbm = rwclrbm;
	}
	/**
	 * @return the rwclrid
	 */
	public String getRwclrid() {
		return rwclrid;
	}
	/**
	 * @param rwclrid the rwclrid to set
	 */
	public void setRwclrid(String rwclrid) {
		this.rwclrid = rwclrid;
	}
	/**
	 * @return the rwclr
	 */
	public String getRwclr() {
		return rwclr;
	}
	/**
	 * @param rwclr the rwclr to set
	 */
	public void setRwclr(String rwclr) {
		this.rwclr = rwclr;
	}
	/**
	 * @return the rwcljgdm
	 */
	public String getRwcljgdm() {
		return rwcljgdm;
	}
	/**
	 * @param rwcljgdm the rwcljgdm to set
	 */
	public void setRwcljgdm(String rwcljgdm) {
		this.rwcljgdm = rwcljgdm;
	}
	/**
	 * @return the rwclsm
	 */
	public String getRwclsm() {
		return rwclsm;
	}
	/**
	 * @param rwclsm the rwclsm to set
	 */
	public void setRwclsm(String rwclsm) {
		this.rwclsm = rwclsm;
	}
	/**
	 * @return the rwclzxff
	 */
	public String getRwclzxff() {
		return rwclzxff;
	}
	/**
	 * @param rwclzxff the rwclzxff to set
	 */
	public void setRwclzxff(String rwclzxff) {
		this.rwclzxff = rwclzxff;
	}
	/**
	 * @return the cjsj
	 */
	public String getCjsj() {
		return cjsj;
	}
	/**
	 * @param cjsj the cjsj to set
	 */
	public void setCjsj(String cjsj) {
		this.cjsj = cjsj;
	}
	/**
	 * @return the cjrbmid
	 */
	public String getCjrbmid() {
		return cjrbmid;
	}
	/**
	 * @param cjrbmid the cjrbmid to set
	 */
	public void setCjrbmid(String cjrbmid) {
		this.cjrbmid = cjrbmid;
	}
	/**
	 * @return the cjrbm
	 */
	public String getCjrbm() {
		return cjrbm;
	}
	/**
	 * @param cjrbm the cjrbm to set
	 */
	public void setCjrbm(String cjrbm) {
		this.cjrbm = cjrbm;
	}
	/**
	 * @return the cjrid
	 */
	public String getCjrid() {
		return cjrid;
	}
	/**
	 * @param cjrid the cjrid to set
	 */
	public void setCjrid(String cjrid) {
		this.cjrid = cjrid;
	}
	/**
	 * @return the cjr
	 */
	public String getCjr() {
		return cjr;
	}
	/**
	 * @param cjr the cjr to set
	 */
	public void setCjr(String cjr) {
		this.cjr = cjr;
	}
	/**
	 * @return the cjjgdm
	 */
	public String getCjjgdm() {
		return cjjgdm;
	}
	/**
	 * @param cjjgdm the cjjgdm to set
	 */
	public void setCjjgdm(String cjjgdm) {
		this.cjjgdm = cjjgdm;
	}
	/**
	 * @return the cjzxff
	 */
	public String getCjzxff() {
		return cjzxff;
	}
	/**
	 * @param cjzxff the cjzxff to set
	 */
	public void setCjzxff(String cjzxff) {
		this.cjzxff = cjzxff;
	}
	/**
	 * @return the ywrwztdm
	 */
	public String getYwrwztdm() {
		return ywrwztdm;
	}
	/**
	 * @param ywrwztdm the ywrwztdm to set
	 */
	public void setYwrwztdm(String ywrwztdm) {
		this.ywrwztdm = ywrwztdm;
	}
	/**
	 * @return the zxzt
	 */
	public String getZxzt() {
		return zxzt;
	}
	/**
	 * @param zxzt the zxzt to set
	 */
	public void setZxzt(String zxzt) {
		this.zxzt = zxzt;
	}
	/**
	 * @return the bz
	 */
	public String getBz() {
		return bz;
	}
	/**
	 * @param bz the bz to set
	 */
	public void setBz(String bz) {
		this.bz = bz;
	}
	/**
	 * @return the xt_cjsj
	 */
	public String getXt_cjsj() {
		return xt_cjsj;
	}
	/**
	 * @param xt_cjsj the xt_cjsj to set
	 */
	public void setXt_cjsj(String xt_cjsj) {
		this.xt_cjsj = xt_cjsj;
	}
	/**
	 * @return the xt_lrsj
	 */
	public String getXt_lrsj() {
		return xt_lrsj;
	}
	/**
	 * @param xt_lrsj the xt_lrsj to set
	 */
	public void setXt_lrsj(String xt_lrsj) {
		this.xt_lrsj = xt_lrsj;
	}
	/**
	 * @return the xt_lrrxm
	 */
	public String getXt_lrrxm() {
		return xt_lrrxm;
	}
	/**
	 * @param xt_lrrxm the xt_lrrxm to set
	 */
	public void setXt_lrrxm(String xt_lrrxm) {
		this.xt_lrrxm = xt_lrrxm;
	}
	/**
	 * @return the xt_lrrid
	 */
	public String getXt_lrrid() {
		return xt_lrrid;
	}
	/**
	 * @param xt_lrrid the xt_lrrid to set
	 */
	public void setXt_lrrid(String xt_lrrid) {
		this.xt_lrrid = xt_lrrid;
	}
	/**
	 * @return the xt_lrrbm
	 */
	public String getXt_lrrbm() {
		return xt_lrrbm;
	}
	/**
	 * @param xt_lrrbm the xt_lrrbm to set
	 */
	public void setXt_lrrbm(String xt_lrrbm) {
		this.xt_lrrbm = xt_lrrbm;
	}
	/**
	 * @return the xt_lrrbmid
	 */
	public String getXt_lrrbmid() {
		return xt_lrrbmid;
	}
	/**
	 * @param xt_lrrbmid the xt_lrrbmid to set
	 */
	public void setXt_lrrbmid(String xt_lrrbmid) {
		this.xt_lrrbmid = xt_lrrbmid;
	}
	/**
	 * @return the xt_lrip
	 */
	public String getXt_lrip() {
		return xt_lrip;
	}
	/**
	 * @param xt_lrip the xt_lrip to set
	 */
	public void setXt_lrip(String xt_lrip) {
		this.xt_lrip = xt_lrip;
	}
	/**
	 * @return the xt_zhxgsj
	 */
	public String getXt_zhxgsj() {
		return xt_zhxgsj;
	}
	/**
	 * @param xt_zhxgsj the xt_zhxgsj to set
	 */
	public void setXt_zhxgsj(String xt_zhxgsj) {
		this.xt_zhxgsj = xt_zhxgsj;
	}
	/**
	 * @return the xt_zhxgrxm
	 */
	public String getXt_zhxgrxm() {
		return xt_zhxgrxm;
	}
	/**
	 * @param xt_zhxgrxm the xt_zhxgrxm to set
	 */
	public void setXt_zhxgrxm(String xt_zhxgrxm) {
		this.xt_zhxgrxm = xt_zhxgrxm;
	}
	/**
	 * @return the xt_zhxgrid
	 */
	public String getXt_zhxgrid() {
		return xt_zhxgrid;
	}
	/**
	 * @param xt_zhxgrid the xt_zhxgrid to set
	 */
	public void setXt_zhxgrid(String xt_zhxgrid) {
		this.xt_zhxgrid = xt_zhxgrid;
	}
	/**
	 * @return the xt_zhxgrbm
	 */
	public String getXt_zhxgrbm() {
		return xt_zhxgrbm;
	}
	/**
	 * @param xt_zhxgrbm the xt_zhxgrbm to set
	 */
	public void setXt_zhxgrbm(String xt_zhxgrbm) {
		this.xt_zhxgrbm = xt_zhxgrbm;
	}
	/**
	 * @return the xt_zhxgrbmid
	 */
	public String getXt_zhxgrbmid() {
		return xt_zhxgrbmid;
	}
	/**
	 * @param xt_zhxgrbmid the xt_zhxgrbmid to set
	 */
	public void setXt_zhxgrbmid(String xt_zhxgrbmid) {
		this.xt_zhxgrbmid = xt_zhxgrbmid;
	}
	/**
	 * @return the xt_zhxgip
	 */
	public String getXt_zhxgip() {
		return xt_zhxgip;
	}
	/**
	 * @param xt_zhxgip the xt_zhxgip to set
	 */
	public void setXt_zhxgip(String xt_zhxgip) {
		this.xt_zhxgip = xt_zhxgip;
	}
	/**
	 * @return the xt_zxbz
	 */
	public String getXt_zxbz() {
		return xt_zxbz;
	}
	/**
	 * @param xt_zxbz the xt_zxbz to set
	 */
	public void setXt_zxbz(String xt_zxbz) {
		this.xt_zxbz = xt_zxbz;
	}
	/**
	 * @return the xt_zxyy
	 */
	public String getXt_zxyy() {
		return xt_zxyy;
	}
	/**
	 * @param xt_zxyy the xt_zxyy to set
	 */
	public void setXt_zxyy(String xt_zxyy) {
		this.xt_zxyy = xt_zxyy;
	}
	
	

}
