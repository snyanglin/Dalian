package com.founder.zdry.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

/***
 * ****************************************************************************
 * 
 * @Package: [com.founder.zdry.bean.Dtgljsxxb.java]
 * @ClassName: [Dtgljsxxb]
 * @Description: [一句话描述该类的功能]
 * @Author: [wu_chunhui@founder.com.cn]
 * @CreateDate: [2015-3-11 下午6:17:10]
 * @UpdateUser: [Administrator(如多次修改保留历史记录，增加修改记录)]
 * @UpdateDate: [2015-3-11 下午6:17:10，(如多次修改保留历史记录，增加修改记录)]
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]
 * @Version: [v1.0]
 */
@DBInfoAnnotation(tableName = "ZDRY_DTGLJSXXB", pk = "id")
public class ZdryDtgljsxxb extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	@FieldDesc("动态管理纪实ID")
	private String id;
	@FieldDesc("重点人员ID")
	private String zdryid;
	@FieldDesc("是否在控代码")
	private String sfzkdm;
	@FieldDesc("纪实_时间")
	private String js_sj;
	@FieldDesc("动态纪实")
	private String dtjs;
	@FieldDesc("动态纪实民警ID")
	private String dtjsmj_id;
	@FieldDesc("动态纪实民警姓名")
	private String dtjsmj_xm;
	@FieldDesc("纪实类型代码")
	private String jslxdm;
	@FieldDesc("备注")
	private String bz;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getZdryid() {
		return zdryid;
	}

	public void setZdryid(String zdryid) {
		this.zdryid = zdryid;
	}

	public String getSfzkdm() {
		return sfzkdm;
	}

	public void setSfzkdm(String sfzkdm) {
		this.sfzkdm = sfzkdm;
	}

	public String getJs_sj() {
		return js_sj;
	}

	public void setJs_sj(String js_sj) {
		this.js_sj = js_sj;
	}

	public String getDtjs() {
		return dtjs;
	}

	public void setDtjs(String dtjs) {
		this.dtjs = dtjs;
	}

	public String getDtjsmj_id() {
		return dtjsmj_id;
	}

	public void setDtjsmj_id(String dtjsmj_id) {
		this.dtjsmj_id = dtjsmj_id;
	}

	public String getDtjsmj_xm() {
		return dtjsmj_xm;
	}

	public void setDtjsmj_xm(String dtjsmj_xm) {
		this.dtjsmj_xm = dtjsmj_xm;
	}

	public String getJslxdm() {
		return jslxdm;
	}

	public void setJslxdm(String jslxdm) {
		this.jslxdm = jslxdm;
	}

	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

}
