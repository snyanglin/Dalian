package com.founder.sydw.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.sydw.bean.XyaqxxbHxd;

@Repository("xyaqxxbHxdDao")
public class XyaqxxbHxdDao extends BaseDaoImpl {
	
	/**
	 * insert 护校队信息表
	 * 
	 * @param XyaqxxbHxd
	 */
	public void insertXyaqxxbHxd(XyaqxxbHxd entity) {
		super.insertForObject("XyaqxxbHxd.save", entity);
	}

	/**
	 * queryById护校队信息表
	 * 
	 * @param id
	 * @return
	 */
	public XyaqxxbHxd queryXyaqxxbHxdById(XyaqxxbHxd entity) {
		return (XyaqxxbHxd) super.queryForObject("XyaqxxbHxd.queryById", entity);
	}

	/**
	 * update 护校队信息表
	 * 
	 * @param XyaqxxbHxd
	 * @return
	 */
	public int updateXyaqxxbHxd(XyaqxxbHxd entity) {
		return super.update("XyaqxxbHxd.update", entity);
	}
	
	/**
	 * 单位证件
	 * @param map
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<XyaqxxbHxd> xyaqxxbHxd_query(Map<String, Object> map) {
		return queryForList("XyaqxxbHxd.xyaqxxbHxd_query", map);
	}

}
