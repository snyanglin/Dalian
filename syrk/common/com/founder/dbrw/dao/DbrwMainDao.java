package com.founder.dbrw.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.stereotype.Repository;

import com.founder.dbrw.bean.DbrwDbrwb;
import com.founder.dbrw.bean.DbrwDbrwsjmxb;
import com.founder.dbrw.bean.DbrwDdbrwb;
import com.founder.dbrw.bean.DbrwDdbrwsjmxb;
import com.founder.dbrw.bean.DbrwJctj;
import com.founder.dbrw.vo.DbrwMainVo;
import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;

@Repository("dbrwMainDao")
public class DbrwMainDao extends BaseDaoImpl {

	/**
	 * 
	 * @Title: queryDdbrwb
	 * @Description: TODO(根据督办模型id查询待督办任务表 )
	 * @param @param dbmxid
	 * @param @return 设定文件
	 * @return List<DbrwDdbrwb> 返回类型
	 * @throws
	 */
	public EasyUIPage queryDdbrwsjmxb(EasyUIPage page, DbrwDdbrwb entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("begin", page.getBegin());
		map.put("end", page.getEnd());
		String sort = page.getSort();
		String order = page.getOrder();
		if (StringUtils.isBlank(sort)) { // 默认排序
			sort = "b.XT_CJSJ";
			order = "asc";
		}
		map.put("sort", sort);
		map.put("order", order);
		map.put("entity", entity);
		page.setTotal((Integer) queryForObject(
				"DbrwMain.queryDbrwDdbrwsjmxbCount", map));
		page.setRows(queryForList("DbrwMain.queryDbrwDdbrwsjmxbList", map));
		return page;
	}

	public int queryDdbrwsjmxbCount(HashMap map) {
		return (Integer) queryForObject("DbrwMain.queryDbrwDdbrwsjmxbCount",
				map);
	}

	public List<DbrwMainVo> queryGwryList(HashMap map) {
		return queryForList("DbrwMain.queryGwryList", map);
	}

	public List<DbrwMainVo> queryZdryList(HashMap map) {
		return queryForList("DbrwMain.queryZdryList", map);
	}

	/**
	 * 查询督办中和完成督办数据 总数
	 * 
	 * @Title: queryDbGwryList
	 * @author wu_chunhui@founder.com.cn
	 * @Description: 查询督办中和完成督办数据
	 * @param @param map（map中无sfwcdm时自动查询督办中任务，sfwcdm为1时查询督办完成任务）
	 * @param @return 设定文件
	 * @return List<DbrwMainVo> 返回类型
	 * @throws
	 */
	public int queryDbrwsjmxbCount(HashMap map) {
		return (Integer) queryForObject("DbrwMain.queryDbrwDbrwsjmxbCount", map);
	}

	/**
	 * 查询督办中和完成督办数据 详细信息展现页面
	 * 
	 * @Title: queryDbGwryList
	 * @author wu_chunhui@founder.com.cn
	 * @Description: 查询督办中和完成督办数据
	 * @param @param map（map中无sfwcdm时自动查询督办中任务，sfwcdm为1时查询督办完成任务）
	 * @param @return 设定文件
	 * @return List<DbrwMainVo> 返回类型
	 * @throws
	 */
	public EasyUIPage queryDbrwsjmxb(EasyUIPage page, DbrwDbrwb entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("begin", page.getBegin());
		map.put("end", page.getEnd());
		String sort = page.getSort();
		String order = page.getOrder();
		if (StringUtils.isBlank(sort)) { // 默认排序
			sort = "b.XT_CJSJ";
			order = "asc";
		}
		map.put("sort", sort);
		map.put("order", order);
		map.put("entity", entity);
		page.setTotal((Integer) queryForObject(
				"DbrwMain.queryDbrwDbrwsjmxbCount", map));

		List<DbrwDbrwsjmxb> listForDDB = queryForList(
				"DbrwMain.queryDbrwDbrwsjmxbList", map);
		List<DbrwDdbrwsjmxb> listForDB = new ArrayList<DbrwDdbrwsjmxb>();

		for (DbrwDbrwsjmxb dbrwDbrwsjmxb : listForDDB) {
			DbrwDdbrwsjmxb dbrwDdbrwsjmxb = new DbrwDdbrwsjmxb();
			dbrwDdbrwsjmxb.setDdbsjx1(dbrwDbrwsjmxb.getDbsjx1());
			dbrwDdbrwsjmxb.setDdbsjx2(dbrwDbrwsjmxb.getDbsjx2());
			dbrwDdbrwsjmxb.setDdbsjx3(dbrwDbrwsjmxb.getDbsjx3());
			dbrwDdbrwsjmxb.setDdbsjx4(dbrwDbrwsjmxb.getDbsjx4());
			dbrwDdbrwsjmxb.setDdbsjx5(dbrwDbrwsjmxb.getDbsjx5());
			dbrwDdbrwsjmxb.setDdbsjx6(dbrwDbrwsjmxb.getDbsjx6());
			dbrwDdbrwsjmxb.setDdbsjx7(dbrwDbrwsjmxb.getDbsjx7());
			dbrwDdbrwsjmxb.setDdbsjx8(dbrwDbrwsjmxb.getDbsjx8());
			dbrwDdbrwsjmxb.setDdbsjx9(dbrwDbrwsjmxb.getDbsjx9());
			dbrwDdbrwsjmxb.setDdbsjx10(dbrwDbrwsjmxb.getDbsjx10());
			dbrwDdbrwsjmxb.setDdbrwid(dbrwDbrwsjmxb.getDbrwid());
			dbrwDdbrwsjmxb.setDdbsjid(dbrwDbrwsjmxb.getDbsjid());
			dbrwDdbrwsjmxb.setSszrqmc(dbrwDbrwsjmxb.getSszrqmc());
			dbrwDdbrwsjmxb.setDbfknr(dbrwDbrwsjmxb.getDbfknr());
			dbrwDdbrwsjmxb.setDataurl(dbrwDbrwsjmxb.getDataurl());
			listForDB.add(dbrwDdbrwsjmxb);
		}
		page.setRows(listForDB);
		return page;
	}

