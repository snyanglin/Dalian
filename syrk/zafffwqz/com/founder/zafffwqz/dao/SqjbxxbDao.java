package com.founder.zafffwqz.dao;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.zafffwqz.bean.Sqjbxxb;

@Repository("sqjbxxbDao")
public class SqjbxxbDao extends BaseDaoImpl {
	
	/**
	 * insert 社区基本信息表
	 * 
	 * @param entity
	 */
	public void insertSqjbxxb(Sqjbxxb entity) {
		super.insertForObject("Sqjbxxb.save", entity);
	}

	/**
	 * queryById 社区基本信息表
	 * 
	 * @param id
	 * @return
	 */
	public Sqjbxxb querySqjbxxbById(Sqjbxxb entity) {
		return (Sqjbxxb) super.queryForObject("Sqjbxxb.queryById", entity);
	}

	/**
	 * update 社区基本信息表
	 * 
	 * @param entity
	 * @return
	 */
	public int updateSqjbxxb(Sqjbxxb entity) {
		return super.update("Sqjbxxb.updateSqjbxxb", entity);
	}
	
	public Sqjbxxb sqjbxxb_query(Map<String, Object> map){
		return (Sqjbxxb) queryForObject("Sqjbxxb.sqjbxxb_query", map);
	}

}
