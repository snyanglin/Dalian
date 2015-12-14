package com.founder.qbld.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.utils.EasyUIPage;
import com.founder.qbld.bean.Lksqb;

/**
 * ****************************************************************************
 * @Package:      [com.founder.qbld.dao.LksqDao.java]  
 * @ClassName:    [LksqDao]   
 * @Description:  [临控申请dao]   
 * @Author:       [yu_sun@founder.com.cn]  
 * @CreateDate:   [2015-5-14 上午9:44:06]   
 * @UpdateUser:   [founder(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-5-14 上午9:44:06，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Repository("lksqDao")
public class LksqDao extends BaseDaoImpl {
	
	/**
	 * @Title: queryLksqList
	 * @Description: TODO(临控申请列表查询)
	 * @param @param page
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	public List<?> queryLksqList(EasyUIPage page, Map<String, Object> map) {
		return queryForList("Lksq.queryLksqList", map);
	}
	
	/**
	 * @Title: queryCountCkyj
	 * @Description: TODO(常控预警信息条数查询)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return long    返回类型
	 * @throws
	 */
	public long queryLksqListCount(Map<String, Object> map) {
		Integer count = (Integer) queryForObject("Lksq.queryLksqCount", map);
		return count.longValue();
	}
	
	/**
	 * @Title: queryLksqb
	 * @Description: TODO(临控申请详情查询服务)
	 * @param @param entity
	 * @param @param map
	 * @param @return    设定文件
	 * @return Lksqb    返回类型
	 * @throws
	 */
	public Lksqb queryLksqb(Lksqb entity, Map<String, Object> map) {
		return (Lksqb) queryForObject("Lksq.queryLksqb", map);
	}	
	
	
	/**
	 * @Title: saveLksqb
	 * @Description: TODO(保存临控申请表-临控申请)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	public String saveLksqb(Lksqb entity) {
		insert("Lksq.saveLksqb", entity); 
		return entity.getXxbkzxbh();
	}
	
}
