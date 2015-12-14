package com.founder.ywxt.dao;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.StringUtils;
import com.founder.framework.utils.UUID;
import com.founder.ywxt.bean.YwxtYwxtCdxxb;

/****
 * ****************************************************************************
 * @Package:      [com.founder.ywxt.dao.YwxtYwxtCdxxbDao.java]  
 * @ClassName:    [YwxtYwxtCdxxbDao]   
 * @Description:  [一句话描述该类的功能]   
 * @Author:       [wu_chunhui@founder.com.cn]  
 * @CreateDate:   [2015-6-1 下午2:37:32]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-6-1 下午2:37:32，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Repository("ywxtYwxtCdxxbDao")
public class YwxtYwxtCdxxbDao extends BaseDaoImpl {

	/***
	 * 
	 * @Title: queryById
	 * @Description: TODO(查询)
	 * @param @param id
	 * @param @return    设定文件
	 * @return YwxtYwxtCdxxb    返回类型
	 * @throws
	 */
	public YwxtYwxtCdxxb queryById(String id) {
		if (StringUtils.isBlank(id)) {
			return null;
		} else {
			return (YwxtYwxtCdxxb) queryForObject("YwxtYwxtCdxxb.queryById", id);
		}
	}

	/**
	 * 新增<br>
	 * 
	 * @param entity
	 */
	public void save(YwxtYwxtCdxxb entity) {
		entity.setId(UUID.create()); // 生成主键
		insert("YwxtYwxtCdxxb.save", entity);
	}

	/**
	 * 更新<br>
	 * 
	 * @param entity
	 */
	public void update(YwxtYwxtCdxxb entity) {
		update("YwxtYwxtCdxxb.update", entity);
	}

	/**
	 * 删除<br>
	 * 
	 * @param entity
	 */
	public void delete(YwxtYwxtCdxxb entity) {
		update("YwxtYwxtCdxxb.delete", entity);
	}

}
