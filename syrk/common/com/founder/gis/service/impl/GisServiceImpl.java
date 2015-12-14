package com.founder.gis.service.impl;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.service.BaseService;
import com.founder.framework.config.SystemConfig;
import com.founder.gis.dao.GisDao;
import com.founder.gis.service.GisService;
import com.founder.gis.vo.GisVo;
/**
 * @类名: GisServiceImpl 
 * @描述: 地图应用【公共组件】ServiceImpl
 * @作者: zhang_guoliang@founder.com 
 * @日期: 2015-3-11 下午6:27:42 
 */
@Service("gisService")
@Transactional
public class GisServiceImpl extends BaseService implements GisService{
	@Resource(name = "gisDao")
	private GisDao gisDao;
	/**
	 * @Title: queryMapBz 
	 * @描述: 获取地图坐标点信息【所属派出所、责任区信息】
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: ZBX【坐标X】、ZBY【坐标Y】
	 * @日期： 2015-3-11 下午6:43:33 
	 * @throws
	 */
	public GisVo queryMapBz(GisVo entity) {
		//获取地图【派出所】坐标点信息
		entity.setTableName(SystemConfig.getString("gisUser")+".FQ_DLPCS_PG T");//查询表名字
		GisVo pcsvo = gisDao.queryPcsMapBz(entity);
		if(pcsvo!=null){
			pcsvo.setZbx(entity.getZbx());
			pcsvo.setZby(entity.getZby());
			//获取地图【责任区】坐标点信息
			pcsvo.setTableName(SystemConfig.getString("gisUser")+".FQ_DLZRQ_PG T");//查询表名字
			GisVo zrqvo = gisDao.queryZrqMapBz(pcsvo);
			entity.setPcsdm(pcsvo.getPcsdm());
			entity.setPcsmc(pcsvo.getPcsmc());
			entity.setZrqdm(zrqvo.getZrqdm());
			entity.setZrqmc(zrqvo.getZrqmc());
		}
		return entity;
	}
	/**
	 * @Title: getShapeTableSrid 
	 * @描述: 获取空间图层的Srid
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: tableName 查询的空间表图层srid
	 * @日期： 2015-4-21 下午2:59:52 
	 * @throws
	 */
	public int getShapeTableSrid(String tableName) {
		Map<String,String> params = new HashMap<String,String>();
		params.put("tableName", tableName);
		params.put("gisUser", SystemConfig.getString("gisUser"));
		int srid = gisDao.getShapeTableSrid(params);
		return srid;
	}
	/**
	 * @Title: getSdeSeqValue 
	 * @描述: 获取SDE空间图层下一个Objectid
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: tableName 查询的空间表图层Objectid
	 * @日期： 2015-5-18 下午3:41:53 
	 * @throws
	 */
	public int getSdeSeqValue(String tableName) {
		Map<String,String> params = new HashMap<String,String>();
		params.put("tableName", tableName);
		params.put("gisUser", SystemConfig.getString("gisUser"));
		int objectid = gisDao.getSdeSeqValue(params);
		return objectid;
	}
}