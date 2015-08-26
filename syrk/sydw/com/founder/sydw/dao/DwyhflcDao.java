package com.founder.sydw.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.base.entity.SessionBean;
import com.founder.sydw.bean.Dwyhflcxxb;
@Repository("dwyhflcDao")
public class DwyhflcDao extends BaseDaoImpl{
	/**
	 * 新增<br>
	 * 
	 * @param entity
	 */
	public void save(Dwyhflcxxb entity, SessionBean sessionBean) {
		insert("Dwyhflc.insertDwyhflc", entity);
	}
	/**
	 * 修改<br>
	 * 
	 * @param entity
	 */
	public void update(Dwyhflcxxb entity, SessionBean sessionBean) {
		update("Dwyhflc.updateDwyhflc", entity);
	}
	/**
	 * 查询单条<br>
	 * 
	 * @param entity
	 * @return
	 */
	public Dwyhflcxxb query(String id) {
		Dwyhflcxxb returnValue = null;
		List<?> list = queryForList("Dwyhflc.queryDwyhflc", id);
		if (list != null && list.size() > 0) {
			returnValue = (Dwyhflcxxb) list.get(0);
		}
		return returnValue;
	}
}
