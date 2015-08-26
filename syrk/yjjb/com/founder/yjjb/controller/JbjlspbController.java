package com.founder.yjjb.controller;

import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.founder.framework.base.controller.BaseController;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.components.AppConst;
import com.founder.framework.organization.department.service.OrgOrganizationService;
import com.founder.framework.organization.user.bean.OrgUser;
import com.founder.framework.utils.DateUtils;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.service.attachment.bean.ZpfjFjxxb;
import com.founder.service.attachment.service.ZpfjFjxxbService;
import com.founder.yjjb.bean.Ajxxb;
import com.founder.yjjb.bean.Jbjlspb;
import com.founder.yjjb.bean.Jbjlxxb;
import com.founder.yjjb.bean.Jlxxb;
import com.founder.yjjb.bean.Xsajgxb;
import com.founder.yjjb.bean.Xsjbxxb;
import com.founder.yjjb.service.AjxxbService;
import com.founder.yjjb.service.CommonService;
import com.founder.yjjb.service.JbjlspbService;
import com.founder.yjjb.service.JbjlxxbService;
import com.founder.yjjb.service.JlxxbService;
import com.founder.yjjb.service.XsajgxbService;
import com.founder.yjjb.service.XscljlbService;
import com.founder.yjjb.service.XsjbxxbService;
import com.founder.yjjb.utils.MessageUtils;

import com.google.gson.Gson;

@Controller
@RequestMapping(value = "/jbjlspb")
public class JbjlspbController extends BaseController {
private Logger logger = Logger.getLogger(this.getClass());
	
	@Resource(name="jbjlspbService")
	private JbjlspbService jbjlspbService;
	
	@Resource(name="commonService")
	private CommonService commonService;
	
	@Resource(name="jlxxbService")
	private JlxxbService jlxxbService;
	
	@Resource(name="jbjlxxbService")
	private JbjlxxbService jbjlxxbService;
	
	@Resource(name="xsjbxxbService")
	private XsjbxxbService xsjbxxbService;
	
	@Resource(name="ajxxbService")
	private AjxxbService ajxxbService;
	
	@Resource(name = "orgOrganizationService")
	private OrgOrganizationService orgOrganizationService;
	
