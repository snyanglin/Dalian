package com.founder.syrkgl.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.StringUtils;
import com.founder.syrkgl.bean.RyRyhykxxb;


/******************************************************************************
 * @Package:      [com.founder.syrkgl.dao.RyRyhykxxbDao.java]  
 * @ClassName:    [RyRyhykxxbDao]   
 * @Description:  [实有人口附加信息-人员会员卡信息表]   
 * @Author:       [congrihong@founder.com.cn]  
 * @CreateDate:   [2015-4-8 下午4:06:51]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-4-8 下午4:06:51，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 */
@Repository("ryRyhykxxbDao")
public class RyRyhykxxbDao extends BaseDaoImpl {

	/**
	 * 查询列表<br>
	 * 
	 * @param page
	 * @param entity
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<RyRyhykxxb> queryViewList(Map<String, Object> map) {
		List<RyRyhykxxb> list = null;
		if (map != null) {
			String ryid = (String) map.get("ryid");
			if (!StringUtils.isBlank(ryid)) {
				list = queryForList("RyRyhykxxb.queryViewList", map);
			}
		}
		return list;
	}

	/**
	 * @Title: queryById
	 * @Description: TODO(根据ID查询单条记录)
	 * @param @param id
	 * @param @return 设定文件
	 * @return Rybmchxxb 返回类型
	 * @throws
	 */
	public RyRyhykxxb queryById(String id) {
		if (StringUtils.isBlank(id)) {
			return null;
		} else {
			return (RyRyhykxxb) queryForObject("RyRyhykxxb.queryById", id);
		}
	}

	/**
	 * 新增<br>
	 * 
	 * @param entity
	 */
	public void save(RyRyhykxxb entity, SessionBean sessionBean) {
		insert("RyRyhykxxb.save", entity);
	}

	/**
	 * 更新<br>
	 * 
	 * @param entity
	 */
	public void update(RyRyhykxxb entity, SessionBean sessionBean) {
		update("RyRyhykxxb.update", entity);
	}

	/**
	 * 删除<br>
	 * 
	 * @param entity
	 */
	public void delete(RyRyhykxxb entity, SessionBean sessionBean) {
		update("RyRyhykxxb.delete", entity);
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
	public Integer queryCount(RyRyhykxxb entity){
		return (Integer) queryForObject("RyRyhykxxb.queryCount", entity);
	}

}
