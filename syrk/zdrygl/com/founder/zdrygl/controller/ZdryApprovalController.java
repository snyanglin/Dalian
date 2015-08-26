package com.founder.zdrygl.controller;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.founder.framework.base.controller.BaseController;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.components.AppConst;
import com.founder.framework.organization.department.bean.OrgOrganization;
import com.founder.framework.organization.department.service.OrgOrganizationService;
import com.founder.framework.organization.position.service.OrgPositionService;
import com.founder.framework.organization.user.service.OrgUserService;
import com.founder.framework.utils.EasyUIPage;
import com.founder.syrkgl.service.SyrkSyrkxxzbService;
import com.founder.workflow.bean.JTask;
import com.founder.workflow.service.inteface.JProcessDefinitionService;
import com.founder.workflow.service.inteface.JProcessManageService;
import com.founder.workflow.service.inteface.JTaskService;
import com.founder.zdrygl.bean.ZdryZdryzb;
import com.founder.zdrygl.service.ZdryZdryzbService;
import com.founder.zdrygl.vo.ZdryWorkflowVO;
import com.google.gson.Gson;

/**
 * ****************************************************************************
 * @Package:      [com.founder.zdrygl.controller.ZdryApprovalController.java]  
 * @ClassName:    [ZdryApprovalController]   
 * @Description:  [一句话描述该类的功能]   
 * @Author:       [he_minxi@founder.com.cn]  
 * @CreateDate:   [2015年8月4日 上午11:04:18]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015年8月4日 上午11:04:18，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Controller
@RequestMapping("zdryApproval")
public class ZdryApprovalController extends BaseController {
	private Logger logger = Logger.getLogger(this.getClass());
	

	@Autowired
	private JProcessDefinitionService processDefinitionService;

	@Autowired
	private JProcessManageService processManageService;

	@Autowired
	private JTaskService taskService;

	
	@Resource(name="zdryZdryzbService")
	private ZdryZdryzbService zdryZdryzbService;
	
	
	
	@Resource(name="syrkSyrkxxzbService")
	private SyrkSyrkxxzbService syrkSyrkxxzbService;
	
	
	@Resource(name = "orgUserService")
	private OrgUserService orgUserService;

	
	@Resource(name = "orgOrganizationService")
	private OrgOrganizationService orgOrganizationService;
	
	@Resource(name = "orgPositionService")
	private OrgPositionService orgPositionService;
	/**
	 * 
	 * @Title: zdryApproval
	 * @Description: TODO(流程审批通用页面)
	 * @param @param zdryId
	 * @param @param workflowId
	 * @param @param approvalMethod
	 * @param @return    设定文件
	 * @return ModelAndView    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/zdryApproval", method = RequestMethod.GET)
	public ModelAndView zdryApproval(String executionId,String workflowId) {
		ModelAndView mv = new ModelAndView("zdrygl/zdryApproval");
		

		String approvalMethod=(String)processDefinitionService.getVariables(executionId).get("approvalMethod");
		
		mv.addObject("workflowId", workflowId);
		mv.addObject("executionId", executionId);
		mv.addObject("approvalMethod", approvalMethod);
		return mv;
	}
	
	
	
	
	
	/**
	 * 
	 * @Title: getZdryXx
	 * @Description: TODO(流程审批通用页面根据executionId获取重点人员信息流程信息)
	 * @param @param executionId
	 * @param @return    设定文件
	 * @return Map    返回类型
	 * @throws
	 */
	
	@RequestMapping(value = "/getZdryXx", method = RequestMethod.POST)
	public @ResponseBody
		Map getZdryXx(String executionId) {
		Map<String, Object> model = new HashMap<String, Object>();
		Map<String, Object> workflowXx = new HashMap<String, Object>();
		workflowXx=processDefinitionService.getVariables(executionId);
		
		ZdryZdryzb zdryZdryzb = zdryZdryzbService.queryById((String)workflowXx.get("zdryId"));
		
		model.put("workflowXx", workflowXx);
		model.put("zdryZdryzb", zdryZdryzb);

		return model;
	}

	
	/**
	 * @Title: query
	 * @Description: TODO(重点人员待审批页面)
	 * @param @return 设定文件
	 * @return ModelAndView 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/query", method = RequestMethod.GET)
	public ModelAndView query(SessionBean sessionBean) {
		ModelAndView mv = new ModelAndView("zdrygl/zdrySpList");
		
		
		return mv;
	}
	/**
	 * 
	 * @Title: queryList
	 * @Description: TODO(重点人员待审批列表)
	 * @param @param page
	 * @param @param rows
	 * @param @param entity
	 * @param @param sessionBean
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	
	@RequestMapping(value = "/queryList", method = RequestMethod.POST)
	public @ResponseBody
	EasyUIPage queryList(EasyUIPage page,
			@RequestParam(value = "rows") Integer rows,ZdryWorkflowVO entity,
			SessionBean sessionBean) {
			page.setPagePara(rows);

			sessionBean = getSessionBean(sessionBean);
			String taskParameter=sessionBean.getUserOrgCode()+"_"+sessionBean.getPositionId();//当前登陆者部门或岗位信息
			
			String FXJZAYWZGPositionId=orgPositionService.queryByPosid("FXJZAYWZG").getId().toString();
			String FXJGLYPositionId=orgPositionService.queryByPosid("FXJGLY").getId().toString();
			String sessionPositionId=sessionBean.getPositionId();
			
			
			
			if(FXJZAYWZGPositionId.equals(sessionPositionId)||FXJGLYPositionId.equals(sessionPositionId)){//岗位类型为业务部门
				
				String fsxOrgCode =orgOrganizationService.queryUpOrgByLevel(sessionBean.getUserOrgCode(),"21").getOrgcode();//  得到本名等级为二级分市县公安局部门code	
				
				taskParameter=fsxOrgCode+"_"+sessionBean.getPositionId();
			}
			
			
			
			List<JTask> tasks = taskService.findTodoTasks(taskParameter);
			List<ZdryWorkflowVO> zdryWorkflowList= new ArrayList();
			for (int i = 0; i < tasks.size(); i++) {
				ZdryWorkflowVO zdryWorkflowVO=new ZdryWorkflowVO();
				JTask task = tasks.get(i);
				
				String zdrylx =(String)processDefinitionService.getVariables(task.getExecutionId()).get("zdrylx");
				String approvalMethod =(String)processDefinitionService.getVariables(task.getExecutionId()).get("approvalMethod");
				String sqrId=(String)processDefinitionService.getVariables(task.getExecutionId()).get("applyUserId");//申请人ID
			    String createTime=(String)processDefinitionService.getVariables(task.getExecutionId()).get("createTime");
				String sqlx=(String)processDefinitionService.getVariables(task.getExecutionId()).get("sqlx");//申请类型
				String sqlxdm=(String)processDefinitionService.getVariables(task.getExecutionId()).get("sqlxdm");//申请类型
				String zdryId=(String)processDefinitionService.getVariables(task.getExecutionId()).get("zdryId");//人员USERID
				String zdryName=(String)processDefinitionService.getVariables(task.getExecutionId()).get("xm");//人员USERID
				String sqrName=orgUserService.queryByUserid(sqrId).getUsername();
				
			
				zdryWorkflowVO.setWorkflowId(task.getId());
				zdryWorkflowVO.setExecutionId(task.getExecutionId());
				zdryWorkflowVO.setZdrylx(zdrylx);
				zdryWorkflowVO.setSqrId(sqrId);
				zdryWorkflowVO.setCreateTime(createTime);
				zdryWorkflowVO.setSqlx(sqlx);
				zdryWorkflowVO.setSqlxdm(sqlxdm);
				zdryWorkflowVO.setZdryId(zdryId);
				zdryWorkflowVO.setZdryName(zdryName);
				zdryWorkflowVO.setSqrName(sqrName);
				zdryWorkflowVO.setApprovalMethod(approvalMethod);
				zdryWorkflowList.add(zdryWorkflowVO);
			}
			 
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("begin", page.getBegin());
				map.put("end", page.getEnd());
				String sort = page.getSort();
				String order = page.getOrder();
				map.put("sort", sort);
				map.put("order", order);
				map.put("zdryWorkflowVO", entity);
				page.setTotal(tasks.size());
				page.setRows(zdryWorkflowList);
		
		 return page;
	}
	/**
	 * 
	 * @Title: mjApproval
	 * @Description: TODO(责任区民警审批)
	 * @param @param zdryWorkflowVO
	 * @param @param sessionBean
	 * @param @return    设定文件
	 * @return ModelAndView    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/mjApproval", method = RequestMethod.POST)
	public ModelAndView mjApproval(ZdryWorkflowVO zdryWorkflowVO,SessionBean sessionBean) {
		
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		sessionBean = getSessionBean(sessionBean);
		Map<String, Object> model = new HashMap<String, Object>();
		try {
	
		Map<String, Object> variables =  new HashMap<String, Object>();
		
		
		
		if(zdryWorkflowVO.getSpjg().equals("1")){//同意
			
			String fsxOrgCode =orgOrganizationService.queryUpOrgByLevel(sessionBean.getUserOrgCode(),"32").getOrgcode();//  得到本名等级为三级，派出所部门code
			String taskParameter=fsxOrgCode+"_"+orgPositionService.queryByPosid("SZ").getId().toString();   //部门code+所长岗位ID
			variables.put("sz", taskParameter);
			variables.put("approvalMethod", "szApproval");
		
		}
		variables.put("spyj", zdryWorkflowVO.getSpyj());
		variables.put("approvedType", zdryWorkflowVO.getSpjg());
		
		taskService.completeTask(zdryWorkflowVO.getWorkflowId(), variables);  //执行任务
		model.put(AppConst.STATUS, AppConst.SUCCESS);
		model.put(AppConst.MESSAGES, "已审批！");
		} catch (Exception e) {
		logger.error(e.getLocalizedMessage(), e);
		model.put(AppConst.STATUS, AppConst.FAIL);
		model.put(AppConst.MESSAGES, "审批失败！");
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}
	/**
	 * 
	 * @Title: szApproval
	 * @Description: TODO(所长审批)
	 * @param @param zdryWorkflowVO
	 * @param @param sessionBean
	 * @param @return    设定文件
	 * @return ModelAndView    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/szApproval", method = RequestMethod.POST)
	public ModelAndView szApproval(ZdryWorkflowVO zdryWorkflowVO,SessionBean sessionBean) {
		
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		sessionBean = getSessionBean(sessionBean);
		Map<String, Object> model = new HashMap<String, Object>();
		try {

		Map<String, Object> variables =  new HashMap<String, Object>();
		if(zdryWorkflowVO.getSpjg().equals("0")){//拒绝
			
			
			variables.put("szApprovedType", "0");
			
			}
		
		else{//同意
			if(zdryWorkflowVO.getZdrylx().equals("01")||zdryWorkflowVO.getZdrylx().equals("02")||zdryWorkflowVO.getZdrylx().equals("04")){//所长审批同意流程结束
				
			variables.put("szApprovedType", "1");	
			}
			
			else{//同意并提交到分县局管理员或分县局治安业务主管
			
				String fsxOrgCode =orgOrganizationService.queryUpOrgByLevel(sessionBean.getUserOrgCode(),"21").getOrgcode();//  得到本名等级为二级分市县公安局部门code
				String Posid="FXJGLY";
				if(zdryWorkflowVO.getZdrylx().equals("03")){//肇事肇祸精神病人
					Posid="FXJZAYWZG";
				}
				if(zdryWorkflowVO.getZdrylx().equals("08")){//涉枪涉爆重点人员
					Posid="FXJGLY";
				}
				String taskParameter=fsxOrgCode+"_"+orgPositionService.queryByPosid(Posid).getId().toString();   //部门code+岗位ID
		
				variables.put("fxjzg", taskParameter);
				variables.put("approvalMethod", "fxjzgApproval");
				variables.put("szApprovedType", "2");	
			}
		}
		
		variables.put("spyj", zdryWorkflowVO.getSpyj());
		taskService.completeTask(zdryWorkflowVO.getWorkflowId(), variables);  //执行任务
		model.put(AppConst.STATUS, AppConst.SUCCESS);
		model.put(AppConst.MESSAGES, "已审批！");
		} catch (Exception e) {
		logger.error(e.getLocalizedMessage(), e);
		model.put(AppConst.STATUS, AppConst.FAIL);
		model.put(AppConst.MESSAGES, "审批失败！");
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));

		return mv;
	}
	/**
	 * 
	 * @Title: fxjzgApproval
	 * @Description: TODO(分县局管理员或分县局治安业务主管审批)
	 * @param @param zdryWorkflowVO
	 * @param @param sessionBean
	 * @param @return    设定文件
	 * @return ModelAndView    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/fxjzgApproval", method = RequestMethod.POST)
	public ModelAndView fxjzgApproval(ZdryWorkflowVO zdryWorkflowVO,SessionBean sessionBean) {
		
		sessionBean = getSessionBean(sessionBean);
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		Map<String, Object> model = new HashMap<String, Object>();
		try {
		Map<String, Object> variables =  new HashMap<String, Object>();
		variables.put("spyj", zdryWorkflowVO.getSpyj());
		variables.put("fxjzgApprovedType", zdryWorkflowVO.getSpjg());
		taskService.completeTask(zdryWorkflowVO.getWorkflowId(), variables);  //执行任务
		model.put(AppConst.STATUS, AppConst.SUCCESS);
		model.put(AppConst.MESSAGES, "已审批！");
		} catch (Exception e) {
		logger.error(e.getLocalizedMessage(), e);
		model.put(AppConst.STATUS, AppConst.FAIL);
		model.put(AppConst.MESSAGES, "审批失败！");
	}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}
	
	/**
	 * 
	 * @Title: sgafApproval
	 * @Description: (涉公安访所长审批)
	 * @param @param zdryWorkflowVO
	 * @param @param sessionBean
	 * @param @return    设定文件
	 * @return ModelAndView    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/sgafApproval", method = RequestMethod.POST)
	public ModelAndView sgafApproval(ZdryWorkflowVO zdryWorkflowVO,SessionBean sessionBean) {
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		sessionBean = getSessionBean(sessionBean);
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			Map<String, Object> variables =  new HashMap<String, Object>();
			variables.put("approved", "1".equals(zdryWorkflowVO.getSpjg()));
			variables.put("spr", sessionBean.getUserName());
			variables.put("spbm", sessionBean.getUserOrgName());
			
			OrgOrganization orgOrganization = orgOrganizationService.queryUpOrgByLevel(sessionBean.getUserOrgCode(),"21");	
			String fsxOrgCode = orgOrganization.getOrgcode(); 
			String taskParameter = fsxOrgCode+"_"+orgPositionService.queryByPosid("FXJSGAFYWZG").getId().toString();  
			variables.put("approvalMethod", "sgafApproval2");
			variables.put("ywzgsp", taskParameter);
//			taskService.claimTask(zdryWorkflowVO.getWorkflowId(), sessionBean.getUserId());  //接收任务
			taskService.completeTask(zdryWorkflowVO.getWorkflowId(), variables);  //执行任务
			model.put(AppConst.STATUS, AppConst.SUCCESS);
			model.put(AppConst.MESSAGES, "已审批！");
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage(), e);
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, "审批失败！");
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}
	
	/**
	 * 
	 * @Title: sgafApproval2
	 * @Description: (涉公安访业务主管审批)
	 * @param @param zdryWorkflowVO
	 * @param @param sessionBean
	 * @param @return    设定文件
	 * @return ModelAndView    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/sgafApproval2", method = RequestMethod.POST)
	public ModelAndView sgafApproval2(ZdryWorkflowVO zdryWorkflowVO,SessionBean sessionBean) {
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		sessionBean = getSessionBean(sessionBean);
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			Map<String, Object> variables =  new HashMap<String, Object>();
			variables.put("approved", "1".equals(zdryWorkflowVO.getSpjg()));
			variables.put("spr", sessionBean.getUserName());
			variables.put("spbm", sessionBean.getUserOrgName());
			taskService.completeTask(zdryWorkflowVO.getWorkflowId(), variables);  //执行任务
			model.put(AppConst.STATUS, AppConst.SUCCESS);
			model.put(AppConst.MESSAGES, "已审批！");
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage(), e);
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, "审批失败！");
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}
	
	
	/**
	 * 涉环保重口一级审批
	 * @param zdryWorkflowVO
	 * @param sessionBean
	 * @return
	 */
	@RequestMapping(value = "/shbApproval", method = RequestMethod.POST)
	public ModelAndView shbApproval(ZdryWorkflowVO zdryWorkflowVO,SessionBean sessionBean) {
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		sessionBean = getSessionBean(sessionBean);
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			Map<String, Object> variables =  new HashMap<String, Object>();
			variables.put("approved", "1".equals(zdryWorkflowVO.getSpjg()));
			variables.put("approvalMethod", "shbApproval2");	
			variables.put("splevel", "2");			

			taskService.completeTask(zdryWorkflowVO.getWorkflowId(), variables);  //执行任务
			model.put(AppConst.STATUS, AppConst.SUCCESS);
			model.put(AppConst.MESSAGES, "已审批！");
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage(), e);
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, "审批失败！");
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}
	
	/**
	 * 涉环保重口二级审批
	 * @param zdryWorkflowVO
	 * @param sessionBean
	 * @return
	 */
	@RequestMapping(value = "/shbApproval2", method = RequestMethod.POST)
	public ModelAndView shbApproval2(ZdryWorkflowVO zdryWorkflowVO,SessionBean sessionBean) {
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			Map<String, Object> variables =  new HashMap<String, Object>();
			variables.put("approved", "1".equals(zdryWorkflowVO.getSpjg()));
			taskService.completeTask(zdryWorkflowVO.getWorkflowId(), variables);  //执行任务
			model.put(AppConst.STATUS, AppConst.SUCCESS);
			model.put(AppConst.MESSAGES, "已审批！");
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage(), e);
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, "审批失败！");
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}
	
	
}
