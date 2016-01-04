package com.founder.zdrygl.base.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import com.founder.framework.exception.RestException;
import com.founder.framework.utils.DateUtils;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.syrkgl.bean.RyRyjbxxb;
import com.founder.syrkgl.bean.SyrkSyrkxxzb;
import com.founder.syrkgl.dao.SyrkSyrkxxzbDao;
import com.founder.syrkgl.service.RyRyjbxxbService;
import com.founder.zdrygl.base.model.ZdryZb;
import com.founder.zdrygl.base.service.ZdryInfoQueryService;
import com.founder.zdrygl.base.vo.ZdryVO;
import com.founder.zdrygl.base.vo.ZdryZdryhsbVO;
import com.founder.zdrygl.base.vo.ZdryZdryzbVO;
import com.founder.zdrygl.core.factory.ZdryAbstractFactory;
import com.founder.zdrygl.core.inteface.ZdryService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
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

import com.founder.zdrygl.base.service.ZdryZdryhsbService;
import com.founder.zdrygl.base.model.ZdryZdryhsb;
import com.google.gson.Gson;
import org.apache.log4j.Logger;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/***
 * ****************************************************************************
 *
 * @Package: [com.founder.zdrygl.bean]
 * @ClassName: ZdryZdryhsb
 * @Description: [一句话描述该类的功能]
 * @Author: [zhoulijun@founder.com.cn]
 * @CreateDate:  2015-12-15 04:46:24
 * @UpdateUser: [Administrator(如多次修改保留历史记录，增加修改记录)]
 * @UpdateDate: [ 2015-12-15 04:46:24，(如多次修改保留历史记录，增加修改记录)]
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]
 * @Version: [v1.0]
 */


@Controller
@RequestMapping("/zdryHsb")
public class ZdryhsbController extends BaseController{
   	private Logger logger = Logger.getLogger(this.getClass());

	@Resource
	private ZdryZdryhsbService zdryZdryhsbService;
	@Resource
	private SyrkSyrkxxzbDao syrkSyrkxxzbDao;
	@Resource
	private ZdryInfoQueryService zdryInfoQueryService;
	@Resource
	private RyRyjbxxbService ryRyjbxxbService;
	@Autowired
	public ZdryAbstractFactory zdryFactory;




	@RequestMapping(value = "/query")
	@ResponseBody
	public   ModelAndView query() {
		ModelAndView mv = new ModelAndView("zdry/zdryHsbList");
		return mv;
	}


	@RequestMapping(value = "/queryList",method = RequestMethod.POST)
	@ResponseBody
	public EasyUIPage queryList(EasyUIPage page, @RequestParam("rows") Integer rows, ZdryZdryhsbVO entity, SessionBean sessionBean) {
		sessionBean = this.getSessionBean(sessionBean);
		page.setPagePara(rows);
		entity.setSspcs(sessionBean.getExtendMap().get("ssPcsCode"));
		if ("".equals(entity.getXm())){
			entity.setXm(null);
		}
		if ("".equals(entity.getZjhm())){
			entity.setZjhm(null);
		}
		if (null==entity.getHszt()){
			entity.setHszt("0,3");
		}
		EasyUIPage easyUIPage = zdryZdryhsbService.queryList(page, entity);
		List zdryHsbList = easyUIPage.getRows();

		for(int i = 0; i < zdryHsbList.size(); ++i) {
			SyrkSyrkxxzb quertEntity = null;
			ZdryZdryhsb zdryHsb = (ZdryZdryhsb)zdryHsbList.get(i);
			HashMap map = new HashMap();
			map.put("zjhm", zdryHsb.getZjhm());
			map.put("gxzrqdm", sessionBean.getUserOrgCode());
			List list = this.syrkSyrkxxzbDao.queryHsbSyrkidByZjhm(map);

			if(list.size() > 0) {
				quertEntity = (SyrkSyrkxxzb)list.get(0);
			}

			if(!StringUtils.isBlank(quertEntity)) {
				zdryHsb.setSyrkid(quertEntity.getId());
				zdryHsb.setRyid(quertEntity.getRyid());
			} else {
				zdryHsb.setSyrkid("");
				zdryHsb.setRyid("");
			}
		}

		return easyUIPage;
	}

	/**
	 * 准备核实撤管
	 * @param zdryHsbId
     * @return
     */
	@RequestMapping(value = "/createHsCg",method =RequestMethod.GET)
	public ModelAndView createHsLg(String zdryHsbId) {
		SessionBean sessionBean = this.getSessionBean();
		ModelAndView mv = new ModelAndView("zdry/zdryHsbCg");
		ZdryZdryhsb zdryHsb = zdryZdryhsbService.queryById(zdryHsbId);
		mv.addObject("zdryHsb", zdryHsb);
		mv.addObject("sqsj", DateUtils.getSystemDateString());
		mv.addObject("sqr_xm", sessionBean.getUserName());
		mv.addObject("zdrygllxdm", zdryHsb.getZdrygllxdm());
		return mv;
	}


	/**
	 * 保存核实撤管申请
	 * @param zdryHsbId
	 * @param sessionBean
     * @return
     */
	@RequestMapping(value = "/saveHsCg",method = RequestMethod.POST)
	public ModelAndView saveHsCg(String zdryHsbId, String sqyj,SessionBean sessionBean) {
		ModelAndView mv = new ModelAndView("redirect:/forward/forword");
		HashMap model = new HashMap();
		sessionBean = this.getSessionBean(sessionBean);

		try {
			ZdryZdryhsb e = zdryZdryhsbService.queryById(zdryHsbId);
			zdryZdryhsbService.saveHsCg(e,sqyj,sessionBean);
			model.put("status", "success");
			model.put("message", "申请发起成功");
		} catch (Exception var7) {
			this.logger.error(var7.getLocalizedMessage(), var7);
			model.put("status", "error");
			model.put("message", "申请发起失败");
		}

		mv.addObject("message", (new Gson()).toJson(model));
		return mv;
	}


