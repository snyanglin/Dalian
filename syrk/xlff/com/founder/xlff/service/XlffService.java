package com.founder.xlff.service;

import java.util.List;

import com.founder.framework.annotation.TypeAnnotation;
import com.founder.xlff.bean.Option;
import com.founder.xlff.vo.Sf_Organization;

/**
 * ****************************************************************************
 * @Package:      [com.founder.xlff.service.XlffService.java]  
 * @ClassName:    [XlffService]   
 * @Description:  [巡逻防范服务]   
 * @Author:       [yu_sun@founder.com.cn]  
 * @CreateDate:   [2015-6-17 上午11:31:18]   
 * @UpdateUser:   [founder(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-6-17 上午11:31:18，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@TypeAnnotation("巡逻防范")
public interface XlffService {

	/**
	 * @Title: queryOption
	 * @Description: TODO(查询设置)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return Option    返回类型
	 * @throws
	 */
	public Option queryOption(Option entity);
	
	/**
	 * @Title: saveOption
	 * @Description: TODO(保存设置)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	public String saveOption(Option entity);
	
	/**
	 * @Title: updateOption
	 * @Description: TODO(修改设置)
	 * @param @param qsfkzt
	 * @param @return    设定文件
	 * @return int    返回类型
	 * @throws
	 */
	public int updateOption(Option qsfkzt);
	
	/**
	 * @Title: downMap
	 * @Description: TODO(四色预警画面)
	 * @param @param orgcode
	 * @param @return    设定文件
	 * @return List<Sf_Organization>    返回类型
	 * @throws
	 */
	public List<Sf_Organization> downMap(String orgcode);
	
	/**
	 * @Title: queryXjZzjgxj
	 * @Description: TODO(获取组织机构)
	 * @param @param zzjgdm
	 * @param @return    设定文件
	 * @return List<Sf_Organization>    返回类型
	 * @throws
	 */
	public List<Sf_Organization> queryXjZzjgxj(String zzjgdm);
	
	/**
	 * @Title: ssyjColor
	 * @Description: TODO(四色预警算法)
	 * @param @param orgcode
	 * @param @param sf
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	public String ssyjColor(Sf_Organization sf);
	
	
}
