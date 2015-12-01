/**********************************************************************   
 * <p>文件名：ImportToCyry.java </p>
 * <p>文件描述：TODO(描述该文件做什么) 
 * @project_name：syrk
 * @author wu_chunhui@founder.com.cn 
 * @date 2014-12-2 下午04:20:33 
 * @history
 * @department：研发部
 *
*/
package com.founder.service.threadService;

import java.io.InputStream;

import javax.annotation.Resource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.founder.framework.base.entity.SessionBean;
import com.founder.sydw_dl.service.CyrydrrwxxbService;

/******************************************************************************
 * @Package:      [com.founder.service.threadService.ImportToCyry.java]  
 * @ClassName:    [ImportToCyry]   
 * @Description:  [新启动后台线程处理导入内容]   
 * @Author:       [wu_chunhui@founder.com.cn]  
 * @CreateDate:   [2014-12-2 下午04:20:33]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2014-12-2 下午04:20:33，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 */

public class ImportToCyry implements Runnable {
	@Resource(name = "cyrydrrwxxbService")
	private CyrydrrwxxbService cyrydrrwxxbService;
	
	private InputStream in;
	private SessionBean sessionBean;
	private String rwid;
	
	public  ImportToCyry(InputStream in,SessionBean sessionBean,String rwid) {
		this.in=in;
		this.sessionBean=sessionBean;
		this.rwid=rwid;
	}

	/* (非 Javadoc)
	 * <p>Title: run</p>
	 * <p>Description: </p>
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		CyrydrrwxxbService cyrydrrwxxbService =(CyrydrrwxxbService)context.getBean("cyrydrrwxxbService");
		// TODO Auto-generated method stub
		//cyrydrrwxxbService.importToCyry(in, sessionBean, rwid);
	}

}
