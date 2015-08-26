package com.founder.zafffwqz.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.UUID;
import com.founder.syrkgl.service.RyRylxfsxxbService;
import com.founder.zafffwqz.bean.Sqzbhb;
import com.founder.zafffwqz.dao.SqzbhbDao;
import com.founder.zafffwqz.service.SqzbhbService;

@Service("sqzbhbService")
@Transactional
public class SqzbhbServiceImpl extends BaseService implements SqzbhbService {

	@Resource(name = "sqzbhbDao")
	private SqzbhbDao sqzbhbDao;
	@Resource(name = "ryRylxfsxxbService")
	private RyRylxfsxxbService ryRylxfsxxbService;
	@Override
	public Sqzbhb querySqzbhb(Sqzbhb entity) {
		return sqzbhbDao.querySqzbhb(entity);
	}

	@Override
	public void saveSqzbhb(Sqzbhb entity, SessionBean sessionBean) {
		entity.setId(UUID.create());
		setSaveProperties(entity,sessionBean);
		sqzbhbDao.saveSqzbhb(entity);
		this.ryRylxfsxxbService.saveLxdh(entity.getRyid(), entity.getFzrlxfs(), sessionBean);

	}

	@Override
	public void updateSqzbhb(Sqzbhb entity, SessionBean sessionBean) {
		setSaveProperties(entity,sessionBean);
		sqzbhbDao.updateSqzbhb(entity);
		this.ryRylxfsxxbService.saveLxdh(entity.getRyid(), entity.getFzrlxfs(), sessionBean);

	}
}
