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
import com.founder.zafffwqz.bean.Wfzjlzmb;
import com.founder.zafffwqz.service.WfzjlzmbService;

import com.google.gson.Gson;
/**
 * 无犯罪记录证明
 * @author Administrator
 *
 */
@Controller
@RequestMapping(value = "/wfzjlzmb")
public class WfzjlzmbController extends BaseController {
	
	
private Logger logger = Logger.getLogger(this.getClass());
	
	@Resource(name = "wfzjlzmbService")
	private WfzjlzmbService wfzjlzmbService;
	
	
	@RequestMapping(value = "/queryList", method = RequestMethod.POST)
	public @ResponseBody
	EasyUIPage queryList(EasyUIPage page,
			@RequestParam(value = "rows") Integer rows, String gmsfhm, 
			String xm,String xbdm,String startime,String endtime) {
		page.setPagePara(rows);
		SessionBean sessionBean = getSessionBean();
		Map map=new HashMap();
		if(!"".equals(gmsfhm)&&gmsfhm!=null){
			map.put("gmsfhm", gmsfhm);
		}else{
			map.put("gmsfhm", null);
		}
		if(!"".equals(xm)&&xm!=null){
			map.put("xm", xm);
		}else{
			map.put("xm", null);
		}
		if(!"".equals(xbdm)&&xbdm!=null){
			map.put("xbdm", xbdm);
		}else{
			map.put("xbdm", null);
		}
		if(!"".equals(startime)&&startime!=null){
			map.put("startime", startime);
		}else{
			map.put("startime", null);
		}
		if(!"".equals(endtime)&&endtime!=null){
			map.put("endtime", endtime);
		}else{
			map.put("endtime", null);
		}
		map.put("xt_lrrbmid", sessionBean.getUserOrgCode());
		return wfzjlzmbService.queryList(page, map);
		
	}
	/**
	 * 跳转-无犯罪记录证明
	 * @param fwid
	 * @param fwdzid
	 * @return
	 */
	@RequestMapping(value = "/addWfzjlzmb", method = RequestMethod.GET)
	public @ResponseBody
	ModelAndView addWfzjlzmb(String id,String mainTabID) {
		ModelAndView mv = new ModelAndView("zafffwqz/wfzjlzmbAdd");
		Wfzjlzmb entity = new Wfzjlzmb();
		mv.addObject("mainTabID", mainTabID);
		if(!"".equals(id)&&id!=null){
			entity.setId(id);
			mv.addObject("flag","update");
		}
//		entity.setCzfwid(fwid);
		entity = wfzjlzmbService.queryWfzjlzmb(entity);
		mv.addObject("entity", entity);
		return mv;
	}
	/**
	 * 保存-无犯罪记录证明
	 * @param entity
	 * @return
	 */
	@RequestMapping(value = "/saveWfzjlzmb", method = RequestMethod.POST)
	public @ResponseBody
	ModelAndView saveWfzjlzmb(Wfzjlzmb entity) {
		ModelAndView mv = new ModelAndView("redirect:/forward/"
				+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		try {
			if (entity.getId() == null || entity.getId().equals("")) {
				wfzjlzmbService.saveWfzjlzmb(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "新增【无犯罪记录证明】成功！");
				model.put(AppConst.SAVE_ID, entity.getId()); // 返回主键
			} else {
				wfzjlzmbService.updateWfzjlzmb(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "修改【无犯罪记录证明】成功！");
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
	/**
	 * 注销无犯罪记录证明
	 * @param entity
	 * @return
	 */
	@RequestMapping(value = "/removeWfzjlzmb", method = RequestMethod.POST)
	public @ResponseBody
	ModelAndView removeWfzjlzmb(Wfzjlzmb entity) {
		ModelAndView mv = new ModelAndView("redirect:/forward/"
				+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		try {
			wfzjlzmbService.removeWfzjlzmb(entity, sessionBean);
			model.put(AppConst.STATUS, AppConst.SUCCESS);
			model.put(AppConst.MESSAGES, "注销【无犯罪记录证明】成功！");
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
