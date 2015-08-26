package com.founder.zafffwqz.dao;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.zafffwqz.bean.Gzjsdmtxxb;
import com.founder.zafffwqz.bean.Gzjsxxb;

@Repository("gzjsxxbDao")
public class GzjsxxbDao  extends BaseDaoImpl {
	
	public Gzjsxxb queryGzjsxxb(Gzjsxxb entity){
		return (Gzjsxxb) super.queryForObject("Gzjsxxb.queryGzjsxxb", entity);
		
	}
	
	public void saveGzjsxxb(Gzjsxxb entity){
		super.insert("Gzjsxxb.insertGzjsxxb", entity);
	}
	
	public void updateGzjsxxb(Gzjsxxb entity){
		super.update("Gzjsxxb.updateGzjsxxb", entity);
	}
	
	@SuppressWarnings("unchecked")
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
		page.setTotal((Integer) queryForObject("Gzjsxxb.queryGzjsxxbCount", map));
		page.setRows(queryForList("Gzjsxxb.queryList", map));
		return page;
	}
	public void delete(Gzjsxxb entity) {
		super.update("Gzjsxxb.delete", entity);
	}
	
	public void insertGzjsdmtxxb(Gzjsdmtxxb entity){
		super.insert("Gzjsdmtxxb.insert", entity);
	}
	
	public void deleteGzjsdmtxxb(String gzjsid){
		super.delete("Gzjsdmtxxb.delete", gzjsid);
	}
	
	@SuppressWarnings("unchecked")
	public List<Gzjsdmtxxb> queryGzjsdmtxxb(String gzjsid){
		return (List<Gzjsdmtxxb>) queryForList("Gzjsdmtxxb.queryList", gzjsid);
	}
	
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> querySqidSqjwsid(String orgCode){
		return (List<Map<String, Object>>) queryForList("Gzjsxxb.querySqidSqjwsid", orgCode);
	}
}
