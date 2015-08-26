package com.founder.zafffwqz.service.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.UUID;
import com.founder.zafffwqz.bean.Kgzmb;
import com.founder.zafffwqz.dao.KgzmbDao;
import com.founder.zafffwqz.service.KgzmbService;

@Service("kgzmbService")
@Transactional
public class KgzmbServiceImpl extends BaseService implements KgzmbService {
	@Resource(name = "kgzmbDao")
	private KgzmbDao kgzmbDao;
	
	
	@Override
	public void delete(Kgzmb entity, SessionBean sessionBean) {
		setCrossoutProperties(entity, sessionBean);
		kgzmbDao.delete(entity);
	}

	@Override
	public Kgzmb queryKgzmb(Kgzmb entity) {
		return kgzmbDao.queryKgzmb(entity);
	}

	@Override
	public EasyUIPage queryList(EasyUIPage page, Map map) {
		return kgzmbDao.queryList(page,map);
	}

	@Override
	public void saveKgzmb(Kgzmb entity, SessionBean sessionBean) {
		entity.setId(UUID.create());
		setSaveProperties(entity, sessionBean);
		kgzmbDao.saveKgzmb(entity);
		
	}

	@Override
	public void updateKgzmb(Kgzmb entity, SessionBean sessionBean) {
		setUpdateProperties(entity, sessionBean);
		kgzmbDao.updateKgzmb(entity);
		
	}

}
