package com.founder.syrkgl.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.StringUtils;
import com.founder.syrkgl.bean.RyRytbtstzxxb;

/**
 * ****************************************************************************
 * @Package:      [com.founder.syrkgl.dao.RyRytbtstzxxbDao.java]  
 * @ClassName:    [RyRytbtstzxxbDao]   
 * @Description:  [实有人口附加信息-人员体表特殊特征信息表]   
 * @Author:       [xu_wenjun@founder.com.cn]  
 * @CreateDate:   [2015-4-12 下午10:35:17]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-4-12 下午10:35:17，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Repository("ryRytbtstzxxbDao")
public class RyRytbtstzxxbDao extends BaseDaoImpl {

	/**
	 * 查询列表<br>
	 * 
	 * @param page
	 * @param entity
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<RyRytbtstzxxb> queryViewList(Map<String, Object> map) {
		List<RyRytbtstzxxb> list = null;
		if (map != null) {
			String ryid = (String) map.get("ryid");
			if (!StringUtils.isBlank(ryid)) {
				list = queryForList("RyRytbtstzxxb.queryViewList", map);
			}
		}
		return list;
	}

	/**
	 * @Title: queryById
	 * @Description: TODO(根据ID查询单条记录)
	 * @param @param id
	 * @param @return 设定文件
	 * @return RyRytbtstzxxb 返回类型
	 * @throws
	 */
	public RyRytbtstzxxb queryById(String id) {
		if (StringUtils.isBlank(id)) {
			return null;
		} else {
			return (RyRytbtstzxxb) queryForObject("RyRytbtstzxxb.queryById", id);
		}
	}

	/**
	 * 新增<br>
	 * 
	 * @param entity
	 */
	public void save(RyRytbtstzxxb entity, SessionBean sessionBean) {
		insert("RyRytbtstzxxb.save", entity);
	}

	/**
	 * 更新<br>
	 * 
	 * @param entity
	 */
	public void update(RyRytbtstzxxb entity, SessionBean sessionBean) {
		update("RyRytbtstzxxb.update", entity);
	}

	/**
	 * 删除<br>
	 * 
	 * @param entity
	 */
	public void delete(RyRytbtstzxxb entity, SessionBean sessionBean) {
		update("RyRytbtstzxxb.delete", entity);
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
	public Integer queryCount(RyRytbtstzxxb entity){
		return (Integer) queryForObject("RyRytbtstzxxb.queryCount", entity);
	}

}
