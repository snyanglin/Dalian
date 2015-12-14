package com.founder.spsxt.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.ws.rs.PathParam;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.founder.framework.base.controller.BaseController;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.components.AppConst;
import com.founder.framework.utils.EasyUIPage;
import com.founder.spsxt.bean.NvrInfo;
import com.founder.spsxt.service.NvrInfoService;





import com.google.gson.Gson;



@Controller
@RequestMapping(value = "/nvrInfo")
public class NvrInfoController extends BaseController {

	private Logger logger = Logger.getLogger(this.getClass());
	
	@Resource(name="nvrInfoService")
	private NvrInfoService nvrInfoService;


	/**
	 * 保存NVR信息(为新增/修改)
	 * @return
	 */
	//新增或修改 my
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView saveNvrInfo(NvrInfo nvrInfo) {
		System.out.println("名称："+nvrInfo.getSbMc()+",NVR："+nvrInfo.getSbIp());//old		
		ModelAndView mv = new ModelAndView("redirect:/forward/"	+ AppConst.FORWORD);
		//ModelAndView mv = new ModelAndView("jfxt/gaOwner/ga_welcome");
		SessionBean sessionBean=getSessionBean();
		//System.out.println("当前用户名："+sessionBean.getUserName()+",所属组织机构："+sessionBean.getspjsdw.getDwbm()+"==>"+spjsdw.getJslb()+","+spjsdw.getJslb().length());
		Map<String, Object> model = new HashMap<String, Object>();
		if(null != sessionBean){//为公共部分赋值
			nvrInfo.setXt_lrrxm(sessionBean.getUserName());
			nvrInfo.setXt_lrrid(sessionBean.getUserId());
			nvrInfo.setXt_lrrbm(sessionBean.getUserOrgName());
			nvrInfo.setXt_lrrbmid(sessionBean.getUserOrgCode());
		}
		try {
			if (nvrInfo.getId() == null || nvrInfo.getId().trim().length()<1) { //新增平台
				System.out.println("NVR新增开始");
				
				nvrInfoService.insertNvrInfo(nvrInfo, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, getAddSuccess());
				System.out.println("NVR新增结束");
			} 
			else { // 修改
				System.out.println("NVR修改开始！"+nvrInfo.getId());
				nvrInfoService.updateNvrInfo(nvrInfo,sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, getUpdateSuccess());
				System.out.println("NVR修改结束");
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, getAddFail());
			
			System.out.println("保存失败！~！！"+e.getMessage());
		}
		System.out.println(AppConst.MESSAGES+","+AppConst.STATUS+"==>"+(new Gson().toJson(model)));
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		//mv.addObject(model);
		return mv;
	}	

