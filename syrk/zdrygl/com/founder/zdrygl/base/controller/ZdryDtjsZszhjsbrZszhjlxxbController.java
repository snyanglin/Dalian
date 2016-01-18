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
import com.founder.zdrygl.base.model.ZdryDtjsZszhjsbrZszhjlxxb;
import com.founder.zdrygl.base.service.ZdryDtjsZszhjsbrZszhjlxxbService;
import com.google.gson.Gson;
@Controller
@RequestMapping("dtjsMore")
public class ZdryDtjsZszhjsbrZszhjlxxbController extends BaseController {
	@Resource
	private ZdryDtjsZszhjsbrZszhjlxxbService zdryDtjsZszhjsbrZszhjlxxbService;
	
	@RequestMapping(value = "/moreDtjsZszhjsbrZszhjlxxb", method = RequestMethod.POST)	
	public @ResponseBody EasyUIPage queryZszhjsbrZszhjlList(EasyUIPage page,
			@RequestParam(value = "rows", required=false) Integer rows, 
			String zdryZjhm,
			SessionBean sessionBean){
		page.setPagePara(rows);
		sessionBean = getSessionBean(sessionBean);
		ZdryDtjsZszhjsbrZszhjlxxb entity=new ZdryDtjsZszhjsbrZszhjlxxb();
		entity.setZdryzjhm(zdryZjhm);
		return zdryDtjsZszhjsbrZszhjlxxbService.queryList(page, entity);
	}
	

	@RequestMapping(value = "/addDtjsZszhjsbrZszhjlxxb", method = RequestMethod.GET)
	public ModelAndView addDtjsZszhjsbrZszhjl( String zdryZjhm,String zdryid,
			SessionBean sessionBean) throws BussinessException {
		    sessionBean = getSessionBean(sessionBean);
			ModelAndView mv = new ModelAndView("zdrygl/dtjsZszhjsbrzszhjlxxbAdd");		
			ZdryDtjsZszhjsbrZszhjlxxb entity=new ZdryDtjsZszhjsbrZszhjlxxb();
			entity.setZdryzjhm(zdryZjhm);
			mv.addObject("entity", entity);
			return mv;
		
	}
	
	@RequestMapping(value = "/editDtjsZszhjsbrZszhjlxxb", method = RequestMethod.GET)
	public ModelAndView editDtjsZszhjsbrzdjlxxb( String id,String type,
			SessionBean sessionBean) throws BussinessException {
		    sessionBean = getSessionBean(sessionBean);
			ModelAndView mv = new ModelAndView("zdrygl/dtjsZszhjsbrzszhjlxxbAdd");		
			ZdryDtjsZszhjsbrZszhjlxxb entity=this.zdryDtjsZszhjsbrZszhjlxxbService.queryById(id);
			mv.addObject("entity", entity);
			mv.addObject("type", type);
			return mv;
		
	}
	@RequestMapping(value = "/saveDtjsZszhjsbrZszhjlxxb", method = RequestMethod.POST)
	public @ResponseBody
	ModelAndView saveDtjsZszhjsbrzdjlxxb(ZdryDtjsZszhjsbrZszhjlxxb entity, SessionBean sessionBean) {
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		Map<String, Object> model = new HashMap<String, Object>();
		sessionBean = getSessionBean(sessionBean);
		try {
			if(StringUtils.isBlank(entity.getId())){
						
				String id =this.zdryDtjsZszhjsbrZszhjlxxbService.save(entity,sessionBean);		
				model.put(AppConst.MESSAGES, getAddSuccess());
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.SAVE_ID, "" + id); // 返回主键

			}else{
				zdryDtjsZszhjsbrZszhjlxxbService.update(entity, sessionBean);
				
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, getUpdateSuccess());
				model.put(AppConst.SAVE_ID, "" + entity.getId()); // 返回主键
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES,getUpdateFail()+e.getLocalizedMessage());
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}
	
	
	@RequestMapping(value = "/deleteDtjsZszhjsbrZszhjlxxb", method = RequestMethod.POST)
	public ModelAndView deleteDtjsZszhjsbrzdjlxxb(ZdryDtjsZszhjsbrZszhjlxxb entity,
			SessionBean sessionBean) throws BussinessException {
		    sessionBean = getSessionBean(sessionBean);
			ModelAndView mv = new ModelAndView(getViewName(sessionBean));		
			Map<String, Object> map = new HashMap<String, Object>();
		    try {
			    this.zdryDtjsZszhjsbrZszhjlxxbService.delete(entity, sessionBean);;
				map.put(AppConst.STATUS, AppConst.SUCCESS);
				map.put(AppConst.MESSAGES, getDeleteSuccess());
			} catch (Exception e) {
				e.printStackTrace();
				map.put(AppConst.STATUS, AppConst.FAIL);
				map.put(AppConst.MESSAGES, getDeleteFail()+e.getLocalizedMessage());
			}
			mv.addObject(AppConst.MESSAGES, new Gson().toJson(map));    
			return mv;
		
	}
}