	/**
	 * 查询督办中和完成督办数据-高危人员
	 * 
	 * @Title: queryDbGwryList
	 * @author wu_chunhui@founder.com.cn
	 * @Description: 查询督办中和完成督办数据
	 * @param @param map（map中无sfwcdm时自动查询督办中任务，sfwcdm为1时查询督办完成任务）
	 * @param @return 设定文件
	 * @return List<DbrwMainVo> 返回类型
	 * @throws
	 */
	public List<DbrwMainVo> queryDbGwryList(HashMap map) {
		return queryForList("DbrwMain.queryDbGwryList", map);
	}

	/**
	 * 查询督办中和完成督办数据-重点人口
	 * 
	 * @Title: queryDbGwryList
	 * @author wu_chunhui@founder.com.cn
	 * @Description: 查询督办中和完成督办数据
	 * @param @param map（map中无sfwcdm时自动查询督办中任务，sfwcdm为1时查询督办完成任务）
	 * @param @return 设定文件
	 * @return List<DbrwMainVo> 返回类型
	 * @throws
	 */
	public List<DbrwMainVo> queryDbZdryList(HashMap map) {
		return queryForList("DbrwMain.queryDbZdryList", map);
	}

	/**
	 * 查询督办中和完成督办数据 -实有房屋
	 * 
	 * @Title: queryDbGwryList
	 * @author wu_chunhui@founder.com.cn
	 * @Description: 查询督办中和完成督办数据
	 * @param @param map（map中无sfwcdm时自动查询督办中任务，sfwcdm为1时查询督办完成任务）
	 * @param @return 设定文件
	 * @return List<DbrwMainVo> 返回类型
	 * @throws
	 */
	public DbrwMainVo getDbSyfwMax(HashMap map) {
		DbrwMainVo returnValue = null;
		List<?> list = queryForList("DbrwMain.getDbSyfwMax", map);
		if (list != null && list.size() > 0) {
			returnValue = (DbrwMainVo) list.get(0);
		}
		return returnValue;
	}

	/**
	 * 查询督办中和完成督办数据 -实有人口
	 * 
	 * @Title: queryDbGwryList
	 * @author wu_chunhui@founder.com.cn
	 * @Description: 查询督办中和完成督办数据
	 * @param @param map（map中无sfwcdm时自动查询督办中任务，sfwcdm为1时查询督办完成任务）
	 * @param @return 设定文件
	 * @return List<DbrwMainVo> 返回类型
	 * @throws
	 */
	public DbrwMainVo getDbSydwMax(HashMap map) {
		DbrwMainVo returnValue = null;
		List<?> list = queryForList("DbrwMain.getDbSydwMax", map);
		if (list != null && list.size() > 0) {
			returnValue = (DbrwMainVo) list.get(0);
		}
		return returnValue;
	}

	public EasyUIPage queryDbrwList(EasyUIPage page, String dbrwfqpcsdm) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("begin", page.getBegin());
		map.put("end", page.getEnd());
		map.put("dbrwfqpcsdm", dbrwfqpcsdm);
		page.setTotal((Integer) queryForObject("DbrwMain.queryDbrwListCount",
				map));
		page.setRows(queryForList("DbrwMain.queryDbrwList", map));
		return page;
	}

	public List<DbrwDdbrwb> queryDdbrwbList(HashMap map) {
		return queryForList("DbrwMain.queryDdbrwbList", map);
	}

	public DbrwMainVo getSyfwMax(String dbrwfqpcsdm) {
		DbrwMainVo returnValue = null;
		List<?> list = queryForList("DbrwMain.getSyfwMax", dbrwfqpcsdm);
		if (list != null && list.size() > 0) {
			returnValue = (DbrwMainVo) list.get(0);
		}
		return returnValue;
	}

	public DbrwMainVo getSydwMax(String dbrwfqpcsdm) {
		DbrwMainVo returnValue = null;
		List<?> list = queryForList("DbrwMain.getSydwMax", dbrwfqpcsdm);
		if (list != null && list.size() > 0) {
			returnValue = (DbrwMainVo) list.get(0);
		}
		return returnValue;
	}

	public String queryShowType(Map<String, String> map) {
		int count = (Integer) queryForObject("DbrwMain.queryWdbrwCount", map);
		if (count == 0) {
			count = (Integer) queryForObject("DbrwMain.queryDbzrwCount", map);
			if (count == 0) {
				count = (Integer) queryForObject("DbrwMain.queryYdbrwCount",
						map);
				if (count == 0) {
					return "wdb";
				} else {
					return "ydb";
				}
			} else {
				return "dbz";
			}
		} else {
			return "wdb";
		}
	}

	public EasyUIPage queryJctjList(EasyUIPage page, String dbrwfqpcsdm) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("begin", page.getBegin());
		map.put("end", page.getEnd());
		map.put("pcsdm", dbrwfqpcsdm.subSequence(0, 8));
		page.setTotal((Integer) queryForObject(
				"DbrwMain.queryJctjListCount", map));
		page.setRows( queryForList("DbrwMain.queryJctjList", map));

		return page;
	}

}
