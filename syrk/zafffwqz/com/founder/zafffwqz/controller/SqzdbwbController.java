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
import com.founder.zafffwqz.bean.Sqzdbwb;
import com.founder.zafffwqz.service.SqzdbwbService;

import com.google.gson.Gson;

@Controller
@RequestMapping(value = "/sqzdbwb")
public class SqzdbwbController extends BaseController {
	
	private Logger logger = Logger.getLogger(this.getClass());
	
	@Resource(name = "sqzdbwbService")
	private SqzdbwbService sqzdbwbService;
	
	/**
	 * 添加 社区重点部位表
	 */
	@RequestMapping(value = "/addSqzdbwb", method = RequestMethod.GET)
	public @ResponseBody
	ModelAndView addSqjbxxb(String jwsid, String id) {
		ModelAndView mv = new ModelAndView("zafffwqz/sqzdbwbAdd");
		Sqzdbwb entity = new Sqzdbwb();
		if (!StringUtils.isBlank(id)) {
			entity.setId(id);
			entity = sqzdbwbService.querySqzdbwb(entity);
		}
		entity.setSqjwsid(jwsid);
		mv.addObject("entity", entity);
		return mv;
	}

	/**
	 * 保存 社区重点部位表
	 * @param entity
	 * @return
	 */
	@RequestMapping(value = "/saveSqzdbwb", method = RequestMethod.POST)
	public @ResponseBody
	ModelAndView saveSqzdbwb(Sqzdbwb entity) {
		ModelAndView mv = new ModelAndView("redirect:/forward/"
				+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		try {
			if (entity.getId() == null || entity.getId().equals("")) {
				sqzdbwbService.saveSqzdbwb(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "新增【社区重点部位】成功！");
				model.put(AppConst.SAVE_ID, entity.getId()); // 返回主键
			} else {
				sqzdbwbService.updateSqzdbwb(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "修改【社区重点部位】成功！");
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
