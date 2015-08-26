package com.founder.zafffwqz.controller;

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

import org.apache.commons.beanutils.MethodUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.founder.framework.base.controller.BaseController;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.components.AppConst;
import com.founder.framework.exception.BussinessException;
import com.founder.framework.utils.DateUtils;
import com.founder.zafffwqz.bean.Sqjwsxxb;
import com.founder.zafffwqz.bean.Sqjwszrqglxxb;
import com.founder.zafffwqz.service.SqjwsxxbService;
import com.founder.zafffwqz.service.ZaffEditService;
import com.founder.zafffwqz.vo.ZaffgnVO;
import com.founder.zafffwqz.vo.ZaffxxzsVO;

import com.google.gson.Gson;

/**
 * 治安防范查看编辑页面控制器
 * 
 * @author Administrator
 * 
 */
@Controller
@RequestMapping("/zaffgl")
public class ZaffEditController extends BaseController {

	private Logger logger = Logger.getLogger(this.getClass());

	@Resource(name = "zaffEditService")
	private ZaffEditService zaffEditService;
	@Resource(name = "sqjwsxxbService")
	private SqjwsxxbService sqjwsxxbService;

	/**
	 * 单位查看编辑页面
	 * 
	 * @param id
	 * @return
	 * @throws BussinessException
	 */
	@RequestMapping(value = "view", method = { RequestMethod.GET,
			RequestMethod.POST })
	public ModelAndView view() throws BussinessException {
		ModelAndView mv;
		
		String zrqdm = getSessionBean().getUserOrgCode();
		Sqjwszrqglxxb sqjwszrqglxxb = new Sqjwszrqglxxb();
		sqjwszrqglxxb.setZrqdm(zrqdm);
		sqjwszrqglxxb = sqjwsxxbService.queryByZrqdm(sqjwszrqglxxb);

		if (sqjwszrqglxxb == null) {
			mv = new ModelAndView("/zafffwqz/sqjwsxxbAdd");
		} else {
			Sqjwsxxb entity = zaffEditService.querySqjwsxxbById(sqjwszrqglxxb
					.getSqjwsid());
			mv = new ModelAndView("zafffwqz/zaffEdit");
			logger.info("查看警务室:" + entity.getJwsmc());
			mv.addObject("entity", entity);
		}

		return mv;
	}

	@RequestMapping(value = "queryJwszsxx", method = RequestMethod.POST)
	public @ResponseBody
	List<ZaffxxzsVO> queryJwszsxx() {
		Map<String, Object> map = new HashMap<String, Object>();
		return zaffEditService.queryJwszsxx(map);
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
				model.put("entity", MethodUtils.invokeMethod(zaffEditService,
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
	 * @param sydwlx
	 * @param gnlxdm
	 *            1 ，2
	 * @return
	 */
	@RequestMapping(value = "/queryYwglgn", method = RequestMethod.POST)
	public @ResponseBody
	List<ZaffgnVO> queryYwglgn(String gnlxdm) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("gnlxdm", gnlxdm);
		return zaffEditService.queryYwglgn(map);
	}

	/**
	 * 跳转-治安防范子项信息注销页面
	 * 
	 * @param url
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/delete_xxzsnrb", method = RequestMethod.GET)
	public ModelAndView delete_xxzsnrb(String url, String id) {
		ModelAndView mv = new ModelAndView("sydw/sydwmessagEdit");
		mv.addObject("url", url);
		mv.addObject("id", id);
		return mv;
	}

	/**
	 * 注销实有单位子项信息
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
			zaffEditService.delete_xxzsnrb(map);
			model.put(AppConst.STATUS, AppConst.SUCCESS);
			model.put(AppConst.MESSAGES, "注销成功！");
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, "注销失败！");
		}

		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}
}
