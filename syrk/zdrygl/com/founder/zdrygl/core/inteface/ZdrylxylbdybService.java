package com.founder.zdrygl.core.inteface;
import java.util.List;

import com.founder.zdrygl.base.model.Zdrylxylbdyb;

/**
 * ****************************************************************************
 * @Package:      [com.founder.zdrygl.service.ZdrylxylbdybService.java]  
 * @ClassName:    [ZdrylxylbdybService]   
 * @Description:  [重点人员 类型类别服务类]   
 * @Author:       [zhang.hai@founder.com.cn]  
 * @CreateDate:   [2015年8月17日 上午11:19:09]   
 * @UpdateUser:   [ZhangHai(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015年8月17日 上午11:19:09，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
public interface ZdrylxylbdybService {
	
	/**
	 * 
	 * @Title: getTopList
	 * @Description: 查询当前区域下的一级类别列表
	 * @param @return    设定文件
	 * @return List    返回类型
	 * @throws
	 */
	public List getTopList();

	/**
	 * 
	 * @Title: getChildList
	 * @Description: 查询当前区域下的子类别列表
	 * @param @param lbdm_p
	 * @param @return    设定文件
	 * @return List    返回类型
	 * @throws
	 */
	public List getChildList(String lbdm_p) ;
	
	/**
	 * 
	 * @Title: query
	 * @Description: 查询当前区域下的类型
	 * @param @param entity
	 * @param @return    设定文件
	 * @return Zdrylxylbdyb    返回类型
	 * @throws
	 */
	public Zdrylxylbdyb query(Zdrylxylbdyb entity);
}

