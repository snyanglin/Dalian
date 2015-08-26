package com.founder.zafffwqz.dao;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.zafffwqz.bean.Sqzdbwb;

@Repository("sqzdbwbDao")
public class SqzdbwbDao extends BaseDaoImpl {
	
	/**
	 * insert 社区重点部位表
	 * 
	 * @param entity
	 */
	public void insertSqzdbwb(Sqzdbwb entity) {
		super.insertForObject("Sqzdbwb.save", entity);
	}

	/**
	 * queryById 社区重点部位表
	 * 
	 * @param id
	 * @return
	 */
	public Sqzdbwb querySqzdbwbById(Sqzdbwb entity) {
		return (Sqzdbwb) super.queryForObject("Sqzdbwb.queryById", entity);
	}

	/**
	 * update 社区重点部位表
	 * 
	 * @param entity
	 * @return
	 */
	public int updateSqzdbwb(Sqzdbwb entity) {
		return super.update("Sqzdbwb.updateSqzdbwb", entity);
	}

}
