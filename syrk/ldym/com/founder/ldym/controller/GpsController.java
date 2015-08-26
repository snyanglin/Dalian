package com.founder.ldym.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.founder.framework.base.controller.BaseController;
import com.founder.ldym.pojo.TZhddSsjlLsgj;
import com.founder.ldym.service.TGpsRealtimeService;


/**
 * 
 * <p>标题：GPS</p>
 * <p>描述：</p>
 * <p>Copyright：Copyright(c) 2014 founder</p>
 * <p>日期：2014-10-17</p>
 * @author	gb
 */
@Controller
@RequestMapping(value="/gps", method=RequestMethod.POST)
public class GpsController extends BaseController{
	
	/**
	 * TGpsRealtimeService  注入service
	 */
	@Autowired
	public TGpsRealtimeService tGpsRealtimeService;

	/**
	 * 
	 * <p>说明：根据指定的gpsid返回实时信号信息</p>
	 * <p>时间：2014-10-17 下午3:36:12</p>
	 * @param gpsids(逗号分隔)
	 * @return
	 */
	@RequestMapping("/getRealTimeGpsInfo")
	public @ResponseBody Map<String, Object> getRealTimeGpsInfo(String gpsids) {
		Map<String, Object> gpsInfo = new HashMap<String, Object>();
		gpsInfo = tGpsRealtimeService.getRealTimeGpsInfos(gpsids);
		return gpsInfo;
	}
	
	/**
	 * 
	 * <p>说明：根据指定组织机构代码统计实时GPS数量</p>
	 * <p>时间：2014-10-17 下午3:38:03</p>
	 * @param zzjgdm gps分组的管理单位代码
	 * @return  v3333
	 */
	@RequestMapping("/getGpsTypeNumberCount")
	public @ResponseBody List<Map<String, String>> getGpsTypeNumberCount(String zzjgdm, String gpsTableName) {
		List<Map<String, String>>  list = new ArrayList<Map<String, String>>();
        list = tGpsRealtimeService.getGpsTypeNumberCount(zzjgdm, gpsTableName);
		return list;
	}
	
	@RequestMapping("/getGpsOnlineList")
	public @ResponseBody List<Map<String, String>> getGpsOnline(String zzjgdm, String gpsTableName , String gpstype){
		List<Map<String, String>>  list = new ArrayList<Map<String, String>>();
        list = tGpsRealtimeService.getGpsOnlineList(zzjgdm, gpsTableName,gpstype);
		return list;
	}
	
	/**
	 * 
	 *<p>说明：根据组织机构统计人数</p>
	 *<p>时间： 2014-11-5 下午： 下午2:22:50</p>
	 * @param zzjgdm
	 * @param gpsTableName
	 * @return v333
	 */
	@RequestMapping("/getGpsPersonNumberCount")
	public @ResponseBody Map<String, Object> getGpsPersonNumberCount(String zzjgdm, String gpsTableName) {
		Map<String, Object> map = new HashMap<String, Object>();
        map = tGpsRealtimeService.getGpsPersonNumberCount(zzjgdm,gpsTableName);
		return map;
	}
	
	
	/**
	 * 
	 *<p>说明：根据GPSid查询Gps的详细信息</p>
	 *<p>时间： 2014-11-5 下午： 下午2:17:50</p>
	 * @param gpsid 
	 * @param gpsTableName 
	 * @return
	 */
	@RequestMapping("/getGpsInfoDetail")
	public @ResponseBody Map<String, Object> getGpsInfoDetail(String gpsid, String gpsTableName) {
		Map<String, Object> detaimap = new HashMap<String, Object>();
		detaimap = tGpsRealtimeService.getGpsInfoDetail(gpsid, gpsTableName);
		return detaimap;
	}
	
	@RequestMapping("/getLsgj")
	@ResponseBody
	public List<TZhddSsjlLsgj> queryLsgj(String gpsid,String time){
			List<TZhddSsjlLsgj>  list= tGpsRealtimeService.getJlLsgj(gpsid, time);
		return  list;
	}
	
}
