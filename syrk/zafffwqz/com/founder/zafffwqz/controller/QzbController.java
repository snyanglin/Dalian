/**********************************************************************   
 * <p>文件名：QzbController.java </p>
 * <p>文件描述：犬只管理控制类
 * @project_name：syrk
 * @author liu_shuai@founder.com.cn 
 * @date 2015-5-12 上午8:55:02 
 * @history
 * @department：研发部
 *
*/
package com.founder.zafffwqz.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.founder.framework.base.controller.BaseController;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.components.AppConst;
import com.founder.framework.utils.EasyUIPage;
import com.founder.zafffwqz.bean.Qzb;
import com.founder.zafffwqz.bean.Qzgz;
import com.founder.zafffwqz.service.QzbService;
import com.google.gson.Gson;

/******************************************************************************
 * @Package:      [com.founder.zafffwqz.controller.QzbController.java]  
 * @ClassName:    [QzbController]   
 * @Description:  [犬只管理控制类]   
 * @Author:       [liu_shuai@founder.com.cn]  
 * @CreateDate:   [2015-5-12 上午8:55:02]   
 * @UpdateUser:   [LIUSHUAI(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-5-12 上午8:55:02，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 */

@Controller
@RequestMapping(value = "/qzb")
public class QzbController extends BaseController {
	private Logger logger = Logger.getLogger(this.getClass());
	
	@Resource(name="qzbService")
	private QzbService qzbService;
	
	/**
	 * 
	 * @Title: addQzb
	 * @Description: 跳转-犬只管理
	 * @param id
	 * @param mainTabID
	 * @param flag
	 * @return ModelAndView对象
	 * @throws
	 */
	@RequestMapping(value = "/addQzb", method = RequestMethod.GET)
	public @ResponseBody
	ModelAndView addQzb(String id,String mainTabID,String flag) {
		ModelAndView mv = new ModelAndView("zafffwqz/zzTest");
		mv.addObject("mainTabID", mainTabID);
		Qzb entity = new Qzb();
		SessionBean sessionBean = getSessionBean();
		String flagTemp ="add";
		try {
			entity.setCbr(sessionBean.getUserName());
			mv.addObject("entity", entity);
			if(id!=null){
				entity.setId(id);
			}
			entity = qzbService.queryQzb(entity);
			if(entity != null){
				mv.addObject("entity", entity);
				//if(entity.getXt_lrrbmid().equals(sessionBean.getUserOrgCode())){
				if(flag!=null){
					//flag ="update";
					flagTemp=flag;
				}else {
					//flag ="see";
				}
			}
			mv.addObject("flag", flagTemp);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}

	/**
	 * 
	 * @Title: saveQzb
	 * @Description: 保存-犬只管理
	 * @param entity
	 * @return ModelAndView对象
	 * @throws
	 */
	@RequestMapping(value = "/saveQzb", method = RequestMethod.POST)
	public @ResponseBody
	ModelAndView saveQzb(Qzb entity) {
		ModelAndView mv = new ModelAndView("redirect:/forward/"
				+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		try {
			if (entity.getId() == null || entity.getId().equals("")) {
				qzbService.saveQzb(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "新增【犬只管理】成功！");
				model.put(AppConst.SAVE_ID, entity.getId()); // 返回主键
			} else {
				qzbService.updateQzb(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "修改【犬只管理】成功！");
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
	 * @Title: queryList
	 * @Description: 查询列表-犬只管理
	 * @param page
	 * @param rows
	 * @param zjhm
	 * @param xm
	 * @param dz_jzdzxz
	 * @param yqytdm
	 * @param qxdm
	 * @param qzdm
	 * @return EasyUIPage对象
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/queryList", method = RequestMethod.POST)
	public @ResponseBody
	EasyUIPage queryList(EasyUIPage page,
			@RequestParam(value = "rows") Integer rows,String zjhm,String xm,String dz_jzdzxz,String yqytdm,String qxdm,String qzdm) {
		page.setPagePara(rows);
		
		SessionBean sessionBean = getSessionBean();
		Map map=new HashMap();
		if(!"".equals(zjhm)&&zjhm!=null){
			map.put("zjhm", zjhm);
		}else{
			map.put("zjhm", null);
		}
		if(!"".equals(xm)&&xm!=null){
			map.put("xm", xm);
		}else{
			map.put("xm", null);
		}
		if(!"".equals(dz_jzdzxz)&&dz_jzdzxz!=null){
			map.put("dz_jzdzxz", dz_jzdzxz);
		}else{
			map.put("dz_jzdzxz", null);
		}
		if(!"".equals(yqytdm)&&yqytdm!=null){
			map.put("yqytdm",yqytdm);
		}else{
			map.put("yqytdm",null);
		}
		if(!"".equals(qxdm)&&qxdm!=null){
			map.put("qxdm",qxdm);
		}else{
			map.put("qxdm",null);
		}
		if(!"".equals(qzdm)&&qzdm!=null){
			map.put("qzdm",qzdm);
		}else{
			map.put("qzdm",null);
		}
		return qzbService.queryList(page, map);
	}
	
	/**
	 * 
	 * @Title: DeleteQzb
	 * @Description: 注销-犬只管理
	 * @param entity
	 * @return ModelAndView对象
	 * @throws
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public ModelAndView DeleteQzb(Qzb entity) {
		ModelAndView mv = new ModelAndView("redirect:/forward/"
				+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		try {
			if (entity.getId() != null) { // 注销
				qzbService.delete(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "注销【犬只管理】成功！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getLocalizedMessage(), e);
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, getMessage("cancel.fail"));
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}
	
	/**
	 * 
	 * @Title: QueryGz
	 * @Description: 查询规则-犬只管理
	 * @param entity
	 * @return Map
	 * @throws
	 */
	@RequestMapping(value = "/queryGz", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> QueryGz(Qzgz entity) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("mc", entity.getMc());
		model.put("lb", entity.getLb());
		Map<String, Object> requestmodel = new HashMap<String, Object>();
		List<Qzgz> qzList = qzbService.queryGz(model);
		requestmodel.put("rows", qzList);
		return requestmodel;
	}
}