	@RequestMapping(value = "/createLcg/{ywlx}",method =RequestMethod.GET)
	public ModelAndView createLg(String syrkid, @RequestParam(required = true) String ryid, @PathVariable("ywlx") String ywlx, String zdrygllxdm, String zdryHsbId) {
		SessionBean sessionBean = this.getSessionBean();
		ModelAndView mv = new ModelAndView("zdry/zdryLcg");
		List zdryZdList = null;
		if(!StringUtils.isBlank(ryid)) {
			zdryZdList = this.zdryInfoQueryService.queryZdryVoByRyid(ryid);
		}

		ZdryZdryzbVO zdryZdryzbVO = new ZdryZdryzbVO();
		if(zdryZdList != null && zdryZdList.size() > 0) {
			zdryZdryzbVO = (ZdryZdryzbVO)zdryZdList.get(0);
			Map zdryLczywblb1 = zdryZdryhsbService.getZdryGlLxByList(zdryZdList, syrkid);
			mv.addAllObjects(zdryLczywblb1);
		} else {
			RyRyjbxxb zdryLczywblb = this.ryRyjbxxbService.queryById(ryid);
			if(zdryLczywblb != null) {
				zdryZdryzbVO.setXm(zdryLczywblb.getXm());
				zdryZdryzbVO.setCyzjdm("111");
				zdryZdryzbVO.setZjhm(zdryLczywblb.getZjhm());
			}
		}

		if(!StringUtils.isBlank(zdryHsbId)) {
			ZdryZdryhsb zdryLczywblb2 = zdryZdryhsbService.queryById(zdryHsbId);
			if(zdryLczywblb2 != null) {
				mv.addObject("zdrygllxdm", zdryLczywblb2.getZdrygllxdm());
				mv.addObject("zdrylbdm", zdryLczywblb2.getZdrylbdm());
				mv.addObject("glffdm", zdryLczywblb2.getZdrk_glffdm());
				mv.addObject("lglydm", zdryLczywblb2.getZdrk_lglydm());
				mv.addObject("xfbmdm", zdryLczywblb2.getXfbmdm());
			}
		}

		zdryZdryzbVO.setSyrkid(syrkid);
		mv.addObject("zdryZdryzbVO", zdryZdryzbVO);
		mv.addObject("ywlx", ywlx);
		mv.addObject("zdrygllxdm", zdrygllxdm);
		mv.addObject("zdryHsbId", zdryHsbId);
		mv.addObject("ywblr_xm", sessionBean.getUserName());
		mv.addObject("ywblr_id", sessionBean.getUserId());
		mv.addObject("ywclsj", DateUtils.getSystemDateString());
		return mv;
	}


	/**
	 * 核实转递准备
	 * @param id
	 * @return
	 * @throws BussinessException
     */
	@RequestMapping(value = "/hszd",method = RequestMethod.GET)
	public ModelAndView hszd(String id) throws BussinessException {
		ModelAndView mv = new ModelAndView("zdry/zdryHszd");
		ZdryZdryhsb zdryHsb = zdryZdryhsbService.queryById(id);
		if(zdryHsb == null) {
			throw new BussinessException("重点人员核实表查询无数据！");
		} else {
			mv.addObject("zdryHsb", zdryHsb);
			return mv;
		}
	}

	@RequestMapping(value ="/saveHszd",method =RequestMethod.POST)
	public ModelAndView saveHszd(ZdryZdryhsb entity, SessionBean sessionBean) {
		ModelAndView mv = new ModelAndView(this.getViewName(sessionBean));
		HashMap map = new HashMap();
		sessionBean = this.getSessionBean(sessionBean);

		try {
			zdryZdryhsbService.saveHszd(entity, sessionBean);
			map.put("status", "success");
			map.put("message", "转递成功");
		} catch (Exception var6) {
			var6.printStackTrace();
			this.logger.error(var6.getMessage(), var6);
			map.put("status", "error");
			map.put("message", "转递失败");
		}

		mv.addObject("message", (new Gson()).toJson(map));
		return mv;
	}

	/**
	 *
	 * @Title: saveLg
	 * @Description: TODO(保存列管)
	 * @param @param zdryVO
	 * @param @param uploadFile
	 * @param @param sessionBean
	 * @param @return 设定文件
	 * @return ModelAndView 返回类型
	 * @throws RestException
	 * @throw
	 */
	@RequestMapping(value = "/saveLg", method = RequestMethod.POST)
	public ModelAndView saveLg(@Valid ZdryVO zdryVO,SessionBean sessionBean) throws RestException {
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		ZdryService zdryService = null;
		Map<String, Object> model = new HashMap<String, Object>();
		sessionBean = getSessionBean(sessionBean);
		try {
			zdryZdryhsbService.saveLg(zdryVO,  sessionBean);
			ZdryZdryhsb e = zdryZdryhsbService.queryById(zdryVO.getZdryHsbId());
			e.setHszt("1");
			zdryZdryhsbService.update(e, sessionBean);
			model.put(AppConst.STATUS, AppConst.SUCCESS);
			model.put(AppConst.MESSAGES, getAddSuccess());
		} catch (BussinessException e) {
			logger.error(e.getLocalizedMessage(), e);
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, e.getLocalizedMessage());
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage(), e);
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, getAddFail());
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}

}

