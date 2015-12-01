package com.founder.zdry.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.zdry.bean.ZdryXdryxxb;
/**
 * ****************************************************************************
 * @Package:      [com.founder.zdry.dao.ZdryXdryxxbDao.java]  
 * @ClassName:    [ZdryXdryxxbDao]   
 * @Description:  [重点人员总表数据操作类]   
 * @Author:       [weiwen]  
 * @CreateDate:   [2015-3-12 下午4:28:00]   
 * @UpdateUser:   [weiwen]   
 * @UpdateDate:   [2015-3-12 下午4:28:00，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Repository("zdryXdryxxbDao")
public class ZdryXdryxxbDao extends BaseDaoImpl {

	public List<ZdryXdryxxb> queryList(String zdryid){
		return (List<ZdryXdryxxb>)queryForList("ZdryXdryxxb.queryList",zdryid);
	}
	
	public ZdryXdryxxb queryByZdryid(String ryid) {
		return (ZdryXdryxxb)queryForObject("ZdryXdryxxb.queryByZdryid", ryid);
	}
	
	public ZdryXdryxxb queryById(String id){
		return (ZdryXdryxxb)queryForObject("ZdryXdryxxb.queryById", id);
	}
	
	public void save(ZdryXdryxxb entity){
		insert("ZdryXdryxxb.save", entity);
	}
	
	public void update(ZdryXdryxxb entity){
		update("ZdryXdryxxb.update", entity);
	}
	
	public void delete(ZdryXdryxxb entity){
		update("ZdryXdryxxb.delete", entity);
	}
	
	/*
	public EasyUIPage queryManagerList(ZdryXdryxxb entity, EasyUIPage page){
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
		map.put("ZdryXdryxxb", entity);
		
		page.setTotal((Integer) queryForObject("ZdryXdryxxb.queryCount", map));
		page.setRows(queryForList("ZdryXdryxxb.query", map));
		return page;
	}*/
	
}
