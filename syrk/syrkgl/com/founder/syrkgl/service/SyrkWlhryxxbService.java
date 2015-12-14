package com.founder.syrkgl.service;

import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.base.entity.SessionBean;
import com.founder.syrkgl.bean.SyrkWlhryxxb;

@TypeAnnotation("未落户人员信息")
public interface SyrkWlhryxxbService {

	/**
	 * 
	 * @Title: queryById
	 * @Description: TODO(根据id（实有人口ID）查询总表)
	 * @param @param id
	 * @param @return    设定文件
	 * @return SyrkWlhryxxb    返回类型
	 * @throws
	 */
	public SyrkWlhryxxb queryById(String id);
	
	public void save(SyrkWlhryxxb entity,SessionBean sessionBean);
	
	public void update(SyrkWlhryxxb entity,SessionBean sessionBean);
	
	public void delete(SyrkWlhryxxb entity,SessionBean sessionBean);
}
