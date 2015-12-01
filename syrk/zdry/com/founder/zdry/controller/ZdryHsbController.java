package com.founder.zdry.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
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
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.syrkgl.bean.SyrkSyrkxxzb;
import com.founder.zdry.bean.ZdryHsb;
import com.founder.zdry.bean.ZdryHsbZdls;
import com.founder.zdry.bean.ZdryYwspb;
import com.founder.zdry.bean.ZdryZdryzb;
import com.founder.zdry.service.ZdryHsbService;
import com.founder.zdry.service.ZdryYwspbService;
import com.founder.zdry.vo.ZdryVO;
import com.founder.syrkgl.dao.SyrkSyrkxxzbDao;
import com.google.gson.Gson;

/***
 * ****************************************************************************
 * 
 * @Package: [com.founder.zdry.controller.ZdryHsbController.java]
 * @ClassName: [ZdryHsbController]
 * @Description: [核实功能跳转controller]
 * @Author: [wu_chunhui@founder.com.cn]
 * @CreateDate: [2015-3-17 下午7:52:37]
 * @UpdateUser: [Administrator(如多次修改保留历史记录，增加修改记录)]
 * @UpdateDate: [2015-3-17 下午7:52:37，(如多次修改保留历史记录，增加修改记录)]
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]
 * @Version: [v1.0]
 */
@Controller
@RequestMapping("zdryHsb")
public class ZdryHsbController extends BaseController {
	private Logger logger = Logger.getLogger(this.getClass());
	@Resource(name = "zdryHsbService")
	private ZdryHsbService zdryHsbService;
	@Resource(name = "zdryYwspbService")
	private ZdryYwspbService zdryYwspbService;
	@Resource(name = "syrkSyrkxxzbDao")
	private SyrkSyrkxxzbDao syrkSyrkxxzbDao;
	

	/**
	 * @Title: query
	 * @Description: TODO(查询列表页面)
	 * @param @return 设定文件
	 * @return ModelAndView 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/query", method = RequestMethod.GET)
	public ModelAndView query() {
		ModelAndView mv = new ModelAndView("zdry/zdryHsbList");
		return mv;
	}

	/**
	 * 
	 * @Title: queryList
	 * @Description: 列表
	 * @param @param page
	 * @param @param rows
	 * @param @param entity
	 * @param @param sessionBean
	 * @param @return 设定文件
	 * @return EasyUIPage 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/queryList", method = RequestMethod.POST)
	public @ResponseBody
	EasyUIPage queryList(EasyUIPage page,
			@RequestParam(value = "rows") Integer rows, ZdryHsb entity,
			SessionBean sessionBean) {
		sessionBean = getSessionBean(sessionBean);
		page.setPagePara(rows);
		 EasyUIPage easyUIPage =zdryHsbService.queryList(entity, page, sessionBean);
		//这里查询是有人口ID，补全信息
		 List<?> zdryHsbList = easyUIPage.getRows();
		 for (int i = 0; i < zdryHsbList.size(); i++) {
			 SyrkSyrkxxzb quertEntity=null;
			 ZdryHsb zdryHsb= (ZdryHsb)zdryHsbList.get(i);
			 Map<String,String> map = new HashMap<String,String>();
			 map.put("zjhm", zdryHsb.getZjhm());
			 map.put("gxzrqdm", sessionBean.getUserOrgCode());
			 List<SyrkSyrkxxzb> list=syrkSyrkxxzbDao.queryHsbSyrkidByZjhm(map);
			 if(list.size()>0){
			 quertEntity=list.get(0);
			 }
			 if(!StringUtils.isBlank(quertEntity)){
				 zdryHsb.setSyrkid(quertEntity.getId());
				 zdryHsb.setRyid(quertEntity.getRyid());
			 }else{
				 zdryHsb.setSyrkid("");
				 zdryHsb.setRyid("");
			 }
		}
		 return easyUIPage;
	}

	/***
	 * 
	 * @Title: createLg
	 * @Description: TODO
	 * @author wu_chunhui@founder.com.cn
	 * @param @param ryid
	 * @param @return
	 * @return ModelAndView
	 * @throws
	 */
	@RequestMapping(value = "/createHsCg", method = RequestMethod.GET)
	public ModelAndView createHsLg(String zdryHsbId, ZdryYwspb zdryYwspb,
			String zdrygllxdm) {
		SessionBean sessionBean = getSessionBean();
		ModelAndView mv = new ModelAndView("zdry/zdryHsbCg");
		ZdryHsb zdryHsb = zdryHsbService.queryById(zdryHsbId);
		zdryYwspb.setSqr_id(sessionBean.getUserId());
		zdryYwspb.setSqr_xm(sessionBean.getUserName());
		zdryYwspb.setSqsj(DateUtils.getSystemDateString());
		mv.addObject("zdryHsb", zdryHsb);
		mv.addObject("zdryYwspb", zdryYwspb);
		mv.addObject("zdrygllxdm", zdrygllxdm);
		return mv;
	}

	/***
	 * 
	 * @Title: saveHsCg
	 * @Description: 核实撤管保存逻辑。
	 * @author wu_chunhui@founder.com.cn
	 * @param @return
	 * @return ModelAndView
	 * @throws
	 */
	@RequestMapping(value = "/saveHsCg", method = RequestMethod.POST)
	public ModelAndView saveHsCg(String zdryHsbId, ZdryYwspb zdryYwspb,
			SessionBean sessionBean) {
		ModelAndView mv = new ModelAndView("redirect:/forward/"
				+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		sessionBean = getSessionBean(sessionBean);
		try {
			ZdryHsb zdryHsb = zdryHsbService.queryById(zdryHsbId);
			zdryHsbService.saveHsCg(zdryHsb, zdryYwspb, sessionBean);
			model.put(AppConst.STATUS, AppConst.SUCCESS);
			model.put(AppConst.MESSAGES, "申请发起成功");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getLocalizedMessage(), e);
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, "申请发起失败");
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}

