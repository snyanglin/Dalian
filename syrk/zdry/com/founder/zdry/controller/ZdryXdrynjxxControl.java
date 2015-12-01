package com.founder.zdry.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.founder.framework.annotation.RestfulAnnotation;
import com.founder.framework.base.controller.BaseController;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.components.AppConst;
import com.founder.framework.exception.BussinessException;
import com.founder.zdry.bean.ZdryXdrynjxxb;
import com.founder.zdry.service.ZdryXdryNjxxService;

import com.google.gson.Gson;

/**
 * ****************************************************************************
 * 
 * @Package: [com.founder.zdry.controller.ZdryZdryzbControl.java]
 * @ClassName: [ZdryZdryzbControl]
 * @Description: [重点人员总表]
 * @Author: [weiwen]
 * @CreateDate: [2015-3-19 上午10:51:54]
 * @UpdateUser: [weiwen]
 * @UpdateDate: [2015-3-19 上午10:51:54，(如多次修改保留历史记录，增加修改记录)]
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]
 * @Version: [v1.0]
 */
@Controller
@RequestMapping("zdryXdrynjxx")
public class ZdryXdrynjxxControl extends BaseController {

	private Logger logger = Logger.getLogger(this.getClass());

	@Resource(name = "zdryXdryNjxxService")
	private ZdryXdryNjxxService zdryXdryNjxxService;

	/**
	 * 打开添加页面
	 * @param zdryid
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView add(String zdryid) {

		if (zdryid == null) {// 测试用
			zdryid = "79fbaec395fe40089d6ae894a9b1840b";
		}

		ModelAndView mv = new ModelAndView("zdry/zdryXdrynjxx");
		ZdryXdrynjxxb entity = new ZdryXdrynjxxb();
		entity.setZdryid(zdryid);
		mv.addObject("entity", entity);
		return mv;
	}

	/**
	 * 新建数据
	 * @param entity
	 * @param sessionBean
	 * @return
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(ZdryXdrynjxxb entity, SessionBean sessionBean) {
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		Map<String, Object> map = new HashMap<String, Object>();
		sessionBean = getSessionBean(sessionBean);
		try {
			zdryXdryNjxxService.save(entity, sessionBean);
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

	/**
	 * 打开编辑页面
	 * 
	 * @param id
	 * @param sessionBean
	 * @return
	 * @throws BussinessException
	 */
	@RestfulAnnotation(serverId = "3")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ModelAndView edit(@PathVariable(value = "id") String id,
			SessionBean sessionBean) throws BussinessException {
		ModelAndView mv = new ModelAndView("zdry/zdryXdrynjxx");
		ZdryXdrynjxxb entity = zdryXdryNjxxService.queryById(id);
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
	@RestfulAnnotation(serverId = "3")
	@RequestMapping(value = "/{id}", method = { RequestMethod.POST,	RequestMethod.PUT })
	public ModelAndView update(ZdryXdrynjxxb entity, SessionBean sessionBean) {
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		Map<String, Object> map = new HashMap<String, Object>();
		sessionBean = getSessionBean(sessionBean);
		try {
			zdryXdryNjxxService.update(entity, sessionBean);
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
}
