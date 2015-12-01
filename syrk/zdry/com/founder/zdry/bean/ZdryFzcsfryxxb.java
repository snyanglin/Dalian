package com.founder.zdry.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;
/***
 * ****************************************************************************
 * @Package:      [com.founder.zdry.bean.Fzcsfryxxb.java]  
 * @ClassName:    [Fzcsfryxxb]   
 * @Description:  [一句话描述该类的功能]   
 * @Author:       [wu_chunhui@founder.com.cn]  
 * @CreateDate:   [2015-3-11 下午6:08:02]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-3-11 下午6:08:02，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@DBInfoAnnotation(tableName = "ZDRY_FZCSFRYXXB", pk = "id")
public class ZdryFzcsfryxxb extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	@FieldDesc("重点人员ID")
	private String id;
	@FieldDesc("信息上报")
	private String xxsb;
	@FieldDesc("上访原因")
	private String sfyy;
	@FieldDesc("交控部门")
	private String jkbm;
	@FieldDesc("交控级别代码")
	private String jkjbdm;
	@FieldDesc("上访人员类别代码")
	private String sfrylbdm;
	@FieldDesc("已解决上访事项")
	private String yjjsfsx;
	@FieldDesc("未解决上访事项")
	private String wjjsfsx;
	@FieldDesc("制造舆论地点")
	private String zzyldd;
	@FieldDesc("接访部门")
	private String jfbm;
	@FieldDesc("涉访处罚情况")
	private String cfqk;
	@FieldDesc("备注")
	private String bz;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getXxsb() {
		return xxsb;
	}

	public void setXxsb(String xxsb) {
		this.xxsb = xxsb;
	}

	public String getSfyy() {
		return sfyy;
	}

	public void setSfyy(String sfyy) {
		this.sfyy = sfyy;
	}

	public String getJkbm() {
		return jkbm;
	}

	public void setJkbm(String jkbm) {
		this.jkbm = jkbm;
	}

	public String getJkjbdm() {
		return jkjbdm;
	}

	public void setJkjbdm(String jkjbdm) {
		this.jkjbdm = jkjbdm;
	}

	public String getSfrylbdm() {
		return sfrylbdm;
	}

	public void setSfrylbdm(String sfrylbdm) {
		this.sfrylbdm = sfrylbdm;
	}

	public String getYjjsfsx() {
		return yjjsfsx;
	}

	public void setYjjsfsx(String yjjsfsx) {
		this.yjjsfsx = yjjsfsx;
	}

	public String getWjjsfsx() {
		return wjjsfsx;
	}

	public void setWjjsfsx(String wjjsfsx) {
		this.wjjsfsx = wjjsfsx;
	}

	public String getZzyldd() {
		return zzyldd;
	}

	public void setZzyldd(String zzyldd) {
		this.zzyldd = zzyldd;
	}

	public String getJfbm() {
		return jfbm;
	}

	public void setJfbm(String jfbm) {
		this.jfbm = jfbm;
	}

	public String getCfqk() {
		return cfqk;
	}

	public void setCfqk(String cfqk) {
		this.cfqk = cfqk;
	}

	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

}
