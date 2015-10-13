package com.founder.ldym.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.mvel2.util.ArrayTools;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.annotation.RestfulAnnotation;
import com.founder.framework.base.controller.BaseController;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.components.AppConst;
import com.founder.framework.exception.BussinessException;
import com.founder.framework.message.bean.SysMessage;
import com.founder.framework.message.service.SysMessageService;
import com.founder.framework.utils.DateUtils;
import com.founder.framework.utils.EasyUIPage;
import com.founder.gzjk.bean.Gzltjb;
import com.founder.sqjw.bean.TjSyrk;



/**
 * @author crh 
 * 领导页面演示 临时用 假页面  演示过后删除
 *
 */
@Controller
@RequestMapping(value = "/ldym")
public class LdymysController extends BaseController {

	private Logger logger = Logger.getLogger(this.getClass());

	@Resource(name = "sysMessageService")
	private SysMessageService sysMessageService;


	/**
	 * 查询任务消息
	 * 
	 * @return
	 */
	@RequestMapping(value = "/searchTask", method = RequestMethod.GET)
	public @ResponseBody
	ModelAndView searchTask() {
		ModelAndView mv = new ModelAndView("ldym/firstPage_wfTask");
		SessionBean sessionBean = getSessionBean();
		String userid = "";
		String orgcode = "";
		if (null != sessionBean) {
			userid = sessionBean.getUserId();
			orgcode = sessionBean.getUserOrgCode();

		}
		Map<String, Object> map = new HashMap<String, Object>();
		SysMessage sysMessage = new SysMessage();
		sysMessage.setJsrdm(userid);
		sysMessage.setJsrssdwdm(orgcode);
		sysMessage.setXxlb("2");
		map.put("sysMessage", sysMessage);
		List<SysMessage> taskList = sysMessageService.searchMessage(map);
		SysMessage sys=new SysMessage();
		sys.setSfck("0");
		sys.setXxlb("2");
		sys.setXxbt("人员联系电话真实性协同");
		sys.setXxnr("白山路派出所解放责任区2李长荣把张海录入为该辖区实有人口");
		sys.setFssj("2015-01-01 10:12:12");
		sys.setYwurl("baidu");
		taskList.add(sys);
		mv.addObject("taskList", taskList);
		return mv;
	}

