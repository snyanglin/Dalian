package com.founder.zafffwqz.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.zafffwqz.bean.ZaffRfcyxxb;
import com.founder.zafffwqz.bean.ZaffRfxxb;
@Repository("rfxxDao")
public class RfxxDao extends BaseDaoImpl{
	/**
	 * insert 人防信息
	 * 
	 * @param entity
	 */
	public void insertRfxx(ZaffRfxxb entity) {
		super.insertForObject("Zaff_rfxx.save", entity);
	}
	
	/**
	 * queryById 人防信息
	 * 
	 * @param id
	 * @return
	 */
	public ZaffRfxxb queryRfxxById(ZaffRfxxb entity) {
		return (ZaffRfxxb) super.queryForObject("Zaff_rfxx.queryRfxxById", entity);
	}
	
	/**
	 * update 人防信息
	 * 
	 * @param entity
	 * @return
	 */
	public int updateRfxx(ZaffRfxxb entity) {
		return super.update("Zaff_rfxx.update", entity);
	}
	/**
	 * 注销
	 * @param entity
	 * @return
	 */
	public int deleteRfxx(ZaffRfxxb entity) {
		return super.update("Zaff_rfxx.delete", entity);
	}
	
	/**
	 * 人防信息查询
	 * @param page
	 * @param entity
	 * @return
	 */
	public EasyUIPage queryRf(EasyUIPage page, ZaffRfxxb entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("begin", page.getBegin());
		map.put("end", page.getEnd());
		String sort = page.getSort();
		String order = page.getOrder();
		if (StringUtils.isBlank(sort)) { // 默认排序
			sort = "id";
			order = "asc";
		}
		map.put("sort", sort);
		map.put("order", order);
		map.put("rfxx", entity);
		page.setTotal((Integer) queryForObject("Zaff_rfxx.queryCountRfxx", map));
		page.setRows(queryForList("Zaff_rfxx.queryRfxx", map));
		return page;
	}
	
	/**
	 * 人防成员的相关
	 * @param entity
	 */
	public void saveRfcyxx(ZaffRfcyxxb entity) {
		super.insertForObject("Zaff_rfxx.saveRfcyxx", entity);
	}
	public ZaffRfcyxxb queryRfcyxxById(ZaffRfcyxxb entity) {
		return (ZaffRfcyxxb) super.queryForObject("Zaff_rfxx.queryRfcyxxById", entity);
	}
	public int updateRfcyxx(ZaffRfcyxxb entity) {
		return super.update("Zaff_rfxx.updateRfcyxx", entity);
	}
	public int deleteRfcyxx(ZaffRfcyxxb entity) {
		return super.update("Zaff_rfxx.deleteRfcyxx", entity);
	}
	
	public EasyUIPage queryRfcyxx(EasyUIPage page, ZaffRfcyxxb entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("begin", page.getBegin());
		map.put("end", page.getEnd());
		String sort = page.getSort();
		String order = page.getOrder();
		if (StringUtils.isBlank(sort)) { // 默认排序
			sort = "id";
			order = "asc";
		}
		map.put("sort", sort);
		map.put("order", order);
		map.put("rfcyxx", entity);
		page.setTotal((Integer) queryForObject("Zaff_rfxx.queryCountRfcyxx", map));
		page.setRows(queryForList("Zaff_rfxx.queryRfcyxx", map));
		return page;
	}
}
