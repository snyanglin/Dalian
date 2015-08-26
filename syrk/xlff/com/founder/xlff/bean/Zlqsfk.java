package com.founder.xlff.bean;

import java.io.Serializable;
import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

/**
 * ****************************************************************************
 * @Package:      [com.founder.xlff.bean.Option.java]  
 * @ClassName:    [Option]   
 * @Description:  [巡逻防范设置表]   
 * @Author:       [yu_sun@founder.com.cn]  
 * @CreateDate:   [2015-6-17 上午11:14:38]   
 * @UpdateUser:   [founder(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-6-17 上午11:14:38，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@DBInfoAnnotation(tableName = "XLFF_YJFX_FKZLQSFK", pk = "id")
public class Zlqsfk extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@FieldDesc("ID")
	private String id;
	@FieldDesc("防控指令ID")
	private String fkzlid;
	@FieldDesc("下发单位代码")
	private String xfdwdm;
	@FieldDesc("下发单位名称")
	private String xfdwmc;
	@FieldDesc("签收人DE00002")
	private String qsr;
	@FieldDesc("签收单位代码")
	private String qsdwdm;
	@FieldDesc("签收单位名称")
	private String qsdwmc;
	@FieldDesc("签收时间")
	private String qssj;
	@FieldDesc("反馈人DE00002")
	private String fkr;
	@FieldDesc("反馈单位代码")
	private String fkdwdm;
	@FieldDesc("反馈单位名称")
	private String fkdwmc;
	@FieldDesc("反馈时间")
	private String fksj;
	@FieldDesc("反馈意见")
	private String fkyj;
	@FieldDesc("签收反馈状态 0 未签收 1 已签收未反馈  2 已反馈")
	private String qsfkzt;
	@FieldDesc("创建时间")
	private String cjsj;
	@FieldDesc("更新时间")
	private String gxsj;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFkzlid() {
		return fkzlid;
	}
	public void setFkzlid(String fkzlid) {
		this.fkzlid = fkzlid;
	}
	public String getXfdwdm() {
		return xfdwdm;
	}
	public void setXfdwdm(String xfdwdm) {
		this.xfdwdm = xfdwdm;
	}
	public String getXfdwmc() {
		return xfdwmc;
	}
	public void setXfdwmc(String xfdwmc) {
		this.xfdwmc = xfdwmc;
	}
	public String getQsr() {
		return qsr;
	}
	public void setQsr(String qsr) {
		this.qsr = qsr;
	}
	public String getQsdwdm() {
		return qsdwdm;
	}
	public void setQsdwdm(String qsdwdm) {
		this.qsdwdm = qsdwdm;
	}
	public String getQsdwmc() {
		return qsdwmc;
	}
	public void setQsdwmc(String qsdwmc) {
		this.qsdwmc = qsdwmc;
	}
	public String getQssj() {
		return qssj;
	}
	public void setQssj(String qssj) {
		this.qssj = qssj;
	}
	public String getFkr() {
		return fkr;
	}
	public void setFkr(String fkr) {
		this.fkr = fkr;
	}
	public String getFkdwdm() {
		return fkdwdm;
	}
	public void setFkdwdm(String fkdwdm) {
		this.fkdwdm = fkdwdm;
	}
	public String getFkdwmc() {
		return fkdwmc;
	}
	public void setFkdwmc(String fkdwmc) {
		this.fkdwmc = fkdwmc;
	}
	public String getFksj() {
		return fksj;
	}
	public void setFksj(String fksj) {
		this.fksj = fksj;
	}
	public String getFkyj() {
		return fkyj;
	}
	public void setFkyj(String fkyj) {
		this.fkyj = fkyj;
	}
	public String getQsfkzt() {
		return qsfkzt;
	}
	public void setQsfkzt(String qsfkzt) {
		this.qsfkzt = qsfkzt;
	}
	public String getCjsj() {
		return cjsj;
	}
	public void setCjsj(String cjsj) {
		this.cjsj = cjsj;
	}
	public String getGxsj() {
		return gxsj;
	}
	public void setGxsj(String gxsj) {
		this.gxsj = gxsj;
	}

}
