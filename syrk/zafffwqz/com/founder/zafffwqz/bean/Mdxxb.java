package com.founder.zafffwqz.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;


/******************************************************************************
 * @Package:      [com.founder.zafffwqz.bean.Mdxxb.java]  
 * @ClassName:    [Mdxxb]   
 * @Description:  [矛盾调节实体类]   
 * @Author:       [tian_chengwei@founder.com.cn]  
 * @CreateDate:   [2015-6-2 下午11:51:27]   
 * @UpdateUser:   [lk(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-6-2 下午11:51:27，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 * 
 * @review      :wu.w@founder.com.cn
 * @reviewDate  : 20150604
 */
@DBInfoAnnotation(tableName = "FWQZ_MDXXB" , pk = "id")
public class Mdxxb extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@FieldDesc("矛盾基本信息ID")
	private String id;
	@FieldDesc("警情ID")
	private String jqid;
	@FieldDesc("矛盾来源代码")
	private String mdlydm;
	@FieldDesc("矛盾管辖归属代码")
	private String mdgxgsdm;
	@FieldDesc("矛盾类型")
	private String mdlx;
	@FieldDesc("矛盾发生时间")
	private String mdfssj;
	@FieldDesc("矛盾发生地点名称")
	private String mdfsddmc;
	@FieldDesc("矛盾原因")
	private String mdyy;
	@FieldDesc("矛盾现状")
	private String mdxz;
	@FieldDesc("调解结果代码")
	private String tjjgdm;
	@FieldDesc("管辖单位名称")
	private String gxdwmc;
	@FieldDesc("管辖单位ID")
	private String gxdwid;
	@FieldDesc("是否移交代码")
	private String sfyjdm;
	@FieldDesc("移交人")
	private String yjr;
	@FieldDesc("接收人")
	private String jsr;
	@FieldDesc("备注")
	private String bz;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getJqid() {
		return jqid;
	}
	public void setJqid(String jqid) {
		this.jqid = jqid;
	}
	public String getMdlydm() {
		return mdlydm;
	}
	public void setMdlydm(String mdlydm) {
		this.mdlydm = mdlydm;
	}
	public String getMdgxgsdm() {
		return mdgxgsdm;
	}
	public void setMdgxgsdm(String mdgxgsdm) {
		this.mdgxgsdm = mdgxgsdm;
	}
	public String getMdlx() {
		return mdlx;
	}
	public void setMdlx(String mdlx) {
		this.mdlx = mdlx;
	}
	public String getMdfssj() {
		return mdfssj;
	}
	public void setMdfssj(String mdfssj) {
		this.mdfssj = mdfssj;
	}
	public String getMdfsddmc() {
		return mdfsddmc;
	}
	public void setMdfsddmc(String mdfsddmc) {
		this.mdfsddmc = mdfsddmc;
	}
	public String getMdyy() {
		return mdyy;
	}
	public void setMdyy(String mdyy) {
		this.mdyy = mdyy;
	}
	public String getMdxz() {
		return mdxz;
	}
	public void setMdxz(String mdxz) {
		this.mdxz = mdxz;
	}
	public String getTjjgdm() {
		return tjjgdm;
	}
	public void setTjjgdm(String tjjgdm) {
		this.tjjgdm = tjjgdm;
	}
	public String getGxdwmc() {
		return gxdwmc;
	}
	public void setGxdwmc(String gxdwmc) {
		this.gxdwmc = gxdwmc;
	}
	public String getGxdwid() {
		return gxdwid;
	}
	public void setGxdwid(String gxdwid) {
		this.gxdwid = gxdwid;
	}
	public String getSfyjdm() {
		return sfyjdm;
	}
	public void setSfyjdm(String sfyjdm) {
		this.sfyjdm = sfyjdm;
	}
	public String getYjr() {
		return yjr;
	}
	public void setYjr(String yjr) {
		this.yjr = yjr;
	}
	public String getJsr() {
		return jsr;
	}
	public void setJsr(String jsr) {
		this.jsr = jsr;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	
	
}
