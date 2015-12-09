package com.founder.zdrygl.base.vo;

import java.io.Serializable;

import com.founder.framework.components.AppConst;
import com.founder.framework.config.SystemConfig;
import com.founder.zdrygl.base.model.ZdryFzcsfryxxb;
import com.founder.zdrygl.base.model.ZdryJgdxxxb;
import com.founder.zdrygl.base.model.ZdryNrsxdxxxb;
import com.founder.zdrygl.base.model.ZdrySgafzdryxxb;
import com.founder.zdrygl.base.model.ZdryShbzdryxxb;
import com.founder.zdrygl.base.model.ZdrySqjzryxxb;
import com.founder.zdrygl.base.model.ZdrySqsbzdryxxb;
import com.founder.zdrygl.base.model.ZdryZb;
import com.founder.zdrygl.base.model.ZdryZdrkxxb;
import com.founder.zdrygl.base.model.ZdryZszhjsbrxxb;
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

	String zdrylbStr;// 重点人员类别，用逗号分隔
	ZdryZb zdryZdryzb;//重点人员总表
	ZdryZdrkxxb zdryZdrk;//重点人口 子表
	ZdryJgdxxxb zdryJgdxxxb;//监管对象
	ZdryZszhjsbrxxb zdryZszhjsbrxxb;//肇事肇祸精神病人
	ZdryFzcsfryxxb zdryFzcsfryxxb;//非正常上访
	ZdryShbzdryxxb zdryShbzdryxxb;//涉环保
	ZdrySqsbzdryxxb zdrySqsbzdryxxb;//涉枪涉暴
	ZdrySqjzryxxb zdrySqjzryxxb;//社区矫正
	ZdrySgafzdryxxb zdrySgafzdryxxb;//涉公安访
	ZdryNrsxdxxxb zdryNrsxdxxxb;//纳入视线
	
	String cglxdm;//撤管类型代码
	String ywsqyy;//业务申请原因（流程用）
	String xm;
	String zjhm;
	ZdryZdryzbVO zdryZdryzbVO;
	
	
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
	public ZdryJgdxxxb getZdryJgdxxxb() {
		return zdryJgdxxxb;
	}
	public void setZdryJgdxxxb(ZdryJgdxxxb zdryJgdxxxb) {
		this.zdryJgdxxxb = zdryJgdxxxb;
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
	public ZdryShbzdryxxb getZdryShbzdryxxb() {
		return zdryShbzdryxxb;
	}
	public void setZdryShbzdryxxb(ZdryShbzdryxxb zdryShbzdryxxb) {
		this.zdryShbzdryxxb = zdryShbzdryxxb;
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
	public ZdrySgafzdryxxb getZdrySgafzdryxxb() {
		return zdrySgafzdryxxb;
	}
	public void setZdrySgafzdryxxb(ZdrySgafzdryxxb zdrySgafzdryxxb) {
		this.zdrySgafzdryxxb = zdrySgafzdryxxb;
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
		String xzqh = SystemConfig.getString(AppConst.XZQH)==""?"210000":SystemConfig.getString(AppConst.XZQH);
		if(xzqh.equals("210000")){
			if(zdryZdryzb==null || zdryZdryzb.getZdrygllxdm()==null) return null;
			if("01".equals(zdryZdryzb.getZdrygllxdm()))//社区矫正人员
				return this.zdrySqjzryxxb;
			if("02".equals(zdryZdryzb.getZdrygllxdm()))//重点人口
				return zdryZdrk;
			if("03".equals(zdryZdryzb.getZdrygllxdm()))//肇事肇祸精神病人
				return this.zdryZszhjsbrxxb;
			if("04".equals(zdryZdryzb.getZdrygllxdm()))//非正常上访重点人员
				return this.zdryFzcsfryxxb;
			if("05".equals(zdryZdryzb.getZdrygllxdm()))//涉公安访重点人员
				return this.zdrySgafzdryxxb;
			//if("06".equals(zdryZdryzb.getZdrygllxdm()))//其他关注对象
			//	return this.
			if("07".equals(zdryZdryzb.getZdrygllxdm()))//涉环保重点人员
				return this.zdryShbzdryxxb;
			if("08".equals(zdryZdryzb.getZdrygllxdm()))//涉枪涉爆重点人员
				return this.zdrySqsbzdryxxb;
		}else if(xzqh.equals("210200")){
			/* 01	监管对象(sqjz)
			 * 02	重点人口(zdrk)
			 * 03	其他重点管理对象(zdrk)
			 * 04	肇事肇祸精神病人(zszh)
			 * 05	轻微滋事精神病人(zszh)
			 * 06	非正常上访重点人员(sgaf)
			 * 07	纳入视线对象（无流程）(nrsx)
			 * 08	一般关注对象(不持久 化 )*/
			if(zdryZdryzb==null || zdryZdryzb.getZdrygllxdm()==null) return null;
			if("01".equals(zdryZdryzb.getZdrygllxdm()))//社区矫正人员
				return this.zdrySqjzryxxb;
			if("02".equals(zdryZdryzb.getZdrygllxdm()) || "03".equals(zdryZdryzb.getZdrygllxdm()))//重点人口&其他重点管理对象
				return zdryZdrk;
			if("04".equals(zdryZdryzb.getZdrygllxdm()) || "05".equals(zdryZdryzb.getZdrygllxdm()))//肇事肇祸精神病人 & 轻微滋事精神病人
				return this.zdryZszhjsbrxxb;
			if("06".equals(zdryZdryzb.getZdrygllxdm()))//非正常上访重点人员
					return this.zdryFzcsfryxxb;
			if("07".equals(zdryZdryzb.getZdrygllxdm()))//纳入视线对象
				return this.zdryNrsxdxxxb;
			if("08".equals(zdryZdryzb.getZdrygllxdm()))//一般关注对象
				return null;
		}else{
			
		}
		return null;
	}
	public String getCglxdm() {
		return cglxdm;
	}
	public void setCglxdm(String cglxdm) {
		this.cglxdm = cglxdm;
	}
	public String getYwsqyy() {
		return ywsqyy;
	}
	public void setYwsqyy(String ywsqyy) {
		this.ywsqyy = ywsqyy;
	}
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
	public ZdryZdryzbVO getZdryZdryzbVO() {
		return zdryZdryzbVO;
	}
	public void setZdryZdryzbVO(ZdryZdryzbVO zdryZdryzbVO) {
		this.zdryZdryzbVO = zdryZdryzbVO;
	}
	public String getZdrylbStr() {
		return zdrylbStr;
	}
	public void setZdrylbStr(String zdrylbStr) {
		this.zdrylbStr = zdrylbStr;
	}
	/**
	 * 
	 * @Title: setZdryZb
	 * @Description: (根据重点人员类别代码设置子表对象)
	 * @param @param zdrygllxdm
	 * @param @param zdry    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public void setZdryZb(String zdrygllxdm , Zdry zdry) {
		if("01".equals(zdrygllxdm))//社区矫正人员
			this.zdrySqjzryxxb = (ZdrySqjzryxxb) zdry;
		if("02".equals(zdrygllxdm))//重点人口
			this.zdryZdrk = (ZdryZdrkxxb) zdry;
		if("03".equals(zdrygllxdm))//肇事肇祸精神病人
			this.zdryZszhjsbrxxb = (ZdryZszhjsbrxxb) zdry;
		if("04".equals(zdrygllxdm))//非正常上访重点人员
			this.zdryFzcsfryxxb = (ZdryFzcsfryxxb) zdry;
		if("05".equals(zdrygllxdm))//涉公安访重点人员
			this.zdrySgafzdryxxb = (ZdrySgafzdryxxb) zdry;
		//if("06".equals(zdrygllxdm))//其他关注对象
		//	return this.
		if("07".equals(zdrygllxdm))//涉环保重点人员
			this.zdryShbzdryxxb = (ZdryShbzdryxxb) zdry;
		if("08".equals(zdrygllxdm))//涉枪涉爆重点人员
			this.zdrySqsbzdryxxb = (ZdrySqsbzdryxxb) zdry;
		
	}	
	
	
}
