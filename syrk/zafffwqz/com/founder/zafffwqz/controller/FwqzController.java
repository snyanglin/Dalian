package com.founder.zafffwqz.controller;

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
import com.founder.zafffwqz.bean.Kthb;
import com.founder.zafffwqz.bean.Slzxqzb;
import com.founder.zafffwqz.bean.Tsqtghb;
import com.founder.zafffwqz.bean.Zaffxcb;
import com.founder.zafffwqz.service.FwqzService;

import com.google.gson.Gson;
@Controller
@RequestMapping(value = "/fwqz")
public class FwqzController extends BaseController {

	@Resource(name="fwqzService")
	private FwqzService fwqzService;
	private Logger logger = Logger.getLogger(this.getClass());
	

	@ResponseBody
	@RequestMapping(value = "/addSlzxqz", method = RequestMethod.GET)
	public ModelAndView addSlzxqz(String id,String mainTabID) {
		ModelAndView mv = new ModelAndView("zafffwqz/slzxqzAdd");
		mv.addObject("mainTabID", mainTabID);
		Slzxqzb entity = new Slzxqzb();
		if (!StringUtils.isBlank(id)) {
			entity.setId(id);
			entity = fwqzService.querySlzxqzbById(entity);
		}
		mv.addObject("entity", entity);
		return mv;
	}
	
	@ResponseBody
	@RequestMapping(value = "/slzxqzInFo", method = RequestMethod.GET)
	public ModelAndView slzxqzInFo(String id,String mainTabID) {
		ModelAndView mv = new ModelAndView("zafffwqz/slzxqzInFo");
		mv.addObject("mainTabID", mainTabID);
		Slzxqzb entity = new Slzxqzb();
		if (!StringUtils.isBlank(id)) {
			entity.setId(id);
			entity = fwqzService.querySlzxqzbById(entity);
		}
		mv.addObject("entity", entity);
		return mv;
	}

	@ResponseBody
	@RequestMapping(value = "/addKthb", method = RequestMethod.GET)
	public ModelAndView addKthb(String id,String mainTabID) {
		ModelAndView mv = new ModelAndView("zafffwqz/kthAdd");
		mv.addObject("mainTabID", mainTabID);
		Kthb entity = new Kthb();
		if (!StringUtils.isBlank(id)) {
			entity.setId(id);
			entity = fwqzService.queryKthbById(entity);
		}
		mv.addObject("entity", entity);
		return mv;
	}
	
	@ResponseBody
	@RequestMapping(value = "/kthInFo", method = RequestMethod.GET)
	public ModelAndView kthInFo(String id,String mainTabID) {
		ModelAndView mv = new ModelAndView("zafffwqz/kthInFo");
		mv.addObject("mainTabID", mainTabID);
		Kthb entity = new Kthb();
		if (!StringUtils.isBlank(id)) {
			entity.setId(id);
			entity = fwqzService.queryKthbById(entity);
		}
		mv.addObject("entity", entity);
		return mv;
	}
	
	@ResponseBody
	@RequestMapping(value = "/addZaffxcb", method = RequestMethod.GET)
	public ModelAndView addZaffxcb(String id,String mainTabID) {
		ModelAndView mv = new ModelAndView("zafffwqz/zaffxcAdd");
		mv.addObject("mainTabID", mainTabID);
		Zaffxcb entity = new Zaffxcb();
		if (!StringUtils.isBlank(id)) {
			entity.setId(id);
			entity = fwqzService.queryZaffxcbById(entity);
		}
		mv.addObject("entity", entity);
		return mv;
	}
	
	@ResponseBody
	@RequestMapping(value = "/zaffxcbInfo", method = RequestMethod.GET)
	public ModelAndView zaffxcbInfo(String id,String mainTabID) {
		ModelAndView mv = new ModelAndView("zafffwqz/zaffxcbInFo");
		mv.addObject("mainTabID", mainTabID);
		Zaffxcb entity = new Zaffxcb();
		if (!StringUtils.isBlank(id)) {
			entity.setId(id);
			entity = fwqzService.queryZaffxcbById(entity);
		}
		mv.addObject("entity", entity);
		return mv;
	}
	
