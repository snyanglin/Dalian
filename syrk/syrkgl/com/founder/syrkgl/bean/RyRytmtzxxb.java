/**********************************************************************   
 * <p>文件名：RyRytmtzxxb.java </p>
 * <p>文件描述：TODO(实有人口附加信息-人员别名绰号表) 
 * @project_name：syrk_syrk
 * @author xu_wenjun@founder.com.cn 
 * @date 2015-4-12 下午4:08:25 
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
 * @Package:      [com.founder.syrkgl.bean.RyRytmtzxxb.java]  
 * @ClassName:    [RyRytmtzxxb]   
 * @Description:  [实有人口附加信息-人员体貌特征信息表]   
 * @Author:       [xu_wenjun@founder.com.cn]  
 * @CreateDate:   [2015-4-12 下午4:08:25]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-4-12 下午4:08:25，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 */
@DBInfoAnnotation(tableName = "RY_RYTMTZXXB", pk = "id")
public class RyRytmtzxxb extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@FieldDesc("ID")
	private String id;
	@FieldDesc("人员ID")
	private String ryid;
	@FieldDesc("血型代码")
	private String xxdm;
	@FieldDesc("身高")
	private Long sg;
	@FieldDesc("体重")
	private Long tz;
	@FieldDesc("体型代码")
	private String txdm;
	@FieldDesc("脸型代码")
	private String lxdm;
	@FieldDesc("足长（MM）")
	private Long zc;
	@FieldDesc("鞋号(MM)")
	private Long xh;
	@FieldDesc("体貌特征描述描述")
	private String tmtzms;
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
	public String getXxdm() {
		return xxdm;
	}
	public void setXxdm(String xxdm) {
		this.xxdm = xxdm;
	}
	public Long getSg() {
		return sg;
	}
	public void setSg(Long sg) {
		this.sg = sg;
	}
	public Long getTz() {
		return tz;
	}
	public void setTz(Long tz) {
		this.tz = tz;
	}
	public String getTxdm() {
		return txdm;
	}
	public void setTxdm(String txdm) {
		this.txdm = txdm;
	}
	public String getLxdm() {
		return lxdm;
	}
	public void setLxdm(String lxdm) {
		this.lxdm = lxdm;
	}
	public Long getZc() {
		return zc;
	}
	public void setZc(Long zc) {
		this.zc = zc;
	}
	public Long getXh() {
		return xh;
	}
	public void setXh(Long xh) {
		this.xh = xh;
	}
	public String getTmtzms() {
		return tmtzms;
	}
	public void setTmtzms(String tmtzms) {
		this.tmtzms = tmtzms;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}

}
