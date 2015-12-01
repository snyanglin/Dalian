/**********************************************************************   
 * <p>文件名：ZdryGlpzpzbDao.java </p>
 * <p>文件描述：重点人员管理配置表Dao 
 * @project_name：syrk_syrk
 * @author xu_wenjun@founder.com.cn 
 * @date 2015-3-12 上午11:14:15 
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
import com.founder.zdry.bean.ZdryGlpzpzb;

/******************************************************************************
 * @Package:      [com.founder.zdry.dao.ZdryGlpzpzbDao.java]  
 * @ClassName:    [ZdryGlpzpzbDao]   
 * @Description:  [重点人员管理配置表]   
 * @Author:       [xu_wenjun@founder.com.cn]  
 * @CreateDate:   [2015-3-12 上午11:14:15]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-3-12 上午11:14:15，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 */
@Repository("zdryGlpzpzbDao")
public class ZdryGlpzpzbDao extends BaseDaoImpl {
	
	/**
	 * 
	 * @Title: insert
	 * @Description: 保存
	 * @param @param entity    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public void insert(ZdryGlpzpzb entity){
		super.insert("ZdryGlpzpzb.save", entity);
	}
	
	/**
	 * 
	 * @Title: queryById
	 * @Description: 查询[根据主键]
	 * @param @param id
	 * @param @return    设定文件
	 * @return ZdryGlpzpzb    返回类型
	 * @throws
	 */
	public ZdryGlpzpzb queryById(String id){
		return (ZdryGlpzpzb) super.queryForObject("ZdryGlpzpzb.queryById", id);
	}
	
	/**
	 * 
	 * @Title: queryByZdrygllxdm
	 * @Description: 查询[根据管理类型代码]
	 * @param @param zdrygllxdm
	 * @param @return    设定文件
	 * @return ZdryGlpzpzb    返回类型
	 * @throws
	 */
	public ZdryGlpzpzb queryByZdrygllxdm(String zdrygllxdm){
		return (ZdryGlpzpzb) super.queryForObject("ZdryGlpzpzb.queryByZdrygllxdm", zdrygllxdm);
	}
	
	
	/**
	 * 
	 * @Title: queryByZdrygllxdm
	 * @Description: 查询[根据管理类型代码不过滤是否上级审批]
	 * @param @param zdrygllxdm
	 * @param @return    设定文件
	 * @return ZdryGlpzpzb    返回类型
	 * @throws
	 */
	public ZdryGlpzpzb queryByZdrygllxdmWhitOutSfsp(String zdrygllxdm){
		return (ZdryGlpzpzb) super.queryForObject("ZdryGlpzpzb.queryByZdrygllxdmWhitOutSfsp", zdrygllxdm);
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
	public int update(ZdryGlpzpzb entity){
		return super.update("ZdryGlpzpzb.update", entity);
	}
	
	/**
	 * 
	 * @Title: delete
	 * @Description: 注销
	 * @param @param entity    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public void delete(ZdryGlpzpzb entity){
		super.update("ZdryGlpzpzb.delete", entity);
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
	public EasyUIPage queryList(EasyUIPage page, ZdryGlpzpzb entity) {
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
		page.setTotal((Integer) queryForObject("ZdryGlpzpzb.queryCount", map));
		page.setRows(queryForList("ZdryGlpzpzb.queryList", map));
		return page;
	}

	/**
	 * 
	 * @Title: queryByDtjszqdmNotNull
	 * @Description: 查询【动态纪实周期】不为空的记录
	 * @param @return    设定文件
	 * @return List<ZdryGlpzpzb>    返回类型
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	public List<ZdryGlpzpzb> queryByDtjszqdmNotNull(){
		return (List<ZdryGlpzpzb>) super.queryForList("ZdryGlpzpzb.queryByDtjszqdmNotNull");
	}
}
