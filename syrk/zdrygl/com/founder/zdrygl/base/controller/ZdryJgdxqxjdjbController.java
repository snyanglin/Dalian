package com.founder.zdrygl.base.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.founder.framework.base.controller.BaseController;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.components.AppConst;
import com.founder.framework.exception.BussinessException;
import com.founder.framework.utils.DateUtils;
import com.founder.workflow.bean.StartProcessInstance;
import com.founder.workflow.service.inteface.JProcessDefinitionService;
import com.founder.zdrygl.base.model.ZdryJgdxqxjdjb;
import com.founder.zdrygl.base.service.ZdryInfoQueryService;
import com.founder.zdrygl.base.service.ZdryJgdxqxjdjbService;
import com.founder.zdrygl.base.service.wf.LcgFlagEnum;
import com.founder.zdrygl.base.service.wf.WorkFlowParametersInitialService;
import com.founder.zdrygl.base.vo.ZdryVO;
import com.founder.zdrygl.core.model.Zdry;
import com.founder.zdrygl.core.utils.ZdryConstant;
import com.google.gson.Gson;

@Controller
@RequestMapping(value = "zdryJgdxqxjdjb")
public class ZdryJgdxqxjdjbController extends BaseController {

	private Logger logger = Logger.getLogger(this.getClass());

	@Autowired
	private ZdryConstant zdryConstant;

	@Resource(name = "zdryJgdxqxjdjbService")
	private ZdryJgdxqxjdjbService zdryJgdxqxjdjbService;

	@Resource(name = "zdryQueryService")
	private ZdryInfoQueryService zdryQueryService;
	
    @Autowired
	private JProcessDefinitionService processDefinitionService;
	
