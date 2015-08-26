/**********************************************************************   
 * <p>文件名：DwOwnsydwController.java </p>
 * <p>文件描述：实有单位补充信息(新增)
 * @project_name：syrk
 * @author star
 * @date 2015-04-20
 * @history
 * @department：研发部
 *
*/
package com.founder.sydw.controller;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.founder.framework.base.controller.BaseController;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.components.AppConst;
import com.founder.sydw.bean.DwOwnAmfwcsBean;
import com.founder.sydw.bean.DwOwnGqwbBean;
import com.founder.sydw.bean.DwOwnGwylcsBean;
import com.founder.sydw.bean.DwOwnMbBean;
import com.founder.sydw.bean.DwOwnMbXmyjBean;
import com.founder.sydw.bean.DwOwnMqBean;
import com.founder.sydw.bean.DwOwnMqZgryBean;
import com.founder.sydw.bean.DwOwnSealBean;
import com.founder.sydw.bean.DwOwnXFBean;
import com.founder.sydw.bean.DwOwnYhBean;
import com.founder.sydw.bean.DwOwnYxyycsBean;
import com.founder.sydw.bean.DwOwnZjbxBean;
import com.founder.sydw.service.DwOwnsydwService;

import com.google.gson.Gson;

/******************************************************************************
 * @Package:      [com.founder.sydw.controller.DwOwnsydwController.java]  
 * @ClassName:    [DwOwnsydwController]   
 * @Description:  [实有单位补充信息(新增)]   
 * @Author:       [star]  
 * @CreateDate:   [ 2015-04-20]   
 * @Version:      [v1.0] 
 */

@Controller
@RequestMapping("/dwownsydw")
public class DwOwnsydwController extends BaseController {
	private Logger logger = Logger.getLogger(this.getClass());
	@Resource(name = "dwownsydwService")
	private DwOwnsydwService dwownsydwService;

	/**
	 * 
	 * @Title: addGwylcs
	 * @Description: 单位分类信息-歌舞娱乐场所信息跳转
	 * @param @param id
	 * @param @param dwid
	 * @param @return   mv
	 * @return ModelAndView    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/editGwylcs", method = RequestMethod.GET)
	public ModelAndView addGwylcs(String id, String dwid) {
		ModelAndView mv = new ModelAndView("sydw/gwxxbAdd");
		DwOwnGwylcsBean entity = new DwOwnGwylcsBean();
		entity.setDwid(dwid);
		if (null != id && !"".equals(id)) {
			entity.setId(id);
			entity = dwownsydwService.queryGwylcsByRyid(entity);
		}
		mv.addObject("entity", entity);
		return mv;
	}

	/**
	 *
	 * @Title: saveGwylcs
	 * @Description: 单位分类信息-歌舞娱乐场所信息新增修改
	 * @param @param entity
	 * @param @return 设定文件
	 * @return ModelAndView 返回类型
	 * @throws
	 */
	
