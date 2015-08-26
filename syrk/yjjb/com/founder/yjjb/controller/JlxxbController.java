package com.founder.yjjb.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.ArrayUtils;
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
import com.founder.framework.organization.department.service.OrgOrganizationService;
import com.founder.framework.organization.user.bean.OrgUser;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.yjjb.bean.Ajxxb;
import com.founder.yjjb.bean.Jbjlspb;
import com.founder.yjjb.bean.Jbjlxxb;
import com.founder.yjjb.bean.Jlxxb;
import com.founder.yjjb.bean.Xsajgxb;
import com.founder.yjjb.bean.Xsjbxxb;
import com.founder.yjjb.bean.Xszcspb;
import com.founder.yjjb.service.AjxxbService;
import com.founder.yjjb.service.CommonService;
import com.founder.yjjb.service.JbjlspbService;
import com.founder.yjjb.service.JbjlxxbService;
import com.founder.yjjb.service.JlxxbService;
import com.founder.yjjb.service.XsajgxbService;
import com.founder.yjjb.service.XsjbxxbService;

import com.google.gson.Gson;

@Controller
@RequestMapping(value = "/jlxxb")
public class JlxxbController extends BaseController {
private Logger logger = Logger.getLogger(this.getClass());
	
	@Resource(name="jlxxbService")
	private JlxxbService jlxxbService;
	
	@Resource(name="commonService")
	private CommonService commonService;
	
	@Resource(name="jbjlspbService")
	private JbjlspbService jbjlspbService;
	
	@Resource(name="jbjlxxbService")
	private JbjlxxbService jbjlxxbService;
	
	@Resource(name="xsjbxxbService")
	private XsjbxxbService xsjbxxbService;
	
	@Resource(name="ajxxbService")
	private AjxxbService ajxxbService;
	
	@Resource(name = "orgOrganizationService")
	private OrgOrganizationService orgOrganizationService;
	
	@Resource(name="xsajgxbService")
	private XsajgxbService xsajgxbService;
	
