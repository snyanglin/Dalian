package com.founder.zafffwqz.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.zafffwqz.bean.Wfzjlzmb;

@Repository("wfzjlzmbDao")
public class WfzjlzmbDao extends BaseDaoImpl {

	public Wfzjlzmb queryWfzjlzmb(Wfzjlzmb entity) {
		// TODO Auto-generated method stub
		return (Wfzjlzmb) super.queryForObject("Wfzjlzmb.queryWfzjlzmbById", entity);
	}
	public void saveWfzjlzmb(Wfzjlzmb entity) {
		// TODO Auto-generated method stub
		super.insertForObject("Wfzjlzmb.saveWfzjlzmb", entity);
	}

	public int updateWfzjlzmb(Wfzjlzmb entity) {
		// TODO Auto-generated method stub
		return super.update("Wfzjlzmb.updateWfzjlzmb", entity);
	}

	public List<Wfzjlzmb> queryWfzjlzmbList(Map map) {
		// TODO Auto-generated method stub
		return super.queryForList("Wfzjlzmb.queryWfzjlzmbList", map);
	}
	public void removeWfzjlzmb(Wfzjlzmb entity) {
		// TODO Auto-generated method stub
		super.update("Wfzjlzmb.removeWfzjlzmb", entity);
	}
	public EasyUIPage queryList(EasyUIPage page, Map map) {
		// TODO Auto-generated method stub
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
		page.setTotal((Integer) queryForObject("Wfzjlzmb.queryWfzjlzmbCount", map));
		page.setRows(queryForList("Wfzjlzmb.queryWfzjlzmbList", map));
		return page;
	}

}
