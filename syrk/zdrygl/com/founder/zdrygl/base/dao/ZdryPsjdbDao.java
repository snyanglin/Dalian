package com.founder.zdrygl.base.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.StringUtils;
import com.founder.zdrygl.base.model.ZdryPsjdb;


/**
 * ****************************************************************************
 * @Package:      [com.founder.zdrygl.base.dao.ZdryPsjdbDao.java]  
 * @ClassName:    [ZdryPsjdbDao]   
 * @Description:  [评审鉴定 DAO]   
 * @Author:       [zhang.hai@founder.com.cn]  
 * @CreateDate:   [2015年9月29日 下午3:31:58]   
 * @UpdateUser:   [ZhangHai(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015年9月29日 下午3:31:58，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Repository("zdryPsjdbDao")
public class ZdryPsjdbDao extends BaseDaoImpl {

	/**
	 * 
	 * @Title: queryViewList
	 * @Description: TODO(查询最近的 maxNum 条数据用于显示)
	 * @param @param map
	 * @param @return    设定文件
	 * @return List<ZdryPsjdb>    返回类型
	 * @throw
	 */
	public List<ZdryPsjdb> queryViewList(Map<String, Object> map) {
		List<ZdryPsjdb> list = null;
		if (map != null) {
			String zdryid = (String) map.get("zdryid");
			if (!StringUtils.isBlank(zdryid)) {
				list = queryForList("ZdryPsjdb.queryViewList", map);
			}
		}
		return list;
	}

	/**
	 * @Title: queryById
	 * @Description: TODO(根据ID查询单条记录)
	 * @param @param id
	 * @param @return 设定文件
	 * @return ZdryPsjdb 返回类型
	 * @throws
	 */
	public ZdryPsjdb queryById(String id) {
		if (StringUtils.isBlank(id)) {
			return null;
		} else {
			return (ZdryPsjdb) queryForObject("ZdryPsjdb.queryById", id);
		}
	}
	
	public void save(ZdryPsjdb entity, SessionBean sessionBean) {
		insert("ZdryPsjdb.save", entity);
	}
	
	public void update(ZdryPsjdb entity, SessionBean sessionBean) {
		update("ZdryPsjdb.update", entity);
	}

	
}
