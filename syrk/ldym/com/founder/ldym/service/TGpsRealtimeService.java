package com.founder.ldym.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.ldym.dao.TGpsInfoToBusiappDao;
import com.founder.ldym.dao.TGpsRealtimeDao;
import com.founder.ldym.pojo.TGpsInfo;
import com.founder.ldym.pojo.TGpsRealtime;
import com.founder.ldym.pojo.TZhddSsjlLsgj;
import com.founder.service.memcached.MemCachedManager;

/**
 * <p>标题：GPS实时信号业务层类</p>
 * <p>描述：法</p>
 * <p>Copyright：Copyright(c) 2014 founder</p>
 * <p>日期：2014-03-24</p>
 * @author gb
 */
@Service
@Transactional
public class TGpsRealtimeService {

	/**
	 * TGpsRealtimeDao 资源注入
	 */
	@Autowired
	private TGpsRealtimeDao tGpsRealtimeDao;
	
	/**
	 * TGpsInfoDao 资源注入
	 */
	@Autowired
	private TGpsInfoToBusiappDao tGpsInfoDao;
	
	/**
	 * 
	 * <p>说明：根据设备ID获取实时信号信息</p>
	 * <p>时间：2014-4-3 下午2:05:15</p>
	 * @param gpsIds gps设备ID 多个用逗号分隔
	 * @return list 查询结果集
	 */
	public List<TGpsRealtime> findTGpsRealtimeList(String[] gpsIds) { 
		return tGpsRealtimeDao.queryTGpsRealtimeList(gpsIds); 
	}
	
	/**
	 * 
	 *<p>说明：根据传入的gpsids在缓存中查找对应的值,key为gpsid，value为x和y坐标的值</p>
	 *<p>时间： 2014-10-21 下午： 下午3:17:22</p>
	 * @param gpsids
	 * @return
	 */
	public Map<String, Object> getRealTimeGpsInfos(String gpsids)
	{
		String[] gpsidArray = gpsids.split(",");
		int gpsIdsize = gpsidArray.length;
		Map<String, Object> gpsdatamap = new HashMap<String, Object>(gpsIdsize);
		Map<String, Object> GpsRealTimeData  = new HashMap<String, Object>();
		Map<String, Object> GpsRealTimeStatData  = new HashMap<String, Object>();
		//得到GPS实时数据
		GpsRealTimeData = getGpsCaches();
		GpsRealTimeStatData = getGpsStatCaches();
		for(int j=0;j<gpsIdsize;j++)
		{
			String tempKey = String.valueOf(gpsidArray[j]);
			Object tempValue =   GpsRealTimeData.get(tempKey);
			Object statValue =   GpsRealTimeStatData.get(tempKey);
			if(null == tempValue)
			{
				Map<String,String> valueMap = (Map<String, String>) tempValue;
				gpsdatamap.put((String)tempKey, "");
			}
			else
			{
				Map<String,String> valueMap = (Map<String, String>) tempValue;
				if(null == statValue)
				{
					valueMap.put("YWLXID", "1");
					valueMap.put("YWLXMC", "巡逻");
					gpsdatamap.put((String)tempKey, valueMap);
				}
				else
				{
					Map<String,String> statValueMap = (Map<String, String>) statValue;
					valueMap.put("YWLXID", statValueMap.get("YWLXID"));
					valueMap.put("YWLXMC", statValueMap.get("YWLXMC"));
					gpsdatamap.put((String)tempKey, valueMap);
				}
			}
		}
		return gpsdatamap;
	}
	
	
	
	
	@SuppressWarnings("unchecked")
	private Map<String, Object> getGpsStatCaches( )
	{
		MemCachedManager cached = MemCachedManager.getInstance();
		Object obj = cached.get("GPS_STATE");
		if(obj != null) {
			return (Map<String, Object>) obj;
		} else {
			return new HashMap<String, Object>();
		}
	}
	
	/**
	 * 
	 *<p>说明：根据GPSID查询gps详细信息</p>
	 *<p>时间： 2014-11-5 下午： 下午2:36:31</p>
	 * @param gpsid
	 * @param gpsTableName
	 * @return
	 */
	public Map<String, Object> getGpsInfoDetail(String gpsid, String gpsTableName)
	{
		return tGpsRealtimeDao.getGpsInfoDetail(gpsid,gpsTableName); 
	}
	
