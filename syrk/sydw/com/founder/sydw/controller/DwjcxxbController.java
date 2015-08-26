package com.founder.sydw.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.founder.framework.base.controller.BaseController;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.components.AppConst;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.sydw.bean.Dwjcdata;
import com.founder.sydw.bean.Dwjctype;
import com.founder.sydw.bean.Dwjcxxb;
import com.founder.sydw.service.DwjcxxbService;
import com.founder.sydw.vo.SydwgnVO;

import com.google.gson.Gson;
@Controller
@RequestMapping(value = "dwjcxxb")
public class DwjcxxbController extends BaseController{
	
	private Logger logger = Logger.getLogger(this.getClass());
	@Resource(name = "dwjcxxbService")
	private DwjcxxbService dwjcxxbService;
	
	/**
	 * 添加
	 * @param id
	 * @param dwid
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public @ResponseBody ModelAndView add(String id, String dwid,String dwlbdm,String ywlbdm,String mainTabID,String rwid) {
		ModelAndView mv = new ModelAndView("sydw/dwjcAdd");
		Dwjcxxb entity = new Dwjcxxb();
		List<Dwjctype> list = new ArrayList<Dwjctype>();
		entity.setDwid(dwid);
		if (!StringUtils.isBlank(id)) {
			entity.setId(id);
			entity = dwjcxxbService.query(entity);
			list= entity.getList();
		}else{
			Map<String,Object> param = new HashMap<String,Object>();
			param.put("sydwlx", dwlbdm);
			param.put("ywlbdm", ywlbdm);
			list = dwjcxxbService.queryDwjctype(param);
		}
		mv.addObject("entity", entity);
		mv.addObject("list", list);
		mv.addObject("mainTabID", mainTabID);
		mv.addObject("rwid", rwid);
		return mv;
	}
	
	/**
	 * 保存检查信息信息
	 * @param entity
	 * @return
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(Dwjcxxb entity){
		ModelAndView mv = new ModelAndView("redirect:/forward/"
				+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		JSONArray  jcxmxJsonArray =JSONArray.fromObject(entity.getJcxmx());
		List<Dwjctype> list = new ArrayList<Dwjctype>();
		JsonConfig jsonConfig = new JsonConfig();  
		jsonConfig.setRootClass(Dwjctype.class);
		Map<String, Class> classMap = new HashMap<String, Class>();  
		classMap.put("list", Dwjcdata.class); // 指定JsonRpcRequest的request字段的内部类型  
		jsonConfig.setClassMap(classMap);
		list = (List<Dwjctype>)jcxmxJsonArray.toCollection(jcxmxJsonArray, jsonConfig);
		entity.setList(list);
		try {
			if(null==entity.getId()||"".equals(entity.getId())){
				entity.setXt_zxbz("0");
				dwjcxxbService.save(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "新增【检查信息】成功！");
				model.put(AppConst.SAVE_ID, entity.getId()); // 返回主键
			} else {
				dwjcxxbService.update(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "修改【检查信息】成功！");
				model.put(AppConst.SAVE_ID, entity.getId()); // 返回主键
			}
			model.put("ZT", entity.getZt());
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getLocalizedMessage(), e);
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, getAddFail());
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}
	
	/**
	 * @Title: queryList
	 * @Description: 查询列表-单位检查管理
	 * @param @param page
	 * @param @param rows
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/queryList", method = RequestMethod.POST)
	public @ResponseBody EasyUIPage queryDw(EasyUIPage page, @RequestParam(value = "rows")Integer rows,Dwjcxxb entity) {
		page.setPagePara(rows);
		SessionBean sessionBean = getSessionBean();
		entity.setGlfxjid(sessionBean.getExtendValue("ssFsxCode"));
		entity.setGlpcsid(sessionBean.getExtendValue("ssPcsCode"));
		entity.setGlbmid(sessionBean.getUserOrgCode());
		return dwjcxxbService.queryList(page, entity);
	}
	
	/**
	 * 
	 * @Title: selCheckTemp
	 * @Description: 选择检查模板
	 * @param @param id
	 * @param @param dwid
	 * @param @param dwlbdm
	 * @param @return    设定文件
	 * @return ModelAndView    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/selCheckTemp", method = RequestMethod.GET)
	public @ResponseBody ModelAndView selCheckTemp(String id, String dwid,String dwlbdm,String url,String mainTabID,String rwid) {
		ModelAndView mv = new ModelAndView("sydw/selCheckTemp");
		Dwjcxxb entity = new Dwjcxxb();
		entity.setId(id);
		entity.setDwid(dwid);
		entity.setDwlbdm(dwlbdm);
		mv.addObject("entity", entity);
		mv.addObject("mainTabID", mainTabID);
		mv.addObject("rwid", rwid);
		return mv;
	}
	
	/**
	 * 选择模板后保存下一步跳转页面
	 * @param entity
	 * @return
	 */
	@RequestMapping(value = "/saveCheckTemp", method = RequestMethod.POST)
	public ModelAndView saveCheckTemp(Dwjcxxb entity){
		ModelAndView mv = new ModelAndView("redirect:/forward/" + AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put(AppConst.STATUS, AppConst.SUCCESS);
		model.put(AppConst.MESSAGES, "模板匹配成功，跳转检查页面！");
		model.put("entity", entity); // 返回主键
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}
	
	/**
	 * 跳转消防检查页面
	 * @param id
	 * @param dwid
	 * @return
	 */
	@RequestMapping(value = "/addXf", method = RequestMethod.GET)
	public @ResponseBody ModelAndView addXf(String id, String dwid,String mainTabID,String flag,String  rwid) {
		ModelAndView mv = new ModelAndView("sydw/xfDwjcAdd");
		SessionBean sessionBean = getSessionBean();
		Dwjcxxb entity = new Dwjcxxb();
		entity.setDwid(dwid);
		if (!StringUtils.isBlank(id)) {
			entity.setId(id);
			entity = dwjcxxbService.query(entity);
		}else{//新增消防检查信息时，从单位信息中查询回填信息
			entity = dwjcxxbService.queryDwfsxxByDwid(dwid);
			entity.setDwid(dwid);
		}
		if (sessionBean != null) {
			mv.addObject("pcsdm", sessionBean.getExtendValue("ssPcsCode"));
			mv.addObject("zrqdm", sessionBean.getUserOrgCode());
			mv.addObject("pcsmc", sessionBean.getExtendValue("ssPcsName"));
			mv.addObject("fsxdm", sessionBean.getExtendValue("ssFsxCode"));
			mv.addObject("fsxmc", sessionBean.getExtendValue("ssFsxName"));
			mv.addObject("dsjdm", sessionBean.getExtendValue("ssDsjCode"));
			mv.addObject("dsjmc", sessionBean.getExtendValue("ssDsjName"));
		}
		mv.addObject("entity", entity);
		mv.addObject("list",new Gson().toJson(entity.getList()));
		mv.addObject("mainTabID", mainTabID);
		mv.addObject("flag", flag);
		mv.addObject("rwid", rwid);
		return mv;
	}
	/**
	 * 跳转技防检查页面
	 * @param id
	 * @param dwid
	 * @return
	 */
	@RequestMapping(value = "/addJf", method = RequestMethod.GET)
	public @ResponseBody ModelAndView addJf(String id, String dwid,String mainTabID,String flag,String rwid) {
		ModelAndView mv = new ModelAndView("sydw/jfDwjcAdd");
		Dwjcxxb entity = new Dwjcxxb();
		SessionBean sessionBean = getSessionBean();
		entity.setDwid(dwid);
		if (!StringUtils.isBlank(id)) {
			entity.setId(id);
			entity = dwjcxxbService.query(entity);
		}else{//新增消防检查信息时，从单位信息中查询回填信息
			entity = dwjcxxbService.queryDwfsxxByDwid(dwid);
			entity.setDwid(dwid);
		}
		if (sessionBean != null) {
			mv.addObject("pcsdm", sessionBean.getExtendValue("ssPcsCode"));
			mv.addObject("zrqdm", sessionBean.getUserOrgCode());
			mv.addObject("pcsmc", sessionBean.getExtendValue("ssPcsName"));
			mv.addObject("fsxdm", sessionBean.getExtendValue("ssFsxCode"));
			mv.addObject("fsxmc", sessionBean.getExtendValue("ssFsxName"));
			mv.addObject("dsjdm", sessionBean.getExtendValue("ssDsjCode"));
			mv.addObject("dsjmc", sessionBean.getExtendValue("ssDsjName"));
		}
		mv.addObject("entity", entity);
		mv.addObject("list",new Gson().toJson(entity.getList()));
		mv.addObject("mainTabID", mainTabID);
		mv.addObject("flag", flag);
		mv.addObject("dwmc", entity.getDwmc());
		mv.addObject("rwid", rwid);
		return mv;
	}
	/**
	 * 
	 * @Title: dwjcxxb_query
	 * @Description: 单位检查信息查询
	 * @param @param dwid
	 * @param @return    设定文件
	 * @return List<Dwjcxxb>    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/dwjcxxb_query", method = RequestMethod.POST)
	public @ResponseBody List<Dwjcxxb> dwjcxxb_query(String dwid) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("dwid", dwid);
		map.put("maxNum", 10);
		return dwjcxxbService.dwjcxxb_query(map);
	}
}