	@RequestMapping(value = "/saveGwylcs", method = RequestMethod.POST)
	public ModelAndView saveGwylcs(DwOwnGwylcsBean entity){
		ModelAndView mv = new ModelAndView("redirect:/forward/"+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		try {
			if(null==entity.getId()||"".equals(entity.getId())){
				entity.setXt_zxbz("0");
				dwownsydwService.saveGwylcs(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "新增【歌舞娱乐场所信息】成功！");
				model.put(AppConst.SAVE_ID, entity.getId()); // 返回主键
			} else {
				dwownsydwService.updateGwylcs(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "修改【歌舞娱乐场所信息】成功！");
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
	 * @Title: addAmfwcs
	 * @Description: 单位分类信息-按摩服务场所信息跳转
	 * @param @param id
	 * @param @param dwid
	 * @param @return    设定文件
	 * @return ModelAndView    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/editAmfwcs", method = RequestMethod.GET)
	public ModelAndView addAmfwcs(String id,String dwid){
		ModelAndView mv = new ModelAndView("sydw/amxxbAdd");
		DwOwnAmfwcsBean entity = new DwOwnAmfwcsBean();
		entity.setDwid(dwid);
		if(null!=id&&!"".equals(id)){
			entity.setId(id);
			entity = dwownsydwService.queryAmfwcsByRyid(entity);
		}
		
		mv.addObject("entity", entity);
		return mv;
	}
	
	/**
	 * 
	 * @Title: saveAmfwcs
	 * @Description: 单位分类信息-按摩服务场所信息跳转新增修改
	 * @param @param entity
	 * @param @return    设定文件
	 * @return ModelAndView    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/saveAmfwcs", method = RequestMethod.POST)
	public ModelAndView saveAmfwcs(DwOwnAmfwcsBean entity){
		ModelAndView mv = new ModelAndView("redirect:/forward/"+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		try {
			if(null==entity.getId()||"".equals(entity.getId())){
				entity.setXt_zxbz("0");
				dwownsydwService.saveAmfwcs(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "新增【按摩服务场所信息】成功！");
				model.put(AppConst.SAVE_ID, entity.getId()); // 返回主键
			} else {
				dwownsydwService.updateAmfwcs(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "修改【按摩服务场所信息】成功！");
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
	 * @Title: addYxyycs
	 * @Description:单位分类信息-游戏游艺场所的行业特有信息跳转
	 * @param @param id
	 * @param @param dwid
	 * @param @return    设定文件
	 * @return ModelAndView    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/editYxyycs", method = RequestMethod.GET)
	public ModelAndView addYxyycs(String id,String dwid){
		ModelAndView mv = new ModelAndView("sydw/yxyyxxbAdd");
		DwOwnYxyycsBean entity = new DwOwnYxyycsBean();
		entity.setDwid(dwid);
		if(null!=id&&!"".equals(id)){
			entity.setId(id);
			entity = dwownsydwService.queryYxyycsByRyid(entity);
		}		
		mv.addObject("entity", entity);
		return mv;
	}
	
	/**
	 * 
	 * @Title: saveYxyycs
	 * @Description: 单位分类信息-游戏游艺场所的行业特有信息保存、修改
	 * @param @param entity
	 * @param @return    设定文件
	 * @return ModelAndView    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/saveYxyycs", method = RequestMethod.POST)
	public ModelAndView saveYxyycs(DwOwnYxyycsBean entity){
		ModelAndView mv = new ModelAndView("redirect:/forward/"+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		try {
			if(null==entity.getId()||"".equals(entity.getId())){
				entity.setXt_zxbz("0");
				dwownsydwService.saveYxyycs(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "新增【游戏游艺场所信息】成功！");
				model.put(AppConst.SAVE_ID, entity.getId()); // 返回主键
			} else {
				dwownsydwService.updateYxyycs(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "修改【游戏游艺场所信息】成功！");
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
	 * @Title: addYz
	 * @Description: 单位分类信息-印章基本信息跳转
	 * @param @param id
	 * @param @param dwid
	 * @param @return    设定文件
	 * @return ModelAndView    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/editYz", method = RequestMethod.GET)
	public ModelAndView addYz(String id, String dwid) {
		ModelAndView mv = new ModelAndView("sydw/yzxxbAdd");
		DwOwnSealBean entity = new DwOwnSealBean();
		entity.setDwid(dwid);
		if (null != id && !"".equals(id)) {
			entity.setId(id);
			entity = dwownsydwService.queryYzByRyid(entity);
		}

		mv.addObject("entity", entity);
		return mv;
	}

	/**
	 * 
	 * @Title: saveYz
	 * @Description: 单位分类信息-印章基本信息保存、修改
	 * @param @param entity
	 * @param @return    设定文件
	 * @return ModelAndView    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/saveYz", method = RequestMethod.POST)
	public ModelAndView saveYz(DwOwnSealBean entity) {
		ModelAndView mv = new ModelAndView("redirect:/forward/"+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		try {
			if (null == entity.getId() || "".equals(entity.getId())) {
				entity.setXt_zxbz("0");
				dwownsydwService.saveYz(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "新增【印章信息】成功！");
				model.put(AppConst.SAVE_ID, entity.getId()); // 返回主键
			} else {
				dwownsydwService.updateYz(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "修改【印章信息】成功！");
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
	 * @Title: addMb
	 * @Description: 单位分类信息-民爆单位基本信息跳转
	 * @param @param id
	 * @param @param dwid
	 * @param @return    设定文件
	 * @return ModelAndView    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/editbMb", method = RequestMethod.GET)
	public ModelAndView addMb(String id, String dwid) {
		ModelAndView mv = new ModelAndView("sydw/mbxxbAdd");
		DwOwnMbBean entity = new DwOwnMbBean();
		entity.setDwid(dwid);
		if (null != id && !"".equals(id)) {
			entity.setId(id);
			entity = dwownsydwService.queryMbByRyid(entity);
		}

		mv.addObject("entity", entity);
		return mv;
	}

	/**
	 * 
	 * @Title: saveMb
	 * @Description: 单位分类信息-民爆单位基本信息保存、修改
	 * @param @param entity
	 * @param @return    设定文件
	 * @return ModelAndView    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/saveMb", method = RequestMethod.POST)
	public ModelAndView saveMb(DwOwnMbBean entity) {
		ModelAndView mv = new ModelAndView("redirect:/forward/"+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		try {
			if (null == entity.getId() || "".equals(entity.getId())) {
				entity.setXt_zxbz("0");
				dwownsydwService.saveMb(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "新增【民爆信息】成功！");
				model.put(AppConst.SAVE_ID, entity.getId()); // 返回主键
			} else {
				dwownsydwService.updateMb(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "修改【民爆信息】成功！");
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
	 * @Title: addMbsgxm
	 * @Description:单位分类信息-民爆施工项目业绩表跳转跳转
	 * @param @param id
	 * @param @param dwid
	 * @param @return    设定文件
	 * @return ModelAndView    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/editbMbxmyj", method = RequestMethod.GET)
	public ModelAndView addMbsgxm(String id, String dwid) {
		ModelAndView mv = new ModelAndView("sydw/mbssxmbAdd");
		DwOwnMbXmyjBean entity = new DwOwnMbXmyjBean();
		entity.setDwid(dwid);
		if (null != id && !"".equals(id)) {
			entity.setId(id);
			entity = dwownsydwService.queryMbXmyjByRyid(entity);
		}

		mv.addObject("entity", entity);
		return mv;
	}

	/**
	 * 
	 * @Title: saveMbXmyj
	 * @Description: 民爆施工项目业绩表保存、修改
	 * @param @param entity
	 * @param @return    设定文件
	 * @return ModelAndView    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/saveMbxmyj", method = RequestMethod.POST)
	public @ResponseBody
	ModelAndView saveMbXmyj(DwOwnMbXmyjBean entity) {
		ModelAndView mv = new ModelAndView("redirect:/forward/"+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		try {
			DwOwnMbXmyjBean domb = dwownsydwService.queryMbXmyjByRyid(entity);
			if (entity.getId() == null || entity.getId().equals("")
					&& domb == null) {
				dwownsydwService.saveMbXmyj(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "新增【民爆施工项目业绩】成功！");
				model.put(AppConst.SAVE_ID, entity.getId()); // 返回主键
			} else if (entity.getId() == null || entity.getId().equals("")
					&& domb != null) {
				model.put(AppConst.STATUS, AppConst.FAIL);
				model.put(AppConst.MESSAGES, "项目名称对应民爆单位已有关联");
			} else {
				dwownsydwService.updateMbXmyj(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "修改【民爆施工项目业绩】成功！");
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
	 * @Title: deleteMbxmyj
	 * @Description: T单位分类信息-民爆施工项目业绩表删除
	 * @param @param domxb
	 * @param @return    设定文件
	 * @return ModelAndView    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/deleteMbxmyj", method = RequestMethod.POST)
	public ModelAndView deleteMbxmyj(DwOwnMbXmyjBean domxb) {
		ModelAndView mv = new ModelAndView("redirect:/forward/"+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			dwownsydwService.deleteMbxmyj(domxb, getSessionBean());
			model.put(AppConst.STATUS, AppConst.SUCCESS);
			model.put(AppConst.MESSAGES, getMessage("cancel.success"));
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage(), e);
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, getMessage("cancel.fail"));
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}

	/**
	 * 
	 * @Title: addMq
	 * @Description: 单位分类信息-民枪配置单位信息跳转
	 * @param @param id
	 * @param @param dwid
	 * @param @return    设定文件
	 * @return ModelAndView    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/editmMq", method = RequestMethod.GET)
	public ModelAndView addMq(String id, String dwid) {
		ModelAndView mv = new ModelAndView("sydw/mqxxbAdd");
		DwOwnMqBean entity = new DwOwnMqBean();
		entity.setDwid(dwid);
		if (null != id && !"".equals(id)) {
			entity.setId(id);
			entity = dwownsydwService.queryMqByRyid(entity);
		}

		mv.addObject("entity", entity);
		return mv;
	}

	/**
	 * 
	 * @Title: saveMq
	 * @Description: 单位分类信息-民枪配置单位信息保存、修改
	 * @param @param entity
	 * @param @return    设定文件
	 * @return ModelAndView    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/saveMq", method = RequestMethod.POST)
	public ModelAndView saveMq(DwOwnMqBean entity) {
		ModelAndView mv = new ModelAndView("redirect:/forward/"+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		try {
			if (null == entity.getId() || "".equals(entity.getId())) {
				entity.setXt_zxbz("0");
				dwownsydwService.saveMq(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "新增【民枪信息】成功！");
				model.put(AppConst.SAVE_ID, entity.getId()); // 返回主键
			} else {
				dwownsydwService.updateMq(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "修改【民枪信息】成功！");
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
	 * @Title: addMqzgry
	 * @Description: 单位_民枪枪支专管人员信息跳转
	 * @param @param id
	 * @param @param dwid
	 * @param @return    设定文件
	 * @return ModelAndView    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/editbMqzgry", method = RequestMethod.GET)
	public ModelAndView addMqzgry(String id, String dwid) {
		ModelAndView mv = new ModelAndView("sydw/mqzgryxxbAdd");
		DwOwnMqZgryBean entity = new DwOwnMqZgryBean();
		entity.setDwid(dwid);
		if (null != id && !"".equals(id)) {
			entity.setId(id);
			entity = dwownsydwService.queryMqzgryByRyid(entity);
		}

		mv.addObject("entity", entity);
		return mv;
	}

	/**
	 * 
	 * @Title: saveMqzgry
	 * @Description: 单位_民枪枪支专管人员信息保存、修改
     * @param bean
	 * @param @param entity
	 * @param @return    设定文件
	 * @return ModelAndView    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/saveMqzgry", method = RequestMethod.POST)
	public ModelAndView saveMqzgry(DwOwnMqZgryBean entity) {
		ModelAndView mv = new ModelAndView("redirect:/forward/"+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		try {
			DwOwnMqZgryBean domb = dwownsydwService.queryMqzgryByRyid(entity);
			if (entity.getId() == null || entity.getId().equals("")
					&& domb == null) {
				dwownsydwService.saveMqzgry(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "新增【民爆施工项目业绩】成功！");
				model.put(AppConst.SAVE_ID, entity.getId()); // 返回主键
			} else if (entity.getId() == null || entity.getId().equals("")
					&& domb != null) {
				model.put(AppConst.STATUS, AppConst.FAIL);
				model.put(AppConst.MESSAGES, "项目名称对应民爆单位已有关联");
			} else {
				dwownsydwService.updateMqzgry(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "修改【民爆施工项目业绩】成功！");
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
	 * @Title: deleteCyryxxb
	 * @Description: 单位分类信息-民枪枪支专管人员信息删除
	 * @param @param domxb
	 * @param @return    设定文件
	 * @return ModelAndView    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/deleteMqzgry", method = RequestMethod.POST)
	public ModelAndView deleteCyryxxb(DwOwnMqZgryBean domxb) {
		ModelAndView mv = new ModelAndView("redirect:/forward/"+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			dwownsydwService.deleteMqzgry(domxb, getSessionBean());
			model.put(AppConst.STATUS, AppConst.SUCCESS);
			model.put(AppConst.MESSAGES, getMessage("cancel.success"));
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage(), e);
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, getMessage("cancel.fail"));
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}

	/**
	 * 
	 * @Title: addYh
	 * @Description: 单位分类信息-烟花配置单位信息跳转
	 * @param @param id
	 * @param @param dwid
	 * @param @return    设定文件
	 * @return ModelAndView    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/editmYh", method = RequestMethod.GET)
	public ModelAndView addYh(String id, String dwid) {
		ModelAndView mv = new ModelAndView("sydw/dwyhxxbAdd");
		DwOwnYhBean entity = new DwOwnYhBean();
		entity.setDwid(dwid);
		if (null != id && !"".equals(id)) {
			entity.setId(id);
			entity = dwownsydwService.queryYhByRyid(entity);
		}

		mv.addObject("entity", entity);
		return mv;
	}

	/**
	 * 
	 * @Title: saveYh
	 * @Description: 单位分类信息-烟花配置单位信息保存、修改
	 * @param @param entity
	 * @param @return    设定文件
	 * @return ModelAndView    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/saveYh", method = RequestMethod.POST)
	public ModelAndView saveYh(DwOwnYhBean entity) {
		ModelAndView mv = new ModelAndView("redirect:/forward/"+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		try {
			if (null == entity.getId() || "".equals(entity.getId())) {
				entity.setXt_zxbz("0");
				dwownsydwService.saveYh(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "新增【烟花信息】成功！");
				model.put(AppConst.SAVE_ID, entity.getId()); // 返回主键
			} else {
				dwownsydwService.updateYh(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "修改【烟花信息】成功！");
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
	 * @Title: addZjbxy
	 * @Description: 单位分类信息-证券/保险业单位信息跳转
	 * @param @param id
	 * @param @param dwid
	 * @param @return    设定文件
	 * @return ModelAndView    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/editmZjbxy", method = RequestMethod.GET)
	public ModelAndView addZjbxy(String id, String dwid) {
		ModelAndView mv = new ModelAndView("sydw/dwzjbxyxxbAdd");
		DwOwnZjbxBean entity = new DwOwnZjbxBean();
		entity.setDwid(dwid);
		if (null != id && !"".equals(id)) {
			entity.setId(id);
			entity = dwownsydwService.queryZjbxyByRyid(entity);
		}

		mv.addObject("entity", entity);
		return mv;
	}

	/**
	 * 
	 * @Title: saveZjbxy
	 * @Description: 单位分类信息-证券/保险业单位信息保存、修改
	 * @param @param entity
	 * @param @return    设定文件
	 * @return ModelAndView    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/saveZjbxy", method = RequestMethod.POST)
	public ModelAndView saveZjbxy(DwOwnZjbxBean entity) {
		ModelAndView mv = new ModelAndView("redirect:/forward/"+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		try {
			if (null == entity.getId() || "".equals(entity.getId())) {
				entity.setXt_zxbz("0");
				dwownsydwService.saveZjbxy(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "新增【证券/保险业信息】成功！");
				model.put(AppConst.SAVE_ID, entity.getId()); // 返回主键
			} else {
				dwownsydwService.updateZjbxy(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "修改【证券/保险业信息】成功！");
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
	 * @Title: addGqwb
	 * @Description: 单位分类信息-工企/文保单位信息跳转
	 * @param @param id
	 * @param @param dwid
	 * @param @return    设定文件
	 * @return ModelAndView    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/editmGqwb", method = RequestMethod.GET)
	public ModelAndView addGqwb(String id, String dwid) {
		ModelAndView mv = new ModelAndView("sydw/dwGqwbxxbAdd");
		DwOwnGqwbBean entity = new DwOwnGqwbBean();
		entity.setDwid(dwid);
		if (null != id && !"".equals(id)) {
			entity.setId(id);
			entity = dwownsydwService.queryGqwbByRyid(entity);
		}

		mv.addObject("entity", entity);
		return mv;
	}

	/**
	 * 单位分类信息-工企/文保单位信息
	 * 
	 * @Description 保存、修改
	 * @param bean
	 * @return
	 */
	@RequestMapping(value = "/saveGqwb", method = RequestMethod.POST)
	public ModelAndView saveGqwb(DwOwnGqwbBean entity) {
		ModelAndView mv = new ModelAndView("redirect:/forward/"+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		try {
			if (null == entity.getId() || "".equals(entity.getId())) {
				entity.setXt_zxbz("0");
				dwownsydwService.saveGqwb(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "新增【工企/文保信息】成功！");
				model.put(AppConst.SAVE_ID, entity.getId()); // 返回主键
			} else {
				dwownsydwService.updateGqwb(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "修改【工企/文保信息】成功！");
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
	 * 单位分类信息-消防信息
	 * 
	 * @Description 跳转
	 * @param id ,dwid
	 * @return
	 */

	@RequestMapping(value = "/editXf", method = RequestMethod.GET)
	public ModelAndView addXf(String id, String dwid) {
		ModelAndView mv = new ModelAndView("sydw/dwXfAdd");
		DwOwnXFBean entity = new DwOwnXFBean();
		entity.setDwid(dwid);
		if (null != id && !"".equals(id)) {
			entity.setId(id);
			entity = dwownsydwService.queryXfByRyid(entity);
		}

		mv.addObject("entity", entity);
		return mv;
	}

	/**
	 * 单位分类信息-消防信息
	 * @Description 保存、修改
	 * @param bean
	 * @return
	 */
	@RequestMapping(value = "/saveXf", method = RequestMethod.POST)
	public ModelAndView saveXf(DwOwnXFBean entity) {
		ModelAndView mv = new ModelAndView("redirect:/forward/"+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		try {
			if (null == entity.getId() || "".equals(entity.getId())) {
				entity.setXt_zxbz("0");
				dwownsydwService.saveXf(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "新增【消防信息】成功！");
				model.put(AppConst.SAVE_ID, entity.getId()); // 返回主键
			} else {
				dwownsydwService.updateXf(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "修改【消防信息】成功！");
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
}