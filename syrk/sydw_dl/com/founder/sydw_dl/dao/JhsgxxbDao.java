package com.founder.sydw_dl.dao;

import java.util.List;
import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.sydw_dl.bean.Jhsgxxb;


@Repository("jhsgxxbDao")
public class JhsgxxbDao extends BaseDaoImpl {
	
	public Jhsgxxb queryJhsgxxbByRyid (Jhsgxxb entity) {
		Jhsgxxb returnValue = null;
		List<?> list = queryForList("Jhsgxxb.query", entity);
		if (list != null && list.size() > 0) {
			returnValue = (Jhsgxxb) list.get(0);
		}
		return returnValue;
	}
	
	public void saveJhsgxxb(Jhsgxxb entity) {
		super.insert("Jhsgxxb.insertJhsg", entity);
	}
	
	public void updateJhsgxxb(Jhsgxxb entity) {
		super.update("Jhsgxxb.updateJhsg", entity);
	}

	
}
