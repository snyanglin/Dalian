package com.founder.syrkgl.controller;

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

import com.founder.bzdz.service.DzService;
import com.founder.bzdz.vo.DzXxbVO;
import com.founder.framework.annotation.RestfulAnnotation;
import com.founder.framework.base.controller.BaseController;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.components.AppConst;
import com.founder.framework.exception.RestException;
import com.founder.framework.organization.department.bean.OrgOrganization;
import com.founder.framework.organization.department.service.OrgOrganizationService;
import com.founder.framework.message.bean.SysMessage;
import com.founder.framework.message.dao.SysMessageDao;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.syrkgl.bean.RyRyjbxxb;
import com.founder.syrkgl.bean.SyrkSyrkxxzb;
import com.founder.syrkgl.service.RyRyjbxxbService;
import com.founder.syrkgl.service.SyrkSyrkxxzbService;
import com.founder.syrkgl.vo.SyrkAddVO;

import com.google.gson.Gson;

/******************************************************************************
 * @Package: [com.founder.syrkgl.controller.SyrkGlController.java]
 * @ClassName: [SyrkGlController]
 * @Description: [实有人口管理]
 * @Author: [hongguanjun]
 * @CreateDate: [2015-4-3 下午1:50:49]
 * @UpdateUser: [hongguanjun(如多次修改保留历史记录，增加修改记录)]
 * @UpdateDate: [2015-4-3 下午1:50:49，(如多次修改保留历史记录，增加修改记录)]
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]
 * @Version: [v1.0]
 */
@Controller
@RequestMapping(value = "syrkGl")
public class SyrkGlController extends BaseController {

	private Logger logger = Logger.getLogger(this.getClass());

	@Resource(name = "ryRyjbxxbService")
	private RyRyjbxxbService ryRyjbxxbService;

	@Resource(name = "syrkSyrkxxzbService")
	private SyrkSyrkxxzbService syrkSyrkxxzbService;

	@Resource(name = "dzService")
	private DzService dzService;

	@Resource(name = "orgOrganizationService")
	private OrgOrganizationService orgOrganizationService;
	
	@Resource(name = "sysMessageDao")
	private SysMessageDao sysMessageDao;
	/**
	 * @Title: query
	 * @Description: TODO(实有人口管理列表页面跳转)
	 * @param @return 设定文件
	 * @return ModelAndView 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/syrkGl", method = RequestMethod.GET)
	public ModelAndView syrkGl(String messageid ) {
		SysMessage sysmessage = new SysMessage();
		try{
			sysmessage.setId(Long.valueOf(messageid));
			sysMessageDao.upadate(sysmessage);
			}
			catch(Exception e){
				e.printStackTrace();
			}
		ModelAndView mv = new ModelAndView("syrkgl/syrkGl");
		return mv;
	}
	
	
	/**
	 * @Title: query
	 * @Description: TODO(实有人口管理列表页面)
	 * @param @return 设定文件
	 * @return ModelAndView 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/query", method = RequestMethod.GET)
	public ModelAndView query() {
		ModelAndView mv = new ModelAndView("syrkgl/syrkGlQuery");
		return mv;
	}

	/**
	 * @Title: queryList
	 * @描述: 查询实有人口管理列表数据【服务接口】
	 * @作者: zhang_guoliang@founder.com
	 * @参数: 传入参数定义
	 * @日期： 2015-4-14 上午11:18:01
	 * @返回值: EasyUIPage 返回类型
	 * @throws
	 */
	@RestfulAnnotation(serverId = "3")
	@RequestMapping(value = "/queryList", method = RequestMethod.POST)
	public @ResponseBody
	EasyUIPage queryList(EasyUIPage page,
			@RequestParam(value = "rows", required = false) Integer rows,
			SyrkSyrkxxzb entity, SessionBean sessionBean) {
		page.setPagePara(rows);
		sessionBean = getSessionBean(sessionBean);
		if (null != sessionBean) {
			OrgOrganization userOrg = orgOrganizationService
					.queryById(sessionBean.getUserOrgId());
			String orglevel = userOrg.getOrglevel();
			if (("21").equals(orglevel)) {
				entity.setGxfjdm((String) sessionBean.getUserOrgCode());
			} else if ("32".equals(orglevel)) {
				entity.setGxpcsdm((String) sessionBean.getUserOrgCode());
			} else if ("50".equals(orglevel)) {
				entity.setGxzrqdm((String) sessionBean.getUserOrgCode());
			}
		}
		return syrkSyrkxxzbService.queryList(entity, page);
	}

