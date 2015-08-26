package com.founder.zdrygl.controller;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.fileupload.FileItem;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.founder.framework.base.controller.BaseController;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.components.AppConst;
import com.founder.framework.organization.department.bean.OrgOrganization;
import com.founder.framework.organization.department.service.OrgOrganizationService;
import com.founder.framework.organization.position.service.OrgPositionService;
import com.founder.framework.organization.user.service.OrgUserService;
import com.founder.framework.utils.DateUtils;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.service.attachment.bean.ZpfjFjxxb;
import com.founder.service.attachment.service.ZpfjFjxxbService;
import com.founder.syrkgl.bean.SyrkSyrkxxzb;
import com.founder.syrkgl.dao.SyrkSyrkxxzbDao;
import com.founder.workflow.bean.JTask;
import com.founder.workflow.service.inteface.JProcessDefinitionService;
import com.founder.workflow.service.inteface.JTaskService;
import com.founder.zdrygl.bean.ZdryZdryzb;
import com.founder.zdrygl.bean.Zdrylxylbdyb;
import com.founder.zdrygl.dao.ZdryZdryzbDao;
import com.founder.zdrygl.dao.ZdrylxylbdybDao;
import com.founder.zdrygl.service.ZdryZdService;
import com.founder.zdrygl.vo.ZdryWorkflowVO;
import com.founder.zdrygl.vo.ZdryZdryzbVO;
import com.google.gson.Gson;

/***
 * ****************************************************************************
 * 
 * @Package: [com.founder.zdrygl.controller.ZdryZdController.java]
 * @ClassName: [ZdryZdController]
 * @Description: [转递业务]
 * @Author: [wu_chunhui@founder.com.cn]
 * @CreateDate: [2015-3-12 下午3:56:09]
 * @UpdateUser: [Administrator(如多次修改保留历史记录，增加修改记录)]
 * @UpdateDate: [2015-3-12 下午3:56:09，(如多次修改保留历史记录，增加修改记录)]
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]
 * @Version: [v1.0]
 */
@Controller
@RequestMapping("zdryZd")
public class ZdryZdController extends BaseController {
	private Logger logger = Logger.getLogger(this.getClass());
	@Resource(name = "zdryZdryzbDao")
	private ZdryZdryzbDao zdryZdryzbDao;
	@Resource(name = "syrkSyrkxxzbDao")
	private SyrkSyrkxxzbDao syrkSyrkxxzbDao;
	@Resource(name = "zdryZdService")
	private ZdryZdService zdryZdService;
	@Resource(name = "orgOrganizationService")
	private OrgOrganizationService orgOrganizationService;
	@Resource(name = "zdrylxylbdybDao")
	private ZdrylxylbdybDao zdrylxylbdybDao;
	@Resource(name = "orgUserService")
	private OrgUserService orgUserService;
	@Resource(name = "orgPositionService")
	private OrgPositionService orgPositionService;
	@Autowired
	private JProcessDefinitionService processDefinitionService;

