package com.founder.zafffwqz.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.StringUtils;
import com.founder.zafffwqz.bean.DxqzxhdCbfxxb;


/******************************************************************************
 * @Package:      [com.founder.zafffwqz.dao.DxqzxhdCbfxxbDao.java]  
 * @ClassName:    [DxqzxhdCbfxxbDao]   
 * @Description:  [大型群众性活动管理-承办方信息表]   
 * @Author:       [xuhaibo@founder.com.cn]  
 * @CreateDate:   [2015-5-14 中午12:50:47]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-5-14 中午12:50:47，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 */
@Repository("dxqzxhdCbfxxbDao")
public class DxqzxhdCbfxxbDao extends BaseDaoImpl {

	/**
	 * 查询列表<br>
	 * 
	 * @param page
	 * @param entity
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<DxqzxhdCbfxxb> queryViewList(Map<String, Object> map) {
		List<DxqzxhdCbfxxb> list = null;
		if (map != null) {
			String ryid = (String) map.get("ryid");
			if (!StringUtils.isBlank(ryid)) {
				list = queryForList("DxqzxhdCbfxxb.queryViewList", map);
			}
		}
		return list;
	}

	/**
	 * @Title: queryById
	 * @Description: TODO(根据ID查询单条记录)
	 * @param @param id
	 * @param @return 设定文件
	 * @return DxqzxhdCbfxxb 返回类型
	 * @throws
	 */
	public DxqzxhdCbfxxb queryById(String id) {
		if (StringUtils.isBlank(id)) {
			return null;
		} else {
			return (DxqzxhdCbfxxb) queryForObject("DxqzxhdCbfxxb.queryById", id);
		}
	}

	/**
	 * 新增<br>
	 * 
	 * @param entity
	 */
	public void save(DxqzxhdCbfxxb entity, SessionBean sessionBean) {
		insert("DxqzxhdCbfxxb.save", entity);
	}

	/**
	 * 更新<br>
	 * 
	 * @param entity
	 */
	public void update(DxqzxhdCbfxxb entity, SessionBean sessionBean) {
		update("DxqzxhdCbfxxb.update", entity);
	}

	/**
	 * 删除<br>
	 * 
	 * @param entity
	 */
	public void delete(DxqzxhdCbfxxb entity, SessionBean sessionBean) {
		update("DxqzxhdCbfxxb.delete", entity);
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
	public Integer queryCount(DxqzxhdCbfxxb entity){
		return (Integer) queryForObject("DxqzxhdCbfxxb.queryCount", entity);
	}

}
