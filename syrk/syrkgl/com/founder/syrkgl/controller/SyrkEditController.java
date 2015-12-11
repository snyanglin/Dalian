package com.founder.syrkgl.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.beanutils.MethodUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.founder.framework.base.controller.BaseController;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.components.AppConst;
import com.founder.framework.exception.BussinessException;
import com.founder.framework.message.bean.SysMessage;
import com.founder.framework.message.dao.SysMessageDao;
import com.founder.framework.utils.DateUtils;
import com.founder.service.attachment.bean.ZpfjFjxxb;
import com.founder.syrkgl.bean.RyRyjbxxb;
import com.founder.syrkgl.bean.SyrkSyrkxxzb;
import com.founder.syrkgl.service.RyRyjbxxbService;
import com.founder.syrkgl.service.RyRylxfsxxbService;
import com.founder.syrkgl.service.SyrkEditService;
import com.founder.syrkgl.service.SyrkSyrkxxzbService;
import com.founder.syrkgl.vo.SyrkgnVo;
import com.founder.syrkgl.vo.SyrkxxzsVo;
import com.founder.zdrygl.base.service.ZdryInfoQueryService;
import com.founder.zdrygl.base.model.ZdryZb;
import com.google.gson.Gson;

/***
 * ****************************************************************************
 * 
 * @Package: [com.founder.syrkgl.controller.SyrkEditController.java]
 * @ClassName: [SyrkEditController]
 * @Description: [人员主页编辑页面]
 * @Author: [wu_chunhui@founder.com.cn]
 * @CreateDate: [2015-4-3 上午10:10:57]
 * @UpdateUser: [Administrator(如多次修改保留历史记录，增加修改记录)]
 * @UpdateDate: [2015-4-3 上午10:10:57，(如多次修改保留历史记录，增加修改记录)]
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]
 * @Version: [v1.0]
 */
@Controller
@RequestMapping("syrkEdit")
public class SyrkEditController extends BaseController {

	@Resource(name = "syrkEditService")
	private SyrkEditService syrkEditService;
	@Resource(name = "syrkSyrkxxzbService")
	private SyrkSyrkxxzbService syrkSyrkxxzbService;
	
	@Resource(name = "zdryQueryService")
	private ZdryInfoQueryService zdryQueryService;
	
	@Resource(name = "ryRyjbxxbService")
	private RyRyjbxxbService ryRyjbxxbService;
	@Resource(name = "ryRylxfsxxbService")
	private RyRylxfsxxbService ryRylxfsxxbService;
	@Resource(name = "sysMessageDao")
	private SysMessageDao sysMessageDao;
	
	
	/**
	 * 
	 * @Title: view
	 * @Description: TODO(打开实有人口编辑查看页面)
	 * @param @param ryid
	 * @param @param syrkid
	 * @param @param mode
	 * @param @return
	 * @param @throws BussinessException 设定文件
	 * @return ModelAndView 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/{ryid}/{syrkid}/view", method = RequestMethod.GET)
	public ModelAndView view(@PathVariable(value = "ryid") String ryid,
			@PathVariable(value = "syrkid") String syrkid,
			@RequestParam(value = "mode", defaultValue = "edit") String mode,String messageid)
			throws BussinessException {
		if(messageid != null && !"".equals(messageid)){
			SysMessage sysmessage = new SysMessage();
			sysmessage.setId(Long.valueOf(messageid));
			sysMessageDao.upadate(sysmessage);
		}
		ModelAndView mv = new ModelAndView("syrkgl/syrkEdit");
		List<SyrkSyrkxxzb> SyrkSyrkxxzbList = syrkSyrkxxzbService.queryListByRyid(ryid);
		
		RyRyjbxxb ryRyjbxxb = ryRyjbxxbService.queryById(ryid);
		/**
		 * 1. syrkid 判断是否当前人管理
		 */
		if (SyrkSyrkxxzbList.isEmpty()||ryRyjbxxb==null) {
			throw new BussinessException("SyrkSyrkxxzbList.notExist，该人不存在");
		}
		String lxdh =ryRylxfsxxbService.queryLastLxfs(ryid);
		
		List<?> zdryList = zdryQueryService.queryListBySyrkId(syrkid);		
		