	@RequestMapping(value = "/querySyrkChart", method = RequestMethod.GET)
	public @ResponseBody
	Map<String, Object> querySyrkChart(String zzjgdm) {
		

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
	    String zero4 = orgcode.substring(orgcode.length()-4, orgcode.length());
		if (zero8.equals("00000000")) {
			map.put("flag", "FJ");
		} else if(zero6.equals("000000")){
			map.put("flag", "PCS");
		}else if(zero4.equals("0000")){
			map.put("flag", "ZRQ");
		}
		//增加局长页面柱状图判断 end
		List<TjSyrk> list = new ArrayList<TjSyrk>();
		TjSyrk cz=new TjSyrk();
		cz.setSl("1560");
		cz.setLx("1");
		cz.setLxmc("常住人口");
		
		TjSyrk jz=new TjSyrk();
		jz.setSl("1000");
		jz.setLx("2");
		jz.setLxmc("寄住人口");
		
		TjSyrk ld=new TjSyrk();
		ld.setSl("980");
		ld.setLx("3");
		ld.setLxmc("流动人口");
		
		TjSyrk jw=new TjSyrk();
		jw.setSl("240");
		jw.setLx("4");
		jw.setLxmc("境外人员");
		
		TjSyrk wlh=new TjSyrk();
		wlh.setSl("10");
		wlh.setLx("5");
		wlh.setLxmc("未落户人员");
		
		list.add(cz);
		list.add(jz);
		list.add(ld);
		list.add(jw);
		list.add(wlh);
	
		
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
		if (zzjgdm.indexOf("~") != -1) {
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
	
	@RequestMapping(value = "/queryGzdxChart", method = RequestMethod.GET)
	public @ResponseBody
	Map<String, Object> queryGzdxChart(String zzjgdm) {

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
		List<TjSyrk> gzdxList = new ArrayList<TjSyrk>();
		TjSyrk jgdx=new TjSyrk();
		jgdx.setSl("10");
		jgdx.setLxmc("监管对象");
		TjSyrk zdrk=new TjSyrk();
		zdrk.setSl("3");
		zdrk.setLxmc("重点人口");
		TjSyrk zszhjsbr=new TjSyrk();
		zszhjsbr.setSl("5");
		zszhjsbr.setLxmc("肇事肇祸精神病人");
		TjSyrk fzcsf=new TjSyrk();
		fzcsf.setSl("1");
		fzcsf.setLxmc("非正常上访人员");
		TjSyrk nrsx=new TjSyrk();
		nrsx.setSl("2");
		nrsx.setLxmc("纳入视线对象");
		TjSyrk fxdx=new TjSyrk();
		fxdx.setSl("20");
		fxdx.setLxmc("放心对象");
		
		gzdxList.add(jgdx);
		gzdxList.add(zdrk);
		gzdxList.add(zszhjsbr);
		gzdxList.add(fzcsf);
		gzdxList.add(nrsx);
		gzdxList.add(fxdx);

		//柱状颜色
		Object[] colors = {"#85d021","#4dc2ed","#ee431b","#e96a3b","#ee9539","#fdbe63","#f1e740","#ffb543","#ff7a7b","#008080","#AA4400","#0000FF"};
		//生命对应值和名称
		int lszs = gzdxList.size();
		Object[] values = new Object[lszs];
		String[] labels = new String[lszs];
		Object[] valuestags =  new Object[lszs];
		Integer max = 10;
		Integer zs = 0;
		for(int i=0;i<lszs;i++){
			if(i<gzdxList.size()){
				TjSyrk vo = gzdxList.get(i);
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
			TjSyrk val = gzdxList.get(i);
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
	
	@RequestMapping(value = "/queryLdrkChart", method = RequestMethod.GET)
	public @ResponseBody
	Map<String, Object> queryLdrkChart(String zzjgdm) {

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
		List<TjSyrk> ldrkList = new ArrayList<TjSyrk>();
		TjSyrk ld1=new TjSyrk();
		ld1.setSl("1068");
		ld1.setLxmc("辽宁");
		
		TjSyrk ld2=new TjSyrk();
		ld2.setSl("28");
		ld2.setLxmc("安徽");
		
		TjSyrk ld3=new TjSyrk();
		ld3.setSl("108");
		ld3.setLxmc("湖北");
		
		TjSyrk ld4=new TjSyrk();
		ld4.setSl("5");
		ld4.setLxmc("云南");
		
		TjSyrk ld5=new TjSyrk();
		ld5.setSl("7");
		ld5.setLxmc("四川");
		
		TjSyrk ld6=new TjSyrk();
		ld6.setSl("8");
		ld6.setLxmc("贵州");
		
		TjSyrk ld7=new TjSyrk();
		ld7.setSl("106");
		ld7.setLxmc("山东");
		
		TjSyrk ld8=new TjSyrk();
		ld8.setSl("15");
		ld8.setLxmc("海南");
		
		TjSyrk ld9=new TjSyrk();
		ld9.setSl("26");
		ld9.setLxmc("吉林");
		
		TjSyrk ld10=new TjSyrk();
		ld10.setSl("48");
		ld10.setLxmc("黑龙江");	
		
		ldrkList.add(ld10);
		ldrkList.add(ld9);
		ldrkList.add(ld8);
		ldrkList.add(ld7);
		ldrkList.add(ld6);
		ldrkList.add(ld5);
		ldrkList.add(ld4);
		ldrkList.add(ld3);
		ldrkList.add(ld2);
		ldrkList.add(ld1);
		
		
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

	
	@RequestMapping(value = "/queryNlChart", method = RequestMethod.GET)
	public @ResponseBody
	Map<String, Object> queryNlChart(String zzjgdm) {

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
		List<TjSyrk> list =new ArrayList<TjSyrk>();
		TjSyrk nl1=new TjSyrk();
		nl1.setSl("231");
		nl1.setLxmc("18以下");
		TjSyrk nl2=new TjSyrk();
		nl2.setSl("1087");
		nl2.setLxmc("18~59");
		TjSyrk nl3=new TjSyrk();
		nl3.setSl("325");
		nl3.setLxmc("59以上");
		
		list.add(nl1);
		list.add(nl2);
		list.add(nl3);
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
	 * 领导页面工作量统计
	 * 
	 * @return
	 */
	@RequestMapping(value = "/count", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, Object> gzltj() {

		Map<String, Object> resMap = new HashMap<String, Object>();// 返回用

		List<Gzl> list = new ArrayList<Gzl>();
		Gzl gzl1=new Gzl();
		gzl1.setSyrkAdd("770");
		gzl1.setSyrkUpdate("102");
		gzl1.setSyrkDelete("90" );
		gzl1.setSydwAdd("345");
		gzl1.setSydwUpdate("34");
		gzl1.setSydwDelete("20");
		gzl1.setSyfwAdd("540");
		gzl1.setSyfwUpdate("23");
		gzl1.setSyfwDelete("6");
		gzl1.setGxfjname("旅顺分局");
		
		Gzl gzl2=new Gzl();
		gzl2.setSyrkAdd("770");
		gzl2.setSyrkUpdate("102");
		gzl2.setSyrkDelete("90" );
		gzl2.setSydwAdd("345");
		gzl2.setSydwUpdate("34");
		gzl2.setSydwDelete("20");
		gzl2.setSyfwAdd("540");
		gzl2.setSyfwUpdate("23");
		gzl2.setSyfwDelete("6");
		gzl2.setGxfjname("沙河口分局");

		Gzl gzl3=new Gzl();
		gzl3.setSyrkAdd("340");
		gzl3.setSyrkUpdate("112");
		gzl3.setSyrkDelete("93" );
		gzl3.setSydwAdd("645");
		gzl3.setSydwUpdate("14");
		gzl3.setSydwDelete("44");
		gzl3.setSyfwAdd("585");
		gzl3.setSyfwUpdate("234");
		gzl3.setSyfwDelete("64");
		gzl3.setGxfjname("金州分局");

		
		Gzl gzl4=new Gzl();
		gzl4.setSyrkAdd("640");
		gzl4.setSyrkUpdate("112");
		gzl4.setSyrkDelete("320" );
		gzl4.setSydwAdd("315");
		gzl4.setSydwUpdate("30");
		gzl4.setSydwDelete("21");
		gzl4.setSyfwAdd("530");
		gzl4.setSyfwUpdate("21");
		gzl4.setSyfwDelete("3");
		gzl4.setGxfjname("甘井子分局");

		
		Gzl gzl5=new Gzl();
		gzl5.setSyrkAdd("1000");
		gzl5.setSyrkUpdate("101");
		gzl5.setSyrkDelete("120" );
		gzl5.setSydwAdd("123");
		gzl5.setSydwUpdate("234");
		gzl5.setSydwDelete("42");
		gzl5.setSyfwAdd("540");
		gzl5.setSyfwUpdate("23");
		gzl5.setSyfwDelete("7");
		gzl5.setGxfjname("中山分局");

		
		Gzl gzl6=new Gzl();
		gzl6.setSyrkAdd("870");
		gzl6.setSyrkUpdate("143");
		gzl6.setSyrkDelete("91" );
		gzl6.setSydwAdd("432");
		gzl6.setSydwUpdate("31");
		gzl6.setSydwDelete("54");
		gzl6.setSyfwAdd("512");
		gzl6.setSyfwUpdate("23");
		gzl6.setSyfwDelete("9");
		gzl6.setGxfjname("西岗分局");

		
		Gzl gzl7=new Gzl();
		gzl7.setSyrkAdd("960");
		gzl7.setSyrkUpdate("101");
		gzl7.setSyrkDelete("91" );
		gzl7.setSydwAdd("325");
		gzl7.setSydwUpdate("31");
		gzl7.setSydwDelete("25");
		gzl7.setSyfwAdd("450");
		gzl7.setSyfwUpdate("13");
		gzl7.setSyfwDelete("97");
		gzl7.setGxfjname("保税区分局");

		list.add(gzl1);
		list.add(gzl2);
		list.add(gzl3);
		list.add(gzl4);
		list.add(gzl5);
		list.add(gzl6);
		list.add(gzl7);

		resMap.put("rows", list);
		resMap.put("total", list.size());
		return resMap;
	}
	
	public class Gzl {
    
		private String syrkAdd;
		
		private String syrkUpdate;
		
		private String syrkDelete;
		
		private String sydwAdd;
		
		private String sydwUpdate;
		
		private String sydwDelete;
		
		private String syfwAdd;
		
		private String syfwUpdate;
		
		private String syfwDelete;

		private String gxfjname;
		
		
		
		public String getGxfjname() {
			return gxfjname;
		}

		public void setGxfjname(String gxfjname) {
			this.gxfjname = gxfjname;
		}

		public String getSyrkAdd() {
			return syrkAdd;
		}

		public void setSyrkAdd(String syrkAdd) {
			this.syrkAdd = syrkAdd;
		}

		public String getSyrkUpdate() {
			return syrkUpdate;
		}

		public void setSyrkUpdate(String syrkUpdate) {
			this.syrkUpdate = syrkUpdate;
		}

		public String getSyrkDelete() {
			return syrkDelete;
		}

		public void setSyrkDelete(String syrkDelete) {
			this.syrkDelete = syrkDelete;
		}

		public String getSydwAdd() {
			return sydwAdd;
		}

		public void setSydwAdd(String sydwAdd) {
			this.sydwAdd = sydwAdd;
		}

		public String getSydwUpdate() {
			return sydwUpdate;
		}

		public void setSydwUpdate(String sydwUpdate) {
			this.sydwUpdate = sydwUpdate;
		}

		public String getSydwDelete() {
			return sydwDelete;
		}

		public void setSydwDelete(String sydwDelete) {
			this.sydwDelete = sydwDelete;
		}

		public String getSyfwAdd() {
			return syfwAdd;
		}

		public void setSyfwAdd(String syfwAdd) {
			this.syfwAdd = syfwAdd;
		}

		public String getSyfwUpdate() {
			return syfwUpdate;
		}

		public void setSyfwUpdate(String syfwUpdate) {
			this.syfwUpdate = syfwUpdate;
		}

		public String getSyfwDelete() {
			return syfwDelete;
		}

		public void setSyfwDelete(String syfwDelete) {
			this.syfwDelete = syfwDelete;
		}
	
		
	}
	
	@RequestMapping(value = "/yxsjtj", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, Object> yxsjtj() {

		Map<String, Object> resMap = new HashMap<String, Object>();// 返回用

		List<Yxsj> list = new ArrayList<Yxsj>();
		Yxsj yxsj1=new Yxsj();
		yxsj1.setCz("7370");
		yxsj1.setJz("1032");
		yxsj1.setLd("390" );
		yxsj1.setWl("35");
		yxsj1.setJw("334");
		yxsj1.setLdy("203");
		yxsj1.setTzhy("5340");
		yxsj1.setYlcs("232");
		yxsj1.setNbdw("62");
		yxsj1.setSyfw("632");
		yxsj1.setCzfw("36");
		yxsj1.setCzr("54");
		yxsj1.setGxfjname("旅顺分局");
		
		Yxsj yxsj2=new Yxsj();
		yxsj2.setCz("7670");
		yxsj2.setJz("1062");
		yxsj2.setLd("906" );
		yxsj2.setWl("35");
		yxsj2.setJw("346");
		yxsj2.setLdy("206");
		yxsj2.setTzhy("6540");
		yxsj2.setYlcs("263");
		yxsj2.setNbdw("66");
		yxsj2.setSyfw("661");
		yxsj2.setCzfw("87");
		yxsj2.setCzr("45");
		yxsj2.setGxfjname("沙河口分局");

		Yxsj yxsj3=new Yxsj();
		yxsj3.setCz("12220");
		yxsj3.setJz("1102");
		yxsj3.setLd("920" );
		yxsj3.setWl("25");
		yxsj3.setJw("342");
		yxsj3.setLdy("202");
		yxsj3.setTzhy("5240");
		yxsj3.setYlcs("232");
		yxsj3.setNbdw("62");
		yxsj3.setSyfw("611");
		yxsj3.setCzfw("126");
		yxsj3.setCzr("62");
		yxsj3.setGxfjname("金州分局");

		
		Yxsj yxsj4=new Yxsj();
		yxsj4.setCz("7710");
		yxsj4.setJz("1102");
		yxsj4.setLd("910" );
		yxsj4.setWl("15");
		yxsj4.setJw("341");
		yxsj4.setLdy("201");
		yxsj4.setTzhy("5410");
		yxsj4.setYlcs("213");
		yxsj4.setNbdw("61");
		yxsj4.setSyfw("161");
		yxsj4.setCzfw("62");
		yxsj4.setCzr("21");
		yxsj4.setGxfjname("甘井子分局");

		
		Yxsj yxsj5=new Yxsj();
		yxsj5.setCz("7170");
		yxsj5.setJz("1021");
		yxsj5.setLd("910" );
		yxsj5.setWl("14");
		yxsj5.setJw("314");
		yxsj5.setLdy("220");
		yxsj5.setTzhy("5410");
		yxsj5.setYlcs("223");
		yxsj5.setNbdw("32");
		yxsj5.setSyfw("26");
		yxsj5.setCzfw("16");
		yxsj5.setCzr("61");
		yxsj5.setGxfjname("中山分局");

		
		Yxsj yxsj6=new Yxsj();
		yxsj6.setCz("75320");
		yxsj6.setJz("1026");
		yxsj6.setLd("902" );
		yxsj6.setWl("31");
		yxsj6.setJw("314");
		yxsj6.setLdy("201");
		yxsj6.setTzhy("5410");
		yxsj6.setYlcs("213");
		yxsj6.setNbdw("61");
		yxsj6.setSyfw("89");
		yxsj6.setCzfw("26");
		yxsj6.setCzr("31");
		yxsj6.setGxfjname("西岗分局");

		
		Yxsj yxsj7=new Yxsj();
		yxsj7.setCz("7470");
		yxsj7.setJz("1042");
		yxsj7.setLd("904" );
		yxsj7.setWl("45");
		yxsj7.setJw("344");
		yxsj7.setLdy("240");
		yxsj7.setTzhy("5440");
		yxsj7.setYlcs("243");
		yxsj7.setNbdw("64");
		yxsj7.setSyfw("461");
		yxsj7.setCzfw("96");
		yxsj7.setCzr("64");
		yxsj7.setGxfjname("保税区分局");

		list.add(yxsj1);
		list.add(yxsj2);
		list.add(yxsj3);
		list.add(yxsj4);
		list.add(yxsj5);
		list.add(yxsj6);
		list.add(yxsj7);

		resMap.put("rows", list);
		resMap.put("total", list.size());
		return resMap;
	}
	
	public class Yxsj {
		
		private String gxfjname;
		
		private String cz;
		
		private String jz;
		
		private String ld;
		
		private String jw;
		
		private String wl;
		
		private String ldy;
		
		private String tzhy;
		
		private String ylcs;
		
		private String nbdw;
		
		private String syfw;
		
		private String czfw;
		
		private String czr;

		public String getGxfjname() {
			return gxfjname;
		}

		public void setGxfjname(String gxfjname) {
			this.gxfjname = gxfjname;
		}

		public String getCz() {
			return cz;
		}

		public void setCz(String cz) {
			this.cz = cz;
		}

		public String getJz() {
			return jz;
		}

		public void setJz(String jz) {
			this.jz = jz;
		}

		public String getLd() {
			return ld;
		}

		public void setLd(String ld) {
			this.ld = ld;
		}

		public String getJw() {
			return jw;
		}

		public void setJw(String jw) {
			this.jw = jw;
		}

		public String getWl() {
			return wl;
		}

		public void setWl(String wl) {
			this.wl = wl;
		}

		public String getLdy() {
			return ldy;
		}

		public void setLdy(String ldy) {
			this.ldy = ldy;
		}

		public String getTzhy() {
			return tzhy;
		}

		public void setTzhy(String tzhy) {
			this.tzhy = tzhy;
		}

		public String getYlcs() {
			return ylcs;
		}

		public void setYlcs(String ylcs) {
			this.ylcs = ylcs;
		}

		public String getNbdw() {
			return nbdw;
		}

		public void setNbdw(String nbdw) {
			this.nbdw = nbdw;
		}

		public String getSyfw() {
			return syfw;
		}

		public void setSyfw(String syfw) {
			this.syfw = syfw;
		}

		public String getCzfw() {
			return czfw;
		}

		public void setCzfw(String czfw) {
			this.czfw = czfw;
		}

		public String getCzr() {
			return czr;
		}

		public void setCzr(String czr) {
			this.czr = czr;
		}
		
	}
    
}
