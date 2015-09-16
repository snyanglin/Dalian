package com.founder.sqjw.service;

import java.util.List;
import java.util.Map;

import com.founder.framework.utils.EasyUIPage;
import com.founder.sqjw.bean.LogInfo;
import com.founder.sqjw.bean.TjSyrk;
import com.founder.sqjw.bean.Tjgzjl;
import com.founder.sqjw.bean.XJSZ;
import com.founder.sqjw.bean.XjtjXq;
import com.founder.sqjw.bean.Xjtjcar;
import com.founder.sqjw.bean.Xjtjemployee;
import com.founder.sqjw.vo.ZzjgVo;
import com.founder.tzgg.bean.Org_Organization;

/**
 * @类名: HomePageService 
 * @描述: 接口类
 * @作者: zhang_guoliang@founder.com 
 * @日期: 2014-7-4 下午2:31:17 
 *
 */
public interface HomePageService {
    /**
     * @Title: syrkChart 
     * @描述: 实有人口饼状图
     * @作者: zhang_guoliang@founder.com 
     * @参数: 传入参数定义 
     * @日期： 2014-7-9 下午9:02:19 
     * @返回值: Map<String,Object>    返回类型 
     * @throws
     */
	public Map<String, Object> syrkChart(String zzjgdm);
	/**
	 * @Title: gzdxChart 
	 * @描述: 工作对象柱状图
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2014-7-9 下午9:02:24 
	 * @返回值: Map<String,Object>    返回类型 
	 * @throws
	 */
	public Map<String, Object> gzdxChart(String zzjgdm);
	/**
	 * @Title: bzdzChart 
	 * @描述: 标准地址饼状图
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2014-7-11 上午9:58:31 
	 * @返回值: Map<String,Object>    返回类型 
	 * @throws
	 */
	public Map<String, Object> bzdzChart(String zzjgdm);
	/**
	 * @Title: ldrkChart 
	 * @描述: 流动人口来自地区状图
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2014-7-11 上午10:10:05 
	 * @返回值: Map<String,Object>    返回类型 
	 * @throws
	 */
	public Map<String, Object> ldrkChart(String zzjgdm);
	/**
	 * @Title: jwrkChart 
	 * @描述: 境外人口柱状图
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2014-7-11 上午10:31:28 
	 * @返回值: Map<String,Object>    返回类型 
	 * @throws
	 */
	public Map<String, Object> jwrkChart(String zzjgdm);
	/**
	 * @Title: nlChart 
	 * @描述: 年龄段统计
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2014-7-14 下午6:37:46 
	 * @返回值: Map<String,Object>    返回类型 
	 * @throws
	 */
	public Map<String, Object> nlChart(String zzjgdm);
	/**
	 * @Title: whcdChart 
	 * @描述: 文化程度统计 
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2014-7-14 下午6:47:58 
	 * @返回值: Map<String,Object>    返回类型 
	 * @throws
	 */
	public Map<String, Object> whcdChart(String zzjgdm);
    /**
     * @Title: queryGzjlDate 
     * @描述: 获取工作记录时间 
     * @作者: zhang_guoliang@founder.com 
     * @参数: 传入参数定义 
     * @日期： 2014-7-10 上午11:19:32 
     * @返回值: List<String>    返回类型 
     * @throws
     */
	public List<String> queryGzjlDate();
	/**
	 * @Title: queryGzjlList 
	 * @描述: 获取工作记录昨天数据 
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2014-7-10 下午8:55:22 
	 * @返回值: List<Tjgzjl>    返回类型 
	 * @throws
	 */
	public List<Tjgzjl> queryGzjlList(Map<String,Object> param);
	public List<Map<String, String>> queryGzjlList2(Map<String,Object> param);
	/**
	 * @Title: queryGzjlInfo 
	 * @描述: 工作记录详情数据
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2014-7-14 下午10:59:29 
	 * @返回值: List<LogInfo>    返回类型 
	 * @throws
	 */
	public List<LogInfo> queryGzjlInfo(Map<String,Object> param);
	/**
	 * @Title: queryGzjlInfoCount 
	 * @描述:工作记录详情总数
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2014-7-15 下午2:04:18 
	 * @返回值: int    返回类型 
	 * @throws
	 */
	public int queryGzjlInfoCount(Map<String,Object> param);
	/**
	 * @Title: queryGzdxList 
	 * @描述: 查询工作对象坐标详情 
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2014-7-17 下午15:43:21 
	 * @返回值: List<Bzdzxxb>    返回类型 
	 * @throws
	 */
	public List<TjSyrk> queryGzdxList(Map<String,Object> param);
	/**
	 * @Title: queryldrkList 
	 * @描述: 流动人口统计坐标详情
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2014-7-17 下午4:32:18 
	 * @返回值: List<TjSyrk>    返回类型 
	 * @throws
	 */
	public List<TjSyrk> queryldrkList(Map<String,Object> param);
	/**
	 * @Title: queryjwrkList 
	 * @描述: 境外人口统计坐标详情
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2014-7-17 下午4:53:31 
	 * @返回值: List<TjSyrk>    返回类型 
	 * @throws
	 */
	public List<TjSyrk> queryjwrkList(Map<String,Object> param);
	/**
	 * @Title: querynlList 
	 * @描述: 年龄段统计坐标详情
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2014-7-17 下午5:04:26 
	 * @返回值: List<TjSyrk>    返回类型 
	 * @throws
	 */
	public List<TjSyrk> querynlList(Map<String,Object> param);
	/**
	 * @Title: queryXjZzjg 
	 * @描述: 获取派出所下级组织机构
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2014-10-23 下午2:03:37 
	 * @返回值: List<ZzjgVo>    返回类型 
	 * @throws
	 */
	public List<ZzjgVo> queryXjZzjg(String zzjgdm);
	
