package com.founder.zdrygl.base.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.config.SystemConfig;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.zdrygl.base.model.ZdryZb;
import com.founder.zdrygl.base.vo.ZdryZdryzbVO;
import com.founder.zdrygl.core.inteface.ZdryZdryzbDaoService;
import com.founder.zdrygl.core.model.Zdry;
import com.founder.zdrygl.until.ZdryUntil;

@Repository("ZdryZdryZbDao")
public class ZdryZdryZbDao extends BaseDaoImpl implements ZdryZdryzbDaoService {

	@Resource(name = "ZdryUntil")
	private ZdryUntil zdryUntil;
	
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
	/***
	 * 
	 * @Title: queryList
	 * @Description: TODO(管理列表)
	 * @param @param entity
	 * @param @param page
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	public EasyUIPage queryManagerList(ZdryZdryzbVO entity, EasyUIPage page){
		Map<String, Object> map = new HashMap<String, Object>();
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
		map.put("zdryZdryzbVO", entity);
		String  address =zdryUntil.querySYSConfig();
		map.put("QYDM", address);
		
		page.setTotal((Integer) queryForObject("ZdryZdryzb.queryCount", map));
		page.setRows(queryForList("ZdryZdryzb.query", map));
		return page;
	}
	
	/***
	 * 
	 * @Title: queryDwDzOnPT
	 * @Description: TODO重点人员空间查询
	 * @param @param page
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	public EasyUIPage queryDwDzOnPT(EasyUIPage page, ZdryZdryzbVO entity){
		Map<String, Object> map = new HashMap<String, Object>();
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
		map.put("zdryZdryzbVO", entity);		
		String  address =zdryUntil.querySYSConfig();
		map.put("QYDM", address);
		page.setTotal((Integer) queryForObject("ZdryZdryzb.queryCountZdryOnPT", map));
		page.setRows(queryForList("ZdryZdryzb.queryZdryOnPT", map));
		return page;
	}
	
	
	/**
	 * 获取空间图层Srid
	 * 
	 * @return
	 */
	public int getSrid() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("tableName", "BZDZ_ADD_MLDZDXB_PT");
		map.put("shapeDbName", SystemConfig.getString("gisUser"));
		return (Integer) queryForObject("ZdryZdryzb.queryShapetableSrid", map);
	}

	public List<ZdryZb> queryZdryBySyrkid(String syrkid) {
		return queryForList("ZdryZdryzb.queryZdryBySyrkid", syrkid);
	}
	
	public List<ZdryZdryzbVO> queryZdryVoByRyid(String ryid) {
		Map map = new HashMap();
		String  address =zdryUntil.querySYSConfig();
		map.put("QYDM", address);
		map.put("ryid", ryid);
		return queryForList("ZdryZdryzb.queryZdryVOByRyid", map);
	}
	
	public ZdryZdryzbVO queryZdryVoByZdryid(String zdryid) {
		Map map = new HashMap();
		String  address =zdryUntil.querySYSConfig();
		map.put("QYDM", address);
		map.put("zdryid", zdryid);
		return (ZdryZdryzbVO) queryForObject("ZdryZdryzb.queryZdryVOByZdryid", map);
	}
	
	public List<ZdryZdryzbVO> querySgafZdryVOByRyid(String ryid) {
		Map map = new HashMap();
		String  address =zdryUntil.querySYSConfig();
		map.put("QYDM", address);
		map.put("ryid", ryid);
		return queryForList("ZdryZdryzb.querySgafZdryVOByRyid", map);
	}
	
	public ZdryZb queryBySyrkidAndgllx(String syrkid, String gllx) {
		Map<String,String> map = new HashMap<String,String>();
		map.put("syrkid", syrkid);
		map.put("gllx", gllx);
		return (ZdryZb) queryForObject("ZdryZdryzb.queryBySyrkidAndgllx", map);
	}

	/*	public List<ZdrylgxxVO> queryLgxxByZdryid(Map<String, Object> map) {
		return queryForList("ZdryZdryzb.queryLgxxByZdryid", map.get("zdryid"));
	}
	*/
	/*public List<ZpfjFjxxb> fjxx_query(Map<String, Object> map){
		map.put("lybm","ZDRY_ZDRYZB");
		map.put("id",map.get("zdryid"));
		return queryForList("ZpfjFjxxb.fjxx_query", map);
	}*/
	
	/***
	 * 
	 * @Title: queryZdryBySyrkid
	 * @Description: TODO根据身份证查询重点人员类型
	 * @param @param syrkid
	 * @param @return    设定文件
	 * @return List<ZdryZdryzbVO>    返回类型
	 * @throws
	 */
	public List<ZdryZb> queryZdrylxdmByGmsfhm(String zjhm) {
		return queryForList("ZdryZdryzb.queryZdrylxdmByGmsfhm", zjhm);
	}
	
	
	public Integer  queryCount(String syrkId){
		return (Integer) queryForObject("ZdryZdryzb.queryCountBySyrk", syrkId);
	}
	
	/**
	 * 
	 * @Title: queryHjdZrqdm
	 * @Description: TODO(根据门楼牌查询户籍地责任区代码)
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	public String queryHjdZrqdm(String MLDZID){
		return (String) queryForObject("ZdryZdryzb.queryHjdZrqdm", MLDZID);
	}
	
}
