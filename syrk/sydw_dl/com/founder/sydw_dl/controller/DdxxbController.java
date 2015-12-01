package com.founder.sydw_dl.controller;

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
import com.founder.sydw_dl.bean.Ddxxb;
import com.founder.sydw_dl.service.DdxxbService;

@Controller
@RequestMapping(value = "/ddxxb_dl")
public class DdxxbController extends BaseController {
	
	private Logger logger = Logger.getLogger(this.getClass());
	
	@Resource(name = "ddxxbService")
	private DdxxbService ddxxbService;
	
	/**
	 * 添加 典当业信息表
	 * @param id
	 * @param ryid
	 * @return
	 */
	@RequestMapping(value = "/addDdxxb", method = RequestMethod.GET)
	public @ResponseBody
	ModelAndView addDdxxb(String id, String dwid) {
		ModelAndView mv = new ModelAndView("sydw_dl/ddxxbAdd");
		Ddxxb entity = new Ddxxb();
		entity.setDwid(dwid);
		if (!StringUtils.isBlank(id)) {
			entity.setId(id);
			entity = ddxxbService.queryDdxxb(entity);
		}
		mv.addObject("entity", entity);
		return mv;
	}

	/**
	 * 保存 典当业信息表
	 * @param tkjzryxxb
	 * @return
	 */
	@RequestMapping(value = "/saveDdxxb", method = RequestMethod.POST)
	public @ResponseBody
	ModelAndView saveDdxxb(Ddxxb entity) {
		ModelAndView mv = new ModelAndView("redirect:/forward/"
				+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		try {
			if (entity.getId() == null || entity.getId().equals("")) {
				ddxxbService.saveDdxxb(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "新增【典当业信息】成功！");
				model.put(AppConst.SAVE_ID, entity.getId()); // 返回主键
			} else {
				ddxxbService.updateDdxxb(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "修改【典当业信息】成功！");
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
