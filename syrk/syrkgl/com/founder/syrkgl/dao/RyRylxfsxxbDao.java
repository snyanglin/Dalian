package com.founder.syrkgl.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.StringUtils;
import com.founder.syrkgl.bean.RyRylxfsxxb;

/**
 * ****************************************************************************
 * @Package:      [com.founder.syrkgl.dao.RyRylxfsxxbDao.java]  
 * @ClassName:    [RyRylxfsxxbDao]   
 * @Description:  [实有人口附加信息-人员联系方式信息表]   
 * @Author:       [xu_wenjun@founder.com.cn]  
 * @CreateDate:   [2015-4-7 下午7:44:57]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-4-7 下午7:44:57，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Repository("ryRylxfsxxbDao")
public class RyRylxfsxxbDao extends BaseDaoImpl {

	/**
	 * 查询列表<br>
	 * 
	 * @param page
	 * @param entity
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<RyRylxfsxxb> queryViewList(Map<String, Object> map) {
		List<RyRylxfsxxb> list = null;
		if (map != null) {
			String ryid = (String) map.get("ryid");
			if (!StringUtils.isBlank(ryid)) {
				list = queryForList("RyRylxfsxxb.queryViewList", map);
			}
		}
		return list;
	}

	/**
	 * @Title: queryById
	 * @Description: TODO(根据ID查询单条记录)
	 * @param @param id
	 * @param @return 设定文件
	 * @return RyRylxfsxxb 返回类型
	 * @throws
	 */
	public RyRylxfsxxb queryById(String id) {
		if (StringUtils.isBlank(id)) {
			return null;
		} else {
			return (RyRylxfsxxb) queryForObject("RyRylxfsxxb.queryById", id);
		}
	}

	/**
	 * 新增<br>
	 * 
	 * @param entity
	 */
	public void save(RyRylxfsxxb entity, SessionBean sessionBean) {
		insert("RyRylxfsxxb.save", entity);
	}

	/**
	 * 更新<br>
	 * 
	 * @param entity
	 */
	public void update(RyRylxfsxxb entity, SessionBean sessionBean) {
		update("RyRylxfsxxb.update", entity);
	}

	/**
	 * 删除<br>
	 * 
	 * @param entity
	 */
	public void delete(RyRylxfsxxb entity, SessionBean sessionBean) {
		update("RyRylxfsxxb.delete", entity);
	}
	
	/**
	 * 
	 * @Title: queryCount
	 * @Description: TODO(根据条件查询记录数)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return Integer    返回类型
	 * @throws
	 */
	public Integer queryCount(RyRylxfsxxb entity){
		return (Integer) queryForObject("RyRylxfsxxb.queryCount", entity);
	}
	
	/**
	 * 
	 * @Title: queryLastLxfs
	 * @Description: TODO(返回最新的联系方式)
	 * @param @param ryid
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	public String queryLastLxfs(String ryid){
		return (String) queryForObject("RyRylxfsxxb.queryLastLxfs", ryid);
	}
	
	/**
	 * 
	 * @Title: queryLxfsValidLs
	 * @Description: TODO(验证联系方式是否与其他人重复)
	 * @param @param ryid
	 * @param @param lxfs
	 * @param @return    设定文件
	 * @return RyRylxfsxxb    返回类型
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	public RyRylxfsxxb queryLxfsValidLs(String ryid, String lxfs){
		RyRylxfsxxb entity = new RyRylxfsxxb();
		entity.setLxfs(lxfs);
		List<RyRylxfsxxb> list = queryForList("RyRylxfsxxb.queryLxfsValidLs", entity);
		RyRylxfsxxb returnVal = new RyRylxfsxxb();
		if(list != null && list.size() > 0){
			returnVal = list.get(0);
		}
		return returnVal;
	}

}
