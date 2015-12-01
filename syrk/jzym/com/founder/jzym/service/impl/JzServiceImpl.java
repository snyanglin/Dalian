package com.founder.jzym.service.impl;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.EasyUIPage;
import com.founder.jzym.bean.JqChart;
import com.founder.jzym.bean.Jz_jqxxb;
import com.founder.jzym.dao.JzDao;
import com.founder.jzym.service.JzService;
import com.founder.jzym.vo.Sf_Organization;
import com.founder.service.requestservice.AddressRequestService;
import com.founder.xjpt.vo.ZzjgVo;

@Service("jzService")
public class JzServiceImpl extends BaseService implements JzService {
	protected static final Log logger = LogFactory
			.getLog(JzServiceImpl.class);
	@Resource(name = "jzDao")
	private JzDao jzDao;

	@Override
	public EasyUIPage queryJq(EasyUIPage page, Jz_jqxxb entity) {
		return jzDao.queryJq(page, entity);
	}

	@Override
	public long queryCountJq(Jz_jqxxb entity) {
		return jzDao.queryCountJq(entity);
	}

	/**
	 * @Title: jqChart 
	 * @描述: 警情柱状图
	 * @参数: 传入参数定义  
	 * @throws
	 */
	@Override
	public Map<String, Object> jqChart(String zzjgdm, String kssj, String jssj, String jqlxdm, String zrq) {
		//创建一个Flash统计图Map对象
		Map<String, Object> returnMap = new HashMap<String, Object>();
		//获取柱状图数据
		List<JqChart> ldrkList = new ArrayList<JqChart>();
		if(jqlxdm!=null && !jqlxdm.equals("")){
			ldrkList = jzDao.jqShiCharts(zzjgdm, kssj, jssj, jqlxdm, zrq);
		} else {
			ldrkList = jzDao.jqShiChart(zzjgdm, kssj, jssj, jqlxdm);
		}
		//柱状颜色
		Object[] colors = {"#85d021","#4dc2ed","#ee431b","#e96a3b","#ee9539","#fdbe63","#f1e740","#ffb543","#ff7a7b","#008080","#AA4400","#0000FF"};
		//生命对应值和名称
		int lszs = ldrkList.size();
		Object[] values = new Object[lszs];
		String[] labels = new String[lszs];
		Object[] valuestags =  new Object[lszs];
		Integer max = 10;
		Integer zs = 0;
		int temp = 0;
		for(int i=0;i<lszs;i++){
			if(i<ldrkList.size()){
				JqChart vo = ldrkList.get(i);
				//将数字放置到柱子上
				Map<String, Object> valtag = new HashMap<String, Object>();
				if(i > 1){
					temp = 0;
				}
				valtag.put("colour", colors[temp]);
				temp ++;
				valtag.put("tip", vo.getSl()+"起");
				valtag.put("top", Integer.parseInt(vo.getSl()));
				valtag.put("on-click", "change('"+vo.getLx()+"', '" + vo.getOrgcode() + "')");
				values[i] = valtag;
				labels[i] = vo.getLxmc();
				if(max<Integer.parseInt(vo.getSl())){
					max = Integer.parseInt(vo.getSl());
				}
				//将数字放置到柱子上
				Map<String, Object> tag = new HashMap<String, Object>();
				tag.put("y", Integer.parseInt(vo.getSl()));
				tag.put("x", i);
				//加载到柱子上
				valuestags[i] = tag;
			}
			JqChart val = ldrkList.get(i);
			zs += Integer.parseInt(val.getSl());
		}
		Map<String, Object> elements = new HashMap<String, Object>();
		elements.put("type", "bar_filled");
		elements.put("values", values);
		//柱子特效
		Map<String, Object> xtc = new HashMap<String, Object>();
		xtc.put("type", "pop");//柱子特效（随即特效）
		xtc.put("cascade", 1);
		xtc.put("delay", 0.5);//设置柱子的颜色
		elements.put("on-show", xtc);
		//Date date = new Date();
		//SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日");
		String titletext = "警情数量("+zs+")";
		Map<String, Object> title = new HashMap<String, Object>();
		title.put("text", titletext);
		title.put("style", "font-size:18px;color: #000000;");
		//柱子上显示数字
		Map<String, Object> tags = new HashMap<String, Object>();
		tags.put("type", "tags");
		tags.put("values", valuestags);
		tags.put("font", "Verdana");
		tags.put("font-size", 12);
		tags.put("colour", "#000000");
		tags.put("align-x", "center");
		tags.put("text", "#y# 起");
		//设置y轴
		Map<String, Object> yaxisMap = new HashMap<String, Object>();
		Integer steps = 0;
		if(max>lszs&&lszs!=0){
			steps = max/lszs;
		}else{
			steps = max;   
		}
		yaxisMap.put("max", steps+max);
	    yaxisMap.put("steps",steps);
	    yaxisMap.put("min", 0);
		//设置X轴
	    Map<String, Object> xaxisMap = new HashMap<String, Object>();
        xaxisMap.put("labels",labels);
        xaxisMap.put("size", 12);
        Map<String, Object> xaxisMap2 = new HashMap<String, Object>();
        xaxisMap2.put("labels", xaxisMap);
        //生成JSON格式
        Object[] elementsObject = {elements,tags};
		returnMap.put("elements", elementsObject);
		returnMap.put("y_axis", yaxisMap);
		returnMap.put("x_axis", xaxisMap2);
		returnMap.put("title", title);
		returnMap.put("bg_colour", "#FFFFFF");//背景色
		//String test = new Gson().toJson(returnMap);
		//System.out.print(test);
		return returnMap;
	}
	
