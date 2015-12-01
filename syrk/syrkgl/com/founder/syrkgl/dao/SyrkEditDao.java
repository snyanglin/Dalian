package com.founder.syrkgl.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.service.attachment.bean.ZpfjFjxxb;
import com.founder.syrkgl.vo.SyrkgnVo;
import com.founder.syrkgl.vo.SyrkxxzsVo;

/***
 * ****************************************************************************
 * 
 * @Package: [com.founder.syrkgl.dao.SyrkEditDao.java]
 * @ClassName: [SyrkEditDao]
 * @Description: [实有人口编辑页面查询dao]
 * @Author: [wu_chunhui@founder.com.cn]
 * @CreateDate: [2015-4-3 下午2:20:27]
 * @UpdateUser: [Administrator(如多次修改保留历史记录，增加修改记录)]
 * @UpdateDate: [2015-4-3 下午2:20:27，(如多次修改保留历史记录，增加修改记录)]
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]
 * @Version: [v1.0]
 */
@Repository("syrkEditDao")
public class SyrkEditDao extends BaseDaoImpl {

	/****
	 * 
	 * @Title: queryYwglgn
	 * @Description: TODO(查询功能)
	 * @param @param gnlxdm
	 * @param @return    设定文件
	 * @return List<SyrkgnVo>    返回类型
	 * @throws
	 */
	public List<SyrkgnVo> queryYwglgn(String gnlxdm,String syrklx) {
		Map<String,String> map = new HashMap<String,String>();
		map.put("syrklx", syrklx);
		map.put("gnlxdm", gnlxdm);
		return queryForList("SyrkEdit.queryYwglgn", map);
	}

	/**
	 * 
	 * @Title: queryRyzsxx
	 * @Description: TODO(查询信息展示项)
	 * @param @param map
	 * @param @return    设定文件
	 * @return List<SyrkxxzsVo>    返回类型
	 * @throws
	 */
	public List<SyrkxxzsVo> queryRyzsxx(Map<String, Object> map) {
		return queryForList("SyrkEdit.queryXxzsBySyrklx", map);
	}

	/***
	 * 
	 * @Title: delete_xxzsnrb
	 * @Description: TODO(通用删除方法)
	 * @param @param map
	 * @param @return    设定文件
	 * @return int    返回类型
	 * @throws
	 */
	public int delete_xxzsnrb(Map<String, Object> map) {
		List<?> list = queryForList("SyrkEdit.queryxxzsnrbByxxdybm",
				map.get("url"));
		map.put("tablename", list.get(0).toString());
		if (list != null && list.size() > 0) {
			return update("SyrkEdit.updateTableByxxdybm", map);
		} else {
			return 0;
		}
	}
	/***
	 * 
	 * @Title: fjxx_query
	 * @Description: TODO(查询照片)
	 * @param @param map
	 * @param @return    设定文件
	 * @return List<ZpfjFjxxb>    返回类型
	 * @throws
	 */
	public List<ZpfjFjxxb> fjxx_query(Map<String, Object> map){
		map.put("lybm","SYRK_SYRKXXZB");
		if(map.get("lyid")!=null){
			map.put("id",map.get("lyid"));
		}
		else if(map.get("syrkid")!=null){
			map.put("id",map.get("syrkid"));
		}
		return queryForList("ZpfjFjxxb.fjxx_query", map);
	}

}
