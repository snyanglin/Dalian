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
import com.founder.sydw_dl.bean.Dwjcxxb;
import com.founder.sydw_dl.service.DwjcxxbService;

import com.google.gson.Gson;
@Controller
@RequestMapping(value = "dwjcxxb_dl")
public class DwjcxxbController extends BaseController{
	
	private Logger logger = Logger.getLogger(this.getClass());
	@Resource(name = "dwjcxxbService")
	private DwjcxxbService dwjcxxbService;
	
	/**
	 * 添加
	 * @param id
	 * @param dwid
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public @ResponseBody
	ModelAndView add(String id, String dwid) {
		ModelAndView mv = new ModelAndView("sydw_dl/dwjcAdd");
		Dwjcxxb entity = new Dwjcxxb();
		entity.setDwid(dwid);
		if (!StringUtils.isBlank(id)) {
			entity.setId(id);
			entity = dwjcxxbService.query(entity);
		}
		mv.addObject("entity", entity);
		return mv;
	}
	
	/**
	 * 保存检查信息信息
	 * @param entity
	 * @return
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(Dwjcxxb entity){
		ModelAndView mv = new ModelAndView("redirect:/forward/"
				+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		try {
			if(null==entity.getId()||"".equals(entity.getId())){
				entity.setXt_zxbz("0");
				dwjcxxbService.save(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "新增【检查信息】成功！");
				model.put(AppConst.SAVE_ID, entity.getId()); // 返回主键
			} else {
				dwjcxxbService.update(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "修改【检查信息】成功！");
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
