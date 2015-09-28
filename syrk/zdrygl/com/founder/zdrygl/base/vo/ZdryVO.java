package com.founder.zdrygl.base.vo;

import java.io.Serializable;

import com.founder.zdrygl.base.model.ZdryFzcsfryxxb;
import com.founder.zdrygl.base.model.ZdryJgdxxxb;
import com.founder.zdrygl.base.model.ZdrySgafzdryxxb;
import com.founder.zdrygl.base.model.ZdryShbzdryxxb;
import com.founder.zdrygl.base.model.ZdrySqjzryxxb;
import com.founder.zdrygl.base.model.ZdrySqsbzdryxxb;
import com.founder.zdrygl.base.model.ZdryZdrkxxb;
import com.founder.zdrygl.base.model.ZdryZb;
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
	
	ZdryZb zdryZdryzb;//重点人员总表
	ZdryZdrkxxb zdryZdrk;//重点人口 子表
	ZdryJgdxxxb zdryJgdxxxb;//监管对象
	ZdryZszhjsbrxxb zdryZszhjsbrxxb;//肇事肇祸精神病人
	ZdryFzcsfryxxb zdryFzcsfryxxb;//非正常上访
	ZdryShbzdryxxb zdryShbzdryxxb;//涉环保
	ZdrySqsbzdryxxb zdrySqsbzdryxxb;//涉枪涉暴
	ZdrySqjzryxxb zdrySqjzryxxb;//社区矫正
	ZdrySgafzdryxxb zdrySgafzdryxxb;//涉公安访
	
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
		if(zdryZdryzb==null || zdryZdryzb.getZdrygllxdm()==null) return null;
		if("02".equals(zdryZdryzb.getZdrygllxdm()))//重点人口
			return zdryZdrk;
		return null;
	}		
			
}
