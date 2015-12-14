package com.founder.syrkgl.service;

import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.base.entity.SessionBean;
import com.founder.syrkgl.bean.SyrkLdrkxxb;

@TypeAnnotation("流动人口信息")
public interface SyrkLdrkxxbService {

	/**
	 * 
	 * @Title: queryById
	 * @Description: TODO(根据id（实有人口ID）查询总表)
	 * @param @param id
	 * @param @return    设定文件
	 * @return SyrkLdrkxxb    返回类型
	 * @throws
	 */
	public SyrkLdrkxxb queryById(String id);
	
	public void save(SyrkLdrkxxb entity,SessionBean sessionBean);
	
	public void update(SyrkLdrkxxb entity,SessionBean sessionBean);
	
	public void delete(SyrkLdrkxxb entity,SessionBean sessionBean);
}
