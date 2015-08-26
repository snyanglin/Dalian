package com.founder.yjjb.controller;

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
@RequestMapping(value = "/xszjxxb")
public class XszjxxbController extends BaseController {
private Logger logger = Logger.getLogger(this.getClass());
	
	@Resource(name="xszjxxbService")
	private XszjxxbService xszjxxbService;
	
	@Resource(name="xszjspbService")
	private XszjspbService xszjspbService;
	
	@Resource(name="commonService")
	private CommonService commonService;
	
	/**
	 * 跳转
	 * @param id
	 * @param mainTabID
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/openSqList", method = RequestMethod.GET)
	public ModelAndView xszjsqbList(String id,String mainTabID) {
		
		ModelAndView mv = new ModelAndView("yjjb/xszjList");
		mv.addObject("mainTabID", mainTabID);
		Xszjxxb entity = new Xszjxxb();
		
		if (!StringUtils.isBlank(id)) {
			
			entity.setId(id);
			entity = xszjxxbService.queryById(entity);
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
	@RequestMapping(value = "/openXxList", method = RequestMethod.GET)
	public ModelAndView xszjxxbList(String id,String mainTabID) {
		
		ModelAndView mv = new ModelAndView("yjjb/xszjList");
		mv.addObject("mainTabID", mainTabID);
		Xszjxxb entity = new Xszjxxb();
		
		if (!StringUtils.isBlank(id)) {
			
			entity.setId(id);
			entity = xszjxxbService.queryById(entity);
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
	public ModelAndView save(Xszjxxb entity){
		
		ModelAndView mv = new ModelAndView("redirect:/forward/" + AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		String orgCode = sessionBean.getUserOrgCode();
		try {
			if (entity.getId() == null || entity.getId().equals("")) {	//新增
				entity.setId(commonService.CreateNewSeq("05", orgCode));
				entity.setSpzt("0");
				Xszjspb entity1 = new Xszjspb();
				entity1.setId(commonService.CreateNewSeq("06", orgCode));
				entity1.setSqsj(entity.getSqsj());
				entity1.setSqbh(entity.getId());
				entity1.setSqdw(entity.getSqdw());
				entity1.setSpdw(commonService.queryUpOrgID(orgCode));
				entity1.setSpzt("0");
				entity1.setLybh("0");
				entity1.setBz(entity.getBz());
				xszjxxbService.save(entity, sessionBean);
				xszjspbService.save(entity1, sessionBean);
				MessageUtils.db_xszjsp(entity1);	//递转审批待办任务
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES,  getMessage("add.success"));
				model.put(AppConst.SAVE_ID, entity.getId()); // 返回主键
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
	@RequestMapping(value = "/sqQuery", method = RequestMethod.POST)
	public @ResponseBody
	EasyUIPage sqQueryList(EasyUIPage page,
			@RequestParam(value = "rows") Integer rows, Xszjxxb entity){
		
		page.setPagePara(rows);
		SessionBean sessionBean = getSessionBean();
		if(null != sessionBean){
			entity.setXt_lrrbmid(sessionBean.getUserOrgCode());
		}
		
		return this.xszjxxbService.queryList(page,entity);
	}
	
	/**
	 * 查询</br>
	 * @param page
	 * @param rows
	 * @param entity
	 * @return
	 */
	@RequestMapping(value = "/xxQuery", method = RequestMethod.POST)
	public @ResponseBody
	EasyUIPage xxQueryList(EasyUIPage page,
			@RequestParam(value = "rows") Integer rows, Xszjxxb entity){
		
		page.setPagePara(rows);
		SessionBean sessionBean = getSessionBean();
		if(null != sessionBean){
			entity.setXt_lrrbmid(sessionBean.getUserOrgCode());
			entity.setTy("ty");
		}
		
		return this.xszjxxbService.queryList(page,entity);
	}
	
	
	/**
	 * 跳转新增页面
	 * @param id
	 * @param mainTabID
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/sqOpenAdd", method = RequestMethod.GET)
	public ModelAndView sqOpenAdd(String id,String mainTabID) {
		
		ModelAndView mv = new ModelAndView("yjjb/xszjsqAdd");
		mv.addObject("mainTabID", mainTabID);
		SessionBean sessionBean = getSessionBean();
		
		Xszjxxb entity = new Xszjxxb();
		List<Xszjspb> list = null;
		String sj = "",sjnew = "",spzt = "",spztnew = "";
		if (!StringUtils.isBlank(id)) {
			
			entity.setId(id);
			entity = xszjxxbService.queryById(entity);
			entity.setSqrxm(commonService.queryUserNameByUserId(entity.getSqr().trim()));
			sj = entity.getSqsj().trim();
			sjnew = sj.substring(0,4)+"年"+sj.substring(5,7)+"月"+sj.substring(8,10)+"日"+sj.substring(11,13)+"时"+sj.substring(14,16)+"分"+sj.substring(17,19)+"秒";
			mv.addObject("sjnew", sjnew);
			Xszjspb entity1 = new Xszjspb();
			entity1.setSqbh(id);
			list = xszjspbService.queryBySqbh(entity1);
			for(int i = 0;i<list.size();i++){
				String sjonlist = "",bmonlist = "",sprxmonlist = "";
				sj = list.get(i).getXt_zhxgsj().trim();
				sjnew = sj.substring(0,4)+"年"+sj.substring(5,7)+"月"+sj.substring(8,10)+"日"+sj.substring(11,13)+"时"+sj.substring(14,16)+"分"+sj.substring(17,19)+"秒";
				 spzt =  list.get(i).getSpzt().trim();
				 bmonlist =  commonService.searchOrgList(list.get(i).getSpdw().trim()).get(0).getText();
				switch(Integer.parseInt(spzt)){
				case 0: spztnew = "即将处理或处理中";sjonlist = "即将";sprxmonlist = "";break;
				case 1: spztnew = "同意";sjonlist = sjnew;sprxmonlist = "的"+list.get(i).getXt_zhxgrxm();break;
				case 2: spztnew = "拒绝";sjonlist = sjnew;sprxmonlist = "的"+list.get(i).getXt_zhxgrxm();break;
				}
				list.get(i).setXt_zhxgsj(sjnew);list.get(i).setSpzt(spztnew);list.get(i).setSjonlist(sjonlist);list.get(i).setBmonlist(bmonlist);list.get(i).setSprxmonlist(sprxmonlist);
			}
		}
		mv.addObject("entity", entity);
		mv.addObject("list", list);
		return mv;
	}
	
	/**
	 * 跳转新增页面
	 * @param id
	 * @param mainTabID
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/xxOpenAdd", method = RequestMethod.GET)
	public ModelAndView xxOpenAdd(String id,String mainTabID) {
		
		ModelAndView mv = new ModelAndView("yjjb/xszjAdd");
		mv.addObject("mainTabID", mainTabID);
		SessionBean sessionBean = getSessionBean();
		
		Xszjxxb entity = new Xszjxxb();
		if (!StringUtils.isBlank(id)) {
			entity.setId(id);
			entity = xszjxxbService.queryById(entity);
		}
		mv.addObject("entity", entity);
		return mv;
	}

}
