package com.founder.ldym.dao;

import java.io.IOException;
import java.io.Reader;
import java.sql.Clob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.ldym.pojo.TGpsRealtime;
import com.founder.ldym.pojo.TZhddSsjlLsgj;
import com.founder.ldym.util.StringUtil;


/**
 * <p>标题：GPS实时信号持久层类</p>
 * <p>描述：</p>
 * <p>Copyright：Copyright(c) 2014 founder</p>
 * <p>日期：2014-03-24</p>
 * @author gb
 */
@Repository
public class TGpsRealtimeDao extends BaseDaoImpl {
	
	/**
	 * 
	 * <p>说明：根据设备ID获取实时信号信息</p>
	 * <p>时间：2014-4-3 下午2:05:15</p>
	 * @param gpsIds gps设备ID 多个用逗号分隔
	 * @return list 查询结果集
	 */
	public List<TGpsRealtime> queryTGpsRealtimeList(String[] gpsIds) {
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT distinct T2.*,T3.ORGID GROUPID,T4.ORGNAME GROUPNAME,T1.POLICEID,");
		sb.append(" T1.POLICENAME,T1.CALLNO,T1.CARNO,T1.PICTURETYPE,T5.STATUSID,T5.YWBH FROM");
		sb.append(" T_GPS_INFO T1,T_GPS_REALTIME T2,M_GPS_ZZJG T3,T_GPS_ZZJG T4,T_ZHDD_JLSTATUS T5");
		sb.append(" WHERE T1.GPSID = T2.GPSID AND T1.GPSID = T3.GPSID AND T1.GPSID = T5.GPSID AND");
		sb.append(" T3.ORGID = T4.ORGID");
		if(gpsIds.length > 0) {
			sb.append(" AND T2.GPSID IN(");
			for(int i = 0; i<gpsIds.length; i++) {
				sb.append("'"+gpsIds[i]+"'");
				if(i != gpsIds.length-1) {
					sb.append(",");
				}
			}
			sb.append(")");
		}
		return super.queryForList("Ldym.queryTGpsRealtimeList", sb.toString()); 
	}
	
	/**
	 * 
	 *<p>说明：根据GPSID查询gps详细信息</p>
	 *<p>时间： 2014-11-5 下午： 下午2:36:31</p>
	 * @param gpsid
	 * @param gpsTableName
	 * @return
	 */
	public Map<String, Object>  getGpsInfoDetail(String gpsid, String gpsTableName)
	{
		String sql = " select * from "+gpsTableName+" v where v.sbid ='"+gpsid+"'";
		return (Map<String, Object>) queryForObject("Ldym.queryGpsMap3", sql);
	}
	
