package com.founder.qbld.bean;

import java.io.Serializable;
import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

/**
 * ****************************************************************************
 * @Package:      [com.founder.qbld.bean.Zsjlb.java]  
 * @ClassName:    [Zsjlb]   
 * @Description:  [肇事记录表]   
 * @Author:       [yu_sun@founder.com.cn]  
 * @CreateDate:   [2015-6-4 下午5:05:32]   
 * @UpdateUser:   [founder(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-6-4 下午5:05:32，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@DBInfoAnnotation(tableName = "QBLD_SK_ZDRY_ZSZHJSBR_ZSZHJL", pk = "ID")
public class Zsjlb extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@FieldDesc("ID")
	private String id;
	@FieldDesc("XXBH")
	private String xxbh;
	@FieldDesc("ZSZHLB")
	private String zszhlb;
	@FieldDesc("SFSJ")
	private String sfsj;
	@FieldDesc("SFDD")
	private String sfdd;
	@FieldDesc("CLJG")
	private String cljg;
	@FieldDesc("JDJG")
	private String jdjg;
	@FieldDesc("JDJGBH")
	private String jdjgbh;
	@FieldDesc("JDDH")
	private String jddh;
	@FieldDesc("JDR")
	private String jdr;
	@FieldDesc("JDRLXDH")
	private String jdrlxdh;
	@FieldDesc("BAMJ")
	private String bamj;
	@FieldDesc("MJLXFS")
	private String mjlxfs;
	@FieldDesc("SSGAJGMC")
	private String ssgajgmc;
	@FieldDesc("TJSJ")
	private String tjsj;
	@FieldDesc("XGSJ")
	private String xgsj;
	@FieldDesc("SSGAJGDM")
	private String ssgajgdm;
	@FieldDesc("SJGCMS")
	private String sjgcms;
	
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
	public String getZszhlb() {
		return zszhlb;
	}
	public void setZszhlb(String zszhlb) {
		this.zszhlb = zszhlb;
	}
	public String getSfsj() {
		return sfsj;
	}
	public void setSfsj(String sfsj) {
		this.sfsj = sfsj;
	}
	public String getSfdd() {
		return sfdd;
	}
	public void setSfdd(String sfdd) {
		this.sfdd = sfdd;
	}
	public String getCljg() {
		return cljg;
	}
	public void setCljg(String cljg) {
		this.cljg = cljg;
	}
	public String getJdjg() {
		return jdjg;
	}
	public void setJdjg(String jdjg) {
		this.jdjg = jdjg;
	}
	public String getJdjgbh() {
		return jdjgbh;
	}
	public void setJdjgbh(String jdjgbh) {
		this.jdjgbh = jdjgbh;
	}
	public String getJddh() {
		return jddh;
	}
	public void setJddh(String jddh) {
		this.jddh = jddh;
	}
	public String getJdr() {
		return jdr;
	}
	public void setJdr(String jdr) {
		this.jdr = jdr;
	}
	public String getJdrlxdh() {
		return jdrlxdh;
	}
	public void setJdrlxdh(String jdrlxdh) {
		this.jdrlxdh = jdrlxdh;
	}
	public String getBamj() {
		return bamj;
	}
	public void setBamj(String bamj) {
		this.bamj = bamj;
	}
	public String getMjlxfs() {
		return mjlxfs;
	}
	public void setMjlxfs(String mjlxfs) {
		this.mjlxfs = mjlxfs;
	}
	public String getSsgajgmc() {
		return ssgajgmc;
	}
	public void setSsgajgmc(String ssgajgmc) {
		this.ssgajgmc = ssgajgmc;
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
	public String getSsgajgdm() {
		return ssgajgdm;
	}
	public void setSsgajgdm(String ssgajgdm) {
		this.ssgajgdm = ssgajgdm;
	}
	public String getSjgcms() {
		return sjgcms;
	}
	public void setSjgcms(String sjgcms) {
		this.sjgcms = sjgcms;
	}
	
}
