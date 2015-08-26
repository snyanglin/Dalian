package com.founder.zafffwqz.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.zafffwqz.bean.Sqjwsxxb;
import com.founder.zafffwqz.bean.Sqjwszrqglxxb;

@Repository("sqjwsxxbDao")
public class SqjwsxxbDao extends BaseDaoImpl {

	public Sqjwsxxb querySqjwsxxb(Sqjwsxxb entity) {
		return (Sqjwsxxb) super.queryForObject("Sqjwsxxb.query", entity);
	}

	public void saveSqjwsxxb(Sqjwsxxb entity) {
		super.insert("Sqjwsxxb.insertSqjwsxxb", entity);
	}

	public void updateSqjwsxxb(Sqjwsxxb entity) {
		super.update("Sqjwsxxb.updateSqjwsxxb", entity);
	}

	public void insertSqjwszrqglxxb(Sqjwszrqglxxb entity) {
		super.insert("Sqjwsxxb.insertSqjwszrqglxxb", entity);
	}

	public Sqjwszrqglxxb queryByZrqdm(Sqjwszrqglxxb entity) {
		Sqjwszrqglxxb returnValue = null;
		List<?> list = queryForList("Sqjwsxxb.queryByZrqdm", entity);
		if (list != null && list.size() > 0) {
			returnValue = (Sqjwszrqglxxb) list.get(0);
		}
		return returnValue;
	}

}
