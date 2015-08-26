package com.founder.qbld.bean;

import java.io.Serializable;
import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

/**
 * ****************************************************************************
 * @Package:      [com.founder.qbld.bean.WsRecord.java]  
 * @ClassName:    [WsRecord]   
 * @Description:  [ws调用记录表]   
 * @Author:       [yu_sun@founder.com.cn]  
 * @CreateDate:   [2015-7-20 上午8:55:18]   
 * @UpdateUser:   [founder(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-7-20 上午8:55:18，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@DBInfoAnnotation(tableName = "QBLD_WS_RECORD", pk = "ID")
public class WsRecord extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	private String sysB;
	private String sysE;
	@FieldDesc("id")
	private String id;
	@FieldDesc("类型")
	private String type;
	@FieldDesc("写入日期")
	private String sys;
	@FieldDesc("记录id")
	private String sid;
	@FieldDesc("异常记录")
	private String msg;
	@FieldDesc("记录单位")
	private String org;
	
	public String getSysB() {
		return sysB;
	}
	public void setSysB(String sysB) {
		this.sysB = sysB;
	}
	public String getSysE() {
		return sysE;
	}
	public void setSysE(String sysE) {
		this.sysE = sysE;
	}
	public String getOrg() {
		return org;
	}
	public void setOrg(String org) {
		this.org = org;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSys() {
		return sys;
	}
	public void setSys(String sys) {
		this.sys = sys;
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}
