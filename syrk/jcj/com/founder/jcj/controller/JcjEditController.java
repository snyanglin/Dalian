package com.founder.jcj.controller;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.founder.framework.annotation.RestfulAnnotation;
import com.founder.framework.base.controller.BaseController;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.components.AppConst;
import com.founder.framework.exception.BussinessException;
import com.founder.framework.utils.DateUtils;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.jcj.bean.JcjCjxxb;
import com.founder.jcj.bean.JcjCshpz;
import com.founder.jcj.bean.JcjFkxxb;
import com.founder.jcj.bean.JcjJjxxb;
import com.founder.jcj.bean.jcjSaveVo;
import com.founder.jcj.service.JcjEditService;
import com.founder.jcj.vo.JcjgnVO;
import com.founder.jcj.vo.JcjxxzsVO;

import com.google.gson.Gson;
import org.apache.commons.beanutils.MethodUtils;

/**
 * ****************************************************************************
 * 
 * @Package: [com.founder.jcj.controller.JcjEditController.java]
 * @ClassName: [JcjEditController]
 * @Description: [接处警控制器]
 * @Author: [weiwen]
 * @CreateDate: [2015-2-3 下午3:53:09]
 * @UpdateUser: [陈红彬]
 * @UpdateDate: [2015-2-3 下午3:53:09，(如多次修改保留历史记录，增加修改记录)]
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]
 * @Version: [v1.0]
 */
@Controller
@RequestMapping("jcj")
public class JcjEditController extends BaseController {

	private Logger logger = Logger.getLogger(this.getClass());

	@Resource(name = "jcjEditService")
	private JcjEditService jcjEditService;
    /**
     * 
     * @Title: view
     * @Description: TODO(进入 接处警编辑页面)
     * @param @param id
     * @param @param sfcx
     * @param @param mainTabID
     * @param @return
     * @param @throws BussinessException    设定文件
     * @return ModelAndView    返回类型
     * @throws
     */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public ModelAndView view(@RequestParam(value = "id") String id,
			@RequestParam(value = "sfcx") String sfcx,@RequestParam(value = "mainTabID",required=false) String mainTabID)
			throws BussinessException {
		ModelAndView mv = null;
		if ("1".equals(sfcx)) {
			mv = new ModelAndView("jcj/jcjEditCx");
		} else {
			mv = new ModelAndView("jcj/jcjEditCz");
		}
		JcjJjxxb entity = jcjEditService.queryJcjJjxxb(id);
		JcjCjxxb entity1 = new JcjCjxxb();
		if (entity != null) {
			entity1 = jcjEditService.queryJcjxxbById(entity.getJjbh());
			if (entity1 == null) {
				entity.setQszt("0");
			} else {
				entity.setQszt("1");
			}
		}
		mv.addObject("jcj", entity);
		mv.addObject("cj", entity1);
		mv.addObject("mainTabID", mainTabID);
		return mv;
	}

