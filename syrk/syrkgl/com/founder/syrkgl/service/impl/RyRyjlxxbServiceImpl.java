package com.founder.syrkgl.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.UUID;
import com.founder.syrkgl.bean.RyRyjlxxb;
import com.founder.syrkgl.dao.RyRyjlxxbDao;
import com.founder.syrkgl.service.RyRyjlxxbService;
@Service("ryRyjlxxbService")
@Transactional
public class RyRyjlxxbServiceImpl implements RyRyjlxxbService {
	
	@Resource(name = "ryRyjlxxbDao")
	private RyRyjlxxbDao ryRyjlxxbDao;

	@Override
	public RyRyjlxxb queryById(String id) {

		return ryRyjlxxbDao.queryById(id);
	}

	@Override
	public void save(RyRyjlxxb entity, SessionBean sessionBean) {
		entity.setId(UUID.create()); // 生成主键
		BaseService.setSaveProperties(entity, sessionBean);
		this.ryRyjlxxbDao.save(entity, sessionBean);
	}

	@Override
	public void update(RyRyjlxxb entity, SessionBean sessionBean) {
		BaseService.setUpdateProperties(entity, sessionBean);
		this.ryRyjlxxbDao.update(entity, sessionBean);
	}

}