	/**
	 * @Title: querySsyj 
	 * @描述: 获取分局组织机构
	 * @参数: 传入参数定义  
	 * @throws
	 */
	public List<ZzjgVo> querySsyj(String zzjgdm) {
		return jzDao.querySsyj(zzjgdm);
	}
	
	/**
	 * @Title: downMap 
	 * @描述: 获取分局组织机构
	 * @参数: 传入参数定义  
	 * @throws
	 */
	public List<Sf_Organization> downMap(String orgcode) {
		List<Sf_Organization> lists = new ArrayList<Sf_Organization>();
		lists = jzDao.queryTree("", orgcode, "into");
		return lists;
	}

	/**
	 * @Title: queryXjZzjgxj 
	 * @描述: 获取分局组织机构
	 * @参数: 传入参数定义  
	 * @throws
	 */
	public List<Sf_Organization> queryXjZzjgxj(String zzjgdm) {
		return jzDao.queryXjZzjgxj(zzjgdm);
	}
	
	@Override
	public List<Sf_Organization> querySf(Sf_Organization sf) {
		List<Sf_Organization> lists = new ArrayList<Sf_Organization>();
		lists = jzDao.querySf(sf);
		return lists;
	}
	
	/**
	 * @Title: ssyjChart 
	 * @描述: 四色预警柱状图
	 * @参数: 传入参数定义  
	 * @throws
	 */
	@Override
	public Map<String, Object> ssyjChart(Sf_Organization sf) {
		//创建一个Flash统计图Map对象
		Map<String, Object> returnMap = new HashMap<String, Object>();
		//获取柱状图数据
		List<JqChart> ldrkList = jzDao.jqSsyjChart(sf);
		//柱状颜色
		//Object[] colors = {"#85d021","#4dc2ed","#ee431b","#e96a3b","#ee9539","#fdbe63","#f1e740","#ffb543","#ff7a7b","#008080","#AA4400","#0000FF"};
		//生命对应值和名称
		int lszs = ldrkList.size();
		Object[] values = new Object[lszs];
		String[] labels = new String[lszs];
		Object[] valuestags =  new Object[lszs];
		Integer max = 10;
		Integer zs = 0;
		for(int i=0;i<lszs;i++){
			if(i<ldrkList.size()){
				JqChart vo = ldrkList.get(i);
				//将数字放置到柱子上
				Map<String, Object> valtag = new HashMap<String, Object>();
				String color = "#85d021";
				if("red".equals(vo.getColor())){
					color = "#ff0000";
				} else if("yellow".equals(vo.getColor())){
					color= "#ffd306";
				} else if("orange".equals(vo.getColor())){
					color= "#ff8000";
				}
				valtag.put("colour", color);
				valtag.put("tip", vo.getSl()+"起");
				valtag.put("top", Integer.parseInt(vo.getSl()));
				valtag.put("on-click", "change('" + vo.getLxmc() + "')");
				values[i] = valtag;
				labels[i] = vo.getLxmc();
				if(max<Integer.parseInt(vo.getSl())){
					max = Integer.parseInt(vo.getSl());
				}
				//将数字放置到柱子上
				Map<String, Object> tag = new HashMap<String, Object>();
				tag.put("y", Integer.parseInt(vo.getSl()));
				tag.put("x", i);
				//加载到柱子上
				valuestags[i] = tag;
			}
			JqChart val = ldrkList.get(i);
			zs += Integer.parseInt(val.getSl());
		}
		Map<String, Object> elements = new HashMap<String, Object>();
		elements.put("type", "bar_filled");
		elements.put("values", values);
		//柱子特效
		Map<String, Object> xtc = new HashMap<String, Object>();
		xtc.put("type", "pop");//柱子特效（随即特效）
		xtc.put("cascade", 1);
		xtc.put("delay", 0.5);//设置柱子的颜色
		elements.put("on-show", xtc);
		//Date date = new Date();
		//SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日");
		String titletext = "四色预警统计("+zs+")";
		Map<String, Object> title = new HashMap<String, Object>();
		title.put("text", titletext);
		title.put("style", "font-size:18px;color: #000000;");
		//柱子上显示数字
		Map<String, Object> tags = new HashMap<String, Object>();
		tags.put("type", "tags");
		tags.put("values", valuestags);
		tags.put("font", "Verdana");
		tags.put("font-size", 12);
		tags.put("colour", "#000000");
		tags.put("align-x", "center");
		tags.put("text", "#y# 起");
		//设置y轴
		Map<String, Object> yaxisMap = new HashMap<String, Object>();
		Integer steps = 0;
		if(max>lszs&&lszs!=0){
			steps = max/lszs;
		}else{
			steps = max;   
		}
		yaxisMap.put("max", steps+max);
	    yaxisMap.put("steps",steps);
	    yaxisMap.put("min", 0);
		//设置X轴
	    Map<String, Object> xaxisMap = new HashMap<String, Object>();
        xaxisMap.put("labels",labels);
        xaxisMap.put("size", 12);
        Map<String, Object> xaxisMap2 = new HashMap<String, Object>();
        xaxisMap2.put("labels", xaxisMap);
        //生成JSON格式
        Object[] elementsObject = {elements,tags};
		returnMap.put("elements", elementsObject);
		returnMap.put("y_axis", yaxisMap);
		returnMap.put("x_axis", xaxisMap2);
		returnMap.put("title", title);
		returnMap.put("bg_colour", "#FFFFFF");//背景色
		//String test = new Gson().toJson(returnMap);
		//System.out.print(test);
		return returnMap;
	}
	
