package com.founder.zdrygl.base.dao;



import org.springframework.stereotype.Repository;
import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.zdrygl.base.vo.ZdryZdryhsbVO;
import com.founder.zdrygl.base.model.ZdryZdryhsb;

import java.util.HashMap;
import java.util.Map;

/***
 * ****************************************************************************
 *
 * @Package: [com.founder.zdrygl.bean]
 * @ClassName: ZdryZdryhsb
 * @Description: [一句话描述该类的功能]
 * @Author: [zhoulijun@founder.com.cn]
 * @CreateDate:  2015-12-15 04:46:24
 * @UpdateUser: [Administrator(如多次修改保留历史记录，增加修改记录)]
 * @UpdateDate: [ 2015-12-15 04:46:24，(如多次修改保留历史记录，增加修改记录)]
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]
 * @Version: [v1.0]
 */


@Repository
public class ZdryZdryhsbDao extends BaseDaoImpl{

	public void save(ZdryZdryhsb entity){
		insert("ZdryZdryhsb.insert", entity);
	}

	public void update(ZdryZdryhsb entity){
		update("ZdryZdryhsb.update", entity);
	}

	public void delete(ZdryZdryhsb entity){
		update("ZdryZdryhsb.delete", entity);
	}

	public ZdryZdryhsb queryById(String id){
		return (ZdryZdryhsb) queryForObject("ZdryZdryhsb.queryById", id);
	}

    public EasyUIPage queryList(EasyUIPage page, ZdryZdryhsbVO entity){
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
		map.put("zdryZdryhsbVO", entity);

		page.setTotal((Integer) queryForObject("ZdryZdryhsb.queryCount", map));
		page.setRows(queryForList("ZdryZdryhsb.query", map));
		return page;
	}
	

}
