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
import com.founder.zafffwqz.bean.Sqzbhb;
import com.founder.zafffwqz.service.SqzbhbService;

import com.google.gson.Gson;

@Controller
@RequestMapping(value = "/sqzbhb")
public class SqzbhbController extends BaseController {

private Logger logger = Logger.getLogger(this.getClass());
	
	@Resource(name="sqzbhbService")
	private SqzbhbService sqzbhbService;
	
	/**
	 *跳转-社区治保会
	 * @param fwid
	 * @param fwdzid
	 * @return
	 */
	@RequestMapping(value = "/addSqzbhb", method = RequestMethod.GET)
	public @ResponseBody
	ModelAndView addSqjwsxxb(String jwsid, String id) {
		ModelAndView mv = new ModelAndView("zafffwqz/sqzbhbAdd");
		Sqzbhb entity = new Sqzbhb();
		String flag = "add";
		if(!"".equals(id)&&id!=null){
			entity.setId(id);
			entity = sqzbhbService.querySqzbhb(entity);
			flag ="update";
		}
		
		entity.setSqjwsid(jwsid);
		mv.addObject("entity", entity);
		mv.addObject("flag", flag);
		return mv;
	}
	/**
	 * 保存、修改-社区治保会
	 * @param Fwglrtgrzb
	 * @return
	 */
	@RequestMapping(value = "/saveSqzbhb", method = RequestMethod.POST)
	public ModelAndView saveSqzbhb(Sqzbhb entity){
		ModelAndView mv = new ModelAndView("redirect:/forward/"
				+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		try {
			if(null==entity.getId()||"".equals(entity.getId())){
				entity.setXt_zxbz("0");
				sqzbhbService.saveSqzbhb(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "新增【社区治保会信息】成功！");
				model.put(AppConst.SAVE_ID, entity.getId()); // 返回主键
			} else {
				sqzbhbService.updateSqzbhb(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "修改【社区治保会信息】成功！");
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
