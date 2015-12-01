package com.founder.sydw_dl.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.UUID;
import com.founder.sydw_dl.bean.Zzyhjzzsbb;
import com.founder.sydw_dl.dao.ZzyhjzzsbbDao;
import com.founder.sydw_dl.service.ZzyhjzzsbbService;

@Service("zzyhjzzsbbService")
@Transactional
public class ZzyhjzzsbbServiceImpl extends BaseService implements ZzyhjzzsbbService  {
	
	@Resource(name = "zzyhjzzsbbDao")
	private ZzyhjzzsbbDao zzyhjzzsbbDao;

	@Override
	public void saveZzyhjzzsbb(Zzyhjzzsbb entity, SessionBean sessionBean) {
		entity.setId(UUID.create());
		setSaveProperties(entity,sessionBean);
		zzyhjzzsbbDao.saveZzyhjzzsbb(entity);
	}

	@Override
	public void updateZzyhjzzsbb(Zzyhjzzsbb entity, SessionBean sessionBean) {
		setUpdateProperties(entity,sessionBean);
		zzyhjzzsbbDao.updateZzyhjzzsbb(entity);
	}

	@Override
	public Zzyhjzzsbb queryZzyhjzzsbbByRyid(Zzyhjzzsbb entity) {
		return zzyhjzzsbbDao.queryZzyhjzzsbbByRyid(entity);
	}

}
