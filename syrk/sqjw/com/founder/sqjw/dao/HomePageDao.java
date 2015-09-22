package com.founder.sqjw.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.utils.UUID;
import com.founder.sqjw.bean.LogInfo;
import com.founder.sqjw.bean.TjSyrk;
import com.founder.sqjw.bean.Tjgzjl;
import com.founder.sqjw.bean.XJSZ;
import com.founder.sqjw.bean.XjtjXq;
import com.founder.sqjw.bean.Xjtjcar;
import com.founder.sqjw.bean.Xjtjemployee;
import com.founder.sqjw.bean.Xjxlrw;
import com.founder.sqjw.vo.ZdryCountVo;
import com.founder.sqjw.vo.ZzjgVo;
import com.founder.tzgg.bean.Org_Organization;

/**
 * @类名: HomePageDao
 * @描述:(类描述)
 * @作者: zhang_guoliang@founder.com
 * @日期: 2014-7-4 下午3:46:17
 * 
 */
@Repository("homePageDao")
public class HomePageDao extends BaseDaoImpl {
	/**
	 * @Title: queryGzjlDate
	 * @描述: 获取工作记录时间
	 * @作者: zhang_guoliang@founder.com
	 * @参数: 传入参数定义
	 * @日期： 2014-7-10 上午11:20:21
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	public List<String> queryGzjlDate() {
		return queryForList("HomePage.queryGzjlDate");
	}

	/**
	 * @Title: queryGzjlList
	 * @描述: 获取工作记录昨天数据
	 * @作者: zhang_guoliang@founder.com
	 * @参数: 传入参数定义
	 * @日期： 2014-7-10 下午8:58:06
	 * @返回值: List<String> 返回类型
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	public List<Tjgzjl> queryGzjlList(Map<String, Object> param) {
		return queryForList("HomePage.queryGzjlList", param);
	}
	@SuppressWarnings("unchecked")
	public List<Map<String, String>> queryGzjlList2(Map<String, Object> param) {
		return queryForList("HomePage.queryGzjlList2", param);
	}

	/**
	 * @Title: syrkChart
	 * @描述: 实有人口饼状图
	 * @作者: zhang_guoliang@founder.com
	 * @参数: 传入参数定义
	 * @日期： 2014-7-14 下午4:17:45
	 * @返回值: List<TjSyrk> 返回类型
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	public List<TjSyrk> syrkChart(Map<String, Object> map) {
		String zzjgdm = (String) map.get("zzjgdm");
		Map<String, Object> params = new HashMap<String, Object>();
		if (zzjgdm.length() >= 12 && "0000".equals(zzjgdm.substring(8, 12))) {
			params.put("lx", 14);
		} else {
			params.put("lx", 15);
		}
		params.put("zzjgdm", zzjgdm);
		//局长判断  begin
		params.put("flag", (String) map.get("flag"));
		params.put("type", (String) map.get("type"));
		//局长判断  end
		return queryForList("HomePage.syrkChart", params);
	}

	/**
	 * @Title: ldrkhjdChart
	 * @描述: 工作对象柱状图
	 * @作者: zhang_guoliang@founder.com
	 * @参数: 传入参数定义
	 * @日期： 2014-7-14 下午4:29:31
	 * @返回值: List<TjSyrk> 返回类型
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	public List<TjSyrk> gzdxChart(Map<String, Object> map) {
		return queryForList("HomePage.gzdxChart", map);
	}

	/**
	 * @Title: bzdzChart
	 * @描述: 标准地址饼状图
	 * @作者: zhang_guoliang@founder.com
	 * @参数: 传入参数定义
	 * @日期： 2014-7-14 下午4:42:48
	 * @返回值: List<TjSyrk> 返回类型
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	public List<TjSyrk> bzdzChart(String zzjgdm) {
		return queryForList("HomePage.bzdzChart", zzjgdm);
	}

	/**
	 * @Title: ldrkChart
	 * @描述: 流动人口来自地区柱状图
	 * @作者: zhang_guoliang@founder.com
	 * @参数: 传入参数定义
	 * @日期： 2014-7-14 下午5:03:28
	 * @返回值: List<TjSyrk> 返回类型
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	public List<TjSyrk> ldrkChart(Map<String, Object> map) {
		String zzjgdm = (String) map.get("zzjgdm");
		Map<String, Object> params = new HashMap<String, Object>();
		if (zzjgdm.length() >= 12 && "0000".equals(zzjgdm.substring(8, 12))) {
			params.put("lx", 14);
		} else {
			params.put("lx", 15);
		}
		params.put("zzjgdm", zzjgdm);
		//局长判断  begin
		params.put("flag", (String) map.get("flag"));
		params.put("type", (String) map.get("type"));
		//局长判断  end
		return queryForList("HomePage.ldrkChart", params);
	}

	/**
	 * @Title: jwrkChart
	 * @描述: 境外人口柱状图
	 * @作者: zhang_guoliang@founder.com
	 * @参数: 传入参数定义
	 * @日期： 2014-7-14 下午6:05:19
	 * @返回值: List<TjSyrk> 返回类型
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	public List<TjSyrk> jwrkChart(String zzjgdm) {
		return queryForList("HomePage.jwrkChart", zzjgdm);
	}

	/**
	 * @Title: nlChart
	 * @描述: 年龄段统计
	 * @作者: zhang_guoliang@founder.com
	 * @参数: 传入参数定义
	 * @日期： 2014-7-14 下午6:39:40
	 * @返回值: List<TjSyrk> 返回类型
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	public List<TjSyrk> nlChart(Map<String, Object> map) {
		return queryForList("HomePage.nlChart", map);
	}

	/**
	 * @Title: whcdChart
	 * @描述: 文化程度统计
	 * @作者: zhang_guoliang@founder.com
	 * @参数: 传入参数定义
	 * @日期： 2014-7-14 下午6:49:56
	 * @返回值: List<TjSyrk> 返回类型
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	public List<TjSyrk> whcdChart(String zzjgdm) {
		return queryForList("HomePage.whcdChart", zzjgdm);
	}

	/**
	 * @Title: queryGzjlInfo
	 * @描述: 工作记录详情数据
	 * @作者: zhang_guoliang@founder.com
	 * @参数: 传入参数定义
	 * @日期： 2014-7-14 下午11:00:44
	 * @返回值: List<TjSyrk> 返回类型
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	public List<LogInfo> queryGzjlInfo(Map<String, Object> param) {
		return queryForList("HomePage.queryGzjlInfo", param);
	}

	/**
	 * @Title: queryGzjlInfoCount
	 * @描述: 工作记录详情总数
	 * @作者: zhang_guoliang@founder.com
	 * @参数: 传入参数定义
	 * @日期： 2014-7-15 下午2:07:13
	 * @返回值: int 返回类型
	 * @throws
	 */
	public int queryGzjlInfoCount(Map<String, Object> param) {
		return (Integer) queryForObject("HomePage.queryGzjlInfoCount", param);
	}

