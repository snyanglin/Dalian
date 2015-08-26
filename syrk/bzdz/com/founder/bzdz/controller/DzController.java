package com.founder.bzdz.controller;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.founder.bzdz.bean.DzContextCombo;
import com.founder.bzdz.bean.DzContextCondition;
import com.founder.bzdz.service.DzService;
import com.founder.bzdz.vo.BzdzxxbVO;
import com.founder.bzdz.vo.DzBuildingVO;
import com.founder.bzdz.vo.DzTjVO;
import com.founder.framework.annotation.RestfulAnnotation;
import com.founder.framework.base.controller.BaseController;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.components.AppConst;
import com.founder.framework.config.SystemConfig;
import com.founder.framework.exception.RestException;
import com.founder.framework.organization.department.bean.OrgOrganization;
import com.founder.framework.organization.department.service.OrgOrganizationService;
import com.founder.framework.utils.DateUtils;
import com.founder.framework.utils.EasyUIPage;
import com.founder.utils.FileUtils;

import com.google.gson.Gson;
/**
 * @类名: DzController 
 * @描述: 地址管理
 * @作者: zhang_guoliang@founder.com 
 * @日期: 2014-12-19 下午3:22:37 
 */
@Controller
@RequestMapping(value = "dz")
public class DzController extends BaseController {
	@Resource(name = "dzService")
	private DzService dzService;
	@Resource(name = "orgOrganizationService")
	private OrgOrganizationService orgOrganizationService;
	/**
	 * @Title: queryDzList 
	 * @描述: 查询地址管理列表【服务接口】
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2014-12-25 下午2:47:12 
	 * @返回值: EasyUIPage    返回类型 
	 * @throws
	 */
	@RestfulAnnotation(serverId="3")
	@RequestMapping(value = "/queryDzList",method = RequestMethod.POST)
	public @ResponseBody EasyUIPage queryDzList(EasyUIPage page,@RequestParam(value = "rows",required=false) Integer rows,BzdzxxbVO entity,SessionBean sessionBean){
		page.setPagePara(rows);
		sessionBean = getSessionBean(sessionBean);
		if(null != sessionBean){
			OrgOrganization userOrg = orgOrganizationService.queryById(sessionBean.getUserOrgId());
			String orglevel = userOrg.getOrglevel();
			if(("21").equals(orglevel)){
				entity.setFxjdm((String)sessionBean.getUserOrgCode());
			}else if("32".equals(orglevel)){
				entity.setPcsdm((String)sessionBean.getUserOrgCode());
			}else if("50".equals(orglevel)){
				entity.setZrqdm((String)sessionBean.getUserOrgCode());
			}
		}
		return dzService.queryDzList(page, entity);
	}
	/**
	 * @Title: createDz 
	 * @描述: 地址新建页面
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2014-12-29 下午2:50:17 
	 * @返回值: ModelAndView  返回类型 
	 * @throws
	 */
	@RequestMapping(value = "/createDz", method = RequestMethod.GET)
    public ModelAndView createDz(String mainTabID){
		ModelAndView mv = new ModelAndView("bzdz/dzManage/dzAdd");
		List<BzdzxxbVO> dzBmArray = new ArrayList<BzdzxxbVO>();
		if(dzBmArray.size() == 0){
			dzBmArray.add(new BzdzxxbVO());
		}
		mv.addObject("mainTabID", mainTabID);
		mv.addObject("dzBmArray",dzBmArray);
		mv.addObject("dzBmArrayLength",dzBmArray.size());
		return mv;
    }
	/**
	 * @Title: saveDz 
	 * @描述: 保存地址
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2015-1-8 上午10:49:12 
	 * @返回值: ModelAndView    返回类型 
	 * @throws
	 */
	@RestfulAnnotation(valiField="xzqhdm,xzqhmc,dmdm,dmmc,mlph,mlphhz,mlphhzmc,zbx,zby",serverId="3")
	@RequestMapping(value = "/saveDz", method = RequestMethod.POST)
	public @ResponseBody ModelAndView saveDz(BzdzxxbVO entity,SessionBean sessionBean){
		ModelAndView mv = new ModelAndView("redirect:/forward/"+ AppConst.FORWORD);
		sessionBean = getSessionBean(sessionBean);
		//返回提示
		Map<String, Object> model = new HashMap<String, Object>();
		//判断门楼牌号名称
		if("".equals(entity.getMlphqc())||entity.getMlphqc()==null){
			String mlphqc = entity.getDmmc()+entity.getMlphqzmc()+entity.getMlph()+entity.getMlphhzmc();
			entity.setMlphqc(mlphqc);
		}
		//层户结构判断
		if((entity.getDsdys()==null||"".equals(entity.getDsdys()))&&(entity.getDxdys()==null||"".equals(entity.getDsdys()))){
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, "保存【"+entity.getMlphqc()+"】失败，层户结构信息不完整，请完善信息。");
			mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
			return mv;
		}
		if(entity.getDsdys()!=null&&!"".equals(entity.getDsdys())){
			if(entity.getDszdcs()==null||"".equals(entity.getDszdcs())||entity.getDszdcs()=="0"||entity.getDszdhs()==null||"".equals(entity.getDszdhs())||entity.getDszdhs()=="0"){
				model.put(AppConst.STATUS, AppConst.FAIL);
				model.put(AppConst.MESSAGES, "保存【"+entity.getMlphqc()+"】失败，地上层户信息不完整，请完善信息。");
				mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
				return mv;
			}
		}
		if(entity.getDxdys()!=null&&!"".equals(entity.getDxdys())){
			if(entity.getDxzdcs()==null||"".equals(entity.getDxzdcs())||entity.getDxzdcs()=="0"||entity.getDxzdhs()==null||"".equals(entity.getDxzdhs())||entity.getDxzdhs()=="0"){
				model.put(AppConst.STATUS, AppConst.FAIL);
				model.put(AppConst.MESSAGES, "保存【"+entity.getMlphqc()+"】失败，地下层户信息不完整，请完善信息。");
				mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
				return mv;
			}
		}
		//判断门楼地址是否存在
		List<BzdzxxbVO> mldzlist = new ArrayList<BzdzxxbVO>();
		mldzlist = dzService.queryMldzPd(entity);
		if(mldzlist.size()>0){
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, "保存【"+entity.getMlphqc()+"】失败，该地址已在【"+mldzlist.get(0).getXt_zhxgrbm()+"】存在！");
			model.put(AppConst.SAVE_ID, entity.getMldzid());
		}else{
			dzService.saveDz(entity,sessionBean);
			model.put(AppConst.STATUS, AppConst.SUCCESS);
			model.put(AppConst.MESSAGES, "保存【"+entity.getMlphqc()+"】成功！");
			model.put(AppConst.SAVE_ID, entity.getMldzid());
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}
	/**
	 * @Title: saveChDz 
	 * @描述: 保存层户地址
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2015-4-7 下午2:27:53 
	 * @返回值: ModelAndView    返回类型 
	 * @throws
	 */
	@RequestMapping(value = "/saveChDz", method = RequestMethod.POST)
	public @ResponseBody ModelAndView saveChDz(BzdzxxbVO entity,SessionBean sessionBean){
		ModelAndView mv = new ModelAndView("redirect:/forward/"+ AppConst.FORWORD);
		sessionBean = getSessionBean(sessionBean);
		//返回提示
		Map<String, Object> model = new HashMap<String, Object>();
		//层户结构判断
		if((entity.getDsdys()==null||"".equals(entity.getDsdys()))&&(entity.getDxdys()==null||"".equals(entity.getDsdys()))){
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, "保存【"+entity.getMlphqc()+"】失败，层户结构信息不完整，请完善信息。");
			mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
			return mv;
		}
		if(entity.getDsdys()!=null&&!"".equals(entity.getDsdys())){
			if(entity.getDszdcs()==null||"".equals(entity.getDszdcs())||entity.getDszdcs()=="0"||entity.getDszdhs()==null||"".equals(entity.getDszdhs())||entity.getDszdhs()=="0"){
				model.put(AppConst.STATUS, AppConst.FAIL);
				model.put(AppConst.MESSAGES, "保存【"+entity.getMlphqc()+"】失败，地上层户信息不完整，请完善信息。");
				mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
				return mv;
			}
		}
		if(entity.getDxdys()!=null&&!"".equals(entity.getDxdys())){
			if(entity.getDxzdcs()==null||"".equals(entity.getDxzdcs())||entity.getDxzdcs()=="0"||entity.getDxzdhs()==null||"".equals(entity.getDxzdhs())||entity.getDxzdhs()=="0"){
				model.put(AppConst.STATUS, AppConst.FAIL);
				model.put(AppConst.MESSAGES, "保存【"+entity.getMlphqc()+"】失败，地下层户信息不完整，请完善信息。");
				mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
				return mv;
			}
		}
		dzService.saveChDz(entity,sessionBean);
		model.put(AppConst.STATUS, AppConst.SUCCESS);
		model.put(AppConst.MESSAGES, "层户结构【注销重建】成功！");
		model.put(AppConst.SAVE_ID, entity.getMldzid());
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}
	/**
	 * @Title: crossOutDspAndTh
	 * @描述: 注销待审批或被回退地址数据
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2015-2-4 下午5:55:56 
	 * @返回值: ModelAndView    返回类型 
	 * @throws
	 */
	@RequestMapping(value = "/crossOutDspAndTh", method = RequestMethod.POST)
	public @ResponseBody ModelAndView crossOutDspAndTh(BzdzxxbVO entity){
		ModelAndView mv = new ModelAndView("redirect:/forward/"+ AppConst.FORWORD);
		SessionBean sessionBean = getSessionBean();
		//返回提示
		Map<String, Object> model = new HashMap<String, Object>();
		try{
			dzService.crossOutDspAndTh(entity,sessionBean);
			model.put(AppConst.STATUS, AppConst.SUCCESS);
			model.put(AppConst.MESSAGES, "注销【"+entity.getMlphqc()+"】成功！");
			model.put(AppConst.SAVE_ID, entity.getMldzid());
		}catch(Exception e){
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, getUpdateFail());
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}
	/**
	 * @Title: doDeleteYqy 
	 * @描述: 已启用地址注销【有业务数据处理】
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2015-2-9 下午6:54:42 
	 * @返回值: ModelAndView    返回类型 
	 * @throws
	 */
	@RequestMapping(value = "/doDeleteYqy", method = RequestMethod.POST)
	public @ResponseBody ModelAndView doDeleteYqy(BzdzxxbVO entity){
		ModelAndView mv = new ModelAndView("redirect:/forward/"+ AppConst.FORWORD);
		SessionBean sessionBean = getSessionBean();
		//返回提示
		Map<String, Object> model = new HashMap<String, Object>();
		try{
			dzService.doDeleteYqy(entity,sessionBean);
			model.put(AppConst.STATUS, AppConst.SUCCESS);
			model.put(AppConst.MESSAGES, "注销【"+entity.getMlphqc()+"】成功！");
			model.put(AppConst.SAVE_ID, entity.getMldzid());
		}catch(Exception e){
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, getUpdateFail());
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}
	/**
	 * @Title: queryShDzList 
	 * @描述: 查询地址审核列表
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2015-2-5 下午2:33:34 
	 * @返回值: EasyUIPage    返回类型 
	 * @throws
	 */
	@RequestMapping(value = "/queryShDzList",method = RequestMethod.POST)
	public @ResponseBody EasyUIPage queryShDzList(EasyUIPage page,@RequestParam(value = "rows") Integer rows,BzdzxxbVO entity){
		page.setPagePara(rows);
		SessionBean sessionBean = getSessionBean();
		if(null != sessionBean){
			OrgOrganization userOrg = orgOrganizationService.queryById(sessionBean.getUserOrgId());
			String orglevel = userOrg.getOrglevel();
			if(("21").equals(orglevel)){
				entity.setFxjdm((String)sessionBean.getUserOrgCode());
			}else if("32".equals(orglevel)){
				entity.setPcsdm((String)sessionBean.getUserOrgCode());
			}else if("50".equals(orglevel)){
				entity.setZrqdm((String)sessionBean.getUserOrgCode());
			}
		}
		return dzService.queryShDzList(page, entity);
	}
	/**
	 * @Title: queryShDzCount 
	 * @描述: 查询地址审核列表总数
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2015-2-5 下午2:38:38 
	 * @返回值: long    返回类型 
	 * @throws
	 */
	@RequestMapping(value = "/queryShDzCount",method = RequestMethod.POST)
	public @ResponseBody long queryShDzCount(BzdzxxbVO entity){
		SessionBean sessionBean = getSessionBean();
		if(null != sessionBean){
			OrgOrganization userOrg = orgOrganizationService.queryById(sessionBean.getUserOrgId());
			String orglevel = userOrg.getOrglevel();
			if(("21").equals(orglevel)){
				entity.setFxjdm((String)sessionBean.getUserOrgCode());
			}else if("32".equals(orglevel)){
				entity.setPcsdm((String)sessionBean.getUserOrgCode());
			}else if("50".equals(orglevel)){
				entity.setZrqdm((String)sessionBean.getUserOrgCode());
			}
		}
		return dzService.queryShDzCount(entity);
	}
	/**
	 * @Title: queryZzjg 
	 * @描述: 查询组织机构信息（主要查询边界坐标，无公共方法）
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2015-2-6 上午10:07:11 
	 * @返回值: List<BzdzxxbVO>    返回类型 
	 * @throws
	 */
	@RequestMapping(value = "/queryZzjg", method = RequestMethod.POST)
	public @ResponseBody List<BzdzxxbVO> queryZzjg(String zzjgdm){
		return dzService.queryZzjg(zzjgdm);
	}
	/**
	 * @Title: createDzShAndXq 
	 * @描述: 创建地址审核或查看
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: MLDZID【门楼地址ID】、MAINTABID【列表tab标签ID】、TYPE【0为可编辑、1为只读】、dzChb【地址层户表 0为层户地址对象表、1为层户地址审核表】、chType层户结构 0为编辑、1为只读 
	 * @日期： 2015-2-6 下午2:39:04 
	 * @返回值: ModelAndView    返回类型 
	 * @throws
	 */
	@RequestMapping(value = "/createDzShAndXq", method = RequestMethod.GET)
    public ModelAndView createDzShAndXq(String mldzid,String mainTabID,String type,String dzChb,String chType){
		ModelAndView mv = new ModelAndView("bzdz/dzVerify/dzVerifyAndSee");
		//查询单条门楼地址详情数据
		BzdzxxbVO entity = dzService.queryMldzShXx(mldzid);
		List<BzdzxxbVO> dzBmArray = new ArrayList<BzdzxxbVO>();
		dzBmArray = dzService.queryDzbm(mldzid);
		if(dzBmArray.size() == 0){
			dzBmArray.add(new BzdzxxbVO());
		}
		mv.addObject("chType",chType);
		mv.addObject("type",type);
		mv.addObject("dzChb",dzChb);
		mv.addObject("entity", entity);
		mv.addObject("mainTabID", mainTabID);
		mv.addObject("dzBmArray",dzBmArray);
		mv.addObject("dzBmArrayLength",dzBmArray.size());
		return mv;
	}
	/**
	 * @Title: createUpdateAndXq 
	 * @描述: 已启用地址维护更新或详情
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: MLDZID【门楼地址ID】、MAINTABID【列表tab标签ID】、TYPE【0为可编辑、1为只读】、dzChb【地址层户表 0为层户地址对象表、1为层户地址审核表】, chType层户结构 0为编辑、1为只读  
	 * @日期： 2015-2-9 下午7:38:40 
	 * @返回值: ModelAndView    返回类型 
	 * @throws
	 */
	@RequestMapping(value = "/createUpdateAndXq", method = RequestMethod.GET)
    public ModelAndView createUpdateAndXq(String mldzid,String mainTabID,String type,String dzChb,String chType){
		ModelAndView mv = new ModelAndView("bzdz/dzManage/dzEdit");
		//查询单条门楼地址详情数据
		BzdzxxbVO entity = new BzdzxxbVO();
		if("1".equals(dzChb)){
			entity = dzService.queryMldzShXx(mldzid);
		}else{
			entity = dzService.queryMldzDx(mldzid);
		}		
		List<BzdzxxbVO> dzBmArray = new ArrayList<BzdzxxbVO>();
		dzBmArray = dzService.queryDzbm(mldzid);
		if(dzBmArray.size() == 0){
			dzBmArray.add(new BzdzxxbVO());
		}
		mv.addObject("dzChb",dzChb);
		mv.addObject("chType",chType);
		mv.addObject("type",type);
		mv.addObject("entity", entity);
		mv.addObject("mainTabID", mainTabID);
		mv.addObject("dzBmArray",dzBmArray);
		mv.addObject("dzBmArrayLength",dzBmArray.size());
		return mv;
	}
	/**
	 * @Title: updateSh 
	 * @描述: 更新审核地址
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2015-2-7 下午1:45:52 
	 * @返回值: ModelAndView    返回类型 
	 * @throws
	 */
	@RequestMapping(value = "/updateShzt", method = RequestMethod.POST)
	public @ResponseBody ModelAndView updateShzt(BzdzxxbVO entity){
		ModelAndView mv = new ModelAndView("redirect:/forward/"+ AppConst.FORWORD);
		SessionBean sessionBean = getSessionBean();
		//返回提示
		Map<String, Object> model = new HashMap<String, Object>();
		try{
			dzService.updateSh(entity,sessionBean);
			model.put(AppConst.STATUS, AppConst.SUCCESS);
			model.put(AppConst.MESSAGES, "审批【"+entity.getMlphqc()+"】成功！");
			model.put(AppConst.SAVE_ID, entity.getMldzid());
		}catch(Exception e){
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, "审批【"+entity.getMlphqc()+"】失败！");
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}
	/**
	 * @Title: queryChjg 
	 * @描述: 加载层户结构【对象层户】【服务接口】
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: dzChb【地址层户表 0为层户地址对象表、1为层户地址审核表】 
	 * @日期： 2015-2-7 下午5:29:25 
	 * @返回值: ModelAndView    返回类型 
	 * @throws
	 */
	@RestfulAnnotation(valiField="mldzid,",serverId="3")
	@RequestMapping(value = "/queryJzwChjg/{mldzid}", method = RequestMethod.GET)
	public @ResponseBody List<BzdzxxbVO> queryJzwChjg(BzdzxxbVO entity) throws RestException{
		entity.setDzChb("0");
		List<BzdzxxbVO> vo = dzService.queryJzwChjg(entity);
		if(vo.size()==0){
			throw new RestException("查无此层户结构信息！");
		}
		return vo;
	}
	/**
	 * @Title: queryJzwChjgSh 
	 * @描述: 加载层户结构【审核层户】【服务接口】
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: dzChb【地址层户表 0为层户地址对象表、1为层户地址审核表】 
	 * @日期： 2015-4-7 下午6:36:33 
	 * @返回值: List<BzdzxxbVO>    返回类型 
	 * @throws
	 */
	@RestfulAnnotation(valiField="mldzid,",serverId="3")
	@RequestMapping(value = "/queryJzwChjgSh/{mldzid}", method = RequestMethod.GET)
	public @ResponseBody List<BzdzxxbVO> queryJzwChjgSh(BzdzxxbVO entity) throws RestException{
		entity.setDzChb("1");
		List<BzdzxxbVO> vo = dzService.queryJzwChjg(entity);
		if(vo.size()==0){
			entity.setDzChb("0");
			vo =  dzService.queryJzwChjg(entity);
			if(vo.size()==0){
				throw new RestException("查无此层户结构信息！");
			}
		}
		return vo;
	}
	/**
	 * @Title: queryChShdz 
	 * @描述: 获取层户地址_【层户地址审核表】【服务接口】
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2015-2-9 下午3:35:36 
	 * @返回值: List<BzdzxxbVO>    返回类型 
	 * @throws
	 */
	@RestfulAnnotation(valiField="mldzid,",serverId="3")
	@RequestMapping(value = "/queryChShdz/{mldzid}",method = RequestMethod.GET)
	public @ResponseBody List<BzdzxxbVO> queryChShdz(BzdzxxbVO entity){
		return dzService.queryChShdz(entity);
	}
	/**
	 * @Title: queryChdzdxb 
	 * @描述: 获取层户地址_【层户地址对象表】【服务接口】
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2015-3-3 下午2:09:10 
	 * @返回值: List<BzdzxxbVO>    返回类型 
	 * @throws
	 */
	@RestfulAnnotation(valiField="mldzid,",serverId="3")
	@RequestMapping(value = "/queryChdzdxb/{mldzid}",method = RequestMethod.GET)
	public @ResponseBody List<BzdzxxbVO> queryChdzdxb(BzdzxxbVO entity) throws RestException{
		List<BzdzxxbVO> vo = dzService.queryChdzdxb(entity);
		if(vo.size()==0){
			throw new RestException("查无此层户地址信息！");
		}
		return vo;
	}
	/**
	 * @Title: updateMldz 
	 * @描述: 更新维护门楼地址【服务接口】
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2015-2-10 下午4:07:44 
	 * @返回值: ModelAndView    返回类型 
	 * @throws
	 */
	@RestfulAnnotation(valiField="mldzid,xzqhdm,xzqhmc,dmdm,dmmc,mlph,mlphhz,mlphhzmc",serverId="3")
	@RequestMapping(value = "/updateMldz", method = {RequestMethod.PUT,RequestMethod.POST})
	public @ResponseBody ModelAndView updateMldz(BzdzxxbVO entity,SessionBean sessionBean){
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		sessionBean = getSessionBean(sessionBean);
		//返回提示
		Map<String, Object> model = new HashMap<String, Object>();
		//判断门楼牌号名称
		if("".equals(entity.getMlphqc())||entity.getMlphqc()==null){
			String mlphqc = entity.getDmmc()+entity.getMlphqzmc()+entity.getMlph()+entity.getMlphhzmc();
			entity.setMlphqc(mlphqc);
		}
		//判断门楼地址是否存在
		List<BzdzxxbVO> mldzlist = new ArrayList<BzdzxxbVO>();
		mldzlist = dzService.queryMldzPd(entity);
		if(mldzlist.size()>0){
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, "维护【"+entity.getMlphqc()+"】失败，该地址已在【"+mldzlist.get(0).getXt_zhxgrbm()+"】存在！");
			model.put(AppConst.SAVE_ID, entity.getMldzid());
		}else{
			dzService.updateMldz(entity,sessionBean);
			model.put(AppConst.STATUS, AppConst.SUCCESS);
			model.put(AppConst.MESSAGES, "维护【"+entity.getMlphqc()+"】成功！");
			model.put(AppConst.SAVE_ID, entity.getMldzid());
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}
	/**
	 * @Title: dzBuilding 
	 * @描述: 查询建筑物层户结构
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: MLDZID为门楼地址ID 、TYPE(0为可编辑、1为只读),dzChb地址层户表 0为层户地址对象表、1为层户地址审核表 ,mainTabID 标签ID,、chType层户结构 0为编辑、1为只读
	 * @日期： 2015-3-2 下午2:23:58 
	 * @返回值: ModelAndView    返回类型 
	 * @throws
	 */
	@RequestMapping(value = "/dzBuilding", method = RequestMethod.GET)
    public ModelAndView dzBuilding(String mldzid,String type,String dzChb,String chType,String mainTabID){
		ModelAndView mv = new ModelAndView("bzdz/dzBuilding/dzBuilding");
		//查询单条门楼地址详情数据
		BzdzxxbVO entity = new BzdzxxbVO();
		if("1".equals(dzChb)){
			entity = dzService.queryMldzShXx(mldzid);
		}else{
			entity = dzService.queryMldzDx(mldzid);
		}
		mv.addObject("chType", chType);
		mv.addObject("mainTabID", mainTabID);
		mv.addObject("entity", entity);
		mv.addObject("mldzid", mldzid);
		mv.addObject("type", type);
		mv.addObject("dzChb", dzChb);
		return mv;
    }
	/**
	 * @Title: dzBuildingAdd 
	 * @描述: 建筑物层户结构【新建】
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2015-4-7 上午10:23:22 
	 * @返回值: ModelAndView    返回类型 
	 * @throws
	 */
	@RequestMapping(value = "/dzBuildingAdd", method = RequestMethod.GET)
	public ModelAndView dzBuildingAdd(String mldzid,String type,String dzChb,String chType,String mainTabID){
		ModelAndView mv = new ModelAndView("bzdz/dzBuilding/dzBuildingAdd");
		BzdzxxbVO entity = new BzdzxxbVO();
		if("1".equals(dzChb)){
			entity = dzService.queryMldzShXx(mldzid);
		}else{
			entity = dzService.queryMldzDx(mldzid);
		}
		//地址是否进行审核状态【系统配置】
		String bzdzSh = SystemConfig.getString("bzdzSh");
		mv.addObject("mainTabID", mainTabID);
		mv.addObject("chType", chType);
		mv.addObject("bzdzSh", bzdzSh);
		mv.addObject("entity", entity);
		mv.addObject("mldzid", mldzid);
		mv.addObject("type", type);
		mv.addObject("dzChb", dzChb);
		return mv;
	}
	/**
	 * @Title: updateDymc 
	 * @描述: 修改单元名称_【层户地址对象表】【服务接口】
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: MLDZID【门楼地址ID】、DYH【旧单元号】、NEWDYH【新单元号】、DYHLX【单元号类型】
	 * @日期： 2015-3-3 上午10:26:38 
	 * @返回值: ModelAndView  返回类型 
	 * @throws
	 */
	@RestfulAnnotation(valiField="mldzid,dyh,newdyh,dyhlx",serverId="3")
	@RequestMapping(value = "/updateDymc", method = RequestMethod.POST)
    public ModelAndView updateDymc(BzdzxxbVO entity,SessionBean sessionBean){
		ModelAndView mv = new ModelAndView("redirect:/forward/"+ AppConst.FORWORD);
		sessionBean = getSessionBean(sessionBean);
		//返回提示
		Map<String, Object> model = new HashMap<String, Object>();
		try{
			dzService.updateDymc(entity,sessionBean);
			model.put(AppConst.STATUS, AppConst.SUCCESS);
			model.put(AppConst.MESSAGES, "修改单元名称【"+entity.getNewdyh()+"】成功！");
			model.put(AppConst.SAVE_ID, entity.getMldzid());
		}catch(Exception e){
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, "修改单元名称【"+entity.getNewdyh()+"】失败！");
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
    }
	/**
	 * @Title: updateDycs 
	 * @描述: 修改单元层数_【层户地址对象表】【服务接口】
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: MLDZID【门楼地址ID】、DYH【单元号】、ZDLCS【旧楼层数】、NEWLCS【新楼层数】、DYHLX【单元号类型】、ZDHS【最大户数】
	 * @日期： 2015-3-4 上午9:33:23 
	 * @返回值: ModelAndView    返回类型 
	 * @throws
	 */
	@RestfulAnnotation(valiField="mldzid,dyh,zdlcs,newlcs,dyhlx,zdhs",serverId="3")
	@RequestMapping(value = "/updateDycs", method = RequestMethod.POST)
    public ModelAndView updateDycs(BzdzxxbVO entity,SessionBean sessionBean){
		ModelAndView mv = new ModelAndView("redirect:/forward/"+ AppConst.FORWORD);
		sessionBean = getSessionBean(sessionBean);
		//返回提示
		Map<String, Object> model = new HashMap<String, Object>();
		try{
			dzService.updateDycs(entity,sessionBean);
			model.put(AppConst.STATUS, AppConst.SUCCESS);
			model.put(AppConst.MESSAGES, "修改【"+entity.getDyh()+"】单元层数为【"+entity.getNewlcs()+"】成功！");
			model.put(AppConst.SAVE_ID, entity.getMldzid());
		}catch(Exception e){
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, "修改【"+entity.getDyh()+"】单元层数为【"+entity.getNewlcs()+"】失败！");
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
    }
	/**
	 * @Title: updateDyhs 
	 * @描述: 修改单元户数_【层户地址对象表】【服务接口】
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: MLDZID【门楼地址ID】、DYH【单元号】、ZDLCS【最大层数】、NEWHS【新户数】、DYHLX【单元号类型】
	 * @日期： 2015-3-4 下午4:22:59 
	 * @返回值: ModelAndView    返回类型 
	 * @throws
	 */
	@RestfulAnnotation(valiField="mldzid,dyh,zdlcs,newhs,dyhlx",serverId="3")
	@RequestMapping(value = "/updateDyhs", method = RequestMethod.POST)
    public ModelAndView updateDyhs(BzdzxxbVO entity,SessionBean sessionBean){
		ModelAndView mv = new ModelAndView("redirect:/forward/"+ AppConst.FORWORD);
		sessionBean = getSessionBean();
		//返回提示
		Map<String, Object> model = new HashMap<String, Object>();
		try{
			dzService.updateDyhs(entity,sessionBean);
			model.put(AppConst.STATUS, AppConst.SUCCESS);
			model.put(AppConst.MESSAGES, "修改【"+entity.getDyh()+"】单元户数为【"+entity.getNewhs()+"】成功！");
			model.put(AppConst.SAVE_ID, entity.getMldzid());
		}catch(Exception e){
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, "修改【"+entity.getDyh()+"】单元户数为【"+entity.getNewhs()+"】失败！");
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}
	/**
	 * @Title: updateDyLchs 
	 * @描述: 修改楼层户数【服务接口】
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: MLDZID【门楼地址ID】、DYH【单元号】、LCH【楼层号】、ZDHS【最大户数】、NEWHS【新户数】、DYHLX【单元号类型】
	 * @日期： 2015-3-5 上午10:13:44 
	 * @返回值: ModelAndView    返回类型 
	 * @throws
	 */
	@RestfulAnnotation(valiField="mldzid,dyh,lch,newhs,zdhs,dyhlx",serverId="3")
	@RequestMapping(value = "/updateDyLchs", method = RequestMethod.POST)
    public ModelAndView updateDyLchs(BzdzxxbVO entity,SessionBean sessionBean){
		ModelAndView mv = new ModelAndView("redirect:/forward/"+ AppConst.FORWORD);
		sessionBean = getSessionBean(sessionBean);
		//返回提示
		Map<String, Object> model = new HashMap<String, Object>();
		try{
			dzService.updateDyLchs(entity,sessionBean);
			model.put(AppConst.STATUS, AppConst.SUCCESS);
			model.put(AppConst.MESSAGES, "修改【"+entity.getDyh()+"】单元【"+entity.getLch()+"】层户数为【"+entity.getNewhs()+"】成功！");
			model.put(AppConst.SAVE_ID, entity.getMldzid());
		}catch(Exception e){
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, "修改【"+entity.getDyh()+"】单元【"+entity.getLch()+"】层户数为【"+entity.getNewhs()+"】失败！");
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}
	/**
	 * @Title: updateDyfjmc 
	 * @描述: 修改房间名称 【服务接口】
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: MLDZID【门楼地址ID】、DYH【单元号】、LCH【楼层号】、SH【室号】、NEWSH【新室号】、DYHLX【单元号类型】 
	 * @日期： 2015-3-5 下午2:49:24 
	 * @返回值: ModelAndView    返回类型 
	 * @throws
	 */
	@RestfulAnnotation(valiField="mldzid,dyh,lch,sh,newsh,dyhlx",serverId="3")
	@RequestMapping(value = "/updateDyfjmc", method = RequestMethod.POST)
    public ModelAndView updateDyfjmc(BzdzxxbVO entity,SessionBean sessionBean){
		ModelAndView mv = new ModelAndView("redirect:/forward/"+ AppConst.FORWORD);
		sessionBean = getSessionBean(sessionBean);
		//返回提示
		Map<String, Object> model = new HashMap<String, Object>();
		try{
			dzService.updateDyfjmc(entity,sessionBean);
			model.put(AppConst.STATUS, AppConst.SUCCESS);
			model.put(AppConst.MESSAGES, "修改【"+entity.getDyh()+"】单元，房间【"+entity.getSh()+"】名称为【"+entity.getNewsh()+"】成功！");
			model.put(AppConst.SAVE_ID, entity.getMldzid());
		}catch(Exception e){
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, "修改【"+entity.getDyh()+"】单元，房间【"+entity.getSh()+"】名称为【"+entity.getNewsh()+"】失败！");
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}
	/**
	 * @Title: queryMldzDx 
	 * @描述: 门楼地址查询【服务接口】
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: mldzid【门楼地址ID】
	 * @日期： 2015-3-20 上午10:54:29 
	 * @返回值: List<BzdzxxbVO>    返回类型 
	 * @throws
	 */
	@RestfulAnnotation(valiField="mldzid",serverId = "3")
	@RequestMapping(value = "/mldz/{mldzid}", method = RequestMethod.GET)
	public @ResponseBody BzdzxxbVO queryMldzDx(@PathVariable(value="mldzid")String mldzid) throws RestException{
		BzdzxxbVO vo = dzService.queryMldzDx(mldzid);
		if(vo==null){
			throw new RestException("查无此门楼地址信息！");
		}else{
			List<BzdzxxbVO> dzBmArray = dzService.queryDzbm(mldzid);
			String dzbm = "";
			for(int i=0;i<dzBmArray.size();i++){
				if(i==dzBmArray.size()-1){
					dzbm += dzBmArray.get(i).getDzbm();
				}else{
					dzbm += dzBmArray.get(i).getDzbm()+",";
				}
				
			}
			vo.setDzbm(dzbm);
		}
		return vo;
	}
	/**
	 * @Title: updateHouseHb 
	 * @描述: 合并保存事件【层户地址对象表】
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2015-4-10 下午3:33:48 
	 * @返回值: ModelAndView    返回类型 
	 * @throws
	 */
	@RequestMapping(value = "/updateHouseHb", method = RequestMethod.POST)
    public ModelAndView updateHouseHb(BzdzxxbVO entity,SessionBean sessionBean){
		ModelAndView mv = new ModelAndView("redirect:/forward/"+ AppConst.FORWORD);
		sessionBean = getSessionBean(sessionBean);
		//返回提示
		Map<String, Object> model = new HashMap<String, Object>();
		try{
			dzService.updateHouseHb(entity,sessionBean);
			model.put(AppConst.STATUS, AppConst.SUCCESS);
			model.put(AppConst.MESSAGES, "合并房间成功！");
			model.put(AppConst.SAVE_ID, entity.getMldzid());
		}catch(Exception e){
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, "合并房间失败！");
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
    }
	/**
	 * @Title: updateHouseQxHb 
	 * @描述: 取消合并保存事件【层户地址对象表】
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2015-4-11 下午5:02:33 
	 * @返回值: ModelAndView    返回类型 
	 * @throws
	 */
	@RequestMapping(value = "/updateHouseQxHb", method = RequestMethod.POST)
    public ModelAndView updateHouseQxHb(BzdzxxbVO entity,SessionBean sessionBean){
		ModelAndView mv = new ModelAndView("redirect:/forward/"+ AppConst.FORWORD);
		sessionBean = getSessionBean(sessionBean);
		//返回提示
		Map<String, Object> model = new HashMap<String, Object>();
		try{
			dzService.updateHouseQxHb(entity,sessionBean);
			model.put(AppConst.STATUS, AppConst.SUCCESS);
			model.put(AppConst.MESSAGES, "取消此房间合并关联成功！");
			model.put(AppConst.SAVE_ID, entity.getMldzid());
		}catch(Exception e){
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, "取消此房间合并关联失败！");
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
    }
	/**
	 * @Title: searchAddressMlph 
	 * @描述: 【门楼地址】全文检索【 服务接口】
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2015-4-13 上午10:09:02 
	 * @返回值: List<DzContextCombo>    返回类型 
	 * @throws
	 */
	@RestfulAnnotation(valiField="searchKey",serverId="3")
	@RequestMapping(value = "/searchAddressMlph", method = RequestMethod.POST)
    public @ResponseBody List<DzContextCombo> searchAddressMlph(DzContextCondition condition,SessionBean sessionBean) {
    	return dzService.searchAddressMlph(condition);
    }
    /**
     * @Title: searchAddressMlphXz 
     * @描述:【层户地址】全文检索【 服务接口】
     * @作者: zhang_guoliang@founder.com 
     * @参数: 传入参数定义 
     * @日期： 2015-4-13 上午10:28:23 
     * @返回值: List<DzContextCombo>    返回类型 
     * @throws
     */
	@RestfulAnnotation(valiField="id,searchKey",serverId="3")
	@RequestMapping(value = "/searchAddressMlphXz", method = RequestMethod.POST)
	public @ResponseBody List<DzContextCombo> searchAddressMlphXz(DzContextCondition condition,SessionBean sessionBean) {
		return dzService.searchAddressMlphXz(condition);
	}
	/**
	 * @Title: dzBuildingShow 
	 * @描述: 地址建筑物信息展现【层户结构】
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: mldzid 【门楼地址ID】、chdzid 【层户地址ID】、mainTabID【打开窗口ID】
	 * @日期： 2015-5-7 上午9:25:44 
	 * @返回值: ModelAndView    返回类型 
	 * @throws
	 */
	@RequestMapping(value = "/dzBuildingShow", method = RequestMethod.GET)
    public ModelAndView dzBuildingShow(String mldzid,String chdzid,String mainTabID){
		ModelAndView mv = new ModelAndView("bzdz/dzBuilding/dzBuildingShow");
		BzdzxxbVO entity = dzService.queryMldzDx(mldzid);
		mv.addObject("entity", entity);
		mv.addObject("mldzid", mldzid);
		mv.addObject("chdzid", chdzid);
		mv.addObject("mainTabID", mainTabID);
		return mv;
    }
	/**
	 * @Title: queryChdzdxbShow 
	 * @描述: 获取层户地址信息展现内容【此方法有统计_人口、单位信息】
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: mldzid 【门楼地址ID】
	 * @日期： 2015-5-7 下午2:46:10 
	 * @返回值: List<DzBuildingVO>    返回类型 
	 * @throws
	 */
	@RestfulAnnotation(valiField="mldzid,",serverId="3")
	@RequestMapping(value = "/queryChdzdxbShow/{mldzid}",method = RequestMethod.GET)
	public @ResponseBody List<DzBuildingVO> queryChdzdxbShow(@PathVariable(value = "mldzid") String mldzid) throws RestException{
		return dzService.queryChdzdxbShow(mldzid);
	}
	/**
	 * @Title: dzBuildingRoom 
	 * @描述: 跳转到房间展示信息
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: mldzid 【门楼地址ID】、chdzid 【层户地址ID】
	 * @日期： 2015-5-8 下午4:43:22 
	 * @返回值: ModelAndView    返回类型 
	 * @throws
	 */
	@RequestMapping(value = "/dzBuildingRoom", method = RequestMethod.GET)
    public ModelAndView dzBuildingRoom(String mldzid,String chdzid){
		ModelAndView mv = new ModelAndView("bzdz/dzBuilding/dzBuildingRoom");
		BzdzxxbVO entity = dzService.queryMldzDx(mldzid);
		mv.addObject("entity", entity);
		mv.addObject("mldzid", mldzid);
		mv.addObject("chdzid", chdzid);
		return mv;
    }
	/**
	 * @Title: queryDzTjList 
	 * @描述: 标准地址统计 
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2015-5-12 下午4:12:36 
	 * @返回值: EasyUIPage    返回类型 
	 * @throws
	 */
	@RequestMapping(value = "/queryDzTjList",method = RequestMethod.POST)
	public @ResponseBody EasyUIPage queryDzTjList(EasyUIPage page,@RequestParam(value = "rows",required=false) Integer rows,DzTjVO entity){
		page.setPagePara(rows);
		return dzService.queryDzTjList(page, entity);
	}
	/**
	 * @Title: queryDzTjList_export 
	 * @描述: 标准地址统计_导出
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: title 文件标题
     * @参数: field 显示字段
     * @参数: rows  行数据
	 * @日期： 2015-5-14 下午5:49:20 
	 * @返回值: void    返回类型 
	 * @throws
	 */
	@RequestMapping(value = "/queryDzTjList_export",method = RequestMethod.GET)
	public void queryDzTjList_export(String title,String field,DzTjVO entity,HttpServletResponse response){
		response.setContentType("application/binary;charset=UTF-8");
		try {
			ServletOutputStream outputStream = response.getOutputStream();
			String fileName = "标准地址统计";
			response.setHeader("Content-disposition", "attachment;filename="+new String(fileName.getBytes(),"ISO8859-1")+""+DateUtils.getSystemDateTimeCompactString()+".xlsx");
			List<Map<String, String>> rowlist = dzService.queryDzTjList_export(entity);
			String rows = JSONArray.fromObject(rowlist).toString();
			FileUtils.dateGridExportExcel(fileName,title,field,rows,outputStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}