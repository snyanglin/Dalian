package com.founder.zafffwqz.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.UUID;
import com.founder.zafffwqz.bean.Sqzdbwb;
import com.founder.zafffwqz.dao.SqzdbwbDao;
import com.founder.zafffwqz.service.SqzdbwbService;

@Service("sqzdbwbService")
@Transactional
public class SqzdbwbServiceImpl extends BaseService implements SqzdbwbService {
	
	@Resource(name = "sqzdbwbDao")
	private SqzdbwbDao sqzdbwbDao;

	@Override
	public Sqzdbwb querySqzdbwb(Sqzdbwb entity) {
		return sqzdbwbDao.querySqzdbwbById(entity);
	}

	@Override
	public void saveSqzdbwb(Sqzdbwb entity, SessionBean sessionBean) {
		entity.setId(UUID.create());
		setSaveProperties(entity, sessionBean);
		sqzdbwbDao.insertSqzdbwb(entity);
	}

	@Override
	public int updateSqzdbwb(Sqzdbwb entity, SessionBean sessionBean) {
		setUpdateProperties(entity, sessionBean);
		return sqzdbwbDao.updateSqzdbwb(entity);
	}

}
