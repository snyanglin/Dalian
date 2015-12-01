package com.founder.sydw_dl.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.base.entity.SessionBean;
import com.founder.sydw_dl.bean.Dwjcxxb;
@Repository("dwjcxxbDao")
public class DwjcxxbDao extends BaseDaoImpl {

	/**
	 * 新增<br>
	 * 
	 * @param entity
	 */
	public void save(Dwjcxxb entity, SessionBean sessionBean) {
		insert("Dwjcxxb.insertDwjcxxb", entity);
	}
	
	/**
	 * 修改<br>
	 * 
	 * @param entity
	 */
	public void update(Dwjcxxb entity, SessionBean sessionBean) {
		update("Dwjcxxb.updateDwjcxxb", entity);
	}
	
	/**
	 * 查询单条<br>
	 * 
	 * @param entity
	 * @return
	 */
	public Dwjcxxb query(String id) {
		Dwjcxxb returnValue = null;
		List<?> list = queryForList("Dwjcxxb.queryDwjcxxb", id);
		if (list != null && list.size() > 0) {
			returnValue = (Dwjcxxb) list.get(0);
		}
		return returnValue;
	}
}
