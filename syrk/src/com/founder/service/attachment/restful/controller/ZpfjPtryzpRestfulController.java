package com.founder.service.attachment.restful.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
import com.founder.framework.annotation.RestfulAnnotation;
import com.founder.framework.base.controller.BaseController;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.components.AppConst;
import com.founder.framework.config.SystemConfig;
import com.founder.framework.utils.ImageUtils;
import com.founder.service.attachment.bean.ZpfjPtryzpglb;
import com.founder.service.attachment.bean.ZpfjPtryzpxxb;
import com.founder.service.attachment.service.ZpfjPtryzpService;

import com.google.gson.Gson;

/**
 * ****************************************************************************
 * @Package:      [com.founder.service.attachment.restful.ZpfjPtryzpRestful.java]  
 * @ClassName:    [ZpfjPtryzpRestful]   
 * @Description:  [人员照片功能REST服务]   
 * @Author:       [weiwen]  
 * @CreateDate:   [2015-3-26 上午9:40:15]   
 * @UpdateUser:   [weiwen]   
 * @UpdateDate:   [2015-3-26 上午9:40:15，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Controller
@RequestMapping("/ryzp")
public class ZpfjPtryzpRestfulController extends BaseController {

	private Logger logger = Logger.getLogger(this.getClass());

	@Resource(name = "zpfjPtryzpService")
	private ZpfjPtryzpService zpfjPtryzpService;
	
	/**
	 * 
	 * @Title: save
	 * @Description: TODO(照片上传)
	 * JSON格式用ZpfjPtryzpglb里面的uploadFile接收BASE64位数据，FORM表单用 CommonsMultipartFile uploadFile接收照片
	 * @param @param uploadFile
	 * @param @param zpfjPtryzpglb
	 * @param @param sessionBean
	 * @param @return    设定文件
	 * @return ModelAndView    返回类型
	 * @throws
	 */
	@RestfulAnnotation(serverId="11",valiField="ryid,lybm,lyid,lyms")
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public @ResponseBody ModelAndView save(@RequestParam(required = false) CommonsMultipartFile uploadFile,ZpfjPtryzpglb zpfjPtryzpglb,
			SessionBean sessionBean) {
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			boolean isEmpty = false ;
			byte[] imageByte = null;
			if (uploadFile != null && !uploadFile.isEmpty()) {
				imageByte = uploadFile.getBytes();
			} else if(uploadFile != null || StringUtils.isEmpty(zpfjPtryzpglb.getUploadFile())){
				isEmpty = true;
			}else{
				imageByte = base64Decoder(zpfjPtryzpglb.getUploadFile());
			}
			if(isEmpty){
				model.put(AppConst.STATUS, AppConst.FAIL);
				model.put(AppConst.MESSAGES, "保存失败！由于上传文件为空！");
			}else{
				ZpfjPtryzpxxb zpfjPtryzpxxb = new ZpfjPtryzpxxb();
				zpfjPtryzpxxb.setZp(imageByte);
				zpfjPtryzpxxb.setZpslt(ImageUtils.convertImageSize(imageByte,179, 220, false));
				zpfjPtryzpService.savePtryzpxxb(zpfjPtryzpglb, zpfjPtryzpxxb, getSessionBean(sessionBean));
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, getAddSuccess());
			}
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage(), e);
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, getAddFail());
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}
	
	private byte[] base64Decoder(String file) throws IOException{
		return new BASE64Decoder().decodeBuffer(file);
	}
	
	private String base64Edcoder(byte[] file){
		return new BASE64Encoder().encode(file);
	}
	
	
	/**
	 * 
	 * @Title: queryPtryzpSingle
	 * @Description: TODO(根据来源表名与来源ID查询照片)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return HttpEntity<byte[]>    返回类型
	 * @throws
	 */
	@RestfulAnnotation(serverId="33",valiField="lybm,lyid,ryid")
	@RequestMapping(value = "/single", method = RequestMethod.GET)
	public @ResponseBody String queryPtryzpSingle(ZpfjPtryzpglb entity) {
//		HttpHeaders headers = new HttpHeaders();
//		headers.setContentType(MediaType.IMAGE_JPEG);
		ZpfjPtryzpxxb zpfjPtryzpxxb = zpfjPtryzpService.queryPtryzpSingle(entity);
		if (zpfjPtryzpxxb != null && zpfjPtryzpxxb.getZp() != null
				&& zpfjPtryzpxxb.getZp().length > 0) {
//			headers.setContentLength(zpfjPtryzpxxb.getZp().length);
			return base64Edcoder(zpfjPtryzpxxb.getZp());
		} else {
//			if ("111".equals(entity.getCyzjdm()) //调用公安请求服务，暂时不用 2015-3-27
//					|| "112".equals(entity.getCyzjdm())
//					|| "335".equals(entity.getCyzjdm())) {
//				SessionBean sessionBean = getSessionBean();
//				CzrkRequestService czrkRequestService = new CzrkRequestService();
//				CzrkResult result = czrkRequestService.selectCzrk(entity.getZjhm(), true);
//				if (result != null && !StringUtils.isBlank(result.getXP())) {
//					byte[] pictureByte = null;
//					try {
//						pictureByte = new BASE64Decoder().decodeBuffer(result
//								.getXP());
//					} catch (Exception ex) {
//						byte[] empty_ryzp = SystemConfig.getByteArray("empty_ryzp");
//						headers.setContentLength(empty_ryzp.length);
//						return new HttpEntity(empty_ryzp, headers);
//					}
//					if (pictureByte != null) {
//						ZpfjPtryzpxxb zpfjPtryzpxxb1 = new ZpfjPtryzpxxb();
//						zpfjPtryzpxxb1.setZp(pictureByte);
//						try {
//							zpfjPtryzpxxb1.setZpslt(ImageUtils
//									.convertImageSize(pictureByte, 179, 220,
//											false));
//						} catch (Exception e) {
//							e.printStackTrace();
//						}
//						ZpfjPtryzpglb zpfjPtryzpglb = new ZpfjPtryzpglb();
//						zpfjPtryzpglb.setRyid(entity.getRyid());
//						zpfjPtryzpglb.setLybm("人员基本信息表");
//						zpfjPtryzpglb.setLyid(entity.getRyid());
//						zpfjPtryzpglb.setLyms("RK_RYJBXXB");
//						zpfjPtryzpService.savePtryzpxxb(zpfjPtryzpglb,
//								zpfjPtryzpxxb1, sessionBean);
//						headers.setContentLength(pictureByte.length);
//						return new HttpEntity(pictureByte, headers);
//					}
//				}
//			}
			byte[] empty_ryzp = SystemConfig.getByteArray("empty_ryzp");
//			headers.setContentLength(empty_ryzp.length);
			return base64Edcoder(empty_ryzp);
		}
	}

	/**
	 * 
	 * @Title: queryPtryzpsltSingle
	 * @Description: TODO(根据来源表名与来源ID查询照片缩略图)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return HttpEntity<byte[]>    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/single/small", method = RequestMethod.GET)
	public @ResponseBody String queryPtryzpsltSingle(ZpfjPtryzpglb entity) {
//		HttpHeaders headers = new HttpHeaders();
//		headers.setContentType(MediaType.IMAGE_JPEG);
		ZpfjPtryzpxxb zpfjPtryzpxxb = zpfjPtryzpService.queryPtryzpsltSingle(entity);
		if (zpfjPtryzpxxb != null && zpfjPtryzpxxb.getZpslt() != null
				&& zpfjPtryzpxxb.getZpslt().length > 0) {
//			headers.setContentLength(zpfjPtryzpxxb.getZpslt().length);
			return base64Edcoder(zpfjPtryzpxxb.getZpslt());
		} else {
			byte[] empty_ryzp = SystemConfig.getByteArray("empty_ryzp");
//			headers.setContentLength(empty_ryzp.length);
			return base64Edcoder(empty_ryzp);
		}
	}
}
