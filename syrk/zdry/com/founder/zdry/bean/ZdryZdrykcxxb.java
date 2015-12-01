package com.founder.zdry.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

/***
 * ****************************************************************************
 * 
 * @Package: [com.founder.zdry.bean.Zdrykcxxb.java]
 * @ClassName: [Zdrykcxxb]
 * @Description: [一句话描述该类的功能]
 * @Author: [wu_chunhui@founder.com.cn]
 * @CreateDate: [2015-3-11 下午6:16:02]
 * @UpdateUser: [Administrator(如多次修改保留历史记录，增加修改记录)]
 * @UpdateDate: [2015-3-11 下午6:16:02，(如多次修改保留历史记录，增加修改记录)]
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]
 * @Version: [v1.0]
 */
@DBInfoAnnotation(tableName = "ZDRY_ZDRYKCXXB", pk = "id")
public class ZdryZdrykcxxb extends BaseEntity implements Serializable {

	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 */
	private static final long serialVersionUID = 1L;
	@FieldDesc("考察ID")
	private String id;
	@FieldDesc("重点人员ID")
	private String zdryid;
	@FieldDesc("考察周期代码")
	private String kczqdm;
	@FieldDesc("考察年份")
	private String kcnf;
	@FieldDesc("考察季度")
	private String kcjd;
	@FieldDesc("考察月份")
	private String kcyf;
	@FieldDesc("考察情况")
	private String kcqk;
	@FieldDesc("考察民警ID")
	private String kcmjid;
	@FieldDesc("考察民警姓名")
	private String kcmjxm;
	@FieldDesc("考察_时间")
	private String kc_sj;
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

	public String getKczqdm() {
		return kczqdm;
	}

	public void setKczqdm(String kczqdm) {
		this.kczqdm = kczqdm;
	}

	public String getKcnf() {
		return kcnf;
	}

	public void setKcnf(String kcnf) {
		this.kcnf = kcnf;
	}

	public String getKcjd() {
		return kcjd;
	}

	public void setKcjd(String kcjd) {
		this.kcjd = kcjd;
	}

	public String getKcyf() {
		return kcyf;
	}

	public void setKcyf(String kcyf) {
		this.kcyf = kcyf;
	}

	public String getKcqk() {
		return kcqk;
	}

	public void setKcqk(String kcqk) {
		this.kcqk = kcqk;
	}

	public String getKcmjid() {
		return kcmjid;
	}

	public void setKcmjid(String kcmjid) {
		this.kcmjid = kcmjid;
	}

	public String getKcmjxm() {
		return kcmjxm;
	}

	public void setKcmjxm(String kcmjxm) {
		this.kcmjxm = kcmjxm;
	}

	public String getKc_sj() {
		return kc_sj;
	}

	public void setKc_sj(String kc_sj) {
		this.kc_sj = kc_sj;
	}

	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

}
