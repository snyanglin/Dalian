package com.founder.zdrygl.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.founder.framework.base.controller.BaseController;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.components.AppConst;
import com.founder.framework.organization.department.service.OrgOrganizationService;
import com.founder.framework.utils.EasyUIPage;
import com.founder.qbld.utils.QbldUtil;
import com.founder.syrkgl.bean.RyRyjbxxb;
import com.founder.syrkgl.service.RyRyjbxxbService;
import com.founder.zdrygl.bean.ZdryDtjsClxxb;
import com.founder.zdrygl.bean.ZdryDtjsGxbgxxb;
import com.founder.zdrygl.bean.ZdryDtjsSaxxb;
import com.founder.zdrygl.bean.ZdryDtjsSdfdxxb;
import com.founder.zdrygl.bean.ZdryDtjsSdxdxxb;
import com.founder.zdrygl.bean.ZdryDtjsSdzdxxb;
import com.founder.zdrygl.bean.ZdryDtjsSfxxb;
import com.founder.zdrygl.bean.ZdryDtjsShgxrxxb;
import com.founder.zdrygl.bean.ZdryDtjsSwxxb;
import com.founder.zdrygl.bean.ZdryDtjsXsxxb;
import com.founder.zdrygl.bean.ZdryDtjsZdxsfzqkxxb;
import com.founder.zdrygl.bean.ZdryDtjsZszhjsbrxxb;
import com.founder.zdrygl.bean.ZdryDtjsZtxxb;
import com.founder.zdrygl.bean.ZdryDtjsZszhjsbrZdjlxxb;
import com.founder.zdrygl.bean.ZdryDtjsZszhjsbrZszhjlxxb;
import com.founder.zdrygl.service.ZdryDtjsService;
import com.founder.zdrygl.service.ZdryZdryzbService;
import com.google.gson.Gson;
/**
 * ****************************************************************************
 * @Package:      [com.founder.zdrygl.controller.ZdryEditController.java]  
 * @ClassName:    [ZdryEditController]   
 * @Description:  [重点人员编辑页面控制器]   
 * @Author:       [weiwen]  
 * @CreateDate:   [2015-3-12 上午9:37:09]   
 * @UpdateUser:   [weiwen]   
 * @UpdateDate:   [2015-3-12 上午9:37:09，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Controller
@RequestMapping("zdryDtjs")
public class ZdryDtjsController extends BaseController {
	@Resource(name = "zdryDtjsService")
	private ZdryDtjsService zdryDtjsService;
	
	@Resource(name = "ryRyjbxxbService")
	private RyRyjbxxbService ryRyjbxxbService;
	
	@Resource(name = "orgOrganizationService")
	private OrgOrganizationService orgOrganizationService;
	
	@Resource(name="zdryZdryzbService")
	private ZdryZdryzbService zdryZdryzbService;
	
	
	@RequestMapping(value="/dtjsMain",method = RequestMethod.GET)
	public ModelAndView zdryDtjsZtxxAddPre(String ryid){
		ModelAndView mv = new ModelAndView("zdrygl/dtjs/dtjsMain");
		
		RyRyjbxxb ryRyjbxxb = ryRyjbxxbService.queryById(ryid);//人员基本信息
		List zdryList =zdryZdryzbService.queryList(ryid);
		mv.addObject("ryRyjbxxb",ryRyjbxxb);
		mv.addObject("zdryList",zdryList);
		return mv;
	}		
	
	@RequestMapping(value = "/saveDtjs", method = RequestMethod.POST)
	public @ResponseBody
	ModelAndView saveDtjs(ZdryDtjsXsxxb entity, SessionBean sessionBean) {
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		Map<String, Object> model = new HashMap<String, Object>();
		sessionBean = getSessionBean(sessionBean);
		entity.setTxrid(sessionBean.getUserId());
		entity.setTxrmc(sessionBean.getUserName());
		entity.setTxrdwdm(sessionBean.getUserOrgCode());
		entity.setTxrdwmc(sessionBean.getUserOrgName());
		try {
			zdryDtjsService.saveDtjs(entity);			
			model.put(AppConst.STATUS, AppConst.SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			model.put(AppConst.STATUS, AppConst.FAIL);
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}
	
		
	
	@RequestMapping(value = "/saveDtjsZtxxb", method = RequestMethod.POST)
	public @ResponseBody
	ModelAndView saveDtjsZtxxb(ZdryDtjsZtxxb entity, SessionBean sessionBean) {
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		Map<String, Object> model = new HashMap<String, Object>();
		sessionBean = getSessionBean(sessionBean);
		entity.setLadwdm(sessionBean.getUserOrgCode());
		try {
			zdryDtjsService.saveZtxxb(entity);
			model.put(AppConst.STATUS, AppConst.SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			model.put(AppConst.STATUS, AppConst.FAIL);
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}
	
	@RequestMapping(value = "/saveSwxxb", method = RequestMethod.POST)
	public @ResponseBody
	ModelAndView saveSwxxb(ZdryDtjsSwxxb entity, SessionBean sessionBean) {
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		Map<String, Object> model = new HashMap<String, Object>();
		sessionBean = getSessionBean(sessionBean);
		try {
			zdryDtjsService.saveSwxxb(entity);
			model.put(AppConst.STATUS, AppConst.SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			model.put(AppConst.STATUS, AppConst.FAIL);
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}
	
	@RequestMapping(value = "/saveSfxxb", method = RequestMethod.POST)
	public @ResponseBody
	ModelAndView saveSfxxb(ZdryDtjsSfxxb entity, SessionBean sessionBean) {
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		Map<String, Object> model = new HashMap<String, Object>();
		sessionBean = getSessionBean(sessionBean);
		try {
			zdryDtjsService.saveSfxxb(entity);
			model.put(AppConst.STATUS, AppConst.SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			model.put(AppConst.STATUS, AppConst.FAIL);
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}
	
	@RequestMapping(value = "/saveSdxdxxb", method = RequestMethod.POST)
	public @ResponseBody
	ModelAndView saveSdxdxxb(ZdryDtjsSdxdxxb entity, SessionBean sessionBean) {
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		Map<String, Object> model = new HashMap<String, Object>();
		sessionBean = getSessionBean(sessionBean);
		try {
			zdryDtjsService.saveSdxdxxb(entity);
			model.put(AppConst.STATUS, AppConst.SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			model.put(AppConst.STATUS, AppConst.FAIL);
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}
	
	@RequestMapping(value = "/saveSdfdxxb", method = RequestMethod.POST)
	public @ResponseBody
	ModelAndView saveSdfdxxb(ZdryDtjsSdfdxxb entity, SessionBean sessionBean) {
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		Map<String, Object> model = new HashMap<String, Object>();
		sessionBean = getSessionBean(sessionBean);
		try {
			zdryDtjsService.saveSdfdxxb(entity);
			model.put(AppConst.STATUS, AppConst.SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			model.put(AppConst.STATUS, AppConst.FAIL);
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}
	
	@RequestMapping(value = "/saveSdzdxxb", method = RequestMethod.POST)
	public @ResponseBody
	ModelAndView saveSdzdxxb(ZdryDtjsSdzdxxb entity, SessionBean sessionBean) {
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		Map<String, Object> model = new HashMap<String, Object>();
		sessionBean = getSessionBean(sessionBean);
		try {
			zdryDtjsService.saveSdzdxxb(entity);
			model.put(AppConst.STATUS, AppConst.SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			model.put(AppConst.STATUS, AppConst.FAIL);
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}
	
	@RequestMapping(value = "/saveZdxsfzqkxxb", method = RequestMethod.POST)
	public @ResponseBody
	ModelAndView saveZdxsfzqkxxb(ZdryDtjsZdxsfzqkxxb entity, SessionBean sessionBean) {
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		Map<String, Object> model = new HashMap<String, Object>();
		sessionBean = getSessionBean(sessionBean);
		try {
			zdryDtjsService.saveZdxsfzqkxxb(entity);
			model.put(AppConst.STATUS, AppConst.SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			model.put(AppConst.STATUS, AppConst.FAIL);
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}
	
	@RequestMapping(value = "/saveZszhjsbrxxb", method = RequestMethod.POST)
	public @ResponseBody
	ModelAndView saveZszhjsbrxxb(ZdryDtjsZszhjsbrxxb entity, SessionBean sessionBean) {
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		Map<String, Object> model = new HashMap<String, Object>();
		sessionBean = getSessionBean(sessionBean);
		try {
			zdryDtjsService.saveZszhjsbrxxb(entity);
			model.put(AppConst.STATUS, AppConst.SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			model.put(AppConst.STATUS, AppConst.FAIL);
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}
	
	@RequestMapping(value = "/saveZszhjsbrZdjlxxb", method = RequestMethod.POST)
	public @ResponseBody
	ModelAndView saveZszhjsbrZdjlxxb(ZdryDtjsZszhjsbrZdjlxxb entity, SessionBean sessionBean) {
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		Map<String, Object> model = new HashMap<String, Object>();
		sessionBean = getSessionBean(sessionBean);
		try {
			zdryDtjsService.saveZszhjsbrZdjlxxb(entity);
			model.put(AppConst.STATUS, AppConst.SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			model.put(AppConst.STATUS, AppConst.FAIL);
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}
	
	@RequestMapping(value = "/saveZszhjsbrZszhjlxxb", method = RequestMethod.POST)
	public @ResponseBody
	ModelAndView saveZszhjsbrZszhjlxxb(ZdryDtjsZszhjsbrZszhjlxxb entity, SessionBean sessionBean) {
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		Map<String, Object> model = new HashMap<String, Object>();
		sessionBean = getSessionBean(sessionBean);
		try {
			zdryDtjsService.saveZszhjsbrZszhjlxxb(entity);
			model.put(AppConst.STATUS, AppConst.SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			model.put(AppConst.STATUS, AppConst.FAIL);
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}
	
	
	@RequestMapping(value = "/updateGxbg", method = RequestMethod.POST)
	public @ResponseBody
	ModelAndView updateGxbg(ZdryDtjsGxbgxxb entity, SessionBean sessionBean) {
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		Map<String, Object> model = new HashMap<String, Object>();
		sessionBean = getSessionBean(sessionBean);
		try {
			zdryDtjsService.updateGxbg(entity);
			model.put(AppConst.STATUS, AppConst.SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			model.put(AppConst.STATUS, AppConst.FAIL);
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}
	
	@RequestMapping(value = "/saveShgxrxxb", method = RequestMethod.POST)
	public @ResponseBody
	ModelAndView saveShgxrxxb(ZdryDtjsShgxrxxb entity, SessionBean sessionBean) {
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		Map<String, Object> model = new HashMap<String, Object>();
		sessionBean = getSessionBean(sessionBean);
		entity.setTbdwdm(sessionBean.getUserOrgCode());
		entity.setTbdwmc(sessionBean.getUserOrgNameQc());
		try {
			zdryDtjsService.saveShgxr(entity);
			model.put(AppConst.STATUS, AppConst.SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			model.put(AppConst.STATUS, AppConst.FAIL);
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}
	
	@RequestMapping(value = "/saveSaxxb", method = RequestMethod.POST)
	public @ResponseBody
	ModelAndView saveSaxxb(ZdryDtjsSaxxb entity, SessionBean sessionBean) {
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		Map<String, Object> model = new HashMap<String, Object>();
		sessionBean = getSessionBean(sessionBean);
		try {
			zdryDtjsService.saveSaxx(entity);
			model.put(AppConst.STATUS, AppConst.SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			model.put(AppConst.STATUS, AppConst.FAIL);
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}
	
	@RequestMapping(value = "/saveClxxb", method = RequestMethod.POST)
	public @ResponseBody
	ModelAndView saveClxxb(ZdryDtjsClxxb entity, SessionBean sessionBean) {
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		Map<String, Object> model = new HashMap<String, Object>();
		sessionBean = getSessionBean(sessionBean);
		try {
			zdryDtjsService.saveClxx(entity);
			model.put(AppConst.STATUS, AppConst.SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			model.put(AppConst.STATUS, AppConst.FAIL);
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}
	
	@RequestMapping(value = "/queryDtjsXsxxList", method = RequestMethod.POST)
	public @ResponseBody EasyUIPage queryDtjsXsxxList(EasyUIPage page,
			@RequestParam(value = "rows", required=false) Integer rows, 
			ZdryDtjsXsxxb entity){
		page.setPagePara(rows);
		return zdryDtjsService.queryRyxsList(page, entity);
	}
	
	@RequestMapping(value = "/queryDtjsZtxxList", method = RequestMethod.POST)	
	public @ResponseBody EasyUIPage queryDtjsZtxxList(EasyUIPage page,
			@RequestParam(value = "rows", required=false) Integer rows, 
			ZdryDtjsZtxxb entity,
			SessionBean sessionBean){
		page.setPagePara(rows);
		sessionBean = getSessionBean(sessionBean);
		entity.setLadwdm(QbldUtil.isOrg(sessionBean, orgOrganizationService));
		return zdryDtjsService.queryDtjsZtxxList(page, entity);
	}
	
	@RequestMapping(value = "/queryDtjsSwxxList", method = RequestMethod.POST)
	public @ResponseBody EasyUIPage queryDtjsSwxxList(EasyUIPage page,
			@RequestParam(value = "rows", required=false) Integer rows, 
			ZdryDtjsSwxxb entity,
			SessionBean sessionBean){
		page.setPagePara(rows);
		sessionBean = getSessionBean(sessionBean);
		return zdryDtjsService.queryDtjsSwxxList(page, entity);
	}
	
	@RequestMapping(value = "/queryDtjsSfxxList", method = RequestMethod.POST)
	public @ResponseBody EasyUIPage queryDtjsSfxxList(EasyUIPage page,
			@RequestParam(value = "rows", required=false) Integer rows, 
			ZdryDtjsSfxxb entity,
			SessionBean sessionBean){
		page.setPagePara(rows);
		sessionBean = getSessionBean(sessionBean);
		return zdryDtjsService.queryDtjsSfxxList(page, entity);
	}
	
	@RequestMapping(value = "/queryDtjsSdxdxxList", method = RequestMethod.POST)
	public @ResponseBody EasyUIPage queryDtjsSdxdxxList(EasyUIPage page,
			@RequestParam(value = "rows", required=false) Integer rows, 
			ZdryDtjsSdxdxxb entity,
			SessionBean sessionBean){
		page.setPagePara(rows);
		sessionBean = getSessionBean(sessionBean);
		return zdryDtjsService.queryDtjsSdxdxxList(page, entity);
	}
	
	@RequestMapping(value = "/queryDtjsSdfdxxList", method = RequestMethod.POST)
	public @ResponseBody EasyUIPage queryDtjsSdfdxxList(EasyUIPage page,
			@RequestParam(value = "rows", required=false) Integer rows, 
			ZdryDtjsSdfdxxb entity,
			SessionBean sessionBean){
		page.setPagePara(rows);
		sessionBean = getSessionBean(sessionBean);
		return zdryDtjsService.queryDtjsSdfdxxList(page, entity);
	}
	
	@RequestMapping(value = "/queryDtjsSdzdxxList", method = RequestMethod.POST)
	public @ResponseBody EasyUIPage queryDtjsSdzdxxList(EasyUIPage page,
			@RequestParam(value = "rows", required=false) Integer rows, 
			ZdryDtjsSdzdxxb entity,
			SessionBean sessionBean){
		page.setPagePara(rows);
		sessionBean = getSessionBean(sessionBean);
		return zdryDtjsService.queryDtjsSdzdxxList(page, entity);
	}
	
	@RequestMapping(value = "/queryDtjsZdxsfzqkxxList", method = RequestMethod.POST)
	public @ResponseBody EasyUIPage queryDtjsZdxsfzqkxxList(EasyUIPage page,
			@RequestParam(value = "rows", required=false) Integer rows, 
			ZdryDtjsZdxsfzqkxxb entity,
			SessionBean sessionBean){
		page.setPagePara(rows);
		sessionBean = getSessionBean(sessionBean);
		return zdryDtjsService.queryDtjsZdxsfzqkxxList(page, entity);
	}
	
	@RequestMapping(value = "/queryDtjsZszhjsbrxxList", method = RequestMethod.POST)
	public @ResponseBody EasyUIPage queryDtjsZszhjsbrxxList(EasyUIPage page,
			@RequestParam(value = "rows", required=false) Integer rows, 
			ZdryDtjsZszhjsbrxxb entity,
			SessionBean sessionBean){
		page.setPagePara(rows);
		sessionBean = getSessionBean(sessionBean);
		return zdryDtjsService.queryDtjsZszhjsbrxxList(page, entity);
	}
	
	@RequestMapping(value = "/queryDtjsZszhjsbrZdjlxxList", method = RequestMethod.POST)
	public @ResponseBody EasyUIPage queryDtjsZszhjsbrZdjlxxList(EasyUIPage page,
			@RequestParam(value = "rows", required=false) Integer rows, 
			ZdryDtjsZszhjsbrZdjlxxb entity,
			SessionBean sessionBean){
		page.setPagePara(rows);
		sessionBean = getSessionBean(sessionBean);
		return zdryDtjsService.queryDtjsZszhjsbrZdjlxxList(page, entity);
	}
	
	@RequestMapping(value = "/queryDtjsZszhjsbrZszhjlxxList", method = RequestMethod.POST)
	public @ResponseBody EasyUIPage queryDtjsZszhjsbrZszhjlxxList(EasyUIPage page,
			@RequestParam(value = "rows", required=false) Integer rows, 
			ZdryDtjsZszhjsbrZszhjlxxb entity,
			SessionBean sessionBean){
		page.setPagePara(rows);
		sessionBean = getSessionBean(sessionBean);
		return zdryDtjsService.queryDtjsZszhjsbrZszhjlxxList(page, entity);
	}
	
	@RequestMapping(value = "/queryGxbgList", method = RequestMethod.POST)
	public @ResponseBody EasyUIPage queryGxbgList(EasyUIPage page,
			@RequestParam(value = "rows", required=false) Integer rows, 
			ZdryDtjsGxbgxxb entity,
			SessionBean sessionBean){
		page.setPagePara(rows);
		sessionBean = getSessionBean(sessionBean);
		return zdryDtjsService.queryGxbgList(page, entity);
	}
	
	@RequestMapping(value = "/queryShgxrList", method = RequestMethod.POST)
	public @ResponseBody EasyUIPage queryShgxrList(EasyUIPage page,
			@RequestParam(value = "rows", required=false) Integer rows, 
			ZdryDtjsShgxrxxb entity,
			SessionBean sessionBean){
		page.setPagePara(rows);
		sessionBean = getSessionBean(sessionBean);
		return zdryDtjsService.queryShgxrList(page, entity);
	}
	
	@RequestMapping(value = "/querySaxxList", method = RequestMethod.POST)
	public @ResponseBody EasyUIPage querySaxxList(EasyUIPage page,
			@RequestParam(value = "rows", required=false) Integer rows, 
			ZdryDtjsSaxxb entity,
			SessionBean sessionBean){
		page.setPagePara(rows);
		sessionBean = getSessionBean(sessionBean);
		return zdryDtjsService.querySaxxList(page, entity);
	}
	
	@RequestMapping(value = "/queryClxxList", method = RequestMethod.POST)
	public @ResponseBody EasyUIPage queryClxxList(EasyUIPage page,
			@RequestParam(value = "rows", required=false) Integer rows, 
			ZdryDtjsClxxb entity,
			SessionBean sessionBean){
		page.setPagePara(rows);
		sessionBean = getSessionBean(sessionBean);
		return zdryDtjsService.queryClxxList(page, entity);
	}
}