	/**
	 * @Title: querySyrk
	 * @描述: 实有人口查询列表数据【服务接口】
	 * @作者: zhang_guoliang@founder.com
	 * @参数: 传入参数定义
	 * @日期： 2015-4-15 上午10:05:19
	 * @返回值: EasyUIPage 返回类型
	 * @throws
	 */
	@RestfulAnnotation(serverId = "3")
	@RequestMapping(value = "/querySyrk", method = RequestMethod.POST)
	public @ResponseBody
	EasyUIPage querySyrk(EasyUIPage page,
			@RequestParam(value = "rows", required = false) Integer rows,
			SyrkSyrkxxzb entity, SessionBean sessionBean) {
		page.setPagePara(rows);
		return syrkSyrkxxzbService.querySyrk(entity, page);
	}

	/**
	 * @Title: querySyrkCount
	 * @描述: 查询实有人口查询列表数据总数【服务接口】
	 * @作者: zhang_guoliang@founder.com
	 * @参数: 传入参数定义
	 * @日期： 2015-4-15 上午10:19:43
	 * @返回值: long 返回类型
	 * @throws
	 */
	@RestfulAnnotation(serverId = "3")
	@RequestMapping(value = "/querySyrkCount", method = RequestMethod.POST)
	public @ResponseBody
	long querySyrkCount(SyrkSyrkxxzb entity, SessionBean sessionBean) {
		return syrkSyrkxxzbService.querySyrkCount(entity);
	}

