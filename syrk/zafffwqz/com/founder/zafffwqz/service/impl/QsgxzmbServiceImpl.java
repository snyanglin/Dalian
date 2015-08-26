package com.founder.zafffwqz.service.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.UUID;
import com.founder.zafffwqz.bean.Qsgxrzb;
import com.founder.zafffwqz.bean.Qsgxzmb;
import com.founder.zafffwqz.bean.Wfzjlzmb;
import com.founder.zafffwqz.dao.QsgxzmbDao;
import com.founder.zafffwqz.dao.WfzjlzmbDao;
import com.founder.zafffwqz.service.QsgxzmbService;

@Service("qsgxzmbService")
@Transactional
public class QsgxzmbServiceImpl extends BaseService implements QsgxzmbService {
	
	@Resource(name = "qsgxzmbDao")
	private QsgxzmbDao qsgxzmbDao;
	@Override
	public EasyUIPage queryList(EasyUIPage page, Map map) {
		// TODO Auto-generated method stub
		return qsgxzmbDao.queryList(page, map);
	}

	@Override
	public Qsgxzmb queryQsgxzmb(Qsgxzmb entity) {
		// TODO Auto-generated method stub
		return qsgxzmbDao.queryQsgxzmb(entity);
	}

	@Override
	public void removeQsgxzmb(Qsgxzmb entity,Qsgxrzb qsgxrzb, SessionBean sessionBean) {
		// TODO Auto-generated method stub
		setSaveProperties(entity,sessionBean);
		qsgxzmbDao.removeQsgxzmb(entity);
		setSaveProperties(qsgxrzb,sessionBean);
		qsgxzmbDao.removeQsgxrzb(qsgxrzb);
	}

	@Override
	public void saveQsgxzmb(Qsgxzmb entity, SessionBean sessionBean) {
		// TODO Auto-generated method stub
		entity.setId(UUID.create());
		setSaveProperties(entity,sessionBean);
		qsgxzmbDao.saveQsgxzmb(entity);
	}

	@Override
	public void saveQsgxrzb(Qsgxrzb entity, SessionBean sessionBean) {
		// TODO Auto-generated method stub
		entity.setId(UUID.create());
		setSaveProperties(entity,sessionBean);
		qsgxzmbDao.saveQsgxrzb(entity);
	}
	@Override
	public EasyUIPage queryQsList(EasyUIPage page, Map map) {
		// TODO Auto-generated method stub
		return qsgxzmbDao.queryQsList(page, map);
	}
}
