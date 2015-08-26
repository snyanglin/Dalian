package com.founder.xlff.dao;

import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.utils.EasyUIPage;
import com.founder.xlff.bean.Fkzl;
import com.founder.xlff.bean.Zlqsfk;

/**
 * ****************************************************************************
 * @Package:      [com.founder.xlff.dao.ZlxfDao.java]  
 * @ClassName:    [ZlxfDao]   
 * @Description:  [指令下发dao]   
 * @Author:       [yu_sun@founder.com.cn]  
 * @CreateDate:   [2015-6-24 上午10:21:05]   
 * @UpdateUser:   [founder(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-6-24 上午10:21:05，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Repository("zlxfDao")
public class ZlxfDao extends BaseDaoImpl {
	
	/**
	 * @Title: queryZlxfList
	 * @Description: TODO(查询指令列表)
	 * @param @param map
	 * @param @return    设定文件
	 * @return List<?>    返回类型
	 * @throws
	 */
	public List<?> queryZlxfList(EasyUIPage page, Map<String, Object> map) {
		return queryForList("Zlxf.queryZlxfList", map);
	}
	
	/**
	 * @Title: queryZlxfCount
	 * @Description: TODO(查询指令数量)
	 * @param @param map
	 * @param @return    设定文件
	 * @return long    返回类型
	 * @throws
	 */
	public long queryZlxfCount(Map<String, Object> map) {
		Integer count = (Integer) queryForObject("Zlxf.queryZlxfCount", map);
		return count.longValue();
	}	
	
	/**
	 * @Title: saveZlxf
	 * @Description: TODO(保存设置)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	public String saveZlxf(Fkzl entity) {
		insert("Zlxf.saveZlxf", entity); 
		return entity.getId();
	}
	
	/**
	 * @Title: saveFkzlqsfk
	 * @Description: TODO(批量保存指令签收反馈数据)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	public String saveFkzlqsfk(List<Zlqsfk> list) {
		insert("Zlxf.saveFkzlqsfk", list);
		return "";
	}
	
	/**
	 * @Title: queryZlqsfkList
	 * @Description: TODO(指令签收反馈表数据列表 )
	 * @param @param page
	 * @param @param map
	 * @param @return    设定文件
	 * @return List<?>    返回类型
	 * @throws
	 */
	public List<?> queryZlqsfkList(EasyUIPage page, Map<String, Object> map) {
		return queryForList("Zlxf.queryZlqsfkList", map);
	}
	
	/**
	 * @Title: queryZlqsfkCount
	 * @Description: TODO(指令前是否反馈总数)
	 * @param @param map
	 * @param @return    设定文件
	 * @return long    返回类型
	 * @throws
	 */
	public long queryZlqsfkCount(Map<String, Object> map) {
		Integer count = (Integer) queryForObject("Zlxf.queryZlqsfkCount", map);
		return count.longValue();
	}
	
	/**
	 * @Title: updateZlqsfk
	 * @Description: TODO(指令签收反馈操作-更新指令签收反馈表)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	public String updateZlqsfk(Zlqsfk entity) {
		update("Zlxf.updateZlqsfk", entity);
		return entity.getId();
	}
	
}
