package com.founder.xlff.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.google.gson.Gson;
import com.founder.framework.base.controller.BaseController;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.components.AppConst;
import com.founder.xlff.bean.Option;
import com.founder.xlff.service.XlffService;
import com.founder.xlff.vo.Sf_Organization;

/**
 * ****************************************************************************
 * @Package:      [com.founder.xlff.controller.XlffController.java]  
 * @ClassName:    [XlffController]   
 * @Description:  [巡逻防范四色预警控制器]   
 * @Author:       [yu_sun@founder.com.cn]  
 * @CreateDate:   [2015-6-17 上午11:22:51]   
 * @UpdateUser:   [founder(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-6-17 上午11:22:51，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Controller
@RequestMapping(value = "xlff")
public class XlffController extends BaseController {
	
	@Resource(name = "xlffService")
	private XlffService xlffService;
	
	/**
	 * @Title: queryXlff
	 * @Description: TODO(设置查询)
	 * @param @param entity
	 * @param @param sessionBean
	 * @param @return    设定文件
	 * @return Option    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/queryXlff", method = RequestMethod.POST)
	public @ResponseBody Option queryXlff(Option entity, SessionBean sessionBean){
		sessionBean = getSessionBean(sessionBean);
		return xlffService.queryOption(entity);
	}
	
	/**
	 * @Title: saveOption
	 * @Description: TODO(保存四色预警设置表。有记录则update，否则insert)
	 * @param entity
	 * @param sessionBean
	 * @param @return    设定文件
	 * @return Xscjb    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/saveOption", method = RequestMethod.POST)
	public @ResponseBody
	ModelAndView saveOption(Option entity, SessionBean sessionBean) {
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		Map<String, Object> model = new HashMap<String, Object>();
		sessionBean = getSessionBean(sessionBean);
		try {
			Option xlff = xlffService.queryOption(entity);
			if (xlff == null) {
				xlffService.saveOption(entity);
			} else {
				xlffService.updateOption(entity);
			}
			model.put(AppConst.STATUS, AppConst.SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			model.put(AppConst.STATUS, AppConst.FAIL);
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}
	
	/**
	 * @Title: downMap
	 * @描述: 返回四色预警list
	 * @参数: 传入参数定义
	 * @返回值: List<Sf_Organization> 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/downMap", method = RequestMethod.POST)
	public @ResponseBody
	List<Sf_Organization> downMap(Sf_Organization sf) {
		String orgcode = sf.getOrgcode();
		List<Sf_Organization> list = xlffService.downMap(orgcode);
		return list;
	}
	
	/**
	 * @Title: querySsyj
	 * @描述: 获取四色预警新算法
	 * @参数: 传入参数定义
	 * @返回值: List<Sf_Organization> 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/querySsyj", method = RequestMethod.POST)
	public @ResponseBody
	List<Sf_Organization> queryXjZzjgxj(Sf_Organization option) {
		//获取组织机构坐标
		List<Sf_Organization> list = new ArrayList<Sf_Organization>();
		list = xlffService.queryXjZzjgxj(option.getOrgcode());
		List<Sf_Organization> last = new ArrayList<Sf_Organization>();
		//默认是绿色
		String color = "green";
		for (int i = 0; i < list.size(); i++) {
			Sf_Organization s = (Sf_Organization)list.get(i);
			s.setF1(option.getF1());
			s.setF2(option.getF2());
			s.setF3(option.getF3());
			s.setF4(option.getF4());
			color = xlffService.ssyjColor(s);
			s.setColor(color);
			last.add(s);
		}
		return last;
	}
	
}