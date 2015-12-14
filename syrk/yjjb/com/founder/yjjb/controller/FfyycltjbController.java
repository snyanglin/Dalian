package com.founder.yjjb.controller;

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
import com.founder.yjjb.bean.Ajxxb;
import com.founder.yjjb.bean.Ffyycltjb;
import com.founder.yjjb.service.AjxxbService;
import com.founder.yjjb.service.CommonService;
import com.founder.yjjb.service.FfyycltjbService;

import com.google.gson.Gson;

/**
 * 非法营运车辆统计表</br>
 * @author Administrator
 * @since 2014-12-19
 */
@Controller
@RequestMapping(value = "/ffyycltjb")
public class FfyycltjbController extends BaseController {

	private Logger logger = Logger.getLogger(this.getClass());
	
	@Resource(name="ffyycltjbService")
	private FfyycltjbService ffyycltjbService;
	
	@Resource(name="commonService")
	private CommonService commonService;
	
	@Resource(name="ajxxbService")
	private AjxxbService ajxxbService;
	
	/**
	 * 跳转
	 * @param id
	 * @param mainTabID
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/openList", method = RequestMethod.GET)
	public ModelAndView ffyycltjbList(String id,String mainTabID) {
		
		ModelAndView mv = new ModelAndView("yjjb/ffyyclList");
		mv.addObject("mainTabID", mainTabID);
		Ffyycltjb entity = new Ffyycltjb();
		
		if (!StringUtils.isBlank(id)) {
			
			entity.setId(id);
			entity = ffyycltjbService.queryById(entity);
		}
		mv.addObject("entity", entity);
		return mv;
	}
	
	/**
	 * 查询</br>
	 * @param page
	 * @param rows
	 * @param entity
	 * @return
	 */
	@RequestMapping(value = "/query", method = RequestMethod.POST)
	public @ResponseBody
	EasyUIPage queryList(EasyUIPage page,
			@RequestParam(value = "rows") Integer rows, Ffyycltjb entity){
		
		page.setPagePara(rows);
		SessionBean sessionBean = getSessionBean();
		if(null != sessionBean){
			
		}
		return this.ffyycltjbService.queryList(page,entity);
	}
	
	/**
	 * 跳转新增/编辑页面
	 * @param id
	 * @param mainTabID
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/openAdd", method = RequestMethod.GET)
	public ModelAndView add(String id,String mainTabID) {
		
		ModelAndView mv = new ModelAndView("yjjb/ffyyclAdd");
		mv.addObject("mainTabID", mainTabID);
		Ffyycltjb entity = new Ffyycltjb();
		
		if (!StringUtils.isBlank(id)) {
			
			entity.setId(id);
			entity = ffyycltjbService.queryById(entity);
		}
		
		mv.addObject("entity", entity);
		return mv;
	}
	
	/**
	 * 新增和修改
	 * @param entity
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(Ffyycltjb entity){
		
		ModelAndView mv = new ModelAndView("redirect:/forward/" + AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		String orgCode = sessionBean.getUserOrgCode();
		try {
			
			if (entity.getId() == null || entity.getId().equals("")) {	//新增
				entity.setId(commonService.CreateNewSeq("12", orgCode));
				String dwjb = commonService.getDwjb(orgCode);
				if(null!=dwjb)
				if("00".equals(dwjb.trim())){
					entity.setSlfzdm(orgCode);
					String slzdm = commonService.queryUpOrgID(orgCode);
					entity.setSlzdm(slzdm);
					entity.setSlzxdm(commonService.queryUpOrgID(slzdm));
				}
				else if("01".equals(dwjb.trim())){
					entity.setSlzdm(orgCode);
					entity.setSlzxdm(commonService.queryUpOrgID(orgCode));
				}
				else if("02".equals(dwjb.trim())) entity.setSlzxdm(orgCode);
				ffyycltjbService.save(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES,  getMessage("add.success"));
				model.put(AppConst.SAVE_ID, entity.getId()); // 返回主键
			} else {	//修改
				
				ffyycltjbService.update(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES,  getMessage("update.success"));
			}
		}catch (Exception e) {
			
			e.printStackTrace();
			logger.error(e.getLocalizedMessage(), e);
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, getAddFail());
		}
		
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}
	
	/**
	 * 注销
	 * @param entity
	 * @return
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public @ResponseBody
	ModelAndView delete(Ffyycltjb entity){
		
		ModelAndView mv = new ModelAndView("redirect:/forward/"	+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		
		try {
			
			ffyycltjbService.delete(entity, sessionBean);
			model.put(AppConst.STATUS, AppConst.SUCCESS);
			model.put(AppConst.MESSAGES,  getMessage("cancel.success"));
		} catch (Exception e) {
			
			e.printStackTrace();
			logger.error(e.getLocalizedMessage(), e);
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, getAddFail());
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}
	
	/**
	 * 查询案件编号是否存在
	 * @param entity
	 * @return
	 */
	@RequestMapping(value = "/queryAjxxByAjbh", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> queryAjxxByAjbh(String ajbh){
		Map<String, Object> model = new HashMap<String, Object>();
		Ajxxb ajxxb = new Ajxxb();
		ajxxb.setAjbh(ajbh);
		ajxxb = ajxxbService.queryAllAjxxByAjbh(ajxxb);
		if(ajxxb==null){ ajxxb = new Ajxxb(); ajxxb.setAjbh("0000");}
		model.put("ajbh", ajxxb.getAjbh());
		return model;
	}
}
