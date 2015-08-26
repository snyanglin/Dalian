/**********************************************************************   
 * <p>文件名：SerialNumberController.java </p>
 * <p>文件描述：TODO(描述该文件做什么) 
 * @project_name：syrk
 * @author wu_chunhui@founder.com.cn 
 * @date 2014-12-18 上午11:31:40 
 * @history
 * @department：研发部
 *
*/
package com.founder.service.serialNumberService.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.founder.framework.base.controller.BaseController;
import com.founder.service.serialNumberService.service.SerialNumberService;

/******************************************************************************
 * @Package:      [com.founder.service.serialNumberService.controller.SerialNumberController.java]  
 * @ClassName:    [SerialNumberController]   
 * @Description:  [一句话描述该类的功能]   
 * @Author:       [wu_chunhui@founder.com.cn]  
 * @CreateDate:   [2014-12-18 上午11:31:40]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2014-12-18 上午11:31:40，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 */
@Controller
@RequestMapping(value = "serialNumber")
public class SerialNumberController extends BaseController {
	
	@Resource(name = "serialNumberService")
	private  SerialNumberService serialNumberService;
	
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView edit() {
		ModelAndView mv = new ModelAndView("");
		serialNumberService.creatSequence("");
		
		return mv;
	}
	
	
	
}
