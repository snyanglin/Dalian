package com.founder.sydw.service.impl;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.UUID;
import com.founder.sydw.bean.Dwhbxxb;
import com.founder.sydw.dao.DwhbxxbDao;
import com.founder.sydw.service.DwhbxxbService;
@Service("dwhbxxbService")
@Transactional
public class DwhbxxbServiceImpl extends BaseService implements DwhbxxbService {
	@Resource(name = "dwhbxxbDao")
	private DwhbxxbDao dwhbxxbDao;
	@Override
	public Dwhbxxb queryDwhbxxbByid(Dwhbxxb entity) {
		return dwhbxxbDao.queryDwhbxxbByid(entity);
	}
	@Override
	public void saveDwhbxxb(Dwhbxxb entity, SessionBean sessionBean) {
		entity.setId(UUID.create());
		setSaveProperties(entity,sessionBean);
		dwhbxxbDao.saveDwhbxxb(entity);
	}
	@Override
	public void updateDwhbxxb(Dwhbxxb entity, SessionBean sessionBean) {
		setUpdateProperties(entity,sessionBean);
		dwhbxxbDao.updateDwhbxxb(entity);
	}
	

}
