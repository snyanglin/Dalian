package com.founder.gzjk.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.founder.framework.base.controller.BaseController;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.organization.department.service.OrgOrganizationService;
import com.founder.framework.utils.ComboBox;
import com.founder.framework.utils.DateUtils;
import com.founder.framework.utils.EasyUIPage;
import com.founder.gzjk.bean.Gzdt;
import com.founder.gzjk.romcache.BzdzRamCache;
import com.founder.gzjk.romcache.RamCache;
import com.founder.gzjk.romcache.SydwRamCache;
import com.founder.gzjk.romcache.SyfwRamCache;
import com.founder.gzjk.romcache.ZdryRamCache;
import com.founder.gzjk.service.GzjkService;
import com.founder.gzjk.vo.CountBean;
import com.founder.gzjk.vo.GzjkTemp;

/**
 * 工作监控控制器
 * 
 * @author Administrator
 * 
 */
@Controller
@RequestMapping("/gzjk")
public class GzjkController extends BaseController {

	@Resource(name = "gzjkService")
	private GzjkService gzjkService;

	@Resource(name = "orgOrganizationService")
	private OrgOrganizationService orgOrganizationService;

	/**
	 * 工作监控主页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/main/{level}", method = RequestMethod.GET)
	public String gzjk(Model model, @PathVariable(value = "level") String level) {
		model.addAttribute("level", level);
		return "gzjk/gzjkMain";
	}

	@RequestMapping(value = "/maindz/{level}", method = RequestMethod.GET)
	public String gzjkdz(Model model,
			@PathVariable(value = "level") String level) {
		model.addAttribute("level", level);
		return "gzjk/gzjkBzdzMain";
	}

	/**
	 * 列表查询
	 * 
	 * @param page
	 * @param rows
	 * @param entity
	 * @return
	 */
	@RequestMapping(value = "/list/{dwdm}", method = RequestMethod.GET)
	public @ResponseBody
	EasyUIPage queryList(@PathVariable(value = "dwdm") String dwdm) {
		EasyUIPage page = new EasyUIPage();
		page.setPagePara(20);
		page.setTotal(20);
		// page.setRows(RamCache.findGzjkList(dwdm.length() >
		// 8?dwdm.substring(0, 8)+"0000":dwdm));
		return page;
	}

	/**
	 * 列表查询不分页
	 * 
	 * @param page
	 * @param rows
	 * @param entity
	 * @return
	 */
	// @RequestMapping(value = "/listnopage/{dwdm}", method =
	// RequestMethod.POST)
	// public @ResponseBody List<Gzjk>
	// queryListNoPage(@PathVariable(value="dwdm")String dwdm) {
	// return RamCache.findGzjkList(dwdm.length() > 8?dwdm.substring(0,
	// 8)+"0000":dwdm);
	// }
	//
	@RequestMapping(value = "/list/dz/{dwdm}", method = RequestMethod.GET)
	public @ResponseBody
	EasyUIPage queryListDz(@PathVariable(value = "dwdm") String dwdm) {
		EasyUIPage page = new EasyUIPage();
		page.setPagePara(20);
		page.setTotal(20);
		// page.setRows(BzdzRamCache.findGzjkList(dwdm.length() >
		// 8?dwdm.substring(0, 8)+"0000":dwdm));
		return page;
	}

	// @RequestMapping(value = "/list/zdry/{dwdm}", method = RequestMethod.GET)
	// public @ResponseBody EasyUIPage queryListZdry(
	// @PathVariable(value="dwdm")String dwdm) {
	// EasyUIPage page = new EasyUIPage();
	// page.setPagePara(20);
	// page.setTotal(20);
	// page.setRows(ZdryRamCache.findGzjkList(dwdm.length() >
	// 8?dwdm.substring(0, 8)+"0000":dwdm));
	// return page;
	// }
	//
	// @RequestMapping(value = "/list/dw/{dwdm}", method = RequestMethod.GET)
	// public @ResponseBody EasyUIPage queryListDw(
	// @PathVariable(value="dwdm")String dwdm) {
	// EasyUIPage page = new EasyUIPage();
	// page.setPagePara(20);
	// page.setTotal(20);
	// page.setRows(SydwRamCache.findGzjkList(dwdm.length() >
	// 8?dwdm.substring(0, 8)+"0000":dwdm));
	// return page;
	// }
	//
	// @RequestMapping(value = "/list/fw/{dwdm}", method = RequestMethod.GET)
	// public @ResponseBody EasyUIPage queryListFw(
	// @PathVariable(value="dwdm")String dwdm) {
	// EasyUIPage page = new EasyUIPage();
	// page.setPagePara(20);
	// page.setTotal(20);
	// page.setRows(SyfwRamCache.findGzjkList(dwdm.length() >
	// 8?dwdm.substring(0, 8)+"0000":dwdm));
	// return page;
	// }

