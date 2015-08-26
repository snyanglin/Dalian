package com.founder.spsxt.dao;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.spsxt.bean.NvrInfo;




@Repository("nvrInfoDao")
public class NvrInfoDao extends BaseDaoImpl {


	//新增一个NVR
	public void insertNvrInfo(NvrInfo entity){
		insert("NvrInfo.insertNvrInfo", entity);
		
	}
	//修改一个NVR
	public void updateNvrInfo(NvrInfo entity){
		update("NvrInfo.updateNvrInfo", entity);
	}		
	
	//根据id获得一个NVR记录
	public NvrInfo queryNvrInfoById(String id){
		return (NvrInfo) queryForObject("NvrInfo.queryNvrInfoById",id);
		
	}
	
	//根据主键删除
	public int deleteNvrInfoById(String id){
		return delete("NvrInfo.deleteNvrInfoById",id);
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
		page.setTotal((Integer) queryForObject("NvrInfo.getNvrInfoCountByCondition", map));
		page.setRows(queryForList("NvrInfo.getNvrInfoListByCondition", map));
		return page;
	}
	public List getNVRByPt(String dwbm){
		Map<String, String> map = new HashMap<String, String>();
		map.put("dwbm", dwbm);
		return super.queryForList("NvrInfo.getNVRByPt", map);
	}
	//检查同一平台下设备名称(NVR)是否唯一
	public int isUniqueForPlatformName(Map paramMap){		
		return (Integer) queryForObject("NvrInfo.isUniqueForPlatformName",paramMap);
		
	}
	
	//根据平台id(pt_id)删除NVR
	public int deleteNvrInfoByPtId(String pt_id){
		return delete("NvrInfo.deleteNvrInfoByPtId",pt_id);
	}

}
