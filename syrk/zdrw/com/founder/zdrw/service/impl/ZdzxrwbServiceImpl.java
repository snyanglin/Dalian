package com.founder.zdrw.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.UUID;
import com.founder.zdrw.bean.Zdzxrwb;
import com.founder.zdrw.dao.ZdzxrwbDao;
import com.founder.zdrw.service.ZdzxrwbService;

@Service("zdzxrwbService")
@Transactional
public class ZdzxrwbServiceImpl extends BaseService implements ZdzxrwbService {
	
	@Resource(name = "zdzxrwbDao")
	private ZdzxrwbDao zdzxrwbDao;
	
	/**
	 * 查询01
	 */
	public EasyUIPage queryList(EasyUIPage page, Zdzxrwb entity) {
		return zdzxrwbDao.queryList(page,entity);
	}

	/**
	 * 查询02
	 */
	public Zdzxrwb queryZdzxrwbById(Zdzxrwb entity) {
		return zdzxrwbDao.queryZdzxrwbById(entity);
	}

	/**
	 * 删除
	 */
	@Override
	public int deleteZdzxrwb(Zdzxrwb entity, SessionBean sessionBean) {
		
		setCrossoutProperties(entity, sessionBean);
		return zdzxrwbDao.deleteZdzxrwb(entity);
	}

	/**
	 * 插入
	 */
	public void insertZdzxrwb(Zdzxrwb entity, SessionBean sessionBean) {
		
		entity.setId(UUID.create());
		setSaveProperties(entity, sessionBean);
		zdzxrwbDao.insertZdzxrwb(entity);
	}

	/**
	 * 更新
	 */
	public int updateZdzxrwb(Zdzxrwb entity, SessionBean sessionBean) {
		
		setUpdateProperties(entity, sessionBean);
		return zdzxrwbDao.updateZdzxrwb(entity);
	}

}
