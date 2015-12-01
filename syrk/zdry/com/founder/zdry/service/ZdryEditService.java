package com.founder.zdry.service;

import java.util.List;
import java.util.Map;

import com.founder.service.attachment.bean.ZpfjFjxxb;
import com.founder.zdry.bean.ZdryDtgljsxxb;
import com.founder.zdry.bean.ZdryFzcsfryxxb;
import com.founder.zdry.bean.ZdryJgdxqxjdjb;
import com.founder.zdry.bean.ZdryJgdxxxb;
import com.founder.zdry.bean.ZdryJkbjllxxb;
import com.founder.zdry.bean.ZdryNrsxdxxxb;
import com.founder.zdry.bean.ZdryPsjdb;
import com.founder.zdry.bean.ZdryShbzdryxxb;
import com.founder.zdry.bean.ZdrySqsbzdryxxb;
import com.founder.zdry.bean.ZdryWffzjlxxb;
import com.founder.zdry.bean.ZdryXdrynjxxb;
import com.founder.zdry.bean.ZdryXdryxxb;
import com.founder.zdry.bean.ZdryZagltdxxb;
import com.founder.zdry.bean.ZdryZdrkxxb;
import com.founder.zdry.bean.ZdryZdrykcxxb;
import com.founder.zdry.bean.ZdryZdryzb;
import com.founder.zdry.bean.ZdryZszhjsbrxxb;
import com.founder.zdry.vo.ZdrygnVO;
import com.founder.zdry.vo.ZdrylgxxVO;
import com.founder.zdry.vo.ZdryxxzsVO;


public interface ZdryEditService {

	public List<ZdryZdryzb> queryZdryByRyid(String ryid);

	public List<ZdrygnVO> queryYwglgn(String gllxdm);

	public List<ZdryxxzsVO> queryRyzsxx(Map<String, Object> map);

	public void delete_xxzsnrb(Map<String, Object> map);
	
	/**
	 * 
	 * @Title: jgdxxxb_query
	 * @Description: TODO(监管对象)
	 * @param @param map
	 * @param @return    设定文件
	 * @return List<ZdryJgdxxxb>    返回类型
	 * @throws
	 */
	public  ZdryJgdxxxb  jgdxxxb_query(Map<String, Object> map);
	
	/**
	 * 
	 * @Title: psjdb_query
	 * @Description: TODO(评审鉴定)
	 * @param @param map
	 * @param @return    设定文件
	 * @return List<ZdryPsjdb>    返回类型
	 * @throws
	 */
	public List<ZdryPsjdb> psjdb_query(Map<String, Object> map);
	
	/**
	 * 
	 * @Title: dtgljsb_query
	 * @Description: TODO(动态管理纪实)
	 * @param @param map
	 * @param @return    设定文件
	 * @return List<ZdryDtgljsxxb>    返回类型
	 * @throws
	 */
	public List<ZdryDtgljsxxb> dtgljsb_query(Map<String, Object> map);
	

	/**
	 * 
	 * @Title: fzcfryxxb_query
	 * @Description: TODO(非正常访)
	 * @param @param map
	 * @param @return    设定文件
	 * @return List<ZdryFzcsfryxxb>    返回类型
	 * @throws
	 */
	public  ZdryFzcsfryxxb fzcfryxxb_query(Map<String, Object> map);
	
	/**
	 * 纳入视线对象信息表查询
	 * @Title: nrsxdxxxb_query
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param map
	 * @param @return    设定文件
	 * @return ZdryNrsxdxxxb    返回类型
	 * @throws
	 */
	public ZdryNrsxdxxxb nrsxdxxxb_query(Map<String, Object> map);
		
	/**
	 * 
	 * @Title: qxjdjb_query
	 * @Description: TODO(请消假)
	 * @param @param map
	 * @param @return    设定文件
	 * @return List<ZdryJgdxqxjdjb>    返回类型
	 * @throws
	 */
	public List<ZdryJgdxqxjdjb> qxjdjb_query(Map<String, Object> map);
	
	/**
	 *重点人员-重点人员作案规律特点
	 */
	public List<ZdryZagltdxxb> zagltdb_query(Map<String, Object> map);

	/**
	 *重点人员-重点人员违法犯罪记录
	 */
	public List<ZdryWffzjlxxb> wffzjlb_query(Map<String, Object> map);
	
	
	/**
	 *重点人员-
	 */
	public List<ZdryXdryxxb> zdryXdryxxb_query(Map<String, Object> map);
	
	
	public List<ZdryXdrynjxxb> zdryXdrynjxx_query(Map<String, Object> map);
	
	/**
	 * 
	 * @Title: jkbjryxxb_query
	 * @Description: TODO(监控帮教力量)
	 * @param @param map
	 * @param @return    设定文件
	 * @return List<ZdryJkbjllxxb>    返回类型
	 * @throws
	 */
	public List<ZdryJkbjllxxb> jkbjryxxb_query(Map<String,Object> map);
	
	/**
	 * 
	 * @Title: fjxx_query
	 * @Description: TODO(附件)
	 * @param @param map
	 * @param @return    设定文件
	 * @return List<ZpfjFjxxb>    返回类型
	 * @throws
	 */
	public List<ZpfjFjxxb> fjxx_query(Map<String,Object> map);
	
	/**
	 * 
	 * @Title: zdrykcb_query
	 * @Description: TODO(考察)
	 * @param @param map
	 * @param @return    设定文件
	 * @return List<ZdryZdrykcxxb>    返回类型
	 * @throws
	 */
	public List<ZdryZdrykcxxb> zdrykcb_query(Map<String,Object> map);
	
	public ZdryZdrkxxb zdrkxxb_query (Map<String,Object> map);
	
	
	
	public ZdryZszhjsbrxxb zszhjsbrxxb_query(Map<String,Object> map);
	/**
	 * 
	 * @Title: lgxx_query
	 * @Description: TODO(列管信息)
	 * @param @param map
	 * @param @return    设定文件
	 * @return List<ZdrylgxxVO>    返回类型
	 * @throws
	 */
	public List<ZdrylgxxVO> lgxx_query(Map<String,Object> map);
	/**
	 * 
	 * @Title: shbzdry_query
	 * @Description: TODO(涉环保重点人员)
	 * @param @param map
	 * @param @return    设定文件
	 * @return List<ZdrylgxxVO>    返回类型
	 * @throws
	 */
	public ZdryShbzdryxxb shbzdry_query (Map<String,Object> map);
	
	
	/**
	 * 
	 * @Title: shbzdry_query
	 * @Description: TODO(涉环保重点人员)
	 * @param @param map
	 * @param @return    设定文件
	 * @return List<ZdrylgxxVO>    返回类型
	 * @throws
	 */
	public ZdrySqsbzdryxxb sqsbxxb_query (Map<String,Object> map);
}
