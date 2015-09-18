package com.founder.aqff.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import net.sf.json.JSONArray;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.founder.aqff.bean.Aqffrfryxxb;
import com.founder.aqff.bean.AqffRfxxb;
import com.founder.aqff.service.RfxxbService;
import com.founder.framework.base.controller.BaseController;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.components.AppConst;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.framework.utils.UUID;
import com.founder.sydw.bean.Dwjbxxb;
import com.founder.sydw.service.DwjbxxbService;
import com.google.gson.Gson;
/******************************************************************************
 * @Package:      [com.founder.aqff.controller.AqffRfxxbController.java]  
 * @ClassName:    [AqffRfxxbController]   
 * @Description:  [人防信息与人方人员控制层]   
 * @Author:       [xu_haibo@founder.com.cn]  
 * @CreateDate:   [2015-6-2 上午1:22:04]   
 * @UpdateUser:   [haibo(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-6-2 上午1:22:04，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 */
@Controller
@RequestMapping(value = "/rfxxb")
public class AqffRfxxbController extends BaseController{

	private Logger logger = Logger.getLogger(this.getClass());
	
	//人防信息表service
	@Resource(name = "rfxxbService")
	private RfxxbService rfxxService;
	//单位基本信息表service
	@Resource(name = "dwjbxxbService")
	private DwjbxxbService dwjbxxbService;
	
	/**
	 * @Title: addRfxx
	 * @Description: TODO(人防信息添加跳转)
	 * @param  id
	 * @param  mainTabID
	 * @param  dwid
	 * @param  infoUrl
	 * @param  设定文件
	 * @return  ModelAndView    返回类型
	 * @throws
	 */
	@ResponseBody
	@RequestMapping(value = "/addRfxx", method = RequestMethod.GET)
	public ModelAndView addRfxx(String id,String mainTabID,String dwid,String infoUrl) {
		ModelAndView mv = new ModelAndView("aqff/aqffRfxxadd");
		mv.addObject("mainTabID", mainTabID);
		SessionBean sessionBean = getSessionBean();
		AqffRfxxb entity = new AqffRfxxb();
		String flag = "add";
		List<Aqffrfryxxb> list = new ArrayList<Aqffrfryxxb>();
		if (!StringUtils.isBlank(id)) {
			entity.setId(id);
			entity = rfxxService.queryRfxxById(entity);
			list = entity.getRyAllList();
			if(entity.getXt_lrrbmid().equals(sessionBean.getUserOrgCode())){
				flag ="update";
			}else {
				flag ="see";
			}
			
		}
		mv.addObject("flag", flag);
		mv.addObject("entity", entity);
		mv.addObject("list",new Gson().toJson(list));
		return mv;
	}
	
