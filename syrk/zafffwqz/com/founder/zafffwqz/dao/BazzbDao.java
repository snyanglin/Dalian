package com.founder.zafffwqz.dao;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.zafffwqz.bean.Bazzb;
import com.founder.zafffwqz.bean.Sqjwsxxb;
@Repository("bazzbDao")
public class BazzbDao extends BaseDaoImpl {

	public Bazzb queryBazzb(Bazzb entity) {
		// TODO Auto-generated method stub
		return (Bazzb) super.queryForObject("Bazzb.query", entity);
	}

	public void saveBazzb(Bazzb entity) {
		// TODO Auto-generated method stub
		super.insert("Bazzb.insertBazzb", entity);
	}

	public void updateBazzb(Bazzb entity) {
		// TODO Auto-generated method stub
		super.update("Bazzb.updateBazzb", entity);
	}


}
