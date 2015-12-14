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
import com.founder.zafffwqz.bean.Bazzryxxb;
import com.founder.zafffwqz.dao.BazzryxxbDao;
import com.founder.zafffwqz.service.BazzryxxbService;

@Service("bazzryxxbService")
@Transactional
public class BazzryxxbServiceImpl extends BaseService implements BazzryxxbService{
	
	@Resource(name = "bazzryxxbDao")
	private BazzryxxbDao bazzryxxbDao;

	@Resource(name="ryRylxfsxxbService")
	private RyRylxfsxxbService ryRylxfsxxbService;
	@Override
	public Bazzryxxb queryBazzryxxb(Bazzryxxb entity) {
		return bazzryxxbDao.queryBazzryxxb(entity);
	}

	@Override
	public void saveBazzryxxb(Bazzryxxb entity, SessionBean sessionBean) {
		entity.setId(UUID.create());
		setSaveProperties(entity, sessionBean);
		bazzryxxbDao.saveBazzryxxb(entity);
		
		ryRylxfsxxbService.saveLxdh(entity.getRyid(), entity.getLxfs(), sessionBean);
		
	}

	@Override
	public void updateBazzryxxb(Bazzryxxb entity, SessionBean sessionBean) {
		setUpdateProperties(entity, sessionBean);
		bazzryxxbDao.updateBazzryxxb(entity);

		this.ryRylxfsxxbService.saveLxdh(entity.getRyid(), entity.getLxfs(), sessionBean);
	}

	@Override
	public void deleteBazzryxxb(Bazzryxxb entity, SessionBean sessionBean) {
		setCrossoutProperties(entity, sessionBean);
		bazzryxxbDao.deleteBazzryxxb(entity);
	}

	@Override
	public EasyUIPage queryList(EasyUIPage page, Map map) {
		return bazzryxxbDao.queryList(page, map);
	}

}