	/**
	 * 接处警查看编辑页面 展示配置信息查询
	 * 
	 * @param jcjlx
	 * @return
	 */
	@RequestMapping(value = "queryJcjzsxx", method = RequestMethod.POST)
	public @ResponseBody
	List<JcjxxzsVO> queryFwzsxx(@RequestParam(value = "jcjlx") String jcjlx) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("jcjlx", jcjlx);
		return jcjEditService.queryZsxx(map);
	}

	@RequestMapping(method = { RequestMethod.GET, RequestMethod.POST }, value = "/service/{method}")
	public @ResponseBody
	Map<String, Object> handleRequest(
			@PathVariable(value = "method") String methodName) throws Exception {
		Map<String, Object> params = getParams(super.getRequest());
		params.put("sessionBean", getSessionBean());
		Map<String, Object> model = new HashMap<String, Object>();
		if (methodName != null) {
			methodName += "_query";
			try {
				model.put("entity", MethodUtils.invokeMethod(jcjEditService,
						methodName, params));
				// model.put("fields",
				// getFieldDesc(MethodUtils.getAccessibleMethod(syrkService.getClass(),
				// methodName , Map.class)));
			} catch (NoSuchMethodException e) {
			} catch (InvocationTargetException inv) {
				throw new Exception(inv.getTargetException().getCause()
						.getLocalizedMessage(), inv.getTargetException()
						.getCause());
			}
		}
		return model;
	}

	private List<String> getFieldDesc(Class<?> clazz) {
		List<String> fieldList = new ArrayList<String>();
		for (Field f : clazz.getDeclaredFields()) {
			fieldList.add(f.getName());
		}
		return fieldList;
	}

	@SuppressWarnings("unused")
	private List<String> getFieldDesc(Method m) {
		Type type = m.getGenericReturnType();
		if (type instanceof ParameterizedType) {
			return getFieldDesc((Class<?>) ((ParameterizedType) type)
					.getActualTypeArguments()[0]);
		} else {
			return getFieldDesc(m.getReturnType());
		}
	}

	/**
	 * 业务办理与可增加信息查询
	 * 
	 * @param fwlxdm
	 * @param gnlxdm
	 *            1 ，2
	 * @return
	 */
	@RequestMapping(value = "/queryYwglgn", method = RequestMethod.POST)
	public @ResponseBody
	List<JcjgnVO> queryYwglgn(@RequestParam(value = "jcjlx") String jcjlx,
			String gnlxdm) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("jcjlx", jcjlx);
		map.put("gnlxdm", gnlxdm);
		return jcjEditService.queryYwglgn(map);
	}

	/**
	 * 跳转-实有接处警子项信息注销页面
	 * 
	 * @param url
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/delete_xxzsnrb", method = RequestMethod.GET)
	public ModelAndView delete_xxzsnrb(String url, String id) {
		ModelAndView mv = new ModelAndView("Jcj/JcjmessagEdit");
		mv.addObject("url", url);
		mv.addObject("id", id);
		return mv;
	}

	/**
	 * 注销实有接处警子项信息
	 * 
	 * @param url
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/calcle_xxzsnrb", method = RequestMethod.POST)
	public ModelAndView calcle_xxzsnrb(String url, String id, String xt_zxyy) {
		ModelAndView mv = new ModelAndView("redirect:/forward/"
				+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		Map<String, Object> map = new HashMap<String, Object>();
		if (sessionBean != null) {
			map.put("xt_zhxgrxm", sessionBean.getUserName());
			map.put("xt_zhxgrid", sessionBean.getUserId());
			map.put("xt_zhxgrbm", sessionBean.getUserOrgName());
			map.put("xt_zhxgrbmid", sessionBean.getUserOrgCode());
			map.put("xt_zhxgip", sessionBean.getRemoteAddr());
		}
		map.put("xt_zhxgsj", DateUtils.getSystemDateTimeString());
		map.put("url", url);
		map.put("id", id);
		map.put("xt_zxyy", xt_zxyy);
		try {
			jcjEditService.delete_xxzsnrb(map);
			model.put(AppConst.STATUS, AppConst.SUCCESS);
			model.put(AppConst.MESSAGES, getMessage("cancel.success"));
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, getMessage("cancel.fail"));
		}

		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}

	/**
	 * 
	 * @Title: queryJcjNoPt
	 * @Description: TODO(接处警列表查询)
	 * @param @param page
	 * @param @param rows
	 * @param @param entity
	 * @param @return 设定文件
	 * @return EasyUIPage 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/queryJcjNoPt", method = RequestMethod.POST)
	public @ResponseBody
	EasyUIPage queryJcjNoPt(EasyUIPage page,
			@RequestParam(value = "rows") Integer rows, JcjJjxxb entity) {
		page.setPagePara(rows);
		SessionBean sessionBean = getSessionBean();
		entity.setStationhousecode(sessionBean.getUserOrgCode());
		if (entity.getCurrrentDay() == null) {
			entity.setXt_lrsj(DateUtils.getSystemDateString());
		}
		return jcjEditService.queryJcjNoPt(page, entity);
	}

	/**
	 * 
	 * @Title: queryJjxx
	 * @Description: TODO(查询接警信息列表)
	 * @param @param page
	 * @param @param rows
	 * @param @param entity
	 * @param @param sessionBean
	 * @param @return 设定文件
	 * @return EasyUIPage 返回类型
	 * @throws
	 */
	@RestfulAnnotation(serverId = "3")
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public @ResponseBody
	EasyUIPage queryJjxx(EasyUIPage page,
			@RequestParam(value = "rows",required=false) Integer rows, JcjJjxxb entity,
			SessionBean sessionBean) {
		page.setPagePara(rows);
		sessionBean = getSessionBean(sessionBean);
		if(entity.getCurrrentDay() !=null && "1".equals(entity.getCurrrentDay())){
			entity.setCurrrentDay(DateUtils.getSystemDateString());
		}
		entity.setStationhousecode(sessionBean.getUserOrgCode());
		return jcjEditService.queryJcjNoPt(page, entity);
	}

	/**
	 * 
	 * @Title: saveCjxxb
	 * @Description: TODO(签收)
	 * @param @param entity
	 * @param @param sessionBean
	 * @param @return 设定文件
	 * @return ModelAndView 返回类型
	 * @throws
	 */
	@RestfulAnnotation(valiField = "jjbh,xzqhdm,orgseatno", serverId = "3")
	@RequestMapping(value = "/saveCjxxb", method = RequestMethod.POST)
	public @ResponseBody
	ModelAndView saveCjxxb(JcjCjxxb entity, SessionBean sessionBean) {
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		Map<String, Object> model = new HashMap<String, Object>();
		sessionBean = getSessionBean(sessionBean);
		try {
			entity.setQszt("1");
			entity.setJqztdm("03");
			entity.setCjdwdm(sessionBean.getUserOrgCode());
			entity.setCj_jybh(sessionBean.getUserId());
			entity.setCjy_xm(sessionBean.getUserName());
			jcjEditService.insertCjxxb(entity, sessionBean);
			model.put(AppConst.STATUS, AppConst.SUCCESS);
			model.put(AppConst.MESSAGES, "保存成功！");
			model.put(AppConst.SAVE_ID, entity.getId()); // 返回主键
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
	 * 
	 * @Title: addFkxxb
	 * @Description: TODO(跳转反馈页面)
	 * @param @param jjbh
	 * @param @param xzqhdm
	 * @param @param cjdbh
	 * @param @param id
	 * @param @return 设定文件
	 * @return ModelAndView 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/addFkxxb", method = RequestMethod.GET)
	public @ResponseBody
	ModelAndView addFkxxb(
			@RequestParam(required = true, value = "jjbh") String jjbh,
			@RequestParam(required = true, value = "xzqhdm") String xzqhdm,
			@RequestParam(required = true, value = "cjdbh") String cjdbh,
			String id) {
		JcjFkxxb entity = new JcjFkxxb();
		if (!StringUtils.isBlank(id)) {
			entity = jcjEditService.queryFkxxbById(id);
		} else {
			entity.setJjbh(jjbh);
			entity.setXzqhdm(xzqhdm);
			entity.setCjdbh(cjdbh);
		}
		ModelAndView mv = new ModelAndView("jcj/JcjFkxxb");
		mv.addObject("entity", entity);
		return mv;
	}

	/**
	 * 
	 * @Title: saveFkxxb
	 * @Description: TODO(反馈)
	 * @param @param entity
	 * @param @param sessionBean
	 * @param @return    设定文件
	 * @return ModelAndView    返回类型
	 * @throws
	 */
	@RestfulAnnotation(valiField = "jqlbdm,jqdjdm,jqfs_sj,jqjs_sj,ddxc_sj,clwb_sj,jqcl_jg,jjbh,cjdbh", serverId = "3")
	@RequestMapping(value = "/saveFkxxb", method = RequestMethod.POST)
	public ModelAndView saveFkxxb(JcjFkxxb entity, SessionBean sessionBean) {
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		Map<String, Object> model = new HashMap<String, Object>();
		sessionBean = getSessionBean(sessionBean);
		try {
			JcjFkxxb fkxxb = jcjEditService.queryFkxxbById(entity.getId());
			if (fkxxb == null) {
				entity.setFk_sj(DateUtils.getSystemDateTimeString());
				jcjEditService.insertFkxxb(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "保存成功！");
				model.put(AppConst.SAVE_ID, entity.getId()); // 返回主键
			} else {
				jcjEditService.updateFkxxb(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "修改成功！");
			}

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
	 * 
	 * @Title: saveCshpz
	 * @Description: TODO(初始化配置信息)
	 * @param @param vo
	 * @param @param sessionBean
	 * @param @return 设定文件
	 * @return ModelAndView 返回类型
	 * @throws
	 */
	@RestfulAnnotation(valiField = "district,msgid,msgtype,ip", serverId = "3")
	@RequestMapping(value = "/addCshpz", method = { RequestMethod.POST,
			RequestMethod.PUT })
	public @ResponseBody
	ModelAndView saveCshpz(JcjCshpz vo, SessionBean sessionBean) {
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		Map<String, Object> model = new HashMap<String, Object>();
		sessionBean = getSessionBean(sessionBean);
		try {
			JcjCshpz jcjcshpz = jcjEditService.queryCshpzByXzqh(vo
					.getDistrict());
			if (jcjcshpz == null) {
				String currentTime = DateUtils.getSystemDateString();
				jcjEditService.insertCshpzb(vo, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, super.getAddSuccess());
				model.put(AppConst.SAVE_ID, vo.getId()); // 返回主键
			} else {
				jcjEditService.updateCshpzb(vo, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "保存成功！");
			}
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage(), e);
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, getAddFail());
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}

	/**
	 * 
	 * @Title: saveJjxxb
	 * @Description: TODO(接处警新增)
	 * @param @param vo
	 * @param @param sessionBean
	 * @param @return 设定文件
	 * @return ModelAndView 返回类型
	 * @throws
	 */
	@RestfulAnnotation(valiField = "jjbh,bj_sj,stationhousecode", serverId = "3")
	@RequestMapping(value = { "/addJjxx"}, method = { RequestMethod.POST })
	public @ResponseBody
	ModelAndView saveJjxxb(JcjJjxxb vo, SessionBean sessionBean) {
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		Map<String, Object> model = new HashMap<String, Object>();
		sessionBean = getSessionBean(sessionBean);
		try {

			Map<String, String> lhlxdmMap = new HashMap<String, String>();// 来话类型代码
			lhlxdmMap.put("U0046_1", "01");
			lhlxdmMap.put("U0046_2", "02");
			lhlxdmMap.put("U0046_3", "06");
			lhlxdmMap.put("U0046_4", "03");
			lhlxdmMap.put("U0046_5", "98");
			lhlxdmMap.put("U0046_6", "99");
			lhlxdmMap.put("U0046_7", "99");
			lhlxdmMap.put("U0046_8", "99");
			lhlxdmMap.put("U0046_9", "05");
			lhlxdmMap.put("U0046_10", "99");
			lhlxdmMap.put("U0046_11", "04");
			vo.setLhlxdm(lhlxdmMap.get(vo.getLhlxdm()));

			Map<String, String> jqlbdmMap = new HashMap<String, String>();// 警情类别代码
			jqlbdmMap.put("U00400155", "030000");
			jqlbdmMap.put("U00400156", "040000");
			jqlbdmMap.put("U00400101", "010000");
			jqlbdmMap.put("U00400102", "020000");
			jqlbdmMap.put("U00400103", "050000");
			jqlbdmMap.put("U00400104", "090000");
			jqlbdmMap.put("U00400105", "060000");
			jqlbdmMap.put("U00400106", "070000");
			jqlbdmMap.put("U00400107", "060000");
			jqlbdmMap.put("U00400108", "080000");
			jqlbdmMap.put("U00400109", "990000");
			jqlbdmMap.put("U00400110", "990000");
			vo.setJqlbdm(jqlbdmMap.get(vo.getJqlbdm()));

			Map<String, String> bjfsdmMap = new HashMap<String, String>();// 报警方式
			bjfsdmMap.put("1", "04");
			bjfsdmMap.put("2", "99");
			bjfsdmMap.put("8", "01");
			bjfsdmMap.put("4", "02");
			bjfsdmMap.put("5", "03");
			bjfsdmMap.put("6", "09");
			bjfsdmMap.put("7", "99");
			bjfsdmMap.put("0", "02");
			vo.setBjfsdm(bjfsdmMap.get(vo.getBjfsdm()));

			Map<String, String> JqlxxlMap = new HashMap<String, String>();// 警情类型细类
			JqlxxlMap.put("U00400105_1", "069900");
			JqlxxlMap.put("U00400105_2", "060102");
			JqlxxlMap.put("U00400105_3", "070500");
			JqlxxlMap.put("U00400106_1", "070100");
			JqlxxlMap.put("U00400106_2", "070300");
			JqlxxlMap.put("U00400106_3", "070300");
			JqlxxlMap.put("U00400106_4", "070700");
			JqlxxlMap.put("U00400107_1", "079900");
			JqlxxlMap.put("U00400107_2", "079900");
			JqlxxlMap.put("U00400108_1", "089900");
			JqlxxlMap.put("U00400108_2", "080600");
			JqlxxlMap.put("U00400109_1", "990000");
			JqlxxlMap.put("U00400109_2", "990000");
			JqlxxlMap.put("U00400109_3", "990000");
			JqlxxlMap.put("U00400101_1", "011000");
			JqlxxlMap.put("U00400101_2", "010900");
			JqlxxlMap.put("U00400101_3", "011200");
			JqlxxlMap.put("U00400101_4", "011300");
			JqlxxlMap.put("U00400101_5", "011100");
			JqlxxlMap.put("U00400101_6", "019900");
			JqlxxlMap.put("U00400101_7", "010600");
			JqlxxlMap.put("U00400101_8", "010500");
			JqlxxlMap.put("U00400101_9", "010509");
			JqlxxlMap.put("U00400101_10", "080102");
			JqlxxlMap.put("U00400101_11", "019900");
			JqlxxlMap.put("U00400101_12", "010700");
			JqlxxlMap.put("U00400101_13", "010101");
			JqlxxlMap.put("U00400101_14", "010200");
			JqlxxlMap.put("U00400101_15", "010802");
			JqlxxlMap.put("U00400101_16", "010804");
			JqlxxlMap.put("U00400101_17", "080103");
			JqlxxlMap.put("U00400101_18", "010103");
			JqlxxlMap.put("U00400101_19", "011502");
			JqlxxlMap.put("U00400101_20", "010401");
			JqlxxlMap.put("U00400101_21", "010403");
			JqlxxlMap.put("U00400101_22", "080106");
			JqlxxlMap.put("U00400101_23", "019900");
			JqlxxlMap.put("U00400101_24", "019900");
			JqlxxlMap.put("U00400101_25", "019900");
			JqlxxlMap.put("U00400101_26", "019900");
			JqlxxlMap.put("U00400101_27", "019900");
			JqlxxlMap.put("U00400101_28", "019900");
			JqlxxlMap.put("U00400101_29", "019900");
			JqlxxlMap.put("U00400101_30", "019900");
			JqlxxlMap.put("U00400101_31", "019900");
			JqlxxlMap.put("U00400101_32", "019900");
			JqlxxlMap.put("U00400102_1", "020108");
			JqlxxlMap.put("U00400102_2", "020200");
			JqlxxlMap.put("U00400102_3", "011100");
			JqlxxlMap.put("U00400102_4", "011200");
			JqlxxlMap.put("U00400102_5", "011300");
			JqlxxlMap.put("U00400102_6", "080106");
			JqlxxlMap.put("U00400102_7", "011501");
			JqlxxlMap.put("U00400102_8", "020500");
			JqlxxlMap.put("U00400102_9", "080102");
			JqlxxlMap.put("U00400102_10", "011103");
			JqlxxlMap.put("U00400102_11", "029900");
			JqlxxlMap.put("U00400102_12", "011701");
			JqlxxlMap.put("U00400102_13", "060102");
			JqlxxlMap.put("U00400102_14", "011400");
			JqlxxlMap.put("U00400102_15", "021300");
			JqlxxlMap.put("U00400102_16", "050105");
			JqlxxlMap.put("U00400102_17", "050105");
			JqlxxlMap.put("U00400102_18", "080103");
			JqlxxlMap.put("U00400102_19", "080104");
			JqlxxlMap.put("U00400102_20", "011106");
			JqlxxlMap.put("U00400102_21", "021203");
			JqlxxlMap.put("U00400102_22", "029900");
			JqlxxlMap.put("U00400102_23", "029900");
			JqlxxlMap.put("U00400102_24", "020100");
			JqlxxlMap.put("U00400102_25", "020101");
			JqlxxlMap.put("U00400102_26", "020104");
			JqlxxlMap.put("U00400102_27", "029900");
			JqlxxlMap.put("U00400102_28", "020214");
			JqlxxlMap.put("U00400102_29", "010803");
			JqlxxlMap.put("U00400102_30", "020900");
			JqlxxlMap.put("U00400102_31", "029900");
			JqlxxlMap.put("U00400102_32", "021202");
			JqlxxlMap.put("U00400102_33", "010804");
			JqlxxlMap.put("U00400102_34", "029900");

			JqlxxlMap.put("U00400102_35", "020600");
			JqlxxlMap.put("U00400102_36", "029900");
			JqlxxlMap.put("U00400102_37", "029900");
			JqlxxlMap.put("U00400102_38", "029900");
			JqlxxlMap.put("U00400102_39", "029900");
			JqlxxlMap.put("U00400103_1", "050801");
			JqlxxlMap.put("U00400103_2", "059900");
			JqlxxlMap.put("U00400103_3", "059900");
			JqlxxlMap.put("U00400103_4", "050199");
			JqlxxlMap.put("U00400103_5", "059900");
			JqlxxlMap.put("U00400103_6", "059900");
			JqlxxlMap.put("U00400103_7", "059900");
			JqlxxlMap.put("U00400103_8", "059900");
			JqlxxlMap.put("U00400103_9", "050105");

			JqlxxlMap.put("U00400103_10", "050101");
			JqlxxlMap.put("U00400103_11", "059900");
			JqlxxlMap.put("U00400103_12", "059900");
			JqlxxlMap.put("U00400104_1", "051100");
			JqlxxlMap.put("U00400104_2", "091303");
			JqlxxlMap.put("U00400104_3", "091000");
			JqlxxlMap.put("U00400104_4", "090700");
			JqlxxlMap.put("U00400104_5", "990000");
			JqlxxlMap.put("U00400104_6", "990000");
			JqlxxlMap.put("U00400104_7", "990000");
			JqlxxlMap.put("U00400104_8", "990000");

			JqlxxlMap.put("U00400110_01", "990000");
			JqlxxlMap.put("U00400108_99", "089900");
			JqlxxlMap.put("U00400107_03", "069900");
			JqlxxlMap.put("U00400107_04", "060301");

			JqlxxlMap.put("U00400107_05", "060302");
			JqlxxlMap.put("U00400107_99", "069900");
			JqlxxlMap.put("U00400106_99", "079900");
			JqlxxlMap.put("U00400105_99", "069900");
			JqlxxlMap.put("U00400104_99", "990000");
			JqlxxlMap.put("U00400103_13", "059900");
			JqlxxlMap.put("U00400105_4", "011503");
			vo.setJqlxdm(JqlxxlMap.get(vo.getJqlxdm()));
			vo.setJqxldm(JqlxxlMap.get(vo.getJqxldm()));
			String currentTime = DateUtils.getSystemDateString();
			vo.setRk_sj(currentTime);
			vo.setGx_sj(currentTime);
			vo.setJjlxdm("01");
			jcjEditService.insertJjxxb(vo, sessionBean);
			model.put(AppConst.STATUS, AppConst.SUCCESS);
			model.put(AppConst.MESSAGES, "新增【接警信息】成功！");
			model.put(AppConst.SAVE_ID, vo.getId()); // 返回主键
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage(), e);
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, getAddFail());
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}

	/**
	 * 跳转自接警登记页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/addZjjxxb", method = RequestMethod.GET)
	public @ResponseBody
	ModelAndView addZjjxxb() {
		ModelAndView mv = new ModelAndView("jcj/JcjZjjdj");
		return mv;
	}

	/**
	 * 
	 * @Title: saveZdjxx
	 * @Description: TODO(自接警新增数据)
	 * @param @param entity
	 * @param @return 设定文件
	 * @return ModelAndView 返回类型
	 * @throws
	 */
	@RestfulAnnotation(valiField = "jcjfkxxb.jqlbdm,jcjfkxxb.jqdjdm,jcjfkxxb.jqfs_sj,jcjfkxxb.jqjs_sj,jcjfkxxb.ddxc_sj,jcjfkxxb.clwb_sj,jcjfkxxb.jqcl_jg,jcjjjxxb.jjlxdm,jcjjjxxb.bjfsdm,jcjjjxxb.bjnr,jcjjjxxb.bjr_xbdm,jcjjjxxb.bj_sj,jcjjjxxb.jqdzms,jcjjjxxb.jqdzxz,", serverId = "3")
	@RequestMapping(value = "/saveZdjxx", method = RequestMethod.POST)
	public ModelAndView saveZdjxx(jcjSaveVo entity, SessionBean sessionBean) {
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		Map<String, Object> model = new HashMap<String, Object>();
		sessionBean = getSessionBean(sessionBean);
		try {
			jcjEditService.sqveZjjxx(entity, sessionBean);
			model.put(AppConst.STATUS, AppConst.SUCCESS);
			model.put(AppConst.MESSAGES, "保存成功！");
			model.put(AppConst.SAVE_ID, entity.getJcjjjxxb().getId()); // 返回主键
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
	 * 
	 * @Title: queryJjxx
	 * @Description: TODO(查询接警信息)
	 * @param @param id
	 * @param @return
	 * @param @throws BussinessException 设定文件
	 * @return ModelAndView 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/queryJjxx", method = RequestMethod.GET)
	public ModelAndView queryJjxx(@RequestParam(value = "id") String id)
			throws BussinessException {
		ModelAndView mv = new ModelAndView("message/sysDtjqMessageView");
		JcjJjxxb entity = jcjEditService.queryJcjJjxxb(id);
		SessionBean sessionBean = getSessionBean();
		entity.setGxdwmc(sessionBean.getUserOrgName());
		mv.addObject("jcj", entity);
		return mv;
	}

	/**
	 * 
	 * @Title: querySyDtjqxx
	 * @Description: TODO(查询首页动态警情信息【内部】)
	 * @param @return 设定文件
	 * @return ModelAndView 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/querySyDtjqxx", method = RequestMethod.GET)
	public @ResponseBody
	ModelAndView querySyDtjqxx() {
		ModelAndView mv = new ModelAndView("main/firstPage_DtjqMessage");
		SessionBean sessionBean = getSessionBean();
		JcjJjxxb jcjjjxxb = new JcjJjxxb();
		jcjjjxxb.setStationhousecode(sessionBean.getUserOrgCode());
		jcjjjxxb.setXt_lrsj(DateUtils.getSystemDateString());
		jcjjjxxb.setRownum("8");
		List<JcjJjxxb> msgList = jcjEditService.queryJcjjjxxb(jcjjjxxb);
		mv.addObject("dtjqMessage", msgList);
		mv.addObject("userorgcode", sessionBean.getUserOrgCode());
		return mv;
	}

}
