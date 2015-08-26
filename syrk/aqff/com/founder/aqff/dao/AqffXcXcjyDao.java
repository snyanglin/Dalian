/**********************************************************************   
 * <p>文件名：AqffXcXcjyDao.java </p>
 * <p>文件描述：TODO(描述该文件做什么) 
 * @project_name：syrk
 * @author wu.w@founder.com.cn 
 * @date 2015-5-25 上午9:51:49 
 * @history
 * @department：研发部
 *
*/
package com.founder.aqff.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.aqff.bean.AqffXcXcjyxxb;
import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;

/******************************************************************************
 * @Package:      [com.founder.aqff.dao.AqffXcXcjyDao.java]  
 * @ClassName:    [AqffXcXcjyDao]   
 * @Description:  [宣传教育dao]   
 * @Author:       [wu.w@founder.com.cn]  
 * @CreateDate:   [2015-5-25 上午9:51:49]   
 * @UpdateUser:   [way(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-5-25 上午9:51:49，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 * @review      : tian_chengwei@founder.com.cn
 * @reviewDate  : 20150604
 */
@Repository("aqffxcjyDao")
public class AqffXcXcjyDao extends BaseDaoImpl {
	
	/**
	 * @Title: query
	 * @Description: query
	 * @param @param page
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	public EasyUIPage query(EasyUIPage page,AqffXcXcjyxxb entity){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("begin", page.getBegin());
		map.put("end", page.getEnd());
		String sort = page.getSort();
		String order = page.getOrder();
		if (StringUtils.isBlank(sort)) {
			sort = "kzrq";
			order = "desc";
		}
		map.put("sort", sort);
		map.put("order", order);
		map.put("entity", entity);
		page.setRows(queryForList("AqffXcXcjyxxb.queryList", map));
		page.setTotal((Integer) queryForObject("AqffXcXcjyxxb.queryListCount", map));
		return page;
	}
	
	/**
	 * @Title: save
	 * @param @param entity    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public void saveXcjy(AqffXcXcjyxxb entity){
		insert("AqffXcXcjyxxb.save", entity);
	}
	
	/**
	 * @Title: update
	 * @param @param entity    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public void updateXcjy(AqffXcXcjyxxb entity){
		update("AqffXcXcjyxxb.update", entity);
	}
	
	/**
	 * @Title: delete
	 * @param @param entity    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public void deleteXcjy(AqffXcXcjyxxb entity){
		update("AqffXcXcjyxxb.delete", entity);
	}
}
