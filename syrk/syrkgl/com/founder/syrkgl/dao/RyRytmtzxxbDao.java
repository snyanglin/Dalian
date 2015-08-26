package com.founder.syrkgl.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.StringUtils;
import com.founder.syrkgl.bean.RyRytmtzxxb;

/**
 * ****************************************************************************
 * @Package:      [com.founder.syrkgl.dao.RyRytmtzxxbDao.java]  
 * @ClassName:    [RyRytmtzxxbDao]   
 * @Description:  [实有人口附加信息-人员体貌特征信息表]   
 * @Author:       [xu_wenjun@founder.com.cn]  
 * @CreateDate:   [2015-4-12 下午4:29:00]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-4-12 下午4:29:00，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Repository("ryRytmtzxxbDao")
public class RyRytmtzxxbDao extends BaseDaoImpl {

	/**
	 * 查询列表<br>
	 * 
	 * @param page
	 * @param entity
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<RyRytmtzxxb> queryViewList(Map<String, Object> map) {
		List<RyRytmtzxxb> list = null;
		if (map != null) {
			String ryid = (String) map.get("ryid");
			if (!StringUtils.isBlank(ryid)) {
				list = queryForList("RyRytmtzxxb.queryViewList", map);
			}
		}
		return list;
	}
	
	
	/***
	 * 
	 * @Title: queryByRyid
	 * @Description: TODO(根据人员ID查询特征)
	 * @param @param map
	 * @param @return    设定文件
	 * @return RyRytmtzxxb    返回类型
	 * @throws
	 */
	public RyRytmtzxxb queryByRyid(Map<String, Object> map){
		RyRytmtzxxb ryRytmtzxxb =null;
		if (map != null) {
			String ryid = (String) map.get("ryid");
			if (!StringUtils.isBlank(ryid)) {
			ryRytmtzxxb=(RyRytmtzxxb) queryForObject("RyRytmtzxxb.queryByRyid", map);
			}
		}
		return ryRytmtzxxb;
	}

	/**
	 * @Title: queryById
	 * @Description: TODO(根据ID查询单条记录)
	 * @param @param id
	 * @param @return 设定文件
	 * @return RyRytmtzxxb 返回类型
	 * @throws
	 */
	public RyRytmtzxxb queryById(String id) {
		if (StringUtils.isBlank(id)) {
			return null;
		} else {
			return (RyRytmtzxxb) queryForObject("RyRytmtzxxb.queryById", id);
		}
	}

	/**
	 * 新增<br>
	 * 
	 * @param entity
	 */
	public void save(RyRytmtzxxb entity, SessionBean sessionBean) {
		insert("RyRytmtzxxb.save", entity);
	}

	/**
	 * 更新<br>
	 * 
	 * @param entity
	 */
	public void update(RyRytmtzxxb entity, SessionBean sessionBean) {
		update("RyRytmtzxxb.update", entity);
	}

	/**
	 * 删除<br>
	 * 
	 * @param entity
	 */
	public void delete(RyRytmtzxxb entity, SessionBean sessionBean) {
		update("RyRytmtzxxb.delete", entity);
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
	public Integer queryCount(RyRytmtzxxb entity){
		return (Integer) queryForObject("RyRytmtzxxb.queryCount", entity);
	}

}
