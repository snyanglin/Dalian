package com.founder.sydw_dl.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.founder.framework.base.controller.BaseController;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.components.AppConst;
import com.founder.sydw_dl.bean.Dwcfxxb;
import com.founder.sydw_dl.service.DwcfxxbService;

import com.google.gson.Gson;
@Controller
@RequestMapping(value = "/dwcfxxb_dl")
public class DwcfxxbController extends BaseController {
	
	private Logger logger = Logger.getLogger(this.getClass());
	
	@Resource(name = "dwcfxxbService")
	private DwcfxxbService dwcfxxbService;
	
	/**
	 * 跳转
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView edit(String id,String dwid){
		ModelAndView mv = new ModelAndView("sydw_dl/dwcfAdd");
		Dwcfxxb entity = new Dwcfxxb();
		entity.setDwid(dwid);
		if(null!=id&&!"".equals(id)){
			entity.setId(id);
			entity = dwcfxxbService.queryEntityById(entity);
		}
		mv.addObject("entity", entity);
		return mv;
	}
	/**
	 * 单位处罚
	 * @param entity
	 * @return
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(Dwcfxxb entity){
		ModelAndView mv = new ModelAndView("redirect:/forward/"
				+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		try {
			if(null==entity.getId()||"".equals(entity.getId())){
				entity.setXt_zxbz("0");
				dwcfxxbService.save(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "新增【单位处罚】成功！");
				model.put(AppConst.SAVE_ID, entity.getId()); // 返回主键
			} else {
				dwcfxxbService.update(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "修改【单位处罚】成功！");
			}
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
