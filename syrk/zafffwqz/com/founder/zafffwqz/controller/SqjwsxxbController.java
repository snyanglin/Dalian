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
import com.founder.zafffwqz.bean.Sqjwsxxb;
import com.founder.zafffwqz.service.SqjwsxxbService;

import com.google.gson.Gson;


@Controller
@RequestMapping(value = "/sqjwsxxb")
public class SqjwsxxbController extends BaseController {
	
	private Logger logger = Logger.getLogger(this.getClass());
	
	@Resource(name="sqjwsxxbService")
	private SqjwsxxbService sqjwsxxbService;
	
	/**
	 *跳转-社区警务室
	 * @param fwid
	 * @param fwdzid
	 * @return
	 */
	@RequestMapping(value = "/addSqjwsxxb", method = RequestMethod.GET)
	public @ResponseBody
	ModelAndView addSqjwsxxb(String id) {
		ModelAndView mv = new ModelAndView("zafffwqz/sqjwsxxbEdit");
		Sqjwsxxb entity = new Sqjwsxxb();
		if(!"".equals(id)&&id!=null){
			entity.setId(id);
		}
		mv.addObject("entity", entity);
		entity = sqjwsxxbService.querySqjwsxxb(entity);
		if(entity != null){
			mv.addObject("entity", entity);
		}
		return mv;
	}

	@RequestMapping(value = "/saveAddSqjwsxxb", method = RequestMethod.POST)
	public ModelAndView saveAddSqjwsxxb(Sqjwsxxb entity){
		
		ModelAndView mv = new ModelAndView("zafffwqz/zaffEdit");
		SessionBean sessionBean = getSessionBean();
		
		try {
			entity.setXt_zxbz("0");
			sqjwsxxbService.saveSqjwsxxb(entity, sessionBean);
			mv.addObject("entity", entity);

		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getLocalizedMessage(), e);
		}
		return mv;
	}
	
	/**
	 * 保存、修改
	 * @param Fwglrtgrzb
	 * @return
	 */
	@RequestMapping(value = "/saveSqjwsxxb", method = RequestMethod.POST)
	public ModelAndView saveSqjwsxxb(Sqjwsxxb entity){
		ModelAndView mv = new ModelAndView("redirect:/forward/"
				+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		try {
			if(null==entity.getId() || "".equals(entity.getId())){
				entity.setXt_zxbz("0");
				sqjwsxxbService.saveSqjwsxxb(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "新增【社区警务室信息】成功！");
				model.put(AppConst.SAVE_ID, entity.getId()); // 返回主键
			} else {
				sqjwsxxbService.updateSqjwsxxb(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "修改【社区警务室信息】成功！");
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