	/**
	 * @Title: queryGzdxList
	 * @描述: 查询工作对象坐标详情
	 * @作者: zhang_guoliang@founder.com
	 * @参数: 传入参数定义
	 * @日期： 2014-7-17 下午3:46:22
	 * @返回值: List<TjSyrk> 返回类型
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	public List<TjSyrk> queryGzdxList(Map<String, Object> param) {
		return queryForList("HomePage.queryGzdxList", param);
	}

	/**
	 * @Title: queryldrkList
	 * @描述: 流动人口统计坐标详情
	 * @作者: zhang_guoliang@founder.com
	 * @参数: 传入参数定义
	 * @日期： 2014-7-17 下午4:34:05
	 * @返回值: List<TjSyrk> 返回类型
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	public List<TjSyrk> queryldrkList(Map<String, Object> param) {
		return queryForList("HomePage.queryldrkList", param);
	}

	/**
	 * @Title: queryjwrkList
	 * @描述: 境外人口统计坐标详情
	 * @作者: zhang_guoliang@founder.com
	 * @参数: 传入参数定义
	 * @日期： 2014-7-17 下午4:54:26
	 * @返回值: List<TjSyrk> 返回类型
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	public List<TjSyrk> queryjwrkList(Map<String, Object> param) {
		return queryForList("HomePage.queryjwrkList", param);
	}

	/**
	 * @Title: querynlList
	 * @描述: 年龄段统计坐标详情
	 * @作者: zhang_guoliang@founder.com
	 * @参数: 传入参数定义
	 * @日期： 2014-7-17 下午5:05:27
	 * @返回值: List<TjSyrk> 返回类型
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	public List<TjSyrk> querynlList(Map<String, Object> param) {
		return queryForList("HomePage.querynlList", param);
	}

	/**
	 * @Title: queryXjZzjg
	 * @描述: 获取派出所下级组织机构
	 * @作者: zhang_guoliang@founder.com
	 * @参数: 传入参数定义
	 * @日期： 2014-10-23 下午2:11:34
	 * @返回值: List<ZzjgVo> 返回类型
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	public List<ZzjgVo> queryXjZzjg(String zzjgdm) {
		return queryForList("HomePage.queryXjZzjg", zzjgdm);
	}

	/**
	 * @Title: queryPcsTj
	 * @描述: 派出所统计
	 * @作者: zhang_guoliang@founder.com
	 * @参数: 传入参数定义
	 * @日期： 2014-10-25 下午4:45:50
	 * @返回值: List<ZzjgVo> 返回类型
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	public List<ZzjgVo> queryPcsTj(Map<String, Object> params) {
		return queryForList("HomePage.queryPcsTj", params);
	}

	/**
	 * @Title: queryZrqUser
	 * @描述: 责任区民警
	 * @作者: zhang_guoliang@founder.com
	 * @参数: 传入参数定义
	 * @日期： 2014-10-26 下午2:30:24
	 * @返回值: List<ZzjgVo> 返回类型
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	public List<ZzjgVo> queryZrqUser(String zzjgdm) {
		return queryForList("HomePage.queryZrqUser", zzjgdm);
	}

	/**
	 * @Title: querytwspMap
	 * @描述: 天网视频撒点
	 * @作者: zhang_guoliang@founder.com
	 * @参数: 传入参数定义
	 * @日期： 2014-10-27 下午4:33:34
	 * @返回值: List<ZzjgVo> 返回类型
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	public List<ZzjgVo> querytwspMap(String zzjgdm) {
		return queryForList("HomePage.querytwspMap", zzjgdm);
	}
    
    
     /**
 	 * @Title: querySydwMap
 	 * @描述: 实有单位撒点
 	 * @作者: yu_sun@founder.com
 	 * @参数: 传入参数定义
 	 * @日期： 2014-10-28 下午4:33:34
 	 * @返回值: List<ZzjgVo> 返回类型
 	 * @throws
 	 */
 	@SuppressWarnings("unchecked")
 	public List<ZzjgVo> querySydwMap(Map<String, Object> map) {
 		return queryForList("HomePage.querySydwMap", map);
 	}
 	/**
	 * @Title: querytwspMap
	 * @描述: 实有房屋撒点
	 * @作者: yu_sun@founder.com
	 * @参数: 传入参数定义
	 * @日期： 2014-10-28 下午4:33:34
	 * @返回值: List<ZzjgVo> 返回类型
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	public List<ZzjgVo> querySyfwMap(Map<String, Object> map) {
		return queryForList("HomePage.querySyfwMap", map);
	}
	
	/**
     * 
     * @Title: censusChart
     * @Description: TODO(月统计/季度统计)
     * @param @param map
     * @param @return    设定文件
     * @return List<TjSyrk>    返回类型
     * @throws
     */
     @SuppressWarnings("unchecked")
     public List<TjSyrk> censusChart(Map<String, Object> map){
     	return queryForList("HomePage.censusChart", map);
     }
     
