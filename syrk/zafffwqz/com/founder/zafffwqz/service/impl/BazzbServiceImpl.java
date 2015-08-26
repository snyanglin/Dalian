package com.founder.zafffwqz.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.UUID;
import com.founder.syrkgl.service.RyRylxfsxxbService;
import com.founder.zafffwqz.bean.Bazzb;
import com.founder.zafffwqz.dao.BazzbDao;
import com.founder.zafffwqz.service.BazzbService;


@Service("bazzbService")
@Transactional
public class BazzbServiceImpl extends BaseService implements BazzbService {

	@Resource(name = "bazzbDao")
	private BazzbDao bazzbDao;
	@Resource(name = "ryRylxfsxxbService")
	private RyRylxfsxxbService ryRylxfsxxbService;
		
	@Override
	public Bazzb queryBazzb(Bazzb entity) {
		return bazzbDao.queryBazzb(entity);
	}

	@Override
	public void saveBazzb(Bazzb entity, SessionBean sessionBean) {
		entity.setId(UUID.create());
		setSaveProperties(entity,sessionBean);
		bazzbDao.saveBazzb(entity);
		ryRylxfsxxbService.saveLxdh(entity.getRyid(), entity.getFzrlxfs(), sessionBean);
	}

	@Override
	public void updateBazzb(Bazzb entity, SessionBean sessionBean) {
		setSaveProperties(entity,sessionBean);
		bazzbDao.updateBazzb(entity);
		ryRylxfsxxbService.saveLxdh(entity.getRyid(), entity.getFzrlxfs(), sessionBean);
	}
	
	
}
