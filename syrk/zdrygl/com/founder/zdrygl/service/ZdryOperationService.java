package com.founder.zdrygl.service;

import java.util.List;

import com.founder.zdrygl.vo.ZdryVO;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.exception.BussinessException;

/**
 * ****************************************************************************
 * @Package:      [com.founder.zdrygl.service.zdryOperationService.java]  
 * @ClassName:    [zdryOperationService]   
 * @Description:  [重点人员操作接口]   
 * @Author:       [wu_chunhui@founder.com.cn]  
 * @CreateDate:   [2015年7月21日 下午5:16:04]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015年7月21日 下午5:16:04，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
public interface ZdryOperationService {
	
	/**
	 * 
	 * @Title: saveLg
	 * @Description: TODO(列管动作，保存基础数据，触发流程)
	 * @param @param ZdryVO
	 * @param @throws BussinessException    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public void saveLg(ZdryVO vo)throws BussinessException;
	/**
	 * 
	 * @Title: saveCg
	 * @Description: TODO(撤管，保存基础数据，触发流程)
	 * @param @param ZdryVO
	 * @param @throws BussinessException    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public void saveCg(ZdryVO vo)throws BussinessException;
	/**
	 * 
	 * @Title: saveZd
	 * @Description: TODO(转递，保存基础数据，触发流程)
	 * @param @param ZdryVO
	 * @param @throws BussinessException    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public void saveZd(ZdryVO vo)throws BussinessException;
	
	
	/***
	 * 
	 * @Title: queryByZdryID
	 * @Description: TODO(根据重点人员ID，查询VO对象并跳转页面)
	 * @param @param zdryid
	 * @param @return    设定文件
	 * @return Map<String,String>    返回类型
	 * @throws
	 */
	public ZdryVO queryByZdryID(String zdryid);
	
	/***
	 * 
	 * @Title: queryByZdrylx
	 * @Description: TODO(根据重点人员类型，查询VO对象并跳转页面)
	 * @param @param zdrylx
	 * @param @return    设定文件
	 * @return Map<String,String>    返回类型
	 * @throws
	 */
	public List queryByZdrylx(String zdrylx);
	
	/***
	 * 
	 * @Title: updateByZdrylx
	 * @Description: TODO(根据重点人员类型，修改VO对象并跳转页面)
	 * @param @param zdryVO    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public void updateByZdrylx(ZdryVO zdryVO,SessionBean sessionBean);
	
	
	
}
