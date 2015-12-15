package com.founder.zdrygl.base.dao;


import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.zdrygl.base.vo.ZdrygnVO;
import com.founder.zdrygl.base.vo.ZdrylgxxVO;
import com.founder.zdrygl.base.vo.ZdryxxzsVO;

/**
 * ****************************************************************************
 * @Package:      [com.founder.zdrygl.base.dao.ZdryEditDao.java]  
 * @ClassName:    [ZdryEditDao]   
 * @Description:  [重点人员编辑配置页面DAO]   
 * @Author:       [wei.wen@founder.com.cn]  
 * @CreateDate:   [2015年9月21日 下午7:47:58]   
 * @UpdateUser:   [wei.wen@founder.com.cn(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015年9月21日 下午7:47:58，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Repository("zdryEditDao")
public class ZdryEditDao extends BaseDaoImpl {
	
	/**
	 * 
	 * @Title: queryYwglgn
	 * @Description: TODO(业务办理菜单查询)
	 * @param @param gnlxdm
	 * @param @return    设定文件
	 * @return List<ZdrygnVO>    返回类型
	 * @throw
	 */
	@SuppressWarnings("unchecked")
	public List<ZdrygnVO> queryYwglgn(String gnlxdm) {
		return queryForList("ZdryEdit.queryYwglgn", gnlxdm);
	}

	/**
	 * 
	 * @Title: queryRyzsxx
	 * @Description: TODO(人员展示信息菜单查询)
	 * @param @param map
	 * @param @return    设定文件
	 * @return List<ZdryxxzsVO>    返回类型
	 * @throw
	 */
	@SuppressWarnings("unchecked")
	public List<ZdryxxzsVO> queryRyzsxx(Map<String, Object> map) {
		return queryForList("ZdryEdit.queryXxzsByZdrylx", map);
	}

	/**
	 * 
	 * @Title: delete_xxzsnrb
	 * @Description: TODO(展示菜单中的删除操作)
	 * @param @param map
	 * @param @return    设定文件
	 * @return int    返回类型
	 * @throw
	 */
	public int delete_xxzsnrb(Map<String, Object> map) {
		List<?> list = queryForList("ZdryEdit.queryxxzsnrbByxxdybm", map.get("url"));
		map.put("tablename", list.get(0).toString());
		if (list != null && list.size() > 0) {
			return update("ZdryEdit.updateTableByxxdybm", map);
		} else {
			return 0;
		}
	}

	public List<ZdrylgxxVO> queryLgxxByZdryid(Map<String, Object> map) {
		return queryForList("ZdryEdit.queryLgxxByZdryid", map.get("zdryid"));
	}

}