	/**
	 * @Title: saveRfxx
	 * @Description: TODO(人防信息保存方法)
	 * @param  entity
	 * @param  设定文件
	 * @return ModelAndView    返回类型
	 * @throws
	 */
	@SuppressWarnings({ "unchecked", "static-access" })
	@ResponseBody
	@RequestMapping(value = "/saveRfxx", method = RequestMethod.POST)
	public ModelAndView saveRfxx(AqffRfxxb entity){
		ModelAndView mv = new ModelAndView("redirect:/forward/" + AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		JSONArray  jcxmxJsonArray =JSONArray.fromObject(entity.getRyAll());
		List<Aqffrfryxxb> list = new ArrayList<Aqffrfryxxb>();
		list = (List<Aqffrfryxxb>)jcxmxJsonArray.toCollection(jcxmxJsonArray, Aqffrfryxxb.class);
		int rfxxnum = 0;
		String orgcode = sessionBean.getUserOrgCode();
		entity.setXt_lrrbmid(orgcode);
		rfxxnum = rfxxService.queryRfxxCF(entity);
		try {
			if (entity.getId() == null || entity.getId().equals("")) {
				if(rfxxnum>0){
					model.put(AppConst.STATUS, AppConst.ERRORS);
					model.put(AppConst.MESSAGES,  "组织名称重复!");
					mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
					return mv;
				}
				entity.setId(UUID.create());
				rfxxService.insertRfxx(entity, sessionBean);
				//添加人员之前先删掉之前已有人员
				rfxxService.deleteRfryxx(entity);
				for(int i = 0;i<list.size();i++){
					Aqffrfryxxb rfry = list.get(i);
					rfry.setRfid(entity.getId());
					rfxxService.saveRfcyxx(rfry, sessionBean);
				}
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES,  getMessage("add.success"));
				model.put(AppConst.SAVE_ID, entity.getId()); // 返回主键
			} else {
				AqffRfxxb rfxxdb = rfxxService.queryRfxxById(entity);
				String zzmc = rfxxdb.getZzmc();
				if(!zzmc.equals(entity.getZzmc())){
					if(rfxxnum>0){
						model.put(AppConst.STATUS, AppConst.ERRORS);
						model.put(AppConst.MESSAGES,  "组织名称重复!");
						mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
						return mv;
					}
				}
				rfxxService.updateRfxx(entity, sessionBean);
				//添加人员之前先删掉之前已有人员
				rfxxService.deleteRfryxx(entity);
				for(int i = 0;i<list.size();i++){
					Aqffrfryxxb rfry = list.get(i);
					rfry.setRfid(entity.getId());
					rfxxService.saveRfcyxx(rfry, sessionBean);
				}
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
	 * @Title: deleteRfxx
	 * @Description: TODO(人防信息注销)
	 * @param entity
	 * @param 设定文件
	 * @return ModelAndView    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/deleteRfxx", method = RequestMethod.POST)
	public @ResponseBody
	ModelAndView deleteRfxx(AqffRfxxb entity) {
		ModelAndView mv = new ModelAndView("redirect:/forward/"	+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		try {
				rfxxService.deleteRfxx(entity, sessionBean);
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
	 * @Title: queryRf
	 * @Description: TODO(人防信息模糊查询)
	 * @param page
	 * @param rows
	 * @param entity
	 * @param 设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/queryMHRf", method = RequestMethod.POST)
	public @ResponseBody
	EasyUIPage queryMHRf(EasyUIPage page,
			@RequestParam(value = "rows") Integer rows, AqffRfxxb entity) {
		page.setPagePara(rows);
		SessionBean sessionBean = getSessionBean();
		if(null != sessionBean){
			//entity.setXt_lrrid(sessionBean.getUserId());
			entity.setXt_lrrbmid(sessionBean.getUserOrgCode());
		}
		return rfxxService.queryMHRf(page, entity);
	}

	/**
	 * @Title: queryRf
	 * @Description: TODO(人防信息精确查询)
	 * @param page
	 * @param rows
	 * @param entity
	 * @param 设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/queryJQRf", method = RequestMethod.POST)
	public @ResponseBody
	EasyUIPage queryJQRf(EasyUIPage page,
			@RequestParam(value = "rows") Integer rows, AqffRfxxb entity) {
		page.setPagePara(rows);
		SessionBean sessionBean = getSessionBean();
		if(null != sessionBean){
			//entity.setXt_lrrid(sessionBean.getUserId());
			if(entity.getSfck()==0){
				entity.setXt_lrrbmid(sessionBean.getUserOrgCode());
			}
		}
		return rfxxService.queryJQRf(page, entity);
	}
	
	/**
	 * @Title: saveRfcyxx
	 * @Description: TODO(人方人员添加方法)
	 * @param entity
	 * @param 设定文件
	 * @return ModelAndView    返回类型
	 * @throws
	 */
	@ResponseBody       
	@RequestMapping(value = "/saveRfcyxx", method = RequestMethod.POST)
	public ModelAndView saveRfcyxx(Aqffrfryxxb entity){
		ModelAndView mv = new ModelAndView("redirect:/forward/" + AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		try {
			if (entity.getId() == null || entity.getId().equals("")) {
				Aqffrfryxxb newnetity = new Aqffrfryxxb();
				newnetity.setRfid(entity.getRfid());
				newnetity.setZjhm(entity.getZjhm());
				int ints = rfxxService.queryRfcyxxByZjhm(newnetity);
				Aqffrfryxxb rfxxdb = rfxxService.queryRfcyxxById(entity);
				String zjhm = "";
				if(!"".equals(entity.getId())){
					zjhm = rfxxdb.getZjhm();
				}
				if(ints==0&&!zjhm.equals(entity.getZjhm())){
					model.put(AppConst.STATUS, AppConst.SUCCESS);
					model.put(AppConst.MESSAGES,  getMessage("add.success"));
					model.put(AppConst.SAVE_ID, entity.getId()); // 返回主键
				}else{
					model.put(AppConst.STATUS, AppConst.ERRORS);
					model.put(AppConst.MESSAGES,  "人员重复!");
					model.put(AppConst.SAVE_ID, entity.getId());
				}
			} else {
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, getMessage("update.success"));
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
	 * @Title: deleteRfcyxx
	 * @Description: TODO(人防人员删除)
	 * @param entity
	 * @param 设定文件
	 * @return ModelAndView    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/deleteRfcyxx", method = RequestMethod.POST)
	public @ResponseBody
	ModelAndView deleteRfxx(Aqffrfryxxb entity) {
		ModelAndView mv = new ModelAndView("redirect:/forward/"	+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		try {
			rfxxService.deleteRfcyxx(entity, sessionBean);
			model.put(AppConst.STATUS, AppConst.SUCCESS);
			model.put(AppConst.MESSAGES, getMessage("cancel.success"));
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
	 * @Title: queryRfcyxx
	 * @Description: TODO(人方人员查询)
	 * @param page
	 * @param rows
	 * @param entity
	 * @param 设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/queryRfcyxx", method = RequestMethod.POST)
	public @ResponseBody
	EasyUIPage queryRfcyxx(EasyUIPage page,
			@RequestParam(value = "rows") Integer rows, Aqffrfryxxb entity) {
		page.setPagePara(rows);
		if(entity.getRfid()!=null){
			entity.setRfid(entity.getRfid().replace(",", ""));
		}
		return rfxxService.queryRfcyxx(page, entity);
	}
	
	/**
	 * @Title: addRfryxx
	 * @Description: TODO(人防人员添加跳转)
	 * @param id
	 * @param mainTabID
	 * @param states
	 * @param rfid
	 * @param infoUrl
	 * @param 设定文件
	 * @return ModelAndView    返回类型
	 * @throws
	 */
	@ResponseBody
	@RequestMapping(value = "/addRfryxx", method = RequestMethod.GET)
	public ModelAndView addRfryxx(String id,String mainTabID,String states,String rfid,String infoUrl,String zjhm,String zjlxdm,
			String xm,String xbdm,String whcddm,String zzmmdm,String rylydm,String zznzw,String lxfs,
			String cjsj,String dz_jzdzmlpdm,String dz_jzdzmlpxz,String dz_jzdzdm,
			String dz_jzdzssxqdm,String dz_jzdzxz,String cylbdm,String bz,String gzdw,String dwid,String index) {
		ModelAndView mv = new ModelAndView("aqff/aqffrfryxxAdd");
		mv.addObject("mainTabID", mainTabID);
		mv.addObject("states", states);
		Aqffrfryxxb entity = new Aqffrfryxxb();
		String flag = "add";
		try {
			if(!"".equals(zjhm)&&zjhm != null&&"null"!=zjhm&&!zjhm.equals("")){
			mv.addObject("zjhm", java.net.URLDecoder.decode(zjhm,"UTF-8"));
			mv.addObject("zjlxdm", java.net.URLDecoder.decode(zjlxdm,"UTF-8"));
			mv.addObject("xm", java.net.URLDecoder.decode(xm,"UTF-8"));
			mv.addObject("xbdm", java.net.URLDecoder.decode(xbdm,"UTF-8"));
			mv.addObject("whcddm", java.net.URLDecoder.decode(whcddm,"UTF-8"));
			mv.addObject("zzmmdm", java.net.URLDecoder.decode(zzmmdm,"UTF-8"));
			mv.addObject("rylydm", java.net.URLDecoder.decode(rylydm,"UTF-8"));
			mv.addObject("zznzw", java.net.URLDecoder.decode(zznzw,"UTF-8"));
			mv.addObject("lxfs", java.net.URLDecoder.decode(lxfs,"UTF-8"));
			mv.addObject("cjsj", java.net.URLDecoder.decode(cjsj,"UTF-8"));
			mv.addObject("dz_jzdzmlpdm", java.net.URLDecoder.decode(dz_jzdzmlpdm,"UTF-8"));
			mv.addObject("dz_jzdzmlpxz", java.net.URLDecoder.decode(dz_jzdzmlpxz,"UTF-8"));
			mv.addObject("dz_jzdzdm", java.net.URLDecoder.decode(dz_jzdzdm,"UTF-8"));
			mv.addObject("dz_jzdzssxqdm", java.net.URLDecoder.decode(dz_jzdzssxqdm,"UTF-8"));
			mv.addObject("dz_jzdzxz", java.net.URLDecoder.decode(dz_jzdzxz,"UTF-8"));
			mv.addObject("cylbdm", java.net.URLDecoder.decode(cylbdm,"UTF-8"));
			mv.addObject("bz", java.net.URLDecoder.decode(bz,"UTF-8"));
			mv.addObject("gzdw", java.net.URLDecoder.decode(gzdw,"UTF-8"));
			mv.addObject("dwid", java.net.URLDecoder.decode(dwid,"UTF-8"));
			mv.addObject("id", java.net.URLDecoder.decode(id,"UTF-8"));
			mv.addObject("index", java.net.URLDecoder.decode(index,"UTF-8"));
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (!StringUtils.isBlank(zjhm)&&!zjhm.equals("undefined")&&!StringUtils.isBlank(id)&&!id.equals("undefined")) {
			entity.setZjhm(zjhm);
			entity.setRfid(rfid);
			entity = rfxxService.queryRfcyxxByZjhmForDW(entity);
			Dwjbxxb dwjbxxb = new Dwjbxxb();
			dwjbxxb.setId(entity.getDwid());
			dwjbxxb = dwjbxxbService.query(dwjbxxb);
			if(dwjbxxb!=null){
				mv.addObject("dwmc", dwjbxxb.getDwmc());
			}

			flag ="update";
		}else if(!StringUtils.isBlank(dwid)&&!dwid.equals("undefined")){
			Dwjbxxb dwjbxxb = new Dwjbxxb();
			dwjbxxb.setId(dwid);
			if(dwjbxxb!=null){
				mv.addObject("dwmc", dwjbxxb.getDwmc());
			}
			flag ="update";
		}
		mv.addObject("rfid", rfid==null ? "":rfid);
		mv.addObject("infoUrl", infoUrl==null ? "":infoUrl);
		mv.addObject("flag", flag);
		mv.addObject("entity", entity);
		return mv;
	}
	
	/**
	 * @Title: queryRfxxInfo
	 * @Description: TODO(人防信息查看页面跳转)
	 * @param id
	 * @param mainTabID
	 * @param dwid
	 * @param infoUrl
	 * @param 设定文件
	 * @return ModelAndView    返回类型
	 * @throws
	 */
	@ResponseBody
	@RequestMapping(value = "/queryRfxxInfo", method = RequestMethod.GET)
	public ModelAndView queryRfxxInfo(String id,String mainTabID,String dwid,String infoUrl) {
		ModelAndView mv = new ModelAndView("aqff/aqffRfxxinfo");
		mv.addObject("mainTabID", mainTabID);
		AqffRfxxb entity = new AqffRfxxb();
		String flag = "see";
		if (!StringUtils.isBlank(id)) {
			entity.setId(id);
			entity = rfxxService.queryRfxxById(entity);		
		}
		mv.addObject("sydwid", dwid==null ? "":dwid);
		mv.addObject("infoUrl", infoUrl==null ? "":infoUrl);
		mv.addObject("flag", flag);
		mv.addObject("entity", entity);
		return mv;
	}
	
	/**
	 * @Title: queryRfInfo
	 * @Description: TODO(人防查询页面list精确查询方法)
	 * @param page
	 * @param rows
	 * @param entity
	 * @param 设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/queryJQRfInfo", method = RequestMethod.POST)
	public @ResponseBody
	EasyUIPage queryJQRfInfo(EasyUIPage page,
		@RequestParam
		(value = "rows") Integer rows, AqffRfxxb entity) {
		page.setPagePara(rows);
		return rfxxService.queryJQRf(page, entity);
	}
	
	/**
	 * @Title: queryRfInfo
	 * @Description: TODO(人防查询页面list模糊查询方法)
	 * @param page
	 * @param rows
	 * @param entity
	 * @param 设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/queryMHRfInfo", method = RequestMethod.POST)
	public @ResponseBody
	EasyUIPage queryMHRfInfo(EasyUIPage page,
		@RequestParam
		(value = "rows") Integer rows, AqffRfxxb entity) {
		page.setPagePara(rows);
		return rfxxService.queryMHRf(page, entity);
	}
	
	/**
	 * @Title: RfryxxInfo
	 * @Description: TODO(人防人员详细信息页面跳转)
	 * @param id
	 * @param mainTabID
	 * @param states
	 * @param rfid
	 * @param infoUrl
	 * @param 设定文件
	 * @return ModelAndView    返回类型
	 * @throws
	 */
	@ResponseBody
	@RequestMapping(value = "/RfryxxInfo", method = RequestMethod.GET)
	public ModelAndView RfryxxInfo(String id,String mainTabID,String states,String rfid,String infoUrl) {
		ModelAndView mv = new ModelAndView("aqff/aqffrfryxxInfo");
		mv.addObject("mainTabID", mainTabID);
		mv.addObject("states", states);
		Aqffrfryxxb entity = new Aqffrfryxxb();
		String flag = "see";
		if (!StringUtils.isBlank(id)) {
			entity.setId(id);
			entity = rfxxService.queryRfcyxxById(entity);
			//单位名称
			Dwjbxxb dwjbxxb = new Dwjbxxb();
			dwjbxxb.setId(entity.getGzdw());
			dwjbxxb = dwjbxxbService.query(dwjbxxb);
			if(dwjbxxb!=null){
				mv.addObject("dwmc", dwjbxxb.getDwmc());
			}
		}
		mv.addObject("rfid", rfid==null ? "":rfid);
		mv.addObject("infoUrl", infoUrl==null ? "":infoUrl);
		mv.addObject("flag", flag);
		mv.addObject("entity", entity);
		return mv;
	}

}

	

