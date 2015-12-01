/**********************************************************************   
 * <p>文件名：ZakhJbxxCjService.java </p>
 * <p>文件描述：治安考核-基本信息采集服务类接口
 * @project_name：syrk
 * @author wu.w@founder.com.cn 
 * @date 2015-4-17 上午8:50:31 
 * @history
 * @department：研发部
 *
*/
package com.founder.zakh.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;

import com.founder.zakh.vo.KhfstjVO;

/******************************************************************************
 * @Package:      [com.founder.zakh.service.ZakhJbxxCjService.java]  
 * @ClassName:    [ZakhJbxxCjService]   
 * @Description:  [治安考核-基本信息采集服务类接口]   
 * @Author:       [wu.w@founder.com.cn]  
 * @CreateDate:   [2015-4-17 上午8:50:31]   
 * @UpdateUser:   [Way(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-4-17 上午8:50:31，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 */

public interface ZakhJbxxCjService {
	

	/**
	 * 查看考核统计得分
	 * @Title: queryKhtj
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param map
	 * @param @return    设定文件
	 * @return Map<String,Object>    返回类型
	 * @throws
	 */
	public Map<String,Object> queryKhtj(Map<String,String> map);

	
	public void bckhfstj(String date);
	
	/**
	 * 补充某个组织机构的考核分数
	 * @Title: bckhfstjByOrgCode
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param date
	 * @param @param orgCode    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public void bckhfstjByOrgCode(String date,String orgCode);

	

	public Map<String,Object> queryXXByGzltj(Map<String,String> paramMap);
	
	
	
	
	
	
	/**
	 * 导出excel
	 * @Title: exportExcel
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param list
	 * @param @param outputStream    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public void exportExcel(List<KhfstjVO>  list, ServletOutputStream outputStream);

	
	
	public void tjFj(int tjYear,int tjWeek, Date startDate, Date endDate);
	
	public void tjPcs(int tjYear,int tjWeek, Date startDate, Date endDate);
	
	public void tjZrq(int tjYear,int tjWeek, Date startDate, Date endDate);
}
