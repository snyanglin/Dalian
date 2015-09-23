package com.founder.zdrygl.core.inteface;

import java.util.List;

import com.founder.framework.utils.EasyUIPage;
import com.founder.zdrygl.base.model.ZdryZb;
import com.founder.zdrygl.core.model.Zdry;

/**
 * ****************************************************************************
 * @Package:      [com.founder.zdrygl.core.inteface.ZdryQueryService.java]  
 * @ClassName:    [ZdryQueryService]   
 * @Description:  [重点人员查询服务接口]   
 * @Author:       [wei.wen@founder.com.cn]  
 * @CreateDate:   [2015年9月18日 下午3:04:48]   
 * @UpdateUser:   [wei.wen@founder.com.cn(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015年9月18日 下午3:04:48，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
public interface ZdryQueryService {
	
	/**
	 * 
	 * @Title: queryList
	 * @Description: TODO(查询重点人管理列表)
	 * @param @param page
	 * @param @param object
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throw
	 */
	public EasyUIPage queryList(EasyUIPage page , ZdryZb object);
	
	public EasyUIPage queryDwDzOnPT(EasyUIPage page , Object object);
	
	public List<?> queryListByRyid(String ryid);
	
	public List<?> queryListBySyrkId(String syrkId);
	
	public Zdry queryById(String zdryzbId);

	/**
	 * 
	 * @Title: getChildList
	 * @Description: TODO(查询重点人员类型下的子类列表)
	 * @param @param lbdm_p 上级类型
	 * @param @return    设定文件
	 * @return List    返回类型
	 * @throw
	 */
	public List getChildList(String lbdm_p);

	/**
	 * 
	 * @Title: queryListByEntity
	 * @Description: TODO(通过重点人员总表对象查询List)
	 * @param @param zdryZb
	 * @param @return    设定文件
	 * @return List    返回类型
	 * @throw
	 */
	public List queryListByEntity(ZdryZb zdryZb);
	
}