	/**
	 * @Title: add
	 * @Description: TODO(实有人口新增)
	 * @param @param cyzjdm 证件种类
	 * @param @param zjhm 证件号码
	 * @param @param mainTabID 原页面主框架tab标签页ID
	 * @param @param invokeJSMethod 原页面回调JS方法名
	 * @param @param sessionBean
	 * @param @return 设定文件
	 * @return ModelAndView 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView add(String cyzjdm, String zjhm, String mainTabID,
			String invokeJSMethod, SessionBean sessionBean, String messageid) {
		// 这里修改兼容通过message打开
		try {
			SysMessage sysmessage = new SysMessage();
			sysmessage.setId(Long.valueOf(messageid));
			sysMessageDao.upadate(sysmessage);
		} catch (Exception e) {
			e.printStackTrace();
		}

		ModelAndView mv = new ModelAndView("syrkgl/syrkGlAdd");
		sessionBean = getSessionBean(sessionBean);
		RyRyjbxxb ryRyjbxxb = null;
		if (!StringUtils.isBlank(zjhm)) {
			if (StringUtils.isBlank(cyzjdm)) { // 有身份证号码传入，证件种类为空时默认为居民身份证
				cyzjdm = "111";
			}
			ryRyjbxxb = ryRyjbxxbService.dataApply(cyzjdm, zjhm, sessionBean);
			if (ryRyjbxxb == null) { // 复用无数据
				ryRyjbxxb = new RyRyjbxxb();
				ryRyjbxxb.setCyzjdm(cyzjdm);
				ryRyjbxxb.setZjhm(zjhm);
			}
		}
		mv.addObject("ryRyjbxxb", ryRyjbxxb);
		if (sessionBean != null) { // 取责任区空挂地址
			mv.addObject("pcsdm", sessionBean.getExtendValue("ssPcsCode"));
			mv.addObject("zrqdm", sessionBean.getUserOrgCode());
			String zrqdm = sessionBean.getUserOrgCode();
			DzXxbVO kgJt = dzService.queryHjdKgJt(zrqdm); // 空挂集体
			mv.addObject("kgJt", kgJt);
			DzXxbVO kgJm = dzService.queryHjdKgJm(zrqdm); // 空挂居民
			mv.addObject("kgJm", kgJm);
		}
		mv.addObject("mainTabID", mainTabID);
		mv.addObject("invokeJSMethod", invokeJSMethod);
		return mv;
	}

	/**
	 * @throws RestException
	 * @Title: save
	 * @Description: TODO(新增保存)
	 * @param @param entity
	 * @param @param sessionBean
	 * @param @return 设定文件
	 * @return ModelAndView 返回类型
	 * @throws
	 */
	@RestfulAnnotation(valiField = "syrkywlxdm,jbxx.cyzjdm,jbxx.zjhm,jbxx.xbdm,jbxx.xm,jbxx.csrq", serverId = "3")
	@RequestMapping(value = { "/save", "/{syrklx}/save" }, method = RequestMethod.POST)
	public ModelAndView save(SyrkAddVO syrkAddVO, SessionBean sessionBean)
			throws RestException {
		if (sessionBean != null
				&& !StringUtils.isBlank(sessionBean.getUserId())) {
			vilidateSaveSyrkLx(syrkAddVO);
		}
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		Map<String, Object> map = new HashMap<String, Object>();
		sessionBean = getSessionBean(sessionBean);
		try {
			String errorMessage = syrkSyrkxxzbService.isValidSyrkAdd(syrkAddVO,
					sessionBean);
			if (!StringUtils.isBlank(errorMessage)) {
				map.put(AppConst.STATUS, AppConst.FAIL);
				map.put(AppConst.MESSAGES, "实有人口新增失败：<br/><br/>" + errorMessage);
			} else {
				map.put(AppConst.STATUS, AppConst.SUCCESS);
				map.put(AppConst.MESSAGES, getAddSuccess());
				String syrkid = syrkSyrkxxzbService.syrkAdd(syrkAddVO,
						sessionBean);
				map.put(AppConst.SAVE_ID, syrkid); // 返回主键
				map.put("ryid", syrkAddVO.getJbxx().getId()); // 返回主键
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
			map.put(AppConst.STATUS, AppConst.FAIL);
			map.put(AppConst.MESSAGES, getAddFail());
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(map));
		return mv;
	}

	/**
	 * @throws RestException
	 * @Title: cancelSyrk
	 * @描述: 实有人口注销【服务接口】
	 * @作者: zhang_guoliang@founder.com
	 * @参数: 传入参数定义
	 * @日期： 2015-4-15 下午4:57:54
	 * @返回值: ModelAndView 返回类型
	 * @throws
	 */
	@RestfulAnnotation(valiField = "jbxx.id,syrkywlxdm", serverId = "3")
	@RequestMapping(value = { "/cancelSyrk", "/{syrklx}/cancel" }, method = RequestMethod.POST)
	public ModelAndView cancelSyrk(SyrkAddVO entity, SessionBean sessionBean)
			throws RestException {
		if (sessionBean != null
				&& !StringUtils.isBlank(sessionBean.getUserId())) {
			vilidateSaveSyrkLx(entity);
		}
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		Map<String, Object> map = new HashMap<String, Object>();
		sessionBean = getSessionBean(sessionBean);
		try {
			String message = syrkSyrkxxzbService
					.deleteSyrk(entity, sessionBean);
			if (StringUtils.isBlank(message)) {
				map.put(AppConst.STATUS, AppConst.SUCCESS);
				map.put(AppConst.MESSAGES, "注销成功！");
			} else {
				map.put(AppConst.STATUS, AppConst.FAIL);
				map.put(AppConst.MESSAGES, message);
			}

		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
			map.put(AppConst.STATUS, AppConst.FAIL);
			map.put(AppConst.MESSAGES, "注销失败！");
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(map));
		return mv;
	}

	private void vilidateSaveSyrkLx(SyrkAddVO syrkAddVO) throws RestException {
		String syrklx = syrkAddVO.getSyrkywlxdm();
		String exceptionStr = "";
		if ("1".equals(syrklx)) {
			if (syrkAddVO.getCzrk() == null)
				exceptionStr = "实有人口类型和对象类型传递错误";
			else if (StringUtils.isBlank(syrkAddVO.getCzrk().getSfrhyzdm()))
				exceptionStr = "是否人户一致必填";
			else if (StringUtils.isBlank(syrkAddVO.getCzrk().getJzd_xzqhdm()))
				exceptionStr = "居住地_行政区划代码必填";
			else if (StringUtils.isBlank(syrkAddVO.getCzrk().getJzd_mlpdm()))
				exceptionStr = "居住地_门楼牌代码必填";
			else if (StringUtils.isBlank(syrkAddVO.getCzrk().getJzd_mlpxz()))
				exceptionStr = "居住地_门楼牌详址必填";
			else if (StringUtils.isBlank(syrkAddVO.getCzrk().getJzd_dzid()))
				exceptionStr = "居住地_地址ID必填";
			else if (StringUtils.isBlank(syrkAddVO.getCzrk().getJzd_dzxz()))
				exceptionStr = "居住地_地址详址必填";
			else if (StringUtils.isBlank(syrkAddVO.getCzrk().getJzd_zbx()))
				exceptionStr = "居住地_坐标X必填";
			else if (StringUtils.isBlank(syrkAddVO.getCzrk().getJzd_zby()))
				exceptionStr = "居住地_坐标Y必填";
		} else if ("2".equals(syrklx)) {
			if (syrkAddVO.getJzrk() == null)
				exceptionStr = "实有人口类型和对象类型传递错误";
			else if (StringUtils.isBlank(syrkAddVO.getJzrk().getJzd_xzqhdm()))
				exceptionStr = "居住地_行政区划代码必填";
			else if (StringUtils.isBlank(syrkAddVO.getJzrk().getJzd_mlpdm()))
				exceptionStr = "居住地_门楼牌代码必填";
			else if (StringUtils.isBlank(syrkAddVO.getJzrk().getJzd_mlpxz()))
				exceptionStr = "居住地_门楼牌详址必填";
			else if (StringUtils.isBlank(syrkAddVO.getJzrk().getJzd_dzid()))
				exceptionStr = "居住地_地址ID必填";
			else if (StringUtils.isBlank(syrkAddVO.getJzrk().getJzd_dzxz()))
				exceptionStr = "居住地_地址详址必填";
			else if (StringUtils.isBlank(syrkAddVO.getJzrk().getJzd_zbx()))
				exceptionStr = "居住地_坐标X必填";
			else if (StringUtils.isBlank(syrkAddVO.getJzrk().getJzd_zby()))
				exceptionStr = "居住地_坐标Y必填";
			else if (StringUtils.isBlank(syrkAddVO.getJzrk().getJzlbdm()))
				exceptionStr = "寄住类别代码必填";
			else if (StringUtils.isBlank(syrkAddVO.getJzrk().getJz_ksrq01()))
				exceptionStr = "寄住_开始日期必填";
		} else if ("3".equals(syrklx)) {
			if (syrkAddVO.getLdrk() == null)
				exceptionStr = "实有人口类型和对象类型传递错误";
			else if (StringUtils.isBlank(syrkAddVO.getLdrk().getJzd_xzqhdm()))
				exceptionStr = "居住地_行政区划代码必填";
			else if (StringUtils.isBlank(syrkAddVO.getLdrk().getJzd_mlpdm()))
				exceptionStr = "居住地_门楼牌代码必填";
			else if (StringUtils.isBlank(syrkAddVO.getLdrk().getJzd_mlpxz()))
				exceptionStr = "居住地_门楼牌详址必填";
			else if (StringUtils.isBlank(syrkAddVO.getLdrk().getJzd_dzid()))
				exceptionStr = "居住地_地址ID必填";
			else if (StringUtils.isBlank(syrkAddVO.getLdrk().getJzd_dzxz()))
				exceptionStr = "居住地_地址详址必填";
			else if (StringUtils.isBlank(syrkAddVO.getLdrk().getJzd_zbx()))
				exceptionStr = "居住地_坐标X必填";
			else if (StringUtils.isBlank(syrkAddVO.getLdrk().getJzd_zby()))
				exceptionStr = "居住地_坐标Y必填";
			else if (StringUtils.isBlank(syrkAddVO.getLdrk().getZjzsydm()))
				exceptionStr = "暂（居）住事由必填";
		} else if ("4".equals(syrklx)) {
			if (syrkAddVO.getJwry() == null)
				exceptionStr = "实有人口类型和对象类型传递错误";
			else if (StringUtils.isBlank(syrkAddVO.getJwry().getJzd_xzqhdm()))
				exceptionStr = "居住地_行政区划代码必填";
			else if (StringUtils.isBlank(syrkAddVO.getJwry().getJzd_mlpdm()))
				exceptionStr = "居住地_门楼牌代码必填";
			else if (StringUtils.isBlank(syrkAddVO.getJwry().getJzd_mlpxz()))
				exceptionStr = "居住地_门楼牌详址必填";
			else if (StringUtils.isBlank(syrkAddVO.getJwry().getJzd_dzid()))
				exceptionStr = "居住地_地址ID必填";
			else if (StringUtils.isBlank(syrkAddVO.getJwry().getJzd_dzxz()))
				exceptionStr = "居住地_地址详址必填";
			else if (StringUtils.isBlank(syrkAddVO.getJwry().getJzd_zbx()))
				exceptionStr = "居住地_坐标X必填";
			else if (StringUtils.isBlank(syrkAddVO.getJwry().getJzd_zby()))
				exceptionStr = "居住地_坐标Y必填";
		} else if ("5".equals(syrklx)) {
			if (syrkAddVO.getWlrk() == null)
				exceptionStr = "实有人口类型和对象类型传递错误";
			else if (StringUtils.isBlank(syrkAddVO.getWlrk().getJzd_xzqhdm()))
				exceptionStr = "居住地_行政区划代码必填";
			else if (StringUtils.isBlank(syrkAddVO.getWlrk().getJzd_mlpdm()))
				exceptionStr = "居住地_门楼牌代码必填";
			else if (StringUtils.isBlank(syrkAddVO.getWlrk().getJzd_mlpxz()))
				exceptionStr = "居住地_门楼牌详址必填";
			else if (StringUtils.isBlank(syrkAddVO.getWlrk().getJzd_dzid()))
				exceptionStr = "居住地_地址ID必填";
			else if (StringUtils.isBlank(syrkAddVO.getWlrk().getJzd_dzxz()))
				exceptionStr = "居住地_地址详址必填";
			else if (StringUtils.isBlank(syrkAddVO.getWlrk().getJzd_zbx()))
				exceptionStr = "居住地_坐标X必填";
			else if (StringUtils.isBlank(syrkAddVO.getWlrk().getJzd_zby()))
				exceptionStr = "居住地_坐标Y必填";
			else if (StringUtils.isBlank(syrkAddVO.getWlrk().getWlhyydm()))
				exceptionStr = "未落户原因代码必填";
		}
		if (!StringUtils.isBlank(exceptionStr)) {
			throw new RestException(exceptionStr);
		}
	}

	/**
	 * @Title: queryListByRyidYwlx
	 * @描述: 根据RYID、实有人口业务类型查询列表
	 * @作者: zhang_guoliang@founder.com
	 * @参数: 传入参数定义
	 * @日期： 2015-4-24 下午6:38:46
	 * @返回值: List<SyrkSyrkxxzb> 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/queryListByRyidYwlx", method = RequestMethod.POST)
	public @ResponseBody
	List<SyrkSyrkxxzb> queryListByRyidYwlx(SyrkSyrkxxzb entity) {
		List<SyrkSyrkxxzb> listVo = syrkSyrkxxzbService
				.queryListByRyidYwlx(entity);
		return listVo;
	}
}