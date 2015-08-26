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
import com.founder.framework.utils.UUID;
import com.founder.zafffwqz.bean.Bazzb;
import com.founder.zafffwqz.service.BazzbService;

import com.google.gson.Gson;

@Controller
@RequestMapping(value = "/bazzb")
public class BazzbController extends BaseController {

private Logger logger = Logger.getLogger(this.getClass());
	
	@Resource(name="bazzbService")
	private BazzbService bazzbService;
	
	/**
	 *跳转-保安组织
	 * @param fwid
	 * @param fwdzid
	 * @return
	 */
	@RequestMapping(value = "/addBazzb", method = RequestMethod.GET)
	public @ResponseBody
	ModelAndView addBazzb(String jwsid, String id,String sqid) {
		ModelAndView mv = new ModelAndView("zafffwqz/bazzbAdd");
		Bazzb entity = new Bazzb();
		if(!"".equals(id)&&id!=null){
			entity.setId(id);
			entity = bazzbService.queryBazzb(entity);
		}
		entity.setSqid(UUID.create());
		entity.setSqjwsid(jwsid);
		mv.addObject("entity", entity);
		return mv;
	}
	
	/**
	 * 保存、修改-保安组织
	 * @param Fwglrtgrzb
	 * @return
	 */
	@RequestMapping(value = "/saveBazzb", method = RequestMethod.POST)
	public ModelAndView saveBazzb(Bazzb entity){
		ModelAndView mv = new ModelAndView("redirect:/forward/"
				+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		try {
			if(null==entity.getId()||"".equals(entity.getId())){
				entity.setXt_zxbz("0");
				bazzbService.saveBazzb(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "新增【保安组织信息】成功！");
				model.put(AppConst.SAVE_ID, entity.getId()); // 返回主键
			} else {
				bazzbService.updateBazzb(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "修改【保安组织信息】成功！");
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
