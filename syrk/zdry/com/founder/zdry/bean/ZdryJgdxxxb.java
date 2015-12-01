package com.founder.zdry.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

/***
 * ****************************************************************************
 * 
 * @Package: [com.founder.zdry.bean.Jgdxxxb.java]
 * @ClassName: [Jgdxxxb]
 * @Description: [一句话描述该类的功能]
 * @Author: [wu_chunhui@founder.com.cn]
 * @CreateDate: [2015-3-11 下午5:53:41]
 * @UpdateUser: [Administrator(如多次修改保留历史记录，增加修改记录)]
 * @UpdateDate: [2015-3-11 下午5:53:41，(如多次修改保留历史记录，增加修改记录)]
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]
 * @Version: [v1.0]
 */
@DBInfoAnnotation(tableName = "ZDRY_JGDXXXB", pk = "id")
public class ZdryJgdxxxb extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	@FieldDesc("重点人员ID")
	private String id;
	@FieldDesc("监管类别代码")
	private String jglbdm;
	@FieldDesc("监管单位机构代码")
	private String jgdwjgdm;
	@FieldDesc("监管单位名称")
	private String jgdwmc;
	@FieldDesc("犯罪性质代码")
	private String fzxzdm;
	@FieldDesc("违法嫌疑人处理结果代码")
	private String wfxyrcljgdm;
	@FieldDesc("判决机关名称")
	private String pjjgmc;
	@FieldDesc("备注")
	private String bz;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getJglbdm() {
		return jglbdm;
	}

	public void setJglbdm(String jglbdm) {
		this.jglbdm = jglbdm;
	}

	public String getJgdwjgdm() {
		return jgdwjgdm;
	}

	public void setJgdwjgdm(String jgdwjgdm) {
		this.jgdwjgdm = jgdwjgdm;
	}

	public String getJgdwmc() {
		return jgdwmc;
	}

	public void setJgdwmc(String jgdwmc) {
		this.jgdwmc = jgdwmc;
	}

	public String getFzxzdm() {
		return fzxzdm;
	}

	public void setFzxzdm(String fzxzdm) {
		this.fzxzdm = fzxzdm;
	}

	public String getWfxyrcljgdm() {
		return wfxyrcljgdm;
	}

	public void setWfxyrcljgdm(String wfxyrcljgdm) {
		this.wfxyrcljgdm = wfxyrcljgdm;
	}

	public String getPjjgmc() {
		return pjjgmc;
	}

	public void setPjjgmc(String pjjgmc) {
		this.pjjgmc = pjjgmc;
	}

	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

}
