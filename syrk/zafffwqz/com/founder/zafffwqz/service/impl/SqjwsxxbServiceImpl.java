package com.founder.zafffwqz.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.UUID;
import com.founder.sydw_dl.dao.DwjbxxbDao;
import com.founder.zafffwqz.bean.Sqjwsxxb;
import com.founder.zafffwqz.bean.Sqjwszrqglxxb;
import com.founder.zafffwqz.dao.SqjwsxxbDao;
import com.founder.zafffwqz.service.SqjwsxxbService;

@Service("sqjwsxxbService")
@Transactional
public class SqjwsxxbServiceImpl extends BaseService implements SqjwsxxbService {

	@Resource(name = "sqjwsxxbDao")
	private SqjwsxxbDao sqjwsxxbDao;
	
	@Resource(name = "dwjbxxbDao")
	private DwjbxxbDao dwjbxxbDao;

	@Override
	public Sqjwsxxb querySqjwsxxb(Sqjwsxxb entity) {
		return sqjwsxxbDao.querySqjwsxxb(entity);
	}

	@Override
	public void saveSqjwsxxb(Sqjwsxxb entity,SessionBean sessionBean) {
		String jwsid = UUID.create();
		entity.setId(jwsid);
		setSaveProperties(entity,sessionBean);
		sqjwsxxbDao.saveSqjwsxxb(entity);
		
		Sqjwszrqglxxb sqjwszrqglxxb = new Sqjwszrqglxxb();
		sqjwszrqglxxb.setId(UUID.create());
		sqjwszrqglxxb.setSqjwsid(jwsid);
		sqjwszrqglxxb.setZrqdm(sessionBean.getUserOrgCode());
		setSaveProperties(sqjwszrqglxxb, sessionBean);
		sqjwsxxbDao.insertSqjwszrqglxxb(sqjwszrqglxxb);
	}

	@Override
	public void updateSqjwsxxb(Sqjwsxxb entity, SessionBean sessionBean) {
		setSaveProperties(entity,sessionBean);
		sqjwsxxbDao.updateSqjwsxxb(entity);
	}

	@Override
	public Sqjwszrqglxxb queryByZrqdm(Sqjwszrqglxxb entity) {
		return sqjwsxxbDao.queryByZrqdm(entity);
	}
}