     /**
      * 
      * @Title: censusDayChart
      * @Description: TODO(日统计)
      * @param @param map
      * @param @return    设定文件
      * @return List<TjSyrk>    返回类型
      * @throws
      */
     @SuppressWarnings("unchecked")
     public List<TjSyrk> censusDayChart(Map<String, Object> map){
     	return queryForList("HomePage.censusDayChart", map);
     }
     
     /**
      * 
      * @Title: censusWeekChart
      * @Description: TODO(周统计)
      * @param @param map
      * @param @return    设定文件
      * @return List<TjSyrk>    返回类型
      * @throws
      */
     @SuppressWarnings("unchecked")
     public List<TjSyrk> censusWeekChart(Map<String, Object> map){
     	return queryForList("HomePage.censusWeekChart", map);
     }
     
     /**
      * 
      * @Title: censusWeekChart
      * @Description: TODO(周统计)
      * @param @param map
      * @param @return    设定文件
      * @return List<TjSyrk>    返回类型
      * @throws
      */
     @SuppressWarnings("unchecked")
     public List<TjSyrk> censusChartSyrkWeek(Map<String, Object> map){
     	return queryForList("HomePage.censusChartSyrkWeek", map);
     }
     
     @SuppressWarnings("unchecked")
     public List<TjSyrk> censusChartZdryWeek(Map<String, Object> map){
     	return queryForList("HomePage.censusChartZdryWeek", map);
     }
     
