package com.founder.zdrygl.base.controller;

import java.util.HashMap;
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
import com.founder.framework.exception.BussinessException;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.zdrygl.base.model.ZdryDtjsZszhjsbrZdjlxxb;
import com.founder.zdrygl.base.service.ZdryDtjsZszhjsbrzdjlxxbService;
import com.google.gson.Gson;
@Controller
@RequestMapping("dtjsMore")
public class ZdryDtjsZszhjsbrzdjlxxbController extends BaseController {
	@Resource
	private ZdryDtjsZszhjsbrzdjlxxbService zdryDtjsZszhjsbrzdjlxxbService;
	
	
	@RequestMapping(value = "/moreDtjsZszhjsbrzdjlxxb", method = RequestMethod.POST)	
	public @ResponseBody EasyUIPage queryDtjsSfList(EasyUIPage page,
			@RequestParam(value = "rows", required=false) Integer rows, 
			String zdryZjhm,
			SessionBean sessionBean){
		page.setPagePara(rows);
		sessionBean = getSessionBean(sessionBean);
		ZdryDtjsZszhjsbrZdjlxxb entity=new ZdryDtjsZszhjsbrZdjlxxb();
		entity.setZdryzjhm(zdryZjhm);
		return zdryDtjsZszhjsbrzdjlxxbService.queryList(page, entity);
	}
	

	@RequestMapping(value = "/addDtjsZszhjsbrzdjlxxb", method = RequestMethod.GET)
	public ModelAndView addDtjsZszhjsbrzdjlxxb( String zdryZjhm,String zdryid,
			SessionBean sessionBean) throws BussinessException {
		    sessionBean = getSessionBean(sessionBean);
			ModelAndView mv = new ModelAndView("zdrygl/dtjsZszhjsbrzdjlxxbAdd");		
			ZdryDtjsZszhjsbrZdjlxxb entity=new ZdryDtjsZszhjsbrZdjlxxb();
			entity.setZdryzjhm(zdryZjhm);
			mv.addObject("entity", entity);
			return mv;
		
	}
	
	@RequestMapping(value = "/editDtjsZszhjsbrzdjlxxb", method = RequestMethod.GET)
	public ModelAndView editDtjsZszhjsbrzdjlxxb( String id,String type,
			SessionBean sessionBean) throws BussinessException {
		    sessionBean = getSessionBean(sessionBean);
			ModelAndView mv = new ModelAndView("zdrygl/dtjsZszhjsbrzdjlxxbAdd");		
			ZdryDtjsZszhjsbrZdjlxxb entity=this.zdryDtjsZszhjsbrzdjlxxbService.queryById(id);
			mv.addObject("entity", entity);
			mv.addObject("type", type);
			return mv;
		
	}
	@RequestMapping(value = "/saveDtjsZszhjsbrzdjlxxb", method = RequestMethod.POST)
	public @ResponseBody
	ModelAndView saveDtjsZszhjsbrzdjlxxb(ZdryDtjsZszhjsbrZdjlxxb entity, SessionBean sessionBean) {
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		Map<String, Object> model = new HashMap<String, Object>();
		sessionBean = getSessionBean(sessionBean);
		try {
			if(StringUtils.isBlank(entity.getId())){
						
				String id =this.zdryDtjsZszhjsbrzdjlxxbService.save(entity,sessionBean);		
				model.put(AppConst.MESSAGES, getAddSuccess());
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.SAVE_ID, "" + id); // 返回主键

			}else{
				zdryDtjsZszhjsbrzdjlxxbService.update(entity, sessionBean);
				
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, getUpdateSuccess());
				model.put(AppConst.SAVE_ID, "" + entity.getId()); // 返回主键
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.put(AppConst.STATUS, AppConst.FAIL);
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}
	
	
	@RequestMapping(value = "/deleteDtjsZszhjsbrzdjlxxb", method = RequestMethod.POST)
	public ModelAndView deleteDtjsZszhjsbrzdjlxxb(ZdryDtjsZszhjsbrZdjlxxb entity,
			SessionBean sessionBean) throws BussinessException {
		    sessionBean = getSessionBean(sessionBean);
			ModelAndView mv = new ModelAndView(getViewName(sessionBean));		
			Map<String, Object> map = new HashMap<String, Object>();
		    try {
			    this.zdryDtjsZszhjsbrzdjlxxbService.delete(entity, sessionBean);;
				map.put(AppConst.STATUS, AppConst.SUCCESS);
				map.put(AppConst.MESSAGES, getDeleteSuccess());
			} catch (Exception e) {
				e.printStackTrace();
				map.put(AppConst.STATUS, AppConst.FAIL);
				map.put(AppConst.MESSAGES, getDeleteFail());
			}
			mv.addObject(AppConst.MESSAGES, new Gson().toJson(map));    
			return mv;
		
	}
}
