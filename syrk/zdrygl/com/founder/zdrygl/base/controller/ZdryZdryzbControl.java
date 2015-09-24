package com.founder.zdrygl.base.controller;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.founder.framework.annotation.RestfulAnnotation;
import com.founder.framework.base.controller.BaseController;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.components.AppConst;
import com.founder.framework.exception.BussinessException;
import com.founder.framework.exception.RestException;
import com.founder.framework.organization.department.bean.OrgOrganization;
import com.founder.framework.organization.department.service.OrgOrganizationService;
import com.founder.framework.organization.position.service.OrgPositionService;
import com.founder.framework.organization.user.service.OrgUserService;
import com.founder.framework.utils.DateUtils;
import com.founder.framework.utils.EasyUIPage;
import com.founder.service.attachment.bean.ZpfjFjxxb;
import com.founder.service.attachment.service.ZpfjFjxxbService;
import com.founder.syrkgl.bean.SyrkSyrkxxzb;
import com.founder.syrkgl.service.RyRyjbxxbService;
import com.founder.syrkgl.service.SyrkSyrkxxzbService;
import com.founder.workflow.service.inteface.JProcessDefinitionService;
import com.founder.workflow.service.inteface.JProcessManageService;
import com.founder.workflow.service.inteface.JTaskService;
import com.founder.zdrygl.base.model.ZdryZb;
import com.founder.zdrygl.base.service.ZdryInfoQueryService;
import com.founder.zdrygl.base.vo.ZdryVO;
import com.founder.zdrygl.core.factory.ZdryAbstractFactory;
import com.founder.zdrygl.core.inteface.ZdryQueryService;
import com.founder.zdrygl.core.inteface.ZdryService;
import com.founder.zdrygl.core.utils.ZdryConstant;
import com.google.gson.Gson;

