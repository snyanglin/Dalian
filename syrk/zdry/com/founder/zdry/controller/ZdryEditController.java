package com.founder.zdry.controller;

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
import com.founder.framework.utils.DateUtils;
import com.founder.service.attachment.bean.ZpfjFjxxb;
import com.founder.zdry.bean.ZdryZdryzb;
import com.founder.zdry.service.ZdryEditService;
import com.founder.zdry.vo.ZdrygnVO;
import com.founder.zdry.vo.ZdryxxzsVO;

import com.google.gson.Gson;
/**
 * ****************************************************************************
 * @Package:      [com.founder.zdry.controller.ZdryEditController.java]  
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
@RequestMapping("zdry")
public class ZdryEditController extends BaseController {
	
	@Resource(name="zdryEditService")
	private ZdryEditService zdryEditService;

	
	/**
	 * 
	 * @Title: view
	 * @Description: TODO(打开重点人员编辑查看页面)
	 * @param @param ryid
	 * @param @param syrkid
	 * @param @param mode
	 * @param @return
	 * @param @throws BussinessException    设定文件
	 * @return ModelAndView    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/{ryid}/{syrkid}/view" ,method = RequestMethod.GET)
	public ModelAndView view(@PathVariable(value="ryid")String ryid,@PathVariable(value="syrkid")String syrkid,
			@RequestParam(value="mode",defaultValue="edit")String mode,String mainTabID) throws BussinessException{
		ModelAndView mv = new ModelAndView("rkEdit/zdryEdit");
		
		List<ZdryZdryzb> zdry = zdryEditService.queryZdryByRyid(ryid);
		/** 1. syrkid 判断是否当前人管理
		 *  2. glzt 只查2，3
		*/
		if(zdry.isEmpty())
			throw new BussinessException("syrk.notExist");
		
		ZdryZdryzb temp = null;
		List<Map<String,String>> zdrylxList = new ArrayList<Map<String,String>>();
		Map<String,String> map = null;
		List<String> zdrylx = new ArrayList<String>();//本人管理类型
		int sort = 0 ;
		for (int i = 0; i < zdry.size(); i++) {
			map  = new HashMap<String,String>();
			temp = zdry.get(i);
			map.put("zdryid", temp.getId());
			map.put("zdrylx", temp.getZdrygllxdm());
			map.put("gxzrq", temp.getSszrqdm());
			if(syrkid.equals(temp.getSyrkid())){
				zdrylx.add(temp.getZdrygllxdm());
				map.put("isEdit", "1");
				zdry.remove(i);
				zdry.add(sort++, temp);
			}else
				map.put("isEdit", "0");
			zdrylxList.add(map);
		}
		mv.addObject("zdry", zdry.get(0));
		mv.addObject("mode", mode);
		mv.addObject("zdrylx", zdrylx);
		mv.addObject("zdrylxList", zdrylxList);
		mv.addObject("zdrylxJson", new Gson().toJson(zdrylxList));
		mv.addObject("mainTabID", mainTabID);
		
		
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
	public @ResponseBody List<ZdrygnVO> queryYwglgn(String gnlxdm) {
		return zdryEditService.queryYwglgn(gnlxdm);
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
	public @ResponseBody List<ZdryxxzsVO> queryRyzsxx(@RequestParam(value="zdrylxJson")String zdrylxJson) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("zdrylxJson", zdrylxJson);
		return zdryEditService.queryRyzsxx(map);
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
				model.put("entity", MethodUtils.invokeMethod(zdryEditService,
						methodName, params));
				// model.put("fields",
				// getFieldDesc(MethodUtils.getAccessibleMethod(syrkService.getClass(),
				// methodName , Map.class)));
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
	 * 跳转-实有人口信息注销页面
	 * 
	 * @param url
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/delete_xxzsnrb", method = RequestMethod.GET)
	public ModelAndView delete_xxzsnrb(String url, String id) {
		ModelAndView mv = new ModelAndView("rkEdit/zdryDeleteEdit");
		mv.addObject("url", url);
		mv.addObject("id", id);
		return mv;
	}

	/**
	 * 注销实有人口
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
		zdryEditService.delete_xxzsnrb(map);
		model.put(AppConst.STATUS, AppConst.SUCCESS);
		model.put(AppConst.MESSAGES, "注销成功！");
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}

	
	/**
	 * 查询实有人口活动轨迹
	 * 
	 * @return
	 */
	@RequestMapping(value = "/queryRkHdgj", method = RequestMethod.POST)
	public @ResponseBody ModelAndView queryRkHdgj(String ryid) {
		ModelAndView mv = new ModelAndView("sryk/srykAdd");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ryid", ryid);
//		List<Ryhdgjb> srykHdgjList = zdryEditService.queryRkHdgj(map);
//		mv.addObject("srykGlryList", srykHdgjList);
		return mv;
	}
	
	
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView edit(String zdryid) {
		ModelAndView mv = new ModelAndView("zpfj/fjEdit");
		mv.addObject("lybm", "ZDRY_ZDRYZB");
		mv.addObject("lyid", zdryid);
		mv.addObject("lyms", "重点人员-附件");
		mv.addObject("fileType", "");
		mv.addObject("fileOnly", 0);
		return mv;
	}
	
	@RequestMapping(value = "/query", method = RequestMethod.POST)
	public @ResponseBody List<ZpfjFjxxb> query(String ryid){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", ryid);
		List<ZpfjFjxxb> fjxx = zdryEditService.fjxx_query(map);
		return fjxx;
	}
}
