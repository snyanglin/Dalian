package com.founder.zdrygl.base.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.config.SystemConfig;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.zdrygl.base.model.ZdryZb;
import com.founder.zdrygl.core.inteface.ZdryZdryzbDaoService;
import com.founder.zdrygl.core.model.Zdry;

@Repository("ZdryZdryZbDao")
public class ZdryZdryZbDao extends BaseDaoImpl implements ZdryZdryzbDaoService {

	private Map<String,Object> convertToMap(Zdry entity){
		ZdryZb zdryZb = (ZdryZb)entity;
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("id",zdryZb.getId());
		map.put("ryid",zdryZb.getRyid());
		map.put("zdrylb",zdryZb.getZdrylb());
		map.put("syrkid",zdryZb.getSyrkid());
		map.put("zdrygllxdm",zdryZb.getZdrygllxdm());
		map.put("glzt",zdryZb.getGlzt());
		map.put("zywtjxsbx",zdryZb.getZywtjxsbx());
		map.put("glbm",zdryZb.getGlbm());
		map.put("cxbm",zdryZb.getCxbm());
		map.put("jgssxdm",zdryZb.getJgssxdm());
//		map.put("hjd_ssxjgajgdm",zdryZb.getHjd_ssxjgajgdm());
//		map.put("hjd_sspcsdm",zdryZb.getHjd_sspcsdm());
//		map.put("hjd_sssq",zdryZb.getHjd_sssq());
//		map.put("jzd_szdsdm",zdryZb.getJzd_szdsdm());
//		map.put("gxbm",zdryZb.getGxbm());
		map.put("cyzjdm",zdryZb.getCyzjdm());
		map.put("zjhm",zdryZb.getZjhm());
		map.put("xm",zdryZb.getXm());
		map.put("xbdm",zdryZb.getXbdm());
		map.put("mzdm",zdryZb.getMzdm());
		map.put("csrq",zdryZb.getCsrq());
		map.put("jzd_dzxz",zdryZb.getJzd_dzxz());
		return map;
	}
	
	@Override
	public void insert(Zdry entity) {
		ZdryZb zdryZb = (ZdryZb)entity;
		super.insert("ZdryZdryzb.save", zdryZb);
	}

	@Override
	public void update(Zdry entity) {
		ZdryZb zdryZb = (ZdryZb)entity;
		super.update("ZdryZdryzb.update", zdryZb);
	}

	@Override
	public void delete(Zdry entity) {
		ZdryZb zdryZb = (ZdryZb)entity;
		super.update("ZdryZdryzb.delete", zdryZb);
	}

	@Override
	public Zdry queryById(String zdryzbId) {
		ZdryZb zdryZdryzb = new ZdryZb();
		zdryZdryzb.setId(zdryzbId);
		return this.queryByEntity(zdryZdryzb, null);
	}

	@Override
	public List<Zdry> queryListByRyId(String ryId, String andCondition) {
		ZdryZb zdryZdryzb = new ZdryZb();
		zdryZdryzb.setRyid(ryId);
		return this.queryListByEntity(zdryZdryzb, andCondition);
	}

	@Override
	public List<Zdry> queryListBySyrkId(String syrkId, String andCondition) {
		ZdryZb zdryZdryzb = new ZdryZb();
		zdryZdryzb.setSyrkid(syrkId);
		return this.queryListByEntity(zdryZdryzb, andCondition);
	}

	@Override
	public Zdry queryByEntity(Zdry zdryZdryzb, String andCondition) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("andCondition", andCondition);
		ZdryZb zdryZb = (ZdryZb)zdryZdryzb;
		map.put("zdryZdryzb", zdryZb);
		return (Zdry)queryForObject("ZdryZdryzb.queryByMap", map);
	}
	
	@Override
	public List<Zdry> queryListByEntity(Zdry zdryZdryzb, String andCondition) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("andCondition", andCondition);
		
		ZdryZb zdryZb = (ZdryZb)zdryZdryzb;
		map.put("zdryZdryzb", zdryZb);
		
		return (List<Zdry>) super.queryForList("ZdryZdryzb.queryListByMap", map);
	}

	@Override
	public EasyUIPage queryPageList(Map<String, Object> map, EasyUIPage page) {
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
		
		//TODO 实现配置方法
//		String  address =zdryUntil.querySYSConfig();
//		map.put("QYDM", address);
		
		map.put("QYDM", SystemConfig.getString("systemXzqh"));
		
		page.setTotal((Integer) queryForObject("ZdryZdryzb.queryPageCount", map));
		page.setRows(queryForList("ZdryZdryzb.queryPage", map));
		return page;
	}

	@Override
	public EasyUIPage queryDwDzOnPT(Map<String, Object> map, EasyUIPage page) {
		map.put("begin", page.getBegin());
		map.put("end", page.getEnd());
		String sort = page.getSort();
		String order = page.getOrder();
		if (StringUtils.isBlank(sort)) { // 默认排序
			sort = "id";
			order = "asc";
		}
		//entity.setSrid(getSrid());
		map.put("sort", sort);
		map.put("order", order);
		
		//TODO 实现配置方法
//		String  address =zdryUntil.querySYSConfig();
//		map.put("QYDM", address);
		
		map.put("QYDM", "2100");
		
		page.setTotal((Integer) queryForObject("ZdryZdryzb.queryCountZdryOnPT", map));
		page.setRows(queryForList("ZdryZdryzb.queryZdryOnPT", map));
		return page;
	}

	@Override
	public int getSrid() {
		return (int)super.queryForObject("ZdryZdryzb.queryShapetableSrid", null);
	}

	@Override
	public Map<String, Object> queryZdryVoById(String zdryzbId, String andCondition) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("andCondition", andCondition);
		Map<String,Object> zdryZdryzb = new HashMap<String,Object>();
		zdryZdryzb.put("id", zdryzbId);
		map.put("zdryZdryzb", zdryZdryzb);
		return (Map<String, Object>) super.queryForObject("ZdryZdryzb.queryZdryVOByMap", map);
	}

	@Override
	public List<Map<String, Object>> queryZdryVoByRyId(String ryId, String andCondition) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("andCondition", andCondition);
		Map<String,Object> zdryZdryzb = new HashMap<String,Object>();
		zdryZdryzb.put("ryid", ryId);
		map.put("zdryZdryzb", zdryZdryzb);
		return (List<Map<String, Object>>) super.queryForObject("ZdryZdryzb.queryListZdryVOByMap", map);
	}

	@Override
	public List<Map<String, Object>> queryZdryVoBySyrkId(String syrkId, String andCondition) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("andCondition", andCondition);
		Map<String,Object> zdryZdryzb = new HashMap<String,Object>();
		zdryZdryzb.put("syrkid", syrkId);
		map.put("zdryZdryzb", zdryZdryzb);
		return (List<Map<String, Object>>) super.queryForList("ZdryZdryzb.queryListZdryVOByMap", map);
	}

	@Override
	public List<Map<String, Object>> queryLgxxByZdryzbId(String zdryzbId, String andCondition) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id", zdryzbId);
		map.put("andCondition", andCondition);
		return (List<Map<String, Object>>)super.queryForObject("ZdryZdryzb.queryLgxxByZdryid", map);
	}

	@Override
	public Integer queryCountByEntity(Zdry entity) {
		Map<String,Object> map = this.convertToMap(entity);
		return (Integer)super.queryForObject("ZdryZdryzb.queryCountByMap", map);
	}


}
