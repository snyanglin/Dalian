package com.founder.zdrygl.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
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
import com.founder.framework.organization.department.bean.OrgOrganization;
import com.founder.framework.organization.department.service.OrgOrganizationService;
import com.founder.framework.organization.position.service.OrgPositionService;
import com.founder.workflow.service.inteface.JProcessDefinitionService;
import com.founder.zdrygl.bean.ZdryJgdxqxjdjb;
import com.founder.zdrygl.bean.ZdryZdryzb;
import com.founder.zdrygl.bean.Zdrylxylbdyb;
import com.founder.zdrygl.service.ZdryJgdxqxjdjbService;
import com.founder.zdrygl.service.ZdryZdryzbService;
import com.founder.zdrygl.service.ZdrylxylbdybService;
import com.google.gson.Gson;

@Controller
@RequestMapping(value = "zdryJgdxqxjdjb")
public class ZdryJgdxqxjdjbController extends BaseController {

	private Logger logger = Logger.getLogger(this.getClass());

	@Resource(name = "zdryJgdxqxjdjbService")
	private ZdryJgdxqxjdjbService zdryJgdxqxjdjbService;

	@Resource(name = "zdryZdryzbService")
	private ZdryZdryzbService zdryZdryzbService;

	@Resource(name="zdrylxylbdybService")
	private ZdrylxylbdybService zdrylxylbdybService;
	
	@Resource(name = "orgOrganizationService")
	private OrgOrganizationService orgOrganizationService;
	
