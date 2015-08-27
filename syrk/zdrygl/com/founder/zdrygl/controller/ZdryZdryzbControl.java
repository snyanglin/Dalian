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
import com.founder.framework.utils.MapUtils;
import com.founder.service.attachment.bean.ZpfjFjxxb;
import com.founder.service.attachment.service.ZpfjFjxxbService;
import com.founder.syrkgl.bean.SyrkSyrkxxzb;
import com.founder.syrkgl.service.RyRyjbxxbService;
import com.founder.syrkgl.service.SyrkSyrkxxzbService;
import com.founder.workflow.service.inteface.JProcessDefinitionService;
import com.founder.workflow.service.inteface.JProcessManageService;
import com.founder.workflow.service.inteface.JTaskService;
import com.founder.zdrygl.bean.ZdryGzb;
import com.founder.zdrygl.bean.ZdrySgafzdryxxb;
import com.founder.zdrygl.bean.ZdryShbzdryxxb;
import com.founder.zdrygl.bean.ZdryZdryzb;
import com.founder.zdrygl.bean.Zdrylxylbdyb;
import com.founder.zdrygl.dao.ZdryGzbDao;
import com.founder.zdrygl.service.ZdryHsbService;
import com.founder.zdrygl.service.ZdrySgafzdryxxbService;
import com.founder.zdrygl.service.ZdryShbzdryxxbService;
import com.founder.zdrygl.service.ZdryZdryzbService;
import com.founder.zdrygl.service.ZdrylxylbdybService;
import com.founder.zdrygl.until.ZdryUntil;
import com.founder.zdrygl.vo.ZdryVO;
import com.founder.zdrygl.vo.ZdryZdryzbVO;
import com.google.gson.Gson;

