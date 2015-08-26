package com.founder.sydw.controller;
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
import com.google.gson.Gson;
import com.founder.framework.base.controller.BaseController;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.components.AppConst;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.MapUtils;
import com.founder.framework.utils.StringUtils;
import com.founder.sydw.bean.Dwjbxxb;
import com.founder.sydw.service.SydwQueryService;
@Controller
@RequestMapping("/sydwcx")
public class SydwQueryController extends BaseController{
	private Logger logger = Logger.getLogger(this.getClass());
	
	@Resource(name="sydwQueryService")
	private SydwQueryService sydwQueryService;
	
	/**
	 * 单位注销
	 * @param entity
	 * @return
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public ModelAndView DeleteRyjzdzzb(Dwjbxxb entity) {
		ModelAndView mv = new ModelAndView("redirect:/forward/"
				+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		try {
			if (entity.getId() != null) { // 注销
				sydwQueryService.delete(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, getMessage("cancel.success"));
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
	//实有单位列表延迟加载增加的方法;
	@RequestMapping(value = "/queryCountSydw", method = RequestMethod.POST)
	public @ResponseBody
		long queryCountSydw(Dwjbxxb entity) {
				SessionBean sessionBean = getSessionBean();
				if(null != sessionBean){
					entity.setGlbmid(sessionBean.getUserOrgCode());
					entity.setGlpcsid((String)sessionBean.getExtendMap().get("ssPcsCode"));
				}
				
				return sydwQueryService.queryCountSydw(entity);
			}
	
	/**
	 *  按照地址代码查询单位列表
	 * @param entity
	 * @return
	 */
	@RequestMapping(value = "/queryDwByDzDm",method = RequestMethod.GET)
	public @ResponseBody List queryDwByDzDm(Dwjbxxb entity){
		SessionBean sessionBean = getSessionBean();
		if(null != sessionBean){
			entity.setGlbmid(sessionBean.getUserOrgCode());
			entity.setGlpcsid((String)sessionBean.getExtendMap().get("ssPcsCode"));
		}
		return sydwQueryService.queryDwByDzDm(entity);
	}
	
	/**
	 * 单位核实列表
	 * @param page
	 * @param rows
	 * @param entity
	 * @return
	 */
	@RequestMapping(value = "/queryDwHs", method = RequestMethod.POST)
	public @ResponseBody
	EasyUIPage queryDwHs(EasyUIPage page,
			@RequestParam(value = "rows") Integer rows, Dwjbxxb entity) {
		page.setPagePara(rows);
		SessionBean sessionBean = getSessionBean();
		if(null != sessionBean){
			//entity.setGlbmid(sessionBean.getUserOrgCode());
			//entity.setGlpcsid((String)sessionBean.getExtendMap().get("ssPcsCode"));
		}
		return sydwQueryService.queryDwHs(page, entity);
	}
	
	
	//实有单位核实列表统计列表记录数;
	@RequestMapping(value = "/queryCountSydwHs", method = RequestMethod.POST)
	public @ResponseBody
		long queryCountSydwHs(Dwjbxxb entity) {
			SessionBean sessionBean = getSessionBean();
		if(null != sessionBean){
			//	entity.setGlpcsid((String)sessionBean.getExtendMap().get("ssPcsCode"));
		}
		return sydwQueryService.queryCountSydwHs(entity);
	}
	
	/**
	 * 只查询单位基本信息表
	 * @param page
	 * @param rows
	 * @param entity
	 * @return
	 */
	@RequestMapping(value = "/queryDw", method = RequestMethod.POST)
	public @ResponseBody
	EasyUIPage queryDw(EasyUIPage page,  @RequestParam(value="flag", required=false) String flag,
			@RequestParam(value = "rows") Integer rows, Dwjbxxb entity) {
		page.setPagePara(rows);
		SessionBean sessionBean = getSessionBean();
		//增加查询条件 begin
		if(StringUtils.isBlank(flag) && null != sessionBean){
			//entity.setGlpcsid((String)sessionBean.getExtendMap().get("ssPcsCode"));
			entity.setGlbmid((String)sessionBean.getUserOrgCode());
		} 
		//增加查询条件 end
		return sydwQueryService.queryDw(page, entity);
	}
	//实有单位列表延迟加载增加的方法;
	@RequestMapping(value = "/queryCountDw", method = RequestMethod.POST)
	public @ResponseBody
		long queryCountDw(Dwjbxxb entity,  @RequestParam(value="flag", required=false) String flag) {
					SessionBean sessionBean = getSessionBean();
				
				//增加查询条件 begin
				if(StringUtils.isBlank(flag) && null != sessionBean){
					//entity.setGlpcsid((String)sessionBean.getExtendMap().get("ssPcsCode"));
					entity.setGlbmid((String)sessionBean.getUserOrgCode());
				} 
				//增加查询条件 end
				return sydwQueryService.queryCountDw(entity);
	}
	/**
	 * 根据地址id查询坐标
	 * @param entity
	 * @return
	 */
	@RequestMapping(value = "/queryZbByDzId",method = RequestMethod.GET)
	public @ResponseBody List<Dwjbxxb> queryZbByDzId(String dwids){
		//SessionBean sessionBean = getSessionBean();
		//if(null != sessionBean){
			//entity.setGlbmid(sessionBean.getUserOrgCode());
		//}
		return sydwQueryService.queryZbByDzId(dwids);
	}
	
	/**
	 * 实有单位核实注销更新操作
	 * @param entity
	 * @return
	 */
	@RequestMapping(value = "/updateHs",method = RequestMethod.GET)
	public @ResponseBody int updateHs(Dwjbxxb entity){
		SessionBean sessionBean = getSessionBean();
		
		return sydwQueryService.updateHs(entity,sessionBean);
	}
	
	/**
	 * 地图查询
	 * @param page
	 * @param rows
	 * @param entity
	 * @return
	 */
	@RequestMapping(value = "/queryDwDzOnPT", method = RequestMethod.POST)
	public @ResponseBody
	EasyUIPage queryDwDzOnPT(EasyUIPage page,
			@RequestParam(value = "rows") Integer rows, Dwjbxxb entity) {
		page.setPagePara(rows);
		SessionBean sessionBean = getSessionBean();
		if(null != sessionBean){
			entity.setGlbmid(sessionBean.getUserOrgCode());
			entity.setGlpcsid((String)sessionBean.getExtendMap().get("ssPcsCode"));
		}
		if(entity.getType()!=null &&!"".equals(entity.getType())){
			if(entity.getType().equals("3")){
				
			}else if(entity.getType().equals("2")){
				String[] str =  entity.getZbz().split(",");
				entity.setZbz(str[0]+" "+str[1]);
			}else{
				
				entity.setZbz(MapUtils.getSdeZbz(entity.getZbz()));
			}
		}
		return sydwQueryService.queryDwDzOnPT(page, entity);
	}
	
	/**
	 *  查询带类型的实有单位的列表
	 * @param url
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/queryDwByLx", method = RequestMethod.GET)
	public ModelAndView queryDwByLx(String sydwlx){
		ModelAndView mv = new ModelAndView("sydw/sydwMain");
		mv.addObject("dwlbdm", sydwlx);
		return mv;
	}
}
