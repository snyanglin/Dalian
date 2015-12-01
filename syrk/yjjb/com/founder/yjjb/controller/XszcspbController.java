package com.founder.yjjb.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import com.founder.framework.organization.department.service.OrgOrganizationService;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.yjjb.bean.Xsajgxb;
import com.founder.yjjb.bean.Xsjbxxb;
import com.founder.yjjb.bean.Xszcspb;
import com.founder.yjjb.bean.Xszcsqb;
import com.founder.yjjb.service.CommonService;
import com.founder.yjjb.service.XscljlbService;
import com.founder.yjjb.service.XsjbxxbService;
import com.founder.yjjb.service.XszcspbService;
import com.founder.yjjb.service.XszcsqbService;
import com.founder.yjjb.utils.MessageUtils;

import com.google.gson.Gson;

/**
 * 线索递转审批表</br>
 * @author Administrator
 * @since 2014-11-24
 */
@Controller
@RequestMapping(value = "/xszcspb")
public class XszcspbController extends BaseController {

	private Logger logger = Logger.getLogger(this.getClass());
	
	@Resource(name="xszcspbService")
	private XszcspbService xszcspbService;
	@Resource(name="xszcsqbService")
	private XszcsqbService xszcsqbService;
	@Resource(name="xsjbxxbService")
	private XsjbxxbService xsjbxxbService;
	@Resource(name="commonService")
	private CommonService commonService;
	
