package com.founder.zdrygl.base.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.activiti.engine.FormService;
import org.activiti.engine.HistoryService;
import org.apache.log4j.Logger;
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
import com.founder.framework.organization.assign.service.OrgAssignPublic;
import com.founder.framework.organization.assign.vo.OrgUserInfo;
import com.founder.framework.organization.department.bean.OrgOrganization;
import com.founder.framework.organization.department.service.OrgOrganizationService;
import com.founder.framework.organization.position.service.OrgPositionService;
import com.founder.framework.organization.user.service.OrgUserService;
import com.founder.framework.utils.EasyUIPage;
import com.founder.syrkgl.service.SyrkSyrkxxzbService;
import com.founder.workflow.bean.JExecution;
import com.founder.workflow.bean.JHistoricTaskInstance;
import com.founder.workflow.bean.JTask;
import com.founder.workflow.service.inteface.JHistoryService;
import com.founder.workflow.service.inteface.JProcessDefinitionService;
import com.founder.workflow.service.inteface.JProcessManageService;
import com.founder.workflow.service.inteface.JRuntimeService;
import com.founder.workflow.service.inteface.JTaskService;
import com.founder.zdrygl.base.model.ZdryJgdxqxjdjb;
import com.founder.zdrygl.base.model.ZdryZb;
import com.founder.zdrygl.base.service.ZdryInfoQueryService;
import com.founder.zdrygl.base.service.ZdryJgdxqxjdjbService;
import com.founder.zdrygl.base.vo.ZdryWorkflowVO;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

/**
 * ****************************************************************************
 * 
 * @Package: [com.founder.zdrygl.controller.ZdryApprovalController.java]
 * @ClassName: [ZdryApprovalController]
 * @Description: [一句话描述该类的功能]
 * @Author: [he_minxi@founder.com.cn]
 * @CreateDate: [2015年8月4日 上午11:04:18]
 * @UpdateUser: [Administrator(如多次修改保留历史记录，增加修改记录)]
 * @UpdateDate: [2015年8月4日 上午11:04:18，(如多次修改保留历史记录，增加修改记录)]
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]
 * @Version: [v1.0]
 */
@Controller
@RequestMapping("zdryApproval")
public class ZdryApprovalController extends BaseController {
	private Logger logger = Logger.getLogger(this.getClass());

	@Autowired
	private JProcessDefinitionService processDefinitionService;

	@Autowired
	private JProcessManageService processManageService;

	@Resource(name = "jTaskService")
	private JTaskService taskService;

	@Resource(name = "zdryQueryService")
	private ZdryInfoQueryService zdryInfoQueryService;

	@Resource(name = "syrkSyrkxxzbService")
	private SyrkSyrkxxzbService syrkSyrkxxzbService;

	@Resource(name = "orgUserService")
	private OrgUserService orgUserService;

	@Resource(name = "orgOrganizationService")
	private OrgOrganizationService orgOrganizationService;

	@Resource(name = "orgPositionService")
	private OrgPositionService orgPositionService;

	@Resource(name = "zdryJgdxqxjdjbService")
	private ZdryJgdxqxjdjbService zdryJgdxqxjdjbService;
	@Autowired
	private JRuntimeService runtimeService;
	@Autowired
	protected JHistoryService historyService;
	@Autowired
	protected FormService formService;

	@Autowired
	protected HistoryService ahistoryService;

