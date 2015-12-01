package com.founder.ywxt.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.founder.framework.annotation.RestfulAnnotation;
import com.founder.framework.base.controller.BaseController;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.components.AppConst;
import com.founder.framework.exception.BussinessException;
import com.founder.framework.utils.EasyUIPage;
import com.founder.ywxt.bean.Ywxtsfqypzb;
import com.founder.ywxt.service.YwxtsfqypzService;

import com.google.gson.Gson;
@Controller
@RequestMapping("ywxtsfqypz")
public class YwxtsfqypzbController extends BaseController {
	
	@Resource
	private YwxtsfqypzService ywxtsfqypzService;
	
	@RestfulAnnotation(serverId = "3")
	@RequestMapping(value = "/queryList", method = RequestMethod.POST)
	public @ResponseBody
	EasyUIPage queryList(EasyUIPage page,
			@RequestParam(value = "rows", required = false) Integer rows,
			Ywxtsfqypzb entity, SessionBean sessionBean) {
		page.setPagePara(rows);
		sessionBean = getSessionBean(sessionBean);		
		return ywxtsfqypzService.queryList(entity, page);
	}
	
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView add() {
		ModelAndView mv = new ModelAndView("ywxt/ywxtsfqypzbAdd");
		
		return mv;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView add(Ywxtsfqypzb entity) {
		entity=this.ywxtsfqypzService.queryById(entity.getId());
		ModelAndView mv = new ModelAndView("ywxt/ywxtsfqypzbEdit");
		mv.addObject("entity",entity);
		return mv;
	}

	/**
	 * @Title: save
	 * @Description: TODO(新增保存)
	 * @param @param entity
	 * @param @param sessionBean
	 * @param @return 设定文件
	 * @return ModelAndView 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)	
	public ModelAndView save( Ywxtsfqypzb entity, SessionBean sessionBean) {
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		Map<String, Object> map = new HashMap<String, Object>();
		sessionBean = getSessionBean(sessionBean);
		try {
			if(StringUtils.isEmpty(entity.getId())){
				Ywxtsfqypzb ywxtsfqypzb=ywxtsfqypzService.queryByYwxtlx(entity.getYwxtlx());
				if(ywxtsfqypzb!=null){
					throw new BussinessException("相同类型的业务协同不能重复添加！");
	  
				}else{
					ywxtsfqypzService.save(entity, sessionBean);

				}
			}else{
				Ywxtsfqypzb ywxtsfqypzb=this.ywxtsfqypzService.queryById(entity.getId());
				ywxtsfqypzb.setBz(entity.getBz());
				this.ywxtsfqypzService.update(ywxtsfqypzb, sessionBean);
			}
			
			map.put(AppConst.STATUS, AppConst.SUCCESS);
			map.put(AppConst.MESSAGES, getAddSuccess());
			map.put(AppConst.SAVE_ID, "" + entity.getId()); // 返回主键
		}catch(BussinessException e){
			map.put(AppConst.STATUS, AppConst.FAIL);
			map.put(AppConst.MESSAGES, "相同类型的业务协同不能重复添加！");
		} 
		
		
		catch (Exception e) {
			map.put(AppConst.STATUS, AppConst.FAIL);
			map.put(AppConst.MESSAGES, getAddFail());
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(map));
		return mv;
	}

	/**
	 * @Title: update
	 * @Description: 停用
	 * @param @param entity
	 * @param @param sessionBean
	 * @param @return 设定文件
	 * @return ModelAndView 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/close", method = RequestMethod.POST)
	public ModelAndView close(Ywxtsfqypzb entity) {
		ModelAndView mv = new ModelAndView("redirect:/forward/"+AppConst.FORWORD);
		Map<String, Object> map = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		try {
			entity=this.ywxtsfqypzService.queryById(entity.getId());
			entity.setSfqy("0");
			ywxtsfqypzService.update(entity, sessionBean);
			map.put(AppConst.STATUS, AppConst.SUCCESS);
			map.put(AppConst.MESSAGES, getUpdateSuccess());
		} catch (Exception e) {
			e.printStackTrace();
			map.put(AppConst.STATUS, AppConst.FAIL);
			map.put(AppConst.MESSAGES, getUpdateFail());
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(map));
		return mv;
	}

	/**
	 * @Title: delete
	 * @Description: 启用
	 * @param @param entity
	 * @param @param sessionBean
	 * @param @return 设定文件
	 * @return ModelAndView 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/open", method = RequestMethod.POST)
	public ModelAndView open(Ywxtsfqypzb entity) {
		ModelAndView mv = new ModelAndView("redirect:/forward/"+AppConst.FORWORD);
		Map<String, Object> map = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		try {
			entity=this.ywxtsfqypzService.queryById(entity.getId());
			entity.setSfqy("1");
			ywxtsfqypzService.update(entity, sessionBean);
			map.put(AppConst.STATUS, AppConst.SUCCESS);
			map.put(AppConst.MESSAGES, getUpdateSuccess());
		} catch (Exception e) {
			map.put(AppConst.STATUS, AppConst.FAIL);
			map.put(AppConst.MESSAGES, getUpdateFail());
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(map));
		return mv;
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public ModelAndView delete(Ywxtsfqypzb entity) {
		ModelAndView mv = new ModelAndView("redirect:/forward/"+AppConst.FORWORD);
		Map<String, Object> map = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		try {
			entity=this.ywxtsfqypzService.queryById(entity.getId());
			
			ywxtsfqypzService.delete(entity, sessionBean);
			map.put(AppConst.STATUS, AppConst.SUCCESS);
			map.put(AppConst.MESSAGES, getUpdateSuccess());
		} catch (Exception e) {
			e.printStackTrace();
			map.put(AppConst.STATUS, AppConst.FAIL);
			map.put(AppConst.MESSAGES, getUpdateFail());
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(map));
		return mv;
	}
}