     @SuppressWarnings("unchecked")
     public List<TjSyrk> censusChartSydwWeek(Map<String, Object> map){
     	return queryForList("HomePage.censusChartSydwWeek", map);
     }
     
     @SuppressWarnings("unchecked")
     public List<TjSyrk> censusChartSyfwWeek(Map<String, Object> map){
     	return queryForList("HomePage.censusChartSyfwWeek", map);
     }
     
     @SuppressWarnings("unchecked")
     public List<TjSyrk> censusChartBzdzWeek(Map<String, Object> map){
     	return queryForList("HomePage.censusChartBzdzWeek", map);
     }
     
//
     @SuppressWarnings("unchecked")
     public List<TjSyrk> censusChartSyrk(Map<String, Object> map){
     	return queryForList("HomePage.censusChartSyrk", map);
     }
     
     @SuppressWarnings("unchecked")
     public List<TjSyrk> censusChartZdry(Map<String, Object> map){
     	return queryForList("HomePage.censusChartZdry", map);
     }
     
     @SuppressWarnings("unchecked")
     public List<TjSyrk> censusChartSydw(Map<String, Object> map){
     	return queryForList("HomePage.censusChartSydw", map);
     }
     
     @SuppressWarnings("unchecked")
     public List<TjSyrk> censusChartSyfw(Map<String, Object> map){
     	return queryForList("HomePage.censusChartSyfw", map);
     }
     
     @SuppressWarnings("unchecked")
     public List<TjSyrk> censusChartBzdz(Map<String, Object> map){
     	return queryForList("HomePage.censusChartBzdz", map);
     }

//
     
     @SuppressWarnings("unchecked")
     public List<TjSyrk> censusDayChartSyrk(Map<String, Object> map){
     	return queryForList("HomePage.censusDayChartSyrk", map);
     }
     
     @SuppressWarnings("unchecked")
     public List<TjSyrk> censusDayChartZdry(Map<String, Object> map){
     	return queryForList("HomePage.censusDayChartZdry", map);
     }
     
     @SuppressWarnings("unchecked")
     public List<TjSyrk> censusDayChartSydw(Map<String, Object> map){
     	return queryForList("HomePage.censusDayChartSydw", map);
     }
     
     @SuppressWarnings("unchecked")
     public List<TjSyrk> censusDayChartSyfw(Map<String, Object> map){
     	return queryForList("HomePage.censusDayChartSyfw", map);
     }
     
     @SuppressWarnings("unchecked")
     public List<TjSyrk> censusDayChartBzdz(Map<String, Object> map){
     	return queryForList("HomePage.censusDayChartBzdz", map);
     }
     /**
      * @Title: queryZdrkMap 
      * @描述:(方法描述) 
      * @作者: zhang_guoliang@founder.com 
      * @参数: 传入参数定义 
      * @日期： 2014-10-29 下午5:45:37 
      * @返回值: List<ZzjgVo>    返回类型 
      * @throws
      */
     @SuppressWarnings("unchecked")
 	 public List<ZzjgVo> queryZdrkMap(Map<String, Object> map) {
 		return queryForList("HomePage.queryZdrkMap", map);
 	 }
     /**
      * @Title: queryPcs 
      * @描述: 查询所有派出所代码
      * @作者: zhang_guoliang@founder.com 
      * @参数: 传入参数定义 
      * @日期： 2014-11-21 下午5:24:44 
      * @返回值: List<ZzjgVo>    返回类型 
      * @throws
      */
     @SuppressWarnings("unchecked")
	 public List<ZzjgVo> queryPcs() {
  		return queryForList("HomePage.queryPcs");
  	 }
     
