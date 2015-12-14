package com.founder.gis.service;
import com.founder.framework.annotation.TypeAnnotation;
import com.founder.gis.vo.GisVo;
/**
 * @类名: GisService 
 * @描述: 地图应用【公共组件】Service
 * @作者: zhang_guoliang@founder.com 
 * @日期: 2015-3-11 下午6:19:25 
 */
@TypeAnnotation("地图应用")
public interface GisService {
    /**
     * @Title: queryMapBz 
     * @描述: 获取地图坐标点信息【所属派出所、责任区信息】
     * @作者: zhang_guoliang@founder.com 
     * @参数: ZBX【坐标X】、ZBY【坐标Y】
     * @日期： 2015-3-11 下午6:42:53 
     * @返回值: GisVo    返回类型 
     * @throws
     */
	public GisVo queryMapBz(GisVo entity);
	/**
	 * @Title: getShapeTableSrid 
	 * @描述: 获取空间图层的Srid
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: tableName 图层表名
	 * @日期： 2015-4-21 上午11:20:55 
	 * @返回值: int    返回类型 
	 * @throws
	 */
	public int getShapeTableSrid(String tableName);
	/**
	 * @Title: getSdeSeqValue 
	 * @描述: 获取SDE空间图层下一个Objectid
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2015-5-18 下午3:40:54 
	 * @返回值: int    返回类型 
	 * @throws
	 */
	public int getSdeSeqValue(String tableName);
}
