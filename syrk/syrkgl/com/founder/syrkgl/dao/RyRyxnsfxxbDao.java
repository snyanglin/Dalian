package com.founder.syrkgl.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.StringUtils;
import com.founder.syrkgl.bean.RyRyxnsfxxb;

/**
 * ****************************************************************************
 * @Package:      [com.founder.syrkgl.dao.RyRyxnsfxxbDao.java]  
 * @ClassName:    [RyRyxnsfxxbDao]   
 * @Description:  [实有人口附加信息-人员虚拟身份信息表]   
 * @Author:       [xu_wenjun@founder.com.cn]  
 * @CreateDate:   [2015-4-7 下午3:55:09]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-4-7 下午3:55:09，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Repository("ryRyxnsfxxbDao")
public class RyRyxnsfxxbDao extends BaseDaoImpl {

	/**
	 * 查询列表<br>
	 * 
	 * @param page
	 * @param entity
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<RyRyxnsfxxb> queryViewList(Map<String, Object> map) {
		List<RyRyxnsfxxb> list = null;
		if (map != null) {
			String ryid = (String) map.get("ryid");
			if (!StringUtils.isBlank(ryid)) {
				list = queryForList("RyRyxnsfxxb.queryViewList", map);
			}
		}
		return list;
	}

	/**
	 * @Title: queryById
	 * @Description: TODO(根据ID查询单条记录)
	 * @param @param id
	 * @param @return 设定文件
	 * @return RyRyxnsfxxb 返回类型
	 * @throws
	 */
	public RyRyxnsfxxb queryById(String id) {
		if (StringUtils.isBlank(id)) {
			return null;
		} else {
			return (RyRyxnsfxxb) queryForObject("RyRyxnsfxxb.queryById", id);
		}
	}

	/**
	 * 新增<br>
	 * 
	 * @param entity
	 */
	public void save(RyRyxnsfxxb entity, SessionBean sessionBean) {
		insert("RyRyxnsfxxb.save", entity);
	}

	/**
	 * 更新<br>
	 * 
	 * @param entity
	 */
	public void update(RyRyxnsfxxb entity, SessionBean sessionBean) {
		update("RyRyxnsfxxb.update", entity);
	}

	/**
	 * 删除<br>
	 * 
	 * @param entity
	 */
	public void delete(RyRyxnsfxxb entity, SessionBean sessionBean) {
		update("RyRyxnsfxxb.delete", entity);
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
	public Integer queryCount(RyRyxnsfxxb entity){
		return (Integer) queryForObject("RyRyxnsfxxb.queryCount", entity);
	} 

}
