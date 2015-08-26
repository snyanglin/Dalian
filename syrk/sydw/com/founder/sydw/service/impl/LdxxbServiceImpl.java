package com.founder.sydw.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.UUID;
import com.founder.sydw.bean.Ldxxb;
import com.founder.sydw.dao.LdxxbDao;
import com.founder.sydw.service.LdxxbService;

@Service("ldxxbService")
@Transactional
public class LdxxbServiceImpl extends BaseService implements LdxxbService {
	
	@Resource(name = "ldxxbDao")
	private LdxxbDao ldxxbDao;

	@Override
	public Ldxxb queryLdxxb(Ldxxb entity) {
		return ldxxbDao.queryLdxxbById(entity);
	}

	@Override
	public void saveLdxxb(Ldxxb entity, SessionBean sessionBean) {
		entity.setId(UUID.create());
		setSaveProperties(entity, sessionBean);
		ldxxbDao.insertLdxxb(entity);
	}

	@Override
	public int updateLdxxb(Ldxxb entity, SessionBean sessionBean) {
		setUpdateProperties(entity, sessionBean);
		return ldxxbDao.updateLdxxb(entity);
	}

}
