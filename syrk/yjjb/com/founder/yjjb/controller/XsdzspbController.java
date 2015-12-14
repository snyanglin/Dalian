package com.founder.yjjb.controller;

import java.util.HashMap;
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
import com.founder.framework.organization.department.bean.OrgOrganization;
import com.founder.framework.organization.department.service.OrgOrganizationService;
import com.founder.framework.utils.DateUtils;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.yjjb.bean.Xsdzspb;
import com.founder.yjjb.bean.Xsdzsqb;
import com.founder.yjjb.bean.Xsjbxxb;
import com.founder.yjjb.service.CommonService;
import com.founder.yjjb.service.XsdzspbService;
import com.founder.yjjb.service.XsdzsqbService;
import com.founder.yjjb.service.XsjbxxbService;

import com.google.gson.Gson;

/**
 * 线索递转审批表</br>
 * @author Administrator
 * @since 2014-11-24
 */
@Controller
@RequestMapping(value = "/xsdzspb")
public class XsdzspbController extends BaseController {

	private Logger logger = Logger.getLogger(this.getClass());
	
	@Resource(name="xsdzspbService")
	private XsdzspbService xsdzspbService;
	
	@Resource(name="xsdzsqbService")
	private XsdzsqbService xsdzsqbService;
	
	@Resource(name="xsjbxxbService")
	private XsjbxxbService xsjbxxbService;
	
	@Resource(name = "orgOrganizationService")
	private OrgOrganizationService orgOrganizationService;
	
	@Resource(name="commonService")
	private CommonService commonService;
	
