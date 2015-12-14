package com.founder.zafffwqz.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.config.SystemConfig;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.zafffwqz.bean.ZaffWfxx;
/******************************************************************************
 * @Package:      [com.founder.zafffwqz.dao.WfxxDao.java]  
 * @ClassName:    [WfxxDao]   
 * @Description:  [物防信息DAO层：主要对空间查询操作]   
 * @Author:       [tian_chengwei@founder.com.cn]  
 * @CreateDate:   [2015-5-26 下午4:51:51]   
 * @UpdateUser:   [lk(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-5-26 下午4:51:51，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 * 
 *  * @review      : wu.w@founder.com.cn
 * @reviewDate  : 20150604
 */
@Repository("wfxxDao")
public class WfxxDao extends BaseDaoImpl{

	/**
	 * 
	 * @Title: queryWf
	 * @Description: TODO(物防信息分页查询)
	 * @param page
	 * @param entity
	 * @return EasyUIPage返回类型
	 * @throws
	 */
	public EasyUIPage queryWf(EasyUIPage page, ZaffWfxx entity) {
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
		map.put("wfxx", entity);
		page.setTotal((Integer) queryForObject("Zaff_wfxx.queryCountWf", map));
		page.setRows(queryForList("Zaff_wfxx.queryWf", map));
		return page;
	}

	/**
	 * 
	 * @Title: queryWfxxOnPT
	 * @Description: TODO(物防空间分页查询)
	 * @param page
	 * @param entity
	 * @return EasyUIPage返回类型
	 * @throws
	 */
	public EasyUIPage queryWfxxOnPT(EasyUIPage page, ZaffWfxx entity) {
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
		map.put("srid", getSrid(entity));
		map.put("wfxx", entity);
		page.setTotal((Integer) queryForObject("Zaff_wfxx.queryCountWfxxOnPT", map));
		page.setRows(queryForList("Zaff_wfxx.queryWfxxOnPT", map));
		return page;
	}
	/**
	 * 
	 * @Title: updateWf
	 * @Description: TODO(修改物防属性表X，Y坐标)
	 * @param entity设定文件
	 * @return void返回类型
	 * @throws
	 */
	public void updateWf(ZaffWfxx entity){
		update("Zaff_wfxx.updateWf", entity);
	}
	/**
	 * 
	 * @Title: delete
	 * @Description: TODO(注销属性表操作)
	 * @param  entity
	 * @return void    返回类型
	 * @throws
	 */
	public void deleteSx(ZaffWfxx entity) {
		update("Zaff_wfxx.cancelWfSx", entity);
	}
	/**
	 * 
	 * @Title: deleteKj
	 * @Description: TODO(注销空间表信息操作)
	 * @param entity
	 * @return void返回类型
	 * @throws
	 */
	public void deleteKj(ZaffWfxx entity) {
		update("Zaff_wfxx.cancelWfKj", entity);
	}
	
	/**
	 * 
	 * @Title: getSrid
	 * @Description: TODO(获取空间srid操作)
	 * @param  entity
	 * @return int    返回类型
	 * @throws
	 */
	public int getSrid(ZaffWfxx entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("tableName",ZaffWfxx.getGisTable());
		map.put("shapeDbName", SystemConfig.getString("gisUser"));
		return (Integer) queryForObject("Zaff_wfxx.queryShapetableSrid", map);
	}
	
	/**
	 * 
	 * @Title: insertWfPt
	 * @Description: TODO(对空间表插入操作)
	 * @param  entity
	 * @return void    返回类型
	 * @throws
	 */
	public void insertWfPt(ZaffWfxx entity){
		entity.setObjectid(getObjectId());
		entity.setSrid(getSrid(entity));
		entity.setWfid(entity.getId());
		insert("Zaff_wfxx.insertWfPt",entity);
	}
	/**
	 * 
	 * @Title: updateWfPt
	 * @Description: TODO(空间表修改操作)
	 * @param  entity
	 * @return void    返回类型
	 * @throws
	 */
	public void updateWfPt(ZaffWfxx entity){
		entity.setWfid(entity.getId());
		entity.setSrid(getSrid(entity));
		update("Zaff_wfxx.updateWfPt",entity);
	}
	/**
	 * 
	 * @Title: getObjectId
	 * @Description: TODO(获取空间OBJECTID主键值操作)
	 * @param  entity
	 * @return void    返回类型
	 * @throws
	 */
	public Long getObjectId(){
		ZaffWfxx entity = new  ZaffWfxx();
		entity.setGisUser(SystemConfig.getString("gisUser"));
		return (Long) queryForObject("Zaff_wfxx.getObjectId2", entity);
	}
	
}
