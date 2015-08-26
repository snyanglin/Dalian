/**
*** ┏┓           ┏┓
* ┏┛ ┻━━┛ ┻┓ 　
* ┃             ━              ┃
* ┃    ┳┛    ┗┳    ┃
* ┃    …                    …    ┃
* ┃             ┻              ┃
* ┗━┓            ┏━┛
*     ┃           ┃ Code is far away from bug with the animal protecting.
*     ┃           ┃ 神兽护佑, 代码无Bug.
*     ┃           ┗ ━━━━━━━━┓
*     ┃                                                         ┣┓
*     ┃                                                         ┏┛
*     ┗┓┓ ┏━━━━┳┓ ┏━┛
*       ┃┫┫                     ┃┫┫
*       ┗┻┛                     ┗┻┛ 
***/
package com.founder.yjjb.controller;

import java.util.ArrayList;
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
import com.founder.framework.organization.right.service.OrgRightPublic;
import com.founder.framework.organization.role.bean.OrgRole;
import com.founder.framework.utils.DateUtils;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.framework.utils.UUID;
import com.founder.yjjb.bean.Ajxxb;
import com.founder.yjjb.bean.Fjajgxb;
import com.founder.yjjb.bean.Xsajgxb;
import com.founder.yjjb.bean.Xscljlb;
import com.founder.yjjb.bean.Xsdzspb;
import com.founder.yjjb.bean.Xsdzsqb;
import com.founder.yjjb.bean.Xsjbxxb;
import com.founder.yjjb.bean.Xszcspb;
import com.founder.yjjb.bean.Xszcsqb;
import com.founder.yjjb.service.CommonService;
import com.founder.yjjb.service.XsajgxbService;
import com.founder.yjjb.service.XscljlbService;
import com.founder.yjjb.service.XsdzspbService;
import com.founder.yjjb.service.XsdzsqbService;
import com.founder.yjjb.service.XsjbxxbService;
import com.founder.yjjb.service.XszcspbService;
import com.founder.yjjb.service.XszcsqbService;
import com.founder.yjjb.utils.MessageUtils;

import com.google.gson.Gson;

@Controller
@RequestMapping(value = "/xsjbxxb")
public class XsjbxxbController extends BaseController {

	private Logger logger = Logger.getLogger(this.getClass());
	
	@Resource(name="xsjbxxbService")
	private XsjbxxbService xsjbxxbService;
	
	@Resource(name="xsdzsqbService")
	private XsdzsqbService xsdzsqbService;
	
	@Resource(name="xsdzspbService")
	private XsdzspbService xsdzspbService;
	
	@Resource(name="xszcsqbService")
	private XszcsqbService xszcsqbService;
	
	@Resource(name="xszcspbService")
	private XszcspbService xszcspbService;
	
	@Resource(name="commonService")
	private CommonService commonService;
	
	@Resource(name="xsajgxbService")
	private XsajgxbService xsajgxbService;
	
	// 日志处理
	@Resource(name="xscljlbService")
	private XscljlbService xscljlbService;
	String xsbh = "";
	String czlx = "";
	StringBuffer cznrBF = new StringBuffer();
	
	/**
	 * 跳转
	 * @param id
	 * @param mainTabID
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/openList", method = RequestMethod.GET)
	public ModelAndView xsjbxxbList(String id,String mainTabID) {
		
		ModelAndView mv = new ModelAndView("yjjb/jbxsList");
		mv.addObject("mainTabID", mainTabID);
		Xsjbxxb entity = new Xsjbxxb();
		
		if (!StringUtils.isBlank(id)) {
			
			entity.setId(id);
			entity = xsjbxxbService.queryById(entity);
		}
		mv.addObject("entity", entity);
		return mv;
	}
	

	/**
	 * 跳转
	 * @param id
	 * @param mainTabID
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/openXgaj", method = RequestMethod.GET)
	public ModelAndView openXgaj(String xsId,String mainTabID) {
		
		ModelAndView mv = new ModelAndView("yjjb/xgajList");
		mv.addObject("mainTabID", mainTabID);
		SessionBean sessionBean = getSessionBean();
		
		//String orgId = sessionBean.getUserId();
		//String alarm = commonService.selectByOrgId(orgId);
		
		String orgUserID = "";
		String alarm = "";
		if (null != sessionBean) {
			
			orgUserID = sessionBean.getUserId();
			alarm = commonService.selectByOrgId(orgUserID);
		}
		
		if(null == alarm || alarm.equals("")){
			
			alarm = "";
		}
		mv.addObject("xsId", xsId);
		mv.addObject("alarm", alarm);
		return mv;
	}
	
	/**
	 * 查询</br>
	 * @param page
	 * @param rows
	 * @param entity
	 * @return
	 */
	@RequestMapping(value = "/query", method = RequestMethod.POST)
	public @ResponseBody
	EasyUIPage queryList(EasyUIPage page,
			@RequestParam(value = "rows") Integer rows, Xsjbxxb entity){
		
		page.setPagePara(rows);
		SessionBean sessionBean = getSessionBean();
		if(null != sessionBean){
			
		}
		entity.setSlfzdm(sessionBean.getUserOrgCode().replaceAll("0+?$", ""));
		return this.xsjbxxbService.queryList(page,entity);
	}
	
	/**
	 * 查询</br>
	 * @param page
	 * @param rows
	 * @param entity
	 * @return
	 */
	@RequestMapping(value = "/queryAll", method = RequestMethod.POST)
	public @ResponseBody
	EasyUIPage queryAll(EasyUIPage page,
			@RequestParam(value = "rows") Integer rows, Xsjbxxb entity){
		
		page.setPagePara(rows);
		SessionBean sessionBean = getSessionBean();
		if(null != sessionBean){
			
		}
		return this.xsjbxxbService.queryAllList(page,entity);
	}
	
