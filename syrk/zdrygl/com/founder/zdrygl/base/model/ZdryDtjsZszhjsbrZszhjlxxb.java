package com.founder.zdrygl.base.model;

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
@DBInfoAnnotation(tableName = "ZDRY_DTJS_ZSZHJSBR_ZSZHJL", pk = "ID")
public class ZdryDtjsZszhjsbrZszhjlxxb extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@FieldDesc("ID")
	private String id;
	@FieldDesc("肇事肇祸类别")
	private String zszhlb;
	@FieldDesc("事发时间")
	private String sfsj;
	@FieldDesc("事发地点")
	private String sfdd;
	@FieldDesc("处理结果")
	private String cljg;
	@FieldDesc("鉴定机构")
	private String jdjg;
	@FieldDesc("鉴定结果")
	private String jdjgbh;
	@FieldDesc("鉴定单号")
	private String jddh;
	@FieldDesc("鉴定人")
	private String jdr;
	@FieldDesc("鉴定人联系电话")
	private String jdrlxdh;
	@FieldDesc("办案民警")
	private String bamj;
	@FieldDesc("民警联系方式")
	private String mjlxfs;
	@FieldDesc("所属公安机关")
	private String ssgajgmc;
	@FieldDesc("所属公安机构代码")
	private String ssgajgdm;
	@FieldDesc("事件过程描述")
	private String sjgcms;
	@FieldDesc("重点人员证件号码")
	private String zdryzjhm;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public String getZdryzjhm() {
		return zdryzjhm;
	}
	public void setZdryzjhm(String zdryzjhm) {
		this.zdryzjhm = zdryzjhm;
	}

	
}
