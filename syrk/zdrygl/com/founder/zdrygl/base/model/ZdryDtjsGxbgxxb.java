package com.founder.zdrygl.base.model;

import java.io.Serializable;
import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

/**
 * ****************************************************************************
 * @Package:      [com.founder.qbld.bean.ZdryGxbg.java]  
 * @ClassName:    [ZdryGxbg]   
 * @Description:  [重点人员管辖变更 ]   
 * @Author:       [yu_sun@founder.com.cn]  
 * @CreateDate:   [2015-6-10 下午3:29:25]   
 * @UpdateUser:   [founder(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-6-10 下午3:29:25，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@DBInfoAnnotation(tableName = "ZDRY_DTJS_GXBG", pk = "ZDRYZJHM")
public class ZdryDtjsGxbgxxb extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@FieldDesc("重点人员证件号码")
	private String zdryzjhm;
	@FieldDesc("户籍派出所")
	private String hjpcs;
	@FieldDesc("管辖派出所")
	private String gxpcs;
	@FieldDesc("采集人")
	private String cjr;
	@FieldDesc("入库时间")
	private String rksj;
	@FieldDesc("管辖时间")
	private String xgsj;
	@FieldDesc("户籍派出所名称")
	private String hjpcsmc;
	@FieldDesc("管辖派出所名称")
	private String gxpcsmc;
	@FieldDesc("采集人姓名")
	private String cjrxm;
	public String getZdryzjhm() {
		return zdryzjhm;
	}
	public void setZdryzjhm(String zdryzjhm) {
		this.zdryzjhm = zdryzjhm;
	}
	public String getHjpcs() {
		return hjpcs;
	}
	public void setHjpcs(String hjpcs) {
		this.hjpcs = hjpcs;
	}
	public String getGxpcs() {
		return gxpcs;
	}
	public void setGxpcs(String gxpcs) {
		this.gxpcs = gxpcs;
	}
	public String getCjr() {
		return cjr;
	}
	public void setCjr(String cjr) {
		this.cjr = cjr;
	}
	public String getRksj() {
		return rksj;
	}
	public void setRksj(String rksj) {
		this.rksj = rksj;
	}
	public String getXgsj() {
		return xgsj;
	}
	public void setXgsj(String xgsj) {
		this.xgsj = xgsj;
	}
	public String getHjpcsmc() {
		return hjpcsmc;
	}
	public void setHjpcsmc(String hjpcsmc) {
		this.hjpcsmc = hjpcsmc;
	}
	public String getGxpcsmc() {
		return gxpcsmc;
	}
	public void setGxpcsmc(String gxpcsmc) {
		this.gxpcsmc = gxpcsmc;
	}
	public String getCjrxm() {
		return cjrxm;
	}
	public void setCjrxm(String cjrxm) {
		this.cjrxm = cjrxm;
	}
	
}
