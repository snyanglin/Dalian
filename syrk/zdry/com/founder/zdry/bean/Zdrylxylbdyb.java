package com.founder.zdry.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

/**
 * ****************************************************************************
 * 
 * @Package: [com.founder.syrk.bean.Zdrylxylbdyb.java]
 * @ClassName: [Zdrylxylbdyb]
 * @Description: [重点人员类型与类别对应表]
 * @Author: [lixiaoqin@founder.com.cn]
 * @CreateDate: [2015-1-23 上午10:47:31]
 * @UpdateUser: [zhangxijiu@founder.com.cn(如多次修改保留历史记录，增加修改记录)]
 * @UpdateDate: [2015-1-29 上午10:01:31，(如多次修改保留历史记录，增加修改记录)]
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]
 * @Version: [v1.0]
 */
@DBInfoAnnotation(tableName = "ZDRY_ZDRYLXYLBDYB", pk = "id")
public class Zdrylxylbdyb extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@FieldDesc("对应ID")
	private String id;
	@FieldDesc("重点人员类型代码")
	private String zdrylxdm;
	@FieldDesc("重点人员类别代码")
	private String zdrylbdm;
	@FieldDesc("备注")
	private String bz;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getZdrylxdm() {
		return zdrylxdm;
	}
	public void setZdrylxdm(String zdrylxdm) {
		this.zdrylxdm = zdrylxdm;
	}
	public String getZdrylbdm() {
		return zdrylbdm;
	}
	public void setZdrylbdm(String zdrylbdm) {
		this.zdrylbdm = zdrylbdm;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}

}
