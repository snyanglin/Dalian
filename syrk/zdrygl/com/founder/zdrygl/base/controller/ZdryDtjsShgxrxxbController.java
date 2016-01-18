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
import com.founder.zdrygl.base.model.ZdryDtjsShgxrxxb;
import com.founder.zdrygl.base.model.ZdryZb;
import com.founder.zdrygl.base.service.ZdryDtjsShgxrxxbService;
import com.founder.zdrygl.base.service.ZdryInfoQueryService;
import com.google.gson.Gson;
@Controller
@RequestMapping("dtjsMore")
public class ZdryDtjsShgxrxxbController extends BaseController {
	@Resource
	private ZdryDtjsShgxrxxbService zdryDtjsShgxrxxbService;
	@Resource(name="zdryQueryService")
	private ZdryInfoQueryService zdryQueryService ;
	 

	@RequestMapping(value = "/moreDtjsShgxrxxb", method = RequestMethod.POST)	
	public @ResponseBody EasyUIPage queryDtjsSwList(EasyUIPage page,
			@RequestParam(value = "rows", required=false) Integer rows, 
			String zdryZjhm,
			SessionBean sessionBean){
		page.setPagePara(rows);
		sessionBean = getSessionBean(sessionBean);
		ZdryDtjsShgxrxxb entity=new ZdryDtjsShgxrxxb();
		entity.setZdryzjhm(zdryZjhm);
		return zdryDtjsShgxrxxbService.queryList(page, entity);
	}
	

	@RequestMapping(value = "/addDtjsShgxrxxb", method = RequestMethod.GET)
	public ModelAndView addDtjsShgxrxxb( String zdryZjhm,String zdryid,
			SessionBean sessionBean) throws BussinessException {
		    sessionBean = getSessionBean(sessionBean);
			ModelAndView mv = new ModelAndView("zdrygl/dtjsShgxrxxbAdd");		
			ZdryZb zdryzb = (ZdryZb) zdryQueryService.queryById(zdryid);
			ZdryDtjsShgxrxxb entity=new ZdryDtjsShgxrxxb();
			entity.setZdryzjhm(zdryZjhm);
			entity.setZdrylbbj(zdryzb.getZdrygllxdm());
			entity.setZdryxl(zdryzb.getZdrylb());
			mv.addObject("entity", entity);
			return mv;
		
	}
	
	@RequestMapping(value = "/editDtjsShgxrxxb", method = RequestMethod.GET)
	public ModelAndView editDtjsSwxx( String id,String type,
			SessionBean sessionBean) throws BussinessException {
		    sessionBean = getSessionBean(sessionBean);
			ModelAndView mv = new ModelAndView("zdrygl/dtjsShgxrxxbAdd");		
			ZdryDtjsShgxrxxb entity=this.zdryDtjsShgxrxxbService.queryById(id);
			mv.addObject("entity", entity);
			mv.addObject("type", type);
			return mv;
		
	}
	@RequestMapping(value = "/saveDtjsShgxrxxb", method = RequestMethod.POST)
	public @ResponseBody
	ModelAndView saveDtjsSwxx(ZdryDtjsShgxrxxb entity, SessionBean sessionBean) {
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		Map<String, Object> model = new HashMap<String, Object>();
		sessionBean = getSessionBean(sessionBean);
		try {
			if(StringUtils.isBlank(entity.getId())){
						
				String id =this.zdryDtjsShgxrxxbService.save(entity,sessionBean);		
				model.put(AppConst.MESSAGES, getAddSuccess());
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.SAVE_ID, "" + id); // 返回主键

			}else{
				zdryDtjsShgxrxxbService.update(entity, sessionBean);
				
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
	
	
	@RequestMapping(value = "/deleteDtjsShgxrxxb", method = RequestMethod.POST)
	public ModelAndView deleteDtjsSwxx(ZdryDtjsShgxrxxb entity,
			SessionBean sessionBean) throws BussinessException {
		    sessionBean = getSessionBean(sessionBean);
			ModelAndView mv = new ModelAndView(getViewName(sessionBean));		
			Map<String, Object> map = new HashMap<String, Object>();
		    try {
			    this.zdryDtjsShgxrxxbService.delete(entity, sessionBean);;
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