	@Resource(name = "orgPositionService")
	private OrgPositionService orgPositionService;
	
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
	public ModelAndView add(String id) {
		ModelAndView mv = new ModelAndView("zdrygl/edit/zdryJgdxqxjdjbAdd");
		ZdryJgdxqxjdjb entity = new ZdryJgdxqxjdjb();
		entity.setZdryid(id);
		mv.addObject("entity", entity);
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
	public ModelAndView save(ZdryJgdxqxjdjb entity, SessionBean sessionBean,String xm,String sfzh) {
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		Map<String, Object> map = new HashMap<String, Object>();
		sessionBean = getSessionBean(sessionBean);
		if(!zdryJgdxqxjdjbService.sfnqj(entity.getZdryid())){
			map.put(AppConst.STATUS, AppConst.FAIL);
			map.put(AppConst.MESSAGES, "该重点人员还有未销假的请假申请，不能再请假");
			mv.addObject(AppConst.MESSAGES, new Gson().toJson(map));
			return mv;
		}
		try {
			zdryJgdxqxjdjbService.save(entity, sessionBean);
			
			//启动审批流程
			Map<String, Object> variables =  new HashMap<String, Object>();
			ZdryZdryzb zdryZdryzb=zdryZdryzbService.queryById(entity.getZdryid());
			Zdrylxylbdyb zdrylxylbdyb=new Zdrylxylbdyb();
			zdrylxylbdyb.setLbdm(zdryZdryzb.getZdrygllxdm());
			String zdrylxmc =  zdrylxylbdybService.query(zdrylxylbdyb).getBz();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String createTime=formatter.format(new Date());//申请时间
			String  lrrzrq= sessionBean.getUserOrgCode();
			variables.put("createTime", createTime);
			variables.put("lrrzrq", lrrzrq);//录入人管辖责任区
	 		variables.put("zdryId", entity.getZdryid()); //重点人员总表Id
			variables.put("zdrylx", zdryZdryzb.getZdrygllxdm());//人员类型	
			variables.put("zdrylxmc", zdrylxmc);//人员类型名称	
			variables.put("xm", xm);//被列管人员姓名
			variables.put("zjhm", sfzh);//证件号码		
		    //variables.put("sqyj", zdryVO.getYwsqyy());//申请意见	
			variables.put("sqlx", "请假审批");//申请类型	
			variables.put("sqlxdm", "04");//申请类型为 请假
			
			variables.put("qjId", entity.getId());//请假ID
			
			OrgOrganization orgOrganization = orgOrganizationService.queryUpOrgByLevel(lrrzrq,"32");	
			String fsxOrgCode = orgOrganization.getOrgcode();//  得到本名等级为三级，派出所部门code
			String taskParameter = fsxOrgCode+"_"+orgPositionService.queryByPosid("SZ").getId().toString();   //部门code+所长岗位ID				
			variables.put("sz", taskParameter);
			variables.put("approvalMethod", "szApproval");
			
			processDefinitionService.startProcessInstance(sessionBean.getUserId(), "szsp", zdryZdryzb.getId(), variables);
			
			
			map.put(AppConst.STATUS, AppConst.SUCCESS);
			map.put(AppConst.MESSAGES, getAddSuccess());
			map.put(AppConst.SAVE_ID, "" + entity.getId()); // 返回主键
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
		mv.addObject("entity",zdryJgdxqxjdjbService.queryById(id));
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
	public ModelAndView update(ZdryJgdxqxjdjb entity, SessionBean sessionBean) {
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		Map<String, Object> map = new HashMap<String, Object>();
		sessionBean = getSessionBean(sessionBean);
		try {
			zdryJgdxqxjdjbService.update(entity, sessionBean);
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
	
	
	
	/*下方是历史代码，未调试，留待后续可能有用*/
	
	
	
	
	
	
	
	
	
	
	/*
	
	@RequestMapping(value = "/queryList", method = RequestMethod.POST)
	public @ResponseBody
	EasyUIPage queryList(EasyUIPage page,
			@RequestParam(value = "rows", required = false) Integer rows,
			ZdryJgdxqxjdjb entity, SessionBean sessionBean) {
		page.setPagePara(rows);
		sessionBean = getSessionBean(sessionBean);
		return zdryJgdxqxjdjbService.queryList(page, entity);
	}
	
	/**
	 * @Title: query
	 * @Description: TODO(查询列表页面)
	 * @param @return 设定文件
	 * @return ModelAndView 返回类型
	 * @throws
	 *
	@RequestMapping(value = "/query", method = RequestMethod.GET)
	public ModelAndView query() {
		ModelAndView mv = new ModelAndView("zdry/zdryJgdxqxjdjbQuery");
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
	 *
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

	/**
	 * @Title: edit
	 * @Description: TODO(编辑页面)
	 * @param @param id
	 * @param @return
	 * @param @throws BussinessException 设定文件
	 * @return ModelAndView 返回类型
	 * @throws
	 *
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ModelAndView edit(@PathVariable(value = "id") String id)
			throws BussinessException {
		ModelAndView mv = new ModelAndView("zdry/zdryJgdxqxjdjbEdit");
		ZdryJgdxqxjdjb entity = zdryJgdxqxjdjbService.queryById(id);
		if (entity == null) {
			throw new BussinessException("查询无数据！");
		}
		mv.addObject("entity", entity);
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
	 *
	@RequestMapping(value = "/sp", method = RequestMethod.GET)
	public ModelAndView sp(String id, Long messageid, SessionBean sessionBean)
			throws BussinessException {
		ModelAndView mv = new ModelAndView("zdry/zdryJgdxqxjdjbSp");
		ZdryJgdxqxjdjb entity = zdryJgdxqxjdjbService.queryById(id);
		if (entity == null) {
			throw new BussinessException("查询无数据！");
		}
		ZdryZdryzb zdryZdryzb = zdryZdryzbService.queryById(entity.getZdryid());
		mv.addObject("zdryZdryzb", zdryZdryzb);
		sessionBean = getSessionBean(sessionBean);
		entity.setSpr_id(sessionBean.getUserId());
		entity.setSpr_xm(sessionBean.getUserName());
		entity.setSpsj(DateUtils.getSystemDateString());
		entity.setMessageid(messageid);
		mv.addObject("entity", entity);
		return mv;
	}

	

	/**
	 * @Title: delete
	 * @Description: TODO(注销保存)
	 * @param @param entity
	 * @param @param sessionBean
	 * @param @return 设定文件
	 * @return ModelAndView 返回类型
	 * @throws
	 *
	@RequestMapping(value = "/{id}", method = { RequestMethod.DELETE })
	public ModelAndView delete(ZdryJgdxqxjdjb entity, SessionBean sessionBean) {
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		Map<String, Object> map = new HashMap<String, Object>();
		sessionBean = getSessionBean(sessionBean);
		try {
			zdryJgdxqxjdjbService.delete(entity, sessionBean);
			map.put(AppConst.STATUS, AppConst.SUCCESS);
			map.put(AppConst.MESSAGES, getDeleteSuccess());
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
			map.put(AppConst.STATUS, AppConst.FAIL);
			map.put(AppConst.MESSAGES, getDeleteFail());
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(map));
		return mv;
	}
*/
}