	/**
	 * @Title: queryPcsTj 
	 * @描述: 派出所统计
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2014-10-25 下午4:44:34 
	 * @返回值: List<ZzjgVo>    返回类型 
	 * @throws
	 */
	public List<ZzjgVo> queryPcsTj(Map<String,Object> params);
	/**
	 * @Title: queryZrqUser 
	 * @描述: 责任区民警
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2014-10-26 下午2:29:01 
	 * @返回值: List<ZzjgVo>    返回类型 
	 * @throws
	 */
	public List<ZzjgVo> queryZrqUser(String zzjgdm);
	/**
	 * @Title: querytwspMap 
	 * @描述: 天网视频撒点
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2014-10-27 下午4:32:17 
	 * @返回值: List<ZzjgVo>    返回类型 
	 * @throws
	 */
	public List<ZzjgVo> querytwspMap(String zzjgdm);
	/**
	 * @Title: censusChart
	 * @Description: TODO(首页派出所)
	 * @param @param zzjgdm
	 * @param @return    设定文件
	 * @return Map<String,Object>    返回类型
	 * @throws
	 */
	public Map<String, Object> censusChart(String zzjgdm, String pcsdm);
	/**
	 * @Title: querySydwMap 
	 * @描述: 实有单位撒点
	 * @作者: yu_sun@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2014-10-28 下午4:32:17 
	 * @返回值: List<ZzjgVo>    返回类型 
	 * @throws
	 */
	public List<ZzjgVo> querySydwMap(Map<String, Object> map);
	/**
	 * @Title: querySyfwMap 
	 * @描述: 实有房屋撒点
	 * @作者: yu_sun@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2014-10-28 下午4:32:17 
	 * @返回值: List<ZzjgVo>    返回类型 
	 * @throws
	 */
	public List<ZzjgVo> querySyfwMap(Map<String, Object> map);
	/**
	 * @Title: queryZdrkMap 
	 * @描述: 重点人口撒点
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2014-10-29 下午5:35:00 
	 * @返回值: List<ZzjgVo>    返回类型 
	 * @throws
	 */
	public List<ZzjgVo> queryZdrkMap(Map<String, Object> map);
	/**
	 * @Title: queryPcs 
	 * @描述: 查询所有派出所代码
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2014-11-21 下午5:22:39 
	 * @返回值: List<ZzjgVo>    返回类型 
	 * @throws
	 */
	public List<ZzjgVo> queryPcs();
	
