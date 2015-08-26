package com.founder.framework.message.controller;

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

import com.google.gson.Gson;

import com.founder.framework.annotation.RestfulAnnotation;
import com.founder.framework.base.controller.BaseController;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.components.AppConst;
import com.founder.framework.exception.BussinessException;
import com.founder.framework.message.bean.SysMessage;
import com.founder.framework.message.service.SysMessageService;
import com.founder.framework.utils.DateUtils;
import com.founder.framework.utils.EasyUIPage;

@Controller
@RequestMapping(value = "/sysMessage")
public class SysMessageController extends BaseController {

	private Logger logger = Logger.getLogger(this.getClass());

	@Resource(name = "sysMessageService")
	private SysMessageService sysMessageService;

	/**
	 * 查询提醒消息
	 * 
	 * @return
	 */
	@RequestMapping(value = "/searchRemind", method = RequestMethod.GET)
	public @ResponseBody
	ModelAndView searchRemind() {
		ModelAndView mv = new ModelAndView("main/firstPage_message");
		SessionBean sessionBean = getSessionBean();
		String userid = "";
		String orgcode = "";
		if (null != sessionBean) {
			userid = sessionBean.getUserId();
			orgcode = sessionBean.getUserOrgCode();

		}
		Map<String, Object> map = new HashMap<String, Object>();
		SysMessage sysMessage = new SysMessage();
		sysMessage.setJsrdm(userid);
		sysMessage.setJsrssdwdm(orgcode);
		sysMessage.setXxlb("1");
		map.put("sysMessage", sysMessage);
		List<SysMessage> msgList = sysMessageService.searchMessage(map);

		mv.addObject("msgList", msgList);
		return mv;
	}

	/**
	 * 查询任务消息
	 * 
	 * @return
	 */
	@RequestMapping(value = "/searchTask", method = RequestMethod.GET)
	public @ResponseBody
	ModelAndView searchTask() {
		ModelAndView mv = new ModelAndView("main/firstPage_wfTask");
		SessionBean sessionBean = getSessionBean();
		String userid = "";
		String orgcode = "";
		if (null != sessionBean) {
			userid = sessionBean.getUserId();
			orgcode = sessionBean.getUserOrgCode();

		}
		Map<String, Object> map = new HashMap<String, Object>();
		SysMessage sysMessage = new SysMessage();
		sysMessage.setJsrdm(userid);
		sysMessage.setJsrssdwdm(orgcode);
		sysMessage.setXxlb("2");
		map.put("sysMessage", sysMessage);
		List<SysMessage> taskList = sysMessageService.searchMessage(map);

		mv.addObject("taskList", taskList);
		return mv;
	}