	/**
	 * @Title: jqdbChart 
	 * @描述: 警情对比柱状图
	 * @参数: 传入参数定义  
	 * @throws
	 */
	@Override
	public Map<String, Object> jqdbChart(String zzjgdm, String kssj, String jssj, String jqlxdm, String zrq) {
		// 创建一个Flash统计图Map对象
		Map<String, Object> returnMap = new HashMap<String, Object>();
		//获取柱状图数据
		List<JqChart> ldrkList = new ArrayList<JqChart>();
		ldrkList = jzDao.jqShidbChart(zzjgdm, kssj, jssj, jqlxdm);
		int rwCount = 10; 
		Integer[] a1 = new Integer[ldrkList.size()];
		Integer[] a2 = new Integer[ldrkList.size()];
		String[] labels = new String[ldrkList.size()];
		JqChart fkb = null;
		/* 年份1 */
		Map<String, Object> map = new HashMap<String, Object>();
		/* 年份2 */
		Map<String, Object> map2 = new HashMap<String, Object>();
		Integer max = 10;
		int lszs = ldrkList.size();
		int a = 0;
		int b = 0;
		for (int i = 0; i < ldrkList.size(); i++) {
			fkb = ldrkList.get(i);
			String bjsj[] = fkb.getBjsj().split(",");
			String sl[] = fkb.getSl().split(",");
			
			for(int j=0; j<sl.length; j++){
				if(max < Integer.valueOf(sl[j])){
					max = Integer.valueOf(sl[j]);
				}
				if(bjsj[j].equals(kssj)){
					a1[a] = Integer.valueOf(sl[j]);
					labels[i] = fkb.getLxmc();
					a++;
				} else if(bjsj[j].equals(jssj)){
					a2[b] = Integer.valueOf(sl[j]);
					labels[i] = fkb.getLxmc();
					b++;
				}
			}
			if(a > b){
				a2[b] = 0;
				b++;
			} else if(a < b){
				a1[a] = 0;
				a++;
			} 
			
		}
		
		//取得最大柱子的值
		for (int i = 0; i < a1.length; i++) {
			if (a1[i] > rwCount) {
				rwCount = a1[i];
			}
		}
		for (int i = 0; i < a2.length; i++) {
			if (a2[i] > rwCount) {
				rwCount = a2[i];
			}
		}
		rwCount += 1;
		
//		a1[0] = 1;
//		a1[1] = 2;
//		a2[0] = null;
//		a2[1] = 5;
		map.put("type", "bar");
		map.put("colour", "#00BFFF");
		map.put("text", kssj);
		map.put("font-size", 12);
		map.put("values", a1);
		//map.put("on-click", "change('" + lx1 + "')");
		//柱子特效
		Map<String, Object> xtc = new HashMap<String, Object>();
		xtc.put("type", "pop");//柱子特效（随即特效）
		xtc.put("cascade", 1);
		xtc.put("delay", 0.5);//设置柱子的颜色
		map.put("on-show", xtc);
				
//		Map<String, Object> map_tags = new HashMap<String, Object>();
//		map_tags.put("type", "tags");
//		map_tags.put("colour", "#ff0000");
//		map_tags.put("text", "a");
//		map_tags.put("font-size", 12);
//		map_tags.put("values", a1);

		map2.put("type", "bar");
		map2.put("colour", "#ff0000");
		map2.put("text", jssj);
		map2.put("font-size", 12);
		map2.put("values", a2);
		//map2.put("on-click", "change('" + lx2 + "')");
		//柱子特效
		Map<String, Object> xtc2 = new HashMap<String, Object>();
		xtc2.put("type", "pop");//柱子特效（随即特效）
		xtc2.put("cascade", 1);
		xtc2.put("delay", 0.5);//设置柱子的颜色
		map2.put("on-show", xtc2);
				
		//Object[] elements = { map, map_tags, map2 };
		Object[] elements = { map, map2 };
		Map<String, Object> xaxisMap = new HashMap<String, Object>();
		xaxisMap.put("labels", labels);
		xaxisMap.put("size", 12);
		Map<String, Object> xaxisMap2 = new HashMap<String, Object>();
		xaxisMap2.put("labels", xaxisMap);
		// xaxisMap2.put("3d", 10);

		Map<String, Object> title = new HashMap<String, Object>();
		title.put("text", "警情对比分析");

		Map<String, Object> y_axisMap = new HashMap<String, Object>();
		y_axisMap.put("min", 0);
		y_axisMap.put("max", rwCount);
		Integer steps = 0;
		if(max>lszs&&lszs!=0){
			steps = max/lszs;
		}else{
			steps = max;   
		}
		y_axisMap.put("steps", steps);

		// 生成JSON格式
		returnMap.put("elements", elements);
		returnMap.put("y_axis", y_axisMap);
		returnMap.put("x_axis", xaxisMap2);
		returnMap.put("title", title);
		returnMap.put("bg_colour", "#FFFFFF");//背景色
		//System.out.print(new Gson().toJson(returnMap));
		return returnMap;
	}

