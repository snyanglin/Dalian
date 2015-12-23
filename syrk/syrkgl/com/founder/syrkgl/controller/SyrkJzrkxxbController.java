package com.founder.syrkgl.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.founder.framework.annotation.RestfulAnnotation;
import com.founder.framework.base.controller.BaseController;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.components.AppConst;
import com.founder.framework.exception.BussinessException;
import com.founder.framework.message.bean.SysMessage;
import com.founder.framework.message.dao.SysMessageDao;
import com.founder.framework.utils.StringUtils;
import com.founder.syrkgl.bean.SyrkJzrkxxb;
import com.founder.syrkgl.service.SyrkJzrkxxbService;

import com.google.gson.Gson;

/******************************************************************************
 * @Package: [com.founder.syrkgl.controller.SyrkJzrkxxbController.java]
 * @ClassName: [SyrkJzrkxxbController]
 * @Description: [寄住人口信息表]
 * @Author: [hongguanjun]
 * @CreateDate: [2015-4-14 下午7:29:26]
 * @UpdateUser: [hongguanjun(如多次修改保留历史记录，增加修改记录)]
 * @UpdateDate: [2015-4-14 下午7:29:26，(如多次修改保留历史记录，增加修改记录)]
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]
 * @Version: [v1.0]
 */
@Controller
@RequestMapping(value = "syrkJzrkxxb")
public class SyrkJzrkxxbController extends BaseController {

	private Logger logger = Logger.getLogger(this.getClass());

	@Resource(name = "syrkJzrkxxbService")
	private SyrkJzrkxxbService syrkJzrkxxbService;
	@Resource
	private SysMessageDao sysMessageDao;

	/**
	 * @Title: edit
	 * @Description: TODO(编辑页面)
	 * @param @param id
	 * @param @return
	 * @param @throws BussinessException 设定文件
	 * @return ModelAndView 返回类型
	 * @throws
	 */

	@RestfulAnnotation(serverId = "3")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ModelAndView edit(@PathVariable(value = "id") String id,
			SessionBean sessionBean, String messageid) throws BussinessException {
		// 这里修改兼容通过message打开
		if(!StringUtils.isBlank(messageid)){
			SysMessage sysmessage = new SysMessage();
			sysmessage.setId(Long.valueOf(messageid));
			sysMessageDao.upadate(sysmessage);
		} 
		if (sessionBean != null
				&& !StringUtils.isBlank(sessionBean.getUserName())) { // 服务调用
			ModelAndView mv = new ModelAndView(getViewName(sessionBean));
			SyrkJzrkxxb jzrk = syrkJzrkxxbService.queryById(id);
			if (jzrk == null) {
				throw new BussinessException("查询无数据！");
			}
			mv.addObject(AppConst.MESSAGES, new Gson().toJson(jzrk));
			return mv;
		} else {
			ModelAndView mv = new ModelAndView("syrkgl/syrkJzrkxxb");
			SyrkJzrkxxb jzrk = syrkJzrkxxbService.queryById(id);
			if (jzrk == null) {
				throw new BussinessException("查询无数据！");
			}
			if (sessionBean != null) {
				mv.addObject("pcsdm", sessionBean.getExtendValue("ssPcsCode"));
				mv.addObject("zrqdm", sessionBean.getUserOrgCode());
			}
			mv.addObject("jzrk", jzrk);
			return mv;
		}
	}

	/**
	 * @Title: update
	 * @Description: TODO(修改保存)
	 * @param @param entity
	 * @param @param sessionBean
	 * @param @return 设定文件
	 * @return ModelAndView 返回类型
	 * @throws
	 */
	@RestfulAnnotation(valiField = "id,ryid", serverId = "3")
	@RequestMapping(value = "/{id}", method = { RequestMethod.POST,
			RequestMethod.PUT })
	public ModelAndView update(SyrkJzrkxxb entity, SessionBean sessionBean) {
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		Map<String, Object> map = new HashMap<String, Object>();
		sessionBean = getSessionBean(sessionBean);
		try {
			syrkJzrkxxbService.update(entity, sessionBean);
			map.put(AppConst.STATUS, AppConst.SUCCESS);
			map.put(AppConst.MESSAGES, getUpdateSuccess());
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
			map.put(AppConst.STATUS, AppConst.FAIL);
			map.put(AppConst.MESSAGES, getUpdateFail());
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(map));
		return mv;
	}

}
