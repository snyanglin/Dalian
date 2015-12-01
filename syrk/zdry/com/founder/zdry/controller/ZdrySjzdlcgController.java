package com.founder.zdry.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

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
import com.founder.framework.dictionary.service.SysDictGlService;
import com.founder.framework.message.bean.SysMessage;
import com.founder.framework.message.dao.SysMessageDao;
import com.founder.framework.utils.DateUtils;
import com.founder.framework.utils.EasyUIPage;
import com.founder.syrkgl.bean.RyRyjbxxb;
import com.founder.zdry.bean.ZdryLczywblb;
import com.founder.zdry.bean.ZdryZdryzb;
import com.founder.zdry.service.ZdryLcgService;
import com.founder.zdry.service.ZdrySjzdlcgService;
import com.founder.zdry.service.ZdryZdryzbService;
import com.founder.zdry.vo.ZdryVO;

import com.google.gson.Gson;

/**
 * ****************************************************************************
 * @Package:      [com.founder.syrk.controller.SjzdlcgController.java]  
 * @ClassName:    [SjzdlcgController]   
 * @Description:  [上级指定列撤管]   
 * @Author:       [xu_wenjun@founder.com.cn]  
 * @CreateDate:   [2015-1-28 下午1:58:12]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-1-28 下午1:58:12，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Controller
@RequestMapping(value = "zdrySjzdlcg")
public class ZdrySjzdlcgController extends BaseController {
	
	private Logger logger = Logger.getLogger(this.getClass());
	
	@Resource(name = "zdrySjzdlcgService")
	private ZdrySjzdlcgService zdrySjzdlcgService;
	
	@Resource(name = "zdryLcgService")
	private ZdryLcgService zdryLcgService;
	
	@Resource(name = "zdryZdryzbService")
	private ZdryZdryzbService zdryZdryzbService;
	
	@Resource(name = "sysMessageDao")
	private SysMessageDao sysMessageDao;
	
	@Resource(name = "sysDictGlService")
	private SysDictGlService sysDictGlService;
	
	/**
	 * 
	 * @Title: lgList
	 * @Description: 重点人员指定列表  列管
	 * @param @param page
	 * @param @param rows
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/queryLgZdryzdlb", method = RequestMethod.POST)
	public @ResponseBody EasyUIPage lgList(EasyUIPage page,
			@RequestParam(value = "rows") Integer rows, RyRyjbxxb entity) {
		page.setPagePara(rows);
		return zdrySjzdlcgService.queryLgZdryzdlb(page, entity);
	}
	
	/**
	 * 
	 * @Title: cgList
	 * @Description: 重点人员指定列表  撤管
	 * @param @param page
	 * @param @param rows
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/queryCgZdryzdlb", method = RequestMethod.POST)
	public @ResponseBody EasyUIPage cgList(EasyUIPage page,
			@RequestParam(value = "rows") Integer rows, ZdryZdryzb entity) {
		page.setPagePara(rows);
		//添加[指定部门代码]过滤条件
		entity.setZdlgbmid(getSessionBean().getUserOrgCode());
		return zdrySjzdlcgService.queryCgZdryzdlb(page, entity);
	}
	
	/**
	 * 
	 * @Title: subList
	 * @Description: 重点人员指定列表二级列表查询
	 * @param @param entity
	 * @param @return    设定文件
	 * @return List<ZdryZdryzb>    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/querySubList", method = RequestMethod.POST)
	public @ResponseBody List<ZdryZdryzb> subList(ZdryZdryzb entity) {
		return zdrySjzdlcgService.querySubList(entity);
	}
	
	/**
	 * 
	 * @Title: sjzdlgAdd
	 * @Description: 跳转-上级指定列管
	 * @param @param entity
	 * @param @return    设定文件
	 * @return ModelAndView    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/sjzdlgAdd", method = RequestMethod.GET)
	public ModelAndView sjzdlgAdd(ZdryZdryzb entity) {
		ModelAndView mv = new ModelAndView("zdry/zdrySjzdlcg_sjzdlg");
		//获取姓名,身份证号
		RyRyjbxxb ryjbxxb = zdrySjzdlcgService.queryRyjbxxbById(entity.getRyid());
		if(ryjbxxb != null){
			entity.setXm(ryjbxxb.getXm());
			entity.setZjhm(ryjbxxb.getZjhm());
		}
		Map<String, String> hjdz = zdrySjzdlcgService.getHjdzJson(entity.getRyid());
		List<Map<String, String>> jzdzList = zdrySjzdlcgService.getJzdzJsonList(entity.getRyid());
		List<JSONObject> jsonList = new ArrayList<JSONObject>();
		for(Map<String, String> obj : jzdzList){
			JSONObject jsonObj = JSONObject.fromObject(obj);
			jsonList.add(jsonObj);
		}
		//页面html使用
		mv.addObject("hjdz", hjdz);
		mv.addObject("jzdzList", jzdzList);
		//页面js使用
		mv.addObject("hjdzJson", JSONObject.fromObject(hjdz));
		mv.addObject("jzdzJsonList", jsonList.toString());
		mv.addObject("entity", entity);
		mv.addObject("zdrylx", zdrySjzdlcgService.queryZdrylbLg(entity.getRyid()));
		return mv;
	}
	
	/**
	 * 
	 * @Title: sjzdlgSave
	 * @Description: 上级指定列管 保存
	 * @param @param entity
	 * @param @param zdrylbStr
	 * @param @param dzdmStr
	 * @param @param jzdzzbidStr
	 * @param @param sessionBean
	 * @param @return    设定文件
	 * @return ModelAndView    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/sjzdlgSave", method = RequestMethod.POST)
	public @ResponseBody
	ModelAndView sjzdlgSave(ZdryZdryzb entity, String zdrylbStr, String dzdmStr, String jzdzzbidStr, SessionBean sessionBean){
		ModelAndView mv = new ModelAndView("redirect:/forward/"
				+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		String[] jzdzzbidArray = jzdzzbidStr.split(",");
		sessionBean = getSessionBean(sessionBean);
		ZdryVO zdryVO;
		ZdryZdryzb zdryZdryzb;
		try {
			for(int i = 0; i < jzdzzbidArray.length; i ++){
				zdryZdryzb = new ZdryZdryzb();
				zdryZdryzb.setSyrkid(jzdzzbidArray[i]);
				zdryZdryzb.setZdrygllxdm(entity.getZdrygllxdm());
				zdryZdryzb.setZdlgbmid(sessionBean.getUserOrgCode());
				zdryZdryzb.setZdlgbmmc(sessionBean.getUserOrgName());
				zdryVO = new ZdryVO();
				zdryVO.setZdryZdryzb(zdryZdryzb);
				zdryVO.setZdrylbStr(zdrylbStr);
				ZdryLczywblb zdryLczywblb = new ZdryLczywblb();
				zdryLczywblb.setYwblr_id(sessionBean.getUserId());
				zdryLczywblb.setYwblr_xm(sessionBean.getUserName());
				zdryLczywblb.setYwfqyy("上级指定列管");
				zdryVO.setZdryLczywblb(zdryLczywblb);
				Map<String, String> returnMap = zdryLcgService.saveLg(zdryVO, ZdryLczywblb.NOAPPROVALTYPE, sessionBean);
				//获取重点人员管理类型字典
				Map<String, String> dictMapZdrygllx = new HashMap<String, String>();
				dictMapZdrygllx = sysDictGlService.getDictMap("BD_D_ZDRYLBDM");
				//获取重点人员证件类型字典
				Map<String, String> dictMapCyzjdm = new HashMap<String, String>();
				dictMapCyzjdm = sysDictGlService.getDictMap("D_BZ_CYZJ");
				//向所属派出所所长发送消息
				String zdryzbId = returnMap.get("zdryZbId");
				if(zdryzbId != null){
					zdryZdryzb = zdryZdryzbService.queryById(zdryzbId);
					if(zdryZdryzb != null){
						SysMessage message = new SysMessage();
						message.setFsr(sessionBean.getUserName());
						message.setFsrdm(sessionBean.getUserId());
						message.setFssj(DateUtils.getSystemDateTimeString());
						message.setFsrssdw(sessionBean.getUserOrgName());
						message.setFsrssdwdm(sessionBean.getUserOrgCode());
						message.setXxnr("【"+zdryZdryzb.getXm()+"】（【"+dictMapCyzjdm.get(zdryZdryzb.getCyzjdm())+"】：【"+zdryZdryzb.getZjhm()+"】）已被【"+zdryZdryzb.getZdlgbmmc()+"】列为【"+dictMapZdrygllx.get(zdryZdryzb.getZdrygllxdm())+"】，请开展日常管控工作。");
						message.setXxbt("重点人员指定列管提醒");
						message.setXxlb("1");
						sysMessageDao.saveMessageByOrgAndPos(message, zdryZdryzb.getSspcsdm(), "SZ");
						sysMessageDao.saveMessageByOrg(message, zdryZdryzb.getSszrqdm(), false, false);
					}
				}
			}
			model.put(AppConst.STATUS, AppConst.SUCCESS);
			model.put(AppConst.MESSAGES, "【指定列管】成功！");
			//model.put(AppConst.SAVE_ID, entity.getId());
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
	 * @Title: sjzdcgAdd
	 * @Description: 跳转-上级指定撤管
	 * @param @param entity
	 * @param @param dzdmStr
	 * @param @param jzdzzbidStr
	 * @param @return    设定文件
	 * @return ModelAndView    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/sjzdcgAdd", method = RequestMethod.GET)
	public ModelAndView sjzdcgAdd(ZdryZdryzb entity, String dzdmStr, String jzdzzbidStr) {
		ModelAndView mv = new ModelAndView("zdry/zdrySjzdlcg_sjzdcg");
		entity = zdryZdryzbService.queryById(entity.getId());
		Map<String, String> dz = zdrySjzdlcgService.getCgDzJson(entity.getSyrkid());
		mv.addObject("entity", entity);
		mv.addObject("dz", dz);
		return mv;
	}
	
	/**
	 * 
	 * @Title: sjzdcgSave
	 * @Description: 上级指定撤管 保存
	 * @param @param entity
	 * @param @param cglxdm
	 * @param @return    设定文件
	 * @return ModelAndView    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/sjzdcgSave", method = RequestMethod.POST)
	public @ResponseBody
	ModelAndView sjzdcgSave(ZdryZdryzb entity, String cglxdm){
		ModelAndView mv = new ModelAndView("redirect:/forward/"
				+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		ZdryVO zdryVO;
		try {
			zdryVO = new ZdryVO();
			entity.setZdrygllxdm("6");
			zdryVO.setZdryZdryzb(entity);
			ZdryLczywblb zdryLczywblb = new ZdryLczywblb();
			zdryLczywblb.setYwblr_id(sessionBean.getUserId());
			zdryLczywblb.setYwblr_xm(sessionBean.getUserName());
			zdryLczywblb.setYwfqyy("上级指定撤管");
			zdryVO.setZdryLczywblb(zdryLczywblb);
			Map<String, String> returnMap = zdryLcgService.saveCg(zdryVO, ZdryLczywblb.NOAPPROVALTYPE, sessionBean, cglxdm);
			//获取重点人员管理类型字典
			Map<String, String> dictMapZdrygllx = new HashMap<String, String>();
			dictMapZdrygllx = sysDictGlService.getDictMap("BD_D_ZDRYLBDM");
			//获取重点人员证件类型字典
			Map<String, String> dictMapCyzjdm = new HashMap<String, String>();
			dictMapCyzjdm = sysDictGlService.getDictMap("D_BZ_CYZJ");
			//向所属派出所所长发送消息
			String zdryzbId = returnMap.get("zdryZbId");
			if(zdryzbId != null){
				ZdryZdryzb zdryZdryzb = zdryZdryzbService.queryById(zdryzbId);
				if(zdryZdryzb != null){
					SysMessage message = new SysMessage();
					message.setFsr(sessionBean.getUserName());
					message.setFsrdm(sessionBean.getUserId());
					message.setFssj(DateUtils.getSystemDateTimeString());
					message.setFsrssdw(sessionBean.getUserOrgName());
					message.setFsrssdwdm(sessionBean.getUserOrgCode());
					message.setXxnr("【"+dictMapZdrygllx.get(zdryZdryzb.getZdrygllxdm())+"】【"+zdryZdryzb.getXm()+"】（【"+dictMapCyzjdm.get(zdryZdryzb.getCyzjdm())+"】：【"+zdryZdryzb.getZjhm()+"】）已被【"+zdryZdryzb.getZdlgbmmc()+"】指定撤管。");
					message.setXxbt("重点人员指定撤管提醒");
					message.setXxlb("1");
					sysMessageDao.saveMessageByOrgAndPos(message, zdryZdryzb.getSspcsdm(), "SZ");
					sysMessageDao.saveMessageByOrg(message, zdryZdryzb.getSszrqdm(), false, false);
				}
			}
			model.put(AppConst.STATUS, AppConst.SUCCESS);
			model.put(AppConst.MESSAGES, "【指定撤管】成功！");
			//model.put(AppConst.SAVE_ID, entity.getId());
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
	 * @Title: getZdrylbdmExceptYlg
	 * @Description: 根据大类取小类,去掉已列管
	 *     增加指定列撤管的过滤条件(对多个地址循环过滤)
	 * @param @param zdrylxdm
	 * @param @param syrkid
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 
	@RequestMapping(value = "/getZdrylbdmExceptYlg", method = RequestMethod.POST)
	public@ResponseBody String getZdrylbdmExceptYlg(String zdrylxdm,String syrkidStr){
		String[] syrkidArray = syrkidStr.split(",");
		String zdrylbdm="";
		List<Zdrylxylbdyb> zdrylbdmList=zdrylxylbdybService.queryZdrylbdm(zdrylxdm);
		List<String> zdrylbdmListStr = zdrkglService.getZdrylbdmExceptYlg(zdrylbdmList, syrkidArray[0]);
		//多个地址,从第二个循环 begin
		for(int i = 1; i < syrkidArray.length; i++){
			//待删除list
			List<Zdrylxylbdyb> deleteList = new ArrayList<Zdrylxylbdyb>();
			for(int j = 0; j < zdrylbdmList.size(); j++){
				boolean flag = false;
				for(int k = 0; k < zdrylbdmListStr.size(); k++){
					if(zdrylbdmList.get(j).getZdrylbdm().equals(zdrylbdmListStr.get(k))){//没有过滤掉
						flag = true;
						break;
					}
				}
				if(flag){
					continue;
				}else{//删除，继续下次过滤
					deleteList.add(zdrylbdmList.get(j));
				}
			}
			zdrylbdmList.removeAll(deleteList);//删除上一次过滤的
			zdrylbdmListStr = zdrkglService.getZdrylbdmExceptYlg(zdrylbdmList, syrkidArray[i]);
		}
		//多个地址,从第二个循环 end
		 for(int i = 0; i < zdrylbdmListStr.size(); i++) {
				if(i==zdrylbdmListStr.size()-1){
					zdrylbdm+= zdrylbdmListStr.get(i);
				}else{
					zdrylbdm+= zdrylbdmListStr.get(i)+"|";
				}
			}
		 return zdrylbdm;
	}
	*/
}
