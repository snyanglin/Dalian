package com.founder.dbrw.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.dbrw.bean.DbrwDbrwb;
import com.founder.dbrw.bean.DbrwDbrwfkb;
import com.founder.dbrw.bean.DbrwDbrwsjmxb;
import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.utils.DateUtils;

@Repository("dbrwRwclDao")
public class DbrwRwclDao extends BaseDaoImpl {
	
	
	/**
	 *  根据督办任务ID查询督办任务主表
	 * @return
	 */
	public DbrwDbrwb queryDbrwb(DbrwDbrwb entity) {
		return (DbrwDbrwb) queryForObject("DbrwRwcl.queryDbrwb", entity);
	}

	
	/**
	 * 根据督办任务ID查询督办任务子表 
	 * @return
	 */
	public List<DbrwDbrwsjmxb> queryDbrwsjmxb(Map map) {
		return queryForList("DbrwRwcl.queryDbrwsjmxb", map);
	}
	
	
	/**
	 * 根据dbmxbh得到统计模型列表title
	 * @return
	 */
	public Map getFiledTitle(String dbmxID) {
		return (Map) queryForObject("DbrwRwcl.getFiledTitle", dbmxID);
	}
	
	
	/**
	 * 根据dbmxbh得到统计模型列表title
	 * @return
	 */
	public DbrwDbrwsjmxb queryDbrwDbrwsjmxb(DbrwDbrwsjmxb dbrwDbrwsjmxb) {
		return (DbrwDbrwsjmxb) queryForObject("DbrwRwcl.queryDbrwDbrwsjmxb", dbrwDbrwsjmxb);
	}
	
	
	
	/**
	 * 根据dbmxbh得到统计模型列表title
	 * @return
	 */
	public void saveFK(DbrwDbrwsjmxb dbrwDbrwsjmxb) {
		update("DbrwRwcl.saveFK", dbrwDbrwsjmxb);
	}
	
	
	
	/**
	 * 刷新处理情况
	 * @return
	 */
	public void Refresh(Map map) {
		queryForObject("DbrwRwcl.Refresh", map);
	}
	
	
	/**
	 * 完成任务处理
	 * @return
	 */
	public void Complete(Map map) {
		queryForObject("DbrwRwcl.Refresh", map);
	}
	
	
	/**
	 * 完成任务处理后处理Message
	 * @return
	 */
	public void ChangeMessage(String MessageID) {
		Map CoultMap = new HashMap();
		CoultMap.put("MessageID", MessageID);
		CoultMap.put("cksj", DateUtils.getSystemDateTimeString());
		update("DbrwRwcl.updateMessage", CoultMap);
	}
	
	
	
	/**
	 *  根据督办任务ID查询督办任务主表
	 * @return
	 */
	public DbrwDbrwfkb queryDbrwDbrwfkb(DbrwDbrwfkb dbrwDbrwfkb) {
		return (DbrwDbrwfkb) queryForObject("DbrwRwcl.querydbrwDbrwfkb", dbrwDbrwfkb);
	}
	
	
	
	/**
	 * 保存督办任务反馈表
	 * @return
	 */
	public void saveDbrwfkb(DbrwDbrwfkb dbrwDbrwfkb) {
		insert("DbrwRwcl.insertDbrwfkb", dbrwDbrwfkb);
	}
	
	
	
	/**
	 * 修改督办任务反馈表
	 * @return
	 */
	public void updateDbrwfkb(DbrwDbrwfkb dbrwDbrwfkb) {
		update("DbrwRwcl.updateDbrwfkb", dbrwDbrwfkb);
	}
	
	
	/**
	 * 根据督办任务ID查询督办任务子表 总数
	 * @return
	 */
	public Integer queryDbrwsjmxbCount(Map map) {
		return (Integer) queryForObject("DbrwRwcl.queryDbrwsjmxbCount", map);
	}
	
	
	/**
	 * 根据dbmxbh得到统计模型列表title
	 * @return
	 */
	public Integer queryDbrwsjmxbWcCount(Map map) {
		return (Integer) queryForObject("DbrwRwcl.queryDbrwsjmxbWcCount", map);
	}
}