	@Resource(name = "orgOrganizationService")
	private OrgOrganizationService orgOrganizationService;
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
	public ModelAndView xszcspbList(String id,String mainTabID) {
		
		ModelAndView mv = new ModelAndView("yjjb/zcspList");
		mv.addObject("mainTabID", mainTabID);
		Xszcspb entity = new Xszcspb();
		
		if (!StringUtils.isBlank(id)) {
			
			entity.setId(id);
			entity = xszcspbService.queryById(entity);
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
			@RequestParam(value = "rows") Integer rows, Xszcspb entity){
		
		page.setPagePara(rows);
		SessionBean sessionBean = getSessionBean();
		if(null != sessionBean){
			String orgCode = sessionBean.getUserOrgCode();
			entity.setSpdw(orgCode);
		}
		
		return this.xszcspbService.queryList(page,entity);
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
		
		ModelAndView mv = new ModelAndView("yjjb/zccl");
		mv.addObject("mainTabID", mainTabID);
		SessionBean sessionBean = getSessionBean();
		Xsjbxxb entity = new Xsjbxxb();
		String orgCode = sessionBean.getUserOrgCode();
		String dwjb = commonService.getDwjb(orgCode);
		String theHighest = "";
		if(dwjb.equals("02")){
			theHighest = "1";
		}else{
			theHighest = "0";
		}
		
		if (!StringUtils.isBlank(xsbh)) {
			entity.setId(xsbh);
			entity = xsjbxxbService.queryById(entity);
		}
		mv.addObject("dwjb",dwjb);
		mv.addObject("entity", entity);
		mv.addObject("spbh", id);
		mv.addObject("sqbh", sqbh);
		mv.addObject("theHighest", theHighest);
		return mv;
	}
	
	/**
	 * 查看详细
	 * @param id
	 * @param mainTabID
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/viewDetail", method = RequestMethod.GET)
	public ModelAndView viewDetail(String id,String sqbh,String xsbh,String mainTabID) {
		
		ModelAndView mv = new ModelAndView("yjjb/zcclV");
		mv.addObject("mainTabID", mainTabID);
		Xsjbxxb entity = new Xsjbxxb();
		Xszcspb entitySp = new Xszcspb();
		
		if (!StringUtils.isBlank(xsbh)) {
			entity.setId(xsbh);
			entity = xsjbxxbService.queryById(entity);
		}
		if (!StringUtils.isBlank(id)) {
			entitySp.setId(id);
			entitySp = xszcspbService.queryById(entitySp);
		}
		
		mv.addObject("entity", entity);
		mv.addObject("spbh", id);
		mv.addObject("sqbh", sqbh);
		mv.addObject("sphf", entitySp.getSphf());
		
		return mv;
	}
	
	/**
	 * 新增和修改
	 * @param entity
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(Xszcspb entity){
		
		ModelAndView mv = new ModelAndView("redirect:/forward/" + AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		try {
			
			if (entity.getId() == null || entity.getId().equals("")) {	//新增
				
				xszcspbService.save(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES,  getMessage("add.success"));
				model.put(AppConst.SAVE_ID, entity.getId()); // 返回主键
			} else {	//修改
				
				xszcspbService.update(entity, sessionBean);
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
	ModelAndView delete(Xszcspb entity){
		
		ModelAndView mv = new ModelAndView("redirect:/forward/"	+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		
		try {
			
			xszcspbService.delete(entity, sessionBean);
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
	 * 确认仲裁
	 * @param entity
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/chuliZC", method = RequestMethod.POST)
	public ModelAndView chuliZC(Xszcspb entity,String btnType,String slfzdm,String slzdm,String sldw,String slzxdm){
		
		ModelAndView mv = new ModelAndView("redirect:/forward/" + AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		
		Xszcsqb XszcspbSQ = new Xszcsqb();
		Xszcspb XszcspbSP = new Xszcspb();
		Xszcspb XszcspbSP2 = new Xszcspb();
		Xsjbxxb xsjbxxb = new Xsjbxxb();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			if("0".equals(btnType)) {//如果点击确认仲裁
				String orgCode = sessionBean.getUserOrgCode();
				//OrgOrganization enti = orgOrganizationService.queryByOrgcode(orgCode);
				String dwjb = commonService.getDwjb(orgCode);
				if(dwjb.equals("02")){//如果该级别没有父亲，也就是说这是最上级
					slzdm = sldw.equals("")?slzdm:sldw;
					//更新审批表
					XszcspbSP.setId(entity.getId());
					XszcspbSP.setSpzt("1");
					XszcspbSP.setSphf(entity.getSphf());
					//XszcspbSP.setZpsldw(slzdm);//由中心到站，暂时不知道具体的受理单位
					xszcspbService.update(XszcspbSP, sessionBean);
					//新建一条审批记录
					String ZCSP = commonService.CreateNewSeq("04", orgCode);
					XszcspbSP2.setId(ZCSP);
					XszcspbSP2.setLybh(entity.getId());//申请记录的上一流程的编号
					XszcspbSP2.setXsbh(entity.getXsbh());// 线索编号
					XszcspbSP2.setSqbh(entity.getSqbh());// 申请编号
					XszcspbSP2.setSqdw(orgCode);// 申请单位
					XszcspbSP2.setSpdw(slzdm);//受理站代码
					XszcspbSP2.setSpzt("0");// 审批状态 初始值
					xszcspbService.save(XszcspbSP2, sessionBean);
					
					// ********************************************日志处理
					String userName = sessionBean.getUserName();
					String orgName = sessionBean.getUserOrgName();
					
					czlx = "10";
					xsbh = entity.getId();
					cznrBF = new StringBuffer();
					cznrBF.append(orgName);
					cznrBF.append(" 的 ");
					cznrBF.append(userName);
						
					cznrBF.append(", 完成了审批, 当前线索状态为'递转中'");
					xscljlbService.saveLog(xsbh, cznrBF.toString(),czlx, sessionBean);
					
					MessageUtils.db_dzsp(XszcspbSP2);	//递转审批待办任务
					// ********************************************日志处理
					
				}else if(dwjb.equals("01")){//如果该级别有父亲，则是从站往分站走
					//更新申请表
					XszcspbSQ.setId(entity.getSqbh());
					XszcspbSQ.setSpzt("1");
					xszcsqbService.update(XszcspbSQ, sessionBean);
					//更新审批表
					XszcspbSP.setId(entity.getId());
					XszcspbSP.setSpzt("1");
					XszcspbSP.setSphf(entity.getSphf());
					XszcspbSP.setZpsldw(slfzdm);//受理分站代码
					xszcspbService.update(XszcspbSP, sessionBean);
					//更新线索表
					xsjbxxb.setId(entity.getXsbh());

//					xsjbxxb.setSlfzdm(slfzdm);//受理分站代码
//					xsjbxxb.setSlzdm(commonService.queryUpOrgID(slfzdm));//受理站代码
//					xsjbxxb.setSlzxdm(commonService.queryUpOrgID(commonService.queryUpOrgID(slfzdm)));//受理中心代码
					
					//**************************************************************************
					//获取线索信息
					xsjbxxb = xsjbxxbService.queryById(xsjbxxb);
					if (null == slfzdm || slfzdm.equals("")) {
						if (null != xsjbxxb.getSldzdm() && !xsjbxxb.getSldzdm().equals("")) {
							xsjbxxb.setSlfzdm(commonService.queryPcsByDZID(xsjbxxb.getXsdzdm()));  // 根据线索地址查询所属派出所
							xsjbxxb.setSlzdm(commonService.queryUpOrgID(xsjbxxb.getSlfzdm()));     // 受理分站的上级单位为受理站
							xsjbxxb.setSlzxdm(commonService.queryUpOrgID(xsjbxxb.getSlzdm()));
						}
					} else{
						slfzdm = sldw.equals("")?slfzdm:sldw;
						xsjbxxb.setSlfzdm(slfzdm);//受理分站代码
						xsjbxxb.setSlzdm(commonService.queryUpOrgID(slfzdm));//受理站代码
						xsjbxxb.setSlzxdm(commonService.queryUpOrgID(xsjbxxb.getSlzdm()));//受理中心代码
					}
					
					// 如果因为地图选点错误，受理分站有数据，受理站仍然没有数据，则使用受理分站的上级单位作为受理站
					if (null == xsjbxxb.getSlzdm() || xsjbxxb.getSlzdm().equals("")) {
						
						xsjbxxb.setSlzdm(commonService.queryUpOrgID(slfzdm));
					}
					
					// 如果因为地图选点错误，受理站有数据，受理中心仍然没有数据，则使用受理站的上级单位作为受理中心
					if (null == xsjbxxb.getSlzxdm() || xsjbxxb.getSlzxdm().equals("")) {
						
						xsjbxxb.setSlzxdm(commonService.queryUpOrgID(xsjbxxb.getSlzdm()));
					}
					
					// 如果受理中心仍然没有数据，则使用大连市公安局作为受理站
					if (null == xsjbxxb.getSlzxdm() || xsjbxxb.getSlzxdm().equals("")) {
						
						xsjbxxb.setSlzxdm("210200000000");
					}
					//**************************************************************************
					xsjbxxb.setXszt("00");
					xsjbxxb.setCcjg("00");
					xsjbxxb.setCcjg("00");
					//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					xsjbxxb.setCcsj(sdf.format(new Date()));
					xsjbxxb.setFcsj("");
					
					xsjbxxbService.update(xsjbxxb, sessionBean);
					
					// ********************************************日志处理
					String userName = sessionBean.getUserName();
					String orgName = sessionBean.getUserOrgName();
					
					czlx = "10";
					xsbh = entity.getId();
					cznrBF = new StringBuffer();
					cznrBF.append(orgName);
					cznrBF.append(" 的 ");
					cznrBF.append(userName);
						
					cznrBF.append(", 完成了审批, 当前线索状态为'待初查'");
					xscljlbService.saveLog(xsbh, cznrBF.toString(),czlx, sessionBean);
					MessageUtils.db_3d(xsjbxxb.getId(), xsjbxxb.getSlfzdm(), sessionBean);
					// ********************************************日志处理
				}
				
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES,  getMessage("update.success"));
			}else if("1".equals(btnType)) {//如果点击申请上级仲裁
				//更新仲裁表原数据的"审批状态"和"处理意见"
				XszcspbSP.setId(entity.getId());
				XszcspbSP.setSpzt("1");
				XszcspbSP.setSphf(entity.getSphf());
				xszcspbService.update(XszcspbSP, sessionBean);
				//在仲裁审批表插入新数据
				String orgCode = sessionBean.getUserOrgCode();
				String ZCSP = commonService.CreateNewSeq("04", orgCode);
				
				//审批表id
				XszcspbSP2.setId(ZCSP);
				//申请记录的上一流程的编号
				XszcspbSP2.setLybh(entity.getId());
				// 线索编号
				XszcspbSP2.setXsbh(entity.getXsbh());
				
				// 申请编号 申请表ID
				XszcspbSP2.setSqbh(entity.getSqbh());
				
				// 申请单位  当前派出所
				XszcspbSP2.setSqdw(orgCode);
				
				// 审批单位 派出所所属分局
				XszcspbSP2.setSpdw(commonService.queryUpOrgID(orgCode));
				
				// 审批状态 初始值
				XszcspbSP2.setSpzt("0");
				
				xszcspbService.save(XszcspbSP2, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES,  getMessage("add.success"));
				
				// ********************************************日志处理
				String userName = sessionBean.getUserName();
				String orgName = sessionBean.getUserOrgName();
				
				czlx = "10";
				xsbh = entity.getId();
				cznrBF = new StringBuffer();
				cznrBF.append(orgName);
				cznrBF.append(" 的 ");
				cznrBF.append(userName);
					
				cznrBF.append(", 完成了审批, 当前线索状态为'递转中'");
				xscljlbService.saveLog(xsbh, cznrBF.toString(),czlx, sessionBean);
				// ********************************************日志处理
				
				MessageUtils.db_dzsp(XszcspbSP2);	//递转审批待办任务
			}
		
		}catch (Exception e) {
			
			e.printStackTrace();
			logger.error(e.getLocalizedMessage(), e);
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, getAddFail());
		}
		
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		MessageUtils.rmdb_dzsp(entity.getId());
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
	public ModelAndView prints(String xsbh,String sqbh,String mainTabID) {

		
		String printJsp = "yjjb/jbxsPrintDZ";
		ModelAndView mv = new ModelAndView(printJsp);
		mv.addObject("mainTabID", mainTabID);
		Xszcsqb xszcsqb = new Xszcsqb();
		Xsjbxxb xsjbxxb = new Xsjbxxb();
		String sqdw = "";
		String jbsj = "";
		// 调查年月日
		String yyyy = "";
		String mm = "";
		String dd  = "";
		
		String sldw = "";
		if (!StringUtils.isBlank(sqbh)) {
			
			xszcsqb.setId(sqbh);
			xszcsqb = xszcsqbService.queryById(xszcsqb);
			sqdw = xszcsqb.getXt_lrrbm(); 
		}
		
		if (!StringUtils.isBlank(xsbh)) {
			
			xsjbxxb.setId(xsbh);
			xsjbxxb = xsjbxxbService.queryById(xsjbxxb);
			jbsj = xsjbxxb.getJbsj();
			if (jbsj.length() >= 4) {
				
				yyyy = jbsj.substring(0, 4);
			}
			if (jbsj.length() >= 7) {
				
				mm = jbsj.substring(5, 7);
			}
			if (jbsj.length() >= 10) {
				
				dd = jbsj.substring(8, 10);
			}
			
			sldw = xsjbxxb.getSlfzdm();
			sldw = orgOrganizationService.queryOrgNameByOrgcodes(sldw);
		}
		
		mv.addObject("yyyy", yyyy);
		mv.addObject("mm", mm);
		mv.addObject("dd", dd);
		mv.addObject("xsbh", xsbh);
		mv.addObject("sqdw", sqdw);
		mv.addObject("sldw", sldw);
		return mv;
	}
}
