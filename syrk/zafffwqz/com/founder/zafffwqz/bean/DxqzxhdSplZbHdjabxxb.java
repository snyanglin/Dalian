/**********************************************************************   
 * <p>文件名：DxqzxhdSplZbHdjabxxb.java </p>
 * <p>文件描述：TODO(描述该文件做什么) 
 * @project_name：syrk
 * @author wu.w@founder.com.cn 
 * @date 2015-5-15 下午2:36:47 
 * @history
 * @department：研发部
 *
*/
package com.founder.zafffwqz.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

/******************************************************************************
 * @Package:      [com.founder.zafffwqz.bean.DxqzxhdSplZbHdjabxxb.java]  
 * @ClassName:    [DxqzxhdSplZbHdjabxxb]   
 * @Description:  [大型群众性活动审批类-子表-活动及安保信息表]   
 * @Author:       [wu.w@founder.com.cn]  
 * @CreateDate:   [2015-5-15 下午2:36:47]   
 * @UpdateUser:   [way(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-5-15 下午2:36:47，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 * @review      : tian_chengwei@founder.com.cn
 * @reviewDate  : 20150604
 */
@DBInfoAnnotation(tableName = "DXQZXHDSPL_ZB_HDJABXXB", pk = "hdid")
public class DxqzxhdSplZbHdjabxxb extends BaseEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	@FieldDesc("活动ID")
	private String hdid;
	@FieldDesc("安全检查")
	private Long aqjc;
	@FieldDesc("督促整改安全隐患")
	private Long dczgaqyh;
	@FieldDesc("是否取缔代码")
	private String sfqddm;
	@FieldDesc("警告")
	private Long jg;
	@FieldDesc("罚款")
	private Long fk;
	@FieldDesc("是否拘留代码")
	private String sfjldm;
	@FieldDesc("拘留_单处")
	private Long jldc;
	@FieldDesc("拘留_并处罚款")
	private Long jlbcfk;
	@FieldDesc("拘留_责令禁进入")
	private Long jlzljjr;
	@FieldDesc("起数")
	private Long qs;
	@FieldDesc("伤亡人数")
	private Long swrs;
	@FieldDesc("经济损失")
	private Long jjss;
	@FieldDesc("备注")
	private String bz;
	public String getHdid() {
		return hdid;
	}
	public void setHdid(String hdid) {
		this.hdid = hdid;
	}
	public Long getAqjc() {
		return aqjc;
	}
	public void setAqjc(Long aqjc) {
		this.aqjc = aqjc;
	}
	public Long getDczgaqyh() {
		return dczgaqyh;
	}
	public void setDczgaqyh(Long dczgaqyh) {
		this.dczgaqyh = dczgaqyh;
	}
	public String getSfqddm() {
		return sfqddm;
	}
	public void setSfqddm(String sfqddm) {
		this.sfqddm = sfqddm;
	}
	public Long getJg() {
		return jg;
	}
	public void setJg(Long jg) {
		this.jg = jg;
	}
	public Long getFk() {
		return fk;
	}
	public void setFk(Long fk) {
		this.fk = fk;
	}
	
	public String getSfjldm() {
		return sfjldm;
	}
	public void setSfjldm(String sfjldm) {
		this.sfjldm = sfjldm;
	}
	public Long getJldc() {
		return jldc;
	}
	public void setJldc(Long jldc) {
		this.jldc = jldc;
	}
	public Long getJlbcfk() {
		return jlbcfk;
	}
	public void setJlbcfk(Long jlbcfk) {
		this.jlbcfk = jlbcfk;
	}
	public Long getJlzljjr() {
		return jlzljjr;
	}
	public void setJlzljjr(Long jlzljjr) {
		this.jlzljjr = jlzljjr;
	}
	public Long getQs() {
		return qs;
	}
	public void setQs(Long qs) {
		this.qs = qs;
	}
	public Long getSwrs() {
		return swrs;
	}
	public void setSwrs(Long swrs) {
		this.swrs = swrs;
	}
	public Long getJjss() {
		return jjss;
	}
	public void setJjss(Long jjss) {
		this.jjss = jjss;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
}
