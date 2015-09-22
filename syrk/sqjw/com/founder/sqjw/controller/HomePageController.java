package com.founder.sqjw.controller;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.founder.framework.base.controller.BaseController;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.sqjw.bean.LogInfo;
import com.founder.sqjw.bean.TjSyrk;
import com.founder.sqjw.bean.XJSZ;
import com.founder.sqjw.bean.XjtjXq;
import com.founder.sqjw.bean.Xjtjcar;
import com.founder.sqjw.bean.Xjtjemployee;
import com.founder.sqjw.service.HomePageService;
import com.founder.sqjw.vo.ZzjgVo;
import com.founder.tzgg.bean.Org_Organization;
import com.founder.zakh.tools.Dateutil;


/**
 * @类名: HomePageController
 * @描述: 社区警务HomePage主页
 * @作者: zhang_guoliang@founder.com
 * @日期: 2014-7-4 下午1:41:22
 * 
 */
@Controller
// 声明控制器
@RequestMapping("/homePage")
// 映射URL
public class HomePageController extends BaseController {

	// private Logger logger = Logger.getLogger(this.getClass());

	@Resource(name = "homePageService")
	private HomePageService homePageService;

	/**
	 * @Title: syrkChart
	 * @描述: 实有人口饼状图
	 * @作者: zhang_guoliang@founder.com
	 * @参数: 传入参数定义
	 * @日期： 2014-7-9 下午9:01:30
	 * @返回值: Map<String,Object> 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/querySyrkChart", method = RequestMethod.GET)
	public @ResponseBody
	Map<String, Object> querySyrkChart(String zzjgdm) {
		return homePageService.syrkChart(zzjgdm);
	}

	/**
	 * @Title: gzdxChart
	 * @描述: 工作对象柱状图
	 * @作者: zhang_guoliang@founder.com
	 * @参数: 传入参数定义
	 * @日期： 2014-7-9 下午9:01:55
	 * @返回值: Map<String,Object> 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/queryGzdxChart", method = RequestMethod.GET)
	public @ResponseBody
	Map<String, Object> queryGzdxChart(String zzjgdm) {
		return homePageService.gzdxChart(zzjgdm);
	}

	/**
	 * @Title: queryBzdzChart
	 * @描述: 流动人口来自地区状图
	 * @作者: zhang_guoliang@founder.com
	 * @参数: 传入参数定义
	 * @日期： 2014-7-11 上午9:57:34
	 * @返回值: Map<String,Object> 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/queryBzdzChart", method = RequestMethod.GET)
	public @ResponseBody
	Map<String, Object> queryBzdzChart(String zzjgdm) {
		return homePageService.bzdzChart(zzjgdm);
	}

	/**
	 * @Title: queryLdrkChart
	 * @描述: 流动人口柱状图
	 * @作者: zhang_guoliang@founder.com
	 * @参数: 传入参数定义
	 * @日期： 2014-7-11 上午10:09:08
	 * @返回值: Map<String,Object> 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/queryLdrkChart", method = RequestMethod.GET)
	public @ResponseBody
	Map<String, Object> queryLdrkChart(String zzjgdm) {
		return homePageService.ldrkChart(zzjgdm);
	}

	/**
	 * @Title: queryJwrkChart
	 * @描述: 境外人口柱状图
	 * @作者: zhang_guoliang@founder.com
	 * @参数: 传入参数定义
	 * @日期： 2014-7-11 上午10:30:34
	 * @返回值: Map<String,Object> 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/queryJwrkChart", method = RequestMethod.GET)
	public @ResponseBody
	Map<String, Object> queryJwrkChart(String zzjgdm) {
		return homePageService.jwrkChart(zzjgdm);
	}

	/**
	 * @Title: queryNlChart
	 * @描述: 年龄段统计
	 * @作者: zhang_guoliang@founder.com
	 * @参数: 传入参数定义
	 * @日期： 2014-7-14 下午6:37:11
	 * @返回值: Map<String,Object> 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/queryNlChart", method = RequestMethod.GET)
	public @ResponseBody
	Map<String, Object> queryNlChart(String zzjgdm) {
		return homePageService.nlChart(zzjgdm);
	}

	/**
	 * @Title: queryWhcdChart
	 * @描述: 文化程度统计
	 * @作者: zhang_guoliang@founder.com
	 * @参数: 传入参数定义
	 * @日期： 2014-7-14 下午6:47:27
	 * @返回值: Map<String,Object> 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/queryWhcdChart", method = RequestMethod.GET)
	public @ResponseBody
	Map<String, Object> queryWhcdChart(String zzjgdm) {
		return homePageService.whcdChart(zzjgdm);
	}

	/**
	 * @Title: queryGzjlDate
	 * @描述: 获取工作记录时间
	 * @作者: zhang_guoliang@founder.com
	 * @参数: 传入参数定义
	 * @日期： 2014-7-10 上午11:19:12
	 * @返回值: List<String> 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/queryGzjlDate", method = RequestMethod.POST)
	public @ResponseBody
	List<String> queryGzjlDate() {
		return homePageService.queryGzjlDate();
	}

	/**
	 * @Title: queryGzjlList
	 * @描述: 获取工作记录昨天数据
	 * @作者: zhang_guoliang@founder.com
	 * @参数: 传入参数定义
	 * @日期： 2014-7-10 下午4:27:01
	 * @返回值: Map<String,Object> 返回类型
	 * @throws
	 */
	/*
	 * @RequestMapping(value = "/queryGzjlList", method = RequestMethod.POST)
	 * public @ResponseBody Map<String, Object> queryGzjlList(String zzjgdm,
	 * String dTime) { String tt[] = dTime.split("-"); String ptime = tt[1] +
	 * tt[2]; Map<String, Object> param = new HashMap<String, Object>();
	 * param.put("zzjgdm", zzjgdm); param.put("ptime", ptime); List<Tjgzjl> list
	 * = homePageService.queryGzjlList(param); Map<String, Object> resultMap =
	 * new HashMap<String, Object>(); List<Map<String, Object>> resultList = new
	 * ArrayList<Map<String, Object>>(); for (Tjgzjl ls : list) { Map<String,
	 * Object> moduleMap = new HashMap<String, Object>(); moduleMap.put("id",
	 * ls.getLx()); moduleMap.put("gzjlnr", ls.getLxmc()); moduleMap.put("ri",
	 * ls.getDay()); moduleMap.put("zhou", ls.getWeek()); moduleMap.put("yue",
	 * ls.getMonth()); moduleMap.put("nian", ls.getYear()); int lx =
	 * ls.getLx().length(); if (lx == 2) { resultList.add(moduleMap); } else if
	 * (lx == 4) { moduleMap.put("_parentId", ls.getLx().substring(0, 2));
	 * moduleMap.put("state", "closed"); resultList.add(moduleMap); } else if
	 * (lx == 6) { moduleMap.put("_parentId", ls.getLx().substring(0, 4));
	 * resultList.add(moduleMap); } } resultMap.put("rows", resultList); return
	 * resultMap; }
	 */
	@RequestMapping(value = "/queryGzjlList", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, Object> queryGzjlList(String zzjgdm, String dTime) {
		//String tt[] = dTime.split("-");
		// String ptime = tt[1] + "-" + tt[2];
		String ptime = dTime;
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("zzjgdm", zzjgdm);
		param.put("ptime", ptime);
		List<Map<String, String>> list = homePageService.queryGzjlList2(param);
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>();
		for (Map<String, String> ls : list) {
			Map<String, Object> moduleMap = new HashMap<String, Object>();
			moduleMap.put("id", ls.get("YWID"));
			moduleMap.put("gzjlnr", ls.get("YWID"));
			// moduleMap.put("ri", tt[2]);//ptime.substring(8, 10)
			// moduleMap.put("yue",tt[1]);// ptime.substring(5, 7)
			// moduleMap.put("nian", tt[0]);//ptime.substring(0, 4)
			moduleMap.put("rixz", ls.get("JRXZ"));
			moduleMap.put("rizx", ls.get("JRZX"));
			moduleMap.put("yuexz", ls.get("BYXZ"));
			moduleMap.put("yuezx", ls.get("BYZX"));
			moduleMap.put("nianxz", ls.get("BNXZ"));
			moduleMap.put("nianzx", ls.get("BNZX"));
			resultList.add(moduleMap);
		}
		resultMap.put("rows", resultList);
		return resultMap;
	}

	/**
	 * @Title: queryGzjlXqList
	 * @描述: 查询工作记录详情
	 * @作者: zhang_guoliang@founder.com
	 * @参数: 传入参数定义
	 * @日期： 2014-7-14 下午10:45:51
	 * @返回值: List<Bzdzxxb> 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/queryGzjlXqList", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, Object> queryGzjlXqList(int page, int rows, String zzjgdm,
			String code, String day, String week, String month, String year,
			String type) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("page", page);
		param.put("rows", rows);
		param.put("zzjgdm", zzjgdm);
		param.put("code", code);
		param.put("type", type);
		param.put("day", day);
		param.put("week", week);
		param.put("month", month);
		param.put("year", year);
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<LogInfo> rowsData = homePageService.queryGzjlInfo(param);
		int rowCount = homePageService.queryGzjlInfoCount(param);
		resultMap.put("rows", rowsData);
		resultMap.put("total", rowCount);
		return resultMap;
	}

	/**
	 * @Title: queryGzdxList
	 * @描述: 查询工作对象坐标详情
	 * @作者: zhang_guoliang@founder.com
	 * @参数: 传入参数定义
	 * @日期： 2014-7-17 下午15:43:21
	 * @返回值: List<Bzdzxxb> 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/queryGzdxList", method = RequestMethod.POST)
	public @ResponseBody
	List<TjSyrk> queryGzdxList(String lx, String zzjgdm) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("lx", lx);
		param.put("zzjgdm", zzjgdm);
		return homePageService.queryGzdxList(param);
	}

	/**
	 * @Title: queryldrkList
	 * @描述: 流动人口统计坐标详情
	 * @作者: zhang_guoliang@founder.com
	 * @参数: 传入参数定义
	 * @日期： 2014-7-17 下午4:31:38
	 * @返回值: List<TjSyrk> 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/queryldrkList", method = RequestMethod.POST)
	public @ResponseBody
	List<TjSyrk> queryldrkList(String lx, String zzjgdm) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("lx", lx);
		param.put("zzjgdm", zzjgdm);
		return homePageService.queryldrkList(param);
	}

	/**
	 * @Title: queryjwrkList
	 * @描述: 境外人口统计坐标详情
	 * @作者: zhang_guoliang@founder.com
	 * @参数: 传入参数定义
	 * @日期： 2014-7-17 下午4:52:42
	 * @返回值: List<TjSyrk> 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/queryjwrkList", method = RequestMethod.POST)
	public @ResponseBody
	List<TjSyrk> queryjwrkList(String lx, String zzjgdm) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("lx", lx);
		param.put("zzjgdm", zzjgdm);
		return homePageService.queryjwrkList(param);
	}

	/**
	 * @Title: querynlList
	 * @描述: 年龄段坐标统计详情
	 * @作者: zhang_guoliang@founder.com
	 * @参数: 传入参数定义
	 * @日期： 2014-7-17 下午5:03:41
	 * @返回值: List<TjSyrk> 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/querynlList", method = RequestMethod.POST)
	public @ResponseBody
	List<TjSyrk> querynlList(String lx, String zzjgdm) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("lx", lx);
		param.put("zzjgdm", zzjgdm);
		return homePageService.querynlList(param);
	}

	/**
	 * @Title: queryXjZzjg
	 * @描述: 获取派出所下级组织机构
	 * @作者: zhang_guoliang@founder.com
	 * @参数: 传入参数定义
	 * @日期： 2014-10-23 下午2:02:27
	 * @返回值: List<ZzjgVo> 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/queryXjZzjg", method = RequestMethod.POST)
	public @ResponseBody
	List<ZzjgVo> queryXjZzjg(String zzjgdm) {
		zzjgdm = zzjgdm.substring(0, 8);
		return homePageService.queryXjZzjg(zzjgdm);
	}
	
	/**
	 * @Title: queryPcsTj
	 * @描述:派出所统计
	 * @作者: zhang_guoliang@founder.com
	 * @参数: 传入参数定义
	 * @日期： 2014-10-25 下午4:43:03
	 * @返回值: List<ZzjgVo> 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/queryPcsTj", method = RequestMethod.POST)
	public @ResponseBody
	List<ZzjgVo> queryPcsTj(String zzjgdm) {
		Map<String, Object> param = new HashMap<String, Object>();
		if (!StringUtils.isBlank(zzjgdm) && zzjgdm.length() >= 12) {
			if ("0000".equals(zzjgdm.substring(8, 12))) {
				param.put("lx", 14);
				param.put("pcsdm", zzjgdm);
			} else {
				param.put("lx", 15);
				param.put("pcsdm", zzjgdm.substring(0, 8) + "0000");
			}
		}
		param.put("zzjgdm", zzjgdm);
		return homePageService.queryPcsTj(param);
	}
	
	/**
	 * @Title: queryPcsTj
	 * @描述:派出所统计
	 * @作者: zhang_guoliang@founder.com
	 * @参数: 传入参数定义
	 * @日期： 2014-10-25 下午4:43:03
	 * @返回值: List<ZzjgVo> 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/countXX" ,method = RequestMethod.POST)
	public @ResponseBody Map<String,Object> khxx(){
		Map<String,Object> paramMap=new HashMap<String, Object>();
		String orgid = getSessionBean().getUserOrgCode();
	    paramMap.put("orgCode", orgid);
	    Map<String,Object> resMap = homePageService.queryzrqtj(paramMap);
		return resMap;
	}

	/**
	 * @Title: queryZrqUser
	 * @描述: 责任区民警
	 * @作者: zhang_guoliang@founder.com
	 * @参数: 传入参数定义
	 * @日期： 2014-10-26 下午2:28:15
	 * @返回值: List<ZzjgVo> 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/queryZrqUser", method = RequestMethod.POST)
	public @ResponseBody
	List<ZzjgVo> queryZrqUser(String zzjgdm) {
		return homePageService.queryZrqUser(zzjgdm);
	}

	/**
	 * @Title: querytwspMap
	 * @描述: 天网视频撒点
	 * @作者: zhang_guoliang@founder.com
	 * @参数: 传入参数定义
	 * @日期： 2014-10-27 下午4:31:42
	 * @返回值: List<ZzjgVo> 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/querytwspMap", method = RequestMethod.POST)
	public @ResponseBody
	List<ZzjgVo> querytwspMap(String zzjgdm) {
		return homePageService.querytwspMap(zzjgdm);
	}

	/**
	 * 
	 * @Title: queryCensusChart
	 * @Description: TODO(首页-派出所)
	 * @param @param zzjgdm
	 * @param @return 设定文件
	 * @return Map<String,Object> 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/queryCensusChart", method = RequestMethod.GET)
	public @ResponseBody
	Map<String, Object> queryCensusChart(String zzjgdm) {
		String pcsdm = getSessionBean().getUserOrgCode();
		if (pcsdm.length() >= 8) {
			pcsdm = pcsdm.substring(0, 8);
		}
		return homePageService.censusChart(zzjgdm, pcsdm);
	}

	/**
	 * @Title: querytwspMap
	 * @描述: 实有单位撒点
	 * @作者: yu_sun@founder.com
	 * @参数: 传入参数定义
	 * @日期： 2014-10-28 下午4:31:42
	 * @返回值: List<ZzjgVo> 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/querySydwMap", method = RequestMethod.POST)
	public @ResponseBody
	List<ZzjgVo> querySydwMap(String lx, String zzjgdm) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("dwlx", lx);
		if ("0000".equals(zzjgdm.substring(8, 12))) {
			param.put("lx", 14);
		} else {
			param.put("lx", 15);
		}
		param.put("zzjgdm", zzjgdm);
		return homePageService.querySydwMap(param);
	}

	/**
	 * @Title: querytwspMap
	 * @描述: 实有房屋撒点
	 * @作者: yu_sun@founder.com
	 * @参数: 传入参数定义
	 * @日期： 2014-10-28 下午4:31:42
	 * @返回值: List<ZzjgVo> 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/querySyfwMap", method = RequestMethod.POST)
	public @ResponseBody
	List<ZzjgVo> querySyfwMap(String lx, String zzjgdm) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("fwlx", lx);
		if ("0000".equals(zzjgdm.substring(8, 12))) {
			param.put("lx", 14);
		} else {
			param.put("lx", 15);
		}
		param.put("zzjgdm", zzjgdm);
		return homePageService.querySyfwMap(param);
	}

	/**
	 * @Title: queryZdrkMap
	 * @描述: 重点人口撒点
	 * @作者: zhang_guoliang@founder.com
	 * @参数: 传入参数定义
	 * @日期： 2014-10-29 下午5:34:20
	 * @返回值: List<ZzjgVo> 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/queryZdrkMap", method = RequestMethod.POST)
	public @ResponseBody
	List<ZzjgVo> queryZdrkMap(String lx, String zzjgdm) {
		Map<String, Object> param = new HashMap<String, Object>();
		String zdrylbdm = "";
		param.put("zdlx", "1");
		if ("11".equals(lx)) {
			zdrylbdm = "'010103','030601'";
			param.put("zdrylbdm", zdrylbdm);
		} else if ("12".equals(lx)) {
			zdrylbdm = "'010601', '010602', '010603', '010604', '010605', '101701', '101702'";
			param.put("zdrylbdm", zdrylbdm);
		} else if ("13".equals(lx)) {
			zdrylbdm = "'010501', '010502'";
			param.put("zdrylbdm", zdrylbdm);
		} else if (!"1".equals(lx)) {
			param.put("zdlx", lx);
		}
		if ("0000".equals(zzjgdm.substring(8, 12))) {
			param.put("lx", 14);
		} else {
			param.put("lx", 15);
		}
		param.put("zzjgdm", zzjgdm);
		return homePageService.queryZdrkMap(param);
	}
	/**
	 * @Title: queryPcs 
	 * @描述: 查询所有派出所代码
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2014-11-21 下午5:21:58 
	 * @返回值: List<ZzjgVo>    返回类型 
	 * @throws
	 */
	@RequestMapping(value = "/queryPcs", method = RequestMethod.POST)
	public @ResponseBody List<ZzjgVo> queryPcs() {
		return homePageService.queryPcs();
	}
	
	
	//begin
		/**
		 * @Title: queryXjList
		 * @描述: 查询巡警坐标详情
		 * @参数: 传入参数定义
		 * @日期： 2015-1-8 下午8:32:46
		 * @返回值: List<Bzdzxxb> 返回类型
		 * @throws
		 */
		@RequestMapping(value = "/queryXjList", method = RequestMethod.POST)
		public @ResponseBody
		List<TjSyrk> queryXjList(String lx, String lxs, String zzjgdm) {
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("lx", lx);
			param.put("lxs", lxs);
			param.put("zzjgdm", zzjgdm);
			return homePageService.queryXjList(param);
		}
		
		/**
		 * @Title: queryXjZzjg
		 * @描述: 获取分局下级组织机构
		 * @参数: 传入参数定义
		 * @返回值: List<ZzjgVo> 返回类型
		 * @throws
		 */
		@RequestMapping(value = "/queryXjZzjgxj", method = RequestMethod.POST)
		public @ResponseBody
		List<ZzjgVo> queryXjZzjgxj(String zzjgdm) {
			return homePageService.queryXjZzjgxj(zzjgdm);
		}
		
		@RequestMapping(value = "/downMap", method = RequestMethod.POST)
		public @ResponseBody
		List<Org_Organization> downMap(String orgcode) {
			List<Org_Organization> list = homePageService.downMap(orgcode);
			 String zero8 = orgcode.substring(orgcode.length()-8, orgcode.length());
			 String zero6 = orgcode.substring(orgcode.length()-6, orgcode.length());
			 String zero4 = orgcode.substring(orgcode.length()-4, orgcode.length());
			 if (zero8.equals("00000000")) {
				 Org_Organization org = new Org_Organization();
				 for (int i = 0; i < list.size(); i++) {
					org = (Org_Organization)list.get(i);
					String temp = org.getOrgcode().substring(org.getOrgcode().length()-8, org.getOrgcode().length());
					if (("00000000").equals(temp)) {
						list.remove(i);
					} 
				}
			 } else if(zero6.equals("000000")){
				 Org_Organization org = new Org_Organization();
				 for (int i = 0; i < list.size(); i++) {
					    org = (Org_Organization)list.get(i);
					    String temp = org.getOrgcode().substring(org.getOrgcode().length()-6, org.getOrgcode().length());
						if (("000000").equals(temp)) {
							list.remove(i);
						} 
					}
			 } else if(!zero8.equals("00000000") && !zero6.equals("000000") && zero4.equals("0000")){
				 Org_Organization org = new Org_Organization();
				 for (int i = 0; i < list.size(); i++) {
					 org = (Org_Organization)list.get(i);
					 String temp = org.getOrgcode().substring(org.getOrgcode().length()-4, org.getOrgcode().length());
						if (("0000").equals(temp)) {
							list.remove(i);
						} 
					}
			 }
			 
			return list;
		}
		
		/**
		 * @Title: syrkChart
		 * @描述: 警情统计饼状图
		 * @参数: 传入参数定义
		 * @日期： 2014-12-8 下午9:01:30
		 * @返回值: Map<String,Object> 返回类型
		 * @throws
		 */
		@RequestMapping(value = "/queryXjChart", method = RequestMethod.GET)
		public @ResponseBody
		Map<String, Object> queryXjChart(String zzjgdm) {
			return homePageService.jqChart(zzjgdm);
		}
		
		/**
		 * @Title: querynlList
		 * @描述: 考核统计
		 * @参数: 传入参数定义
		 * @日期： 2014-12-9 下午5:03:41
		 * @返回值: List<TjSyrk> 返回类型
		 * @throws
		 */
		@RequestMapping(value = "/queryXly", method = RequestMethod.GET)
		public @ResponseBody
			ModelAndView queryXly(String type, String userid, String flag) {
			ModelAndView mv = new ModelAndView("sqjw/total_xj");
			Map<String, Object> param = new HashMap<String, Object>();
			
			param.put("userid", userid);
			param.put("flag", flag);
			List<Xjtjemployee> list =  homePageService.queryXly(param);
			Xjtjemployee ee = new Xjtjemployee();
			if(list.size() > 0){
				for (int i = 0; i < list.size(); i++) {
					ee = (Xjtjemployee)list.get(i);
				}
			} else {
				mv.addObject("begin", "stop");
			}
			mv.addObject("entity", ee);
		
			List<Xjtjcar> listc =  homePageService.queryCar(param);
			Xjtjcar eec = new Xjtjcar();
			if(listc.size() > 0){
				for (int i = 0; i < listc.size(); i++) {
					eec = (Xjtjcar)listc.get(i);
				}
			} else {
				mv.addObject("begin", "stop");
			}
			mv.addObject("entityc", eec);
			
			List<XjtjXq> listq =  homePageService.queryXq(param);
			XjtjXq eeq = new XjtjXq();
			if(listq.size() > 0){
				for (int i = 0; i < listq.size(); i++) {
					eeq = (XjtjXq)listq.get(i);
				}
			} else {
				mv.addObject("begin", "stop");
			}
			mv.addObject("entityq", eeq);

			return mv;
		}
		
		/**
		 * @Title: queryXjXlc
		 * @Description: TODO(巡逻员查询)
		 * @return void 返回类型
		 * @throws
		 */
		@RequestMapping(value = "/queryXjXlY", method = RequestMethod.POST)
		public @ResponseBody
		EasyUIPage queryXjXlY(EasyUIPage page,
				@RequestParam(value = "rows") Integer rows, @RequestParam(value="userid", required=false) String userid, @RequestParam(value="type", required=false) String type,
				@RequestParam(value="flag", required=false) String flag) {
			page.setPagePara(rows);
			SessionBean sessionBean = getSessionBean();
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("userid", userid);
			param.put("type", type);
			param.put("flag", flag);
			param.put("orgcode", sessionBean.getUserOrgCode());
			return homePageService.queryXly(page, param);
		}
		
		/**
		 * @Title: queryXllx
		 * @Description: TODO(巡逻员查询)
		 * @return void 返回类型
		 * @throws
		 */
		@RequestMapping(value = "/queryXllx", method = RequestMethod.POST)
		public @ResponseBody
		EasyUIPage queryXllx(EasyUIPage page,
				@RequestParam(value = "rows") Integer rows, @RequestParam(value="userid", required=false) String userid, @RequestParam(value="type", required=false) String type,
				@RequestParam(value="flag", required=false) String flag) {
			page.setPagePara(rows);
			SessionBean sessionBean = getSessionBean();
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("userid", userid);
			param.put("type", type);
			param.put("flag", flag);
			param.put("orgcode", sessionBean.getUserOrgCode());
			return homePageService.queryXllx(page, param);
		}
		
		/**
		 * @Title: queryXllx
		 * @Description: TODO(巡逻员查询)
		 * @return void 返回类型
		 * @throws
		 */
		@RequestMapping(value = "/queryXllxs", method = RequestMethod.POST)
		public @ResponseBody
		EasyUIPage queryXllxs(EasyUIPage page,
				@RequestParam(value = "rows", required=false) Integer rows, @RequestParam(value="userid", required=false) String userid, @RequestParam(value="type", required=false) String type,
				@RequestParam(value="flag", required=false) String flag) {
			page.setPagePara(rows);
			SessionBean sessionBean = getSessionBean();
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("userid", userid);
			param.put("type", type);
			param.put("flag", flag);
			param.put("isChild", "ok");
			param.put("orgcode", sessionBean.getUserOrgCode());
			return homePageService.queryXllx(page, param);
		}
		
		/**
		 * @Title: queryGzjlDate
		 * @描述: 获取设置
		 * @作者: zhang_guoliang@founder.com
		 * @参数: 传入参数定义
		 * @日期： 2014-7-10 上午11:19:12
		 * @返回值: List<String> 返回类型
		 * @throws
		 */
		@RequestMapping(value = "/querySZ", method = RequestMethod.POST)
		public @ResponseBody
		List<XJSZ> querySZ(@RequestParam(value="userid", required=false) String userid) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("userid", userid);
			return homePageService.querySZ(map);
		}
		
