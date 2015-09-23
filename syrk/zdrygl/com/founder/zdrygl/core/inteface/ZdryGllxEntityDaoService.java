package com.founder.zdrygl.core.inteface;

import java.util.Map;

import com.founder.zdrygl.core.model.Zdry;

/**
 * 重点人员管理类型对应业务表的基础数据接口服务
 * 
 * @author guotl
 *
 */
public interface ZdryGllxEntityDaoService {

	/**
	 * 新增
	 * 
	 * @param entity
	 */
	public void insert(Zdry zdry);
	
	/**
	 * 更新
	 * 
	 * @param entity
	 */
	public void update(Zdry zdry);
	
	/**
	 * 注销
	 * 
	 * @param entity
	 */
	public void delete(Zdry zdry);
	
	/**
	 * 通过数据ID查询
	 * 
	 * @param entityId
	 * @return
	 */
	public Zdry queryById(String entityId);
	
	/**
	 * 重口编辑页面，框架查询信息
	 * 
	 * @param queryMap
	 * @return Object
	 */
	public Zdry queryViewByMap(Map<String,Object> queryMap);
}
