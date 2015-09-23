package com.founder.zdrygl.core.inteface;

import java.util.Map;

import com.founder.framework.utils.EasyUIPage;

/**
 * 动态纪实基础数据接口服务
 * 
 * @author guotl
 *
 */
public interface ZdryDtjsDaoService {

	/**
	 * 新增
	 * 
	 * @param entity
	 */
	public void insert(Object entity);
	
	/**
	 * 列表页面查询
	 * 
	 * @param map 查询条件
	 * @param page 分页信息
	 * @return EasyUIPage
	 */
	public EasyUIPage queryPageList(Map<String,Object> map, EasyUIPage page);
}
