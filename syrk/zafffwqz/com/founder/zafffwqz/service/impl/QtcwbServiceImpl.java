package com.founder.zafffwqz.service.impl;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.UUID;
import com.founder.syrkgl.service.RyRylxfsxxbService;
import com.founder.zafffwqz.bean.Qtcwb;
import com.founder.zafffwqz.dao.QtcwbDao;
import com.founder.zafffwqz.service.QtcwbService;
@Service("qtcwbService")
@Transactional
public class QtcwbServiceImpl extends BaseService implements QtcwbService {
	@Resource(name = "qtcwbDao")
	private QtcwbDao qtcwbDao;
	@Resource(name="ryRylxfsxxbService")
	private RyRylxfsxxbService ryRylxfsxxbService;
	@Override
	public void delete(Qtcwb entity, SessionBean sessionBean) {
		setCrossoutProperties(entity, sessionBean);
		qtcwbDao.delete(entity);
		
	}

	@Override
	public EasyUIPage queryList(EasyUIPage page, Map map) {
		return qtcwbDao.queryList(page, map);
	}

	@Override
	public Qtcwb queryQtcwb(Qtcwb entity) {
		return qtcwbDao.queryQtcwb(entity);
	}

	@Override
	public void saveQtcwb(Qtcwb entity, SessionBean sessionBean) {
		entity.setId(UUID.create());
		setSaveProperties(entity, sessionBean);
		qtcwbDao.saveQtcwb(entity);
		this.ryRylxfsxxbService.saveLxdh(entity.getRyid(), entity.getLxdh(), sessionBean);

	}
	

	@Override
	public void updateQtcwb(Qtcwb entity, SessionBean sessionBean) {
		setUpdateProperties(entity, sessionBean);
		qtcwbDao.updateQtcwb(entity);
		this.ryRylxfsxxbService.saveLxdh(entity.getRyid(), entity.getLxdh(), sessionBean);

	}
	
}
