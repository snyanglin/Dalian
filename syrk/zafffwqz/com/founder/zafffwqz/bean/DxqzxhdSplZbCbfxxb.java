/**********************************************************************   
 * <p>文件名：DxqzxhdSplZbCbfxxb.java </p>
 * <p>文件描述：TODO(描述该文件做什么) 
 * @project_name：syrk
 * @author wu.w@founder.com.cn 
 * @date 2015-5-15 下午2:24:14 
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
 * @Package:      [com.founder.zafffwqz.bean.DxqzxhdSplZbCbfxxb.java]  
 * @ClassName:    [DxqzxhdSplZbCbfxxb]   
 * @Description:  [大型群众性活动审批类-子表-承办方信息表]   
 * @Author:       [wu.w@founder.com.cn]  
 * @CreateDate:   [2015-5-15 下午2:24:14]   
 * @UpdateUser:   [way(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-5-15 下午2:24:14，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 * @review      : tian_chengwei@founder.com.cn
 * @reviewDate  : 20150604
 */
@DBInfoAnnotation(tableName = "DXQZXHDSPL_ZB_CBFXXB", pk = "hdid")
public class DxqzxhdSplZbCbfxxb extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	@FieldDesc("活动ID")
	private String hdid;
	@FieldDesc("活动承办者代码")
	private String hdcbzdm;
	@FieldDesc("承办部门名称")
	private String cbbmmc;
	@FieldDesc("法人_姓名")
	private String frxm;
	@FieldDesc("法人_证件种类代码")
	private String frzjzldm;
	@FieldDesc("法人_证件号")
	private String frzjhm;
	@FieldDesc("活动负责人")
	private String hdfzr;
	@FieldDesc("活动负责人职务")
	private String hdfzrzw;
	@FieldDesc("活动负责人证件种类代码")
	private String hdfzrzjzldm;
	@FieldDesc("活动负责人证件号码")
	private String hdfzrzjhm;
	@FieldDesc("活动负责人联系电话")
	private String hdfzrlxdh;
	@FieldDesc("活动联系人")
	private String hdlxr;
	@FieldDesc("活动联系人职务")
	private String hdlxrzw;
	@FieldDesc("活动联系人证件种类代码")
	private String hdlxrzjzldm;
	@FieldDesc("活动联系人证件号码")
	private String hdlxrzjhm;
	@FieldDesc("活动联系人联系电话")
	private String hdlxrlxdh;
	@FieldDesc("活动安全负责人")
	private String hdaqfzr;
	@FieldDesc("活动安全负责人职务")
	private String hdaqfzrzw;
	@FieldDesc("活动安全负责人证件种类代码")
	private String hdaqfzrzjzldm;
	@FieldDesc("活动安全负责人证件号码")
	private String hdaqfzrzjhm;
	@FieldDesc("活动安全负责人联系电话")
	private String hdaqfzrlxdh;
	@FieldDesc("备注")
	private String bz;
	public String getHdid() {
		return hdid;
	}
	public void setHdid(String hdid) {
		this.hdid = hdid;
	}
	public String getHdcbzdm() {
		return hdcbzdm;
	}
	public void setHdcbzdm(String hdcbzdm) {
		this.hdcbzdm = hdcbzdm;
	}
	public String getCbbmmc() {
		return cbbmmc;
	}
	public void setCbbmmc(String cbbmmc) {
		this.cbbmmc = cbbmmc;
	}
	public String getFrxm() {
		return frxm;
	}
	public void setFrxm(String frxm) {
		this.frxm = frxm;
	}
	public String getFrzjzldm() {
		return frzjzldm;
	}
	public void setFrzjzldm(String frzjzldm) {
		this.frzjzldm = frzjzldm;
	}
	public String getFrzjhm() {
		return frzjhm;
	}
	public void setFrzjhm(String frzjhm) {
		this.frzjhm = frzjhm;
	}
	public String getHdfzr() {
		return hdfzr;
	}
	public void setHdfzr(String hdfzr) {
		this.hdfzr = hdfzr;
	}
	public String getHdfzrzw() {
		return hdfzrzw;
	}
	public void setHdfzrzw(String hdfzrzw) {
		this.hdfzrzw = hdfzrzw;
	}
	public String getHdfzrzjzldm() {
		return hdfzrzjzldm;
	}
	public void setHdfzrzjzldm(String hdfzrzjzldm) {
		this.hdfzrzjzldm = hdfzrzjzldm;
	}
	public String getHdfzrzjhm() {
		return hdfzrzjhm;
	}
	public void setHdfzrzjhm(String hdfzrzjhm) {
		this.hdfzrzjhm = hdfzrzjhm;
	}
	public String getHdfzrlxdh() {
		return hdfzrlxdh;
	}
	public void setHdfzrlxdh(String hdfzrlxdh) {
		this.hdfzrlxdh = hdfzrlxdh;
	}
	public String getHdlxr() {
		return hdlxr;
	}
	public void setHdlxr(String hdlxr) {
		this.hdlxr = hdlxr;
	}
	public String getHdlxrzw() {
		return hdlxrzw;
	}
	public void setHdlxrzw(String hdlxrzw) {
		this.hdlxrzw = hdlxrzw;
	}
	public String getHdlxrzjzldm() {
		return hdlxrzjzldm;
	}
	public void setHdlxrzjzldm(String hdlxrzjzldm) {
		this.hdlxrzjzldm = hdlxrzjzldm;
	}
	public String getHdlxrzjhm() {
		return hdlxrzjhm;
	}
	public void setHdlxrzjhm(String hdlxrzjhm) {
		this.hdlxrzjhm = hdlxrzjhm;
	}
	public String getHdlxrlxdh() {
		return hdlxrlxdh;
	}
	public void setHdlxrlxdh(String hdlxrlxdh) {
		this.hdlxrlxdh = hdlxrlxdh;
	}
	public String getHdaqfzr() {
		return hdaqfzr;
	}
	public void setHdaqfzr(String hdaqfzr) {
		this.hdaqfzr = hdaqfzr;
	}
	public String getHdaqfzrzw() {
		return hdaqfzrzw;
	}
	public void setHdaqfzrzw(String hdaqfzrzw) {
		this.hdaqfzrzw = hdaqfzrzw;
	}
	public String getHdaqfzrzjzldm() {
		return hdaqfzrzjzldm;
	}
	public void setHdaqfzrzjzldm(String hdaqfzrzjzldm) {
		this.hdaqfzrzjzldm = hdaqfzrzjzldm;
	}
	public String getHdaqfzrzjhm() {
		return hdaqfzrzjhm;
	}
	public void setHdaqfzrzjhm(String hdaqfzrzjhm) {
		this.hdaqfzrzjhm = hdaqfzrzjhm;
	}
	public String getHdaqfzrlxdh() {
		return hdaqfzrlxdh;
	}
	public void setHdaqfzrlxdh(String hdaqfzrlxdh) {
		this.hdaqfzrlxdh = hdaqfzrlxdh;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
