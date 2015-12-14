package com.founder.yjjb.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.EasyUIPage;
import com.founder.yjjb.bean.Jbjlxxb;
import com.founder.yjjb.bean.Jlxxb;
import com.founder.yjjb.dao.JlxxbDao;
import com.founder.yjjb.service.JlxxbService;

@Service("jlxxbService")
@Transactional
public class JlxxbServiceImpl extends BaseService implements JlxxbService  {
	
	@Resource(name = "jlxxbDao")
	private JlxxbDao jlxxbDao;
	
	/**
	 * 查询</br>
	 */
	public EasyUIPage queryList(EasyUIPage page,Jlxxb entity) {
		
		return jlxxbDao.queryList(page, entity);
	}

	/**
	 * 查询</br>
	 */
	public Jlxxb queryById(Jlxxb entity) {
		
		return jlxxbDao.queryById(entity);
	}
	
	/**
	 * 新增</br>
	 */
	public void save(Jlxxb entity, SessionBean sessionBean) {
		
		setSaveProperties(entity, sessionBean);
		jlxxbDao.save(entity, sessionBean);
	}
	
	/**
	 * 修改</br>
	 */
	public void update(Jlxxb entity, SessionBean sessionBean) {
		
		setUpdateProperties(entity, sessionBean);
		jlxxbDao.update(entity, sessionBean);
	}
	/**
	 * 删除</br>
	 */
	public void delete(Jlxxb entity, SessionBean sessionBean) {
		
		setCrossoutProperties(entity, sessionBean);
		jlxxbDao.delete(entity, sessionBean);
	}
}
