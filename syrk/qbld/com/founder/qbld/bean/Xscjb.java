package com.founder.qbld.bean;

import java.io.Serializable;
import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

/**
 * ****************************************************************************
 * @Package:      [com.founder.qbld.bean.Xscjb.java]  
 * @ClassName:    [Xscjb]   
 * @Description:  [线索采集表javabean]   
 * @Author:       [yu_sun@founder.com.cn]  
 * @CreateDate:   [2015-5-4 上午11:17:47]   
 * @UpdateUser:   [founder(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-5-4 上午11:17:47，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@DBInfoAnnotation(tableName = "QBLD_XS_CJB", pk = "guid")
public class Xscjb extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	private String bssjB;
	private String bssjE;
	
	@FieldDesc("记录编号")
	private String jlid;
	@FieldDesc("报送时间")
	private String bssj;
	@FieldDesc("紧急程度")
	private String jjcd;
	@FieldDesc("是否已发生")
	private String sfyfs;
	@FieldDesc("是否续报")
	private String sfxb;
	@FieldDesc("线索来源")
	private String xsly;
	@FieldDesc("标题")
	private String bt;
	@FieldDesc("关键词")
	private String gjc;
	@FieldDesc("采集单位代码")
	private String cjdwdm;
	@FieldDesc("采集单位名称")
	private String cjdwmc;
	@FieldDesc("采集人")
	private String cjr;
	@FieldDesc("填报单位代码")
	private String tbdwdm;
	@FieldDesc("填报单位名称")
	private String tbdwmc;
	@FieldDesc("填报人")
	private String tbr;
	@FieldDesc("审核人")
	private String shr;
	@FieldDesc("涉事主体")
	private String sszt;
	@FieldDesc("涉事类别大类")
	private String sslbdl;
	@FieldDesc("涉事类别")
	private String sslb;
	@FieldDesc("涉及敏感时点")
	private String sjmgsd;
	@FieldDesc("涉及重大活动")
	private String sjzdhd;
	@FieldDesc("涉及人数")
	private String sjrs;
	@FieldDesc("涉及损失")
	private String sjss;
	@FieldDesc("涉事诱因")
	private String ssyy;
	@FieldDesc("表现形式")
	private String bxxs;
	@FieldDesc("案(事)时间")
	private String assj;
	@FieldDesc("案(事)地点类别")
	private String asddlb;
	@FieldDesc("涉事骨干情况")
	private String ssggqk;
	@FieldDesc("续报原记录编号")
	private String xbyjlid;
	@FieldDesc("是否删除")
	private String sfsc;
	@FieldDesc("删除原因")
	private String scyy;
	@FieldDesc("删除时间")
	private String scsj;
	@FieldDesc("案(事)时间_开始")
	private String b_assj_ks;
	@FieldDesc("案(事)时间_结束")
	private String b_assj_js;
	@FieldDesc("涉事主题代码")
	private String b_ssztdm;
	@FieldDesc("信息正文")
	private String xxzw;
	
	public String getBssjB() {
		return bssjB;
	}
	public void setBssjB(String bssjB) {
		this.bssjB = bssjB;
	}
	public String getBssjE() {
		return bssjE;
	}
	public void setBssjE(String bssjE) {
		this.bssjE = bssjE;
	}
	public String getJlid() {
		return jlid;
	}
	public void setJlid(String jlid) {
		this.jlid = jlid;
	}
	public String getBssj() {
		return bssj;
	}
	public void setBssj(String bssj) {
		this.bssj = bssj;
	}
	public String getJjcd() {
		return jjcd;
	}
	public void setJjcd(String jjcd) {
		this.jjcd = jjcd;
	}
	public String getSfyfs() {
		return sfyfs;
	}
	public void setSfyfs(String sfyfs) {
		this.sfyfs = sfyfs;
	}
	public String getSfxb() {
		return sfxb;
	}
	public void setSfxb(String sfxb) {
		this.sfxb = sfxb;
	}
	public String getXsly() {
		return xsly;
	}
	public void setXsly(String xsly) {
		this.xsly = xsly;
	}
	public String getBt() {
		return bt;
	}
	public void setBt(String bt) {
		this.bt = bt;
	}
	public String getGjc() {
		return gjc;
	}
	public void setGjc(String gjc) {
		this.gjc = gjc;
	}
	public String getCjdwdm() {
		return cjdwdm;
	}
	public void setCjdwdm(String cjdwdm) {
		this.cjdwdm = cjdwdm;
	}
	public String getCjdwmc() {
		return cjdwmc;
	}
	public void setCjdwmc(String cjdwmc) {
		this.cjdwmc = cjdwmc;
	}
	public String getCjr() {
		return cjr;
	}
	public void setCjr(String cjr) {
		this.cjr = cjr;
	}
	public String getTbdwdm() {
		return tbdwdm;
	}
	public void setTbdwdm(String tbdwdm) {
		this.tbdwdm = tbdwdm;
	}
	public String getTbdwmc() {
		return tbdwmc;
	}
	public void setTbdwmc(String tbdwmc) {
		this.tbdwmc = tbdwmc;
	}
	public String getTbr() {
		return tbr;
	}
	public void setTbr(String tbr) {
		this.tbr = tbr;
	}
	public String getShr() {
		return shr;
	}
	public void setShr(String shr) {
		this.shr = shr;
	}
	public String getSszt() {
		return sszt;
	}
	public void setSszt(String sszt) {
		this.sszt = sszt;
	}
	public String getSslbdl() {
		return sslbdl;
	}
	public void setSslbdl(String sslbdl) {
		this.sslbdl = sslbdl;
	}
	public String getSslb() {
		return sslb;
	}
	public void setSslb(String sslb) {
		this.sslb = sslb;
	}
	public String getSjmgsd() {
		return sjmgsd;
	}
	public void setSjmgsd(String sjmgsd) {
		this.sjmgsd = sjmgsd;
	}
	public String getSjzdhd() {
		return sjzdhd;
	}
	public void setSjzdhd(String sjzdhd) {
		this.sjzdhd = sjzdhd;
	}
	public String getSjrs() {
		return sjrs;
	}
	public void setSjrs(String sjrs) {
		this.sjrs = sjrs;
	}
	public String getSjss() {
		return sjss;
	}
	public void setSjss(String sjss) {
		this.sjss = sjss;
	}
	public String getSsyy() {
		return ssyy;
	}
	public void setSsyy(String ssyy) {
		this.ssyy = ssyy;
	}
	public String getBxxs() {
		return bxxs;
	}
	public void setBxxs(String bxxs) {
		this.bxxs = bxxs;
	}
	public String getAssj() {
		return assj;
	}
	public void setAssj(String assj) {
		this.assj = assj;
	}
	public String getAsddlb() {
		return asddlb;
	}
	public void setAsddlb(String asddlb) {
		this.asddlb = asddlb;
	}
	public String getSsggqk() {
		return ssggqk;
	}
	public void setSsggqk(String ssggqk) {
		this.ssggqk = ssggqk;
	}
	public String getXbyjlid() {
		return xbyjlid;
	}
	public void setXbyjlid(String xbyjlid) {
		this.xbyjlid = xbyjlid;
	}
	public String getSfsc() {
		return sfsc;
	}
	public void setSfsc(String sfsc) {
		this.sfsc = sfsc;
	}
	public String getScyy() {
		return scyy;
	}
	public void setScyy(String scyy) {
		this.scyy = scyy;
	}
	public String getScsj() {
		return scsj;
	}
	public void setScsj(String scsj) {
		this.scsj = scsj;
	}
	public String getB_assj_ks() {
		return b_assj_ks;
	}
	public void setB_assj_ks(String b_assj_ks) {
		this.b_assj_ks = b_assj_ks;
	}
	public String getB_assj_js() {
		return b_assj_js;
	}
	public void setB_assj_js(String b_assj_js) {
		this.b_assj_js = b_assj_js;
	}
	public String getB_ssztdm() {
		return b_ssztdm;
	}
	public void setB_ssztdm(String b_ssztdm) {
		this.b_ssztdm = b_ssztdm;
	}
	public String getXxzw() {
		return xxzw;
	}
	public void setXxzw(String xxzw) {
		this.xxzw = xxzw;
	}

}