	/**
	 * 查询任务消息
	 * 
	 * @return
	 */
	@RequestMapping(value = "/searchInform", method = RequestMethod.GET)
	public @ResponseBody
	ModelAndView searchInform() {
		ModelAndView mv = new ModelAndView("main/firstPage_inform");
		SessionBean sessionBean = getSessionBean();
		String userid = "";
		String orgcode = "";
		if (null != sessionBean) {
			userid = sessionBean.getUserId();
			orgcode = sessionBean.getUserOrgCode();

		}
		Map<String, Object> map = new HashMap<String, Object>();
		SysMessage sysMessage = new SysMessage();
		sysMessage.setJsrdm(userid);
		sysMessage.setJsrssdwdm(orgcode);
		sysMessage.setXxlb("3");
		map.put("sysMessage", sysMessage);
		List<SysMessage> infoList = sysMessageService.searchMessage(map);

		mv.addObject("infoList", infoList);
		return mv;
	}
	/**
	 * 修改消息表状态
	 * 
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody
	String updateMessage(Long id) {
		String returnValue = "";
		SessionBean sessionBean = getSessionBean();
		SysMessage entity = new SysMessage();
		entity.setId(id);
		entity.setCksj(DateUtils.getSystemDateTimeString());
		try {
			if (entity.getId() != null) { // 修改
				sysMessageService.update(entity, sessionBean);
			}
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage(), e);
		}
		returnValue = super.getUpdateSuccess();
		return returnValue;
	}

	/**
	 * 打开查询条件页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/query", method = RequestMethod.GET)
	public ModelAndView query() {
		ModelAndView mv = new ModelAndView("message/sysMessageQueryCondition");
		return mv;
	}

	/**
	 * 查询分页List
	 * 
	 * @return
	 */
	@RequestMapping(value = "/queryList", method = RequestMethod.POST)
	public @ResponseBody
	EasyUIPage queryList(EasyUIPage page,
			@RequestParam(value = "rows") Integer rows, SysMessage entity) {
		page.setPagePara(rows);
		SessionBean sessionBean = getSessionBean();
		String userid = "";
		String orgcode = "";
		if (null != sessionBean) {
			userid = sessionBean.getUserId();
			orgcode = sessionBean.getUserOrgCode();

		}
		Map<String, Object> map = new HashMap<String, Object>();
		entity.setJsrdm(userid);
		entity.setJsrssdwdm(orgcode);
		// sysMessage.setXxlb("1");
		map.put("sysMessage", entity);
		return sysMessageService.queryList(page, map);

	}

	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public ModelAndView view(SysMessage entity) throws BussinessException {
		entity = sysMessageService.query(entity);
		SessionBean sessionBean = getSessionBean();
		Long nextID = new Long(0);
		Long prevID = new Long(0);
		if (entity == null) {
			throw new BussinessException("该数据不存在或已被注销！");
		}
		try {
			nextID = sysMessageService.getViewNextID(entity);
			prevID = sysMessageService.getViewPrevID(entity);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		if ("0".equals(entity.getSfck())) {
			String cksj = DateUtils.getSystemDateTimeString();
			entity.setCksj(cksj);
			sysMessageService.update(entity, sessionBean);

		}
		ModelAndView mv = new ModelAndView("message/sysMessageView");
		mv.addObject("nextID", nextID);
		mv.addObject("prevID", prevID);
		mv.addObject("entity", entity);
		return mv;
	}
	/**
	 * @Title: viewReply 
	 * @描述: 打开消息【回复】
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 消息ID
	 * @日期： 2015-3-14 下午2:35:06 
	 * @返回值: ModelAndView    返回类型 
	 * @throws
	 */
	@RequestMapping(value = "/viewReply", method = RequestMethod.GET)
	public ModelAndView viewReply(SysMessage entity) throws BussinessException{
		ModelAndView mv = new ModelAndView("message/sysMessageReply");
		String title = "";
		String hfbz = entity.getHfbz();
		if("1".equals(entity.getHfbz())){
			title = "回复内容：";
		}else{
			title = "转发原因：";
		}
		entity = sysMessageService.query(entity);
		entity.setHfbz(hfbz);
		mv.addObject("entity", entity);
		mv.addObject("title", title);
		return mv;
	}
	/**
	 * @Title: updateReply 
	 * @描述: 更新消息【回复】 
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2015-3-14 下午2:50:34 
	 * @返回值: ModelAndView    返回类型 
	 * @throws
	 */
	@RequestMapping(value = "/updateReply", method = RequestMethod.POST)
	public @ResponseBody ModelAndView updateReply(SysMessage entity) {
		ModelAndView mv = new ModelAndView("redirect:/forward/"+ AppConst.FORWORD);
		SessionBean sessionBean = getSessionBean();
		//返回提示
		Map<String, Object> model = new HashMap<String, Object>();
		try{
			sysMessageService.updateReply(entity, sessionBean);
			model.put(AppConst.STATUS, AppConst.SUCCESS);
			if("1".equals(entity.getHfbz())){
				model.put(AppConst.MESSAGES, "消息回复成功！");
			}else{
				model.put(AppConst.MESSAGES, "消息转发成功！");
			}
		}catch(Exception e){
			model.put(AppConst.STATUS, AppConst.FAIL);
			if("1".equals(entity.getHfbz())){
				model.put(AppConst.MESSAGES, "消息回复失败！");
			}else{
				model.put(AppConst.MESSAGES, "消息转发失败！");
			}
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}
	/**
	 * 进入下一条查看页面前的查询以及其他处理<br>
	 * 
	 * @return String
	 */
	@RequestMapping(value = "/viewNext", method = RequestMethod.POST)
	public ModelAndView viewNext(SysMessage entity, String direction,
			Long nextID, Long prevID) {
		ModelAndView mv = new ModelAndView("message/sysMessageView");
		SessionBean sessionBean = getSessionBean();
		try {
			Long tempID = null;
			if ("prev".equals(direction)) {
				entity.setId(prevID);
			} else {
				tempID = entity.getId();
				entity.setId(nextID);
			}
			entity = sysMessageService.query(entity);
			if (entity == null) {
				mv.addObject("fail", AppConst.FAIL);
				return mv;
			}
			if ("0".equals(entity.getSfck())) {
				String cksj = DateUtils.getSystemDateTimeString();
				entity.setCksj(cksj);
				sysMessageService.update(entity, sessionBean);
			}
			if (tempID != null) {
				prevID = tempID;
			} else {
				prevID = sysMessageService.getViewPrevID(entity);
			}
			nextID = sysMessageService.getViewNextID(entity);
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			super.getRequest().setAttribute("myException", ex);
			mv.addObject("fail", AppConst.FAIL);
			return mv;
		}
		mv.addObject("nextID", nextID);
		mv.addObject("prevID", prevID);
		mv.addObject("entity", entity);
		return mv;
	}

	// begin
	/**
	 * 进入下一条查看页面前的查询以及其他处理<br>
	 * 
	 * @return String
	 */
	@RequestMapping(value = "/saveMsg", method = RequestMethod.POST)
	public @ResponseBody
	Map saveMsg(SysMessage entity, String direction, Long nextID, Long prevID) {
		SessionBean sessionBean = getSessionBean();
		if (null != sessionBean) {
			entity.setFsr((String) sessionBean.getExtendMap().get("userName"));
			entity.setFsrdm((String) sessionBean.getExtendMap().get("userId"));
			entity.setFsrssdw((String) sessionBean.getExtendMap().get(
					"userOrgName"));
			entity.setFsr((String) sessionBean.getUserName());
			entity.setFsrdm((String) sessionBean.getUserId());
			entity.setFsrssdw((String) sessionBean.getUserOrgName());
		}
		Map<String, Object> model = new HashMap<String, Object>();
		String s = sysMessageService.saveMsg(entity);
		model.put("e", s);
		return model;

		/*
		 * ModelAndView mv = new ModelAndView("dbrw/sendMsg"); SessionBean
		 * sessionBean = getSessionBean(); Long msg = 0L; try { Long tempID =
		 * null; msg = sysMessageService.saveMsg(entity); if (entity == null) {
		 * mv.addObject("fail", AppConst.FAIL); return mv; } } catch (Exception
		 * ex) { logger.error(ex.getMessage(), ex);
		 * super.getRequest().setAttribute("myException", ex);
		 * mv.addObject("fail", AppConst.FAIL); return mv; } mv.addObject("id",
		 * msg); return mv;
		 */
	}

	// 巡警 begin
	/**
	 * 查询提醒消息
	 * 
	 * @return
	 */
	@RequestMapping(value = "/xjsearchRemind", method = RequestMethod.GET)
	public @ResponseBody
	ModelAndView xjsearchRemind() {
		ModelAndView mv = new ModelAndView("main/firstPage_message");
		SessionBean sessionBean = getSessionBean();
		String userid = "";
		String orgcode = "";
		if (null != sessionBean) {
			userid = sessionBean.getUserId();
			orgcode = sessionBean.getUserOrgCode();
		}
		Map<String, Object> map = new HashMap<String, Object>();
		SysMessage sysMessage = new SysMessage();
		sysMessage.setJsrdm(userid);
		sysMessage.setJsrssdwdm(orgcode);
		sysMessage.setXxlb("9");
		map.put("sysMessage", sysMessage);
		List<SysMessage> msgList = sysMessageService.searchMessage(map);
		mv.addObject("msgList", msgList);
		return mv;
	}
	// end
	/**
	 * @Title: queryMessage 
	 * @描述: 查询系统消息【服务接口】
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @返回值: ModelAndView    返回类型 
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	@RestfulAnnotation(serverId="3")
	@RequestMapping(value = "/queryMessage", method = RequestMethod.POST)
	public @ResponseBody List<SysMessage> queryMessage(SysMessage sysMessage,SessionBean sessionBean){
		sessionBean = getSessionBean(sessionBean);
		sysMessage.setJsrdm(sessionBean.getUserId());
		sysMessage.setJsrssdwdm(sessionBean.getUserOrgCode());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("sysMessage", sysMessage);
		List<SysMessage> infoList = sysMessageService.searchMessage(map);
		return infoList;
	}
}
