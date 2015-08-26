package com.founder.zafffwqz.dao;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.zafffwqz.bean.Sqmjxxb;
import com.founder.zafffwqz.bean.Sqzbhb;

@Repository("sqzbhbDao")
public class SqzbhbDao extends BaseDaoImpl {

	public Sqzbhb querySqzbhb(Sqzbhb entity) {
		// TODO Auto-generated method stub
		return (Sqzbhb) super.queryForObject("Sqzbhb.query", entity);
	}

	public void saveSqzbhb(Sqzbhb entity) {
		// TODO Auto-generated method stub
		super.insert("Sqzbhb.insertSqzbhb", entity);
	}

	public void updateSqzbhb(Sqzbhb entity) {
		// TODO Auto-generated method stub
		super.update("Sqzbhb.updateSqzbhb", entity);
	}

}
