package com.founder.sydw.dao;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.sydw.bean.Ldxxb;

@Repository("ldxxbDao")
public class LdxxbDao extends BaseDaoImpl {
	
	/**
	 * insert 旅馆信息表
	 * 
	 * @param ldxxb
	 */
	public void insertLdxxb(Ldxxb entity) {
		super.insertForObject("Ldxxb.save", entity);
	}

	/**
	 * queryById旅馆信息表
	 * 
	 * @param id
	 * @return
	 */
	public Ldxxb queryLdxxbById(Ldxxb entity) {
		return (Ldxxb) super.queryForObject("Ldxxb.queryById", entity);
	}

	/**
	 * update 旅馆信息表
	 * 
	 * @param ldxxb
	 * @return
	 */
	public int updateLdxxb(Ldxxb entity) {
		return super.update("Ldxxb.updateLdxxb", entity);
	}

}
