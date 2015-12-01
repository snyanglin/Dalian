package com.founder.sydw_dl.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.founder.framework.base.controller.BaseController;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.components.AppConst;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.sydw_dl.bean.Frfzrllrb;
import com.founder.sydw_dl.service.FrfzrllrbService;

import com.google.gson.Gson;

@Controller
@RequestMapping(value = "dwfrfzrllyxxb_dl")
public class FrfzrllrbController extends BaseController {
	
	private Logger logger = Logger.getLogger(this.getClass());
	
	@Resource(name = "frfzrllrbService")
	private FrfzrllrbService frfzrllrbService;
	
	/**
	 * 
	 * @param id 从业人员id
	 * @param dwid 单位id
	 * @param dwmc 单位名称
	 * @return
	 */
	@RequestMapping(value = "/createPage", method = RequestMethod.GET)
	public @ResponseBody
	ModelAndView createPage(String id, String dwid) {
		ModelAndView mv = new ModelAndView("sydw_dl/dwfrfzrllyxxbAdd");
		SessionBean sessionBean = getSessionBean();
		Frfzrllrb entity = new Frfzrllrb();

		if (!StringUtils.isBlank(id)) {
			entity = frfzrllrbService.queryById(id);
		}
		if (sessionBean != null) {
			mv.addObject("pcsdm", sessionBean.getExtendValue("ssPcsCode"));
			mv.addObject("zrqdm", sessionBean.getUserOrgCode());
		}
		entity.setDwid(dwid);
		mv.addObject("entity", entity);
		return mv;
	}
	
	/**
	 * 保存法人\负责人\联络员信息
	 * @param entity
	 * @return
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public @ResponseBody
	ModelAndView save(Frfzrllrb entity) {
		ModelAndView mv = new ModelAndView("redirect:/forward/"
				+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();

		try {
			if (entity.getId() == null || entity.getId().equals("")) {
				boolean returnBoolean = frfzrllrbService.add(entity, sessionBean);
				if(returnBoolean){
					model.put(AppConst.STATUS, AppConst.SUCCESS);
					model.put(AppConst.MESSAGES, "新增【法人/负责人/联络员】成功！");
					model.put(AppConst.SAVE_ID, entity.getId()); // 返回主键					
				}else{
					model.put(AppConst.STATUS, AppConst.FAIL);
					model.put(AppConst.MESSAGES, "新增【法人/负责人/联络员】失败，因为一个单位只能有一个法人！");
				}
				
			} else {
				boolean returnBoolean = frfzrllrbService.update(entity, sessionBean);
				if(returnBoolean){
					model.put(AppConst.STATUS, AppConst.SUCCESS);
					model.put(AppConst.MESSAGES, "修改【法人/负责人/联络员】成功！");					
				}else{
					model.put(AppConst.STATUS, AppConst.FAIL);
					model.put(AppConst.MESSAGES, "修改【法人/负责人/联络员】失败，因为一个单位只能有一个法人！");	
				}
				
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

	
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public @ResponseBody EasyUIPage list(EasyUIPage page,
			@RequestParam(value = "rows") Integer rows, String dwid) {
		page.setPagePara(rows);
		return frfzrllrbService.queryList(page, dwid);
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public ModelAndView deleteDwfrfzrllyxxb(Frfzrllrb entity) {
		ModelAndView mv = new ModelAndView("redirect:/forward/" + AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			frfzrllrbService.delete(entity,  getSessionBean());
			model.put(AppConst.STATUS, AppConst.SUCCESS);
			model.put(AppConst.MESSAGES, getMessage("cancel.success"));
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage(), e);
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, getMessage("cancel.fail"));
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}
}
