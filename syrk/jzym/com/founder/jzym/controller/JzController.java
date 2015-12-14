package com.founder.jzym.controller;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.founder.framework.base.controller.BaseController;
import com.founder.framework.utils.EasyUIPage;
import com.founder.jzym.bean.Jz_jqxxb;
import com.founder.jzym.service.JzService;
import com.founder.jzym.vo.Sf_Organization;
import com.founder.xjpt.vo.ZzjgVo;
/**
 * @类名: JzjcxxController
 * @描述: 局长基础信息
 * 
 */
@Controller
@RequestMapping(value = "jz")
public class JzController extends BaseController {
	@Resource(name = "jzService")
	private JzService jzService;
	
	/**
	 * 警情列表
	 * @param page
	 * @param rows
	 * @param entity
	 * @return
	 */
	@RequestMapping(value = "/queryJq", method = RequestMethod.POST)
	public @ResponseBody
	EasyUIPage queryJq(EasyUIPage page,
			@RequestParam(value = "rows") Integer rows, Jz_jqxxb entity, @RequestParam(value="flag", required=false) String flag) {
		page.setPagePara(rows);
		return jzService.queryJq(page, entity);
	}
	
	/**
	 * 警情列表延迟加载增加的方法
	 * @param page
	 * @param rows
	 * @param entity
	 * @return
	 */
	@RequestMapping(value = "/queryCountJq", method = RequestMethod.POST)
	public @ResponseBody
		long queryCountJq(Jz_jqxxb entity, @RequestParam(value="flag", required=false) String flag) {
		return jzService.queryCountJq(entity);
	}	
	