	/**
	 *<p>说明：根据人员ID查询班次，班次时间，巡逻区域，同班人员信息等</p>
	 *<p>时间： 2014-11-6 下午： 下午3:32:22</p>
	 * @param ryid
	 * @return
	 */
//	public Map<String, Object>  getGpsPersonQwInfo(String ryid) 
//	{
//		StringBuffer sb = new StringBuffer();
//        sb.append(" select tbc1.XFBBBCID ,");   //班次
//        sb.append(" tbc1.XQZB,");   //区域坐标
//        sb.append(" tbc1.XQLX, ");   //区域坐标类型
//        sb.append(" decode(tbc1.SFKT,1,tbc1.bckssj ||'-次日'||tbc1.bcjssj,tbc1.bckssj ||'-'||tbc1.bcjssj) BCSJ  ,");   //-班次时间
//        sb.append(" try.RYID,");   //同班人员ID
//        sb.append(" try.RYXM ,");   //同班人姓名
//        sb.append(" tp.JYDH,");   //同班人电话
//        sb.append(" tinf.CALLNO, ");   //同班人员个呼号
//        sb.append(" tzblx.ZBLXDM ZBLXDM, "); 
//        sb.append(" tzblx.ZBLXMC "); 
//        sb.append(" from (select t.XFBBBCID,tqy.xqzb,tqy.xqlx,tbc.bckssj,tbc.bcjssj,tbc.SFKT from t_qwgl_xfbbry t ");   
//        sb.append(" left join T_QWGL_XFBBXQBC tbc on tbc.id =t.XFBBBCID ");  
//        sb.append(" left join T_QWGL_XFBBXQ txq on txq.id = tbc.xfbbxqid"); 
//        sb.append(" left join T_QWGL_XLQY tqy on tqy.xqid = txq.xfqyid"); 
//        sb.append(" where   to_char(t.xfrq, 'yyyy/mm/dd') = to_char(sysdate, 'yyyy/mm/dd') "); 
//        sb.append(" and t.ryid = '"); 
//        sb.append(ryid);
//        sb.append("' and to_char(sysdate, 'yyyy/mm/dd HH24:MI') <= to_char(t.xfrq + tbc.sfkt, 'yyyy/mm/dd') || ' ' || tbc.bcjssj "); 
//        sb.append(" and to_char(sysdate, 'yyyy/mm/dd HH24:MI') >= to_char(t.xfrq, 'yyyy/mm/dd') || ' ' || tbc.bckssj) tbc1 "); 
//        sb.append(" left join t_qwgl_xfbbry try on try.xfbbbcid =tbc1.XFBBBCID and to_char(try.xfrq, 'yyyy/mm/dd') = to_char(sysdate, 'yyyy/mm/dd')"); 
//        sb.append(" left join T_PERSONNEL tp on tp.jybh = try.RYID"); 
//        sb.append(" left join T_QWGL_XFBBRYZBGL tgl on tgl.ryid = try.ryid and tgl.xfbbbc=tbc1.XFBBBCID "); 
//        sb.append("  and to_char(tgl.xfbbrq, 'yyyy/mm/dd') = to_char(sysdate, 'yyyy/mm/dd') "); 
//        sb.append(" left join T_QWGL_ZBLX tzblx on tzblx.zblxdm = tgl.zblx "); 
//        sb.append(" left join t_gps_info tinf on tinf.gpsid = tgl.zbid  order by tzblx.sorted"); 
// 		return dealGpsPersonQwInfo(jdbcTemplate.queryForRowSet(sb.toString()));
//	}
	
