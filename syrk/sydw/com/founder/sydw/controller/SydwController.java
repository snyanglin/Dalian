package com.founder.sydw.controller;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.fileupload.FileItem;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;
import com.google.gson.Gson;
import com.founder.framework.annotation.RestfulAnnotation;
import com.founder.framework.base.controller.BaseController;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.components.AppConst;
import com.founder.framework.exception.BussinessException;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.service.attachment.bean.ZpfjFjxxb;
import com.founder.service.attachment.service.ZpfjFjxxbService;
import com.founder.sydw.bean.Dwbmxxb;
import com.founder.sydw.bean.Dwjbxxb;
import com.founder.sydw.bean.Frfzrllrb;
import com.founder.sydw.service.DwjbxxbService;
import com.founder.sydw.service.FrfzrllrbService;
import com.founder.sydw.service.SydwQueryService;
import com.founder.sydw.vo.DwjbxxbSaveVO;

/**
 * ****************************************************************************
 * @Package:      [com.founder.sydw.controller.SydwController.java]  
 * @ClassName:    [SydwController]   
 * @Description:  [实有单位基础控制器（服务接口）]   
 * @Author:       [weiwen]  
 * @CreateDate:   [2015-2-8 下午3:36:07]   
 * @UpdateUser:   [weiwen]   
 * @UpdateDate:   [2015-2-8 下午3:36:07，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 * @UpdateUser:   [star]   
 * @UpdateDate:   [2015-04-21 ]   
 * @UpdateRemark: [新加图片上传 更新]  
 */
@Controller
@RequestMapping("/sydw")
public class SydwController extends BaseController {

	private Logger logger = Logger.getLogger(this.getClass());

	@Resource(name = "dwjbxxbService")
	private DwjbxxbService dwjbxxbService;

	@Resource(name="sydwQueryService")
	private SydwQueryService sydwQueryService;
	
	
	@Resource(name = "frfzrllrbService")
	private FrfzrllrbService frfzrllrbService;
	
