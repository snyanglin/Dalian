package com.founder.sydw.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.UUID;
import com.founder.sydw.bean.Ddxxb;
import com.founder.sydw.dao.DdxxbDao;
import com.founder.sydw.service.DdxxbService;

@Service("ddxxbService")
@Transactional
public class DdxxbServiceImpl extends BaseService implements DdxxbService {
	
	@Resource(name = "ddxxbDao")
	private DdxxbDao ddxxbDao;

	@Override
	public Ddxxb queryDdxxb(Ddxxb entity) {
		return ddxxbDao.queryDdxxbById(entity);
	}

	@Override
	public void saveDdxxb(Ddxxb entity, SessionBean sessionBean) {
		entity.setId(UUID.create());
		setSaveProperties(entity, sessionBean);
		ddxxbDao.insertDdxxb(entity);
	}

	@Override
	public int updateDdxxb(Ddxxb entity, SessionBean sessionBean) {
		setUpdateProperties(entity, sessionBean);
		return ddxxbDao.updateDdxxb(entity);
	}

}
