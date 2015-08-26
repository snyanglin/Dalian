package com.founder.qbld.bean;

import java.io.Serializable;
import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

/**
 * ****************************************************************************
 * @Package:      [com.founder.qbld.bean.Shgxrb.java]  
 * @ClassName:    [Zdjlb]   
 * @Description:  [诊断信息表]   
 * @Author:       [yu_sun@founder.com.cn]  
 * @CreateDate:   [2015-6-4 上午10:11:58]   
 * @UpdateUser:   [founder(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-6-4 上午10:11:58，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@DBInfoAnnotation(tableName = "QBLD_SK_ZDRY_ZSZHJSBR_ZDJL", pk = "ID")
public class Zdjlb extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@FieldDesc("ID")
	private String id;
	@FieldDesc("XXBH")
	private String xxbh;
	@FieldDesc("ZDDH")
	private String zddh;
	@FieldDesc("ZDSJ")
	private String zdsj;
	@FieldDesc("QZJG")
	private String qzjg;
	@FieldDesc("QZDW")
	private String qzdw;
	@FieldDesc("QZYY")
	private String qzyy;
	@FieldDesc("QZYS")
	private String qzys;
	@FieldDesc("JDR")
	private String jdr;
	@FieldDesc("QZYSLXDH")
	private String qzyslxdh;
	@FieldDesc("JDRLXDH")
	private String jdrlxdh;
	@FieldDesc("ZDGCMS")
	private String zdgcms;
	@FieldDesc("TJSJ")
	private String tjsj;
	@FieldDesc("XGSJ")
	private String xgsj;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getXxbh() {
		return xxbh;
	}
	public void setXxbh(String xxbh) {
		this.xxbh = xxbh;
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
	public String getTjsj() {
		return tjsj;
	}
	public void setTjsj(String tjsj) {
		this.tjsj = tjsj;
	}
	public String getXgsj() {
		return xgsj;
	}
	public void setXgsj(String xgsj) {
		this.xgsj = xgsj;
	}
	
}
