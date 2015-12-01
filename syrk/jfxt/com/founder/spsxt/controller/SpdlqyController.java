package com.founder.spsxt.controller;
import java.util.HashMap;
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
import com.founder.framework.exception.BussinessException;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.spsxt.bean.Spdlqy;
import com.founder.spsxt.service.SpdlqyService;
import com.google.gson.Gson;
@Controller
@RequestMapping(value = "/spdlqy")
public class SpdlqyController extends BaseController {

	private Logger logger = Logger.getLogger(this.getClass());
	@Resource(name="spdlqyService")
	private SpdlqyService spdlqyService;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/queryList", method = RequestMethod.POST)
	public @ResponseBody
	EasyUIPage queryList(EasyUIPage page,@RequestParam(value = "rows") Integer rows) {
		System.out.println("rows="+rows+","+page.getBegin()+","+page.getEnd());
		System.out.println("sort,"+page.getSort()+","+page.getOrder());
		page.setPagePara(rows);
		SessionBean sessionBean = getSessionBean();
		Map map=new HashMap();
		map.put("xt_lrrid", sessionBean.getUserId());
		map.put("xt_lrrbmid", sessionBean.getUserOrgCode());
		return spdlqyService.queryList(page, map);
	}
	//修改地理区域
	@RequestMapping(value = "/spdlqyEdit", method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView spdlqyEdit(@RequestParam(value = "id") String id,@RequestParam(value = "mode",required=false,defaultValue="") String mode)	throws BussinessException {
		ModelAndView mv = new ModelAndView("jfxt/spdlqyModify");
		Spdlqy entity =  spdlqyService.queryById(id);
		mv.addObject("entity", entity);
		mv.addObject("mode", mode);
		return mv;
	}
	/**
	 * 更新和保存
	 * @param entity
	 * @return
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public @ResponseBody ModelAndView save(Spdlqy entity) {
		ModelAndView mv = new ModelAndView("redirect:/forward/"+AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		if(null != sessionBean){
			entity.setXt_lrrxm(sessionBean.getUserName());
			entity.setXt_lrrid(sessionBean.getUserId());
			entity.setXt_lrrbm(sessionBean.getUserOrgName());
			entity.setXt_lrrbmid(sessionBean.getUserOrgCode());			
		}
		try {
			if (entity.getId() == null || entity.getId().equals("")) {
				String policecode = entity.getXt_lrrbmid().substring(0,6)+"000000";
				entity.setPolicecode(policecode);
				//获得本组中code最大值，然后+1
				String code      =spdlqyService.getCode(policecode);
				int icode		 =Integer.parseInt(code)+1;
				entity.setCode(Integer.toString(icode));
				//获得parentcode值
				String parentcode=spdlqyService.getParentCode(policecode);
				entity.setParentcode(parentcode);
				
				spdlqyService.save(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "新增【视频区域】成功");
				model.put(AppConst.SAVE_ID, entity.getId()); // 返回主键
			} else {
				spdlqyService.update(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "修改【视频区域】成功");
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
	 * 检查区域名称是否重名
	 */
	@RequestMapping(value = "/checkSameName", method = RequestMethod.POST)
	public @ResponseBody int checkSameName(@RequestParam(value = "meaning") String meaning){
		//Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		Map<String,String> map=new HashMap<String,String>();
		String policecode=sessionBean.getUserOrgCode().substring(0,6)+"000000";
		map.put("policecode", policecode);
		map.put("meaning", meaning);
		int SameNameNum= spdlqyService.checkSameName(map);
		return SameNameNum;
	}
}
