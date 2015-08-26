package com.founder.aqff.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.aqff.bean.Aqffrfryxxb;
import com.founder.aqff.bean.AqffRfxxb;
import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
/******************************************************************************
 * @Package:      [com.founder.aqff.dao.RfxxbDao.java]  
 * @ClassName:    [RfxxbDao]   
 * @Description:  [人防信息dao]   
 * @Author:       [xu_haibo@founder.com.cn]  
 * @CreateDate:   [2015-6-2 上午2:12:09]   
 * @UpdateUser:   [haibo(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-6-2 上午2:12:09，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 */
@Repository("rfxxbDao")
public class RfxxbDao extends BaseDaoImpl{
	
	/**
	 * 
	 * @Title: insertRfxx
	 * @Description: TODO(添加人员信息)
	 * @param entity 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public void insertRfxx(AqffRfxxb entity) {
		super.insertForObject("Zaff_rfxxb.save", entity);
	}
	
	/**
	 * @Title: queryRfxxById
	 * @Description: TODO(通过id查找人员信息)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return AqffRfxxb    返回类型
	 * @throws
	 */
	public AqffRfxxb queryRfxxById(AqffRfxxb entity) {
		return (AqffRfxxb) super.queryForObject("Zaff_rfxxb.queryRfxxById", entity);
	}
	
	/**
	 * @Title: updateRfxx
	 * @Description: TODO(人防信息修改)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return int    返回类型
	 * @throws
	 */
	public int updateRfxx(AqffRfxxb entity) {
		return super.update("Zaff_rfxxb.update", entity);
	}
	
	/**
	 * @Title: deleteRfxx
	 * @Description: TODO(人防信息注销)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return int    返回类型
	 * @throws
	 */
	public int deleteRfxx(AqffRfxxb entity) {
		return super.update("Zaff_rfxxb.delete", entity);
	}
	
	/**
	 * @Title: deleteRfglry
	 * @Description: TODO(人防信息注销)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return int    返回类型
	 * @throws
	 */
	public int deleteRfglry(AqffRfxxb entity) {
		return super.update("Zaff_rfxxb.deleterfry", entity);
	}
	
	/**
	 * @Title: queryRf
	 * @Description: TODO(人防信息分页精确查询)
	 * @param @param page
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	public EasyUIPage queryJQRf(EasyUIPage page, AqffRfxxb entity) {
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
		map.put("rfxxb", entity);
		page.setTotal((Integer) queryForObject("Zaff_rfxxb.queryCountJQRfxx", map));
		page.setRows(queryForList("Zaff_rfxxb.queryJQRfxx", map));
		return page;
	}
	
	/**
	 * @Title: queryRf
	 * @Description: TODO(人防信息分页模糊查询)
	 * @param @param page
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	public EasyUIPage queryMHRf(EasyUIPage page, AqffRfxxb entity) {
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
		map.put("rfxxb", entity);
		page.setTotal((Integer) queryForObject("Zaff_rfxxb.queryCountMHRfxx", map));
		page.setRows(queryForList("Zaff_rfxxb.queryMHRfxx", map));
		return page;
	}
	
	/**
	 * @Title: saveRfcyxx
	 * @Description: TODO(人防人员信息保存方法)
	 * @param @param entity    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public void saveRfcyxx(Aqffrfryxxb entity) {
		super.insertForObject("Zaff_rfxxb.saveRfcyxx", entity);
	}
	
	/**
	 * @Title: queryRfcyxxById
	 * @Description: TODO(通过id查找人员信息)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return Aqffrfryxxb    返回类型
	 * @throws
	 */
	public Aqffrfryxxb queryRfcyxxById(Aqffrfryxxb entity) {
		return (Aqffrfryxxb) super.queryForObject("Zaff_rfxxb.queryRfcyxxById", entity);
	}
	
	/**
	 * @Title: queryRfcyxxByZjhm
	 * @Description: TODO(通过证件号码查找人员信息)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return int    返回类型
	 * @throws
	 */
	public int queryRfcyxxByZjhm(Aqffrfryxxb entity) {
		return (Integer) queryForObject("Zaff_rfxxb.queryRfcyxxByZjhm", entity);
	}
	
