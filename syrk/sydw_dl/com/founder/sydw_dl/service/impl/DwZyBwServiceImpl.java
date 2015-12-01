package com.founder.sydw_dl.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.UUID;
import com.founder.sydw_dl.bean.DwzybwXxb;
import com.founder.sydw_dl.dao.DwZyBwDao;
import com.founder.sydw_dl.dao.DwjbxxbDao;
import com.founder.sydw_dl.service.DwZyBwService;
@Service("dwzybwService")
@Transactional
public class DwZyBwServiceImpl extends BaseService implements DwZyBwService {

	@Resource(name = "dwzybwDao")
	private DwZyBwDao dwzybwDao;
	
	@Resource(name = "dwjbxxbDao")
	private DwjbxxbDao dwjbxxbDao;
	
	@Override
	public void save(DwzybwXxb entity, SessionBean sessionBean) {
		entity.setId(UUID.create());
		BaseService.setSaveProperties(entity, sessionBean);
		dwzybwDao.save(entity);
	}

	@Override
	public DwzybwXxb queryZybw(DwzybwXxb entity, SessionBean sessionBean) {
		return dwzybwDao.queryZybw(entity);
	}

	@Override
	public void update(DwzybwXxb entity, SessionBean sessionBean) {
		BaseService.setUpdateProperties(entity, sessionBean);
		dwzybwDao.update(entity);
	}
	@Override
	public boolean queryLxfsValid(String lxdh, String dwid) {
		return dwjbxxbDao.queryLxfsValid(lxdh, dwid);
	}

}
