package com.founder.sydw.dao;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.sydw.bean.Gxxxb;

@Repository("gxxxbDao")
public class GxxxbDao extends BaseDaoImpl {

	public Gxxxb queryGxxxbByRyid (Gxxxb entity) {
		return (Gxxxb) queryForObject("Gxxxb.query", entity);
	}
	
	public Gxxxb gxxxb_query(Map<String, Object> map){
		return (Gxxxb) queryForObject("Gxxxb.gxxxb_query", map);
	}
	
	public void saveGxxxb(Gxxxb entity) {
		super.insert("Gxxxb.insert", entity);
	}
	
	public void updateGxxxb(Gxxxb entity) {
		super.update("Gxxxb.update", entity);
	}
	
}
