package com.founder.zdry.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.UUID;
import com.founder.zdry.bean.ZdryXdryxxb;
import com.founder.zdry.dao.ZdryXdryxxbDao;
import com.founder.zdry.service.ZdryXdryService;

@Service("zdryXdryService")
@Transactional
public class ZdryXdryServiceImpl extends BaseService implements ZdryXdryService {

	@Resource(name="zdryXdryxxbDao")
	private ZdryXdryxxbDao zdryXdryxxbDao;
	
	@Override
	public ZdryXdryxxb queryById(String id) {
		return this.zdryXdryxxbDao.queryById(id);
	}
	
	@Override
	public ZdryXdryxxb getZdryXdryxdqk(String zdryId) {
		return this.zdryXdryxxbDao.queryByZdryid(zdryId);
	}

	@Override
	public void save(ZdryXdryxxb entity, SessionBean sessionBean) {
		entity.setId(UUID.create()); // 生成主键
		BaseService.setSaveProperties(entity, sessionBean);
		this.zdryXdryxxbDao.save(entity);
	}

	@Override
	public void update(ZdryXdryxxb entity, SessionBean sessionBean) {
		BaseService.setUpdateProperties(entity, sessionBean);
		this.zdryXdryxxbDao.update(entity);
	}
	
}
