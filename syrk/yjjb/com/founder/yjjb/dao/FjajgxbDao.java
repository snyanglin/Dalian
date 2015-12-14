package com.founder.yjjb.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.base.entity.SessionBean;
import com.founder.yjjb.bean.Ajxxb;
import com.founder.yjjb.bean.Fjajgxb;
import com.founder.yjjb.bean.Xszcspb;

/**
 * 案件信息表</br>
 * 增删改查等基本操作
 * @author Administrator
 * @since 2014-11-17
 */
@Repository("fjajgxbDao")
public class FjajgxbDao extends BaseDaoImpl {
	
	/**
	 * 查询
	 * @param entity
	 * @return
	 * @since 2014-11-17
	 */
	public Fjajgxb queryById(Fjajgxb entity){
		
		return (Fjajgxb)super.queryForObject("fjajgxb.queryById", entity);
	}
	
	/**
	 * 新增<br>
	 * @param entity
	 * @return
	 * @since 2014-11-17
	 */
	public void save(Fjajgxb entity, SessionBean sessionBean) {
		
		insert("fjajgxb.save", entity);
	}
	
	/**
	 * 删除<br>
	 * @param entity
	 * @return
	 * @since 2014-11-17
	 */
	public void delete(Fjajgxb entity, SessionBean sessionBean) {
		
		update("fjajgxb.delete", entity);
	}

	/**
	 * @Title: queryByAjbh
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param entity
	 * @param @return    设定文件
	 * @throws
	 */
	public List<Fjajgxb> queryByAjbh(String ajbh) {
		List<Fjajgxb> list = queryForList("fjajgxb.queryByAjbh", ajbh);
		return list;
	}
	
	/**
	 * 删除<br>
	 * @param entity
	 * @return
	 * @since 2014-11-17
	 */
	public void deleteByAjbh(Fjajgxb entity, SessionBean sessionBean) {
		
		update("fjajgxb.deleteByAjbh", entity);
	}

	/**
	 * @Title: update
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param entity
	 * @param @param sessionBean    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public void update(Fjajgxb entity, SessionBean sessionBean) {
		update("fjajgxb.update", entity);
	}
	
}
