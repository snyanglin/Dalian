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
import com.founder.framework.utils.DateUtils;
import com.founder.framework.utils.EasyUIPage;
import com.founder.zafffwqz.bean.Qsgxrzb;
import com.founder.zafffwqz.bean.Qsgxzmb;
import com.founder.zafffwqz.bean.Wfzjlzmb;
import com.founder.zafffwqz.service.QsgxzmbService;
import com.founder.zafffwqz.service.WfzjlzmbService;

import com.google.gson.Gson;
/**
 * 亲属关系证明
 * @author Administrator
 *
 */
@Controller
@RequestMapping(value = "/qsgxzmb")
public class QsgxzmbController extends BaseController {
	
	
private Logger logger = Logger.getLogger(this.getClass());
	
	@Resource(name = "qsgxzmbService")
	private QsgxzmbService qsgxzmbService;
	
	
	@RequestMapping(value = "/queryList", method = RequestMethod.POST)
	public @ResponseBody
	EasyUIPage queryList(EasyUIPage page,
			@RequestParam(value = "rows") Integer rows, String gmsfhm, String dz_jzdzxz,
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
		if(!"".equals(dz_jzdzxz)&&dz_jzdzxz!=null){
			map.put("dz_jzdzxz", dz_jzdzxz);
		}else{
			map.put("dz_jzdzxz", null);
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
		return qsgxzmbService.queryList(page, map);
		
	}
	/**
	 * 跳转-亲属关系证明
	 * @param fwid
	 * @param fwdzid
	 * @return
	 */
	@RequestMapping(value = "/addQsgxzmb", method = RequestMethod.GET)
	public @ResponseBody
	ModelAndView addQsgxzmb(String id,String mainTabID) {
		ModelAndView mv = new ModelAndView("zafffwqz/qsgxzmbAdd");
		Qsgxzmb entity = new Qsgxzmb();
		mv.addObject("mainTabID", mainTabID);
		String nowDate = DateUtils.getSystemDateString();
		if(!"".equals(id)&&id!=null){
			entity.setId(id);
			mv.addObject("flag","update");
			entity = qsgxzmbService.queryQsgxzmb(entity);
		}
		if("".equals(id)||id==null){
			entity.setZmjsdw("大连市公证处");
			entity.setKjrq(nowDate);
			mv.addObject("flag","add");
		}
		mv.addObject("entity", entity);
		
		return mv;
	}
	/**
	 * 保存-亲属关系证明
	 * @param entity
	 * @return
	 */
	@RequestMapping(value = "/saveQsgxzmb", method = RequestMethod.POST)
	public @ResponseBody
	ModelAndView saveQsgxzmb(Qsgxzmb entity) {
		ModelAndView mv = new ModelAndView("redirect:/forward/"
				+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		try {
			if (entity.getId() == null || entity.getId().equals("")) {
				qsgxzmbService.saveQsgxzmb(entity, sessionBean);
				mv.addObject("flag","update");
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "新增【亲属关系证明】成功！");
				model.put(AppConst.SAVE_ID, entity.getId()); // 返回主键
			} else {
				qsgxzmbService.saveQsgxzmb(entity, sessionBean);
				mv.addObject("flag","update");
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "修改【亲属关系证明】成功！");
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
	 * 注销亲属关系证明
	 * @param entity
	 * @return
	 */
	@RequestMapping(value = "/removeQsgxzmb", method = RequestMethod.POST)
	public @ResponseBody
	ModelAndView removeQsgxzmb(Qsgxzmb entity) {
		ModelAndView mv = new ModelAndView("redirect:/forward/"
				+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		Qsgxrzb qsgxrzb=new Qsgxrzb();
		qsgxrzb.setQsgxid(entity.getId());
		SessionBean sessionBean = getSessionBean();
		try {
			qsgxzmbService.removeQsgxzmb(entity,qsgxrzb, sessionBean);
			model.put(AppConst.STATUS, AppConst.SUCCESS);
			model.put(AppConst.MESSAGES, "注销【亲属关系证明】成功！");
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
	 * 跳转关系添加页面
	 */
	@RequestMapping(value = "/addQsgxrzb", method = RequestMethod.GET)
	public @ResponseBody
	ModelAndView addQsgxrzb(String qsgxid) {
		ModelAndView mv = new ModelAndView("zafffwqz/qsgxrzbAdd");
		Qsgxrzb entity = new Qsgxrzb();
		entity.setQsgxid(qsgxid);
		mv.addObject("entity", entity);
		return mv;
	}
	/**
	 * 保存关系添加
	 */
	@RequestMapping(value = "/saveQsgxrzb", method = RequestMethod.POST)
	public @ResponseBody
	ModelAndView saveQsgxrzb(Qsgxrzb entity) {
		ModelAndView mv = new ModelAndView("redirect:/forward/"
				+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		try {
			if (entity.getId() == null || entity.getId().equals("")) {
				qsgxzmbService.saveQsgxrzb(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "新增【亲属关系】成功！");
				model.put(AppConst.SAVE_ID, entity.getId()); // 返回主键
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
	 * id为FWQZ_QSGXZMB表的id
	 */
	@RequestMapping(value = "/queryQsList", method = RequestMethod.POST)
	public @ResponseBody
	EasyUIPage queryQsList(EasyUIPage page,
			@RequestParam(value = "rows") Integer rows,String id) {
		page.setPagePara(rows);
		SessionBean sessionBean = getSessionBean();
		Map map=new HashMap();
		map.put("qsgxid", id);
		return qsgxzmbService.queryQsList(page, map);
		
	}
}
