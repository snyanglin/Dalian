package com.founder.sydw.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.UUID;
import com.founder.sydw.bean.Yyssxxb;
import com.founder.sydw.dao.YyssxxbDao;
import com.founder.sydw.service.YyssxxbService;
@Service("yyssxxbService")
@Transactional
public class YyssxxbServiceImpl extends BaseService implements YyssxxbService {
	@Resource(name = "yyssxxbDao")
	private YyssxxbDao yyssxxbDao;
	@Override
	public Yyssxxb queryEntityById(Yyssxxb entity) {
		return yyssxxbDao.queryEntityById(entity);
	}
	@Override
	public void saveEntity(Yyssxxb entity, SessionBean sessionBean) {
		entity.setId(UUID.create());
		setSaveProperties(entity,sessionBean);
		yyssxxbDao.saveEntity(entity);
	}
	@Override
	public void updateEntity(Yyssxxb entity, SessionBean sessionBean) {
		setUpdateProperties(entity,sessionBean);
		yyssxxbDao.updateEntity(entity);
	}
	
}
