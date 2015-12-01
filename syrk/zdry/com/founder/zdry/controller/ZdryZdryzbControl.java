package com.founder.zdry.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.founder.framework.annotation.RestfulAnnotation;
import com.founder.framework.base.controller.BaseController;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.MapUtils;
import com.founder.framework.utils.StringUtils;
import com.founder.zdry.bean.ZdryZdryzb;
import com.founder.zdry.service.ZdryZdryzbService;
import com.founder.zdry.vo.ZdryZdryzbVO;

/**
 * ****************************************************************************
 * @Package:      [com.founder.zdry.controller.ZdryZdryzbControl.java]  
 * @ClassName:    [ZdryZdryzbControl]   
 * @Description:  [重点人员总表]   
 * @Author:       [weiwen]  
 * @CreateDate:   [2015-3-19 上午10:51:54]   
 * @UpdateUser:   [weiwen]   
 * @UpdateDate:   [2015-3-19 上午10:51:54，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Controller
@RequestMapping("/zdryzb")
public class ZdryZdryzbControl extends BaseController {
	
	@Resource(name="zdryZdryzbService")
	private ZdryZdryzbService zdryZdryzbService;

	/**
	 * 
	 * @Title: manage
	 * @Description: TODO(打开重点人员管理列表)
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	@RequestMapping(value="/manager",method = RequestMethod.GET)
	public String manage(){
		return "zdry/zdryManage";
	}
	
	/**
	 * 
	 * @Title: list
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param page
	 * @param @param rows
	 * @param @param entity
	 * @param @param sessionBean
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	@RestfulAnnotation(serverId="3")
	@RequestMapping(value="/list",method = RequestMethod.POST)
	public @ResponseBody EasyUIPage list(EasyUIPage page,@RequestParam(value="rows",required = false)Integer rows,
			ZdryZdryzb entity,SessionBean sessionBean){
		page.setPagePara(rows);
			entity.setSszrqdm(getSessionBean(sessionBean).getUserOrgCode());
		return zdryZdryzbService.queryList(entity, page);
	}
	
	/**
	 * 地图查询
	 * @param page
	 * @param rows
	 * @param entity
	 * @return
	 */
	@RequestMapping(value = "/queryZdryOnPT", method = RequestMethod.POST)
	public @ResponseBody
	EasyUIPage queryDwDzOnPT(EasyUIPage page,
			@RequestParam(value = "rows") Integer rows, ZdryZdryzbVO entity) {
		page.setPagePara(rows);
		SessionBean sessionBean = getSessionBean();
		if(entity.getType()!=null &&!"".equals(entity.getType())){
			if(entity.getType().equals("3")){
				
			}else if(entity.getType().equals("2")){
				String[] str =  entity.getZbz().split(",");
				entity.setZbz(str[0]+" "+str[1]);
			}else{
				
				entity.setZbz(MapUtils.getSdeZbz(entity.getZbz()));
			}
		}
		return zdryZdryzbService.queryDwDzOnPT(page, entity);
	}
}