	/**
	 *<p>说明：对查询的结果进行结果集的组装</p>
	 *<p>时间： 2014-11-6 下午： 下午3:32:33</p>
	 * @param rs
	 * @return
	 */
	private Map<String ,Object>  dealGpsPersonQwInfo(SqlRowSet rs)  
	{
		Map<String ,Object>  gpsPersonQwInfoMap = new HashMap<String ,Object>();
		Map<String ,String>  otherPersonInfoMap = null;
		List<Map<String ,String> > otherPersonList = new ArrayList<Map<String ,String>>();
		String xfbbbcid= "";
		String bcsj= "";
		Clob xqzb= null;;
		String xqlx="";
		
		//存放装备类型以及数量
		Map<String ,Integer> zbNumMap = new LinkedHashMap<String,Integer>();
		Map<String ,String> zblxMcMap =new HashMap<String,String>();
		while (rs.next())
		{
			xfbbbcid= rs.getString("XFBBBCID");
			bcsj= rs.getString("BCSJ");
			xqzb=  (Clob)rs.getObject("XQZB");
		    xqlx = rs.getString("XQLX");
		    otherPersonInfoMap = new HashMap<String,String>();
		    String ryid = rs.getString("RYID");
			otherPersonInfoMap.put("RYID", ryid);
			otherPersonInfoMap.put("RYXM", rs.getString("RYXM"));
			otherPersonInfoMap.put("JYDH", rs.getString("JYDH"));
			otherPersonInfoMap.put("CALLNO",  rs.getString("CALLNO"));
//			otherPersonInfoMap.put("zblxdm", rs.getString("zblxdm"));
//			otherPersonInfoMap.put("zblxmc", rs.getString("zblxmc"));
			otherPersonList.add(otherPersonInfoMap);
			
			//统计设备类型和数量
			String zblxdm = rs.getString("ZBLXDM");
			if(null !=zblxdm && ""!=zblxdm)
			{
				if(zbNumMap.containsKey(zblxdm))
				{
					Integer number = zbNumMap.get(zblxdm);
					zbNumMap.put(zblxdm, number+1);
				}
				else
				{
					zbNumMap.put(zblxdm, 1);
					zblxMcMap.put(zblxdm, rs.getString("ZBLXMC"));
				}
			}
			
		}
		//巡防报备班次ID
		gpsPersonQwInfoMap.put("XFBBBCID", xfbbbcid);
		//班次时间
		gpsPersonQwInfoMap.put("BCSJ", bcsj);
		
		String xqzbStr = "";
		try {
			if(xqzb != null) {
				Reader inStream = xqzb.getCharacterStream();
				char[] c = new char[(int)xqzb.length()];
				inStream.read(c);
				xqzbStr=  new String(c);
				inStream.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		//组装装备类型统计结果
		Map<String ,String>  tempCallNoMap = null;
		List<Map<String ,String>> zblxList = new ArrayList<Map<String ,String>>();
		Set<String> keySet = zbNumMap.keySet();
		for(String key :keySet)
		{
			tempCallNoMap = new HashMap<String ,String>();
			tempCallNoMap.put("ZBLXDM", key);
			tempCallNoMap.put("ZBLXMC", zblxMcMap.get(key));
			tempCallNoMap.put("ZBLXNUMBER", String.valueOf(zbNumMap.get(key)));
			zblxList.add(tempCallNoMap);
		}
		gpsPersonQwInfoMap.put("ZBLXCOUNT", zblxList);
		gpsPersonQwInfoMap.put("XQZB", xqzbStr);
		gpsPersonQwInfoMap.put("XQLX", xqlx);
		gpsPersonQwInfoMap.put("OTHERPERSON", getPersonCount(otherPersonList));
		return gpsPersonQwInfoMap;
	}
	
	/**
	 *<p>说明：统计组装人员信息</p>
	 *<p>时间： 2014-11-7 下午： 下午3:03:43</p>
	 * @param otherPersonList
	 * @return
	 */
	private List<Map<String ,String> > getPersonCount(List<Map<String ,String> > otherPersonList)
	{
		List<Map<String ,String>> tempList = new ArrayList<Map<String ,String>>();
		Map<String ,String> callNotemp = new HashMap<String ,String>();
		Map<String ,Object> persontemp = new HashMap<String ,Object>();
		int size = otherPersonList.size();
		for(int i = 0;i < size;i++)
		{
			Map<String ,String> otherPersonInfoMap = otherPersonList.get(i);
			Map<String ,String> tempPersonInfoMap = new HashMap<String ,String>();
			
			String ryid = otherPersonInfoMap.get("RYID");
			if(!persontemp.containsKey(ryid))
			{
				tempPersonInfoMap.put("RYID", ryid);
				tempPersonInfoMap.put("RYXM", otherPersonInfoMap.get("RYXM"));
				tempPersonInfoMap.put("JYDH", otherPersonInfoMap.get("JYDH"));
				persontemp.put(ryid, tempPersonInfoMap);
			}
			
			//将设备个呼号存入(可能一个人携带多个设备)
			String callno = otherPersonInfoMap.get("CALLNO");
			if((null != ryid && "" != ryid) )
			{
				if((null != callno && "" != callno))
				{
					if(callNotemp.containsKey(ryid))
					{
						String callnoValue = callNotemp.get(ryid)+","+callno;
						callNotemp.put(ryid, callnoValue);
					}
					else
					{
						callNotemp.put(ryid, callno);
					}
				}
				else
				{
					callNotemp.put(ryid, "");
				}
			}
		}
		
		Set<String> keyset = persontemp.keySet();
		for(String key : keyset)
		{
			Map<String ,String> tempPersonInfoMap = (Map<String, String>) persontemp.get(key);
			String callno =   callNotemp.get(key);
			tempPersonInfoMap.put("CALLNO", callno);
			tempList.add(tempPersonInfoMap);
		}
		return tempList;
	}
	
	/**
	 * 
	 *<p>说明：根据指定组织机构代码统计实时GPS数量</p>
	 *<p>时间： 2014-11-7 下午： 下午4:49:20</p>
	 * @param zzjgdm
	 * @param gpsTableName
	 * @return
	 */
	public Map<String, Object>  getGpsPersonNumberCount(String zzjgdm, String gpsTableName) 
	{
		String zzjg = StringUtil.getSplitJgdm(zzjgdm);
		StringBuffer sb = new StringBuffer();
        sb.append(" select count(1) ALLNUM, ");   //班次
        sb.append(" count(decode(t.JYLXID,1,1,null)) MJ,");   //区域坐标
        sb.append(" count(decode(t.JYLXID,0,1,null)) XJ, ");   //区域坐标类型
        sb.append(" count(decode(t.JYLXID,1,null,0,null,1)) QT ");   //-班次时间
        sb.append(" from "+gpsTableName + " t ");   //同班人员ID
        sb.append(" where t.JYZZJGDM like '%");   //同班人姓名
        sb.append(zzjg);
        sb.append("%'");
 		return queryForMap("Ldym.queryGpsMap", sb.toString(),"key", "value");
	}
	
	/**
	 * 
	 *<p>说明：根据交通方式类型类型统计</p>
	 *<p>时间： 2014-11-10 下午： 上午9:55:16</p>
	 * @param zzjgdm
	 * @param gpsTableName
	 * @return
	 */
	public List<Map<String, String>>  getGpsTypeNumberCount(String zzjgdm, String gpsTableName) 
	{
		String zzjg = StringUtil.getSplitJgdm(zzjgdm);
		StringBuffer sb = new StringBuffer();
		sb.append(" select t.ct LXMC,decode(t1.ALLNUMBER,null,0,t1.ALLNUMBER) ALLNUMBER,decode(t1.XL,null,0,t1.XL) XL,");
		sb.append(" decode(t1.CJ,null,0,t1.CJ) CJ,decode(t1.QT,null,0,t1.QT) QT from t_sys_dict_jtfs t");
		sb.append(" left join ( ");
        sb.append(" select t.ct LXMC,t.dm,");   //类型名称
        sb.append(" count(v.jtfsid) ALLNUMBER,");   //总数
        sb.append(" count(decode(v.XHZT, 1, 1, null)) XL, ");   //巡逻
        sb.append(" count(decode(v.ywlxid,2,1,null)) CJ, ");   //出警
        sb.append(" count(v.jtfsid)- count(decode(v.ywlxid,1,1,null))-count(decode(v.ywlxid,2,1,null))  QT ");   //其他
        sb.append(" from t_sys_dict_jtfs  t ");
        sb.append(" left join "+gpsTableName+" v on t.dm = v.JTFSID");
        sb.append(" where 1=1  and  v.JYZZJGDM like '%");
        sb.append(zzjg);
        sb.append("%'");
        sb.append(" group by t.dm, t.ct,t.xh order by t.xh");
        sb.append(" ) t1 on t1.dm= t.dm order by t.xh");
//        System.out.println("==========="+sb.toString());
// 		return dealGpsTypeNumberCount(jdbcTemplate.queryForRowSet(sb.toString()));
        List<Map> list  =  queryForList("Ldym.queryListMap", sb.toString());
 		return dealGpsTypeNumberCount(list);
	}
	
	
	private List<Map<String, String>>  dealGpsTypeNumberCount(List<Map> rs)  
	{
		Map<String, String> resultMap = null;
		List<Map<String, String>> resultList = new ArrayList<Map<String, String>>();
		long all_allnumber=0;
		long all_xl=0;
		long all_cj=0;
		long all_qt=0;
		Map<String,Object> temp = null;
		for (int i = 0; i < rs.size(); i++) {
			temp = rs.get(i);
			resultMap = new HashMap<String,String>();
			resultMap.put("LXMC", temp.get("LXMC").toString());
			//总计
			String  allnumber = (String) temp.get("ALLNUMBER").toString();
			resultMap.put("ALLNUMBER", allnumber);
			//巡逻
			String xl = temp.get("XL").toString();
			resultMap.put("XL", xl);
			//处警
			String cj = temp.get("CJ").toString();
			resultMap.put("CJ", cj);
			//其他
			String qt = temp.get("QT").toString();
			resultMap.put("QT", qt);
			resultList.add(resultMap);
			
			all_allnumber += Integer.valueOf(allnumber);
			all_xl += Integer.valueOf(xl);
			all_cj += Integer.valueOf(cj);
			all_qt += Integer.valueOf(qt);
		}
		
		Map<String, String> resultAllMap = new HashMap<String,String>();
		//由sql查出每个类型的统计，然后代码计算出总计
		resultAllMap.put("LXMC", "总计");
		resultAllMap.put("ALLNUMBER", String.valueOf(all_allnumber));
		resultAllMap.put("XL", String.valueOf(all_xl));
		resultAllMap.put("CJ", String.valueOf(all_cj));
		resultAllMap.put("QT", String.valueOf(all_qt));
		resultList.add(resultAllMap);
		return resultList;
	}
	
	/**
	 * 
	 *<p>说明：解析组装查询结果</p>
	 *<p>时间： 2014-11-10 下午： 上午9:58:08</p>
	 * @param rs
	 * @return
	 */
	private List<Map<String, String>>  dealGpsTypeNumberCount(SqlRowSet rs)  
	{
		Map<String, String> resultMap = null;
		List<Map<String, String>> resultList = new ArrayList<Map<String, String>>();
		long all_allnumber=0;
		long all_xl=0;
		long all_cj=0;
		long all_qt=0;
		while(rs.next())
		{
			resultMap = new HashMap<String,String>();
			resultMap.put("LXMC", rs.getString("LXMC"));
			//总计
			String  allnumber = rs.getString("ALLNUMBER");
			resultMap.put("ALLNUMBER", allnumber);
			//巡逻
			String xl = rs.getString("XL");
			resultMap.put("XL", xl);
			//处警
			String cj = rs.getString("CJ");
			resultMap.put("CJ", cj);
			//其他
			String qt = rs.getString("QT");
			resultMap.put("QT", qt);
			resultList.add(resultMap);
			
			all_allnumber += Integer.valueOf(allnumber);
			all_xl += Integer.valueOf(xl);
			all_cj += Integer.valueOf(cj);
			all_qt += Integer.valueOf(qt);
		}
		
		Map<String, String> resultAllMap = new HashMap<String,String>();
		//由sql查出每个类型的统计，然后代码计算出总计
		resultAllMap.put("LXMC", "总计");
		resultAllMap.put("ALLNUMBER", String.valueOf(all_allnumber));
		resultAllMap.put("XL", String.valueOf(all_xl));
		resultAllMap.put("CJ", String.valueOf(all_cj));
		resultAllMap.put("QT", String.valueOf(all_qt));
		resultList.add(resultAllMap);
		return resultList;
	}
	
	/**
	 *<p>说明：查询重点车辆状态统计</p>
	 *<p>时间： 2014-12-30 下午： 下午2:36:31</p>
	 * @return Map<String, Object>
	 */
	public Map<String, Object> getZdclGpsInfoStatus()
	{
		String sql = " select xhzt,count(*) as count from v_gps_user_realtime_info_zdcl group by xhzt";
		return queryForMap("Ldym.queryGpsMap", sql,"key", "value");
	}

	public List<Map<String, String>> getGpsOnlineList(String zzjgdm,
			String gpsTableName ,String gpstype) {
		String zzjg = StringUtil.getSplitJgdm(zzjgdm);
		StringBuffer sb = new StringBuffer();
		sb.append(" select * from  "+gpsTableName+" t where  1=1  and  t.JYZZJGDM like '%");
        sb.append(zzjg);
        sb.append("%'"); 
        if(!"总计".equals(gpstype))
        	sb.append(" and t.JTFSMC = '"+ gpstype +"' ");
		sb.append("and t.XHZT='1' order by t.realtime desc");
        List<Map<String, String>> list  =  queryForList("Ldym.queryListMap2", sb.toString());
		return list;
	}

	public List<TZhddSsjlLsgj> getJlLsgj(String gpsid, String[] table,
			String time) {
		StringBuilder sqlBuilder = new StringBuilder();
		int t = Integer.parseInt(time);
		if (table.length == 1) {
			sqlBuilder.append("select t.* from ").append(table[0])
					.append(" t ");
			sqlBuilder.append("where t.time>sysdate-(1*").append(t)
					.append(")/(24*60) ");
			sqlBuilder.append("and gpsid=").append("'"+gpsid+"'")
					.append(" order by time");
		} else if (table.length == 2) {
			sqlBuilder.append("select t.* from ").append(table[0])
					.append(" t ");
			sqlBuilder.append("where t.time>sysdate-(1*").append(t)
					.append(")/(24*60) ");
			sqlBuilder.append("and t.gpsid=").append("'"+gpsid+"'");
			sqlBuilder.append(" union all ");
			sqlBuilder.append("(select t1.* from ").append(table[1])
					.append(" t1 ");
			sqlBuilder.append("where t1.time>sysdate-(1*").append(t)
					.append(")/(24*60) ");
			sqlBuilder.append("and t1.gpsid=")
					.append("'"+gpsid+"'" + " order by time)");
		}
		return queryForList("Ldym.lsgj",sqlBuilder.toString());
	}
}