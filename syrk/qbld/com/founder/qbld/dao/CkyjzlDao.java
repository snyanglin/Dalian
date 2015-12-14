package com.founder.qbld.dao;

import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.utils.EasyUIPage;
import com.founder.qbld.bean.CkyjzlczFkb;
import com.founder.qbld.bean.CkyjzlQsb;
import com.founder.qbld.bean.Ckyjzlb;

/**
 * ****************************************************************************
 * @Package:      [com.founder.qbld.dao.CkyjzlDao.java]  
 * @ClassName:    [CkyjzlDao]   
 * @Description:  [预警指令dao]   
 * @Author:       [yu_sun@founder.com.cn]  
 * @CreateDate:   [2015-4-22 上午9:31:48]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-4-22 上午9:31:48，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Repository("ckyjzlDao")
public class CkyjzlDao extends BaseDaoImpl {
	
	/**
	 * @Title: queryCkyjzlList
	 * @Description: TODO(预警指令信息列表查询)
	 * @param @param page
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	public List<?> queryCkyjzlList(EasyUIPage page, Map<String, Object> map) {
		return queryForList("Ckyjzl.queryCkyjzlList", map);
	}
	
	/**
	 * @Title: queryCkyjzlCount
	 * @Description: TODO(预警指令信息条数查询)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return long    返回类型
	 * @throws
	 */
	public long queryCkyjzlCount(Map<String, Object> map) {
		Integer count = (Integer) queryForObject("Ckyjzl.queryCkyjzlCount", map);
		return count.longValue();
	}	
	
	/**
	 * @Title: queryCkyjzl
	 * @Description: TODO(根据id获取预警指令详情信息)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return Ckyjzlb    返回类型
	 * @throws
	 */
	public Ckyjzlb queryCkyjzl(Map<String, Object> map) {
		return (Ckyjzlb) queryForObject("Ckyjzl.queryCkyjzl", map);
	}	
	
	/**
	 * @Title: queryCkyjzlFkb
	 * @Description: TODO(查询预警指令反馈表)
	 * @param @param entity
	 * @param @param map
	 * @param @return    设定文件
	 * @return Ckyjzlfkb    返回类型
	 * @throws
	 */
	public CkyjzlczFkb queryCkyjzlFkb(Map<String, Object> map) {
		return (CkyjzlczFkb) queryForObject("Ckyjzl.queryCkyjzlFkb", map);
	}
	
	/**
	 * @Title: updateCkyjzlb
	 * @Description: TODO(更新预警指令信息表)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return int    返回类型
	 * @throws
	 */
	public int updateCkyjzlb(Ckyjzlb entity) {
		return update("Ckyjzl.updateCkyjzlb", entity); 
	}
	
	/**
	 * @Title: saveCkyjzlQs
	 * @Description: TODO(新增预警指令签收数据)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	public String saveCkyjzlQs(CkyjzlQsb entity) {
		insert("Ckyjzl.saveCkyjzlQs", entity); 
		return entity.getYjzlbh();
	}
	
	/**
	 * @Title: saveCkyjzlFk
	 * @Description: TODO(新增临控预警反馈表)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	public String saveCkyjzlFk(CkyjzlczFkb entity) {
		insert("Ckyjzl.saveCkyjzlFk", entity); 
		return entity.getYjzlbh();
	}
	
	/**
	 * @Title: queryCkyjzlFkList
	 * @Description: TODO(预警指令反馈信息列表查询)
	 * @param @param page
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	public List<?> queryCkyjzlFkList(EasyUIPage page, Map<String, Object> map) {
		return queryForList("Ckyjzl.queryCkyjzlFkList", map);
	}
	
	/**
	 * @Title: queryCkyjzlFkCount
	 * @Description: TODO(预警指令反馈信息条数查询)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return long    返回类型
	 * @throws
	 */
	public long queryCkyjzlFkCount(Map<String, Object> map) {
		Integer count = (Integer) queryForObject("Ckyjzl.queryCkyjzlFkCount", map);
		return count.longValue();
	}
	
	/**
	 * @Title: updateCkyjzlczFkb
	 * @Description: TODO(尿检物品修改功能)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	public String updateCkyjzlczFkb(CkyjzlczFkb entity) {
		return "" + update("Ckyjzl.updateCkyjzlczFkb", entity); 
	}
	
	/**
	 * @Title: cyryxxb_export
	 * @Description: TODO(常控警情导出功能)
	 * @param @param dwid
	 * @param @return    设定文件
	 * @return List<Map<String,String>>    返回类型
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	public List<Map<String, String>> ckyjzlb_query_export(Map<String, Object> map) {
		 return queryForList("Ckyjzl.queryCkyjzlListExport", map);
	}
	
}
