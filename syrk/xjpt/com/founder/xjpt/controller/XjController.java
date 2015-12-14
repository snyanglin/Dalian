package com.founder.xjpt.controller;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.founder.framework.base.controller.BaseController;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.organization.right.service.OrgRightPublic;
import com.founder.framework.organization.role.bean.OrgRole;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.MapUtils;
import com.founder.framework.utils.StringUtils;
import com.founder.xjpt.bean.Xj_ajxxb;
import com.founder.xjpt.bean.Xj_jqxxb;
import com.founder.xjpt.bean.Xj_sjxxb;
import com.founder.xjpt.bean.Zdryjbxxb;
import com.founder.xjpt.service.XjService;

@Controller
@RequestMapping(value = "xj")
public class XjController extends BaseController {
	@Resource(name = "xjService")
	private XjService xjService;
	
	/**
	 * 警情列表
	 * @param page
	 * @param rows
	 * @param entity
	 * @return
	 */
	@RequestMapping(value = "/queryJq", method = RequestMethod.POST)
	public @ResponseBody
	EasyUIPage queryJq(EasyUIPage page,
			@RequestParam(value = "rows") Integer rows, Xj_jqxxb entity, @RequestParam(value="flag", required=false) String flag) {
		page.setPagePara(rows);
		SessionBean sessionBean = getSessionBean();
		//增加查询条件 begin
		if(null != sessionBean){
			entity.setGxzrqdm(sessionBean.getUserOrgCode());
			entity.setGxpcsdm((String)sessionBean.getExtendMap().get("ssPcsCode"));
		} 
		//增加查询条件 end
		entity.setZbz(MapUtils.getSdeZbz(entity.getZbz()));
		return xjService.queryJq(page, entity);
	}
	
	/**
	 * 警情列表延迟加载增加的方法
	 * @param page
	 * @param rows
	 * @param entity
	 * @return
	 */
	@RequestMapping(value = "/queryCountJq", method = RequestMethod.POST)
	public @ResponseBody
		long queryCountJq(Xj_jqxxb entity, @RequestParam(value="flag", required=false) String flag) {
		SessionBean sessionBean = getSessionBean();
		//增加查询条件 begin
		if(StringUtils.isBlank(flag) && null != sessionBean){
			entity.setGxzrqdm(sessionBean.getUserOrgCode());
			entity.setGxpcsdm((String)sessionBean.getExtendMap().get("ssPcsCode"));
		} 
		//增加查询条件 end
		return xjService.queryCountJq(entity);
	}	
	
	/**
	 * 案件列表
	 * @param page
	 * @param rows
	 * @param entity
	 * @return
	 */
	@RequestMapping(value = "/queryAj", method = RequestMethod.POST)
	public @ResponseBody
	EasyUIPage queryAj(EasyUIPage page,
			@RequestParam(value = "rows") Integer rows, Xj_ajxxb entity, @RequestParam(value="flag", required=false) String flag) {
		page.setPagePara(rows);
		SessionBean sessionBean = getSessionBean();
		//增加查询条件 begin
		if(null != sessionBean){
			entity.setGxzrqdm(sessionBean.getUserOrgCode());
			entity.setGxpcsdm((String)sessionBean.getExtendMap().get("ssPcsCode"));
		} 
		//增加查询条件 end
		entity.setZbz(MapUtils.getSdeZbz(entity.getZbz()));
		return xjService.queryAj(page, entity);
	}
	
	/**
	 * 案件列表延迟加载增加的方法
	 * @param page
	 * @param rows
	 * @param entity
	 * @return
	 */
	@RequestMapping(value = "/queryCountAj", method = RequestMethod.POST)
	public @ResponseBody
		long queryCountAj(Xj_ajxxb entity, @RequestParam(value="flag", required=false) String flag) {
		SessionBean sessionBean = getSessionBean();
		//增加查询条件 begin
		if(StringUtils.isBlank(flag) && null != sessionBean){
			entity.setGxzrqdm(sessionBean.getUserOrgCode());
			entity.setGxpcsdm((String)sessionBean.getExtendMap().get("ssPcsCode"));
		} 
		//增加查询条件 end
		return xjService.queryCountAj(entity);
	}
	
