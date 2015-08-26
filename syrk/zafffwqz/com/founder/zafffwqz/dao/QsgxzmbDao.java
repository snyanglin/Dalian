package com.founder.zafffwqz.dao;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.zafffwqz.bean.Qsgxrzb;
import com.founder.zafffwqz.bean.Qsgxzmb;
import com.founder.zafffwqz.bean.Wfzjlzmb;

@Repository("qsgxzmbDao")
public class QsgxzmbDao extends BaseDaoImpl {

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
		page.setTotal((Integer) queryForObject("Qsgxzmb.queryQsgxzmbCount", map));
		page.setRows(queryForList("Qsgxzmb.queryQsgxzmbList", map));
		return page;
	}

	public Qsgxzmb queryQsgxzmb(Qsgxzmb entity) {
		// TODO Auto-generated method stub
		return (Qsgxzmb) super.queryForObject("Qsgxzmb.queryQsgxzmbById", entity);
	}

	public void removeQsgxzmb(Qsgxzmb entity) {
		// TODO Auto-generated method stub
		super.update("Qsgxzmb.removeQsgxzmb", entity);
	}

	public void saveQsgxzmb(Qsgxzmb entity) {
		// TODO Auto-generated method stub
		super.insertForObject("Qsgxzmb.saveQsgxzmb", entity);
	}

	public void saveQsgxrzb(Qsgxrzb entity) {
		// TODO Auto-generated method stub
		super.insertForObject("Qsgxzmb.saveQsgxrzb", entity);
	}
	
	public EasyUIPage queryQsList(EasyUIPage page, Map map) {
		// TODO Auto-generated method stub
		map.put("begin", page.getBegin());
		map.put("end", page.getEnd());
		String sort = page.getSort();
		String order = page.getOrder();
		if (StringUtils.isBlank(sort)) { // 默认排序
			sort = "qsgxid";
			order = "asc";
		}
		map.put("sort", sort);
		map.put("order", order);
		page.setTotal((Integer) queryForObject("Qsgxzmb.queryQsCount", map));
		page.setRows(queryForList("Qsgxzmb.queryQsList", map));
		return page;
	}

	public void removeQsgxrzb(Qsgxrzb qsgxrzb) {
		// TODO Auto-generated method stub
		super.update("Qsgxzmb.removeQsgxrzb", qsgxrzb);
	}

}
