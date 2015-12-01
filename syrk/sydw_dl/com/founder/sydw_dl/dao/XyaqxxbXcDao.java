package com.founder.sydw_dl.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.sydw_dl.bean.XyaqxxbXc;

@Repository("xyaqxxbXcDao")
public class XyaqxxbXcDao extends BaseDaoImpl {
	
	/**
	 * insert 校车信息表
	 * 
	 * @param XyaqxxbXc
	 */
	public void insertXyaqxxbXc(XyaqxxbXc entity) {
		super.insertForObject("XyaqxxbXc.save", entity);
	}

	/**
	 * queryById校车信息表
	 * 
	 * @param id
	 * @return
	 */
	public XyaqxxbXc queryXyaqxxbXcById(XyaqxxbXc entity) {
		return (XyaqxxbXc) super.queryForObject("XyaqxxbXc.queryById", entity);
	}

	/**
	 * update 校车信息表
	 * 
	 * @param XyaqxxbHxd
	 * @return
	 */
	public int updateXyaqxxbXc(XyaqxxbXc entity) {
		return super.update("XyaqxxbXc.update", entity);
	}
	
	/**
	 * @param map
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<XyaqxxbXc> xyaqxxbXc_query(Map<String, Object> map) {
		return queryForList("XyaqxxbXc.xyaqxxbXc_query", map);
	}

}
