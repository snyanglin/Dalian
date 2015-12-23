package com.founder.zdrygl.core.inteface;

import java.util.List;

import com.founder.zdrygl.base.vo.ZdryZdryzbVO;
import org.springframework.beans.factory.annotation.Autowired;

import com.founder.framework.utils.EasyUIPage;
import com.founder.zdrygl.core.model.Zdry;
import com.founder.zdrygl.core.utils.ZdryConstant;

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
public abstract class ZdryQueryService {
	  @Autowired
		private ZdryConstant zdryConstant;
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
	public abstract EasyUIPage queryList(EasyUIPage page , Object object);
	
	/**
	 * 
	 * @Title: getQueryList
	 * @Description: TODO(获取查询权限的List)
	 * @param @param page
	 * @param @param object
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throw
	 */
	public abstract EasyUIPage getQueryList(EasyUIPage page , Object object);
	
	public abstract List<?> queryListByRyid(String ryid);
	
	public abstract List<?> queryListBySyrkId(String syrkId);
	
	public abstract Zdry queryById(String zdryzbId);	
	
	/**
	 * 
	 * @Title: queryZdryzbById
	 * @Description: (根据重点人员id查询子表信息)
	 * @param @param zdryId
	 * @param @return    设定文件
	 * @return Zdry    返回类型
	 * @throws
	 */
	public abstract Zdry queryZdryzbById(String zdryId , String zdrygllxdm);
	
	public abstract Integer queryForCount(String syrkId);

	public abstract List<ZdryZdryzbVO> queryZdryVoByRyid(String ryid);
}
