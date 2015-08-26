package com.founder.gzjk.dao;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.gzjk.vo.LogGzjltjb;

@Repository("tempDao")
public class TempDao extends BaseDaoImpl {
	
	/**
	 * 查询单条
	 * @param entity
	 * @return
	 */
	public LogGzjltjb querySingle(LogGzjltjb entity){
		return (LogGzjltjb) queryForObject("LogGzjltjb.querySingle", entity);
	}
	
	public void insert(LogGzjltjb entity){
		insert("LogGzjltjb.insert", entity);
	}
	
	public void updateGzjl(LogGzjltjb entity){
		update("LogGzjltjb.update", entity);
	}

}
