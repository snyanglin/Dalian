package com.founder.qbld.controller;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.google.gson.Gson;
import com.founder.framework.base.controller.BaseController;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.components.AppConst;
import com.founder.framework.utils.EasyUIPage;
import com.founder.qbld.bean.Ryxsb;
import com.founder.qbld.service.RyxsService;
import com.founder.qbld.service.ZdryService;

/**
 * ****************************************************************************
 * @Package:      [com.founder.qbld.controller.RyxsController.java]  
 * @ClassName:    [RyxsController]   
 * @Description:  [人员写实控制器]   
 * @Author:       [yu_sun@founder.com.cn]  
 * @CreateDate:   [2015-5-5 上午9:18:50]   
 * @UpdateUser:   [founder(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-5-5 上午9:18:50，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Controller
@RequestMapping(value = "ryxs")
public class RyxsController extends BaseController {
	
	@Resource(name = "ryxsService")
	private RyxsService ryxsService;
	
	@Resource(name = "zdryService")
	private ZdryService zdryService;
	
	/**
	 * @Title: queryRyxsList
	 * @Description: TODO(人员写实列表查询)
	 * @param page
	 * @param rows
	 * @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/queryRyxsList", method = RequestMethod.POST)
	public @ResponseBody EasyUIPage queryRyxsList(EasyUIPage page,
			@RequestParam(value = "rows", required=false) Integer rows, 
			Ryxsb entity){
		page.setPagePara(rows);
		return ryxsService.queryRyxsList(page, entity);
	}
	
	/**
	 * @Title: queryRyxs
	 * @Description: TODO(人员写实详情)
	 * @param entity
	 * @param sessionBean
	 * @param @return    设定文件
	 * @return Ryxsb    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/queryRyxs", method = RequestMethod.POST)
	public @ResponseBody Ryxsb queryRyxs(Ryxsb entity, SessionBean sessionBean){
		sessionBean = getSessionBean(sessionBean);
		return ryxsService.queryRyxs(entity);
	}
	
	/**
	 * @Title: saveRyxsb
	 * @Description: TODO(保存人员写实表)
	 * @param entity
	 * @param sessionBean
	 * @param @return    设定文件
	 * @return Ryxsb    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/saveRyxsb", method = RequestMethod.POST)
	public @ResponseBody
	ModelAndView saveRyxsb(Ryxsb entity, SessionBean sessionBean) {
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		Map<String, Object> model = new HashMap<String, Object>();
		sessionBean = getSessionBean(sessionBean);
		entity.setTxrsfzh(sessionBean.getUserId());
		entity.setTxrmc(sessionBean.getUserName());
		entity.setTxrdwdm(sessionBean.getUserOrgCode());
		entity.setTxrdwdm(sessionBean.getUserOrgNameQc());
		try {
			ryxsService.saveRyxsb(entity);
			//写实之后，更新重点人员表的写实时间
			zdryService.updateZdryxxb(entity.getZdry_zjhm());
			model.put(AppConst.STATUS, AppConst.SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			model.put(AppConst.STATUS, AppConst.FAIL);
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}
	
}