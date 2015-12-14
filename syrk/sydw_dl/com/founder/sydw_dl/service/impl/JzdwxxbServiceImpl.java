package com.founder.sydw_dl.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.UUID;
import com.founder.sydw_dl.bean.Jzdwxxb;
import com.founder.sydw_dl.bean.Ldxxb;
import com.founder.sydw_dl.dao.JzdwxxbDao;
import com.founder.sydw_dl.dao.LdxxbDao;
import com.founder.sydw_dl.service.JzdwxxbService;
@Service("jzdwxxbService")
@Transactional
public class JzdwxxbServiceImpl extends BaseService implements JzdwxxbService {
	@Resource(name = "jzdwxxbDao")
	private JzdwxxbDao jzdwxxbDao;
	@Override
	public void saveJzdwxxb(Jzdwxxb entity, SessionBean sessionBean) {
		entity.setId(UUID.create()); // 生成主键
		BaseService.setSaveProperties(entity, sessionBean);
		 jzdwxxbDao.insert(entity);
	}


	@Override
	public void updateJzdwxb(Jzdwxxb entity, SessionBean sessionBean) {
		BaseService.setUpdateProperties(entity, sessionBean);

		jzdwxxbDao.update(entity);
	}

	@Override
	public Jzdwxxb queryById(String id) {
		
		return jzdwxxbDao.queryById(id);
	}

}
