package com.founder.syrkgl.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.jzym.bean.Ryjzdzzb;
import com.founder.syrkgl.bean.RyRyjbxxb;

/******************************************************************************
 * @Package: [com.founder.syrkgl.dao.RyRyjbxxbDao.java]
 * @ClassName: [RyRyjbxxbDao]
 * @Description: [人员基本信息表]
 * @Author: [hongguanjun]
 * @CreateDate: [2015-4-2 下午4:00:11]
 * @UpdateUser: [hongguanjun(如多次修改保留历史记录，增加修改记录)]
 * @UpdateDate: [2015-4-2 下午4:00:11，(如多次修改保留历史记录，增加修改记录)]
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]
 * @Version: [v1.0]
 */
@Repository("ryRyjbxxbDao")
public class RyRyjbxxbDao extends BaseDaoImpl {

	/**
	 * @Title: queryList
	 * @Description: TODO(查询列表)
	 * @param @param page
	 * @param @param entity
	 * @param @return 设定文件
	 * @return EasyUIPage 返回类型
	 * @throws
	 */
	public EasyUIPage queryList(EasyUIPage page, RyRyjbxxb entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("begin", page.getBegin());
		map.put("end", page.getEnd());
		String sort = page.getSort();
		String order = page.getOrder();
		if (StringUtils.isBlank(sort)) { // 默认排序
			sort = "cyzjdm";
			order = "asc";
		}
		map.put("sort", sort);
		map.put("order", order);
		entity.setWwx(StringUtils.getSqlExpression(entity.getWwx()));
		entity.setWwm(StringUtils.getSqlExpression(entity.getWwm()));
		entity.setXm(StringUtils.getSqlExpression(entity.getXm()));
		entity.setCym(StringUtils.getSqlExpression(entity.getCym()));
		entity.setHjd_dzxz(StringUtils.getSqlExpression(entity.getHjd_dzxz()));
		entity.setZy(StringUtils.getSqlExpression(entity.getZy()));
		map.put("ryRyjbxxb", entity);
		page.setTotal((Integer) queryForObject("RyRyjbxxb.queryCount", map));
		page.setRows(queryForList("RyRyjbxxb.queryList", map));
		return page;
	}
	
	public List<RyRyjbxxb> queryAllByPage(String begin,String end){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("begin", begin);
		map.put("end", end);
		return queryForList("RyRyjbxxb.queryAllByPage",map);
	}
	
	public int queryAllCount(){
		return (Integer)queryForObject("RyRyjbxxb.queryAllCount",null);
	}
	

	/**
	 * @Title: queryById
	 * @Description: TODO(根据ID查询单条记录)
	 * @param @param id
	 * @param @return 设定文件
	 * @return RyRyjbxxb 返回类型
	 * @throws
	 */
	public RyRyjbxxb queryById(String id) {
		if (StringUtils.isBlank(id)) {
			return null;
		} else {
			return (RyRyjbxxb) queryForObject("RyRyjbxxb.queryById", id);
		}
	}

	/**
	 * @Title: queryByCyzjdmZjhm
	 * @Description: 查询单条（根据证件种类和证件号码）
	 * @param @param cyzjdm
	 * @param @param zjhm
	 * @param @return 设定文件
	 * @return RyRyjbxxb 返回类型
	 * @throws
	 */
	public RyRyjbxxb queryByCyzjdmZjhm(String cyzjdm, String zjhm) {
		RyRyjbxxb entity = null;
		if (!StringUtils.isBlank(zjhm)) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("cyzjdm", cyzjdm);
			map.put("zjhm", zjhm);
			entity = (RyRyjbxxb) queryForObject("RyRyjbxxb.queryByCyzjdmZjhm",
					map);
		}
		return entity;
	}
	
	/**
	 * @Title: queryByCyzjdmZjhm
	 * @Description: 取没有照片的人员基本信息表数据
	 * @param @return 设定文件
	 * @return List<RyRyjbxxb> 返回类型
	 * @throws
	 */
	public List<RyRyjbxxb> queryNotHavePhoto(String begin,String end) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("begin", begin);
		map.put("end", end);
			List<RyRyjbxxb>  jbxxs= (List<RyRyjbxxb>) queryForList("RyRyjbxxb.queryNotHavePhotoByPage",map);
		
		return jbxxs;
	}
	
	public int queryNotHavePhotoCount(){
		return (Integer)queryForObject("RyRyjbxxb.queryNotHavePhotoCount",null);
	}
	

	/**
	 * @Title: save
	 * @Description: TODO(新增)
	 * @param @param entity
	 * @param @param sessionBean 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public void save(RyRyjbxxb entity, SessionBean sessionBean) {
		insert("RyRyjbxxb.save", entity);
	}

	/**
	 * @Title: update
	 * @Description: TODO(更新)
	 * @param @param entity
	 * @param @param sessionBean 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public void update(RyRyjbxxb entity, SessionBean sessionBean) {
		update("RyRyjbxxb.update", entity);
	}

	/**
	 * @Title: delete
	 * @Description: TODO(删除)
	 * @param @param entity
	 * @param @param sessionBean 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public void delete(RyRyjbxxb entity, SessionBean sessionBean) {
		update("RyRyjbxxb.delete", entity);
	}
}