package com.founder.framework.login.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.founder.framework.base.controller.BaseController;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.components.AppConst;
import com.founder.framework.organization.user.bean.OrgUser;
import com.founder.framework.organization.user.service.OrgUserService;
import com.founder.framework.utils.DateUtils;
import com.founder.framework.utils.PropertitiesManagement;
import com.founder.framework.utils.StringUtils;

/******************************************************************************
 * @Package: [com.founder.framework.login.controller.LoginPage.java]
 * @ClassName: [LoginPage]
 * @Description: [单点登录服务器]
 * @CreateDate: [2014-07-02 上午10:28:46]
 * @UpdateUser: [liut]
 * @UpdateDate: [2014-07-02 上午10:28:46]
 * @UpdateRemark: [第一次创建]
 */
@Controller
@RequestMapping("/LoginPage")
public class LoginPageController extends BaseController {

	private final String loginView = "login";
	private final String mainView = PropertitiesManagement.getResouceString("mainPage"); // 业务主框架页面
//	private final String mainView = "mainbase/main"; // 基础管理主框架页面

	@Resource(name = "orgUserService")
	private OrgUserService orgUserService;

	@RequestMapping(value = "/login")
	public ModelAndView login(
			@RequestParam(value = "action", required = false) String action,
			HttpServletResponse response, OrgUser parentBiz, ModelMap model)
			throws IOException {
		// 设置兼容模式
		response.setHeader("X-UA-Compatible", "IE=EmulateIE8");
		if ("login".equals(action)) {
			model.addAttribute("userid", parentBiz.getUserid());
			OrgUser orgUser = orgUserService.queryByUserid(parentBiz.getUserid());
			if (orgUser == null) {
				orgUser = orgUserService.queryByIndustrialid(parentBiz.getUserid());
			}
			if (orgUser == null) {
				model.addAttribute(AppConst.ERRORS, super.getLoginUserNotExist());
				model.addAttribute("focus", "userid");
				return new ModelAndView(loginView, model);
			} else {
				String password = StringUtils.nullToStr(parentBiz.getPassword());
				if (!password.equals(orgUser.getPassword())) {
					model.addAttribute(AppConst.ERRORS, super.getLoginWrongPassowrd());
					model.addAttribute("focus", "password");
					return new ModelAndView(loginView, model);
				} else {
					SessionBean sessionBean = orgUserService.initSessionUser(orgUser);
					sessionBean.setRemoteAddr(super.getRequest().getRemoteAddr());
					super.getSession().setAttribute(AppConst.USER_SESSION,sessionBean);
					return new ModelAndView(mainView, model);
				}
			}
		} else if ("logout".equals(action)) {
			getSession().invalidate();
		} else if ("pki".equals(action)){
			model.addAttribute("userid", parentBiz.getUserid());
			OrgUser orgUser = orgUserService.queryByUserid(parentBiz.getUserid());
			if (orgUser == null) {
				orgUser = orgUserService.queryByIndustrialid(parentBiz.getUserid());
			}
			if (orgUser == null) {
				model.addAttribute(AppConst.ERRORS, super.getLoginUserNotExist());
				model.addAttribute("focus", "userid");
				return new ModelAndView(loginView, model);
			} else {
				SessionBean sessionBean = orgUserService.initSessionUser(orgUser);
				sessionBean.setRemoteAddr(super.getRequest().getRemoteAddr());
				super.getSession().setAttribute(AppConst.USER_SESSION,sessionBean);
				return new ModelAndView(mainView, model);
			}
		}
		
		return new ModelAndView(loginView);
	}

	@RequestMapping(value = "/getUser", method = RequestMethod.POST)
	public @ResponseBody
	OrgUser getUser(Long id) {
		OrgUser orgUser = new OrgUser();
		if (0 != id) {
			orgUser.setId(id);
			orgUser = orgUserService.query(orgUser);
		}

		return orgUser;
	}

	@RequestMapping(value = "/editUser", method = RequestMethod.POST)
	public @ResponseBody
	String editUser(OrgUser orgUser) {
		String returnValue = "";
		orgUser.setXt_zhxgsj(DateUtils.getSystemDateTimeString());
		orgUserService.updatePersonalMessage(orgUser, getSessionBean());
		returnValue = super.getUpdateSuccess();
		return returnValue;
	}

}
