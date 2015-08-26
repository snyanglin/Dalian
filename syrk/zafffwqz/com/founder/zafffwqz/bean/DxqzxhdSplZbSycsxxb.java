/**********************************************************************   
 * <p>文件名：DxqzxhdSplZbSycsxxb.java </p>
 * <p>文件描述：TODO(描述该文件做什么) 
 * @project_name：syrk
 * @author wu.w@founder.com.cn 
 * @date 2015-5-15 下午2:27:19 
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
 * @Package:      [com.founder.zafffwqz.bean.DxqzxhdSplZbSycsxxb.java]  
 * @ClassName:    [DxqzxhdSplZbSycsxxb]   
 * @Description:  [大型群众性活动审批类-子表-使用场所信息表]   
 * @Author:       [wu.w@founder.com.cn]  
 * @CreateDate:   [2015-5-15 下午2:27:19]   
 * @UpdateUser:   [way(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-5-15 下午2:27:19，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 * @review      : tian_chengwei@founder.com.cn
 * @reviewDate  : 20150604
 */
@DBInfoAnnotation(tableName = "DXQZXHDSPL_ZB_SYCSXXB", pk = "hdid")
public class DxqzxhdSplZbSycsxxb extends BaseEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	@FieldDesc("活动ID")
	private String hdid;
	@FieldDesc("场所承租单位")
	private String csczdw;
	@FieldDesc("场所主要负责人")
	private String cszyfzr;
	@FieldDesc("场所主要负责人职务")
	private String cszyfzrzw;
	@FieldDesc("场所主要负责人证件种类代码")
	private String cszyfzrzjzldm;
	@FieldDesc("场所主要负责人证件号码")
	private String cszyfzrzjhm;
	@FieldDesc("场所主要负责人联系电话")
	private String cszyfzrlxdh;
	@FieldDesc("场所联系人")
	private String cslxr;
	@FieldDesc("场所联系人职务")
	private String cslxrzw;
	@FieldDesc("场所联系人证件种类代码")
	private String cslxrzjzldm;
	@FieldDesc("场所联系人证件号码")
	private String cslxrzjhm;
	@FieldDesc("场所联系人联系电话")
	private String cslxrlxdh;
	@FieldDesc("备注")
	private String bz;
	public String getHdid() {
		return hdid;
	}
	public void setHdid(String hdid) {
		this.hdid = hdid;
	}
	public String getCsczdw() {
		return csczdw;
	}
	public void setCsczdw(String csczdw) {
		this.csczdw = csczdw;
	}
	public String getCszyfzr() {
		return cszyfzr;
	}
	public void setCszyfzr(String cszyfzr) {
		this.cszyfzr = cszyfzr;
	}
	public String getCszyfzrzw() {
		return cszyfzrzw;
	}
	public void setCszyfzrzw(String cszyfzrzw) {
		this.cszyfzrzw = cszyfzrzw;
	}
	public String getCszyfzrzjzldm() {
		return cszyfzrzjzldm;
	}
	public void setCszyfzrzjzldm(String cszyfzrzjzldm) {
		this.cszyfzrzjzldm = cszyfzrzjzldm;
	}
	public String getCszyfzrzjhm() {
		return cszyfzrzjhm;
	}
	public void setCszyfzrzjhm(String cszyfzrzjhm) {
		this.cszyfzrzjhm = cszyfzrzjhm;
	}
	public String getCszyfzrlxdh() {
		return cszyfzrlxdh;
	}
	public void setCszyfzrlxdh(String cszyfzrlxdh) {
		this.cszyfzrlxdh = cszyfzrlxdh;
	}
	public String getCslxr() {
		return cslxr;
	}
	public void setCslxr(String cslxr) {
		this.cslxr = cslxr;
	}
	public String getCslxrzw() {
		return cslxrzw;
	}
	public void setCslxrzw(String cslxrzw) {
		this.cslxrzw = cslxrzw;
	}
	public String getCslxrzjzldm() {
		return cslxrzjzldm;
	}
	public void setCslxrzjzldm(String cslxrzjzldm) {
		this.cslxrzjzldm = cslxrzjzldm;
	}
	public String getCslxrzjhm() {
		return cslxrzjhm;
	}
	public void setCslxrzjhm(String cslxrzjhm) {
		this.cslxrzjhm = cslxrzjhm;
	}
	public String getCslxrlxdh() {
		return cslxrlxdh;
	}
	public void setCslxrlxdh(String cslxrlxdh) {
		this.cslxrlxdh = cslxrlxdh;
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
