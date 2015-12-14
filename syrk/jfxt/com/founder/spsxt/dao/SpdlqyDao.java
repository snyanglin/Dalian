package com.founder.spsxt.dao;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.spsxt.bean.Spdlqy;
import com.founder.tzgg.bean.Sys_Tzggb;


@Repository("spdlqyDao")
public class SpdlqyDao extends BaseDaoImpl {

	//查询视频地理区域
	public Spdlqy querySpdlqy() {
		// TODO Auto-generated method stub
		return (Spdlqy) super.queryForList("Spdlqy.queryAll");
	}
	public Spdlqy queryById(String id){
		return (Spdlqy) super.queryForObject("Spdlqy.queryById", id);
	}
	public EasyUIPage queryList(EasyUIPage page, Map map){
		map.put("begin", page.getBegin());
		map.put("end", page.getEnd());
		String sort = page.getSort();
		String order = page.getOrder();
		if (StringUtils.isBlank(sort)) { // 默认排序
			sort = "code";
			order = "asc";
		}
		map.put("sort", sort);
		map.put("order", order);
		page.setTotal((Integer) queryForObject("Spdlqy.querySpdlqyCount", map));
		page.setRows(queryForList("Spdlqy.queryList", map));
		return page;
	}
	
	public void save(Spdlqy entity) {
		insert("Spdlqy.save", entity);
	}
	public void update(Spdlqy entity) {
		update("Spdlqy.update", entity);
	}
	public String getParentCode(String policecode){
		return (String)super.queryForObject("Spdlqy.getParentCode",policecode);
	}
	public String getCode(String policecode){
		return (String)super.queryForObject("Spdlqy.getCode",policecode);
	}
	public Integer checkSameName(Map map){
		return (Integer) super.queryForObject("Spdlqy.checkSameName",map);
	}
}
