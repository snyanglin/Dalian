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

import com.google.gson.Gson;

import com.founder.framework.base.controller.BaseController;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.components.AppConst;
import com.founder.framework.utils.StringUtils;
import com.founder.zafffwqz.bean.Bazzryxxb;
import com.founder.zafffwqz.service.BazzryxxbService;

@Controller
@RequestMapping(value = "/bazzryxxb")
public class BazzryxxbController extends BaseController{
	
	private Logger logger = Logger.getLogger(this.getClass());
	
	@Resource(name = "bazzryxxbService")
	private BazzryxxbService bazzryxxbService;
	/**
	 * 跳转-保安组织人员信息
	 * @param jwsid
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/addBazzryxxb", method = RequestMethod.GET)
	public @ResponseBody ModelAndView addBazzryxxb(String sqid,String jwsid,String id,String bazzid){
		ModelAndView mv = new ModelAndView("zafffwqz/bazzryxxadd");
		Bazzryxxb entity = new Bazzryxxb();
		if(!StringUtils.isBlank(id)){
			entity.setId(id);
			entity = bazzryxxbService.queryBazzryxxb(entity);
		}
		entity.setSqid(sqid);
		entity.setSqjwsid(jwsid);
		entity.setBazzid(bazzid);
		mv.addObject("entity", entity);
		return mv;
	}
	/**
	 * 添加-保安组织人员信息
	 * @param entity
	 * @return
	 */
	@RequestMapping(value = "saveBazzryxxb",method = RequestMethod.POST)
	public @ResponseBody ModelAndView saveBazzryxxb(Bazzryxxb entity){
		ModelAndView mv = new ModelAndView("redirect:/forward/"+AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		try {
			if (entity.getId() == null || entity.getId().equals("")) {
				bazzryxxbService.saveBazzryxxb(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "新增【保安组织人员信息】成功！");
				model.put(AppConst.SAVE_ID, entity.getId()); // 返回主键
			} else {
				bazzryxxbService.updateBazzryxxb(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "修改【保安组织人员信息】成功！");
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
	
	public ModelAndView deleteBazzryxxb(Bazzryxxb entity){
		ModelAndView mv = new ModelAndView("redirect:/forward/"
				+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		try {
			if (entity.getId() != null) { // 注销
				bazzryxxbService.deleteBazzryxxb(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, getMessage("cancel.success"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getLocalizedMessage(), e);
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, getMessage("cancel.fail"));
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}
}
