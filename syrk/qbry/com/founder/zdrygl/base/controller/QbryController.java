package com.founder.zdrygl.base.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
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
import com.founder.framework.organization.department.bean.OrgOrganization;
import com.founder.framework.organization.department.service.OrgOrganizationService;
import com.founder.framework.utils.EasyUIPage;
import com.founder.syrkgl.bean.SyrkSyrkxxzb;
import com.founder.syrkgl.service.SyrkSyrkxxzbService;
import com.founder.zdrygl.base.model.ZdryQbxxb;
import com.founder.zdrygl.base.model.ZdryQbywb;
import com.founder.zdrygl.base.service.ZdryQbxxbService;
import com.founder.zdrygl.base.service.ZdryQbywbService;
import com.founder.zdrygl.core.utils.ZdryQbDict;

/**
 * ****************************************************************************
 * @Package:      [com.founder.zdrygl.base.controller.qbryController.java]  
 * @ClassName:    [qbryController]   
 * @Description:  [情报人员 控制器]   
 * @Author:       [zhang.hai@founder.com.cn]  
 * @CreateDate:   [2016年1月4日 上午9:42:26]   
 * @UpdateUser:   [ZhangHai(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2016年1月4日 上午9:42:26，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Controller
@RequestMapping("/qbryManager")
public class QbryController extends BaseController {
	private Logger logger = Logger.getLogger(this.getClass());
	
	@Resource(name = "orgOrganizationService")
	private OrgOrganizationService orgOrganizationService;
	
	@Resource(name = "zdryQbxxbService")
	private ZdryQbxxbService zdryQbxxbService;
	
	@Resource(name = "zdryQbywbService")
	private ZdryQbywbService zdryQbywbService;
	
	@Resource(name = "syrkSyrkxxzbService")
	private SyrkSyrkxxzbService syrkSyrkxxzbService;
	
	/**
	 * 
	 * @Title: qbryManager
	 * @Description: TODO(情报管理页面)
	 * @param @return
	 * @param @throw BussinessException    设定文件
	 * @return ModelAndView    返回类型
	 * @throw
	 */
	@RequestMapping(value = "/qbryManager", method = RequestMethod.GET)
	public ModelAndView qbryManager() throws BussinessException {
			ModelAndView mv = new ModelAndView("qbry/manager/qbryManage");		
			return mv;
		
	}
	
	/**
	 * 
	 * @Title: qbryQuery
	 * @Description: TODO(情报人员查询页面)
	 * @param @return
	 * @param @throw BussinessException    设定文件
	 * @return ModelAndView    返回类型
	 * @throw
	 */
	@RequestMapping(value = "/qbryQuery", method = RequestMethod.GET)
	public ModelAndView qbryQuery(SessionBean sessionBean) throws BussinessException {
			ModelAndView mv = new ModelAndView("qbry/query/qbryQuery");	
			
			sessionBean = getSessionBean(sessionBean);
			
			String qbzdCode = null;	//市局部门代码
			String qbddCode = null;	//分局部门代码
			String qbpcsCode = null;	//派出所部门代码
			
			String userOrgCode = sessionBean.getUserOrgCode();	//获取当前用户的部门代码
			String userOrgLevel = sessionBean.getUserOrgLevel();	//获取当前用户的部门级别
			
			if(userOrgLevel.equals("10")){
				qbzdCode = userOrgCode;
			}else if(userOrgLevel.equals("21")){//当前部门是分局
				OrgOrganization qbzdCodeObject = orgOrganizationService.queryParentOrgByOrgcode(userOrgCode);
				qbzdCode = qbzdCodeObject.getOrgcode();
				qbddCode = userOrgCode;
			}else if(userOrgLevel.equals("32")){//当前部门是派出所
				OrgOrganization qbddCodeObject = orgOrganizationService.queryParentOrgByOrgcode(userOrgCode);
				qbddCode = qbddCodeObject.getOrgcode();
				OrgOrganization qbzdCodeObject = orgOrganizationService.queryParentOrgByOrgcode(qbddCode);
				qbzdCode = qbzdCodeObject.getOrgcode(); 
				qbpcsCode = userOrgCode;
			}else if(userOrgLevel.equals("50")){//当前部门是责任区
				OrgOrganization qbpcsObject = orgOrganizationService.queryParentOrgByOrgcode(userOrgCode);
				qbpcsCode = qbpcsObject.getOrgcode();
				OrgOrganization qbddCodeObject = orgOrganizationService.queryParentOrgByOrgcode(qbpcsCode);
				qbddCode = qbddCodeObject.getOrgcode();
				OrgOrganization qbzdCodeObject = orgOrganizationService.queryParentOrgByOrgcode(qbddCode);
				qbzdCode = qbzdCodeObject.getOrgcode();
			}
			mv.addObject("qbzdCode",qbzdCode);
			mv.addObject("qbddCode",qbddCode);
			mv.addObject("qbpcsCode",qbpcsCode);
			return mv;
		
	}
	
	
	/**
	 * 
	 * @Title: queryList
	 * @Description: TODO(情报人员管理列表)
	 * @param @param page
	 * @param @param rows
	 * @param @param entity
	 * @param @param sessionBean
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/{type}/queryList", method = RequestMethod.POST)
	public @ResponseBody
	EasyUIPage queryList(EasyUIPage page,@PathVariable(value = "type") String pagetype,@RequestParam(value = "rows", required = false) Integer rows,ZdryQbxxb entity, SessionBean sessionBean) {
		page.setPagePara(rows);
		sessionBean = getSessionBean(sessionBean);
		 
		//通过登录人来获取组织结构级别和组织机构代码,然后来设置相应的支队的代码
		OrgOrganization userOrg = orgOrganizationService.queryById(sessionBean.getUserOrgId());
		String orglevel = userOrg.getOrglevel();
		if(("10").equals(orglevel)){
			entity.setQbzd((String) sessionBean.getUserOrgCode());
		} else if (("21").equals(orglevel)) {
			entity.setQbdd((String) sessionBean.getUserOrgCode());
		} else if ("32".equals(orglevel)) {
			entity.setQbpcs((String) sessionBean.getUserOrgCode());
		} else if ("50".equals(orglevel)) {
			entity.setQbzrq((String) sessionBean.getUserOrgCode());
		}
		if(pagetype.equals("Manage")){//情报重点人员管理页面
			entity.setDqjb(orglevel);
		}
		return zdryQbxxbService.queryList(entity, page);
	}
	
	/**
	 * 
	 * @Title: gotoqbryadd
	 * @Description: (前往新增页面)
	 * @param @return    设定文件
	 * @return ModelAndView    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/qbryadd")
	public  ModelAndView gotoqbryadd(){			
		ModelAndView mv = new ModelAndView("qbry/getqbry/qbryGet");		
		return mv;
	}
	/**
	 * 
	 * @Title: qbryget
	 * @Description: TODO(验证信息,新增人口)
	 * @param @return    设定文件
	 * @return ModelAndView    返回类型
	 * @throws
	 */
	@RequestMapping(value ="/qbryget", method = RequestMethod.POST)
	public ModelAndView qbryget(ZdryQbxxb qbzdrymsg,SessionBean sessionBean){
		 /*验证字段
		  *调用别的service验证：
		  * 1.情报人员在实有人口表里是否已存在
		  * 自己的service里完成验证功能：
		  * 1.身份证号是否存在以及位数是否正确（18位）	  		  
		  */		
		   ModelAndView mv = new ModelAndView(getViewName(sessionBean));		
		   sessionBean = getSessionBean(sessionBean); 		          
		   SyrkSyrkxxzb entity=new  SyrkSyrkxxzb();
		  //ZJHM(证件号码)【默认身份证】、
		 //可增加查询条件字段： JZD_DZID（居住地详细地址）、 CYZJDM（证件种类）
		   entity.setZjhm(qbzdrymsg.getGmsfhm());
		   entity = syrkSyrkxxzbService.querySyrkxxzb(entity);
		   if(entity!=null) 	    	
		   qbzdrymsg.setSyrkid(entity.getId());
	       try{			        		     	        	   
		      zdryQbxxbService.save(qbzdrymsg,sessionBean);
			  System.out.println("保存成功！");					
			  mv = new ModelAndView("qbry/manager/qbryManage");					 
			   }catch(Exception e){
			  logger.error(e.getLocalizedMessage(), e);							   
			  System.out.println("保存失败!");							   							  
			}	
	       
	       return mv;
	}	
	
	/**
	 * 
	 * @Title: view
	 * @Description: 跳转情报人员编辑页面
	 * @param @param qbryid
	 * @param @return    设定文件
	 * @return ModelAndView    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/{type}/{ryid}/view", method = RequestMethod.GET)
	public ModelAndView view(@PathVariable(value = "ryid") String qbryid,@PathVariable(value = "type") String type,SessionBean sessionBean){
			ModelAndView mv = null ;
			
			if(type.equals("Detail")){
				mv = new ModelAndView("qbry/query/qbryDetail");
			}
			else if(type.equals("Edit")){
				mv = new ModelAndView("qbry/manager/qbryEdit");
			}
			
			ZdryQbxxb qbxxb = zdryQbxxbService.queryById(qbryid);
			mv.addObject("qbry",qbxxb);
			
			sessionBean = getSessionBean(sessionBean);
			mv.addObject("orgCode",sessionBean.getUserOrgCode());
			mv.addObject("orgLevel",sessionBean.getUserOrgLevel());
			return mv;
	}

	/**
	 * 
	 * @Title: ywList
	 * @Description: 根据身份证号查询业务操作记录
	 * @param @param gmsfhm
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/ywList/{gmsfhm}", method = RequestMethod.POST)
	public @ResponseBody 
		EasyUIPage ywList(EasyUIPage page,@PathVariable(value = "gmsfhm") String gmsfhm,@RequestParam(value = "rows", required = false) Integer rows, 
				ZdryQbywb entity,SessionBean sessionBean){
			page.setPagePara(rows);
			return zdryQbywbService.queryListByZjhm(gmsfhm,page,entity);
	}
	
	/**
	 * 
	 * @Title: sendBack
	 * @Description: TODO(退回申请)
	 * @param @param id
	 * @param @param czyj
	 * @param @param sessionBean
	 * @param @return    设定文件
	 * @return Map<String,Object>    返回类型
	 * @throw
	 */
	@RequestMapping(value = "/sendBack", method = RequestMethod.POST)
    public  @ResponseBody Map<String, Object> sendBack(String id,String czyj,SessionBean sessionBean){
		
		Map<String, Object> model = new HashMap<String, Object>();
		sessionBean = getSessionBean(sessionBean);
		try{		
		  ZdryQbxxb zdrtqbxxb=zdryQbxxbService.queryById(id);//查询情报人员信息
			if(zdrtqbxxb==null){
				throw new BussinessException("未查询到该情报人员信息！");
			}
			
			zdrtqbxxb.setGlzt(ZdryQbDict.GLZT_THSQZ);//退回申请中
		    zdryQbxxbService.update(zdrtqbxxb, sessionBean);
		    
		    //添加业务操作记录
		    ZdryQbywb zdryqbywb=new ZdryQbywb();
		    zdryqbywb.setCzlb(ZdryQbDict.YWCZLX_TH);//退回
		    zdryqbywb.setCzyj(czyj); //把回退原因写到操作意见里	
		    zdryqbywb.setGmsfhm(zdrtqbxxb.getGmsfhm());
		    zdryQbywbService.insert( zdryqbywb, sessionBean);
		    
		    model.put(AppConst.STATUS, AppConst.SUCCESS);
			model.put(AppConst.MESSAGES, "退回成功");
		} catch (BussinessException e) {
			logger.error(e.getLocalizedMessage(), e);
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, e.getLocalizedMessage());
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage(), e);
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, "退回失败！");
		}
    	return model;
    }
	
	/**
	 * 
	 * @Title: sendBackCancel
	 * @Description: TODO(退回撤销)
	 * @param @param id
	 * @param @param czyj
	 * @param @param sessionBean
	 * @param @return    设定文件
	 * @return Map<String,Object>    返回类型
	 * @throw
	 */
	@RequestMapping(value = "/sendBackCancel", method = RequestMethod.POST)
    public  @ResponseBody Map<String, Object> sendBackCancel(String id,String czyj,SessionBean sessionBean){
		
		Map<String, Object> model = new HashMap<String, Object>();
		sessionBean = getSessionBean(sessionBean);
		try{		
		  ZdryQbxxb zdrtqbxxb=zdryQbxxbService.queryById(id);//查询情报人员信息
			if(zdrtqbxxb==null){
				throw new BussinessException("未查询到该情报人员信息！");
			}
			
			zdrtqbxxb.setGlzt(ZdryQbDict.GLZT_DXF);//改为待下发
		    zdryQbxxbService.update(zdrtqbxxb, sessionBean);
		    
		    //添加业务操作记录
		    ZdryQbywb zdryqbywb=new ZdryQbywb();
		    zdryqbywb.setCzlb(ZdryQbDict.YWCZLX_THCX);//退回撤销
		    zdryqbywb.setCzyj(czyj); //把回退原因写到操作意见里	
		    zdryqbywb.setGmsfhm(zdrtqbxxb.getGmsfhm());
		    zdryQbywbService.insert( zdryqbywb, sessionBean);
		    
		    model.put(AppConst.STATUS, AppConst.SUCCESS);
			model.put(AppConst.MESSAGES, "退回成功");
		} catch (BussinessException e) {
			logger.error(e.getLocalizedMessage(), e);
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, e.getLocalizedMessage());
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage(), e);
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, "退回失败！");
		}
    	return model;
    }
	
	/**
	 * 
	 * @Title: saveLg
	 * @Description: TODO(情报人员接收，列管)
	 * @param @param id 情报人员ID
	 * @param @param sessionBean
	 * @param @return    设定文件
	 * @return ModelAndView    返回类型
	 * @throw
	 */
	@RequestMapping(value = "/saveLg", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> saveLg(String id,String czyj,SessionBean sessionBean) {
		Map<String, Object> model = new HashMap<String, Object>();
		sessionBean = getSessionBean(sessionBean);
		try {
			ZdryQbxxb entity = zdryQbxxbService.queryById(id);//查询情报人员信息			
			if(entity==null){
				throw new BussinessException("未查询到该情报人员信息！");
			}
			if(entity.getSyrkid()==null){
				throw new BussinessException("请先添加实有人口信息！");
			}
			
			//查询实有人口信息
			SyrkSyrkxxzb syrkEntity = syrkSyrkxxzbService.queryById(entity.getSyrkid());
			if(syrkEntity==null){
				throw new BussinessException("未查询到该重点人员对应的实有人口信息！");
			}
			
			zdryQbxxbService.saveLg(entity,syrkEntity,sessionBean);
			
			//添加业务操作记录
			ZdryQbywb qbywbEntity = new ZdryQbywb();
			qbywbEntity.setCzlb(ZdryQbDict.YWCZLX_JS);
			qbywbEntity.setCzyj(czyj);
			qbywbEntity.setGmsfhm(entity.getGmsfhm());
			zdryQbywbService.insert(qbywbEntity, sessionBean);
			
			model.put(AppConst.STATUS, AppConst.SUCCESS);
			model.put(AppConst.MESSAGES, "接收成功");
		} catch (BussinessException e) {
			logger.error(e.getLocalizedMessage(), e);
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, e.getLocalizedMessage());
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage(), e);
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, "接收失败！");
		}

		return model;

	}

	/**
	 * 
	 * @Title: send
	 * @Description: (下发)
	 * @param @param id 情报人员ID
	 * @param @param sessionBean
	 * @param @return    设定文件
	 * @return ModelAndView    返回类型
	 * @throw
	 */
	@RequestMapping(value = "/sendDown", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> sendDown(ZdryQbywb yewuBean,SessionBean sessionBean) {
		Map<String, Object> model = new HashMap<String, Object>();
		sessionBean = getSessionBean(sessionBean);
		try {
			ZdryQbxxb zdrtqbxxb=zdryQbxxbService.queryById(yewuBean.getId());//查询情报人员信息
			if(zdrtqbxxb==null){
				throw new BussinessException("未查询到该情报人员信息！");
			}
			
			String orgLevel = sessionBean.getUserOrgLevel();
			if("10".equals(orgLevel)){//市局，设置下级机构
				zdrtqbxxb.setDqjb("21");
				zdrtqbxxb.setQbdd(yewuBean.getMbbmdm());
				zdrtqbxxb.setQbddmc(yewuBean.getMbbmmc());
			}else if("21".equals(orgLevel)){//分县局
				zdrtqbxxb.setDqjb("32");
				zdrtqbxxb.setQbpcs(yewuBean.getMbbmdm());
				zdrtqbxxb.setQbpcsmc(yewuBean.getMbbmmc());
			}else if("32".equals(orgLevel)){//派出所
				zdrtqbxxb.setDqjb("50");//责任区
				zdrtqbxxb.setQbzrq(yewuBean.getMbbmdm());
				zdrtqbxxb.setQbzrqmc(yewuBean.getMbbmmc());
			}
		    zdryQbxxbService.update(zdrtqbxxb, sessionBean);
			
			//添加操作记录
			yewuBean.setCzlb(ZdryQbDict.YWCZLX_XF);//下发
			zdryQbywbService.insert(yewuBean,sessionBean);
			model.put(AppConst.STATUS, AppConst.SUCCESS);
			model.put(AppConst.MESSAGES, "下发成功");
			
		} catch (BussinessException e) {
			logger.error(e.getLocalizedMessage(), e);
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, e.getLocalizedMessage());
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage(), e);
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, "下发失败！");
		}
		return model;
	}
}