	/**
	 * 
	 * @Title: zdryApproval
	 * @Description: TODO(流程审批通用页面)
	 * @param @param zdryId
	 * @param @param workflowId
	 * @param @param approvalMethod
	 * @param @return 设定文件
	 * @return ModelAndView 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/zdryApproval", method = RequestMethod.GET)
	public ModelAndView zdryApproval(String executionId, String workflowId) {
		ModelAndView mv = new ModelAndView("zdrygl/zdryApproval");

		String approvalMethod = (String) processDefinitionService.getVariables(
				executionId).get("approvalMethod");
		// String
		// sqlxdm=(String)processDefinitionService.getVariables(executionId).get("sqlxdm");

		Object renderedTaskForm = formService.getRenderedTaskForm(workflowId);
		mv.addObject("renderedTaskForm", (String) renderedTaskForm);
		mv.addObject("workflowId", workflowId);
		mv.addObject("executionId", executionId);
		mv.addObject("approvalMethod", approvalMethod);
		// mv.addObject("sqlxdm", sqlxdm);
		return mv;
	}

	/**
	 * 
	 * @Title: getZdryXx
	 * @Description: TODO(流程审批通用页面根据executionId获取重点人员信息流程信息)
	 * @param @param executionId
	 * @param @return 设定文件
	 * @return Map 返回类型
	 * @throws
	 */

	@RequestMapping(value = "/getZdryXx", method = RequestMethod.POST)
	public @ResponseBody Map getZdryXx(String executionId) {
		Map<String, Object> model = new HashMap<String, Object>();
		Map<String, Object> workflowXx = new HashMap<String, Object>();
		workflowXx = processDefinitionService.getVariables(executionId);

		ZdryZb zdryZdryzb = (ZdryZb) zdryInfoQueryService.queryById((String) workflowXx
				.get("zdryId"));

		if ("04".equals(workflowXx.get("sqlxdm"))
				&& workflowXx.get("qjId") != null) {// 请假，查询请假信息
			ZdryJgdxqxjdjb zdryJgdxqxjdjb = zdryJgdxqxjdjbService
					.queryById(workflowXx.get("qjId").toString());
			model.put("zdryJgdxqxjdjb", zdryJgdxqxjdjb);
		}

		model.put("workflowXx", workflowXx);
		model.put("zdryZdryzb", zdryZdryzb);

		return model;
	}

	@RequestMapping(value = "/getApprovalOrgCode", method = RequestMethod.POST)
	public @ResponseBody Map getApprovalOrgCode(String condition) {
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		if (condition.equals("sjbm")) {
			// 上级部门
			OrgOrganization orgOrganization = orgOrganizationService
					.queryParentOrgByOrgcode(sessionBean.getUserOrgCode());
			model.put("orgOrganization", orgOrganization);

		}
		if (condition.equals("xjbm")) {
			// 下级部门
			OrgOrganization orgOrganization = orgOrganizationService
					.queryParentOrgByOrgcode(sessionBean.getUserOrgCode());
			model.put("orgOrganization", orgOrganization);
		}

		// 从本部门上行指定等级代码的部门
		// OrgOrganization
		// orgOrganization1=orgOrganizationService.queryUpOrgByLevel(orgcode,"");
		// 取得两个部门的共同上级部门
		// OrgOrganization
		// orgOrganization2=orgOrganizationService.querySameParentOrg(orgcode,"");

		return model;
	}

