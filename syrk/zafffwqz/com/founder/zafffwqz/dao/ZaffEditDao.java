package com.founder.zafffwqz.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.zafffwqz.bean.Bazzb;
import com.founder.zafffwqz.bean.Bazzryxxb;
import com.founder.zafffwqz.bean.Sqjbxxb;
import com.founder.zafffwqz.bean.Sqjwsxxb;
import com.founder.zafffwqz.bean.Sqmjxxb;
import com.founder.zafffwqz.bean.Sqwyhcyb;
import com.founder.zafffwqz.bean.Sqzbhb;
import com.founder.zafffwqz.bean.Sqzdbwb;
import com.founder.zafffwqz.bean.Zazzryxxb;
import com.founder.zafffwqz.vo.ZaffgnVO;
import com.founder.zafffwqz.vo.ZaffxxzsVO;

@Repository("zaffEditDao")
public class ZaffEditDao extends BaseDaoImpl{

	public Sqjwsxxb querySqjwsxxbById(String id) {
		Sqjwsxxb entity = new Sqjwsxxb();
		entity.setId(id);
		return (Sqjwsxxb) queryForObject("Sqjwsxxb.query", entity);
	}

	public List<ZaffxxzsVO> queryJwszsxx(Map<String, Object> map) {
		return queryForList("Zaffglpz.queryZhxxzspz",map);
	}
	
	public void delete_xxzsnrb(Map<String, Object> map) {
		List<?> list = queryForList("Zaffglpz.queryxxzsnrbByxxdybm", map.get("url"));
		map.put("tablename", list.get(0).toString());
		if (list != null && list.size() > 0) {
			update("Zaffglpz.updateTableByxxdybm", map);
		} 
	}
	

	public List<ZaffgnVO> queryYwglgn(Map<String, Object> map) {
		return queryForList("Zaffglpz.queryYwglgn",map);
	}

	public Sqjbxxb sqjbxxb_query(Map<String, Object> map){
		return (Sqjbxxb) queryForObject("Sqjbxxb.sqjbxxb_query", map);
	}
	
	public List<Sqwyhcyb> sqwyhcyb_query(Map<String, Object> map){
		return (List<Sqwyhcyb>) queryForList("Sqwyhcyb.sqwyhcyb_query", map);
	}
	
	public List<Sqzdbwb> sqzdbwb_query(Map<String, Object> map){
		return (List<Sqzdbwb>) queryForList("Sqzdbwb.sqzdbwb_query", map);
	}
	
	public List<Zazzryxxb> zazzryxxb_query(Map<String, Object> map){
		return (List<Zazzryxxb>) queryForList("Zazzryxxb.zazzryxxb_query", map);
	}
	
	public List<Bazzryxxb> bazzryxxb_query(Map<String, Object> map){
		return (List<Bazzryxxb>) queryForList("Bazzryxxb.bazzryxxb_query", map);
	}

	public Bazzb bazzb_query(Map<String, Object> map) {
		
		return (Bazzb) queryForObject("Bazzb.bazzb_query", map);
	}

	public Sqjwsxxb sqjwsxxb_query(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return (Sqjwsxxb) queryForObject("Sqjwsxxb.sqjwsxxb_query", map);
	}

	public Sqmjxxb sqmjxxb_query(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return (Sqmjxxb) queryForObject("Sqmjxxb.sqmjxxb_query", map);
	}

	public List<Sqzbhb> sqzbhb_query(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return (List<Sqzbhb>) queryForList("Sqzbhb.sqzbhb_query", map);
	}

}
