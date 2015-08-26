package com.founder.zafffwqz.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.UUID;
import com.founder.syrkgl.service.RyRylxfsxxbService;
import com.founder.zafffwqz.bean.Sqwyhcyb;
import com.founder.zafffwqz.dao.SqwyhcybDao;
import com.founder.zafffwqz.service.SqwyhcybService;

@Service("sqwyhcybService")
@Transactional
public class SqwyhcybServiceImpl extends BaseService implements SqwyhcybService {
	
	@Resource(name = "sqwyhcybDao")
	private SqwyhcybDao sqwyhcybDao;
	@Resource(name="ryRylxfsxxbService")
	private RyRylxfsxxbService ryRylxfsxxbService;
	@Override
	public Sqwyhcyb querySqwyhcyb(Sqwyhcyb entity) {
		return sqwyhcybDao.querySqwyhcybById(entity);
	}

	@Override
	public void saveSqwyhcyb(Sqwyhcyb entity, SessionBean sessionBean) {
		entity.setId(UUID.create());
		setSaveProperties(entity, sessionBean);
		sqwyhcybDao.insertSqwyhcyb(entity);
		this.ryRylxfsxxbService.saveLxdh(entity.getRyid(), entity.getLxdh(), sessionBean);

	}

	@Override
	public int updateSqwyhcyb(Sqwyhcyb entity, SessionBean sessionBean) {
		setUpdateProperties(entity, sessionBean);
		this.ryRylxfsxxbService.saveLxdh(entity.getRyid(), entity.getLxdh(), sessionBean);

		return sqwyhcybDao.updateSqwyhcyb(entity);
		
	}

}
