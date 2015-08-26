package com.founder.yjjb.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.framework.utils.UUID;
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
import com.founder.yjjb.service.XsjbxxbService;
import com.founder.yjjb.utils.MessageUtils;

import com.google.gson.Gson;

@Controller
@RequestMapping(value = "/jbjlxxb")
public class JbjlxxbController extends BaseController {
private Logger logger = Logger.getLogger(this.getClass());
	
	@Resource(name="jbjlxxbService")
	private JbjlxxbService jbjlxxbService;
	
	@Resource(name="commonService")
	private CommonService commonService;
	
	@Resource(name="xsjbxxbService")
	private XsjbxxbService xsjbxxbService;
	
	@Resource(name="jlxxbService")
	private JlxxbService jlxxbService;
	
	@Resource(name="jbjlspbService")
	private JbjlspbService jbjlspbService;
	
	@Resource(name="ajxxbService")
	private AjxxbService ajxxbService;
	
	@Resource(name="xsajgxbService")
	private XsajgxbService xsajgxbService;
	
	/**
	 * 跳转
	 * @param id
	 * @param mainTabID
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/openList", method = RequestMethod.GET)
	public ModelAndView jbjlxxbList(String id,String mainTabID) {
		
		ModelAndView mv = new ModelAndView("");
		mv.addObject("mainTabID", mainTabID);
		Jbjlxxb entity = new Jbjlxxb();
		
		if (!StringUtils.isBlank(id)) {
			
			entity.setId(id);
			entity = jbjlxxbService.queryById(entity);
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
	public ModelAndView save(Jbjlxxb entity){
		
		ModelAndView mv = new ModelAndView("redirect:/forward/" + AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		String orgCode = sessionBean.getUserOrgCode();
		try {
			if (entity.getId() == null || entity.getId().equals("")) {	//新增
				//举报奖励信息表主键和奖励信息表主键一致，不需要新建
				entity.setId(commonService.CreateNewSeq("08", orgCode));
				jbjlxxbService.save(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES,  getMessage("add.success"));
				model.put(AppConst.SAVE_ID, entity.getId()); // 返回主键
			} else {	//修改
				
				jbjlxxbService.update(entity, sessionBean);
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
	 * 查询</br>
	 * @param page
	 * @param rows
	 * @param entity
	 * @return
	 */
	@RequestMapping(value = "/query", method = RequestMethod.POST)
	public @ResponseBody
	EasyUIPage queryList(EasyUIPage page,
			@RequestParam(value = "rows") Integer rows, Jbjlxxb entity){
		
		page.setPagePara(rows);
		SessionBean sessionBean = getSessionBean();
		if(null != sessionBean){
			
		}
		
		return this.jbjlxxbService.queryList(page,entity);
	}
	
