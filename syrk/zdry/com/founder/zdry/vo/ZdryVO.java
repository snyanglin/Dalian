package com.founder.zdry.vo;

import java.io.Serializable;

import com.founder.zdry.bean.ZdryFzcsfryxxb;
import com.founder.zdry.bean.ZdryJgdxxxb;
import com.founder.zdry.bean.ZdryLczywblb;
import com.founder.zdry.bean.ZdryNrsxdxxxb;
import com.founder.zdry.bean.ZdrySqjzryxxb;
import com.founder.zdry.bean.ZdrySqsbzdryxxb;
import com.founder.zdry.bean.ZdryYwspb;
import com.founder.zdry.bean.ZdryZdrkxxb;
import com.founder.zdry.bean.ZdryZdryzb;
import com.founder.zdry.bean.ZdryZszhjsbrxxb;

/***
 * ****************************************************************************
 * 
 * @Package: [com.founder.zdry.bean.zdryVO.java]
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
	//社区矫正人员
	ZdrySqjzryxxb zdrySqjzryxxb;
	ZdrySqsbzdryxxb zdrySqsbzdryxxb;//涉枪涉爆重点人员
	ZdryZszhjsbrxxb zdryZszhjsbrxxb;
	ZdryFzcsfryxxb zdryFzcsfryxxb;
	ZdryNrsxdxxxb zdryNrsxdxxxb;//纳入视线对象信息表
	ZdryLczywblb zdryLczywblb;
	ZdryYwspb zdryYwspb;
	String cglxdm;
	String zdryHsbId;
	
	
	
	
	public ZdryNrsxdxxxb getZdryNrsxdxxxb() {
		return zdryNrsxdxxxb;
	}

	public void setZdryNrsxdxxxb(ZdryNrsxdxxxb zdryNrsxdxxxb) {
		this.zdryNrsxdxxxb = zdryNrsxdxxxb;
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

	public ZdryYwspb getZdryYwspb() {
		return zdryYwspb;
	}

	public void setZdryYwspb(ZdryYwspb zdryYwspb) {
		this.zdryYwspb = zdryYwspb;
	}

	public ZdryLczywblb getZdryLczywblb() {
		return zdryLczywblb;
	}

	public void setZdryLczywblb(ZdryLczywblb zdryLczywblb) {
		this.zdryLczywblb = zdryLczywblb;
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

}
