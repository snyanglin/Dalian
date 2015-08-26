package com.founder.jcj.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.jcj.bean.JcjCjxxb;
import com.founder.jcj.bean.JcjCshpz;
import com.founder.jcj.bean.JcjCwrzb;
import com.founder.jcj.bean.JcjFkxxb;
import com.founder.jcj.bean.JcjJjxxb;
import com.founder.jcj.vo.JcjgnVO;
import com.founder.jcj.vo.JcjxxzsVO;

@Repository("jcjEditDao")
public class JcjEditDao extends BaseDaoImpl {

	public List<JcjxxzsVO> queryFwzsxx(Map<String, Object> map) {
		return queryForList("Jcjglpz.queryZhxxzspz",map);
	}

	public List<JcjgnVO> queryYwglgn(Map<String, Object> map) {
		return queryForList("Jcjglpz.queryYwglgn",map);
	}

	public void delete_xxzsnrb(Map<String, Object> map) {
		List<?> list = queryForList("Jcjglpz.queryxxzsnrbByxxdybm", map.get("url"));
		map.put("tablename", list.get(0).toString());
		if (list != null && list.size() > 0) {
			update("Jcjglpz.updateTableByxxdybm", map);
		} 
	}

	public JcjJjxxb queryJcjJjxxb(String id) {
		return (JcjJjxxb) queryForObject("Jcjglpz.queryJcjjjxxbById", id);
	}
	
	
	/**
	 * 
	 * @Title: queryJcjNoPt
	 * @Description: TODO(接处警列表查询)
	 * @param @param page
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	public EasyUIPage queryJcjNoPt(EasyUIPage page, JcjJjxxb entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("begin", page.getBegin());
		map.put("end", page.getEnd());
		String sort = page.getSort();
		String order = page.getOrder();
		if (StringUtils.isBlank(sort)) { // 默认排序
			order = "asc";
		}
		map.put("sort", sort);
		map.put("order", order);
		map.put("jcjjjxxb", entity);
		page.setTotal((Integer) queryForObject("Jcjglpz.queryCountJcjNoPt", map));
		page.setRows(queryForList("Jcjglpz.queryJcjNoPt", map));
		return page;
	}
	
	/**
	 * 
	 * @Title: queryJcjxxbById
	 * @Description: TODO(查询处警信息)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return JcjCjxxb    返回类型
	 * @throws
	 */
	public JcjCjxxb queryJcjxxbById(String id) {
		// TODO Auto-generated method stub
		return (JcjCjxxb) super.queryForObject("Jcjglpz.queryJcjxxbById", id);
	}
    /**
     * 
     * @Title: insertCjxxb
     * @Description: TODO(新增处警信息)
     * @param @param entity    设定文件
     * @return void    返回类型
     * @throws
     */
	public void insertCjxxb(JcjCjxxb entity) {
		// TODO Auto-generated method stub
		super.insertForObject("Jcjglpz.insertCjxxb", entity);
	}
    /**
     * 
     * @Title: updateCzrzb
     * @Description: TODO(修改处警信息)
     * @param @param entity    设定文件
     * @return void    返回类型
     * @throws
     */
	public void updateCjxxb(JcjCjxxb entity) {
		// TODO Auto-generated method stub
		super.update("Jcjglpz.updateJcxxbBy", entity);
	}
	
	
	
	public JcjFkxxb queryFkxxbById(String id) {
		// TODO Auto-generated method stub
		return (JcjFkxxb) super.queryForObject("Jcjglpz.queryJcjfkxxbById", id);
	}
	public void insertFkxxb(JcjFkxxb entity) {
		// TODO Auto-generated method stub
		super.insertForObject("Jcjglpz.insertjcjfkxxb", entity);
	}
	public void updateFkxxb(JcjFkxxb entity) {
		// TODO Auto-generated method stub
		super.update("Jcjglpz.updatefkxxbByid", entity);
	}
	
	public int queryCountFkxxb(String jjbh) {
		// TODO Auto-generated method stub
		return (Integer) super.queryForObject("Jcjglpz.queryCountFkxxb", jjbh);
	}
	
	
	public List<JcjFkxxb> queryJcjfkxxbByJjbh(String jjbh) {
		// TODO Auto-generated method stub
		return (List<JcjFkxxb>) super.queryForList("Jcjglpz.queryJcjfkxxbByJjbh", jjbh);
	}
	/**
	 * 
	 * @Title: insertJjxxb
	 * @Description: TODO(新增接警信息)
	 * @param @param entity    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public void insertJjxxb(JcjJjxxb entity) {
		// TODO Auto-generated method stub
		super.insertForObject("Jcjglpz.insertJjxxb", entity);
	}
	
	public void insertCshpzb(JcjCshpz entity) {
		// TODO Auto-generated method stub
		super.insertForObject("Jcjglpz.insertCshpzb", entity);
	}
    
	
	public void updateCshpz(JcjCshpz entity) {
		// TODO Auto-generated method stub
		super.update("Jcjglpz.updateCshpz", entity);
	}
	
	
	public JcjCshpz queryCshpzByXzqh(String district) {
		// TODO Auto-generated method stub
		return (JcjCshpz) super.queryForObject("Jcjglpz.queryCshpzByXzqh", district);
	}
	
	
	
	public JcjJjxxb queryJcjjjxxbByJJXBH(String jjbh) {
		return (JcjJjxxb) queryForObject("Jcjglpz.queryJcjjjxxbByJJXBH", jjbh);
	}
	/**
	 * 
	 * @Title: queryJcjjjxxb
	 * @Description: TODO(查询接警信息表列表)
	 * @param @param JcjJjxxb
	 * @param @return    设定文件
	 * @return List<JcjJjxxb>    返回类型
	 * @throws
	 */
	public List<JcjJjxxb> queryJcjjjxxb(JcjJjxxb JcjJjxxb){
		return queryForList("Jcjglpz.queryJcjjjxxb",JcjJjxxb);
	}
	
	
	
	
	 /**
	  * 
	  * @Title: cancelJjxxb
	  * @Description: TODO(注销接警信息)
	  * @param @param jjbh    设定文件
	  * @return void    返回类型
	  * @throws
	  */
	public void cancelJjxxb(JcjJjxxb entity) {
		// TODO Auto-generated method stub
		super.update("Jcjglpz.cancelJjxxb", entity);
	}
	
	 /**
     * 
     * @Title: insertCjxxb
     * @Description: TODO(新增错误日志表)
     * @param @param entity    设定文件
     * @return void    返回类型
     * @throws
     */
	public void insertJkCwrzb(JcjCwrzb entity) {
		// TODO Auto-generated method stub
		super.insertForObject("Jcjglpz.insertJkCwrzb", entity);
	}
}