	@ResponseBody
	@RequestMapping(value = "/addTsqtghb", method = RequestMethod.GET)
	public ModelAndView addTsqtghb(String id,String mainTabID) {
		ModelAndView mv = new ModelAndView("zafffwqz/tsqtghbAdd");
		mv.addObject("mainTabID", mainTabID);
		Tsqtghb entity = new Tsqtghb();
		if (!StringUtils.isBlank(id)) {
			entity.setId(id);
			entity = fwqzService.queryTsqtghbById(entity);
		}
		mv.addObject("entity", entity);
		return mv;
	}
	
	@ResponseBody
	@RequestMapping(value = "/tsqtghbInFo", method = RequestMethod.GET)
	public ModelAndView tsqtghbInFo(String id,String mainTabID) {
		ModelAndView mv = new ModelAndView("zafffwqz/tsqtghbInFo");
		mv.addObject("mainTabID", mainTabID);
		Tsqtghb entity = new Tsqtghb();
		if (!StringUtils.isBlank(id)) {
			entity.setId(id);
			entity = fwqzService.queryTsqtghbById(entity);
		}
		mv.addObject("entity", entity);
		return mv;
	}
	
	@RequestMapping(value = "/querySlzxqz", method = RequestMethod.POST)
	public @ResponseBody
	EasyUIPage querySlzxqz(EasyUIPage page,
			@RequestParam(value = "rows") Integer rows, Slzxqzb entity) {
		page.setPagePara(rows);
		SessionBean sessionBean = getSessionBean();
		if(null != sessionBean){
		}
		return fwqzService.querySlzxqz(page, entity);
	}
	
	@RequestMapping(value = "/queryKthb", method = RequestMethod.POST)
	public @ResponseBody
	EasyUIPage queryKthb(EasyUIPage page,
			@RequestParam(value = "rows") Integer rows, Kthb entity) {
		page.setPagePara(rows);
		SessionBean sessionBean = getSessionBean();
		if(null != sessionBean){
		}
		return fwqzService.queryKthb(page, entity);
	}
	
	@RequestMapping(value = "/queryZaffxcb", method = RequestMethod.POST)
	public @ResponseBody
	EasyUIPage queryZaffxcb(EasyUIPage page,
			@RequestParam(value = "rows") Integer rows, Zaffxcb entity) {
		page.setPagePara(rows);
		SessionBean sessionBean = getSessionBean();
		if(null != sessionBean){
		}
		return fwqzService.queryZaffxcb(page, entity);
	}
	
	@RequestMapping(value = "/queryTsqtghb", method = RequestMethod.POST)
	public @ResponseBody
	EasyUIPage queryTsqtghb(EasyUIPage page,
			@RequestParam(value = "rows") Integer rows, Tsqtghb entity) {
		page.setPagePara(rows);
		SessionBean sessionBean = getSessionBean();
		if(null != sessionBean){
		}
		return fwqzService.queryTsqtghb(page, entity);
	}
	