	//begin
	/**
	 * @Title: queryXjList 
	 * @描述: 查询巡警坐标详情 
	 * @参数: 传入参数定义 
	 * @日期： 2015-1-1 下午8:33:46 
	 * @返回值: List<LogInfo>    返回类型 
	 * @throws
	 */
	public List<TjSyrk> queryXjList(Map<String,Object> param);
	
	/** 
	 * @Title: queryXjZzjg 
	 * @描述: 获取分局组织机构
	 * @参数: 传入参数定义 
	 * @返回值: List<ZzjgVo>    返回类型 
	 * @throws
	 */
	public List<ZzjgVo> queryXjZzjgxj(String zzjgdm);
	
	public List jsonTree(String id, String orgcode, String flag);
	
	public List<Org_Organization> downMap(String orgcode);
	
	 /**
     * @Title: jqChart 
     * @描述: 警情饼状图
     * @参数: 传入参数定义 
     * @日期： 2014-12-8 下午9:02:19 
     * @返回值: Map<String,Object>    返回类型 
     * @throws
     */
	public Map<String, Object> jqChart(String zzjgdm);
	
	/**
	 * @Title: queryXly 
	 * @描述: 查询巡逻员统计
	 * @参数: 传入参数定义 
	 * @日期： 2014-12-9 下午5:04:26 
	 * @返回值: List<TjSyrk>    返回类型 
	 * @throws
	 */
	public List<Xjtjemployee> queryXly(Map<String,Object> param);
	
	/**
	 * @Title: queryCar 
	 * @描述: 查询巡逻车统计
	 * @参数: 传入参数定义 
	 * @日期： 2014-12-9 下午5:04:26 
	 * @返回值: List<TjSyrk>    返回类型 
	 * @throws
	 */
	public List<Xjtjcar> queryCar(Map<String,Object> param);
	
	/**
	 * @Title: queryCar 
	 * @描述: 查询巡逻车统计
	 * @参数: 传入参数定义 
	 * @日期： 2014-12-9 下午5:04:26 
	 * @返回值: List<TjSyrk>    返回类型 
	 * @throws
	 */
	public List<XjtjXq> queryXq(Map<String,Object> param);
	
	public EasyUIPage queryXly(EasyUIPage page, Map<String,Object> param);
	
	public EasyUIPage queryXllx(EasyUIPage page, Map<String,Object> param);
	
	/**
     * @Title: querySZ 
     * @描述: 获取设置 
     * @参数: 传入参数定义 
     * @日期： 2014-12-15 上午11:19:32 
     * @返回值: List<String>    返回类型 
     * @throws
     */
	public List<XJSZ> querySZ( Map<String,Object> param);
	
	/**
     * @Title: uptSZ 
     * @描述: 修改设置 
     * @参数: 传入参数定义 
     * @日期： 2014-12-15 上午11:19:32 
     * @返回值: List<String>    返回类型 
     * @throws
     */
	public int uptSZ( Map<String,Object> param);
	
	/**
     * @Title: uptSZ 
     * @描述: 修改设置 
     * @参数: 传入参数定义 
     * @日期： 2014-12-15 上午11:19:32 
     * @返回值: List<String>    返回类型 
     * @throws
     */
	public int addSZ( Map<String,Object> param);
	//end
	
	//jz begin
	/**
     * @Title: syrkChart 
     * @描述: 实有单位饼状图
     * @参数: 传入参数定义 
     * @日期： 2014-7-9 下午9:02:19 
     * @返回值: Map<String,Object>    返回类型 
     * @throws
     */
	public Map<String, Object> sydwChart(String zzjgdm);
	/**
     * @Title: syrkChart 
     * @描述: 实有房屋饼状图
     * @参数: 传入参数定义 
     * @日期： 2014-7-9 下午9:02:19 
     * @返回值: Map<String,Object>    返回类型 
     * @throws
     */
	public Map<String, Object> syfwChart(String zzjgdm);
	//jz end
	/**
     * @Title: queryzrqtj
     * @描述: 责任区统计
     * @参数: 传入参数定义 
     * @日期： 2014-7-9 下午9:02:19 
     * @返回值: Map<String,Object>    返回类型 
     * @throws
     */
	public Map<String, Object> queryzrqtj(Map<String, Object> paramMap);
	
}