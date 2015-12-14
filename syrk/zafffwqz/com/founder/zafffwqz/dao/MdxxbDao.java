package com.founder.zafffwqz.dao;
import java.util.Map;
import org.springframework.stereotype.Repository;
import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.zafffwqz.bean.Mdxxb;
@Repository("mdxxbDao")
public class MdxxbDao extends BaseDaoImpl {
	
	public Mdxxb queryMdxxb(Mdxxb entity){
		return (Mdxxb) super.queryForObject("Mdxxb.queryMdxxb", entity);
		
	}
	
	public void saveMdxxb(Mdxxb entity){
		super.insert("Mdxxb.insertMdxxb", entity);	
	}
	
	public void updateMdxxb(Mdxxb entity){
		super.update("Mdxxb.updateMdxxb", entity);
	}
	
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
		page.setTotal((Integer) queryForObject("Mdxxb.queryMdxxbCount", map));
		page.setRows(queryForList("Mdxxb.queryList", map));
		return page;
	}
	public void delete(Mdxxb entity) {
		super.update("Mdxxb.delete", entity);
	}
}