	@RequestMapping(value = "/saveSlzxqzb", method = RequestMethod.POST)
	public @ResponseBody
	ModelAndView saveSlzxqzb(Slzxqzb entity) {
		ModelAndView mv = new ModelAndView("redirect:/forward/"
				+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		try {
			if (entity.getId() == null || entity.getId().equals("")) {
				fwqzService.saveSlzxqzb(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "新增【受理咨询求助】成功！");
				model.put(AppConst.SAVE_ID, entity.getId()); // 返回主键
			} else {
				fwqzService.updateSlzxqzb(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "修改【受理咨询求助】成功！");
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
	
	@RequestMapping(value = "/saveKthb", method = RequestMethod.POST)
	public @ResponseBody
	ModelAndView saveKthb(Kthb entity) {
		ModelAndView mv = new ModelAndView("redirect:/forward/"
				+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		try {
			if (entity.getId() == null || entity.getId().equals("")) {
				fwqzService.saveKthb(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "新增【恳谈会】成功！");
				model.put(AppConst.SAVE_ID, entity.getId()); // 返回主键
			} else {
				fwqzService.updateKthb(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "修改【恳谈会】成功！");
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
	
	@RequestMapping(value = "/saveZaffxcb", method = RequestMethod.POST)
	public @ResponseBody
	ModelAndView saveZaffxcb(Zaffxcb entity) {
		ModelAndView mv = new ModelAndView("redirect:/forward/"
				+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		try {
			if (entity.getId() == null || entity.getId().equals("")) {
				fwqzService.saveZaffxcb(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "新增【治安防范宣传】成功！");
				model.put(AppConst.SAVE_ID, entity.getId()); // 返回主键
			} else {
				fwqzService.updateZaffxcb(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "修改【治安防范宣传】成功！");
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
	
	@RequestMapping(value = "/saveTsqtghb", method = RequestMethod.POST)
	public @ResponseBody
	ModelAndView saveTsqtghb(Tsqtghb entity) {
		ModelAndView mv = new ModelAndView("redirect:/forward/"
				+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		try {
			if (entity.getId() == null || entity.getId().equals("")) {
				fwqzService.saveTsqtghb(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "新增【特殊群体关怀】成功！");
				model.put(AppConst.SAVE_ID, entity.getId()); // 返回主键
			} else {
				fwqzService.updateTsqtghb(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "修改【特殊群体关怀】成功！");
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
	
	@RequestMapping(value = "/querySlzxqzById", method = RequestMethod.POST)
	public @ResponseBody
		Slzxqzb querySlzxqzById(Slzxqzb entity) {
		SessionBean sessionBean = getSessionBean();
		if(null != sessionBean){
		}
		return fwqzService.querySlzxqzbById(entity);
	}
	
	@RequestMapping(value = "/queryKthbById", method = RequestMethod.POST)
	public @ResponseBody
			Kthb queryKthbById(Kthb entity) {
		SessionBean sessionBean = getSessionBean();
		if(null != sessionBean){
		}
		return fwqzService.queryKthbById(entity);
	}
	
	@RequestMapping(value = "/queryZaffxcbById", method = RequestMethod.POST)
	public @ResponseBody
		Zaffxcb queryZaffxcbById(Zaffxcb entity) {
		SessionBean sessionBean = getSessionBean();
		if(null != sessionBean){
		}
		return fwqzService.queryZaffxcbById(entity);
	}
	
	@RequestMapping(value = "/queryTsqtghbById", method = RequestMethod.POST)
	public @ResponseBody
		Tsqtghb queryTsqtghbById(Tsqtghb entity) {
		SessionBean sessionBean = getSessionBean();
		if(null != sessionBean){
		}
		return fwqzService.queryTsqtghbById(entity);
	}

	@RequestMapping(value = "/deleteSlzxqzb", method = RequestMethod.POST)
	public ModelAndView deleteSlzxqzb(Slzxqzb entity) {
		ModelAndView mv = new ModelAndView("redirect:/forward/"
				+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		try {
			if (entity.getId() != null) { // 注销
				fwqzService.deleteSlzxqzb(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, getMessage("cancel.success"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getLocalizedMessage(), e);
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, getMessage("cancel.fail"));
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}
	
	@RequestMapping(value = "/deleteKthb", method = RequestMethod.POST)
	public ModelAndView deleteKthb(Kthb entity) {
		ModelAndView mv = new ModelAndView("redirect:/forward/"
				+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		try {
			if (entity.getId() != null) { // 注销
				fwqzService.deleteKthb(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, getMessage("cancel.success"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getLocalizedMessage(), e);
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, getMessage("cancel.fail"));
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}
	
	@RequestMapping(value = "/deleteZaffxcb", method = RequestMethod.POST)
	public ModelAndView deleteZaffxcb(Zaffxcb entity) {
		ModelAndView mv = new ModelAndView("redirect:/forward/"
				+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		try {
			if (entity.getId() != null) { // 注销
				fwqzService.deleteZaffxcb(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, getMessage("cancel.success"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getLocalizedMessage(), e);
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, getMessage("cancel.fail"));
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}
	
	@RequestMapping(value = "/deleteTsqtghb", method = RequestMethod.POST)
	public ModelAndView deleteTsqtghb(Tsqtghb entity) {
		ModelAndView mv = new ModelAndView("redirect:/forward/"
				+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		try {
			if (entity.getId() != null) { // 注销
				fwqzService.deleteTsqtghb(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, getMessage("cancel.success"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getLocalizedMessage(), e);
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, getMessage("cancel.fail"));
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}
}
