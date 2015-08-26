package com.founder.sydw.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.founder.framework.base.controller.BaseController;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.components.AppConst;
import com.founder.sydw.bean.Dwyhflcxxb;
import com.founder.sydw.service.DwyhflcxxbService;

import com.google.gson.Gson;
@Controller
@RequestMapping(value = "/dwyhflcxxb")
public class DwyhflcxxbController extends BaseController {
	
	private Logger logger = Logger.getLogger(this.getClass());
	@Resource(name = "dwyhflcxxbService")
	private DwyhflcxxbService dwyhflcxxbService;
	
	
	/**
	 * 跳转
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView add(String id,String dwid){
		ModelAndView mv = new ModelAndView("sydw/dwyhflcAdd");
		Dwyhflcxxb entity = new Dwyhflcxxb();
		entity.setDwid(dwid);
		String flag = "add";
		if(null!=id&&!"".equals(id)){
			entity.setId(id);
			entity = dwyhflcxxbService.query(entity);
			flag ="update";
		}
		mv.addObject("entity", entity);
		mv.addObject("flag", flag);
		return mv;
	}
	/**
	 * 保存银行分理处信息
	 * @param entity
	 * @return
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(Dwyhflcxxb entity){
		ModelAndView mv = new ModelAndView("redirect:/forward/"
				+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		try {
			if(null==entity.getId()||"".equals(entity.getId())){
				entity.setXt_zxbz("0");
				dwyhflcxxbService.save(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "新增【银行分理处信息】成功！");
				model.put(AppConst.SAVE_ID, entity.getId()); // 返回主键
			} else {
				dwyhflcxxbService.update(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "修改【银行分理处信息】成功！");
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
