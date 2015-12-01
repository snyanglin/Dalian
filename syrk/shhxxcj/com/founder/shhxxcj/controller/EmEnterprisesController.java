package com.founder.shhxxcj.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

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
import com.founder.framework.utils.DateUtils;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.shhxxcj.bean.EmEnterprises;
import com.founder.shhxxcj.bean.Enterprises;
import com.founder.shhxxcj.service.EmEnterprisesService;
import com.founder.shhxxcj.service.EnterprisesService;
import com.founder.sydw_dl.bean.Dwbmxxb;
import com.founder.sydw_dl.bean.Dwjbxxb;
import com.founder.sydw_dl.service.DwjbxxbService;
import com.founder.sydw_dl.vo.DwjbxxbSaveVO;

import com.google.gson.Gson;



/******************************************************************************
 * @Package:      [com.founder.shhxxcj.controller.EnterprisesController.java]  
 * @ClassName:    [EnterprisesController]   
 * @Description:  [EnterprisesController]   
 * @Author:       [cong_rihong@founder.com.cn]  
 * @CreateDate:   [2015-11-19 上午10:35:58]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-11-19 上午10:35:58，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 */
@Controller
@RequestMapping(value = "/shhxxcj")
public class EmEnterprisesController extends BaseController {


	@Resource
	private EmEnterprisesService emEnterprisesService;
	
	@Resource
	private DwjbxxbService dwjbxxbService;
	/**
	 * @Title: query
	 * @Description: TODO(实有人口管理列表页面)
	 * @param @return 设定文件
	 * @return ModelAndView 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/emEnterpriseList", method = RequestMethod.GET)
	public ModelAndView query() {
		ModelAndView mv = new ModelAndView("shhxxcj/emEnterpriseList");
		return mv;
	}

	/**
	 * @Title: queryList
	 * @描述: 查询实有人口管理列表数据【服务接口】
	 * @作者: zhang_guoliang@founder.com
	 * @参数: 传入参数定义
	 * @日期： 2015-4-14 上午11:18:01
	 * @返回值: EasyUIPage 返回类型
	 * @throws
	 */
	@RestfulAnnotation(serverId = "3")
	@RequestMapping(value = "/queryEmEnterpriseList", method = RequestMethod.POST)
	public @ResponseBody
	EasyUIPage queryList(EasyUIPage page,
			@RequestParam(value = "rows", required = false) Integer rows,
			EmEnterprises entity, SessionBean sessionBean) {
		page.setPagePara(rows);
		sessionBean = getSessionBean(sessionBean);

				
		return emEnterprisesService.queryList(entity, page,sessionBean);
	}
	
	@RequestMapping(value = "/sydwhs", method = RequestMethod.GET)
	public ModelAndView sydwhs(String id, String mainTabID,
			String invokeJSMethod, SessionBean sessionBean) {
		ModelAndView mv = new ModelAndView("shhxxcj/sydwhs");
		sessionBean = getSessionBean(sessionBean);
		if (sessionBean != null) {		
			mv.addObject("pcsdm", sessionBean.getExtendValue("ssPcsCode"));
			mv.addObject("zrqdm", sessionBean.getUserOrgCode());
			mv.addObject("pcsmc", sessionBean.getExtendValue("ssPcsName"));
			mv.addObject("fsxdm", sessionBean.getExtendValue("ssFsxCode"));
			mv.addObject("fsxmc", sessionBean.getExtendValue("ssFsxName"));
			mv.addObject("dsjdm", sessionBean.getExtendValue("ssDsjCode"));
			mv.addObject("dsjmc", sessionBean.getExtendValue("ssDsjName"));
			//设置是否属于责任区
			if("50".equals(sessionBean.getUserOrgLevel())){
				//属于责任区
				mv.addObject("sfsyzrq", "1");
			}else{
				//不属于责任区
				mv.addObject("sfsyzrq", "0");
			}

		}
		Dwjbxxb dwjbxxb=new Dwjbxxb();
		
		EmEnterprises enterprise=this.emEnterprisesService.queryById(id);
		dwjbxxb.setJyfwzy(enterprise.getJyfw());		
		dwjbxxb.setDwmc(enterprise.getDwmc());
		dwjbxxb.setYyzzh(enterprise.getYyzzbh());
		dwjbxxb.setSfblyyzzdm("1");
		dwjbxxb.setYyzzyxq_qsrq(enterprise.getYyzzqs());
		dwjbxxb.setYyzzyxq_jzrq(enterprise.getYyzzjz());
		dwjbxxb.setGlbmid(sessionBean.getUserOrgCode());
		//dwjbxxb.setZczb(enterprise.getZczj());
		dwjbxxb.setLxdh(enterprise.getLxdh());
	
		mv.addObject("mainTabID", mainTabID);
		mv.addObject("invokeJSMethod", invokeJSMethod);
		mv.addObject("enterpriseId", id);

		mv.addObject("nowtime", DateUtils.getShortString(new Date()));
		mv.addObject("zrqdm", sessionBean.getUserOrgCode());
		mv.addObject("dwjbxxb",dwjbxxb);
		mv.addObject("enterprises",enterprise);
		mv.addObject("zrqdm",sessionBean.getUserOrgCode());
		
		return mv;
	}
	