     //begin 
     /**
 	 * @Title: queryXjList
 	 * @描述: 查询巡警坐标详情
 	 * @参数: 传入参数定义
 	 * @日期： 2015-1-1 下午8:41:27
 	 * @返回值: List<Bzdzxxb> 返回类型
 	 * @throws
 	 */
 	@SuppressWarnings("unchecked")
 	public List<TjSyrk> queryXjList(Map<String, Object> param) {
 		String zzjgdm = param.get("lx").toString();
 		String type = zzjgdm.substring(zzjgdm.indexOf("@")+1, zzjgdm.indexOf("*"));
		String flag = zzjgdm.substring(zzjgdm.indexOf("*")+1, zzjgdm.length());
		zzjgdm = zzjgdm.substring(0, zzjgdm.indexOf("~"));
		String lxs = param.get("lxs").toString();
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("zzjgdm", zzjgdm);
		params.put("lxs", lxs);
		params.put("type", type);
		Date date = new Date();
		String dateStr = "";
		String temp = "";
		String begin = "";
		String end = "";
		if (flag.equals("month")) {
			dateStr = new SimpleDateFormat("yyyy-MM").format(date); 
			temp = "mon";
		} else if(flag.equals("week")){
			begin = this.getMondayOfWeek();
			end = this.getSundayOfWeek();
			temp = "week";
		} else if (flag.equals("hour")) {
			dateStr = new SimpleDateFormat("yyyy-MM-dd").format(date);
			temp = "hour";
		} else {
			dateStr = flag;
			temp = "custom";
		}
		params.put("parm", dateStr);
		params.put("temp", temp);
		params.put("begin", begin);
		params.put("end", end);
	
		 String zero8 = zzjgdm.substring(zzjgdm.length()-8, zzjgdm.length());
		 String zero6 = zzjgdm.substring(zzjgdm.length()-6, zzjgdm.length());
		 String zero4 = zzjgdm.substring(zzjgdm.length()-4, zzjgdm.length());
		 if (zero8.equals("00000000")) {
			 params.put("flag", "FJ");
		 } else if(zero6.equals("000000")){
			 params.put("flag", "PCS");
		 } else if(!zero8.equals("00000000") && !zero6.equals("000000") && zero4.equals("0000")){
			 params.put("flag", "ZRQ");
		 }
		 
		if("jqChart".equals(type)){
			return queryForList("HomePage.jqPotin", params);
		} else if("ajChart".equals(type)){
			return queryForList("HomePage.ajPoint", params);
		} else if("kxxChart".equals(type)){
			params.put("KFX", "1");
			return queryForList("HomePage.ajPoint", params);
		} else if("sjChart".equals(type)){
			return queryForList("HomePage.sjPoint", params);
		}
		return null; 
 	}
 	
	 @SuppressWarnings("unchecked")
	 public List<Org_Organization> queryTree(String id, String orgcode, String flag) {
		 Map<String, Object> map = new HashMap<String, Object>();
		 map.put("id", id);
		 map.put("orgcode", orgcode);
		 String zero8 = orgcode.substring(orgcode.length()-8, orgcode.length());
		 String zero6 = orgcode.substring(orgcode.length()-6, orgcode.length());
		 String zero4 = orgcode.substring(orgcode.length()-4, orgcode.length());
		 if (zero8.equals("00000000")) {
			map.put("flag", "FJ");
		 } else if(zero6.equals("000000")){
			 map.put("flag", "PCS");
		 } else if(!zero8.equals("00000000") && !zero6.equals("000000") && zero4.equals("0000")){
			 map.put("flag", "ZRQ");
		 }
		 if (null != flag && "line".equals(flag)) {
			 map.put("line", "line");
		 } 
		 return queryForList("HomePage.queryTree", map);
  	 }
     
	 /**
		 * @Title: queryXjZzjg
		 * @描述: 获取分局组织机构
		 * @参数: 传入参数定义
		 * @返回值: List<ZzjgVo> 返回类型 
		 * @throws
		 */
		@SuppressWarnings("unchecked")
		public List<ZzjgVo> queryXjZzjgxj(String zzjgdm) {
			List list = new ArrayList();
			String [] str = zzjgdm.split(",");
			for (int i = 0; i < str.length; i++) {
				ZzjgVo entity = new ZzjgVo();
				entity.setId(str[i]);
				list.add(entity);
			}
			return queryForList("HomePage.queryXjZzjgxj", list);
		}
		
