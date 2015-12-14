package com.founder.sydw_dl.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.service.attachment.bean.ZpfjFjxxb;
import com.founder.sydw_dl.bean.Dwzjb;
import com.founder.zafffwqz.bean.ZaffRfxxb;
import com.founder.zafffwqz.bean.ZaffWfxx;


@Repository("dwzjxxzbDao")
public class DwzjxxzbDao extends BaseDaoImpl {
	
	public Dwzjb queryZjxx (Dwzjb entity) {
		Dwzjb returnValue = null;
		List<?> list = queryForList("Dwzjxxzb.query", entity);
		if (list != null && list.size() > 0) {
			returnValue = (Dwzjb) list.get(0);
		}
		return returnValue;
	}
	
	public void saveZjxx(Dwzjb entity) {
		super.insert("Dwzjxxzb.insertDwzj", entity);
	}
	
	public void updateZjxx(Dwzjb entity) {
		super.update("Dwzjxxzb.updateDwzj", entity);
	}
	
	@SuppressWarnings("unchecked")
	public List<Dwzjb> queryDwzjxx(String zjzldm, String zjbh){
		Map<String, String> map = new HashMap<String, String>();
		map.put("zjzldm", zjzldm);
		map.put("zjbh", zjbh);
		return queryForList("Dwzjxxzb.queryDwzjzldm", map);
	}
	/**
	 * 单位证件
	 * @param map
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Dwzjb> dwzjxxzb_query(Map<String, Object> map) {
		return queryForList("Dwzjxxzb.dwzjxxzb_query", map);
	}
	
	/**
	 * 附件信息
	 * @param map
	 * @return
	 */
	public List<ZpfjFjxxb> fjxx_query(Map<String, Object> map){
		map.put("lybm","DW_DWJBXXB");
		map.put("id",map.get("dwid"));
		return queryForList("ZpfjFjxxb.fjxx_query", map);
	}
	
	public List<ZaffRfxxb> rfxxb_query(Map<String, Object> map) {
		return queryForList("Zaff_rfxx.rfxxb_query", map);
	}
	
	public List<ZaffWfxx> wfxxb_query(Map<String, Object> map) {
		return queryForList("Zaff_wfxx.wfxxb_query", map);
	}

}
