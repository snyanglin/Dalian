package com.founder.sydw.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.framework.utils.UUID;
import com.founder.sydw.bean.Dwjbxxb;
import com.founder.sydw.bean.Dwxqxxb;
import com.founder.sydw.dao.DwXqjbxxbDao;
import com.founder.sydw.service.DwXqjbxxbService;

@Service("dwXqjbxxbService")
@Transactional
public class DwXqjbxxbServiceImpl extends BaseService implements
		 DwXqjbxxbService{
	
	@Resource(name = "dwXqjbxxbdao")
	private DwXqjbxxbDao dwXqjbxxbDao;
	
	@Override
	public EasyUIPage queryDwXq(EasyUIPage page, Dwxqxxb entity) {
		return dwXqjbxxbDao.queryDwXq(page, entity);
	}

	@Override
	public long queryCountDwXq(Dwxqxxb entity) {
		return dwXqjbxxbDao.queryCountDwXq(entity);
	}
	
	@Override
	public Dwxqxxb query(String id) {
		return dwXqjbxxbDao.queryEntityById(id);
	}
	
	@Override
	public void save(Dwxqxxb entity, SessionBean sessionBean) {
		entity.setId(UUID.create());
		setSaveProperties(entity,sessionBean);
		dwXqjbxxbDao.dwxqsave(entity);
	}
	
	@Override
	public void update(Dwxqxxb entity, SessionBean sessionBean) {
		setUpdateProperties(entity,sessionBean);
		dwXqjbxxbDao.dwxqupdate(entity);

	}
	
	@Override
	public int dwxqzx(Dwxqxxb entity, SessionBean sessionBean) {
		BaseService.setUpdateProperties(entity, sessionBean);
		int first=dwXqjbxxbDao.dwxqzx(entity);
		return first;
	}
	
}
