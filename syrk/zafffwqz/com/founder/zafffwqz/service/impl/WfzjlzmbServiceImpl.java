package com.founder.zafffwqz.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.UUID;
import com.founder.zafffwqz.bean.Wfzjlzmb;
import com.founder.zafffwqz.dao.WfzjlzmbDao;
import com.founder.zafffwqz.service.WfzjlzmbService;

@Service("wfzjlzmbService")
@Transactional
public class WfzjlzmbServiceImpl extends BaseService implements WfzjlzmbService {

	@Resource(name = "wfzjlzmbDao")
	private WfzjlzmbDao wfzjlzmbDao;
	
	public Wfzjlzmb queryWfzjlzmb(Wfzjlzmb entity) {
		// TODO Auto-generated method stub
		return wfzjlzmbDao.queryWfzjlzmb(entity);
	}
	
	public void saveWfzjlzmb(Wfzjlzmb entity, SessionBean sessionBean) {
		// TODO Auto-generated method stub
		entity.setId(UUID.create());
		setSaveProperties(entity,sessionBean);
		wfzjlzmbDao.saveWfzjlzmb(entity);
	}
	
	public void updateWfzjlzmb(Wfzjlzmb entity, SessionBean sessionBean) {
		// TODO Auto-generated method stub
		setSaveProperties(entity,sessionBean);
		wfzjlzmbDao.updateWfzjlzmb(entity);
	}

	@Override
	public List<Wfzjlzmb> queryWfzjlzmbList(Map map) {
		// TODO Auto-generated method stub
		return wfzjlzmbDao.queryWfzjlzmbList(map);
	}

	@Override
	public void removeWfzjlzmb(Wfzjlzmb entity, SessionBean sessionBean) {
		// TODO Auto-generated method stub
		setSaveProperties(entity,sessionBean);
		wfzjlzmbDao.removeWfzjlzmb(entity);
	}

	@Override
	public EasyUIPage queryList(EasyUIPage page, Map map) {
		// TODO Auto-generated method stub
		return wfzjlzmbDao.queryList(page, map);
	}
}
