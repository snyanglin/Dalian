package com.founder.sydw_dl.dao;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.sydw_dl.bean.Ddxxb;

@Repository("ddxxbDao")
public class DdxxbDao extends BaseDaoImpl {
	
	/**
	 * insert 典当业信息表
	 * 
	 * @param ddxxb
	 */
	public void insertDdxxb(Ddxxb entity) {
		super.insertForObject("Ddxxb.save", entity);
	}

	/**
	 * queryById典当业信息表
	 * 
	 * @param id
	 * @return
	 */
	public Ddxxb queryDdxxbById(Ddxxb entity) {
		return (Ddxxb) super.queryForObject("Ddxxb.queryById", entity);
	}

	/**
	 * update 典当业信息表
	 * 
	 * @param ddxxb
	 * @return
	 */
	public int updateDdxxb(Ddxxb entity) {
		return super.update("Ddxxb.updateDdxxb", entity);
	}

}
