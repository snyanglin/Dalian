package com.founder.xlff.dao;

import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.xlff.bean.Option;
import com.founder.xlff.vo.Sf_Organization;

/**
 * ****************************************************************************
 * @Package:      [com.founder.xlff.dao.XlffDao.java]  
 * @ClassName:    [XlffDao]   
 * @Description:  [巡逻防范dao]   
 * @Author:       [yu_sun@founder.com.cn]  
 * @CreateDate:   [2015-6-17 上午11:35:05]   
 * @UpdateUser:   [founder(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-6-17 上午11:35:05，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Repository("xlffDao")
public class XlffDao extends BaseDaoImpl {
	
	/**
	 * @Title: queryOption
	 * @Description: TODO(查询设置)
	 * @param @param map
	 * @param @return    设定文件
	 * @return Option    返回类型
	 * @throws
	 */
	public Option queryOption(Map<String, Object> map) {
		return (Option) queryForObject("Option.queryOption", map);
	}	
	
	/**
	 * @Title: saveOption
	 * @Description: TODO(保存设置)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	public String saveOption(Option entity) {
		insert("Option.saveOption", entity); 
		return entity.getOrgcode();
	}
	
	/**
	 * @Title: updateCkyjxxb
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return int    返回类型
	 * @throws
	 */
	public int updateOption(Option entity) {
		return update("Option.updateOption", entity); 
	}
	
	/**
	 * @Title: queryTree
	 * @Description: TODO(四色预警画面)
	 * @param @param id
	 * @param @param orgcode
	 * @param @param flag
	 * @param @return    设定文件
	 * @return List<Sf_Organization>    返回类型
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	 public List<Sf_Organization> queryTree( Map<String, Object> map) {
		 return queryForList("Option.queryTree", map);
	 }
	 
	 /**
		 * @Title: queryXjZzjgxj
		 * @描述: 获取组织机构
		 * @参数: 传入参数定义
		 * @返回值: List<Sf_Organization> 返回类型 
		 * @throws
		 */
		@SuppressWarnings("unchecked")
		public List<Sf_Organization> queryXjZzjgxj(List<Sf_Organization> list) {
			return queryForList("Option.queryXjZzjgxj", list);
		}
		
		/**
		 * @Title: queryCountJq
		 * @描述:查询警情数量信息
		 * @参数: 传入参数定义
		 * @日期： 2014-10-25 下午4:43:03
		 * @返回值:long 返回类型
		 * @throws
		 */
		public long queryCountJq(Map<String, Object> map) {
			 Integer count = (Integer) queryForObject("Option.queryCountJq",map);
			 return count.longValue();
		}
		
	
}
