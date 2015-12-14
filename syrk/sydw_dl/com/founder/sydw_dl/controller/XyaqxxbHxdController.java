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

import com.google.gson.Gson;

import com.founder.framework.base.controller.BaseController;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.components.AppConst;
import com.founder.framework.utils.StringUtils;
import com.founder.sydw_dl.bean.Dwxyaqxxb;
import com.founder.sydw_dl.bean.XyaqxxbHxd;
import com.founder.sydw_dl.service.DwxyaqService;
import com.founder.sydw_dl.service.XyaqxxbHxdService;

@Controller
@RequestMapping(value = "/xyaqxxbHxd_dl")
public class XyaqxxbHxdController extends BaseController {
	
	private Logger logger = Logger.getLogger(this.getClass());
	
	@Resource(name = "xyaqxxbHxdService")
	private XyaqxxbHxdService xyaqxxbHxdService;
	
	@Resource(name = "dwxyaqService")
	private DwxyaqService dwxyaqService;
	
	/**
	 * 添加 护校队信息表
	 * @param id
	 * @param ryid
	 * @return
	 */
	@RequestMapping(value = "/addXyaqxxbHxd", method = RequestMethod.GET)
	public @ResponseBody
	ModelAndView addXyaqxxbHxd(String id, String dwid) {
		ModelAndView mv = new ModelAndView("sydw_dl/xyaqxxbHxdAdd");
		XyaqxxbHxd entity = new XyaqxxbHxd();
		Dwxyaqxxb dwxyaqxxb =dwxyaqService.queryByDwid(dwid);
		if(dwxyaqxxb != null){
			entity.setXyid(dwxyaqxxb.getId());
		}
		if (!StringUtils.isBlank(id)) {
			entity.setId(id);
			entity = xyaqxxbHxdService.queryXyaqxxbHxd(entity);
		}
		mv.addObject("entity", entity);
		return mv;
	}
	
	/**
	 * 保存护校队信息表
	 * @param tkjzryxxb
	 * @return
	 */
	@RequestMapping(value = "/saveXyaqxxbHxd", method = RequestMethod.POST)
	public @ResponseBody
	ModelAndView saveXyaqxxbHxd(XyaqxxbHxd entity) {
		ModelAndView mv = new ModelAndView("redirect:/forward/"
				+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		try {
			if (entity.getId() == null || entity.getId().equals("")) {
				xyaqxxbHxdService.saveXyaqxxbHxd(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "新增【护校队信息】成功！");
				model.put(AppConst.SAVE_ID, entity.getId()); // 返回主键
			} else {
				xyaqxxbHxdService.update(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "修改【护校队信息】成功！");
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

