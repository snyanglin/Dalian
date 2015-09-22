package com.founder.sqjw.service.impl;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.sqjw.bean.LogInfo;
import com.founder.sqjw.bean.TjSyrk;
import com.founder.sqjw.bean.Tjgzjl;
import com.founder.sqjw.bean.XJSZ;
import com.founder.sqjw.bean.XjtjXq;
import com.founder.sqjw.bean.Xjtjcar;
import com.founder.sqjw.bean.Xjtjemployee;
import com.founder.sqjw.dao.HomePageDao;
import com.founder.sqjw.service.HomePageService;
import com.founder.sqjw.vo.ZdryCountVo;
import com.founder.sqjw.vo.ZzjgVo;
import com.founder.tzgg.bean.Org_Organization;
/**
 * @类名: HomePageServiceImpl 
 * @描述:(类描述) 
 * @作者: zhang_guoliang@founder.com 
 * @日期: 2014-7-4 下午2:40:30 
 *
 */
@Service("homePageService")
@Transactional
public class HomePageServiceImpl implements HomePageService{
	
	@Resource(name = "homePageDao")
	private HomePageDao homePageDao;
    /**
     * @Title: syrkChart 
     * @描述: 实有人口饼状图
     * @作者: zhang_guoliang@founder.com 
     * @参数: 传入参数定义 
     * @日期： 2014-7-9 下午9:02:51 
     * @throws
     */
	public Map<String, Object> syrkChart(String zzgjdm) {
		//创建一个Flash统计图Map返回对象
		Map<String, Object> returnMap = new HashMap<String, Object>();
		//创建一个Flash统计图Map对象
		Map<String, Object> elements = new HashMap<String, Object>();
		elements.put("type", "pie");
		elements.put("alpha", 1);
		elements.put("start-angle", 35);
		Map<String,String> mapan = new HashMap<String,String>();
        mapan.put("type", "fade");
        Map<String,Object> mapantype = new HashMap<String,Object>();	
        mapantype.put("type", "bounce");
        mapantype.put("distance", 5);
        Object[] animates = {mapan,mapantype};
		elements.put("animate", animates);
		String[] colours = {"#85d021","#ffb543","#ff7a7b","#4dc2ed","#ee431b","#e96a3b"};
		elements.put("colours", colours);
		//elements.put("gradient-fill", 2);
		elements.put("tip", "#label# <br> #val# / #total#<br> 占总数的 #percent#");
		//加载数据
		//增加局长页面柱状图判断 begin
		Map<String, Object> map = new HashMap<String, Object>();
		String orgcode = "";
		if (zzgjdm.indexOf("~") != -1) {
			orgcode = zzgjdm.substring(0, zzgjdm.length()-1);
			map.put("zzjgdm", orgcode);
			map.put("type", "jzChart");
		} else {
			orgcode = zzgjdm;
			map.put("zzjgdm", orgcode);
			map.put("type", "");
		}
		String zero8 = orgcode.substring(orgcode.length()-8, orgcode.length());
	    String zero6 = orgcode.substring(orgcode.length()-6, orgcode.length());
	    String zero4 = orgcode.substring(orgcode.length()-4, orgcode.length());
		if (zero8.equals("00000000")) {
			map.put("flag", "FJ");
		} else if(zero6.equals("000000")){
			map.put("flag", "PCS");
		}else if(zero4.equals("0000")){
			map.put("flag", "ZRQ");
		}
		//增加局长页面柱状图判断 end
		List<TjSyrk> list = homePageDao.syrkChart(map);
		int lszs = list.size();
		Integer zs = 0;
		Object[] values = new Object[lszs];
		for(int i=0;i<lszs;i++){
			TjSyrk vo = list.get(i);
			Map<String, Object> valMap = new HashMap<String, Object>();
			valMap.put("value", Integer.parseInt(vo.getSl()));
			valMap.put("label", vo.getLxmc()+"("+vo.getSl()+")");
			valMap.put("font-size", "12");
			valMap.put("on-click", "parent.HomePage.syrkListMBR('"+Integer.parseInt(vo.getLx())+"')");
			values[i] = valMap;
			zs += Integer.parseInt(vo.getSl());
		}
		String titletext = "";
		//局长不点击 
		if (zzgjdm.indexOf("~") != -1) {
			titletext = "辖区内实有人口类型统计图("+zs+")";
		} else {
			titletext = "辖区内实有人口类型统计图("+zs+")";
		}
		Map<String, Object> title = new HashMap<String, Object>();
		title.put("text", titletext);
		title.put("style", "width: 100%;font-size:18px;color: #000000;");
		//将数据放入统计图中
		elements.put("values", values);
		Object[] elementsObject = {elements};
		returnMap.put("elements", elementsObject);
		returnMap.put("title", title);
		returnMap.put("bg_colour", "#FFFFFF");//背景色
		return returnMap;
	}
	/**
	 * @Title: gzdxChart 
	 * @描述:工作对象柱状图
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2014-7-9 下午9:03:00 
	 * @throws
	 */
	public Map<String, Object> gzdxChart(String zzjgdm) {
		//创建一个Flash统计图Map对象
		Map<String, Object> returnMap = new HashMap<String, Object>();
		//获取柱状图数据
		//增加局长页面柱状图判断 begin
		Map<String, Object> map = new HashMap<String, Object>();
		String orgcode = "";
		if (zzjgdm.indexOf("~") != -1) {
			orgcode = zzjgdm.substring(0, zzjgdm.length()-1);
			map.put("zzjgdm", orgcode);
			map.put("type", "jzChart");
		} else {
			orgcode = zzjgdm;
			map.put("zzjgdm", orgcode);
			map.put("type", "");
		}
		String zero8 = orgcode.substring(orgcode.length()-8, orgcode.length());
	    String zero6 = orgcode.substring(orgcode.length()-6, orgcode.length());
		if (zero8.equals("00000000")) {
			map.put("flag", "FJ");
		} else if(zero6.equals("000000")){
			map.put("flag", "PCS");
		}
		//增加局长页面柱状图判断 end
		List<TjSyrk> ldrkList = homePageDao.gzdxChart(map);
		//柱状颜色
		Object[] colors = {"#85d021","#4dc2ed","#ee431b","#e96a3b","#ee9539","#fdbe63","#f1e740","#ffb543","#ff7a7b","#008080","#AA4400","#0000FF"};
		//生命对应值和名称
		int lszs = ldrkList.size();
		Object[] values = new Object[lszs];
		String[] labels = new String[lszs];
		Object[] valuestags =  new Object[lszs];
		Integer max = 10;
		Integer zs = 0;
		for(int i=0;i<lszs;i++){
			if(i<ldrkList.size()){
				TjSyrk vo = ldrkList.get(i);
				//将数字放置到柱子上
				Map<String, Object> valtag = new HashMap<String, Object>();
				valtag.put("colour", colors[i]);
				valtag.put("tip", vo.getSl()+"人");
				valtag.put("top", Integer.parseInt(vo.getSl()));
				//valtag.put("on-click", "parent.HomePage.gzdxListMBR('"+vo.getLx()+"')");
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
			TjSyrk val = ldrkList.get(i);
			zs += Integer.parseInt(val.getSl());
		}
		Map<String, Object> elements = new HashMap<String, Object>();
		elements.put("type", "bar_filled");
		elements.put("values", values);
		//柱子特效
		/*Map<String, Object> xtc = new HashMap<String, Object>();
		xtc.put("type", "pop");//柱子特效（随即特效）
		xtc.put("cascade", 1);
		xtc.put("delay", 0.5);//设置柱子的颜色
		elements.put("on-show", xtc);*/
		String titletext = "辖区内重点人口统计图("+zs+")";
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
		tags.put("text", "#y# 人");
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
		return returnMap;
	}
	/**
	 * @Title: bzdzChart 
	 * @描述: 标准地址饼状图
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2014-7-11 上午10:01:12 
	 * @throws
	 */
	public Map<String, Object> bzdzChart(String zzjgdm) {
		//创建一个Flash统计图Map返回对象
		Map<String, Object> returnMap = new HashMap<String, Object>();
		//创建一个Flash统计图Map对象
		Map<String, Object> elements = new HashMap<String, Object>();
		elements.put("type", "pie");
		elements.put("alpha", 1);
		elements.put("start-angle", 35);
		Map<String,String> mapan = new HashMap<String,String>();
        mapan.put("type", "fade");
        Map<String,Object> mapantype = new HashMap<String,Object>();	
        mapantype.put("type", "bounce");
        mapantype.put("distance", 5);
        Object[] animates = {mapan,mapantype};
		elements.put("animate", animates);
		String[] colours = {"#ff7a7b","#85d021","#e96a3b","#4dc2ed","#ee431b"};
		elements.put("colours", colours);
		//elements.put("gradient-fill", 2);
		elements.put("tip", "#label# <br> #val# / #total#<br> 占总数的 #percent#");
		//加载数据
  	    List<TjSyrk> list = homePageDao.bzdzChart(zzjgdm);
		int lszs = list.size();
		Integer zs = 0;
		Object[] values = new Object[lszs];
		for(int i=0;i<lszs;i++){
			TjSyrk vo = list.get(i);
			Map<String, Object> valMap = new HashMap<String, Object>();
			valMap.put("value", Integer.parseInt(vo.getSl()));
			valMap.put("label", vo.getLxmc()+"("+vo.getSl()+")");
			valMap.put("font-size", "12");
			if("02".equals(vo.getLx())){
				//valMap.put("on-click", "parent.HomePage.bzdzListMBR('"+vo.getLx()+"')");
			}
			values[i] = valMap;
  		    zs += Integer.parseInt(vo.getSl());
		}
		String titletext = "辖区内标准地址统计图("+zs+")";
		Map<String, Object> title = new HashMap<String, Object>();
		title.put("text", titletext);
		title.put("style", "width: 100%;font-size:18px;color: #000000;");
		//将数据放入统计图中
		elements.put("values", values);
		Object[] elementsObject = {elements};
		returnMap.put("elements", elementsObject);
		returnMap.put("title", title);
		returnMap.put("bg_colour", "#FFFFFF");//背景色
		return returnMap;
	}
	/**
	 * @Title: ldrkChart 
	 * @描述: 流动人口来自地区状图
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2014-7-11 上午10:10:45 
	 * @throws
	 */
	public Map<String, Object> ldrkChart(String zzjgdm) {
		//创建一个Flash统计图Map对象
		Map<String, Object> returnMap = new HashMap<String, Object>();
		//获取柱状图数据
		//增加局长页面柱状图判断 begin
		Map<String, Object> map = new HashMap<String, Object>();
		String orgcode = "";
		if (zzjgdm.indexOf("~") != -1) {
			orgcode = zzjgdm.substring(0, zzjgdm.length()-1);
			map.put("zzjgdm", orgcode);
			map.put("type", "jzChart");
		} else {
			orgcode = zzjgdm;
			map.put("zzjgdm", orgcode);
			map.put("type", "");
		}
		String zero8 = orgcode.substring(orgcode.length()-8, orgcode.length());
	    String zero6 = orgcode.substring(orgcode.length()-6, orgcode.length());
		if (zero8.equals("00000000")) {
			map.put("flag", "FJ");
		} else if(zero6.equals("000000")){
			map.put("flag", "PCS");
		}
		//增加局长页面柱状图判断 end
		List<TjSyrk> ldrkList = homePageDao.ldrkChart(map);
		//柱状颜色
		Object[] colors = {"#ee431b","#e96a3b","#ee9539","#fdbe63","#f1e740","#85d021","#4dc2ed","#ffb543","#ff7a7b","#008080","#AA4400","#0000FF"};
		//生命对应值和名称
		int lszs = ldrkList.size();
		Object[] values = new Object[10];
		String[] labels = new String[10];
		Object[] valuestags =  new Object[10];
		Integer max = 10;
		Integer zs = 0;
		for(int i=0;i<lszs;i++){
			if(i<10){
				TjSyrk vo = ldrkList.get(i);
				//将数字放置到柱子上
				Map<String, Object> valtag = new HashMap<String, Object>();
				valtag.put("colour", colors[i]);
				valtag.put("tip", vo.getSl()+"人");
				valtag.put("top", Integer.parseInt(vo.getSl()));
				//valtag.put("on-click", "parent.HomePage.ldrkListMBR('"+vo.getLx()+"','"+vo.getLxmc()+"')");
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
			TjSyrk val = ldrkList.get(i);
			zs += Integer.parseInt(val.getSl());
		}
		Map<String, Object> elements = new HashMap<String, Object>();
		elements.put("type", "bar_filled");
		elements.put("values", values);
		//柱子特效
		/*Map<String, Object> xtc = new HashMap<String, Object>();
		xtc.put("type", "pop");//柱子特效（随即特效）
		xtc.put("cascade", 1);
		xtc.put("delay", 0.5);//设置柱子的颜色
		elements.put("on-show", xtc);*/
		String titletext = "辖区流动人口来自地区统计图("+zs+")";
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
		tags.put("text", "#y# 人");
		//设置y轴
		Map<String, Object> yaxisMap = new HashMap<String, Object>();
		Integer steps = 0;
		if(max>10){
			steps = max/10;
			yaxisMap.put("max", steps+max);
		}else{
			steps = max;   
			yaxisMap.put("max", steps);
		}
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
		return returnMap;
	}
	/**
	 * @Title: jwrkChart 
	 * @描述: 境外人口柱状图 
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2014-7-11 上午10:32:36 
	 * @throws
	 */
	public Map<String, Object> jwrkChart(String zzjgdm) {
		//创建一个Flash统计图Map对象
		Map<String, Object> returnMap = new HashMap<String, Object>();
		//获取柱状图数据
		List<TjSyrk> ldrkList = homePageDao.jwrkChart(zzjgdm);
		//柱状颜色
		Object[] colors = {"#4dc2ed","#ffb543","#ff7a7b","#ee431b","#e96a3b","#ee9539","#fdbe63","#f1e740","#85d021","#008080","#AA4400","#0000FF"};
		//生命对应值和名称
		int lszs = ldrkList.size();
		Object[] values = new Object[10];
		String[] labels = new String[10];
		Object[] valuestags =  new Object[10];
		Integer max = 10;
		Integer zs = 0;
		for(int i=0;i<lszs;i++){
			if(i<10){
				TjSyrk vo = ldrkList.get(i);
				//将数字放置到柱子上
				Map<String, Object> valtag = new HashMap<String, Object>();
				valtag.put("colour", colors[i]);
				valtag.put("tip", vo.getSl()+"人");
				valtag.put("top", Integer.parseInt(vo.getSl()));
				//valtag.put("on-click", "parent.HomePage.jwrkListMBR('"+vo.getLx()+"','"+vo.getLxmc()+"')");
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
			TjSyrk val = ldrkList.get(i);
			zs += Integer.parseInt(val.getSl());
		}
		Map<String, Object> elements = new HashMap<String, Object>();
		elements.put("type", "bar_filled");
		elements.put("values", values);
		/*//柱子特效
		Map<String, Object> xtc = new HashMap<String, Object>();
		xtc.put("type", "pop");//柱子特效（随即特效）
		xtc.put("cascade", 1);
		xtc.put("delay", 0.5);//设置柱子的颜色
		elements.put("on-show", xtc);*/
		String titletext = "辖区内境外人口国籍统计图("+zs+")";
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
		tags.put("text", "#y# 人");
		//设置y轴
		Map<String, Object> yaxisMap = new HashMap<String, Object>();
		Integer steps = 0;
		if(max>10){
			steps = max/10;
			yaxisMap.put("max", steps+max);
		}else{
			steps = max;   
			yaxisMap.put("max", steps);
		}
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
		return returnMap;
	}
	/**
	 * @Title: nlChart 
	 * @描述: 年龄段统计
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2014-7-14 下午6:38:34 
	 * @throws
	 */
	public Map<String, Object> nlChart(String zzgjdm) {
		//创建一个Flash统计图Map返回对象
		Map<String, Object> returnMap = new HashMap<String, Object>();
		//创建一个Flash统计图Map对象
		Map<String, Object> elements = new HashMap<String, Object>();
		elements.put("type", "pie");
		elements.put("alpha", 1);
		elements.put("start-angle", 35);
		Map<String,String> mapan = new HashMap<String,String>();
        mapan.put("type", "fade");
        Map<String,Object> mapantype = new HashMap<String,Object>();	
        mapantype.put("type", "bounce");
        mapantype.put("distance", 5);
        Object[] animates = {mapan,mapantype};
		elements.put("animate", animates);
		String[] colours = {"#85d021","#ffb543","#e96a3b","#4dc2ed","#ee431b","#ee431b","#e96a3b"};
		elements.put("colours", colours);
		//elements.put("gradient-fill", 2);
		elements.put("tip", "#label# <br> #val# / #total#<br> 占总数的 #percent#");
		//加载数据
		//增加局长页面柱状图判断 begin
		Map<String, Object> map = new HashMap<String, Object>();
		String orgcode = "";
		if (zzgjdm.indexOf("~") != -1) {
			orgcode = zzgjdm.substring(0, zzgjdm.length()-1);
			map.put("zzjgdm", orgcode);
			map.put("type", "jzChart");
		} else {
			orgcode = zzgjdm;
			map.put("zzjgdm", orgcode);
			map.put("type", "");
		}
		String zero8 = orgcode.substring(orgcode.length()-8, orgcode.length());
	    String zero6 = orgcode.substring(orgcode.length()-6, orgcode.length());
		if (zero8.equals("00000000")) {
			map.put("flag", "FJ");
		} else if(zero6.equals("000000")){
			map.put("flag", "PCS");
		}
		//增加局长页面柱状图判断 end
		List<TjSyrk> list = homePageDao.nlChart(map);
		int lszs = list.size();
		Integer zs = 0;
		Object[] values = new Object[lszs];
		for(int i=0;i<lszs;i++){
			TjSyrk vo = list.get(i);
			Map<String, Object> valMap = new HashMap<String, Object>();
			valMap.put("value", Integer.parseInt(vo.getSl()));
			valMap.put("label", vo.getLxmc()+"("+vo.getSl()+")");
			//valMap.put("on-click", "parent.HomePage.nlListMBR('"+vo.getLx()+"','"+vo.getLxmc()+"')");
			valMap.put("font-size", "12");
			values[i] = valMap;
			zs += Integer.parseInt(vo.getSl());
		}
		String titletext = "辖区内常住人口年龄段统计图("+zs+")";
		Map<String, Object> title = new HashMap<String, Object>();
		title.put("text", titletext);
		title.put("style", "width: 100%;font-size:18px;color: #000000;");
		//将数据放入统计图中
		elements.put("values", values);
		Object[] elementsObject = {elements};
		returnMap.put("elements", elementsObject);
		returnMap.put("title", title);
		returnMap.put("bg_colour", "#FFFFFF");//背景色
		return returnMap;
	}
	/**
	 * @Title: whcdChart 
	 * @描述: 文化程度统计
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2014-7-14 下午6:48:53 
	 * @throws
	 */
	public Map<String, Object> whcdChart(String zzgjdm) {
		//创建一个Flash统计图Map返回对象
		Map<String, Object> returnMap = new HashMap<String, Object>();
		//创建一个Flash统计图Map对象
		Map<String, Object> elements = new HashMap<String, Object>();
		elements.put("type", "pie");
		elements.put("alpha", 1);
		elements.put("start-angle", 35);
		Map<String,String> mapan = new HashMap<String,String>();
        mapan.put("type", "fade");
        Map<String,Object> mapantype = new HashMap<String,Object>();	
        mapantype.put("type", "bounce");
        mapantype.put("distance", 5);
        Object[] animates = {mapan,mapantype};
		elements.put("animate", animates);
		String[] colours = {"#85d021","#4dc2ed","#ffb543","#ff7a7b","#f1e740","#fdbe63","#ee9539","#896a3b","#ee431b"};
		elements.put("colours", colours);
		//elements.put("gradient-fill", 2);
		elements.put("tip", "#label# <br> #val# / #total#<br> 占总数的 #percent#");
		//加载数据
		List<TjSyrk> list = homePageDao.whcdChart(zzgjdm);
		int lszs = list.size();
		Integer zs = 0;
		Object[] values = new Object[lszs];
		for(int i=0;i<lszs;i++){
			TjSyrk vo = list.get(i);
			Map<String, Object> valMap = new HashMap<String, Object>();
			valMap.put("value", Integer.parseInt(vo.getSl()));
			valMap.put("label", vo.getLxmc()+"("+vo.getSl()+")");
			valMap.put("font-size", "12");
			values[i] = valMap;
			zs += Integer.parseInt(vo.getSl());
		}
		String titletext = "辖区内实有人口文化程度统计图("+zs+")";
		Map<String, Object> title = new HashMap<String, Object>();
		title.put("text", titletext);
		title.put("style", "width: 100%;font-size:18px;color: #000000;");
		//将数据放入统计图中
		elements.put("values", values);
		Object[] elementsObject = {elements};
		returnMap.put("elements", elementsObject);
		returnMap.put("title", title);
		returnMap.put("bg_colour", "#FFFFFF");//背景色
		return returnMap;
	}
	/**
	 * @Title: queryGzjlDate 
	 * @描述: 获取工作记录时间 
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2014-7-10 上午11:20:21 
	 * @throws
	 */
	public List<String> queryGzjlDate() {
		return homePageDao.queryGzjlDate();
	}
	/**
	 * @Title: queryGzjlList 
	 * @描述: 获取工作记录昨天数据 
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2014-7-10 下午8:56:13 
	 * @throws
	 */
	public List<Tjgzjl> queryGzjlList(Map<String,Object> param){
		return homePageDao.queryGzjlList(param);
	}
	public List<Map<String, String>> queryGzjlList2(Map<String,Object> param) {
		return homePageDao.queryGzjlList2(param);
	}
	/**
	 * @Title: queryGzjlInfo 
	 * @描述: 工作记录详情数据
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2014-7-14 下午10:59:57 
	 * @throws
	 */
	public List<LogInfo> queryGzjlInfo(Map<String,Object> param) {
		return homePageDao.queryGzjlInfo(param);
	}
	/**
	 * @Title: queryGzjlInfoCount 
	 * @描述: 工作记录详情总数
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2014-7-15 下午2:05:23 
	 * @throws
	 */
	public int queryGzjlInfoCount(Map<String, Object> param) {
		return homePageDao.queryGzjlInfoCount(param);
	}
	/**
	 * @Title: queryGzdxList 
	 * @描述: 查询工作对象坐标详情 
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2014-7-17 下午15:45:43 
	 * @返回值:  
	 * @throws
	 */
	public List<TjSyrk> queryGzdxList(Map<String, Object> param) {
		return homePageDao.queryGzdxList(param);
	}
	/**
	 * @Title: queryldrkList 
	 * @描述: 流动人口统计坐标详情
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2014-7-17 下午4:33:08 
	 * @throws
	 */
	public List<TjSyrk> queryldrkList(Map<String, Object> param) {
		return homePageDao.queryldrkList(param);
	}
	/**
	 * @Title: queryjwrkList 
	 * @描述: 境外人口统计坐标详情
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2014-7-17 下午4:53:31 
	 * @返回值: List<TjSyrk>    返回类型 
	 * @throws
	 */
	public List<TjSyrk> queryjwrkList(Map<String, Object> param) {
		return homePageDao.queryjwrkList(param);
	}
	/**
	 * @Title: querynlList 
	 * @描述: 年龄段统计坐标详情
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2014-7-17 下午5:04:26 
	 * @返回值: List<TjSyrk>    返回类型 
	 * @throws
	 */
	public List<TjSyrk> querynlList(Map<String, Object> param) {
		return homePageDao.querynlList(param);
	}
	/**
	 * @Title: queryXjZzjg 
	 * @描述: 获取派出所下级组织机构
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2014-10-23 下午2:09:42 
	 * @throws
	 */
	public List<ZzjgVo> queryXjZzjg(String zzjgdm) {
		return homePageDao.queryXjZzjg(zzjgdm);
	}
	
	/**
	 * @Title: queryPcsTj 
	 * @描述: 派出所统计
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2014-10-25 下午4:45:19 
	 * @throws
	 */
	public List<ZzjgVo> queryPcsTj(Map<String,Object> params) {
		return homePageDao.queryPcsTj(params);
	}
	/**
	 * @Title: queryZrqUser 
	 * @描述: 责任区民警
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2014-10-26 下午2:29:30 
	 * @throws
	 */
	public List<ZzjgVo> queryZrqUser(String zzjgdm) {
		return homePageDao.queryZrqUser(zzjgdm);
	}
	/**
	 * @Title: querytwspMap 
	 * @描述: 天网视频撒点
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2014-10-27 下午4:32:37 
	 * @throws
	 */
	public List<ZzjgVo> querytwspMap(String zzjgdm) {
		return homePageDao.querytwspMap(zzjgdm);
	}

	/**
	 * @Title: querySydwMap 
	 * @描述: 实有单位撒点 1表示旅馆 0表示网吧
	 * @作者: yu_sun@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2014-10-28 下午4:32:37 
	 * @throws
	 */
	public List<ZzjgVo> querySydwMap(Map<String, Object> map) {
		return homePageDao.querySydwMap(map);
	}
	/**
	 * @Title: querySyfwMap 
	 * @描述: 实有房屋撒点
	 * @作者: yu_sun@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2014-10-28 下午4:32:37 
	 * @throws
	 */
	public List<ZzjgVo> querySyfwMap(Map<String, Object> map) {
		return homePageDao.querySyfwMap(map);
	}
	
	/**
	 * 
	 * @Title: getThisDays
	 * @Description: TODO(取得本月所有日期)
	 * @param @return    Map<String, Object>
	 * @return Map<String,Object>    返回类型
	 * @throws
	 */
	public static Map<String, Object> getThisDays(){
	 SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");        
	 Calendar cal = Calendar.getInstance();        
	 cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), 1);
	 cal.add(Calendar.MONTH, 1);
	 cal.add(Calendar.DATE, -1);
	 String lastDay = sf.format(cal.getTime());
	 String aDay = "";
	 Map<String, Object> map = new HashMap<String, Object>();
	 int num = 0;
	 int i = 1;
	 while (!lastDay.equals(aDay)) {
		cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), i);
		aDay = sf.format(cal.getTime());
		String str = sf.format(cal.getTime());
		map.put(++num+"", str);
		i++;
	}
     return map;
	}
	
	/**
	 * 
	 * @Title: getThisDay
	 * @Description: TODO(取得本月所有日期)
	 * @param @return    yyyy-MM
	 * @return String    返回类型
	 * @throws
	 */
	public static String getThisDay(){
		 SimpleDateFormat sf = new SimpleDateFormat("dd");        
		 Calendar cal = Calendar.getInstance();        
		 cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), 1);
		 cal.add(Calendar.MONTH, 1);
		 cal.add(Calendar.DATE, -1);
		 String lastDay = sf.format(cal.getTime());
		 String aDay = "";
		 StringBuffer map = new StringBuffer();
		 int i = 1;
		 while (!lastDay.equals(aDay)) {
			cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), i);
			aDay = sf.format(cal.getTime());
			map.append(sf.format(cal.getTime())).append(",");
			i++;
		}
	    return map.toString().substring(0, map.toString().lastIndexOf(","));
	}
	
	/**
	 * 
	 * @Title: getThisMonths
	 * @Description: TODO(取得本年所有月)
	 * @param @return   yyyy-MM
	 * @return Map<String,Object>    返回类型
	 * @throws
	 */
	public static Map<String, Object> getThisMonths(){
		 SimpleDateFormat sf = new SimpleDateFormat("yyyy");        
		 Calendar cal = Calendar.getInstance();        
		 cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), 1);     
		 Map<String, Object> map = new HashMap<String, Object>();
		 for (int i = 1; i <= 12; i++) {
			 String str = sf.format(cal.getTime());
			 map.put(i+"", str + "-" + ( i<10 ? "0"+i : i) );
		 }
		 return map;
	}
	
	public static void main(String[] args) {
		System.out.println(getThisWeek());
		System.out.println(getThisDays());
		int[] a = {1, 2, 3};
		int[] b = {4, 5, 6};
		int c[] = new int[a.length + b.length];
		System.arraycopy(a, 0, c, 0, a.length);
		System.out.println(c.length);
	}
	
	/**
	 * 
	 * @Title: getThisWeek
	 * @Description: TODO(得到本周所有日期)
	 * @param @return    yyyy-MM-dd, yyyy-MM-dd ...
	 * @return Map<String,Object>    返回类型
	 * @throws
	 */
	 public static Map<String, Object> getThisWeek() {
		  Calendar c = Calendar.getInstance();
		  int dayofweek = c.get(Calendar.DAY_OF_WEEK) - 1;
		  if (dayofweek == 0) {
			dayofweek = 7;
		  }
		  c.add(Calendar.DATE, -dayofweek+1);
		  SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		  Map<String, Object> map = new HashMap<String, Object>();
		  for (int i = 1; i <=7; i++) {
			  String str = sf.format(c.getTime());
			  map.put(i+"", str);
			  c.add(Calendar.DATE, 1);
		  }
		  return map;
	 }
	 
	 /**
	  * 
	  * @Title: get4Data
	  * @Description: TODO(填充季度的数据)
	  * @param @param vo
	  * @param @return    设定文件
	  * @return Object[]    返回类型
	  * @throws
	  */
	 public Object[] get4Data(TjSyrk vo){
		    Object[] obj = new Object[4];
			int num = 0;
			obj[num++] = Integer.parseInt(vo.getA()) + Integer.parseInt(vo.getB()) + Integer.parseInt(vo.getC());
			obj[num++] = Integer.parseInt(vo.getD()) + Integer.parseInt(vo.getE()) + Integer.parseInt(vo.getF());
			obj[num++] = Integer.parseInt(vo.getG()) + Integer.parseInt(vo.getH()) + Integer.parseInt(vo.getI());
			obj[num++] = Integer.parseInt(vo.getJ()) + Integer.parseInt(vo.getK()) + Integer.parseInt(vo.getL());
			return obj;
		 }
	 
	 /**
	  * 
	  * @Title: getData
	  * @Description: TODO(填充年数据)
	  * @param @param vo
	  * @param @return    设定文件
	  * @return Object[]    返回类型
	  * @throws
	  */
	 public Object[] getData(TjSyrk vo){
	    Object[] obj = new Object[12];
		int num = 0;
		obj[num++] = Integer.parseInt(vo.getA());
		obj[num++] = Integer.parseInt(vo.getB());
		obj[num++] = Integer.parseInt(vo.getC());
		obj[num++] = Integer.parseInt(vo.getD());
		obj[num++] = Integer.parseInt(vo.getE());
		obj[num++] = Integer.parseInt(vo.getF());
		obj[num++] = Integer.parseInt(vo.getG());
		obj[num++] = Integer.parseInt(vo.getH());
		obj[num++] = Integer.parseInt(vo.getI());
		obj[num++] = Integer.parseInt(vo.getJ());
		obj[num++] = Integer.parseInt(vo.getK());
		obj[num++] = Integer.parseInt(vo.getL());
		return obj;
	 }
	 
	 /**
	  * 
	  * @Title: get7Data
	  * @Description: TODO(填充周统计数据)
	  * @param @param vo
	  * @param @return    设定文件
	  * @return Object[]    返回类型
	  * @throws
	  */
	 public Object[] get7Data(TjSyrk vo){
	    Object[] obj = new Object[7];
		int num = 0;
		obj[num] = Integer.parseInt(vo.getA());
		obj[++num] = Integer.parseInt(vo.getB());
		obj[++num] = Integer.parseInt(vo.getC());
		obj[++num] = Integer.parseInt(vo.getD());
		obj[++num] = Integer.parseInt(vo.getE());
		obj[++num] = Integer.parseInt(vo.getF());
		obj[++num] = Integer.parseInt(vo.getG());
		return obj;
	 }
	 
	 /**
	  * 
	  * @Title: getDayData
	  * @Description: TODO(填充日统计数据)
	  * @param @param vo
	  * @param @return    设定文件
	  * @return Object[]    返回类型
	  * @throws
	  */
	 public Object[] getDayData(TjSyrk vo){
	    Object[] obj = new Object[31];
		int num = 0;
		obj[num] = Integer.parseInt(vo.getA());
		obj[++num] = Integer.parseInt(vo.getB());
		obj[++num] = Integer.parseInt(vo.getC());
		obj[++num] = Integer.parseInt(vo.getD());
		obj[++num] = Integer.parseInt(vo.getE());
		obj[++num] = Integer.parseInt(vo.getF());
		obj[++num] = Integer.parseInt(vo.getG());
		obj[++num] = Integer.parseInt(vo.getH());
		obj[++num] = Integer.parseInt(vo.getI());
		obj[++num] = Integer.parseInt(vo.getJ());
		obj[++num] = Integer.parseInt(vo.getK());
		obj[++num] = Integer.parseInt(vo.getL());
		obj[++num] = Integer.parseInt(vo.getM());
		obj[++num] = Integer.parseInt(vo.getN());
		obj[++num] = Integer.parseInt(vo.getO());
		obj[++num] = Integer.parseInt(vo.getP());
		obj[++num] = Integer.parseInt(vo.getQ());
		obj[++num] = Integer.parseInt(vo.getR());
		obj[++num] = Integer.parseInt(vo.getS());
		obj[++num] = Integer.parseInt(vo.getT());
		obj[++num] = Integer.parseInt(vo.getU());
		obj[++num] = Integer.parseInt(vo.getV());
		obj[++num] = Integer.parseInt(vo.getW());
		obj[++num] = Integer.parseInt(vo.getX());
		obj[++num] = Integer.parseInt(vo.getY());
		obj[++num] = Integer.parseInt(vo.getZ());
		obj[++num] = Integer.parseInt(vo.getAa());
		obj[++num] = Integer.parseInt(vo.getBb());
		if(vo.getCc() != null){
			obj[++num] = Integer.parseInt(vo.getCc());			
		}
		if(vo.getDd() != null){
			obj[++num] = Integer.parseInt(vo.getDd());			
		}
		if(vo.getEe() != null){
			obj[++num] = Integer.parseInt(vo.getEe());			
		}
		return obj;
	 }
	 
	 
 /**
  * 
  * @Title: get7Data
  * @Description: TODO(首页-派出所)
  * @param @param vo
  * @param @return    设定文件
  * @return Object[]    返回类型
  * @throws
  */
	@SuppressWarnings("static-access")
	public Map<String, Object> censusChart(String dateStr, String pcsdm) {
		String [] param = dateStr.split("-");
		String flag = "Total";
		if(param.length > 1){
			flag = param[1];
		}
		dateStr = param[0];
		//设置两条线的动画效果
		Object[] tx = {"pop-up","explode","mid-slide","drop"};
		Map<String, Object> xtc1 = new HashMap<String, Object>();
		xtc1.put("type", tx[(int) Math.floor(Math.random()*tx.length)]);//折线图1特效（随即特效）
		xtc1.put("cascade", 1);
		xtc1.put("delay", 0.5);
		//获取月报、周报、日报、季度报表数据
		List<TjSyrk> list = new ArrayList<TjSyrk>();
		Map<String, Object> map = new HashMap<String, Object>();
		if (!StringUtils.isBlank(dateStr)) {
			if ("month".equals(dateStr)) {
				map = getThisMonths();
				map.put("pcsdm", pcsdm);
				if ("Total".equals(flag)) {
					list = homePageDao.censusChart(map);
				} if ("Syrk".equals(flag)) {
					list = homePageDao.censusChartSyrk(map);
				} if ("Zdry".equals(flag)) {
					list = homePageDao.censusChartZdry(map);
				} if ("Syfw".equals(flag)) {
					list = homePageDao.censusChartSyfw(map);
				} if ("Sydw".equals(flag)) {
					list = homePageDao.censusChartSydw(map);
				} if ("Bzdz".equals(flag)) {
					list = homePageDao.censusChartBzdz(map);
				}
			} else if("day".equals(dateStr)){
				map = getThisDays();
				map.put("pcsdm", pcsdm);
				if ("Total".equals(flag)) {
					list = homePageDao.censusDayChart(map);
				} if ("Syrk".equals(flag)) {
					list = homePageDao.censusDayChartSyrk(map);
				} if ("Zdry".equals(flag)) {
					list = homePageDao.censusDayChartZdry(map);
				} if ("Syfw".equals(flag)) {
					list = homePageDao.censusDayChartSyfw(map);
				} if ("Sydw".equals(flag)) {
					list = homePageDao.censusDayChartSydw(map);
				} if ("Bzdz".equals(flag)) {
					list = homePageDao.censusDayChartBzdz(map);
				}
			} else if("quarter".equals(dateStr)){
				map = getThisMonths();
				map.put("pcsdm", pcsdm);
				if ("Total".equals(flag)) {
					list = homePageDao.censusChart(map);
				} if ("Syrk".equals(flag)) {
					list = homePageDao.censusChartSyrk(map);
				} if ("Zdry".equals(flag)) {
					list = homePageDao.censusChartZdry(map);
				} if ("Syfw".equals(flag)) {
					list = homePageDao.censusChartSyfw(map);
				} if ("Sydw".equals(flag)) {
					list = homePageDao.censusChartSydw(map);
				} if ("Bzdz".equals(flag)) {
					list = homePageDao.censusChartBzdz(map);
				}
			} else if("week".equals(dateStr)){
				map = getThisWeek();
				map.put("pcsdm", pcsdm);
				if ("Total".equals(flag)) {
					list = homePageDao.censusWeekChart(map);
				} if ("Syrk".equals(flag)) {
					list = homePageDao.censusChartSyrkWeek(map);
				} if ("Zdry".equals(flag)) {
					list = homePageDao.censusChartZdryWeek(map);
				} if ("Syfw".equals(flag)) {
					list = homePageDao.censusChartSyfwWeek(map);
				} if ("Sydw".equals(flag)) {
					list = homePageDao.censusChartSydwWeek(map);
				} if ("Bzdz".equals(flag)) {
					list = homePageDao.censusChartBzdzWeek(map);
				}
			}
		}
		//填充数据
		Object[] numSyrk = new Object[12];
		Object[] numZdry = new Object[12];
		Object[] numSydw = new Object[12];
		Object[] numSyFw = new Object[12];
		Object[] numBzdz = new Object[12];
		
		Object[] numSyrks = new Object[12];
		Object[] numZdrys = new Object[12];
		Object[] numSydws = new Object[12];
		Object[] numSyFws = new Object[12];
		Object[] numBzdzs = new Object[12];
		
		for (int i = 0; i < list.size(); i++) {
			TjSyrk vo = (TjSyrk)list.get(i);
			if ("实有人口".equals(vo.getFlag())) {
				if ("month".equals(dateStr)) {
					if ("0".equals(vo.getIsZx())) {
						numSyrk = getData(vo);
					} else {
						numSyrks = getData(vo);
					}
				} else if("day".equals(dateStr)){
					if ("0".equals(vo.getIsZx())) {
						numSyrk = new Object[31];
						numSyrk = getDayData(vo);
					} else {
						numSyrks = new Object[31];
						numSyrks = getDayData(vo);
					}
				} else if("quarter".equals(dateStr)){
					if ("0".equals(vo.getIsZx())) {
						numSyrk = new Object[4];
						numSyrk = get4Data(vo);
					} else {
						numSyrks = new Object[4];
						numSyrks = get4Data(vo);
					}
				} else if("week".equals(dateStr)){
					if ("0".equals(vo.getIsZx())) {
						numSyrk = new Object[7];
						numSyrk = get7Data(vo);
					} else {
						numSyrks = new Object[7];
						numSyrks = get7Data(vo);
					}
				}
			} else if ("重点人员".equals(vo.getFlag())) {
				if ("month".equals(dateStr)) {
					if ("0".equals(vo.getIsZx())) {
						numZdry = getData(vo);
					} else {
						numZdrys = getData(vo);
					}
				} else if("day".equals(dateStr)){
					if ("0".equals(vo.getIsZx())) {
						numZdry = new Object[31];
						numZdry = getDayData(vo);
					} else {
						numZdrys = new Object[31];
						numZdrys = getDayData(vo);
					}
				} else if("quarter".equals(dateStr)){
					if ("0".equals(vo.getIsZx())) {
						numZdry = new Object[4];
						numZdry = get4Data(vo);
					} else {
						numZdrys = new Object[4];
						numZdrys = get4Data(vo);
					}
				} else if("week".equals(dateStr)){
					if ("0".equals(vo.getIsZx())) {
						numZdry = new Object[7];
						numZdry = get7Data(vo);
					} else {
						numZdrys = new Object[7];
						numZdrys = get7Data(vo);
					}
				}
			} else if ("实有单位".equals(vo.getFlag())) {
				if ("month".equals(dateStr)) {
					if ("0".equals(vo.getIsZx())) {
						numSydw = getData(vo);
					} else {
						numSydws = getData(vo);
					}
				} else if("day".equals(dateStr)){
					if ("0".equals(vo.getIsZx())) {
						numSydw = new Object[31];
						numSydw = getDayData(vo);
					} else {
						numSydws = new Object[31];
						numSydws = getDayData(vo);
					}
				} else if("quarter".equals(dateStr)){
					if ("0".equals(vo.getIsZx())) {
						numSydw = new Object[4];
						numSydw = get4Data(vo);
					} else {
						numSydws = new Object[4];
						numSydws = get4Data(vo);
					}
				} else if("week".equals(dateStr)){
					if ("0".equals(vo.getIsZx())) {
						numSydw = new Object[7];
						numSydw = get7Data(vo);
					} else {
						numSydws = new Object[7];
						numSydws = get7Data(vo);
					}
				}
			} else if ("实有房屋".equals(vo.getFlag())) {
				if ("month".equals(dateStr)) {
					if ("0".equals(vo.getIsZx())) {
						numSyFw = getData(vo);
					} else {
						numSyFws = getData(vo);
					}
				} else if("day".equals(dateStr)){
					if ("0".equals(vo.getIsZx())) {
						numSyFw = new Object[31];
						numSyFw = getDayData(vo);
					} else {
						numSyFws = new Object[31];
						numSyFws = getDayData(vo);
					}
				} else if("quarter".equals(dateStr)){
					if ("0".equals(vo.getIsZx())) {
						numSyFw = new Object[4];
						numSyFw = get4Data(vo);
					} else {
						numSyFws = new Object[4];
						numSyFws = get4Data(vo);
					}
				} else if("week".equals(dateStr)){
					if ("0".equals(vo.getIsZx())) {
						numSyFw = new Object[7];
						numSyFw = get7Data(vo);
					} else {
						numSyFws = new Object[7];
						numSyFws = get7Data(vo);
					}
				}
			} else if ("标准地址".equals(vo.getFlag())) {
				if ("month".equals(dateStr)) {
					if ("0".equals(vo.getIsZx())) {
						numBzdz = getData(vo);
					} else {
						numBzdzs = getData(vo);
					}
				} else if("day".equals(dateStr)){
					if ("0".equals(vo.getIsZx())) {
						numBzdz = new Object[31];
						numBzdz = getDayData(vo);
					} else {
						numBzdzs = new Object[31];
						numBzdzs = getDayData(vo);
					}
				} else if("quarter".equals(dateStr)){
					if ("0".equals(vo.getIsZx())) {
						numBzdz = new Object[4];
						numBzdz = get4Data(vo);
					} else {
						numBzdzs = new Object[4];
						numBzdzs = get4Data(vo);
					}
				} else if("week".equals(dateStr)){
					if ("0".equals(vo.getIsZx())) {
						numBzdz = new Object[7];
						numBzdz = get7Data(vo);
					} else {
						numBzdzs = new Object[7];
						numBzdzs = get7Data(vo);
					}
				}
			} 
		}
		
		//取得最大数字，作为纵坐标最大值
		Integer max = 0;
		int a = numSyrk.length;
		int b = numZdry.length;
		int c = numSydw.length;
		int d = numSyFw.length;
		int e = numBzdz.length;
		int f = numSyrks.length;
		int g = numZdrys.length;
		int h = numSydws.length;
		int ii = numSyFws.length;
		int jj = numBzdzs.length;
		Object[] lastArr = new Object[a + b + c + d + e + f + g + h + ii + jj];
		System.arraycopy(numSyrk, 0, lastArr, 0, a);
		System.arraycopy(numZdry, 0, lastArr, a, b);
		System.arraycopy(numSydw, 0, lastArr, a+b , c);
		System.arraycopy(numSyFw, 0, lastArr, a+b+c, d);
		System.arraycopy(numBzdz, 0, lastArr, a+b+c+d, e);
		System.arraycopy(numSyrks, 0, lastArr, a+b+c+d+e, f);
		System.arraycopy(numZdrys, 0, lastArr, a+b+c+d+e+f, g);
		System.arraycopy(numSydws, 0, lastArr, a+b+c+d+e+f+g, h);
		System.arraycopy(numSyFws, 0, lastArr, a+b+c+d+e+f+g+h, ii);
		System.arraycopy(numBzdzs, 0, lastArr, a+b+c+d+e+f+g+h+ii, jj);
		for (int t = 0; t < lastArr.length; t++) {
			Integer temp = (Integer)lastArr[t];
			if (temp != null) {
				if (max < temp) {
					max = temp;
				}
			}
		}
		
		int num = list.size();
		Object[] values = new Object[num];
		
		//draw
		for (int i = 0; i < list.size(); i++) {
			TjSyrk vo = (TjSyrk)list.get(i);
			Map<String, Object> valMap = new HashMap<String, Object>();
			//设置折线图1的类型
			valMap.put("type", "line");
			//设置折线图1的颜色
			String color[] = {"#AE00AE", "#00A600", "#930000", "#0000C6", "#FF5809", "#842B00", "#6C3365", "#5B4B00", "#548C00", "#5151A2"};
			valMap.put("colour", color[i]);
			//设置折线图的标题
			String text = vo.getFlag() + "(注销)";
			if ("0".equals(vo.getIsZx())) {
				text = vo.getFlag() + "(新增)";
			} 
			valMap.put("text", text);
			//设置折线图1的框显示内容
			//valMap.put("tip", "数量：#val#");
			//设置折线图1的显示特效
			valMap.put("on-show", xtc1);
			//设置折线逗点样式、事件
			Map<String, Object> ss = new HashMap<String, Object>();
			ss.put("type", "solid-dot");
			ss.put("dot-size", 3);
			ss.put("halo-size", 1);
			ss.put("hollow", "false");
			ss.put("tip", "#val#<br>" +  text);
			//s.put("colour", "#C95653");
			//s.put("on-click", "parent.HomePage.test('" + vo.getFlag() + "', '" + dateStr + "')");
			//设置折线图1的点的显示方法
			valMap.put("dot-style", ss);
			//设置线加宽
			valMap.put("width", 3);
			//填充数据
			if ("实有人口".equals(vo.getFlag())) {
				if ("0".equals(vo.getIsZx())) {
					valMap.put("values", numSyrk);
				} else {
					valMap.put("values", numSyrks);
				}
				
			} else if ("重点人员".equals(vo.getFlag())) {
				if ("0".equals(vo.getIsZx())) {
					valMap.put("values", numZdry);
				} else {
					valMap.put("values", numZdrys);
				}
				
			} else if ("实有单位".equals(vo.getFlag())) {
				if ("0".equals(vo.getIsZx())) {
					valMap.put("values", numSydw);
				} else {
					valMap.put("values", numSydws);
				}
			} else if ("实有房屋".equals(vo.getFlag())) {
				if ("0".equals(vo.getIsZx())) {
					valMap.put("values", numSyFw);
				} else {
					valMap.put("values", numSyFws);
				}
			} else if ("标准地址".equals(vo.getFlag())) {
				if ("0".equals(vo.getIsZx())) {
					valMap.put("values", numBzdz);
				} else {
					valMap.put("values", numBzdzs);
				}
				
			} 
			values[i] = valMap;
		}
		//创建一个Flash折线图Map对象
		Map<String, Object> returnMap = new HashMap<String, Object>();
		//创建一个折线图标题Map对象
		Map<String, Object> titleMap = new HashMap<String, Object>();
		String lab = null;
		if (!StringUtils.isBlank(dateStr)) {
			if ("month".equals(dateStr)) {
				//设置Flash图的标题
				titleMap.put("text", "本年各月份统计结果");
				//设置Flash图的格式
				titleMap.put("style", "font-size:14px;");
				//将标题添加到OFC对象中
				returnMap.put("title", titleMap);
				//设置折线图X轴的标签所现实的值
				SimpleDateFormat sf = new SimpleDateFormat("yyyy");
				String x = sf.format(new Date());
				StringBuffer y = new StringBuffer();
				for (int j = 1; j <= 12; j++) {
					y = y.append(x).append("-").append(j).append(",");
				}
				lab = y.substring(0, y.lastIndexOf(","));
			} else if("day".equals(dateStr)){
				//设置Flash图的标题
				titleMap.put("text", "本月每日统计结果");
				//设置Flash图的格式
				titleMap.put("style", "font-size:14px;");
				//将标题添加到OFC对象中
				returnMap.put("title", titleMap);
				//设置折线图X轴的标签所现实的值
				lab = this.getThisDay();
			} else if("quarter".equals(dateStr)){
				//设置Flash图的标题
				titleMap.put("text", "本年各季度统计结果");
				//设置Flash图的格式
				titleMap.put("style", "font-size:14px;");
				//将标题添加到OFC对象中
				returnMap.put("title", titleMap);
				//设置折线图X轴的标签所现实的值
				lab = "第一季度, 第二季度, 第三季度, 第四季度";
			} else if("week".equals(dateStr)){
				//设置Flash图的标题
				titleMap.put("text", "本周统计结果");
				//设置Flash图的格式
				titleMap.put("style", "font-size:14px;");
				//将标题添加到OFC对象中
				returnMap.put("title", titleMap);
				//设置折线图X轴的标签所现实的值
				lab = "星期一, 星期二, 星期三, 星期四, 星期五, 星期六, 星期日";
			}
		}
		//创建一个折线图X轴Map对象
		Map<String, Object> xaxisMap = new HashMap<String, Object>();
		Map<String, Object> xaxisMap2 = new HashMap<String, Object>();
		String labs[] = lab.split(",");
		xaxisMap2.put("labels",labs);
		xaxisMap.put("labels",xaxisMap2);
		//设置X轴3D效果
		xaxisMap.put("3d","7");
		//设置X轴颜色
		xaxisMap.put("colour","#959797");
		//创建一个折线图Y轴Map对象
		Map<String, Object> yaxisMap = new HashMap<String, Object>();
		//设置Y轴值的增长幅度（相应的参数所表示的依次为：最大值，最小值，间隔值）
		yaxisMap.put("max", max+1);
		yaxisMap.put("min", "0");
		yaxisMap.put("steps", max>5 ? max/5 : max);
		//设置Y轴颜色
		yaxisMap.put("colour", "#959797");
		//将X轴添加到OFC对象中
		returnMap.put("x_axis",xaxisMap);
		//将Y轴添加到OFC对象中
		returnMap.put("y_axis",yaxisMap);
		//拼装折线
		Object[] elementsObject = values;
		returnMap.put("elements", elementsObject);
		//设置Flash折线图Map对象的背景颜色
		returnMap.put("bg_colour", "#FFFFFF");
		//test
		//String t =  new Gson().toJson(returnMap);
		//System.out.println(t);
		return returnMap;
	}
	/**
	 * @Title: queryZdrkMap 
	 * @描述: 重点人口撒点
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2014-10-29 下午5:43:41 
	 * @throws
	 */
	public List<ZzjgVo> queryZdrkMap(Map<String, Object> map) {
		return homePageDao.queryZdrkMap(map);
	}
	/**
	 * @Title: queryPcs 
	 * @描述: 查询所有派出所代码
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2014-11-21 下午5:23:39 
	 * @throws
	 */
	public List<ZzjgVo> queryPcs() {
		return homePageDao.queryPcs();
	}
	
	//begin
	/**
	 * @Title: queryXjList 
	 * @描述: 查询巡警坐标详情 
	 * @参数: 传入参数定义 
	 * @日期： 2015-2-1 下午8:33:46 
	 * @返回值: List<LogInfo>    返回类型 
	 * @throws
	 */
	public List<TjSyrk> queryXjList(Map<String, Object> param) {
		return homePageDao.queryXjList(param);
	}
	
	/**
	 * @Title: queryXjZzjgxj 
	 * @描述: 获取分局组织机构
	 * @参数: 传入参数定义  
	 * @throws
	 */
	public List<ZzjgVo> queryXjZzjgxj(String zzjgdm) {
		return homePageDao.queryXjZzjgxj(zzjgdm);
	}
	
	/**
	 * @Title: queryXjZzjgxj 
	 * @描述: 获取分局组织机构
	 * @参数: 传入参数定义  
	 * @throws
	 */
	public List<Org_Organization> downMap(String orgcode) {
		List<Org_Organization> lists = new ArrayList<Org_Organization>();
		lists = homePageDao.queryTree("", orgcode, "into");
		return lists;
	}
	
	
	
	/**
     * @Title: jqChart 
     * @描述: 警情统计饼状图
     * @参数: 传入参数定义 
     * @日期： 2014-7-9 下午9:02:51 
     * @throws
     */
	public Map<String, Object> jqChart(String zzgjdm) {
		//创建一个Flash统计图Map返回对象
		Map<String, Object> returnMap = new HashMap<String, Object>();
		//创建一个Flash统计图Map对象
		Map<String, Object> elements = new HashMap<String, Object>();
		elements.put("type", "pie");
		elements.put("alpha", 1);
		elements.put("start-angle", 35);
		Map<String,String> mapan = new HashMap<String,String>();
        mapan.put("type", "fade");
        Map<String,Object> mapantype = new HashMap<String,Object>();	
        mapantype.put("type", "bounce");
        mapantype.put("distance", 5);
        Object[] animates = {mapan,mapantype};
		elements.put("animate", animates);
		String[] colours = {"#85d021","#ffb543","#ff7a7b","#4dc2ed","#ee431b","#e96a3b"};
		elements.put("colours", colours);
		//elements.put("gradient-fill", 2);
		elements.put("tip", "#label# <br> #val# / #total#<br> 占总数的 #percent#");
		//加载数据
		List<TjSyrk> list = homePageDao.jqChart(zzgjdm);
		int lszs = list.size();
		Integer zs = 0;
		Object[] values = new Object[lszs];
		for(int i=0;i<lszs;i++){
			TjSyrk vo = list.get(i);
			Map<String, Object> valMap = new HashMap<String, Object>();
			valMap.put("value", Integer.parseInt(vo.getSl()));
			valMap.put("label", vo.getLxmc()+"("+vo.getSl()+")");
			valMap.put("font-size", "12");
			//valMap.put("on-click", "parent.HomePage.syrkListMBR(" + zzgjdm + "," + vo.getLx() + ");");
			//valMap.put("on-click", "parent.HomePage.syrkListMBR('"+zzgjdm+"^" + vo.getLx()+"')");
			values[i] = valMap;
			zs += Integer.parseInt(vo.getSl());
		}
		//String titletext = "<a href='javascript:parent.HomePage.syrkBzdzMain()' style='color: blue;'>辖区内实有人口类型统计图("+zs+")</a>";
		String temp = "";
		if (zzgjdm.indexOf("jqChart") != -1) {
			temp = "警情统计图";
		} else if(zzgjdm.indexOf("ajChart") != -1) {
			temp = "案件统计图";
		} else if(zzgjdm.indexOf("kxxChart") != -1) {
			temp = "可行性案件统计图";
		} else if(zzgjdm.indexOf("sjChart") != -1) {
			temp = "事件统计图";
		}
		String titletext = temp + "("+zs+")";
		Map<String, Object> title = new HashMap<String, Object>();
		title.put("text", titletext);
		title.put("style", "width: 100%;font-size:18px;color: #000000;");
		//将数据放入统计图中
		elements.put("values", values);
		Object[] elementsObject = {elements};
		returnMap.put("elements", elementsObject);
		returnMap.put("title", title);
		returnMap.put("bg_colour", "#FFFFFF");//背景色
		//test
		//String t =  new Gson().toJson(returnMap);
		//System.out.println(t);
		return returnMap;
	}
	
	/**
	 * @Title: queryXly 
	 * @描述: 获取巡逻员角色的统计
	 * @参数: 传入参数定义  
	 * @throws
	 */
	public List<Xjtjemployee> queryXly(Map<String,Object> param) {
		return homePageDao.queryXly(param);
	}
	
	/**
	 * @Title: queryCar 
	 * @描述: 获取巡逻员角色的统计
	 * @参数: 传入参数定义  
	 * @throws
	 */
	public List<Xjtjcar> queryCar(Map<String,Object> param) {
		return homePageDao.queryCar(param);
	}
	
	/**
	 * @Title: queryXq 
	 * @描述: 获取巡逻员角色的统计
	 * @参数: 传入参数定义  
	 * @throws
	 */
	public List<XjtjXq> queryXq(Map<String,Object> param) {
		return homePageDao.queryXq(param);
	}
	
	@Override
	public EasyUIPage queryXly(EasyUIPage page, Map<String,Object> param) {
		param.put("begin", page.getBegin());
		param.put("end", page.getEnd());
		String sort = page.getSort();
		String order = page.getOrder();
		if (StringUtils.isBlank(sort)) {
			sort = "score";
			order = "desc";
		}
		//param.put("sort", sort);
		//param.put("order", order);
		 String zzjgdm = (String) param.get("orgcode");
		 String zero8 = zzjgdm.substring(zzjgdm.length()-8, zzjgdm.length());
		 String zero6 = zzjgdm.substring(zzjgdm.length()-6, zzjgdm.length());
		 String zero4 = zzjgdm.substring(zzjgdm.length()-4, zzjgdm.length());
		 if (zero8.equals("00000000")) {
			 param.put("qFlag", "FJ");
		 } else if(zero6.equals("000000")){
			 param.put("qFlag", "PCS");
		 } else if(!zero8.equals("00000000") && !zero6.equals("000000") && !zero4.equals("0000")){
			 param.put("qFlag", "ZRQ");
		 }
		String type = param.get("type").toString();
		if ("1".equals(type)) {
			List<?> list = homePageDao.queryXly(param);
			page.setRows(list);
			int count = homePageDao.queryXlyCount(param);
			page.setTotal(count);
		} else if("2".equals(type)) {
			List<?> list = homePageDao.queryCar(param);
			page.setRows(list);
			int count = homePageDao.queryCarCount(param);
			page.setTotal(count);
		} else if("3".equals(type)) {
			List<?> list = homePageDao.queryXq(param);
			page.setRows(list);
			int count = homePageDao.queryXqCount(param);
			page.setTotal(count);
		}
		return page;
	}
	
	@Override
	public EasyUIPage queryXllx(EasyUIPage page, Map<String,Object> param) {
		param.put("begin", page.getBegin());
		param.put("end", page.getEnd());
//		String sort = page.getSort();
//		String order = page.getOrder();
//		if (StringUtils.isBlank(sort)) {
//			sort = "score";
//			order = "desc";
//		}
//		map.put("sort", sort);
//		map.put("order", order);
		String childrn = ""+param.get("isChild");
		if ("ok".equals(childrn)) {
			List<?> list = homePageDao.queryXllxs(param);
			page.setRows(list);
			page.setTotal(list.size());
		} else {
			List<?> list = homePageDao.queryXllx(param);
			page.setRows(list);
			int count = homePageDao.queryXllxCount(param);
			page.setTotal(count);
		}
		
		return page;
	}
	
	/**
	 * @Title: querySZ 
	 * @描述: 获取设置
	 * @参数: 传入参数定义 
	 * @日期： 2014-12-15 上午11:20:21 
	 * @throws
	 */
	public List<XJSZ> querySZ(Map<String, Object> map) {
		return homePageDao.querySZ(map);
	}
	
	/**
	 * @Title: uptSZ 
	 * @描述: 修改设置
	 * @参数: 传入参数定义 
	 * @日期： 2014-12-15 上午11:20:21 
	 * @throws
	 */
	public int uptSZ(Map<String, Object> map) {
		return homePageDao.uptSZ(map);
	}
	
	/**
	 * @Title: addSZ 
	 * @描述: 修改设置
	 * @参数: 传入参数定义 
	 * @日期： 2014-12-15 上午11:20:21 
	 * @throws
	 */
	public int addSZ(Map<String, Object> map) {
		return homePageDao.addSZ(map);
	}
	//end
	
	//jz begin
	/**
     * @Title: sydwChart 
     * @描述: 实有人单位饼状图
     * @参数: 传入参数定义 
     * @日期： 2014-7-9 下午9:02:51 
     * @throws
     */
	public Map<String, Object> sydwChart(String zzgjdm) {
		//创建一个Flash统计图Map返回对象
		Map<String, Object> returnMap = new HashMap<String, Object>();
		//创建一个Flash统计图Map对象
		Map<String, Object> elements = new HashMap<String, Object>();
		elements.put("type", "pie");
		elements.put("alpha", 1);
		elements.put("start-angle", 35);
		Map<String,String> mapan = new HashMap<String,String>();
        mapan.put("type", "fade");
        Map<String,Object> mapantype = new HashMap<String,Object>();	
        mapantype.put("type", "bounce");
        mapantype.put("distance", 5);
        Object[] animates = {mapan,mapantype};
		elements.put("animate", animates);
		String[] colours = {"#85d021","#ffb543","#ff7a7b","#4dc2ed","#ee431b","#e96a3b"};
		elements.put("colours", colours);
		//elements.put("gradient-fill", 2);
		elements.put("tip", "#label# <br> #val# / #total#<br> 占总数的 #percent#");
		//加载数据
		//增加局长页面柱状图判断 begin
		Map<String, Object> map = new HashMap<String, Object>();
		String orgcode = "";
		if (zzgjdm.indexOf("~") != -1) {
			orgcode = zzgjdm.substring(0, zzgjdm.length()-1);
			map.put("zzjgdm", orgcode);
			map.put("type", "jzChart");
		} else {
			orgcode = zzgjdm;
			map.put("zzjgdm", orgcode);
			map.put("type", "");
		}
		String zero8 = orgcode.substring(orgcode.length()-8, orgcode.length());
	    String zero6 = orgcode.substring(orgcode.length()-6, orgcode.length());
	    String zero4 = orgcode.substring(orgcode.length()-4, orgcode.length());
		if (zero8.equals("00000000")) {
			map.put("flag", "FJ");
		} else if(zero6.equals("000000")){
			map.put("flag", "PCS");
		}else if(zero4.equals("0000")){
			map.put("flag", "ZRQ");
		}
		//增加局长页面柱状图判断 end
		List<TjSyrk> list = homePageDao.sydwChart(map);
		int lszs = list.size();
		Integer zs = 0;
		Object[] values = new Object[lszs];
		for(int i=0;i<lszs;i++){
			TjSyrk vo = list.get(i);
			Map<String, Object> valMap = new HashMap<String, Object>();
			valMap.put("value", Integer.parseInt(vo.getSl()));
			valMap.put("label", vo.getLxmc()+"("+vo.getSl()+")");
			valMap.put("font-size", "12");
			//valMap.put("on-click", "parent.HomePage.syrkListMBR('"+Integer.parseInt(vo.getLx())+"')");
			values[i] = valMap;
			zs += Integer.parseInt(vo.getSl());
		}
		String titletext = "";
		//局长不点击 
		if (zzgjdm.indexOf("~") != -1) {
			titletext = "辖区内实有单位类型统计图("+zs+")";
		} else {
			titletext = "辖区内实有人口类型统计图("+zs+")";
		}
		Map<String, Object> title = new HashMap<String, Object>();
		title.put("text", titletext);
		title.put("style", "width: 100%;font-size:18px;color: #000000;");
		//将数据放入统计图中
		elements.put("values", values);
		Object[] elementsObject = {elements};
		returnMap.put("elements", elementsObject);
		returnMap.put("title", title);
		returnMap.put("bg_colour", "#FFFFFF");//背景色
		return returnMap;
	}
	
	/**
     * @Title: syfwChart 
     * @描述: 实有房屋饼状图
     * @作者: zhang_guoliang@founder.com 
     * @参数: 传入参数定义 
     * @日期： 2014-7-9 下午9:02:51 
     * @throws
     */
	public Map<String, Object> syfwChart(String zzgjdm) {
		//创建一个Flash统计图Map返回对象
		Map<String, Object> returnMap = new HashMap<String, Object>();
		//创建一个Flash统计图Map对象
		Map<String, Object> elements = new HashMap<String, Object>();
		elements.put("type", "pie");
		elements.put("alpha", 1);
		elements.put("start-angle", 35);
		Map<String,String> mapan = new HashMap<String,String>();
        mapan.put("type", "fade");
        Map<String,Object> mapantype = new HashMap<String,Object>();	
        mapantype.put("type", "bounce");
        mapantype.put("distance", 5);
        Object[] animates = {mapan,mapantype};
		elements.put("animate", animates);
		String[] colours = {"#85d021","#ffb543","#ff7a7b","#4dc2ed","#ee431b","#e96a3b"};
		elements.put("colours", colours);
		//elements.put("gradient-fill", 2);
		elements.put("tip", "#label# <br> #val# / #total#<br> 占总数的 #percent#");
		//加载数据
		//增加局长页面柱状图判断 begin
		Map<String, Object> map = new HashMap<String, Object>();
		String orgcode = "";
		if (zzgjdm.indexOf("~") != -1) {
			orgcode = zzgjdm.substring(0, zzgjdm.length()-1);
			map.put("zzjgdm", orgcode);
			map.put("type", "jzChart");
		} else {
			orgcode = zzgjdm;
			map.put("zzjgdm", orgcode);
			map.put("type", "");
		}
		String zero8 = orgcode.substring(orgcode.length()-8, orgcode.length());
	    String zero6 = orgcode.substring(orgcode.length()-6, orgcode.length());
	    String zero4 = orgcode.substring(orgcode.length()-4, orgcode.length());
		if (zero8.equals("00000000")) {
			map.put("flag", "FJ");
		} else if(zero6.equals("000000")){
			map.put("flag", "PCS");
		}else if(zero4.equals("0000")){
			map.put("flag", "ZRQ");
		}
		//增加局长页面柱状图判断 end
		List<TjSyrk> list = homePageDao.syfwChart(map);
		int lszs = list.size();
		Integer zs = 0;
		Object[] values = new Object[lszs];
		for(int i=0;i<lszs;i++){
			TjSyrk vo = list.get(i);
			Map<String, Object> valMap = new HashMap<String, Object>();
			valMap.put("value", Integer.parseInt(vo.getSl()));
			valMap.put("label", vo.getLxmc()+"("+vo.getSl()+")");
			valMap.put("font-size", "12");
			//valMap.put("on-click", "parent.HomePage.syrkListMBR('"+Integer.parseInt(vo.getLx())+"')");
			values[i] = valMap;
			zs += Integer.parseInt(vo.getSl());
		}
		String titletext = "";
		//局长不点击 
		if (zzgjdm.indexOf("~") != -1) {
			titletext = "辖区内实有房屋类型统计图("+zs+")";
		} else {
			titletext = "辖区内实有人口类型统计图("+zs+")";
		}
		Map<String, Object> title = new HashMap<String, Object>();
		title.put("text", titletext);
		title.put("style", "width: 100%;font-size:18px;color: #000000;");
		//将数据放入统计图中
		elements.put("values", values);
		Object[] elementsObject = {elements};
		returnMap.put("elements", elementsObject);
		returnMap.put("title", title);
		returnMap.put("bg_colour", "#FFFFFF");//背景色
		return returnMap;
	}
	//jz end
	@Override
	public Map<String, Object> queryzrqtj(Map<String, Object> paramMap) {
		// TODO Auto-generated method stub
		//统计实有人口的
		List<ZzjgVo> zzjg = homePageDao.queryPcsTj(paramMap);
		//统计实有重点人口
		List<ZdryCountVo> zdry = homePageDao.queryZdryTj(paramMap);
		//统计房屋的
		long czf = homePageDao.queryCzfTj(paramMap);
		long checkf = homePageDao.queryCheckTj(paramMap);
		//long uncheckf = homePageDao.queryunCheckTj(paramMap);
		//统计治安管理的
		Map<String, Object> resMap = new HashMap<String, Object>();
		resMap.put("zzjg", zzjg);
		resMap.put("zdry", zdry);
		resMap.put("czf", czf);
		resMap.put("checkf", checkf);
		return resMap;
	}
	
}