	@Resource(name = "zpfjFjxxbService")
	private ZpfjFjxxbService zpfjFjxxbService;
	
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
	public ModelAndView jbjlspbList(String id,String mainTabID) {
		
		ModelAndView mv = new ModelAndView("");
		mv.addObject("mainTabID", mainTabID);
		Jbjlspb entity = new Jbjlspb();
		
		if (!StringUtils.isBlank(id)) {
			
			entity.setId(id);
			entity = jbjlspbService.queryById(entity);
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
	public ModelAndView save(Jbjlspb entity){
		
		ModelAndView mv = new ModelAndView("redirect:/forward/" + AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		String orgCode = sessionBean.getUserOrgCode();
		try {
			if (entity.getId() == null || entity.getId().equals("")) {	//新增
				entity.setId(commonService.CreateNewSeq("09", orgCode));
				jbjlspbService.save(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES,  getMessage("add.success"));
				model.put(AppConst.SAVE_ID, entity.getId()); // 返回主键
			} else {	//修改
				
				jbjlspbService.update(entity, sessionBean);
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
	 * 跳转新增/编辑页面
	 * @param id
	 * @param mainTabID
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/openAdd", method = RequestMethod.GET)
	public ModelAndView add(String id,String mainTabID) {
		
		ModelAndView mv = new ModelAndView("yjjb/jbjlspCK");
		mv.addObject("mainTabID", mainTabID);
		Jbjlspb  jbjlspb  = new  Jbjlspb();
		Jlxxb jlxxb = new Jlxxb();
		Jbjlxxb jbjlxxb = new Jbjlxxb();
		Xsjbxxb xsjbxxb = new Xsjbxxb();
		Ajxxb ajxxb = new Ajxxb();
		// 用户单位
		SessionBean sessionBean = getSessionBean();
		String orgCode = sessionBean.getUserOrgCode();
		String orglevel = commonService.getDwjb(orgCode);
		if (!StringUtils.isBlank(id)) {
			// 审批信息
			jbjlspb.setId(id);
			jbjlspb = jbjlspbService.queryById(jbjlspb);
			if (null != jbjlspb && null != jbjlspb.getSqbh() && !"".equals(jbjlspb.getSqbh())) {
				
				String sqbh = jbjlspb.getSqbh();
				// 申请信息
				jlxxb.setId(sqbh);
				jlxxb = jlxxbService.queryById(jlxxb);
				// 举报奖励信息
				jbjlxxb.setId(sqbh);
				jbjlxxb = jbjlxxbService.queryById(jbjlxxb);
			}
			
			if (null != jbjlxxb && null != jbjlxxb.getXsbh() && !"".equals(jbjlxxb.getXsbh())) {
				// 线索信息
				String xsid = jbjlxxb.getXsbh();
				xsjbxxb.setId(xsid);
				xsjbxxb = xsjbxxbService.queryById(xsjbxxb);
				xsjbxxb.setCcsj(xsjbxxb.getCcsj().substring(0, 10));
				xsjbxxb.setSlfzdm(orgOrganizationService.queryByOrgcode(xsjbxxb.getSlfzdm()).getOrgname());
			}
			
			if (null != jbjlxxb && null != jbjlxxb.getAjbh() && !"".equals(jbjlxxb.getAjbh())) {
				
				// 案件信息
				String ajbh = jbjlxxb.getAjbh();
				ajxxb.setAjbh(ajbh);
				ajxxb = ajxxbService.queryAllAjxxByAjbh(ajxxb);
				
				if(null==ajxxb.getXt_lrrbm() || "".equals(ajxxb.getXt_lrrbm())){
					ajxxb.setXt_lrrbm(ajxxb.getBadw());
				}
				
				if (ajxxb.getXt_lrrid().length() > 0) {
					
					OrgUser user = new OrgUser();
					StringBuffer userSB = new StringBuffer();
					
					String[] alarms =  ajxxb.getXt_lrrid().split(",");
					
					if(null!=alarms){
						List<String> username = new ArrayList<String>(); 
						for (String alarm : alarms) {
							user = (OrgUser)commonService.getUserByalarm(alarm);
							username.add(user.getUsername());
						}
						ajxxb.setXt_lrrxm(org.apache.commons.lang.StringUtils.join(username, ","));
					}
					
					
					/*
					if (alarms.length > 0) {
						
						for (int i = 0; i < alarms.length; i++) {
							
							String alarm = alarms[i];
							user = (OrgUser) commonService.getUserByalarm(alarm);
							
							if (i == alarms.length -1) {
								
								userSB.append(user.getUsername() );
							} else{
								
								userSB.append(user.getUsername() + ", ");
							}
						}
						
						ajxxb.setXt_lrrxm(userSB.toString());
					}
					*/
				}
			}
		}
		
		//根据ajid和xsid查询线索案件表内容
		Xsajgxb entityXsAj = new Xsajgxb();
		entityXsAj.setXsbh(xsjbxxb.getId());
		entityXsAj.setAjbh(ajxxb.getAjbh());
		entityXsAj = xsajgxbService.queryByXsidAjid(entityXsAj);
		String ajSource = entityXsAj.getAjsource();
		
		//查询当前用户的警号
		String orgId = sessionBean.getUserId();
		String alarm = commonService.selectByOrgId(orgId);//查询当前用户的警号
		
		mv.addObject("jbjlspb", jbjlspb);
		mv.addObject("jlxxb", jlxxb);
		mv.addObject("jbjlxxb", jbjlxxb);
		mv.addObject("xsjbxxb", xsjbxxb);
		mv.addObject("ajxxb", ajxxb);
		mv.addObject("orglevel", orglevel);
		mv.addObject("ajSource", ajSource);
		mv.addObject("alarm", alarm);
		return mv;
	}
	
	/**
	 * 跳转新增/编辑页面
	 * @param id
	 * @param mainTabID
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/openDY", method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView openDY(String id,ServletRequest request) {
		
//		Map model = new HashMap();
		ModelAndView mv = new ModelAndView("yjjb/dayinSpb");
//		mv.addObject("mainTabID", mainTabID);
		Jbjlspb  jbjlspb  = new  Jbjlspb();
		Jlxxb jlxxb = new Jlxxb();
		Jbjlxxb jbjlxxb = new Jbjlxxb();
		Xsjbxxb xsjbxxb = new Xsjbxxb();
		Ajxxb ajxxb = new Ajxxb();
		// 用户单位
		SessionBean sessionBean = getSessionBean();
		String orgCode = sessionBean.getUserOrgCode();
		String orglevel = commonService.getDwjb(orgCode);
		if (!StringUtils.isBlank(id)) {
			// 审批信息
			jbjlspb.setId(id);
			jbjlspb = jbjlspbService.queryById(jbjlspb);
			if (null != jbjlspb && null != jbjlspb.getSqbh() && !"".equals(jbjlspb.getSqbh())) {
				
				String sqbh = jbjlspb.getSqbh();
				// 申请信息
				jlxxb.setId(sqbh);
				jlxxb = jlxxbService.queryById(jlxxb);
				jlxxb.setSlfzspsj(getDatefromDatetime(jlxxb.getSlfzspsj()));
				jlxxb.setSlzspsj(getDatefromDatetime(jlxxb.getSlzspsj()));
				// 举报奖励信息
				jbjlxxb.setId(sqbh);
				jbjlxxb = jbjlxxbService.queryById(jbjlxxb);
			}
			
			if (null != jbjlxxb && null != jbjlxxb.getXsbh() && !"".equals(jbjlxxb.getXsbh())) {
				
				// 线索信息
				String xsid = jbjlxxb.getXsbh();
				xsjbxxb.setId(xsid);
				xsjbxxb = xsjbxxbService.queryById(xsjbxxb);
				xsjbxxb.setCcsj(xsjbxxb.getCcsj().substring(0, 10));
				xsjbxxb.setSlfzdm(orgOrganizationService.queryByOrgcode(xsjbxxb.getSlfzdm()).getOrgname());
				 
				
				// ********************************************日志处理
				if (null != sessionBean && null != xsjbxxb) {
					
					String userName = sessionBean.getUserName();
					String orgName = sessionBean.getUserOrgName();// 打印
					czlx = "70";
					cznrBF = new StringBuffer();
					
					cznrBF = new StringBuffer();
					cznrBF.append(orgName);
					cznrBF.append(" 的 ");
					cznrBF.append(userName);
					// 操作内容
					cznrBF.append(", 查看了打印页面");
					if (xsjbxxb.getXszt().equals("00")) {
						
						cznrBF.append(", 当前线索状态为'待初查'");
					}else if (xsjbxxb.getXszt().equals("10")) {
						
						cznrBF.append(", 当前线索状态为'待复查'");
					}else if (xsjbxxb.getXszt().equals("20")) {
						
						cznrBF.append(", 当前线索状态为'递转中'");
					}else if (xsjbxxb.getXszt().equals("30")) {
						
						cznrBF.append(", 当前线索状态为'递转中'");
					}else if (xsjbxxb.getXszt().equals("40")) {
						
						cznrBF.append(", 当前线索状态为'已处理'");
					}else if (xsjbxxb.getXszt().equals("50")) {
						
						cznrBF.append(", 当前线索状态为'已废弃'");
					}
					xscljlbService.saveLog(xsbh, cznrBF.toString(), czlx, sessionBean);
				}
				
				// ********************************************日志处理
			}
			
			if (null != jbjlxxb && null != jbjlxxb.getAjbh() && !"".equals(jbjlxxb.getAjbh())) {
				
				// 案件信息
				String ajbh = jbjlxxb.getAjbh();
				ajxxb.setAjbh(ajbh);
				ajxxb = ajxxbService.queryAllAjxxByAjbh(ajxxb);
				if(null==ajxxb.getXt_lrrbm() || "".equals(ajxxb.getXt_lrrbm())){
					ajxxb.setXt_lrrbm(ajxxb.getBadw());
				}
				if (ajxxb.getXt_lrrid().length() > 0) {
					
					OrgUser user = new OrgUser();
//					StringBuffer userSB = new StringBuffer();
					
//					String[] alarms =  ajxxb.getXt_lrrxm().split(",");
					String[] alarms =  ajxxb.getXt_lrrid().split(",");
					
					if(null!=alarms){
						List<String> username = new ArrayList<String>(); 
						for (String alarm : alarms) {
							user = (OrgUser)commonService.getUserByalarm(alarm);
							username.add(user.getUsername());
						}
						ajxxb.setXt_lrrxm(org.apache.commons.lang.StringUtils.join(username, ","));
					}
					/*
					if (alarms.length > 0) {
						
						for (int i = 0; i < alarms.length; i++) {
							
							String alarm = alarms[i];
							user = (OrgUser) commonService.getUserByalarm(alarm);
							
							if (i == alarms.length -1) {
								
								userSB.append(user.getUsername() );
							} else{
								
								userSB.append(user.getUsername() + ", ");
							}
						}
						
						ajxxb.setXt_lrrxm(userSB.toString());
					}
					*/
				}
			}
		}
		
		mv.addObject("jbjlspb", jbjlspb);
		mv.addObject("jlxxb", jlxxb);
		mv.addObject("jbjlxxb", jbjlxxb);
		mv.addObject("xsjbxxb", xsjbxxb);
		mv.addObject("ajxxb", ajxxb);
		mv.addObject("orglevel", orglevel);
		
//		Map dataMap = new HashMap();
//		dataMap.put("jbjlspb", jbjlspb);
//		dataMap.put("jlxxb", jlxxb);
//		dataMap.put("jbjlxxb", jbjlxxb);
//		dataMap.put("xsjbxxb", xsjbxxb);
//		dataMap.put("ajxxb", ajxxb);
//		dataMap.put("orglevel", orglevel);
//		
//		ServletContext context = RequestContextUtils.getWebApplicationContext(request).getServletContext();
//		
//		Configuration configuration = new Configuration();
//		configuration.setDefaultEncoding("UTF-8");
//		configuration.setServletContextForTemplateLoading(context, "/tmpl");
//		Template tmpl = null;
//		try {
//			tmpl = configuration.getTemplate("客运出租从业人员协助破案奖励审批表.xml");
//		} catch (Exception e) {
//			e.printStackTrace();
//			model.put(AppConst.STATUS,AppConst.ERRORS);
//			model.put(AppConst.MESSAGES, "申请生成失败");
//			return model;
//		}
//		String path = "/file";
//		File outFile = new File("D:/客运出租从业人员协助破案奖励审批表_"+jlxxb.getId()+".doc");
//		Writer out = null;
//		try {
//			out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile),"UTF-8"));
//		} catch (Exception e) {
//			e.printStackTrace();
//			model.put(AppConst.STATUS,AppConst.ERRORS);
//			model.put(AppConst.MESSAGES, "申请生成失败");
//			return model;
//		}
//		try {
//			tmpl.process(dataMap, out);
//			out.close();
//			InputStream is = new FileInputStream(outFile);
//			ByteArrayOutputStream stream = new ByteArrayOutputStream();
//			byte[] xml = new byte[is.available()];
//			is.read(xml);
//			is.close();
//			outFile.delete();
//			
//			//保存文件
//			ZpfjFjxxb entity = new ZpfjFjxxb();
//			entity.setLybm("YJJB_JBXXB");
//			entity.setLyid(jlxxb.getId());
////			entity.setCt(null);
//			entity.setLyms("0");
//			String wjmc = "客运出租从业人员协助破案奖励审批表_"+jlxxb.getId()+".doc";
//			String wjhzlx = "";
//			int atI = wjmc.lastIndexOf(".");
//			if (atI != -1) {
//				wjhzlx = wjmc.substring(atI + 1);
//				wjhzlx = wjhzlx.toLowerCase();
//			}
//			entity.setWjmc(wjmc);
//			entity.setWjhzlx(wjhzlx);
//			entity.setWj(xml);
//			long wjdx = entity.getWj().length;
//			entity.setWjdx(new Long(wjdx));
//			String wjdxsm = "";
//			if (wjdx < 1024) {
//				wjdxsm = "" + wjdx + " B";
//			} else if (wjdx > 1048576) {
//				double mb = Math.floor(wjdx / 1048576);
//				DecimalFormat formater = new DecimalFormat(
//						"###,###,###.00");
//				wjdxsm = "" + formater.format(mb) + " MB";
//			} else {
//				long kb = (long) Math.floor(wjdx / 1024);
//				wjdxsm = "" + kb + " KB";
//			}
//			entity.setWjdxsm(wjdxsm);
//			entity.setWjxzcs(new Long(0));
//			zpfjFjxxbService.updateZpfjFjxxb(entity, sessionBean);
//			
//			model.put(AppConst.STATUS,AppConst.SUCCESS);
//			model.put(AppConst.MESSAGES, entity.getId());
//			//保存文件结束
//		} catch (Exception e) {
//			e.printStackTrace();
//			model.put(AppConst.STATUS,AppConst.ERRORS);
//			model.put(AppConst.MESSAGES, "申请生成失败");
//			return model;
//		}
//		return model;
		return mv;
	}
	/**
	 * 审批处理</br>
	 * @param entity
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/sp", method = RequestMethod.POST)
	public ModelAndView jbjlsp(Jbjlspb jbjlspb, String btnType
			,String jlxxbid
			,String jlje
			,String jlxxbbz
			,String slfzcljg
			,String slzcljg
			,String slzxcljg
			){
		ModelAndView mv = new ModelAndView("redirect:/forward/" + AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		
		// 获取奖励信息
		Jlxxb jlxxb = new Jlxxb();
		jlxxb.setId(jlxxbid);
		jlxxb = jlxxbService.queryById(jlxxb);
		
		// ********************************************日志处理
		Jbjlxxb jbjlxxb = new Jbjlxxb();
		jbjlxxb.setId(jlxxbid);
		jbjlxxb = jbjlxxbService.queryById(jbjlxxb);
		xsbh=jbjlxxb.getXsbh();//线索编号
		
		Xsjbxxb xsjbxxb = new Xsjbxxb();
		xsjbxxb.setId(xsbh);
		xsjbxxb = xsjbxxbService.queryById(xsjbxxb);
		if (null != sessionBean && null != xsjbxxb) {
			
			String userName = sessionBean.getUserName();
			String orgName = sessionBean.getUserOrgName();
			czlx = "80"; // 审批
			cznrBF = new StringBuffer();
			
			cznrBF = new StringBuffer();
			cznrBF.append(orgName);
			cznrBF.append(" 的 ");
			cznrBF.append(userName);
			// 操作内容
			cznrBF.append(", 审批了这条线索");
			if (xsjbxxb.getXszt().equals("00")) {
				
				cznrBF.append(", 当前线索状态为'待初查'");
			}else if (xsjbxxb.getXszt().equals("10")) {
				
				cznrBF.append(", 当前线索状态为'待复查'");
			}else if (xsjbxxb.getXszt().equals("20")) {
				
				cznrBF.append(", 当前线索状态为'递转中'");
			}else if (xsjbxxb.getXszt().equals("30")) {
				
				cznrBF.append(", 当前线索状态为'递转中'");
			}else if (xsjbxxb.getXszt().equals("40")) {
				
				cznrBF.append(", 当前线索状态为'已处理'");
			}else if (xsjbxxb.getXszt().equals("50")) {
				
				cznrBF.append(", 当前线索状态为'已废弃'");
			}
			xscljlbService.saveLog(xsbh, cznrBF.toString(), czlx, sessionBean);
		}
		
		// ********************************************日志处理
		// 用户单位
		String orgCode = sessionBean.getUserOrgCode();
		//单位级别
		String dwjb = commonService.getDwjb(orgCode);
		// 当前时间
		String DateTime = DateUtils.getSystemDateTimeString();
		
		// 受理中心
		String orgCenter = "210200000000";
		String upOrgCode ="";
		if (!orgCode.equals(orgCenter)) {
			
			upOrgCode = orgOrganizationService.queryByOrgcode(orgCode).getParenttreepath();
			
			int lengthOfupOrgCode = upOrgCode.length();
			upOrgCode = (String) upOrgCode.subSequence(lengthOfupOrgCode -13, lengthOfupOrgCode - 1);
		}
		
		try {
			
			if (null != jbjlspb.getId()  && !jbjlspb.getId().equals("")) {
				jbjlspb = jbjlspbService.queryById(jbjlspb);
				
				//审批表增加审批意见
				if (null != dwjb && !dwjb.equals("")) {
				
					if (dwjb.equals("00")) {
						
						jbjlspb.setSphf(slfzcljg);
					}else if (dwjb.equals("01")) {
						
						jbjlspb.setSphf(slzcljg);
					}else if (dwjb.equals("02")) {
						
						jbjlspb.setSphf(slzxcljg);
					}
				}
				
				// 同意奖励
				if (btnType.equals("1")) {
					// 修改审批记录为：同意
					jbjlspb.setSpzt("1");
					
					if (orgCode.equals(orgCenter)) {
						// 受理中心修改奖励申请为：同意
						jlxxb.setSpzt("1");
					}else {
						// 新增一条审批记录交由上级处理
						Jbjlspb newJbjlspb = new Jbjlspb();
						newJbjlspb.setId(commonService.CreateNewSeq("09", orgCode));
						newJbjlspb.setSqbh(jbjlspb.getSqbh());
						newJbjlspb.setSqsj(DateTime);
						newJbjlspb.setSqdw(orgCode);
						newJbjlspb.setSpdw(upOrgCode);
						newJbjlspb.setSpzt("0");
						newJbjlspb.setLybh(jbjlspb.getId());
						jbjlspbService.save(newJbjlspb, sessionBean);
						MessageUtils.db_jlsp(newJbjlspb);	//递转审批待办任务
					}
				}else {
					
					// 修改审批记录为：拒绝
					jbjlspb.setSpzt("2");
					
					// 修改申请记录为：拒绝
					jlxxb.setSpzt("2");
				}
			}
			try {
				jlxxb.setJlje(Long.parseLong(jlje));
			} catch (Exception e) {
				jlxxb.setJlje(0L);
			}
			if (null != dwjb && !dwjb.equals("")) {
				
				if (dwjb.equals("00")) {
					
					jlxxb.setSlfzspsj(DateTime);
				}else if(dwjb.equals("01")){
					
					jlxxb.setSlzspsj(DateTime);
				}else if (dwjb.equals("02")) {
					
					jlxxb.setSlzxspsj(DateTime);
				}
			}
			jlxxb.setBz(jlxxbbz);
			jlxxb.setSlfzcljg(slfzcljg);
			jlxxb.setSlzcljg(slzcljg);
			jlxxb.setSlzxcljg(slzxcljg);
			jlxxbService.update(jlxxb, sessionBean);
			jbjlspbService.update(jbjlspb, sessionBean);
			
			model.put(AppConst.STATUS, AppConst.SUCCESS);
			model.put(AppConst.MESSAGES,  getMessage("update.success"));
		}catch (Exception e) {
			
			e.printStackTrace();
			logger.error(e.getLocalizedMessage(), e);
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, getAddFail());
		}
		
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		MessageUtils.rmdb_jlsp(jbjlspb.getId());  // 更新信息表的代办状态为查看
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
			@RequestParam(value = "rows") Integer rows, Jbjlspb entity){
		
		page.setPagePara(rows);
		SessionBean sessionBean = getSessionBean();
		if(null != sessionBean){
			
		}
		
		// 默认查询条件为本单位，页面查询条件为本单位及下属单位
//		if (null == entity.getSpdw() || entity.getSpdw().equals("")) {
//			
//			entity.setSpdw(sessionBean.getUserOrgCode());
//		}
//		
//		// 去除右侧的0，进行模糊查询
//		entity.setSpdw(entity.getSpdw().replaceAll("0+?$", ""));
		
//		if (null != entity.getSqdw() && !entity.getSqdw().equals("")) {
//			
//			// 去除右侧的0，进行模糊查询
//			entity.setSqdw(entity.getSqdw().replaceAll("0+?$", ""));
//		}
		// 只查询本单位
		if(null!=sessionBean){
			entity.setSpdw(sessionBean.getUserOrgCode());
		}else{
			entity.setSpdw("NULL");
		}
		return this.jbjlspbService.queryList(page,entity);
	}
	
	/**
	 * 注销
	 * @param entity
	 * @return
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public @ResponseBody
	ModelAndView delete(Jbjlspb entity){
		
		ModelAndView mv = new ModelAndView("redirect:/forward/"	+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		
		try {
			jbjlspbService.delete(entity, sessionBean);
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
	
	// yyyy-MM-dd HH:mm:ss转化为yyyy年MM月dd日
	public static String  getDatefromDatetime(String dateTime){
		
		StringBuffer dateSB = new StringBuffer();
		if (dateTime.length() > 10) {
			
			dateSB.append(dateTime.substring(0, 4));
			dateSB.append(" 年 ");
			dateSB.append(dateTime.substring(5, 7));
			dateSB.append(" 月 ");
			dateSB.append(dateTime.substring(8, 10));
			dateSB.append(" 日 ");
		}
		return dateSB.toString();
	}
}
