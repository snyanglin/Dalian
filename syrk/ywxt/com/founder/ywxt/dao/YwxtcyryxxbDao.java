package com.founder.ywxt.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.utils.StringUtils;
import com.founder.framework.utils.UUID;
import com.founder.ywxt.bean.Ywxtcyryxxb;
/***
 * ****************************************************************************
 * @Package:      [com.founder.ywxt.dao.YwxycyryxxbDao.java]  
 * @ClassName:    [YwxycyryxxbDao]   
 * @Description:  [业务协同参与人信息表DAO]   
 * @Author:       [wu_chunhui@founder.com.cn]  
 * @CreateDate:   [2015-6-1 下午2:48:31]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-6-1 下午2:48:31，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Repository("ywxtcyryxxbDao")
public class YwxtcyryxxbDao  extends BaseDaoImpl{

	/***
	 * 
	 * @Title: queryById
	 * @Description: TODO(查询)
	 * @param @param id
	 * @param @return    设定文件
	 * @return Ywxtcyryxxb    返回类型
	 * @throws
	 */
	public Ywxtcyryxxb queryById(String id) {
		if (StringUtils.isBlank(id)) {
			return null;
		} else {
			return (Ywxtcyryxxb) queryForObject("Ywxtcyryxxb.queryById", id);
		}
	}

	/**
	 * 新增<br>
	 * 
	 * @param entity
	 */
	public void save(Ywxtcyryxxb entity) {
		entity.setId(UUID.create()); // 生成主键
		insert("Ywxtcyryxxb.save", entity);
	}

	/**
	 * 更新<br>
	 * 
	 * @param entity
	 */
	public void update(Ywxtcyryxxb entity) {
		update("Ywxtcyryxxb.update", entity);
	}

	/**
	 * 删除<br>
	 * 
	 * @param entity
	 */
	public void delete(Ywxtcyryxxb entity) {
		update("Ywxtcyryxxb.delete", entity);
	}
	/***
	 * 
	 * @Title: queryByXtid
	 * @Description: TODO(根据协同任务查询出所有参与人)
	 * @param @param xtid
	 * @param @return    设定文件
	 * @return List<Ywxtcyryxxb>    返回类型
	 * @throws
	 */
	public List<Ywxtcyryxxb> queryByXtid(String xtid){
		return queryForList("Ywxtcyryxxb.queryByXtid", xtid);
	}
}
