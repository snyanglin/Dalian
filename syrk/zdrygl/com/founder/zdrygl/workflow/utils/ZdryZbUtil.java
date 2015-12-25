package com.founder.zdrygl.workflow.utils;

import com.founder.framework.exception.BussinessException;
import com.founder.syrkgl.bean.RyRyjbxxb;
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
		if(source == null) return;
		target.setHjd_dzid(source.getHjd_dzid());
		target.setHjd_dzxz(source.getHjd_dzxz());
		target.setHjd_mlpdm(source.getHjd_mlpdm());
		target.setHjd_mlpxz(source.getHjd_mlpxz());
		target.setHjd_xzqhdm(source.getHjd_xzqhdm());
	}
}
