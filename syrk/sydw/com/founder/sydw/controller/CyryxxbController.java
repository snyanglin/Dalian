package com.founder.sydw.controller;

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
import com.founder.framework.exception.BussinessException;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.sydw.bean.Cyryxxb;
import com.founder.sydw.service.CyryxxbService;
import com.founder.sydw.vo.DwjbxxbSaveVO;

import com.google.gson.Gson;

@Controller
@RequestMapping(value = "cyryxxb")
public class CyryxxbController extends BaseController {

	private Logger logger = Logger.getLogger(this.getClass());

	@Resource(name = "cyryxxbService")
	private CyryxxbService cyryxxbService;

	/**
	 * 
	 * @param id 从业人员id
	 * @param dwid 单位id
	 * @param dwmc 单位名称
	 * @return
	 */
	@RequestMapping(value = "/createPage", method = RequestMethod.GET)
	public @ResponseBody
	ModelAndView createPage(String id, String dwid) {
		ModelAndView mv = new ModelAndView("sydw/cyryxxbAdd");
		SessionBean sessionBean = getSessionBean();
		Cyryxxb entity = new Cyryxxb();
		if (!StringUtils.isBlank(id)) {
			entity = cyryxxbService.queryById(id);
			if(entity.getSflzdm() == null || entity.getSflzdm().equals("")){
				entity.setSflzdm("0");	
			}
			if(entity.getSfysgzdm() == null || entity.getSfysgzdm().equals("")){
				entity.setSfysgzdm("0");
			}
		}else{
			entity.setSfysgzdm("0");
			entity.setSflzdm("0");			
		}
		
		if (sessionBean != null) {
			mv.addObject("pcsdm", sessionBean.getExtendValue("ssPcsCode"));
			mv.addObject("zrqdm", sessionBean.getUserOrgCode());
		}
		entity.setDwid(dwid);
		mv.addObject("entity", entity);
		return mv;
	}

	/**
	 * 保存从业人员信息
	 * @param entity
	 * @return
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public @ResponseBody
	ModelAndView save(Cyryxxb entity,DwjbxxbSaveVO swjbxxbSaveVO) {
		ModelAndView mv = new ModelAndView("redirect:/forward/"
				+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		try {
			Cyryxxb cyryxxb=cyryxxbService.queryByZjlx(entity);
				if (entity.getId() == null || entity.getId().equals("")&&cyryxxb==null) {
					cyryxxbService.add(entity, sessionBean);
					model.put(AppConst.STATUS, AppConst.SUCCESS);
					model.put(AppConst.MESSAGES, "新增【从业人员】成功！");
					model.put(AppConst.SAVE_ID, entity.getId()); // 返回主键
				}else if (entity.getId() == null || entity.getId().equals("")&&cyryxxb!=null) {
					model.put(AppConst.STATUS, AppConst.FAIL);
					model.put(AppConst.MESSAGES, "身份证对应人员已是该单位的从业人员");
				}
				else {
					cyryxxbService.update(entity,sessionBean);
					model.put(AppConst.STATUS, AppConst.SUCCESS);
					model.put(AppConst.MESSAGES, "修改【从业人员】成功！");
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
	 * 复用从业人员信息
	 * 
	 * @param cyzjdm
	 * @param zjhm
	 * @return
	 * @throws BussinessException
	 */
	@RequestMapping(value = "/getCyry", method = RequestMethod.POST)
	public @ResponseBody Map<String,Object> getCyry(String cyzjdm, String zjhm, String dwid) {
		Map<String, Object> model = new HashMap<String, Object>();
		if (StringUtils.isBlank(cyzjdm)) { // 默认为身份证
			cyzjdm = "111";
		}

		Cyryxxb cyryxxb = new Cyryxxb();
		cyryxxb.setDwid(dwid);
		cyryxxb.setCyzjdm(cyzjdm);
		cyryxxb.setZjhm(zjhm);
		cyryxxb = cyryxxbService.queryByZjlx(cyryxxb);
		model.put("cyryxxb", cyryxxb);
		return model;
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public @ResponseBody EasyUIPage list(EasyUIPage page,
			@RequestParam(value = "rows") Integer rows, String dwid) {
		page.setPagePara(rows);
		return cyryxxbService.queryList(page, dwid);
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public ModelAndView deleteCyryxxb(Cyryxxb cyryxxb) {
		ModelAndView mv = new ModelAndView("redirect:/forward/" + AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			cyryxxbService.delete(cyryxxb,  getSessionBean());
			model.put(AppConst.STATUS, AppConst.SUCCESS);
			model.put(AppConst.MESSAGES, getMessage("cancel.success"));
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage(), e);
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, getMessage("cancel.fail"));
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}
	

}
