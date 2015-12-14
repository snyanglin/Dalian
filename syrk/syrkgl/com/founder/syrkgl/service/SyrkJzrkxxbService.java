package com.founder.syrkgl.service;

import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.base.entity.SessionBean;
import com.founder.syrkgl.bean.SyrkJzrkxxb;

@TypeAnnotation("寄住人口信息")
public interface SyrkJzrkxxbService {

	/**
	 * 
	 * @Title: queryById
	 * @Description: TODO(根据id（实有人口ID）查询总表)
	 * @param @param id
	 * @param @return    设定文件
	 * @return SyrkJzrkxxb    返回类型
	 * @throws
	 */
	public SyrkJzrkxxb queryById(String id);
	
	public void save(SyrkJzrkxxb entity,SessionBean sessionBean);
	
	public void update(SyrkJzrkxxb entity,SessionBean sessionBean);
	
	public void delete(SyrkJzrkxxb entity,SessionBean sessionBean);
}
