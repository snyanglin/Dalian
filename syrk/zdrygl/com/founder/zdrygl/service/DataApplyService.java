package com.founder.zdrygl.service;

import com.founder.framework.annotation.TypeAnnotation;
import com.founder.syrkgl.bean.RyRyjbxxb;
import com.founder.syrkgl.bean.SyrkSyrkxxzb;

/**
 * ****************************************************************************
 * @Package:      [com.founder.zdrygl.service.DataApplyService.java]  
 * @ClassName:    [DataApplyService]   
 * @Description:  [信息复用服务]   
 * @Author:       [zhang.hai@founder.com.cn]  
 * @CreateDate:   [2015年9月22日 上午10:24:37]   
 * @UpdateUser:   [ZhangHai(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015年9月22日 上午10:24:37，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@TypeAnnotation("信息复用服务")
public interface DataApplyService {

	/**
	 * 
	 * @Title: ryjbxxApply
	 * @Description: TODO(人员基本信息查询)
	 * @param @param cyzjdm 证件类型
	 * @param @param zjhm 证件号码
	 * @param @return    设定文件
	 * @return RyRyjbxxb    返回类型
	 * @throw
	 */
	public RyRyjbxxb ryjbxxApply(String cyzjdm,String zjhm);
	
	/**
	 * 
	 * @Title: syrkApply
	 * @Description: TODO(实有人口查询)
	 * @param @param cyzjdm 证件类型
	 * @param @param zjhm 证件号码
	 * @param @return    设定文件
	 * @return SyrkSyrkxxzb    返回类型
	 * @throw
	 */
	public SyrkSyrkxxzb syrkApply(String cyzjdm,String zjhm);
	
}
