package com.founder.zafffwqz.dao;

import com.founder.framework.base.dao.BaseDaoImpl;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.zafffwqz.bean.Dsrxxzb;
import com.founder.zafffwqz.bean.DxqzxhdCbfxxb;
import com.founder.zafffwqz.bean.DxqzxhdFspxxb;



/******************************************************************************
 * @Package:      [com.founder.zafffwqz.dao.DxqzxhdfsplDao.java]  
 * @ClassName:    [DxqzxhdfsplDao]   
 * @Description:  [大型社会活动信息-非审批Dao]   
 * @Author:       [xu_haibo@founder.com.cn]  
 * @CreateDate:   [2015-5-21 上午9:30:52]   
 * @UpdateUser:   [haibo(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-5-21 上午9:30:52，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 */
@Repository("dxqzxhdfsplDao")
public class DxqzxhdfsplDao extends BaseDaoImpl {

/**
 * 
 * @Title: queryViewList
 * @Description: TODO(查询列表)
 * @param @param map
 * @param @return    设定文件
 * @return List<DxqzxhdFspxxb>    返回类型
 * @throws
 */
	@SuppressWarnings("unchecked")
	public List<DxqzxhdFspxxb> queryViewList(Map<String, Object> map) {
		List<DxqzxhdFspxxb> list = null;
		if (map != null) {
			String id = (String) map.get("id");
			if (!StringUtils.isBlank(id)) {
				list = queryForList("DxqzxhdFspxxb.queryViewList", map);
			}
		}
		return list;
	}

/**
 * 
 * @Title: queryById
 * @Description: TODO(根据ID查询单条记录)
 * @param @param id
 * @param @return    设定文件
 * @return DxqzxhdFspxxb    返回类型
 * @throws
 */
	public DxqzxhdFspxxb queryById(String id) {
		if (StringUtils.isBlank(id)) {
			return null;
		} else {
			return (DxqzxhdFspxxb) queryForObject("DxqzxhdFspxxb.queryById", id);
		}
	}

/**
 * 
 * @Title: save
 * @Description: TODO(新增)
 * @param @param entity
 * @param @param sessionBean    设定文件
 * @return void    返回类型
 * @throws
 */
	public void save(DxqzxhdFspxxb entity, SessionBean sessionBean) {
		insert("DxqzxhdFspxxb.save", entity);
	}

/**
 * 
 * @Title: update
 * @Description: TODO(更新)
 * @param @param entity
 * @param @param sessionBean    设定文件
 * @return void    返回类型
 * @throws
 */
	public void modifyFsp(DxqzxhdFspxxb entity, SessionBean sessionBean) {
		update("DxqzxhdFspxxb.modifyFsp", entity);
	}

/**
 * 
 * @Title: delete
 * @Description: TODO(删除)
 * @param @param entity
 * @param @param sessionBean    设定文件
 * @return void    返回类型
 * @throws
 */
	public void delete(DxqzxhdFspxxb entity, SessionBean sessionBean) {
		update("DxqzxhdFspxxb.delete", entity);
	}
	
/**
 * 
 * @Title: queryCount
 * @Description: TODO(根据条件查询记录数)
 * @param @param map
 * @param @return    设定文件
 * @return Integer    返回类型
 * @throws
 */
	public Integer queryCount( Map map){
		return (Integer) queryForObject("DxqzxhdFspxxb.queryCount", map);
	}
/**
 * 
 * @Title: queryList
 * @Description: TODO(分页查询)
 * @param @param page
 * @param @param map
 * @param @return    设定文件
 * @return EasyUIPage    返回类型
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
		page.setTotal((Integer) queryForObject("DxqzxhdFspxxb.queryCount", map));
		page.setRows(queryForList("DxqzxhdFspxxb.queryViewList", map));
		return page;
	}
	public DxqzxhdFspxxb queryDxqzxhdFspxxb(DxqzxhdFspxxb entity){
		return (DxqzxhdFspxxb) super.queryForObject("DxqzxhdFspxxb.queryDxqzxhdFspxxb", entity);
		
	}

}

