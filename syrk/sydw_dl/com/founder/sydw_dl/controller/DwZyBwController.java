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
import com.founder.sydw_dl.bean.DwzybwXxb;
import com.founder.sydw_dl.service.DwZyBwService;

import com.google.gson.Gson;
@Controller
@RequestMapping(value = "dwzybw_dl")
public class DwZyBwController extends BaseController {
	
	private Logger logger = Logger.getLogger(this.getClass());
	
	@Resource(name = "dwzybwService")
	private DwZyBwService dwzybwService;
	
	
	@RequestMapping(value = "/createPage", method = RequestMethod.GET)
	public @ResponseBody
	ModelAndView createPage(String id, String dwid) {
		ModelAndView mv = new ModelAndView("sydw_dl/dwzybwxxbAdd");
		SessionBean sessionBean = getSessionBean();
		DwzybwXxb entity = new DwzybwXxb();
		String flag ="add";
		if (!StringUtils.isBlank(id)) {
			entity.setId(id);
			entity = dwzybwService.queryZybw(entity, sessionBean);
			flag="update";
		}
		entity.setDwid(dwid);
		mv.addObject("entity", entity);
		mv.addObject("flag", flag);
		return mv;
	}
	
	/**
	 * 保存重要部位信息
	 * @param entity
	 * @return
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(DwzybwXxb entity){
		ModelAndView mv = new ModelAndView("redirect:/forward/"
				+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		try {
			if(null==entity.getId()||"".equals(entity.getId())){
				entity.setXt_zxbz("0");
				dwzybwService.save(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "新增【重要部位】成功！");
				model.put(AppConst.SAVE_ID, entity.getId()); // 返回主键
			} else {
				dwzybwService.update(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "修改【重要部位】成功！");
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