	/***
	 * 
	 * @Title: creatCgApporval
	 * @Description: TODO(撤管审批页面)
	 * @param @param zdryYwspbId
	 * @param @param messageid
	 * @param @param zdryHsbId
	 * @param @return 设定文件
	 * @return ModelAndView 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/creatCgApporval", method = RequestMethod.GET)
	public ModelAndView creatCgApporval(String zdryYwspbId, String messageid,
			String zdryHsbId) {
		ModelAndView mv = new ModelAndView("zdry/zdryLCApproval");
		SessionBean sessionBean = getSessionBean();
		ZdryYwspb zdryYwspb = zdryYwspbService.queryById(zdryYwspbId);
		zdryYwspb.setSpbm(sessionBean.getUserOrgCode());
		zdryYwspb.setSpr_id(sessionBean.getUserId());
		zdryYwspb.setSpr_xm(sessionBean.getUserName());
		zdryYwspb.setSpsj(DateUtils.getSystemDateString());
		ZdryHsb zdryHsb = zdryHsbService.queryById(zdryHsbId);
		ZdryVO zdryVO = new ZdryVO();
		ZdryZdryzb zdryZdryzb = new ZdryZdryzb();
		zdryZdryzb.setXm(zdryHsb.getXm());
		zdryZdryzb.setZjhm(zdryHsb.getZjhm());
		zdryZdryzb.setZdrygllxdm(zdryHsb.getZdrygllxdm());
		zdryVO.setZdryZdryzb(zdryZdryzb);
		zdryVO.setZdryYwspb(zdryYwspb);
		mv.addObject("zdryVO", zdryVO);
		mv.addObject("zdryHsbId", zdryHsbId);
		mv.addObject("messageid", messageid);
		return mv;
	}

	/***
	 * 
	 * @Title: saveApproval
	 * @Description: TODO(保存审批意见，发送反馈消息，修改记录状态)
	 * @param @param zdryYwspb
	 * @param @param messageid
	 * @param @param sessionBean
	 * @param @return 设定文件
	 * @return ModelAndView 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/saveApproval", method = RequestMethod.POST)
	public ModelAndView saveApproval(ZdryYwspb zdryYwspb, String messageid,
			SessionBean sessionBean) {
		ModelAndView mv = new ModelAndView("redirect:/forward/"
				+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		sessionBean = getSessionBean(sessionBean);
		try {
			zdryYwspb.setSpbm(sessionBean.getUserOrgCode());
			zdryYwspb.setSpr_id(sessionBean.getUserId());
			zdryYwspb.setSpr_xm(sessionBean.getUserName());
			zdryYwspb.setSpsj(DateUtils.getSystemDateString());
			zdryYwspbService.updateZdryYwspb(zdryYwspb, sessionBean, messageid);
			model.put(AppConst.STATUS, AppConst.SUCCESS);
			model.put(AppConst.MESSAGES, getUpdateSuccess());
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getLocalizedMessage(), e);
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, getUpdateFail());
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}

	/**
	 * @throws BussinessException
	 * @Title: hszd
	 * @Description: TODO(核实转递)
	 * @param @param id
	 * @param @return 设定文件
	 * @return ModelAndView 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/hszd", method = RequestMethod.GET)
	public ModelAndView hszd(String id) throws BussinessException {
		ModelAndView mv = new ModelAndView("zdry/zdryHszd");
		ZdryHsb zdryHsb = zdryHsbService.queryById(id);
		if (zdryHsb == null) {
			throw new BussinessException("重点人员核实表查询无数据！");
		}
		ZdryHsbZdls entity = new ZdryHsbZdls();
		entity.setHsid(id);
		entity.setYsspcs(zdryHsb.getSspcs());
		entity.setYdz_jzdzdm(zdryHsb.getDz_jzdzdm());
		entity.setYdz_jzdzmlpdm(zdryHsb.getDz_jzdzmlpdm());
		entity.setYdz_jzdzmlpxz(zdryHsb.getDz_jzdzmlpxz());
		entity.setYdz_jzdzssxdm(zdryHsb.getDz_jzdzssxdm());
		entity.setYdz_jzdzxz(zdryHsb.getDz_jzdzxz());
		mv.addObject("zdryHsb", zdryHsb);
		mv.addObject("entity", entity);
		return mv;
	}

	/**
	 * @Title: saveApproval
	 * @Description: TODO(核实转递保存)
	 * @param @param zdryYwspb
	 * @param @param messageid
	 * @param @param sessionBean
	 * @param @return 设定文件
	 * @return ModelAndView 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/saveHszd", method = RequestMethod.POST)
	public ModelAndView saveHszd(ZdryHsbZdls entity, SessionBean sessionBean) {
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		Map<String, Object> map = new HashMap<String, Object>();
		sessionBean = getSessionBean(sessionBean);
		try {
			zdryHsbService.saveHszd(entity, sessionBean);
			map.put(AppConst.STATUS, AppConst.SUCCESS);
			map.put(AppConst.MESSAGES, getAddSuccess());
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
			map.put(AppConst.STATUS, AppConst.FAIL);
			map.put(AppConst.MESSAGES, getAddFail());
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(map));
		return mv;
	}

}