	//新增或修改 my
	@RequestMapping(value = "/save2", method = RequestMethod.POST)
	public ModelAndView saveNvrInfo2(NvrInfo nvrInfo,RedirectAttributes model) {
		System.out.println("名称："+nvrInfo.getSbMc()+",NVR："+nvrInfo.getSbIp());
		
		ModelAndView mv = new ModelAndView("redirect:/forward/"	+ AppConst.FORWORD);
		SessionBean sessionBean=getSessionBean();
		//System.out.println("当前用户名："+sessionBean.getUserName()+",所属组织机构："+sessionBean.getspjsdw.getDwbm()+"==>"+spjsdw.getJslb()+","+spjsdw.getJslb().length());
		//Map<String, Object> model = new HashMap<String, Object>();
		//RedirectAttributes model=new RedirectAttributes();
		if(null != sessionBean){//为公共部分赋值
			nvrInfo.setXt_lrrxm(sessionBean.getUserName());
			nvrInfo.setXt_lrrid(sessionBean.getUserId());
			nvrInfo.setXt_lrrbm(sessionBean.getUserOrgName());
			nvrInfo.setXt_lrrbmid(sessionBean.getUserOrgCode());
		}
		try {
			if (nvrInfo.getId() == null || nvrInfo.getId().trim().length()<1) { //新增平台
				System.out.println("NVR新增开始");
				
				nvrInfoService.insertNvrInfo(nvrInfo, sessionBean);
				//model.put(AppConst.STATUS, AppConst.SUCCESS);
				//model.put(AppConst.MESSAGES, getAddSuccess());
				model.addFlashAttribute(AppConst.STATUS, AppConst.SUCCESS);				
				model.addFlashAttribute(AppConst.MESSAGES, getAddSuccess());
				System.out.println("NVR新增结束");
			} 
			else { // 修改
				System.out.println("NVR修改开始！"+nvrInfo.getId());
				nvrInfoService.updateNvrInfo(nvrInfo,sessionBean);
				//model.put(AppConst.STATUS, AppConst.SUCCESS);
				//model.put(AppConst.MESSAGES, getUpdateSuccess());
				model.addFlashAttribute(AppConst.STATUS, AppConst.SUCCESS);
				model.addFlashAttribute(AppConst.MESSAGES, getAddSuccess());
				System.out.println("NVR修改结束");
			}
		} catch (Exception e) {
			e.printStackTrace();
			//model.put(AppConst.STATUS, AppConst.FAIL);
			//model.put(AppConst.MESSAGES, getAddFail());
			model.addFlashAttribute(AppConst.STATUS, AppConst.FAIL);
			model.addFlashAttribute(AppConst.MESSAGES, getAddFail());
			
			System.out.println("保存失败！~！！"+e.getMessage());
		}
		System.out.println(AppConst.MESSAGES+","+AppConst.STATUS+"==>"+(new Gson().toJson(model)));
		//mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}	
	//根据主键删除实体对象
	@RequestMapping(value = "/deleteNvrInfoById/{id}", method = RequestMethod.GET)
	public ModelAndView deleteNvrInfoById(@PathVariable(value = "id") String id) {		
		System.out.println("删除NVR：id="+id);
		ModelAndView mv = new ModelAndView("jfxt/gaOwner/ga_nvrInfoDelete");//返回到删除(列表)页面
		String affectedRow=nvrInfoService.deleteNvrInfoById(id);
		System.out.println("affectedRow="+affectedRow);
		return mv;
	}
	
	
	//根据主键查询实体对象(for modify)
	@RequestMapping(value = "/queryNvrInfoById/{id}", method = RequestMethod.GET)
	public ModelAndView queryNvrInfoById(@PathVariable(value = "id") String id) {
		ModelAndView mv = new ModelAndView("jfxt/gaOwner/ga_nvrInfoAdd");		
		NvrInfo nvrInfo=nvrInfoService.queryNvrInfoById(id);
		mv.addObject("entity",nvrInfo);
		return mv;
	}


	//分页查询
	@RequestMapping(value = "/pageQueryNvr", method = RequestMethod.POST)
	public @ResponseBody
	EasyUIPage pageQueryNvr(EasyUIPage page,@RequestParam(value = "rows") Integer rows) {
		System.out.println("rows="+rows+","+page.getBegin()+","+page.getEnd());
		System.out.println("sort,"+page.getSort()+","+page.getOrder());
		
		page.setPagePara(rows);
		SessionBean sessionBean = getSessionBean();
		
		String bmid=sessionBean.getUserOrgCode();//派出所编码
		String policeId=sessionBean.getUserId();//民警警号
		Map<String,String> map=new HashMap<String,String>();
		//map.put("xt_lrrbmid", sessionBean.getUserOrgCode());
		map.put("bmid", bmid);//所在部门
		//map.put("policeId", policeId);//民警警号
		
		return nvrInfoService.pageQueryByCondition(page, map);
	}
	
	//根据平台选择NVR
	@RequestMapping(value = "/getNVRByPt", method = RequestMethod.GET)
	public @ResponseBody List getNVRByPt(String dwbm){
		List spNVRList =nvrInfoService.getNVRByPt(dwbm);
		System.out.println("长度"+spNVRList.size());
		//model.put("spjkxtList", spjkxtList);
		return spNVRList;
	}
	
	
	
	/*
	//检查本人管辖的单位是否同名
	@RequestMapping(value = "/checkSameName", method = RequestMethod.POST)
	public @ResponseBody int checkSameName(	@RequestParam(value = "dwmc")String dwmc){
		//Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		Map<String,String> map=new HashMap<String,String>();
		map.put("xt_lrrid", sessionBean.getUserId());
		map.put("dwmc", dwmc);
		int SameNameNum= spjsdwService.checkSameName(map);
		//SpsxtZBVO Spsxtvo = new SpsxtZBVO();
		
		try {
			Spsxtvo.setSameName(SameNameNum.toString());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	
		//model.put("Spsxtvo", Spsxtvo);
		return SameNameNum;//存在>0
	}
	*/
	//检查同一平台下设备名称是否唯一
	@RequestMapping(value = "/isUniqueForPlatformName")
	public @ResponseBody int isUniqueForPlatformName(String pt_id,String sbMc) {
		Map<String,String> paramMap=new HashMap<String,String>();
		paramMap.put("pt_id",pt_id);
		paramMap.put("sbMc",sbMc);
		return nvrInfoService.isUniqueForPlatformName(paramMap);
	}
}