	@Autowired
	private JTaskService taskService;
	@Resource(name = "zpfjFjxxbService")
	private ZpfjFjxxbService zpfjFjxxbService;
	
	
	/***
	 * 
	 * @Title: createLg
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param syrkid
	 * @param @param ryid
	 * @param @param ywlx
	 * @param @return 设定文件
	 * @return ModelAndView 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/createZd", method = RequestMethod.GET)
	public ModelAndView createZd(String syrkid) {
		SessionBean sessionBean = getSessionBean();
		ModelAndView mv = new ModelAndView("zdrygl/zdryZd");
		List<ZdryZdryzb> zdryZdList = null;
		ZdryZdryzb zdryZdryzb = null;
		String filterZdStr="";
		if (!StringUtils.isBlank(syrkid)) {
			zdryZdList = zdryZdryzbDao.queryZdryBySyrkid(syrkid);
		}
		if (zdryZdList != null && zdryZdList.size() > 0) {// 不是第一次，取得已经列管的类型
			zdryZdryzb = zdryZdList.get(0);
		}
		for (int i = 0; i < zdryZdList.size(); i++) {
			filterZdStr+=zdryZdList.get(0).getZdrygllxdm()+"|";
		}
		
		SyrkSyrkxxzb syrkSyrkxxzb =syrkSyrkxxzbDao.queryById(syrkid);
		OrgOrganization orgOrganization=orgOrganizationService.queryParentOrgByOrgcode(sessionBean.getUserOrgCode());
		mv.addObject("syrkSyrkxxzb", syrkSyrkxxzb);
		mv.addObject("zdryZdryzb", zdryZdryzb);
		mv.addObject("ywblr_id", sessionBean.getUserId());
		mv.addObject("ywblr_xm", sessionBean.getUserName());
		mv.addObject("ywclsj", DateUtils.getSystemDateString());
		mv.addObject("filterZdStr", filterZdStr);
		mv.addObject("sspcsdm", orgOrganization.getOrgcode());
		
		return mv;
	}

	/***
	 * 
	 * @Title: saveZd
	 * @Description: TODO重点人员转递保存逻辑
	 * @param @param zdryLczywblb
	 * @param @param sessionBean
	 * @param @return 设定文件
	 * @return ModelAndView 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/saveZd", method = RequestMethod.POST)
	public ModelAndView saveZd(
			ZdryZdryzbVO zdryZdryzbVO, 
			SessionBean sessionBean,
			@RequestParam(value="uploadFile") CommonsMultipartFile[] uploadFile) {
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		Map<String, Object> model = new HashMap<String, Object>();
		sessionBean = getSessionBean(sessionBean);
		try {
			zdryZdService.sendZd(zdryZdryzbVO, sessionBean);
			
			//处理上传的转递依据
			List<ZpfjFjxxb> list = new ArrayList<ZpfjFjxxb>();
			for (int i = 0; i < uploadFile.length; i++) {
				CommonsMultipartFile multipartFile = uploadFile[i];
				if (!multipartFile.isEmpty()) {
					FileItem fileItem = multipartFile.getFileItem();
					ZpfjFjxxb entity = new ZpfjFjxxb();
					entity.setLybm("ZDRY_ZDRYZB");
					entity.setLyid(zdryZdryzbVO.getId());//保存的是当前选择的重点人员id，因为后续 转递要改成一次只转一个类型
					entity.setLyms("重点人员转递-转递依据");
					String wjmc = fileItem.getName();
					if (wjmc.indexOf("\\") != -1) { // 去除完整路径
						wjmc = wjmc.substring(wjmc.lastIndexOf("\\") + 1);
					}
					String wjhzlx = "";
					int atI = wjmc.lastIndexOf(".");
					if (atI != -1) {
						wjhzlx = wjmc.substring(atI + 1);
						wjhzlx = wjhzlx.toLowerCase();
					}
					entity.setWjmc(wjmc);
					entity.setWjhzlx(wjhzlx);
					entity.setWj(multipartFile.getBytes());
					long wjdx = entity.getWj().length;
					entity.setWjdx(new Long(wjdx));
					String wjdxsm = "";
					if (wjdx < 1024) {
						wjdxsm = "" + wjdx + " B";
					} else if (wjdx > 1048576) {
						double mb = Math.floor(wjdx / 1048576);
						DecimalFormat formater = new DecimalFormat(
								"###,###,###.00");
						wjdxsm = "" + formater.format(mb) + " MB";
					} else {
						long kb = (long) Math.floor(wjdx / 1024);
						wjdxsm = "" + kb + " KB";
					}
					entity.setWjdxsm(wjdxsm);
					entity.setWjxzcs(new Long(0));
					list.add(entity);
				}
			}
			if (list.size() > 0) {
				zpfjFjxxbService.saveZpfjFjxxb(list, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, getAddSuccess());
			}
			
			//处理完毕
			
			Map<String, Object> variables =  new HashMap<String, Object>();
			Zdrylxylbdyb zdrylxylbdyb=new Zdrylxylbdyb();
			zdrylxylbdyb.setLbdm(zdryZdryzbVO.getZdrygllxdm());
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			variables.put("sqsj",formatter.format(new Date())); //申请时间
			variables.put("syrkid", zdryZdryzbVO.getSyrkid()); //重点人员总表Id
			variables.put("xm", zdryZdryzbVO.getXm());//被列管人员姓名
			variables.put("zjhm", zdryZdryzbVO.getZjhm());//证件号码
			variables.put("yjzddz", zdryZdryzbVO.getDz_hjdzmlpxz());//原居住地址	
			variables.put("ygxpcsdm", zdryZdryzbVO.getYgxpcsdm());//原居住地址所属派出所代码	
			variables.put("ygxzrqdm", zdryZdryzbVO.getYgxzrqdm());//原居住地址所属责任区代码	
			variables.put("zddz", zdryZdryzbVO.getDz_jzdzmlpxz());//转递地址
			variables.put("sspcsdm", zdryZdryzbVO.getSspcsdm());//转递派出所
			variables.put("sszrqdm", zdryZdryzbVO.getSszrqdm());//转递责任区
			variables.put("ywfqyy", zdryZdryzbVO.getYwfqyy());//转递原因
			variables.put("sqrName", sessionBean.getUserName());//转递发起人名称
			variables.put("sqrbmdm", sessionBean.getUserOrgCode());//转递发起人名称
			
			variables.put("ywlx", "重点人员转递");//申请类型为转递
			processDefinitionService.startProcessInstance(sessionBean.getUserId(), "zd", zdryZdryzbVO.getId(), variables);
			model.put(AppConst.STATUS, AppConst.SUCCESS);
			model.put(AppConst.MESSAGES, "转递发起成功");
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getLocalizedMessage(), e);
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, getAddFail());
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}

	/**
	 * @Title: query
	 * @Description: TODO(重点人员待审批页面)
	 * @param @return 设定文件
	 * @return ModelAndView 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/zdQuery", method = RequestMethod.GET)
	public ModelAndView zdQuery(SessionBean sessionBean) {
		ModelAndView mv = new ModelAndView("zdrygl/zdryZdList");
		
		
		return mv;
	}
	/**
	 * @Title: query
	 * @Description: TODO(重点人员待审批页面)
	 * @param @return 设定文件
	 * @return ModelAndView 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/cjQuery", method = RequestMethod.GET)
	public ModelAndView cjQuery(SessionBean sessionBean) {
		ModelAndView mv = new ModelAndView("zdrygl/zdryCjList");
		
		
		return mv;
	}
	/**
	 * 
	 * @Title: queryList
	 * @Description: TODO(重点人员转递待接收列表)
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
			@RequestParam(value = "rows") Integer rows,ZdryZdryzbVO entity,
			SessionBean sessionBean) {
			page.setPagePara(rows);

			sessionBean = getSessionBean(sessionBean);
			String taskParameter=sessionBean.getUserOrgCode()+"_"+sessionBean.getPositionId()+"_ZDJS";//当前登陆者部门或岗位信息
			List<JTask> tasks = taskService.findTodoTasks(taskParameter);
			List<ZdryZdryzbVO> ZdryZdryzbVOList= new ArrayList();
			for (int i = 0; i < tasks.size(); i++) {
				ZdryZdryzbVO zdryZdryzbVO=new ZdryZdryzbVO();
				JTask task = tasks.get(i);
				
				zdryZdryzbVO.setExecutionId(task.getExecutionId());
				zdryZdryzbVO.setTaskId(task.getId());
				zdryZdryzbVO.setSqrName((String)processDefinitionService.getVariables(task.getExecutionId()).get("sqrName"));
				zdryZdryzbVO.setSqsj((String)processDefinitionService.getVariables(task.getExecutionId()).get("sqsj"));
				zdryZdryzbVO.setXm((String)processDefinitionService.getVariables(task.getExecutionId()).get("xm"));
				zdryZdryzbVO.setYwlx((String)processDefinitionService.getVariables(task.getExecutionId()).get("ywlx"));
				ZdryZdryzbVOList.add(zdryZdryzbVO);
			}
			 
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("begin", page.getBegin());
				map.put("end", page.getEnd());
				String sort = page.getSort();
				String order = page.getOrder();
				map.put("sort", sort);
				map.put("order", order);
				map.put("zdryZdryzbVO", entity);
				page.setTotal(tasks.size());
				page.setRows(ZdryZdryzbVOList);
		
		 return page;
	}
	/**
	 * 
	 * @Title: queryCjList
	 * @Description: TODO(重点人员裁决待接收列表)
	 * @param @param page
	 * @param @param rows
	 * @param @param entity
	 * @param @param sessionBean
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	
	@RequestMapping(value = "/queryCjList", method = RequestMethod.POST)
	public @ResponseBody
	EasyUIPage queryCjList(EasyUIPage page,
			@RequestParam(value = "rows") Integer rows,ZdryZdryzbVO entity,
			SessionBean sessionBean) {
			page.setPagePara(rows);

			sessionBean = getSessionBean(sessionBean);
			String taskParameter=sessionBean.getUserOrgCode()+"_"+sessionBean.getPositionId()+"_ZDCJ";//当前登陆者部门或岗位信息
		
			List<JTask> tasks = taskService.findTodoTasks(taskParameter);
			List<ZdryZdryzbVO> ZdryZdryzbVOList= new ArrayList();
			for (int i = 0; i < tasks.size(); i++) {
				ZdryZdryzbVO zdryZdryzbVO=new ZdryZdryzbVO();
				JTask task = tasks.get(i);
				
				zdryZdryzbVO.setExecutionId(task.getExecutionId());
				zdryZdryzbVO.setTaskId(task.getId());
				zdryZdryzbVO.setSqrName((String)processDefinitionService.getVariables(task.getExecutionId()).get("sqrName"));
				zdryZdryzbVO.setSqsj((String)processDefinitionService.getVariables(task.getExecutionId()).get("sqsj"));
				zdryZdryzbVO.setXm((String)processDefinitionService.getVariables(task.getExecutionId()).get("xm"));
				zdryZdryzbVO.setYwlx((String)processDefinitionService.getVariables(task.getExecutionId()).get("ywlx"));
				ZdryZdryzbVOList.add(zdryZdryzbVO);
			}
			 
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("begin", page.getBegin());
				map.put("end", page.getEnd());
				String sort = page.getSort();
				String order = page.getOrder();
				map.put("sort", sort);
				map.put("order", order);
				map.put("zdryZdryzbVO", entity);
				page.setTotal(tasks.size());
				page.setRows(ZdryZdryzbVOList);
		
		 return page;
	}
	/**
	 * 
	 * @param executionId
	 * @param taskId
	 * @return
	 */
	@RequestMapping(value = "/zdryZdApproval", method = RequestMethod.GET)
	public ModelAndView zdryZdApproval(String executionId,String taskId) {
		ModelAndView mv = new ModelAndView("zdrygl/zdryZdJs");
		
		
		mv.addObject("taskId", taskId);
		mv.addObject("executionId", executionId);
		return mv;
	}
	/**
	 * 
	 * @param executionId
	 * @param taskId
	 * @return
	 */
	@RequestMapping(value = "/zdryCjApproval", method = RequestMethod.GET)
	public ModelAndView zdryCjApproval(String executionId,String taskId) {
		ModelAndView mv = new ModelAndView("zdrygl/zdryZdCj");
		
		
		mv.addObject("taskId", taskId);
		mv.addObject("executionId", executionId);
		return mv;
	}
	
