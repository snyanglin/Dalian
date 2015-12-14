/**********************************************************************   
 * <p>文件名：ZakhCjclDao.java </p>
 * <p>文件描述：治安考核-基本信息采集常量持久类
 * @project_name：syrk
 * @author wu.w@founder.com.cn 
 * @date 2015-4-17 上午8:59:21 
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
import com.founder.zakh.bean.ZakhCjclBean;

/******************************************************************************
 * @Package:      [com.founder.zakh.dao.ZakhCjclDao.java]  
 * @ClassName:    [ZakhCjclDao]   
 * @Description:  [治安考核-基本信息采集常量持久类]   
 * @Author:       [wu.w@founder.com.cn]  
 * @CreateDate:   [2015-4-17 上午8:59:21]   
 * @UpdateUser:   [Way(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-4-17 上午8:59:21，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
@Repository("zakhCjclDao")
public class ZakhCjclDao extends BaseDaoImpl{
	/**
	 * 
	 * @Title: save
	 * @Description: 保存基本信息采集常量
	 * @param @param entity    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public void save(ZakhCjclBean entity){
		insert("ZakhCjcl.save", entity);
	}
	
	/**
	 * 
	 * @Title: delete
	 * @Description: 删除基本信息采集常量
	 * @param @param orgid
	 * @param @return    设定文件
	 * @return int    返回类型
	 * @throws
	 */
	public int delete(String orgid){
		return delete("ZakhCjcl.delete",orgid);
	}
	
	/**
	 * 
	 * @Title: update
	 * @Description: 更新基本信息采集常量
	 * @param @param entity
	 * @param @return    设定文件
	 * @return int    返回类型
	 * @throws
	 */
	public int update(ZakhCjclBean entity){
		return update("ZakhCjcl.update", entity);
	}
	
	/**
	 * 
	 * @Title: query
	 * @Description: 查询基本信息采集常量
	 * @param @param orgid or null
	 * @param @return    设定文件
	 * @return List<ZakhCjclBean>    返回类型
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	public List<ZakhCjclBean> query(Map<String,String> map){
		return queryForList("ZakhCjcl.query", map);
	}
	
	public Long querySumCl(Map<String,String> paramMap){
		return (Long)queryForObject("ZakhCjcl.querySumCl", paramMap);
	}
	
	
	@Test
	public void test(){
		
	}
	
}