		/**
		 * @Title: queryGzjlDate
		 * @描述: 修改设置
		 * @作者: zhang_guoliang@founder.com
		 * @参数: 传入参数定义
		 * @日期： 2014-7-10 上午11:19:12
		 * @返回值: List<String> 返回类型
		 * @throws
		 */
		@RequestMapping(value = "/uptSZ", method = RequestMethod.POST)
		public @ResponseBody
		String uptSZ(@RequestParam(value="userid", required=false) String userid, @RequestParam(value="pro", required=false) String pro) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("userid", userid);
			map.put("pro", pro);
			map.put("type", "xqdt");
			int res = 0;
			List<XJSZ> list = homePageService.querySZ(map);
			if(list!=null && list.size()>0){
				res = homePageService.uptSZ(map);
			} else {
				res = homePageService.addSZ(map);
			}
			if (res>=0) {
				return "success";
			}
			return "";
		}
	
		//jz begin
		/**
		 * @Title: querySydwChart
		 * @描述: 局长实有单位饼状图
		 * @参数: 传入参数定义
		 * @日期： 2015-3-25 下午9:01:30
		 * @返回值: Map<String,Object> 返回类型
		 * @throws
		 */
		@RequestMapping(value = "/querySydwChart", method = RequestMethod.GET)
		public @ResponseBody
		Map<String, Object> querySydwChart(String zzjgdm) {
			return homePageService.sydwChart(zzjgdm);
		}
		
		/**
		 * @Title: querySyfwChart
		 * @描述: 局长实有房屋饼状图
		 * @参数: 传入参数定义
		 * @日期： 2015-3-25 下午9:01:30
		 * @返回值: Map<String,Object> 返回类型
		 * @throws
		 */
		@RequestMapping(value = "/querySyfwChart", method = RequestMethod.GET)
		public @ResponseBody
		Map<String, Object> querySyfwChart(String zzjgdm) {
			return homePageService.syfwChart(zzjgdm);
		}
		//jz end
}