	/**
	 * 跳转新增/编辑页面
	 * @param id
	 * @param mainTabID
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/openAdd", method = RequestMethod.GET)
	public ModelAndView add(String id,String mainTabID) {
		
		ModelAndView mv = new ModelAndView("yjjb/jbxsAdd");
		mv.addObject("mainTabID", mainTabID);
		Xsjbxxb entity = new Xsjbxxb();
		
		//List<String> listlxfs = new ArrayList();
		if (!StringUtils.isBlank(id)) {
			
			entity.setId(id);
			entity = xsjbxxbService.queryById(entity);
			// *****************联系方式处理
			/*
			String lxfs = entity.getJbrlxfs();
			if (null != lxfs && !lxfs.equals("")) {
				
				String[] lxfsList = lxfs.split(",");
				for(String str : lxfsList) {
					listlxfs.add(str);
				}
			} else {
				
				listlxfs.add("");
			}
			*/
			// ******************联系方式处理
		}/* else {
			
			listlxfs.add("");
		}*/
		
		//mv.addObject("listlxfs", listlxfs);
		mv.addObject("entity", entity);
		
		return mv;
	}

	
	/**
	 * 反馈打印</br>
	 * @param id
	 * @param mainTabID
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/openPrint", method = RequestMethod.GET)
	public ModelAndView prints(String id,String mainTabID,String flag) {

		
		String printJsp = "yjjb/jbxsPrint3";
		if (flag.equals("3")) {
			
			printJsp = "yjjb/jbxsPrint3";
		}else if (flag.equals("30")) {
			
			printJsp = "yjjb/jbxsPrint30";
		}
		ModelAndView mv = new ModelAndView(printJsp);
		mv.addObject("mainTabID", mainTabID);
		Xsjbxxb entity = new Xsjbxxb();
	
		if (!StringUtils.isBlank(id)) {
			
			entity.setId(id);
			entity = xsjbxxbService.queryById(entity);
			// 调查年月日
			String yyyy = entity.getJbsj().substring(0, 4);
			String mm = entity.getJbsj().substring(5, 7);
			String dd = entity.getJbsj().substring(8, 10);
			
			// 初查结果 （废弃原因）
			String ccbz = entity.getCcbz();
			// 复查结果（废弃原因）
			String fcbz = entity.getFcbz();
			// 调查单位
			String dcdw = entity.getSlfzdm();
			// 线索状态
			String xszt = entity.getXszt();
			// 线索编号
			String xsbh = id;
			// 案件列表，顿号分隔
			String ajbhList = "";
			List<Xsajgxb> xsajgxbList = xsajgxbService.queryAJListByXsbh(xsbh);
			if (null != xsajgxbList && xsajgxbList.size() >0) {
				
				for (Xsajgxb xsajgxb:xsajgxbList) {
					
					ajbhList += xsajgxb.getAjbh();
				}
				ajbhList = ajbhList.substring(0, ajbhList.length() -1);
			}
			String resultMsg = "";
			// 初查结果
			String ccjg = entity.getCcjg();
			// 复查结果
			String fcjg = entity.getFcjg();
			if (null != flag && flag.equals("3")) {
				
				if (null != ccjg && ccjg.equals("10")) {
						
					resultMsg = "已采用，案件正在调查中";
				}else if (null != ccjg && ccjg.equals("20")){
					
					resultMsg = "已采用，现案件已立案侦查，案件编号：";
				}else if (null != ccjg && ccjg.equals("30")){
					
					resultMsg = "已采用，但无法继续深入工作："+ccbz;
				}
			}else if(null != flag && flag.equals("30")){
				
				if (null != ccjg && ccjg.equals("10")) {
						
					resultMsg = "已采用，案件正在调查中";
				}else if (null != ccjg && ccjg.equals("20")){
					
					resultMsg = "已采用，现案件已立案侦查，案件编号：";
				}else if (null != ccjg && ccjg.equals("30")){
					
					resultMsg = "已采用，但无法继续深入工作："+fcbz;
				}
			}
			
			mv.addObject("yyyy", yyyy);
			mv.addObject("mm", mm);
			mv.addObject("dd", dd);
			mv.addObject("ccbz", ccbz);
			mv.addObject("fcbz", fcbz);
			
			mv.addObject("xsbh", xsbh);
			mv.addObject("xszt", xszt);
			mv.addObject("ccjg", ccjg);
			mv.addObject("fcjg", fcjg);
			mv.addObject("ajbhList", ajbhList);
		}
		
		mv.addObject("entity", entity);
		
		return mv;
	}
	
	/**
	 * 跳转新增/编辑页面
	 * @param id
	 * @param mainTabID
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/openView", method = RequestMethod.GET)
	public ModelAndView view(String id,String mainTabID) {
		
		ModelAndView mv = new ModelAndView("yjjb/jbxsView");
		mv.addObject("mainTabID", mainTabID);
		Xsjbxxb entity = new Xsjbxxb();
		
		//List<String> listlxfs = new ArrayList();
		if (!StringUtils.isBlank(id)) {
			
			entity.setId(id);
			entity = xsjbxxbService.queryById(entity);
			// *****************联系方式处理
			/*
			String lxfs = entity.getJbrlxfs();
			if (null != lxfs && !lxfs.equals("")) {
				
				String[] lxfsList = lxfs.split(",");
				for(String str : lxfsList) {
					listlxfs.add(str);
				}
			} else {
				
				listlxfs.add("");
			}
			*/
			// ******************联系方式处理
		}/* else {
			
			listlxfs.add("");
		}*/

		//mv.addObject("list", listlxfs);
		mv.addObject("entity", entity);
		return mv;
	}
	
	/**
	 * 跳转初查页面
	 * @param id
	 * @param mainTabID
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/openCC", method = RequestMethod.GET)
	public ModelAndView openCC(String id,String mainTabID) {
		
		ModelAndView mv = new ModelAndView("yjjb/jbxsCC");
		mv.addObject("mainTabID", mainTabID);
		Xsjbxxb entity = new Xsjbxxb();
		//List<String> listlxfs = new ArrayList();
		
		if (!StringUtils.isBlank(id)) {
			
			entity.setId(id);
			entity = xsjbxxbService.queryById(entity);
			
			// *****************联系方式处理
			/*
			String lxfs = entity.getJbrlxfs();
			if (null != lxfs && !lxfs.equals("")) {
				
				String[] lxfsList = lxfs.split(",");
				for(String str : lxfsList) {
					listlxfs.add(str);
				}
			} else {
				
				listlxfs.add("");
			}
			*/
			// ******************联系方式处理
		}/* else {
			
			listlxfs.add("");
		}*/
		
		SessionBean sessionBean = getSessionBean();
		String orgUserID = "";
		String alarm = "";
		if (null != sessionBean) {
			orgUserID = sessionBean.getUserId();
			alarm = commonService.selectByOrgId(orgUserID);
		}
		if(null == alarm || alarm.equals("")){
			alarm = "";
		}
		
		mv.addObject("alarm", alarm);
		//mv.addObject("listlxfs", listlxfs);
		mv.addObject("entity", entity);
		return mv;
	}
	
	/**
	 * 跳转复查页面
	 * @param id
	 * @param mainTabID
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/openFC", method = RequestMethod.GET)
	public ModelAndView openFC(String id,String mainTabID) {
		
		ModelAndView mv = new ModelAndView("yjjb/jbxsFC");
		mv.addObject("mainTabID", mainTabID);
		Xsjbxxb entity = new Xsjbxxb();
		//List<String> listlxfs = new ArrayList();
		
		if (!StringUtils.isBlank(id)) {
			entity.setId(id);
			entity = xsjbxxbService.queryById(entity);
			// *****************联系方式处理
			/*
			String lxfs = entity.getJbrlxfs();
			if (null != lxfs && !lxfs.equals("")) {
				
				String[] lxfsList = lxfs.split(",");
				for(String str : lxfsList) {
					
					listlxfs.add(str);
				}
			} else {
				
				listlxfs.add("");
			}
			*/
			// ******************联系方式处理
		}/* else {
			
			listlxfs.add("");
		}*/
		
		SessionBean sessionBean = getSessionBean();
		String orgUserID = "";
		String alarm = "";
		if (null != sessionBean) {
			orgUserID = sessionBean.getUserId();
			alarm = commonService.selectByOrgId(orgUserID);
		}
		
		if(null == alarm || alarm.equals("")){
			alarm = "";
		}
		
		
		mv.addObject("alarm", alarm);
		//mv.addObject("listlxfs", listlxfs);
		mv.addObject("entity", entity);
		return mv;
	}
	
	/**
	 * 递转和递转过程中查看线索信息的页面</br>
	 * @param id
	 * @param mainTabID
	 * @return
	 * @since 2014-11-28
	 */
	@ResponseBody
	@RequestMapping(value = "/openCK", method = RequestMethod.GET)
	public ModelAndView openCK(String id,String mainTabID) {
		
		ModelAndView mv = new ModelAndView("yjjb/jbxsCK");
		mv.addObject("mainTabID", mainTabID);
		Xsjbxxb entity = new Xsjbxxb();
		List<Xszcspb> list = new ArrayList<Xszcspb>();
		//List<String> listlxfs = new ArrayList();
		if (!StringUtils.isBlank(id)) {
			entity.setId(id);
			entity = xsjbxxbService.queryById(entity);
			
			// *****************联系方式处理
			/*
			String lxfs = entity.getJbrlxfs();
			if (null != lxfs && !lxfs.equals("")) {
				
				String[] lxfsList = lxfs.split(",");
				for(String str : lxfsList) {
					
					listlxfs.add(str);
				}
			} else {
				
				listlxfs.add("");
			}
			*/
			// ******************联系方式处理
		}/* else {
			
			listlxfs.add("");
		}*/
			
		SessionBean sessionBean = getSessionBean();
		String orgUserID = "";
		String alarm = "";
		if (null != sessionBean) {
			orgUserID = sessionBean.getUserId();
			alarm = commonService.selectByOrgId(orgUserID);
		}
		
		if(null == alarm || alarm.equals("")){
			alarm = "";
		}
		
		
		mv.addObject("alarm", alarm);
		mv.addObject("entity", entity);
		mv.addObject("list", list);
		//mv.addObject("listlxfs", listlxfs);
		return mv;
	}
	
	/**
	 * 递转过程中查看线索信息的页面</br>
	 * @param id
	 * @param mainTabID
	 * @return
	 * @since 2014-11-28
	 */
	@ResponseBody
	@RequestMapping(value = "/openZCCK", method = RequestMethod.GET)
	public ModelAndView openZCCK(String xsbh,String sqbh,String mainTabID) {
		
		ModelAndView mv = new ModelAndView("yjjb/zcCK");
		mv.addObject("mainTabID", mainTabID);
		Xsjbxxb entity = new Xsjbxxb();
		List<Xszcspb> list = new ArrayList<Xszcspb>();
		Xszcsqb entitySq = new Xszcsqb();
		
		//List<String> listlxfs = new ArrayList();
		if(!StringUtils.isBlank(sqbh)){
			entitySq.setId(sqbh);
		}
		if (!StringUtils.isBlank(xsbh)) {
			entity.setId(xsbh);
			entity = xsjbxxbService.queryById(entity);
			list = xszcspbService.queryListBySqid(sqbh);
			entitySq = xszcsqbService.queryById(entitySq);
			
			// *****************联系方式处理
			/*
			String lxfs = entity.getJbrlxfs();
			if (null != lxfs && !lxfs.equals("")) {
				
				String[] lxfsList = lxfs.split(",");
				for(String str : lxfsList) {
					
					listlxfs.add(str);
				}
			} else {
				
				listlxfs.add("");
			}
			*/
			
			// ******************联系方式处理
		}/* else {
			
			listlxfs.add("");
		}*/
			
		SessionBean sessionBean = getSessionBean();
		String orgUserID = "";
		String alarm = "";
		if (null != sessionBean) {
			
			orgUserID = sessionBean.getUserId();
			alarm = commonService.selectByOrgId(orgUserID);
		}
		
		if(null == alarm || alarm.equals("")){
			
			alarm = "";
		}
		//获得上级部门名称
		String zcfqdwUpId = commonService.queryUpOrgID(entitySq.getZcfqdw());
		String zcfqdwUpName = commonService.queryNameOrgID(zcfqdwUpId);
		
		mv.addObject("alarm", alarm);
		mv.addObject("entity", entity);
		mv.addObject("list", list);
		mv.addObject("entitySq", entitySq);
		mv.addObject("zcfqdwUpName", zcfqdwUpName);
		//mv.addObject("listlxfs", listlxfs);
		return mv;
	}
	
	/**
	 * 打开线索查看+log的页面</br>
	 * @param id
	 * @param mainTabID
	 * @return
	 * @since 2014-11-28
	 */
	@ResponseBody
	@RequestMapping(value = "/openXsckLog", method = RequestMethod.GET)
	public ModelAndView openXsckLog(String xsbh,String mainTabID) {
		
		ModelAndView mv = new ModelAndView("yjjb/xsckLog");
		mv.addObject("mainTabID", mainTabID);
		Xsjbxxb entity = new Xsjbxxb();
		Xscljlb entityLog = new Xscljlb();
		List<Xscljlb> list = new ArrayList<Xscljlb>();
		//List<String> listlxfs = new ArrayList();
		
		if (!StringUtils.isBlank(xsbh)) {
			entity.setId(xsbh);
			entity = xsjbxxbService.queryById(entity);//获得线索实体的内容
			entityLog.setXsbh(xsbh);
			list = xscljlbService.queryListByXsbh(entityLog);
			
			// *****************联系方式处理
			/*
			String lxfs = entity.getJbrlxfs();
			if (null != lxfs && !lxfs.equals("")) {
				
				String[] lxfsList = lxfs.split(",");
				for(String str : lxfsList) {
					
					listlxfs.add(str);
				}
			} else {
				
				listlxfs.add("");
			}
			*/
			// ******************联系方式处理
		}/*else {
			
			listlxfs.add("");
		}
		*/
		// ****************************警号
		SessionBean sessionBean = getSessionBean();
		String orgUserID = "";
		String alarm = "";
		if (null != sessionBean) {
			
			orgUserID = sessionBean.getUserId();
			alarm = commonService.selectByOrgId(orgUserID);
		}
		
		
		if(null == alarm || alarm.equals("")){
			
			alarm = "";
		}
		
		mv.addObject("alarm", alarm);
		// ****************************警号
		//mv.addObject("listlxfs", listlxfs);
		mv.addObject("entity", entity);
		mv.addObject("list", list);
		return mv;
	}
	
	/**
	 * 打开线索查看页面</br>
	 * @param id
	 * @param mainTabID
	 * @return
	 * @since 2014-11-28
	 */
	@ResponseBody
	@RequestMapping(value = "/openXsck", method = RequestMethod.GET)
	public ModelAndView openXsck(String xsbh,String mainTabID) {
		
		ModelAndView mv = new ModelAndView("yjjb/xsckLog");
		mv.addObject("mainTabID", mainTabID);
		Xsjbxxb entity = new Xsjbxxb();
		
		
		if (!StringUtils.isBlank(xsbh)) {
			entity.setId(xsbh);
			entity = xsjbxxbService.queryById(entity);//获得线索实体的内容
		}
			
		// ****************************警号
		SessionBean sessionBean = getSessionBean();
		String orgUserID = "";
		String alarm = "";
		if (null != sessionBean) {
			
			orgUserID = sessionBean.getUserId();
			alarm = commonService.selectByOrgId(orgUserID);
		}
		
		
		if(null == alarm || alarm.equals("")){
			
			alarm = "";
		}
		
		mv.addObject("alarm", alarm);
		// ****************************警号
		mv.addObject("entity", entity);
		return mv;
	}
	
	/**
	 * 线索查看+一个或多个递转信息</br>
	 * @param id
	 * @param mainTabID
	 * @return
	 * @since 2014-11-28
	 */
	@ResponseBody
	@RequestMapping(value = "/openXsDz", method = RequestMethod.GET)
	public ModelAndView openXsDz(String xsbh,String mainTabID) {
		
		ModelAndView mv = new ModelAndView("yjjb/xsDz");
		mv.addObject("mainTabID", mainTabID);
		Xsjbxxb entity = new Xsjbxxb();
		List<Xszcsqb> listSq = new ArrayList<Xszcsqb>();
		List<Xszcspb> listSp = new ArrayList<Xszcspb>();
		List<List<Xszcspb>> spAll = new ArrayList<List<Xszcspb>>();
		Xszcsqb entitySq = new Xszcsqb();
		//List<String> listlxfs = new ArrayList();
		
		if (!StringUtils.isBlank(xsbh)) {
			//拿出线索详细内容的实体
			entity.setId(xsbh);
			entity = xsjbxxbService.queryById(entity);
			
			// *****************联系方式处理
			/*
			String lxfs = entity.getJbrlxfs();
			if (null != lxfs && !lxfs.equals("")) {
				
				String[] lxfsList = lxfs.split(",");
				for(String str : lxfsList) {
					
					listlxfs.add(str);
				}
			} else {
				
				listlxfs.add("");
			}
			 */
			// ******************联系方式处理
			
			//根据线索编号拿到所有申请id的list
			entitySq.setXsbh(xsbh);
			listSq = xszcsqbService.queryListByXsbh(entitySq);
			for(int i = 0;i < listSq.size();i++) {
				listSp = xszcspbService.queryListBySqid(listSq.get(i).getId());//通过申请编号查询审批列表对应数据
				spAll.add(listSp);
			}
		}/*else {
			
			listlxfs.add("");
		}
		
		
		mv.addObject("listlxfs", listlxfs);*/
		mv.addObject("entity", entity);
		mv.addObject("listSq", listSq);
		mv.addObject("spAll", spAll);
		return mv;
	}

	/**
	 * 递转过程中查看线索信息的页面</br>
	 * @param id
	 * @param mainTabID
	 * @return
	 * @since 2014-11-28
	 */
	@ResponseBody
	@RequestMapping(value = "/openDZCK", method = RequestMethod.GET)
	public ModelAndView openDZCK(String xsbh,String sqbh,String mainTabID) {
		
		ModelAndView mv = new ModelAndView("yjjb/jbxsDZCK");
		mv.addObject("mainTabID", mainTabID);
		Xsjbxxb entity = new Xsjbxxb();
		List<Xsdzspb> xsdzspb = new ArrayList<Xsdzspb>();
		Xsdzsqb xsdzsqb = new Xsdzsqb();
		//List<String> listlxfs = new ArrayList();
		
		if(!StringUtils.isBlank(sqbh)){
			xsdzsqb.setId(sqbh);
		}
		if (!StringUtils.isBlank(xsbh)) {
			entity.setId(xsbh);
			entity = xsjbxxbService.queryById(entity);
			xsdzspb = xsdzspbService.queryListByXsId(xsbh);
			xsdzsqb = xsdzsqbService.queryById(xsdzsqb);
			
			// *****************联系方式处理
			/*
			String lxfs = entity.getJbrlxfs();
			if (null != lxfs && !lxfs.equals("")) {
				
				String[] lxfsList = lxfs.split(",");
				for(String str : lxfsList) {
					
					listlxfs.add(str);
				}
			} else {
				
				listlxfs.add("");
			}
			*/
			// ******************联系方式处理
		}/* else {
			
			listlxfs.add("");
		}*/
			
		SessionBean sessionBean = getSessionBean();
		String orgUserID = "";
		String alarm = "";
		if (null != sessionBean) {
			
			orgUserID = sessionBean.getUserId();
			alarm = commonService.selectByOrgId(orgUserID);
		}
		
		
		if(null == alarm || alarm.equals("")){
			
			alarm = "";
		}
		
		//mv.addObject("listlxfs", listlxfs);
		mv.addObject("alarm", alarm);
		mv.addObject("entity", entity);
		mv.addObject("xsdzspb", xsdzspb);
		mv.addObject("xsdzsqb", xsdzsqb);
		return mv;
	}
	
	/**
	 * 跳转案件页面
	 * @param id
	 * @param mainTabID
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/openAJ", method = RequestMethod.GET)
	public ModelAndView openAJ(String id,String mainTabID) {
		
		ModelAndView mv = new ModelAndView("yjjb/xgajList");
		mv.addObject("mainTabID", mainTabID);
		Xsjbxxb entity = new Xsjbxxb();
		//List<String> listlxfs = new ArrayList();
		
		if (!StringUtils.isBlank(id)) {
			
			entity.setId(id);
			entity = xsjbxxbService.queryById(entity);
			
			// *****************联系方式处理
			/*
			String lxfs = entity.getJbrlxfs();
			if (null != lxfs && !lxfs.equals("")) {
				
				String[] lxfsList = lxfs.split(",");
				for(String str : lxfsList) {
					
					listlxfs.add(str);
				}
			} else {
				
				listlxfs.add("");
			}
			*/
			// ******************联系方式处理
		}/* else {
			
			listlxfs.add("");
		}*/
		//mv.addObject("listlxfs", listlxfs);
		mv.addObject("entity", entity);
		return mv;
	}
	/**
	 * 新增和修改
	 * @param entity
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(Xsjbxxb entity){
		

		ModelAndView mv = new ModelAndView("redirect:/forward/" + AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		String orgCode = "";
		if (null != sessionBean) {
			
			orgCode = sessionBean.getUserOrgCode();
		}
		
		try {
			if (entity.getId() == null || entity.getId().equals("")) {	//新增

				// **************初始化******开始************************************
				entity.setId(commonService.CreateNewSeq("00", orgCode));// "XSXX"+ORGCODE+DATIME+SEQ
				entity.setXszt("00"); // 待初查
				entity.setCcjg("00"); // 待处理
				entity.setFcjg("00"); // 待处理
				String datime = DateUtils.getSystemDateString();// 系统时间
				entity.setJbsj(datime);
				entity.setCcsj(datime);
				entity.setXsly("0"); // 系统录入
				entity.setDzbz("0"); // 未递转
				entity.setZcbz("0"); // 未初查
				// **************初始化******结束************************************
				
				// 如果没有地图选点，则根据线索地址代码获取受理单位信息
				if ((entity.getSlfzdm() == null || entity.getSlfzdm().equals("")) ) {
					if (entity.getXsdzdm() != null && !entity.getXsdzdm().equals("")) {
						
						entity.setSlfzdm(commonService.queryPcsByDZID(entity.getXsdzdm()));  // 根据线索地址查询所属派出所
						entity.setSlzdm(commonService.queryUpOrgID(entity.getSlfzdm()));     // 受理分站的上级单位为受理站
						entity.setSlzxdm(commonService.queryUpOrgID(entity.getSlzdm()));     // 受理站的上级单位为受理中心
					} else{
						
						entity.setSlfzdm(orgCode);
						entity.setSlzdm(commonService.queryUpOrgID(orgCode));
						entity.setSlzxdm(commonService.queryUpOrgID(entity.getSlzdm()));
					}
					
				}
				/*
				StringBuffer lxfsSB = new StringBuffer();
				for(String lxfs:entity.getJbrlxfsList()){
					
					lxfsSB.append(lxfs);
					lxfsSB.append(",");
				}
				entity.setJbrlxfs(lxfsSB.toString());
				*/
				entity.setJbrlxfs(entity.getJbrlxfs());
				xsjbxxbService.save(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES,  getMessage("add.success"));
				model.put(AppConst.SAVE_ID, entity.getId()); // 返回主键
				
				//待办发送
				MessageUtils.db_3d(entity.getId(), entity.getSlfzdm(), sessionBean);
				//待办发送
			} else {	//修改
				/*
				StringBuffer lxfsSB = new StringBuffer();
				for(String lxfs:entity.getJbrlxfsList()){
					
					lxfsSB.append(lxfs);
					lxfsSB.append(",");
				}
				entity.setJbrlxfs(lxfsSB.toString());
				*/
				entity.setJbrlxfs(entity.getJbrlxfs());
				xsjbxxbService.update(entity, sessionBean);
				
				// ********************************************日志处理
				if (null !=sessionBean && null != entity) {
					
					String userName = sessionBean.getUserName();
					String orgName = sessionBean.getUserOrgName();
					
					czlx = "50";
					xsbh = entity.getId();
					entity = xsjbxxbService.queryById(entity);
					cznrBF = new StringBuffer();
					cznrBF.append(orgName);
					cznrBF.append(" 的 ");
					cznrBF.append(userName);
					// 操作内容
					cznrBF.append(", 编辑了线索内容");
					if (entity.getXszt().equals("00")) {
						
						cznrBF.append(", 当前线索状态为'待初查'");
					}else if (entity.getXszt().equals("10")) {
						
						cznrBF.append(", 当前线索状态为'待复查'");
					}else if (entity.getXszt().equals("20")) {
						
						cznrBF.append(", 当前线索状态为'递转中'");
					}else if (entity.getXszt().equals("30")) {
						
						cznrBF.append(", 当前线索状态为'递转中'");
					}else if (entity.getXszt().equals("40")) {
						
						cznrBF.append(", 当前线索状态为'已处理'");
					}else if (entity.getXszt().equals("50")) {
						
						cznrBF.append(", 当前线索状态为'已废弃'");
					}
					xscljlbService.saveLog(xsbh, cznrBF.toString(), czlx, sessionBean);
				}
				
				// ********************************************日志处理
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES,  getMessage("update.success"));
				//待办发送
				MessageUtils.rmdb_3d(entity.getId());
				MessageUtils.db_3d(entity.getId(), entity.getSlfzdm(), sessionBean);
				//待办发送
			}
		}catch (Exception e) {
			
			e.printStackTrace();
			logger.error(e.getLocalizedMessage(), e);
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, getAddFail());
		}
		
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}
	
	/**
	 * 初查</br>
	 * 在save的基础上增加递转和递转的新增申请
	 * @param entity
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/saveCC", method = RequestMethod.POST)
	public ModelAndView saveCC(Xsjbxxb entity){
		
		ModelAndView mv = new ModelAndView("redirect:/forward/" + AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		
		String orgCode = "";
		if (null != sessionBean) {
			
			orgCode = sessionBean.getUserOrgCode();
		}
		try {
			if (entity.getId() == null || entity.getId().equals("")) {	//新增
				
				xsjbxxbService.save(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES,  getMessage("add.success"));
				model.put(AppConst.SAVE_ID, entity.getId()); // 返回主键
			} else {	//修改
				
				if (entity.getCcjg().equals("10") || entity.getCcjg().equals("20")) {
					
					// 初查结果为  10：已采用正在调查中,  20：已采用并立案侦查, 则修改线索状态为10：待复查
					entity.setXszt("10");
					entity.setFcsj(DateUtils.getSystemDateString());
					
				} else if (entity.getCcjg().equals("30")) {
					
					// 初查结果为30：经查无作用, 则修改线索状态为50：已废弃
					entity.setXszt("50");
					entity.setFcsj(DateUtils.getSystemDateString());
//				} else if (entity.getCcjg().equals("40")) {
//					
//					// 初查结果为40：经查非本站管辖范围,  则修改线索状态为20：递转中
//					entity.setXszt("20");
//					entity.setFcsj(DateUtils.getSystemDateString());
//					// 已递转
//					entity.setDzbz("1");
//					// 插数据到递转申请表
//					Xsdzsqb xsdzsq = new Xsdzsqb();
//					
//					// 申请编号
//					String DZSQ = commonService.CreateNewSeq("01", orgCode);
//					xsdzsq.setId(DZSQ);
//					
//					// 线索编号
//					xsdzsq.setXsbh(entity.getId()); 
//					
//					// 递转申请发起单位
//					
//					xsdzsq.setDzfqdw(orgCode); 
//					
//					// 递转接收发起单位 
//					String dzjsdw = commonService.queryPcsByDZID(entity.getXsdzdm());
//					xsdzsq.setDzjsdw(dzjsdw); 
//					
//					// 审批状态初始化
//					xsdzsq.setSpzt("0"); 
//					
//					// 申请时间  系统自动获取
//					//xsdzsq.setSqsj()); 
//					
//					// 流转状态初始化
//					xsdzsq.setLzzt("1"); 
//					
//					xsdzsqbService.save(xsdzsq, sessionBean);
//					
//					//*******************************************************************************
//					// 插数据到递转审批表
//					Xsdzspb xsdzspb = new Xsdzspb();
//					
//					// 线索编号
//					xsdzspb.setXsbh(entity.getId());
//					
//					// 申请时间 系统自动获取
//					// xsdzspb.setSqsj("");
//					String DZSP = commonService.CreateNewSeq("02", orgCode);
//					
//					//审批编号
//					xsdzspb.setId(DZSP);
//					
//					// 申请编号： 申请表ID
//					xsdzspb.setSqbh(DZSQ);
//					// 递转发起单位 当前派出所
//					xsdzspb.setSqdw(orgCode);
//					
//					// 递转接受单位：派出所所属分局
//					xsdzspb.setSpdw(commonService.queryUpOrgID(orgCode));
//					
//					//审批状态 初始值
//					xsdzspb.setSpzt("0");
//					
//					xsdzspbService.save(xsdzspb, sessionBean);
					
//				} else if (entity.getCcjg().equals("50")) {
				} else if (entity.getCcjg().equals("40")) {
					// 初查结果为40：非本站关系申请递转, 则修改线索状态为20：递转中
					entity.setXszt("20");
					entity.setFcsj(DateUtils.getSystemDateString());
					// 已递转
					entity.setZcbz("1");
					// 数据插入到线索递转表
					Xszcsqb xszcsq = new Xszcsqb();
					// 线索编号
					xszcsq.setXsbh(entity.getId()); 

					String ZCSQ = commonService.CreateNewSeq("03", orgCode);
					
					// ID
					xszcsq.setId(ZCSQ);
					xszcsq.setXsbh(entity.getId());
					// 递转申请发起单位
					xszcsq.setZcfqdw(orgCode); 

					// 审批状态初始化
					xszcsq.setSpzt("0"); 

					// 申请时间  系统自动获取
					//xszcsq.setSqsj()); 

					// 流转状态初始化
					xszcsq.setLzzt("1"); 

					xszcsqbService.save(xszcsq, sessionBean);
					
					//*************************************************************************************
					Xszcspb xszcspb = new Xszcspb();
					
					String ZCSP = commonService.CreateNewSeq("04", orgCode);
					
					xszcspb.setId(ZCSP);
					// 线索编号
					xszcspb.setXsbh(entity.getId());
					
					// 申请编号 申请表ID
					xszcspb.setSqbh(xszcsq.getId());
					// 申请时间 系统自动获取
					// xszcspb.setSqsj("");
					
					// 申请单位  当前派出所
					xszcspb.setSqdw(orgCode);
					
					// 审批单位 派出所所属分局
					xszcspb.setSpdw(commonService.queryUpOrgID(orgCode));
					
					// 审批状态 初始值
					xszcspb.setSpzt("0");
					
					xszcspbService.save(xszcspb, sessionBean);
					
					MessageUtils.rmdb_3d(entity.getId());
					MessageUtils.db_dzsp(xszcspb);	//递转审批待办任务
		
				}
				
				xsjbxxbService.update(entity, sessionBean);
				
				entity = xsjbxxbService.queryById(entity);
				// ********************************************日志处理
				MessageUtils.rmdb_3d(entity.getId());
				if (null !=sessionBean && null != entity) {
					
					String userName = sessionBean.getUserName();
					String orgName = sessionBean.getUserOrgName();
					
					czlx = "20";
					xsbh = entity.getId();
					cznrBF = new StringBuffer();
					cznrBF.append(orgName);
					cznrBF.append(" 的 ");
					cznrBF.append(userName);
					cznrBF.append(", 进行了初查");
					if (entity.getXszt().equals("00")) {
						
						cznrBF.append(", 当前线索状态为'待初查'");
					}else if (entity.getXszt().equals("10")) {
						cznrBF.append(", 当前线索状态为'待复查'");
						
						MessageUtils.db_30d(entity.getId(), entity.getSlfzdm(), sessionBean);
						
					}else if (entity.getXszt().equals("20")) {
						
						cznrBF.append(", 当前线索状态为'递转中'");
					}else if (entity.getXszt().equals("30")) {
						
						cznrBF.append(", 当前线索状态为'递转中'");
					}else if (entity.getXszt().equals("40")) {
						
						cznrBF.append(", 当前线索状态为'已处理'");
					}else if (entity.getXszt().equals("50")) {
						
						cznrBF.append(", 当前线索状态为'已废弃'");
					}
					xscljlbService.saveLog(xsbh, cznrBF.toString(),czlx, sessionBean);
				}
				
				// ********************************************日志处理
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES,  getMessage("update.success"));
			}
		}catch (Exception e) {
			
			e.printStackTrace();
			logger.error(e.getLocalizedMessage(), e);
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, getAddFail());
		}
		MessageUtils.rmdb_xsbhCc(entity.getId());
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}
	
	/**
	 * 复查</br>
	 * 在save的基础上增加递转和递转的申请
	 * @param entity
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/saveFC", method = RequestMethod.POST)
	public ModelAndView saveFC(Xsjbxxb entity){
		
		ModelAndView mv = new ModelAndView("redirect:/forward/" + AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		String orgCode = "";
		if (null != sessionBean) {
			
			orgCode = sessionBean.getUserOrgCode();
		}
		try {
			if (entity.getId() == null || entity.getId().equals("")) {	//新增
				
				xsjbxxbService.save(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES,  getMessage("add.success"));
				model.put(AppConst.SAVE_ID, entity.getId()); // 返回主键
			} else {	//修改
						
				if (entity.getFcjg().equals("10") || entity.getFcjg().equals("20")) {
					
					// 复查结果为  10：已采用正在调查中,  20：已采用并立案侦查, 则修改线索状态为10：待复查
					entity.setXszt("40");
				} else if (entity.getFcjg().equals("30")) {
					
					// 复查结果为30：经查无作用, 则修改线索状态为50：已废弃
					entity.setXszt("50");
//				} else if (entity.getFcjg().equals("40")) {
//					
//					// 初查结果为40：经查非本站管辖范围,  则修改线索状态为20：递转中
//					entity.setXszt("20");
//					entity.setCcsj(DateUtils.getSystemDateString());
//					// 已递转
//					entity.setDzbz("1");
//					// 插数据到递转申请表
//					Xsdzsqb xsdzsq = new Xsdzsqb();
//					
//					// 申请编号
//					String DZSQ = commonService.CreateNewSeq("01", orgCode);
//					xsdzsq.setId(DZSQ);
//					
//					// 线索编号
//					xsdzsq.setXsbh(entity.getId()); 
//					
//					// 递转申请发起单位
//					
//					xsdzsq.setDzfqdw(orgCode); 
//					
//					// 递转接收发起单位 
//					String dzjsdw = commonService.queryPcsByDZID(entity.getXsdzdm());
//					xsdzsq.setDzjsdw(dzjsdw); 
//					
//					// 审批状态初始化
//					xsdzsq.setSpzt("0"); 
//					
//					// 申请时间  系统自动获取
//					//xsdzsq.setSqsj()); 
//					
//					// 流转状态初始化
//					xsdzsq.setLzzt("1"); 
//					
//					xsdzsqbService.save(xsdzsq, sessionBean);
//					
//					//*******************************************************************************
//					// 插数据到递转审批表
//					Xsdzspb xsdzspb = new Xsdzspb();
//					
//					// 线索编号
//					xsdzspb.setXsbh(entity.getId());
//					
//					// 申请时间 系统自动获取
//					// xsdzspb.setSqsj("");
//					String DZSP = commonService.CreateNewSeq("02", orgCode);
//					
//					//审批编号
//					xsdzspb.setId(DZSP);
//					
//					// 申请编号： 申请表ID
//					xsdzspb.setSqbh(DZSQ);
//					// 递转发起单位 当前派出所
//					xsdzspb.setSqdw(orgCode);
//					
//					// 递转接受单位：派出所所属分局
//					xsdzspb.setSpdw(commonService.queryUpOrgID(orgCode));
//					
//					//审批状态 初始值
//					xsdzspb.setSpzt("0");
//					
//					xsdzspbService.save(xsdzspb, sessionBean);
//					
//				} else if (entity.getFcjg().equals("50")) {
				} else if (entity.getFcjg().equals("40")) {
					// 初查结果为50：管辖单位有争议申请上级递转, 则修改线索状态为30：递转中---------无效
					// 初查结果为40：非本站关系申请递转, 则修改线索状态为20：递转中
					entity.setXszt("20");
					//entity.setCcsj(DateUtils.getSystemDateString());
					// 已递转
					entity.setZcbz("1");
					// 数据插入到线索递转表
					Xszcsqb xszcsq = new Xszcsqb();
					// 线索编号
					xszcsq.setXsbh(entity.getId()); 

					String ZCSQ = commonService.CreateNewSeq("03", orgCode);
					
					// ID
					xszcsq.setId(ZCSQ);
					xszcsq.setXsbh(entity.getId());
					// 递转申请发起单位
					xszcsq.setZcfqdw(orgCode); 

					// 审批状态初始化
					xszcsq.setSpzt("0"); 

					// 申请时间  系统自动获取
					//xszcsq.setSqsj()); 

					// 流转状态初始化
					xszcsq.setLzzt("1"); 

					xszcsqbService.save(xszcsq, sessionBean);
					
					//*************************************************************************************
					Xszcspb xszcspb = new Xszcspb();
					
					String ZCSP = commonService.CreateNewSeq("04", orgCode);
					xszcspb.setId(ZCSP);
					// 线索编号
					xszcspb.setXsbh(entity.getId());
					
					// 申请编号 申请表ID
					xszcspb.setSqbh(xszcsq.getId());
					// 申请时间 系统自动获取
					// xszcspb.setSqsj("");
					
					// 申请单位  当前派出所
					xszcspb.setSqdw(orgCode);
					
					// 审批单位 派出所所属分局
					xszcspb.setSpdw(commonService.queryUpOrgID(orgCode));
					
					// 审批状态 初始值
					xszcspb.setSpzt("0");
					
					xszcspbService.save(xszcspb, sessionBean);
					
					
					MessageUtils.db_dzsp(xszcspb);	//递转审批待办任务
				} 
				 
				xsjbxxbService.update(entity, sessionBean);
				MessageUtils.rmdb_30d(entity.getId());
				// ********************************************日志处理
				if (null !=sessionBean && null != entity) {
					
					String userName = sessionBean.getUserName();
					String orgName = sessionBean.getUserOrgName();
					
					czlx = "30";
					xsbh = entity.getId();
					cznrBF = new StringBuffer();
					cznrBF.append(orgName);
					cznrBF.append(" 的 ");
					cznrBF.append(userName);
					cznrBF.append(", 进行了复查");
					if (entity.getXszt().equals("00")) {
						
						cznrBF.append(", 当前线索状态为'待初查'");
					}else if (entity.getXszt().equals("10")) {
						
						cznrBF.append(", 当前线索状态为'待复查'");
					}else if (entity.getXszt().equals("20")) {
						
						cznrBF.append(", 当前线索状态为'递转中'");
					}else if (entity.getXszt().equals("30")) {
						
						cznrBF.append(", 当前线索状态为'递转中'");
					}else if (entity.getXszt().equals("40")) {
						
						cznrBF.append(", 当前线索状态为'已处理'");
					}else if (entity.getXszt().equals("50")) {
						
						cznrBF.append(", 当前线索状态为'已废弃'");
					}
					xscljlbService.saveLog(xsbh, cznrBF.toString(), czlx, sessionBean);
				}
				
				// ********************************************日志处理
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES,  getMessage("update.success"));
			}
		}catch (Exception e) {
			
			e.printStackTrace();
			logger.error(e.getLocalizedMessage(), e);
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, getAddFail());
		}
		MessageUtils.rmdb_xsbhFc(entity.getId());
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}
	/**
	 * 注销
	 * @param entity
	 * @return
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public @ResponseBody
	ModelAndView delete(Xsjbxxb entity){
		
		ModelAndView mv = new ModelAndView("redirect:/forward/"	+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		
		try {
			
			xsjbxxbService.delete(entity, sessionBean);
			model.put(AppConst.STATUS, AppConst.SUCCESS);
			model.put(AppConst.MESSAGES,  getMessage("cancel.success"));
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
	 * 判断当前用户是不是高级管理员，是返回1，否则返回0
	 * @param xsbh
	 * @return
	 */
	@RequestMapping(value = "/isGjgly", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> isGjgly(){
		String isGjgly = "0";
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		OrgRightPublic orgRightPublic = new OrgRightPublic();
		List<OrgRole> list = new ArrayList<OrgRole>();
		list = orgRightPublic.queryUserAssignRole(sessionBean);//获得当前用户所有角色
		for(OrgRole tem:list){
			if("有奖举报管理员".equals(tem.getRolename())){//以后改成tem.getBz()
				isGjgly = "1";
			}
		}
		model.put("isGjgly", isGjgly);
		return model;
	}
}
