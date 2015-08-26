package com.founder.sydw.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.sydw.bean.Zzyhjzzsbb;

@Repository("zzyhjzzsbbDao")
public class ZzyhjzzsbbDao extends BaseDaoImpl {

	public Zzyhjzzsbb queryZzyhjzzsbbByRyid (Zzyhjzzsbb entity) {
		Zzyhjzzsbb returnValue = null;
		List<?> list = queryForList("Zzyhjzzsbb.query", entity);
		if (list != null && list.size() > 0) {
			returnValue = (Zzyhjzzsbb) list.get(0);
		}
		return returnValue;
	}
	
	public List<Zzyhjzzsbb> zzyhjzzsbb_query(Map<String, Object> map){
		return queryForList("Zzyhjzzsbb.zzyhjzzsbb_query", map);
	}
	
	public void saveZzyhjzzsbb(Zzyhjzzsbb entity) {
		super.insert("Zzyhjzzsbb.insert", entity);
	}
	
	public void updateZzyhjzzsbb(Zzyhjzzsbb entity) {
		super.update("Zzyhjzzsbb.update", entity);
	}
	
}
