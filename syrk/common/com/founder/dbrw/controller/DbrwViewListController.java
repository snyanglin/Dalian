package com.founder.dbrw.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.founder.dbrw.bean.DbrwDbpzb;
import com.founder.dbrw.bean.DbrwDbrwb;
import com.founder.dbrw.bean.DbrwDbrwsjmxb;
import com.founder.dbrw.bean.RuleYwxtgzrwlsjlb;
import com.founder.dbrw.service.DbrwDbpzbService;
import com.founder.dbrw.service.DbrwRwclService;
import com.founder.dbrw.service.DbrwViewListService;
import com.founder.framework.base.controller.BaseController;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.exception.BussinessException;
import com.founder.framework.message.bean.SysMessage;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;

/**
 * ****************************************************************************
 * 
 * @Package: [com.founder.dbrw.controller.DbrwViewListController.java]
 * @ClassName: [DbrwViewListController]
 * @Description: [领导查看督办任务控制器]
 * @Author: [weiwen]
 * @CreateDate: [2014-10-26 下午3:08:39]
 * @UpdateUser: [weiwen(如多次修改保留历史记录，增加修改记录)]
 * @UpdateDate: [2014-10-26 下午3:08:39，(如多次修改保留历史记录，增加修改记录)]
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]
 * @Version: [v1.0]
 */
@Controller
@RequestMapping(value = "/dbrwVL")
public class DbrwViewListController extends BaseController {

	@Resource(name = "dbrwViewListService")
	private DbrwViewListService dbrwVLService;

	@Resource(name = "dbrwDbpzbService")
	private DbrwDbpzbService dbrwDbpzbService;

	@Resource(name = "dbrwRwclService")
	private DbrwRwclService dbrwRwclService;

	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public ModelAndView main(String id) {
		DbrwDbrwb entity = dbrwVLService.getRwById(id);
		if (entity == null) {
			ModelAndView mv = new ModelAndView("bussiness");
			mv.addObject("message", getMessage("authority.fail"));
			return mv;
		}
		ModelAndView mv = new ModelAndView("dbrw/rwViewList");
		mv.addObject("entity", entity);
		mv.addObject("titleArray", dbrwRwclService.getFiledTitle(entity
				.getDbmxid()));
		return mv;
	}

