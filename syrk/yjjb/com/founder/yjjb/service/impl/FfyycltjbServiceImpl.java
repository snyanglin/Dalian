package com.founder.yjjb.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.EasyUIPage;
import com.founder.yjjb.bean.Ffyycltjb;
import com.founder.yjjb.dao.FfyycltjbDao;
import com.founder.yjjb.service.FfyycltjbService;

@Service("ffyycltjbService")
@Transactional
public class FfyycltjbServiceImpl extends BaseService implements FfyycltjbService {

	@Resource(name = "ffyycltjbDao")
	private FfyycltjbDao ffyycltjbDao;
	
	/**
	 * 查询</br>
	 */
	public EasyUIPage queryList(EasyUIPage page,Ffyycltjb entity) {
		
		return ffyycltjbDao.queryList(page, entity);
	}

	/**
	 * 查询</br>
	 */
	public Ffyycltjb queryById(Ffyycltjb entity) {
		
		return ffyycltjbDao.queryById(entity);
	}

	/**
	 * 新增</br>
	 */
	public void save(Ffyycltjb entity, SessionBean sessionBean) {
		
		setSaveProperties(entity, sessionBean);
		ffyycltjbDao.save(entity, sessionBean);
	}

	/**
	 * 修改</br>
	 */
	public void update(Ffyycltjb entity, SessionBean sessionBean) {
		
		setUpdateProperties(entity, sessionBean);
		ffyycltjbDao.update(entity, sessionBean);
	}

	/**
	 * 删除</br>
	 */
	public void delete(Ffyycltjb entity, SessionBean sessionBean) {
		
		setCrossoutProperties(entity, sessionBean);
		ffyycltjbDao.delete(entity, sessionBean);
	}
}
