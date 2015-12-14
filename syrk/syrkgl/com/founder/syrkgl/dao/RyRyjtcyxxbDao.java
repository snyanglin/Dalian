package com.founder.syrkgl.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.StringUtils;
import com.founder.syrkgl.bean.RyRyjtcyxxb;

/**
 * ****************************************************************************
 * @Package:      [com.founder.syrkgl.dao.RyRyjtcyxxbDao.java]  
 * @ClassName:    [RyRyjtcyxxbDao]   
 * @Description:  [实有人口附加信息-人员家庭成员信息表]   
 * @Author:       [xu_wenjun@founder.com.cn]  
 * @CreateDate:   [2015-4-10 上午9:41:46]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-4-10 上午9:41:46，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Repository("ryRyjtcyxxbDao")
public class RyRyjtcyxxbDao extends BaseDaoImpl {

	/**
	 * 查询列表<br>
	 * 
	 * @param page
	 * @param entity
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<RyRyjtcyxxb> queryViewList(Map<String, Object> map) {
		List<RyRyjtcyxxb> list = null;
		if (map != null) {
			String ryid = (String) map.get("ryid");
			if (!StringUtils.isBlank(ryid)) {
				list = queryForList("RyRyjtcyxxb.queryViewList", map);
			}
		}
		return list;
	}

	/**
	 * @Title: queryById
	 * @Description: TODO(根据ID查询单条记录)
	 * @param @param id
	 * @param @return 设定文件
	 * @return RyRyjtcyxxb 返回类型
	 * @throws
	 */
	public RyRyjtcyxxb queryById(String id) {
		if (StringUtils.isBlank(id)) {
			return null;
		} else {
			return (RyRyjtcyxxb) queryForObject("RyRyjtcyxxb.queryById", id);
		}
	}

	/**
	 * 新增<br>
	 * 
	 * @param entity
	 */
	public void save(RyRyjtcyxxb entity, SessionBean sessionBean) {
		insert("RyRyjtcyxxb.save", entity);
	}

	/**
	 * 更新<br>
	 * 
	 * @param entity
	 */
	public void update(RyRyjtcyxxb entity, SessionBean sessionBean) {
		update("RyRyjtcyxxb.update", entity);
	}

	/**
	 * 删除<br>
	 * 
	 * @param entity
	 */
	public void delete(RyRyjtcyxxb entity, SessionBean sessionBean) {
		update("RyRyjtcyxxb.delete", entity);
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
	public Integer queryCount(RyRyjtcyxxb entity){
		return (Integer) queryForObject("RyRyjtcyxxb.queryCount", entity);
	}

}
