package com.founder.gis.dao;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.gis.vo.GisVo;
/**
 * @类名: GisDao 
 * @描述: 地图应用【公共组件】Dao
 * @作者: zhang_guoliang@founder.com 
 * @日期: 2015-3-11 下午6:31:18 
 */
@Repository("gisDao")
public class GisDao extends BaseDaoImpl{
	/**
	 * @Title: queryZrqMapBz
	 * @描述: 获取地图【责任区】坐标点信息
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: ZBX【坐标X】、ZBY【坐标Y】
	 * @日期： 2015-3-11 下午6:45:43 
	 * @返回值: GisVo    返回类型 
	 * @throws
	 */
	public GisVo queryZrqMapBz(GisVo entity){
		GisVo returnValue = null;
		List<?> list = queryForList("com.founder.gis.sqlmap.Gis.queryZrqMapBz", entity);
		if (list != null && list.size() > 0){
			returnValue = (GisVo) list.get(0);
		}
		return returnValue;
	}
	/**
	 * @Title: queryPcsMapBz 
	 * @描述: 获取地图【派出所】坐标点信息
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2015-3-12 下午2:53:51 
	 * @返回值: GisVo    返回类型 
	 * @throws
	 */
	public GisVo queryPcsMapBz(GisVo entity){
		GisVo returnValue = null;
		List<?> list = queryForList("com.founder.gis.sqlmap.Gis.queryPcsMapBz", entity);
		if (list != null && list.size() > 0){
			returnValue = (GisVo) list.get(0);
		}
		return returnValue;
	}
	/**
	 * @Title: getShapeTableSrid 
	 * @描述: 获取空间图层的Srid
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: tableName 图层表名
	 * @日期： 2015-4-21 上午11:34:12 
	 * @返回值: int    返回类型 
	 * @throws
	 */
	public int getShapeTableSrid(Map<String,String> map) {
		Integer count = (Integer) queryForObject("com.founder.gis.sqlmap.Gis.getShapeTableSrid",map);
		return count;
	}
	/**
	 * @Title: getSdeSeqValue 
	 * @描述: 获取SDE空间图层下一个Objectid
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2015-5-18 下午3:43:19 
	 * @返回值: int    返回类型 
	 * @throws
	 */
	public int getSdeSeqValue(Map<String,String> map) {
		Integer count = (Integer) queryForObject("com.founder.gis.sqlmap.Gis.getSdeSeqValue",map);
		return count;
	}
}