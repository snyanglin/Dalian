package com.founder.zdrygl.base.dao;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.utils.EasyUIPage;
import com.founder.zdrygl.base.model.ZdrySgafzdryxxb;
import com.founder.zdrygl.core.inteface.ZdryGllxEntityDaoService;
import com.founder.zdrygl.core.model.Zdry;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * ****************************************************************************
 * @Package:      [com.founder.zdrygl.base.dao.ZdrySgafzdryxxbDao.java]  
 * @ClassName:    [ZdrySgafzdryxxbDao]   
 * @Description:  [涉公安访 dao]   
 * @Author:       [cong_rihong@founder.com.cn]  
 * @CreateDate:   [2015年9月28日 下午2:51:16]   
 * @UpdateUser:   [cong_rihong@founder.com.cn(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015年9月28日 下午2:51:16，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Repository
public class ZdrySgafzdryxxbDao extends BaseDaoImpl implements ZdryGllxEntityDaoService {

	@Override
	public void insert(Zdry zdry) {
		ZdrySgafzdryxxb sgaf = (ZdrySgafzdryxxb)zdry;
		super.insert("ZdrySgafzdryxxb.save", sgaf);
	}

	@Override
	public void update(Zdry zdry) {
		ZdrySgafzdryxxb sgaf = (ZdrySgafzdryxxb)zdry;
		super.insert("ZdrySgafzdryxxb.update", sgaf);
	}

	@Override
	public void delete(Zdry zdry) {
		ZdrySgafzdryxxb sgaf = (ZdrySgafzdryxxb)zdry;
		super.insert("ZdrySgafzdryxxb.delete", sgaf);
	}

	@Override
	public Zdry queryById(String entityId) {
		return (Zdry)super.queryForObject("ZdrySgafzdryxxb.queryById", entityId);
	}

	@Override
	public Zdry queryViewByMap(Map<String, Object> queryMap) {
		return (Zdry)super.queryForObject("ZdrySgafzdryxxb.queryViewByMap", queryMap);
	}
	
	public ZdrySgafzdryxxb queryMaxPc(ZdrySgafzdryxxb zdrySgafzdryxxb){
		return (ZdrySgafzdryxxb) queryForObject("ZdrySgafzdryxxb.queryMaxPc", zdrySgafzdryxxb);
	}
	
	public Integer queryCount(String gmsfhm){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("gmsfhm", gmsfhm);
		return (Integer)queryForObject("ZdrySgafzdryxxb.queryCount", map);
	}
	
	/***
	 * 
	 * @Title: queryList
	 * @Description: TODO(核实数据列表展示)
	 * @param @param entity
	 * @param @param page
	 * @param @return 设定文件
	 * @return EasyUIPage 返回类型
	 * @throws
	 */
	public EasyUIPage queryList(ZdrySgafzdryxxb entity, EasyUIPage page) {
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
		map.put("zdrySgafzdryxxb", entity);

		page.setTotal((Integer) queryForObject("ZdrySgafzdryxxb.queryListCount", map));
		page.setRows(queryForList("ZdrySgafzdryxxb.queryList", map));
		return page;
	}

}
