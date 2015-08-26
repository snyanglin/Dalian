package com.founder.sydw.controller;
 
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.beanutils.MethodUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.founder.framework.base.controller.BaseController;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.components.AppConst;
import com.founder.framework.dictionary.service.SysDictGlService;
import com.founder.framework.exception.BussinessException;
import com.founder.framework.utils.DateUtils;
import com.founder.framework.utils.EasyUIPage;
import com.founder.sydw.bean.Cyryxxb;
import com.founder.sydw.bean.DwOwnMbXmyjBean;
import com.founder.sydw.bean.DwOwnMqZgryBean;
import com.founder.sydw.bean.Dwbmxxb;
import com.founder.sydw.bean.Dwjbxxb;
import com.founder.sydw.bean.DwjbxxbBay;
import com.founder.sydw.bean.Dwjqdtjlb;
import com.founder.sydw.bean.Frfzrllrb;
import com.founder.sydw.service.DwjbxxbService;
import com.founder.sydw.service.SydwEditService;
import com.founder.sydw.vo.SydwgnVO;
import com.founder.sydw.vo.SydwxxzsVO;

import com.google.gson.Gson;
/**
 * 单位查看编辑控制器
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/sydwgl")
public class SydwEditController extends BaseController {
	
	private Logger logger = Logger.getLogger(this.getClass());
	
	@Resource(name="sydwEditService")
	private SydwEditService sydwEditService;
	
	@Resource(name="dwjbxxbService")
	private DwjbxxbService dwjbxxbService;
	
	@Resource(name = "sysDictGlService")
	private SysDictGlService sysDictGlService;
	
	/**
	 * 单位查看编辑页面
	 * @param id
	 * @return
	 * @throws BussinessException
	 */
	@RequestMapping(value="view", method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView view(@RequestParam(value = "id") String id,@RequestParam(value = "mode",required=false,defaultValue="") String mode)	throws BussinessException {
		ModelAndView mv = new ModelAndView("sydw/sydwEdit");
		Dwjbxxb entity = sydwEditService.queryDwjbxxbById(id);
		if (entity == null)
			throw new BussinessException("没有查到此单位！");
		Dwjbxxb sjdwEntity = sydwEditService.queryDwjbxxbById(entity.getSjdwid());
		 List<Dwbmxxb> bmList = dwjbxxbService.queryDwbmxxbByDwid(entity.getId());
		 String bm="";
		for (int i = 0; i < bmList.size(); i++) {
			String str = bmList.get(i).getDwbm();
			if(str!=null){
				bm=bm + str +",";
			}
		}
		if(bm.length()>1){
			 bm = bm.substring(0, bm.length()-1);
		}
		entity.setDwbm(bm);
		 
		if(null!=sjdwEntity){
	     entity.setSjdwmc(sjdwEntity.getDwmc());
		}
		SessionBean sessionBean = getSessionBean();
		if (sessionBean != null) {
			mv.addObject("pcsdm", sessionBean.getExtendValue("ssPcsCode"));
			mv.addObject("zrqdm", sessionBean.getUserOrgCode());
			mv.addObject("pcsmc", sessionBean.getExtendValue("ssPcsName"));
			mv.addObject("fsxdm", sessionBean.getExtendValue("ssFsxCode"));
			mv.addObject("fsxmc", sessionBean.getExtendValue("ssFsxName"));
			mv.addObject("dsjdm", sessionBean.getExtendValue("ssDsjCode"));
			mv.addObject("dsjmc", sessionBean.getExtendValue("ssDsjName"));
		}
		logger.info("查看实有单位:"+entity.getDwmc());
		String dwlx = entity.getDwlbdm();
		if(dwlx.startsWith("21")){
			dwlx="210";
		}else if(dwlx.startsWith("22")){
			dwlx="220";
		}else if(dwlx.startsWith("23")){
			dwlx="230";
		}else if(dwlx.startsWith("26")){
			dwlx="260";
		}else if(dwlx.startsWith("31")){
			dwlx="310";
		}else if(dwlx.startsWith("32")){
			dwlx="320";
		}else if(dwlx.startsWith("33")){
			dwlx="330";
		}else if(dwlx.startsWith("34")){
			dwlx="340";
		}else if(dwlx.startsWith("36")||dwlx.startsWith("37")||dwlx.startsWith("38")){
			dwlx="360";
		}else if(dwlx.startsWith("41")||dwlx.startsWith("42")||dwlx.startsWith("43")){
			dwlx="400";
		}else {
			
		}
		mv.addObject("dwlx", dwlx);
		mv.addObject("dw", entity);
		if("partview".equals(mode)){
			mv.addObject("mode", "view");
			mv.addObject("partview", "true");
		}else{
			mv.addObject("mode", mode);
		}
		
		//这里添加单位近期动态记录展示功能
		 List<Dwjqdtjlb> jlList = sydwEditService.queryDwjqdtjl(id);
		 mv.addObject("jqdtjl", jlList);
		List<Frfzrllrb> list = sydwEditService.queryFrfzr(id);
		if(list != null){
			for (Iterator<Frfzrllrb> iterator = list.iterator(); iterator.hasNext();) {
				Frfzrllrb temp = iterator.next();
				/*
				 * 常东旭  2014-09-25 修改bug1239时修改
				 * 开始
				 */
				String[] strarray = null;
				String a = temp.getDwrylxdm();
				System.out.println(a);
				if(a!=null){
					strarray = a.split(",");
					if(checkdwrylx("1",strarray)){
						mv.addObject("fr", temp);
					}
					if(checkdwrylx("2",strarray)){
						mv.addObject("fzr", temp);
					}
					if(checkdwrylx("3",strarray)){
						mv.addObject("lly", temp);
					}
				}
				/*
				 * 结束
				 */
			}
		}
		return mv;
	}
	/*
	 * 常东旭2014-09-25修改bug1239添加
	 */
	private boolean checkdwrylx(String flag,String[] m){
		boolean f = false;
		for (int i = 0; i < m.length; i++) {
			if (flag.equals(m[i])) {
				f=true;
			}
		}
		return f;
	}
	
	@RequestMapping(value="queryDwzsxx",method = RequestMethod.POST)
	public @ResponseBody List<SydwxxzsVO> queryDwzsxx(@RequestParam(value = "sydwlx") String sydwlx){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("sydwlx", sydwlx);
		return sydwEditService.queryDwzsxx(map);
	}
	
	@RequestMapping(method = { RequestMethod.GET, RequestMethod.POST }, value = "/service/{method}")
	public @ResponseBody Map<String, Object> handleRequest(
			@PathVariable(value = "method") String methodName) throws Exception {
		Map<String, Object> params = getParams(super.getRequest());
		params.put("sessionBean", getSessionBean());
		Map<String, Object> model = new HashMap<String, Object>();
		if (methodName != null) {
			methodName += "_query";
			try {
				model.put("entity", MethodUtils.invokeMethod(sydwEditService,methodName, params));
				// model.put("fields",
				// getFieldDesc(MethodUtils.getAccessibleMethod(syrkService.getClass(),
				// methodName , Map.class)));
			} catch (NoSuchMethodException e) {
			} catch (InvocationTargetException inv) {
				throw new Exception(inv.getTargetException().getCause()
						.getLocalizedMessage(), inv.getTargetException()
						.getCause());
			}
		}
		return model;
	}

	private List<String> getFieldDesc(Class<?> clazz) {
		List<String> fieldList = new ArrayList<String>();
		for (Field f : clazz.getDeclaredFields()) {
			fieldList.add(f.getName());
		}
		return fieldList;
	}

	@SuppressWarnings("unused")
	private List<String> getFieldDesc(Method m) {
		Type type = m.getGenericReturnType();
		if (type instanceof ParameterizedType) {
			return getFieldDesc((Class<?>) ((ParameterizedType) type)
					.getActualTypeArguments()[0]);
		} else {
			return getFieldDesc(m.getReturnType());
		}
	}
	
	/**
	 * 业务办理与可增加信息查询
	 * @param sydwlx
	 * @param gnlxdm 1 ，2
	 * @return
	 */
	@RequestMapping(value = "/queryYwglgn", method = RequestMethod.POST)
	public @ResponseBody List<SydwgnVO> queryYwglgn(@RequestParam(value = "sydwlx") String sydwlx,String gnlxdm) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("sydwlx", sydwlx);
		map.put("gnlxdm", gnlxdm);
		return sydwEditService.queryYwglgn(map);
	}
	
	/**
	 * 跳转-实有单位子项信息注销页面
	 * @param url
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/delete_xxzsnrb", method = RequestMethod.GET)
	public ModelAndView delete_xxzsnrb(String url, String id){
		ModelAndView mv = new ModelAndView("sydw/sydwmessagEdit");
		mv.addObject("url", url);
		mv.addObject("id", id);
		return mv;
	}
	/**
	 * 注销实有单位子项信息
	 * @param url
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/calcle_xxzsnrb", method = RequestMethod.POST)
	public ModelAndView calcle_xxzsnrb(String url, String id,String xt_zxyy){
		ModelAndView mv = new ModelAndView("redirect:/forward/"	+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		Map<String , Object> map=new HashMap<String , Object>();
		if (sessionBean != null) {
			map.put("xt_zhxgrxm", sessionBean.getUserName());
			map.put("xt_zhxgrid", sessionBean.getUserId());
			map.put("xt_zhxgrbm", sessionBean.getUserOrgName());
			map.put("xt_zhxgrbmid", sessionBean.getUserOrgCode());
			map.put("xt_zhxgip", sessionBean.getRemoteAddr());
		}
		map.put("xt_zhxgsj", DateUtils.getSystemDateTimeString());
		map.put("url", url);
		map.put("id", id);
		map.put("xt_zxyy",xt_zxyy);
		try{
			sydwEditService.delete_xxzsnrb(map);
			model.put(AppConst.STATUS, AppConst.SUCCESS);
			model.put(AppConst.MESSAGES, "注销成功！");
		}catch (Exception e) {
			logger.error(e.getMessage(), e);
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, "注销失败！");
		}
		
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}
	
	/**
	 * 根据字段查询记录是否存在
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/checkIfExistByCol", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object>  checkIfExistByCol(String colMap){
		Map<String, Object> model = new HashMap<String, Object>();
		JSONObject jsonObj = null;
		String tableName = "";
		List<Map<String, Object>> colList;
		Map<String, Object> map = new HashMap<String, Object>();
		int count = 0;
		try {
			jsonObj = JSONObject.fromObject(colMap);
			tableName = jsonObj.getString("tableName");
			colList = (List<Map<String, Object>>) jsonObj.get("colList");
			map.put("tableName", tableName);
			map.put("colList", colList);
			count = sydwEditService.getCountByCol(map);
			model.put("count", count);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}
	
	
	@RequestMapping(value = "/cyryxxb_query_new", method = RequestMethod.POST)
	@ResponseBody
	public List<Cyryxxb> cyryxxb_query_new(String dwid){
		return sydwEditService.cyryxxb_query_new(dwid);
	}
	
	@RequestMapping(value = "/cyryxxb_query_more", method = RequestMethod.GET)
	public ModelAndView cyryxxb_query_more(String dwid,String mode){
		ModelAndView mv = new ModelAndView("sydw/cyryxxbDetail");
		mv.addObject("dwid", dwid);
		mv.addObject("mode", mode);
		return mv;
	}
	
	@RequestMapping(value = "/cyryxxb_query_all", method = RequestMethod.POST)
	@ResponseBody
	public EasyUIPage cyryxxb_query_all(EasyUIPage page, Integer rows, String condition, String dwid){
		page.setPagePara(rows);
		return sydwEditService.cyryxxb_query_all(page, condition, dwid);
	}
	
	@RequestMapping(value = "/cyryxxb_query_all_count", method = RequestMethod.POST)
	@ResponseBody
	public long cyryxxb_query_all_count(EasyUIPage page, Integer rows, String condition, String dwid){
		return sydwEditService.cyryxxb_query_all_count(condition, dwid);
	}
	
	@RequestMapping(value = "/cyryxxb_export")
	public void cyryxxb_query_all_export(String dwid, HttpServletResponse response){
		response.setContentType("application/binary;charset=UTF-8");
		try {
			ServletOutputStream outputStream = response.getOutputStream();
			String fileName = new String(("从业人员信息表").getBytes(), "ISO8859-1");
			response.setHeader("Content-disposition", "attachment;filename=dw_cyryxxb_" + DateUtils.getSystemDateString() + ".xlsx");
	
			String[] titleArray = {"身份证号码","姓名 ","性别","出生日期","居住地址","联系电话","工作部门","工种","进公司时间"};
			String[] keyArray = {"zjhm","xm","xbdm","csrq","dz_xzzxz","lxdh","szbmmc","zylbdm","pysj"};
		
			List<Map<String, String>> list = sydwEditService.cyryxxb_query_all_export(dwid);
			//添加性别转换
			Map<String,String> dictMap = sysDictGlService.getDictMap("D_BZ_XB");
			for (int i = 0; i < list.size(); i++) {
				Map<String,String> map = list.get(i);
				list.get(i).put("XBDM", dictMap.get(list.get(i).get("XBDM")));
			}
			sydwEditService.exportExcel(titleArray, keyArray, list, outputStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "/baryxxb_query_new", method = RequestMethod.POST)
	@ResponseBody
	public List<DwjbxxbBay> baryxxb_query_new(String dwid){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("dwid", dwid);
		return sydwEditService.dwxyaqxxbBay_query(map);
	}
	/**
	 * ****************************************************************************
	 * @UpdateUser:   [star]   
	 * @UpdateDate:   [2015-4-27]   
	 * @UpdateRemark: [民爆单位-实施项目业绩,]  
	 * @Version:      [v1.0]
	 * @UpdateUser:   [star]   
	 */
	//@star开始
	/**
	 * 民爆单位-实施项目业绩
	 */
	
	@RequestMapping(value = "/mbsgxm_query_new", method = RequestMethod.POST)
	@ResponseBody
	public List<DwOwnMbXmyjBean> mbsgxm_query_new(String dwid){
		return sydwEditService.mbsgxm_query_new(dwid);
	}
	@RequestMapping(value = "/mbsgxm_query_more", method = RequestMethod.GET)
	public ModelAndView mbsgxm_query_more(String dwid,String mode){
		ModelAndView mv = new ModelAndView("sydw/mbsgxmDetail");
		mv.addObject("dwid", dwid);
		mv.addObject("mode", mode);
		return mv;
	}
	@RequestMapping(value = "/mbsgxm_query_all", method = RequestMethod.POST)
	@ResponseBody
	public EasyUIPage mbsgxm_query_all(EasyUIPage page, Integer rows, String condition, String dwid){
		page.setPagePara(rows);
		return sydwEditService.mbsgxm_query_all(page, condition, dwid);
	}
	
	@RequestMapping(value = "/mbsgxm_query_all_count", method = RequestMethod.POST)
	@ResponseBody
	public long mbsgxm_query_all_count(EasyUIPage page, Integer rows, String condition, String dwid){
		return sydwEditService.mbsgxm_query_all_count(condition, dwid);
	}
	/**
	 * 民枪单位-民枪专管人员
	 */
	@RequestMapping(value = "/mqzgry_query_new", method = RequestMethod.POST)
	@ResponseBody
	public List<DwOwnMqZgryBean> mqzgry_query_new(String dwid){
		return sydwEditService.mqzgry_query_new(dwid);
	}
	@RequestMapping(value = "/mqzgry_query_more", method = RequestMethod.GET)
	public ModelAndView mqzgry_query_more(String dwid,String mode){
		ModelAndView mv = new ModelAndView("sydw/mqzgryDetail");
		mv.addObject("dwid", dwid);
		mv.addObject("mode", mode);
		return mv;
	}
	@RequestMapping(value = "/mqzgry_query_all", method = RequestMethod.POST)
	@ResponseBody
	public EasyUIPage mqzgry_query_all(EasyUIPage page, Integer rows, String condition, String dwid){
		page.setPagePara(rows);
		return sydwEditService.mqzgry_query_all(page, condition, dwid);
	}
	
	@RequestMapping(value = "/mqzgry_query_all_count", method = RequestMethod.POST)
	@ResponseBody
	public long mqzgry_query_all_count(EasyUIPage page, Integer rows, String condition, String dwid){
		return sydwEditService.mqzgry_query_all_count(condition, dwid);
	}
	/**
	 * 自助银行
	 */	
	@RequestMapping(value = "/zzyh_query_all", method = RequestMethod.POST)
	@ResponseBody
	public EasyUIPage zzyh_query_all(EasyUIPage page, Integer rows, String condition, String dwid){
		page.setPagePara(rows);
		return sydwEditService.zzyh_query_all(page, condition, dwid);
	}
	@RequestMapping(value = "/zzyh_query_all_count", method = RequestMethod.POST)
	@ResponseBody
	public long zzyh_query_all_count(EasyUIPage page, Integer rows, String condition, String dwid){
		return sydwEditService.zzyh_query_all_count(condition, dwid);
	}
	/**
	 * 校车
	 */	
	@RequestMapping(value = "/xc_query_all", method = RequestMethod.POST)
	@ResponseBody
	public EasyUIPage xc_query_all(EasyUIPage page, Integer rows, String condition, String dwid){
		page.setPagePara(rows);
		return sydwEditService.xc_query_all(page, condition, dwid);
	}
	@RequestMapping(value = "/xc_query_all_count", method = RequestMethod.POST)
	@ResponseBody
	public long xc_query_all_count(EasyUIPage page, Integer rows, String condition, String dwid){
		return sydwEditService.xc_query_all_count(condition, dwid);
	}

	/**
	 * 护校队
	 */	
	@RequestMapping(value = "/hxd_query_all", method = RequestMethod.POST)
	@ResponseBody
	public EasyUIPage hxd_query_all(EasyUIPage page, Integer rows, String condition, String dwid){
		page.setPagePara(rows);
		return sydwEditService.hxd_query_all(page, condition, dwid);
	}
	@RequestMapping(value = "/hxd_query_all_count", method = RequestMethod.POST)
	@ResponseBody
	public long hxd_query_all_count(EasyUIPage page, Integer rows, String condition, String dwid){
		return sydwEditService.hxd_query_all_count(condition, dwid);
	}
	//@star结束
}
