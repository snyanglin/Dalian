package com.founder.syrkgl.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.syrkgl.bean.JzzblBhSequence;

@Repository("jzzblBhSequenceDao")
public class JzzblBhSequenceDao extends BaseDaoImpl {

	public void saveJzzblBhSequence(JzzblBhSequence entity){
		insert("JzzblBhSequence.save", entity);
	}
	
	public int updateJzzblBhSequence(JzzblBhSequence entity){
		return update("JzzblBhSequence.update", entity);
	}
	
	public JzzblBhSequence queryBhSequenceByCode(String code){
		Map map = new HashMap<String, Object>();
		map.put("code", code);
		return (JzzblBhSequence) queryForObject("JzzblBhSequence.queryBhSequenceByCode", map);
	}
}