	/**
	 * 
	 *<p>说明：将gps实时信息缓存数据读入内存中</p>
	 *<p>时间： 2014-10-21 下午： 下午3:18:07</p>
	 * @param cached
	 * @return
	 */
	private Map<String, Object> getGpsCaches()
	{
		Map<String, Object> temp = new HashMap<String, Object>();
		MemCachedManager cached = MemCachedManager.getInstance();
		int i = 0;
		while(true)
		{
			i++;
			Map<String, Object> temp1 = (Map<String, Object>) cached.get("GPS_DATA"+String.valueOf(i));
			if(null == temp1)
			{
				break;
			}
			Set<String>  tempkeySet = temp1.keySet();
			for(String key : tempkeySet)
			{
				temp.put(key,  temp1.get(key));
			}
		}
		return temp;
	}
	
	/**
	 *<p>说明：根据人员ID查询班次，班次时间，巡逻区域，同班人员信息等</p>
	 *<p>时间： 2014-11-6 下午： 下午3:32:04</p>
	 * @param ryid
	 * @return
	 */
//	public Map<String, Object> getGpsPersonQwInfo(String ryid)
//	{
//		return tGpsRealtimeDao.getGpsPersonQwInfo(ryid); 
//	}
	
	/**
	 * 
	 *<p>说明：根据指定组织机构代码统计实时GPS数量</p>
	 *<p>时间： 2014-11-7 下午： 下午4:49:06</p>
	 * @param zzjgdm
	 * @param gpsTableName
	 * @return
	 */
	public Map<String, Object> getGpsPersonNumberCount(String zzjgdm, String gpsTableName)
	{
		return tGpsRealtimeDao.getGpsPersonNumberCount(zzjgdm,gpsTableName); 
	}
	
	/**
	 * 
	 *<p>说明：根据交通方式类型类型统计</p>
	 *<p>时间： 2014-11-10 下午： 上午9:59:42</p>
	 * @param zzjgdm
	 * @param gpsTableName
	 * @return
	 */
	public List<Map<String, String>>  getGpsTypeNumberCount(String zzjgdm, String gpsTableName) 
	{
 		return tGpsRealtimeDao.getGpsTypeNumberCount(zzjgdm,gpsTableName);
	}
	
	/**
	 * 重点车辆统计
	 * @return
	 */
	public List<TGpsInfo> getGpsCartypeCount(){
		return tGpsInfoDao.getGpsCartypeCount();
	}
	
	/**
	 *<p>说明：查询重点车辆状态统计</p>
	 *<p>时间： 2014-12-30 下午： 下午2:36:31</p>
	 * @return List<TGpsInfo>
	 */
	public List<TGpsInfo> getZdclGpsInfoStatus()
	{
		return tGpsInfoDao.getZdclGpsInfoStatus();
	}

	public List<Map<String, String>> getGpsOnlineList(String zzjgdm,
			String gpsTableName , String gpstype) {
		return tGpsRealtimeDao.getGpsOnlineList(zzjgdm,gpsTableName,gpstype);
	}

	public List<TZhddSsjlLsgj> getJlLsgj(String gpsid, String time) {
		String[] tables = null;
		Date nowDate = new Date();
		long mills = nowDate.getTime();
		Date lastDate = new Date(mills - 24 * 60 * 60 * 1000);
		int hh = nowDate.getHours();
		int mi = nowDate.getMinutes();
		String lastDateString = getShortString(lastDate).replaceAll(
				"-", "_");//前一天
		String nowDateString = getShortString(nowDate).replaceAll(
				"-", "_");//当前时间 2014-04-01
		if (hh == 0 && mi < Integer.parseInt(time)) {//判断是否需要前一天的表进行查询
			tables = new String[] { "XJGISDATA.GA_GPS_HISTORY_" + nowDateString+"@oradb156",
					"GA_GPS_HISTORY_" + lastDateString+"@oradb156" };
		} else {
			tables = new String[] { "XJGISDATA.GA_GPS_HISTORY_" + nowDateString +"@oradb156"};
		}
		return tGpsRealtimeDao.getJlLsgj(gpsid, tables, time);
	}
	
	public String getShortString(Date convertDate) {
		String returnValue = "";
		if (convertDate != null) {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			returnValue = formatter.format(convertDate);
		}
		return returnValue;
	}
}