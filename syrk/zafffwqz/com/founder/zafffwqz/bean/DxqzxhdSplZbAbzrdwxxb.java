/**********************************************************************   
 * <p>文件名：DxqzxhdSplZbAbzrdwxxb.java </p>
 * <p>文件描述：TODO(描述该文件做什么) 
 * @project_name：syrk
 * @author wu.w@founder.com.cn 
 * @date 2015-5-15 下午2:33:45 
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
 * @Package:      [com.founder.zafffwqz.bean.DxqzxhdSplZbAbzrdwxxb.java]  
 * @ClassName:    [DxqzxhdSplZbAbzrdwxxb]   
 * @Description:  [大型群众性活动审批类-子表-安保责任单位信息表]   
 * @Author:       [wu.w@founder.com.cn]  
 * @CreateDate:   [2015-5-15 下午2:33:45]   
 * @UpdateUser:   [way(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-5-15 下午2:33:45，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 * @review      : tian_chengwei@founder.com.cn
 * @reviewDate  : 20150604
 */
@DBInfoAnnotation(tableName = "DXQZXHDSPL_ZB_ABZRDWXXB", pk = "hdid")
public class DxqzxhdSplZbAbzrdwxxb extends BaseEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	@FieldDesc("活动ID")
	private String hdid;
	@FieldDesc("安全许可单位")
	private String abxkdw;
	@FieldDesc("安全许可单位负责人")
	private String aqxkdwfzr;
	@FieldDesc("安保负责人")
	private String abfzr;
	@FieldDesc("安保联系人")
	private String ablxr;
	@FieldDesc("安保勤务等级代码")
	private String abqwdjdm;
	@FieldDesc("安全许可意见")
	private String aqxkyj;
	@FieldDesc("每场次安保种类代码")
	private String mccabzldm;
	@FieldDesc("每场次安保警力数")
	private Long mccabjls;
	@FieldDesc("雇佣保安员保安公司名称")
	private String gybaybagsmc;
	@FieldDesc("保安公司主要负责人")
	private String bagszyfzr;
	@FieldDesc("保安公司主要负责人职务")
	private String bagszyfzrzw;
	@FieldDesc("保安公司主要负责人证件种类代码")
	private String bagszyfzrzjzldm;
	@FieldDesc("保安公司主要负责人证件号码")
	private String bagszyfzrzjhm;
	@FieldDesc("保安公司主要负责人联系电话")
	private String bagszyfzrlxdh;
	@FieldDesc("安保方案")
	private String abfa;
	@FieldDesc("备注")
	private String bz;
	@FieldDesc("安保详情")
	private String abxq;
	public String getAbxq() {
		return abxq;
	}
	public void setAbxq(String abxq) {
		this.abxq = abxq;
	}
	public String getHdid() {
		return hdid;
	}
	public void setHdid(String hdid) {
		this.hdid = hdid;
	}
	public String getAbxkdw() {
		return abxkdw;
	}
	public void setAbxkdw(String abxkdw) {
		this.abxkdw = abxkdw;
	}
	public String getAqxkdwfzr() {
		return aqxkdwfzr;
	}
	public void setAqxkdwfzr(String aqxkdwfzr) {
		this.aqxkdwfzr = aqxkdwfzr;
	}
	public String getAbfzr() {
		return abfzr;
	}
	public void setAbfzr(String abfzr) {
		this.abfzr = abfzr;
	}
	public String getAblxr() {
		return ablxr;
	}
	public void setAblxr(String ablxr) {
		this.ablxr = ablxr;
	}
	public String getAbqwdjdm() {
		return abqwdjdm;
	}
	public void setAbqwdjdm(String abqwdjdm) {
		this.abqwdjdm = abqwdjdm;
	}
	public String getAqxkyj() {
		return aqxkyj;
	}
	public void setAqxkyj(String aqxkyj) {
		this.aqxkyj = aqxkyj;
	}
	public String getMccabzldm() {
		return mccabzldm;
	}
	public void setMccabzldm(String mccabzldm) {
		this.mccabzldm = mccabzldm;
	}
	public Long getMccabjls() {
		return mccabjls;
	}
	public void setMccabjls(Long mccabjls) {
		this.mccabjls = mccabjls;
	}
	public String getGybaybagsmc() {
		return gybaybagsmc;
	}
	public void setGybaybagsmc(String gybaybagsmc) {
		this.gybaybagsmc = gybaybagsmc;
	}
	public String getBagszyfzr() {
		return bagszyfzr;
	}
	public void setBagszyfzr(String bagszyfzr) {
		this.bagszyfzr = bagszyfzr;
	}
	public String getBagszyfzrzw() {
		return bagszyfzrzw;
	}
	public void setBagszyfzrzw(String bagszyfzrzw) {
		this.bagszyfzrzw = bagszyfzrzw;
	}
	public String getBagszyfzrzjzldm() {
		return bagszyfzrzjzldm;
	}
	public void setBagszyfzrzjzldm(String bagszyfzrzjzldm) {
		this.bagszyfzrzjzldm = bagszyfzrzjzldm;
	}
	public String getBagszyfzrzjhm() {
		return bagszyfzrzjhm;
	}
	public void setBagszyfzrzjhm(String bagszyfzrzjhm) {
		this.bagszyfzrzjhm = bagszyfzrzjhm;
	}
	public String getBagszyfzrlxdh() {
		return bagszyfzrlxdh;
	}
	public void setBagszyfzrlxdh(String bagszyfzrlxdh) {
		this.bagszyfzrlxdh = bagszyfzrlxdh;
	}
	public String getAbfa() {
		return abfa;
	}
	public void setAbfa(String abfa) {
		this.abfa = abfa;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
}
