package com.founder.zdrygl.base.model;

import java.io.Serializable;
import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

/**
 * ****************************************************************************
 * @Package:      [com.founder.zdrygl.bean.ZdryDtjsZszhjsbrxxb.java]  
 * @ClassName:    [ZdryDtjsZszhjsbrxxb]   
 * @Description:  [重点人员 动态记实 肇事肇祸精神病人 属性表]   
 * @Author:       [cong_rihong@founder.com.cn]  
 * @CreateDate:   [2015年12月15日 下午7:09:25]   
 * @UpdateUser:   [cong_rihong(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015年12月15日 下午7:09:25，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@DBInfoAnnotation(tableName = "ZDRY_DTJS_ZSZHJSBRXXB", pk = "id")
public class ZdryDtjsZszhjsbrxxb extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@FieldDesc("ID")
	private String id;
	@FieldDesc("所属类别")
	private String sslb;
	@FieldDesc("病人类别")
	private String brlb;
	@FieldDesc("现实状况")
	private String xszk;
	@FieldDesc("病情描述")
	private String bqms;
	@FieldDesc("病情描述")
	private String zyby;
	@FieldDesc("重点人证件号码")
	private String zdryzjhm;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSslb() {
		return sslb;
	}
	public void setSslb(String sslb) {
		this.sslb = sslb;
	}
	public String getBrlb() {
		return brlb;
	}
	public void setBrlb(String brlb) {
		this.brlb = brlb;
	}
	public String getXszk() {
		return xszk;
	}
	public void setXszk(String xszk) {
		this.xszk = xszk;
	}
	public String getBqms() {
		return bqms;
	}
	public void setBqms(String bqms) {
		this.bqms = bqms;
	}
	public String getZyby() {
		return zyby;
	}
	public void setZyby(String zyby) {
		this.zyby = zyby;
	}
	public String getZdryzjhm() {
		return zdryzjhm;
	}
	public void setZdryzjhm(String zdryzjhm) {
		this.zdryzjhm = zdryzjhm;
	}

	
}
