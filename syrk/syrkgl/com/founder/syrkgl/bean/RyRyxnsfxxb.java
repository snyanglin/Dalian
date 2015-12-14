/**********************************************************************   
 * <p>文件名：Ryxnsfxxb.java </p>
 * <p>文件描述：TODO(描述该文件做什么) 
 * @project_name：syrk_syrk
 * @author xu_wenjun@founder.com.cn 
 * @date 2015-4-7 下午2:59:11 
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
 * @Package:      [com.founder.syrkgl.bean.RyRyxnsfxxb.java]  
 * @ClassName:    [RyRyxnsfxxb]   
 * @Description:  [实有人口附加信息-人员虚拟身份信息表]   
 * @Author:       [xu_wenjun@founder.com.cn]  
 * @CreateDate:   [2015-4-7 下午2:59:11]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-4-7 下午2:59:11，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 */
@DBInfoAnnotation(tableName = "RY_RYXNSFXXB", pk = "id")
public class RyRyxnsfxxb extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@FieldDesc("人员虚拟身份ID")
	private String id;
	@FieldDesc("人员ID")
	private String ryid;
	@FieldDesc("账户类型代码")
	private String zhlxdm;
	@FieldDesc("账户名称")
	private String zhmc;
	@FieldDesc("账户号码")
	private String zhhm;
	@FieldDesc("账户单位名称")
	private String zhdwmc;
	@FieldDesc("账户注册日期")
	private String zhzcrq;
	@FieldDesc("账户有效日期")
	private String zhyxrq;
	@FieldDesc("账户注册人")
	private String zhzcr;
	@FieldDesc("是否实名代码")
	private String sfsmdm;
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
	public String getZhlxdm() {
		return zhlxdm;
	}
	public void setZhlxdm(String zhlxdm) {
		this.zhlxdm = zhlxdm;
	}
	public String getZhmc() {
		return zhmc;
	}
	public void setZhmc(String zhmc) {
		this.zhmc = zhmc;
	}
	public String getZhhm() {
		return zhhm;
	}
	public void setZhhm(String zhhm) {
		this.zhhm = zhhm;
	}
	public String getZhdwmc() {
		return zhdwmc;
	}
	public void setZhdwmc(String zhdwmc) {
		this.zhdwmc = zhdwmc;
	}
	public String getZhzcrq() {
		return zhzcrq;
	}
	public void setZhzcrq(String zhzcrq) {
		this.zhzcrq = zhzcrq;
	}
	public String getZhyxrq() {
		return zhyxrq;
	}
	public void setZhyxrq(String zhyxrq) {
		this.zhyxrq = zhyxrq;
	}
	public String getZhzcr() {
		return zhzcr;
	}
	public void setZhzcr(String zhzcr) {
		this.zhzcr = zhzcr;
	}
	public String getSfsmdm() {
		return sfsmdm;
	}
	public void setSfsmdm(String sfsmdm) {
		this.sfsmdm = sfsmdm;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}

}