	/**
	 * 
	 * @Title: add
	 * @Description: TODO(新增 页面)
	 * @param @param id
	 * @param @return    设定文件
	 * @return ModelAndView    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView add(String zdryid) {
		ModelAndView mv = new ModelAndView("zdrygl/edit/zdryJgdxqxjdjbAdd");
		ZdryJgdxqxjdjb entity = new ZdryJgdxqxjdjb();
		entity.setZdryid(zdryid);
		ZdryVO vo = new ZdryVO();
		vo.setZdryJgdxqxjdjb(entity);
		mv.addObject("entity", vo);
		return mv;
	}
	
	/**
	 * 
	 * @Title: save
	 * @Description: TODO(新增 保存数据)
	 * @param @param entity
	 * @param @param sessionBean
	 * @param @return    设定文件
	 * @return ModelAndView    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(ZdryVO zdryVO, SessionBean sessionBean,String xm,String sfzh) {
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		Map<String, Object> map = new HashMap<String, Object>();
		sessionBean = getSessionBean(sessionBean);
		if(!zdryJgdxqxjdjbService.sfnqj(zdryVO.getZdryJgdxqxjdjb().getZdryid())){
			map.put(AppConst.STATUS, AppConst.FAIL);
			map.put(AppConst.MESSAGES, "该重点人员还有未销假的请假申请，不能再请假");
			mv.addObject(AppConst.MESSAGES, new Gson().toJson(map));
			return mv;
		}
		try {
			Zdry zdryzb = zdryQueryService.queryById(zdryVO.getZdryJgdxqxjdjb().getZdryid());
			zdryJgdxqxjdjbService.save(zdryVO.getZdryJgdxqxjdjb(), sessionBean);
			// start process
			WorkFlowParametersInitialService wfpis = new WorkFlowParametersInitialService(zdryConstant,zdryQueryService);
			StartProcessInstance spi = wfpis.initialProcessInstance(sessionBean, zdryVO,LcgFlagEnum.QXJ);
			spi.getVariables().put("zdryZb", zdryzb);
			spi.getVariables().put("jgdx", zdryVO.getZdryJgdxqxjdjb());
			processDefinitionService.startProcessInstance(spi.getApplyUserId(),spi.getProcessKey(), spi.getBusinessKey(), spi.getVariables());
			
			map.put(AppConst.STATUS, AppConst.SUCCESS);
			map.put(AppConst.MESSAGES, getAddSuccess());
			map.put(AppConst.SAVE_ID, "" + zdryVO.getZdryJgdxqxjdjb().getId()); // 返回主键
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
			map.put(AppConst.STATUS, AppConst.FAIL);
			map.put(AppConst.MESSAGES, getAddFail());
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(map));
		return mv;
	}
		
	/**
	 * 
	 * @Title: queryDetail
	 * @Description: TODO(根据ID 查询详情)
	 * @param @param id
	 * @param @return    设定文件
	 * @return ModelAndView    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/queryDetail", method = RequestMethod.GET)
	public ModelAndView queryDetail(String id) {		
		ModelAndView mv = new ModelAndView("zdrygl/edit/zdryJgdxqxjdjbInfo");
		ZdryVO vo = new ZdryVO();
		vo.setZdryJgdxqxjdjb(zdryJgdxqxjdjbService.queryById(id));
		mv.addObject("entity",vo);
		return mv;
	}
	
	/**
	 * 
	 * @Title: update
	 * @Description: TODO(更新)
	 * @param @param entity
	 * @param @param sessionBean
	 * @param @return    设定文件
	 * @return ModelAndView    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/{id}", method = { RequestMethod.POST,
			RequestMethod.PUT })
	public ModelAndView update(ZdryVO zdryVO, SessionBean sessionBean) {
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		Map<String, Object> map = new HashMap<String, Object>();
		sessionBean = getSessionBean(sessionBean);
		try {
			zdryJgdxqxjdjbService.update(zdryVO.getZdryJgdxqxjdjb(), sessionBean);
			map.put(AppConst.STATUS, AppConst.SUCCESS);
			map.put(AppConst.MESSAGES, getUpdateSuccess());
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
			map.put(AppConst.STATUS, AppConst.FAIL);
			map.put(AppConst.MESSAGES, getUpdateFail());
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(map));
		return mv;
	}
	/**
	 * @Title: edit
	 * @Description: TODO(审批页面)
	 * @param @param id
	 * @param @return
	 * @param @throws BussinessException 设定文件
	 * @return ModelAndView 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/sp", method = RequestMethod.GET)
	public ModelAndView sp(String id, Long messageid, SessionBean sessionBean)
			throws BussinessException {
		ModelAndView mv = new ModelAndView("zdry/zdryJgdxqxjdjbSp");
		ZdryJgdxqxjdjb entity = zdryJgdxqxjdjbService.queryById(id);
		if (entity == null) {
			throw new BussinessException("查询无数据！");
		}
		Zdry zdryzb = zdryQueryService.queryById(entity.getZdryid());
		mv.addObject("zdryZdryzb", zdryzb);
		sessionBean = getSessionBean(sessionBean);
		entity.setSpr_id(sessionBean.getUserId());
		entity.setSpr_xm(sessionBean.getUserName());
		entity.setSpsj(DateUtils.getSystemDateString());
		entity.setMessageid(messageid);
		mv.addObject("entity", entity);
		return mv;
	}

	/**
	 * @Title: update
	 * @Description: TODO(审批保存)
	 * @param @param entity
	 * @param @param sessionBean
	 * @param @return 设定文件
	 * @return ModelAndView 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/updateSp", method = RequestMethod.POST)
	public ModelAndView updateSp(ZdryJgdxqxjdjb entity, SessionBean sessionBean) {
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		Map<String, Object> map = new HashMap<String, Object>();
		sessionBean = getSessionBean(sessionBean);
		try {
			zdryJgdxqxjdjbService.updateSp(entity, sessionBean);
			map.put(AppConst.STATUS, AppConst.SUCCESS);
			map.put(AppConst.MESSAGES, "审批成功！");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
			map.put(AppConst.STATUS, AppConst.FAIL);
			map.put(AppConst.MESSAGES, "审批失败！");
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(map));
		return mv;
	}
	
}
