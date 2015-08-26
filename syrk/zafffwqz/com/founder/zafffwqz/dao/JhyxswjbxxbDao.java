/**********************************************************************   
 * <p>文件名：JhyxswjbxxbDao.java </p>
 * <p>文件描述：TODO(集会游行示威DAO) 
 * @project_name：syrk
 * @author tian_chengwei@founder.com.cn 
 * @date 2015-5-18 上午9:41:32 
 * @history
 * @department：研发部
 *
*/
package com.founder.zafffwqz.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.zafffwqz.bean.Jhyxswjbxxb;

/******************************************************************************
 * @Package:      [com.founder.zafffwqz.dao.AfxxbDao.java]  
 * @ClassName:    [AfxxbDao]   
 * @Description:  [一句话描述该类的功能]   
 * @Author:       [tian_chengwei@founder.com.cn]  
 * @CreateDate:   [2015-5-18 上午9:41:32]   
 * @UpdateUser:   [lk(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-5-18 上午9:41:32，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 * 
 * @review      : wu.w@founder.com.cn
 * @reviewDate  : 20150604
 */
@Repository("jhyxswjbxxbDao")
public class JhyxswjbxxbDao extends BaseDaoImpl {
	/**
	 * 
	 * @Title: queryJhyxswjbxxb
	 * @Description: TODO(单条查询)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return Jhyxswjbxxb    返回类型
	 * @throws
	 */
	public Jhyxswjbxxb queryJhyxswjbxxb(Jhyxswjbxxb entity){
		
		return (Jhyxswjbxxb) super.queryForObject("Jhyxswjbxxb.queryJhyxswjbxxb", entity);
	}
	/**
	 * 
	 * @Title: saveJhyxswjbxxb
	 * @Description: TODO(保存)
	 * @param @param entity    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public void saveJhyxswjbxxb(Jhyxswjbxxb entity){
		super.insert("Jhyxswjbxxb.insertJhyxswjbxxb", entity);
	}
	/**
	 * 
	 * @Title: delete
	 * @Description: TODO(删除操作)
	 * @param entity
	 * @return void返回类型
	 * @throws
	 */
	public void delete(Jhyxswjbxxb entity){
		super.delete("Jhyxswjbxxb.delete", entity);
	}
	/**
	 * 
	 * @Title: updateJhyxswjbxxb
	 * @Description: TODO(修改)
	 * @param @param entity    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public void updateJhyxswjbxxb(Jhyxswjbxxb entity){
		super.update("Jhyxswjbxxb.updateJhyxswjbxxb", entity);
	}
	/**
	 * 
	 * @Title: queryList
	 * @Description: TODO(分页查询)
	 * @param @param page
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	public EasyUIPage queryList(EasyUIPage page,Jhyxswjbxxb entity){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("begin", page.getBegin());
		map.put("end", page.getEnd());
		String sort = page.getSort();
		String order = page.getOrder();
		if (StringUtils.isBlank(sort)) { // 默认排序
			sort = "id";
			order = "asc";
		}
		map.put("sort", sort);
		map.put("order", order);
		map.put("jhyxswjbxxb", entity);
		page.setTotal((Integer) queryForObject("Jhyxswjbxxb.queryCount", map));
		page.setRows(queryForList("Jhyxswjbxxb.queryList", map));
		return page;
	}

}
