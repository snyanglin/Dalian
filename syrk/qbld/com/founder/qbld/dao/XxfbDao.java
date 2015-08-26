package com.founder.qbld.dao;

import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.utils.EasyUIPage;
import com.founder.qbld.bean.XxfbArticle;

/**
 * ****************************************************************************
 * @Package:      [com.founder.qbld.dao.XxfbDao.java]  
 * @ClassName:    [XxfbDao]   
 * @Description:  [信息发布dao]   
 * @Author:       [yu_sun@founder.com.cn]  
 * @CreateDate:   [2015-6-26 下午2:36:45]   
 * @UpdateUser:   [founder(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-6-26 下午2:36:45，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Repository("xxfbDao")
public class XxfbDao extends BaseDaoImpl {
	
	/**
	 * @Title: queryClassList
	 * @Description: TODO(信息发布类型列表查询)
	 * @param @param page
	 * @param @param map
	 * @param @return    设定文件
	 * @return List<?>    返回类型
	 * @throws
	 */
	public List<?> queryClassList(EasyUIPage page, Map<String, Object> map) {
		return queryForList("Xxfb.queryClassList", map);
	}
	
	/**
	 * @Title: queryArticleList
	 * @Description: TODO(信息发布内容列表查询 )
	 * @param @param page
	 * @param @param map
	 * @param @return    设定文件
	 * @return List<?>    返回类型
	 * @throws
	 */
	public List<?> queryArticleList(EasyUIPage page, Map<String, Object> map) {
		return queryForList("Xxfb.queryArticleList", map);
	}
	
	/**
	 * @Title: queryClassCount
	 * @Description: TODO(信息发布内容数量查询)
	 * @param @param map
	 * @param @return    设定文件
	 * @return long    返回类型
	 * @throws
	 */
	public long queryArticleCount(Map<String, Object> map) {
		Integer count = (Integer) queryForObject("Xxfb.queryArticleCount", map);
		return count.longValue();
	}
	
	/**
	 * @Title: queryLksqb
	 * @Description: TODO(临控申请详情查询服务)
	 * @param @param entity
	 * @param @param map
	 * @param @return    设定文件
	 * @return Lksqb    返回类型
	 * @throws
	 */
	public XxfbArticle queryArticle(XxfbArticle entity, Map<String, Object> map) {
		return (XxfbArticle) queryForObject("Xxfb.queryArticle", map);
	}	
	
}
