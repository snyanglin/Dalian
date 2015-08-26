package com.founder.zafffwqz.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.zafffwqz.bean.DxqzxhdCbfxxb;
import com.founder.zafffwqz.bean.DxqzxhdDxhdjbxxb;


/******************************************************************************
 * @Package:      [com.founder.zafffwqz.dao.DxqzxhdDxhdjbxxbDao.java]  
 * @ClassName:    [DxqzxhdDxhdjbxxbDao]   
 * @Description:  [大型群众性活动管理-大型活动基本信息表]   
 * @Author:       [xuhaibo@founder.com.cn]  
 * @CreateDate:   [2015-5-14 中午12:50:47]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-5-14 中午12:50:47，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 */
@Repository("dxqzxhdDxhdjbxxbDao")
public class DxqzxhdDxhdjbxxbDao extends BaseDaoImpl {

	/**
	 * 查询列表<br>
	 * 
	 * @param page
	 * @param entity
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<DxqzxhdDxhdjbxxb> queryViewList(Map<String, Object> map) {
		List<DxqzxhdDxhdjbxxb> list = null;
		if (map != null) {
			String ryid = (String) map.get("ryid");
			if (!StringUtils.isBlank(ryid)) {
				list = queryForList("DxqzxhdDxhdjbxxb.queryViewList", map);
			}
		}
		return list;
	}

	/**
	 * @Title: queryById
	 * @Description: TODO(根据ID查询单条记录)
	 * @param @param id
	 * @param @return 设定文件
	 * @return DxqzxhdDxhdjbxxb 返回类型
	 * @throws
	 */
	public DxqzxhdDxhdjbxxb queryById(String id) {
		if (StringUtils.isBlank(id)) {
			return null;
		} else {
			return (DxqzxhdDxhdjbxxb) queryForObject("DxqzxhdDxhdjbxxb.queryById", id);
		}
	}

	/**
	 * 新增<br>
	 * 
	 * @param entity
	 */
	public void save(DxqzxhdDxhdjbxxb entity, SessionBean sessionBean) {
		insert("DxqzxhdDxhdjbxxb.save", entity);
	}

	/**
	 * 更新<br>
	 * 
	 * @param entity
	 */
	public void update(DxqzxhdDxhdjbxxb entity, SessionBean sessionBean) {
		update("DxqzxhdDxhdjbxxb.update", entity);
	}

	/**
	 * 删除<br>
	 * 
	 * @param entity
	 */
	public void delete(DxqzxhdDxhdjbxxb entity, SessionBean sessionBean) {
		update("DxqzxhdDxhdjbxxb.delete", entity);
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
	public Integer queryCount(DxqzxhdDxhdjbxxb entity){
		return (Integer) queryForObject("DxqzxhdDxhdjbxxb.queryCount", entity);
	}

	/**
	 * 
	 * @Title: queryList
	 * @Description: TODO(分页查询)
	 * @param @param page
	 * @param @return    设定文件
	 * @return Integer    返回类型
	 * @throws
	 */
	public EasyUIPage queryList(EasyUIPage page, Map map){
		map.put("begin", page.getBegin());
		map.put("end", page.getEnd());
		String sort = page.getSort();
		String order = page.getOrder();
		if (StringUtils.isBlank(sort)) { // 默认排序
			sort = "id";
			order = "asc";
		}
		map.put("sort", sort);
		map.put("order", order);
		page.setTotal((Integer) queryForObject("DxqzxhdDxhdjbxxb.queryCount", map));
		page.setRows(queryForList("DxqzxhdDxhdjbxxb.queryList", map));
		return page;
	}
}
