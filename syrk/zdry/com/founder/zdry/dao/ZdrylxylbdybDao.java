package com.founder.zdry.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.zdry.bean.Zdrylxylbdyb;


/**
 * ****************************************************************************
 * @Package:      [com.founder.syrk.dao.ZdrylxylbdybDao.java]  
 * @ClassName:    [ZdrylxylbdybDao]   
 * @Description:  [重点人员类型与类别对应关系DAO]   
 * @Author:       [lixiaoqin@founder.com.cn]  
 * @CreateDate:   [2015-1-23 下午1:47:33]   
 * @UpdateUser:   [zhangxijiu@founder.com.cn(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-2-2 下午15:16:33，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(添加添加、修改、删除方法 ,查询count方法)]  
 * @Version:      [v1.0]
 */
@Repository("zdrylxylbdybDao")
public class ZdrylxylbdybDao extends BaseDaoImpl {
	
	/**
	 * 
	 * @Title: queryList
	 * @Description: TODO(查询列表)
	 * @param @param page
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	public EasyUIPage queryList(EasyUIPage page, Zdrylxylbdyb entity) {
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
		map.put("zdrylxylbdyb", entity);
		List<?> list = queryForList("Zdrylxylbdyb.queryList", map);
		if (page.getBegin() == 0) {
			if (list != null && list.size() > 0) {
				page.setTotal(list.size());
			} else {
				page.setTotal(0);
			}
		} else {
			if (page.getTotal() == 0) {
				if (list != null && list.size() > 0) {
					page.setTotal(list.size());
				}
			}
		}
		page.setRows(list);
		return page;
	}
	
	/**
	 * 
	 * @Title: queryCount
	 * @Description: TODO(查询列表)
	 * @param @param page
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	public long queryCount(Zdrylxylbdyb entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("zdrylxylbdyb", entity);
		Integer count = (Integer) queryForObject("Zdrylxylbdyb.queryCount",
				map);
		return count.longValue();
	}
	

	/***
	 * 
	 * @Title: save
	 * @Description: 保存重点人员类型与类别对应关系
	 * @author zhang_xijiu@founder.com.cn
	 * @param @param entity
	 * @param @return    
	 * @return  
	 * @throws
	 */
	public void save(Zdrylxylbdyb entity,SessionBean sessionBean) {
		super.insert("Zdrylxylbdyb.save", entity);
	}
	/***
	 * 
	 * @Title: update
	 * @Description: 更新重点人员类型与类别对应关系
	 * @author zhang_xijiu@founder.com.cn
	 * @param @param entity
	 * @param @return    
	 * @return  
	 * @throws
	 */
	public void update(Zdrylxylbdyb entity,SessionBean sessionBean) {
		super.update("Zdrylxylbdyb.update", entity);
	}
	/***
	 * 
	 * @Title: query
	 * @Description: 查询重点人员类型与类别对应关系
	 * @author zhang_xijiu@founder.com.cn
	 * @param @param entity
	 * @param @return    
	 * @return  
	 * @throws
	 */
	public Zdrylxylbdyb query(Zdrylxylbdyb entity) {
		return (Zdrylxylbdyb) super.queryForObject("Zdrylxylbdyb.query", entity);
	}
	/***
	 * 
	 * @Title: delete
	 * @Description: 删除重点人员类型与类别对应关系
	 * @author zhang_xijiu@founder.com.cn
	 * @param @param entity
	 * @param @return    
	 * @return  
	 * @throws
	 */
	public void delete(Zdrylxylbdyb entity, SessionBean sessionBean) {
		super.update("Zdrylxylbdyb.delete", entity);
	}
	/***
	 * 
	 * @Title: queryZdrylbdm
	 * @Description: 查询重点人员类型与类别对应关系
	 * @author zhang_xijiu@founder.com.cn
	 * @param @param zdrylxdm
	 * @param @return  List<Zdrylxylbdyb>  
	 * @return  
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	public List<Zdrylxylbdyb> queryZdrylbdm(String zdrylxdm){
		return queryForList("Zdrylxylbdyb.queryZdrylbdm",zdrylxdm);
	}
	/***
	 * 
	 * @Title: getisExist
	 * @Description: 判断重点人员类型与类别对应关系
	 * @author zhang_xijiu@founder.com.cn
	 * @param @param zdrylxdm
	 * @param @return  List<Zdrylxylbdyb>  
	 * @return  
	 * @throws
	 */
	public List<Zdrylxylbdyb> getisExist(String zdrylbdm) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("zdrylbdm", zdrylbdm);
		return queryForList("Zdrylxylbdyb.queryisExist", map);
	}
	

}

