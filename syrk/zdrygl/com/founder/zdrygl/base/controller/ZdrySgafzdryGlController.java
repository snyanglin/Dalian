package com.founder.zdrygl.base.controller;

import com.founder.framework.base.controller.BaseController;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.components.AppConst;
import com.founder.framework.exception.BussinessException;
import com.founder.framework.utils.EasyUIPage;
import com.founder.syrkgl.bean.RyRyjbxxb;
import com.founder.zdrygl.base.model.ZdrySgafzdryxxb;
import com.founder.zdrygl.base.service.ZdrySgafzdryxxbService;
import com.founder.zdrygl.base.vo.ZdrySgafzdryAddVO;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/zdrySgafzdryGl")
public class ZdrySgafzdryGlController extends BaseController {

	private Logger logger = Logger.getLogger(this.getClass());
	
	@Resource
	private ZdrySgafzdryxxbService zdrySgafzdryxxbService;
	
	
	@RequestMapping(value = "/addView", method = RequestMethod.GET)
	public ModelAndView add(@RequestParam String tabid){
		ModelAndView mv = new ModelAndView("zdrygl/zdrySgafzdryAdd");
		ZdrySgafzdryAddVO vo = new ZdrySgafzdryAddVO();
		vo.setRyRyjbxxb(new RyRyjbxxb());
		vo.setZdrySgafzdryxxb(new ZdrySgafzdryxxb());
		mv.addObject("addVO", vo);
		mv.addObject("tabid", tabid);
		return mv;
	}
	
	/**
	 * 重点人员列表查询
	 * @param page
	 * @param rows
	 * @param entity
	 * @return
	 */
	@RequestMapping(value = "/queryList", method = RequestMethod.POST)
	public @ResponseBody EasyUIPage zdryApproval(EasyUIPage page,@RequestParam(value="rows",required = false)Integer rows,
			ZdrySgafzdryxxb entity) {
		
		SessionBean sessionBean = this.getSessionBean();
		String orglevel = sessionBean.getUserOrgLevel();
		String userOrg = sessionBean.getUserOrgCode();
		
		//默认展现待处理功能
		if(StringUtils.isBlank(entity.getSearchStatus())){
			entity.setSearchStatus("dcl");
		}
		
		if("10".equals(orglevel)){
			entity.setSssj(userOrg);
			if("dcl".equals(entity.getSearchStatus())){//待处理
				entity.setSearchStatus("T2.SSFJ is null");
			}else if("xfz".equals(entity.getSearchStatus())){//下发中
				entity.setSearchStatus("T2.SSFJ is not null AND (T2.SSZRQ is null or T2.SSPCS is null)");
			}else{//已下发
				entity.setSearchStatus("T2.SSZRQ is not null");
			}
		}else if("21".equals(orglevel)){
			entity.setSsfj(userOrg);
			if("dcl".equals(entity.getSearchStatus())){//待处理
				entity.setSearchStatus("T2.SSPCS is null");
			}else if("xfz".equals(entity.getSearchStatus())){//下发中
				entity.setSearchStatus("T2.SSPCS is not null AND T2.SSZRQ is null");
			}else{//已下发
				entity.setSearchStatus("T2.SSZRQ is not null");
			}
		}else if("32".equals(orglevel)){
			entity.setSspcs(userOrg);
			if("dcl".equals(entity.getSearchStatus())){//待处理
				entity.setSearchStatus("T2.SSZRQ is null");
			}else{//已下发
				entity.setSearchStatus("T2.SSZRQ is not null");
			}
		}else{
			//其他级别暂时不暴漏数据
			page.setRownum(0);
			page.setTotal(0);
			return page;
		}
		page.setPagePara(rows);
		return this.zdrySgafzdryxxbService.queryList(entity, page);
	}
	
	/**
	 * 重点人员下发功能
	 * @param addVO
	 * @param sessionBean
	 * @return
	 */
	@RequestMapping(value = "/saveAdd", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> saveAdd(ZdrySgafzdryAddVO addVO,SessionBean sessionBean) {
		Map<String, Object> map = new HashMap<String, Object>();
		sessionBean = getSessionBean(sessionBean);
		
		try {
			this.zdrySgafzdryxxbService.saveAdd(addVO, sessionBean);
			map.put(AppConst.STATUS, AppConst.SUCCESS);
			map.put(AppConst.MESSAGES, "新增成功");
		}catch (BussinessException e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
			map.put(AppConst.STATUS, AppConst.FAIL);
			map.put(AppConst.MESSAGES, "该涉公安访重点人员信息已存在");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
			map.put(AppConst.STATUS, AppConst.FAIL);
			map.put(AppConst.MESSAGES, getAddFail()+e.getLocalizedMessage());
		}
		return map;
	}
	
	/**
	 * 重点人员下发功能
	 * @param entity
	 * @param sessionBean
	 * @return
	 */
	@RequestMapping(value = "/zdryXiaFa", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> zdryXiaFa(ZdrySgafzdryxxb entity, SessionBean sessionBean) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		sessionBean = getSessionBean(sessionBean);
		
		try {
			this.zdrySgafzdryxxbService.sgafzdryXiaFa(entity, sessionBean);
			map.put(AppConst.STATUS, AppConst.SUCCESS);
			map.put(AppConst.MESSAGES, getUpdateSuccess());
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
			map.put(AppConst.STATUS, AppConst.FAIL);
			map.put(AppConst.MESSAGES, getUpdateFail()+e.getLocalizedMessage());
		}
		return map;
	}
	
	/**
	 * 根据重点人员数据ID获取对应的下发页面
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/viewXiaFa", method = RequestMethod.GET)
	public ModelAndView viewXiaFa(@RequestParam String id,@RequestParam String tabid) {
		ModelAndView mv = new ModelAndView("zdrygl/zdrySgafzdryXf");
		ZdrySgafzdryxxb model = this.zdrySgafzdryxxbService.queryById(id);
		mv.addObject("zdrySgafzdryxxb", model);
		mv.addObject("tabid", tabid);
		return mv;
	}
	
}
