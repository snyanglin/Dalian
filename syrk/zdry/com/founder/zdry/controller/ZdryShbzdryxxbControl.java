package com.founder.zdry.controller;

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

import com.google.gson.Gson;

import com.founder.framework.annotation.RestfulAnnotation;
import com.founder.framework.base.controller.BaseController;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.components.AppConst;
import com.founder.framework.exception.RestException;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.syfw.bean.Fwjbxxb;
import com.founder.syrkgl.vo.SyrkAddVO;
import com.founder.zdry.bean.ZdryYwspb;
import com.founder.zdry.bean.ZdryZdryzb;
import com.founder.zdry.service.ZdryShbzdryxxbService;
import com.founder.zdry.vo.ZdryShbzdryVo;

/**
 * ****************************************************************************
 * @Package:      [com.founder.zdry.controller.ZdryShbzdryxxbControl.java]  
 * @ClassName:    [ZdryShbzdryxxbControl]   
 * @Description:  [涉环保重点人员信息表controller]   
 * @Author:       [wu_chunhui@founder.com.cn]  
 * @CreateDate:   [2015-6-15 上午10:52:04]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-6-15 上午10:52:04，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Controller
@RequestMapping("/shbzdry")
public class ZdryShbzdryxxbControl extends BaseController {
	
	@Resource(name="zdryShbzdryxxbService")
	private ZdryShbzdryxxbService zdryShbzdryxxbService;
	
	private Logger logger = Logger.getLogger(this.getClass());

	
	/**
	 * 
	 * @Title: manage
	 * @Description: TODO(打开涉环保重点人员管理页面)
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	@RequestMapping(value="/list",method = RequestMethod.GET)
	public String list(){
		return "zdry/zdryShbzdryList";
	}
	
	@RequestMapping(value="/create",method = RequestMethod.GET)
	public String create(){
		return "zdry/zdryShbzdryAdd";
	}
	
	@RequestMapping(value = { "/save" }, method = RequestMethod.POST)
	public ModelAndView save(ZdryShbzdryVo zdryShbzdryVo, SessionBean sessionBean)
			throws RestException {
		if (sessionBean != null
				&& !StringUtils.isBlank(sessionBean.getUserId())) {
			
		}
		ModelAndView mv = new ModelAndView("redirect:/forward/"+ AppConst.FORWORD);
		Map<String, Object> map = new HashMap<String, Object>();
		sessionBean = getSessionBean(sessionBean);	
		//ZdryZdryzb entity = zdryShbzdryVo.getZdryzb();
//		entity.setSsfxjdm(sessionBean.getExtendValue("ssFsxCode"));
//		entity.setSspcsdm(sessionBean.getExtendValue("ssPcsCode"));
//		entity.setSszrqdm(sessionBean.getUserOrgCode());
//		
		
		try {
		   this.zdryShbzdryxxbService.create(zdryShbzdryVo, sessionBean);
		   map.put(AppConst.STATUS, AppConst.SUCCESS);
		   map.put(AppConst.MESSAGES, "登记成功");
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
			map.put(AppConst.STATUS, AppConst.FAIL);
			map.put(AppConst.MESSAGES, "登记失败");
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(map));
		return mv;
	}
	
	@RequestMapping(value = "/updateShbzdry1jYwspb", method = RequestMethod.POST)
	public ModelAndView updateShbzdry1jYwspb(ZdryYwspb zdryYwspb, String messageid,
			SessionBean sessionBean) {
		ModelAndView mv = new ModelAndView("redirect:/forward/"
				+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		sessionBean = getSessionBean(sessionBean);
		
		try {
			zdryYwspb.setSpbm(sessionBean.getUserOrgCode());
			this.zdryShbzdryxxbService.updateSybzdry1jYwspb(zdryYwspb, sessionBean, messageid);
			model.put(AppConst.STATUS, AppConst.SUCCESS);
			model.put(AppConst.MESSAGES, getUpdateSuccess());
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getLocalizedMessage(), e);
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, getUpdateFail());
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}
	
	@RequestMapping(value = "/updateShbzdry2jYwspb", method = RequestMethod.POST)
	public ModelAndView updateShbzdry2jYwspb(ZdryYwspb zdryYwspb, String messageid,
			SessionBean sessionBean) {
		ModelAndView mv = new ModelAndView("redirect:/forward/"
				+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		sessionBean = getSessionBean(sessionBean);
		
		try {
			zdryYwspb.setSpbm(sessionBean.getUserOrgCode());
			this.zdryShbzdryxxbService.updateSybzdry2jYwspb(zdryYwspb, sessionBean, messageid);
			model.put(AppConst.STATUS, AppConst.SUCCESS);
			model.put(AppConst.MESSAGES, getUpdateSuccess());
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getLocalizedMessage(), e);
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, getUpdateFail());
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}
	
	
	/**
	 * 
	 * @Title: list
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param page
	 * @param @param rows
	 * @param @param entity
	 * @param @param sessionBean
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	@RestfulAnnotation(serverId="3")
	@RequestMapping(value="/list",method = RequestMethod.POST)
	public @ResponseBody EasyUIPage list(EasyUIPage page,@RequestParam(value="rows",required = false)Integer rows,
			ZdryZdryzb entity,SessionBean sessionBean){
		page.setPagePara(rows);
		sessionBean = getSessionBean(sessionBean);
		return zdryShbzdryxxbService.queryList(entity, page,sessionBean);
	}
	
}
