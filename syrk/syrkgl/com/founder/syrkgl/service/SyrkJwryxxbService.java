package com.founder.syrkgl.service;

import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.base.entity.SessionBean;
import com.founder.syrkgl.bean.SyrkJwryxxb;

@TypeAnnotation("境外人员信息")
public interface SyrkJwryxxbService {

	/**
	 * 
	 * @Title: queryById
	 * @Description: TODO(根据id（实有人口ID）查询总表)
	 * @param @param id
	 * @param @return    设定文件
	 * @return SyrkJwryxxb    返回类型
	 * @throws
	 */
	public SyrkJwryxxb queryById(String id);
	
	public void save(SyrkJwryxxb entity,SessionBean sessionBean);
	
	public void update(SyrkJwryxxb entity,SessionBean sessionBean);
	
	public void delete(SyrkJwryxxb entity,SessionBean sessionBean);
}
