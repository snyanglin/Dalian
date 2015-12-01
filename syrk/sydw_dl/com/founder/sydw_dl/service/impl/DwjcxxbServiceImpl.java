package com.founder.sydw_dl.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.UUID;
import com.founder.sydw_dl.bean.Dwjcxxb;
import com.founder.sydw_dl.dao.DwjcxxbDao;
import com.founder.sydw_dl.service.DwjcxxbService;
@Service("dwjcxxbService")
@Transactional
public class DwjcxxbServiceImpl implements DwjcxxbService {
	@Resource(name = "dwjcxxbDao")
	private DwjcxxbDao dwjcxxbDao;
	@Override
	public void save(Dwjcxxb entity, SessionBean sessionBean) {
		entity.setId(UUID.create());
		BaseService.setSaveProperties(entity, sessionBean);
		dwjcxxbDao.save(entity, sessionBean);
	}

	@Override
	public Dwjcxxb query(Dwjcxxb entity) {
		return dwjcxxbDao.query(entity.getId());
	}

	@Override
	public void update(Dwjcxxb entity, SessionBean sessionBean) {
		BaseService.setUpdateProperties(entity, sessionBean);
		dwjcxxbDao.update(entity, sessionBean);
	}

}