	/**
	 * 
	 * @Title: list
	 * @Description: TODO(根据任务ID，或任务)
	 * @param @param page
	 * @param @param rows
	 * @param @param rwb
	 * @param @return 设定文件
	 * @return EasyUIPage 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public @ResponseBody
	EasyUIPage list(EasyUIPage page,
			@RequestParam(value = "rows") Integer rows, DbrwDbrwb rwb) {
		page.setPagePara(rows);
		if (StringUtils.isBlank(rwb.getDbrwfqpcsdm()))
			rwb.setDbrwfqpcsdm(super.getSessionBean().getUserOrgCode());
		return dbrwVLService.list(page, rwb);
	}

	@RequestMapping(value = "/list/{id}", method = RequestMethod.GET)
	public @ResponseBody
	EasyUIPage list(EasyUIPage page,
			@RequestParam(value = "rows") Integer rows,
			@PathVariable(value = "id") String id, DbrwDbrwb rwb) {
		page.setPagePara(rows);
		if (StringUtils.isBlank(rwb.getDbrwfqpcsdm()))
			rwb.setDbrwfqpcsdm(super.getSessionBean().getUserOrgCode());
		return dbrwVLService.list(page, rwb, id);
	}

	/**
	 * 
	 * @Title: view
	 * @Description: TODO(根据ID查询任务记录)
	 * @param @param id
	 * @param @return
	 * @param @throws BussinessException 设定文件
	 * @return DbrwDbrwb 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody
	DbrwDbrwb view(@PathVariable(value = "id") String id)
			throws BussinessException {
		DbrwDbrwb rw = dbrwVLService.getRwById(id);
		if (rw == null) {
			throw new BussinessException("没有此任务！");
		}
		return rw;
	}

	/**
	 * 
	 * @Title: rwmxlist
	 * @Description: TODO(根据任务ID取所有任务记录)
	 * @param @param page
	 * @param @param rows
	 * @param @param rwid
	 * @param @return 设定文件
	 * @return EasyUIPage 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/rwmxlist", method = RequestMethod.POST)
	public @ResponseBody
	EasyUIPage rwmxlist(EasyUIPage page,
			@RequestParam(value = "rows") Integer rows, DbrwDbrwsjmxb entity) {
		entity.setSspcsdm(super.getSessionBean().getUserOrgCode());
		page.setPagePara(rows);
		return dbrwVLService.rwmxlist(page, entity);
	}

	@RequestMapping(value = "mxfiled/{dbmxid}", method = RequestMethod.GET)
	public @ResponseBody
	String[] mxfiled(@PathVariable(value = "dbmxid") String dbmxid)
			throws BussinessException {
		DbrwDbpzb dbrwDbpzb = dbrwDbpzbService.query(dbmxid);

		String dbsjxbtm = dbrwDbpzb.getDbsjxbtm();
		String[] titleArray = null;
		if (!StringUtils.isBlank(dbsjxbtm)) {
			titleArray = dbsjxbtm.split("#");
		}
		return titleArray;
	}

	@RequestMapping(value = "/queryRwqktjChart", method = RequestMethod.GET)
	public @ResponseBody
	Map<String, Object> queryGzdxChart(String rwid) {
		return dbrwVLService.gzdxChart(rwid.substring(0, rwid.indexOf("~")));
	}

	/**
	 * sny
	 * 
	 * @Title: queryDb
	 * @Description: TODO(更多督办功能)
	 * @param @param page
	 * @param @param rows
	 * @param @param rwb
	 * @param @return 设定文件
	 * @return EasyUIPage 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/queryDb", method = RequestMethod.POST)
	public @ResponseBody
	EasyUIPage queryDb(EasyUIPage page,
			@RequestParam(value = "rows") Integer rows, DbrwDbrwb rwb) {
		page.setPagePara(rows);
		if (StringUtils.isBlank(rwb.getDbrwfqpcsdm()))
			rwb.setDbrwfqpcsdm(super.getSessionBean().getUserOrgCode());
		return dbrwVLService.listDb(page, rwb);
	}

	/**
	 * sny
	 * 
	 * @Title: queryDbTotal
	 * @Description: TODO(更多督办功能总条数)
	 * @param @param entity
	 * @param @param flag
	 * @param @return 设定文件
	 * @return long 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/queryDbTotal")
	public @ResponseBody
	long queryDbTotal(DbrwDbrwb entity,
			@RequestParam(value = "flag", required = false) String flag) {
		return dbrwVLService.listDbTotal(entity);
	}

	/**
	 * sny
	 * 
	 * @Title: mainMore
	 * @Description: TODO(更多督办功能调整页面)
	 * @param @param id
	 * @param @return 设定文件
	 * @return ModelAndView 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/mainMore", method = RequestMethod.GET)
	public ModelAndView mainMore(String id) {
		ModelAndView mv = new ModelAndView("dbrw/rwMoreList");
		mv.addObject("id", StringUtils.nullToStr(id));
		return mv;
	}

	@RequestMapping(value = "/queryCondition", method = RequestMethod.GET)
	public ModelAndView queryCondition(String rwid) {
		ModelAndView mv = new ModelAndView("dbrw/rwViewQueryCondition");
		DbrwDbrwb rwb = dbrwVLService.getRwById(rwid);
		if (rwb != null) {
			String dbmxid = rwb.getDbmxid();
			DbrwDbpzb dbrwDbpzb = dbrwDbpzbService.query(dbmxid);
			if (dbrwDbpzb != null) {
				String dbsjxbtm = dbrwDbpzb.getDbsjxbtm();
				if (!StringUtils.isBlank(dbsjxbtm)) {
					String[] fieldNameArray = dbsjxbtm.split("#");
					mv.addObject("fieldNameArray", fieldNameArray);
				}
			}
		}
		return mv;
	}

	/**
	 * sny
	 * 
	 * @Title: queryDb
	 * @Description: TODO(更多督办功能)
	 * @param @param page
	 * @param @param rows
	 * @param @param rwb
	 * @param @return 设定文件
	 * @return EasyUIPage 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/queryXt", method = RequestMethod.POST)
	public @ResponseBody
	EasyUIPage queryXt(EasyUIPage page,
			@RequestParam(value = "rows") Integer rows, RuleYwxtgzrwlsjlb rwb) {
		page.setPagePara(rows);
		SessionBean sessionBean = getSessionBean();
		if(null != sessionBean){
			//rwb.setRwclrbmid((String)sessionBean.getUserOrgCode());
			rwb.setRwclrbmid("210202460203");
		}
//		if (StringUtils.isBlank(rwb.getDbrwfqpcsdm()))
//			rwb.setDbrwfqpcsdm(super.getSessionBean().getUserOrgCode());
		return dbrwVLService.listXt(page, rwb);
	}

	/**
	 * sny
	 * 
	 * @Title: queryDbTotal
	 * @Description: TODO(更多督办功能总条数)
	 * @param @param entity
	 * @param @param flag
	 * @param @return 设定文件
	 * @return long 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/queryXtTotal")
	public @ResponseBody
	long queryXtTotal(RuleYwxtgzrwlsjlb entity,
			@RequestParam(value = "flag", required = false) String flag) {
		SessionBean sessionBean = getSessionBean();
		if(null != sessionBean){
			entity.setRwclrbmid((String)sessionBean.getUserOrgCode());
		}
		return dbrwVLService.listXtTotal(entity);
	}
	
	
	@RequestMapping(value = "/xtMore", method = RequestMethod.GET)
	public ModelAndView xtMore(String id) {
		RuleYwxtgzrwlsjlb entity = dbrwVLService.getXtById(id);
		if (entity == null) {
			ModelAndView mv = new ModelAndView("bussiness");
			mv.addObject("message", getMessage("authority.fail"));
			return mv;
		}
		ModelAndView mv = new ModelAndView("dbrw/todoMore");
		mv.addObject("entity", entity);
		return mv;
	}
	//test
	@RequestMapping(value = "/tMore", method = RequestMethod.GET)
	public ModelAndView tMore(String id) {
		ModelAndView mv = new ModelAndView("dbrw/sendMsg");
		return mv;
	}
	
	@RequestMapping(value = "/sMore", method = RequestMethod.GET)
	public ModelAndView sMore(String id) {
		ModelAndView mv = new ModelAndView("dbrw/seeMsg");
		return mv;
	}
	//test
	
	/**
	 * sny
	 * 
	 * @Title: queryDb
	 * @Description: TODO(更多督办功能)
	 * @param @param page
	 * @param @param rows
	 * @param @param rwb
	 * @param @return 设定文件
	 * @return EasyUIPage 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/queryMsg", method = RequestMethod.POST)
	public @ResponseBody
	EasyUIPage queryMsg(EasyUIPage page,
			@RequestParam(value = "rows") Integer rows, SysMessage db) {
		page.setPagePara(rows);
		SessionBean sessionBean = getSessionBean();
		if(null != sessionBean){
			db.setFsrdm((String)sessionBean.getUserId());
			//db.setFsr((String)sessionBean.getExtendMap().get("userName"));
			//db.setFsrssdw((String)sessionBean.getExtendMap().get("userOrgName"));
		}
		return dbrwVLService.listMsg(page, db);
	}

	/**
	 * sny
	 * 
	 * @Title: queryDbTotal
	 * @Description: TODO(更多督办功能总条数)
	 * @param @param entity
	 * @param @param flag
	 * @param @return 设定文件
	 * @return long 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/queryMsgTotal")
	public @ResponseBody
	long queryMsgTotal(SysMessage entity,
			@RequestParam(value = "flag", required = false) String flag) {
		SessionBean sessionBean = getSessionBean();
		if(null != sessionBean){
			entity.setFsrdm((String)sessionBean.getUserId());
			//entity.setJsrssdwdm((String)sessionBean.getUserOrgCode());
		}
		return dbrwVLService.listMsgTotal(entity);
	}
	
	@RequestMapping(value = "/backMsg", method = RequestMethod.POST)
	public @ResponseBody
		Map backMsg(String id) {
		Map<String, Object> model = new HashMap<String, Object>();
		String entity = dbrwVLService.backMsg(id);
		model.put("e", entity);
		return model;
	}
	
	
}
