package com.founder.syrkgl.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.StringUtils;
import com.founder.syrkgl.bean.RyRyhykxxb;
import com.founder.syrkgl.bean.RyRyjlxxb;



/******************************************************************************
 * @Package:      [com.founder.syrkgl.dao.RyRyjlxxbDao.java]  
 * @ClassName:    [RyRyjlxxbDao]   
 * @Description:  [实有人口附加信息-人员经历信息表]   
 * @Author:       [congrihong@founder.com.cn]  
 * @CreateDate:   [2015-4-10 上午10:01:10]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-4-10 上午10:01:10，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 */
@Repository("ryRyjlxxbDao")
public class RyRyjlxxbDao extends BaseDaoImpl {


	/**
	 * @Title: queryById
	 * @Description: TODO(根据ID查询单条记录)
	 * @param @param id
	 * @param @return 设定文件
	 * @return Rybmchxxb 返回类型
	 * @throws
	 */
	public RyRyjlxxb queryById(String id) {
		if (StringUtils.isBlank(id)) {
			return null;
		} else {
			return (RyRyjlxxb) queryForObject("RyRyjlxxb.queryById", id);
		}
	}

	@SuppressWarnings("unchecked")
	public List<RyRyjlxxb> queryViewList(Map<String, Object> map) {
		List<RyRyjlxxb> list = null;
		if (map != null) {
			String ryid = (String) map.get("ryid");
			if (!StringUtils.isBlank(ryid)) {
				list = queryForList("RyRyjlxxb.queryViewList", map);
			}
		}
		return list;
	}
	
	
	/**
	 * 新增<br>
	 * 
	 * @param entity
	 */
	public void save(RyRyjlxxb entity, SessionBean sessionBean) {
		insert("RyRyjlxxb.save", entity);
	}

	/**
	 * 更新<br>
	 * 
	 * @param entity
	 */
	public void update(RyRyjlxxb entity, SessionBean sessionBean) {
		update("RyRyjlxxb.update", entity);
	}



}
