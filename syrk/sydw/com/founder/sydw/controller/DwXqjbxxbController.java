package com.founder.sydw.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import com.founder.framework.base.controller.BaseController;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.components.AppConst;
import com.founder.framework.utils.EasyUIPage;
import com.founder.sydw.bean.Dwjbxxb;
import com.founder.sydw.bean.Dwxqxxb;
import com.founder.sydw.service.DwXqjbxxbService;

@Controller
@RequestMapping("/dwxqjbxxb")
public class DwXqjbxxbController extends BaseController{
	private Logger logger = Logger.getLogger(this.getClass());
	
	@Resource(name = "dwXqjbxxbService")
	private DwXqjbxxbService dwXqjbxxbService;

	@RequestMapping(value = "/queryDwXq", method = RequestMethod.POST)
	public @ResponseBody
	EasyUIPage queryDwXq(EasyUIPage page,
			@RequestParam(value = "rows") Integer rows, Dwxqxxb entity) {
		page.setPagePara(rows);
		return dwXqjbxxbService.queryDwXq(page, entity);
	}
	
	@RequestMapping(value = "/queryCountDwXq", method = RequestMethod.POST)
	public @ResponseBody
		long queryCountDwXq(Dwxqxxb entity) {
		return dwXqjbxxbService.queryCountDwXq(entity);
	}
	
	
	@RequestMapping(value = "/createPage", method = RequestMethod.GET)
	public @ResponseBody
	ModelAndView createPage(String id) {
		ModelAndView mv = new ModelAndView("sydw/sydwXqxxAdd");
		Dwxqxxb entity = new Dwxqxxb();
	    if (!StringUtils.isBlank(id)) {
			entity = dwXqjbxxbService.query(id);
		}
		mv.addObject("entity", entity);
		return mv;
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(Dwxqxxb entity){
		ModelAndView mv = new ModelAndView("redirect:/forward/"
				+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		if (entity.getId() == null || entity.getId().equals("")) {
			try {
				dwXqjbxxbService.save(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "新增【小区信息】成功！");
				model.put(AppConst.SAVE_ID, entity.getId()); // 返回主键
				
			} catch (Exception e) {
				logger.error(e.getLocalizedMessage(), e);
				model.put(AppConst.STATUS, AppConst.FAIL);
				model.put(AppConst.MESSAGES, getAddFail());
			}

		} else {
			try {
				dwXqjbxxbService.update(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "修改【小区信息】成功！");
				model.put(AppConst.SAVE_ID, entity.getId()); 
			} catch (Exception e) {
				logger.error(e.getLocalizedMessage(), e);
				model.put(AppConst.STATUS, AppConst.FAIL);
				model.put(AppConst.MESSAGES, getUpdateFail());
			}
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}
	
	@RequestMapping(value = "/dwxqzx",method = RequestMethod.GET)
	public @ResponseBody int dwxqzx(Dwxqxxb entity){
		SessionBean sessionBean = getSessionBean();
		return dwXqjbxxbService.dwxqzx(entity,sessionBean);
	}
	
}