	/**
	 * 
	 * @param executionId
	 * @return
	 */
	@RequestMapping(value = "/getZdryXx", method = RequestMethod.POST)
	public @ResponseBody
		Map getZdryXx(String executionId) {
		Map<String, Object> model = new HashMap<String, Object>();
		Map<String, Object> workflowXx = new HashMap<String, Object>();
		workflowXx=processDefinitionService.getVariables(executionId);
		
		model.put("workflowXx", workflowXx);

		return model;
	}
	
	/**
	 * 
	 * @Title: zdryZdJs
	 * @Description: TODO(责任区民警接收)
	 * @param @param zdryWorkflowVO
	 * @param @param sessionBean
	 * @param @return    设定文件
	 * @return ModelAndView    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/zdryZdJs", method = RequestMethod.POST)
	public ModelAndView zdryZdJs(ZdryZdryzbVO ZdryZdryzbVO,SessionBean sessionBean) {
		
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		sessionBean = getSessionBean(sessionBean);
		String taskParameter="";
		Map<String, Object> model = new HashMap<String, Object>();
		try {
	
		Map<String, Object> variables =  new HashMap<String, Object>();
		
		
		
		if(ZdryZdryzbVO.getSpjg().equals("0")){//不接收
			
			OrgOrganization  orgOrganization =orgOrganizationService.querySameParentOrg(sessionBean.getUserOrgCode(),(String)processDefinitionService.getVariables(ZdryZdryzbVO.getExecutionId()).get("sqrbmdm"));
			//得到共同上级部门
			if(orgOrganization.getOrglevel().equals("10")){//共同上级为市公安局
				
				taskParameter=orgOrganization.getOrgcode()+"_"+orgPositionService.queryByPosid("SJGLY").getId().toString()+"_ZDCJ";   //部门code+所长岗位ID	
				}
			else if(orgOrganization.getOrglevel().equals("21")){//分局
			
				taskParameter=orgOrganization.getOrgcode()+"_"+orgPositionService.queryByPosid("FXJGLY").getId().toString()+"_ZDCJ";   //部门code+所长岗位ID	
			}
			else if(orgOrganization.getOrglevel().equals("32")){//派出所
				
				taskParameter=orgOrganization.getOrgcode()+"_"+orgPositionService.queryByPosid("SZ").getId().toString()+"_ZDCJ";   //部门code+所长岗位ID	
				}
			
			variables.put("sfcj", "1");
			variables.put("sjcd", taskParameter);
		
		}
		
		variables.put("jslx", ZdryZdryzbVO.getSpjg());
		taskService.completeTask(ZdryZdryzbVO.getTaskId(), variables);  //执行任务
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
	 * @Title: zdryZdJs
	 * @Description: TODO(责任区民警接收)
	 * @param @param zdryWorkflowVO
	 * @param @param sessionBean
	 * @param @return    设定文件
	 * @return ModelAndView    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/zdryZdCj", method = RequestMethod.POST)
	public ModelAndView zdryZdCj(ZdryZdryzbVO ZdryZdryzbVO,SessionBean sessionBean) {
		
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		sessionBean = getSessionBean(sessionBean);
		Map<String, Object> model = new HashMap<String, Object>();
		try {
	
		Map<String, Object> variables =  new HashMap<String, Object>();
		
		variables.put("cdjg", ZdryZdryzbVO.getSpjg());
		taskService.completeTask(ZdryZdryzbVO.getTaskId(), variables);  //执行任务
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