	/**
	 * @Title: updateRfcyxx
	 * @Description: TODO(人员信息修改)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return int    返回类型
	 * @throws
	 */
	public int updateRfcyxx(Aqffrfryxxb entity) {
		return super.update("Zaff_rfxxb.updateRfcyxx", entity);
	}
	
	/**
	 * @Title: deleteRfcyxx
	 * @Description: TODO(人员信息删除)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return int    返回类型
	 * @throws
	 */
	public int deleteRfcyxx(Aqffrfryxxb entity) {
		return super.update("Zaff_rfxxb.deleteRfcyxx", entity);
	}
	
	/**
	 * @Title: queryRfcyxx
	 * @Description: TODO(人员信息分页查询)
	 * @param @param page
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	public EasyUIPage queryRfcyxx(EasyUIPage page, Aqffrfryxxb entity) {
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
		map.put("rfcyxxb", entity);
		page.setTotal((Integer) queryForObject("Zaff_rfxxb.queryCountRfcyxx", map));
		page.setRows(queryForList("Zaff_rfxxb.queryRfcyxx", map));
		return page;
	}

	/**
	 * @Title: insertRfPt
	 * @Description: TODO(人防信息空间表添加)
	 * @param @param entity    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public void insertRfPt(AqffRfxxb entity){
		entity.setObjectid(getObjectId());
		entity.setSrid(getSrid(entity));
		entity.setRfid(entity.getId());
		insert("Zaff_rfxxb.insertRfPt",entity);
	}
	
	/**
	 * @Title: updateWfPt
	 * @Description: TODO(人防信息空间表修改)
	 * @param @param entity    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public void updateWfPt(AqffRfxxb entity){
		entity.setRfid(entity.getId());
		entity.setSrid(getSrid(entity));
		if(entity.getXldx()!=""||entity.getXlqy()!=""){
			update("Zaff_rfxxb.updateRfPt",entity);
		}
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
		AqffRfxxb entity = new  AqffRfxxb();
		//entity.setGisUser(SystemConfig.getString("gisUser"));
		entity.setGisUser("GIS210000000000");
		return (Long) queryForObject("Zaff_rfxxb.getObjectId", entity);
	}
	
	/**
	 * 
	 * @Title: getSrid
	 * @Description: TODO(获取空间srid操作)
	 * @param  entity
	 * @return int    返回类型
	 * @throws
	 */
	@SuppressWarnings("static-access")
	public int getSrid(AqffRfxxb entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("tableName",entity.getGisTable());
		map.put("shapeDbName", "GIS210000000000");
		return (Integer) queryForObject("Zaff_rfxxb.queryShapetableSrid", map);
	}
	
	/**
	 * 
	 * @Title: queryRfcyxxByrfid
	 * @Description: TODO(管理页面人员信息获取)
	 * @param map
	 * @return 设定文件
	 * @return List<Aqffrfryxxb> 返回类型
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	public List<Aqffrfryxxb> queryRfcyxxByrfid(Map<String, Object> map) {
		return  queryForList("Zaff_rfxxb.queryRfcyxxByrfid", map);
	}
	
	/**
	 * 
	 * @Title: deleteRfryxx
	 * @Description: TODO(管理页面人防删除关联人员)
	 * @param entity 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	@SuppressWarnings("static-access")
	public void deleteRfryxx(AqffRfxxb entity) {
		queryForObject("Zaff_rfxxb.deleteRfryxx", entity);
	}
	
	
	/**
	 * 
	 * @Title: queryRfxxCF
	 * @Description: TODO(人防信息重复性查询 )
	 * @param entity 设定文件
	 * @return int 返回类型
	 * @throws
	 */
	public int queryRfxxCF(AqffRfxxb entity) {
		return (Integer) queryForObject("Zaff_rfxxb.queryRfxxCF", entity);
	}
	/**
	 * 
	 * @Title: queryRfcyxxByZjhmForDW
	 * @Description: TODO(人防人员单位查询 )
	 * @param entity 设定文件
	 * @return int 返回类型
	 * @throws
	 */
	public Aqffrfryxxb queryRfcyxxByZjhmForDW(Aqffrfryxxb entity) {
		return  (Aqffrfryxxb) queryForObject("Zaff_rfxxb.queryRfcyxxByZjhmForDW", entity);
	}
}
