package com.founder.zdrygl.vo;

import java.io.Serializable;

import com.founder.zdrygl.bean.ZdryFzcsfryxxb;
import com.founder.zdrygl.bean.ZdryJgdxxxb;
import com.founder.zdrygl.bean.ZdrySgafzdryxxb;
import com.founder.zdrygl.bean.ZdryShbzdryxxb;
import com.founder.zdrygl.bean.ZdrySqjzryxxb;
import com.founder.zdrygl.bean.ZdrySqsbzdryxxb;
import com.founder.zdrygl.bean.ZdryZdrkxxb;
import com.founder.zdrygl.bean.ZdryZdryzb;
import com.founder.zdrygl.bean.ZdryZszhjsbrxxb;

/***
 * ****************************************************************************
 * 
 * @Package: [com.founder.zdrygl.bean.zdryVO.java]
 * @ClassName: [zdryVO]
 * @Description: [重点人口视图对象，用于重点人员业务提交等]
 * @Author: [wu_chunhui@founder.com.cn]
 * @CreateDate: [2015-3-12 上午9:30:08]
 * @UpdateUser: [Administrator(如多次修改保留历史记录，增加修改记录)]
 * @UpdateDate: [2015-3-12 上午9:30:08，(如多次修改保留历史记录，增加修改记录)]
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]
 * @Version: [v1.0]
 */
public class ZdryVO implements Serializable {

	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 */
	private static final long serialVersionUID = 1L;
	String zdrylbStr;// 重点人员类别，用逗号分隔
	ZdryZdryzb zdryZdryzb;
	ZdryJgdxxxb zdryJgdxxxb;
	ZdryZdrkxxb zdryZdrkxxb;
	ZdryZszhjsbrxxb zdryZszhjsbrxxb;
	ZdryFzcsfryxxb zdryFzcsfryxxb;
	ZdryShbzdryxxb zdryShbzdryxxb;
	ZdrySqsbzdryxxb zdrySqsbzdryxxb;
	ZdrySqjzryxxb zdrySqjzryxxb;
	String cglxdm;
	String zdryHsbId;
	String ywsqyy;
	String xm;
	String zjhm;
	ZdrySgafzdryxxb zdrySgafzdryxxb;
	ZdryZdryzbVO zdryZdryzbVO;
	
	
	public String getXm() {
		return xm;
	}

	public void setXm(String xm) {
		this.xm = xm;
	}

	public String getZjhm() {
		return zjhm;
	}

	public void setZjhm(String zjhm) {
		this.zjhm = zjhm;
	}

	public String getYwsqyy() {
		return ywsqyy;
	}

	public void setYwsqyy(String ywsqyy) {
		this.ywsqyy = ywsqyy;
	}

	public ZdrySqsbzdryxxb getZdrySqsbzdryxxb() {
		return zdrySqsbzdryxxb;
	}

	public void setZdrySqsbzdryxxb(ZdrySqsbzdryxxb zdrySqsbzdryxxb) {
		this.zdrySqsbzdryxxb = zdrySqsbzdryxxb;
	}

	public ZdrySqjzryxxb getZdrySqjzryxxb() {
		return zdrySqjzryxxb;
	}

	public void setZdrySqjzryxxb(ZdrySqjzryxxb zdrySqjzryxxb) {
		this.zdrySqjzryxxb = zdrySqjzryxxb;
	}

	public ZdryShbzdryxxb getZdryShbzdryxxb() {
		return zdryShbzdryxxb;
	}

	public void setZdryShbzdryxxb(ZdryShbzdryxxb zdryShbzdryxxb) {
		this.zdryShbzdryxxb = zdryShbzdryxxb;
	}

	public String getZdryHsbId() {
		return zdryHsbId;
	}

	public void setZdryHsbId(String zdryHsbId) {
		this.zdryHsbId = zdryHsbId;
	}

	public String getCglxdm() {
		return cglxdm;
	}

	public void setCglxdm(String cglxdm) {
		this.cglxdm = cglxdm;
	}

	

	public String getZdrylbStr() {
		return zdrylbStr;
	}

	public void setZdrylbStr(String zdrylbStr) {
		this.zdrylbStr = zdrylbStr;
	}

	public ZdryZdryzb getZdryZdryzb() {
		return zdryZdryzb;
	}

	public void setZdryZdryzb(ZdryZdryzb zdryZdryzb) {
		this.zdryZdryzb = zdryZdryzb;
	}

	public ZdryJgdxxxb getZdryJgdxxxb() {
		return zdryJgdxxxb;
	}

	public void setZdryJgdxxxb(ZdryJgdxxxb zdryJgdxxxb) {
		this.zdryJgdxxxb = zdryJgdxxxb;
	}

	public ZdryZdrkxxb getZdryZdrkxxb() {
		return zdryZdrkxxb;
	}

	public void setZdryZdrkxxb(ZdryZdrkxxb zdryZdrkxxb) {
		this.zdryZdrkxxb = zdryZdrkxxb;
	}

	public ZdryZszhjsbrxxb getZdryZszhjsbrxxb() {
		return zdryZszhjsbrxxb;
	}

	public void setZdryZszhjsbrxxb(ZdryZszhjsbrxxb zdryZszhjsbrxxb) {
		this.zdryZszhjsbrxxb = zdryZszhjsbrxxb;
	}

	public ZdryFzcsfryxxb getZdryFzcsfryxxb() {
		return zdryFzcsfryxxb;
	}

	public void setZdryFzcsfryxxb(ZdryFzcsfryxxb zdryFzcsfryxxb) {
		this.zdryFzcsfryxxb = zdryFzcsfryxxb;
	}

	public ZdrySgafzdryxxb getZdrySgafzdryxxb() {
		return zdrySgafzdryxxb;
	}

	public void setZdrySgafzdryxxb(ZdrySgafzdryxxb zdrySgafzdryxxb) {
		this.zdrySgafzdryxxb = zdrySgafzdryxxb;
	}

	public ZdryZdryzbVO getZdryZdryzbVO() {
		return zdryZdryzbVO;
	}

	public void setZdryZdryzbVO(ZdryZdryzbVO zdryZdryzbVO) {
		this.zdryZdryzbVO = zdryZdryzbVO;
	}
	
}
