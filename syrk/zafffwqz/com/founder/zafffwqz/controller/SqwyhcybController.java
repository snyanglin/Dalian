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
import com.founder.zafffwqz.bean.Sqwyhcyb;
import com.founder.zafffwqz.service.SqwyhcybService;

import com.google.gson.Gson;

@Controller
@RequestMapping(value = "/sqwyhcyb")
public class SqwyhcybController extends BaseController {
	
	private Logger logger = Logger.getLogger(this.getClass());
	
	@Resource(name = "sqwyhcybService")
	private SqwyhcybService sqwyhcybService;
	
	/**
	 * 添加 社区委员会成员表
	 */
	@RequestMapping(value = "/addSqwyhcyb", method = RequestMethod.GET)
	public @ResponseBody
	ModelAndView addSqwyhcyb(String jwsid,String id) {
		ModelAndView mv = new ModelAndView("zafffwqz/sqwyhcybAdd");
		Sqwyhcyb entity = new Sqwyhcyb();
		if (!StringUtils.isBlank(id)) {
			entity.setId(id);
			entity = sqwyhcybService.querySqwyhcyb(entity);
		}
		entity.setSqjwsid(jwsid);
		mv.addObject("entity", entity);
		return mv;
	}

	/**
	 * 保存 社区委员会成员表
	 * @param entity
	 * @return
	 */
	@RequestMapping(value = "/saveSqwyhcyb", method = RequestMethod.POST)
	public @ResponseBody
	ModelAndView saveSqwyhcyb(Sqwyhcyb entity) {
		ModelAndView mv = new ModelAndView("redirect:/forward/"
				+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		try {
			if (entity.getId() == null || entity.getId().equals("")) {
				sqwyhcybService.saveSqwyhcyb(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "新增【社区委员会成员】成功！");
				model.put(AppConst.SAVE_ID, entity.getId()); // 返回主键
			} else {
				sqwyhcybService.updateSqwyhcyb(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "修改【社区委员会成员】成功！");
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
