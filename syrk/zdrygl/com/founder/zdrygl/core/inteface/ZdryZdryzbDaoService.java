package com.founder.zdrygl.core.inteface;

import java.util.List;
import java.util.Map;

import com.founder.framework.utils.EasyUIPage;
import com.founder.zdrygl.core.model.Zdry;

/**
 * 重点人员总表基础数据接口服务
 * 
 * @author guotl
 *
 */
public interface ZdryZdryzbDaoService {

	/**
	 * 新增
	 * 
	 * @param entity
	 */
	public void insert(Zdry entity);
	
	/**
	 * 更新
	 * 
	 * @param entity
	 */
	public void update(Zdry entity);
	
	/**
	 * 注销
	 * 
	 * @param entity
	 */
	public void delete(Zdry entity);
	
	/**
	 * 通过ID查询总表信息
	 * 
	 * @param zdryzbId
	 * @return
	 */
	public Zdry queryById(String zdryzbId);
	
	/**
	 * 通过人员ID查询总表信息
	 * 
	 * @param ryId
	 * @return
	 */
	public List<Zdry> queryListByRyId(String ryId,String andCondition);
	
	/**
	 * 通过实有人口ID查询总表信息
	 * 
	 * @param syrkId
	 * @return
	 */
	public List<Zdry> queryListBySyrkId(String syrkId,String andCondition);
	
	/**
	 * 通过entity查询总表信息
	 * 
	 * @param zdryZdryzb
	 * @return ZdryZdryzb
	 */
	public Zdry queryByEntity(Zdry zdryZdryzb,String andCondition);
	
	/**
	 * 通过entity查询总表信息
	 * 
	 * @param zdryZdryzb
	 * @return List of ZdryZdryzb
	 */
	public List<Zdry> queryListByEntity(Zdry zdryZdryzb,String andCondition);
	
	/**
	 * 
	 * @param entity
	 * @param page
	 * @return
	 */
	public EasyUIPage queryPageList(Map<String,Object> map, EasyUIPage page);
	
	/**
	 * 
	 * @param entity
	 * @param page
	 * @return
	 */
	public EasyUIPage getQueryList(Map<String,Object> map, EasyUIPage page);
	
	/**
	 * 
	 * @return
	 */
	public int getSrid();
	
	/**
	 * 
	 * @param zdryzbId
	 * @return
	 */
	public Map<String,Object> queryZdryVoById(String zdryzbId,String andCondition);
	
	/**
	 * 
	 * @param ryId
	 * @return
	 */
	public List<Map<String,Object>> queryZdryVoByRyId(String ryId,String andCondition);
	
	/**
	 * 
	 * @param syrkId
	 * @return
	 */
	public List<Map<String,Object>> queryZdryVoBySyrkId(String syrkId,String andCondition);
	
	/**
	 * 
	 * @param zdryzbId
	 * @return
	 */
	public List<Map<String,Object>> queryLgxxByZdryzbId(String zdryzbId,String andCondition);
	
	/**
	 * 
	 * @param entity
	 * @return
	 */
	public Integer queryCountByEntity(Zdry entity);
}
