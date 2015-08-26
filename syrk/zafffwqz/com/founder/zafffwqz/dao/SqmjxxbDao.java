package com.founder.zafffwqz.dao;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.zafffwqz.bean.Sqmjxxb;


@Repository("sqmjxxbDao")
public class SqmjxxbDao extends BaseDaoImpl {

	public Sqmjxxb querySqmjxxb(Sqmjxxb entity) {
		// TODO Auto-generated method stub
		return (Sqmjxxb) super.queryForObject("Sqmjxxb.query", entity);
	}

	public void saveSqmjxxb(Sqmjxxb entity) {
		// TODO Auto-generated method stub
		super.insert("Sqmjxxb.insertSqmjxxb", entity);
	}

	public void updateSqmjxxb(Sqmjxxb entity) {
		// TODO Auto-generated method stub
		super.update("Sqmjxxb.updateSqmjxxb", entity);
	}

}
