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
import com.founder.zafffwqz.bean.Sqmjxxb;
import com.founder.zafffwqz.service.SqmjxxbService;

import com.google.gson.Gson;

@Controller
@RequestMapping(value = "/sqmjxxb")
public class SqmjxxbController extends BaseController {

private Logger logger = Logger.getLogger(this.getClass());
	
	@Resource(name="sqmjxxbService")
	private SqmjxxbService sqmjxxbService;
	
	/**
	 *跳转-社区民警
	 * @param fwid
	 * @param fwdzid
	 * @return
	 */
	@RequestMapping(value = "/addSqmjxxb", method = RequestMethod.GET)
	public @ResponseBody
	ModelAndView addSqjwsxxb(String jwsid, String id) {
		ModelAndView mv = new ModelAndView("zafffwqz/sqmjxxbAdd");
		Sqmjxxb entity = new Sqmjxxb();
		if(!"".equals(id)&&id!=null){
			entity.setId(id);
			entity = sqmjxxbService.querySqmjxxb(entity);
		}
		entity.setSqjwsid(jwsid);
		mv.addObject("entity", entity);
		return mv;
	}
	/**
	 * 保存、修改
	 * @param Fwglrtgrzb
	 * @return
	 */
	@RequestMapping(value = "/saveSqmjxxb", method = RequestMethod.POST)
	public ModelAndView saveSqmjxxb(Sqmjxxb entity){
		ModelAndView mv = new ModelAndView("redirect:/forward/"
				+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		try {
			if(null==entity.getId()||"".equals(entity.getId())){
				entity.setXt_zxbz("0");
				sqmjxxbService.saveSqmjxxb(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "新增【社区民警信息】成功！");
				model.put(AppConst.SAVE_ID, entity.getId()); // 返回主键
			} else {
				sqmjxxbService.updateSqmjxxb(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "修改【社区民警信息】成功！");
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
