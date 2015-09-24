package com.founder.zdrygl.base.dao;


import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.zdrygl.base.vo.ZdrygnVO;
import com.founder.zdrygl.base.vo.ZdryxxzsVO;

/**
 * ****************************************************************************
 * @Package:      [com.founder.zdrygl.dao.ZdryEditDao.java]  
 * @ClassName:    [ZdryEditDao]   
 * @Description:  [一句话描述该类的功能]   
 * @Author:       [weiwen]  
 * @CreateDate:   [2015-3-14 下午2:08:06]   
 * @UpdateUser:   [weiwen]   
 * @UpdateDate:   [2015-3-14 下午2:08:06，(如多次修改保留历史记录，增加修改记录)]   
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

}
