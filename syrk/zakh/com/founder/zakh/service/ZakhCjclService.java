/**********************************************************************   
 * <p>文件名：ZakhCjclService.java </p>
 * <p>文件描述：治安考核-基本信息采集常量服务类
 * @project_name：syrk
 * @author wu.w@founder.com.cn 
 * @date 2015-4-17 上午8:54:11 
 * @history
 * @department：研发部
 *
*/
package com.founder.zakh.service;

import com.founder.zakh.bean.ZakhCjclBean;
import java.util.*;

/******************************************************************************
 * @Package:      [com.founder.zakh.service.ZakhCjclService.java]  
 * @ClassName:    [ZakhCjclService]   
 * @Description:  [治安考核-基本信息采集常量服务类]   
 * @Author:       [wu.w@founder.com.cn]  
 * @CreateDate:   [2015-4-17 上午8:54:11]   
 * @UpdateUser:   [Way(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-4-17 上午8:54:11，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 */

public interface ZakhCjclService {
	/**
	 * 
	 * @Title: save
	 * @Description: 保存基本信息采集常量
	 * @param @param entity    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public void save(ZakhCjclBean entity);
	
	/**
	 * 
	 * @Title: delete
	 * @Description: 删除基本信息采集常量
	 * @param @param orgid    设定文件
	 * @return int    返回类型
	 * @throws
	 */
	public int delete(String orgid);
	
	/**
	 * 
	 * @Title: update
	 * @Description: 更新基本信息采集常量
	 * @param @param entity    设定文件
	 * @return int    返回类型
	 * @throws
	 */
	public int update(ZakhCjclBean entity);
	
	/**
	 * 
	 * @Title: query
	 * @Description: 查询基本信息采集常量
	 * @param @param orgid    设定文件
	 * @return List<ZakhCjclBean>    返回类型
	 * @throws
	 */
	public List<ZakhCjclBean> query(String orgid);
}
