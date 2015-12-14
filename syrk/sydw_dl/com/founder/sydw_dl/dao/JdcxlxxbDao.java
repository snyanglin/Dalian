package com.founder.sydw_dl.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.sydw_dl.bean.Jdcxlxxb;

@Repository("jdcxlxxbDao")
public class JdcxlxxbDao extends BaseDaoImpl {

	public Jdcxlxxb queryjdcxlxxbByRyid(Jdcxlxxb entity) {
		Jdcxlxxb returnValue = null;
		List<?> list = queryForList("Jdcxlxxb.query", entity);
		if (list != null && list.size() > 0) {
			returnValue = (Jdcxlxxb) list.get(0);
		}
		return returnValue;
	}

	public void saveJdcxlxxb(Jdcxlxxb entity) {
		super.insert("Jdcxlxxb.insertJdcxlxxb", entity);
	}

	public void updateJdcxlxxb(Jdcxlxxb entity) {
		super.update("Jdcxlxxb.updateJdcxlxxb", entity);
	}

	public Jdcxlxxb jdcxlxxb_query(Map<String, Object> map) {
	
		return (Jdcxlxxb)  queryForObject("Jdcxlxxb.jdcxlxxb_query", map);
	}

}
