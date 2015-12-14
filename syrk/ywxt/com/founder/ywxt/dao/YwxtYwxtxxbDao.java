package com.founder.ywxt.dao;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.StringUtils;
import com.founder.framework.utils.UUID;
import com.founder.ywxt.bean.YwxtYwxtxxb;
/***
 * ****************************************************************************
 * @Package:      [com.founder.ywxt.dao.YwxtYwxtxxbDao.java]  
 * @ClassName:    [YwxtYwxtxxbDao]   
 * @Description:  [业务协同信息主表DAO]   
 * @Author:       [wu_chunhui@founder.com.cn]  
 * @CreateDate:   [2015-6-1 下午2:46:26]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-6-1 下午2:46:26，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Repository("ywxtYwxtxxbDao")
public class YwxtYwxtxxbDao  extends BaseDaoImpl {

	/***
	 * 
	 * @Title: queryById
	 * @Description: TODO(查询)
	 * @param @param id
	 * @param @return    设定文件
	 * @return YwxtYwxtxxb    返回类型
	 * @throws
	 */
	public YwxtYwxtxxb queryById(String id) {
		if (StringUtils.isBlank(id)) {
			return null;
		} else {
			return (YwxtYwxtxxb) queryForObject("YwxtYwxtxxb.queryById", id);
		}
	}

	/**
	 * 新增<br>
	 * 
	 * @param entity
	 */
	public void save(YwxtYwxtxxb entity) {
		entity.setId(UUID.create()); // 生成主键
		insert("YwxtYwxtxxb.save", entity);
	}

	/**
	 * 更新<br>
	 * 
	 * @param entity
	 */
	public void update(YwxtYwxtxxb entity) {
		update("YwxtYwxtxxb.update", entity);
	}

	/**
	 * 删除<br>
	 * 
	 * @param entity
	 */
	public void delete(YwxtYwxtxxb entity) {
		update("YwxtYwxtxxb.delete", entity);
	}
}
