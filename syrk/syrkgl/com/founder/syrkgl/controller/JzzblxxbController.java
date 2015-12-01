package com.founder.syrkgl.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
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
import com.founder.framework.organization.department.bean.OrgOrganization;
import com.founder.framework.organization.department.service.OrgOrganizationService;
import com.founder.framework.utils.DateUtils;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.syrkgl.bean.Jzzblxxb;
import com.founder.syrkgl.bean.RyRyjbxxb;
import com.founder.syrkgl.bean.SyrkLdrkxxb;
import com.founder.syrkgl.service.JzzblxxbService;
import com.founder.syrkgl.service.RyRyjbxxbService;

import com.google.gson.Gson;

/**
 * ****************************************************************************
 * 
 * @Package: [com.founder.syrkgl.controller.JzzblxxbController.java]
 * @ClassName: [JzzblxxbController]
 * @Description: [居住证办理]
 * @Author: [陈红彬]
 * @CreateDate: [2015-4-27 下午6:14:13]
 * @UpdateUser: [zdk(如多次修改保留历史记录，增加修改记录)]
 * @UpdateDate: [2015-4-27 下午6:14:13，(如多次修改保留历史记录，增加修改记录)]
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]
 * @Version: [v1.0]
 */
@Controller
@RequestMapping(value = "jzzblxxb")
public class JzzblxxbController extends BaseController {

	private Logger logger = Logger.getLogger(this.getClass());

	@Resource(name = "jzzblxxbService")
	private JzzblxxbService jzzblxxbService;

	@Resource(name = "ryRyjbxxbService")
	private RyRyjbxxbService ryRyjbxxbService;
	@Resource(name = "orgOrganizationService")
	private OrgOrganizationService orgOrganizationService;

