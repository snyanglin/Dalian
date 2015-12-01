/**********************************************************************   
 * <p>文件名：ZdryJsmbpzbDao.java </p>
 * <p>文件描述：TODO(描述该文件做什么) 
 * @project_name：syrk_syrk
 * @author xu_wenjun@founder.com.cn 
 * @date 2015-3-13 上午8:50:42 
 * @history
 * @department：研发部
 *
*/
package com.founder.zdry.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.zdry.bean.ZdryJsmbpzb;

/******************************************************************************
 * @Package:      [com.founder.zdry.dao.ZdryJsmbpzbDao.java]  
 * @ClassName:    [ZdryJsmbpzbDao]   
 * @Description:  [重点人员纪实模板配置表]   
 * @Author:       [xu_wenjun@founder.com.cn]  
 * @CreateDate:   [2015-3-13 上午8:50:42]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-3-13 上午8:50:42，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 */
@Repository("zdryJsmbpzbDao")
public class ZdryJsmbpzbDao extends BaseDaoImpl {
	
	/**
	 * 
	 * @Title: insert
	 * @Description: 保存
	 * @param @param entity    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public void insert(ZdryJsmbpzb entity){
		super.insert("ZdryJsmbpzb.save", entity);
	}
	
	/**
	 * 
	 * @Title: queryById
	 * @Description: 查询[根据主键]
	 * @param @param id
	 * @param @return    设定文件
	 * @return ZdryJsmbpzb    返回类型
	 * @throws
	 */
	public ZdryJsmbpzb queryById(String id){
		return (ZdryJsmbpzb) super.queryForObject("ZdryJsmbpzb.queryById", id);
	}
	
	/**
	 * 
	 * @Title: update
	 * @Description: 修改
	 * @param @param entity
	 * @param @return    设定文件
	 * @return int    返回类型
	 * @throws
	 */
	public int update(ZdryJsmbpzb entity){
		return super.update("ZdryJsmbpzb.update", entity);
	}
	
	/**
	 * 
	 * @Title: delete
	 * @Description: 注销
	 * @param @param id    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public void delete(ZdryJsmbpzb entity){
		super.update("ZdryJsmbpzb.delete", entity);
	}
	
	/**
	 * 
	 * @Title: updateBeforeSetDefault
	 * @Description: 设置[默认]前,对该类型其他模板设为[非默认]
	 * @param @param entity    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public void updateBeforeSetDefault(ZdryJsmbpzb entity){
		super.update("ZdryJsmbpzb.updateBeforeSetDefault", entity);
	}
	
	/**
	 * 
	 * @Title: queryList
	 * @Description: 查询列表
	 * @param @param page
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	public EasyUIPage queryList(EasyUIPage page, ZdryJsmbpzb entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("begin", page.getBegin());
		map.put("end", page.getEnd());
		String sort = page.getSort();
		String order = page.getOrder();
		if (StringUtils.isBlank(sort)) {
			sort = "id";
			order = "asc";
		}
		map.put("sort", sort);
		map.put("order", order);
		map.put("entity", entity);
		page.setTotal((Integer) queryForObject("ZdryJsmbpzb.queryCount", map));
		page.setRows(queryForList("ZdryJsmbpzb.queryList", map));
		return page;
	}
	
	@SuppressWarnings("unchecked")
	public List<ZdryJsmbpzb> queryForList(ZdryJsmbpzb entity){
		return queryForList("ZdryJsmbpzb.queryForList", entity);
	}

}
