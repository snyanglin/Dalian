package com.founder.sydw_dl.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.UUID;
import com.founder.sydw_dl.bean.Dwyhflcxxb;
import com.founder.sydw_dl.dao.DwjbxxbDao;
import com.founder.sydw_dl.dao.DwyhflcDao;
import com.founder.sydw_dl.service.DwyhflcxxbService;
@Service("dwyhflcxxbService")
@Transactional
public class DwyhflcxxbServiceImpl implements DwyhflcxxbService {
	@Resource(name = "dwyhflcDao")
	private DwyhflcDao dwyhflcDao;
	
	@Resource(name = "dwjbxxbDao")
	private DwjbxxbDao dwjbxxbDao;
	
	@Override
	public void save(Dwyhflcxxb entity, SessionBean sessionBean) {
		entity.setId(UUID.create());
		BaseService.setSaveProperties(entity, sessionBean);
		dwyhflcDao.save(entity, sessionBean);
		Boolean a = queryLxfsValid(entity.getFzrlxdh(), entity.getDwid());

	}

	@Override
	public Dwyhflcxxb query(Dwyhflcxxb entity) {
		return dwyhflcDao.query(entity.getId());
	}

	@Override
	public void update(Dwyhflcxxb entity, SessionBean sessionBean) {
		BaseService.setUpdateProperties(entity, sessionBean);
		dwyhflcDao.update(entity, sessionBean);
	}

	@Override
	public boolean queryLxfsValid(String lxdh, String dwid) {
		return dwjbxxbDao.queryLxfsValid(lxdh, dwid);
	}

}
