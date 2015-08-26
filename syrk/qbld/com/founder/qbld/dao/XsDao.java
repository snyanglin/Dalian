package com.founder.qbld.dao;

import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.utils.EasyUIPage;
import com.founder.qbld.bean.Xscjb;

/**
 * ****************************************************************************
 * @Package:      [com.founder.qbld.dao.XsDao.java]  
 * @ClassName:    [XsDao]   
 * @Description:  [线索dao]   
 * @Author:       [yu_sun@founder.com.cn]  
 * @CreateDate:   [2015-5-4 下午1:58:05]   
 * @UpdateUser:   [founder(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-5-4 下午1:58:05，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Repository("xsDao")
public class XsDao extends BaseDaoImpl {
	
	/**
	 * @Title: queryXsList
	 * @Description: TODO(线索列表查询)
	 * @param @param page
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	public List<?> queryXsList(EasyUIPage page, Map<String, Object> map) {
		return queryForList("Xscjb.queryXsList", map);
	}
	
	/**
	 * @Title: queryXsCount
	 * @Description: TODO(线索条数查询)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return long    返回类型
	 * @throws
	 */
	public long queryXsCount(Map<String, Object> map) {
		Integer count = (Integer) queryForObject("Xscjb.queryXsCount", map);
		return count.longValue();
	}	
	
	/**
	 * @Title: queryXs
	 * @Description: TODO(根据id获取线索详情信息)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return Xscjb    返回类型
	 * @throws
	 */
	public Xscjb queryXs(Map<String, Object> map) {
		return (Xscjb) queryForObject("Xscjb.queryXs", map);
	}	
	
	/**
	 * @Title: saveXscjb
	 * @Description: TODO(保存线索采集表数据)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	public String saveXscjb(Xscjb entity) {
		insert("Xscjb.saveXscjb", entity); 
		return entity.getJlid();
	}

	/**
	 * @Title: updateXsb
	 * @Description: TODO(记录调用ws接口报错字段信息)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return int    返回类型
	 * @throws
	 */
	public int updateXsb(Xscjb entity) {
		return update("Xscjb.updateXsb", entity); 
	}
	
}
