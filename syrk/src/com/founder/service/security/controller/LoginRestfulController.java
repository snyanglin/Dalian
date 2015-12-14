package com.founder.service.security.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.founder.framework.annotation.RestfulAnnotation;
import com.founder.framework.base.controller.BaseController;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.exception.RestException;
import com.founder.framework.organization.department.bean.OrgOrganization;
import com.founder.framework.organization.department.service.OrgOrganizationService;
import com.founder.framework.organization.user.bean.OrgUser;
import com.founder.framework.organization.user.service.OrgUserService;

/**
 * ****************************************************************************
 * @Package:      [com.founder.service.security.controller.LoginRestfulController.java]  
 * @ClassName:    [LoginRestfulController]   
 * @Description:  [一句话描述该类的功能]   
 * @Author:       [weiwen]  
 * @CreateDate:   [2015-4-18 下午7:44:27]   
 * @UpdateUser:   [weiwen]   
 * @UpdateDate:   [2015-4-18 下午7:44:27，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Controller
public class LoginRestfulController extends BaseController {

	@Resource(name = "orgUserService")
	private OrgUserService orgUserService;
	
	@Resource(name = "orgOrganizationService")
	private OrgOrganizationService orgOrganizationService;

	/**
	 * 
	 * @Title: queryBjzbz
	 * @Description: TODO(根据用户ID返回边界坐标值)
	 * @param @param userId
	 * @param @return
	 * @param @throws RestException    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	@RestfulAnnotation(serverId="23")
	@RequestMapping(value="/bjzbz/{orgCode}",method=RequestMethod.GET)
	public @ResponseBody String queryBjzbz(@PathVariable(value="orgCode")String orgCode) throws RestException{
		OrgOrganization org = orgOrganizationService.queryAllFieldByOrgcode(orgCode);
		if (org == null) {
			throw new RestException("部门不存在：" + orgCode);
		} 
		return org.getBjzbz();
	}
	
	@RestfulAnnotation(serverId="324")
	@RequestMapping(value="/loginin/{userId}/{pwd}",method=RequestMethod.GET)
	public @ResponseBody Map<String,String> queryUser(@PathVariable(value="userId")String userId,
			@PathVariable(value="pwd")String pwd) throws RestException{
		OrgUser orgUser = orgUserService.queryByUserid(userId);
		if (orgUser == null) {
			throw new RestException("用户名不存在：" + userId);
		}
		if(!pwd.equals(orgUser.getPassword()))
			throw new RestException("账号密码错误：" + userId);
		SessionBean userInfo = orgUserService.initSessionUser(orgUser);
		Map<String,String> map = new HashMap<String,String>();
		map.put("userId", userInfo.getUserId());
		map.put("password", userInfo.getPassword());
		map.put("username", userInfo.getUserName());
		map.put("orgCode", userInfo.getUserOrgCode());
		map.put("orgName", userInfo.getUserOrgName());
		map.put("pcsdm", userInfo.getExtendValue("ssPcsCode"));
		map.put("pcsmc", userInfo.getExtendValue("ssPcsName"));
		map.put("fxjdm", userInfo.getExtendValue("ssFsxCode"));
		map.put("fxjmc", userInfo.getExtendValue("ssFsxName"));
		map.put("alarm", userInfo.getIndustrialid());
		return map;
	}
}
