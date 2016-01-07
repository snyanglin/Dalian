package com.founder.zdrygl.base.model;

import java.io.Serializable;
import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

/**
 * ****************************************************************************
 * @Package:      [com.founder.zdrygl.bean.ZdryDtjsZszhjsbrZdjlxxb.java]  
 * @ClassName:    [ZdryDtjsZszhjsbrZdjlxxb]   
 * @Description:  [诊断信息表]   
 * @Author:       [cong_rihong@founder.com.cn]  
 * @CreateDate:   [2015-12-15 上午10:11:58]   
 * @UpdateUser:   [founder(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-12-15 上午10:11:58，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@DBInfoAnnotation(tableName = "ZDRY_DTJS_ZSZHJSBR_ZDJL", pk = "ID")
public class ZdryDtjsZszhjsbrZdjlxxb extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@FieldDesc("ID")
	private String id;
	@FieldDesc("诊断单号")
	private String zddh;
	@FieldDesc("诊断时间")
	private String zdsj;
	@FieldDesc("诊断结果")
	private String qzjg;
	@FieldDesc("诊断单位？")
	private String qzdw;
	@FieldDesc("确诊医院")
	private String qzyy;
	@FieldDesc("确诊医师")
	private String qzys;
	@FieldDesc("鉴定人")
	private String jdr;
	@FieldDesc("确诊医生联系电话")
	private String qzyslxdh;
	@FieldDesc("鉴定人联系电话")
	private String jdrlxdh;
	@FieldDesc("诊断过程描述")
	private String zdgcms;
	
	@FieldDesc("重点人员证件号码")
	private String zdryzjhm;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getZddh() {
		return zddh;
	}
	public void setZddh(String zddh) {
		this.zddh = zddh;
	}
	public String getZdsj() {
		return zdsj;
	}
	public void setZdsj(String zdsj) {
		this.zdsj = zdsj;
	}
	public String getQzjg() {
		return qzjg;
	}
	public void setQzjg(String qzjg) {
		this.qzjg = qzjg;
	}
	public String getQzdw() {
		return qzdw;
	}
	public void setQzdw(String qzdw) {
		this.qzdw = qzdw;
	}
	public String getQzyy() {
		return qzyy;
	}
	public void setQzyy(String qzyy) {
		this.qzyy = qzyy;
	}
	public String getQzys() {
		return qzys;
	}
	public void setQzys(String qzys) {
		this.qzys = qzys;
	}
	public String getJdr() {
		return jdr;
	}
	public void setJdr(String jdr) {
		this.jdr = jdr;
	}
	public String getQzyslxdh() {
		return qzyslxdh;
	}
	public void setQzyslxdh(String qzyslxdh) {
		this.qzyslxdh = qzyslxdh;
	}
	public String getJdrlxdh() {
		return jdrlxdh;
	}
	public void setJdrlxdh(String jdrlxdh) {
		this.jdrlxdh = jdrlxdh;
	}
	public String getZdgcms() {
		return zdgcms;
	}
	public void setZdgcms(String zdgcms) {
		this.zdgcms = zdgcms;
	}
	public String getZdryzjhm() {
		return zdryzjhm;
	}
	public void setZdryzjhm(String zdryzjhm) {
		this.zdryzjhm = zdryzjhm;
	}

	
}
