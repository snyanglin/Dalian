package com.founder.zdry.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

/***
 * ****************************************************************************
 * 
 * @Package: [com.founder.zdry.bean.Xdrynjxxb.java]
 * @ClassName: [Xdrynjxxb]
 * @Description: [一句话描述该类的功能]
 * @Author: [wu_chunhui@founder.com.cn]
 * @CreateDate: [2015-3-11 下午6:14:50]
 * @UpdateUser: [Administrator(如多次修改保留历史记录，增加修改记录)]
 * @UpdateDate: [2015-3-11 下午6:14:50，(如多次修改保留历史记录，增加修改记录)]
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]
 * @Version: [v1.0]
 */
@DBInfoAnnotation(tableName = "ZDRY_XDRYNJXXB", pk = "id")
public class ZdryXdrynjxxb extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	@FieldDesc("吸毒人员尿检信息ID")
	private String id;
	@FieldDesc("重点人员ID")
	private String zdryid;
	@FieldDesc("尿检_日期")
	private String nj_rq;
	@FieldDesc("尿检结果代码")
	private String njjgdm;
	@FieldDesc("签到_日期")
	private String qd_rq;

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

	public String getNj_rq() {
		return nj_rq;
	}

	public void setNj_rq(String nj_rq) {
		this.nj_rq = nj_rq;
	}

	public String getNjjgdm() {
		return njjgdm;
	}

	public void setNjjgdm(String njjgdm) {
		this.njjgdm = njjgdm;
	}

	public String getQd_rq() {
		return qd_rq;
	}

	public void setQd_rq(String qd_rq) {
		this.qd_rq = qd_rq;
	}

}
