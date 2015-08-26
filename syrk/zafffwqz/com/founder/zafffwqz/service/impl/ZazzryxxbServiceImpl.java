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
import com.founder.zafffwqz.bean.Zazzryxxb;
import com.founder.zafffwqz.dao.ZazzryxxbDao;
import com.founder.zafffwqz.service.ZazzryxxbService;

@Service("zazzryxxbService")
@Transactional
public class ZazzryxxbServiceImpl extends BaseService implements ZazzryxxbService{
	
	@Resource(name = "zazzryxxbDao")
	private ZazzryxxbDao zazzryxxbDao;
	@Resource(name = "ryRylxfsxxbService")
	private RyRylxfsxxbService ryRylxfsxxbService;
	@Override
	public Zazzryxxb queryZazzryxxb(Zazzryxxb entity) {
		return zazzryxxbDao.queryZazzryxxb(entity);
	}

	@Override
	public void saveZazzryxxb(Zazzryxxb entity, SessionBean sessionBean) {
		entity.setId(UUID.create());
		setSaveProperties(entity, sessionBean);
		zazzryxxbDao.saveZazzryxxb(entity);
		this.ryRylxfsxxbService.saveLxdh(entity.getRyid(), entity.getLxfs(), sessionBean);

	}

	@Override
	public void updateZazzryxxb(Zazzryxxb entity, SessionBean sessionBean) {
		setUpdateProperties(entity, sessionBean);
		zazzryxxbDao.updateZazzryxxb(entity);
		this.ryRylxfsxxbService.saveLxdh(entity.getRyid(), entity.getLxfs(), sessionBean);

	}

	@Override
	public void deleteZazzryxxb(Zazzryxxb entity, SessionBean sessionBean) {
		setCrossoutProperties(entity, sessionBean);
		zazzryxxbDao.deleteZazzryxxb(entity);
	}

	@Override
	public EasyUIPage queryList(EasyUIPage page, Map map) {
		return zazzryxxbDao.queryList(page, map);
	}
	

}