	/**
	 * 跳转
	 * @param id
	 * @param mainTabID
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/openList", method = RequestMethod.GET)
	public ModelAndView jlxxbList(String id,String mainTabID) {
		
		ModelAndView mv = new ModelAndView("");
		mv.addObject("mainTabID", mainTabID);
		Jlxxb entity = new Jlxxb();
		
		if (!StringUtils.isBlank(id)) {
			
			entity.setId(id);
			entity = jlxxbService.queryById(entity);
		}
		mv.addObject("entity", entity);
		return mv;
	}
	
	/**
	 * 跳转新增/编辑页面</br>
	 * 审批页面用</br>
	 * @param id
	 * @param mainTabID
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/openAdd", method = RequestMethod.GET)
	public ModelAndView add(String id,String mainTabID) {
		
		ModelAndView mv = new ModelAndView("yjjb/jlxxCK");
		mv.addObject("mainTabID", mainTabID);
		Jlxxb jlxxb = new Jlxxb();
		Jbjlxxb jbjlxxb = new Jbjlxxb();
		Jbjlspb  jbjlspb  = new  Jbjlspb();
		Xsjbxxb xsjbxxb = new Xsjbxxb();
		Ajxxb ajxxb = new Ajxxb();
		// 用户单位
		SessionBean sessionBean = getSessionBean();
		String orgCode = sessionBean.getUserOrgCode();
		String orglevel = commonService.getDwjb(orgCode);

		if (!StringUtils.isBlank(id)) {
			
			jbjlspb.setId(id);
			jbjlspb = jbjlspbService.queryById(jbjlspb);
			
			jbjlxxb.setId(id);
			jbjlxxb = jbjlxxbService.queryById(jbjlxxb);
			
			jlxxb.setId(id);
			jlxxb = jlxxbService.queryById(jlxxb);
			
			xsjbxxb.setId(jbjlxxb.getXsbh());
			xsjbxxb = xsjbxxbService.queryById(xsjbxxb);
			
			ajxxb.setAjbh(jbjlxxb.getAjbh());
			ajxxb = ajxxbService.queryAllAjxxByAjbh(ajxxb);
			if(null==ajxxb.getXt_lrrbm() || "".equals(ajxxb.getXt_lrrbm())){
				ajxxb.setXt_lrrbm(ajxxb.getBadw());
			}
			
			if (ajxxb.getXt_lrrid().length() > 0) {
				
				OrgUser user = new OrgUser();
//				StringBuffer userSB = new StringBuffer();
				
				String[] alarms =  ajxxb.getXt_lrrid().split(",");
				//String[] lrrid = ajxxb.getXt_lrrid().split(",");
				if(null!=alarms){
					List<String> username = new ArrayList<String>(); 
					for (String alarm : alarms) {
						user = (OrgUser)commonService.getUserByalarm(alarm);
						username.add(user.getUsername());
					}
					ajxxb.setXt_lrrxm(org.apache.commons.lang.StringUtils.join(username, ","));
				}
				
/*
				if (alarms.length > 0) {
					
					
					for (int i = 0; i < alarms.length; i++) {
						
						String alarm = alarms[i];
						user = (OrgUser) commonService.getUserByalarm(alarm);
						
						if (i == alarms.length -1) {
							
							userSB.append(user.getUsername() );
						} else{
							
							userSB.append(user.getUsername() + ", ");
						}
					}
					
					ajxxb.setXt_lrrxm(userSB.toString());
				}
				*/
			}
		}
		
		//根据ajid和xsid查询线索案件表内容
		Xsajgxb entityXsAj = new Xsajgxb();
		entityXsAj.setXsbh(xsjbxxb.getId());
		entityXsAj.setAjbh(ajxxb.getAjbh());
		entityXsAj = xsajgxbService.queryByXsidAjid(entityXsAj);
		String ajSource = entityXsAj.getAjsource();
		//查询当前用户的警号
		String orgId = sessionBean.getUserId();
		String alarm = commonService.selectByOrgId(orgId);//查询当前用户的警号
		
		//获取举报奖励审批表的主键，录入时间，部门，状态，回复
		Jbjlspb entityJbjlspb = new Jbjlspb();
		List<Jbjlspb> list = new ArrayList<Jbjlspb>();
		entityJbjlspb.setSqbh(jbjlxxb.getId());
		list = jbjlspbService.queryBySqbh(entityJbjlspb);
		
		//获得上级部门名称
				String sqdwUpId = commonService.queryUpOrgID(jlxxb.getSqdw());
				String sqdwUpName = commonService.queryNameOrgID(sqdwUpId);
		
		mv.addObject("jbjlspb", jbjlspb);
		mv.addObject("jlxxb", jlxxb);
		mv.addObject("jbjlxxb", jbjlxxb);
		mv.addObject("xsjbxxb", xsjbxxb);
		mv.addObject("ajxxb", ajxxb);
		mv.addObject("orglevel", orglevel);
		mv.addObject("ajSource", ajSource);
		mv.addObject("alarm", alarm);
		mv.addObject("list", list);
		mv.addObject("sqdwUpName", sqdwUpName);
		
		return mv;
	}
	/**
	 * 新增和修改
	 * @param entity
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(Jlxxb entity){
		
		ModelAndView mv = new ModelAndView("redirect:/forward/" + AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		String orgCode = sessionBean.getUserOrgCode();
		try {
			if (entity.getId() == null || entity.getId().equals("")) {	//新增
				
				entity.setId(commonService.CreateNewSeq("07", orgCode));
				jlxxbService.save(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES,  getMessage("add.success"));
				model.put(AppConst.SAVE_ID, entity.getId()); // 返回主键
			} else {	//修改
				
				jlxxbService.update(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES,  getMessage("update.success"));
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
	
	/**
	 * 查询</br>
	 * @param page
	 * @param rows
	 * @param entity
	 * @return
	 */
	@RequestMapping(value = "/query", method = RequestMethod.POST)
	public @ResponseBody
	EasyUIPage queryList(EasyUIPage page,
			@RequestParam(value = "rows") Integer rows, Jlxxb entity){
		page.setPagePara(rows);
		SessionBean sessionBean = getSessionBean();
		if(null != sessionBean){
			
		}
		
		// 默认查询条件为本单位，页面查询条件为本单位及下属单位
		if (null == entity.getSqdw() || entity.getSqdw().equals("")) {
			if(null!=sessionBean){
				entity.setSqdw(sessionBean.getUserOrgCode());
			}else{
				entity.setSqdw("NULL");
			}
		}
		
		// 去除右侧的0，进行模糊查询
		entity.setSqdw(entity.getSqdw().replaceAll("0+?$", ""));
		
		return this.jlxxbService.queryList(page,entity);
	}
	
	/**
	 * 注销
	 * @param entity
	 * @return
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public @ResponseBody
	ModelAndView delete(Jlxxb entity){
		
		ModelAndView mv = new ModelAndView("redirect:/forward/"	+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		
		try {
			jlxxbService.delete(entity, sessionBean);
			model.put(AppConst.STATUS, AppConst.SUCCESS);
			model.put(AppConst.MESSAGES,  getMessage("cancel.success"));
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
	 * 查询id
	 * @param xsbh
	 * @return
	 */
	@RequestMapping(value = "/queryId", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> queryId(String xsbh,String ajbh){
		Map<String, Object> model = new HashMap<String, Object>();
		Jbjlxxb jbjlxxb = new Jbjlxxb();
		jbjlxxb.setXsbh(xsbh);
		jbjlxxb.setAjbh(ajbh);
		jbjlxxb = jbjlxxbService.queryId(jbjlxxb);
		model.put("appId", jbjlxxb.getId());
		return model;
	}
}
