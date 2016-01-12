package com.founder.zdrygl.base.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.utils.EasyUIPage;

/**
 * ****************************************************************************
 * @Package:      [com.founder.qbld.dao.RyxsDao.java]  
 * @ClassName:    [RyxsDao]   
 * @Description:  [在逃基本信息]   
 * @Author:       [cong_rihong@founder.com.cn]  
 * @CreateDate:   [2015-12-7 上午9:30:05]   
 * @UpdateUser:   [founder(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-12-7 上午9:30:05，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Repository("zdryDtjsSaxxbDao")
public class ZdryDtjsSaxxbDao extends BaseDaoImpl {

	public List<?> queryList(EasyUIPage page, Map<String, Object> map) {
		return queryForList("ZdryDtjsSaxxb.queryPageByZdryZjhm", map);
	}

	
	/**
	 * @Title: queryCount
	 * @Description: TODO(涉案条数查询)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return long    返回类型
	 * @throws
	 */
	public long queryCount(Map<String, Object> map) {
		Integer count = (Integer) queryForObject("ZdryDtjsSaxxb.queryCountByZdryZjhm", map);
		return count.longValue();
	}	
	
	
}
