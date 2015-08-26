/**********************************************************************   
 * <p>文件名：QzbDao.java </p>
 * <p>文件描述：犬只管理dao 
 * @project_name：syrk
 * @author liu_shuai@founder.com.cn 
 * @date 2015-5-13 上午9:59:20 
 * @history
 * @department：研发部
 *
*/
package com.founder.zafffwqz.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.zafffwqz.bean.Qzb;
import com.founder.zafffwqz.bean.Qzgz;

/**
 * ****************************************************************************
 * @Package:      [com.founder.zafffwqz.dao.QzbDao.java]  
 * @ClassName:    [QzbDao]   
 * @Description:  [犬只管理dao]   
 * @Author:       [liu_shuai@founder.com.cn]  
 * @CreateDate:   [2015-5-13 上午10:02:28]   
 * @UpdateUser:   [liushuai(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-5-13 上午10:02:28，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Repository("qzbDao")
public class QzbDao extends BaseDaoImpl {
	/**
	 * 
	 * @Title: queryQzb
	 * @Description: 跳转查询-犬只管理
	 * @param entity
	 * @return Qzb   返回类型
	 * @throws
	 */
	public Qzb queryQzb(Qzb entity){
		return (Qzb) super.queryForObject("Qzb.queryQzb", entity);
		
	}
	/**
	 * 
	 * @Title: saveQzb
	 * @Description: 保存-犬只管理
	 * @param entity
	 * @throws
	 */
	public void saveQzb(Qzb entity){
		super.insert("Qzb.insertQzb", entity);	
	}
	/**
	 * 
	 * @Title: updateQzb
	 * @Description: 更新-犬只管理
	 * @param entity
	 * @throws
	 */
	public void updateQzb(Qzb entity){
		super.update("Qzb.updateQzb", entity);
	}
	/**
	 * 
	 * @Title: queryList
	 * @Description: 查询列表-犬只管理
	 * @param page
	 * @param map
	 * @return EasyUIPage   返回类型
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	public EasyUIPage queryList(EasyUIPage page, Map map){
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
		page.setTotal((Integer) queryForObject("Qzb.queryQzbCount", map));
		page.setRows(queryForList("Qzb.queryList", map));
		return page;
	}
	/**
	 * 
	 * @Title: delete
	 * @Description: 注销-犬只管理
	 * @param entity
	 * @throws
	 */
	public void delete(Qzb entity) {
		super.update("Qzb.delete", entity);
	}
	/**
	 * 
	 * @Title: queryGz
	 * @Description: 查询规则-犬只管理
	 * @param Map<String, Object>
	 * @return List<Qzgz>   返回类型
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	public List<Qzgz> queryGz(Map<String, Object> map) {
		return super.queryForList("Qzb.queryGz", map);

	}
	
}
