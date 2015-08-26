package com.founder.sydw.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.UUID;
import com.founder.sydw.bean.Yhxxb;
import com.founder.sydw.dao.YhxxbDao;
import com.founder.sydw.service.YhxxbService;

@Service("yhxxbService")
@Transactional
public class YhxxbServiceImpl extends BaseService implements YhxxbService  {
	
	@Resource(name = "yhxxbDao")
	private YhxxbDao yhxxbDao;

	@Override
	public void save(Yhxxb entity, SessionBean sessionBean) {
		entity.setId(UUID.create());
		setSaveProperties(entity,sessionBean);
		yhxxbDao.save(entity);
	}

	@Override
	public void update(Yhxxb entity, SessionBean sessionBean) {
		setUpdateProperties(entity,sessionBean);
		yhxxbDao.update(entity);
	}

	@Override
	public Yhxxb queryYhxxbById(Yhxxb entity) {
		return yhxxbDao.queryYhxxbById(entity);
	}

}
