package com.founder.zdrygl.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.founder.zdrygl.bean.ZdryZdryzb;
import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.config.SystemConfig;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.service.attachment.bean.ZpfjFjxxb;
import com.founder.zdrygl.until.ZdryUntil;
import com.founder.zdrygl.vo.ZdryZdryzbVO;
import com.founder.zdrygl.vo.ZdrylgxxVO;
/**
 * ****************************************************************************
 * @Package:      [com.founder.zdrygl.dao.ZdryZdryzbDao.java]  
 * @ClassName:    [ZdryZdryzbDao]   
 * @Description:  [重点人员总表数据操作类]   
 * @Author:       [weiwen]  
 * @CreateDate:   [2015-3-12 下午4:28:00]   
 * @UpdateUser:   [weiwen]   
 * @UpdateDate:   [2015-3-12 下午4:28:00，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Repository("zdryZdryzbDao")
public class ZdryZdryzbDao extends BaseDaoImpl {
	
	@Resource(name = "ZdryUntil")
	private ZdryUntil zdryUntil;

	public List<ZdryZdryzb> queryZdryByRyid(String ryid) {
		return queryForList("ZdryZdryzb.queryList", ryid);
	}
	
	public void insert(ZdryZdryzb entity){
		insert("ZdryZdryzb.save", entity);
	}
	
	public void update(ZdryZdryzb entity){
		update("ZdryZdryzb.update", entity);
	}
	
	public void delete(ZdryZdryzb entity){
		update("ZdryZdryzb.delete", entity);
	}
	
	public Object queryById(String id){
		return (ZdryZdryzb) queryForObject("ZdryZdryzb.queryById", id);
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

	public List<ZdryZdryzb> queryZdryBySyrkid(String syrkid) {
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
	
	public ZdryZdryzb queryBySyrkidAndgllx(String syrkid, String gllx) {
		Map<String,String> map = new HashMap<String,String>();
		map.put("syrkid", syrkid);
		map.put("gllx", gllx);
		return (ZdryZdryzb) queryForObject("ZdryZdryzb.queryBySyrkidAndgllx", map);
	}

	public List<ZdrylgxxVO> queryLgxxByZdryid(Map<String, Object> map) {
		return queryForList("ZdryZdryzb.queryLgxxByZdryid", map.get("zdryid"));
	}
	
	public List<ZpfjFjxxb> fjxx_query(Map<String, Object> map){
		map.put("lybm","ZDRY_ZDRYZB");
		map.put("id",map.get("zdryid"));
		return queryForList("ZpfjFjxxb.fjxx_query", map);
	}
	
	/***
	 * 
	 * @Title: queryZdryBySyrkid
	 * @Description: TODO根据身份证查询重点人员类型
	 * @param @param syrkid
	 * @param @return    设定文件
	 * @return List<ZdryZdryzbVO>    返回类型
	 * @throws
	 */
	public List<ZdryZdryzb> queryZdrylxdmByGmsfhm(String zjhm) {
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
