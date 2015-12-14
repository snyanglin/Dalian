package com.founder.yjjb.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.EasyUIPage;
import com.founder.yjjb.bean.Ajxxb;
import com.founder.yjjb.dao.AjxxbDao;
import com.founder.yjjb.service.AjxxbService;

@Service("ajxxbService")
@Transactional
public class AjxxbServiceImpl extends BaseService implements AjxxbService {

	@Resource(name = "ajxxbDao")
	private AjxxbDao ajxxbDao;
	
	/**
	 * 查询</br>
	 */
	public EasyUIPage queryList(EasyUIPage page,Ajxxb entity) {
		
		return ajxxbDao.queryList(page, entity);
	}

	/**
	 * 查询</br>
	 */
	public Ajxxb queryById(Ajxxb entity) {
		
		return ajxxbDao.queryById(entity);
	}

	/**
	 * 新增</br>
	 */
	public void save(Ajxxb entity, SessionBean sessionBean) {
		
		setSaveProperties(entity, sessionBean);
		ajxxbDao.save(entity, sessionBean);
	}

	/**
	 * 修改</br>
	 */
	public void update(Ajxxb entity, SessionBean sessionBean) {
		
		setUpdateProperties(entity, sessionBean);
		ajxxbDao.update(entity, sessionBean);
	}

	/**
	 * 删除</br>
	 */
	public void delete(Ajxxb entity, SessionBean sessionBean) {
		
		setCrossoutProperties(entity, sessionBean);
		ajxxbDao.delete(entity, sessionBean);
	}
	
	/**
	 * 查询</br>
	 */
	public Ajxxb queryByAjbh(Ajxxb entity) {
		
		return ajxxbDao.queryByAjbh(entity);
	}

	public int ifExistAjNum(String ajbh) {
		int resultNum = ajxxbDao.ifExistAjNum(ajbh);
		return resultNum;
	}

	/**
	 * 通过id查询老警综数据
	 */
	public Ajxxb queryByAjbhLjz(Ajxxb entity) {
		return ajxxbDao.queryByAjbhLjz(entity);
	}

	public Ajxxb queryAllAjxxByAjbh(Ajxxb entity) {

		return ajxxbDao.queryAllAjxxByAjbh(entity);
	}
}
