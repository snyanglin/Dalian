package com.founder.sydw_dl.dao;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.sydw_dl.bean.Dwccxxb;
@Repository("dwccxxbDao")
public class DwccxxbDao extends BaseDaoImpl {

	public Dwccxxb queryEntityById(Dwccxxb entity) {
		return (Dwccxxb)queryForObject("Dwccxxb.queryDwcc", entity);
	}

	public void saveEntity(Dwccxxb entity) {
		super.insert("Dwccxxb.insertDwcc", entity);
	}

	public void updateEntity(Dwccxxb entity) {
		super.update("Dwccxxb.updateDwcc", entity);
	}

}
