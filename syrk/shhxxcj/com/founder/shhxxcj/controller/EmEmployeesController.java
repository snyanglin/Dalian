package com.founder.shhxxcj.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import com.founder.bzdz.service.DzService;
import com.founder.bzdz.vo.DzXxbVO;
import com.founder.framework.annotation.RestfulAnnotation;
import com.founder.framework.base.controller.BaseController;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.components.AppConst;
import com.founder.framework.message.dao.SysMessageDao;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.shhxxcj.bean.CzrhsCzqkdjxxb;
import com.founder.shhxxcj.bean.EmEmployees;
import com.founder.shhxxcj.bean.EmEnterprises;
import com.founder.shhxxcj.bean.Enterprises;
import com.founder.shhxxcj.bean.Houses;
import com.founder.shhxxcj.bean.LesseeZZs;
import com.founder.shhxxcj.service.CzrService;
import com.founder.shhxxcj.service.EmEmployeesService;
import com.founder.shhxxcj.service.EmEnterprisesService;
import com.founder.shhxxcj.service.HousesService;
import com.founder.sydw_dl.bean.Cyryxxb;
import com.founder.sydw_dl.service.CyryxxbService;
import com.founder.sydw_dl.vo.DwjbxxbSaveVO;
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
public class EmEmployeesController extends BaseController {


	@Resource
	private EmEnterprisesService emEnterprisesService;
	@Resource
	private EmEmployeesService emEmployeesService;
	@Resource
	private RyRyjbxxbService ryRyjbxxbService;

	@Resource(name = "cyryxxbService")
	private CyryxxbService cyryxxbService;
	/**
	 * @Title: query
	 * @Description: TODO(实有人口管理列表页面)
	 * @param @return 设定文件
	 * @return ModelAndView 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/cyryList", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView query(String emEnterpriseId) {
		ModelAndView mv = new ModelAndView("shhxxcj/cyryList");
		EmEnterprises ementerprise=this.emEnterprisesService.queryById(emEnterpriseId);
		if(!StringUtils.isBlank(ementerprise.getHszt())){
			mv.addObject("emEnterpriseHszt",ementerprise.getHszt().toString());

		}else{
			mv.addObject("emEnterpriseHszt","0");
		}
		mv.addObject("emEnterpriseId",emEnterpriseId);
		
		mv.addObject("emDwmc",ementerprise.getDwmc());

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
	@RequestMapping(value = "/queryCyryList", method = RequestMethod.POST)
	public @ResponseBody
	EasyUIPage queryList(EasyUIPage page,
			@RequestParam(value = "rows", required = false) Integer rows,
			EmEmployees entity,SessionBean sessionBean) {
		page.setPagePara(rows);
		sessionBean = getSessionBean(sessionBean);
		
		return this.emEmployeesService.queryList(entity, page,sessionBean);
	}
	

	
	@RequestMapping(value = "/cyryhs", method = RequestMethod.GET)
	public @ResponseBody
	ModelAndView cyryhs(String emEmployeeId,String mainTabID,String invokeJSMethod,SessionBean sessionBean) {
		sessionBean=getSessionBean();
		ModelAndView mv = new ModelAndView("shhxxcj/cyryhs");
		EmEmployees emEmployees =this.emEmployeesService.queryById(emEmployeeId);
		Cyryxxb entity = new Cyryxxb();
        
	    entity.setCsrq(emEmployees.getCsrq());
	    if("居民身份证".equals(emEmployees.getZjlb())){
	    	entity.setCyzjdm("111");
	    	RyRyjbxxb ryjbxxb=ryRyjbxxbService.dataApply("111", emEmployees.getZjhm(), sessionBean);
	    	entity.setXbdm(ryjbxxb.getXbdm());
            entity.setXm(ryjbxxb.getXm());
            entity.setCsrq(ryjbxxb.getCsrq());
            entity.setGjdm(ryjbxxb.getGjdm());
            entity.setRyid(ryjbxxb.getId());
	    }
	    entity.setZjhm(emEmployees.getZjhm());
	    
	    EmEnterprises enterprise=this.emEnterprisesService.queryById(emEmployees.getEnterpriseid());
	    if(enterprise!=null){
		    entity.setDwid(enterprise.getSydwid());

	    }
	    entity.setLxdh(emEmployees.getLxdh());
	    entity.setXm(emEmployees.getXm());
	    mv.addObject("pcsdm", sessionBean.getExtendValue("ssPcsCode"));
		mv.addObject("zrqdm", sessionBean.getUserOrgCode());
        mv.addObject("emEmployeeId",emEmployeeId);
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
	@RequestMapping(value = "/saveCyryhs", method = RequestMethod.POST)
	public @ResponseBody
	ModelAndView saveCyryhs(Cyryxxb entity,String emEmployeeId ) {
		SessionBean sessionBean = getSessionBean();

		ModelAndView mv = new ModelAndView("redirect:/forward/"
				+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			Cyryxxb cyryxxb=cyryxxbService.queryByZjlx(entity);
				if (entity.getId() == null || entity.getId().equals("")&&cyryxxb==null) {
					this.emEmployeesService.saveCyryhs(entity,emEmployeeId, sessionBean);
					model.put(AppConst.STATUS, AppConst.SUCCESS);
					model.put(AppConst.MESSAGES, "核实【从业人员】成功！");
					model.put(AppConst.SAVE_ID, entity.getId()); // 返回主键
				}else if (entity.getId() == null || entity.getId().equals("")&&cyryxxb!=null) {
					model.put(AppConst.STATUS, AppConst.FAIL);
					model.put(AppConst.MESSAGES, "身份证对应人员已是该单位的从业人员");
				}
		} catch (Exception e) {
			e.printStackTrace();
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, getAddFail());
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}


	
}