	/**
	 * @Title: queryJzChart
	 * @描述: 警情柱状图
	 * @参数: 传入参数定义
	 * @返回值: Map<String, Object> 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/queryJzChart", method = RequestMethod.GET)
	public @ResponseBody
	Map<String, Object> queryJzChart(String zzjgdm) {
		String zzjgdms = zzjgdm.substring(0, zzjgdm.indexOf("@"));
		String fqsj = zzjgdm.substring(zzjgdm.indexOf("@")+1, zzjgdm.indexOf("~"));
		String jssj = "";
		String jqlxdm = "";
		String zrq = "";
		if(zzjgdm.indexOf("^") != -1 && zzjgdm.indexOf("`") != -1){
			jssj = zzjgdm.substring(zzjgdm.indexOf("~")+1, zzjgdm.indexOf("^"));
			jqlxdm = zzjgdm.substring(zzjgdm.indexOf("^")+1, zzjgdm.length()-1);
			zrq = "`";
		} else if(zzjgdm.indexOf("^") != -1 && zzjgdm.indexOf("`") == -1){
			jssj = zzjgdm.substring(zzjgdm.indexOf("~")+1, zzjgdm.indexOf("^"));
			jqlxdm = zzjgdm.substring(zzjgdm.indexOf("^")+1, zzjgdm.length());
		} else {
			jssj = zzjgdm.substring(zzjgdm.indexOf("~")+1, zzjgdm.length());
		}
		return jzService.jqChart(zzjgdms, fqsj, jssj, jqlxdm, zrq);
	}
	
	@RequestMapping(value = "/querySsyj", method = RequestMethod.POST)
	public @ResponseBody
	List<ZzjgVo> querySsyu(String zzjgdm) {
		return jzService.querySsyj(zzjgdm);
	}
	
	/**
	 * @Title: downMap
	 * @描述: 四色预警下钻
	 * @参数: 传入参数定义
	 * @返回值: List<Sf_Organization> 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/downMap", method = RequestMethod.POST)
	public @ResponseBody
	List<Sf_Organization> downMap(Sf_Organization sf) {
		String orgcode = sf.getOrgcode();
		List<Sf_Organization> list = jzService.downMap(orgcode);
		 String zero8 = orgcode.substring(orgcode.length()-8, orgcode.length());
		 String zero6 = orgcode.substring(orgcode.length()-6, orgcode.length());
		 String zero4 = orgcode.substring(orgcode.length()-4, orgcode.length());
		 if (zero8.equals("00000000")) {
			 Sf_Organization org = new Sf_Organization();
			 for (int i = 0; i < list.size(); i++) {
				org = (Sf_Organization)list.get(i);
				String temp = org.getOrgcode().substring(org.getOrgcode().length()-8, org.getOrgcode().length());
				if (("00000000").equals(temp)) {
					list.remove(i);
				} 
			}
		 } else if(zero6.equals("000000")){
			 Sf_Organization org = new Sf_Organization();
			 for (int i = 0; i < list.size(); i++) {
				    org = (Sf_Organization)list.get(i);
				    String temp = org.getOrgcode().substring(org.getOrgcode().length()-6, org.getOrgcode().length());
					if (("000000").equals(temp)) {
						list.remove(i);
					} 
				}
		 } else if(!zero8.equals("00000000") && !zero6.equals("000000") && zero4.equals("0000")){
			 Sf_Organization org = new Sf_Organization();
			 for (int i = 0; i < list.size(); i++) {
				 org = (Sf_Organization)list.get(i);
				 String temp = org.getOrgcode().substring(org.getOrgcode().length()-4, org.getOrgcode().length());
					if (("0000").equals(temp)) {
						list.remove(i);
					} 
				}
		 }
		 return list;
	}
	
	/**
	 * @Title: queryXjZzjgxj
	 * @描述: 获取四色预警算法
	 * @参数: 传入参数定义
	 * @返回值: List<ZzjgVo> 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/queryXjZzjgxjs", method = RequestMethod.POST)
	public @ResponseBody
	List<Sf_Organization> queryXjZzjgxjs(String zzjgdm, Sf_Organization sf) {
		List<Sf_Organization> list = new ArrayList<Sf_Organization>();
		list = jzService.queryXjZzjgxj(zzjgdm);
		//获取四色预警算法结果
		List<Sf_Organization> li = new ArrayList<Sf_Organization>();
		li = jzService.querySf(sf);
		List<Sf_Organization> last = new ArrayList<Sf_Organization>();
		for (int i = 0; i < list.size(); i++) {
			Sf_Organization s = (Sf_Organization)list.get(i);
			String orgcode = s.getZzjgdm();
			for (int j = 0; j < li.size(); j++) {
				Sf_Organization ss = (Sf_Organization)li.get(j);
				String orgcodes = ss.getOrgcode();
				if(orgcodes.equals(orgcode)){
					s.setColor(ss.getColor());
				}
			}
			last.add(s);
		}
		
		return last;
	}

	/**
	 * @Title: queryXjZzjgxj
	 * @描述: 获取四色预警新算法
	 * @参数: 传入参数定义
	 * @返回值: List<ZzjgVo> 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/queryXjZzjgxj", method = RequestMethod.POST)
	public @ResponseBody
	List<Sf_Organization> queryXjZzjgxj(String zzjgdm, Sf_Organization sf) {
		//获取组织机构坐标
		List<Sf_Organization> list = new ArrayList<Sf_Organization>();
		list = jzService.queryXjZzjgxj(zzjgdm);
		List<Sf_Organization> last = new ArrayList<Sf_Organization>();
		String orgcode = "";
		String color = "";
		for (int i = 0; i < list.size(); i++) {
			Sf_Organization s = (Sf_Organization)list.get(i);
			orgcode = s.getZzjgdm();
			color = jzService.ssyjColor(orgcode, sf);
			s.setColor(color);
			last.add(s);
		}
		return last;
	}
	
	/**
	 * @Title: querySsyjChart
	 * @描述: 四色预警柱状图
	 * @参数: 传入参数定义
	 * @返回值: Map<String, Object> 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/querySsyjChart", method = RequestMethod.GET)
	public @ResponseBody
	Map<String, Object> querySsyjChart(String zzjgdm) {
		String zzjgdms = zzjgdm.substring(0, zzjgdm.indexOf("@"));
		String ssyj_zzjglx = zzjgdm.substring(zzjgdm.indexOf("@")+1, zzjgdm.indexOf("~"));
		String time1 = zzjgdm.substring(zzjgdm.indexOf("~")+1, zzjgdm.indexOf("^"));
		String time2 = zzjgdm.substring(zzjgdm.indexOf("^")+1, zzjgdm.indexOf("`"));
		String chestr = "";
		String down = "";
		if(zzjgdm.indexOf("_") != -1){ //下钻
			chestr = zzjgdm.substring(zzjgdm.indexOf("`")+1, zzjgdm.length()-1);
			down = "_";
		} else {
			chestr = zzjgdm.substring(zzjgdm.indexOf("`")+1, zzjgdm.length());
		}
		Sf_Organization sf = new Sf_Organization();
		sf.setOrgcode(zzjgdms);
		sf.setSsyj_zzjglx(ssyj_zzjglx);
		sf.setTime1(time1);
		sf.setTime2(time2);
		sf.setChestr(chestr);
		sf.setDown(down);
		return jzService.ssyjChart(sf);
	}
	
	/**
	 * @Title: queryXjZzjg
	 * @描述: 警情对比分析双主图
	 * @参数: 传入参数定义
	 * @返回值: Map<String, Object> 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/queryDbChart", method = RequestMethod.GET)
	public @ResponseBody
	Map<String, Object> queryDbChart(String zzjgdm) {
		String zzjgdms = zzjgdm.substring(0, zzjgdm.indexOf("@"));
		String fqsj = zzjgdm.substring(zzjgdm.indexOf("@")+1, zzjgdm.indexOf("~"));
		String jssj = zzjgdm.substring(zzjgdm.indexOf("~")+1, zzjgdm.indexOf("^"));
		String jqlbdm = zzjgdm.substring(zzjgdm.indexOf("^")+1, zzjgdm.length());
		String zrq = "";
		return jzService.jqdbChart(zzjgdms, fqsj, jssj, jqlbdm, zrq);
	}
		
	/**
	 * @Title: queryJrjq
	 * @描述: 今日警情统计
	 * @参数: 传入参数定义
	 * @返回值: entity
	 * @throws
	 */
	@RequestMapping(value = "/queryJrjq", method = RequestMethod.POST)
	public @ResponseBody
		Map<String, Object> queryJrjq(Jz_jqxxb entity, @RequestParam(value="flag", required=false) String flag) {
		long countTotal = jzService.queryCountJq(entity);
		String wffz = "";
		entity.setJqlbdm(wffz);
		long countWffz = jzService.queryCountJq(entity);
		String xs = "";
		entity.setJqlbdm(xs);
		long countXs = jzService.queryCountJq(entity);
		String za = "";
		entity.setJqlbdm(za);
		long countZa = jzService.queryCountJq(entity);
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("countTotal", countTotal);
		jsonMap.put("countWffz", countWffz);
		jsonMap.put("countXs", countXs);
		jsonMap.put("countZa", countZa);
		long countQt = countTotal - countWffz - countXs - countZa;
		jsonMap.put("countQt", countQt<0 ? 0 : countQt);
		return jsonMap;
	}	
	
	/**
	 * @Title: main
	 * @Description: TODO(测试方法)
	 * @param @param args    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public static void main(String[] args) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy"); 
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.YEAR, -1);
		String firstYear = format.format(cal.getTime());
		cal.add(Calendar.YEAR, -1);
		String secondYear = format.format(cal.getTime());
		cal.add(Calendar.YEAR, -1);
		String threeYear = format.format(cal.getTime());
		System.out.println(firstYear +  " " + secondYear + " " + threeYear);
	}
}
