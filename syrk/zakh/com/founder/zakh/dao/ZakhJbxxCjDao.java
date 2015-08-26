/**********************************************************************   
 * <p>文件名：ZakhJbxxCjDao.java </p>
 * <p>文件描述：治安考核-基本信息采集持久类
 * @project_name：syrk
 * @author wu.w@founder.com.cn 
 * @date 2015-4-17 上午8:59:04 
 * @history
 * @department：研发部
 *
*/
package com.founder.zakh.dao;

import java.util.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.zakh.bean.ZakhJbxxCjBean;

/******************************************************************************
 * @Package:      [com.founder.zakh.dao.ZakhJbxxCjDao.java]  
 * @ClassName:    [ZakhJbxxCjDao]   
 * @Description:  [治安考核-基本信息采集持久类]   
 * @Author:       [wu.w@founder.com.cn]  
 * @CreateDate:   [2015-4-17 上午8:59:04]   
 * @UpdateUser:   [Way(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-4-17 上午8:59:04，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
@Repository("zakhJbxxCjDao")
public class ZakhJbxxCjDao extends BaseDaoImpl {
	/**
	 * 
	 * @Title: save
	 * @Description: 保存基本信息采集信息
	 * @param entity    
	 * @return void    返回类型
	 * @throws
	 */
	public void save(ZakhJbxxCjBean entity){
		insert("ZakhJbxxCj.save", entity);
	}
	/**
	 * 
	 * @Title: saveByList
	 * @Description: 保存基本信息采集信息
	 * @param list    
	 * @return void    返回类型
	 * @throws
	 */
	public void saveByList(List<ZakhJbxxCjBean> list){
		insert("ZakhJbxxCj.saveByList", list);
	}
	
	/**
	 * 
	 * @Title: query
	 * @Description: 查询基本信息采集信息
	 * @param @param parameterObject
	 * @param @return    设定文件
	 * @return List<ZakhJbxxCjBean>    返回类型
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	public List<ZakhJbxxCjBean> query(Map<String,Object> parameterObject){
		return queryForList("ZakhJbxxCj.query", parameterObject);
	}
	
	/**
	 * @Title: getRHYZRK
	 * @Description: 统计人户一致人口
	 * @param @param parameterObject
	 * @param @return    设定文件
	 * @return List<Map<String,String>>    返回类型
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	public List<Map<String,Object>> getRHYZRK(Map<String,Object> parameterObject){
		return queryForList("ZakhJbxxCj.getRHYZRK", parameterObject);
	}
	
	/**
	 * @Title: getKGRK
	 * @Description: 统计口挂人口
	 * @param @param parameterObject
	 * @param @return    设定文件
	 * @return List<Map<String,String>>    返回类型
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	public List<Map<String,Object>> getKGRK(Map<String,Object> parameterObject){
		return queryForList("ZakhJbxxCj.getKGRK", parameterObject);
	}
	
	/**
	 * @Title: getJZRK
	 * @Description: 统计寄住人口
	 * @param @param parameterObject
	 * @param @return    设定文件
	 * @return List<Map<String,String>>    返回类型
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	public List<Map<String,Object>> getJZRK(Map<String,Object> parameterObject){
		return queryForList("ZakhJbxxCj.getJZRK", parameterObject);
	}
	
	/**
	 * @Title: getZZRK
	 * @Description: 统计暂住人口
	 * @param @param parameterObject
	 * @param @return    设定文件
	 * @return List<Map<String,String>>    返回类型
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	public List<Map<String,Object>> getZZRK(Map<String,Object> parameterObject){
		return queryForList("ZakhJbxxCj.getZZRK", parameterObject);
	}
	
	/**
	 * @Title: getJWRK
	 * @Description: 统计境外人口
	 * @param @param parameterObject
	 * @param @return    设定文件
	 * @return List<Map<String,String>>    返回类型
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	public List<Map<String,Object>> getJWRK(Map<String,Object> parameterObject){
		return queryForList("ZakhJbxxCj.getJWRK", parameterObject);
	}
	
	/**
	 * @Title: getWLHRK
	 * @Description: 统计未落户人口
	 * @param @param parameterObject
	 * @param @return    设定文件
	 * @return List<Map<String,String>>    返回类型
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	public List<Map<String,Object>> getWLHRK(Map<String,Object> parameterObject){
		return queryForList("ZakhJbxxCj.getWLHRK", parameterObject);
	}
	
	/**
	 * @Title: getCZFW
	 * @Description: 统计出租房屋
	 * @param @param parameterObject
	 * @param @return    设定文件
	 * @return List<Map<String,String>>    返回类型
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	public List<Map<String,Object>> getCZFW(Map<String,Object> parameterObject){
		return queryForList("ZakhJbxxCj.getCZFW", parameterObject);
	}
	
	/**
	 * @Title: getCZR
	 * @Description: 统计承租人
	 * @param @param parameterObject
	 * @param @return    设定文件
	 * @return List<Map<String,String>>    返回类型
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	public List<Map<String,Object>> getCZR(Map<String,Object> parameterObject){
		return queryForList("ZakhJbxxCj.getCZR", parameterObject);
	}
	
	/**
	 * @Title: getDWJBXX
	 * @Description: 统计单位基本信息
	 * @param @param parameterObject
	 * @param @return    设定文件
	 * @return List<Map<String,String>>    返回类型
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	public List<Map<String,Object>> getDWJBXX(Map<String,Object> parameterObject){
		return queryForList("ZakhJbxxCj.getDWJBXX", parameterObject);
	}
	
	/**
	 * @Title: getCYRY
	 * @Description: 统计从业人员
	 * @param @param parameterObject
	 * @param @return    设定文件
	 * @return List<Map<String,String>>    返回类型
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	public List<Map<String,Object>> getCYRY(Map<String,Object> parameterObject){
		return queryForList("ZakhJbxxCj.getCYRY", parameterObject);
	}
	
	/**
	 * @Title: getOrg
	 * @Description: 统计从业人员
	 * @param @param parameterObject
	 * @param @return    设定文件
	 * @return List<Map<String,String>>    返回类型
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	public List<Map<String,Object>> getORG(Map<String,Object> parameterObject){
		return queryForList("ZakhJbxxCj.getORG", parameterObject);
	}
	
	
	@Test
	public void test(){
//		Map<String,Object> map=new HashMap<String, Object>();
//		map.put("bweek", 3);
//		map.put("eweek", 8);
//		List<ZakhJbxxCjBean> list=query(map);
//		for(ZakhJbxxCjBean b:list){
//			System.out.println(b.getId()+"   "+b.getWeek());
//		}
		
//		Map<String,Object> map=new HashMap<String, Object>();
//		map.put("btime", "2015-04-10");
//		map.put("etime", "2015-04-20");
//		List<Map<String,Object>> list=getJZRK(map);
//		for(Map<String,Object> m:list){
//			System.out.println(m.get("ORGID")+"   "+m.get("ADDNUM").toString()+"   "+m.get("DELNUM").toString());
//		}
		
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("level", "50");
		map.put("type", "04");
		List<Map<String,Object>> list=getORG(map);
		for(Map<String,Object> m:list){
			System.out.println(m.get("ORGID")+"   "+m.get("ORGNAME").toString()+"   "+m.get("PARENTTREEPATH").toString());
		}
	}
}