	/**
	 * @Title: saveSydwhs
	 * @Description: 保存实有单位核实
	 * @param @param swjbxxbSaveVO
	 * @param @param hsrwid
	 * @param @param sessionBean
	 * @param @return    设定文件
	 * @return ModelAndView    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/saveSydwhs", method = {RequestMethod.POST})
	public @ResponseBody ModelAndView saveSydwhs(DwjbxxbSaveVO swjbxxbSaveVO, String hsrwid ,SessionBean sessionBean) {

		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		Map<String, Object> model = new HashMap<String, Object>();
		Dwjbxxb dwjbxxb = swjbxxbSaveVO.getDwjbxxb();
		Dwbmxxb [] dwbmxxbArray = swjbxxbSaveVO.getDwbmxxbArray();
		sessionBean = getSessionBean(sessionBean);
		try {
			if((!StringUtils.isBlank(dwjbxxb.getDz_dwdzdm()) && !StringUtils.isBlank(dwjbxxb.getDz_dwdzmlpdm())  &&
					!StringUtils.isBlank(dwjbxxb.getDz_dwdzmlpxz())  && !StringUtils.isBlank(dwjbxxb.getDz_dwdzssxdm()) &&
					!StringUtils.isBlank(dwjbxxb.getDz_dwdzxz())) ||(!StringUtils.isBlank(dwjbxxb.getDzms_zbx()) &&
							!StringUtils.isBlank(dwjbxxb.getDzms_zby()) && !StringUtils.isBlank(dwjbxxb.getDzms_sspcsdm()) && 
							!StringUtils.isBlank(dwjbxxb.getDzms_sszrqdm()) && !StringUtils.isBlank(dwjbxxb.getDzms_dwdzmlpxz()))){
				//这里判断名称和地址同时重复
				Dwjbxxb  cfDwjbxx = dwjbxxbService.queryByDwmcDwdzdm(dwjbxxb.getDwmc(), dwjbxxb.getDz_dwdzdm());
				if(StringUtils.isBlank(cfDwjbxx)){
					
						if(StringUtils.isBlank(dwjbxxb.getGlfxjid())){
							dwjbxxb.setGlfxjid(sessionBean.getExtendValue("ssFsxCode"));
						}
						if(StringUtils.isBlank(dwjbxxb.getGlpcsid())){
							dwjbxxb.setGlpcsid(sessionBean.getExtendValue("ssPcsCode"));
						}
						if(StringUtils.isBlank(dwjbxxb.getGlbmid())){
							dwjbxxb.setGlbmid(sessionBean.getUserOrgCode());						
					    }
						
						emEnterprisesService.saveSydwhs(dwjbxxb, swjbxxbSaveVO.getEnterpriseId(), dwbmxxbArray, sessionBean);
					model.put(AppConst.STATUS, AppConst.SUCCESS);
					model.put(AppConst.MESSAGES, getAddSuccess());
					model.put(AppConst.SAVE_ID, "" + dwjbxxb.getId()); // 返回主键
				}else{
					model.put(AppConst.STATUS, AppConst.FAIL);
					model.put(AppConst.MESSAGES,"该地址已经有该单位名称，地址和名称不可同时重复");
				}
			}else{
				model.put(AppConst.STATUS, AppConst.FAIL);
				model.put(AppConst.MESSAGES,"地址描述和单位地址选择必须选择其填一个！！");
			}
			
		} catch (Exception e) {
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, getAddFail());
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	
	}
}