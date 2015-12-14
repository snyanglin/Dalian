package com.founder.dbrw.controller;

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

import com.founder.dbrw.bean.DbrwDbrwb;
import com.founder.dbrw.bean.DbrwDdbrwb;
import com.founder.dbrw.service.DbrwMainService;
import com.founder.dbrw.vo.DbrwMainVo;
import com.founder.framework.base.controller.BaseController;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;

@Controller
@RequestMapping("/dbrwMain")
public class DbrwMainController extends BaseController {

	@Resource(name = "dbrwMainService")
	private DbrwMainService dbrwMainService;

	/**
	 * 
	 * @Title: createPage
	 * @Description: TODO(入口页面)
	 * @param @return 设定文件
	 * @return ModelAndView 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public @ResponseBody
	ModelAndView main() {
		ModelAndView mv = new ModelAndView("dbrw/ddbrwMain");// ddbrwMain
		String gwry = "";// 高危地区人员
		String zdry = "";// 重点人员
		String syrk_wzjzd = "";// 未知居住地户籍人员
		String syrk_wyry = "";// 无业人员
		String syrk_yywjzd = "";// 有业无居住地人员
		String syfw_dj = "";// 独居出租房屋
		String syfw_qj = "";// 群居出租房屋
		String syfw_wrjz = "";// 无人居住房屋
		String sydw_ldxjd = "";// 从业人员流动性较大的企业
		String sydw_wcyry = "";// 无从业人员的企业
 
		String bzdz_wbzmlp = "";// 未标注门楼牌
		String bzdz_wchmlp = "";// 无层户门楼牌
		String bzdz_wrjzjzw = "";// 无人居住建筑物
		String bzdz_wbzdzdyhjdz = "";// 无标准地址对应户籍地址
		String bzdz_qsdmlph = "";// 缺少的门楼牌号

		HashMap map = new HashMap();
		map.put("dbrwfqpcsdm", getSessionBean().getUserOrgCode());
		List<DbrwDdbrwb> list = dbrwMainService.queryDdbrwbList(map);
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				DbrwDdbrwb bean = list.get(i);
				if ("DC4A5D794B2D42E9862B5B978D1B21BA".equals(bean.getDbmxid())) {
					gwry = bean.getId();
				}
				if ("9AD87AE4A63F4B089F52544CC3E4B07E".equals(bean.getDbmxid())) {
					zdry = bean.getId();
				}
				if ("F86AE4A6E6754464A8AB3EF48D1D5F6E".equals(bean.getDbmxid())) {
					syrk_wzjzd = bean.getId();
				}
				if ("A7D9858777F146DA80D9C0D426E94B1C".equals(bean.getDbmxid())) {
					syrk_wyry = bean.getId();
				}
				if ("718DD320402249BB99B6840926EE8408".equals(bean.getDbmxid())) {
					syrk_yywjzd = bean.getId();
				}
				if ("3F93097553E34BEC9DD7F70767FB5925".equals(bean.getDbmxid())) {
					syfw_dj = bean.getId();
				}
				if ("CC51C3AAB08448668A1F0D0A5385DD15".equals(bean.getDbmxid())) {
					syfw_qj = bean.getId();
				}
				if ("15D9845505C14BEF8F3C658986536318".equals(bean.getDbmxid())) {
					syfw_wrjz = bean.getId();
				}
				if ("32264DA2945A424297C18613666A6077".equals(bean.getDbmxid())) {
					sydw_ldxjd = bean.getId();
				}
				if ("3BC189E54F99495EB87411255C1D8A9A".equals(bean.getDbmxid())) {
					sydw_wcyry = bean.getId();
				}
				if ("06C63C87B17C8812E053E105500A282C".equals(bean.getDbmxid())) {
					bzdz_wbzmlp = bean.getId();
				}
				if ("06C63C87B17D8812E053E105500A282C".equals(bean.getDbmxid())) {
					bzdz_wchmlp = bean.getId();
				}
				if ("06C63C87B17E8812E053E105500A282C".equals(bean.getDbmxid())) {
					bzdz_wrjzjzw = bean.getId();
				}
				if ("06C63C87B17F8812E053E105500A282C".equals(bean.getDbmxid())) {
					bzdz_wbzdzdyhjdz = bean.getId();
				}
				if ("06C63C87B1808812E053E105500A282C".equals(bean.getDbmxid())) {
					bzdz_qsdmlph = bean.getId();
				}
			}
		}
		
		DbrwMainVo sydwVo = dbrwMainService.getSydwMax(getSessionBean().getUserOrgCode());
		DbrwMainVo syfwVo = dbrwMainService.getSyfwMax(getSessionBean().getUserOrgCode());
		String zdryDbzt = dbrwMainService.getMaxByDbmxid(getSessionBean().getUserOrgCode(), "'9AD87AE4A63F4B089F52544CC3E4B07E'");
		String gwdqDbzt = dbrwMainService.getMaxByDbmxid(getSessionBean().getUserOrgCode(), "'DC4A5D794B2D42E9862B5B978D1B21BA'");
		String syrkDbzt = dbrwMainService.getMaxByDbmxid(getSessionBean().getUserOrgCode(), "'F86AE4A6E6754464A8AB3EF48D1D5F6E', 'A7D9858777F146DA80D9C0D426E94B1C', '718DD320402249BB99B6840926EE8408'");
		String bzdzDbzt = dbrwMainService.getMaxByDbmxid(getSessionBean().getUserOrgCode(), "'06C63C87B17C8812E053E105500A282C', '06C63C87B17D8812E053E105500A282C', '06C63C87B17E8812E053E105500A282C', '06C63C87B17F8812E053E105500A282C', '06C63C87B1808812E053E105500A282C'");
		
		int zdryCount = 0;
		int gwdqCount = 0;
		int syrk_wzjzdCount = 0;
		int syrk_wyryCount = 0;
		int syrk_yywjzdCount = 0;
		int bzdz_wbzmlpCount = 0;
		int bzdz_wchmlpCount = 0;
		int bzdz_wrjzjzwCount = 0;
		int bzdz_wbzdzdyhjdzCount = 0;
		int bzdz_qsdmlphCount = 0;
		
		if(zdryDbzt.equals("wdb")){
			zdryCount = dbrwMainService.queryDdbrwsjmxbCount(getSessionBean().getUserOrgCode(), "9AD87AE4A63F4B089F52544CC3E4B07E");			
		}else if(zdryDbzt.equals("dbz")){
			zdryCount = dbrwMainService.queryDbrwsjmxbCount(getSessionBean().getUserOrgCode(), "9AD87AE4A63F4B089F52544CC3E4B07E", "");	
		}else if(zdryDbzt.equals("ydb")){
			zdryCount = dbrwMainService.queryDbrwsjmxbCount(getSessionBean().getUserOrgCode(), "9AD87AE4A63F4B089F52544CC3E4B07E", "1");	
		}
		if(gwdqDbzt.equals("wdb")){
			gwdqCount = dbrwMainService.queryDdbrwsjmxbCount(getSessionBean().getUserOrgCode(), "DC4A5D794B2D42E9862B5B978D1B21BA");			
		}else if(zdryDbzt.equals("dbz")){
			gwdqCount = dbrwMainService.queryDbrwsjmxbCount(getSessionBean().getUserOrgCode(), "DC4A5D794B2D42E9862B5B978D1B21BA", "");	
		}else if(zdryDbzt.equals("ydb")){
			gwdqCount = dbrwMainService.queryDbrwsjmxbCount(getSessionBean().getUserOrgCode(), "DC4A5D794B2D42E9862B5B978D1B21BA", "1");
		}
		if(syrkDbzt.equals("wdb")){
			syrk_wzjzdCount = dbrwMainService.queryDdbrwsjmxbCount(getSessionBean().getUserOrgCode(), "F86AE4A6E6754464A8AB3EF48D1D5F6E");
			syrk_wyryCount = dbrwMainService.queryDdbrwsjmxbCount(getSessionBean().getUserOrgCode(), "A7D9858777F146DA80D9C0D426E94B1C");
			syrk_yywjzdCount = dbrwMainService.queryDdbrwsjmxbCount(getSessionBean().getUserOrgCode(), "718DD320402249BB99B6840926EE8408");
		}else if(syrkDbzt.equals("dbz")){
			syrk_wzjzdCount = dbrwMainService.queryDbrwsjmxbCount(getSessionBean().getUserOrgCode(), "F86AE4A6E6754464A8AB3EF48D1D5F6E", "");	
			syrk_wyryCount = dbrwMainService.queryDbrwsjmxbCount(getSessionBean().getUserOrgCode(), "A7D9858777F146DA80D9C0D426E94B1C", "");	
			syrk_yywjzdCount = dbrwMainService.queryDbrwsjmxbCount(getSessionBean().getUserOrgCode(), "718DD320402249BB99B6840926EE8408", "");	
		}else if(syrkDbzt.equals("ydb")){
			syrk_wzjzdCount = dbrwMainService.queryDbrwsjmxbCount(getSessionBean().getUserOrgCode(), "F86AE4A6E6754464A8AB3EF48D1D5F6E", "1");	
			syrk_wyryCount = dbrwMainService.queryDbrwsjmxbCount(getSessionBean().getUserOrgCode(), "A7D9858777F146DA80D9C0D426E94B1C", "1");	
			syrk_yywjzdCount = dbrwMainService.queryDbrwsjmxbCount(getSessionBean().getUserOrgCode(), "718DD320402249BB99B6840926EE8408", "1");	
		}
		if(bzdzDbzt.equals("wdb")){
			bzdz_wbzmlpCount = dbrwMainService.queryDdbrwsjmxbCount(getSessionBean().getUserOrgCode(), "06C63C87B17C8812E053E105500A282C");
			bzdz_wchmlpCount = dbrwMainService.queryDdbrwsjmxbCount(getSessionBean().getUserOrgCode(), "06C63C87B17D8812E053E105500A282C");
			bzdz_wrjzjzwCount = dbrwMainService.queryDdbrwsjmxbCount(getSessionBean().getUserOrgCode(), "06C63C87B17E8812E053E105500A282C");
			bzdz_wbzdzdyhjdzCount = dbrwMainService.queryDdbrwsjmxbCount(getSessionBean().getUserOrgCode(), "06C63C87B17F8812E053E105500A282C");
			bzdz_qsdmlphCount = dbrwMainService.queryDdbrwsjmxbCount(getSessionBean().getUserOrgCode(), "06C63C87B1808812E053E105500A282C");
		}else if(bzdzDbzt.equals("dbz")){
			bzdz_wbzmlpCount = dbrwMainService.queryDbrwsjmxbCount(getSessionBean().getUserOrgCode(), "06C63C87B17C8812E053E105500A282C", "");
			bzdz_wchmlpCount = dbrwMainService.queryDbrwsjmxbCount(getSessionBean().getUserOrgCode(), "06C63C87B17D8812E053E105500A282C", "");
			bzdz_wrjzjzwCount = dbrwMainService.queryDbrwsjmxbCount(getSessionBean().getUserOrgCode(), "06C63C87B17E8812E053E105500A282C", "");
			bzdz_wbzdzdyhjdzCount = dbrwMainService.queryDbrwsjmxbCount(getSessionBean().getUserOrgCode(), "06C63C87B17F8812E053E105500A282C", "");
			bzdz_qsdmlphCount = dbrwMainService.queryDbrwsjmxbCount(getSessionBean().getUserOrgCode(), "06C63C87B1808812E053E105500A282C", "");
		}else if(bzdzDbzt.equals("ydb")){
			bzdz_wbzmlpCount = dbrwMainService.queryDbrwsjmxbCount(getSessionBean().getUserOrgCode(), "06C63C87B17C8812E053E105500A282C", "1");
			bzdz_wchmlpCount = dbrwMainService.queryDbrwsjmxbCount(getSessionBean().getUserOrgCode(), "06C63C87B17D8812E053E105500A282C", "1");
			bzdz_wrjzjzwCount = dbrwMainService.queryDbrwsjmxbCount(getSessionBean().getUserOrgCode(), "06C63C87B17E8812E053E105500A282C", "1");
			bzdz_wbzdzdyhjdzCount = dbrwMainService.queryDbrwsjmxbCount(getSessionBean().getUserOrgCode(), "06C63C87B17F8812E053E105500A282C", "1");
			bzdz_qsdmlphCount = dbrwMainService.queryDbrwsjmxbCount(getSessionBean().getUserOrgCode(), "06C63C87B1808812E053E105500A282C", "1");
		}
		
		mv.addObject("gwry", gwry);
		mv.addObject("zdry", zdry);
		mv.addObject("syrk_wzjzd", syrk_wzjzd);
		mv.addObject("syrk_wyry", syrk_wyry);
		mv.addObject("syrk_yywjzd", syrk_yywjzd);
		mv.addObject("syfw_dj", syfw_dj);
		mv.addObject("syfw_qj", syfw_qj);
		mv.addObject("syfw_wrjz", syfw_wrjz);
		mv.addObject("sydw_ldxjd", sydw_ldxjd);
		mv.addObject("sydw_wcyry", sydw_wcyry);
		mv.addObject("sydwVo", sydwVo);
		mv.addObject("syfwVo", syfwVo);
		mv.addObject("bzdz_wbzmlp", bzdz_wbzmlp);
		mv.addObject("bzdz_wchmlp", bzdz_wchmlp);
		mv.addObject("bzdz_wrjzjzw", bzdz_wrjzjzw);
		mv.addObject("bzdz_wbzdzdyhjdz", bzdz_wbzdzdyhjdz);
		mv.addObject("bzdz_qsdmlph", bzdz_qsdmlph);
		
		mv.addObject("zdryDbzt", zdryDbzt);
		mv.addObject("gwdqDbzt", gwdqDbzt);
		mv.addObject("syrkDbzt", syrkDbzt);
		mv.addObject("bzdzDbzt", bzdzDbzt);
		
		mv.addObject("zdryCount", zdryCount);
		mv.addObject("gwdqCount", gwdqCount);
		mv.addObject("syrk_wzjzdCount", syrk_wzjzdCount);
		mv.addObject("syrk_wyryCount", syrk_wyryCount);
		mv.addObject("syrk_yywjzdCount", syrk_yywjzdCount);

		mv.addObject("bzdz_wbzmlpCount", bzdz_wbzmlpCount);
		mv.addObject("bzdz_wchmlpCount", bzdz_wchmlpCount);
		mv.addObject("bzdz_wrjzjzwCount", bzdz_wrjzjzwCount);
		mv.addObject("bzdz_wbzdzdyhjdzCount", bzdz_wbzdzdyhjdzCount);
		mv.addObject("bzdz_qsdmlphCount", bzdz_qsdmlphCount);
		return mv;
	}
	
	/**
	 * 
	 * @Title: queryDdbrwsjmxbList
	 * @Description: TODO(待办任务查询)
	 * @param @param dbmxid 待办模型id
	 * @param @param maxNum 最大查询条数
	 * @param @param response 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/queryDdbrwsjmxbList", method = RequestMethod.GET)
	public @ResponseBody
	EasyUIPage queryDdbrwsjmxbList(EasyUIPage page, @RequestParam(value = "rows") Integer rows, DbrwDdbrwb entity) {
		page.setPagePara(rows);
		if (!StringUtils.isBlank(entity.getDbmxid())) {
			String dbzt = entity.getDbzt();
			
			if(dbzt.equals("wdb")){//未督办
				entity.setDbrwfqpcsdm(getSessionBean().getUserOrgCode());
				page = dbrwMainService.queryDdbrwsjmxb(page, entity);
			}else if(dbzt.equals("dbz")){//督办中
				DbrwDbrwb vo = new DbrwDbrwb();
				vo.setDbrwfqpcsdm(getSessionBean().getUserOrgCode());
				vo.setDbmxid(entity.getDbmxid());
				if (!StringUtils.isBlank(entity.getDdbsjx1())){
					vo.setDbsjx1(entity.getDdbsjx1());
				}
				if (!StringUtils.isBlank(entity.getDdbsjx9())){
					vo.setDbsjx9(entity.getDdbsjx9());
				}
				page = dbrwMainService.queryDbrwsjmxb(page, vo);
				
			}else if(dbzt.equals("ydb")){//已督办
				DbrwDbrwb vo = new DbrwDbrwb();
				vo.setDbrwfqpcsdm(getSessionBean().getUserOrgCode());
				vo.setDbmxid(entity.getDbmxid());
				if (!StringUtils.isBlank(entity.getDdbsjx1())){
					vo.setDbsjx1(entity.getDdbsjx1());
				}
				if (!StringUtils.isBlank(entity.getDdbsjx9())){
					vo.setDbsjx9(entity.getDdbsjx9());
				}
				vo.setSfwcdm("1");
				page = dbrwMainService.queryDbrwsjmxb(page, vo);
			}
		}
		
		return page;
	}

	/**
	 * 
	 * @Title: querySydwChart
	 * @Description: TODO(实有单位饼状图)
	 * @param @return 设定文件
	 * @return Map<String,Object> 返回类型
	 * @throws
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/querySydwChart", method = RequestMethod.GET)
	public @ResponseBody
	Map<String, Object> querySydwChart(String dbzt, String time) {
		HashMap map = new HashMap();
		map.put("dbrwfqpcsdm", getSessionBean().getUserOrgCode());
		map.put("dbzt", dbzt);
		return dbrwMainService.querySydwChart(map);
	}

	/**
	 * 
	 * @Title: querySyfwChart
	 * @Description: TODO(实有房屋饼状图)
	 * @param @return 设定文件
	 * @return Map<String,Object> 返回类型
	 * @throws
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/querySyfwChart", method = RequestMethod.GET)
	public @ResponseBody
	Map<String, Object> querySyfwChart(String dbzt, String time) {
		HashMap map = new HashMap();
		map.put("dbrwfqpcsdm", getSessionBean().getUserOrgCode());
		map.put("dbzt", dbzt);
		return dbrwMainService
				.querySyfwChart(map);
	}

	/**
	 * 
	 * @Title: queryGwryChart
	 * @Description: TODO(高危人员柱状图)
	 * @param @param zzjgdm 组织机构代码
	 * @param @return 设定文件
	 * @return Map<String,Object> 返回类型
	 * @throws
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/queryGwryChart", method = RequestMethod.GET)
	public @ResponseBody
	Map<String, Object> queryGwryChart(String dbzt, String time) {
		HashMap map = new HashMap();
		map.put("dbrwfqpcsdm", getSessionBean().getUserOrgCode());
		map.put("dbmxid", "DC4A5D794B2D42E9862B5B978D1B21BA");
		map.put("dbzt", dbzt);
		return dbrwMainService.queryGwryChart(map);// 测试
	}

	/**
	 * 
	 * @Title: queryZdryChart
	 * @Description: TODO(重点人员饼状图)
	 * @param @return 设定文件
	 * @return Map<String,Object> 返回类型
	 * @throws
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/queryZdryChart", method = RequestMethod.GET)
	public @ResponseBody
	Map<String, Object> queryZdryChart(String dbzt, String time) {
		HashMap map = new HashMap();
		map.put("dbrwfqpcsdm", getSessionBean().getUserOrgCode());
		map.put("dbmxid", "9AD87AE4A63F4B089F52544CC3E4B07E");
		map.put("dbzt", dbzt);
		return dbrwMainService.queryZdryChart(map);
	}

	/**
	 * 
	 * @Title: queryDbrwList
	 * @Description: TODO(督办任务列表)
	 * @param @param page
	 * @param @param rows
	 * @param @return 设定文件
	 * @return EasyUIPage 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/queryDbrwList", method = RequestMethod.GET)
	public @ResponseBody
	EasyUIPage queryDbrwList(EasyUIPage page,
			@RequestParam(value = "rows") Integer rows) {
		page.setPagePara(rows);
		String pcs = getSessionBean().getUserOrgCode();
		return dbrwMainService.queryDbrwList(page, pcs);
	}
	
	
	
	/**
	 * 重点人员展示类型
	 * @Title: queryDbrwList
	 * @Description: TODO(督办任务列表)
	 * @param @param page
	 * @param @param rows
	 * @param @return 设定文件
	 * @return EasyUIPage 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/queryShowType", method = RequestMethod.GET)
	public @ResponseBody String queryShowType(String ywzlid) {
		Map<String,String> coultMap = new HashMap();
		coultMap.put("ywzlid", ywzlid);
		coultMap.put("sspcsdm", super.getSessionBean().getUserOrgCode());
		return dbrwMainService.queryShowType(coultMap);
	}
	
	/**
	 * 
	 * @Title: queryJctjList
	 * @Description: TODO(纠错统计)
	 * @param @param page
	 * @param @param rows
	 * @param @return 设定文件
	 * @return EasyUIPage 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/queryJctjList", method = RequestMethod.GET)
	public @ResponseBody
	EasyUIPage queryJctjList(EasyUIPage page, @RequestParam(value = "rows") Integer rows) {
		page.setPagePara(rows);
		String pcs = getSessionBean().getUserOrgCode();
		return dbrwMainService.queryJctjList(page, pcs);
	}
	
	@RequestMapping(value = "/getTypeCount", method = RequestMethod.POST)
	public @ResponseBody
	Map getTypeCount(String dbzt, String dbmxid, String columName) {
		Map<String, Object> model = new HashMap<String, Object>();
		
		int count = 0;
		
		if(dbzt.equals("wdb")){
			count = dbrwMainService.queryDdbrwsjmxbCount(getSessionBean().getUserOrgCode(), dbmxid);
		}else if(dbzt.equals("dbz")){
			count = dbrwMainService.queryDbrwsjmxbCount(getSessionBean().getUserOrgCode(), dbmxid, "");
		}else if(dbzt.equals("ydb")){
			count = dbrwMainService.queryDbrwsjmxbCount(getSessionBean().getUserOrgCode(), dbmxid, "1");	
		}
		
		model.put("count", count);
		return model;
	}


}
