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
import com.founder.framework.base.controller.BaseController;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.components.AppConst;
import com.founder.framework.utils.EasyUIPage;
import com.founder.spsxt.bean.Platform;
import com.founder.spsxt.service.NameValuePairService;
import com.founder.spsxt.service.PlatformService;




import com.google.gson.Gson;



@Controller
@RequestMapping(value = "/platform")
public class PlatformController extends BaseController {

	private Logger logger = Logger.getLogger(this.getClass());
	
	@Resource(name="platformService")
	private PlatformService platformService;

	@Resource(name="nameValuePairService")
	private NameValuePairService nameValuePairService;
	/**
	 * 保存平台信息(为新增/修改)
	 * @return
	 */
	//新增或修改 my
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView saveSpjkxt(Platform platform) {
		System.out.println("平台名称："+platform.getPtmc()+",平台厂商："+platform.getPtcs());
		
		ModelAndView mv = new ModelAndView("redirect:/forward/"	+ AppConst.FORWORD);
		SessionBean sessionBean=getSessionBean();
		//System.out.println("当前用户名："+sessionBean.getUserName()+",所属组织机构："+sessionBean.getspjsdw.getDwbm()+"==>"+spjsdw.getJslb()+","+spjsdw.getJslb().length());
		Map<String, Object> model = new HashMap<String, Object>();
		if(null != sessionBean){//为公共部分赋值
			platform.setXt_lrrxm(sessionBean.getUserName());
			platform.setXt_lrrid(sessionBean.getUserId());
			platform.setXt_lrrbm(sessionBean.getUserOrgName());
			platform.setXt_lrrbmid(sessionBean.getUserOrgCode());
		}
		try {
			if (platform.getId() == null || platform.getId().trim().length()<1) { //新增平台
				System.out.println("平台新增开始");
				
				platformService.insertPlatform(platform, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, getAddSuccess());
				System.out.println("平台新增结束");
			} 
			else { // 修改
				System.out.println("平台修改开始！"+platform.getId());
				platformService.updatePlatform(platform,sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, getUpdateSuccess());
				System.out.println("平台修改结束");
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
	
	//根据主键删除实体对象
	@RequestMapping(value = "/deletePlatformById/{id}", method = RequestMethod.GET)
	public ModelAndView deletePlatformById(@PathVariable(value = "id") String id) {		
		System.out.println("删除平台：id="+id);
		ModelAndView mv = new ModelAndView("jfxt/gaOwner/ga_platformDelete");//返回到删除(列表)页面
		String affectedRow=platformService.deletePlatformById(id);
		System.out.println("affectedRow="+affectedRow);
		return mv;
	}
	
	
	//根据主键查询实体对象(for modify)
	@RequestMapping(value = "/queryPlatformById/{id}", method = RequestMethod.GET)
	public ModelAndView queryPlatformById(@PathVariable(value = "id") String id) {
		System.out.println("修改平台：id="+id);
		ModelAndView mv = new ModelAndView("jfxt/gaOwner/ga_platformAdd");		
		Platform platform=platformService.queryPlatformById(id);
		mv.addObject("entity",platform);
		return mv;
	}


	//分页查询
	@RequestMapping(value = "/pageQueryPlatform", method = RequestMethod.POST)
	public @ResponseBody
	EasyUIPage queryPlatformList(EasyUIPage page,@RequestParam(value = "rows") Integer rows) {
		System.out.println("rows="+rows+","+page.getBegin()+","+page.getEnd());
		System.out.println("sort,"+page.getSort()+","+page.getOrder());
		
		page.setPagePara(rows);
		SessionBean sessionBean = getSessionBean();
		
		String pcsbm=sessionBean.getUserOrgCode();//派出所编码
		String policeId=sessionBean.getUserId();//民警警号
		Map<String,String> map=new HashMap<String,String>();
		//map.put("xt_lrrbmid", sessionBean.getUserOrgCode());
		map.put("pcsbm", pcsbm);//派出所编码
		map.put("policeId", policeId);//民警警号
		
		return platformService.pageQueryByCondition(page, map);
	}
	

	//获得自己的平台名称和id？
	//获得本单位所属分局的所有平台
	@RequestMapping(value = "/getPlatformNameAndId", method = RequestMethod.GET)
	public @ResponseBody List getPlatformNameAndId(){
       	SessionBean userInfo = getSessionBean();
       	String userOrgCode=userInfo.getUserOrgCode();
		String twoLevelOrgCode=nameValuePairService.get2LevelDepartByOrgCode(userOrgCode);
		System.out.println("userOrgCode="+userOrgCode+",twoLevelOrgCode:"+twoLevelOrgCode);
		
		//String pcsbm=sessionBean.getUserOrgCode();//派出所编码
		//String policeId=sessionBean.getUserId();//民警警号
		List nameAndIdList=platformService.getPlatformNameAndId(twoLevelOrgCode);		
		return nameAndIdList;		
	}

	//检查平台名称是否全局唯一.唯一,返回true
	@RequestMapping(value = "/isUniqueForPlatformName")
	public @ResponseBody int isUniqueForPlatformName(@RequestParam(value = "ptmc") String ptmc) {
		return platformService.isUniqueForPlatformName(ptmc);
	}
}
