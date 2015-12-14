package com.founder.syrkgl.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.StringUtils;
import com.founder.syrkgl.bean.RyRytbtsbjxxb;

/**
 * ****************************************************************************
 * @Package:      [com.founder.syrkgl.dao.RyRytbtsbjxxbDao.java]  
 * @ClassName:    [RyRytbtsbjxxbDao]   
 * @Description:  [实有人口附加信息-人员体表特殊标记信息表]   
 * @Author:       [xu_wenjun@founder.com.cn]  
 * @CreateDate:   [2015-4-12 下午11:26:34]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-4-12 下午11:26:34，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Repository("ryRytbtsbjxxbDao")
public class RyRytbtsbjxxbDao extends BaseDaoImpl {

	/**
	 * 查询列表<br>
	 * 
	 * @param page
	 * @param entity
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<RyRytbtsbjxxb> queryViewList(Map<String, Object> map) {
		List<RyRytbtsbjxxb> list = null;
		if (map != null) {
			String ryid = (String) map.get("ryid");
			if (!StringUtils.isBlank(ryid)) {
				list = queryForList("RyRytbtsbjxxb.queryViewList", map);
			}
		}
		return list;
	}

	/**
	 * @Title: queryById
	 * @Description: TODO(根据ID查询单条记录)
	 * @param @param id
	 * @param @return 设定文件
	 * @return RyRytbtsbjxxb 返回类型
	 * @throws
	 */
	public RyRytbtsbjxxb queryById(String id) {
		if (StringUtils.isBlank(id)) {
			return null;
		} else {
			return (RyRytbtsbjxxb) queryForObject("RyRytbtsbjxxb.queryById", id);
		}
	}

	/**
	 * 新增<br>
	 * 
	 * @param entity
	 */
	public void save(RyRytbtsbjxxb entity, SessionBean sessionBean) {
		insert("RyRytbtsbjxxb.save", entity);
	}

	/**
	 * 更新<br>
	 * 
	 * @param entity
	 */
	public void update(RyRytbtsbjxxb entity, SessionBean sessionBean) {
		update("RyRytbtsbjxxb.update", entity);
	}

	/**
	 * 删除<br>
	 * 
	 * @param entity
	 */
	public void delete(RyRytbtsbjxxb entity, SessionBean sessionBean) {
		update("RyRytbtsbjxxb.delete", entity);
	}
	
	/**
	 * 
	 * @Title: queryCount
	 * @Description: TODO(根据条件查询记录数)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return Integer    返回类型
	 * @throws
	 */
	public Integer queryCount(RyRytbtsbjxxb entity){
		return (Integer) queryForObject("RyRytbtsbjxxb.queryCount", entity);
	}

}
