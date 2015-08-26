package com.founder.qbld.bean;

import java.io.Serializable;
import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

/**
 * ****************************************************************************
 * @Package:      [com.founder.qbld.bean.XxfbArticle.java]  
 * @ClassName:    [XxfbArticle]   
 * @Description:  [信息发布内容]   
 * @Author:       [yu_sun@founder.com.cn]  
 * @CreateDate:   [2015-6-26 上午9:21:40]   
 * @UpdateUser:   [founder(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-6-26 上午9:21:40，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@DBInfoAnnotation(tableName = "QBLD_XXFB_ARITICLE", pk = "objectid")
public class XxfbArticle extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	private String createtimeB;
	private String createtimeE;
	
	public String getCreatetimeB() {
		return createtimeB;
	}
	public void setCreatetimeB(String createtimeB) {
		this.createtimeB = createtimeB;
	}
	public String getCreatetimeE() {
		return createtimeE;
	}
	public void setCreatetimeE(String createtimeE) {
		this.createtimeE = createtimeE;
	}
	@FieldDesc("OBJECTID")
	private String objectid;
	@FieldDesc("TITLE")
	private String title;
	@FieldDesc("SUBJECT")
	private String subject;
	@FieldDesc("SUBJECTNAME")
	private String subjectname;
	@FieldDesc("CREATETIME")
	private String createtime;
	@FieldDesc("CREATEUSERID")
	private String createuserid;
	@FieldDesc("CREATEUSERNAME")
	private String createusername;
	@FieldDesc("CREATEDEPTCODE")
	private String createdeptcode;
	@FieldDesc("CREATEDEPTNAME")
	private String createdeptname;
	@FieldDesc("STATE")
	private String state;
	@FieldDesc("UPDATETIME")
	private String updatetime;
	@FieldDesc("CONTENT")
	private String content;
	@FieldDesc("HITS")
	private Long hits;
	@FieldDesc("JZDM")
	private String jzdm;
	@FieldDesc("JZMC")
	private String jzmc;
	@FieldDesc("FWBH")
	private String fwbh;
	@FieldDesc("FWR")
	private String fwr;
	@FieldDesc("SPR")
	private String spr;
	@FieldDesc("JJCDDJ")
	private String jjcddj;
	@FieldDesc("B_QS")
	private String b_qs;
	@FieldDesc("QFR")
	private String qfr;
	@FieldDesc("QFSJ")
	private String qfsj;
	@FieldDesc("B_SFXF")
	private String b_sfxf;
	@FieldDesc("XFSH")
	private String xfsh;
	@FieldDesc("FJ_IDS")
	private String fj_ids;
	public String getObjectid() {
		return objectid;
	}
	public void setObjectid(String objectid) {
		this.objectid = objectid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getSubjectname() {
		return subjectname;
	}
	public void setSubjectname(String subjectname) {
		this.subjectname = subjectname;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public String getCreateuserid() {
		return createuserid;
	}
	public void setCreateuserid(String createuserid) {
		this.createuserid = createuserid;
	}
	public String getCreateusername() {
		return createusername;
	}
	public void setCreateusername(String createusername) {
		this.createusername = createusername;
	}
	public String getCreatedeptcode() {
		return createdeptcode;
	}
	public void setCreatedeptcode(String createdeptcode) {
		this.createdeptcode = createdeptcode;
	}
	public String getCreatedeptname() {
		return createdeptname;
	}
	public void setCreatedeptname(String createdeptname) {
		this.createdeptname = createdeptname;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Long getHits() {
		return hits;
	}
	public void setHits(Long hits) {
		this.hits = hits;
	}
	public String getJzdm() {
		return jzdm;
	}
	public void setJzdm(String jzdm) {
		this.jzdm = jzdm;
	}
	public String getJzmc() {
		return jzmc;
	}
	public void setJzmc(String jzmc) {
		this.jzmc = jzmc;
	}
	public String getFwbh() {
		return fwbh;
	}
	public void setFwbh(String fwbh) {
		this.fwbh = fwbh;
	}
	public String getFwr() {
		return fwr;
	}
	public void setFwr(String fwr) {
		this.fwr = fwr;
	}
	public String getSpr() {
		return spr;
	}
	public void setSpr(String spr) {
		this.spr = spr;
	}
	public String getJjcddj() {
		return jjcddj;
	}
	public void setJjcddj(String jjcddj) {
		this.jjcddj = jjcddj;
	}
	public String getB_qs() {
		return b_qs;
	}
	public void setB_qs(String b_qs) {
		this.b_qs = b_qs;
	}
	public String getQfr() {
		return qfr;
	}
	public void setQfr(String qfr) {
		this.qfr = qfr;
	}
	public String getQfsj() {
		return qfsj;
	}
	public void setQfsj(String qfsj) {
		this.qfsj = qfsj;
	}
	public String getB_sfxf() {
		return b_sfxf;
	}
	public void setB_sfxf(String b_sfxf) {
		this.b_sfxf = b_sfxf;
	}
	public String getXfsh() {
		return xfsh;
	}
	public void setXfsh(String xfsh) {
		this.xfsh = xfsh;
	}
	public String getFj_ids() {
		return fj_ids;
	}
	public void setFj_ids(String fj_ids) {
		this.fj_ids = fj_ids;
	}

}