	/**
	 * 注销
	 * @param entity
	 * @return
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public @ResponseBody
	ModelAndView delete(Jbjlxxb entity){
		
		ModelAndView mv = new ModelAndView("redirect:/forward/"	+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		
		try {
			jbjlxxbService.delete(entity, sessionBean);
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
	 * 跳转新增/编辑页面
	 * @param id
	 * @param mainTabID
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/jlSq", method = RequestMethod.GET)
	public ModelAndView jlSq(String xsbh,String ajbh,String ajSource,String id,String mainTabID) {
		
		ModelAndView mv = new ModelAndView("yjjb/jbjlSq");
		mv.addObject("mainTabID", mainTabID);
		Xsjbxxb entity = new Xsjbxxb();
		SessionBean sessionBean = getSessionBean();
		String orgId = sessionBean.getUserId();
		String alarm = commonService.selectByOrgId(orgId);//查询当前用户的警号
		
		if (!StringUtils.isBlank(xsbh)) {
			
			entity.setId(xsbh);
			entity = xsjbxxbService.queryById(entity);
		}
		//通过案件编号查询新老警综内容
		
		//根据ajid和xsid查询线索案件表内容
		Xsajgxb entityXsAj = new Xsajgxb();
		entityXsAj.setXsbh(entity.getId());
		entityXsAj.setAjbh(ajbh);
		entityXsAj = xsajgxbService.queryByXsidAjid(entityXsAj);
		String ajSource1 = entityXsAj.getAjsource();
		
		Ajxxb entityAj = new Ajxxb();
		if (!StringUtils.isBlank(ajbh)) {
			entityAj.setAjbh(ajbh);
			if(ajSource1.equals("0")){
				entityAj=ajxxbService.queryByAjbh(entityAj);
			}else{
				entityAj=ajxxbService.queryByAjbhLjz(entityAj);
			}
		}
		Ajxxb ajxxb = new Ajxxb();
		ajxxb.setAjbh(ajbh);
		ajxxb = ajxxbService.queryAllAjxxByAjbh(ajxxb);
		if(null==ajxxb.getXt_lrrbm() || "".equals(ajxxb.getXt_lrrbm())){
			ajxxb.setXt_lrrbm(ajxxb.getBadw());
		}
		
		mv.addObject("entityAj", entityAj);
		mv.addObject("entity", entity);
		mv.addObject("ajbh", ajbh);
		mv.addObject("ajxxb", ajxxb);
		mv.addObject("ajSource", ajSource1);
		mv.addObject("alarm", alarm);
		mv.addObject("id", id);
		return mv;
	}
	
	/**
	 * 提交举报申请，并跳转到举报奖励申请列表页面
	 * @param id
	 * @param mainTabID
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/approval", method = RequestMethod.POST)
	public Map approval(Jbjlxxb entityJB,Jlxxb entityJL,String id) {
		
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		String orgCode = sessionBean.getUserOrgCode();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//更新线索案件表是否提交申请字段
		Xsajgxb entityX = new Xsajgxb();
		entityX.setId(id);
		entityX.setSfffjl("1");
		
		xsajgxbService.update(entityX, sessionBean);
		//创建奖励信息表内容--主表
		Jlxxb jlxxbS = new Jlxxb();
		jlxxbS.setId(commonService.CreateNewSeq("07", orgCode));//ID
		jlxxbS.setSqsj(format.format(new Date()));//申请时间
		jlxxbS.setSqdw(orgCode);//申请单位
		jlxxbS.setSpzt("0");
		jlxxbS.setSqr(sessionBean.getUserId());//申请人
		jlxxbS.setJllx("00");//奖励类型
		jlxxbS.setBz(entityJL.getBz());//处理结果
		jlxxbService.save(jlxxbS, sessionBean);
		
		//创建举报奖励信息表内容--附表
		Jbjlxxb jbjlxxbS = new Jbjlxxb();
		jbjlxxbS.setId(jlxxbS.getId());//id
		jbjlxxbS.setJbrxm(entityJB.getJbrxm());
		jbjlxxbS.setJbrsfzh(entityJB.getJbrsfzh());
		jbjlxxbS.setXsbh(entityJB.getXsbh());//线索编号
		jbjlxxbS.setAjbh(entityJB.getAjbh());
		jbjlxxbS.setJlbh(jlxxbS.getId());
		jbjlxxbS.setXzfs(entityJB.getXzfs());
		jbjlxxbS.setXzfsnr(entityJB.getXzfsnr());
		jbjlxxbService.save(jbjlxxbS, sessionBean);
		
		//创建一条审批表内容如
		Jbjlspb jbjlspbS = new Jbjlspb();
		jbjlspbS.setId(commonService.CreateNewSeq("09", orgCode));
		jbjlspbS.setSqbh(jlxxbS.getId());
		jbjlspbS.setSqsj(jlxxbS.getSqsj());
		jbjlspbS.setSqdw(jlxxbS.getSqdw());
		jbjlspbS.setSpzt("0");
		jbjlspbS.setSpdw(orgCode);
		jbjlspbService.save(jbjlspbS, sessionBean);
		MessageUtils.db_jlsp(jbjlspbS);	//递转审批待办任务
		
		model.put(AppConst.STATUS, AppConst.SUCCESS);
		model.put(AppConst.MESSAGES, getMessage("add.success"));
		return model;
	}
}
