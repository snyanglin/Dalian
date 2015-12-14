package com.founder.spsxt.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.spsxt.bean.Spjkxt;



//视频监控系统

@Repository("spjkxtDao")
public class SpjkxtDao extends BaseDaoImpl {

	
	public Spjkxt querySpjkxtByXh(int xh){
		return (Spjkxt) super.queryForObject("Spjkxt.queryByXh", xh);
		
	}
	
	//根据主键删除
	public int deleteSpjkxtByXh(String xh){
		return super.delete("Spjkxt.deleteSpjkxtByXh",xh);
	}
	
	public EasyUIPage queryList(EasyUIPage page, Map map){
		map.put("begin", page.getBegin());
		map.put("end", page.getEnd());
		String sort = page.getSort();
		String order = page.getOrder();
		if (StringUtils.isBlank(sort)) { // 默认排序
			sort = "xh";
			order = "asc";
		}
		map.put("sort", sort);
		map.put("order", order);
		page.setTotal((Integer) queryForObject("Spjkxt.querySpjkxtCount", map));
		page.setRows(queryForList("Spjkxt.querySpjkxtList", map));
		return page;
	}

	
	
	public void insertSpjkxt(Spjkxt entity){
		insert("Spjkxt.insertSpjkxt", entity);
		
	}
	public void updateSpjkxt(Spjkxt entity){
		update("Spjkxt.updateSpjkxt", entity);
	}
	
	public Integer checkSameName(Map map){
		return (Integer) super.queryForObject("Spjkxt.checkSameName",map);
	}
	
	//根据外键(dwbm)删除匹配的所有监控系统
	public int deleteSpjkxtByDwbm(String dwbm){
		return super.delete("Spjkxt.deleteSpjkxtByDwbm",dwbm);
	}
	
	public Map<String, String> queryLwsxByXh(String xh){
		Map<String, String> map = new HashMap<String, String>();
		List list=super.queryForList("Spjkxt.queryLwsxByXh", xh);
		if (null != list && list.size() > 0) {
			map = (Map) list.get(0);
		}
		return map;
	}
	
	/*
	public void deleteSpjkxt(Spjkxt entity) {
		super.update("Spjkxt.delete", entity);
	}
	*/		
	
	

/*
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
		page.setTotal((Integer) queryForObject("Spjsdw.querySpjsdwCount", map));
		page.setRows(queryForList("Spjsdw.queryList", map));
		return page;
	}
*/

}
