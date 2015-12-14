package com.founder.spsxt.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;


import com.founder.spsxt.bean.Spjsdw;


@Repository("spjsdwDao")
public class SpjsdwDao extends BaseDaoImpl {


	//根据单位编码查询视频建设单位
	public Spjsdw querySpjsdwByDwbm(String dwbm){
		return (Spjsdw) super.queryForObject("Spjsdw.querySpjsdwByDwbm",dwbm);
		
	}
	//根据派出所编码和民警警号查询(为视监控系统提供下拉列表内容)
	public List queryByPcsPoliceId(Map paramMap){
		return super.queryForList("Spjsdw.queryByPcsPoliceId", paramMap);
		
	}
	
	//根据派出所编码、民警警号和拼音查询(为视监控系统提供下拉列表内容)
	public List getDepartmentBasicInfoByPy(Map paramMap){
		return super.queryForList("Spjsdw.getDepartmentBasicInfoByPy", paramMap);
		
	}
	
	public List getGazjByDw(Map paramMap){
		return super.queryForList("Spjsdw.getGazjByDw", paramMap);
	}
	
	
	public List queryByBmid(Map paramMap){
		return super.queryForList("Spjsdw.queryByBmid", paramMap);
		
	}	
	
	
	
	//根据主键删除
	public int deleteSpjsdwByDwbm(String dwbm){
		return super.delete("Spjsdw.deleteSpjsdwByDwbm",dwbm);
	}
	
	public EasyUIPage queryList(EasyUIPage page, Map map){
		
		map.put("begin", page.getBegin());
		map.put("end", page.getEnd());
		String sort = page.getSort();
		String order = page.getOrder();
		if (StringUtils.isBlank(sort)) { // 默认排序
			sort = "dwbm";
			order = "asc";
		}
		map.put("sort", sort);
		map.put("order", order);
		page.setTotal((Integer) queryForObject("Spjsdw.querySpjsdwCount", map));
		page.setRows(queryForList("Spjsdw.querySpjsdwList", map));
		return page;
	}

	//通用分页查询
	public EasyUIPage queryListByBmid(EasyUIPage page, Map map){
		
		map.put("begin", page.getBegin());
		map.put("end", page.getEnd());
		String sort = page.getSort();
		String order = page.getOrder();
		if (StringUtils.isBlank(sort)) { // 默认排序
			sort = "dwbm";
			order = "asc";
		}
		map.put("sort", sort);
		map.put("order", order);
		page.setTotal((Integer) queryForObject("Spjsdw.querySpjsdwCountByBmid", map));
		page.setRows(queryForList("Spjsdw.querySpjsdwListByBmid", map));
		return page;
	}
	
	public void insertSpjsdw(Spjsdw entity){
		insert("Spjsdw.insertSpjsdw", entity);
		
	}
	public void updateSpjsdw(Spjsdw entity){
		update("Spjsdw.updateSpjsdw", entity);
	}
	public Integer checkSameName(Map map){
		return (Integer) super.queryForObject("Spjsdw.checkSameName",map);
	}
	//根据单位id查询其详细信息2014.11.7.
	public List getDepartmentInfoByDwId(String dwId){
		return super.queryForList("Spjsdw.getDepartmentInfoByDwId", dwId);
		
	}	
	//全局范围检查视频单位的唯一性
	public Integer isUniqueForSpjsdw(String dwbm){
		return (Integer) super.queryForObject("Spjsdw.isUniqueForSpjsdw",dwbm);
	}
}
