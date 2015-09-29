package com.founder.zdrygl.base.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
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
	
	/**
	 * 查询包括已撤管的重点人员
	 */
	@Override
	public List<Zdry> queryListByEntity(Zdry zdryZdryzb, String andCondition) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("andCondition", andCondition);
		
		ZdryZb zdryZb = (ZdryZb)zdryZdryzb;
		map.put("zdryZdryzb", zdryZb);
		
		return (List<Zdry>) super.queryForList("ZdryZdryzb.queryListByMap", map);
	}

	/**
	 * 管理列表查询
	 */
	@Override
	public EasyUIPage queryPageList(Map<String, Object> map, EasyUIPage page) {
		map.put("begin", page.getBegin());
		map.put("end", page.getEnd());
		String sort = page.getSort();
		String order = page.getOrder();
		if (StringUtils.isBlank(sort)) { // 默认排序
			sort = "XT_CJSJ";
			order = "DESC";
		}
		map.put("sort", sort);
		map.put("order", order);	
		
		page.setTotal((Integer) queryForObject("ZdryZdryzb.queryPageCount", map));
		page.setRows(queryForList("ZdryZdryzb.queryPage", map));
		return page;
	}

	/**
	 * 查询列表查询
	 */
	@Override
	public EasyUIPage getQueryList(Map<String, Object> map, EasyUIPage page) {
		map.put("begin", page.getBegin());
		map.put("end", page.getEnd());
		String sort = page.getSort();
		String order = page.getOrder();
		if (StringUtils.isBlank(sort)) { // 默认排序
			sort = "XT_CJSJ";
			order = "DESC";
		}
		//entity.setSrid(getSrid());
		map.put("sort", sort);
		map.put("order", order);		
		
		page.setTotal((Integer) queryForObject("ZdryZdryzb.getQeryListCount", map));
		page.setRows(queryForList("ZdryZdryzb.getQeryList", map));
		return page;
	}		

}