	/**
	 * 
	 * @Title: add
	 * @Description: TODO(跳转居住证办理)
	 * @param @param id
	 * @param @param ryid
	 * @param @param ryflid
	 * @param @return
	 * @param @throws BussinessException 设定文件
	 * @return ModelAndView 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView add(
			@RequestParam(value = "id", required = false) String id,
			String ryid, String syrkid) throws BussinessException {
		ModelAndView mv = new ModelAndView("syrkgl/jzzblxxbAdd");
		SessionBean sessionBean = getSessionBean();
		Jzzblxxb entity = new Jzzblxxb();
		if (!StringUtils.isBlank(id) || !StringUtils.isBlank(syrkid)) {
			SyrkLdrkxxb SyrkLdrkxxb = null;

			if (!StringUtils.isBlank(id)) {
				SyrkLdrkxxb = jzzblxxbService.queryLdrk(id);
				entity.setSyrkid(id);
			} else {
				SyrkLdrkxxb = jzzblxxbService.queryLdrk(syrkid);
				entity.setSyrkid(syrkid);
			}
			entity.setZjhm(SyrkLdrkxxb.getZjhm());
			entity.setXm(SyrkLdrkxxb.getXm());
			entity.setXbdm(SyrkLdrkxxb.getXbdm());
			entity.setMzdm(SyrkLdrkxxb.getMzdm());
			entity.setCsrq(SyrkLdrkxxb.getCsrq());
			//这里取基础人口信息的描述
			RyRyjbxxb ryRyjbxxb =ryRyjbxxbService.queryById(SyrkLdrkxxb.getRyid());
			entity.setHjd_dzxz(ryRyjbxxb.getHjd_dzms());
			entity.setJzd_dzxz(SyrkLdrkxxb.getJzd_dzxz());
			String nowDate = DateUtils.getSystemDateString();
			entity.setJzzblrq(nowDate);// 居住证办理日期
			entity.setRyid(ryid);
			entity.setCyzjdm(SyrkLdrkxxb.getCyzjdm());
			entity.setBlr_id(sessionBean.getUserId());
			entity.setBlr_xm(sessionBean.getUserName());
			entity.setJzz_blztdm("1");
			entity.setJzzblrq(DateUtils.getSystemDateString());

		}
		mv.addObject("entity", entity);
		return mv;
	}

	/**
	 * 
	 * @Title: edit
	 * @Description: TODO(跳转制证编辑页面)
	 * @param @param id
	 * @param @return
	 * @param @throws BussinessException 设定文件
	 * @return ModelAndView 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView edit(@RequestParam(value = "id") String id)
			throws BussinessException {
		ModelAndView mv = new ModelAndView("syrkgl/jzzblxxbEdit");
		SessionBean sessionBean = getSessionBean();
		Jzzblxxb entity = new Jzzblxxb();
		if (!StringUtils.isBlank(id)) {
			entity = jzzblxxbService.queryJzzblxxb(id);
			entity.setZzr_id(sessionBean.getUserId());
			entity.setZzr_xm(sessionBean.getUserName());
		}
		mv.addObject("entity", entity);
		return mv;
	}

	/**
	 * 
	 * @Title: edit
	 * @Description: TODO(保存编辑信息)
	 * @param @param id
	 * @param @return
	 * @param @throws BussinessException 设定文件
	 * @return ModelAndView 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/saveEdit", method = RequestMethod.POST)
	public ModelAndView saveEdit(Jzzblxxb entity, SessionBean sessionBean) {
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		Map<String, Object> model = new HashMap<String, Object>();
		sessionBean = getSessionBean(sessionBean);
		try {
			jzzblxxbService.updateJzzblxxb(entity, sessionBean);
			model.put(AppConst.STATUS, AppConst.SUCCESS);
			model.put(AppConst.MESSAGES, "修改居住证信息成功！");
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage(), e);
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, getUpdateFail());
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}

	/**
	 * 
	 * @Title: saveLg
	 * @Description: TODO(居住证新增保存)
	 * @param @param entity
	 * @param @return 设定文件
	 * @return ModelAndView 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(Jzzblxxb entity, SessionBean sessionBean) {
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		Map<String, Object> model = new HashMap<String, Object>();
		sessionBean = getSessionBean(sessionBean);

		try {
			
			if("12".equals(sessionBean.getUserOrgBiztype())){
				if("20".equals(sessionBean.getUserOrgLevel())){
					//内保支队办理
					entity.setBl_fjmc(sessionBean.getUserOrgName());
					entity.setBl_fjdm(sessionBean.getUserOrgCode());
				}else{
					//内保大队办理
					OrgOrganization org = this.orgOrganizationService.queryParentOrgByOrgcode(sessionBean.getUserOrgCode());
					entity.setBl_fjmc(org.getOrgname());
					entity.setBl_fjdm(org.getOrgcode());
					entity.setBl_pcsmc(sessionBean.getUserOrgName());
					entity.setBl_pcsdm(sessionBean.getUserOrgCode());
				}
				jzzblxxbService.saveJzzblxx(entity, sessionBean);
				
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, getAddSuccess());
				model.put(AppConst.SAVE_ID, entity.getId()); // 返回主键
			}else{
				
				// 添加不可重复录入居住证规则
				Jzzblxxb hasSameJzd_dzxz = jzzblxxbService.queryJzzblxxbByJzd_dzxzAndSyrkid(entity.getJzd_dzxz(), entity.getSyrkid());
				if (hasSameJzd_dzxz != null) {
					model.put(AppConst.STATUS, AppConst.FAIL);
					model.put(AppConst.MESSAGES, "该实有人口，于 "+hasSameJzd_dzxz.getJzzblrq()+" 已申请过【"+hasSameJzd_dzxz.getJzd_dzxz()+"】的居住证");
				}else{
					if ("50".equals(sessionBean.getUserOrgLevel())) {
						entity.setBl_fjmc(sessionBean.getExtendValue("ssFsxName"));
						entity.setBl_fjdm(sessionBean.getExtendValue("ssFsxCode"));
						entity.setBl_pcsmc(sessionBean.getExtendValue("ssPcsName"));
						entity.setBl_pcsdm(sessionBean.getExtendValue("ssPcsCode"));
						entity.setBl_zrqmc(sessionBean.getUserOrgName());
						entity.setBl_zrqdm(sessionBean.getUserOrgCode());
						jzzblxxbService.saveJzzblxx(entity, sessionBean);
					} else if ("32".equals(sessionBean.getUserOrgLevel())) {
						entity.setBl_fjmc(sessionBean.getExtendValue("ssFsxName"));
						entity.setBl_fjdm(sessionBean.getExtendValue("ssFsxCode"));
						entity.setBl_pcsmc(sessionBean.getUserOrgName());
						entity.setBl_pcsdm(sessionBean.getUserOrgCode());
						jzzblxxbService.saveJzzblxx(entity, sessionBean);
					}
					
					// 校验该人最后办理的居住证
					Jzzblxxb hasJzz = jzzblxxbService.queryLastYblJzz(entity.getRyid());
					if (hasJzz != null) {
						//页面消息提示
						String message = "";
						if (StringUtils.isBlank(hasJzz.getYxq_jzrq())){
							message = hasJzz.getBl_pcsmc() + " 已签发该实有人口居住证";
						}else{
							message = hasJzz.getBl_zrqmc() + " 已签发该实有人口居住证";
						}
						if(org.apache.commons.lang.StringUtils.isNotBlank(hasJzz.getJzz_qfrq())){
							message = message + "，签发日期：" + hasJzz.getJzz_qfrq();
						}
						
						model.put("message_yqf", message);
						//发送消息
						jzzblxxbService.noticeLastYblPcs(hasJzz, entity, sessionBean);
					}
					
					model.put(AppConst.STATUS, AppConst.SUCCESS);
					model.put(AppConst.MESSAGES, getAddSuccess());
					model.put(AppConst.SAVE_ID, entity.getId()); // 返回主键
				}
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
	 * 
	 * @Title: queryJzzblxxList
	 * @Description: TODO(查询居住证办理信息列表)
	 * @param @param page
	 * @param @param rows
	 * @param @param entity
	 * @param @param sessionBean
	 * @param @return 设定文件
	 * @return EasyUIPage 返回类型
	 * @throws
	 */
	@RestfulAnnotation(serverId = "3")
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public @ResponseBody
	EasyUIPage queryJzzblxxList(EasyUIPage page,
			@RequestParam(value = "rows", required = false) Integer rows,
			Jzzblxxb entity, SessionBean sessionBean) {
		page.setPagePara(rows);
		sessionBean = getSessionBean(sessionBean);
		String orglevel = sessionBean.getUserOrgLevel();
		EasyUIPage easyui = null;
		
		if("12".equals(sessionBean.getUserOrgBiztype())){
			entity.setNb_orgcode(sessionBean.getUserOrgCode());
			easyui = jzzblxxbService.queryJzzblList(page, entity);
		}else{
			String fxjdm = sessionBean.getExtendValue("ssFsxCode");
			if (!"30".equals(orglevel)) {
				entity.setBl_fjdm(fxjdm);
			}
			if ("31".equals(orglevel) || "30".equals(orglevel)) {
				easyui = jzzblxxbService.queryJzzblList(page, entity);
			}
		}
		return easyui;
	}

	
	@RestfulAnnotation(serverId = "3")
	@RequestMapping(value = "/export", method = RequestMethod.GET)
	public @ResponseBody
	void export(String bl_fjdm,String bl_pcsdm,String bl_zrqdm,String jzzblrq,String jzzbljsrq,String jzz_yxqdm,String xm,String zjhm, HttpServletResponse response,SessionBean sessionBean) {
		sessionBean = getSessionBean(sessionBean);
		String orglevel = sessionBean.getUserOrgLevel();
		EasyUIPage easyui = null;
		Jzzblxxb entity=new Jzzblxxb();
		entity.setBl_fjdm(bl_fjdm);
		entity.setBl_pcsdm(bl_pcsdm);
		entity.setBl_zrqdm(bl_zrqdm);
		entity.setJzzblrq(jzzblrq);
		entity.setJzzbljsrq(jzzbljsrq);
		entity.setJzz_yxqdm(jzz_yxqdm);
		entity.setXm(xm);
		entity.setZjhm(zjhm);
		if("12".equals(sessionBean.getUserOrgBiztype())){
			entity.setNb_orgcode(sessionBean.getUserOrgCode());
		}else{
			String fxjdm = sessionBean.getExtendValue("ssFsxCode");
			if (!"30".equals(orglevel)) {
				entity.setBl_fjdm(fxjdm);
			}
			if ("31".equals(orglevel) || "30".equals(orglevel)) {
			}
		}

		ServletOutputStream outputStream=null;
		try {
			outputStream = response.getOutputStream();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			String fileName = new String(("居住证下载").getBytes(), "ISO8859-1");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.setHeader("Content-disposition", "attachment;filename=jzzbl_" + DateUtils.getSystemDateString() + ".xlsx");

		
		this.jzzblxxbService.exportExcel(entity, outputStream);
	
	}
	
	
	/**
	 * 
	 * @Title: jzzView
	 * @Description: TODO(居住证办理预览)
	 * @param @param id
	 * @param @return
	 * @param @throws BussinessException 设定文件
	 * @return ModelAndView 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/jzzView", method = RequestMethod.GET)
	public ModelAndView jzzView(@RequestParam(value = "id") String id,
			SessionBean sessionBean) {
		ModelAndView mv = new ModelAndView("syrkgl/jzzblView");
		sessionBean = getSessionBean(sessionBean);
		Jzzblxxb entity = null;
		if (!StringUtils.isBlank(id)) {
			entity = jzzblxxbService.jzzView(id, sessionBean);
		}
		mv.addObject("entity", entity);
		return mv;
	}
	
	
	/***
	 * 
	 * @Title: getZdrylbdmExceptYlg
	 * @Description: 批量打印调用填写日期，和更改状态
	 * @author wu_chunhui@founder.com.cn
	 * @param @return
	 * @return String
	 * @throws
	 */
	@RequestMapping(value = "/piLiangDaYing", method = RequestMethod.POST)
	public @ResponseBody
	String piLiangDaYing(String id) {
		Jzzblxxb entity = null;
		SessionBean sessionBean = getSessionBean();
		if (!StringUtils.isBlank(id)) {
			entity = jzzblxxbService.jzzView(id, sessionBean);
		}
		String str = new Gson().toJson(entity);
		return str;
	}
	/***
	 * 
	 * @Title: piLiangDaYing
	 * @Description: TODO(打印全部查询结果，取得所有ID)
	 * @param @param id
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/getAllIds", method = RequestMethod.POST)
	public @ResponseBody
	String getAllIds(Jzzblxxb entity) {
		return new Gson().toJson(jzzblxxbService.queryIdsForPrint(entity)) ;
	}

	
	
	

}
