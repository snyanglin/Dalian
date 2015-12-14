package com.founder.dbrw.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.founder.dbrw.bean.DbrwDbpzb;
import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.utils.StringUtils;

@Repository("dbrwDbpzbDao")
public class DbrwDbpzbDao extends BaseDaoImpl {

	/**
	 * 查询单条<br>
	 * 
	 * @param id
	 * @return DbrwDbpzb
	 */
	public DbrwDbpzb query(String id) {
		return (DbrwDbpzb) queryForObject("DbrwDbpzb.query", id);
	}

	/**
	 * 根据 dbmxbh 查询单条<br>
	 * 
	 * @param rolename
	 * @return DbrwDbpzb
	 */
	public DbrwDbpzb queryByDbmxbh(String dbmxbh) {
		DbrwDbpzb returnValue = null;
		if (!StringUtils.isBlank(dbmxbh)) {
			returnValue = (DbrwDbpzb) queryForObject("DbrwDbpzb.queryByDbmxbh",
					dbmxbh);
		}
		return returnValue;
	}

	/**
	 * 查询所有<br>
	 * 
	 * @return List<DbrwDbpzb>
	 */
	public List<DbrwDbpzb> queryAll() {
		return (List<DbrwDbpzb>) queryForList("DbrwDbpzb.queryAll", null);
	}

}
