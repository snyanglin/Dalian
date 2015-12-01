package com.founder.shhxxcj.service;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.EasyUIPage;
import com.founder.shhxxcj.bean.EmEnterpriseFrfzrxxb;

public interface EmEnterpriseFrfzrxxbService {

	
	/**
	 * @Title: queryList
	 * @Description: 查询列表
	 * @param @param entity
	 * @param @param page
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	public EasyUIPage queryList(EmEnterpriseFrfzrxxb entity, EasyUIPage page,SessionBean sessionBean);

	
	
}
