/**********************************************************************   
 * <p>文件名：ZakhZzgjDao.java </p>
 * <p>文件描述：治安考核-获取组织机构dao 
 * @project_name：syrk
 * @author liu_shuai@founder.com.cn 
 * @date 2015-4-13 上午9:59:20 
 * @history
 * @department：研发部
 *
*/
package com.founder.zakh.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.zakh.bean.ZakhZzjgBean;
/**
 * ****************************************************************************
 * @Package:      [com.founder.zakh.dao.ZakhZzgjDao.java]  
 * @ClassName:    [ZakhZzgjDao]   
 * @Description:  [获取组织机构dao]   
 * @Author:       [liu_shuai@founder.com.cn]  
 * @CreateDate:   [2015-4-13 上午10:02:28]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-4-13 上午10:02:28，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Repository("zakhZzgjDao")
public class ZakhZzgjDao extends BaseDaoImpl {
	/**
	 * 
	 * @Title: query
	 * @Description: 查询所有分局
	 * @param @param parameterObject
	 * @param @return    设定文件
	 * @return List<ZakhCjclBean>    返回类型
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	public List<ZakhZzjgBean> query(){
		return queryForList("ZakhZzjg.query");
	}
	/**
	 * 
	 * @Title: sjQuery
	 * @Description: 查询分局下属派出所
	 * @param @param entity
	 * @param @return    设定文件
	 * @return List<ZakhCjclBean>    返回类型
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	public List<ZakhZzjgBean> pcsQuery(String orgcode){
		return queryForList("ZakhZzjg.pcsQuery", orgcode);
	}
	/**
	 * 
	 * @Title: xqQuery
	 * @Description: 查询派出所下属社区
	 * @param @param entity
	 * @param @return    设定文件
	 * @return List<ZakhCjclBean>    返回类型
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	public List<ZakhZzjgBean> xqQuery(String orgcode){
		return  queryForList("ZakhZzjg.xqquery", orgcode);
	}
	
	/**
	 * 
	 * @Title: getOrgByCode
	 * @Description: 根据机构编码得到机构类
	 * @param @param orgcode
	 * @param @return    设定文件
	 * @return ZakhZzjgBean    返回类型
	 * @throws
	 */
	public ZakhZzjgBean getOrgByCode(String orgcode){
		return (ZakhZzjgBean) queryForObject("ZakhZzjg.getOrgByCode", orgcode);
	}
}
