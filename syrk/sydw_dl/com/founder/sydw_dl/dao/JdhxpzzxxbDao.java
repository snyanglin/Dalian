package com.founder.sydw_dl.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.sydw_dl.bean.Jdhxpzzxxb;
@Repository("jdhxpzzxxbDao")
public class JdhxpzzxxbDao extends BaseDaoImpl {

	public Jdhxpzzxxb queryjdhxpzzxxbByRyid(Jdhxpzzxxb entity) {
		Jdhxpzzxxb returnValue = null;
		List<?> list = queryForList("Jdhxpzzxxb.query", entity);
		if (list != null && list.size() > 0) {
			returnValue = (Jdhxpzzxxb) list.get(0);
		}
		return returnValue;
	}

	public void saveJdhxpzzxxb(Jdhxpzzxxb entity) {
		super.insert("Jdhxpzzxxb.insertJdhx", entity);
	}

	public void updateLxfs(Jdhxpzzxxb entity) {
		super.update("Jdhxpzzxxb.updateJdhxpzzxxb", entity);
	}

	public Jdhxpzzxxb jdhxpzzxxb_query(Map<String, Object> map) {
		return  (Jdhxpzzxxb)queryForObject("Jdhxpzzxxb.jdhxpzzxxb_query", map);
	}


}
