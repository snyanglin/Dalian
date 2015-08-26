package com.founder.qbld.dao;

import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.utils.EasyUIPage;
import com.founder.qbld.bean.Ryxsb;

/**
 * ****************************************************************************
 * @Package:      [com.founder.qbld.dao.RyxsDao.java]  
 * @ClassName:    [RyxsDao]   
 * @Description:  [人员写实dao]   
 * @Author:       [yu_sun@founder.com.cn]  
 * @CreateDate:   [2015-5-5 上午9:30:05]   
 * @UpdateUser:   [founder(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-5-5 上午9:30:05，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Repository("ryxsDao")
public class RyxsDao extends BaseDaoImpl {
	
	/**
	 * @Title: queryRyxsList
	 * @Description: TODO(人员写实列表查询)
	 * @param @param page
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	public List<?> queryRyxsList(EasyUIPage page, Map<String, Object> map) {
		return queryForList("Ryxsb.queryRyxsList", map);
	}
	
	/**
	 * @Title: queryRyxsListCount
	 * @Description: TODO(人员写实条数查询)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return long    返回类型
	 * @throws
	 */
	public long queryRyxsListCount(Map<String, Object> map) {
		Integer count = (Integer) queryForObject("Ryxsb.queryRyxsListCount", map);
		return count.longValue();
	}	
	
	/**
	 * @Title: queryXs
	 * @Description: TODO(根据id获取人员写实详情信息)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return Ryxsb    返回类型
	 * @throws
	 */
	public Ryxsb queryRyxs(Map<String, Object> map) {
		return (Ryxsb) queryForObject("Ryxsb.queryRyxs", map);
	}	
	
	/**
	 * @Title: saveXscjb
	 * @Description: TODO(保存人员写实表数据)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	public String saveRyxsb(Ryxsb entity) {
		insert("Ryxsb.saveRyxsb", entity); 
		return entity.getId();
	}
	
}