	@RequestMapping(value = "/list/rylb", method = RequestMethod.GET)
	public @ResponseBody
	EasyUIPage queryZdryRylb(@RequestParam(value = "dwdm") String dwdm,
			@RequestParam(value = "rylb") String rylbdm) {
		EasyUIPage page = new EasyUIPage();
		page.setPagePara(20);
		page.setTotal(20);
		page.setRows(gzjkService.queryZdryRylb(dwdm, rylbdm));
		return page;
	}

	@RequestMapping(value = "/zdrylbdm", method = RequestMethod.GET)
	public @ResponseBody
	Map<String, Object> zdrylbdm(String dwdm, String zdrylb) {
		Map<String, Object> map = new HashMap<String, Object>();
		CountBean cb = gzjkService.queryBean(dwdm, zdrylb);
		map.put("add", cb.getAddCount());
		map.put("update", cb.getEditCount());
		map.put("del", cb.getCancellCont());
		map.put("total", cb.getCount());
		return map;
	}

	@RequestMapping(value = "/jrtj", method = RequestMethod.GET)
	public @ResponseBody
	Map<String, Object> queryJrtj(String dwdm) {
		Map<String, Object> map = new HashMap<String, Object>();
		CountBean syrk = RamCache.findGzjkCount(dwdm);
		CountBean bzdz = BzdzRamCache.findGzjkCount(dwdm);
		CountBean zdry = ZdryRamCache.findGzjkCount(dwdm);
		CountBean sydw = SydwRamCache.findGzjkCount(dwdm);
		CountBean syfw = SyfwRamCache.findGzjkCount(dwdm);
		int add = syrk.getAddCount() + bzdz.getAddCount() + sydw.getAddCount()
				+ zdry.getAddCount() + zdry.getEditCount()
				+ syfw.getEditCount();
		int update = syrk.getEditCount() + bzdz.getEditCount()
				+ sydw.getEditCount();
		int del = syrk.getCancellCont() + bzdz.getCancellCont()
				+ sydw.getCancellCont() + zdry.getCancellCont();
		// 总数
		map.put("syrkCount", syrk.getCount());
		map.put("bzdzCount", bzdz.getCount());
		map.put("zdryCount", zdry.getCount());
		map.put("sydwCount", sydw.getCount());
		map.put("syfwCount", syfw.getCount());
		map.put("add", add);
		map.put("update", update);
		map.put("del", del);
		return map;
	}

	@RequestMapping(value = "/jrtj/dz", method = RequestMethod.GET)
	public @ResponseBody
	Map<String, Object> queryJrtjDz(String dwdm) {
		Map<String, Object> map = new HashMap<String, Object>();
		CountBean cb = BzdzRamCache.findGzjkCount(dwdm);
		map.put("add", cb.getAddCount());
		map.put("update", cb.getEditCount());
		map.put("del", cb.getCancellCont());
		map.put("total", cb.getCount());
		return map;
	}

	@RequestMapping(value = "/jrtj/zdry", method = RequestMethod.GET)
	public @ResponseBody
	Map<String, Object> queryJrtjzdry(String dwdm) {
		Map<String, Object> map = new HashMap<String, Object>();
		CountBean cb = ZdryRamCache.findGzjkCount(dwdm);
		map.put("add", cb.getAddCount());
		map.put("update", cb.getEditCount());
		map.put("del", cb.getCancellCont());
		map.put("total", cb.getCount());
		return map;
	}

	@RequestMapping(value = "/jrtj/dw", method = RequestMethod.GET)
	public @ResponseBody
	Map<String, Object> queryJrtjdw(String dwdm) {
		Map<String, Object> map = new HashMap<String, Object>();
		CountBean cb = SydwRamCache.findGzjkCount(dwdm);
		map.put("add", cb.getAddCount());
		map.put("update", cb.getEditCount());
		map.put("del", cb.getCancellCont());
		map.put("total", cb.getCount());
		return map;
	}

	@RequestMapping(value = "/jrtj/fw", method = RequestMethod.GET)
	public @ResponseBody
	Map<String, Object> queryJrtjfw(String dwdm) {
		Map<String, Object> map = new HashMap<String, Object>();
		CountBean cb = SyfwRamCache.findGzjkCount(dwdm);
		map.put("add", cb.getAddCount());
		map.put("update", cb.getEditCount());
		map.put("del", cb.getCancellCont());
		map.put("total", cb.getCount());
		return map;
	}

