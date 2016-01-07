package com.founder.zdrygl.base.model;

import java.io.Serializable;
import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

/**
 * ****************************************************************************
 * @Package:      [com.founder.zdrygl.bean.ZdryDtjsSdfdxxb.java]  
 * @ClassName:    [ZdryDtjsSdfdxxb]   
 * @Description:  [重点人员 动态记实 涉毒-贩毒 属性 表]   
 * @Author:       [cong_rihong@founder.com.cn]  
 * @CreateDate:   [2015年12月15日 下午7:00:19]   
 * @UpdateUser:   [cong_rihong(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015年12月15日 下午7:00:19，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@DBInfoAnnotation(tableName = "ZDRY_DTJS_SDFDXXB", pk = "id")
public class ZdryDtjsSdfdxxb extends BaseEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7007913650597562026L;
	@FieldDesc("ID")
	private String id;
	@FieldDesc("毒品种类")
	private String fmdpzl;
	@FieldDesc("毒品来源")
	private String dply;
	@FieldDesc("毒品种类其他")
	private String dplyqt;
	@FieldDesc("贩卖毒品渠道")
	private String fmdpqd;
	@FieldDesc("毒品其他渠道")
	private String dpqdqt;
	@FieldDesc("毒资去向")
	private String shdzqx;
	@FieldDesc("写实信息编号")
	private String xsbh;
	@FieldDesc("毒品种类其他")
	private String dpzlqt;
	@FieldDesc("重点人身份证号")
	private String zdryzjhm;
	@FieldDesc("来源地")
	private String lyd;
	@FieldDesc("毒资取向其他")
	private String dzqxqt;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFmdpzl() {
		return fmdpzl;
	}
	public void setFmdpzl(String fmdpzl) {
		this.fmdpzl = fmdpzl;
	}
	public String getDply() {
		return dply;
	}
	public void setDply(String dply) {
		this.dply = dply;
	}
	public String getDplyqt() {
		return dplyqt;
	}
	public void setDplyqt(String dplyqt) {
		this.dplyqt = dplyqt;
	}
	public String getFmdpqd() {
		return fmdpqd;
	}
	public void setFmdpqd(String fmdpqd) {
		this.fmdpqd = fmdpqd;
	}
	public String getDpqdqt() {
		return dpqdqt;
	}
	public void setDpqdqt(String dpqdqt) {
		this.dpqdqt = dpqdqt;
	}
	public String getShdzqx() {
		return shdzqx;
	}
	public void setShdzqx(String shdzqx) {
		this.shdzqx = shdzqx;
	}
	public String getXsbh() {
		return xsbh;
	}
	public void setXsbh(String xsbh) {
		this.xsbh = xsbh;
	}
	public String getDpzlqt() {
		return dpzlqt;
	}
	public void setDpzlqt(String dpzlqt) {
		this.dpzlqt = dpzlqt;
	}
	public String getZdryzjhm() {
		return zdryzjhm;
	}
	public void setZdryzjhm(String zdryzjhm) {
		this.zdryzjhm = zdryzjhm;
	}
	public String getLyd() {
		return lyd;
	}
	public void setLyd(String lyd) {
		this.lyd = lyd;
	}
	public String getDzqxqt() {
		return dzqxqt;
	}
	public void setDzqxqt(String dzqxqt) {
		this.dzqxqt = dzqxqt;
	}

	
	
}
