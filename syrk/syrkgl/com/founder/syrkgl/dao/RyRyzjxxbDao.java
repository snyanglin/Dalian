package com.founder.syrkgl.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.StringUtils;
import com.founder.syrkgl.bean.RyRyzjxxb;

/**
 * ****************************************************************************
 * @Package:      [com.founder.syrkgl.dao.RyRyzjxxbDao.java]  
 * @ClassName:    [RyRyzjxxbDao]   
 * @Description:  [实有人口附加信息-人员证件信息表]   
 * @Author:       [xu_wenjun@founder.com.cn]  
 * @CreateDate:   [2015-4-3 下午3:29:40]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-4-3 下午3:29:40，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Repository("ryRyzjxxbDao")
public class RyRyzjxxbDao extends BaseDaoImpl {

	/**
	 * 查询列表<br>
	 * 
	 * @param page
	 * @param entity
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<RyRyzjxxb> queryViewList(Map<String, Object> map) {
		List<RyRyzjxxb> list = null;
		if (map != null) {
			String ryid = (String) map.get("ryid");
			if (!StringUtils.isBlank(ryid)) {
				list = queryForList("RyRyzjxxb.queryViewList", map);
			}
		}
		return list;
	}

	/**
	 * @Title: queryById
	 * @Description: TODO(根据ID查询单条记录)
	 * @param @param id
	 * @param @return 设定文件
	 * @return RyRyzjxxb 返回类型
	 * @throws
	 */
	public RyRyzjxxb queryById(String id) {
		if (StringUtils.isBlank(id)) {
			return null;
		} else {
			return (RyRyzjxxb) queryForObject("RyRyzjxxb.queryById", id);
		}
	}

	/**
	 * 新增<br>
	 * 
	 * @param entity
	 */
	public void save(RyRyzjxxb entity, SessionBean sessionBean) {
		insert("RyRyzjxxb.save", entity);
	}

	/**
	 * 更新<br>
	 * 
	 * @param entity
	 */
	public void update(RyRyzjxxb entity, SessionBean sessionBean) {
		update("RyRyzjxxb.update", entity);
	}

	/**
	 * 删除<br>
	 * 
	 * @param entity
	 */
	public void delete(RyRyzjxxb entity, SessionBean sessionBean) {
		update("RyRyzjxxb.delete", entity);
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
	public Integer queryCount(RyRyzjxxb entity){
		return (Integer) queryForObject("RyRyzjxxb.queryCount", entity);
	} 

}
