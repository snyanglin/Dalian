package com.founder.zdrygl.base.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.StringUtils;
import com.founder.zdrygl.base.model.ZdryJgdxqxjdjb;


/**
 * ****************************************************************************
 * @Package:      [com.founder.zdrygl.dao.ZdryJgdxqxjdjbDao.java]  
 * @ClassName:    [ZdryJgdxqxjdjbDao]   
 * @Description:  [监管对象请销假DAO]   
 * @Author:       [zhang.hai@founder.com.cn]  
 * @CreateDate:   [2015年9月6日 下午3:35:32]   
 * @UpdateUser:   [ZhangHai(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015年9月6日 下午3:35:32，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Repository("zdryJgdxqxjdjbDao")
public class ZdryJgdxqxjdjbDao extends BaseDaoImpl {
	
	/**
	 * 
	 * @Title: queryViewList
	 * @Description: TODO(查询下方菜单显示的信息，有最大条数限制)
	 * @param @param map
	 * @param @return    设定文件
	 * @return List<ZdryJgdxqxjdjb>    返回类型
	 * @throws
	 */
	public List<ZdryJgdxqxjdjb> queryViewList(Map<String, Object> map) {
		List<ZdryJgdxqxjdjb> list = null;
		if (map != null) {
			String zdryid = (String) map.get("zdryid");
			if (!StringUtils.isBlank(zdryid)) {
				list = queryForList("ZdryJgdxqxjdjb.queryViewList", map);
			}
		}
		return list;
	}

	/**
	 * @Title: queryById
	 * @Description: TODO(根据ID查询单条记录)
	 * @param @param id
	 * @param @return 设定文件
	 * @return ZdryJgdxqxjdjb 返回类型
	 * @throws
	 */
	public ZdryJgdxqxjdjb queryById(String id) {
		if (StringUtils.isBlank(id)) {
			return null;
		} else {
			return (ZdryJgdxqxjdjb) queryForObject("ZdryJgdxqxjdjb.queryById", id);
		}

	}

	public void save(ZdryJgdxqxjdjb entity, SessionBean sessionBean) {
		insert("ZdryJgdxqxjdjb.save", entity);
	}

	
	public void update(ZdryJgdxqxjdjb entity) {
		update("ZdryJgdxqxjdjb.update", entity);
	}

	/**
	 * 
	 * @Title: queryWxjNum
	 * @Description: TODO(查询未销假的数)
	 * @param @param zdryId
	 * @param @return    设定文件
	 * @return int    返回类型
	 * @throws
	 */
	public int queryWxjNum(String zdryId){
		return (int)queryForObject("ZdryJgdxqxjdjb.queryWxjNum", zdryId);
	}
}
