package com.founder.zafffwqz.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.UUID;
import com.founder.syrkgl.service.RyRylxfsxxbService;
import com.founder.zafffwqz.bean.Sqmjxxb;
import com.founder.zafffwqz.dao.SqmjxxbDao;
import com.founder.zafffwqz.service.SqmjxxbService;

@Service("sqmjxxbService")
@Transactional
public class SqmjxxbServiceImpl extends BaseService implements SqmjxxbService {

	@Resource(name = "sqmjxxbDao")
	private SqmjxxbDao sqmjxxbDao;
	@Resource(name="ryRylxfsxxbService")
	private RyRylxfsxxbService ryRylxfsxxbService;
	@Override
	public Sqmjxxb querySqmjxxb(Sqmjxxb entity) {
		return sqmjxxbDao.querySqmjxxb(entity);
	}

	@Override
	public void saveSqmjxxb(Sqmjxxb entity, SessionBean sessionBean) {
		entity.setId(UUID.create());
		setSaveProperties(entity,sessionBean);
		sqmjxxbDao.saveSqmjxxb(entity);
		this.ryRylxfsxxbService.saveLxdh(entity.getRyid(), entity.getLxdh(), sessionBean);

	}

	@Override
	public void updateSqmjxxb(Sqmjxxb entity, SessionBean sessionBean) {
		setSaveProperties(entity,sessionBean);
		sqmjxxbDao.updateSqmjxxb(entity);
		this.ryRylxfsxxbService.saveLxdh(entity.getRyid(), entity.getLxdh(), sessionBean);

	}
	

}
