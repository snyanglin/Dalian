package com.founder.ldym.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.ldym.pojo.TGpsInfo;

/**
 * <p>标题：设备管理-定位设备信息持久层类</p>
 * <p>描述：数据表(T_GPS_INFO)数据增、删、改、查</p>
 * <p>Copyright：Copyright(c) 2014 founder</p>
 * <p>日期：2014-12-30</p>
 * @author yang_yongfei
 */
@Repository
public class TGpsInfoToBusiappDao extends BaseDaoImpl {
	/**
	 * 重点车辆统计
	 * @return
	 */
	public List<TGpsInfo> getGpsCartypeCount(){
		StringBuffer sb = new StringBuffer();
		sb.append("select t2.ct as cartype,nvl2(cartype,c,0) as count");
		sb.append("  from (select cartype, count(*) c");
		sb.append(" from v_gps_user_realtime_info_zdcl where cartype is not null");
		sb.append(" and gpsusertype = 2 group by cartype) t1");
		sb.append(" right join T_GPS_CARTYPE t2 on t1.cartype = t2.dm");
		
		return super.queryForList(sb.toString(), TGpsInfo.class); 
	}
	
	/**
	 *<p>说明：查询重点车辆状态统计</p>
	 *<p>时间： 2014-12-30 下午： 下午2:36:31</p>
	 * @return Map<String, Object>
	 */
	public List<TGpsInfo> getZdclGpsInfoStatus()
	{
		String sql = " select xhzt as status,count(*) as count from v_gps_user_realtime_info_zdcl group by xhzt";
		return super.queryForList(sql, TGpsInfo.class); 
	}
}