    //@star新增开始
	@Resource(name = "zpfjFjxxbService")
	private ZpfjFjxxbService zpfjFjxxbService;
	//@star新增结束
	/**
	 * 
	 * @Title: saveDwjbxxb
	 * @Description: TODO(新增单位)
	 * @param @param swjbxxbSaveVO
	 * @param @param hsrwid
	 * @param @param sessionBean
	 * @param @return    设定文件
	 * @return ModelAndView    返回类型
	 * @throws
	 * @UpdateUser：star
	 * @新增@RequestParam CommonsMultipartFile[] uploadFile
	 */
	@RestfulAnnotation(valiField="dwjbxxb.dwlbdm,dwjbxxb.dwmc,dwjbxxb.kyrq,dwjbxxb.lxdh,dwjbxxb.dwztdm",serverId="3")
	@RequestMapping(value = "", method = RequestMethod.POST)
	public @ResponseBody ModelAndView saveDwjbxxb(@RequestParam CommonsMultipartFile[] uploadFile,DwjbxxbSaveVO swjbxxbSaveVO, String hsrwid ,SessionBean sessionBean) {
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		Map<String, Object> model = new HashMap<String, Object>();
		Dwjbxxb dwjbxxb = swjbxxbSaveVO.getDwjbxxb();
		Dwbmxxb [] dwbmxxbArray = swjbxxbSaveVO.getDwbmxxbArray();
		sessionBean = getSessionBean(sessionBean);
		//@star新增开始
		String lyid="";
		String lybm="DW_DWJBXXB";
		String lyms="实有单位";
		//@star新增结束
		try {
			if((!StringUtils.isBlank(dwjbxxb.getDz_dwdzdm()) && !StringUtils.isBlank(dwjbxxb.getDz_dwdzmlpdm())  &&
					!StringUtils.isBlank(dwjbxxb.getDz_dwdzmlpxz())  && !StringUtils.isBlank(dwjbxxb.getDz_dwdzssxdm()) &&
					!StringUtils.isBlank(dwjbxxb.getDz_dwdzxz())) ||(!StringUtils.isBlank(dwjbxxb.getDzms_zbx()) &&
							!StringUtils.isBlank(dwjbxxb.getDzms_zby()) && !StringUtils.isBlank(dwjbxxb.getDzms_sspcsdm()) && 
							!StringUtils.isBlank(dwjbxxb.getDzms_sszrqdm()) && !StringUtils.isBlank(dwjbxxb.getDzms_dwdzmlpxz()))){
				//这里判断名称和地址同时重复
				Dwjbxxb  cfDwjbxx = dwjbxxbService.queryByDwmcDwdzdm(dwjbxxb.getDwmc(), dwjbxxb.getDz_dwdzdm());
				if(StringUtils.isBlank(cfDwjbxx)){
					if(StringUtils.isBlank(dwjbxxb.getGlfxjid()))
						dwjbxxb.setGlfxjid(sessionBean.getExtendValue("ssFsxCode"));
					if(StringUtils.isBlank(dwjbxxb.getGlpcsid()))
						dwjbxxb.setGlpcsid(sessionBean.getExtendValue("ssPcsCode"));
					if(StringUtils.isBlank(dwjbxxb.getGlbmid()))
						dwjbxxb.setGlbmid(sessionBean.getUserOrgCode());
					dwjbxxbService.save(dwjbxxb, dwbmxxbArray, hsrwid,	sessionBean);
					model.put(AppConst.STATUS, AppConst.SUCCESS);
					model.put(AppConst.MESSAGES, getAddSuccess());
					model.put(AppConst.SAVE_ID, "" + dwjbxxb.getId()); // 返回主键
				}else{
					model.put(AppConst.STATUS, AppConst.FAIL);
					model.put(AppConst.MESSAGES,"该地址已经有该单位名称，地址和名称不可同时重复");
				}
				//@star图片上传开始
				 lyid=dwjbxxb.getId();
					List<ZpfjFjxxb> list = new ArrayList<ZpfjFjxxb>();
					for (int i = 0; i < uploadFile.length; i++) {
						CommonsMultipartFile multipartFile = uploadFile[i];
						if (!multipartFile.isEmpty()) {
							FileItem fileItem = multipartFile.getFileItem();
							ZpfjFjxxb entity = new ZpfjFjxxb();
							entity.setLybm(lybm);
							entity.setLyid(lyid);
							entity.setLyms(lyms);
							String wjmc = fileItem.getName();
							if (wjmc.indexOf("\\") != -1) { // 去除完整路径
								wjmc = wjmc.substring(wjmc.lastIndexOf("\\") + 1);
							}
							String wjhzlx = "";
							int atI = wjmc.lastIndexOf(".");
							if (atI != -1) {
								wjhzlx = wjmc.substring(atI + 1);
								wjhzlx = wjhzlx.toLowerCase();
							}
							entity.setWjmc(wjmc);
							entity.setWjhzlx(wjhzlx);
							entity.setWj(multipartFile.getBytes());
							long wjdx = entity.getWj().length;
							entity.setWjdx(new Long(wjdx));
							String wjdxsm = "";
							if (wjdx < 1024) {
								wjdxsm = "" + wjdx + " B";
							} else if (wjdx > 1048576) {
								double mb = Math.floor(wjdx / 1048576);
								DecimalFormat formater = new DecimalFormat(
										"###,###,###.00");
								wjdxsm = "" + formater.format(mb) + " MB";
							} else {
								long kb = (long) Math.floor(wjdx / 1024);
								wjdxsm = "" + kb + " KB";
							}
							entity.setWjdxsm(wjdxsm);
							entity.setWjxzcs(new Long(0));
							list.add(entity);
						}
					}
					if (list.size() > 0) {
						zpfjFjxxbService.saveZpfjFjxxb(list, sessionBean);
						model.put(AppConst.STATUS, AppConst.SUCCESS);
						model.put(AppConst.MESSAGES, getAddSuccess());
					} 
				
				//@star图片结束
			}else{
				model.put(AppConst.STATUS, AppConst.FAIL);
				model.put(AppConst.MESSAGES,"地址描述和单位地址选择必须选择其填一个！！");
			}
			
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage(), e);
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, getAddFail());
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}

	/**
	 * 
	 * @Title: updateDwjbxxb
	 * @Description: TODO(单位修改)
	 * @param @param swjbxxbSaveVO
	 * @param @param hsrwid
	 * @param @param sessionBean
	 * @param @return    设定文件
	 * @return ModelAndView    返回类型
	 * @throws
	 * @UpdateUser：star
	 * @新增@RequestParam CommonsMultipartFile[] uploadFile
	 */
	@RestfulAnnotation(valiField="dwjbxxb.id",serverId = "3")
	@RequestMapping(value = "/{dwid}", method = {RequestMethod.PUT,RequestMethod.POST})
	public @ResponseBody ModelAndView updateDwjbxxb(@RequestParam CommonsMultipartFile[] uploadFile,DwjbxxbSaveVO swjbxxbSaveVO, SessionBean sessionBean) {
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		Map<String, Object> model = new HashMap<String, Object>();
		Dwjbxxb dwjbxxb = swjbxxbSaveVO.getDwjbxxb();
		Dwbmxxb [] dwbmxxbArray = swjbxxbSaveVO.getDwbmxxbArray();
		sessionBean = getSessionBean(sessionBean);
		try {
			dwjbxxbService.update(dwjbxxb, dwbmxxbArray,null,	sessionBean);
			model.put(AppConst.STATUS, AppConst.SUCCESS);
			model.put(AppConst.MESSAGES, getUpdateSuccess());
			model.put(AppConst.SAVE_ID, "" + dwjbxxb.getId()); // 返回主键
			//@star图片更新开始
			String lyid="";
			String lybm="DW_DWJBXXB";
			String lyms="实有单位";
			 lyid=dwjbxxb.getId();
					CommonsMultipartFile multipartFile = uploadFile[0];
					if (!multipartFile.isEmpty()) {
						FileItem fileItem = multipartFile.getFileItem();
						ZpfjFjxxb entity = new ZpfjFjxxb();
						entity.setLybm(lybm);
						entity.setLyid(lyid);
						entity.setLyms(lyms);
						String wjmc = fileItem.getName();
						if (wjmc.indexOf("\\") != -1) { // 去除完整路径
							wjmc = wjmc.substring(wjmc.lastIndexOf("\\") + 1);
						}
						String wjhzlx = "";
						int atI = wjmc.lastIndexOf(".");
						if (atI != -1) {
							wjhzlx = wjmc.substring(atI + 1);
							wjhzlx = wjhzlx.toLowerCase();
						}
						entity.setWjmc(wjmc);
						entity.setWjhzlx(wjhzlx);
						entity.setWj(multipartFile.getBytes());
						long wjdx = entity.getWj().length;
						entity.setWjdx(new Long(wjdx));
						String wjdxsm = "";
						if (wjdx < 1024) {
							wjdxsm = "" + wjdx + " B";
						} else if (wjdx > 1048576) {
							double mb = Math.floor(wjdx / 1048576);
							DecimalFormat formater = new DecimalFormat(
									"###,###,###.00");
							wjdxsm = "" + formater.format(mb) + " MB";
						} else {
							long kb = (long) Math.floor(wjdx / 1024);
							wjdxsm = "" + kb + " KB";
						}
						entity.setWjdxsm(wjdxsm);
						entity.setWjxzcs(new Long(0));
						zpfjFjxxbService.updateZpfjFjxxb(entity, sessionBean);
						model.put(AppConst.STATUS, AppConst.SUCCESS);
						model.put(AppConst.MESSAGES, getAddSuccess());
					}
			//@star图片更新结束


		} catch (Exception e) {
			logger.error(e.getLocalizedMessage(), e);
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, getUpdateFail());
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}

	/**
	 * 单位注销
	 * @param entity
	 * @return
	 */
	@RestfulAnnotation(serverId = "3")
	@RequestMapping(value = "/deletesydwxx", method = RequestMethod.POST)
	public @ResponseBody ModelAndView DeleteRyjzdzzb(Dwjbxxb entity,SessionBean sessionBean) {
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		Map<String, Object> model = new HashMap<String, Object>();
		sessionBean = getSessionBean(sessionBean);
		try {
			if (entity.getId() != null) { // 注销
				sydwQueryService.delete(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, getDeleteSuccess());
			}
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage(), e);
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, getDeleteFail());
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}
	/**
	 * 
	 * @Title: queryDw
	 * @Description: TODO(单位列表查询)
	 * @param @param page
	 * @param @param flag
	 * @param @param rows
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	@RestfulAnnotation(valiField="",serverId = "3")
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public @ResponseBody
	EasyUIPage queryDw(EasyUIPage page,  
			@RequestParam(value = "rows",required = false) Integer rows, Dwjbxxb entity,SessionBean sessionBean) {
		page.setPagePara(rows);
		sessionBean = getSessionBean(sessionBean);
		//增加查询条件 begin
		if(StringUtils.isBlank(page.getFlag()) && null != sessionBean){
			//entity.setGlpcsid((String)sessionBean.getExtendMap().get("ssPcsCode"));
			entity.setGlbmid((String)sessionBean.getUserOrgCode());
		} 
		//增加查询条件 end
		return sydwQueryService.queryDw(page, entity);
	}
	
	/**
	 * @throws BussinessException 
	 * 
	 * @Title: getDwjbxxb
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param id
	 * @param @return    设定文件
	 * @return Dwjbxxb    返回类型
	 * @throws
	 */
	@RestfulAnnotation(serverId = "3")
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public @ResponseBody Dwjbxxb getDwjbxxb(@PathVariable(value="id")String id) throws BussinessException{
		Dwjbxxb entity = new Dwjbxxb();
		entity.setId(id);
		if (!StringUtils.isBlank(id)) {
			entity = dwjbxxbService.query(entity);
		}
		if(entity == null)
			throw new BussinessException("没有此单位！");
		return  entity;
	}
	
	/**
	 * 
	 * @Title: queryFr
	 * @Description: TODO(根据单位ID查询法人信息)
	 * @param @param dwid
	 * @param @return    设定文件
	 * @return Frfzrllrb    返回类型
	 * @throws
	 */
	@RequestMapping(value="/{dwid}/fr" ,method = RequestMethod.GET)
	public @ResponseBody Frfzrllrb queryFr(@PathVariable(value="dwid")String dwid){
		return frfzrllrbService.queryFrByDwid(dwid);
	}
}
