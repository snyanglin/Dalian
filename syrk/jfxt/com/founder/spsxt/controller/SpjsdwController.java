package com.founder.spsxt.controller;
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

import com.founder.spsxt.bean.Spjsdw;
import com.founder.spsxt.service.SpjsdwService;
import com.founder.spsxt.vo.DepartmentInfoVO;
import com.founder.spsxt.vo.SpsxtZBVO;

import com.google.gson.Gson;



@Controller
@RequestMapping(value = "/spjsdw")
public class SpjsdwController extends BaseController {

	private Logger logger = Logger.getLogger(this.getClass());
	
	@Resource(name="spjsdwService")
	private SpjsdwService spjsdwService;


	/**
	 * 保存单位新增和修改结果
	 * @return
	 */
	//新增或修改 my
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView saveSpjkxt(Spjsdw spjsdw) {
		System.out.println("视频单位名称："+spjsdw.getDwmc()+","+spjsdw.getDwbm()+"==>"+spjsdw.getJslb()+","+spjsdw.getJslb().length());
		
		ModelAndView mv = new ModelAndView("redirect:/forward/"	+ AppConst.FORWORD);
		SessionBean sessionBean=getSessionBean();
		//System.out.println("当前用户名："+sessionBean.getUserName()+",所属组织机构："+sessionBean.getspjsdw.getDwbm()+"==>"+spjsdw.getJslb()+","+spjsdw.getJslb().length());
		Map<String, Object> model = new HashMap<String, Object>();
		if(null != sessionBean){
			spjsdw.setXt_lrrxm(sessionBean.getUserName());
			spjsdw.setXt_lrrid(sessionBean.getUserId());
			spjsdw.setXt_lrrbm(sessionBean.getUserOrgName());
			spjsdw.setXt_lrrbmid(sessionBean.getUserOrgCode());
		}
		try {
			if (spjsdw.getId() == null || spjsdw.getId().trim().length()<1) { // 新增
				System.out.println("视频单位新增开始");
				
				spjsdwService.insertSpjsdw(spjsdw,sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, getAddSuccess());
				System.out.println("视频单位新增结束");
			} 
			else { // 修改
				System.out.println("视频单位修改开始！"+spjsdw.getDwbm());
				spjsdwService.updateSpjsdw(spjsdw,sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, getUpdateSuccess());
				System.out.println("视频单位修改结束");
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, getAddFail());
			System.out.println("保存失败！~！！"+e.getMessage());
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}
	
	//根据主键查询实体对象
	@RequestMapping(value = "/queryById", method = RequestMethod.GET)
	public ModelAndView query(@RequestParam(value = "id") String id) {
		ModelAndView mv = new ModelAndView("jfxt/spjsdwAdd");		
		Spjsdw spjsdw=spjsdwService.querySpjsdwByDwbm(id);
		mv.addObject("entity",spjsdw);
		return mv;
	}

	//根据主键删除实体对象
	@RequestMapping(value = "/deleteById", method = RequestMethod.GET)
	public ModelAndView delete(@RequestParam(value = "id") String id) {		
		System.out.println("删除视频建设单位：dwbm="+id);
		ModelAndView mv = new ModelAndView("jfxt/spjsdwDelete");//返回到删除(列表)页面
		String affectedRow=spjsdwService.deleteSpjsdwByDwbm(id);
		System.out.println("affectedRow="+affectedRow);
		return mv;
	}
	

	
	
	
	
	
	
	//根据派出所编码和民警警号查询
	@RequestMapping(value = "/queryByPcsPoliceId", method = RequestMethod.GET)
	public @ResponseBody List queryByPcsPoliceId(){
		SessionBean sessionBean=getSessionBean();
		String pcsbm=sessionBean.getUserOrgCode();//派出所编码
		String policeId=sessionBean.getUserId();//民警警号
		List spjsdwListOfMap=spjsdwService.queryByPcsPoliceId(pcsbm, policeId);		
		return spjsdwListOfMap;		
	}
	
	@RequestMapping(value = "/getGazjByDw", method = RequestMethod.POST)
	public @ResponseBody List getGazjByDw(String dwbm){

		List gazjListOfMap=spjsdwService.getGazjByDw(dwbm);		
		return gazjListOfMap;		
	}

	//根据选择的部门获得其所有的视频假设单位
	@RequestMapping(value = "/queryByBmid", method = RequestMethod.GET)
	public @ResponseBody List queryByBmid(@RequestParam(value = "bmid") String bmid){
		//处理选择的部门id，从后往前查找第一个非0字符，然后取字串0,pos
		int i;
		for(i=bmid.length()-1;i>=0;i--){
			if(bmid.charAt(i)!='0'){
				break;
			}
		}
		String partBmid=bmid.substring(0,i+1);
		System.out.println(bmid+"====>"+partBmid);
		if(bmid==null || bmid.trim().length()<1)
			partBmid="2102";//全局
		Map map=new HashMap();
		map.put("bmid", partBmid);//查询时选择的部门		
		List spjsdwListOfMap=spjsdwService.queryByBmid(map);		
		
		return spjsdwListOfMap;		
	}
	
	//查询本人录入的单位信息2014.11.22.
	@RequestMapping(value = "/queryList", method = RequestMethod.POST)
	public @ResponseBody
	EasyUIPage queryList(EasyUIPage page,@RequestParam(value = "rows") Integer rows) {
		System.out.println("rows="+rows+","+page.getBegin()+","+page.getEnd());
		System.out.println("sort,"+page.getSort()+","+page.getOrder());
		
		page.setPagePara(rows);
		SessionBean sessionBean = getSessionBean();
		
		String pcsbm=sessionBean.getUserOrgCode();//派出所编码
		String policeId=sessionBean.getUserId();//民警警号
		Map map=new HashMap();
		//map.put("xt_lrrbmid", sessionBean.getUserOrgCode());
		map.put("pcsbm", pcsbm);//派出所编码
		map.put("policeId", policeId);//民警警号
		
		return spjsdwService.queryList(page, map);
	}
	
	//通用分页查询(根据选择的部门(大部门/小部门))
	@RequestMapping(value = "/queryListByBmid", method = RequestMethod.POST)
	public @ResponseBody
	EasyUIPage queryListByBmid(EasyUIPage page,@RequestParam(value = "rows") Integer rows,@RequestParam(value = "bmid") String bmid) {
		System.out.println("rows="+rows+","+page.getBegin()+","+page.getEnd());
		System.out.println("sort,"+page.getSort()+","+page.getOrder());
		
		page.setPagePara(rows);
		SessionBean sessionBean = getSessionBean();
		
		String pcsbm=sessionBean.getUserOrgCode();//派出所编码
		String policeId=sessionBean.getUserId();//民警警号
		Map map=new HashMap();
		map.put("xt_lrrbmid", sessionBean.getUserOrgCode());
		//处理选择的部门id，从后往前查找第一个非0字符，然后取字串0,pos
		int i;
		for(i=bmid.length()-1;i>=0;i--){
			if(bmid.charAt(i)!='0'){
				break;
			}
		}
		String partBmid=bmid.substring(0,i+1);
		System.out.println(bmid+"====>"+partBmid);
		
		
		map.put("bmid", partBmid);//查询时选择的部门
		//map.put("policeId", policeId);//民警警号
		
		return spjsdwService.queryListByBmid(page, map);
	}
	

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
		/*
		try {
			Spsxtvo.setSameName(SameNameNum.toString());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		*/
		//model.put("Spsxtvo", Spsxtvo);
		return SameNameNum;//存在>0
	}
	
	
	//根据派出所编码和民警警号查询
	@RequestMapping(value = "/getDepartmentBasicInfoByPy", method = RequestMethod.GET)
	public @ResponseBody List getDepartmentBasicInfoByPy(String py){
		System.out.println("py=="+py);
		SessionBean sessionBean=getSessionBean();
		String pcsbm=sessionBean.getUserOrgCode();//派出所编码
		String policeId=sessionBean.getUserId();//民警警号
		List spjsdwListOfMap=spjsdwService.getDepartmentBasicInfoByPy(pcsbm,policeId,py);
		System.out.println("py=="+py+",SIZE "+spjsdwListOfMap.size());
		System.out.println(new Gson().toJson(spjsdwListOfMap));
		return spjsdwListOfMap;		
	}
	//根据单位id查询其详细信息2014.11.7.
	@RequestMapping(value = "/getDepartmentInfoByDwId", method = RequestMethod.GET)
	public @ResponseBody DepartmentInfoVO getDepartmentInfoByDwId(String dwbm){
		System.out.println("dwbm="+dwbm);
		List list=spjsdwService.getDepartmentInfoByDwId(dwbm);
		if(list.size()>0)//取第一条
			return (DepartmentInfoVO)list.get(0);
		return null;
	}
	//全局范围检查视频单位的唯一性
	@RequestMapping(value = "/isUniqueForSpjsdw")
	public @ResponseBody int isUniqueForSpjsdw(String dwbm){

		int existsCount= spjsdwService.isUniqueForSpjsdw(dwbm);
		return existsCount;//存在>0
	}
}