/**
 * ****************************************************************************
 * @Package:      [com.founder.zdrygl.base.controller.ZdryZdryzbControl.java]  
 * @ClassName:    [ZdryZdryzbControl]   
 * @Description:  [重点人员总表控制器]   
 * @Author:       [wei.wen@founder.com.cn]  
 * @CreateDate:   [2015年9月18日 下午3:20:01]   
 * @UpdateUser:   [wei.wen@founder.com.cn(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015年9月18日 下午3:20:01，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Controller
@RequestMapping("/zdryzb")
public class ZdryZdryzbControl extends BaseController {
	private Logger logger = Logger.getLogger(this.getClass());
	
	@Autowired
	public ZdryAbstractFactory zdryFactory;
	
	@Resource(name="zdryQueryService")
	private ZdryInfoQueryService zdryQueryService ;
	
	@Autowired
	private ZdryConstant zdryConstant;

	/*
	@Resource(name="zdrylxylbdybService")
	private ZdrylxylbdybService zdrylxylbdybService;
	@Resource		
	private ZdryShbzdryxxbService zdryShbzdryxxbService;
	
	@Resource(name = "zpfjFjxxbService")
	private ZpfjFjxxbService zpfjFjxxbService;
	
	@Resource(name="zdryZdryzbService")
	private ZdryZdryzbService zdryZdryzbService;
	
	@Resource(name="ZdryUntil")
	private ZdryUntil zdryUntil;
	
	@Resource(name = "syrkSyrkxxzbService")
	private SyrkSyrkxxzbService syrkSyrkxxzbService;
	
	@Autowired
	private JProcessDefinitionService processDefinitionService;

	@Autowired
	private JProcessManageService processManageService;

	@Autowired
	private JTaskService taskService;

	
	@Resource(name = "orgUserService")
	private OrgUserService orgUserService;
	
	@Resource(name = "orgOrganizationService")
	private OrgOrganizationService orgOrganizationService;
	
	@Resource(name = "orgPositionService")
	private OrgPositionService orgPositionService;
	@Resource
	private RyRyjbxxbService ryRyjbxxbService;
	/*
	@Resource
	private ZdrySgafzdryxxbService zdrySgafzdryxxbService;
	*/
	/**
	 * 
	 * @Title: manage
	 * @Description: TODO(打开重点人员管理列表)
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	@RequestMapping(value="/manager",method = RequestMethod.GET)
	public String manage(){
		zdryConstant.createTreeJS();
		return "zdrygl/zdryManage";
	}
	
	/**
	 * 
	 * @Title: getManageList
	 * @Description: TODO(重点人员管理列表 查询)
	 * @param @param page
	 * @param @param rows
	 * @param @param entity
	 * @param @param sessionBean
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	@RestfulAnnotation(serverId="3")
	@RequestMapping(value="/getManageList",method = RequestMethod.POST)
	public @ResponseBody EasyUIPage getManageList(EasyUIPage page,@RequestParam(value="rows",required = false)Integer rows,
			ZdryZb entity,SessionBean sessionBean){
		page.setPagePara(rows);
		entity.setGlbm(getSessionBean(sessionBean).getUserOrgCode());
		return zdryQueryService.queryList(page,entity);
	}
	
	/**
	 * 
	 * @Title: queryZdryOnPT
	 * @Description: TODO(重点人员查询 列表)
	 * @param @param page
	 * @param @param rows
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throw
	 */
	@RequestMapping(value = "/getQeryList", method = RequestMethod.POST)
	public @ResponseBody
	EasyUIPage getQeryList(EasyUIPage page,
			@RequestParam(value = "rows") Integer rows, 
			ZdryZb entity) {
		page.setPagePara(rows);

		return zdryQueryService.getQueryList(page,entity);
	}
	
	/**
	 * 
	 * @Title: queryZdryChildLbList
	 * @Description:  查询当前区域下的子类别列表
	 * @param @param lbdm_p 上级类型	 
	 * @param @return    设定文件
	 * @return List    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/queryZdryChildLbList", method = RequestMethod.GET)
	public @ResponseBody List queryZdryChildLbList(String lbdm_p) {		
		List list=zdryQueryService.getChildList(lbdm_p);		
		return list; 		
	}
	
	/**
	 * 
	 * @Title: zdryAddPre
	 * @Description: TODO(打开重点人员新增页面)
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	@RequestMapping(value="/zdryAddPre",method = RequestMethod.GET)
	public ModelAndView zdryAddPre(SessionBean sessionBean){
		ModelAndView mv = new ModelAndView("zdrygl/add/zdryAddPre");
		sessionBean = getSessionBean(sessionBean);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		mv.addObject("applyUser",sessionBean.getUserName());
		mv.addObject("applyDate",formatter.format(new Date()));
		return mv;
	}			
			
	
	/**
	 * 
	 * @Title: saveLg
	 * @Description: TODO(保存列管)
	 * @param @param zdryVO
	 * @param @param uploadFile
	 * @param @param sessionBean
	 * @param @return    设定文件
	 * @return ModelAndView    返回类型
	 * @throw
	 */
	@RequestMapping(value = "/saveLg", method = RequestMethod.POST)
	public ModelAndView saveLg(ZdryVO zdryVO, SessionBean sessionBean) {
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		Map<String, Object> model = new HashMap<String, Object>();
		sessionBean = getSessionBean(sessionBean);
		try{
			String zdrygllxdm=zdryVO.getZdryZdryzb().getZdrygllxdm();//重点人员类型		
			ZdryService zdryService = zdryFactory.createZdryService(zdrygllxdm, zdryVO.getZdryZdryzb(), zdryVO.getZdrylbdx());
			zdryService.lg(sessionBean);
			
			model.put(AppConst.STATUS, AppConst.SUCCESS);
			model.put(AppConst.MESSAGES, getAddSuccess());
		}catch(BussinessException e){
			e.printStackTrace();
			new RestException(e.getLocalizedMessage());
			logger.error(e.getLocalizedMessage(), e);
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, e.getLocalizedMessage());
		}catch (Exception e) {
			e.printStackTrace();
			new RestException(e.getLocalizedMessage());
			logger.error(e.getLocalizedMessage(), e);
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, getAddFail());
		}
		
		
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}
	

	/**
	 * 
	 * @Title: view
	 * @Description: TODO(打开重点人员编辑查看页面)
	 * @param @param mode 编辑模式
	 * @param @param mainTabID
	 * @param @param id 重点人员ID
	 * @param @return
	 * @param @throws BussinessException    设定文件
	 * @return ModelAndView    返回类型
	 * @throw
	 */
	@RequestMapping(value = "/{ryid}/{id}/view" ,method = RequestMethod.GET)
	public @ResponseBody ModelAndView view(
			@PathVariable(value="ryid")String ryid,
			@RequestParam(value="mode",defaultValue="edit")String mode,
			String mainTabID,
			@PathVariable(value="id")String id) throws BussinessException{
		ModelAndView mv = new ModelAndView("zdrygl/edit/zdryEdit");
		
		ZdryZb zdryZb=new ZdryZb();
		//ryid可能为空
		if(ryid!=null && ryid.length()>0){
			zdryZb.setRyid(ryid);
		}else{
			zdryZb.setId(id);
		}
		List zdryList =zdryQueryService.queryListByEntity(zdryZb);
		if(zdryList.isEmpty())
			throw new BussinessException("Zdry not Exist");
		
		ZdryZb temp = null;
		List<Map<String,String>> zdrylxList = new ArrayList<Map<String,String>>();
		Map<String,String> map = null;
		String zdrygllxmc;
		StringBuffer zdrylxBuffer = new StringBuffer();//已列管类型名字
		int sort = 0 ;
		for (int i = 0; i < zdryList.size(); i++) {
			map  = new HashMap<String,String>();
			temp = (ZdryZb) zdryList.get(i);
			map.put("zdryid", temp.getId());
			map.put("zdrylx", temp.getZdrygllxdm());
			
			//已列管 重点人员 类型
			zdrygllxmc=zdryConstant.zdryDict().get(temp.getZdrygllxdm());
			if(zdrygllxmc!=null && zdrygllxmc.length()>0){
				if(zdrylxBuffer.length()>0) zdrylxBuffer.append(" ");			
				zdrylxBuffer.append(zdrygllxmc);			
			}
					
			//只取当前重点人员id的重点人员类型
			if(temp.getId().equals(id)){
				mv.addObject("zdry", temp);	
				zdrylxList.add(map);
			}
			
		}		
		
		
		
		String zdrylxStr=zdrylxBuffer.toString();
		if(zdrylxStr.length()>17){
			mv.addObject("zdrylxMore", zdrylxBuffer.toString());//全部的已列管类型
			zdrylxStr=zdrylxStr.subSequence(0, 17)+"……";
		}				
		mv.addObject("zdrylx", zdrylxStr);//简化的已列管类型
		mv.addObject("zdrylxList", zdrylxList);
		mv.addObject("zdrylxJson", new Gson().toJson(zdrylxList));
		mv.addObject("mainTabID", mainTabID);
		mv.addObject("mode", mode);
		
		return mv;
	}
}

