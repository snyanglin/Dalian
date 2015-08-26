package com.founder.sydw.controller;

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
import com.founder.sydw.bean.Dwcfxxb;
import com.founder.sydw.bean.Dwjcxxb;
import com.founder.sydw.service.DwcfxxbService;

import com.google.gson.Gson;
/**
 * ****************************************************************************
 * @Package:      [com.founder.sydw.controller.DwcfxxbController.java]  
 * @ClassName:    [DwcfxxbController]   
 * @Description:  [单位处罚控制层]   
 * @Author:       [yu_guangli@founder.com.cn]  
 * @CreateDate:   [2015-6-11 上午9:49:06]   
 * @UpdateUser:   [yuguangli(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-6-11 上午9:49:06，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [增加分页查询方法queryList]  
 * @Version:      [v1.0]
 */
@Controller
@RequestMapping(value = "/dwcfxxb")
public class DwcfxxbController extends BaseController {
	
	private Logger logger = Logger.getLogger(this.getClass());
	
	@Resource(name = "dwcfxxbService")
	private DwcfxxbService dwcfxxbService;
	
	/**
	 * 跳转
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView edit(String id,String dwid){
		ModelAndView mv = new ModelAndView("sydw/dwcfAdd");
		Dwcfxxb entity = new Dwcfxxb();
		entity.setDwid(dwid);
		if(null!=id&&!"".equals(id)){
			entity.setId(id);
			entity = dwcfxxbService.queryEntityById(entity);
		}
		mv.addObject("entity", entity);
		return mv;
	}
	/**
	 * 单位处罚
	 * @param entity
	 * @return
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(Dwcfxxb entity){
		ModelAndView mv = new ModelAndView("redirect:/forward/"
				+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		try {
			if(null==entity.getId()||"".equals(entity.getId())){
				entity.setXt_zxbz("0");
				dwcfxxbService.save(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "新增【单位处罚】成功！");
				model.put(AppConst.SAVE_ID, entity.getId()); // 返回主键
			} else {
				dwcfxxbService.update(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "修改【单位处罚】成功！");
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
	 * @Title: queryList
	 * @Description: 查询列表-单位处罚管理
	 * @param @param page
	 * @param @param rows
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/queryList", method = RequestMethod.POST)
	public @ResponseBody EasyUIPage queryDw(EasyUIPage page, @RequestParam(value = "rows")Integer rows,Dwcfxxb entity) {
		page.setPagePara(rows);
		return dwcfxxbService.queryList(page, entity);
	}
	
	@RequestMapping(value = "/dwcfxxb_query", method = RequestMethod.POST)
	public @ResponseBody List<Dwcfxxb> dwjcxxb_query(String dwid) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("dwid", dwid);
		map.put("maxNum", 10);
		return dwcfxxbService.dwcfxxb_query(map);
	}
}
