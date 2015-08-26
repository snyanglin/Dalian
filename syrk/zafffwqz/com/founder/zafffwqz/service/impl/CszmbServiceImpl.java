package com.founder.zafffwqz.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.UUID;
import com.founder.zafffwqz.bean.Cszmb;
import com.founder.zafffwqz.dao.CszmbDao;
import com.founder.zafffwqz.service.CszmbService;

@Service("cszmbService")
@Transactional
public class CszmbServiceImpl extends BaseService implements CszmbService {
	
	@Resource(name = "cszmbDao")
	private CszmbDao cszmbDao;

	@Override
	public Cszmb queryCszmb(Cszmb entity) {
		return cszmbDao.queryCszmb(entity);
	}

	@Override
	public void saveCszmb(Cszmb entity, SessionBean sessionBean) {
		entity.setId(UUID.create());
		setSaveProperties(entity, sessionBean);
		cszmbDao.saveCszmb(entity);
		
	}

	@Override
	public void updateCszmb(Cszmb entity, SessionBean sessionBean) {
		setUpdateProperties(entity, sessionBean);
		cszmbDao.updateCszmb(entity);
		
	}

	@Override
	public EasyUIPage queryList(EasyUIPage page,Map map) {
		return cszmbDao.queryList(page, map);
	}

	@Override
	public void delete(Cszmb entity, SessionBean sessionBean) {
		setUpdateProperties(entity, sessionBean);
		cszmbDao.delete(entity);
		
	}

	@Override
	public List<Cszmb> queryRyCs(String zjhm) {
		return cszmbDao.queryRyCs(zjhm);
	}
}
