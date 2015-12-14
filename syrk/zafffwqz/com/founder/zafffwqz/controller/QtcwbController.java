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
import com.founder.framework.utils.UUID;
import com.founder.zafffwqz.bean.Qtcwb;
import com.founder.zafffwqz.service.QtcwbService;

import com.google.gson.Gson;




@Controller
@RequestMapping(value = "/qtcwb")
public class QtcwbController extends BaseController {
private Logger logger = Logger.getLogger(this.getClass());
	
	@Resource(name="qtcwbService")
	private QtcwbService qtcwbService;
	
	/**
	 * 跳转-其它宠物
	 * @param 
	 * @return
	 */
	@RequestMapping(value = "/addQtcwb", method = RequestMethod.GET)
	public @ResponseBody
	ModelAndView addQtcwb(String id,String mainTabID) {
		ModelAndView mv = new ModelAndView("zafffwqz/qtcwbadd");
		mv.addObject("mainTabID", mainTabID);
		Qtcwb entity = new Qtcwb();
		SessionBean sessionBean = getSessionBean();
		String flag ="add";
		try {
			entity.setCbr(sessionBean.getUserName());
			mv.addObject("entity", entity);
			if(id!=null){
				entity.setId(id);
			}
			entity = qtcwbService.queryQtcwb(entity);
			if(entity != null){
				mv.addObject("entity", entity);
				if(entity.getXt_lrrbmid().equals(sessionBean.getUserOrgCode())){
					flag ="update";
				}else {
					flag ="see";
				}
			}
			mv.addObject("flag", flag);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}
	/**
	 * 保存-其它宠物
	 * @param entity
	 * @return
	 */
	@RequestMapping(value = "/saveQtcwb", method = RequestMethod.POST)
	public @ResponseBody
	ModelAndView saveQtcwb(Qtcwb entity) {
		ModelAndView mv = new ModelAndView("redirect:/forward/"
				+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		try {
			if (entity.getId() == null || entity.getId().equals("")) {
				if(entity.getRyid() == null || entity.getRyid().equals("")){
					entity.setRyid(UUID.create());
				}
				qtcwbService.saveQtcwb(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "新增【其它宠物】成功！");
				model.put(AppConst.SAVE_ID, entity.getId()); // 返回主键
			} else {
				qtcwbService.updateQtcwb(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "修改【其它宠物】成功！");
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
	
	@RequestMapping(value = "/queryList", method = RequestMethod.POST)
	public @ResponseBody
	EasyUIPage queryList(EasyUIPage page,
			@RequestParam(value = "rows") Integer rows,String zjhm,String xm,String dz_jzdzxz,String ycwytdm,String cwx,String cwz) {
		page.setPagePara(rows);
		SessionBean sessionBean = getSessionBean();
		Map map=new HashMap();
		if(!"".equals(zjhm)&&zjhm!=null){
			map.put("zjhm", zjhm);
		}else{
			map.put("zjhm", null);
		}
		if(!"".equals(xm)&&xm!=null){
			map.put("xm", xm);
		}else{
			map.put("xm", null);
		}
		if(!"".equals(dz_jzdzxz)&&dz_jzdzxz!=null){
			map.put("dz_jzdzxz", dz_jzdzxz);
		}else{
			map.put("dz_jzdzxz", null);
		}
		if(!"".equals(ycwytdm)&&ycwytdm!=null){
			map.put("ycwytdm",ycwytdm);
		}else{
			map.put("ycwytdm",null);
		}
		if(!"".equals(cwx)&&cwx!=null){
			map.put("cwx",cwx);
		}else{
			map.put("cwx",null);
		}
		if(!"".equals(cwz)&&cwz!=null){
			map.put("cwz",cwz);
		}else{
			map.put("cwz",null);
		}
		return qtcwbService.queryList(page, map);
	}
	
	/**
	 * 注销-其它宠物
	 * @return
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public ModelAndView DeleteQtcwb(Qtcwb entity) {
		ModelAndView mv = new ModelAndView("redirect:/forward/"
				+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		try {
			if (entity.getId() != null) { // 注销
				qtcwbService.delete(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "注销【其它宠物】成功！");
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
