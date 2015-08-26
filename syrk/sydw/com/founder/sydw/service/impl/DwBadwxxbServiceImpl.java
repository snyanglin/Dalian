package com.founder.sydw.service.impl;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.UUID;
import com.founder.sydw.bean.Dwbadwxxb;
import com.founder.sydw.dao.DwBadwxxbDao;
import com.founder.sydw.service.DwBadwxxbService;
@Service("dwBadwxxbService")
@Transactional
public class DwBadwxxbServiceImpl extends BaseService implements DwBadwxxbService {
	@Resource(name = "dwBadwxxbDao")
	private DwBadwxxbDao dwBadwxxbDao;
	@Override
	public Dwbadwxxb queryBadwxxbByid(Dwbadwxxb entity) {
		return dwBadwxxbDao.queryBadwxxbByid(entity);
	}
	@Override
	public void saveBadwxxb(Dwbadwxxb entity, SessionBean sessionBean) {
		entity.setId(UUID.create());
		setSaveProperties(entity,sessionBean);
		dwBadwxxbDao.saveBadwxxb(entity);
	}
	@Override
	public void updateBadwxxb(Dwbadwxxb entity, SessionBean sessionBean) {
		setUpdateProperties(entity,sessionBean);
		dwBadwxxbDao.updateBadwxxb(entity);
	}
	

}
