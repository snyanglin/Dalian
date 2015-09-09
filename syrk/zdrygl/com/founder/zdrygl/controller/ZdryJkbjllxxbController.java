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

import com.founder.framework.annotation.RestfulAnnotation;
import com.founder.framework.base.controller.BaseController;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.components.AppConst;
import com.founder.framework.exception.BussinessException;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.zdrygl.bean.ZdryJkbjllxxb;
import com.founder.zdrygl.service.ZdryJkbjllxxbService;
import com.google.gson.Gson;

@Controller
@RequestMapping(value = "zdryJkbjllxxb")
public class ZdryJkbjllxxbController extends BaseController {

	private Logger logger = Logger.getLogger(this.getClass());

	@Resource(name = "zdryJkbjllxxbService")
	private ZdryJkbjllxxbService zdryJkbjllxxbService;

	/**
	 * @Title: add
	 * @Description: TODO(新增页面)
	 * @param @param zdryid
	 * @param @return 设定文件
	 * @return ModelAndView 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView add(String id) {
		ModelAndView mv = new ModelAndView("zdrygl/edit/zdryJkbjllxxb");
		ZdryJkbjllxxb entity = new ZdryJkbjllxxb();
		entity.setZdryid(id);
		mv.addObject("entity", entity);
		return mv;
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
	@RestfulAnnotation(valiField = "zdryid,jkbjlxdm,jkbjry_ybbjr_rygx,jkbjry_gmsfhm,jkbjry_xm", serverId = "3")
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(ZdryJkbjllxxb entity, SessionBean sessionBean) {
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		Map<String, Object> map = new HashMap<String, Object>();
		sessionBean = getSessionBean(sessionBean);
		try {
			zdryJkbjllxxbService.save(entity, sessionBean);
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
	
	
	@RequestMapping(value = "/queryDetail", method = RequestMethod.GET)
	public ModelAndView queryDetail(String id) {		
		ModelAndView mv = new ModelAndView("zdrygl/edit/zdryJkbjllxxbInfo");
		mv.addObject("entity",zdryJkbjllxxbService.queryById(id));
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
	@RestfulAnnotation(valiField = "id,zdryid,jkbjlxdm,jkbjry_ybbjr_rygx,jkbjry_gmsfhm,jkbjry_xm", serverId = "3")
	@RequestMapping(value = "/{id}", method = { RequestMethod.POST,
			RequestMethod.PUT })
	public ModelAndView update(ZdryJkbjllxxb entity, SessionBean sessionBean) {
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		Map<String, Object> map = new HashMap<String, Object>();
		sessionBean = getSessionBean(sessionBean);
		try {
			zdryJkbjllxxbService.update(entity, sessionBean);
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
	 * @Title: queryList
	 * @Description: TODO(查询列表数据)
	 * @param @param page
	 * @param @param rows
	 * @param @param entity
	 * @param @param sessionBean
	 * @param @return 设定文件
	 * @return EasyUIPage 返回类型
	 * @throws
	 *
	@RequestMapping(value = "/queryList", method = RequestMethod.POST)
	public @ResponseBody
	EasyUIPage queryList(EasyUIPage page,
			@RequestParam(value = "rows", required = false) Integer rows,
			ZdryJkbjllxxb entity, SessionBean sessionBean) {
		page.setPagePara(rows);
		sessionBean = getSessionBean(sessionBean);
		return zdryJkbjllxxbService.queryList(page, entity);
	}
	
	
	
	/**
	 * @Title: query
	 * @Description: TODO(查询列表页面)
	 * @param @return 设定文件
	 * @return ModelAndView 返回类型
	 * @throws
	 *
	@RequestMapping(value = "/query", method = RequestMethod.GET)
	public ModelAndView query() {
		ModelAndView mv = new ModelAndView("zdry/zdryJkbjllxxbQuery");
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
	 *
	@RestfulAnnotation(serverId = "3")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ModelAndView edit(@PathVariable(value = "id") String id,
			SessionBean sessionBean) throws BussinessException {
		if (sessionBean != null
				&& !StringUtils.isBlank(sessionBean.getUserName())) { // 服务调用
			ModelAndView mv = new ModelAndView(getViewName(sessionBean));
			ZdryJkbjllxxb entity = zdryJkbjllxxbService.queryById(id);
			if (entity == null) {
				throw new BussinessException("查询无数据！");
			}
			mv.addObject(AppConst.MESSAGES, new Gson().toJson(entity));
			return mv;
		} else {
			ModelAndView mv = new ModelAndView("zdry/zdryJkbjllxxb");
			ZdryJkbjllxxb entity = zdryJkbjllxxbService.queryById(id);
			if (entity == null) {
				throw new BussinessException("查询无数据！");
			}
			mv.addObject("entity", entity);
			return mv;
		}
	}

	

	

	/**
	 * @Title: delete
	 * @Description: TODO(注销保存)
	 * @param @param entity
	 * @param @param sessionBean
	 * @param @return 设定文件
	 * @return ModelAndView 返回类型
	 * @throws
	 *
	@RestfulAnnotation(valiField = "id", serverId = "3")
	@RequestMapping(value = "/{id}", method = { RequestMethod.DELETE })
	public ModelAndView delete(ZdryJkbjllxxb entity, SessionBean sessionBean) {
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		Map<String, Object> map = new HashMap<String, Object>();
		sessionBean = getSessionBean(sessionBean);
		try {
			zdryJkbjllxxbService.delete(entity, sessionBean);
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

	/**
	 * @Title: bjryIsExist
	 * @Description: TODO(帮教人员是否存在，对于同一个重点人员)
	 * @param @param entity
	 * @param @param sessionBean
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @throws
	 *
	@RequestMapping(value = "/existBjry", method = RequestMethod.POST)
	public @ResponseBody
	String existBjry(ZdryJkbjllxxb entity, SessionBean sessionBean) {
		boolean isExist = zdryJkbjllxxbService.existBjry(entity);
		return "" + isExist;
	}
	*/
}
