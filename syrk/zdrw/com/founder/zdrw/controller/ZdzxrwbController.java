package com.founder.zdrw.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

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
import com.founder.zdrw.bean.Zdzxrwb;
import com.founder.zdrw.service.ZdzxrwbService;

import com.google.gson.Gson;

@Controller
@RequestMapping(value = "zdzxrwb")
public class ZdzxrwbController extends BaseController {
	
	private Logger logger = Logger.getLogger(this.getClass());
	
	@Resource(name="zdzxrwbService")
	private ZdzxrwbService zdzxrwbService;
	
	/**
	 * 跳转
	 * @param id
	 * @param mainTabID
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/zdzxrwbList", method = RequestMethod.GET)
	public ModelAndView zdzxrwList(String id,String mainTabID) {
		
		ModelAndView mv = new ModelAndView("zdzxrw/zdzxrwbList");
		mv.addObject("mainTabID", mainTabID);
		Zdzxrwb entity = new Zdzxrwb();
		if (!StringUtils.isBlank(id)) {
			entity.setId(id);
			entity = zdzxrwbService.queryZdzxrwbById(entity);
		}
		mv.addObject("entity", entity);
		return mv;
	}
	
	/**
	 * 查询
	 * @param page
	 * @param rows
	 * @param entity
	 * @return
	 */
	@RequestMapping(value = "/queryList", method = RequestMethod.POST)
	public @ResponseBody
	EasyUIPage queryList(EasyUIPage page,
			@RequestParam(value = "rows") Integer rows, Zdzxrwb entity){
		page.setPagePara(rows);
		SessionBean sessionBean = getSessionBean();
		if(null != sessionBean){
		}
		return this.zdzxrwbService.queryList(page, entity);
	}
	
	/**
	 * 跳转新增
	 * @param id
	 * @param mainTabID
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/zdzxrwbAdd", method = RequestMethod.GET)
	public ModelAndView addZdzxrwb(String id,String mainTabID) {
		ModelAndView mv = new ModelAndView("zdzxrw/zdzxrwbAdd");
		mv.addObject("mainTabID", mainTabID);
		Zdzxrwb entity = new Zdzxrwb();
		
		if (!StringUtils.isBlank(id)) {
			entity.setId(id);
			entity = zdzxrwbService.queryZdzxrwbById(entity);
		}
		mv.addObject("entity", entity);
		return mv;
	}
	
	/**
	 * 新增和修改
	 * @param entity
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/saveZdzxrwb", method = RequestMethod.POST)
	public ModelAndView saveZdzxrwb(Zdzxrwb entity){
		
		ModelAndView mv = new ModelAndView("redirect:/forward/" + AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		try {
			if (entity.getId() == null || entity.getId().equals("")) {	//新增
				
				zdzxrwbService.insertZdzxrwb(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES,  getMessage("add.success"));
				model.put(AppConst.SAVE_ID, entity.getId()); // 返回主键
			} else {	//修改
				
				zdzxrwbService.updateZdzxrwb(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES,  getMessage("update.success"));
			}
		}catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getLocalizedMessage(), e);
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, getAddFail());
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}
	
	/**
	 * 注销
	 * @param entity
	 * @return
	 */
	@RequestMapping(value = "/deleteZdzxrwb", method = RequestMethod.POST)
	public @ResponseBody
	ModelAndView deleteZdzxrw(Zdzxrwb entity){
		
		ModelAndView mv = new ModelAndView("redirect:/forward/"	+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = new SessionBean();
		
		try {
			
			zdzxrwbService.deleteZdzxrwb(entity, sessionBean);
			model.put(AppConst.STATUS, AppConst.SUCCESS);
			model.put(AppConst.MESSAGES,  getMessage("cancel.success"));
		} catch (Exception e) {
			
			e.printStackTrace();
			logger.error(e.getLocalizedMessage(), e);
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, getAddFail());
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}
}