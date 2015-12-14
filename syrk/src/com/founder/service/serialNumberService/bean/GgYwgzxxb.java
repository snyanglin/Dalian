/**********************************************************************   
 * <p>文件名：GgYwgzxxb.java </p>
 * <p>文件描述：TODO(描述该文件做什么) 
 * @project_name：syrk
 * @author wu_chunhui@founder.com.cn 
 * @date 2014-12-18 下午02:55:57 
 * @history
 * @department：研发部
 *
 */
package com.founder.service.serialNumberService.bean;

import java.io.Serializable;

import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

/******************************************************************************
 * @Package: [com.founder.service.serialNumberService.bean.GgYwgzxxb.java]
 * @ClassName: [GgYwgzxxb]
 * @Description: [一句话描述该类的功能]
 * @Author: [wu_chunhui@founder.com.cn]
 * @CreateDate: [2014-12-18 下午02:55:57]
 * @UpdateUser: [Administrator(如多次修改保留历史记录，增加修改记录)]
 * @UpdateDate: [2014-12-18 下午02:55:57，(如多次修改保留历史记录，增加修改记录)]
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]
 * @Version: [v1.0]
 */

public class GgYwgzxxb extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	@FieldDesc("主键")
	private String id;
	@FieldDesc("业务名称")
	private String ywmc;
	@FieldDesc("业务描述")
	private String ywms;
	@FieldDesc("业务规则")
	private String ywgz;
	@FieldDesc("业务规则字段1")
	private String ywxx1;
	@FieldDesc("业务规则字段2")
	private String ywxx2;

	@FieldDesc("录入时间")
	private String xt_lrsj;
	@FieldDesc("录入人姓名")
	private String xt_lrrxm;
	@FieldDesc("注销标志")
	private String xt_zxbz;

	/**
	 * @return the xt_lrsj
	 */
	public String getXt_lrsj() {
		return xt_lrsj;
	}

	/**
	 * @param xtLrsj
	 *            the xt_lrsj to set
	 */
	public void setXt_lrsj(String xtLrsj) {
		xt_lrsj = xtLrsj;
	}

	/**
	 * @return the xt_lrrxm
	 */
	public String getXt_lrrxm() {
		return xt_lrrxm;
	}

	/**
	 * @param xtLrrxm
	 *            the xt_lrrxm to set
	 */
	public void setXt_lrrxm(String xtLrrxm) {
		xt_lrrxm = xtLrrxm;
	}

	/**
	 * @return the xt_zxbz
	 */
	public String getXt_zxbz() {
		return xt_zxbz;
	}

	/**
	 * @param xtZxbz
	 *            the xt_zxbz to set
	 */
	public void setXt_zxbz(String xtZxbz) {
		xt_zxbz = xtZxbz;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the ywmc
	 */
	public String getYwmc() {
		return ywmc;
	}

	/**
	 * @param ywmc
	 *            the ywmc to set
	 */
	public void setYwmc(String ywmc) {
		this.ywmc = ywmc;
	}

	/**
	 * @return the ywms
	 */
	public String getYwms() {
		return ywms;
	}

	/**
	 * @param ywms
	 *            the ywms to set
	 */
	public void setYwms(String ywms) {
		this.ywms = ywms;
	}

	/**
	 * @return the ywgz
	 */
	public String getYwgz() {
		return ywgz;
	}

	/**
	 * @param ywgz
	 *            the ywgz to set
	 */
	public void setYwgz(String ywgz) {
		this.ywgz = ywgz;
	}

	/**
	 * @return the ywxx1
	 */
	public String getYwxx1() {
		return ywxx1;
	}

	/**
	 * @param ywxx1
	 *            the ywxx1 to set
	 */
	public void setYwxx1(String ywxx1) {
		this.ywxx1 = ywxx1;
	}

	/**
	 * @return the ywxx2
	 */
	public String getYwxx2() {
		return ywxx2;
	}

	/**
	 * @param ywxx2
	 *            the ywxx2 to set
	 */
	public void setYwxx2(String ywxx2) {
		this.ywxx2 = ywxx2;
	}

}
