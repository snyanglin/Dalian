package com.founder.qbld.dao;

import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.utils.EasyUIPage;
import com.founder.qbld.bean.LkyjzlQsb;
import com.founder.qbld.bean.LkyjzlczFkb;
import com.founder.qbld.bean.Lkyjzlb;

/**
 * ****************************************************************************
 * @Package:      [com.founder.qbld.dao.LkyjzlDao.java]  
 * @ClassName:    [LkyjzlDao]   
 * @Description:  [临控预警指令dao]   
 * @Author:       [yu_sun@founder.com.cn]  
 * @CreateDate:   [2015-4-22 上午9:31:48]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-4-22 上午9:31:48，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Repository("lkyjzlDao")
public class LkyjzlDao extends BaseDaoImpl {
	
	/**
	 * @Title: queryLkyjzlList
	 * @Description: TODO(临控预警指令信息列表查询)
	 * @param @param page
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	public List<?> queryLkyjzlList(EasyUIPage page, Map<String, Object> map) {
		return queryForList("Lkyjzl.queryLkyjzlList", map);
	}
	
	/**
	 * @Title: queryLkyjzlCount
	 * @Description: TODO(预警指令信息条数查询)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return long    返回类型
	 * @throws
	 */
	public long queryLkyjzlCount(Map<String, Object> map) {
		Integer count = (Integer) queryForObject("Lkyjzl.queryLkyjzlCount", map);
		return count.longValue();
	}	
	
	/**
	 * @Title: queryLkyjzl
	 * @Description: TODO(根据id获取预警指令详情信息)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return Lkyjzlb    返回类型
	 * @throws
	 */
	public Lkyjzlb queryLkyjzl(Map<String, Object> map) {
		return (Lkyjzlb) queryForObject("Lkyjzl.queryLkyjzl", map);
	}	
	
	/**
	 * @Title: queryLkyjzlFkb
	 * @Description: TODO(查询预警指令反馈表)
	 * @param @param entity
	 * @param @param map
	 * @param @return    设定文件
	 * @return Lkyjzlfkb    返回类型
	 * @throws
	 */
	public LkyjzlczFkb queryLkyjzlFkb(Map<String, Object> map) {
		return (LkyjzlczFkb) queryForObject("Lkyjzl.queryLkyjzlFkb", map);
	}
	
	/**
	 * @Title: updateLkyjzlb
	 * @Description: TODO(更新预警指令信息表)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return int    返回类型
	 * @throws
	 */
	public int updateLkyjzlb(Lkyjzlb entity) {
		return update("Lkyjzl.updateLkyjzlb", entity); 
	}
	
	/**
	 * @Title: saveLkyjzlQs
	 * @Description: TODO(新增预警指令签收数据)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	public String saveLkyjzlQs(LkyjzlQsb entity) {
		insert("Lkyjzl.saveLkyjzlQs", entity); 
		return entity.getLkzlbh();
	}
	
	/**
	 * @Title: saveLkyjzlFk
	 * @Description: TODO(新增临控预警反馈表)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	public String saveLkyjzlFk(LkyjzlczFkb entity) {
		insert("Lkyjzl.saveLkyjzlFk", entity); 
		return entity.getLkzlbh();
	}
	
	/**
	 * @Title: queryLkyjzlFkList
	 * @Description: TODO(预警指令反馈信息列表查询)
	 * @param @param page
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	public List<?> queryLkyjzlFkList(EasyUIPage page, Map<String, Object> map) {
		return queryForList("Lkyjzl.queryLkyjzlFkList", map);
	}
	
	/**
	 * @Title: queryLkyjzlFkCount
	 * @Description: TODO(预警指令反馈信息条数查询)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return long    返回类型
	 * @throws
	 */
	public long queryLkyjzlFkCount(Map<String, Object> map) {
		Integer count = (Integer) queryForObject("Lkyjzl.queryLkyjzlFkCount", map);
		return count.longValue();
	}
	
	/**
	 * @Title: lkyjxxb_query_export
	 * @Description: TODO(临控预警导出功能)
	 * @param @param dwid
	 * @param @return    设定文件
	 * @return List<Map<String,String>>    返回类型
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	public List<Map<String, String>> lkyjzlb_query_export(Map<String, Object> map) {
		 return queryForList("Lkyjzl.queryLkyjzlListExport", map);
	}
	
}
