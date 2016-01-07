package com.founder.zdrygl.base.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.founder.framework.annotation.RestfulAnnotation;
import com.founder.framework.base.controller.BaseController;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.components.AppConst;
import com.founder.framework.exception.BussinessException;
import com.founder.framework.organization.department.service.OrgOrganizationService;
import com.founder.framework.utils.StringUtils;
import com.founder.syrkgl.bean.RyRyjbxxb;
import com.founder.syrkgl.service.RyRyjbxxbService;
import com.founder.zdrygl.base.model.ZdryDtjsXsxxb;
import com.founder.zdrygl.base.model.ZdryZb;
import com.founder.zdrygl.base.service.ZdryDtjsService;
import com.founder.zdrygl.base.service.ZdryInfoQueryService;
import com.google.gson.Gson;
/**
 * ****************************************************************************
 * @Package:      [com.founder.zdrygl.controller.ZdryEditController.java]  
 * @ClassName:    [ZdryEditController]   
 * @Description:  [重点人员编辑页面控制器]   
 * @Author:       [weiwen]  
 * @CreateDate:   [2015-3-12 上午9:37:09]   
 * @UpdateUser:   [weiwen]   
 * @UpdateDate:   [2015-3-12 上午9:37:09，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Controller
@RequestMapping("zdryDtjs")
public class ZdryDtjsController extends BaseController {
	@Resource(name = "zdryDtjsService")
	private ZdryDtjsService zdryDtjsService;
	
	@Resource(name = "ryRyjbxxbService")
	private RyRyjbxxbService ryRyjbxxbService;
	
	@Resource(name = "orgOrganizationService")
	private OrgOrganizationService orgOrganizationService;
	
	@Resource(name="zdryQueryService")
	private ZdryInfoQueryService zdryQueryService ;
	
		
	@RestfulAnnotation(serverId = "3")
	@RequestMapping(value = "/addDtjsXsjbxx", method = RequestMethod.GET)
	public ModelAndView addDtjsXsjbxx( String zdryid,
			SessionBean sessionBean) throws BussinessException {

		    sessionBean = getSessionBean(sessionBean);
			ModelAndView mv = new ModelAndView("zdrygl/dtjsXsjbxxAdd");
			
			ZdryZb zdryzb = (ZdryZb) zdryQueryService.queryById(zdryid);
			ZdryDtjsXsxxb entity=new ZdryDtjsXsxxb();
			entity.setZdryid(zdryid);
			entity.setRylbxx(zdryzb.getZdrygllxdm());
			mv.addObject("entity", entity);
			return mv;
		
	}
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ModelAndView editDtjsXsjbxx(@PathVariable(value = "id") String id,
			SessionBean sessionBean) throws BussinessException {
		    sessionBean = getSessionBean(sessionBean);
			ModelAndView mv = new ModelAndView("zdrygl/dtjsXsjbxxAdd");
			ZdryDtjsXsxxb entity = this.zdryDtjsService.queryXsjbxxById(id);
			if (entity == null) {
				throw new BussinessException("查询无数据！");
			}
			mv.addObject(AppConst.MESSAGES, new Gson().toJson(entity));
			mv.addObject("entity",entity);
			return mv;
		
	}
	@RequestMapping(value = "/saveDtjs", method = RequestMethod.POST)
	public @ResponseBody
	ModelAndView saveDtjs(ZdryDtjsXsxxb entity, SessionBean sessionBean) {
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		Map<String, Object> model = new HashMap<String, Object>();
		sessionBean = getSessionBean(sessionBean);
		entity.setTxrid(sessionBean.getUserId());
		entity.setTxrmc(sessionBean.getUserName());
		entity.setTxrdwdm(sessionBean.getUserOrgCode());
		entity.setTxrdwmc(sessionBean.getUserOrgName());
		try {
			if(StringUtils.isBlank(entity.getId())){
				if(StringUtils.isBlank(entity.getZdry_zjhm())){
					ZdryZb zb = (ZdryZb)zdryQueryService.queryById(entity.getZdryid());
					RyRyjbxxb ryjbxxb = ryRyjbxxbService.queryById(zb.getRyid());
					entity.setZdry_zjhm(ryjbxxb.getZjhm());
				}				
				entity.setTxrsfzh(sessionBean.getUserId());
				String id =zdryDtjsService.saveDtjs(entity,sessionBean);		
				model.put(AppConst.MESSAGES, getAddSuccess());
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.SAVE_ID, "" + id); // 返回主键

			}else{
				zdryDtjsService.updateDtjs(entity, sessionBean);
				
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, getUpdateSuccess());
				model.put(AppConst.SAVE_ID, "" + entity.getId()); // 返回主键
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.put(AppConst.STATUS, AppConst.FAIL);
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}
	
	@RequestMapping(value = "/dtjsMore", method = RequestMethod.POST)
	public @ResponseBody
	ModelAndView dtjsMore(String dtjsXsxxid) {
		ModelAndView mv = new ModelAndView("zdrygl/dtjsMore");
	    ZdryDtjsXsxxb xsxxb=this.zdryDtjsService.queryXsjbxxById(dtjsXsxxid);
		mv.addObject("zdryZjhm",xsxxb.getZdry_zjhm());
		return mv;
	}





}
