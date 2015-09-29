package com.founder.zdrygl.base.controller;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.fileupload.FileItem;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.founder.framework.base.controller.BaseController;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.components.AppConst;
import com.founder.framework.exception.BussinessException;
import com.founder.framework.organization.department.bean.OrgOrganization;
import com.founder.framework.organization.department.service.OrgOrganizationService;
import com.founder.framework.organization.position.service.OrgPositionService;
import com.founder.framework.organization.user.service.OrgUserService;
import com.founder.framework.utils.DateUtils;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.service.attachment.bean.ZpfjFjxxb;
import com.founder.service.attachment.service.ZpfjFjxxbService;
import com.founder.syrkgl.bean.SyrkSyrkxxzb;
import com.founder.syrkgl.dao.SyrkSyrkxxzbDao;
import com.founder.workflow.bean.JTask;
import com.founder.workflow.service.inteface.JProcessDefinitionService;
import com.founder.workflow.service.inteface.JTaskService;
import com.founder.zdrygl.base.model.ZdryZb;
import com.founder.zdrygl.base.service.ZdryInfoQueryService;
import com.founder.zdrygl.core.factory.ZdryAbstractFactory;
import com.founder.zdrygl.core.inteface.ZdryService;
import com.founder.zdrygl.core.utils.ZdryConstant;
import com.google.gson.Gson;

/***
 * ****************************************************************************
 * 
 * @Package: [com.founder.zdrygl.controller.ZdryZdController.java]
 * @ClassName: [ZdryZdController]
 * @Description: [转递业务]
 * @Author: [wu_chunhui@founder.com.cn]
 * @CreateDate: [2015-3-12 下午3:56:09]
 * @UpdateUser: [Administrator(如多次修改保留历史记录，增加修改记录)]
 * @UpdateDate: [2015-3-12 下午3:56:09，(如多次修改保留历史记录，增加修改记录)]
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]
 * @Version: [v1.0]
 */
@Controller
@RequestMapping("zdryZd")
public class ZdryZdController extends BaseController {
	private Logger logger = Logger.getLogger(this.getClass());
	
	@Resource(name="zdryQueryService")
	private ZdryInfoQueryService zdryQueryService ;
	
	@Autowired
	public ZdryAbstractFactory zdryFactory;
	
	@Autowired
	private ZdryConstant zdryConstant;
	
	@Resource(name = "zpfjFjxxbService")
	private ZpfjFjxxbService zpfjFjxxbService;
	/***
	 * 
	 * @Title: createLg
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param syrkid
	 * @param @param ryid
	 * @param @param ywlx
	 * @param @return 设定文件
	 * @return ModelAndView 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/createZd", method = RequestMethod.GET)
	public ModelAndView createZd(String id) {
	//	SessionBean sessionBean = getSessionBean();
		ModelAndView mv = new ModelAndView("zdrygl/zdryZd");
		
		ZdryZb zdryZb=(ZdryZb) zdryQueryService.queryById(id);
		
		//验证状态是否正确
		if(!zdryConstant.YLG.equals(zdryZb.getGlzt())){
			throw new BussinessException("该重点人员正在【"+zdryConstant.getGlztStr(zdryZb.getGlzt())+"】，不能办理其他业务");
		}
				
		mv.addObject("zdryZb", zdryZb);
		
		return mv;
	}

	/***
	 * 
	 * @Title: saveZd
	 * @Description: TODO重点人员转递保存逻辑
	 * @param @param zdryLczywblb
	 * @param @param sessionBean
	 * @param @return 设定文件
	 * @return ModelAndView 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/saveZd", method = RequestMethod.POST)
	public ModelAndView saveZd(
			ZdryZb zdryZb, 
			SessionBean sessionBean,
			@RequestParam(value="uploadFile") CommonsMultipartFile[] uploadFile) {
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		Map<String, Object> model = new HashMap<String, Object>();
		sessionBean = getSessionBean(sessionBean);
		try {
			//撤管重点人员
			ZdryService zdryService = zdryFactory.createZdryService(null, zdryZb, null);
			zdryService.zd(sessionBean);
			
			//处理上传的转递依据
			List<ZpfjFjxxb> list = new ArrayList<ZpfjFjxxb>();
			for (int i = 0; i < uploadFile.length; i++) {
				CommonsMultipartFile multipartFile = uploadFile[i];
				if (!multipartFile.isEmpty()) {
					FileItem fileItem = multipartFile.getFileItem();
					ZpfjFjxxb entity = new ZpfjFjxxb();
					entity.setLybm("ZDRY_ZDRYZB");
					entity.setLyid(zdryZb.getId());//保存的是当前选择的重点人员id，因为后续 转递要改成一次只转一个类型
					entity.setLyms("重点人员转递-转递依据");
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
						
			model.put(AppConst.STATUS, AppConst.SUCCESS);
			model.put(AppConst.MESSAGES, "转递发起成功");
			
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
