package com.founder.spsxt.controller;

import java.io.FileInputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import com.founder.framework.base.controller.BaseController;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.components.AppConst;
import com.founder.framework.config.SystemConfig;
import com.founder.framework.exception.BussinessException;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.spsxt.bean.Spjkxt;
import com.founder.spsxt.bean.Spjsdw;
import com.founder.spsxt.bean.Spsxt;
import com.founder.spsxt.bean.Sxtpath;
import com.founder.spsxt.service.NameValuePairService;
import com.founder.spsxt.service.SpdlqyService;
import com.founder.spsxt.service.SptglService;
import com.founder.spsxt.vo.SpsxtZBVO;

import com.google.gson.Gson;
@Controller
@RequestMapping(value = "/sptgl")
public class SptglController extends BaseController {

	private Logger logger = Logger.getLogger(this.getClass());
	@Value("#{jfxtConfigProperties['sxt.photo.path']}")  //spring注入  
	private String path_m; //摄像头图片基准路径
	
	@Resource(name="sptglService")
	private SptglService sptglService;
	
	@Resource(name="nameValuePairService")
	private NameValuePairService nameValuePairService; 
	
	//根据摄像头条码查询坐标信息
	
	@RequestMapping(value = "/getSpsxtZB", method = RequestMethod.POST)
	public @ResponseBody
	Map getSpsxtZB(String tm) {
		
		Map<String, Object> model = new HashMap<String, Object>();
		Map map = sptglService.getSpsxtZB(tm);
		//SpsxtZBVO sxtZBxxVo = sptglService.getSpsxtZB(tm);
		int countSxt=sptglService.queryByTm(tm);
		SpsxtZBVO sxtZBxxVo = new SpsxtZBVO();
		if(countSxt<1){
			try {
				sxtZBxxVo.setBarcode((String)map.get("BARCODE"));
				sxtZBxxVo.setTeldegree((String)map.get("TELDEGREE"));
				sxtZBxxVo.setTelori((String)map.get("TELORI"));
				sxtZBxxVo.setZpjl((String)map.get("PIC_LOCATION"));
				BigDecimal latDecimal=(BigDecimal)map.get("LAT");
				BigDecimal lonDecimal=(BigDecimal)map.get("LON");
				
				sxtZBxxVo.setLat((latDecimal==null)?null:latDecimal.toString());
				sxtZBxxVo.setLon((lonDecimal==null)?null:lonDecimal.toString());
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		else{
			sxtZBxxVo.setBarcode("haven");
		}
		model.put("sxtZBxxVo", sxtZBxxVo);
		return model;
	}
	//选择视频建设单位
	@RequestMapping(value = "/getSpsxtJsdw", method = RequestMethod.GET)
	public @ResponseBody List getSpsxtJsdw() {
		//Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		String xt_lrrid=sessionBean.getUserId();
		List spjsdwListOfMap =sptglService.getSpsxtJsdw(xt_lrrid);

		//model.put("spjsdwListOfMap", spjsdwListOfMap);
		return spjsdwListOfMap;
	}	
	//选择视频监控系统
	@RequestMapping(value = "/getSpjkxtByDw", method = RequestMethod.GET)
	public @ResponseBody List getSpjkxtByDw(String dwbm){
		
		List spjkxtList =sptglService.getSpjkxtByDw(dwbm);
		System.out.println("长度"+spjkxtList.size());
		//model.put("spjkxtList", spjkxtList);
		return spjkxtList;
	}
	
	//选择所在地理区域
	@RequestMapping(value = "/getSzdlqy", method = RequestMethod.GET)
	public @ResponseBody List getSzdlqy(){
		SessionBean sessionBean = getSessionBean();
		String xt_lrrbmid=sessionBean.getUserOrgCode();
		List spdlqyList = null;
		String orglevel= sptglService.getOrgLevel(xt_lrrbmid);
		//System.out.println("getUserOrgName"+sessionBean.getUserOrgName());
		if( orglevel.equals("50")){
			spdlqyList=	sptglService.getSzdlqy(xt_lrrbmid);
		}
		else{
			spdlqyList=	sptglService.getSzdlqyQS();
		};
		//model.put("spdlqyList", spdlqyList);
		return spdlqyList;
	}
	
	//查询民警所有的摄像头(为地图纠偏),可以考虑增加其它条件
	@RequestMapping(value = "/querySpsxtForMap", method = RequestMethod.GET)
	public @ResponseBody List querySpsxtForMap(String add){
		SessionBean sessionBean=getSessionBean();
		String pcsbm=sessionBean.getUserOrgCode();//派出所编码
		String policeId=sessionBean.getUserId();//民警警号		
		List spsxtListOfMap=sptglService.querySpsxtForMap(pcsbm,policeId,add);		
		return spsxtListOfMap;		
	}

	//根据主键修改摄像头经纬度 longitude:longitudeNew,latitude:latitudeNew
	@RequestMapping(value = "/modifyCoordinateById", method = RequestMethod.GET)
	public @ResponseBody int modifyCoordinateById(String jd, String wd, String id) {
		return sptglService.modifyCoordinateById(jd, wd, id);
	}
	
	@RequestMapping(value = "/getSsjgdmName", method = RequestMethod.POST)
	public @ResponseBody Map getSsjgdmName(){
		SessionBean sessionBean=getSessionBean();
		String xt_lrrbmid=sessionBean.getUserOrgCode();
		Map<String, String>  org=new HashMap<String, String>();
		String orglevel= sptglService.getOrgLevel(xt_lrrbmid);
		//System.out.println("getUserOrgName"+sessionBean.getUserOrgName());
		if( orglevel.equals("50")){
			org=sptglService.getSsjgdm(xt_lrrbmid);
		}
		else{
			org.put("ORGNAME", sessionBean.getUserOrgName());
		}
		return org;
	}
	/**
	 * 显示摄像头图片
	 */
	@RequestMapping(value = "/showPicJspOLD", method = RequestMethod.GET)
	public @ResponseBody ModelAndView showPicJspOLD(String path,HttpServletResponse response){
		ModelAndView mv = new ModelAndView("jfxt/picShow");
		System.out.println("picShow-->path"+path);
		//ServletContext sc=getSession().getServletContext();
		//WebApplicationContext webApplicationContext=ContextLoader.getCurrentWebApplicationContext();
		//WebApplicationContext webApplicationContext=(WebApplicationContext)sc.getAttribute();
		//String path_m= sc.getInitParameter("spsxtFolderPath");
		System.out.println("picShow-->path_m"+path_m);
		Sxtpath entity=new Sxtpath();
		
		String path_s="";//数据库表里的文件夹位置（tm.png前的路径）
		String path_n=path;//新路径
		int i;
		//路径不为空
		if(path.length()>1){
			//取数据库表里的文件夹位置
			for(i=path.length()-1;i>=0;i--){
				if(path.charAt(i)=='/'){
					break;
				}
			}
			path_s=path.substring(0,i+1);
			System.out.println("path_s====>"+path_s);
			//数据表里的文件夹位置与配置文件里的位置不一致
			if(!path_s.equals(path_m)){
				path_n=path_m+path.substring(i+1);
			}
			
		}
		//路径为空
		else{
			//没有照片，提示！
			entity.setMsg("该摄像头没有采集照片！");
		}
		
		entity.setPath(path_n);
		System.out.println("picShow-->path_s  "+path_s);
		System.out.println("picShow-->path_n  "+path_n);
		mv.addObject("entity", entity);
		return mv;
	}
	
	/**2015-03-30
	 * 显示摄像头图片
	 */
	@RequestMapping(value = "/showPicJsp.jpg", method = RequestMethod.GET)
	public HttpEntity<byte[]> showPicJsp(String sxtid) {
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.IMAGE_JPEG);
		Sxtpath sxtpath = sptglService.getPDASxtPic(StringUtils.nullToStr(sxtid));
		if (sxtpath != null && sxtpath.getZp() != null
				&& sxtpath.getZp().length > 0) {
			headers.setContentLength(sxtpath.getZp().length);
			return new HttpEntity(sxtpath.getZp(), headers);
		} else {
			byte[] empty_ryzp = SystemConfig.getByteArray("empty_ryzp");
			headers.setContentLength(empty_ryzp.length);
			return new HttpEntity(empty_ryzp, headers);
		}
	}
	
	@RequestMapping(value = "/showPic", method = RequestMethod.GET)
	public @ResponseBody void showPic(String path,HttpServletResponse response){
		//String path=new PicpathVO().getPath();
		//System.out.println("@@@@@@-->path"+path);
		
		//String path_n="D:\\temp\\pic\\loginBoxBg.png";//新路径
		//path="D:\\temp\\pic\\loginBoxBg.png";
		if(path!=null&&path.length()>1){
			try{
				InputStream ips = new FileInputStream(path);
				ServletOutputStream sos=response.getOutputStream();
				byte[] btfolder=new byte[1024];//new byte[ips.available()];
				//分段读取
				int n;
				while((n=ips.read(btfolder))!=-1){
					sos.write(btfolder);
				}
				
				//ips.read(btfolder);
				//System.out.println("byte长度"+btfolder.length);
				//sos.write(btfolder);
				sos.close();
				
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return ;
	}
	/**
	 * 更新和保存
	 * @param entity
	 * @return
	 */
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public @ResponseBody ModelAndView save(HttpSession session,Spsxt entity) {
		ModelAndView mv = new ModelAndView("redirect:/forward/"+AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		
		SessionBean sessionBean = getSessionBean();
		if(null != sessionBean){
			entity.setXt_lrrxm(sessionBean.getUserName());
			entity.setXt_lrrid(sessionBean.getUserId());
			entity.setXt_lrrbm(sessionBean.getUserOrgName());
			entity.setXt_lrrbmid(sessionBean.getUserOrgCode());
		}
		
		String orglevel= sptglService.getOrgLevel(entity.getXt_lrrbmid());
		if( orglevel.equals("50")){
			
			Map<String, String>  org=sptglService.getSsjgdm(entity.getXt_lrrbmid());
			String ssjgdm=org.get("ORGCODE");
			//entity.setSsjgdm(ssjgdm);
			entity.setSxtgldw(ssjgdm);
		}
		else {
			entity.setSxtgldw(entity.getXt_lrrbmid());
		}
		String sfgazj=(String)session.getAttribute("owner");
		if(sfgazj.equals("noPolice")){
			entity.setSfgazj("0");
		}
		else{
			entity.setSfgazj("1");
		}
		try {
			
			if(entity.getSbgqsx().equals("000")){
				entity.setSb_gqbq("0");
			}
			else{
				entity.setSb_gqbq("1");
			}
			if(entity.getSbyssx().equals("000")){
				entity.setSb_ys("0");
			}
			else{
				entity.setSb_ys("1");
			}
			String sblx=entity.getSb_gqbq()+entity.getSb_qjqj()+entity.getSb_snsw()+entity.getSb_ys();
			//System.out.println("@@@@sblx@@@@"+sblx);
			entity.setSblx(sblx);
			
			
			if (entity.getId() == null || entity.getId().equals("")) {
				sptglService.save(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "新增【摄像头】成功");
				model.put(AppConst.SAVE_ID, entity.getId()); // 返回主键
			} else {
				sptglService.update(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "修改【摄像头】成功");
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
	@RequestMapping(value = "/queryList", method = RequestMethod.POST)
	public @ResponseBody
	EasyUIPage queryList(HttpSession session,EasyUIPage page,@RequestParam(value = "rows") Integer rows) {
		System.out.println("rows="+rows+","+page.getBegin()+","+page.getEnd());
		System.out.println("sort,"+page.getSort()+","+page.getOrder());
		page.setPagePara(rows);
		SessionBean sessionBean = getSessionBean();
		System.out.println("@@@@"+sessionBean.getUserManageOrgCode());
		Map map=new HashMap();
		String sfgazj=(String)session.getAttribute("owner");
		if(sfgazj.equals("noPolice")){
			map.put("sfgazj","0");
		}
		else{
			map.put("sfgazj", "1");
		}
		map.put("xt_lrrbmid", sessionBean.getUserOrgCode());
		map.put("xt_lrrid", sessionBean.getUserId());
		return sptglService.queryList(page, map);
	}
	
	@RequestMapping(value = "/queryListForSxtName", method = RequestMethod.POST)
	public @ResponseBody
	EasyUIPage queryListForSxtName(HttpSession session,EasyUIPage page,@RequestParam(value = "rows") Integer rows,@RequestParam(value = "dwmc",required = false) String dwmc,
			@RequestParam(value = "xt_lrip",required = false) String xt_lrip,String s) {
		
		
		System.out.println("rows="+rows+","+page.getBegin()+","+page.getEnd());
		System.out.println("sort,"+page.getSort()+","+page.getOrder());
		System.out.println("$$$$dwmc,"+dwmc);
		page.setPagePara(rows);
		SessionBean sessionBean = getSessionBean();
		
		
		System.out.println("@@@@"+sessionBean.getUserManageOrgCode());
		Map map=new HashMap();
		//保存条件
		//搜索按钮请求与请它请求区别？
		if(s!=null && s.equals("S")){//点击了搜索按钮
			//移去先前内容
			System.out.println("更新Session");
			session.removeAttribute("sxtNameOld");
			session.removeAttribute("noPerfect");
			//重写新内容
			session.setAttribute("sxtNameOld", dwmc);
			session.setAttribute("noPerfect", xt_lrip);
		}
		else if(session.getAttribute("noPerfect")==null && session.getAttribute("sxtNameOld")==null){//使用先前条件
			session.setAttribute("noPerfect", "Y");
			//session.setAttribute("sxtNameOld",null);
			//System.out.println("读出原来Session");

		}
		dwmc=(String)session.getAttribute("sxtNameOld");
		xt_lrip=(String)session.getAttribute("noPerfect");
		
		System.out.println("s==>"+s+",dwmc==>"+dwmc+",xt_lrip==>"+xt_lrip);
		
		String sfgazj=(String)session.getAttribute("owner");
		if(sfgazj.equals("noPolice")){
			map.put("sfgazj","0");
		}
		else{
			map.put("sfgazj", "1");
		}
		map.put("xt_lrrbmid", sessionBean.getUserOrgCode());
		map.put("xt_lrrid", sessionBean.getUserId());
		map.put("dwmc",dwmc);
		map.put("xt_lrip", xt_lrip);
		return sptglService.queryListForSxtName(page, map);
	}
	
	
	
	@RequestMapping(value = "/spsxtEdit", method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView spdlqyEdit(HttpSession session,@RequestParam(value = "id") String id,@RequestParam(value = "mode",required=false,defaultValue="") String mode)	throws BussinessException {
		String sfgazj=(String)session.getAttribute("owner");
		String modelview="";
		if(sfgazj.equals("noPolice")){
			modelview="jfxt/spsxtAdd";
		}
		else{
			modelview="jfxt/gaOwner/ga_spsxtAdd";
		}
		ModelAndView mv = new ModelAndView(modelview);//jfxt/spsxtModify
		Spsxt entity =  sptglService.queryById(id);
		mv.addObject("entity", entity);
		mv.addObject("mode", mode);
		return mv;
	}


	
	
	
	
	//根据摄像头id查找建设单位
	@RequestMapping(value = "/queryJsdwBySxtId", method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView  queryJsdwBySxtId(@RequestParam(value = "id") String id){
		ModelAndView mv = new ModelAndView("jfxt/spjsdwJYXX");
		Spjsdw entity = sptglService.queryJsdwBySxtId(id);
		mv.addObject("entity",entity);
		return mv;
	}
	//根据摄像头id查找监控系统
	@RequestMapping(value = "/queryJkxtBySxtId", method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView  queryJkxtBySxtId(@RequestParam(value = "id") String id){
		ModelAndView mv = new ModelAndView("jfxt/spjkxtJYXX");
		Spjkxt entity = sptglService.queryJkxtBySxtId(id);
		mv.addObject("entity",entity);
		return mv;
	}
	//根据摄像头id查找监控系统
	@RequestMapping(value = "/showSXTxxxx", method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView  showSXTxxxx(@RequestParam(value = "id") String id){
		ModelAndView mv = new ModelAndView("jfxt/spsxtJYXX");
		Spsxt entity = sptglService.queryById(id);
		mv.addObject("entity",entity);
		return mv;
	}
	
	
	//根据主键删除实体对象	
	@RequestMapping(value = "/spsxtDel", method = RequestMethod.GET)
	public ModelAndView spsxtDel(HttpSession session,@RequestParam(value = "id") String id) {
		String sfgazj=(String)session.getAttribute("owner");
		String modelview="";
		if(sfgazj.equals("noPolice")){
			modelview="jfxt/spsxtList";
		}
		else{
			modelview="jfxt/gaOwner/ga_spsxtList";
		}
		ModelAndView mv = new ModelAndView(modelview);
		int affectedRow=sptglService.delete(id);
		return mv;
	}
	//通用分页查询(根据选择的部门(大部门/小部门))
	@RequestMapping(value = "/queryListByBmid22", method = RequestMethod.POST)
	public @ResponseBody
	EasyUIPage queryListByBmid22(
			EasyUIPage page,@RequestParam(value = "rows") Integer rows,
			@RequestParam(value = "bmid") String bmid ,@RequestParam(value = "dwlx") String dwlx,@RequestParam(value = "dwbm") String dwbm) {
		System.out.println("rows="+rows+","+page.getBegin()+","+page.getEnd());
		System.out.println("sort,"+page.getSort()+","+page.getOrder());
		System.out.println("bmid====>"+bmid);
		page.setPagePara(rows);
		SessionBean sessionBean = getSessionBean();
		
		String pcsbm=sessionBean.getUserOrgCode();//派出所编码
		String policeId=sessionBean.getUserId();//民警警号
		Map map=new HashMap();
		map.put("xt_lrrbmid", sessionBean.getUserOrgCode());
		//处理选择的部门id，从后往前查找第一个非0字符，然后取字串0,pos
		int i;
		for(i=bmid.length()-1;i>=0;i--){
			if(bmid.charAt(i)!='0'){
				break;
			}
		}
		String partBmid=bmid.substring(0,i+1);
		System.out.println(bmid+"====>"+partBmid);
		
		System.out.println("dwbm====>"+dwbm);
		System.out.println("dwlx====>"+dwlx);
		map.put("bmid", partBmid);//查询时选择的部门
		map.put("dwbm", dwbm);//查询时的建设单位
		map.put("dwlx", dwlx);//查询时的行业类型
		
		return sptglService.queryListByBmid(page, map);
	}
	@RequestMapping(value = "/queryListByBmid", method = RequestMethod.POST)
	public @ResponseBody
	EasyUIPage queryListByBmid(
			EasyUIPage page,@RequestParam(value = "rows") Integer rows,
			@RequestParam(value = "bmid") String bmid ) {
		System.out.println("rows="+rows+","+page.getBegin()+","+page.getEnd());
		System.out.println("sort,"+page.getSort()+","+page.getOrder());
		System.out.println("bmid====>"+bmid);
		page.setPagePara(rows);
		SessionBean sessionBean = getSessionBean();
		
		String pcsbm=sessionBean.getUserOrgCode();//派出所编码
		String policeId=sessionBean.getUserId();//民警警号
		Map map=new HashMap();
		
		map.put("bmid", bmid);//查询时选择的部门
		
		return sptglService.queryListByBmid(page, map);
	}
	@RequestMapping(value = "/queryJsdwCount", method = RequestMethod.POST)
	public @ResponseBody int queryJsdwCount(){
		SessionBean sessionBean = getSessionBean();
		Map map=new HashMap();
		map.put("xt_lrrbmid", sessionBean.getUserOrgCode());
		map.put("xt_lrrid", sessionBean.getUserId());
		return sptglService.queryJsdwCount(map);
	}
	
	@RequestMapping(value = "/querySpjkxtCount", method = RequestMethod.POST)
	public @ResponseBody Map querySpjkxtCount(){
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		Map map=new HashMap();
		map.put("xt_lrrbmid", sessionBean.getUserOrgCode());
		map.put("xt_lrrid", sessionBean.getUserId());
		Integer jkxtNum= sptglService.querySpjkxtCount(map);
		Integer jsdwNum= sptglService.queryJsdwCount(map);
		SpsxtZBVO Spsxtvo = new SpsxtZBVO();
		try {
			Spsxtvo.setJsdwNum(jsdwNum.toString());
			Spsxtvo.setJkxtNum(jkxtNum.toString());
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		model.put("Spsxtvo", Spsxtvo);
		return model;
	}
	@RequestMapping(value = "/queryPTNVRCount", method = RequestMethod.POST)
	public @ResponseBody Map queryPTNVRCount(){
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		Map map=new HashMap();
		map.put("xt_lrrbmid", sessionBean.getUserOrgCode());
		map.put("xt_lrrid", sessionBean.getUserId());
		Integer jkxtNum= sptglService.queryNVRCount(map);
		Integer jsdwNum= sptglService.queryPTCount(map);
		SpsxtZBVO Spsxtvo = new SpsxtZBVO();
		try {
			Spsxtvo.setJsdwNum(jsdwNum.toString());
			Spsxtvo.setJkxtNum(jkxtNum.toString());
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		model.put("Spsxtvo", Spsxtvo);
		return model;
	}
	//根据用户orgCode前8位获得其所在派出所的所有责任区
	@RequestMapping(value = "/getSxtZrq")
	public @ResponseBody List getSxtZrq(){
		SessionBean sessionBean = getSessionBean();
		System.out.println("sessionBean.getUserOrgCode()="+sessionBean.getUserOrgCode());
		String orgCode8=sessionBean.getUserOrgCode().substring(0,8);		
		return sptglService.getSxtZrq(orgCode8);
	}	
	
	@RequestMapping(value = "/checkSameName", method = RequestMethod.POST)
	public @ResponseBody int checkSameName(@RequestParam(value = "dwmc")String dwmc){
		//Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		Map<String,String> map=new HashMap<String,String>();
		map.put("xt_lrrid", sessionBean.getUserId());
		map.put("dwmc", dwmc);
		int SameNameNum= sptglService.checkSameName(map);
		
		return SameNameNum;
	}
	@RequestMapping(value = "/checkSameNameSH", method = RequestMethod.POST)
	public @ResponseBody int checkSameNameSH(@RequestParam(value = "dwmc")String dwmc,@RequestParam(value = "dwbm")String dwbm){
		//Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		Map<String,String> map=new HashMap<String,String>();
		map.put("xt_lrrid", sessionBean.getUserId());
		map.put("dwmc", dwmc);
		map.put("dwbm", dwbm);
		int SameNameNum= sptglService.checkSameNameSH(map);
		
		return SameNameNum;
	}
	//监控系统lwsx属性与视频摄像头sfrw属性不一致时提醒用户
	@RequestMapping(value = "/getRemindInfo")
	public @ResponseBody int getRemindInfo(){		
		SessionBean sessionBean = getSessionBean();		
		String currentUser=sessionBean.getUserId();//当前用户ID
		int remindCount= sptglService.getRemindInfo(currentUser);
		System.out.println("remindCount="+remindCount);
		return remindCount;
	}
	//摄像头纠偏分页查询2014.12.20	
	@RequestMapping(value = "/querySpsxtForMap2", method = RequestMethod.POST)
	public @ResponseBody
	EasyUIPage querySpsxtForMap2(HttpSession session,EasyUIPage page,@RequestParam(value = "rows") Integer rows,String locate,String startDate,String endDate,String dwmc) {
		System.out.println("rows="+rows+","+page.getBegin()+","+page.getEnd());
		System.out.println("sort,"+page.getSort()+","+page.getOrder());
		System.out.println("startDate,"+startDate+",endDate:"+endDate);
		
		page.setPagePara(rows);
		SessionBean sessionBean = getSessionBean();
		System.out.println("@@@@"+sessionBean.getUserManageOrgCode());
		Map map=new HashMap();
		String sfgazj=(String)session.getAttribute("owner");
		if(sfgazj.equals("noPolice")){
			map.put("sfgazj","0");
		}
		else{
			map.put("sfgazj", "1");
		}
		map.put("xt_lrrbmid", sessionBean.getUserOrgCode());
		map.put("xt_lrrid", sessionBean.getUserId());
		map.put("locate",locate);//没有经纬度=Y,否则=N		
		map.put("startDate",startDate);
		map.put("endDate",endDate);
		dwmc=(dwmc==null)?"":dwmc;
		map.put("dwmc",dwmc.trim());//点位名称
		return sptglService.querySpsxtForMap2(page, map);
	}	
	@RequestMapping(value = "/checkXTIDBM", method = RequestMethod.POST)
	public @ResponseBody int checkXTIDBM(@RequestParam(value = "xtidbm")String xtidbm){
		//Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		Map<String,String> map=new HashMap<String,String>();
		
		map.put("xtidbm", xtidbm);
		//System.out.println("xtidbm------<<<"+xtidbm);
		int XTIDBMNum= sptglService.checkXTIDBM(map);
		
		return XTIDBMNum;
	}
}