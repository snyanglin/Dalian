package com.founder.qbld.dao;

import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.utils.EasyUIPage;
import com.founder.qbld.bean.LkyjxxQsb;
import com.founder.qbld.bean.LkyjczFkb;
import com.founder.qbld.bean.Lkyjxxb;

/**
 * ****************************************************************************
 * @Package:      [com.founder.qbld.dao.LkyjDao.java]  
 * @ClassName:    [LkyjDao]   
 * @Description:  [临控预警dao]   
 * @Author:       [yu_sun@founder.com.cn]  
 * @CreateDate:   [2015-4-22 上午10:07:34]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-4-22 上午10:07:34，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Repository("lkyjDao")
public class LkyjDao extends BaseDaoImpl {
	
	/**
	 * @Title: queryLkyjList
	 * @Description: TODO(临控预警信息列表查询)
	 * @param @param page
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	public List<?> queryLkyjList(EasyUIPage page, Map<String, Object> map) {
		return queryForList("Lkyj.queryLkyjList", map);
	}
	
	/**
	 * @Title: queryLkyjCount
	 * @Description: TODO(临控预警信息条数查询)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return long    返回类型
	 * @throws
	 */
	public long queryLkyjCount(Map<String, Object> map) {
		Integer count = (Integer) queryForObject("Lkyj.queryLkyjCount", map);
		return count.longValue();
	}	
	
	/**
	 * @Title: queryLkyj
	 * @Description: TODO(临控预警详情)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return Yjzlxxb    返回类型
	 * @throws
	 */
	public Lkyjxxb queryLkyj(Map<String, Object> map) {
		return (Lkyjxxb) queryForObject("Lkyj.queryLkyj", map);
	}
	
	/**
	 * @Title: queryLkyjFkb
	 * @Description: TODO(反馈记录查询服务-根据预警编号查询临控预警反馈表详情)
	 * @param @param entity
	 * @param @param map
	 * @param @return    设定文件
	 * @return Lkyjczfkb    返回类型
	 * @throws
	 */
	public LkyjczFkb queryLkyjFkb(Map<String, Object> map) {
		return (LkyjczFkb) queryForObject("Lkyj.queryLkyjFkb", map);
	}
	
	/**
	 * @Title: updateLkyjxxb
	 * @Description: TODO(更新临控信息表)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return int    返回类型
	 * @throws
	 */
	public int updateLkyjxxb(Lkyjxxb entity) {
		return update("Lkyj.updateLkyjxxb", entity); 
	}
	
	/**
	 * @Title: saveLkyjQs
	 * @Description: TODO(新增临控签收数据)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	public String saveLkyjQs(LkyjxxQsb entity) {
		insert("Lkyj.saveLkyjQs", entity); 
		return entity.getLkzlbh();
	}
	
	/**
	 * @Title: saveLkyjFk
	 * @Description: TODO(新增临控预警反馈表)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	public String saveLkyjFk(LkyjczFkb entity) {
		insert("Lkyj.saveLkyjFk", entity); 
		return entity.getLkzlbh();
	}
	
	/**
	 * @Title: queryLkyjFkList
	 * @Description: TODO(临控预警反馈信息列表查询)
	 * @param @param page
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	public List<?> queryLkyjFkList(EasyUIPage page, Map<String, Object> map) {
		return queryForList("Lkyj.queryLkyjFkList", map);
	}
	
	/**
	 * @Title: queryLkyjCount
	 * @Description: TODO(临控预警信息条数查询)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return long    返回类型
	 * @throws
	 */
	public long queryLkyjFkCount(Map<String, Object> map) {
		Integer count = (Integer) queryForObject("Lkyj.queryLkyjFkCount", map);
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
	public List<Map<String, String>> lkyjxxb_query_export(Map<String, Object> map) {
		 return queryForList("Lkyj.queryLkyjListExport", map);
	}
	
}