	@Override
	/**
	 * @Title: ssyjColor
	 * @描述: 四色预警
	 * @参数: 案件数， 日期数组， 查询类型
	 * @返回值: String 返回类型
	 * @throws
	 *  基准常量= 前三年某一季度案件数量之和÷3
		浮动值常量：每季度案件数量与基准常量相比，取平均绝对值。
		计算公式：
		浮动值=
		（12年一季度案件数-常量）²+（13年1季度案件数-常量）²+（14年1季度案件数-常量）²
		power 3
		/ 该季度天数
		举例：以沙河口分局前三年第一季度刑事立案数为例。
		2012年	2013年	2014年
		1292起	1262起	1009起
		发案基准常量=（1292+1262+1009）÷3÷90 = 13.2起
		浮动值常量=1.4起。
		最低浮动值=13.2-1.4=11.8
		最高浮动值=13.2+1.4=14.6
		每日基准常量算法：发案基准常量×天数，即1月1日为13.2×1=13.2,2月1日为13.2×32=422.4以此类推
		每日浮动值算法：最低浮动值（最高浮动值）×天数，即1月1日最低浮动值为11.8×1=11.8, 最高浮动值为14.6×1=14.6； 2月1日为11.8×32=422.4，最高浮动值为14.6×32=467，以此类推。
		即：绿色预警：最低浮动值×天数以下；黄色预警：最低浮动值×天数至基准常量；橙色预警：基准常量至最高浮动值×天数；红色预警：最高浮动值×天数以上.
	 */
	public String ssyjColor(String orgcode, Sf_Organization sf) {
		long ajCount = 0;
		//1 月查询, 2季度查询
		List<String> dateList = new ArrayList<String>();
		String time1 = sf.getTime1();
		String time2 = sf.getTime2();
		String queryFlag = sf.getChestr();
		String fqsj = "";
		String jssj = "";
		Jz_jqxxb entity = new Jz_jqxxb();
		entity.setGxdwdm(orgcode);
		if ("1".equals(queryFlag)) {
			dateList.add(time2);
			fqsj = time1 + "-" + time2 + "-01";
			if ("01".equals(time2) || "03".equals(time2) || "05".equals(time2) || "07".equals(time2) || "08".equals(time2)
					|| "10".equals(time2) || "12".equals(time2)) {
				jssj = time1 + "-" + time2 + "-31";
			} else if("02".equals(time2)){
				jssj = time1 + "-" + time2 + "-28";
			} else {
				jssj = time1 + "-" + time2 + "-30";
			}
		} else if("2".equals(queryFlag)) {
			if ("1".equals(time2)) {
				dateList.add("01");
				dateList.add("02");
				dateList.add("03");
				fqsj = time1 + "-01-01";
				jssj = time1 + "-03-31";
			} else if("2".equals(time2)){
				dateList.add("04");
				dateList.add("05");
				dateList.add("06");
				fqsj = time1 + "-04-01";
				jssj = time1 + "-06-30";
			} else if("3".equals(time2)){
				dateList.add("07");
				dateList.add("08");
				dateList.add("09");
				fqsj = time1 + "-07-01";
				jssj = time1 + "-09-30";
			} else if("4".equals(time2)){
				dateList.add("10");
				dateList.add("11");
				dateList.add("12");
				fqsj = time1 + "-10-01";
				jssj = time1 + "-12-31";
			}
		}
		entity.setFqsj(fqsj);
		entity.setJssj(jssj);
		entity.setJqlbdm(sf.getJqlbdm());
		ajCount = jzDao.queryCountJq(entity);
		
		//算法
		long one = 0;
		long two = 0;
		long three = 0;
		//前三年发案率
		SimpleDateFormat format = new SimpleDateFormat("yyyy"); 
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.YEAR, -1);
		String threeYear = format.format(cal.getTime());
		cal.add(Calendar.YEAR, -1);
		String secondYear = format.format(cal.getTime());
		cal.add(Calendar.YEAR, -1);
		String firstYear = format.format(cal.getTime());
		//第前3年发案数
		Jz_jqxxb jqxxb1 = new Jz_jqxxb();
		jqxxb1.setGxdwdm(orgcode);
		fqsj = firstYear + "-01-31";
		jssj = firstYear + "-12-31";
		jqxxb1.setFqsj(fqsj);
		jqxxb1.setJssj(jssj);
		jqxxb1.setJqlbdm(sf.getJqlbdm());
		one = jzDao.queryCountJq(jqxxb1);
		//第前2年发案数
		Jz_jqxxb jqxxb2 = new Jz_jqxxb();
		jqxxb2.setGxdwdm(orgcode);
		fqsj = secondYear + "-01-31";
		jssj = secondYear + "-12-31";
		jqxxb2.setFqsj(fqsj);
		jqxxb2.setJssj(jssj);
		jqxxb2.setJqlbdm(sf.getJqlbdm());
		two = jzDao.queryCountJq(jqxxb2);
		//第前1年发案数
		Jz_jqxxb jqxxb3 = new Jz_jqxxb();
		jqxxb3.setGxdwdm(orgcode);
		fqsj = threeYear + "-01-31";
		jssj = threeYear + "-12-31";
		jqxxb3.setFqsj(fqsj);
		jqxxb3.setJssj(jssj);
		jqxxb3.setJqlbdm(sf.getJqlbdm());
		three = jzDao.queryCountJq(jqxxb3);
		System.out.println("前三年发案数 " + one + " "  + two + " " + three);
		double total = one + two + three;
		//发案基准常量
		double jz = total / 3 / 90;
		System.out.println("基准值之和 " + jz);
		double fdzTemp1 = Math.pow((one - (total / 3)), 2);
		double fdzTemp2 = Math.pow((two - (total / 3)), 2);
		double fdzTemp3 = Math.pow((three - (total / 3)), 2);
		//浮动值常量
		double fdz = Math.sqrt((fdzTemp1 + fdzTemp2 + fdzTemp3) / 3) / 90;
		System.out.println("浮动值 " + fdz);
		//最低浮动值
		double minFdz = jz - fdz;
		System.out.println("最小浮动值 " + minFdz);
		//最高浮动值
		double maxFdz = jz + fdz;
		System.out.println("最大浮动值 " + maxFdz);
		//基准常量之和
		double jzTotal = 0;
		//浮动值之和
		double fdzTotal = 0;
		//最低浮动值之和
		double minFdzTotal = 0;
		//最高浮动值之和
		double maxFdzTotal = 0;
		int dateInt = 0;
		//根据参数判断查询类别
		//String queryFlag = "week";
		if ("week".equals(queryFlag)) {
			//周计算
			//String date[] = {"2015-01-01", "2015-01-02", "2015-01-03", "2015-01-04", "2015-01-05", "2015-01-06","2015-01-07"};
			for (int i = 0; i < dateList.size(); i++) {
				dateInt = Integer.parseInt(dateList.get(i).substring(dateList.get(i).length()-2, dateList.get(i).length()));
				jzTotal += jz * dateInt;
				fdzTotal += fdz * dateInt;
				minFdzTotal += minFdz * dateInt;
				maxFdzTotal += maxFdz * dateInt;
			}
			System.out.println("基准值之和 " + jzTotal);
			System.out.println("浮动值之和 " + fdzTotal);
			System.out.println("最小浮动值之和 " + minFdzTotal);
			System.out.println("最大浮动值之和 " + maxFdzTotal);
		} else if("1".equals(queryFlag) || "2".equals(queryFlag) || "half".equals(queryFlag) || "year".equals(queryFlag)){
			//String month[] = {"2015-01", "2015-02", "2015-03"};
			String mon = "";
			for (int i = 0; i < dateList.size(); i++) {
				mon = dateList.get(i); //.substring(6, 2);
				dateInt = Integer.parseInt(mon);
				if(mon.contains("01") || mon.contains("03") || mon.contains("05") || mon.contains("07") || mon.contains("08") 
						|| mon.contains("10") || mon.contains("12")){
					for (int j = 1; j <= 31; j++) {
						jzTotal += jz * j;
						fdzTotal += fdz * j;
						minFdzTotal += minFdz * dateInt;
						maxFdzTotal += maxFdz * dateInt;
					}
				} else if("02".equals(time2)){
					for (int j = 1; j <= 28; j++) {
						jzTotal += jz * j;
						fdzTotal += fdz * j;
						minFdzTotal += minFdz * dateInt;
						maxFdzTotal += maxFdz * dateInt;
					}
				} else {
					for (int j = 1; j <= 30; j++) {
						jzTotal += jz * j;
						fdzTotal += fdz * j;
						minFdzTotal += minFdz * dateInt;
						maxFdzTotal += maxFdz * dateInt;
					}
				}
			}
			System.out.println("基准值之和 " + jzTotal);
			System.out.println("浮动值之和 " + fdzTotal);
			System.out.println("最小浮动值之和 " + minFdzTotal);
			System.out.println("最大浮动值之和 " + maxFdzTotal);
		} 
		
		//颜色
		//ajCount = 3690;
		String color = "green";
		if (ajCount <= minFdzTotal) {
			color = "green";
		} else if (ajCount > minFdzTotal && ajCount <= jzTotal) {
			color = "yellow";
		} else if (ajCount > jzTotal && ajCount <= maxFdzTotal) {
			color = "orange";
		} else if (ajCount > maxFdzTotal) {
			color = "red";
		}
		System.out.println("案件数量" + ajCount);
		System.out.println("颜色 " + color);
		return color;
	}
	
}
