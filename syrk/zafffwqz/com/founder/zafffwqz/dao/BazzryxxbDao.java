package com.founder.zafffwqz.dao;
import java.util.Map;
import org.springframework.stereotype.Repository;
import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.zafffwqz.bean.Bazzryxxb;


/**
 * 保安组织人员信息表DAO
 * @author cdx
 *
 */
@Repository("bazzryxxbDao")
public class BazzryxxbDao extends BaseDaoImpl{
	
	public Bazzryxxb queryBazzryxxb(Bazzryxxb entity){
		return (Bazzryxxb)super.queryForObject("Bazzryxxb.queryBazzryxxb", entity);
	}
	
	public void saveBazzryxxb(Bazzryxxb entity){
		super.insert("Bazzryxxb.insertBazzryxxb", entity);
	}
	
	public void updateBazzryxxb(Bazzryxxb entity){
		super.update("Bazzryxxb.updateBazzryxxb", entity);
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
		page.setTotal((Integer) queryForObject("Bazzryxxb.queryBazzryxxbCount", map));
		page.setRows(queryForList("Bazzryxxb.queryList", map));
		return page;
	}
	
	public void deleteBazzryxxb(Bazzryxxb entity) {
		super.update("Bazzryxxb.deleteBazzryxxb", entity);
	}
}
