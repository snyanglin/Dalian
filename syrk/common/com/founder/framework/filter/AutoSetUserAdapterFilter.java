package com.founder.framework.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.jasig.cas.client.validation.Assertion;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.components.AppConst;
import com.founder.framework.organization.user.bean.OrgUser;
import com.founder.framework.organization.user.service.OrgUserService;

public class AutoSetUserAdapterFilter implements Filter {

	private OrgUserService orgUserService;

	/**
	 * Default constructor.
	 */
	public AutoSetUserAdapterFilter() {
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

	/**
	 * 过滤逻辑：首先判断单点登录的账户是否已经存在本系统中， 如果不存在使用用户查询接口查询出用户对象并设置在Session中
	 * 
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		Object object = httpRequest.getSession().getAttribute("_const_cas_assertion_");
		if (object != null) {
			Assertion assertion = (Assertion) object;
			String loginName = assertion.getPrincipal().getName();
			OrgUser orgUser = orgUserService.queryByUserid(loginName);
			if (orgUser == null) {
				ServletOutputStream out = response.getOutputStream();
				out.write("用户不存在".getBytes());
			} else {
				HttpServletRequest req = (HttpServletRequest) request;
				HttpSession session = req.getSession();
				SessionBean sessionBean = (SessionBean) session
						.getAttribute(AppConst.USER_SESSION);
				if (sessionBean == null) {
					sessionBean = orgUserService.initSessionUser(orgUser);
					sessionBean.setRemoteAddr(req.getRemoteAddr());
					session.setAttribute(AppConst.USER_SESSION, sessionBean);
				}
				chain.doFilter(request, response);
			}
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		ServletContext context = fConfig.getServletContext();
		ApplicationContext ac = WebApplicationContextUtils
				.getWebApplicationContext(context);
		orgUserService = (OrgUserService) ac.getBean("orgUserService");
	}
}