package com.founder.sydw_dl.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.sydw_dl.bean.Yyssxxb;
@Repository("yyssxxbDao")
public class YyssxxbDao extends BaseDaoImpl {

	public Yyssxxb queryEntityById(Yyssxxb entity) {
		return (Yyssxxb)queryForObject("Yyssxxb.query", entity);
	}

	public void saveEntity(Yyssxxb entity) {
		super.insert("Yyssxxb.insertYyss", entity);
	}

	public void updateEntity(Yyssxxb entity) {
		super.update("Yyssxxb.updateYyss", entity);
	}

	public List<Yyssxxb> yyssxxb_query(Map<String, Object> map) {
		return queryForList("Yyssxxb.yyssxxb_query", map);
	}



}
