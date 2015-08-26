package com.founder.alarm.plugin.test;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.sydw.bean.Ldxxb;

@Repository("testDao")
public class TestDao extends BaseDaoImpl {
	
	/**
	 * insert 旅馆信息表
	 * 
	 * @param ldxxb
	 */
	public void insertLdxxb(Ldxxb entity) {
		super.insertForObject("Test.save", entity);
	}

	/**
	 * queryById旅馆信息表
	 * 
	 * @param id
	 * @return
	 */
	public Ldxxb queryLdxxbById(Ldxxb entity) {
		return (Ldxxb) super.queryForObject("Test.queryById", entity);
	}

	/**
	 * update 旅馆信息表
	 * 
	 * @param ldxxb
	 * @return
	 */
	public int updateLdxxb(Ldxxb entity) {
		return super.update("Test.updateLdxxb", entity);
	}

}
