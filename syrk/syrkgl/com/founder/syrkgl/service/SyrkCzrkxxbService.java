package com.founder.syrkgl.service;

import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.base.entity.SessionBean;
import com.founder.syrkgl.bean.SyrkCzrkxxb;
/**
 * ****************************************************************************
 * @Package:      [com.founder.syrkgl.service.SyrkCzrkxxbService.java]  
 * @ClassName:    [SyrkCzrkxxbService]   
 * @Description:  [常住人口业务接口]   
 * @Author:       [weiwen]  
 * @CreateDate:   [2015-4-3 下午4:51:16]   
 * @UpdateUser:   [weiwen]   
 * @UpdateDate:   [2015-4-3 下午4:51:16，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@TypeAnnotation("常住人口信息")
public interface SyrkCzrkxxbService {

	/**
	 * 
	 * @Title: queryById
	 * @Description: TODO(根据id（实有人口ID）查询总表)
	 * @param @param id
	 * @param @return    设定文件
	 * @return SyrkSyrkxxzb    返回类型
	 * @throws
	 */
	public SyrkCzrkxxb queryById(String id);
	
	/**
	 * 
	 * @Title: save
	 * @Description: TODO(保存常住人口表，更新总表相关字段与基本表相关字段)
	 * @param @param entity
	 * @param @param sessionBean    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public void save(SyrkCzrkxxb entity,SessionBean sessionBean);
	
	public void update(SyrkCzrkxxb entity,SessionBean sessionBean);
	
	public void delete(SyrkCzrkxxb entity,SessionBean sessionBean);
}
