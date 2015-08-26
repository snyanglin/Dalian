package com.founder.syrkgl.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.StringUtils;
import com.founder.syrkgl.bean.RyZyjwryxxb;

/**
 * ****************************************************************************
 * @Package:      [com.founder.syrkgl.dao.RyZyjwryxxbDao.java]  
 * @ClassName:    [RyZyjwryxxbDao]   
 * @Description:  [实有人口附加信息-人员主要交往人员信息表]   
 * @Author:       [cong_rihong@founder.com.cn]  
 * @CreateDate:   [2015-4-28 上午10:34:27]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-4-28 上午10:34:27，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Repository("ryZyjwryxxbDao")
public class RyZyjwryxxbDao extends BaseDaoImpl {

	/**
	 * 查询列表<br>
	 * 
	 * @param page
	 * @param entity
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<RyZyjwryxxb> queryViewList(Map<String, Object> map) {
		List<RyZyjwryxxb> list = null;
		if (map != null) {
			String ryid = (String) map.get("ryid");
			if (!StringUtils.isBlank(ryid)) {
				list = queryForList("RyZyjwryxxb.queryViewList", map);
			}
		}
		return list;
	}

	/**
	 * @Title: queryById
	 * @Description: TODO(根据ID查询单条记录)
	 * @param @param id
	 * @param @return 设定文件
	 * @return RyRybmchxxb 返回类型
	 * @throws
	 */
	public RyZyjwryxxb queryById(String id) {
		if (StringUtils.isBlank(id)) {
			return null;
		} else {
			return (RyZyjwryxxb) queryForObject("RyZyjwryxxb.queryById", id);
		}
	}

	/**
	 * 新增<br>
	 * 
	 * @param entity
	 */
	public void save(RyZyjwryxxb entity, SessionBean sessionBean) {
		insert("RyZyjwryxxb.save", entity);
	}

	/**
	 * 更新<br>
	 * 
	 * @param entity
	 */
	public void update(RyZyjwryxxb entity, SessionBean sessionBean) {
		update("RyZyjwryxxb.update", entity);
	}

	/**
	 * 删除<br>
	 * 
	 * @param entity
	 */
	public void delete(RyZyjwryxxb entity, SessionBean sessionBean) {
		update("RyZyjwryxxb.delete", entity);
	}
	
	/**
	 * 
	 * @Title: queryCount
	 * @Description: 根据条件查询记录数
	 * @param @param entity
	 * @param @return    设定文件
	 * @return Integer    返回类型
	 * @throws
	 */
	public Integer queryCount(RyZyjwryxxb entity){
		return (Integer) queryForObject("RyZyjwryxxb.queryCount", entity);
	}

}
