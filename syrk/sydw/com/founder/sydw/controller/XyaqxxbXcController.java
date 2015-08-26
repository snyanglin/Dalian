package com.founder.sydw.controller;

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
import com.founder.sydw.bean.Dwxyaqxxb;
import com.founder.sydw.bean.XyaqxxbXc;
import com.founder.sydw.service.DwxyaqService;
import com.founder.sydw.service.XyaqxxbXcService;

@Controller
@RequestMapping(value = "/xyaqxxbXc")
public class XyaqxxbXcController extends BaseController {
	
	private Logger logger = Logger.getLogger(this.getClass());
	
	@Resource(name = "xyaqxxbXcService")
	private XyaqxxbXcService xyaqxxbXcService;
	
	@Resource(name = "dwxyaqService")
	private DwxyaqService dwxyaqService;
	
	/**
	 * 添加 校车信息表
	 * @param id
	 * @param ryid
	 * @return
	 */
	@RequestMapping(value = "/addXyaqxxbXc", method = RequestMethod.GET)
	public @ResponseBody
	ModelAndView addXyaqxxbXc(String id, String dwid) {
		ModelAndView mv = new ModelAndView("sydw/xyaqxxbXcAdd");
		XyaqxxbXc entity = new XyaqxxbXc();
		Dwxyaqxxb dwxyaqxxb =dwxyaqService.queryByDwid(dwid);
		if(dwxyaqxxb != null){
			entity.setXyid(dwxyaqxxb.getId());
		}
		if (!StringUtils.isBlank(id)) {
			entity.setId(id);
			entity = xyaqxxbXcService.queryXyaqxxbXc(entity);
		}
		mv.addObject("entity", entity);
		return mv;
	}
	
	/**
	 * 保存校车信息表
	 * @param tkjzryxxb
	 * @return
	 */
	@RequestMapping(value = "/saveXyaqxxbXc", method = RequestMethod.POST)
	public @ResponseBody
	ModelAndView saveXyaqxxbXc(XyaqxxbXc entity) {
		ModelAndView mv = new ModelAndView("redirect:/forward/"
				+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		try {
			if (entity.getId() == null || entity.getId().equals("")) {
				xyaqxxbXcService.saveXyaqxxbXc(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "新增【校车信息】成功！");
				model.put(AppConst.SAVE_ID, entity.getId()); // 返回主键
			} else {
				xyaqxxbXcService.update(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "修改【校车信息】成功！");
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

