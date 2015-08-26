package com.founder.yjjb.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.yjjb.bean.Xszjspb;
import com.founder.yjjb.bean.Xszjxxb;
import com.founder.yjjb.service.CommonService;
import com.founder.yjjb.service.XszjspbService;
import com.founder.yjjb.service.XszjxxbService;
import com.founder.yjjb.utils.MessageUtils;

import com.google.gson.Gson;

@Controller
@RequestMapping(value = "/xszjspb")
public class XszjspbController extends BaseController {
private Logger logger = Logger.getLogger(this.getClass());
	
	@Resource(name="xszjspbService")
	private XszjspbService xszjspbService;
	
	@Resource(name="xszjxxbService")
	private XszjxxbService xszjxxbService;
	
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
	public ModelAndView xszjspbList(String id,String mainTabID) {
		
		ModelAndView mv = new ModelAndView("yjjb/xszjspList");
		mv.addObject("mainTabID", mainTabID);
		Xszjspb entity = new Xszjspb();
		
		if (!StringUtils.isBlank(id)) {
			
			entity.setId(id);
			entity = xszjspbService.queryById(entity);
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
			@RequestParam(value = "rows") Integer rows, Xszjspb entity){
		
		page.setPagePara(rows);
		SessionBean sessionBean = getSessionBean();
		if(null != sessionBean){
			entity.setXt_lrrbmid(sessionBean.getUserOrgCode());
		}
		return this.xszjspbService.queryList(page,entity);
	}
	
	/**
	 * 跳转新增页面
	 * @param id
	 * @param mainTabID
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/openAdd", method = RequestMethod.GET)
	public ModelAndView openAdd(String id,String mainTabID) {
		
		ModelAndView mv = new ModelAndView("yjjb/xszjspAdd");
		mv.addObject("mainTabID", mainTabID);
		SessionBean sessionBean = getSessionBean();
		
		Xszjspb entity = new Xszjspb();
		Xszjxxb entity1 = new Xszjxxb();
		List<Xszjspb> list2 = null,list = new ArrayList<Xszjspb>();
		
		if (!StringUtils.isBlank(id)) {
			entity.setId(id);
			entity = xszjspbService.queryById(entity);
			list2 = xszjspbService.queryBySqbh(entity);
			for(int i = 0;i<list2.size();i++) list.add(list2.get(list2.size()-i-1));
			for(int i = 0;i<list.size();i++){
				String bmonlist = commonService.searchOrgList(list.get(i).getSpdw()).get(0).getText();
				((Xszjspb)list.get(i)).setBmonlist(bmonlist);
			}
			entity1.setId(entity.getSqbh());
			entity1 = xszjxxbService.queryById(entity1);
			if("0".equals(entity.getSpzt().trim())){
				entity.setSpdw(sessionBean.getUserOrgCode());
			}
		}
		mv.addObject("entity", entity);
		mv.addObject("entity1", entity1);
		mv.addObject("list", list);
		return mv;
	}
	
	/**
	 * 同意或拒绝审批
	 * @param entity
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(Xszjspb entity){
		
		ModelAndView mv = new ModelAndView("redirect:/forward/" + AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		String orgCode = sessionBean.getUserOrgCode();
		try {
			if("1".equals(entity.getSpzt().trim())&&commonService.queryUpOrgID(orgCode)!=null){
					Xszjspb entity1 = new Xszjspb();
					entity1.setId(commonService.CreateNewSeq("06", orgCode));
					DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					entity1.setSqsj(format.format(new Date()));
					entity1.setSqbh(entity.getSqbh());
					entity1.setSqdw(entity.getSpdw());
					entity1.setSpdw(commonService.queryUpOrgID(orgCode));
					entity1.setSpzt("0");
					entity1.setLybh(entity.getId());
					entity1.setBz(entity.getBz());
					xszjspbService.update(entity, sessionBean);
					xszjspbService.save(entity1, sessionBean);
					MessageUtils.db_xszjsp(entity1);	//递转审批待办任务
					model.put(AppConst.STATUS, AppConst.SUCCESS);
					model.put(AppConst.MESSAGES,  getMessage("update.success"));
					model.put(AppConst.MESSAGES,  getMessage("add.success"));
					model.put(AppConst.SAVE_ID, entity1.getId()); // 返回主键
				}
			else
			{
				Xszjxxb entity2 = new Xszjxxb();
				entity2.setId(entity.getSqbh());
				entity2.setSpzt(entity.getSpzt());
				xszjspbService.update(entity, sessionBean);
				xszjxxbService.update(entity2, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES,  getMessage("update.success"));
				model.put(AppConst.SAVE_ID, entity2.getId()); // 返回主键
			}
		}catch (Exception e) {
			
			e.printStackTrace();
			logger.error(e.getLocalizedMessage(), e);
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, getAddFail());
		}
		
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		MessageUtils.rmdb_xszjsp(entity.getId());
		return mv;
	}
}


