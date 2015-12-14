package com.founder.spsxt.dao;


import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.spsxt.bean.Platform;



@Repository("platformDao")
public class PlatformDao extends BaseDaoImpl {


	//新增一个平台
	public void insertPlatform(Platform entity){
		insert("Platform.insertPlatform", entity);
		
	}
	//修改一个平台
	public void updatePlatform(Platform entity){
		update("Platform.updatePlatform", entity);
	}		
	
	//根据id获得一个平台记录
	public Platform queryPlatformById(String id){
		return (Platform) queryForObject("Platform.queryPlatformById",id);
		
	}
	
	//根据主键删除
	public int deletePlatformById(String id){
		return delete("Platform.deletePlatformById",id);
	}
	
	//分页查询
	public EasyUIPage pageListByCondition(EasyUIPage page, Map map){
		
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
		page.setTotal((Integer) queryForObject("Platform.getPlatformCountByCondition", map));
		page.setRows(queryForList("Platform.getPlatformListByCondition", map));
		return page;
	}

	//获得所属分局的平台名称和id(为NVR提供下拉列表内容)
	public List getPlatformNameAndId(String ssOrgCode){
		return queryForList("Platform.getPlatformNameAndId",ssOrgCode);
		
	}	
	//检查平台名称是否全局唯一.唯一,返回true
	public int isUniqueForPlatformName(String ptmc){		
		return (Integer) queryForObject("Platform.isUniqueForPlatformName",ptmc);
		
	}

}