/**
 * ****************************************************************************
 * @Package:      [com.founder.zdrygl.controller.ZdryZdryzbControl.java]  
 * @ClassName:    [ZdryZdryzbControl]   
 * @Description:  [重点人员总表]   
 * @Author:       [weiwen]  
 * @CreateDate:   [2015-3-19 上午10:51:54]   
 * @UpdateUser:   [weiwen]   
 * @UpdateDate:   [2015-3-19 上午10:51:54，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Controller
@RequestMapping("/zdryzb")
public class ZdryZdryzbControl extends BaseController {
	private Logger logger = Logger.getLogger(this.getClass());
	
	@Resource(name="zdrylxylbdybService")
	private ZdrylxylbdybService zdrylxylbdybService;
	@Resource		
	private ZdryShbzdryxxbService zdryShbzdryxxbService;
	
	@Resource(name = "zdryHsbService")
	private ZdryHsbService zdryHsbService;
	
	@Resource(name = "zpfjFjxxbService")
	private ZpfjFjxxbService zpfjFjxxbService;
	
	@Resource(name="zdryZdryzbService")
	private ZdryZdryzbService zdryZdryzbService;
	
	@Resource(name="ZdryUntil")
	private ZdryUntil zdryUntil;
	
	@Resource(name = "syrkSyrkxxzbService")
	private SyrkSyrkxxzbService syrkSyrkxxzbService;
	
	@Resource(name = "zdryGzbDao")
	private ZdryGzbDao zdryGzbDao;
	
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
	
	@Resource
	private ZdrySgafzdryxxbService zdrySgafzdryxxbService;
	
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
		return "zdrygl/zdryManage";
	}
	
	/**
	 * 
	 * @Title: list
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param page
	 * @param @param rows
	 * @param @param entity
	 * @param @param sessionBean
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	@RestfulAnnotation(serverId="3")
	@RequestMapping(value="/list",method = RequestMethod.POST)
	public @ResponseBody EasyUIPage list(EasyUIPage page,@RequestParam(value="rows",required = false)Integer rows,
			ZdryZdryzbVO entity,SessionBean sessionBean){
		page.setPagePara(rows);
		entity.setGlbm(getSessionBean(sessionBean).getUserOrgCode());
		try{
			String type=entity.getZdrygllxdm();//列管类型,查询时可能为空		
			String strAry[]=type.split("/");
			type=strAry[0];
			entity.setZdrygllxdm(type);	
		}catch(Exception e){}
		return zdryZdryzbService.queryList(entity, page);
	}
	
	/**
	 * 地图查询
	 * @param page
	 * @param rows
	 * @param entity
	 * @return
	 */
	@RequestMapping(value = "/queryZdryOnPT", method = RequestMethod.POST)
	public @ResponseBody
	EasyUIPage queryDwDzOnPT(EasyUIPage page,
			@RequestParam(value = "rows") Integer rows, ZdryZdryzbVO entity) {
		page.setPagePara(rows);
		try{
			String type=entity.getZdrygllxdm();//列管类型,查询时可能为空		
			String strAry[]=type.split("/");
			type=strAry[0];
			entity.setZdrygllxdm(type);	
		}catch(Exception e){}
		return zdryZdryzbService.queryDwDzOnPT(page,entity);
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
	
	/***
	 * 
	 * @Title: getZdrylbdmExceptYlg
	 * @Description: 根据大类取小类,去掉已列管
	 * @author wu_chunhui@founder.com.cn
	 * @param @return
	 * @return String
	 * @throws
	 */
	//以前查类别的接口，可能要删除
//	@RequestMapping(value = "/getZdrylbdmExceptYlg", method = RequestMethod.POST)
//	public @ResponseBody
//	String getZdrylbdmExceptYlg(String zdrylxdm, String syrkid) {
//		String zdrylbdm = "";
//		List<Zdrylxylbdyb> zdrylbdmList = zdrylxylbdybService
//				.queryZdrylbdm(zdrylxdm);
//		List<String> zdrylbdmListStr = zdrylxylbdybService.getZdrylbdmExceptYlg(
//				zdrylbdmList, syrkid);
//		for (int i = 0; i < zdrylbdmListStr.size(); i++) {
//			if (i == zdrylbdmListStr.size() - 1) {
//				zdrylbdm += zdrylbdmListStr.get(i);
//			} else {
//				zdrylbdm += zdrylbdmListStr.get(i) + "|";
//			}
//		}
//		
//		if(zdrylbdm.equals("")) return zdrylbdm;
//		return "^("+zdrylbdm+")$";
//	}
	
	
	
	/***
	 * 
	 * @Title: createLg
	 * @Description: 以前从实有人口管理跳转的列管，可能会删除
	 * @author wu_chunhui@founder.com.cn
	 * @param @param ryid
	 * @param @return
	 * @return ModelAndView
	 * @throws
	 */
	@RequestMapping(value = "/createLcg/{ywlx}", method = { RequestMethod.POST,RequestMethod.GET})
	public ModelAndView createLg(String syrkid,
			@RequestParam(required = true) String ryid,
			@PathVariable(value = "ywlx") String ywlx, String zdrygllxdm,
			String zdryHsbId) {
		ModelAndView mv = new ModelAndView("zdry/zdryLcg");
		return mv;
	}
	
	/***
	 * 
	 * @Title: saveLg
	 * @Description: 列管保存逻辑。
	 * @author wu_chunhui@founder.com.cn
	 * @param @return
	 * @return ModelAndView
	 * @throws
	 */
	@RequestMapping(value = "/saveLg", method = RequestMethod.POST)
	public ModelAndView saveLg(ZdryVO zdryVO, @RequestParam(value="uploadFile") CommonsMultipartFile[] uploadFile,SessionBean sessionBean) {
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		Map<String, Object> model = new HashMap<String, Object>();
		sessionBean = getSessionBean(sessionBean);
		
		ZdryZdryzb zdryZdryzb = zdryVO.getZdryZdryzb();
							
		zdryZdryzb.setGlbm(sessionBean.getUserOrgCode());
		BaseService.setSaveProperties(zdryZdryzb, sessionBean);					
		
		String type=zdryZdryzb.getZdrygllxdm();//列管类型
		String strAry[]=type.split("/");
		type=strAry[0];
		zdryZdryzb.setZdrygllxdm(type);
		
		//验证是否可列管
		String ylgStr=this.queryYlglx(zdryZdryzb.getRyid(), zdryZdryzb.getSyrkid());
		if(ylgStr.contains("/")){
			String[] ylgStrAry=ylgStr.split("/");
			String klgStr=this.queryklglx(ylgStrAry[1]);	
			if(!klgStr.contains(type)){//不在可列管类型中
				throw new BussinessException("当前列管类型不在可列管类型中");
			}
		}
		
		try {			
			
			zdryUntil.initZdryEntity(strAry[1],zdryVO,sessionBean);
			zdryUntil.getZdryService(strAry[1]).saveLg(zdryVO);	
			
			if("SQJZRY".equals(strAry[1])){
				List<ZpfjFjxxb> list = new ArrayList<ZpfjFjxxb>();

				for (int i = 0; i < uploadFile.length; i++) {
					CommonsMultipartFile multipartFile = uploadFile[i];
					if (!multipartFile.isEmpty()) {
						FileItem fileItem = multipartFile.getFileItem();
						ZpfjFjxxb entity = new ZpfjFjxxb();
						entity.setLybm("ZDRY_ZDRYZB");
						entity.setLyid(zdryVO.getZdryZdryzb().getId());
						entity.setLyms("社区矫正人员-判决书");
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
			}
			
		
	
			Map<String, Object> variables =  new HashMap<String, Object>();
			String  lrrzrq= sessionBean.getUserOrgCode();
			String zdryxm = zdryVO.getXm();
			Zdrylxylbdyb zdrylxylbdyb=new Zdrylxylbdyb();
			zdrylxylbdyb.setLbdm(zdryZdryzb.getZdrygllxdm());
			String zdrylxmc =  zdrylxylbdybService.query(zdrylxylbdyb).getBz();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String createTime=formatter.format(new Date());//申请时间
			variables.put("createTime", createTime);
			variables.put("lrrzrq", lrrzrq);//录入人管辖责任区
	 		variables.put("zdryId", zdryZdryzb.getId()); //重点人员总表Id
			variables.put("zdrylx", zdryZdryzb.getZdrygllxdm());//人员类型	
			variables.put("zdrylxmc", zdrylxmc);//人员类型名称	
			variables.put("xm", zdryxm);//被列管人员姓名
			variables.put("zjhm", zdryVO.getZjhm());//证件号码
		//	variables.put("splx", "重点人口列管");//审批类型	  			
		    variables.put("sqyj", zdryVO.getYwsqyy());//申请意见		
			if(zdryZdryzb.getZdrygllxdm().equals("07")){//环保
				variables.put("sqlx", "涉环保");
				variables.put("sqlxdm", "01");//列管01  撤管02
				variables.put("splevel", "1");//设置审批级别，一级审批
				variables.put("sqrOrgCode",sessionBean.getUserOrgCode());//设置申请人组织机构代码
				variables.put("sqrOrgLevel",sessionBean.getUserOrgLevel());//设置申请人组织机构级别
				variables.put("approvalMethod", "shbApproval");
				variables.put("zdryId", zdryZdryzb.getId());
				variables.put("sqyj", "申请将"+zdryVO.getZdryShbzdryxxb().getXm()+"列管为涉环保重点人员");
				variables.put("xm", zdryVO.getZdryShbzdryxxb().getXm());//被列管人员姓名
				variables.put("zjhm", zdryVO.getZdryShbzdryxxb().getZjhm());//证件号码

			processDefinitionService.startProcessInstance(sessionBean.getUserId(), "shb_lcg", zdryZdryzb.getId(), variables);	
			}
			else if(zdryZdryzb.getZdrygllxdm().equals("06")){//其他关注对象
			
				zdryUntil.lgSuccess(zdryZdryzb.getId(), zdryxm, sessionBean.getUserId(), sessionBean.getUserName(), sessionBean.getUserOrgCode(), null);
		}
			else if(zdryZdryzb.getZdrygllxdm().equals("05")){//涉公安访
			variables.put("sqlx", "涉公安访列管");
			variables.put("sqlxdm", "01");//列管01  撤管02
			
			OrgOrganization orgOrganization = orgOrganizationService.queryUpOrgByLevel(lrrzrq,"32");	
			String fsxOrgCode = orgOrganization.getOrgcode();//  得到本名等级为三级，派出所部门code
			String taskParameter = fsxOrgCode+"_"+orgPositionService.queryByPosid("SZ").getId().toString();   //部门code+所长岗位ID
			variables.put("approvalMethod", "sgafApproval");
			variables.put("szsp", taskParameter);
			processDefinitionService.startProcessInstance(sessionBean.getUserId(), "sgaj_lcg", zdryZdryzb.getId(), variables);	
		}
		else{//治安
		
		if(zdryZdryzb.getZdrygllxdm().equals("01")){
			if("0104".equals(zdryZdryzbService.queryById(zdryZdryzb.getId()).getZdrylb())){
				
				variables.put("sqlx", "治安列管");//申请类型	
				variables.put("sqlxdm", "01");//申请类型为列管
				processDefinitionService.startProcessInstance(sessionBean.getUserId(), "zalcg", zdryZdryzb.getId(), variables);
			}	
			else{
				zdryUntil.lgSuccess(zdryZdryzb.getId(), zdryxm, sessionBean.getUserId(), sessionBean.getUserName(), sessionBean.getUserOrgCode(), null);
			}	
			
		}	
		else{
				variables.put("sqlx", "治安列管");//申请类型	
				variables.put("sqlxdm", "01");//申请类型为列管
				processDefinitionService.startProcessInstance(sessionBean.getUserId(), "zalcg", zdryZdryzb.getId(), variables);
	
		}
	}	
		
			
			model.put(AppConst.STATUS, AppConst.SUCCESS);
			model.put(AppConst.MESSAGES, getAddSuccess());
			
		}catch(BussinessException e){
			e.printStackTrace();
			new RestException(e.getLocalizedMessage());
			logger.error(e.getLocalizedMessage(), e);
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, e.getLocalizedMessage());
		}
		catch (Exception e) {
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
	 * @Title: queryZdryTopLbList
	 * @Description: 查询当前区域下的一级类别列表
	 * @param @param sessionBean
	 * @param @return    设定文件
	 * @return List    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/queryZdryTopLbList", method = RequestMethod.GET)
	public @ResponseBody List queryZdryTopLbList(SessionBean sessionBean) {
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		Map<String, Object> model = new HashMap<String, Object>();
		List list=zdrylxylbdybService.getTopList();
		Zdrylxylbdyb zdrylxylbdyb;
		for(int i=0;i<list.size();i++){
			zdrylxylbdyb=(Zdrylxylbdyb) list.get(i);
			zdrylxylbdyb.setLbdm(zdrylxylbdyb.getLbdm()+"/"+zdrylxylbdyb.getFz());
		}
		return list; 		
	}
	
	/**
	 * 
	 * @Title: queryZdryChildLbList
	 * @Description:  查询当前区域下的子类别列表
	 * @param @param lbdm_p
	 * @param @param sessionBean
	 * @param @return    设定文件
	 * @return List    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/queryZdryChildLbList", method = RequestMethod.GET)
	public @ResponseBody List queryZdryChildLbList(String lbdm_p,SessionBean sessionBean) {
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		Map<String, Object> model = new HashMap<String, Object>();
		List list=zdrylxylbdybService.getChildList(lbdm_p);
		Map map,childMap;
		List childList,childList2;
		for(int i=0;i<list.size();i++){
			map=(Map) list.get(i);
			childList=zdrylxylbdybService.getChildList(map.get("id").toString());
			if(childList!=null && childList.size()>0){//二级树结构
				map.put("state", "closed");
				map.put("children", childList);
				for(int j=0;j<childList.size();j++){//三级树结构
					childMap=(Map) childList.get(j);
					childList2=zdrylxylbdybService.getChildList(childMap.get("id").toString());
					if(childList2!=null && childList2.size()>0){
						childMap.put("state", "closed");
						childMap.put("children", childList2);
					}
				}
			}
		}		
		return list; 		
	}
	
	
	/**
	 * 
	 * @Title: view
	 * @Description: TODO(打开重点人员编辑查看页面)
	 * @param @param ryid
	 * @param @param id
	 * @param @param mode
	 * @param @param mainTabID
	 * @param @return
	 * @param @throws BussinessException    设定文件
	 * @return ModelAndView    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/{ryid}/{id}/view" ,method = RequestMethod.GET)
	public @ResponseBody ModelAndView view(@PathVariable(value="ryid")String ryid,
			@RequestParam(value="mode",defaultValue="edit")String mode,String mainTabID,@PathVariable(value="id")String id) throws BussinessException{
		ModelAndView mv = new ModelAndView("zdrygl/edit/zdryEdit");
		
		List zdryList =zdryZdryzbService.queryList(ryid);
		
		/** 1. syrkid 判断是否当前人管理
		 *  2. glzt 只查2，3
		*/
		if(zdryList.isEmpty())
			throw new BussinessException("syrk.notExist");
		
		ZdryZdryzbVO temp = null;
		List<Map<String,String>> zdrylxList = new ArrayList<Map<String,String>>();
		Map<String,String> map = null;
		StringBuffer zdrylxBuffer = new StringBuffer();//本人管理类型
		int sort = 0 ;
		for (int i = 0; i < zdryList.size(); i++) {
			map  = new HashMap<String,String>();
			temp = (ZdryZdryzbVO) zdryList.get(i);
			map.put("zdryid", temp.getId());
			map.put("zdrylx", temp.getZdrygllxdm());
			map.put("fz", temp.getFz());
			//map.put("gxzrq", temp.getSszrqdm());
		/*	if("07".equals(temp.getZdrygllxdm())){
				map.put("isEdit", "1");
			}else{
				if(syrkid.equals(temp.getSyrkid())){
				*/
					//已列管 重点人员 类型
					if(zdrylxBuffer.length()>0) zdrylxBuffer.append(" ");
					zdrylxBuffer.append(temp.getZdrygllxmc());
					/*
					map.put("isEdit", "1");
					zdryList.remove(i);
					zdryList.add(sort++, temp);
				}else{
					map.put("isEdit", "0");
				}
			}*/
					
			//只取当前重点人员id的重点人员类型
			if(temp.getId().equals(id)){
				zdrylxList.add(map);
			}
		}
		((ZdryZdryzbVO)zdryList.get(0)).setId(id);//设置从列表点击过来的重点人员id，区分后续操作是哪个类型
		mv.addObject("zdry", zdryList.get(0));
		mv.addObject("mode", mode);
		
		String zdrylxStr=zdrylxBuffer.toString();
		if(zdrylxStr.length()>17){
			mv.addObject("zdrylxMore", zdrylxBuffer.toString());
			zdrylxStr=zdrylxStr.subSequence(0, 17)+"……";
		}				
		mv.addObject("zdrylx", zdrylxStr);
		mv.addObject("zdrylxList", zdrylxList);
		mv.addObject("zdrylxJson", new Gson().toJson(zdrylxList));
		mv.addObject("mainTabID", mainTabID);
		
		
		return mv;
	}
	
	
	@RequestMapping(value = "/{zdrySgafzdryxxbId}/sgafview" ,method = RequestMethod.GET)
	public ModelAndView sgafview(@PathVariable(value="zdrySgafzdryxxbId")String zdrySgafzdryxxbId,
			@RequestParam(value="mode",defaultValue="edit")String mode,String mainTabID,SessionBean sessionBean) throws BussinessException{
		sessionBean=getSessionBean(sessionBean);
		
		ModelAndView mv = new ModelAndView("zdrygl/edit/zdryEdit");
		
		String ryid = zdrySgafzdryxxbService.queryRyidByZdrySgafzdryId(zdrySgafzdryxxbId);
		if(StringUtils.isBlank(ryid)){
			throw  new BussinessException("数据不整合 ");
		}
		List zdryList =zdryZdryzbService.querySgafList(ryid);

		ZdryZdryzbVO temp = null;
		List<Map<String,String>> zdrylxList = new ArrayList<Map<String,String>>();
		Map<String,String> map = null;
		List<String> zdrylx = new ArrayList<String>();//本人管理类型
		int sort = 0 ;
		for (int i = 0; i < zdryList.size(); i++) {
			map  = new HashMap<String,String>();
			temp = (ZdryZdryzbVO)zdryList.get(i);
			ZdrySgafzdryxxb sgaf=this.zdrySgafzdryxxbService.queryById(temp.getId());
			map.put("zdryid", temp.getId());
			map.put("zdrylx", temp.getZdrygllxdm());
			//map.put("gxzrq", temp.getSszrqdm());
			if(sgaf.getSszrq()!=null){
				if(sgaf.getSszrq().equals(sessionBean.getUserOrgCode())){
					map.put("isEdit", "1");
				}else{
					map.put("isEdit", "0");
				}
				zdrylx.add(temp.getZdrygllxmc());
				
				zdryList.remove(i);
				zdryList.add(sort++, temp);
			}else{
				map.put("isEdit", "0");
			}
				
			zdrylxList.add(map);
		}
		//ZdrySgafzdryxxb sgaf=this.zdrySgafzdryxxbService.queryById(zdry.get(0).getId());

		mv.addObject("zdry", zdryList.get(0));
		mv.addObject("mode", mode);
		mv.addObject("zdrylx", zdrylx);
		mv.addObject("zdrylxList", zdrylxList);
		mv.addObject("zdrylxJson", new Gson().toJson(zdrylxList));
		mv.addObject("mainTabID", mainTabID);
		
		
		return mv;
	}
	
	
	/**
	 * 
	 * @Title: queryYlglx
	 * @Description: TODO(根据人员ID查询已列管的类型)
	 * @param @param ryid
	 * @param @param syrkid
	 * @param @return
	 * @param @throws BussinessException    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/queryYlglx" ,method = RequestMethod.POST)
	public @ResponseBody String queryYlglx(String ryid,String syrkid){	
		if(ryid==null || syrkid==null)
			return "";
			
		List zdryList =zdryZdryzbService.queryList(ryid);
		
		if(zdryList.isEmpty())
			return "";
		
		ZdryZdryzbVO temp = null;		
		StringBuffer resStrBuffer=new StringBuffer("");
		StringBuffer klgStrBuffer=new StringBuffer("");
		for (int i = 0; i < zdryList.size(); i++) {			
			temp = (ZdryZdryzbVO) zdryList.get(i);
						
			if(syrkid.equals(temp.getSyrkid())){
				if(resStrBuffer.length()>0){
					resStrBuffer.append("，");//中文符号，显示页面用
					klgStrBuffer.append(",");//英文符号，后续查询用
				}
				resStrBuffer.append(temp.getZdrygllxmc());	
				klgStrBuffer.append(temp.getZdrygllxdm());
			}
		}
					
		return resStrBuffer.append("/").append(klgStrBuffer).toString();
	}
	
	@RequestMapping(value = "/queryklglx" ,method = RequestMethod.POST)
	public @ResponseBody String queryklglx(String ylglxStr) {	
		String klgStr=zdryZdryzbService.queryKlglx(ylglxStr);
		if("".equals(klgStr)){//没有课列管的类型，不能返回“”，此时应该没有匹配的选项
			klgStr="999999";
		}
		return 	klgStr;	
	}
	
	/**
	 * 
	 * @Title: shbManage
	 * @Description: TODO(涉环保重点人员管理页面)
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	@RequestMapping(value="/shbManage",method = RequestMethod.GET)
	public String shbManage(){
		return "zdrygl/zdryShbzdryList";
	}
	
	/**
	 * 
	 * @Title: shbAddPre
	 * @Description: TODO(涉环保重点人员新增页面)
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	@RequestMapping(value="/shbAddPre",method = RequestMethod.GET)
	public String shbAddPre(){
		return "zdrygl/zdryShbzdryAdd";
	}
	
	@RestfulAnnotation(serverId = "3")
	@RequestMapping(value = "/shbzdry/list", method = RequestMethod.POST)
	public @ResponseBody
	EasyUIPage queryList(EasyUIPage page,
			@RequestParam(value = "rows", required = false) Integer rows,
			ZdryShbzdryxxb entity, SessionBean sessionBean) {
		page.setPagePara(rows);
		sessionBean = getSessionBean(sessionBean);
		//entity.setGxzrqdm(sessionBean.getUserOrgCode());
		return this.zdryShbzdryxxbService.queryList(entity, page,sessionBean);
	}
	
	@RestfulAnnotation(serverId = "3")
	@RequestMapping(value = "/shbzdry/edit", method = RequestMethod.GET)
	public @ResponseBody
	ModelAndView shbzdryEdit(String zdryid,String type) {
		ModelAndView mv=new ModelAndView("/zdrygl/zdryShbzdryEdit");
		ZdryShbzdryxxb shb = this.zdryShbzdryxxbService.queryById(zdryid);
		ZdryZdryzb zb=this.zdryZdryzbService.queryById(zdryid);
		shb.setRyid(zb.getRyid());
		shb.setQx(type);
		mv.addObject("zdryShbzdryxxb",shb);
		
		return mv;
	}
	
	@RestfulAnnotation(serverId = "3")
	@RequestMapping(value = "/shbzdry/update", method = RequestMethod.POST)
	public @ResponseBody
	ModelAndView shbzdryUpdate(ZdryShbzdryxxb zdryShbzdryxxb,SessionBean sessionBean) {
			
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		Map<String, Object> map = new HashMap<String, Object>();
		sessionBean = getSessionBean(sessionBean);
		try {
			this.zdryShbzdryxxbService.update(zdryShbzdryxxb, sessionBean);
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
	
	//删除queryLglxByZdrylx，已在页面过滤

	//删除queryCglxByZdrylx，没用

	/**
	 * 
	 * @Title: zdryDelPre
	 * @Description: (打开重点人员撤管页面)
	 * @param @param id 重点人员ID
	 * @param @return    设定文件
	 * @return ModelAndView    返回类型
	 * @throws
	 */
	@RequestMapping(value="/zdryDelPre",method = RequestMethod.GET)
	public ModelAndView zdryDelPre(String id){
		ModelAndView mv = new ModelAndView("zdrygl/add/zdryDelPre");
		SessionBean sessionBean = getSessionBean();
		ZdryZdryzb zdryZdryzb = zdryZdryzbService.queryById(id);
		if(zdryZdryzb == null)
			throw new BussinessException("syrk.notExist");
		SyrkSyrkxxzb syrk = syrkSyrkxxzbService.queryById(zdryZdryzb.getSyrkid());
	
		Zdrylxylbdyb zdrylxylbdyb= new Zdrylxylbdyb();
		zdrylxylbdyb.setLbdm(zdryZdryzb.getZdrygllxdm());
		zdrylxylbdyb.setQydm(zdryUntil.querySYSConfig());
		String zdrylxmc =  zdrylxylbdybService.query(zdrylxylbdyb).getBz();
		mv.addObject("userName",sessionBean.getUserName());
		mv.addObject("blrq",DateUtils.getSystemDateString());
		mv.addObject("zdryzb",zdryZdryzb);
		mv.addObject("syrk",syrk);
		mv.addObject("zdrylxmc",zdrylxmc);
		
		return mv;
	}
	
	
	/**
	 * 
	 * @Title: queryZdryCgList
	 * @Description: TODO(查询重点人员 可以撤管的类型)
	 * @param @param zdrylxdm
	 * @param @return    设定文件
	 * @return List    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/queryZdryCgList", method = RequestMethod.GET)
	public @ResponseBody List queryZdryCgList(String zdrylxdm) {
		if(zdrylxdm==null)
			return new ArrayList();
		String kcgStr=zdryZdryzbService.queryKcglx(zdrylxdm);
		if(kcgStr==null){//没有可撤管类型
			return new ArrayList();
		}
		List list = zdrylxylbdybService.getTopList();
		String[] kcgAry=kcgStr.split(",");
		Zdrylxylbdyb zdrylxylbdyb;
		for(int i=0;i<list.size();i++){
			zdrylxylbdyb=(Zdrylxylbdyb) list.get(i);
			for(int j=0;j<kcgAry.length;j++){
				if(kcgAry[j].equals(zdrylxylbdyb.getLbdm())){
					zdrylxylbdyb.setLbdm(zdrylxylbdyb.getLbdm()+"/"+zdrylxylbdyb.getFz());
					break;
				}else if(j==kcgAry.length-1){//不在可撤管类型中
					list.remove(i);i--;					
				}
			}			
		}
		return list; 		
	}
	

	/***
	 * 
	 * @Title: saveLg
	 * @Description: 列管保存逻辑。
	 * @author wu_chunhui@founder.com.cn
	 * @param @return
	 * @return ModelAndView
	 * @throws
	 */
	@RequestMapping(value = "/saveCg", method = RequestMethod.POST)
	public ModelAndView saveCg(ZdryVO zdryVO, SessionBean sessionBean) {
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		Map<String, Object> model = new HashMap<String, Object>();
		sessionBean = getSessionBean(sessionBean);

		
		try {		
			ZdryZdryzb zdryZdryzb = zdryVO.getZdryZdryzb();
			
			//查询以前的信息
			ZdryZdryzb zb=zdryZdryzbService.queryById(zdryZdryzb.getId());
			if(zb==null){
				throw new BussinessException("未查询到该重点人员的信息");
			}
			//验证状态是否正确
			zdryUntil.validateState(zb.getGlzt());								
			
			String zdryYlb = zb.getZdrygllxdm();//原重点人员类型
			String zdryYid = zb.getId();//原重点人员ID
			
			//撤管原重点人员
			BaseService.setUpdateProperties(zb, sessionBean);
			zdryVO.setZdryZdryzb(zb);
			zdryUntil.initZdryEntity(zdryYlb,zdryVO,sessionBean);
			zdryUntil.getZdryService(zdryYlb).saveCg(zdryVO);//撤管以前的类型，将状态修改为已撤管
			
			if(StringUtils.isNotEmpty(zdryZdryzb.getZdrygllxdm())){//撤管为其他类型
				zdryZdryzb.setGlbm(sessionBean.getUserOrgCode());
				String type = zdryZdryzb.getZdrygllxdm();//列管类型
				String strAry[] = type.split("/");
				type = strAry[0];
				zdryZdryzb.setZdrygllxdm(type);
				BaseService.setSaveProperties(zdryZdryzb, sessionBean);
				zdryVO.setZdryZdryzb(zdryZdryzb);
				zdryUntil.initZdryEntity(strAry[1],zdryVO,sessionBean);
				zdryUntil.getZdryService(strAry[1]).saveLg(zdryVO);
			}
			
			
			//if("01".equals(type)){
				//List<ZpfjFjxxb> list = new ArrayList<ZpfjFjxxb>();

//				for (int i = 0; i < uploadFile.length; i++) {
//					CommonsMultipartFile multipartFile = uploadFile[i];
//					if (!multipartFile.isEmpty()) {
//						FileItem fileItem = multipartFile.getFileItem();
//						ZpfjFjxxb entity = new ZpfjFjxxb();
//						entity.setLybm("ZDRY_ZDRYZB");
//						entity.setLyid(zdryVO.getZdryZdryzb().getId());
//						entity.setLyms("社区矫正人员-判决书");
//						String wjmc = fileItem.getName();
//						if (wjmc.indexOf("\\") != -1) { // 去除完整路径
//							wjmc = wjmc.substring(wjmc.lastIndexOf("\\") + 1);
//						}
//						String wjhzlx = "";
//						int atI = wjmc.lastIndexOf(".");
//						if (atI != -1) {
//							wjhzlx = wjmc.substring(atI + 1);
//							wjhzlx = wjhzlx.toLowerCase();
//						}
//						entity.setWjmc(wjmc);
//						entity.setWjhzlx(wjhzlx);
//						entity.setWj(multipartFile.getBytes());
//						long wjdx = entity.getWj().length;
//						entity.setWjdx(new Long(wjdx));
//						String wjdxsm = "";
//						if (wjdx < 1024) {
//							wjdxsm = "" + wjdx + " B";
//						} else if (wjdx > 1048576) {
//							double mb = Math.floor(wjdx / 1048576);
//							DecimalFormat formater = new DecimalFormat(
//									"###,###,###.00");
//							wjdxsm = "" + formater.format(mb) + " MB";
//						} else {
//							long kb = (long) Math.floor(wjdx / 1024);
//							wjdxsm = "" + kb + " KB";
//						}
//						entity.setWjdxsm(wjdxsm);
//						entity.setWjxzcs(new Long(0));
//						list.add(entity);
//					}
//				}
//				if (list.size() > 0) {
//					zpfjFjxxbService.saveZpfjFjxxb(list, sessionBean);
//					model.put(AppConst.STATUS, AppConst.SUCCESS);
//					model.put(AppConst.MESSAGES, getAddSuccess());
//				}
			//}



			Map<String, Object> variables =  new HashMap<String, Object>();
			String  lrrzrq= sessionBean.getUserOrgCode();
			String zdryxm = zdryVO.getXm();
			Zdrylxylbdyb zdrylxylbdyb=new Zdrylxylbdyb();
			zdrylxylbdyb.setLbdm(zdryZdryzb.getZdrygllxdm());
			String zdrylxmc =  zdrylxylbdybService.query(zdrylxylbdyb).getBz();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String createTime=formatter.format(new Date());//申请时间
			variables.put("createTime", createTime);
			variables.put("lrrzrq", lrrzrq);//录入人管辖责任区
			variables.put("cghZdryId", zdryZdryzb.getId());
			variables.put("zdryId", zdryYid); //重点人员总表Id
			variables.put("zdrylx", zdryYlb);//人员类型	
			variables.put("zdrylxmc", zdrylxmc);//人员类型名称	
			variables.put("xm", zdryxm);//被列管人员姓名
			variables.put("zjhm", zdryVO.getZjhm());//证件号码
			//	variables.put("splx", "重点人口列管");//审批类型	  			
			variables.put("sqyj", zdryVO.getYwsqyy());//申请意见		
			if(zdryYlb.equals("07")){//环保
				variables.put("sqlx", "涉环保");
				variables.put("sqlxdm", "02");//列管01  撤管02
				variables.put("splevel", "1");//设置审批级别，一级审批
				variables.put("sqrOrgCode",sessionBean.getUserOrgCode());//设置申请人组织机构代码
				variables.put("sqrOrgLevel",sessionBean.getUserOrgLevel());//设置申请人组织机构级别
				variables.put("approvalMethod", "shbApproval");
				variables.put("zdryId", zdryZdryzb.getId());
				variables.put("sqyj", "申请将"+zdryVO.getZdryShbzdryxxb().getXm()+"撤管为涉环保重点人员");
				variables.put("xm", zdryVO.getZdryShbzdryxxb().getXm());//被列管人员姓名
				variables.put("zjhm", zdryVO.getZdryShbzdryxxb().getZjhm());//证件号码

				processDefinitionService.startProcessInstance(sessionBean.getUserId(), "shb_lcg", zdryYid, variables);	
			}
			else if(zdryYlb.equals("06")){//其他关注对象
				zdryUntil.cgSuccess(zdryYid, zdryxm, sessionBean.getUserId(), sessionBean.getUserName(), sessionBean.getUserOrgCode(), null);
//				processDefinitionService.startProcessInstance(sessionBean.getUserId(), " ", zdryZdryzb.getId(), variables);	
			}
			else if(zdryYlb.equals("05")){//涉公安访
				variables.put("sqlx", "涉公安访撤管");
				variables.put("sqlxdm", "02");//列管01  撤管02

				OrgOrganization orgOrganization = orgOrganizationService.queryUpOrgByLevel(lrrzrq,"32");	
				String fsxOrgCode = orgOrganization.getOrgcode();//  得到本名等级为三级，派出所部门code
				String taskParameter = fsxOrgCode+"_"+orgPositionService.queryByPosid("SZ").getId().toString();   //部门code+所长岗位ID
				variables.put("approvalMethod", "sgafApproval");
				variables.put("szsp", taskParameter);
				processDefinitionService.startProcessInstance(sessionBean.getUserId(), "sgaj_lcg", zdryYid, variables);	
			}
			else{//治安
				
				if(zdryZdryzb.getZdrygllxdm().equals("01")){
					if("0104".equals(zdryZdryzbService.queryById(zdryZdryzb.getId()).getZdrylb())){
						
						variables.put("sqlx", "治安撤管");//申请类型	
						variables.put("sqlxdm", "02");//申请类型为撤管
						processDefinitionService.startProcessInstance(sessionBean.getUserId(), "zalcg", zdryYid, variables);
						}	
					else{
						zdryUntil.cgSuccess(zdryYid, zdryxm, sessionBean.getUserId(), sessionBean.getUserName(), sessionBean.getUserOrgCode(), null);
						}	
					
				}	
				else{
						variables.put("sqlx", "治安撤管");//申请类型	
						variables.put("sqlxdm", "02");//申请类型为撤管
						processDefinitionService.startProcessInstance(sessionBean.getUserId(), "zalcg", zdryYid, variables);
				
				}
				
			}	
			model.put(AppConst.STATUS, AppConst.SUCCESS);
			model.put(AppConst.MESSAGES, getAddSuccess());

		}catch (Exception e) {
			logger.error(e.getLocalizedMessage(), e);
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, e.getLocalizedMessage());
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}
}
