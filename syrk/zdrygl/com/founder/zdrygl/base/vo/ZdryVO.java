package com.founder.zdrygl.base.vo;

import java.io.Serializable;

import com.founder.zdrygl.base.model.ZdryZdrkxxb;
import com.founder.zdrygl.base.model.ZdryZb;
import com.founder.zdrygl.core.model.Zdry;


/**
 * ****************************************************************************
 * @Package:      [com.founder.zdrygl.base.vo.ZdryVO.java]  
 * @ClassName:    [ZdryVO]   
 * @Description:  [重点人员列管VO]   
 * @Author:       [zhang.hai@founder.com.cn]  
 * @CreateDate:   [2015年9月22日 下午2:32:37]   
 * @UpdateUser:   [ZhangHai(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015年9月22日 下午2:32:37，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
public class ZdryVO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	ZdryZb zdryZdryzb;//重点人员总表
	ZdryZdrkxxb zdryZdrk;//重点人口 子表
	
	public ZdryZb getZdryZdryzb() {
		return zdryZdryzb;
	}
	public void setZdryZdryzb(ZdryZb zdryZdryzb) {
		this.zdryZdryzb = zdryZdryzb;
	}
	public ZdryZdrkxxb getZdryZdrk() {
		return zdryZdrk;
	}
	public void setZdryZdrk(ZdryZdrkxxb zdryZdrk) {
		this.zdryZdrk = zdryZdrk;
	}
	
	/**
	 * 
	 * @Title: getZdrylbdx
	 * @Description: TODO(返回当前重点人员类型的子表对象)
	 * @param @return    设定文件
	 * @return Zdry    返回类型
	 * @throw
	 */
	public Zdry getZdrylbdx(){
		if(zdryZdryzb==null || zdryZdryzb.getZdrygllxdm()==null) return null;
		if("02".equals(zdryZdryzb.getZdrygllxdm()))//重点人口
			return zdryZdrk;
		return null;
	}
	/*
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
	*/
}
