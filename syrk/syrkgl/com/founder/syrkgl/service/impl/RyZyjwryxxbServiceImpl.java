package com.founder.syrkgl.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.UUID;
import com.founder.syrkgl.bean.RyZyjwryxxb;
import com.founder.syrkgl.dao.RyZyjwryxxbDao;
import com.founder.syrkgl.service.RyZyjwryxxbService;

@Service("ryZyjwryxxbService")
@Transactional
public class RyZyjwryxxbServiceImpl implements RyZyjwryxxbService {

	@Resource(name = "ryZyjwryxxbDao")
	private RyZyjwryxxbDao ryZyjwryxxbDao;

	@Override
	public RyZyjwryxxb queryById(String id) {

		return ryZyjwryxxbDao.queryById(id);
	}

	@Override
	public void save(RyZyjwryxxb entity, SessionBean sessionBean) {
		entity.setId(UUID.create()); // 生成主键
		BaseService.setSaveProperties(entity, sessionBean);
		if (queryCount(entity) == 0) {
			this.ryZyjwryxxbDao.save(entity, sessionBean);
		}
	}

	@Override
	public void update(RyZyjwryxxb entity, SessionBean sessionBean) {
		BaseService.setUpdateProperties(entity, sessionBean);
		if (queryCount(entity) == 0) {
			this.ryZyjwryxxbDao.update(entity, sessionBean);
		}
	}

	@Override
	public void delete(RyZyjwryxxb entity, SessionBean sessionBean) {
		BaseService.setCrossoutProperties(entity, sessionBean);
		this.ryZyjwryxxbDao.delete(entity, sessionBean);
	}

	@Override
	public Integer queryCount(RyZyjwryxxb entity) {

		return this.ryZyjwryxxbDao.queryCount(entity);
	}

}
