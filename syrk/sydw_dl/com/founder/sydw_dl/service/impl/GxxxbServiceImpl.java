package com.founder.sydw_dl.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.UUID;
import com.founder.sydw_dl.bean.Gxxxb;
import com.founder.sydw_dl.dao.GxxxbDao;
import com.founder.sydw_dl.service.GxxxbService;

@Service("gxxxbService")
@Transactional
public class GxxxbServiceImpl extends BaseService implements GxxxbService  {
	
	@Resource(name = "gxxxbDao")
	private GxxxbDao gxxxbDao;

	@Override
	public void saveGxxxb(Gxxxb entity, SessionBean sessionBean) {
		entity.setId(UUID.create());
		setSaveProperties(entity,sessionBean);
		gxxxbDao.saveGxxxb(entity);
	}

	@Override
	public void updateGxxxb(Gxxxb entity, SessionBean sessionBean) {
		setUpdateProperties(entity,sessionBean);
		gxxxbDao.updateGxxxb(entity);
	}

	@Override
	public Gxxxb queryGxxxbByRyid(Gxxxb entity) {
		return gxxxbDao.queryGxxxbByRyid(entity);
	}

}
