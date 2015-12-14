package com.founder.yjjb.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.EasyUIPage;
import com.founder.yjjb.bean.Xsdzsqb;
import com.founder.yjjb.dao.XsdzsqbDao;
import com.founder.yjjb.service.XsdzsqbService;

@Service("xsdzsqbService")
@Transactional
public class XsdzsqbServiceImpl extends BaseService implements XsdzsqbService {

	@Resource(name = "xsdzsqbDao")
	private XsdzsqbDao xsdzsqbDao;
	
	/**
	 * 查询</br>
	 */
	public EasyUIPage queryList(EasyUIPage page,Xsdzsqb entity) {
		
		return xsdzsqbDao.queryList(page, entity);
	}

	/**
	 * 查询</br>
	 */
	public Xsdzsqb queryById(Xsdzsqb entity) {
		
		return xsdzsqbDao.queryById(entity);
	}

	/**
	 * 新增</br>
	 */
	public void save(Xsdzsqb entity, SessionBean sessionBean) {
		
//		entity.setId(UUID.create());
		setSaveProperties(entity, sessionBean);
		xsdzsqbDao.save(entity, sessionBean);
	}

	/**
	 * 修改</br>
	 */
	public void update(Xsdzsqb entity, SessionBean sessionBean) {
		
		setUpdateProperties(entity, sessionBean);
		xsdzsqbDao.update(entity, sessionBean);
	}

	/**
	 * 删除</br>
	 */
	public void delete(Xsdzsqb entity, SessionBean sessionBean) {
		
		setCrossoutProperties(entity, sessionBean);
		xsdzsqbDao.delete(entity, sessionBean);
	}


	
}
