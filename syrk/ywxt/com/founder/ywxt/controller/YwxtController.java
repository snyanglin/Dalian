package com.founder.ywxt.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.founder.framework.base.controller.BaseController;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.components.AppConst;
import com.founder.framework.exception.BussinessException;
import com.founder.framework.message.bean.SysMessage;
import com.founder.framework.message.dao.SysMessageDao;
import com.founder.ywxt.bean.YwxtYwxtxxb;
import com.founder.ywxt.dao.YwxtYwxtxxbDao;
import com.founder.ywxt.factory.XtFactory;
import com.founder.ywxt.service.XtTaskService;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
/***
 * ****************************************************************************
 * @Package:      [com.founder.ywxt.controller.YwxtController.java]  
 * @ClassName:    [YwxtController]   
 * @Description:  [业务系统处理消息controller]   
 * @Author:       [wu_chunhui@founder.com.cn]  
 * @CreateDate:   [2015-6-1 下午4:17:31]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-6-1 下午4:17:31，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Controller
@RequestMapping("ywxt")
public class YwxtController  extends BaseController {
	
	@Resource(name = "ywxtYwxtxxbDao")
	private YwxtYwxtxxbDao ywxtYwxtxxbDao;
	@Resource
	private SysMessageDao sysMessageDao;


	@Resource(name = "xtFactory")
	private XtFactory xtFactory;
	
	/**
	 * 
	 * @Title: creatRyxt
	 * @Description: TODO(人口协同任务打开页面)
	 * @param @param xtId
	 * @param @param messageId
	 * @param @return
	 * @param @throws BussinessException    设定文件
	 * @return ModelAndView    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/creatRyxt", method = RequestMethod.GET)
	public ModelAndView creatRyxt(
			@RequestParam(value = "xtId", required = true) String xtId,
			@RequestParam(value = "messageid", required = true) String messageid,
			@RequestParam(value = "approvalLevel", required = true) String approvalLevel)  {
		ModelAndView mv = new ModelAndView("ywxt/rkxt");
		mv.addObject("xtId", xtId);
		mv.addObject("messageid", messageid);
		mv.addObject("approvalLevel", approvalLevel);
		YwxtYwxtxxb ywxtYwxtxxb =ywxtYwxtxxbDao.queryById(xtId);
		if(ywxtYwxtxxb!=null){
		String dataJson = ywxtYwxtxxb.getDatajson();
		Map<String,Object> jsonMap =new Gson().fromJson(dataJson, new TypeToken<Map<String,Map<String,String>>>(){}.getType());
		Map<String,String> fqMap =(Map<String,String>)jsonMap.get("fq");
		mv.addObject("xm", fqMap.get("xm"));
		mv.addObject("zjhm", fqMap.get("zjhm"));
		mv.addObject("xtType", ywxtYwxtxxb.getYwlx());
		}
		//查询消息内容展现在页面
		SysMessage sysMessage = new SysMessage();
		sysMessage.setId(Long.valueOf(messageid));
		sysMessage=sysMessageDao.query(sysMessage);
		if("1".equals(sysMessage.getSfck())){
			mv.addObject("openType", "view");
		}
		mv.addObject("content",sysMessage.getXxnr());
		return mv;
	}
	
	/***
	 * 
	 * @Title: updateXtjg
	 * @Description: TODO(根据协同结果处理系统模块业务)
	 * @param @param xtId
	 * @param @param messageId
	 * @param @return
	 * @param @throws BussinessException    设定文件
	 * @return ModelAndView    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/updateXtjg", method = RequestMethod.POST)
	public ModelAndView updateXtjg(
			@RequestParam(value = "xtId", required = true) String xtId,
			@RequestParam(value = "messageid", required = true) String messageid,
			@RequestParam(value = "xtjg", required = true) String xtjg,String xtType, 
			@RequestParam(value = "approvalLevel", required = true) int approvalLevel) throws BussinessException {
		SessionBean sessionBean = getSessionBean();
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		Map<String, Object> model = new HashMap<String, Object>();
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("xtjg", xtjg);
		paramMap.put("messageid", messageid);
		paramMap.put("xtId", xtId);
		paramMap.put("approvalLevel", approvalLevel);
		XtTaskService  XtTaskService =	xtFactory.factory(xtType);
		try {
			XtTaskService.updateXtjgByCyr(paramMap, approvalLevel,sessionBean,xtType);
			model.put(AppConst.STATUS, AppConst.SUCCESS);
			model.put(AppConst.MESSAGES, getAddSuccess());
		} catch (Exception e) {
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES,e.getLocalizedMessage());
			
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}
	
	
	
	
}
