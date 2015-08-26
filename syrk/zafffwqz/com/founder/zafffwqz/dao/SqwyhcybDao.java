package com.founder.zafffwqz.dao;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.zafffwqz.bean.Sqwyhcyb;

@Repository("sqwyhcybDao")
public class SqwyhcybDao extends BaseDaoImpl {
	
	/**
	 * insert 社区委员会成员表
	 * 
	 * @param entity
	 */
	public void insertSqwyhcyb(Sqwyhcyb entity) {
		super.insertForObject("Sqwyhcyb.save", entity);
	}

	/**
	 * queryById 社区委员会成员表
	 * 
	 * @param id
	 * @return
	 */
	public Sqwyhcyb querySqwyhcybById(Sqwyhcyb entity) {
		return (Sqwyhcyb) super.queryForObject("Sqwyhcyb.queryById", entity);
	}

	/**
	 * update 社区委员会成员表
	 * 
	 * @param entity
	 * @return
	 */
	public int updateSqwyhcyb(Sqwyhcyb entity) {
		return super.update("Sqwyhcyb.updateSqwyhcyb", entity);
	}

}
