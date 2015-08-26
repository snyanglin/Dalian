package com.founder.sydw.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.sydw.bean.Dwcyjcrwxxb;
import com.founder.sydw.bean.Xfdwcccsxxb;
/**
 * ****************************************************************************
 * @Package:      [com.founder.sydw.dao.CyjhDao.java]  
 * @ClassName:    [CyjhDao]   
 * @Description:  抽样计划  
 * @Author:       [yu_guangli@founder.com.cn]  
 * @CreateDate:   [2015-7-6 上午9:15:02]   
 * @UpdateUser:   [yuguangli(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-7-6 上午9:15:02，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Repository("cyjhDao")
public class CyjhDao extends BaseDaoImpl {
	/**
	 * 
	 * @Title: queryXfdwlxByJbdwlb
	 * @Description: 按照消防监管类别统计本辖区消防单位数量
	 * @param @param param
	 * @param @return    设定文件
	 * @return Map<String,Object>    返回类型
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	public List<Map<String,Object>> queryXfdwlxByJbdwlb(Map<String,Object> param){
		return queryForList("Cyjh.queryXfdwlxByJbdwlb", param);
	}
	
	/**
	 * 
	 * @Title: saveXfdwcccsxxb
	 * @Description: 保存消防单位抽查参数配置
	 * @param @param entity
	 * @param @param sessionBean    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public void saveXfdwcccsxxb(Xfdwcccsxxb entity, SessionBean sessionBean) {
		insert("Cyjh.saveXfdwcccsxxb", entity);
	}
	/**
	 * 
	 * @Title: modifyXfdwcccsxxb
	 * @Description: 修改消防单位抽查参数配置
	 * @param @param entity
	 * @param @param sessionBean    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public void modifyXfdwcccsxxb(Xfdwcccsxxb entity, SessionBean sessionBean) {
		update("Cyjh.modifyXfdwcccsxxb", entity);
	}
	/**
	 * 
	 * @Title: deleteXfdwcccsxxb
	 * @Description: 删除消防单位抽查参数配置
	 * @param @param entity
	 * @param @param sessionBean    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public void deleteXfdwcccsxxb(Xfdwcccsxxb entity, SessionBean sessionBean) {
		update("Cyjh.modifyXfdwcccsxxb", entity);
	}
	/**
	 * 
	 * @Title: queryXfdwcccsxxbForPage
	 * @Description: 分页查询消防单位抽查参数配置
	 * @param @param page
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	public EasyUIPage queryXfdwcccsxxbForPage(EasyUIPage page,Xfdwcccsxxb entity){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("begin", page.getBegin());
		map.put("end", page.getEnd());
		String sort = page.getSort();
		String order = page.getOrder();
		if (StringUtils.isBlank(sort)) { // 默认排序
			sort = "nf";
			order = "asc";
		}
		map.put("sort", sort);
		map.put("order", order);
		map.put("xfdwcccsxxb", entity);
		page.setTotal((Integer) queryForObject("Cyjh.queryXfdwcccsxxbCount", map));
		page.setRows(queryForList("Cyjh.queryXfdwcccsxxbForPage", map));
		return page;
	}
	/**
	 * 
	 * @Title: queryXfdwcccsxxb
	 * @Description: 查询单条消防单位抽查参数配置
	 * @param @param entity
	 * @param @return    设定文件
	 * @return Xfdwcccsxxb    返回类型
	 * @throws
	 */
	public Xfdwcccsxxb queryXfdwcccsxxb(Xfdwcccsxxb entity){
		Xfdwcccsxxb vo = (Xfdwcccsxxb)queryForObject("Cyjh.queryXfdwcccsxxb", entity);
		return vo;
	}
	
	/**
	 * 
	 * @Title: modifyDwcyjcrwxxb
	 * @Description: 修改单位抽样检查任务
	 * @param @param entity
	 * @param @param sessionBean    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public void modifyDwcyjcrwxxb(Dwcyjcrwxxb entity, SessionBean sessionBean) {
		update("Cyjh.modifyDwcyjcrwxxb", entity);
	}
	
	/**
	 * 
	 * @Title: queryDwcyjcrwxxbForPage
	 * @Description: 单位抽样检查任务分页查询
	 * @param @param page
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	public EasyUIPage queryDwcyjcrwxxbForPage(EasyUIPage page,Dwcyjcrwxxb entity){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("begin", page.getBegin());
		map.put("end", page.getEnd());
		String sort = page.getSort();
		String order = page.getOrder();
		if (StringUtils.isBlank(sort)) { // 默认排序
			sort = "xt_cjsj";
			order = "asc";
		}
		map.put("sort", sort);
		map.put("order", order);
		map.put("dwcyjcrwxxb", entity);
		page.setTotal((Integer) queryForObject("Cyjh.queryDwcyjcrwxxbCount", map));
		page.setRows(queryForList("Cyjh.queryDwcyjcrwxxbForPage", map));
		return page;
	}

	/**
	 * 
	 * @Title: saveDwcyjcrwxxb
	 * @Description: 添加单位抽样检查任务
	 * @param @param entity
	 * @param @param sessionBean    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public void saveDwcyjcrwxxb(Dwcyjcrwxxb entity, SessionBean sessionBean) {
		insert("Cyjh.saveDwcyjcrwxxb", entity);
	}
	
	/**
	 * 
	 * @Title: queryDwcyjcrwxxbsByRwid
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param rwid
	 * @param @return    设定文件
	 * @return List<Dwcyjcrwxxb>    返回类型
	 * @throws
	 */
	public List<Dwcyjcrwxxb> queryDwcyjcrwxxbsByRwid(Map<String,Object> param){
		return queryForList("Cyjh.queryDwcyjcrwxxbsByRwid", param);
	}
}
