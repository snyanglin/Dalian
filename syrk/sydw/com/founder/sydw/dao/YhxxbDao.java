package com.founder.sydw.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.sydw.bean.Yhxxb;

@Repository("yhxxbDao")
public class YhxxbDao extends BaseDaoImpl {

	public Yhxxb queryYhxxbById (Yhxxb entity) {
		Yhxxb returnValue = null;
		List<?> list = queryForList("Yhxxb.query", entity);
		if (list != null && list.size() > 0) {
			returnValue = (Yhxxb) list.get(0);
		}
		return returnValue;
	}
	
	public void save(Yhxxb entity) {
		super.insert("Yhxxb.insert", entity);
	}
	
	public void update(Yhxxb entity) {
		super.update("Yhxxb.update", entity);
	}

}