	 /**
		 * @Title: jqChart
		 * @描述: 警情饼状图
		 * @参数: 传入参数定义
		 * @日期： 2014-12-8 下午4:17:45
		 * @返回值: List<TjSyrk> 返回类型
		 * @throws
		 */
		@SuppressWarnings("unchecked")
		public List<TjSyrk> jqChart(String zzjgdm) {
			String type = zzjgdm.substring(zzjgdm.indexOf("@")+1, zzjgdm.indexOf("*"));
			String flag = zzjgdm.substring(zzjgdm.indexOf("*")+1, zzjgdm.length());
			zzjgdm = zzjgdm.substring(0, zzjgdm.indexOf("~"));
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("zzjgdm", zzjgdm);
			params.put("type", type);
			Date date = new Date();
			String dateStr = "";
			String temp = "";
			String begin = "";
			String end = "";
			if (flag.equals("month")) {
				dateStr = new SimpleDateFormat("yyyy-MM").format(date); 
				temp = "mon";
			} else if(flag.equals("week")){
				begin = this.getMondayOfWeek();
				end = this.getSundayOfWeek();
				temp = "week";
			} else if (flag.equals("hour")) {
				dateStr = new SimpleDateFormat("yyyy-MM-dd").format(date);
				temp = "hour";
			} else {
				dateStr = flag;
				temp = "custom";
			}
			params.put("parm", dateStr);
			params.put("temp", temp);
			params.put("begin", begin);
			params.put("end", end);
		
			 String zero8 = zzjgdm.substring(zzjgdm.length()-8, zzjgdm.length());
			 String zero6 = zzjgdm.substring(zzjgdm.length()-6, zzjgdm.length());
			 String zero4 = zzjgdm.substring(zzjgdm.length()-4, zzjgdm.length());
			 if (zero8.equals("00000000")) {
				 params.put("flag", "FJ");
			 } else if(zero6.equals("000000")){
				 params.put("flag", "PCS");
			 } else if(!zero8.equals("00000000") && !zero6.equals("000000") && zero4.equals("0000")){
				 params.put("flag", "ZRQ");
			 }
			 
			if("jqChart".equals(type)){
				return queryForList("HomePage.jqChart", params);
			} else if("ajChart".equals(type)){
				return queryForList("HomePage.ajChart", params);
			} else if("kxxChart".equals(type)){
				params.put("KFX", "1");
				return queryForList("HomePage.ajChart", params);
			} else if("sjChart".equals(type)){
				return queryForList("HomePage.jqChart", params);
			}
			return null; 
		}
		
