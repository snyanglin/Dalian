package com.founder.shhxxcj.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.EasyUIPage;
import com.founder.shhxxcj.bean.EmEnterpriseFrfzrxxb;
import com.founder.shhxxcj.dao.EmEnterpriseFrfzrxxbDao;
import com.founder.shhxxcj.service.EmEnterpriseFrfzrxxbService;
@Service
public class EmEnterpriseFrfzrxxbServiceImpl implements
		EmEnterpriseFrfzrxxbService {

	@Resource
	private EmEnterpriseFrfzrxxbDao emEnterpriseFrfzrxxbDao;
	
	@Override
	public EasyUIPage queryList(EmEnterpriseFrfzrxxb entity, EasyUIPage page,
			SessionBean sessionBean) {
		return this.emEnterpriseFrfzrxxbDao.queryList(entity, page);
	}

	

}
