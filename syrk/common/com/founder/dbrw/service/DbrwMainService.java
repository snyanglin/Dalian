package com.founder.dbrw.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.founder.dbrw.bean.DbrwDbrwb;
import com.founder.dbrw.bean.DbrwDdbrwb;
import com.founder.dbrw.vo.DbrwMainVo;
import com.founder.framework.utils.EasyUIPage;

public interface DbrwMainService {
	
	/**
	 * 
	 * @Title: queryDdbrwsjmxb
	 * @Description: TODO(根据督办模型id查询待督办任务详细表)
	 * @param @param page
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	public EasyUIPage queryDdbrwsjmxb(EasyUIPage page, DbrwDdbrwb entity);
	
	public int queryDdbrwsjmxbCount(String dbrwfqpcsdm, String dbmxid);
	
	public EasyUIPage queryDbrwsjmxb(EasyUIPage page, DbrwDbrwb entity);
	
	public int queryDbrwsjmxbCount(String dbrwfqpcsdm, String dbmxid, String sfwcdm);
	
	/**
	 * 
	 * @Title: querySydwChart
	 * @Description: TODO(实有单位饼状图)
	 * @param @param zzjgdm
	 * @param @return    设定文件
	 * @return Map<String,Object>    返回类型
	 * @throws
	 */
	public Map<String, Object> querySydwChart(HashMap map);
	
	
	/**
	 * 
	 * @Title: querySyfwChart
	 * @Description: TODO(实有房屋饼状图)
	 * @param @param dbrwfqpcsdm
	 * @param @return    设定文件
	 * @return Map<String,Object>    返回类型
	 * @throws
	 */
	public Map<String, Object> querySyfwChart(HashMap map);
	
	/**
	 * 
	 * @Title: queryGwryChart
	 * @Description: TODO(高危人员柱状图)
	 * @param @param selectMap
	 * @param @return    设定文件
	 * @return Map<String,Object>    返回类型
	 * @throws
	 */
	public Map<String, Object> queryGwryChart(HashMap selectMap);
	
	/**
	 * 
	 * @Title: queryZdryChart
	 * @Description: TODO(重点人员饼状图)
	 * @param @param selectMap
	 * @param @return    设定文件
	 * @return Map<String,Object>    返回类型
	 * @throws
	 */
	public Map<String, Object> queryZdryChart(HashMap selectMap);
	
	/**
	 * 
	 * @Title: queryDbrwList
	 * @Description: TODO(督办任务列表)
	 * @param @param page
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	public EasyUIPage queryDbrwList(EasyUIPage page, String dbrwfqpcsdm);
	
	/**
	 * 
	 * @Title: queryDdbrwbList
	 * @Description: TODO(待督办任务)
	 * @param @param map
	 * @param @return    设定文件
	 * @return List<DbrwDdbrwb>    返回类型
	 * @throws
	 */
	public List<DbrwDdbrwb> queryDdbrwbList(HashMap map);
	
	/**
	 * 
	 * @Title: getSydwMax
	 * @Description: TODO(对“从业人员流动性较大的企业”和“无从业人员的企业”统计数据进行比较，并返回最大的类别)
	 * @param @param dbrwfqpcsdm
	 * @param @return    设定文件
	 * @return HashMap    返回类型
	 * @throws
	 */
	public DbrwMainVo getSydwMax(String dbrwfqpcsdm);
	
	/**
	 * 
	 * @Title: getSyfwMax
	 * @Description: TODO(对“无人居住房屋”、“独居出租房屋”和“群居出租房屋”统计数据进行比较，并返回最大的类别)
	 * @param @param dbrwfqpcsdm
	 * @param @return    设定文件
	 * @return HashMap    返回类型
	 * @throws
	 */
	public DbrwMainVo getSyfwMax(String dbrwfqpcsdm);
	
	
	
	/**
	 * 
	 * @Title: getSyfwMax
	 * @Description: TODO(对“无人居住房屋”、“独居出租房屋”和“群居出租房屋”统计数据进行比较，并返回最大的类别)
	 * @param @param dbrwfqpcsdm
	 * @param @return    设定文件
	 * @return HashMap    返回类型
	 * @throws
	 */
	public String queryShowType(Map<String,String> map);
	
	public String getMaxByDbmxid(String dbrwfqpcsdm, String dbmxid);
	
	public EasyUIPage queryJctjList(EasyUIPage page, String dbrwfqpcsdm);
}
