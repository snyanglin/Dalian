package com.founder.tzgg.controller;

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
import com.founder.framework.exception.BussinessException;
import com.founder.framework.message.bean.SysMessage;
import com.founder.framework.message.service.SysMessageService;
import com.founder.framework.utils.DateUtils;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.service.attachment.bean.ZpfjFjxxb;
import com.founder.tzgg.bean.Node;
import com.founder.tzgg.bean.Org_Organization;
import com.founder.tzgg.bean.Sys_Tzggb;
import com.founder.tzgg.service.TzggService;

import com.google.gson.Gson;
@Controller
@RequestMapping("/tzgg")
public class TzggController extends BaseController {

	
	private Logger logger = Logger.getLogger(this.getClass());
	
	@Resource(name="tzggService")
	private TzggService tzggService;
	
	@Resource(name = "sysMessageService")
	private SysMessageService sysMessageService;
	/**
	 * 列表查询通知通告
	 * @param page
	 * @param rows
	 * @param entity
	 * @return
	 */
	@RequestMapping(value = "/queryList", method = RequestMethod.POST)
	public @ResponseBody
	EasyUIPage queryList(EasyUIPage page,
			@RequestParam(value = "rows") Integer rows, Sys_Tzggb entity) {
		page.setPagePara(rows);
		SessionBean sessionBean = getSessionBean();
		if(null != sessionBean){
			entity.setFsbmid(sessionBean.getUserOrgCode());
		}
		return tzggService.queryList(page, entity);
	}

	/**
	 * 查询单条通知公告
	 * @param entity
	 * @return
	 */
	@RequestMapping(value = "/queryById", method = RequestMethod.POST)
	public @ResponseBody
			Sys_Tzggb queryById(Sys_Tzggb entity) {
		SessionBean sessionBean = getSessionBean();
		if(null != sessionBean){
		}
		return tzggService.queryById(entity);
	}

	/**
	 * 注销通知公告
	 * @param entity
	 * @return
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public ModelAndView delete(Sys_Tzggb entity) {
		ModelAndView mv = new ModelAndView("redirect:/forward/"
				+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		try {
			if (entity.getId() != null) { // 注销
				tzggService.delete(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, getMessage("cancel.success"));
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
	
	/**
	 * 更新和保存
	 * @param entity
	 * @return
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public @ResponseBody
	ModelAndView save(Sys_Tzggb entity) {
		ModelAndView mv = new ModelAndView("redirect:/forward/"
				+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		
		if(null != sessionBean){
			entity.setFsr(sessionBean.getUserName());
			entity.setFsrid(sessionBean.getUserId());
			entity.setFsbm(sessionBean.getUserOrgName());
			entity.setFsbmid(sessionBean.getUserOrgCode());
		}
		if(entity.getZjtk()==null || entity.getZjtk()==""){
			entity.setZjtk("1");
		}
		try {
			if (entity.getId() == null || entity.getId().equals("")) {
				//1为未发布;
				//entity.setFbztdm("1");
				tzggService.save(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "新增【通知公告】成功！");
				model.put(AppConst.SAVE_ID, entity.getId()); // 返回主键
			} else {
				tzggService.update(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.SAVE_ID, entity.getId());
				model.put(AppConst.MESSAGES, "修改【通知公告】成功！");
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
	
	@ResponseBody
	@RequestMapping(value = "/addTzgg", method = RequestMethod.GET)
	public ModelAndView addTzgg(String id,String mainTabID,String mode) {
		ModelAndView mv = new ModelAndView("tzgg/tzggAdd");
		mv.addObject("mainTabID", mainTabID);
		mv.addObject("mode", mode);
		Sys_Tzggb entity = new Sys_Tzggb();
		if (!StringUtils.isBlank(id)) {
			entity.setId(id);
			entity = tzggService.queryById(entity);
		}
		mv.addObject("entity", entity);
		return mv;
	}
	
	@ResponseBody
	@RequestMapping(value = "/tzggInfo", method = RequestMethod.GET)
	public ModelAndView tzggInfo(String id,String mainTabID,String mode) {
		ModelAndView mv = new ModelAndView("tzgg/tzggInfo");
		mv.addObject("mainTabID", mainTabID);
		mv.addObject("mode", mode);
		Sys_Tzggb entity = new Sys_Tzggb();
		if (!StringUtils.isBlank(id)) {
			entity.setId(id);
			entity = tzggService.queryById(entity);
		}
		mv.addObject("entity", entity);
		return mv;
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/queryByTzggId", method = RequestMethod.GET)
	public List<Sys_Tzggb> queryByTzggId(Sys_Tzggb entity){
		List<Sys_Tzggb> tzggList = tzggService.queryByTzggId(entity);
		return tzggList;
	}
	
	@ResponseBody
	@RequestMapping(value = "/queryOrg", method = RequestMethod.GET)
	public String queryOrg(Org_Organization organization){
		List<Node> nodeList = null;
		String json = JsonUtil.object2json(nodeList);
		
		System.out.println(json);
		return json;
	}
	
	@ResponseBody
	@RequestMapping(value = "/queryFj", method = RequestMethod.GET)
	public List<ZpfjFjxxb> queryFj(ZpfjFjxxb zpfjFjxxb){
		List<ZpfjFjxxb> fjList = tzggService.queryFj(zpfjFjxxb);
		return fjList;
	}
	
	/*
	 * 更新系统信息表的查看状态;
	 */
	@RequestMapping(value = "/view", method = RequestMethod.POST)
	public @ResponseBody
	String  view(SysMessage entity) throws BussinessException {
		entity = sysMessageService.query(entity);
		SessionBean sessionBean = getSessionBean();
		if (entity == null) {
			throw new BussinessException("该数据不存在或已被注销！");
		}
		if ("0".equals(entity.getSfck())) {
			String cksj = DateUtils.getSystemDateTimeString();
			entity.setCksj(cksj);
			sysMessageService.update(entity, sessionBean);
		}
		
		return "success";
	}
}
