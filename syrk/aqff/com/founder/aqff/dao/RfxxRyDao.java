package com.founder.aqff.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.aqff.bean.Aqffrfryxxb;
import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;

/**
@Repository("rfxxryDao")
public class RfxxRyDao extends BaseDaoImpl {
	

	 * 人防成员的相关
	 * @param entity
	
	public void saveRfcyxx(Aqffrfryxxb entity) {
		super.insertForObject("Zaff_rfxxb.saveRfcyxx", entity);
	}
	public Aqffrfryxxb queryRfcyxxById(Aqffrfryxxb entity) {
		return (Aqffrfryxxb) super.queryForObject("Zaff_rfxxb.queryRfcyxxById", entity);
	}
	public int updateRfcyxx(Aqffrfryxxb entity) {
		return super.update("Zaff_rfxxb.updateRfcyxx", entity);
	}
	public int deleteRfcyxx(Aqffrfryxxb entity) {
		return super.update("Zaff_rfxxb.deleteRfcyxx", entity);
	}
	
	public EasyUIPage queryRfcyxx(EasyUIPage page, Aqffrfryxxb entity) {
		Map<String, Object> map = new HashMap<String, Object>();
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
		map.put("rfcyxxb", entity);
		page.setTotal((Integer) queryForObject("Zaff_rfxxb.queryCountRfcyxx", map));
		page.setRows(queryForList("Zaff_rfxxb.queryRfcyxx", map));
		return page;
	}
}
	 */