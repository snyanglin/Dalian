package com.founder.zafffwqz.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.founder.framework.base.controller.BaseController;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.components.AppConst;
import com.founder.framework.utils.StringUtils;
import com.founder.zafffwqz.bean.Sqjbxxb;
import com.founder.zafffwqz.service.SqjbxxbService;

import com.google.gson.Gson;

@Controller
@RequestMapping(value = "/sqjbxxb")
public class SqjbxxbController extends BaseController {

	private Logger logger = Logger.getLogger(this.getClass());

	@Resource(name = "sqjbxxbService")
	private SqjbxxbService sqjbxxbService;

	/**
	 * 添加 社区基本信息表
	 */
	@RequestMapping(value = "/addSqjbxxb", method = RequestMethod.GET)
	public @ResponseBody
	ModelAndView addSqjbxxb(String jwsid, String id) {
		ModelAndView mv = new ModelAndView("zafffwqz/sqjbxxbAdd");
		Sqjbxxb entity = new Sqjbxxb();
		if (!StringUtils.isBlank(id)) {
			entity.setId(id);
			entity = sqjbxxbService.querySqjbxxb(entity);
		}
		entity.setSqjwsid(jwsid);
		mv.addObject("entity", entity);
		return mv;
	}

	/**
	 * 保存 社区基本信息表
	 * 
	 * @param entity
	 * @return
	 */
	@RequestMapping(value = "/saveSqjbxxb", method = RequestMethod.POST)
	public @ResponseBody
	ModelAndView saveSqjbxxb(Sqjbxxb entity) {
		ModelAndView mv = new ModelAndView("redirect:/forward/"
				+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		try {
			if (entity.getId() == null || entity.getId().equals("")) {
				sqjbxxbService.saveSqjbxxb(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "新增【社区基本信息】成功！");
				model.put(AppConst.SAVE_ID, entity.getId()); // 返回主键
			} else {
				sqjbxxbService.updateSqjbxxb(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "修改【社区基本信息】成功！");
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

	@RequestMapping(value = "/getSqjbxxb", method = RequestMethod.POST)
	public @ResponseBody
	Map getSqjbxxb(String jwsid) {
		Map<String, Object> model = new HashMap<String, Object>();
		Sqjbxxb sqjbxxb = sqjbxxbService.querrBySqjwsid(jwsid);
		model.put("sqjbxxb", sqjbxxb);
		return model;
	}

}
