package com.founder.zdrygl.core.inteface;

import java.util.Map;

import com.founder.framework.base.entity.SessionBean;
import com.founder.zdrygl.base.vo.ZdryVO;
import com.founder.zdrygl.core.model.Zdry;

/**
 * ****************************************************************************
 * @Package:      [com.founder.zdrygl.core.inteface.ZdryService.java]  
 * @ClassName:    [ZdryService]   
 * @Description:  [重点人员业务接口]   
 * @Author:       [wei.wen@founder.com.cn]  
 * @CreateDate:   [2015年9月14日 下午9:01:02]   
 * @UpdateUser:   [wei.wen@founder.com.cn(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015年9月14日 下午9:01:02，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
public interface ZdryService {

	/**
	 * 
	 * @Title: lg
	 * @Description: TODO(重点人员列管)
	 * @param @param sessionBean    设定文件
	 * @return void    返回类型
	 * @throw
	 */
	public void lg(SessionBean sessionBean);

	public void lgSuccess(SessionBean sessionBean);
	
	public void lgFail(SessionBean sessionBean);

	/**
	 * 
	 * @Title: cg
	 * @Description: TODO(重点人员撤管)
	 * @param @param sessionBean    设定文件
	 * @return void    返回类型
	 * @throw
	 */
	public void cg(SessionBean sessionBean);
	
	public void cgSuccess(SessionBean sessionBean);
	
	public void cgFail(SessionBean sessionBean);
	
	/**
	 * 
	 * @Title: zl
	 * @Description: TODO(重点人员转类)
	 * @param @param sessionBean    设定文件
	 * @return void    返回类型
	 * @throw
	 */
	public void zl(SessionBean sessionBean);
	
	public void zlSuccess(SessionBean sessionBean);
	
	public void zlFail(SessionBean sessionBean);
	
	/**
	 * 
	 * @Title: zd
	 * @Description: TODO(重点人员转递)
	 * @param @param sessionBean    设定文件
	 * @return void    返回类型
	 * @throw
	 */
	public void zd(SessionBean sessionBean);
	
	public void zdSuccess(SessionBean sessionBean);
	
	public void zdFail(SessionBean sessionBean);
		
	/**
	 * 
	 * @Title: update
	 * @Description: TODO(重点人员修改)
	 * @param @param sessionBean    设定文件
	 * @return void    返回类型
	 * @throw
	 */
	public void update(SessionBean sessionBean);
	
	public void setZdry(Zdry entity);
	/**
	 * 
	 * @Title: setStartProcessInstance
	 * @Description: (设置流程启动参数)
	 * @param @param businessKey 业务主键
	 * @param @param applyUserId 流程发起人
	 * @param @param variables    设定文件 流程启动业务参数
	 * @return void    返回类型
	 * @throw
	 */
	public void setStartProcessInstance(String processKey,String applyUserId, Map<String,Object> variables);
		
	
	public Zdry getZdry();
	
	/**
	 * 
	 * @Title: getZdryId
	 * @Description: TODO(获取重点人员总表的ID)
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throw
	 */
	public String getZdryId();
	
	/**
	 * 
	 * @Title: queryZdryAllInfo
	 * @Description: TODO(查询重点人员总表和各个子表的的信息)
	 * @param @param zdryid
	 * @param @param zdryVO    设定文件
	 * @return void    返回类型
	 * @throw
	 */
	public void queryZdryAllInfo(String zdryid, ZdryVO zdryVO);

	
}
