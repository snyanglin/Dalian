package com.founder.zdrygl.base.controller;

import com.founder.framework.annotation.RestfulAnnotation;
import com.founder.framework.base.controller.BaseController;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.components.AppConst;
import com.founder.framework.utils.EasyUIPage;
import com.founder.syrkgl.service.SyrkSyrkxxzbService;
import com.founder.zdrygl.base.model.ZdryShbzdryxxb;
import com.founder.zdrygl.base.model.ZdryZb;
import com.founder.zdrygl.base.service.ZdryInfoQueryService;
import com.founder.zdrygl.base.service.ZdryShbzdryxxbService;
import com.founder.zdrygl.core.factory.ZdryAbstractFactory;
import com.google.gson.Gson;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * ****************************************************************************
 * 
 * @Package: [com.founder.zdrygl.base.controller.ZdryShbzdryController.java]
 * @ClassName: [ZdryShbzdryController]
 * @Description: [涉环保指定列管]
 * @Author: [wei.wen@founder.com.cn]
 * @CreateDate: [2015年9月18日 下午3:20:01]
 * @UpdateUser: [wei.wen@founder.com.cn(如多次修改保留历史记录，增加修改记录)]
 * @UpdateDate: [2015年9月18日 下午3:20:01，(如多次修改保留历史记录，增加修改记录)]
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]
 * @Version: [v1.0]
 */
@Controller
@RequestMapping("/shb")
public class ZdryShbzdryController extends BaseController {
	private Logger logger = Logger.getLogger(this.getClass());

	@Autowired
	public ZdryAbstractFactory zdryFactory;

	@Resource(name = "zdryQueryService")
	private ZdryInfoQueryService zdryQueryService;


	@Resource(name = "syrkSyrkxxzbService")
	private SyrkSyrkxxzbService syrkSyrkxxzbService;
	@Resource
	private ZdryShbzdryxxbService zdryShbzdryxxbService;


	
	/**
	 * 
	 * @Title: shbManage
	 * @Description: (涉环保重点人员管理页面)
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	@RequestMapping(value="/shbManage",method = RequestMethod.GET)
	public String shbManage(){
		return "zdrygl/zdryShbzdryList";
	}
	
	/**
	 * 
	 * @Title: shbAddPre
	 * @Description: TODO(涉环保重点人员新增页面)
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	@RequestMapping(value="/shbAddPre",method = RequestMethod.GET)
	public String shbAddPre(){
		return "zdrygl/zdryShbzdryAdd";
	}
	
	@RestfulAnnotation(serverId = "3")
	@RequestMapping(value = "/shbzdry/list", method = RequestMethod.POST)
	public @ResponseBody
	EasyUIPage queryList(EasyUIPage page,
						 @RequestParam(value = "rows", required = false) Integer rows,
						 ZdryShbzdryxxb entity, SessionBean sessionBean) {
		page.setPagePara(rows);
		sessionBean = getSessionBean(sessionBean);
		//entity.setGxzrqdm(sessionBean.getUserOrgCode());
		return this.zdryShbzdryxxbService.queryList(entity, page,sessionBean);
	}
	
	@RestfulAnnotation(serverId = "3")
	@RequestMapping(value = "/shbzdry/edit", method = RequestMethod.GET)
	public @ResponseBody
	ModelAndView shbzdryEdit(String zdryid,String type) {
		ModelAndView mv=new ModelAndView("/zdrygl/zdryShbzdryEdit");
		ZdryShbzdryxxb shb = zdryShbzdryxxbService.queryById(zdryid);
		ZdryZb zb = (ZdryZb) zdryQueryService.queryById(zdryid);
		shb.setRyid(zb.getRyid());
		shb.setQx(type);
		mv.addObject("zdryShbzdryxxb",shb);
		return mv;
	}
	
	@RestfulAnnotation(serverId = "3")
	@RequestMapping(value = "/shbzdry/update", method = RequestMethod.POST)
	public @ResponseBody
	ModelAndView shbzdryUpdate(ZdryShbzdryxxb zdryShbzdryxxb, SessionBean sessionBean) {
			
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		Map<String, Object> map = new HashMap<String, Object>();
		sessionBean = getSessionBean(sessionBean);
		try {
			zdryShbzdryxxbService.update(zdryShbzdryxxb, sessionBean);
			map.put(AppConst.STATUS, AppConst.SUCCESS);
			map.put(AppConst.MESSAGES, getUpdateSuccess());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			map.put(AppConst.STATUS, AppConst.FAIL);
			map.put(AppConst.MESSAGES, getUpdateFail());
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(map));
		return mv;
	}	
	
}