	@RequestMapping(value = "/queryOrg", method = { RequestMethod.GET,
			RequestMethod.GET })
	public @ResponseBody
	List<ComboBox> queryOrgList() {
		return gzjkService.searchOrgList();
	}

	@RequestMapping(value = "/queryOrgLower", method = { RequestMethod.GET,
			RequestMethod.GET })
	public @ResponseBody
	List<ComboBox> queryOrgLowerList(String orgCode) {
		return gzjkService.searchOrgListLower(orgCode);
	}

	// 常东旭 2014-09-12 添加
	@RequestMapping(value = "/queryOrgLowest", method = { RequestMethod.GET,
			RequestMethod.GET })
	public @ResponseBody
	List<ComboBox> queryOrgLowestList(String orgCode) {
		return gzjkService.searchOrgListLowest(orgCode);
	}

	/**
	 * 
	 * @Title: query
	 * @Description: TODO(取选择单位统计数据)
	 * @param @param orgCode
	 * @param @return 设定文件
	 * @return Map<String,Object> 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/query", method = RequestMethod.GET)
	public @ResponseBody
	List<CountBean> query(String dwdm) {
		List<CountBean> list = new ArrayList<CountBean>();
		list.add(RamCache.findGzjkCount(dwdm));
		// SyfwRamCache
		// SydwRamCache
		// ZdryRamCache
		// BzdzRamCache
		return list;
	}

	/**
	 * 
	 * @Title: list
	 * @Description: TODO(查询下一级单位的统计)
	 * @param @param dwdm
	 * @param @return 设定文件
	 * @return EasyUIPage 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public @ResponseBody
	EasyUIPage list(@RequestParam(value = "dwdm") String dwdm) {
		orgOrganizationService.createOrganizationJS();
		EasyUIPage page = new EasyUIPage();
		page.setPagePara(20);
		page.setTotal(20);
		List<CountBean> returnList = new ArrayList<CountBean>();
		// 实有人口
		Map<String, Object> syrkMap = RamCache.finGzjkXjCount(dwdm);
		List<CountBean> syrklist = (List<CountBean>) syrkMap.get("countList");// 单位统计数据
		List<String> syrkdwList = (List<String>) syrkMap.get("dwList");// 单位代码
		// 标准地址
		Map<String, Object> bzdzMap = BzdzRamCache.finGzjkXjCount(dwdm);
		List<CountBean> bzdzlist = (List<CountBean>) bzdzMap.get("countList");// 单位统计数据
		List<String> bzdzdwList = (List<String>) bzdzMap.get("dwList");// 单位代码
		
		// 实有单位
		Map<String, Object> sydwMap = SydwRamCache.finGzjkXjCount(dwdm);
		List<CountBean> sydwlist = (List<CountBean>) sydwMap.get("countList");// 单位统计数据
		List<String> sydwdwList = (List<String>) sydwMap.get("dwList");// 单位代码
		
		// 重点人员
		Map<String, Object> zdryMap = ZdryRamCache.finGzjkXjCount(dwdm);
		List<CountBean> zdrylist = (List<CountBean>) zdryMap.get("countList");// 单位统计数据
		List<String> zdrydwList = (List<String>) zdryMap.get("dwList");// 单位代码
		
		// 实有房屋
		Map<String, Object> syfwMap = SyfwRamCache.finGzjkXjCount(dwdm);
		List<CountBean> syfwlist = (List<CountBean>) syfwMap.get("countList");// 单位统计数据
		List<String> syfwdwList = (List<String>) syfwMap.get("dwList");// 单位代码
		if (syrklist != null && syrklist.size() > 0) {
			CountBean c = null;
			for (int i = 0; i < syrklist.size(); i++) {
				if (syrklist.get(i).getAddCount() == 0
						&& syrklist.get(i).getEditCount() == 0
						&& syrklist.get(i).getCancellCont() == 0) {

				} else {
					c = new CountBean();
					c.setDwdm(syrkdwList.get(i).toString());
					String ywms = "新增" + syrklist.get(i).getAddCount() + ",修改"
							+ syrklist.get(i).getEditCount() + ",注销"
							+ syrklist.get(i).getCancellCont();
					c.setYwms(ywms);
					c.setYwlx("实有人口");
					returnList.add(c);
				}
			}
		}

	
		if (bzdzlist != null && bzdzlist.size() > 0) {
			CountBean c = null;
			for (int i = 0; i < bzdzlist.size(); i++) {
				if (bzdzlist.get(i).getAddCount() == 0
						&& bzdzlist.get(i).getEditCount() == 0
						&& bzdzlist.get(i).getCancellCont() == 0) {

				} else {
					c = new CountBean();
					c.setDwdm(bzdzdwList.get(i).toString());
					String ywms = "新增" + bzdzlist.get(i).getAddCount() + ",修改"
							+ bzdzlist.get(i).getEditCount() + ",注销"
							+ bzdzlist.get(i).getCancellCont();
					c.setYwms(ywms);
					c.setYwlx("标准地址");
					returnList.add(c);
				}
			}
		}

		
		if (sydwlist != null && sydwlist.size() > 0) {
			CountBean c = null;
			for (int i = 0; i < bzdzlist.size(); i++) {
				if (sydwlist.get(i).getAddCount() == 0
						&& sydwlist.get(i).getEditCount() == 0
						&& sydwlist.get(i).getCancellCont() == 0) {

				} else {
					c = new CountBean();
					c.setDwdm(sydwdwList.get(i).toString());
					String ywms = "新增" + sydwlist.get(i).getAddCount() + ",修改"
							+ sydwlist.get(i).getEditCount() + ",注销"
							+ sydwlist.get(i).getCancellCont();
					c.setYwms(ywms);
					c.setYwlx("实有单位");
					returnList.add(c);
				}
			}
		}

		
		if (zdrylist != null && zdrylist.size() > 0) {
			CountBean c = null;
			for (int i = 0; i < bzdzlist.size(); i++) {
				if (zdrylist.get(i).getAddCount() == 0
						&& zdrylist.get(i).getEditCount() == 0
						&& zdrylist.get(i).getCancellCont() == 0) {

				} else {
					c = new CountBean();
					c.setDwdm(zdrydwList.get(i).toString());
					String ywms = "列管" + zdrylist.get(i).getAddCount() + ",管控"
							+ zdrylist.get(i).getEditCount() + ",撤管"
							+ zdrylist.get(i).getCancellCont();
					c.setYwms(ywms);
					c.setYwlx("重点人员");
					returnList.add(c);
				}
			}
		}

		
		if (syfwlist != null && syfwlist.size() > 0) {
			CountBean c = null;
			for (int i = 0; i < bzdzlist.size(); i++) {
				if(syfwlist.get(i).getAddCount() ==0 && syfwlist.get(i).getEditCount()==0 && syfwlist.get(i).getCancellCont() ==0){
					
				}else{
					c = new CountBean();
					c.setDwdm(syfwdwList.get(i).toString());
					String ywms = "出租房总数" + syfwlist.get(i).getAddCount() + ",新增房屋"
							+ syfwlist.get(i).getEditCount() + ",新增出租房"
							+ syfwlist.get(i).getCancellCont();
					c.setYwms(ywms);
					c.setYwlx("实有房屋");
					returnList.add(c);
				}
			}
		}

		page.setRows(returnList);
		return page;
	}

	
	@RequestMapping(value = "/listByLevel", method = RequestMethod.GET)
	public @ResponseBody
	EasyUIPage listByLevel(@RequestParam(value = "dwdm") String dwdm,
			@RequestParam(value = "level") String level,
			@RequestParam(value = "ywlx") String ywlx) {
		EasyUIPage page = new EasyUIPage();
		page.setPagePara(20);
		page.setTotal(20);
		List<GzjkTemp> list = new ArrayList<GzjkTemp>();
		list.addAll(gzjkService.queryListByLevel(dwdm, Integer.valueOf(level),
				ywlx));
		page.setRows(list);
		return page;
	}
	
	
	//重构
	/**
	 * @Title: queryCount
	 * @Description: TODO(统计总数)
	 * @param @param syrkgllbdm
	 * @param @param ryid
	 * @param @return 设定文件
	 * @return Map 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/queryCount", method = RequestMethod.POST)
	public @ResponseBody
	Map queryCount(String dwdm, SessionBean sessionBean) {
		Map<String, Object> map = new HashMap<String, Object>();
		sessionBean = getSessionBean(sessionBean);
		Gzdt gzdt = new Gzdt();
		gzdt.setDwdm(dwdm);
		gzdt.setCurrentDay(DateUtils.getSystemDateString());
		gzdt = gzjkService.queryCount(gzdt);
		map.put("gzdt", gzdt);
		return map;
	}
	
	
	/**
	 * 图形展示
	 * 
	 * @param dwdm
	 * @return
	 */
	@RequestMapping(value = "/queryZtqkChart", method = RequestMethod.GET)
	public @ResponseBody
	Map<String, Object> queryZtqkChart(@RequestParam(value = "dwdm") String dwdm) {
		return gzjkService.gzdxChart(dwdm);
	}

	
	
	

}
