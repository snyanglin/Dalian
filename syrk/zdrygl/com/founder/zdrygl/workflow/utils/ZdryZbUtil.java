package com.founder.zdrygl.workflow.utils;

import com.founder.framework.components.AppConst;
import com.founder.framework.config.SystemConfig;
import com.founder.framework.exception.BussinessException;
import com.founder.syrkgl.bean.RyRyjbxxb;
import com.founder.syrkgl.bean.SyrkSyrkxxzb;
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
import com.founder.zdrygl.base.model.Zdrycx;
import com.founder.zdrygl.core.model.Zdry;

public class ZdryZbUtil {
	/**
	 * 
	 * @Title: setXtZxyy
	 * @Description: (转化对应的字表对象，设置注销原因)
	 * @param @param zdry
	 * @param @param xtZxyy    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public static void setXtZxyy(Zdry zdry,String xtZxyy){

		if(zdry==null){
			return;
		}
		if( zdry instanceof ZdryFzcsfryxxb){
			((ZdryFzcsfryxxb)zdry).setXt_zxyy(xtZxyy);
		}else
		if( zdry instanceof ZdrySgafzdryxxb){
			((ZdrySgafzdryxxb)zdry).setXt_zxyy(xtZxyy);
		}else
		if( zdry instanceof ZdryJgdxxxb){
			((ZdryJgdxxxb)zdry).setXt_zxyy(xtZxyy);
		}else
		if( zdry instanceof ZdryShbzdryxxb){
			((ZdryShbzdryxxb)zdry).setXt_zxyy(xtZxyy);
		}else
		if( zdry instanceof ZdrySqjzryxxb){
			((ZdrySqjzryxxb)zdry).setXt_zxyy(xtZxyy);
		}else
		if( zdry instanceof ZdrySqsbzdryxxb){
			((ZdrySqsbzdryxxb)zdry).setXt_zxyy(xtZxyy);
		}else
		if( zdry instanceof ZdryZdrkxxb){
			((ZdryZdrkxxb)zdry).setXt_zxyy(xtZxyy);
		}else
		if( zdry instanceof ZdryZszhjsbrxxb){
			((ZdryZszhjsbrxxb)zdry).setXt_zxyy(xtZxyy);
		}else
		//ZdryNrsxdxxxb
		if( zdry instanceof ZdryNrsxdxxxb){
			((ZdryNrsxdxxxb)zdry).setXt_zxyy(xtZxyy);
		}else{
			throw new BussinessException("未找到对应的字表!");
		}
	}
	
	/**
	 * 
	 * @Title: copyAttributes
	 * @Description: (Copy attributes from source to target)
	 * @param @param source
	 * @param @param target    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public static void copyAttributes(ZdryZb source, ZdryZb target){
		if(source==null || source.getHjd_mlpdm()== null) return;
		//set foreign key
		target.setRyid(source.getRyid());
		target.setSyrkid(source.getSyrkid());
		
		target.setXbdm(source.getXbdm());
		target.setMzdm(source.getMzdm());
		target.setCsrq(source.getCsrq());
		
		target.setJgssxdm(source.getJgssxdm());
		target.setHjd_dzid(source.getHjd_dzid());
		target.setHjd_dzxz(source.getHjd_dzxz());
		target.setHjd_mlpdm(source.getHjd_mlpdm());
		target.setHjd_mlpxz(source.getHjd_mlpxz());
		target.setHjd_xzqhdm(source.getHjd_xzqhdm());
		
		
	}
	/**
	 * 
	 * @Title: copyAttributes
	 * @Description: (Copy hjd* attributes from source to target)
	 * @param @param source
	 * @param @param target    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public static void copyAttributes(RyRyjbxxb source, ZdryZb target) {
		if(source==null || source.getHjd_mlpdm()== null) return;
		target.setHjd_dzid(source.getHjd_dzid());
		target.setHjd_dzxz(source.getHjd_dzxz());
		target.setHjd_mlpdm(source.getHjd_mlpdm());
		target.setHjd_mlpxz(source.getHjd_mlpxz());
		target.setHjd_xzqhdm(source.getHjd_xzqhdm());
	}
	/**
	 * 
	 * @Title: copyAttributes
	 * @Description: (这里用一句话描述这个方法的作用)
	 * @param @param source
	 * @param @param target    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public static void copyAttributes(SyrkSyrkxxzb source, ZdryZb target) {
		if(source==null || source.getHjd_mlpdm()== null) return;
		target.setHjd_dzid(source.getHjd_dzid());
		target.setHjd_dzxz(source.getHjd_dzxz());
		target.setHjd_mlpdm(source.getHjd_mlpdm());
		target.setHjd_mlpxz(source.getHjd_mlpxz());
		target.setHjd_xzqhdm(source.getHjd_xzqhdm());
	}
	/**
	 * 
	 * @Title: getZdrylbdx
	 * @Description: TODO(返回当前重点人员类型的子表对象)
	 * @param @return    设定文件
	 * @return Zdry    返回类型
	 * @throw
	 */
	public static Zdry getZdrylbdx(Zdrycx zdryZdryzb){
		if(zdryZdryzb==null || zdryZdryzb.getZdrygllxdm()==null) return null;
		if("210000".equals(SystemConfig.getString(AppConst.XZQH))){//辽宁
			if("01".equals(zdryZdryzb.getZdrygllxdm_old()))//社区矫正人员
				return new ZdrySqjzryxxb();
			if("02".equals(zdryZdryzb.getZdrygllxdm_old()))//重点人口
				return new ZdryZdrkxxb();
			if("03".equals(zdryZdryzb.getZdrygllxdm_old()))//肇事肇祸精神病人
				return new ZdryZszhjsbrxxb();
			if("04".equals(zdryZdryzb.getZdrygllxdm_old()))//非正常上访重点人员
				return new ZdryFzcsfryxxb();
			if("05".equals(zdryZdryzb.getZdrygllxdm_old()))//涉公安访重点人员
				return new ZdrySgafzdryxxb();
			//if("06".equals(zdryZdryzb.getZdrygllxdm_old()))//其他关注对象
			//	return this.
			if("07".equals(zdryZdryzb.getZdrygllxdm_old()))//涉环保重点人员
				return new ZdryShbzdryxxb();
			if("08".equals(zdryZdryzb.getZdrygllxdm_old()))//涉枪涉爆重点人员
				return new ZdrySqsbzdryxxb();
		}else{
			if("01".equals(zdryZdryzb.getZdrygllxdm_old())){//监管对象
				return new ZdryJgdxxxb();
			}
			
			if("02".equals(zdryZdryzb.getZdrygllxdm_old()))//重点人口
				return new ZdryZdrkxxb();
			if("03".equals(zdryZdryzb.getZdrygllxdm_old())){//其它重点管理对象
				return new ZdryZdrkxxb();
			}
				
			if("04".equals(zdryZdryzb.getZdrygllxdm_old())){//肇事肇祸精神病人
				return new ZdryZszhjsbrxxb();
			}
				
			if("05".equals(zdryZdryzb.getZdrygllxdm_old())){//肇事肇祸精神病人
				return new ZdryZszhjsbrxxb();
			}
			if("06".equals(zdryZdryzb.getZdrygllxdm_old())){//非正常上访重点人员
				return new ZdryFzcsfryxxb();
			}
			if("07".equals(zdryZdryzb.getZdrygllxdm_old())){//纳入实现对象
				return new ZdryNrsxdxxxb();
			}
		}
		
		return null;
	}
}
