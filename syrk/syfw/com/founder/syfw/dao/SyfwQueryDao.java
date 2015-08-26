package com.founder.syfw.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.syfw.vo.SyfwListVo;

@Repository("syfwQueryDao")
public class SyfwQueryDao extends BaseDaoImpl {


	/**
	 * 删除<br>
	 * 
	 * @param entity
	 */
	public void delete(SyfwListVo entity) {
		update("SyfwQuery.delete", entity);
	}
	
	/**
	 * 
	 * @Title: queryFw
	 * @Description: TODO(房屋列表查询)
	 * @param @param page
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	public EasyUIPage queryFw(EasyUIPage page, SyfwListVo entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("begin", page.getBegin());
		map.put("end", page.getEnd());
		String sort = page.getSort();
		String order = page.getOrder();
		if (StringUtils.isBlank(sort)) { // 默认排序
			//sort = "id";
			order = "asc";
		}
		map.put("sort", sort);
		map.put("order", order);
		map.put("fwjbxxb", entity);
		page.setTotal((Integer) queryForObject("SyfwQuery.queryCountFw", map));
		page.setRows(queryForList("SyfwQuery.queryFw", map));
		return page;
	}
	
	/**
	 * 延时实有房屋列表统计列表记录数<br>
	 * 
	 * @param page
	 * @param entity
	 * @return
	 */
	public long queryCountFw(SyfwListVo entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("fwjbxxb", entity);
		Integer count = (Integer) queryForObject("SyfwQuery.queryCountFw", map);
		return count.longValue();
	}

	public EasyUIPage querySyfw(SyfwListVo entity, EasyUIPage page) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("begin", page.getBegin());
		map.put("end", page.getEnd());
		map.put("fwjbxxb", entity);
		if(!StringUtils.isBlank(entity.getDrawType())&&!StringUtils.isBlank(entity.getDrawZbz())){
			map.put("tableName", "SYFW_FWJBXXB T, BZDZ_ADD_MLDZDXB_PT P");
		}else{
			map.put("tableName", "SYFW_FWJBXXB T");
		}
		List<?> list = queryForList("SyfwQuery.querySyfw", map);
		if (page.getBegin() == 0) {
			if (list != null && list.size() > 0) {
				page.setTotal(list.size());
			} else {
				page.setTotal(0);
			}
		} else {
			if (page.getTotal() == 0) {
				if (list != null && list.size() > 0) {
					page.setTotal(list.size());
				}
			}
		}
		page.setRows(list);
		return page;
	}

	public long querySyfwCount(SyfwListVo entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("fwjbxxb", entity);
		if(!StringUtils.isBlank(entity.getDrawType())&&!StringUtils.isBlank(entity.getDrawZbz())){
			map.put("tableName", "SYFW_FWJBXXB T, BZDZ_ADD_MLDZDXB_PT P");
		}else{
			map.put("tableName", "SYFW_FWJBXXB T");
		}
		Integer count = (Integer) queryForObject("SyfwQuery.querySyfwCount",map);
		return count.longValue();
	}

}
