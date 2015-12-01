package com.founder.zdry.dao;


import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.zdry.vo.ZdrygnVO;
import com.founder.zdry.vo.ZdryxxzsVO;

/**
 * ****************************************************************************
 * @Package:      [com.founder.zdry.dao.ZdryEditDao.java]  
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

	public List<ZdrygnVO> queryYwglgn(String gnlxdm) {
		return queryForList("ZdryEdit.queryYwglgn", gnlxdm);
	}

	public List<ZdryxxzsVO> queryRyzsxx(Map<String, Object> map) {
		return queryForList("ZdryEdit.queryXxzsByZdrylx", map);
	}

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
