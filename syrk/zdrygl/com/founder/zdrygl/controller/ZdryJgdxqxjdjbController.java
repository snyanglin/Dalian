package com.founder.zdrygl.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.founder.framework.base.controller.BaseController;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.components.AppConst;
import com.founder.framework.exception.BussinessException;
import com.founder.framework.utils.DateUtils;
import com.founder.framework.utils.EasyUIPage;
import com.founder.zdrygl.bean.ZdryJgdxqxjdjb;
import com.founder.zdrygl.bean.ZdryZdryzb;
import com.founder.zdrygl.service.ZdryJgdxqxjdjbService;
import com.founder.zdrygl.service.ZdryZdryzbService;
import com.google.gson.Gson;

@Controller
@RequestMapping(value = "zdryJgdxqxjdjb")
public class ZdryJgdxqxjdjbController extends BaseController {

	private Logger logger = Logger.getLogger(this.getClass());

	@Resource(name = "zdryJgdxqxjdjbService")
	private ZdryJgdxqxjdjbService zdryJgdxqxjdjbService;

	@Resource(name = "zdryZdryzbService")
	private ZdryZdryzbService zdryZdryzbService;

	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView add(String id) {
		ModelAndView mv = new ModelAndView("zdrygl/edit/zdryJgdxqxjdjbAdd");
		ZdryJgdxqxjdjb entity = new ZdryJgdxqxjdjb();
		entity.setZdryid(id);
		mv.addObject("entity", entity);
		return mv;
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(ZdryJgdxqxjdjb entity, SessionBean sessionBean) {
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		Map<String, Object> map = new HashMap<String, Object>();
		sessionBean = getSessionBean(sessionBean);
		try {
			zdryJgdxqxjdjbService.save(entity, sessionBean);
			map.put(AppConst.STATUS, AppConst.SUCCESS);
			map.put(AppConst.MESSAGES, getAddSuccess());
			map.put(AppConst.SAVE_ID, "" + entity.getId()); // 返回主键
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
			map.put(AppConst.STATUS, AppConst.FAIL);
			map.put(AppConst.MESSAGES, getAddFail());
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(map));
		return mv;
	}
	
	@RequestMapping(value = "/queryList", method = RequestMethod.POST)
	public @ResponseBody
	EasyUIPage queryList(EasyUIPage page,
			@RequestParam(value = "rows", required = false) Integer rows,
			ZdryJgdxqxjdjb entity, SessionBean sessionBean) {
		page.setPagePara(rows);
		sessionBean = getSessionBean(sessionBean);
		return zdryJgdxqxjdjbService.queryList(page, entity);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * @Title: query
	 * @Description: TODO(查询列表页面)
	 * @param @return 设定文件
	 * @return ModelAndView 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/query", method = RequestMethod.GET)
	public ModelAndView query() {
		ModelAndView mv = new ModelAndView("zdry/zdryJgdxqxjdjbQuery");
		return mv;
	}

	

	

	/**
	 * @Title: edit
	 * @Description: TODO(编辑页面)
	 * @param @param id
	 * @param @return
	 * @param @throws BussinessException 设定文件
	 * @return ModelAndView 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ModelAndView edit(@PathVariable(value = "id") String id)
			throws BussinessException {
		ModelAndView mv = new ModelAndView("zdry/zdryJgdxqxjdjbEdit");
		ZdryJgdxqxjdjb entity = zdryJgdxqxjdjbService.queryById(id);
		if (entity == null) {
			throw new BussinessException("查询无数据！");
		}
		mv.addObject("entity", entity);
		return mv;
	}



	/**
	 * @Title: update
	 * @Description: TODO(修改保存)
	 * @param @param entity
	 * @param @param sessionBean
	 * @param @return 设定文件
	 * @return ModelAndView 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/{id}", method = { RequestMethod.POST,
			RequestMethod.PUT })
	public ModelAndView update(ZdryJgdxqxjdjb entity, SessionBean sessionBean) {
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		Map<String, Object> map = new HashMap<String, Object>();
		sessionBean = getSessionBean(sessionBean);
		try {
			zdryJgdxqxjdjbService.update(entity, sessionBean);
			map.put(AppConst.STATUS, AppConst.SUCCESS);
			map.put(AppConst.MESSAGES, getUpdateSuccess());
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
			map.put(AppConst.STATUS, AppConst.FAIL);
			map.put(AppConst.MESSAGES, getUpdateFail());
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(map));
		return mv;
	}

	/**
	 * @Title: edit
	 * @Description: TODO(审批页面)
	 * @param @param id
	 * @param @return
	 * @param @throws BussinessException 设定文件
	 * @return ModelAndView 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/sp", method = RequestMethod.GET)
	public ModelAndView sp(String id, Long messageid, SessionBean sessionBean)
			throws BussinessException {
		ModelAndView mv = new ModelAndView("zdry/zdryJgdxqxjdjbSp");
		ZdryJgdxqxjdjb entity = zdryJgdxqxjdjbService.queryById(id);
		if (entity == null) {
			throw new BussinessException("查询无数据！");
		}
		ZdryZdryzb zdryZdryzb = zdryZdryzbService.queryById(entity.getZdryid());
		mv.addObject("zdryZdryzb", zdryZdryzb);
		sessionBean = getSessionBean(sessionBean);
		entity.setSpr_id(sessionBean.getUserId());
		entity.setSpr_xm(sessionBean.getUserName());
		entity.setSpsj(DateUtils.getSystemDateString());
		entity.setMessageid(messageid);
		mv.addObject("entity", entity);
		return mv;
	}

	/**
	 * @Title: update
	 * @Description: TODO(审批保存)
	 * @param @param entity
	 * @param @param sessionBean
	 * @param @return 设定文件
	 * @return ModelAndView 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/updateSp", method = RequestMethod.POST)
	public ModelAndView updateSp(ZdryJgdxqxjdjb entity, SessionBean sessionBean) {
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		Map<String, Object> map = new HashMap<String, Object>();
		sessionBean = getSessionBean(sessionBean);
		try {
			zdryJgdxqxjdjbService.updateSp(entity, sessionBean);
			map.put(AppConst.STATUS, AppConst.SUCCESS);
			map.put(AppConst.MESSAGES, "审批成功！");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
			map.put(AppConst.STATUS, AppConst.FAIL);
			map.put(AppConst.MESSAGES, "审批失败！");
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(map));
		return mv;
	}

	/**
	 * @Title: delete
	 * @Description: TODO(注销保存)
	 * @param @param entity
	 * @param @param sessionBean
	 * @param @return 设定文件
	 * @return ModelAndView 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/{id}", method = { RequestMethod.DELETE })
	public ModelAndView delete(ZdryJgdxqxjdjb entity, SessionBean sessionBean) {
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		Map<String, Object> map = new HashMap<String, Object>();
		sessionBean = getSessionBean(sessionBean);
		try {
			zdryJgdxqxjdjbService.delete(entity, sessionBean);
			map.put(AppConst.STATUS, AppConst.SUCCESS);
			map.put(AppConst.MESSAGES, getDeleteSuccess());
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
			map.put(AppConst.STATUS, AppConst.FAIL);
			map.put(AppConst.MESSAGES, getDeleteFail());
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(map));
		return mv;
	}

}
