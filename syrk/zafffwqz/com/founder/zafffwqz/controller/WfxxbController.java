package com.founder.zafffwqz.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.founder.framework.base.controller.BaseController;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.components.AppConst;
import com.founder.framework.utils.StringUtils;
import com.founder.service.contextsearch.department.bean.DwContextCombo;
import com.founder.service.contextsearch.department.bean.DwContextCondition;
import com.founder.sydw.bean.Dwjbxxb;
import com.founder.sydw.bean.Dwxqxxb;
import com.founder.sydw.service.DwXqjbxxbService;
import com.founder.sydw.service.DwjbxxbService;
import com.founder.zafffwqz.bean.ZaffWfxx;
import com.founder.zafffwqz.service.SqjwsxxbService;
import com.founder.zafffwqz.service.WfxxbService;

import com.google.gson.Gson;

/******************************************************************************
 * @Package:      [com.founder.zafffwqz.controller.WfxxbController.java]  
 * @ClassName:    [WfxxbController]   
 * @Description:  [物防控制器：主要负责属性表]   
 * @Author:       [tian_chengwei@founder.com.cn]  
 * @CreateDate:   [2015-5-27 下午1:22:35]   
 * @UpdateUser:   [lk(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-5-27 下午1:22:35，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 * 
 *  * @review      : wu.w@founder.com.cn
 * @reviewDate  : 20150604
 */
@Controller
@RequestMapping(value = "/wfxxb")
public class WfxxbController extends BaseController {
	private Logger logger = Logger.getLogger(this.getClass());
	
	@Resource(name = "wfxxbService")
	private WfxxbService wfxxbService;
	
	@Resource(name = "dwjbxxbService")
	private DwjbxxbService dwjbxxbService;
	
	@Resource(name = "dwXqjbxxbService")
	private DwXqjbxxbService dwXqjbxxbService;
	
	@Resource(name="sqjwsxxbService")
	private SqjwsxxbService sqjwsxxbService;
	/**
	 * 
	 * @Title: addWfxxb
	 * @Description: TODO(添加修改操作跳转以及单位入口)
	 * @param  id
	 * @param  mainTabID
	 * @param  dwid
	 * @param  dwmc
	 * @param  infoUrl
	 * @param     设定文件
	 * @return ModelAndView    返回类型
	 * @throws
	 */
	@ResponseBody
	@RequestMapping(value = "/addWfxxb", method = RequestMethod.GET)
	public ModelAndView addWfxxb(String id,String mainTabID,String dwid,String dwmc,String infoUrl) {
		ModelAndView mv = new ModelAndView("zafffwqz/wfxxbAdd");
		mv.addObject("mainTabID", mainTabID);
		ZaffWfxx entity = new ZaffWfxx();
		if (!StringUtils.isBlank(id)) {
			entity.setId(id);
			entity = wfxxbService.queryWfxxb(entity);
			//单位名称
			Dwjbxxb dwjbxxb = new Dwjbxxb();
			dwjbxxb.setId(entity.getDwid());
			dwjbxxb = dwjbxxbService.query(dwjbxxb);
			if(dwjbxxb != null){
				mv.addObject("dwmc", dwjbxxb.getDwmc());
			}
			Dwxqxxb dwxqxxb = dwXqjbxxbService.query(entity.getXqid());
			if(dwxqxxb != null){
				mv.addObject("xqmc", dwxqxxb.getXqmc());
			}
		}else{
			Dwjbxxb dwjbxxb = new Dwjbxxb();
			dwjbxxb.setId(dwid);
			dwjbxxb = dwjbxxbService.query(dwjbxxb);
			if(dwjbxxb != null){
				mv.addObject("dwmc", dwjbxxb.getDwmc());
			}
		}
		mv.addObject("sydwid", dwid==null ? "":dwid);
		mv.addObject("infoUrl", infoUrl==null ? "":infoUrl);
		mv.addObject("entity", entity);
		//责任区名称、派出所名称
		SessionBean sessionBean = getSessionBean();
		mv.addObject("gxzrq", sessionBean.getUserOrgName());
		mv.addObject("gxpcs", sessionBean.getExtendMap().get("ssPcsName"));
		//单位id
		mv.addObject("dwid", dwid);
		return mv;
	}
	/**
	 * 
	 * @Title: saveWfxxb
	 * @Description: TODO(物防基本信息保存跳转)
	 * @param  entity
	 * @return ModelAndView    返回类型
	 * @throws
	 */
	@ResponseBody
	@RequestMapping(value = "/saveWfxxb", method = RequestMethod.POST)
	public ModelAndView saveWfxxb(ZaffWfxx entity){
		ModelAndView mv = new ModelAndView("redirect:/forward/" + AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		try {
			if (entity.getId() == null || entity.getId().equals("")) {
				
				entity.setGxfxjdm(sessionBean.getUserOrgCode().substring(0,6)+"000000");
				entity.setGxpcsdm((String)sessionBean.getExtendMap().get("ssPcsCode"));
				entity.setGxzrqdm(sessionBean.getUserOrgCode());
				wfxxbService.saveWfxxb(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "新增【物防信息】成功");
				model.put(AppConst.SAVE_ID, entity.getId()); // 返回主键
			} else {
				wfxxbService.updateWfxxb(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES,"修改【物防信息】成功");
			}
		}catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getLocalizedMessage(), e);
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, getAddFail());
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}
	
	@RequestMapping(value = "/searchXqContext", method = RequestMethod.POST)
	public @ResponseBody
	List<DwContextCombo> searchDepartment(DwContextCondition condition) {
		return wfxxbService.searchXqContext(condition);
	}
}
