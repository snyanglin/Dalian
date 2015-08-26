package com.founder.qbld.controller;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.founder.framework.base.controller.BaseController;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.EasyUIPage;
import com.founder.qbld.bean.WsRecord;
import com.founder.qbld.service.WsService;

/**
 * ****************************************************************************
 * @Package:      [com.founder.qbld.controller.WsRecordController.java]  
 * @ClassName:    [WsRecordController]   
 * @Description:  [ws记录表控制器]   
 * @Author:       [yu_sun@founder.com.cn]  
 * @CreateDate:   [2015-7-20 上午8:56:03]   
 * @UpdateUser:   [founder(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-7-20 上午8:56:03，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Controller
@RequestMapping(value = "ws")
public class WsRecordController extends BaseController {
	
	@Resource(name = "wsService")
	private WsService wsService;
	
	/**
	 * @Title: queryCkyjList
	 * @Description: TODO(ws记录表)
	 * @param @param page
	 * @param @param rows
	 * @param @param entity
	 * @param @param sessionBean
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/queryWsList", method = RequestMethod.POST)
	public @ResponseBody EasyUIPage queryCkyjList(EasyUIPage page,
			@RequestParam(value = "rows", required=false) Integer rows, 
			WsRecord entity,
			SessionBean sessionBean){
		page.setPagePara(rows);
		sessionBean = getSessionBean(sessionBean);
		return wsService.queryWsList(page, entity);
	}
	
	/**
	 * @Title: queryWsListCount
	 * @Description: TODO(ws记录表count)
	 * @param @param entity
	 * @param @param sessionBean
	 * @param @return    设定文件
	 * @return long    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/queryWsListCount", method = RequestMethod.POST)
	public @ResponseBody long queryWsListCount(WsRecord entity, SessionBean sessionBean){
		sessionBean = getSessionBean(sessionBean);
		return wsService.queryWsListCount(entity);
	}
	
}