package com.founder.zdrygl.base.controller;

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

import com.founder.framework.annotation.RestfulAnnotation;
import com.founder.framework.base.controller.BaseController;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.components.AppConst;
import com.founder.framework.exception.BussinessException;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.zdrygl.base.model.ZdryZagltdxxb;
import com.founder.zdrygl.base.service.ZdryZagltdxxbService;
import com.google.gson.Gson;

@Controller
@RequestMapping(value = "zdryZagltdxxb")
public class ZdryZagltdxxbController extends BaseController {

	private Logger logger = Logger.getLogger(this.getClass());

	@Resource(name = "zdryZagltdxxbService")
	private ZdryZagltdxxbService zdryZagltdxxbService;

	/**
	 * @Title: add
	 * @Description: TODO(新增页面)
	 * @param @param zdryid
	 * @param @return 设定文件
	 * @return ModelAndView 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView add(String zdryid) {
		ModelAndView mv = new ModelAndView("zdrygl/edit/zdryZagltdxxb");
		ZdryZagltdxxb entity = new ZdryZagltdxxb();
		entity.setZdryid(zdryid);
		mv.addObject("entity", entity);
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
	@RestfulAnnotation(serverId = "3")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ModelAndView edit(@PathVariable(value = "id") String id,
			SessionBean sessionBean) throws BussinessException {
		if (sessionBean != null
				&& !StringUtils.isBlank(sessionBean.getUserName())) { // 服务调用
			ModelAndView mv = new ModelAndView(getViewName(sessionBean));
			ZdryZagltdxxb entity = zdryZagltdxxbService.queryById(id);
			if (entity == null) {
				throw new BussinessException("查询无数据！");
			}
			mv.addObject(AppConst.MESSAGES, new Gson().toJson(entity));
			return mv;
		} else {
			ModelAndView mv = new ModelAndView("zdrygl/edit/zdryZagltdxxb");
			ZdryZagltdxxb entity = zdryZagltdxxbService.queryById(id);
			if (entity == null) {
				throw new BussinessException("查询无数据！");
			}
			mv.addObject("entity", entity);
			return mv;
		}
	}

	/**
	 * @Title: save
	 * @Description: TODO(新增保存)
	 * @param @param entity
	 * @param @param sessionBean
	 * @param @return 设定文件
	 * @return ModelAndView 返回类型
	 * @throws
	 */
	@RestfulAnnotation(valiField = "zdryid", serverId = "3")
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(ZdryZagltdxxb entity, SessionBean sessionBean) {
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		Map<String, Object> map = new HashMap<String, Object>();
		sessionBean = getSessionBean(sessionBean);
		try {
			zdryZagltdxxbService.save(entity, sessionBean);
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
	 * @Title: update
	 * @Description: TODO(修改保存)
	 * @param @param entity
	 * @param @param sessionBean
	 * @param @return 设定文件
	 * @return ModelAndView 返回类型
	 * @throws
	 */
	@RestfulAnnotation(valiField = "id,zdryid", serverId = "3")
	@RequestMapping(value = "/{id}", method = { RequestMethod.POST,
			RequestMethod.PUT })
	public ModelAndView update(ZdryZagltdxxb entity, SessionBean sessionBean) {
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		Map<String, Object> map = new HashMap<String, Object>();
		sessionBean = getSessionBean(sessionBean);
		try {
			zdryZagltdxxbService.update(entity, sessionBean);
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