	/**
	 * 事件列表
	 * @param page
	 * @param rows
	 * @param entity
	 * @return
	 */
	@RequestMapping(value = "/querySj", method = RequestMethod.POST)
	public @ResponseBody
	EasyUIPage querySj(EasyUIPage page,
			@RequestParam(value = "rows") Integer rows, Xj_sjxxb entity, @RequestParam(value="flag", required=false) String flag) {
		page.setPagePara(rows);
		SessionBean sessionBean = getSessionBean();
		//增加查询条件 begin
		if(StringUtils.isBlank(flag) && null != sessionBean){
			entity.setGxzrqdm(sessionBean.getUserOrgCode());
			entity.setGxpcsdm((String)sessionBean.getExtendMap().get("ssPcsCode"));
		} 
		//增加查询条件 end
		entity.setZbz(MapUtils.getSdeZbz(entity.getZbz()));
		return xjService.querySj(page, entity);
	}
	
	/**
	 * 事件列表延迟加载增加的方法
	 * @param page
	 * @param rows
	 * @param entity
	 * @return
	 */
	@RequestMapping(value = "/queryCountSj", method = RequestMethod.POST)
	public @ResponseBody
		long queryCountSj(Xj_sjxxb entity, @RequestParam(value="flag", required=false) String flag) {
		SessionBean sessionBean = getSessionBean();
		//增加查询条件 begin
		if(StringUtils.isBlank(flag) && null != sessionBean){
			entity.setGxzrqdm(sessionBean.getUserOrgCode());
			entity.setGxpcsdm((String)sessionBean.getExtendMap().get("ssPcsCode"));
		} 
		//增加查询条件 end
		return xjService.queryCountSj(entity);
	}
	
	//金万码连接
	public String getURL(){
		String httpURI = "";
	    InputStream in = XjController.class.getResourceAsStream("../sqlmap/HttpURI.properties");
	    Properties p = new Properties();
		try {
			p.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
		httpURI = p.getProperty("httpURI");
		return httpURI;
	}
	
	/***
	 * 
	 * @Title: queryZdryjbxxNoPt
	 * @Description:非空间查询展示列表
	 * @author wu_chunhui@founder.com.cn
	 * @param @param page
	 * @param @param rows
	 * @param @param entity
	 * @param @param flag
	 * @param @return    
	 * @return EasyUIPage    
	 * @throws
	 */
	@RequestMapping(value = "/queryZdryjbxxNoPt", method = RequestMethod.POST)
	public @ResponseBody
	EasyUIPage queryZdryjbxxNoPt(EasyUIPage page,
			@RequestParam(value = "rows") Integer rows,Zdryjbxxb entity, @RequestParam(value="flag", required=false) String flag) {
		page.setPagePara(rows);
		SessionBean sessionBean = getSessionBean();
		//增加查询条件 begin
			//查询条件.本责任区,和户籍地址在本责任区的
			entity.setGxzrqdm(sessionBean.getUserOrgCode());
			entity.setGxpcsdm((String)sessionBean.getExtendMap().get("ssPcsCode"));
		//增加查询条件 end
		entity.setZbz(MapUtils.getSdeZbz(entity.getZbz()));
		return xjService.queryZdryjbxxNoPt(page, entity);
	}
	/***
	 * 
	 * @Title: queryCountZdry
	 * @Description: 重点人员非空间查询，总数查询，这里沿用以前的延迟加载未做改变（具体原因不清）。
	 * @author wu_chunhui@founder.com.cn
	 * @param @param entity
	 * @param @param flag
	 * @param @return    
	 * @return long    
	 * @throws
	 */
	@RequestMapping(value = "/queryCountZdry", method = RequestMethod.POST)
	public @ResponseBody
		long queryCountZdry(Zdryjbxxb entity, @RequestParam(value="flag", required=false) String flag) {
			SessionBean sessionBean = getSessionBean();
			//查询条件.本责任区,和户籍地址在本责任区的
			entity.setGxzrqdm(sessionBean.getUserOrgCode());
			entity.setGxpcsdm((String)sessionBean.getExtendMap().get("ssPcsCode"));
			//增加查询条件 end
			return xjService.queryCountZdryjbxxNoPt(entity);
		}
	
	//test
	public List<OrgRole> testRole(String userid){
		List<OrgRole> list = new OrgRightPublic().queryUserAssignRole(userid);
		return list;
	}
	
}
