package com.founder.sydw.service.impl;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.UUID;
import com.founder.sydw.bean.Dwjfdwxxb;
import com.founder.sydw.dao.DwJfdwxxbDao;
import com.founder.sydw.service.DwJfdwxxbService;
@Service("dwJfdwxxbService")
@Transactional
public class DwJfdwxxbServiceImpl extends BaseService implements DwJfdwxxbService {
	@Resource(name = "dwJfdwxxbDao")
	private DwJfdwxxbDao dwJfdwxxbDao;
	@Override
	public Dwjfdwxxb queryJfdwxxbByid(Dwjfdwxxb entity) {
		return dwJfdwxxbDao.queryJfdwxxbByid(entity);
	}
	@Override
	public void saveJfdwxxb(Dwjfdwxxb entity, SessionBean sessionBean) {
		entity.setId(UUID.create());
		setSaveProperties(entity,sessionBean);
		dwJfdwxxbDao.saveJfdwxxb(entity);
	}
	@Override
	public void updateJfdwxxb(Dwjfdwxxb entity, SessionBean sessionBean) {
		setUpdateProperties(entity,sessionBean);
		dwJfdwxxbDao.updateJfdwxxb(entity);
	}
	

}
