package com.founder.sqjw.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.founder.framework.base.controller.BaseController;
import com.founder.framework.utils.EasyUIPage;
import com.founder.sqjw.service.MainService;
import com.founder.sqjw.vo.CountMapVO;
import com.founder.sqjw.vo.MainVo;
import com.founder.syfw.vo.SyfwListVo;
import com.founder.syrkgl.bean.SyrkSyrkxxzb;
/**
 * @类名: MainController 
 * @描述: 主页Controller
 * @作者: zhang_guoliang@founder.com 
 * @日期: 2015-8-14 下午6:20:53
 */
@Controller
@RequestMapping("/main")
public class MainController extends BaseController{
	@Resource(name = "mainService")
	private MainService mainService;
	/**
	 * @Title: queryPcsXqgkTj
	 * @描述: 查询派出所辖区概况统计
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @返回值: EasyUIPage    返回类型 
	 * @throws
	 */
	@RequestMapping(value = "/queryPcsXqgkTj",method = RequestMethod.POST)
	public @ResponseBody EasyUIPage queryPcsXqgkTj(EasyUIPage page,@RequestParam(value = "rows",required=false) Integer rows,MainVo entity){
		return mainService.queryPcsXqgkTj(page,entity);
	}
	/**
	 * @Title: queryListsyfw 
	 * @描述: 查询派出所辖区实有房概况详情
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @返回值: EasyUIPage    返回类型 
	 * @throws
	 */
	@RequestMapping(value = "/queryListsyfw", method = RequestMethod.POST)
	public @ResponseBody
	List<SyfwListVo> queryListsyfw(String syfwlb) {
		List<SyfwListVo> listVo = null;
		Map<String, String> param = new HashMap<String, String>();
		String orgid = getSessionBean().getUserOrgCode();
		param.put("orgCode", orgid);
		if(syfwlb.equals("1")){
			 listVo = mainService
					.queryListczf(param);
		}else if(syfwlb.equals("2")){
			 listVo = mainService
					.queryListcheckczf(param);
		}else {
			listVo =  mainService.queryListuncheckczf(param);
		}
	
		return listVo;
	}
	/**
	 * @Title: queryListsyfw 
	 * @描述: 查询派出所辖区重点人口概况详情
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @返回值: EasyUIPage    返回类型 
	 * @throws
	 */
	@RequestMapping(value = "/queryListzdrk", method = RequestMethod.POST)
	public @ResponseBody
	List<CountMapVO> queryListzdrk(String zdrybm) {
		List<CountMapVO> listVo = null;
		Map<String, String> param = new HashMap<String, String>();
		String orgid = getSessionBean().getUserOrgCode();
		param.put("orgCode", orgid);
		param.put("zdrydm", zdrybm);
		if(zdrybm.equals("1"))
		listVo = mainService.queryListzdry(param);
		return listVo;
	
		
	}
	/**
	 * @Title: queryPcsXqgkXq 
	 * @描述: 查询派出所辖区概况详情
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @返回值: EasyUIPage    返回类型 
	 * @throws
	 */
	@RequestMapping(value = "/queryczf",method = RequestMethod.POST)
	public @ResponseBody List<MainVo> queryczf(MainVo entity){
		
		return mainService.queryPcsXqgkXq(entity);
	}
	
	
	@RequestMapping(value = "/queryListByRyidYwlx", method = RequestMethod.POST)
	public @ResponseBody
	List<SyrkSyrkxxzb> queryListByRyidYwlx(SyrkSyrkxxzb entity) {
		List<SyrkSyrkxxzb> listVo = mainService
				.queryListByRyidYwlx(entity);
		return listVo;
	}

	
}