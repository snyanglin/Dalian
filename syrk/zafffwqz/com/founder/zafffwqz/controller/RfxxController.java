package com.founder.zafffwqz.controller;

import java.util.HashMap;
import java.util.List;
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
import com.founder.zafffwqz.bean.Sqjwszrqglxxb;
import com.founder.zafffwqz.bean.ZaffRfcyxxb;
import com.founder.zafffwqz.bean.ZaffRfxxb;
import com.founder.zafffwqz.service.RfxxService;
import com.founder.zafffwqz.service.SqjwsxxbService;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
@Controller
@RequestMapping(value = "/rfxx")
public class RfxxController extends BaseController{

	private Logger logger = Logger.getLogger(this.getClass());
	
	@Resource(name = "rfxxService")
	private RfxxService rfxxService;
	
	@Resource(name="sqjwsxxbService")
	private SqjwsxxbService sqjwsxxbService;
	/**
	 * 
	 * @param id
	 * @param mainTabID
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/addRfxx", method = RequestMethod.GET)
	public ModelAndView addRfxx(String id,String mainTabID,String dwid,String infoUrl) {
		ModelAndView mv = new ModelAndView("zafffwqz/rfxxAdd");
		mv.addObject("mainTabID", mainTabID);
		SessionBean sessionBean = getSessionBean();
		ZaffRfxxb entity = new ZaffRfxxb();
		String flag = "add";
		if (!StringUtils.isBlank(id)) {
			entity.setId(id);
			entity = rfxxService.queryRfxxById(entity);
			if(entity.getXt_lrrbmid().equals(sessionBean.getUserOrgCode())){
				flag ="update";
			}else {
				flag ="see";
			}
			
		}
		mv.addObject("sydwid", dwid==null ? "":dwid);
		mv.addObject("infoUrl", infoUrl==null ? "":infoUrl);
		mv.addObject("flag", flag);
		mv.addObject("entity", entity);
		return mv;
	}
	/**
	 * 新增和修改人防信息
	 * @param entity
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/saveRfxx", method = RequestMethod.POST)
	public ModelAndView saveRfxx(ZaffRfxxb entity){
		ModelAndView mv = new ModelAndView("redirect:/forward/" + AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		try {
			if (entity.getId() == null || entity.getId().equals("")) {
				
				rfxxService.insertRfxx(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES,  getMessage("add.success"));
				model.put(AppConst.SAVE_ID, entity.getId()); // 返回主键
			} else {
				rfxxService.updateRfxx(entity, sessionBean);
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
	 * 测试方法2
	 * @param entity
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/saveRfxx2", method = RequestMethod.POST)
	public ModelAndView saveRfxx2(ZaffRfxxb entity,String inserted,String deleted){
		ModelAndView mv = new ModelAndView("redirect:/forward/" + AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		
		List<ZaffRfcyxxb> insertList = JSON.parseArray(inserted, ZaffRfcyxxb.class);
		List<ZaffRfcyxxb> deleteList = JSON.parseArray(deleted, ZaffRfcyxxb.class);
		
		System.out.println("insertList.size()"+insertList.size());
		System.out.println("deleteList.size()"+deleteList.size());
		try {
			if (entity.getId() == null || entity.getId().equals("")) {
				Sqjwszrqglxxb zrqg = new Sqjwszrqglxxb();
				zrqg.setZrqdm(sessionBean.getUserOrgCode());
				zrqg=sqjwsxxbService.queryByZrqdm(zrqg);
				if(zrqg!=null){
					entity.setSqjwsid(zrqg.getSqjwsid());
				}else {
					
				}
				rfxxService.insertRfxx(entity, sessionBean,insertList);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES,"新增【人防信息】成功");
				model.put(AppConst.SAVE_ID, entity.getId()); // 返回主键
			} else {
				if(insertList.size()>0 && deleteList.size()<=0 ){
					//只添加
					rfxxService.updateRfxx(entity, sessionBean,insertList);
				}else if(insertList.size()<=0 && deleteList.size()>0){
					//只注销
					rfxxService.updateRfxxAndDE(entity, sessionBean,deleteList);
				}else{
					//既注销，又添加
					rfxxService.updateRfxx(entity, sessionBean,insertList,deleteList);
				}
				
				
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES,"修改【人防信息】成功");
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
	 * 注销人防信息
	 * @param entity
	 * @return
	 */
	@RequestMapping(value = "/deleteRfxx", method = RequestMethod.POST)
	public @ResponseBody
	ModelAndView deleteRfxx(ZaffRfxxb entity) {
		ModelAndView mv = new ModelAndView("redirect:/forward/"	+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		try {
				rfxxService.deleteRfxx(entity, sessionBean);
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
	 * 人防信息的查询
	 * @param page
	 * @param rows
	 * @param entity
	 * @return
	 */
	@RequestMapping(value = "/queryRf", method = RequestMethod.POST)
	public @ResponseBody
	EasyUIPage queryRf(EasyUIPage page,
			@RequestParam(value = "rows") Integer rows, ZaffRfxxb entity) {
		page.setPagePara(rows);
		SessionBean sessionBean = getSessionBean();
		if(null != sessionBean){
			//entity.setZrqdm(sessionBean.getUserOrgCode());
			//entity.setPcsdm((String)sessionBean.getExtendMap().get("ssPcsCode"));
		}
		return rfxxService.queryRf(page, entity);
	}
	
	
	/**
	 * 人防成员相关
	 * @param entity
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/saveRfcyxx", method = RequestMethod.POST)
	public ModelAndView saveRfcyxx(ZaffRfcyxxb entity){
		ModelAndView mv = new ModelAndView("redirect:/forward/" + AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		try {
			if (entity.getRfid() != null || !entity.getRfid().equals("")) {
				
				rfxxService.saveRfcyxx(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES,  getMessage("add.success"));
				model.put(AppConst.SAVE_ID, entity.getId()); // 返回主键
			} else {
				rfxxService.updateRfcyxx(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, getMessage("update.success"));
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
	
	//人防成员相关
	@RequestMapping(value = "/deleteRfcyxx", method = RequestMethod.POST)
	public @ResponseBody
	ModelAndView deleteRfxx(ZaffRfcyxxb entity) {
		ModelAndView mv = new ModelAndView("redirect:/forward/"	+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		try {
				rfxxService.deleteRfcyxx(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, getMessage("cancel.success"));
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getLocalizedMessage(), e);
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, getAddFail());
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}	
	
	//人防成员相关
	@RequestMapping(value = "/queryRfcyxx", method = RequestMethod.POST)
	public @ResponseBody
	EasyUIPage queryRfcyxx(EasyUIPage page,
			@RequestParam(value = "rows") Integer rows, ZaffRfcyxxb entity) {
		page.setPagePara(rows);
		SessionBean sessionBean = getSessionBean();
		if(null != sessionBean){
			//entity.setZrqdm(sessionBean.getUserOrgCode());
			//entity.setPcsdm((String)sessionBean.getExtendMap().get("ssPcsCode"));
		}
		return rfxxService.queryRfcyxx(page, entity);
	}
	
	
	
}
