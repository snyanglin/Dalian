package com.founder.sydw_dl.controller;

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
import com.founder.sydw_dl.bean.Zzyhjzzsbb;
import com.founder.sydw_dl.service.ZzyhjzzsbbService;

import com.google.gson.Gson;

@Controller
@RequestMapping("/zzyhjzzsbb_dl")
public class ZzyhjzzsbbController  extends BaseController {
	
	private Logger logger = Logger.getLogger(this.getClass());
	
	@Resource(name = "zzyhjzzsbbService")
	private ZzyhjzzsbbService zzyhjzzsbbService;
	
	/**
	 * 跳转
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView add(String id,String dwid){
		ModelAndView mv = new ModelAndView("sydw_dl/zzyhjzzsbbAdd");
		Zzyhjzzsbb entity = new Zzyhjzzsbb();
		if(null!=id&&!"".equals(id)){
			entity.setId(id);
			entity = zzyhjzzsbbService.queryZzyhjzzsbbByRyid(entity);
		}
		entity.setDwid(dwid);
		mv.addObject("entity", entity);
		return mv;
	}
	
	/**
	 * 保存、修改
	 * @param 
	 * @return
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(Zzyhjzzsbb entity){
		ModelAndView mv = new ModelAndView("redirect:/forward/"
				+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		try {
			if(null==entity.getId()||"".equals(entity.getId())){
				entity.setXt_zxbz("0");
				zzyhjzzsbbService.saveZzyhjzzsbb(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "新增【自助银行及自助设备】成功！");
				model.put(AppConst.SAVE_ID, entity.getId()); // 返回主键
			} else {
				zzyhjzzsbbService.updateZzyhjzzsbb(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "修改【自助银行及自助设备】成功！");
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
