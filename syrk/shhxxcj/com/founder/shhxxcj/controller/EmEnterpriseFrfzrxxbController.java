package com.founder.shhxxcj.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.founder.bzdz.vo.DzXxbVO;
import com.founder.framework.annotation.RestfulAnnotation;
import com.founder.framework.base.controller.BaseController;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.shhxxcj.bean.CzrhsCzqkdjxxb;
import com.founder.shhxxcj.bean.EmEnterpriseFrfzrxxb;
import com.founder.shhxxcj.bean.EmEnterprises;
import com.founder.shhxxcj.bean.Houses;
import com.founder.shhxxcj.bean.LesseeZZs;
import com.founder.shhxxcj.service.EmEnterpriseFrfzrxxbService;
import com.founder.shhxxcj.service.EmEnterprisesService;
import com.founder.syfw.bean.Czfwxxb;
import com.founder.syfw.bean.FwCzqkdjxxb;
import com.founder.syrkgl.bean.RyRyjbxxb;
import com.founder.syrkgl.bean.SyrkSyrkxxzb;


/******************************************************************************
 * @Package:      [com.mos.shhxxcj.controller.HousesController.java]  
 * @ClassName:    [HousesController]   
 * @Description:  [一句话描述该类的功能]   
 * @Author:       [cong_rihong@founder.com.cn]  
 * @CreateDate:   [2015-9-15 下午3:12:41]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-9-15 下午3:12:41，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 */
@Controller
@RequestMapping(value = "/shhxxcj")
public class EmEnterpriseFrfzrxxbController extends BaseController {


	@Resource
	private EmEnterpriseFrfzrxxbService emEnterpriseFrfzrxxbService;

	@Resource
	private EmEnterprisesService emEnterprisesService;
	/**
	 * @Title: query
	 * @Description: TODO(法人负责人列表页面)
	 * @param @return 设定文件
	 * @return ModelAndView 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/frfzrList", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView query(String ementerpriseid,String houseDz) {
		ModelAndView mv = new ModelAndView("shhxxcj/frfzrList");
		
		mv.addObject("ementerpriseid",ementerpriseid);
		EmEnterprises enterprise=emEnterprisesService.queryById(ementerpriseid);
        mv.addObject("enterpriseName",enterprise.getDwmc());
		

		return mv;
	}


	/**
	 * 
	 * @Title: queryList
	 * @Description: 法人负责人列表
	 * @param @param page
	 * @param @param rows
	 * @param @param entity
	 * @param @param sessionBean
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/queryFrfzrList", method = RequestMethod.POST)
	public @ResponseBody
	EasyUIPage queryList(EasyUIPage page,
			@RequestParam(value = "rows", required = false) Integer rows,
			EmEnterpriseFrfzrxxb entity,SessionBean sessionBean) {
		page.setPagePara(rows);
		sessionBean = getSessionBean(sessionBean);
		
		return this.emEnterpriseFrfzrxxbService.queryList(entity, page,sessionBean);
	}
	


	
}