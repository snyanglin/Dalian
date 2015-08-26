package com.founder.zafffwqz.controller;

import java.util.HashMap;
import java.util.List;
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
import com.founder.zafffwqz.bean.Zazzryxxb;
import com.founder.zafffwqz.service.ZazzryxxbService;

import com.google.gson.Gson;

@Controller
@RequestMapping(value = "/zazzryxxb")
public class ZazzryxxbController extends BaseController{
	
	private Logger logger = Logger.getLogger(this.getClass());
	
	@Resource(name = "zazzryxxbService")
	private ZazzryxxbService zazzryxxbService;
	
	/**
	 * 跳转-治安组织人员信息
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/addZazzryxxb", method = RequestMethod.GET)
	public @ResponseBody ModelAndView addZazzryxxb(String sqid,String jwsid, String id){
		ModelAndView mv = new ModelAndView("zafffwqz/zazzryxxadd");
		Zazzryxxb entity = new Zazzryxxb();
		if (!StringUtils.isBlank(id)) {
			entity.setId(id);
			entity = zazzryxxbService.queryZazzryxxb(entity);
			mv.addObject("flag", "update");
		}
		entity.setSqid(sqid);
		entity.setSqjwsid(jwsid);
		mv.addObject("entity", entity);
		return mv;
	}
	
	/**
	 * 添加-治安组织人员信息
	 * @param entity
	 * @return
	 */
	@RequestMapping(value = "/saveZazzryxxb", method = RequestMethod.POST)
	public @ResponseBody ModelAndView saveZazzryxxb(Zazzryxxb entity){
		ModelAndView mv = new ModelAndView("redirect:/forward/"
				+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		try {
			if (entity.getId() == null || entity.getId().equals("")) {
				zazzryxxbService.saveZazzryxxb(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "新增【治安组织人员信息】成功！");
				model.put(AppConst.SAVE_ID, entity.getId()); // 返回主键
			} else {
				zazzryxxbService.updateZazzryxxb(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "修改【治安组织人员信息】成功！");
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
	
	/**
	 * 注销-治安组织人员信息
	 * @param entity
	 * @return
	 */
	@RequestMapping(value = "/deleteZazzryxxb", method = RequestMethod.POST)
	public ModelAndView DeleteZazzryxxb(Zazzryxxb entity) {
		ModelAndView mv = new ModelAndView("redirect:/forward/"
				+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		try {
			if (entity.getId() != null) { // 注销
				zazzryxxbService.deleteZazzryxxb(entity, sessionBean);
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
	
	
	@RequestMapping(value = "/getsftj", method = RequestMethod.POST)
	public @ResponseBody
	String getSftj(String zjhm,String zjlx) {
		Zazzryxxb entity = new Zazzryxxb();
		entity.setCyzjdm(zjlx);
		entity.setZjhm(zjhm);
		if(zazzryxxbService.queryZazzryxxb(entity).getId()!=null){
			return "true";
		}else{
		return "false";
		}
	}
	
}
