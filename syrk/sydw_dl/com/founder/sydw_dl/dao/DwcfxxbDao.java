package com.founder.sydw_dl.dao;
import org.springframework.stereotype.Repository;
import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.sydw_dl.bean.Dwcfxxb;
import com.founder.sydw_dl.bean.Dwjbxxb;
@Repository("dwcfxxbDao")
public class DwcfxxbDao extends BaseDaoImpl {

	/**
	 * 新增<br>
	 * 
	 * @param entity
	 */
	public void save(Dwcfxxb entity) {
		insert("Dwcfxx.insertDwcf", entity);
	}
	/**
	 * 新增<br>
	 * 
	 * @param entity
	 */
	public void update(Dwcfxxb entity) {
		update("Dwcfxx.updateDwcf", entity);
	}
	
	/**
	 * 查询单条<br>
	 * 
	 * @param entity
	 * @return
	 */
	public Dwcfxxb queryEntityById(Dwcfxxb entity) {
		return (Dwcfxxb)queryForObject("Dwcfxx.queryDwcf", entity);
	}
	/**
	 * 查询条数<br>
	 * 
	 * @param entity
	 * @return
	 */
	public Long queryCountByDwId(Dwcfxxb entity) {
		return (Long)queryForObject("Dwcfxx.queryCountByDwid", entity);
	}
	
	/**
	 * 更新单位监管级别<br>
	 * 
	 * @param entity
	 */
	public void updateDwjgjb(Dwjbxxb entity) {
		update("Dwjbxxb.update", entity);
	}
}
