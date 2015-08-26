package com.founder.ggfw.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.service.BaseService;
import com.founder.framework.message.bean.SysMessage;
import com.founder.ggfw.bean.Ywxtgzrwb;
import com.founder.ggfw.dao.YwxtgzrwbDao;
import com.founder.ggfw.service.YwxtgzrwbService;

@Service("ywxtgzrwbService")
@Transactional
public class YwxtgzrwbServiceImpl extends BaseService implements YwxtgzrwbService {
	
	@Resource(name = "ywxtgzrwbDao")
	private YwxtgzrwbDao ywxtgzrwbDao;
	
	@Override
	public SysMessage queryYwxtgzrwbById(String id) {
		return ywxtgzrwbDao.queryYwxtgzrwbById(id);
	}

	public void savaYwxtgzrwb(Ywxtgzrwb entity) {
		ywxtgzrwbDao.savaYwxtgzrwb(entity);
	}
	
	public void updateYwxtgzrwb(Ywxtgzrwb entity) {
		ywxtgzrwbDao.updateYwxtgzrwb(entity);
	}

}
