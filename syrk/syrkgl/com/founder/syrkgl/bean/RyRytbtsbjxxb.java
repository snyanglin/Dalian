/**********************************************************************   
 * <p>文件名：RyRytbtsbjxxb.java </p>
 * <p>文件描述：TODO(描述该文件做什么) 
 * @project_name：syrk_syrk
 * @author xu_wenjun@founder.com.cn 
 * @date 2015-4-12 下午11:16:15 
 * @history
 * @department：研发部
 *
*/
package com.founder.syrkgl.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

/******************************************************************************
 * @Package:      [com.founder.syrkgl.bean.RyRytbtsbjxxb.java]  
 * @ClassName:    [RyRytbtsbjxxb]   
 * @Description:  [实有人口附加信息-人员体表特殊标记信息表]   
 * @Author:       [xu_wenjun@founder.com.cn]  
 * @CreateDate:   [2015-4-12 下午11:16:15]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-4-12 下午11:16:15，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 */
@DBInfoAnnotation(tableName = "RY_RYTBTSBJXXB", pk = "id")
public class RyRytbtsbjxxb extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@FieldDesc("ID")
	private String id;
	@FieldDesc("人员ID")
	private String ryid;
	@FieldDesc("体表标记_人体部位代码")
	private String tbbj_rtbwdm;
	@FieldDesc("体表标记_方位代码")
	private String tbbjfwdm;
	@FieldDesc("体表标记_数量代码")
	private String tbbj_sldm;
	@FieldDesc("体表标记代码")
	private String tbbjdm;
	@FieldDesc("体表特殊标记描述")
	private String tbtsbjms;
	@FieldDesc("备注")
	private String bz;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRyid() {
		return ryid;
	}
	public void setRyid(String ryid) {
		this.ryid = ryid;
	}
	public String getTbbj_rtbwdm() {
		return tbbj_rtbwdm;
	}
	public void setTbbj_rtbwdm(String tbbj_rtbwdm) {
		this.tbbj_rtbwdm = tbbj_rtbwdm;
	}
	public String getTbbjfwdm() {
		return tbbjfwdm;
	}
	public void setTbbjfwdm(String tbbjfwdm) {
		this.tbbjfwdm = tbbjfwdm;
	}
	public String getTbbj_sldm() {
		return tbbj_sldm;
	}
	public void setTbbj_sldm(String tbbj_sldm) {
		this.tbbj_sldm = tbbj_sldm;
	}
	public String getTbbjdm() {
		return tbbjdm;
	}
	public void setTbbjdm(String tbbjdm) {
		this.tbbjdm = tbbjdm;
	}
	public String getTbtsbjms() {
		return tbtsbjms;
	}
	public void setTbtsbjms(String tbtsbjms) {
		this.tbtsbjms = tbtsbjms;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
}
