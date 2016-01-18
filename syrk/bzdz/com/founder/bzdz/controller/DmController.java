package com.founder.bzdz.controller;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.founder.bzdz.service.DmService;
import com.founder.bzdz.vo.DmxxbVO;
import com.founder.framework.annotation.RestfulAnnotation;
import com.founder.framework.base.controller.BaseController;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.components.AppConst;
import com.founder.framework.organization.department.bean.OrgOrganization;
import com.founder.framework.organization.department.service.OrgOrganizationService;
import com.founder.framework.utils.ComboBox;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.google.gson.Gson;
/**
 * @类名: DmController
 * @描述: 地名管理
 * @作者: zhang_guoliang@founder.com
 * @日期: 2014-12-10 下午3:12:13
 */
@Controller
@RequestMapping(value = "dm")
public class DmController extends BaseController {
	@Resource(name = "dmService")
	private DmService dmService;
	@Resource(name = "orgOrganizationService")
	private OrgOrganizationService orgOrganizationService;
	/**
	 * @Title: queryDmList
	 * @描述: 查询地名列表
	 * @作者: zhang_guoliang@founder.com
	 * @参数: 传入参数定义
	 * @日期： 2014-12-10 下午3:43:41
	 * @返回值: EasyUIPage 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/queryDmList", method = RequestMethod.POST)
	public @ResponseBody
	EasyUIPage queryDmList(EasyUIPage page,
			@RequestParam(value = "rows") Integer rows, DmxxbVO entity) {
		page.setPagePara(rows);
		SessionBean sessionBean = getSessionBean();
		if(null != sessionBean){
			OrgOrganization userOrg = orgOrganizationService.queryById(sessionBean.getUserOrgId());
			String orglevel = userOrg.getOrglevel();
			if(!"31".equals(orglevel)&&!"30".equals(orglevel)){
				if(("21").equals(orglevel)){
					if(StringUtils.isBlank(entity.getFxjdm())){
						entity.setFxjdm((String)sessionBean.getUserOrgCode());
					}
				}else if("32".equals(orglevel)){
					if(StringUtils.isBlank(entity.getPcsdm())){
						entity.setPcsdm((String)sessionBean.getUserOrgCode());
					}
				}
				if(StringUtils.isBlank(entity.getXzqhdm())){
					entity.setXzqhdm(sessionBean.getUserOrgCode().substring(0,6));
				}
			}
		}
		return dmService.queryDmList(page, entity);
	}

	/**
	 * @Title: queryDmCount
	 * @描述: 查询地名列表总数
	 * @作者: zhang_guoliang@founder.com
	 * @参数: 传入参数定义
	 * @日期： 2014-12-10 下午4:01:16
	 * @返回值: long 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/queryDmCount", method = RequestMethod.POST)
	public @ResponseBody
	long queryDmCount(DmxxbVO entity) {
		SessionBean sessionBean = getSessionBean();
		if(null != sessionBean){
			OrgOrganization userOrg = orgOrganizationService.queryById(sessionBean.getUserOrgId());
			String orglevel = userOrg.getOrglevel();
			if(!"31".equals(orglevel)&&!"30".equals(orglevel)){
				if(("21").equals(orglevel)){
					if(StringUtils.isBlank(entity.getFxjdm())){
						entity.setFxjdm((String)sessionBean.getUserOrgCode());
					}
				}else if("32".equals(orglevel)){
					if(StringUtils.isBlank(entity.getPcsdm())){
						entity.setPcsdm((String)sessionBean.getUserOrgCode());
					}
				}
				if(StringUtils.isBlank(entity.getXzqhdm())){
					entity.setXzqhdm(sessionBean.getUserOrgCode().substring(0,6));
				}
			}
		}
		return dmService.queryDmCount(entity);
	}
	/**
	 * @Title: saveEditDm
	 * @描述: 新增或编辑地名
	 * @作者: zhang_guoliang@founder.com
	 * @参数: 传入参数定义
	 * @日期： 2014-12-12 下午3:42:40
	 * @返回值: ModelAndView 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/saveEditDm", method = RequestMethod.GET)
	public ModelAndView saveEditDm(String dmdm) {
		ModelAndView mv = null;
		DmxxbVO entity = new DmxxbVO();
		List<DmxxbVO> dmxzqhbArray = new ArrayList<DmxxbVO>();
		List<DmxxbVO> dmzzjgbArray = new ArrayList<DmxxbVO>();
		if (!StringUtils.isBlank(dmdm)) {
			 mv = new ModelAndView("bzdz/dmManage/dmEdit");
			 entity.setDmdm(dmdm);
			 entity = dmService.queryDm(entity);
			 dmxzqhbArray = dmService.queryXzqh(entity);
			 dmzzjgbArray = dmService.queryGxdw(entity);
		}else{
			 mv = new ModelAndView("bzdz/dmManage/dmAdd");
		}
		if (dmxzqhbArray.size() == 0) {
			dmxzqhbArray.add(new DmxxbVO());
		}
		if (dmzzjgbArray.size() == 0) {
			dmzzjgbArray.add(new DmxxbVO());
		}
		mv.addObject("entity", entity);
		mv.addObject("dmxzqhbArray", dmxzqhbArray);
		mv.addObject("dmxzqhbArrayLength", dmxzqhbArray.size());
		mv.addObject("dmzzjgbArray", dmzzjgbArray);
		mv.addObject("dmzzjgbArrayLength", dmzzjgbArray.size());
		return mv;
	}
	/**
	 * @Title: editDm 
	 * @描述: 维护地名
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2015-4-9 下午2:54:09 
	 * @返回值: ModelAndView    返回类型 
	 * @throws
	 */
	@RequestMapping(value = "/editDm", method = RequestMethod.POST)
	public @ResponseBody ModelAndView editDm(DmxxbVO entity,SessionBean sessionBean) {
		ModelAndView mv = new ModelAndView("redirect:/forward/"+ AppConst.FORWORD);
		sessionBean = getSessionBean(sessionBean);
		entity.setDmmc(entity.getDmmc().trim());
		entity.setBz(entity.getBz().trim());
		// 返回提示
 	    Map<String, Object> model = new HashMap<String, Object>();
 	    String xzqhmc = "";
 	    DmxxbVO [] zxqhArry = entity.getDmxzqhbArray();
		if(zxqhArry!=null){
			//保存到所属行政区划表
			for(int i=0;i<zxqhArry.length;i++){
				if(!"".equals(zxqhArry[i].getXzqhdm())&&zxqhArry[i].getXzqhdm()!=null){
					entity.setXzqhdm(zxqhArry[i].getXzqhdm());
					List<DmxxbVO> returnList = new ArrayList<DmxxbVO>();
					returnList = dmService.queryDmPd(entity);
					if(returnList.size()>0){
						xzqhmc = returnList.get(0).getXzqhmc();
						break;
					}
				}
			}
		}
		if (!"".equals(xzqhmc)) {
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, "保存数据失败,此地名【"+xzqhmc+"】已存在！");
		} else {
			dmService.editDm(entity, sessionBean);
			model.put(AppConst.STATUS, AppConst.SUCCESS);
			model.put(AppConst.MESSAGES, "维护【地名】成功！");
			model.put(AppConst.SAVE_ID, entity.getDmid()); //返回主键
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}
	/**
	 * @Title: saveDm
	 * @描述: 保存地名
	 * @作者: zhang_guoliang@founder.com
	 * @参数: 传入参数定义
	 * @日期： 2014-12-15 下午9:05:42
	 * @返回值: ModelAndView 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/saveDm", method = RequestMethod.POST)
	public @ResponseBody
	ModelAndView saveDm(DmxxbVO entity) {
		ModelAndView mv = new ModelAndView("redirect:/forward/"
				+ AppConst.FORWORD);
		SessionBean sessionBean = getSessionBean();
		entity.setDmmc(entity.getDmmc().trim());
		entity.setBz(entity.getBz().trim());
		// 返回提示
 	    Map<String, Object> model = new HashMap<String, Object>();
 	    String xzqhmc = "";
 	    //判断新增区划内
		DmxxbVO [] zxqhArry = entity.getDmxzqhbArray();
		if(zxqhArry!=null){
			//保存到所属行政区划表
			for(int i=0;i<zxqhArry.length;i++){
				if(!"".equals(zxqhArry[i].getXzqhdm())&&zxqhArry[i].getXzqhdm()!=null){
					entity.setXzqhdm(zxqhArry[i].getXzqhdm());
					List<DmxxbVO> returnList = new ArrayList<DmxxbVO>();
					returnList = dmService.queryDmPd(entity);
					if(returnList.size()>0){
						xzqhmc = returnList.get(0).getXzqhmc();
						break;
					}
				}
			}
		}
		if (!"".equals(xzqhmc)) {
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, "保存数据失败,此地名【"+xzqhmc+"】已存在！");
		} else {
			dmService.saveDm(entity, sessionBean);
			model.put(AppConst.STATUS, AppConst.SUCCESS);
			model.put(AppConst.MESSAGES, "新增【地名】成功！");
			model.put(AppConst.SAVE_ID, entity.getDmid()); // 返回主键
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}

	/**
	 * @Title: crossouDm
	 * @描述: 注销地名
	 * @作者: zhang_guoliang@founder.com
	 * @参数: 传入参数定义
	 * @日期： 2014-12-17 下午6:56:36
	 * @返回值: ModelAndView 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/crossouDm", method = RequestMethod.POST)
	public @ResponseBody
	ModelAndView crossouDm(DmxxbVO entity) {
		ModelAndView mv = new ModelAndView("redirect:/forward/"
				+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		boolean isExist = false;
		isExist = dmService.queryMldzPd(entity);
		if (isExist) {
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, "注销【地名】失败,此地名已被标准地址业务使用！");
		} else {
			dmService.crossouDm(entity, sessionBean);
			model.put(AppConst.STATUS, AppConst.SUCCESS);
			model.put(AppConst.MESSAGES, "注销【地名】成功！");
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}

	/**
	 * @Title: quertDlst
	 * @描述: 查询地图图层
	 * @作者: zhang_guoliang@founder.com
	 * @参数: 传入参数定义
	 * @日期： 2014-12-18 下午2:52:04
	 * @返回值: String 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/quertDlst", method = RequestMethod.POST)
	public @ResponseBody
	List<DmxxbVO> quertDlst(DmxxbVO entity) {
		return dmService.quertDlst(entity);
	}

	/**
	 * @Title: queryDictDm
	 * @描述: 获取地名下拉框字典【服务接口】
	 * @作者: zhang_guoliang@founder.com
	 * @参数: PCSDM 派出所代码
	 * @日期： 2015-1-7 上午10:31:57
	 * @返回值: List<ComboBox> 返回类型
	 * @throws
	 */
	@RestfulAnnotation(serverId = "3")
	@RequestMapping(value = "/queryDictDm", method = { RequestMethod.GET,RequestMethod.POST })
	public @ResponseBody
	List<ComboBox> queryDictDm(SessionBean sessionBean,@RequestParam String xzqhdm) {
		sessionBean = getSessionBean(sessionBean);
		List<ComboBox> comboxlist = new ArrayList<ComboBox>();
		if (null != sessionBean) {
			Map<String,String> map = new HashMap<String, String>();
			map.put("xzqhdm", xzqhdm);
			String pcsdm = (String) sessionBean.getExtendMap().get("ssPcsCode");
			map.put("pcsdm", pcsdm);
			comboxlist = dmService.queryDictDm(map);
		}
		return comboxlist;
	}

	/**
	 * @Title: queryDictSq
	 * @描述: 获取社区下拉框字典【服务接口】
	 * @作者: zhang_guoliang@founder.com
	 * @参数: PCSDM 派出所代码
	 * @日期： 2015-1-7 下午3:58:45
	 * @返回值: List<ComboBox> 返回类型
	 * @throws
	 */
	@RestfulAnnotation(serverId = "3")
	@RequestMapping(value = "/queryDictSq", method = { RequestMethod.GET,RequestMethod.POST })
	public @ResponseBody
	List<ComboBox> queryDictSq(SessionBean sessionBean) {
		sessionBean = getSessionBean(sessionBean);
		List<ComboBox> comboxlist = new ArrayList<ComboBox>();
		if (null != sessionBean) {
			String orgBiztype = sessionBean.getUserOrgBiztype();
			if("12".equals(orgBiztype)){//内保不需要查责任区，之前获取全部
				comboxlist = dmService.queryDictSq("");
			}else{
				String pcsdm = (String) sessionBean.getExtendMap().get("ssPcsCode");
				comboxlist = dmService.queryDictSq(pcsdm);
			}
		}
		return comboxlist;
	}
}