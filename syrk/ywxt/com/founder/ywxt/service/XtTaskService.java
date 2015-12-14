package com.founder.ywxt.service;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.exception.BussinessException;
import com.founder.ywxt.bean.Ywxtcyryxxb;

/***
 * ****************************************************************************
 * 
 * @Package: [com.founder.ywxt.service.XtTaskService.java]
 * @ClassName: [业务协同接口]
 * @Description: [业务协同接口]
 * @Author: [wu_chunhui@founder.com.cn]
 * @CreateDate: [2015-5-29 上午10:51:04]
 * @UpdateUser: [Administrator(如多次修改保留历史记录，增加修改记录)]
 * @UpdateDate: [2015-5-29 上午10:51:04，(如多次修改保留历史记录，增加修改记录)]
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]
 * @Version: [v1.0]
 */
public interface XtTaskService {

	/***
	 * 
	 * @Title: createTask
	 * @Description: TODO(新建协同任务)
	 * @param @param cyrCollection
	 * @param @param xtType
	 * @param @return 设定文件
	 * @return int 返回类型
	 * @throws
	 */
	void createTask(Map<String,Object> paramMap);

	/***
	 * 
	 * @Title: updateXtjgByCyr
	 * @Description: TODO(更新审批)
	 * @param @param map map 内应该包含xtId，messageid，approvalLevel，
	 * @param @param approvalLevel
	 * @param @return 设定文件
	 * @return int 返回类型
	 * @throws
	 */
	void updateXtjgByCyr(Map<String,Object> map, int approvalLevel,SessionBean  sessionBean,String xtType)throws BussinessException;

	/***
	 * 
	 * @Title: doBusinessOpration
	 * @Description: TODO(业务操作)
	 * @param @param xtid
	 * @param @return 设定文件
	 * @return int 返回类型
	 * @throws
	 */
	void doBusinessOpration(String xtid,SessionBean sessionBean);

	/***
	 * 
	 * @Title: sendMessage
	 * @Description: TODO(消息发送通用方法,只适用于协同)
	 * @param @param messageContent
	 * @param @param xxbt
	 * @param @param fqrxxb
	 * @param @param url
	 * @param @param userIDString    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	void sendMessage(String messageContent, String xxbt, Ywxtcyryxxb fqrxxb,String url,String userIDString);
	/***
	 * 
	 * @Title: sendMessage
	 * @Description: TODO(发起方错误时发送的任务内容)
	 * @param @param messageContent
	 * @param @param xxbt
	 * @param @param fqrxxb
	 * @param @param url
	 * @param @param userIDString    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public void doBusinessRefuse(String xtid, SessionBean sessionBean);
}
