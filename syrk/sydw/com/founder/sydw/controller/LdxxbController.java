package com.founder.sydw.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import com.founder.framework.base.controller.BaseController;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.components.AppConst;
import com.founder.framework.utils.StringUtils;
import com.founder.sydw.bean.Ldxxb;
import com.founder.sydw.service.LdxxbService;

@Controller
@RequestMapping(value = "/ldxxb")
public class LdxxbController extends BaseController {
	
	private Logger logger = Logger.getLogger(this.getClass());
	
	@Resource(name = "ldxxbService")
	private LdxxbService ldxxbService;
	
	/**
	 * 添加 旅馆信息表
	 * @param id
	 * @param ryid
	 * @return
	 */
	@RequestMapping(value = "/addLdxxb", method = RequestMethod.GET)
	public @ResponseBody
	ModelAndView addLdxxb(String id, String dwid) {
		ModelAndView mv = new ModelAndView("sydw/ldxxbAdd");
		Ldxxb entity = new Ldxxb();
		entity.setDwid(dwid);
		if (!StringUtils.isBlank(id)) {
			entity.setId(id);
			entity = ldxxbService.queryLdxxb(entity);
		}
		mv.addObject("entity", entity);
		return mv;
	}
	
	/**
	 * 保存 旅店信息表
	 * @param tkjzryxxb
	 * @return
	 */
	@RequestMapping(value = "/saveLdxxb", method = RequestMethod.POST)
	public @ResponseBody
	ModelAndView saveLdxxb(Ldxxb entity) {
		ModelAndView mv = new ModelAndView("redirect:/forward/"
				+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		try {
			if (entity.getId() == null || entity.getId().equals("")) {
				ldxxbService.saveLdxxb(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "新增【旅店信息】成功！");
				model.put(AppConst.SAVE_ID, entity.getId()); // 返回主键
			} else {
				ldxxbService.updateLdxxb(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "修改【旅店信息】成功！");
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

