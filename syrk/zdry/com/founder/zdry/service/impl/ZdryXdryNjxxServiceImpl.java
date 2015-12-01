package com.founder.zdry.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.UUID;
import com.founder.zdry.bean.ZdryXdrynjxxb;
import com.founder.zdry.dao.ZdryXdrynjxxbDao;
import com.founder.zdry.service.ZdryXdryNjxxService;

@Service("zdryXdryNjxxService")
@Transactional
public class ZdryXdryNjxxServiceImpl extends BaseService implements ZdryXdryNjxxService {

	@Resource(name="zdryXdrynjxxbDao")
	private ZdryXdrynjxxbDao zdryXdrynjxxbDao;
	
	@Override
	public ZdryXdrynjxxb queryById(String id) {
		return this.zdryXdrynjxxbDao.queryById(id);
	}
	
	@Override
	public ZdryXdrynjxxb getZdryXdryxdqk(String zdryId) {
		return this.zdryXdrynjxxbDao.queryByZdryid(zdryId);
	}

	@Override
	public void save(ZdryXdrynjxxb entity, SessionBean sessionBean) {
		entity.setId(UUID.create()); // 生成主键
		BaseService.setSaveProperties(entity, sessionBean);
		this.zdryXdrynjxxbDao.save(entity);
	}

	@Override
	public void update(ZdryXdrynjxxb entity, SessionBean sessionBean) {
		BaseService.setUpdateProperties(entity, sessionBean);
		this.zdryXdrynjxxbDao.update(entity);
	}
	
}