	/**
	 * 跳转
	 * @param id
	 * @param mainTabID
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/openList", method = RequestMethod.GET)
	public ModelAndView xsdzspbList(String id,String mainTabID) {
		
		ModelAndView mv = new ModelAndView("yjjb/dzspList");
		mv.addObject("mainTabID", mainTabID);
		Xsdzspb entity = new Xsdzspb();
		
		if (!StringUtils.isBlank(id)) {
			
			entity.setId(id);
			entity = xsdzspbService.queryById(entity);
		}
		mv.addObject("entity", entity);
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
			@RequestParam(value = "rows") Integer rows, Xsdzspb entity){
		
		page.setPagePara(rows);
		SessionBean sessionBean = getSessionBean();
		if(null != sessionBean){
			
		}
		if (null == entity.getSpdw()) {
			
			// 默认查询条件为本单位，页面查询条件为本单位及下属单位
			entity.setSpdw(sessionBean.getUserOrgCode());
		}
		
		// 去除右侧的0，进行模糊查询
		entity.setSpdw(entity.getSpdw().replaceAll("0+?$", ""));
		
		return this.xsdzspbService.queryList(page,entity);
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
		
		ModelAndView mv = new ModelAndView("yjjb/dzspAdd");
		mv.addObject("mainTabID", mainTabID);
		Xsdzspb entity = new Xsdzspb();
		
		if (!StringUtils.isBlank(id)) {
			
			entity.setId(id);
			entity = xsdzspbService.queryById(entity);
		}
		
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
	public ModelAndView save(Xsdzspb entity){
		
		ModelAndView mv = new ModelAndView("redirect:/forward/" + AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		try {
			
			if (entity.getId() == null || entity.getId().equals("")) {	//新增
				
				xsdzspbService.save(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES,  getMessage("add.success"));
				model.put(AppConst.SAVE_ID, entity.getId()); // 返回主键
			} else {	//修改
				
				xsdzspbService.update(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES,  getMessage("update.success"));
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
	 * 注销
	 * @param entity
	 * @return
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public @ResponseBody
	ModelAndView delete(Xsdzspb entity){
		
		ModelAndView mv = new ModelAndView("redirect:/forward/"	+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		
		try {
			
			xsdzspbService.delete(entity, sessionBean);
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
	 * 审批操作
	 * @param id
	 * @param mainTabID
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/approval", method = RequestMethod.GET)
	public ModelAndView approval(String id,String sqbh,String xsbh,String mainTabID) {
		
		// “XS”开头的字段为初始信息
		// “SL”开头的字段为递转临时字段
		ModelAndView mv = new ModelAndView("yjjb/jbxsDZSP");
		mv.addObject("mainTabID", mainTabID);
		SessionBean sessionBean = getSessionBean();
		Xsjbxxb entity = new Xsjbxxb();
		String orgCode = sessionBean.getUserOrgCode();
		OrgOrganization orgOrganization = orgOrganizationService.queryByOrgcode(orgCode);
		String theHighest = "";
		
		// 是否是最高级别
		if(orgOrganization.getParenttreepath()== null){
			
			theHighest = "1";
		}else{
			
			theHighest = "0";
		}
		
		if (!StringUtils.isBlank(xsbh)) {
			entity.setId(xsbh);
			entity = xsjbxxbService.queryById(entity);
		}
		
		// **递转信息*****************************************************************************
		
		String targetPCS = "";
		if (null != entity.getSldzzbx() && null != entity.getSldzzby()) {
			
			// 地图选点
			targetPCS = "地图选点";
		} else {
			
			// 详细地址选点
			targetPCS = "详细地址选点";
		}
		// **递转信息*****************************************************************************
		mv.addObject("entity", entity);
		mv.addObject("pcs", targetPCS);
		
		
		mv.addObject("spbh", id);
		mv.addObject("sqbh", sqbh);
		mv.addObject("sqbh", sqbh);
		mv.addObject("theHighest", theHighest);
		return mv;
	}
	
	
	/**
	 * 审批处理</br>
	 * @param entity
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/choose", method = RequestMethod.POST)
	public ModelAndView choose(Xsdzspb entity,String btnType){
		
		ModelAndView mv = new ModelAndView("redirect:/forward/" + AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		
		// 递转审批表
		// ID已知，通过queryById获取审批表信息
		entity = xsdzspbService.queryById(entity);
		
		// 审批编号
		String spbh = entity.getId();
		
		// 线索编号
		String xsbh = entity.getXsbh();
		
		// 申请编号
		String sqbh = entity.getSqbh();
		
		// 本条记录的审批单位
		String spdw = entity.getSpdw();
		String orgcode = sessionBean.getUserOrgName();
		
		// 递转审请表
		Xsdzsqb xsdzsqb = new Xsdzsqb();
		//使用审批表的申请编号作为申请表的ID，获取申请信息
		xsdzsqb.setId(sqbh);
		xsdzsqb = xsdzsqbService.queryById(xsdzsqb);
		// 递转接受单位的前六位是否等于当前处理单位的前六位，
		// 是true（接收单位为下属单位），否false（接收单位非下属单位）
		boolean blnXSDW = xsdzsqb.getDzjsdw().substring(0, 6).equals(orgcode.substring(0, 6));
		
		// 线索基本信息
		Xsjbxxb xsjbxxb = new Xsjbxxb();
		// 使用审批表的线索编号作为线索表的ID，获取线索信息
		xsjbxxb.setId(xsbh);
		xsjbxxb = xsjbxxbService.queryById(xsjbxxb);
		
		// 新增一条审批记录
		Xsdzspb xsdzspb = new Xsdzspb();
		
		// 最顶级单位：指挥中心
		String orgCenter = "210200000000";
		try {
			
			if (null !=orgcode && orgcode.equals(orgCenter)) {
				
				// 受理中心审批 TODO
				if (null != btnType && btnType.equals("1")) {
					
					// 同意递转
					// *****处理审批表************************************************************
					// 审批通过,修改原纪录为【同意】
					entity.setSpzt("1");
					//entity.setBz("-"+orgcode+"同意递转-"+entity.getBz());
					xsdzspbService.save(entity, sessionBean);
					//审批通过新增一条审批记录
					xsdzspb.setId(commonService.CreateNewSeq("02", orgcode));
					xsdzspb.setXsbh(xsbh);
					xsdzspb.setSqbh(sqbh);
					xsdzspb.setSqsj(DateUtils.getSystemDateString());
					xsdzspb.setSqdw(entity.getSqdw());
					
					if (xsdzsqb.getLzzt().equals("0")) {
						
						// 审批单位（上行）:递转申请表[接收单位]的上级单位
						xsdzspb.setSpdw(commonService.queryUpOrgID(xsdzsqb.getDzjsdw()));
					} else{
						
						// 审批单位（下行）:递转申请表[发起单位]的上级单位
						xsdzspb.setSpdw(commonService.queryUpOrgID(xsdzsqb.getDzfqdw()));
					}
					
					xsdzspb.setSpzt("0");
					xsdzspb.setSphf("");
					xsdzspb.setLybh(spbh);
					xsdzspb.setBz("");
					xsdzspbService.save(xsdzspb, sessionBean);
					// *****处理申请表************************************************************
					if (xsdzsqb.getLzzt().equals("0")) {
						
						// 上行转下行
						xsdzsqb.setLzzt("1");
					} else{
						
						// 下行转上行
						xsdzsqb.setLzzt("0");
					}
					
					xsdzsqbService.save(xsdzsqb, sessionBean);
					// *****处理线索表************************************************************
					
				}else {
					
					// 拒绝递转
					// *****处理审批表************************************************************
					// 拒绝递转,修改原纪录为【拒绝】
					entity.setSpzt("1");
					entity.setBz("-"+orgcode+"-拒绝递转-"+entity.getBz());
					xsdzspbService.save(entity, sessionBean);
					//审批通过新增一条审批记录
					xsdzspb.setId(commonService.CreateNewSeq("02", orgcode));
					xsdzspb.setXsbh(xsbh);
					xsdzspb.setSqbh(sqbh);
					xsdzspb.setSqsj(DateUtils.getSystemDateString());
					xsdzspb.setSqdw(orgcode);
					
					if (xsdzsqb.getLzzt().equals("0")) {
						
						// 审批单位（上行）:递转申请表[发起单位]的上级单位
						xsdzspb.setSpdw(commonService.queryUpOrgID(xsdzsqb.getDzfqdw()));
					} else{
						
						// 审批单位（下行）:递转申请表[接收单位]的上级单位
						xsdzspb.setSpdw(commonService.queryUpOrgID(xsdzsqb.getDzjsdw()));
					}
					
					xsdzspb.setSpzt("0");
					xsdzspb.setSphf("");
					xsdzspb.setLybh(spbh);
					xsdzspb.setBz("");
					xsdzspbService.save(xsdzspb, sessionBean);
					// *****处理申请表************************************************************
					if (xsdzsqb.getLzzt().equals("0")) {
						
						// 上行转下行
						xsdzsqb.setLzzt("1");
					} else{
						
						// 下行转上行
						xsdzsqb.setLzzt("0");
					}
					
					xsdzsqbService.save(xsdzsqb, sessionBean);
					// *****处理线索表************************************************************
				}
				
			} else if (orgcode.substring(6, 12).equals("000000")) {
				
				// 受理站审批
				// 由受理中心发起的申请
				if (entity.getSqdw().equals(orgCenter)) {
					
					if (null != btnType && btnType.equals("0")) {
						
						// 同意递转
						// *****处理审批表************************************************************
						// 审批通过,修改原纪录为【同意】
						entity.setSpzt("1");
						entity.setBz("-"+orgcode+"-同意递转-"+entity.getBz());
						xsdzspbService.save(entity, sessionBean);
						
						//审批通过新增一条审批记录
						xsdzspb.setId(commonService.CreateNewSeq("02", orgcode));
						xsdzspb.setXsbh(xsbh);
						xsdzspb.setSqbh(sqbh);
						xsdzspb.setSqsj(DateUtils.getSystemDateString());
						xsdzspb.setSqdw(orgcode);
						
						if (xsdzsqb.getLzzt().equals("0")) {
							
							// 中心发送递转给站，上行
							if (blnXSDW) {
								
								//站内传递，审批通过
								xsdzspb.setSpdw(xsdzsqb.getDzjsdw());

							}else{
								
								// 站外传递，递转给指挥中心
								xsdzspb.setSpdw(orgCenter);
							}

						} else{
							
							if (blnXSDW) {
								
								// 站内传递，审批拒绝
								xsdzspb.setSpdw(xsdzsqb.getDzfqdw());
							} else{
								
								// 站外传递，递转给指挥中心
								xsdzspb.setSpdw(orgCenter);
							}
						}
					}
				}
				// 受理站审批
				if (null != btnType && btnType.equals("0")) {
					

					

					

					xsdzspb.setSpzt("0");
					xsdzspb.setSphf("");
					xsdzspb.setLybh(spbh);
					xsdzspb.setBz("");
					xsdzspbService.save(xsdzspb, sessionBean);
					
					// *****处理申请表************************************************************
						
					if (xsdzsqb.getLzzt().equals("0")) {
						
						if (blnXSDW) {
							
							// 站内递转，上行， 同意申请
							xsdzsqb.setSpzt("1");
							// 初始化线索信息表
							xsjbxxb.setXsdzdm(xsjbxxb.getSldzdm());
							xsjbxxb.setXsdzms(xsjbxxb.getSldzms());
							xsjbxxb.setXsdzmlpdm(xsjbxxb.getSldzmlpdm());
							xsjbxxb.setXsdzmlpxz(xsjbxxb.getSldzxz());
							xsjbxxb.setXsdzssxdm(xsjbxxb.getSldzssxdm());
							
							xsjbxxb.setSlfzdm(commonService.queryPcsByDZID(xsjbxxb.getSldzdm()));
							xsjbxxb.setSlzdm(commonService.queryUpOrgID(commonService.queryPcsByDZID(xsjbxxb.getSldzdm())));
							xsjbxxb.setSlzxdm(orgCenter);
							
							xsjbxxb.setCcsj(DateUtils.getSystemDateString().substring(0,10));
							xsjbxxb.setCcjg("00");
							xsjbxxb.setFcjg("00");
							xsjbxxb.setXszt("00");
						}else{
							
						}
					} else {
						
						if (blnXSDW) {
							
						}else{
							
							//站外递转，下行拒绝
							xsdzsqb.setSpzt("2");
						}
					}
					
					xsdzsqbService.save(xsdzsqb, sessionBean);
					// *****处理线索表************************************************************
					
				}else {
					
					// 拒绝递转
				}
				
			}else{
				
				// 分站处理
			}
		} catch (Exception e) {

			e.printStackTrace();
			logger.error(e.getLocalizedMessage(), e);
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, getAddFail());
		}
//		try {
//			
//			if (entity.getId() == null || entity.getId().equals("")) {	//新增
//				
//				xsdzspbService.save(entity, sessionBean);
//				model.put(AppConst.STATUS, AppConst.SUCCESS);
//				model.put(AppConst.MESSAGES,  getMessage("add.success"));
//				model.put(AppConst.SAVE_ID, entity.getId()); // 返回主键
//			} else {	//修改
//				
//				xsdzspbService.update(entity, sessionBean);
//				model.put(AppConst.STATUS, AppConst.SUCCESS);
//				model.put(AppConst.MESSAGES,  getMessage("update.success"));
//			}
//		}catch (Exception e) {
//			
//			e.printStackTrace();
//			logger.error(e.getLocalizedMessage(), e);
//			model.put(AppConst.STATUS, AppConst.FAIL);
//			model.put(AppConst.MESSAGES, getAddFail());
//		}
//		
//		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}

	// TODO
	private String getspdw(Xsjbxxb entity, boolean b) {
		
		String orgcode = "";
		if (b) {
			
			// 审批通过
		} else {
			
			// 审批拒绝
		}
		return orgcode;
	}
}