		private static int getMonthPlus(){
			Calendar cal = Calendar.getInstance();
			int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK) - 1;
			if (dayOfWeek == 1) {
				return 0;
			} else {
				return 1 - dayOfWeek;
			}
		}
		//周一
		private static String getMondayOfWeek(){
			int weeks = 0;
			int mondayPlus = HomePageDao.getMonthPlus();
			GregorianCalendar currentDate = new GregorianCalendar();
			currentDate.add(GregorianCalendar.DATE, mondayPlus);
			Date monday = currentDate.getTime();
			return new SimpleDateFormat("yyyy-MM-dd").format(monday);
		}
		//周日
		private static String getSundayOfWeek(){
			int weeks = 0;
			int mondayPlus = HomePageDao.getMonthPlus();
			GregorianCalendar currentDate = new GregorianCalendar();
			currentDate.add(GregorianCalendar.DATE, mondayPlus+6);
			Date monday = currentDate.getTime();
			return new SimpleDateFormat("yyyy-MM-dd").format(monday);
		}
		
		 @SuppressWarnings("unchecked")
	     public List<Xjtjemployee> queryXly(Map<String, Object> map){
			Date date = new Date();
			String flag = "" + map.get("flag");
			String dateStr = "";
			String temp = "";
			String begin = "";
			String end = "";
			if ("month".equals(flag)) {
				dateStr = new SimpleDateFormat("yyyy-MM").format(date); 
				temp = "mon";
			} else if("week".equals(flag)){
				begin = this.getMondayOfWeek();
				end = this.getSundayOfWeek();
				temp = "week";
			} else {
				dateStr = flag;
				temp = "custom";
			}
			map.put("parm", dateStr);
			map.put("temp", temp);
			map.put("begins", begin);
			map.put("ends", end);
	     	return queryForList("HomePage.queryXly", map);
	     }
		 
		 @SuppressWarnings("unchecked")
	     public int queryXlyCount(Map<String, Object> map){
			Date date = new Date();
			String flag = "" + map.get("flag");
			String dateStr = "";
			String temp = "";
			String begin = "";
			String end = "";
			if ("month".equals(flag)) {
				dateStr = new SimpleDateFormat("yyyy-MM").format(date); 
				temp = "mon";
			} else if("week".equals(flag)){
				begin = this.getMondayOfWeek();
				end = this.getSundayOfWeek();
				temp = "week";
			} else {
				dateStr = flag;
				temp = "custom";
			}
			map.put("parm", dateStr);
			map.put("temp", temp);
			map.put("begins", begin);
			map.put("ends", end);
			return (Integer) queryForObject("HomePage.queryXlyCount", map);
	     }
		 
		 
		 @SuppressWarnings("unchecked")
	     public List<Xjtjcar> queryCar(Map<String, Object> map){
			Date date = new Date();
			String flag = "" + map.get("flag");
			String dateStr = "";
			String temp = "";
			String begin = "";
			String end = "";
			if ("month".equals(flag)) {
				dateStr = new SimpleDateFormat("yyyy-MM").format(date); 
				temp = "mon";
			} else if("week".equals(flag)){
				begin = this.getMondayOfWeek();
				end = this.getSundayOfWeek();
				temp = "week";
			} else {
				dateStr = flag;
				temp = "custom";
			}
			map.put("parm", dateStr);
			map.put("temp", temp);
			map.put("begins", begin);
			map.put("ends", end);
	     	return queryForList("HomePage.queryCar", map);
	     }
		 
		 @SuppressWarnings("unchecked")
	     public int queryCarCount(Map<String, Object> map){
			Date date = new Date();
			String flag = "" + map.get("flag");
			String dateStr = "";
			String temp = "";
			String begin = "";
			String end = "";
			if ("month".equals(flag)) {
				dateStr = new SimpleDateFormat("yyyy-MM").format(date); 
				temp = "mon";
			} else if("week".equals(flag)){
				begin = this.getMondayOfWeek();
				end = this.getSundayOfWeek();
				temp = "week";
			} else {
				dateStr = flag;
				temp = "custom";
			}
			map.put("parm", dateStr);
			map.put("temp", temp);
			map.put("begins", begin);
			map.put("ends", end);
			return (Integer) queryForObject("HomePage.queryCarCount", map);
	     }
		 
		 @SuppressWarnings("unchecked")
	     public List<XjtjXq> queryXq(Map<String, Object> map){
			Date date = new Date();
			String flag = "" + map.get("flag");
			String dateStr = "";
			String temp = "";
			String begin = "";
			String end = "";
			if ("month".equals(flag)) {
				dateStr = new SimpleDateFormat("yyyy-MM").format(date); 
				temp = "mon";
			} else if("week".equals(flag)){
				begin = this.getMondayOfWeek();
				end = this.getSundayOfWeek();
				temp = "week";
			} else {
				dateStr = flag;
				temp = "custom";
			}
			map.put("parm", dateStr);
			map.put("temp", temp);
			map.put("begins", begin);
			map.put("ends", end);
	     	return queryForList("HomePage.queryXq", map);
	     }
		 
		 @SuppressWarnings("unchecked")
	     public int queryXqCount(Map<String, Object> map){
			Date date = new Date();
			String flag = "" + map.get("flag");
			String dateStr = "";
			String temp = "";
			String begin = "";
			String end = "";
			if ("month".equals(flag)) {
				dateStr = new SimpleDateFormat("yyyy-MM").format(date); 
				temp = "mon";
			} else if("week".equals(flag)){
				begin = this.getMondayOfWeek();
				end = this.getSundayOfWeek();
				temp = "week";
			} else {
				dateStr = flag;
				temp = "custom";
			}
			map.put("parm", dateStr);
			map.put("temp", temp);
			map.put("begins", begin);
			map.put("ends", end);
			return (Integer) queryForObject("HomePage.queryXqCount", map);
	     }
		 
		 @SuppressWarnings("unchecked")
	     public List<Xjxlrw> queryXllx(Map<String, Object> map){
	     	return queryForList("HomePage.queryXllx", map);
	     }
		 
		 @SuppressWarnings("unchecked")
	     public int queryXllxCount(Map<String, Object> map){
	     	return (Integer)queryForObject("HomePage.queryXllxCount", map);
	     }
		 
		 
		 @SuppressWarnings("unchecked")
	     public List<Xjxlrw> queryXllxs(Map<String, Object> map){
	     	return queryForList("HomePage.queryXllxs", map);
	     }
		 
		 /**
			 * @Title: querySZ
			 * @描述: 设置偏好
			 * @参数: 传入参数定义
			 * @日期： 2014-12-15 上午11:20:21
			 * @throws
			 */
			@SuppressWarnings("unchecked")
			public List<XJSZ> querySZ(Map<String, Object> map) {
				return queryForList("HomePage.querySZ", map);
			}
			
			 /**
			 * @Title: uptSZ
			 * @描述: 设置偏好
			 * @参数: 传入参数定义
			 * @日期： 2014-12-15 上午11:20:21
			 * @throws
			 */
			@SuppressWarnings("unchecked")
			public int uptSZ(Map<String, Object> map) {
				String pro = ""+map.get("pro");
				String[] pros = pro.split(",");
				List list = new ArrayList();
				String temp = "";
				for (int i = 0; i < pros.length; i++) {
					list.add(pros[i]);
					if (!"".equals(pros[i])) {
						temp += pros[i];
					}
				}
				map.put("list", list);
				//前面split默认就有一个成员，故下面判断要大于1
				map.put("size", temp!="" ? "ok" : "");
				map.put("type", "xqdt");
				int a = update("HomePage.uptSZ", map);
				int b = update("HomePage.uptSZs", map);
				return a+b;
			}
			
			 /**
			 * @Title: addSZ
			 * @描述: 设置偏好
			 * @参数: 传入参数定义
			 * @日期： 2014-12-15 上午11:20:21
			 * @throws
			 */
			@SuppressWarnings("unchecked")
			public int addSZ(Map<String, Object> map) {
				String pro = ""+map.get("pro");
				String[] pros = pro.split(",");
				List list = new ArrayList();
				String temp = "";
				String arr[]  = {"qyfw", "zdrk", "jq", "aj", "sj", "xlxl", "xlc", "xly", "ssyj", "jqfx", "xljh", "kffx"};
				XJSZ sz;
				for (int i = 0; i < arr.length; i++) {
					sz = new XJSZ();
					sz.setId(UUID.create()); // 生成主键
					sz.setUserid(""+map.get("userid"));
					sz.setType(""+map.get("type"));
					sz.setPro(arr[i]);
					for (int j = 0; j < pros.length; j++) {
						if(arr[i].equals(pros[j])){
							sz.setSfxz("1");
							break;
						} else {
							sz.setSfxz("0");
							break;
						}
					}
					list.add(sz);
				}
				insert("HomePage.addSZ", list);
				return 1;
			}
			
		 //end
		 
		//jz begin
			/**
			 * @Title: sydwChart
			 * @描述: 实有单位饼状图
			 * @参数: 传入参数定义
			 * @日期： 2014-7-14 下午4:17:45
			 * @返回值: List<TjSyrk> 返回类型
			 * @throws
			 */
			@SuppressWarnings("unchecked")
			public List<TjSyrk> sydwChart(Map<String, Object> map) {
				String zzjgdm = (String) map.get("zzjgdm");
				Map<String, Object> params = new HashMap<String, Object>();
				if (zzjgdm.length() >= 12 && "0000".equals(zzjgdm.substring(8, 12))) {
					params.put("lx", 14);
				} else {
					params.put("lx", 15);
				}
				params.put("zzjgdm", zzjgdm);
				//局长判断  begin
				params.put("flag", (String) map.get("flag"));
				params.put("type", (String) map.get("type"));
				//局长判断  end
				return queryForList("HomePage.sydwChart", params);
			}
			
			/**
			 * @Title: syfwChart
			 * @描述: 实有房屋饼状图
			 * @参数: 传入参数定义
			 * @日期： 2014-7-14 下午4:17:45
			 * @返回值: List<TjSyrk> 返回类型
			 * @throws
			 */
			@SuppressWarnings("unchecked")
			public List<TjSyrk> syfwChart(Map<String, Object> map) {
				String zzjgdm = (String) map.get("zzjgdm");
				Map<String, Object> params = new HashMap<String, Object>();
				if (zzjgdm.length() >= 12 && "0000".equals(zzjgdm.substring(8, 12))) {
					params.put("lx", 14);
				} else {
					params.put("lx", 15);
				}
				params.put("zzjgdm", zzjgdm);
				//局长判断  begin
				params.put("flag", (String) map.get("flag"));
				params.put("type", (String) map.get("type"));
				//局长判断  end
				return queryForList("HomePage.syfwChart", params);
			}
		//jz end

			public List<ZzjgVo> queryZrqsyrkTj(Map<String, Object> paramMap) {
				
				return  queryForList("HomePage.queryZrqsyrkTj", paramMap);
			}
			public long queryCzfTj(Map<String, Object> paramMap) {
				return (long) queryForObject("HomePage.queryCzfTj", paramMap);
			}

			public long queryCheckTj(Map<String, Object> paramMap) {
				// TODO Auto-generated method stub
				return (long) queryForObject("HomePage.queryCheckTj", paramMap);
				
			}

			public long queryunCheckTj(Map<String, Object> paramMap) {
				// TODO Auto-generated method stub
				return (long) queryForObject("HomePage.queryunCheckTj", paramMap);
			}

			public List<ZdryCountVo> queryZdryTj(Map<String, Object> paramMap) {
				
				return  queryForList("HomePage.queryZdryTj", paramMap);
			}
}