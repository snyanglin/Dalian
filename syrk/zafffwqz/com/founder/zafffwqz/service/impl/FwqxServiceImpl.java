package com.founder.zafffwqz.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.UUID;
import com.founder.zafffwqz.bean.Kthb;
import com.founder.zafffwqz.bean.Slzxqzb;
import com.founder.zafffwqz.bean.Tsqtghb;
import com.founder.zafffwqz.bean.Zaffxcb;
import com.founder.zafffwqz.dao.FwqzDao;
import com.founder.zafffwqz.service.FwqzService;
@Service("fwqzService")
@Transactional
public class FwqxServiceImpl extends BaseService implements FwqzService {
	
	@Resource(name = "fwqzDao")
	private FwqzDao fwqzDao;
	
	@Override
	public EasyUIPage querySlzxqz(EasyUIPage page, Slzxqzb entity) {
		// TODO Auto-generated method stub
		return fwqzDao.querySlzxqz(page, entity);
	}

	@Override
	public EasyUIPage queryKthb(EasyUIPage page, Kthb entity) {
		// TODO Auto-generated method stub
		return fwqzDao.queryKthb(page, entity);
	}

	@Override
	public EasyUIPage queryZaffxcb(EasyUIPage page, Zaffxcb entity) {
		// TODO Auto-generated method stub
		return fwqzDao.queryZaffxcb(page, entity);
	}

	@Override
	public EasyUIPage queryTsqtghb(EasyUIPage page, Tsqtghb entity) {
		// TODO Auto-generated method stub
		return fwqzDao.queryTsqtghb(page, entity);
	}

	@Override
	public void saveSlzxqzb(Slzxqzb entity, SessionBean sessionBean) {
		// TODO Auto-generated method stub
		entity.setId(UUID.create());
		setSaveProperties(entity, sessionBean);
		fwqzDao.saveSlzxqzb(entity);
	}

	@Override
	public void updateSlzxqzb(Slzxqzb entity, SessionBean sessionBean) {
		setUpdateProperties(entity, sessionBean);
		fwqzDao.updateSlzxqzb(entity);
	}

	@Override
	public void deleteSlzxqzb(Slzxqzb entity, SessionBean sessionBean) {
		setCrossoutProperties(entity, sessionBean);
		fwqzDao.deleteSlzxqzb(entity);
	}

	@Override
	public Slzxqzb querySlzxqzbById(Slzxqzb entity) {
		return fwqzDao.querySlzxqzbById(entity);
	}

	@Override
	public void saveKthb(Kthb entity, SessionBean sessionBean) {
		entity.setId(UUID.create());
		setSaveProperties(entity, sessionBean);
		fwqzDao.saveKthb(entity);
	}

	@Override
	public void updateKthb(Kthb entity, SessionBean sessionBean) {
		setUpdateProperties(entity, sessionBean);
		fwqzDao.updateKthb(entity);
	}

	@Override
	public void deleteKthb(Kthb entity, SessionBean sessionBean) {
		setCrossoutProperties(entity, sessionBean);
		fwqzDao.deleteKthb(entity);
	}

	@Override
	public Kthb queryKthbById(Kthb entity) {
		return fwqzDao.queryKthbById(entity);
	}

	@Override
	public void saveZaffxcb(Zaffxcb entity, SessionBean sessionBean) {
		entity.setId(UUID.create());
		setSaveProperties(entity, sessionBean);
		fwqzDao.saveZaffxcb(entity);
	}

	@Override
	public void updateZaffxcb(Zaffxcb entity, SessionBean sessionBean) {
		setUpdateProperties(entity, sessionBean);
		fwqzDao.updateZaffxcb(entity);
	}

	@Override
	public void deleteZaffxcb(Zaffxcb entity, SessionBean sessionBean) {
		setCrossoutProperties(entity, sessionBean);
		fwqzDao.deleteZaffxcb(entity);
	}

	@Override
	public Zaffxcb queryZaffxcbById(Zaffxcb entity) {
		return fwqzDao.queryZaffxcbById(entity);
	}

	@Override
	public void saveTsqtghb(Tsqtghb entity, SessionBean sessionBean) {
		entity.setId(UUID.create());
		setSaveProperties(entity, sessionBean);
		fwqzDao.saveTsqtghb(entity);
	}

	@Override
	public void updateTsqtghb(Tsqtghb entity, SessionBean sessionBean) {
		// TODO Auto-generated method stub
		setUpdateProperties(entity, sessionBean);
		fwqzDao.updateTsqtghb(entity);
	}

	@Override
	public void deleteTsqtghb(Tsqtghb entity, SessionBean sessionBean) {
		// TODO Auto-generated method stub
		setCrossoutProperties(entity, sessionBean);
		fwqzDao.deleteTsqtghb(entity);
	}

	@Override
	public Tsqtghb queryTsqtghbById(Tsqtghb entity) {
		// TODO Auto-generated method stub
		return fwqzDao.queryTsqtghbById(entity);
	}


}
