package com.founder.sydw_dl.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.sydw_dl.bean.DwzybwXxb;
@Repository("dwzybwDao")
public class DwZyBwDao extends BaseDaoImpl {

	/**
	 * 重要部位信息保存
	 * @param entity
	 */
	public void save(DwzybwXxb entity) {
		insert("Dwzybw.insertZybw", entity);
	}
	
	/**
	 * 重要部位信息修改
	 * @param entity
	 */
	public void update(DwzybwXxb entity) {
		update("Dwzybw.updateZybw", entity);
	}
	
	/**
	 * 查询单条,重要部位信息<br>
	 * 
	 * @param entity
	 * @return
	 */
	public DwzybwXxb queryZybw(DwzybwXxb entity) {
		DwzybwXxb returnValue = null;
		List<?> list = queryForList("Dwzybw.queryZybw", entity);
		if (list != null && list.size() > 0) {
			returnValue = (DwzybwXxb) list.get(0);
		}
		return returnValue;
	}
}