	@RequestMapping(value = "/zdryDetail", method = RequestMethod.GET)
	public ModelAndView zdryDetail(ZdryWorkflowVO entity) {
		ModelAndView mv = new ModelAndView("zdrygl/zdryDetail");

		// List<HistoricDetail>
		// aa=ahistoryService.createHistoricDetailQuery().formProperties().list();

		Object renderedStartForm = formService.getRenderedStartForm(entity
				.getPocessDefinitionId());
		// Object renderedStartForm1
		// =formService.getTaskFormData(entity.getWorkflowId());
		// Object
		// renderedTsskForm=formService.getRenderedTaskForm(entity.getWorkflowId(),"approval.form");

		if (null != renderedStartForm) {
			mv.addObject("renderedTaskForm", renderedStartForm.toString());
		}

		return mv;
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
	 * @param @return 设定文件
	 * @return EasyUIPage 返回类型
	 * @throws
	 */

	@RequestMapping(value = "/queryList", method = RequestMethod.POST)
	public @ResponseBody EasyUIPage queryList(EasyUIPage page,
			@RequestParam(value = "rows") Integer rows, ZdryWorkflowVO entity,
			SessionBean sessionBean) {
		page.setPagePara(rows);

		sessionBean = getSessionBean(sessionBean);
		Map<String, Object> filrers = new HashMap<String, Object>();
		String splxString = entity.getSplx();
		String sqlxString = entity.getSqlx();
		if (sqlxString != null && !"".equals(sqlxString)) {
			filrers.put("sqlx", sqlxString);
		}
		if ("1".equals(splxString)) {

			List<JExecution> executions = (List<JExecution>) runtimeService
					.findJExecutionsByUser(sessionBean, page.getBegin(), rows,
							filrers).get(JExecution.EXECUTIONLIST);
			List<ZdryWorkflowVO> zdryWorkflowList = new ArrayList();
			for (int i = 0; i < executions.size(); i++) {
				ZdryWorkflowVO zdryWorkflowVO = new ZdryWorkflowVO();
				JExecution execution = executions.get(i);

				String zdrylx = (String) processDefinitionService.getVariables(
						execution.getId()).get("zdrylx");
				String sqrId = (String) processDefinitionService.getVariables(
						execution.getId()).get("applyUserId");// 申请人ID
				String createTime = (String) processDefinitionService
						.getVariables(execution.getId()).get("createTime");
				String sqlx = (String) processDefinitionService.getVariables(
						execution.getId()).get("sqlx");// 申请类型
				String sqlxdm = (String) processDefinitionService.getVariables(
						execution.getId()).get("sqlxdm");// 申请类型
				String zdryId = (String) processDefinitionService.getVariables(
						execution.getId()).get("zdryId");// 人员USERID
				String zdryName = (String) processDefinitionService
						.getVariables(execution.getId()).get("xm");// 人员USERID
				String sqrName = (String) processDefinitionService
						.getVariables(execution.getId()).get("sqrName");// 申请人姓名

				zdryWorkflowVO.setPocessDefinitionId(execution
						.getProcessDefinitionId());
				zdryWorkflowVO.setExecutionId(execution.getId());
				zdryWorkflowVO.setZdrylx(zdrylx);
				zdryWorkflowVO.setSqrId(sqrId);
				zdryWorkflowVO.setCreateTime(createTime);
				zdryWorkflowVO.setSqlx(sqlx);
				zdryWorkflowVO.setSqlxdm(sqlxdm);
				zdryWorkflowVO.setZdryId(zdryId);
				zdryWorkflowVO.setZdryName(zdryName);
				zdryWorkflowVO.setSqrName(sqrName);
				zdryWorkflowList.add(zdryWorkflowVO);
			}
			page.setTotal((int) runtimeService.findJExecutionsByUser(
					sessionBean, page.getBegin(), rows, filrers).get(
					JExecution.EXECUTIONTOTALCOUNT));
			page.setRows(zdryWorkflowList);

		}
		if ("2".equals(splxString)) {

			List<JHistoricTaskInstance> historicTaskInstances = (List<JHistoricTaskInstance>) historyService
					.findJFinishedTasksByUser(sessionBean, page.getBegin(),
							rows, filrers).get(
							JHistoricTaskInstance.HistoricTaskInstanceLIST);

			List<ZdryWorkflowVO> zdryWorkflowList = new ArrayList();
			for (int i = 0; i < historicTaskInstances.size(); i++) {
				ZdryWorkflowVO zdryWorkflowVO = new ZdryWorkflowVO();
				JHistoricTaskInstance historicTaskInstance = historicTaskInstances
						.get(i);

				// ahistoryService.createHistoricTaskInstanceQuery().processDefinitionId(historicTaskInstance.getProcessInstanceId()).singleResult().getId();

				String zdrylx = (String) historyService.getJHistoricVariable(
						historicTaskInstance.getProcessInstanceId()).get(
						"zdrylx");
				String sqrId = (String) historyService.getJHistoricVariable(
						historicTaskInstance.getProcessInstanceId()).get(
						"applyUserId");// 申请人ID
				String createTime = (String) historyService
						.getJHistoricVariable(
								historicTaskInstance.getProcessInstanceId())
						.get("createTime");
				String sqlx = (String) historyService.getJHistoricVariable(
						historicTaskInstance.getProcessInstanceId())
						.get("sqlx");// 申请类型
				String sqlxdm = (String) historyService.getJHistoricVariable(
						historicTaskInstance.getProcessInstanceId()).get(
						"sqlxdm");// 申请类型
				String zdryId = (String) historyService.getJHistoricVariable(
						historicTaskInstance.getProcessInstanceId()).get(
						"zdryId");// 人员USERID
				String zdryName = (String) historyService.getJHistoricVariable(
						historicTaskInstance.getProcessInstanceId()).get("xm");// 人员USERID
				String sqrName = (String) historyService.getJHistoricVariable(
						historicTaskInstance.getProcessInstanceId()).get(
						"sqrName");// 申请人姓名

				zdryWorkflowVO.setWorkflowId(historicTaskInstance.getId());
				zdryWorkflowVO.setPocessDefinitionId(historicTaskInstance
						.getProcessDefinitionId());
				zdryWorkflowVO.setZdrylx(zdrylx);
				zdryWorkflowVO.setSqrId(sqrId);
				zdryWorkflowVO.setCreateTime(createTime);
				zdryWorkflowVO.setSqlx(sqlx);
				zdryWorkflowVO.setSqlxdm(sqlxdm);
				zdryWorkflowVO.setZdryId(zdryId);
				zdryWorkflowVO.setZdryName(zdryName);
				zdryWorkflowVO.setSqrName(sqrName);
				zdryWorkflowList.add(zdryWorkflowVO);
			}
			page.setTotal((int) historyService.findJFinishedTasksByUser(
					sessionBean, page.getBegin(), rows, filrers).get(
					JHistoricTaskInstance.HistoricTaskInstanceTOTALCOUNT));
			page.setRows(zdryWorkflowList);
		}

		if ("0".equals(splxString) || splxString == null
				|| splxString.equals("")) {
			List<JTask> tasks = (List<JTask>) taskService.findJTasksByUser(
					sessionBean, page.getBegin(), rows, filrers).get(
					JTask.TASKLIST);

			List<ZdryWorkflowVO> zdryWorkflowList = new ArrayList();
			for (int i = 0; i < tasks.size(); i++) {
				ZdryWorkflowVO zdryWorkflowVO = new ZdryWorkflowVO();
				JTask task = tasks.get(i);
				Map<String, Object> vars = processDefinitionService
						.getVariables(task.getExecutionId());
				String zdrylx = (String) vars.get("zdrylx");
				String sqrId = (String) vars.get("applyUserId");// 申请人ID
				String createTime = (String) vars.get("createTime");
				String sqlx = (String) vars.get("sqlx");// 申请类型
				String sqlxdm = (String) vars.get("sqlxdm");// 申请类型
				String zdryId = (String) vars.get("zdryId");// 人员USERID
				String zdryName = (String) vars.get("xm");// 人员USERID
				String sqrName = (String) vars.get("sqrName");// 申请人姓名

				zdryWorkflowVO.setWorkflowId(task.getId());
				zdryWorkflowVO.setExecutionId(task.getExecutionId());
				zdryWorkflowVO.setPocessDefinitionId(task
						.getProcessDefinitionId());
				zdryWorkflowVO.setZdrylx(zdrylx);
				zdryWorkflowVO.setSqrId(sqrId);
				zdryWorkflowVO.setCreateTime(createTime);
				zdryWorkflowVO.setSqlx(sqlx);
				zdryWorkflowVO.setSqlxdm(sqlxdm);
				zdryWorkflowVO.setZdryId(zdryId);
				zdryWorkflowVO.setZdryName(zdryName);
				zdryWorkflowVO.setSqrName(sqrName);
				zdryWorkflowList.add(zdryWorkflowVO);
			}

			page.setTotal((int) taskService.findJTasksByUser(sessionBean,
					page.getBegin(), rows, filrers).get(JTask.TASKTOTALCOUNT));
			page.setRows(zdryWorkflowList);
		}

		return page;
	}

	/**
	 * 
	 * @Title: zdryApproval
	 * @Description: TODO(审批公共方法)
	 * @param @param zdryWorkflowVO
	 * @param @param sessionBean
	 * @param @return 设定文件
	 * @return ModelAndView 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/zdryApproval", method = RequestMethod.POST)
	public ModelAndView zdryApproval(ZdryWorkflowVO zdryWorkflowVO,
			SessionBean sessionBean) {

		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		sessionBean = getSessionBean(sessionBean);
		Map<String, Object> model = new HashMap<String, Object>();
		try {

			Map<String, Object> variables = new HashMap<String, Object>();

			if (!(zdryWorkflowVO.getNextSpUserId().equals("") || zdryWorkflowVO
					.getNextSpUserId() == null)) {

				// variables.put(zdryWorkflowVO.getNextSppos()+"Approved",
				// zdryWorkflowVO.getNextSpUserId());
				variables.put("fxjzg", zdryWorkflowVO.getNextSpUserId());

			}
			if ((zdryWorkflowVO.getNextSpUserId().equals("") || zdryWorkflowVO
					.getNextSpUserId() == null)
					&& (!(zdryWorkflowVO.getNextSpposId().equals("") || zdryWorkflowVO
							.getNextSpposId() == null))) {

				// variables.put(zdryWorkflowVO.getNextSppos()+"Approved",
				// zdryWorkflowVO.getNextSpOrgCode()+"_"+zdryWorkflowVO.getNextSpposId());
				variables.put("fxjzg", zdryWorkflowVO.getNextSpOrgCode() + "_"
						+ zdryWorkflowVO.getNextSpposId());
			}

			String Key = taskService.findJTaskbyTaskId(
					zdryWorkflowVO.getWorkflowId()).getTaskDefinitionKey();
			// variables.put(taskService.findJTaskbyTaskId(zdryWorkflowVO.getWorkflowId()).getTaskDefinitionKey()+"ApprovedType",
			// zdryWorkflowVO.getSpjg());

			variables.put("sz" + "ApprovedType", zdryWorkflowVO.getSpjg());

			// variables.put(orgPositionService.queryByPosid(sessionBean.getUserPositionId()).getId()+"ApprovedType",
			// zdryWorkflowVO.getSpjg());

			ZdryZb zdryZdryzb = (ZdryZb) zdryInfoQueryService.queryById((String) zdryWorkflowVO.getZdryId());
			variables.put("listenerAgree", "");
			variables.put("listenerDisgree", "");
			variables.put("spyj", zdryWorkflowVO.getSpyj());

			// set next task's owner
			if (zdryWorkflowVO.getNextSppos() != null)
				variables.put("posid", zdryWorkflowVO.getNextSppos());// 对应数据库表org_position中的posid
			variables.put("sporgcode", zdryWorkflowVO.getNextSpOrgCode());//
			variables.put("orgposid", zdryWorkflowVO.getNextSpposId());// 对应org_org_pos表中的id
			variables.put("nextSpUserId", zdryWorkflowVO.getNextSpUserId());

			taskService.completeTask(zdryWorkflowVO.getWorkflowId(), variables); // 执行任务

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
	 * @Title: mjApproval
	 * @Description: TODO(责任区民警审批)
	 * @param @param zdryWorkflowVO
	 * @param @param sessionBean
	 * @param @return 设定文件
	 * @return ModelAndView 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/mjApproval", method = RequestMethod.POST)
	public ModelAndView mjApproval(ZdryWorkflowVO zdryWorkflowVO,
			SessionBean sessionBean) {

		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		sessionBean = getSessionBean(sessionBean);
		Map<String, Object> model = new HashMap<String, Object>();
		try {

			Map<String, Object> variables = new HashMap<String, Object>();

			if (zdryWorkflowVO.getSpjg().equals("1")) {// 同意

				String fsxOrgCode = orgOrganizationService.queryUpOrgByLevel(
						sessionBean.getUserOrgCode(), "32").getOrgcode();// 得到本名等级为三级，派出所部门code
				String taskParameter = fsxOrgCode
						+ "_"
						+ orgPositionService.queryByPosid("SZ").getId()
								.toString(); // 部门code+所长岗位ID
				variables.put("sz", taskParameter);
				variables.put("approvalMethod", "szApproval");

			}
			variables.put("spyj", zdryWorkflowVO.getSpyj());
			variables.put("approvedType", zdryWorkflowVO.getSpjg());

			taskService.completeTask(zdryWorkflowVO.getWorkflowId(), variables); // 执行任务
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
	 * @param @return 设定文件
	 * @return ModelAndView 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/szApproval", method = RequestMethod.POST)
	public ModelAndView szApproval(ZdryWorkflowVO zdryWorkflowVO,
			SessionBean sessionBean) {

		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		sessionBean = getSessionBean(sessionBean);
		Map<String, Object> model = new HashMap<String, Object>();
		try {

			Map<String, Object> variables = new HashMap<String, Object>();
			if (zdryWorkflowVO.getSpjg().equals("0")) {// 拒绝

				variables.put("szApprovedType", "0");

			}

			else {// 同意
				if (zdryWorkflowVO.getZdrylx().equals("01")
						|| zdryWorkflowVO.getZdrylx().equals("02")
						|| zdryWorkflowVO.getZdrylx().equals("04")
						|| zdryWorkflowVO.getZdrylx().equals("06")
						|| zdryWorkflowVO.getSqlxdm().equals("04")) {// 所长审批同意流程结束
																		// 新增“其他类型重点人员”和"请假审批"

					variables.put("szApprovedType", "1");
				}

				else {// 同意并提交到分县局管理员或分县局治安业务主管

					String taskParameter = ""; // 部门code+岗位ID
					if (zdryWorkflowVO.getNextSpposId() != null) {
						taskParameter = zdryWorkflowVO.getNextSpOrgCode() + "_"
								+ zdryWorkflowVO.getNextSpposId();
					}
					if (zdryWorkflowVO.getNextSpUserId() != null) {
						taskParameter = zdryWorkflowVO.getNextSpUserId();
					}
					variables.put("fxjzg", taskParameter);
					variables.put("approvalMethod", "fxjzgApproval");
					variables.put("szApprovedType", "2");
				}
			}

			variables.put("spyj", zdryWorkflowVO.getSpyj());
			variables.put("posid", zdryWorkflowVO.getNextSppos());// 对应数据库表org_position中的posid
			variables.put("sporgcode", zdryWorkflowVO.getNextSpOrgCode());//
			variables.put("orgposid", zdryWorkflowVO.getNextSpposId());// 对应org_org_pos表中的id
			variables.put("nextSpUserId", zdryWorkflowVO.getNextSpUserId());
			taskService.completeTask(zdryWorkflowVO.getWorkflowId(), variables); // 执行任务
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
	 * @param @return 设定文件
	 * @return ModelAndView 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/fxjzgApproval", method = RequestMethod.POST)
	public ModelAndView fxjzgApproval(ZdryWorkflowVO zdryWorkflowVO,
			SessionBean sessionBean) {

		sessionBean = getSessionBean(sessionBean);
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			Map<String, Object> variables = new HashMap<String, Object>();
			variables.put("spyj", zdryWorkflowVO.getSpyj());
			variables.put("fxjzgApprovedType", zdryWorkflowVO.getSpjg());
			taskService.completeTask(zdryWorkflowVO.getWorkflowId(), variables); // 执行任务
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
	 * @param @return 设定文件
	 * @return ModelAndView 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/sgafApproval", method = RequestMethod.POST)
	public ModelAndView sgafApproval(ZdryWorkflowVO zdryWorkflowVO,
			SessionBean sessionBean) {
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		sessionBean = getSessionBean(sessionBean);
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			Map<String, Object> variables = new HashMap<String, Object>();
			variables.put("approved", "1".equals(zdryWorkflowVO.getSpjg()));
			variables.put("spr", sessionBean.getUserName());
			variables.put("spbm", sessionBean.getUserOrgName());

			OrgOrganization orgOrganization = orgOrganizationService
					.queryUpOrgByLevel(sessionBean.getUserOrgCode(), "21");
			String fsxOrgCode = orgOrganization.getOrgcode();
			String taskParameter = fsxOrgCode
					+ "_"
					+ orgPositionService.queryByPosid("FXJSGAFYWZG").getId()
							.toString();
			variables.put("approvalMethod", "sgafApproval2");
			variables.put("ywzgsp", taskParameter);
			// taskService.claimTask(zdryWorkflowVO.getWorkflowId(),
			// sessionBean.getUserId()); //接收任务
			taskService.completeTask(zdryWorkflowVO.getWorkflowId(), variables); // 执行任务
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
	 * @param @return 设定文件
	 * @return ModelAndView 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/sgafApproval2", method = RequestMethod.POST)
	public ModelAndView sgafApproval2(ZdryWorkflowVO zdryWorkflowVO,
			SessionBean sessionBean) {
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		sessionBean = getSessionBean(sessionBean);
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			Map<String, Object> variables = new HashMap<String, Object>();
			variables.put("approved", "1".equals(zdryWorkflowVO.getSpjg()));
			variables.put("spr", sessionBean.getUserName());
			variables.put("spbm", sessionBean.getUserOrgName());
			taskService.completeTask(zdryWorkflowVO.getWorkflowId(), variables); // 执行任务
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
	 * 
	 * @param zdryWorkflowVO
	 * @param sessionBean
	 * @return
	 */
	@RequestMapping(value = "/shbApproval", method = RequestMethod.POST)
	public ModelAndView shbApproval(ZdryWorkflowVO zdryWorkflowVO,
			SessionBean sessionBean) {
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		sessionBean = getSessionBean(sessionBean);
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			Map<String, Object> variables = new HashMap<String, Object>();
			variables.put("approved", "1".equals(zdryWorkflowVO.getSpjg()));
			variables.put("approvalMethod", "shbApproval2");
			variables.put("splevel", "2");

			taskService.completeTask(zdryWorkflowVO.getWorkflowId(), variables); // 执行任务
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
	 * 
	 * @param zdryWorkflowVO
	 * @param sessionBean
	 * @return
	 */
	@RequestMapping(value = "/shbApproval2", method = RequestMethod.POST)
	public ModelAndView shbApproval2(ZdryWorkflowVO zdryWorkflowVO,
			SessionBean sessionBean) {
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			Map<String, Object> variables = new HashMap<String, Object>();
			variables.put("approved", "1".equals(zdryWorkflowVO.getSpjg()));
			taskService.completeTask(zdryWorkflowVO.getWorkflowId(), variables); // 执行任务
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
	 * @Title: szzlApproval
	 * @Description: TODO(所长转类审批)
	 * @param @param zdryWorkflowVO
	 * @param @param sessionBean
	 * @param @return 设定文件
	 * @return ModelAndView 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/szzlApproval", method = RequestMethod.POST)
	public ModelAndView szzlApproval(ZdryWorkflowVO zdryWorkflowVO,
			SessionBean sessionBean) {

		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		sessionBean = getSessionBean(sessionBean);
		Map<String, Object> model = new HashMap<String, Object>();
		try {

			Map<String, Object> variables = new HashMap<String, Object>();

			variables.put("spjg", zdryWorkflowVO.getSpjg());
			variables.put("spyj", zdryWorkflowVO.getSpyj());
			taskService.completeTask(zdryWorkflowVO.getWorkflowId(), variables); // 执行任务
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

	@RequestMapping(value = "/queryUserByOrgAndPos/{orgcode}/{posid}", method = RequestMethod.GET)
	public JsonObject getUserByOrgAndPos(@PathVariable String orgcode,
			@PathVariable String posid) {
		JsonObject jObject = new JsonObject();
		OrgAssignPublic orgAssignPublic = new OrgAssignPublic();
		List<OrgUserInfo> users = orgAssignPublic.queryUserByOrgAndPos(orgcode,
				posid);

		return jObject;
	}

}
