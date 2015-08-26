package com.founder.sydw.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
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
import com.founder.sydw.bean.Dwjcdata;
import com.founder.sydw.bean.Dwjctype;
import com.founder.sydw.bean.Dwjcxxb;
import com.founder.sydw.service.DwjctempService;

import com.google.gson.Gson;
/**
 * @描述: 单位检查模板配置
 * @作者:yu_guangli@founder.com 
 * @日期： 2015-6-5 下午1:28:39 
 * @throws
 */
@Controller
@RequestMapping(value = "dwjctemp")
public class DwjctempController extends BaseController {
	private Logger logger = Logger.getLogger(this.getClass());
	@Resource(name = "dwjctempService")
	private DwjctempService dwjctempService;
	
	/**
	 * @Title: addMultDwjctype 
	 * @描述: 保存到DW_DWJC_TYPE表数据
	 * @作者: yu_guangli@founder.com 
	 * @参数: 传入参数定义 
	 * @日期：  2015-6-5 下午1:28:39 
	 * @throws
	 */
	@RequestMapping(value = "/addMultDwjctype", method = RequestMethod.POST)
	public @ResponseBody ModelAndView addMultDwjctype(Dwjctype entity){
		ModelAndView mv = new ModelAndView("redirect:/forward/"+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		try {
			entity.setXt_zxbz("0");
			dwjctempService.addMultDwjctype(entity, sessionBean);
			model.put(AppConst.STATUS, AppConst.SUCCESS);
			model.put(AppConst.MESSAGES, "新增【检查类目】成功！");
		}catch (Exception e) {
			logger.error(e.getLocalizedMessage(), e);
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, getAddFail());
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}
	
	/**
	 *调到单位检查类目编辑页面
	 * @Description 跳转显示
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/editDwjctype", method = RequestMethod.GET)
	public ModelAndView editDwjctype(String id){
		ModelAndView mv = new ModelAndView("sydw/dwjctypeEdit");
		Dwjctype entity = new Dwjctype();
		entity.setId(id);
		if(null!=id&&!"".equals(id)){
			entity.setId(id);
			entity = dwjctempService.queryOneDwjctype(entity);
		}
		
		mv.addObject("entity", entity);
		return mv;
	}
	
	/**
	 * @Title: updateDwjctype 
	 * @描述: 修改DW_DWJC_TYPE表数据
	 * @作者: yu_guangli@founder.com 
	 * @参数: 传入参数定义 
	 * @日期：  2015-6-5 下午1:28:39 
	 * @throws
	 */
	@RequestMapping(value = "/updateDwjctype", method = RequestMethod.POST)
	public @ResponseBody ModelAndView updateDwjctype(Dwjctype entity){
		ModelAndView mv = new ModelAndView("redirect:/forward/"+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		try {
			dwjctempService.updateDwjctype(entity, sessionBean);
			model.put(AppConst.STATUS, AppConst.SUCCESS);
			model.put(AppConst.MESSAGES, "修改【检查类目】成功！");
		}catch (Exception e) {
			logger.error(e.getLocalizedMessage(), e);
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, getAddFail());
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}
	
	/**
	 * @Title: deleteDwjctype 
	 * @描述: 变更DW_DWJC_TYPE表数据的状态
	 * @作者: yu_guangli@founder.com 
	 * @参数: 传入参数定义 
	 * @日期：  2015-6-5 下午1:28:39 
	 * @throws
	 */
	@RequestMapping(value = "/deleteDwjctype", method = RequestMethod.POST)
	public @ResponseBody ModelAndView deleteDwjctype(Dwjctype entity){
		ModelAndView mv = new ModelAndView("redirect:/forward/"+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		try {
			entity.setXt_zxbz("1");
			dwjctempService.deleteDwjctype(entity, sessionBean);
			model.put(AppConst.STATUS, AppConst.SUCCESS);
			model.put(AppConst.MESSAGES, "注销【检查类目】成功！");
		}catch (Exception e) {
			logger.error(e.getLocalizedMessage(), e);
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, getAddFail());
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}
	
	@RequestMapping(value = "/deletePatchDwjctype", method = RequestMethod.POST)
	public ModelAndView deletePatchDwjctype(@RequestBody Dwjctype[] entityArray) {
		ModelAndView mv = new ModelAndView("redirect:/forward/"+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		try {
			for (int i = 0; i < entityArray.length; i++) {
				entityArray[i].setXt_zxbz("1");
				dwjctempService.deleteDwjctype(entityArray[i], sessionBean);
			}
			model.put(AppConst.STATUS, AppConst.SUCCESS);
			model.put(AppConst.MESSAGES, getDeleteSuccess());
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getLocalizedMessage(), e);
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, getDeleteFail());
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}
	
	/**
	 * @Title: queryDwjctype 
	 * @描述: 单位检查类型分页查询
	 * @作者: yu_guangli@founder.com 
	 * @参数: 传入参数定义 
	 * @日期：  2015-6-5 下午1:28:39 
	 * @throws
	 */
	@RequestMapping(value = "/queryDwjctype", method = RequestMethod.POST)
	public @ResponseBody EasyUIPage queryDwjctype(EasyUIPage page, @RequestParam(value = "rows",required = false) Integer rows, Dwjctype entity) {
		page.setPagePara(rows);
		return dwjctempService.queryDwjctype(page, entity);
	}
	
	/**
	 * @Title: addMultDwjcdata 
	 * @描述: 保存到DW_DWJC_DATA表数据
	 * @作者: yu_guangli@founder.com 
	 * @参数: 传入参数定义 
	 * @日期：  2015-6-5 下午1:28:39 
	 * @throws
	 */
	@RequestMapping(value = "/addMultDwjcdata", method = RequestMethod.POST)
	public @ResponseBody ModelAndView addMultDwjcdata(Dwjcdata entity){
		ModelAndView mv = new ModelAndView("redirect:/forward/"+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		try {
			entity.setXt_zxbz("0");
			dwjctempService.addMultDwjcdata(entity, sessionBean);
			model.put(AppConst.STATUS, AppConst.SUCCESS);
			model.put(AppConst.MESSAGES, "新增【检查项信息】成功！");
		}catch (Exception e) {
			logger.error(e.getLocalizedMessage(), e);
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, getAddFail());
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}

	/**
	 *调到单位检查项编辑页面
	 * @Description 跳转显示
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/editDwjcdata", method = RequestMethod.GET)
	public ModelAndView editDwjcdata(String id){
		ModelAndView mv = new ModelAndView("sydw/dwjcdataEdit");
		Dwjcdata entity = new Dwjcdata();
		entity.setId(id);
		if(null!=id&&!"".equals(id)){
			entity.setId(id);
			entity = dwjctempService.queryOneDwjcdata(entity);
		}
		
		mv.addObject("entity", entity);
		return mv;
	}
	
	/**
	 * @Title: updateDwjcdata 
	 * @描述: 修改DW_DWJC_DATA表数据
	 * @作者: yu_guangli@founder.com 
	 * @参数: 传入参数定义 
	 * @日期：  2015-6-5 下午1:28:39 
	 * @throws
	 */
	@RequestMapping(value = "/updateDwjcdata", method = RequestMethod.POST)
	public @ResponseBody ModelAndView updateDwjctype(Dwjcdata entity){
		ModelAndView mv = new ModelAndView("redirect:/forward/"+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		try {
			dwjctempService.updateDwjcdata(entity, sessionBean);
			model.put(AppConst.STATUS, AppConst.SUCCESS);
			model.put(AppConst.MESSAGES, "修改【检查项信息】成功！");
		}catch (Exception e) {
			logger.error(e.getLocalizedMessage(), e);
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, getAddFail());
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}
	
	/**
	 * @Title: deleteDwjcdata 
	 * @描述: 变更DW_DWJC_DATA表数据的状态
	 * @作者: yu_guangli@founder.com 
	 * @参数: 传入参数定义 
	 * @日期：  2015-6-5 下午1:28:39 
	 * @throws
	 */
	@RequestMapping(value = "/deleteDwjcdata", method = RequestMethod.POST)
	public @ResponseBody ModelAndView deleteDwjcdata(Dwjcdata entity){
		ModelAndView mv = new ModelAndView("redirect:/forward/"+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		try {
			dwjctempService.deleteDwjcdata(entity, sessionBean);
			model.put(AppConst.STATUS, AppConst.SUCCESS);
			model.put(AppConst.MESSAGES, "注销【检查项信息】成功！");
		}catch (Exception e) {
			logger.error(e.getLocalizedMessage(), e);
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, getAddFail());
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}
	
	@RequestMapping(value = "/deletePatchDwjcdata", method = RequestMethod.POST)
	public ModelAndView deletePatchDwjcdata(@RequestBody Dwjcdata[] entityArray) {
		ModelAndView mv = new ModelAndView("redirect:/forward/"+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		try {
			for (int i = 0; i < entityArray.length; i++) {
				entityArray[i].setXt_zxbz("1");
				dwjctempService.deleteDwjcdata(entityArray[i], sessionBean);
			}
			model.put(AppConst.STATUS, AppConst.SUCCESS);
			model.put(AppConst.MESSAGES, getDeleteSuccess());
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getLocalizedMessage(), e);
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, getDeleteFail());
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}
	
	/**
	 * @Title: queryDwjcdata 
	 * @描述: 单位检查项分页查询
	 * @作者: yu_guangli@founder.com 
	 * @参数: 传入参数定义 
	 * @日期：  2015-6-5 下午1:28:39 
	 * @throws
	 */
	@RequestMapping(value = "/queryDwjcdata", method = RequestMethod.POST)
	public @ResponseBody EasyUIPage queryDwjcdata(EasyUIPage page, @RequestParam(value = "rows",required = false) Integer rows, Dwjcdata entity) {
		page.setPagePara(rows);
		return dwjctempService.queryDwjcdata(page, entity);
	}
	/**
	 * @Title: queryDwjcTemp 
	 * @描述: 查询单位检查模板--预览功能
	 * @作者: yu_guangli@founder.com 
	 * @参数: 传入参数定义 
	 * @日期：  2015-6-5 下午1:28:39 
	 * @throws
	 */
	@RequestMapping(value = "/queryDwjcTemp", method = RequestMethod.GET)
	public @ResponseBody ModelAndView queryDwjcTemp(String sydwlx,String ywlbdm){
		ModelAndView mv = new ModelAndView("sydw/dwzajctemp_preview");
		List<Dwjctype> list = new ArrayList<Dwjctype>();
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("sydwlx", sydwlx);
		param.put("ywlbdm", ywlbdm);
		list = dwjctempService.queryDwjcTemp(param);
		mv.addObject("list", list);
		return mv;
	}
}