		if(!zdryList.isEmpty()){
			ZdryZb temp; 
			for (int i = 0; i < zdryList.size(); i++) {
				temp = (ZdryZb)zdryList.get(i);
				if("1".equals(temp.getGlzt())){
					zdryList.remove(i);
					i--;
				}
			}
		}
		SyrkSyrkxxzb temp = null;
		String syrklx="";
		String gxzrq="";
		List<Map<String, String>> syrkList = new ArrayList<Map<String, String>>();
		Map<String, String> map = null;
		for (int i = 0; i < SyrkSyrkxxzbList.size(); i++) {
			map = new HashMap<String, String>();
			temp = SyrkSyrkxxzbList.get(i);
			map.put("syrkid", temp.getId());
			map.put("syrklx", temp.getSyrkywlxdm());
			map.put("gxzrq", temp.getGxzrqdm());
			if (syrkid.equals(temp.getId())) {
				map.put("isEdit", "1");
				syrklx=temp.getSyrkywlxdm();
				gxzrq=temp.getGxzrqdm();
				//SyrkSyrkxxzbList.remove(i);
			} else{
				map.put("isEdit", "0");
			}
			syrkList.add(map);
		}
		mv.addObject("gxzrq",gxzrq);
		mv.addObject("ry",ryRyjbxxb);
		mv.addObject("syrkid",syrkid);
		mv.addObject("mode", mode);
		mv.addObject("syrklx", syrklx);
		mv.addObject("lxdh", lxdh);
		mv.addObject("syrkJson", new Gson().toJson(syrkList));
		
		String zdry = "" ;
		for (int i = 0; i < zdryList.size(); i++) {
			zdry += ((ZdryZb)zdryList.get(i)).getZdrygllxdm()+",";
		}
		zdry = zdry.lastIndexOf(",") == zdry.length() ?zdry.substring(0, zdry.length()-1):zdry;
		mv.addObject("zdryList", zdryList);
		return mv;
	}
	
	/**
	 * 
	 * @Title: queryYwglgn
	 * @Description: TODO(查询业务关联功能)
	 * @param @param zdrylxJson
	 * @param @param gnlxdm
	 * @param @return    设定文件
	 * @return List<ZdrygnVO>    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/queryYwglgn", method = RequestMethod.POST)
	public @ResponseBody List<SyrkgnVo> queryYwglgn(String gnlxdm,String syrklx) {
		return syrkEditService.queryYwglgn(gnlxdm,syrklx);
	}

	
	/**
	 * 
	 * @Title: queryRyzsxx
	 * @Description: TODO(重点人口展示配置查询)
	 * @param @param zdrylxJson
	 * @param @return    设定文件
	 * @return List<ZdryxxzsVO>    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/queryRyzsxx", method = RequestMethod.POST)
	public @ResponseBody List<SyrkxxzsVo> queryRyzsxx(@RequestParam(value="syrkJson")String syrkJson) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("syrkJson", syrkJson);
		return syrkEditService.queryRyzsxx(map);
	}
	
	/**
	 * 
	 * @Title: handleRequest
	 * @Description: TODO(通用查询)
	 * @param @param methodName
	 * @param @return
	 * @param @throws Exception    设定文件
	 * @return Map<String,Object>    返回类型
	 * @throws
	 */
	@RequestMapping(method = { RequestMethod.GET, RequestMethod.POST }, value = "/service/{method}")
	public @ResponseBody
	Map<String, Object> handleRequest(
			@PathVariable(value = "method") String methodName) throws Exception {
		Map<String, Object> params = getParams(super.getRequest());
		params.put("sessionBean", getSessionBean());
		Map<String, Object> model = new HashMap<String, Object>();
		if (methodName != null) {
			methodName += "_query";
			try {
				model.put("entity", MethodUtils.invokeMethod(syrkEditService,
						methodName, params));
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
	 * 跳转-通用注销页面
	 * 
	 * @param url
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/delete_xxzsnrb", method = RequestMethod.GET)
	public ModelAndView delete_xxzsnrb(String url, String id) {
		ModelAndView mv = new ModelAndView("syrkgl/syrkmessagEdit");
		mv.addObject("url", url);
		mv.addObject("id", id);
		return mv;
	}

	/**
	 * 通用注销
	 * 
	 * @param url
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/calcle_xxzsnrb", method = RequestMethod.POST)
	public ModelAndView calcle_xxzsnrb(String url, String id, String xt_zxyy) {
		ModelAndView mv = new ModelAndView("redirect:/forward/"
				+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		Map<String, Object> map = new HashMap<String, Object>();
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
		map.put("xt_zxyy", xt_zxyy);
		syrkEditService.delete_xxzsnrb(map);
		model.put(AppConst.STATUS, AppConst.SUCCESS);
		model.put(AppConst.MESSAGES, "注销成功！");
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}

	
	
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView edit(String syrkid) {
		ModelAndView mv = new ModelAndView("syrkgl/syrkfjEdit");
		mv.addObject("lybm", "SYRK_SYRKXXZB");
		mv.addObject("lyid", syrkid);
		mv.addObject("lyms", "实有人口-附件");
		mv.addObject("fileType", "");
		mv.addObject("fileOnly", 0);
		return mv;
	}
	
	@RequestMapping(value = "/query", method = RequestMethod.POST)
	public @ResponseBody List<ZpfjFjxxb> query(String syrkid){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("lyid", syrkid);
		map.put("lybm", "SYRK_SYRKXXZB");
		List<ZpfjFjxxb> fjxx = syrkEditService.fjxx_query(map);
		return fjxx;
	}

}
