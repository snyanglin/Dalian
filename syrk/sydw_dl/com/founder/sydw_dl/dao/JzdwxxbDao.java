package com.founder.sydw_dl.dao;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.sydw_dl.bean.Jzdwxxb;

@Repository("jzdwxxbDao")
public class JzdwxxbDao extends BaseDaoImpl {
	
	/**
	 * insert 
	 * 
	 * @param ldxxb
	 */
	public void insert(Jzdwxxb entity) {
		super.insertForObject("jzdwxxb.save", entity);
	}

	/**
	 * queryById
	 * 
	 * @param id
	 * @return
	 */
	public Jzdwxxb queryById(String id) {
		return (Jzdwxxb) super.queryForObject("jzdwxxb.queryById", id);
	}

	public Jzdwxxb queryByDwid(Map<String,Object> map) {
		return (Jzdwxxb) super.queryForObject("jzdwxxb.jzdwxxb_query", map);
	}
	
	/**
	 * update 
	 * 
	 * @param 
	 * @return
	 */
	public int update(Jzdwxxb entity) {
		return super.update("jzdwxxb.update", entity);
	}

}
