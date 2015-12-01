package com.founder.syfw.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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
import com.founder.framework.exception.RestException;
import com.founder.framework.utils.DateUtils;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.service.attachment.bean.ZpfjFjxxb;
import com.founder.syfw.bean.Czfwjcxxb;
import com.founder.syfw.bean.Czfwxxb;
import com.founder.syfw.bean.FwCzqkdjxxb;
import com.founder.syfw.bean.Fwjbxxb;
import com.founder.syfw.service.CzfwzbService;
import com.founder.syfw.service.SyfwEditService;
import com.founder.syfw.service.SyfwQueryService;
import com.founder.syfw.vo.FwEditVO;
import com.founder.syfw.vo.SyfwListVo;
import com.founder.syfw.vo.SyfwgnVO;
import com.founder.syfw.vo.SyfwxxzsVO;

import com.google.gson.Gson;
import org.apache.commons.beanutils.MethodUtils;

/**
 * ****************************************************************************
 * @Package:      [com.founder.syfw.controller.SyfwEditController.java]  
 * @ClassName:    [SyfwEditController]   
 * @Description:  [实有房屋查看编辑控制器]   
 * @Author:       [weiwen]   
 * @CreateDate:   [2015-1-15 下午7:15:53]   
 * @UpdateUser:   [weiwen(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-1-15 下午7:15:53，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Controller
@RequestMapping("/syfw")
public class SyfwEditController extends BaseController {

	private Logger logger = Logger.getLogger(this.getClass());

	@Resource(name="syfwEditService")
	private SyfwEditService syfwEditService;

	@Resource(name = "syfwQueryService")
	private SyfwQueryService syfwQueryService;
	@Resource
	private CzfwzbService czfwzbService;

	/**
	 * v3
	 * @Title: view
	 * @Description: TODO(根据房屋ID查看房屋信息)
	 * @param @param id
	 * @param @param mode
	 * @param @return
	 * @param @throws BussinessException    设定文件
	 * @return ModelAndView    返回类型
	 * @throws
	 */
	@RequestMapping(value="/{id}/main", method = {RequestMethod.GET})
	public ModelAndView view(@PathVariable(value = "id") String id,@RequestParam(value = "mode",required=false,defaultValue="") String mode)	throws BussinessException {
		ModelAndView mv = new ModelAndView("syfw/syfwEdit");
		Fwjbxxb entity = syfwEditService.queryFwjbxxbById(id);
		if (entity == null) {
			throw new BussinessException("没有查到此房屋！");
		}
		mv.addObject("fw", entity);
		mv.addObject("mode", mode);
		return mv;
	}

	/**
	 * v3
	 * @Title: getFw
	 * @Description: TODO(根据ID获取房屋基本信息)
	 * @param @param id
	 * @param @return    设定文件
	 * @return Fwjbxxb    返回类型
	 * @throws
	 */
	@RestfulAnnotation(serverId = "3")
	@RequestMapping(value="/{id}", method = {RequestMethod.GET})
	public @ResponseBody Fwjbxxb getFw(@PathVariable(value = "id")final String id){
		return syfwEditService.queryFwjbxxbById(id);
	}


	/**
	 * v3
	 * @throws RestException 
	 * 
	 * @Title: getCzfw
	 * @Description: TODO(得到出租房屋)
	 * @param @param id
	 * @param @return    设定文件
	 * @return Fwjbxxb    返回类型
	 * @throws
	 */
	@RestfulAnnotation(serverId = "3")
	@RequestMapping(value="/czfw/{id}", method = {RequestMethod.GET})
	public @ResponseBody Czfwxxb getCzfw(@PathVariable(value = "id")final String id) throws RestException{
		Czfwxxb entity = new Czfwxxb();
		entity.setFwid(id);
		entity = syfwEditService.czfw_query(entity);
		if(entity ==null){
			throw new RestException("查无信息！");
		}
		return entity;
	}

	/**
	 * v3
	 * @Title: queryFw
	 * @Description: TODO(房屋管理列表查询)
	 * @param @param page
	 * @param @param rows
	 * @param @param entity
	 * @param @param flag   是否派出所限制
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	@RestfulAnnotation(serverId = "3")
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public @ResponseBody
	EasyUIPage queryFw(EasyUIPage page,
			@RequestParam(value = "rows",required=false) Integer rows, SyfwListVo entity, @RequestParam(value="flag", required=false ) String flag,SessionBean sessionBean) {
		page.setPagePara(rows);
		sessionBean = getSessionBean(sessionBean);
		//增加查询条件 begin
		if(StringUtils.isBlank(flag) && null != sessionBean){
			entity.setSs4jbmdm(sessionBean.getUserOrgCode());
		} 
		//增加查询条件 end
		return syfwQueryService.queryFw(page, entity);
	}

	/**
	 * v3
	 * @Title: createSyfw
	 * @Description: TODO(打开新增实有房屋页面)
	 * @param @param type
	 * @param @return    设定文件
	 * @return ModelAndView    返回类型
	 * @throws
	 */
	@RequestMapping(value = "create", method = RequestMethod.GET)
	public ModelAndView createSyfw(String type){
		ModelAndView mv = new ModelAndView("syfw/syfwAdd");
		SessionBean sessionBean = getSessionBean();
		String zrqdm = sessionBean.getUserOrgCode();
		/*      注释 - 取消type属性======================20150115
		entity.setType(type != null ? type : "0");//0 xinzeng / 1 caiji*/
		mv.addObject("nowtime", DateUtils.getShortString(new Date()));
		mv.addObject("type", type != null ? type : "0");
		mv.addObject("zrqdm", zrqdm);
		return mv;
	}


	/**
	 * v3
	 * @Title: saveFwjbxxb
	 * @Description: TODO(新增实有房屋)
	 * @param @param vo
	 * @param @return    设定文件
	 * @return ModelAndView    返回类型
	 * @throws
	 */
	@RestfulAnnotation(valiField="fwjbxxb.fz_cyzjdm,fwjbxxb.fz_zjhm,fwjbxxb.fz_xm,fwjbxxb.fz_lxdh,fwjbxxb.sfczfw",serverId = "3")
	@RequestMapping(value = "", method = {RequestMethod.POST})
	public @ResponseBody ModelAndView saveFwjbxxb(FwEditVO vo ,SessionBean sessionBean) {
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		Map<String, Object> model = new HashMap<String, Object>();

		sessionBean = getSessionBean(sessionBean);
		Fwjbxxb entity = vo.getFwjbxxb();
		entity.setSs2jbmdm(sessionBean.getExtendValue("ssFsxCode"));
		entity.setSs3jbmdm(sessionBean.getExtendValue("ssPcsCode"));
		entity.setSs4jbmdm(sessionBean.getUserOrgCode());
		try {
			//			if (entity.getId() == null || entity.getId().equals("")) {
			syfwEditService.insertFwjbxxb(entity, sessionBean);
			if("1".equals(entity.getSfczfw())){
				if(!StringUtils.isBlank(vo.getCzfwxxb().getZazrr_id()) &&!StringUtils.isBlank(vo.getCzfwxxb().getZazrr_xm())
						&&!StringUtils.isBlank(vo.getCzfwxxb().getZrs_qd_rq())){
					vo.getCzfwxxb().setFwid(entity.getId());
					syfwEditService.insertCzfwxxb(vo.getCzfwxxb(), sessionBean);
				}else{
					model.put(AppConst.STATUS, AppConst.FAIL);
					model.put(AppConst.MESSAGES, "治安责任人ID、姓名和责任书签订日期不能为空！");
				}

			}
			model.put(AppConst.STATUS, AppConst.SUCCESS);
			model.put(AppConst.MESSAGES, "新增【实有房屋信息】成功！");
			model.put(AppConst.SAVE_ID, entity.getId()); // 返回主键
			//			} else {
			//				syfwEditService.updateFwjbxxb(entity, sessionBean);
			//				if("1".equals(entity.getSfczfw()))
			//					syfwEditService.updateCzfwxxb(vo.getCzfwxxb(), sessionBean);
			//				model.put(AppConst.STATUS, AppConst.SUCCESS);
			//				model.put(AppConst.MESSAGES, "修改【实有房屋信息】成功！");
			//			}
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage(), e);
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, getAddFail());
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}

	/**
	 * v3
	 * @Title: updateFwjbxxb
	 * @Description: TODO(修改实有房屋信息)
	 * @param @param entity
	 * @param @param sessionBean
	 * @param @return    设定文件
	 * @return ModelAndView    返回类型
	 * @throws
	 */
	@RestfulAnnotation(serverId = "3")
	@RequestMapping(value="/{id}",method={RequestMethod.PUT,RequestMethod.POST})
	public @ResponseBody ModelAndView updateFwjbxxb(FwEditVO vo ,SessionBean sessionBean) {
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		Map<String, Object> model = new HashMap<String, Object>();
		sessionBean = getSessionBean(sessionBean);
		Fwjbxxb entity = vo.getFwjbxxb();
		try {
			syfwEditService.updateFwjbxxb(entity, sessionBean);
			/*if("1".equals(entity.getSfczfw()))
				syfwEditService.updateCzfwxxb(vo.getCzfwxxb(), sessionBean);*/
			model.put(AppConst.STATUS, AppConst.SUCCESS);
			model.put(AppConst.MESSAGES, "修改【实有房屋信息】成功！");
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage(), e);
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES,getUpdateFail());
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}

	/**
	 * v3
	 * @Title: DeleteSyfwListVo
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return ModelAndView    返回类型
	 * @throws
	 */
	@RestfulAnnotation(serverId = "3")
	@RequestMapping(value = "/{id}/delete", method = {RequestMethod.DELETE,RequestMethod.POST})
	public ModelAndView DeleteSyfwListVo(SyfwListVo entity ,SessionBean sessionBean) {
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		Map<String, Object> model = new HashMap<String, Object>();
		sessionBean = getSessionBean(sessionBean);
		try {
			if (entity.getId() != null) { // 注销
				syfwQueryService.delete(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, getMessage("cancel.success"));
			}
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage(), e);
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, getMessage("cancel.fail"));
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}

	/**
	 * v3s
	 * 房屋查看编辑页面 展示配置信息查询
	 * @param fwlxdm
	 * @return
	 */
	@RequestMapping(value="queryFwzsxx",method = RequestMethod.POST)
	public @ResponseBody List<SyfwxxzsVO> queryFwzsxx(@RequestParam(value = "fwlxdm") String fwlxdm){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("fwlxdm", fwlxdm);
		return syfwEditService.queryFwzsxx(map);
	}

	/**
	 * v3
	 * @Title: handleRequest
	 * @Description: TODO(信息主页面通用查询方法)
	 * @param @param methodName 对应service层的方法名称
	 * @param @return
	 * @param @throws Exception    设定文件
	 * @return Map<String,Object>    返回类型
	 * @throws
	 */
	@RequestMapping(method = { RequestMethod.GET, RequestMethod.POST }, value = "/service/{method}")
	public @ResponseBody Map<String, Object> handleRequest(
			@PathVariable(value = "method") String methodName) throws Exception {
		Map<String, Object> params = getParams(super.getRequest());
		params.put("sessionBean", getSessionBean());
		Map<String, Object> model = new HashMap<String, Object>();
		if (methodName != null) {
			methodName += "_query";
			try {
				model.put("entity", MethodUtils.invokeMethod(syfwEditService,methodName, params));
			} catch (NoSuchMethodException e) {
			} catch (InvocationTargetException inv) {
				throw new Exception(inv.getTargetException().getCause()
						.getLocalizedMessage(), inv.getTargetException()
						.getCause());
			}
		}
		return model;
	}


	/**
	 * v3
	 * 业务办理与可增加信息查询
	 * @param fwlxdm
	 * @param gnlxdm 1 ，2
	 * @return
	 */
	@RequestMapping(value = "/queryYwglgn", method = RequestMethod.POST)
	public @ResponseBody List<SyfwgnVO> queryYwglgn(@RequestParam(value = "fwlxdm") String fwlxdm,String gnlxdm) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("fwlxdm", fwlxdm);
		map.put("gnlxdm", gnlxdm);
		return syfwEditService.queryYwglgn(map);
	}

	/**
	 * v3
	 * 跳转-实有房屋子项信息注销页面
	 * @param url
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/delete_xxzsnrb", method = RequestMethod.GET)
	public ModelAndView delete_xxzsnrb(String url, String id){
		ModelAndView mv = new ModelAndView("syfw/syfwmessagEdit");
		mv.addObject("url", url);
		mv.addObject("id", id);
		return mv;
	}
	/**
	 * v3
	 * 注销实有房屋子项信息
	 * @param url
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/calcle_xxzsnrb", method = RequestMethod.POST)
	public ModelAndView calcle_xxzsnrb(String url, String id,String xt_zxyy){
		ModelAndView mv = new ModelAndView("redirect:/forward/"	+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		Map<String , Object> map=new HashMap<String , Object>();
		if (sessionBean != null) {
			map.put("xt_zhxgrxm", sessionBean.getUserName());
			map.put("xt_zhxgrid", sessionBean.getUserId());
			map.put("xt_zhxgrbm", sessionBean.getUserOrgName());
			map.put("xt_zhxgrbmid", sessionBean.getUserOrgCode());
			map.put("xt_zhxgip", sessionBean.getRemoteAddr());
		}
		map.put("xt_zhxgsj", DateUtils.getSystemDateTimeString());
		map.put("url", url);
		map.put("id", id);
		map.put("xt_zxyy",xt_zxyy);
		try{
			syfwEditService.delete_xxzsnrb(map);
			model.put(AppConst.STATUS, AppConst.SUCCESS);
			model.put(AppConst.MESSAGES, getMessage("cancel.success"));
		}catch (Exception e) {
			logger.error(e.getMessage(), e);
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, getMessage("cancel.fail"));
		}

		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}

	/**
	 * v3
	 * @Title: createSyfwEdit
	 * @Description: TODO(房屋编辑)
	 * @param @param id
	 * @param @return    设定文件
	 * @return ModelAndView    返回类型
	 * @throws
	 */
	@RequestMapping(value = "{id}/edit", method = RequestMethod.GET)
	public ModelAndView createSyfwEdit(@PathVariable(value = "id") String  id){
		ModelAndView mv = new ModelAndView("syfw/syfwEditer");
		Fwjbxxb entity = syfwEditService.queryFwjbxxbById(id);
		mv.addObject("entity", entity);
		return mv;
	}


	/**
	 * v3
	 * @Title: checkDz
	 * @Description: TODO(检查地址下是否有房屋)
	 * @param @param dzdm
	 * @param @return    设定文件
	 * @return boolean    返回类型
	 * @throws
	 */
	@RequestMapping(value="/checkdz/{dzdm}",method = RequestMethod.GET)
	public @ResponseBody boolean checkDz(@PathVariable(value = "dzdm") String dzdm){
		return syfwEditService.checkDz(dzdm);
	}

	/**
	 * v3
	 * @Title: query
	 * @Description: TODO(房屋附件查询)
	 * @param @param fwid
	 * @param @return    设定文件
	 * @return List<ZpfjFjxxb>    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/fj/{fwid}/list", method = RequestMethod.GET)
	public @ResponseBody List<ZpfjFjxxb> query(@PathVariable(value="fwid")String fwid){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("fwid", fwid);
		return syfwEditService.fjxx_query(map);
	}


	/**
	 * v3
	 * @Title: fjxx
	 * @Description: TODO(打开房屋附件管理页面)
	 * @param @param fwid
	 * @param @return    设定文件
	 * @return ModelAndView    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/fjxx", method = RequestMethod.GET)
	public ModelAndView fjxx(@RequestParam(value="fwid")String fwid){
		ModelAndView mv = new ModelAndView("syfw/syfwfjEdit");
		mv.addObject("lybm", "SYFW_FWJBXXB");
		mv.addObject("lyid", fwid);
		mv.addObject("lyms", "实有房屋-附件");
		mv.addObject("fileType", "");
		mv.addObject("fileOnly", 0);
		return mv;
	}




	/**
	 * 跳转新增- 出租房屋检查信息表
	 * @param id主键
	 * @param czfwid出租房屋ID
	 * @return
	 */
	@RequestMapping(value = "/addCzfwjc", method = RequestMethod.GET)
	public ModelAndView addCzfwjcxxb(String id,String fwid) {
		ModelAndView mv = new ModelAndView("syfw/czfwjcxxAdd");
		SessionBean sessionBean = getSessionBean();
		Czfwjcxxb entity = new Czfwjcxxb();

		Czfwxxb czfw = new Czfwxxb();
		czfw.setFwid(fwid);
		czfw = syfwEditService.czfw_query(czfw);

		entity.setCzfwid(czfw.getId());
		entity.setId(id);
		entity = syfwEditService.queryCzfwjcxxb(entity);
		if(entity == null){
			entity = new Czfwjcxxb();
			entity.setJcdw_gajgjgdm(sessionBean.getUserOrgCode());
			entity.setJcdw_gajgmc(sessionBean.getUserOrgName());
			entity.setJcr_id(sessionBean.getUserId());
			entity.setJcr_xm(sessionBean.getUserName());
			entity.setCzfwid(czfw.getId());
			entity.setJcrq(DateUtils.getSystemDateString());
		}
		mv.addObject("entity", entity);
		return mv;
	}

	/**
	 * 保存出租房检查信息
	 * @param entity
	 * @return
	 */
	@RequestMapping(value = "/saveCzfwjcxxb", method = RequestMethod.POST)
	public @ResponseBody
	ModelAndView saveCzfwjcxxb(Czfwjcxxb entity) {
		ModelAndView mv = new ModelAndView("redirect:/forward/"
				+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		try {
			Czfwjcxxb currEntity =syfwEditService.queryCzfwjcxxb(entity);
			if(currEntity == null){
				syfwEditService.saveCzfwjcxxb(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "新增【出租房屋检查信息】成功！");
				model.put(AppConst.SAVE_ID, entity.getId()); // 返回主键
			} else {
				syfwEditService.updateCzfwjcxxb(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "修改【出租房屋检查信息】成功！");
			}
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage(), e);
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, getAddFail());
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}





	/**
	 * 跳转新增- 出租房屋检查信息表
	 * @param id主键
	 * @param czfwid出租房屋ID
	 * @return
	 */
	@RequestMapping(value = "/addCzqk", method = RequestMethod.GET)
	public @ResponseBody
	ModelAndView addCzqk(String id,String fwid) {
		ModelAndView mv = new ModelAndView("syfw/CzqkAdd");
		FwCzqkdjxxb entity = new FwCzqkdjxxb();

		Czfwxxb czfw = new Czfwxxb();
		czfw.setFwid(fwid);
		czfw = syfwEditService.czfw_query(czfw);
		entity.setCzfwid(czfw.getId());
		entity.setId(id);
		entity = syfwEditService.queryCzqkdjxx(entity);
		if(entity == null){
			entity = new FwCzqkdjxxb();
			entity.setCzfwid(czfw.getId());
		}
		mv.addObject("entity", entity);
		return mv;
	}



	/**
	 * 保存承租情况登记信息
	 * @param entity
	 * @return
	 */
	@RequestMapping(value = "/saveCzqkxxb", method = RequestMethod.POST)
	public @ResponseBody
	ModelAndView saveCzqkxxb(FwCzqkdjxxb entity) {
		ModelAndView mv = new ModelAndView("redirect:/forward/"
				+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		try {
			Czfwxxb czfwxxb=this.czfwzbService.queryCzfwxxb(entity.getCzfwid());
			Fwjbxxb fwjbxxb=this.syfwEditService.queryFwjbxxbById(czfwxxb.getFwid());
			if(fwjbxxb.getFz_cyzjdm().equals(entity.getChzr_cyzjdm()) && fwjbxxb.getFz_zjhm().equals(entity.getChzr_zjhm())){
				model.put(AppConst.STATUS, AppConst.FAIL);
				model.put(AppConst.MESSAGES, "房主和承租人不能是同一个人");
			}else{
				FwCzqkdjxxb currEntity =syfwEditService.queryCzqkdjxx(entity);
				
				if(currEntity == null){
					syfwEditService.saveCzqkdjxx(entity, sessionBean);
					model.put(AppConst.STATUS, AppConst.SUCCESS);
					model.put(AppConst.MESSAGES, "新增【承租情况登记信息】成功！");
					model.put(AppConst.SAVE_ID, entity.getId()); // 返回主键
				} else {
					syfwEditService.updateCzqkdjxx(entity, sessionBean);
					model.put(AppConst.STATUS, AppConst.SUCCESS);
					model.put(AppConst.MESSAGES, "修改【承租情况登记信息】成功！");
				}
			}
			
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage(), e);
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, getAddFail());
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}



	/**
	 * 承租情况信息复用判断
	 * 
	 * @param cyzjdm
	 * @param zjhm
	 * @return  0 该人员信息非本辖区实有人口, 1 该人员居住地址不是本房屋 2正常
	 * @throws BussinessException
	 */
	@RequestMapping(value = "/decideCzqkxx", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> getRyjbxxb(@RequestParam(value="fwdz_dzid")String fwdz_dzid,@RequestParam()String ryid) {
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		
		boolean bool=syfwEditService.checkFzIsChzr(ryid, fwdz_dzid);
		model.put("fzIsChzr", bool);
		
		int returnValue = syfwEditService.getCountRkjzdzzb(ryid, sessionBean.getUserOrgCode().toString());
		if(returnValue != 0)
			returnValue = syfwEditService.checkCzrjzdz(fwdz_dzid,ryid,sessionBean.getUserOrgCode())?2:1;
		
		
		model.put("returnValue",returnValue );
		return model;
	}

	/**
	 * v3
	 * @Title: syfwList
	 * @Description: TODO(房屋管理页面跳转)
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/manager", method = RequestMethod.GET)
	public String syfwList(){
		return "syfw/syfwManager";
	}

	/**
	 * v3
	 * @Title: queryList
	 * @Description: TODO(房屋查询页面跳转)
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/query", method = RequestMethod.GET)
	public String queryList(){
		return "syfw/syfwQuery";
	}
	
	/**
	 * v3
	 * @Title: querySyfw
	 * @Description: TODO(房屋查询列表)
	 * @param @param page
	 * @param @param rows
	 * @param @param entity
	 * @param @param sessionBean
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/querySyfw", method = RequestMethod.POST)
	public @ResponseBody EasyUIPage querySyfw(EasyUIPage page,
			@RequestParam(value = "rows",required=false) Integer rows, SyfwListVo entity, SessionBean sessionBean) {
		page.setPagePara(rows);
		return syfwQueryService.querySyfw(entity ,page);
	}
	
	@RequestMapping(value = "/querySyfwCount", method = RequestMethod.POST)
	public @ResponseBody long querySyfwCount(SyfwListVo entity, SessionBean sessionBean) {
		return syfwQueryService.querySyfwCount(entity);
	}
	
}
