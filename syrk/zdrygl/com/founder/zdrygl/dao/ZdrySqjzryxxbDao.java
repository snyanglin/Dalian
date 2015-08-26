package com.founder.zdrygl.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.utils.StringUtils;
import com.founder.zdrygl.bean.ZdrySqjzryxxb;

@Repository("zdrySqjzryxxbDao")
public class ZdrySqjzryxxbDao extends BaseDaoImpl {
	

	/**
	 * 
	 * @Title: save
	 * @Description: TODO(保存)
	 * @param @param entity    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public void save(ZdrySqjzryxxb entity) {
		insert("ZdrySqjzryxxb.save", entity);
	}

	/**
	 * 
	 * @Title: update
	 * @Description: TODO(更新)
	 * @param @param entity    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public void update(ZdrySqjzryxxb entity) {
		update("ZdrySqjzryxxb.update", entity);
	}

	/**
	 * 
	 * @Title: delete
	 * @Description: TODO(删除)
	 * @param @param entity    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public void delete(ZdrySqjzryxxb entity) {
		update("ZdrySqjzryxxb.delete", entity);
	}

	/***
	 * 
	 * @Title: queryById
	 * @Description: TODO(根据ID查询对象)
	 * @param @param id
	 * @param @return    设定文件
	 * @return ZdryShbzdryxxb    返回类型
	 * @throws
	 */
	public ZdrySqjzryxxb queryById(String id) {
		if (StringUtils.isBlank(id)) {
			return null;
		} else {
			return (ZdrySqjzryxxb) queryForObject("ZdrySqjzryxxb.queryById", id);
		}
	}
	
}
