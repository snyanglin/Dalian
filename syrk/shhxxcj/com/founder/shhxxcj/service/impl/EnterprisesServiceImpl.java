package com.founder.shhxxcj.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.founder.shhxxcj.bean.Enterprises;
import com.founder.shhxxcj.dao.EnterprisesDao;
import com.founder.shhxxcj.service.EnterprisesService;

@Service
public class EnterprisesServiceImpl implements EnterprisesService {


	@Resource
	private EnterprisesDao enterprisesDao;

	
	@Override
	public Enterprises queryById(String id) {
		
		return enterprisesDao.queryById(id);
	}

}
