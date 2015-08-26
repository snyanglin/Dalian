package com.founder.yjjb.controller;

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
import com.founder.framework.utils.UUID;
import com.founder.yjjb.bean.Ajxxb;
import com.founder.yjjb.bean.Fjajgxb;
import com.founder.yjjb.service.FjajgxbService;

import com.google.gson.Gson;

@Controller
@RequestMapping(value = "/fjajgxb")
public class FjajgxbController extends BaseController {

	private Logger logger = Logger.getLogger(this.getClass());
	
	@Resource(name="fjajgxbService")
	private FjajgxbService fjajgxbService;
	
	/**
	 * 新增
	 * @param entity
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(Ajxxb entity,String xsId){
		ModelAndView mv = new ModelAndView("yjjb/xgajList");
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		
		model.put(AppConst.STATUS, AppConst.SUCCESS);
		model.put(AppConst.MESSAGES,  getMessage("add.success"));
		model.put(AppConst.SAVE_ID, entity.getId()); // 返回主键
		
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}
	
	/**
	 * 注销
	 * @param entity
	 * @return
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public @ResponseBody
	ModelAndView delete(Fjajgxb entity){
		
		ModelAndView mv = new ModelAndView("redirect:/forward/"	+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		
		try {
			
			fjajgxbService.delete(entity, sessionBean);
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
	
	/**
	 * 生成附件分类的id
	 * @param xsbh
	 * @return
	 */
	@RequestMapping(value = "/generalNum", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> ifExistAjNum(String ajbh){
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("fujianFLid", UUID.create());
		return model;
	}
}
