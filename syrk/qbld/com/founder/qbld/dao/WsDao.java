package com.founder.qbld.dao;

import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.utils.EasyUIPage;

/**
 * ****************************************************************************
 * @Package:      [com.founder.qbld.dao.WsDao.java]  
 * @ClassName:    [WsDao]   
 * @Description:  [临控申请dao]   
 * @Author:       [yu_sun@founder.com.cn]  
 * @CreateDate:   [2015-5-14 上午9:44:06]   
 * @UpdateUser:   [founder(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-5-14 上午9:44:06，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Repository("wsDao")
public class WsDao extends BaseDaoImpl {
	
	/**
	 * @Title: queryWsList
	 * @Description: TODO(临控申请列表查询)
	 * @param @param page
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	public List<?> queryWsList(EasyUIPage page, Map<String, Object> map) {
		return queryForList("Ws.queryWsList", map);
	}
	
	/**
	 * @Title: queryCountCkyj
	 * @Description: TODO(常控预警信息条数查询)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return long    返回类型
	 * @throws
	 */
	public long queryWsListCount(Map<String, Object> map) {
		Integer count = (Integer) queryForObject("Ws.queryWsCount", map);
		return count.longValue();
	}
	
}
