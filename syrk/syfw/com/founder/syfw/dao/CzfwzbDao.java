package com.founder.syfw.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.syfw.bean.Czfwjcxxb;
import com.founder.syfw.bean.Czfwxxb;
import com.founder.syfw.bean.FwCzqkdjxxb;

@Repository("czfwzbDao")
public class CzfwzbDao extends BaseDaoImpl {

	public void insetCzfwxxb(Czfwxxb entity) {
		super.insert("Czfwxxb.save", entity);
	}

	public void updateCzfwxxb(Czfwxxb entity) {
		super.update("Czfwxxb.update", entity);
	}

	public void deleteCzfwxxb(Czfwxxb entity) {
		super.delete("Czfwxxb.removeCzfwxxb", entity);
	}

	public Czfwxxb queryCzfwxxb(String id) {
		return (Czfwxxb) super.queryForObject("Czfwxxb.query", id);
	}

	public void updateSfczfw(String sf,String fwid){
		Map<String,String> map = new HashMap<String,String>();
		map.put("sfczfw", sf);
		map.put("id", fwid);
		super.update("Fwjbxxb.updateSfczfw", map);
	}

	public void deleteCzqkdjxxb(FwCzqkdjxxb entity) {
		super.update("Czfwzb.delCzqkdjxxbByCzfwid", entity);
	}

	public void deleteCzfwjcxxb(Czfwjcxxb entity) {
		super.update("Czfwzb.delCzfwjcxxbByCzfwid", entity);
	}

	public Czfwxxb queryCzfwxxbByFwid(String fwid){
		Map<String,String> map  = new HashMap<String,String>();
		map.put("fwid", fwid);
		return (Czfwxxb) queryForObject("Czfwxxb.czfwxxb_query",map);
	}

}
