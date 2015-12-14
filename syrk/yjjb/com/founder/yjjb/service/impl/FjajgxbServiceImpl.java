package com.founder.yjjb.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.yjjb.bean.Fjajgxb;
import com.founder.yjjb.dao.FjajgxbDao;
import com.founder.yjjb.service.FjajgxbService;

@Service("fjajgxbService")
@Transactional
public class FjajgxbServiceImpl extends BaseService implements FjajgxbService {

	@Resource(name = "fjajgxbDao")
	private FjajgxbDao fjajgxbDao;
	
	/**
	 * 查询</br>
	 */
	public Fjajgxb queryById(Fjajgxb entity) {
		
		return fjajgxbDao.queryById(entity);
	}

	/**
	 * 新增</br>
	 */
	public void save(Fjajgxb entity, SessionBean sessionBean) {
		
		setSaveProperties(entity, sessionBean);
		fjajgxbDao.save(entity, sessionBean);
	}
	
	/**
	 * 删除</br>
	 */
	public void delete(Fjajgxb entity, SessionBean sessionBean) {
		
		setCrossoutProperties(entity, sessionBean);
		fjajgxbDao.delete(entity, sessionBean);
	}

	/* (非 Javadoc)
	 * <p>Title: queryByAjbh</p>
	 * <p>Description: </p>
	 * @param entity
	 * @return
	 * @see com.founder.yjjb.service.FjajgxbService#queryByAjbh(com.founder.yjjb.bean.Fjajgxb)
	 */
	public List<Fjajgxb> queryByAjbh(String ajbh) {
		return fjajgxbDao.queryByAjbh(ajbh);
	}
	
	/**
	 * 通过案件编号删除</br>
	 */
	public void deleteByAjbh(Fjajgxb entity, SessionBean sessionBean) {
		
		setCrossoutProperties(entity, sessionBean);
		fjajgxbDao.deleteByAjbh(entity, sessionBean);
	}

	/* (非 Javadoc)
	 * <p>Title: update</p>
	 * <p>Description: </p>
	 * @param entityFu
	 * @param sessionBean
	 * @see com.founder.yjjb.service.FjajgxbService#update(com.founder.yjjb.bean.Fjajgxb, com.founder.framework.base.entity.SessionBean)
	 */
	public void update(Fjajgxb entity, SessionBean sessionBean) {
		setUpdateProperties(entity, sessionBean);
		fjajgxbDao.update(entity, sessionBean);
		
	}

}
