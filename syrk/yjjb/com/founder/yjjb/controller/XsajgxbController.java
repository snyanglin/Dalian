package com.founder.yjjb.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.founder.framework.utils.UUID;

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
import com.founder.yjjb.bean.Jbjlspb;
import com.founder.yjjb.bean.Jbjlxxb;
import com.founder.yjjb.bean.Xsajgxb;
import com.founder.yjjb.bean.Xsjbxxb;
import com.founder.yjjb.service.JbjlxxbService;
import com.founder.yjjb.service.XsajgxbService;
import com.founder.yjjb.service.XscljlbService;
import com.founder.yjjb.service.XsjbxxbService;

import com.google.gson.Gson;

@Controller
@RequestMapping(value = "/xsajgxb")
public class XsajgxbController extends BaseController {

	private Logger logger = Logger.getLogger(this.getClass());
	
	@Resource(name="xsajgxbService")
	private XsajgxbService xsajgxbService;
	
	@Resource(name="xsjbxxbService")
	private XsjbxxbService xsjbxxbService;
	
	@Resource(name="jbjlxxbService")
	private JbjlxxbService jbjlxxbService;
	
	// 日志处理
	@Resource(name="xscljlbService")
	private XscljlbService xscljlbService;
	String xsbh = "";
	String czlx = "";
	StringBuffer cznrBF = new StringBuffer();
	
	/**
	 * 待审请奖励查询</br>
	 * @param page
	 * @param rows
	 * @param entity
	 * @return
	 */
	@RequestMapping(value = "/queryList", method = RequestMethod.POST)
	public @ResponseBody
	EasyUIPage queryList(EasyUIPage page,
			@RequestParam(value = "rows") Integer rows, Xsajgxb entity){
		
		page.setPagePara(rows);
		SessionBean sessionBean = getSessionBean();
		if(null != sessionBean){
			String orgCode = sessionBean.getUserOrgCode();
			entity.setXt_lrrbmid(orgCode.replaceAll("0+?$", ""));
		}
		if (null == entity.getXt_lrrbm() || entity.getXt_lrrbm().equals("")) {
			if(null!=sessionBean){
				entity.setXt_lrrbmid(sessionBean.getUserOrgCode());
			}else{
				entity.setXt_lrrbmid("NULL");
			}
		}
		
		// 去除右侧的0，进行模糊查询
		entity.setXt_lrrbmid(entity.getXt_lrrbmid().replaceAll("0+?$", ""));
		
		return this.xsajgxbService.queryList(page,entity);
	}
	
	/**
	 * 根据线索编号查询内容</br>
	 * @param page
	 * @param rows
	 * @param entity
	 * @return
	 */
	@RequestMapping(value = "/queryByXsId", method = RequestMethod.POST)
	public @ResponseBody
	EasyUIPage queryByXsId(EasyUIPage page,
			@RequestParam(value = "rows") Integer rows, String XsId){
		page.setPagePara(rows);
		SessionBean sessionBean = getSessionBean();
		if(null != sessionBean){
			
		}
		
		return this.xsajgxbService.queryByXsId(page,XsId);
	}
	
	/**
	 * 注销
	 * @param entity
	 * @return
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public @ResponseBody
	Map delete(Xsajgxb entity){
		
//		ModelAndView mv = new ModelAndView("redirect:/forward/"	+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		try {
			xsajgxbService.delete(entity, sessionBean);
			model.put(AppConst.STATUS, AppConst.SUCCESS);
			model.put(AppConst.MESSAGES,  "取消案件关联成功");
		} catch (Exception e) {
			
			e.printStackTrace();
			logger.error(e.getLocalizedMessage(), e);
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, getAddFail());
		}
//		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return model;
	}
	
	/**
	 * 新增多条
	 * @param entity
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/save", method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView save(Xsajgxb entity,String xsId,String ajNum,String ajlx){
		
		ModelAndView mv = new ModelAndView("redirect:/forward/"	+ AppConst.FORWORD);
		String[] b = ajNum.split(",");
		String[] ajlxM = ajlx.split(",");
//		ModelAndView mv = new ModelAndView("yjjb/xgajList");
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		try {
			for(int i=0;i<b.length;i++){
				entity.setId(UUID.create());
				entity.setXsbh(xsId);
				entity.setAjbh(b[i]);
				entity.setBz("0");
				entity.setSfffjl("0");
				if(ajlxM[i].equals("3")){
					entity.setAjsource("1");
				}else{
					entity.setAjsource("0");
				}
				xsajgxbService.save(entity, sessionBean);
				
				// ********************************************日志处理
				String userName = sessionBean.getUserName();
				String orgName = sessionBean.getUserOrgName();
				
				// 关联线索
				czlx = "60";
				Xsjbxxb xsjbxxb = new Xsjbxxb();
				xsjbxxb.setId(xsId);
				xsjbxxb = xsjbxxbService.queryById(xsjbxxb);
				cznrBF = new StringBuffer();
				cznrBF.append(orgName);
				cznrBF.append(" 的 ");
				cznrBF.append(userName);
				cznrBF.append(",关联了案件");
				cznrBF.append(b[i]);
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
				xscljlbService.saveLog(xsId, cznrBF.toString(), czlx, sessionBean);
				// ********************************************日志处理
	
			}
			
			model.put(AppConst.STATUS, AppConst.SUCCESS);
			model.put(AppConst.MESSAGES,  getMessage("update.success"));
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
	 * 查询某线索关联的案件数量
	 * @param xsbh
	 * @return
	 */
	@RequestMapping(value = "/ifExistAj", method = RequestMethod.GET)
	public @ResponseBody int ifExistCh(String xsbh){
		return xsajgxbService.ifExistAj(xsbh);
	}
	
	/**
	 * 取消关联的时候查看是否申请过奖励
	 * @param xsbh
	 * @return
	 */
	@RequestMapping(value = "/checkXs", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> checkXs(String xsbh,String ajbh){
		Map<String, Object> model = new HashMap<String, Object>();
		Jbjlxxb entJbjlxxb = new Jbjlxxb();
		entJbjlxxb.setXsbh(xsbh);
		entJbjlxxb.setAjbh(ajbh);
		List<Jbjlxxb> jbjlxxbList = new ArrayList<Jbjlxxb>();
		jbjlxxbList = jbjlxxbService.queryByXsbhAjbh(entJbjlxxb);
		int sqNum = jbjlxxbList.size();
		
		model.put("sqNum", sqNum); // 返回主键
		return model;
	}
	
}
