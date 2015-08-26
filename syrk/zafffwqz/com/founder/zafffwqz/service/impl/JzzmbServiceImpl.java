package com.founder.zafffwqz.service.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.UUID;
import com.founder.zafffwqz.bean.Jzzmb;
import com.founder.zafffwqz.dao.JzzmbDao;
import com.founder.zafffwqz.service.JzzmbService;

@Service("jzzmbService")
@Transactional
public class JzzmbServiceImpl extends BaseService implements JzzmbService {
	@Resource(name = "jzzmbDao")
	private JzzmbDao jzzmbDao;
	
	@Override
	public void delete(Jzzmb entity, SessionBean sessionBean) {
		setCrossoutProperties(entity, sessionBean);
		jzzmbDao.delete(entity);
		
	}

	@Override
	public Jzzmb queryJzzmb(Jzzmb entity) {
		return jzzmbDao.queryJzzmb(entity);
	}

	@Override
	public EasyUIPage queryList(EasyUIPage page, Map map) {
		return jzzmbDao.queryList(page,map);
	}

	@Override
	public void saveJzzmb(Jzzmb entity, SessionBean sessionBean) {
		entity.setId(UUID.create());
		setSaveProperties(entity, sessionBean);
		jzzmbDao.saveJzzmb(entity);
		
	}

	@Override
	public void updateJzzmb(Jzzmb entity, SessionBean sessionBean) {
		setUpdateProperties(entity, sessionBean);
		jzzmbDao.updateJzzmb(entity);
		
	}

}
