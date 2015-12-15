package com.founder.zdrygl.base.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.beanutils.MethodUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.founder.drools.base.zdry.service.ZdryRuleService;
import com.founder.framework.base.controller.BaseController;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.components.AppConst;
import com.founder.framework.exception.BussinessException;
import com.founder.framework.organization.department.service.OrgOrganizationService;
import com.founder.framework.organization.position.service.OrgPositionService;
import com.founder.framework.utils.DateUtils;
import com.founder.workflow.bean.StartProcessInstance;
import com.founder.zdrygl.base.model.ZdryZb;
import com.founder.zdrygl.base.service.ZdryEditService;
import com.founder.zdrygl.base.service.ZdryInfoQueryService;
import com.founder.zdrygl.base.service.wf.LcgFlagEnum;
import com.founder.zdrygl.base.service.wf.WorkFlowParametersInitialService;
import com.founder.zdrygl.base.vo.ZdryVO;
import com.founder.zdrygl.base.vo.ZdrygnVO;
import com.founder.zdrygl.base.vo.ZdryxxzsVO;
import com.founder.zdrygl.core.factory.ZdryAbstractFactory;
import com.founder.zdrygl.core.inteface.ZdryService;
import com.founder.zdrygl.core.model.ZOBean;
import com.founder.zdrygl.core.utils.ZdryConstant;
import com.google.gson.Gson;
/**
 * ****************************************************************************
 * @Package:      [com.founder.zdrygl.controller.ZdryEditController.java]  
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
@RequestMapping("zdryEdit")
public class ZdryEditController extends BaseController {
	
	@Resource(name="zdryEditService")
	private ZdryEditService zdryEditService;
	
	@Autowired
	public ZdryAbstractFactory zdryFactory;
	
	@Resource(name="zdryQueryService")
	private ZdryInfoQueryService zdryQueryService ;
	
	@Autowired
	private ZdryConstant zdryConstant;
	
	@Autowired
	private ZdryRuleService zdryRuleService;
	
	@Resource(name = "orgOrganizationService")
	private OrgOrganizationService orgOrganizationService;

	@Resource(name = "orgPositionService")
	private OrgPositionService orgPositionService;
	
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
	 * @Description: TODO(重点人员 具体子类 的查询方法)
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
	 * @Title: delete_xxzsnrb
	 * @Description: TODO(下方菜单 删除功能请求 页面)
	 * @param @param url
	 * @param @param id
	 * @param @return    设定文件
	 * @return ModelAndView    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/delete_xxzsnrb", method = RequestMethod.GET)
	public ModelAndView delete_xxzsnrb(String url, String id) {
		ModelAndView mv = new ModelAndView("zdrygl/edit/zdryDeleteEdit");
		mv.addObject("url", url);
		mv.addObject("id", id);
		return mv;
	}		
	
	/**
	 * 
	 * @Title: calcle_xxzsnrb
	 * @Description: TODO(下方菜单 删除功能请求)
	 * @param @param url
	 * @param @param id
	 * @param @param xt_zxyy
	 * @param @return    设定文件
	 * @return ModelAndView    返回类型
	 * @throws
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
	 * 
	 * @Title: zdryUpdatePre
	 * @Description: TODO(重点人员编辑更新初始页)
	 * @param @param zdryid
	 * @param @param sessionBean
	 * @param @return
	 * @param @throws BussinessException    设定文件
	 * @return ModelAndView    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/zdryUpdatePre", method = RequestMethod.GET)
	public ModelAndView zdryUpdatePre( String zdryid,
			SessionBean sessionBean) throws BussinessException {
			ModelAndView mv = new ModelAndView("zdrygl/edit/zdryUpdate");
			
			ZdryZb zdryZb = (ZdryZb)zdryQueryService.queryById(zdryid);
			
			ZdryVO zdryVO = new ZdryVO();			
			zdryVO.setZdryZdryzb(zdryZb);
			zdryVO.setZdryZb(zdryZb.getZdrygllxdm(),zdryQueryService.queryZdryzbById(zdryid,zdryZb.getZdrygllxdm()));
//			ZdryService zdryService = zdryFactory.createZdryService(zdryZb.getZdrygllxdm(), null, null);
//			zdryService.queryZdryAllInfo(zdryid);
			mv.addObject("zdryVO", zdryVO);
			return mv;
	}
	
	@RequestMapping(value = "/zdryUpdate", method = RequestMethod.POST)
	public ModelAndView zdryUpdate(ZdryVO zdryVO, SessionBean sessionBean,@RequestParam(value="uploadFile") CommonsMultipartFile[] uploadFile) {
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		Map<String, Object> model = new HashMap<String, Object>();
		sessionBean = getSessionBean(sessionBean);
		try {
//			ZdryService zdryService = zdryFactory.createZdryService(zdryVO.getZdryZdryzb().getZdrygllxdm(), zdryVO.getZdryZdryzb(), zdryVO.getZdrylbdx());
			ZdryService zdryService = zdryFactory.createZdryService(zdryVO.getZdryZdryzb().getZdrygllxdm());
			ZOBean entity = new ZOBean(zdryVO.getZdryZdryzb(), zdryVO.getZdrylbdx());
			entity.getZdrylbdx().setId(zdryVO.getZdryZdryzb().getId());
			zdryService.update(sessionBean,entity);
			
			model.put(AppConst.STATUS, AppConst.SUCCESS);
			model.put(AppConst.MESSAGES, getUpdateSuccess());
		}catch(BussinessException e){
			e.printStackTrace();			
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, e.getLocalizedMessage());
		}
		catch (Exception e) {
			e.printStackTrace();			
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, getUpdateFail());
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}
	
	/**
	 * 
	 * @Title: zdryZLPre
	 * @Description: TODO(重点人员转类 载入页面)
	 * @param @param zdryid
	 * @param @param sessionBean
	 * @param @return
	 * @param @throws BussinessException    设定文件
	 * @return ModelAndView    返回类型
	 * @throws
	 *
	@RequestMapping(value = "/zdryZLPre", method = RequestMethod.GET)
	public ModelAndView zdryZLPre( String id,
			SessionBean sessionBean) throws BussinessException {
			ModelAndView mv = new ModelAndView("zdrygl/edit/zdryZL");
			ZdryVO zdryVO =zdryEditService.queryZdryAllInfo(id);			
			String glzt=zdryVO.getZdryZdryzb().getGlzt();
			boolean sfkzl=false;
			String errorMsg="该 重点人员管理类型 不可转类";
			try{
				//验证状态是否正确
				zdryUntil.validateState(glzt);		
				sfkzl=zdryEditService.queryIsZL(zdryVO.getZdryZdryzb().getZdrygllxdm());//是否可转类
			}catch(Exception e){
				errorMsg=e.getLocalizedMessage();
			}			
			
			mv.addObject("errorMsg",errorMsg);
			mv.addObject("sfkzl",sfkzl);
			mv.addObject("zdryVO", zdryVO);
			return mv;
	}
	
	/**
	 * 
	 * @Title: zdryZL
	 * @Description: TODO(重点人员转类)
	 * @param @param zdryVO
	 * @param @param sessionBean
	 * @param @param uploadFile
	 * @param @return    设定文件
	 * @return ModelAndView    返回类型
	 * @throws
	 *
	@RequestMapping(value = "/zdryZL", method = RequestMethod.POST)
	public ModelAndView zdryZL(ZdryVO zdryVO, SessionBean sessionBean,String xzdrylbmc) {
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		Map<String, Object> model = new HashMap<String, Object>();
		sessionBean = getSessionBean(sessionBean);
		try {
			zdryVO.getZdryZdryzb().setGlzt("7");//转类申请中
			String zdrylb=zdryVO.getZdryZdryzb().getZdrylb();
			zdryVO.getZdryZdryzb().setZdrylb(null);//此时不修改小类，审批通过后修改
			zdryEditService.zdryZl(zdryVO,sessionBean);
			zdryVO.getZdryZdryzb().setZdrylb(zdrylb);//后续流程取用
			
			Map<String, Object> variables =  new HashMap<String, Object>();
			String  lrrzrq= sessionBean.getUserOrgCode();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String createTime=formatter.format(new Date());//申请时间
			variables.put("createTime", createTime);
			variables.put("lrrzrq", lrrzrq);//录入人管辖责任区
	 		variables.put("zdryId", zdryVO.getZdryZdryzb().getId()); //重点人员总表Id
			variables.put("zdrylxmc", zdryVO.getZdryZdryzbVO().getZdrygllxmc());//人员类型名称	
			variables.put("yzdrylbmc", zdryVO.getZdryZdryzbVO().getZdrylbmc());//转递前类型
			variables.put("xzdrylbmc", xzdrylbmc);//转递后类型
			variables.put("xzdrylb", zdryVO.getZdryZdryzb().getZdrylb());//转递后类型
			
			variables.put("xm", zdryVO.getZdryZdryzbVO().getXm());//被列管人员姓名
			variables.put("zjhm", zdryVO.getZdryZdryzbVO().getZjhm());//证件号码
			variables.put("sqlx", "重点人口转类");//申请类型	  			
		    variables.put("sqyj", zdryVO.getYwsqyy());//申请意见		
			variables.put("sqlxdm", "03");//列管01  撤管02 专类03
			variables.put("approvalMethod", "szzlApproval");
			variables.put("sqyj", "申请将"+zdryVO.getZdryZdryzbVO().getXm()+"转换重点人员类别");
			
			processDefinitionService.startProcessInstance(sessionBean.getUserId(), "zdryzl", zdryVO.getZdryZdryzb().getId(), variables);	

			
			model.put(AppConst.STATUS, AppConst.SUCCESS);
			model.put(AppConst.MESSAGES, getUpdateSuccess());
		}catch(BussinessException e){
			e.printStackTrace();			
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, e.getLocalizedMessage());
		}
		catch (Exception e) {
			e.printStackTrace();			
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, getUpdateFail());
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}
	*/
	/**
	 * 
	 * @Title: zdryFjUploadPre
	 * @Description: TODO(重点人员附件上传页面)
	 * @param @param zdryid
	 * @param @param sessionBean
	 * @param @return
	 * @param @throws BussinessException    设定文件
	 * @return ModelAndView    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/zdryFjUploadPre", method = RequestMethod.GET)
	public ModelAndView zdryFjUploadPre( String zdryid,
			SessionBean sessionBean) throws BussinessException {
			ModelAndView mv = new ModelAndView("zdrygl/edit/zdryFjUploadPre");
			mv.addObject("lybm", "ZDRY_ZDRYZB");
			mv.addObject("lyid", zdryid);
			mv.addObject("lyms", "重点人员-附件");
			mv.addObject("fileType", "");
			mv.addObject("fileOnly", 0);			
			return mv;
	}		
	
	/**
	 * 
	 * @Title: zdryZLPre
	 * @Description: TODO(重点人员转类 载入页面)
	 * @param @param zdryid
	 * @param @param sessionBean
	 * @param @return
	 * @param @throws BussinessException    设定文件
	 * @return ModelAndView    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/zdryZLPre", method = RequestMethod.GET)
	public ModelAndView zdryZLPre( String id,
			SessionBean sessionBean) throws BussinessException {
			ModelAndView mv = new ModelAndView("zdrygl/edit/zdryZL");
			ZdryZb zdryZb=(ZdryZb)zdryQueryService.queryById(id);		
			if(zdryZb==null){
				throw new BussinessException("未查询到该重点人员的信息");
			}
			//验证状态是否正确
			if(!ZdryConstant.YLG.equals(zdryZb.getGlzt())){
				throw new BussinessException("该重点人员正在【"+zdryConstant.getGlztStr(zdryZb.getGlzt())+"】，不能办理其他业务");
			}						
			
			boolean sfkzl=zdryRuleService.getSfkzl(zdryZb.getZdrygllxdm());//是否可转类
			if(!sfkzl)
				throw new BussinessException("该 重点人员管理类型 不可转类");
			

			ZdryVO vo = new ZdryVO();
			vo.setZdryZdryzb(zdryZb);						
			mv.addObject("zdryZb", vo);
			mv.addObject("zdrylxmc", zdryConstant.zdryDict().get(zdryZb.getZdrygllxdm()));
			return mv;
	}
	
	/**
	 * 
	 * @Title: zdryZL
	 * @Description: TODO(重点人员转类)
	 * @param @param zdryVO
	 * @param @param sessionBean
	 * @param @param uploadFile
	 * @param @return    设定文件
	 * @return ModelAndView    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/zdryZL", method = RequestMethod.POST)
	public ModelAndView zdryZL(ZdryVO zdryZb, SessionBean sessionBean,String xzdrylbmc) {
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		Map<String, Object> model = new HashMap<String, Object>();
		sessionBean = getSessionBean(sessionBean);
		try {			
			//只传入了ID和zdrylb两个字段
			String zdrygllxdm = zdryZb.getZdryZdryzb().getZdrygllxdm();// 重点人员类型
			WorkFlowParametersInitialService wfpis = new WorkFlowParametersInitialService(zdryConstant,zdryQueryService);
			StartProcessInstance spi = wfpis.initialProcessInstance(sessionBean,zdryZb,LcgFlagEnum.ZL);
			ZdryService zdryService = zdryFactory.createZdryService(zdrygllxdm);
			ZOBean entity = new ZOBean(zdryZb.getZdryZdryzb(), zdryZb.getZdrylbdx());
			entity.setStartProcessInstance(spi);
			
//			zdryService.setStartProcessInstance(spi.getProcessKey(), spi.getApplyUserId(),spi.getVariables());	
			zdryService.zl(sessionBean,entity);
			
			model.put(AppConst.STATUS, AppConst.SUCCESS);
			model.put(AppConst.MESSAGES, getUpdateSuccess());
		}catch(BussinessException e){
			e.printStackTrace();			
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, e.getLocalizedMessage());
		}
		catch (Exception e) {
			e.printStackTrace();			
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, getUpdateFail());
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}
	
	@RequestMapping(value = "/fjEdit", method = RequestMethod.GET)
	public ModelAndView fjEdit(String zdryid) {
		ModelAndView mv = new ModelAndView("zpfj/fjEdit");
		mv.addObject("lybm", "ZDRY_ZDRYZB");
		mv.addObject("lyid", zdryid);
		mv.addObject("lyms", "重点人员-附件");
		mv.addObject("fileType", "");
		mv.addObject("fileOnly", 0);
		return mv;
	}
	
	/*
	@RequestMapping(value = "/query", method = RequestMethod.POST)
	public @ResponseBody List<ZpfjFjxxb> query(String ryid){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", ryid);
		List<ZpfjFjxxb> fjxx = zdryEditService.fjxx_query(map);
		return fjxx;
	}
	*/
}
