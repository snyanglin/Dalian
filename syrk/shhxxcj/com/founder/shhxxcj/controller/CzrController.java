package com.founder.shhxxcj.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.founder.bzdz.service.DzService;
import com.founder.bzdz.vo.DzXxbVO;
import com.founder.framework.annotation.RestfulAnnotation;
import com.founder.framework.base.controller.BaseController;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.message.dao.SysMessageDao;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.shhxxcj.bean.CzrhsCzqkdjxxb;
import com.founder.shhxxcj.bean.Houses;
import com.founder.shhxxcj.bean.LesseeZZs;
import com.founder.shhxxcj.service.CzrService;
import com.founder.shhxxcj.service.HousesService;
import com.founder.syfw.bean.Czfwxxb;
import com.founder.syfw.bean.FwCzqkdjxxb;
import com.founder.syfw.service.SyfwEditService;
import com.founder.syrkgl.bean.RyRyjbxxb;
import com.founder.syrkgl.bean.SyrkSyrkxxzb;
import com.founder.syrkgl.service.RyRyjbxxbService;
import com.founder.syrkgl.service.RyRylxfsxxbService;
import com.founder.syrkgl.service.SyrkSyrkxxzbService;


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
public class CzrController extends BaseController {


	@Resource
	private RyRyjbxxbService ryRyjbxxbService;
	
	@Resource
	private HousesService housesService;
	@Resource
	private SyfwEditService syfwEditService;
	
	@Resource
	private SyrkSyrkxxzbService syrkSyrkxxzbService;
	
	@Resource
	private CzrService czrService;
	@Resource(name = "dzService")
	private DzService dzService;

	/**
	 * @Title: query
	 * @Description: TODO(实有人口管理列表页面)
	 * @param @return 设定文件
	 * @return ModelAndView 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/czrList", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView query(String housesId,String houseDz) {
		ModelAndView mv = new ModelAndView("shhxxcj/czrList");
		Houses houses=this.housesService.queryById(housesId);
		if(StringUtils.isBlank(houses.getSyfwid())){
			mv.addObject("czfwhszt","0");

		}else{
			mv.addObject("czfwhszt","1");

		}
		mv.addObject("houseId",housesId);
		if(StringUtils.isBlank(houses.getBzdzid())){
			mv.addObject("houseDz",houses.getFwxz());
		}else{
			mv.addObject("houseDz",this.housesService.queryBzdzById(houses.getId()));
		}

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
	@RequestMapping(value = "/queryCzrList", method = RequestMethod.POST)
	public @ResponseBody
	EasyUIPage queryList(EasyUIPage page,
			@RequestParam(value = "rows", required = false) Integer rows,
			LesseeZZs entity,SessionBean sessionBean) {
		page.setPagePara(rows);
		sessionBean = getSessionBean(sessionBean);
		
		return czrService.queryList(entity, page,sessionBean);
	}
	
	@RequestMapping(value = "/syrkAdd", method = RequestMethod.GET)
	public ModelAndView add(String cyzjdm, String zjhm, String mainTabID,
			String invokeJSMethod, SessionBean sessionBean) {

		ModelAndView mv = new ModelAndView("syrkgl/syrkGlAdd");
		sessionBean = getSessionBean(sessionBean);
		RyRyjbxxb ryRyjbxxb = null;
		if (!StringUtils.isBlank(zjhm)) {
			if (StringUtils.isBlank(cyzjdm)) { // 有身份证号码传入，证件种类为空时默认为居民身份证
				cyzjdm = "111";
			}
			ryRyjbxxb = ryRyjbxxbService.dataApply(cyzjdm, zjhm, sessionBean);
			if (ryRyjbxxb == null) { // 复用无数据
				ryRyjbxxb = new RyRyjbxxb();
				ryRyjbxxb.setCyzjdm(cyzjdm);
				ryRyjbxxb.setZjhm(zjhm);
			}
		}
		mv.addObject("ryRyjbxxb", ryRyjbxxb);
		if (sessionBean != null) { // 取责任区空挂地址
			mv.addObject("pcsdm", sessionBean.getExtendValue("ssPcsCode"));
			mv.addObject("zrqdm", sessionBean.getUserOrgCode());
			String zrqdm = sessionBean.getUserOrgCode();
			DzXxbVO kgJt = dzService.queryHjdKgJt(zrqdm); // 空挂集体
			mv.addObject("kgJt", kgJt);
			DzXxbVO kgJm = dzService.queryHjdKgJm(zrqdm); // 空挂居民
			mv.addObject("kgJm", kgJm);
		}
		mv.addObject("mainTabID", mainTabID);
		mv.addObject("invokeJSMethod", invokeJSMethod);
		return mv;
	}
	
	@RequestMapping(value = "/addCzqk", method = RequestMethod.GET)
	public @ResponseBody
	ModelAndView addCzqk(String czrId,String houseid,String syrkid,String mainTabID,String invokeJSMethod,SessionBean sessionBean) {
		sessionBean=getSessionBean();
		ModelAndView mv = new ModelAndView("shhxxcj/czrhs");
		Houses houses =this.housesService.queryById(houseid);
		SyrkSyrkxxzb syrkzb=syrkSyrkxxzbService.queryById(syrkid);
		RyRyjbxxb ryjbxxb=this.ryRyjbxxbService.dataApply("111", syrkzb.getZjhm(), sessionBean);
		FwCzqkdjxxb entity = new FwCzqkdjxxb();
        
		
		Czfwxxb czfw = new Czfwxxb();
		czfw.setFwid(houses.getSyfwid());
		czfw = syfwEditService.czfw_query(czfw);
		entity.setCzfwid(czfw.getId());
		entity.setChzr_csrq(ryjbxxb.getCsrq());
		entity.setChzr_cyzjdm("111");
		entity.setChzr_lxdh(ryjbxxb.getLxdh());
		entity.setChzr_mzdm(ryjbxxb.getMzdm());
        entity.setChzr_ryid(ryjbxxb.getId());
        entity.setChzr_xb(ryjbxxb.getXbdm());
        entity.setChzr_xm(ryjbxxb.getXm());
        entity.setChzr_zjhm(ryjbxxb.getZjhm());
        mv.addObject("czrId",czrId);
		mv.addObject("entity", entity);
		 mv.addObject("mainTabID",mainTabID);
		 mv.addObject("invokeJSMethod",invokeJSMethod);
		return mv;
	}



	/**
	 * 保存承租情况登记信息
	 * @param entity
	 * @return
	 */
	@RequestMapping(value = "/saveCzrhs", method = RequestMethod.POST)
	public @ResponseBody
	void saveCzqkxxb(CzrhsCzqkdjxxb entity) {
		SessionBean sessionBean = getSessionBean();
		try {
			this.czrService.saveCzrhs(entity,sessionBean);
			
		} catch (Exception e) {
		e.printStackTrace();
		}
		

		
	
	}


	
}