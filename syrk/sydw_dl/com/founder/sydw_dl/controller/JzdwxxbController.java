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

import com.founder.framework.base.controller.BaseController;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.components.AppConst;
import com.founder.framework.utils.StringUtils;
import com.founder.sydw_dl.bean.Jzdwxxb;
import com.founder.sydw_dl.service.JzdwxxbService;

import com.google.gson.Gson;

@Controller
@RequestMapping(value = "/jzdwxxb_dl")
public class JzdwxxbController extends BaseController {
	
	private Logger logger = Logger.getLogger(this.getClass());
	
	@Resource(name = "jzdwxxbService")
	private JzdwxxbService jzdwxxbService;
	
	/**
	 * 添加 旅馆信息表
	 * @param id
	 * @param ryid
	 * @return
	 */
	@RequestMapping(value = "/addJzdwxxb", method = RequestMethod.GET)
	public @ResponseBody
	ModelAndView addLdxxb(String id, String dwid) {
		ModelAndView mv = new ModelAndView("sydw_dl/jzdwxxbAdd");
		Jzdwxxb entity = new Jzdwxxb();
		entity.setDwid(dwid);
		if (!StringUtils.isBlank(id)) {
			entity.setId(id);
			entity = jzdwxxbService.queryById(id);
		}
		mv.addObject("entity", entity);
		return mv;
	}
	
	/**
	 * 保存 旅店信息表
	 * @param tkjzryxxb
	 * @return
	 */
	@RequestMapping(value = "/saveJzdwxxb", method = RequestMethod.POST)
	public @ResponseBody
	ModelAndView saveLdxxb(Jzdwxxb entity) {
		ModelAndView mv = new ModelAndView("redirect:/forward/"
				+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		try {
			if (entity.getId() == null || entity.getId().equals("")) {
				jzdwxxbService.saveJzdwxxb(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "新增【技侦单位信息】成功！");
				model.put(AppConst.SAVE_ID, entity.getId()); // 返回主键
			} else {
				jzdwxxbService.updateJzdwxb(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "修改【技侦单位信息】成功！");
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

