package com.founder.sydw.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.sydw.bean.DwOwnAmfwcsBean;
import com.founder.sydw.bean.DwOwnGqwbBean;
import com.founder.sydw.bean.DwOwnMbBean;
import com.founder.sydw.bean.DwOwnMbXmyjBean;
import com.founder.sydw.bean.DwOwnMqBean;
import com.founder.sydw.bean.DwOwnMqZgryBean;
import com.founder.sydw.bean.DwOwnSealBean;
import com.founder.sydw.bean.DwOwnXFBean;
import com.founder.sydw.bean.DwOwnYhBean;
import com.founder.sydw.bean.DwOwnYxyycsBean;
import com.founder.sydw.bean.DwOwnGwylcsBean;
import com.founder.sydw.bean.DwOwnZjbxBean;

/**
 * ****************************************************************************
 * 
 * @Package: [com.founder.sydw.dao.DwOwnsydwDao.java]
 * @ClassName: [DwOwnsydwDao]
 * @Description: [一句话描述该类的功能]
 * @Author: [star]
 * @CreateDate: [2015-6-5 下午3:42:53]
 * @UpdateUser: [star(如多次修改保留历史记录，增加修改记录)]
 * @UpdateDate: [2015-6-5 下午3:42:53，(如多次修改保留历史记录，增加修改记录)]
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]
 * @Version: [v1.0]
 */
@Repository("dwOwnsydwDao")
public class DwOwnsydwDao extends BaseDaoImpl {

	/**
	 * 
	 * @Title: queryOwnGwylcs
	 * @Description: 歌舞娱乐场所信息查询
	 * @param @param map
	 * @param @return 设定文件
	 * @return DwOwnGwylcsBean 返回类型
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	public DwOwnGwylcsBean queryOwnGwylcs(Map<String, Object> map) {
		return (DwOwnGwylcsBean) queryForObject("Dwownsydw.queryGwylcs", map);
	}

	/**
	 * 
	 * @Title: queryGwylcsByRyid
	 * @Description: 歌舞娱乐场所信息条件查询
	 * @param @param entity
	 * @param @return 设定文件
	 * @return DwOwnGwylcsBean 返回类型
	 * @throws
	 */
	public DwOwnGwylcsBean queryGwylcsByRyid(DwOwnGwylcsBean entity) {
		DwOwnGwylcsBean returnValue = null;
		List<?> list = queryForList("Dwownsydw.queryGwylcsByRyid", entity);
		if (list != null && list.size() > 0) {
			returnValue = (DwOwnGwylcsBean) list.get(0);
		}
		return returnValue;
	}

	/**
	 * 
	 * @Title: saveGwylcs
	 * @Description: 歌舞娱乐场所信息新增
	 * @param @param entity 设定文件
	 * @return void 返回类型
	 * @throws
	 */

	public void saveGwylcs(DwOwnGwylcsBean entity) {
		super.insert("Dwownsydw.insertGwylcs", entity);
	}

	/**
	 * 
	 * @Title: updateGwylcs
	 * @Description: 歌舞娱乐场所信息查询更新
	 * @param @param entity 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public void updateGwylcs(DwOwnGwylcsBean entity) {
		super.update("Dwownsydw.updateGwylcs", entity);
	}

	/**
	 * 
	 * @Title: queryOwnAmfwcs
	 * @Description: 按摩服务场所信息查询
	 * @param @param map
	 * @param @return 设定文件
	 * @return DwOwnAmfwcsBean 返回类型
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	public DwOwnAmfwcsBean queryOwnAmfwcs(Map<String, Object> map) {
		return (DwOwnAmfwcsBean) queryForObject("Dwownsydw.queryAmfwcs", map);
	}

	/**
	 * 
	 * @Title: queryAmfwcsByRyid
	 * @Description: 按摩服务场所信息条件查询
	 * @param @param entity
	 * @param @return 设定文件
	 * @return DwOwnAmfwcsBean 返回类型
	 * @throws
	 */
	public DwOwnAmfwcsBean queryAmfwcsByRyid(DwOwnAmfwcsBean entity) {
		DwOwnAmfwcsBean returnValue = null;
		List<?> list = queryForList("Dwownsydw.queryAmfwcsByRyid", entity);
		if (list != null && list.size() > 0) {
			returnValue = (DwOwnAmfwcsBean) list.get(0);
		}
		return returnValue;
	}

	/**
	 * 
	 * @Title: saveAmfwcs
	 * @Description: 按摩服务场所信息新增
	 * @param @param entity 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public void saveAmfwcs(DwOwnAmfwcsBean entity) {
		super.insert("Dwownsydw.insertAmfwcs", entity);
	}

	/**
	 * 
	 * @Title: updateAmfwcs
	 * @Description: 按摩服务场所信息更新
	 * @param @param entity 设定文件
	 * @return void 返回类型
	 * @throws
	 */

	public void updateAmfwcs(DwOwnAmfwcsBean entity) {
		super.update("Dwownsydw.updateAmfwcs", entity);
	}

	/**
	 * 
	 * @Title: queryOwnYxyycs
	 * @Description: T游戏游艺场所的行业特有信息查询
	 * @param @param map
	 * @param @return 设定文件
	 * @return DwOwnYxyycsBean 返回类型
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	public DwOwnYxyycsBean queryOwnYxyycs(Map<String, Object> map) {
		return (DwOwnYxyycsBean) queryForObject("Dwownsydw.queryYxyycs", map);
	}

	/**
	 * 
	 * @Title: queryYxyycsByRyid
	 * @Description: 游戏游艺场所的行业特有信息条件查询
	 * @param @param entity
	 * @param @return 设定文件
	 * @return DwOwnYxyycsBean 返回类型
	 * @throws
	 */
	public DwOwnYxyycsBean queryYxyycsByRyid(DwOwnYxyycsBean entity) {
		DwOwnYxyycsBean returnValue = null;
		List<?> list = queryForList("Dwownsydw.queryYxyycsByRyid", entity);
		if (list != null && list.size() > 0) {
			returnValue = (DwOwnYxyycsBean) list.get(0);
		}
		return returnValue;
	}

	/**
	 * 
	 * @Title: saveYxyycs
	 * @Description:游戏游艺场所的行业特有信息新增
	 * @param @param entity 设定文件
	 * @return void 返回类型
	 * @throws
	 */

	public void saveYxyycs(DwOwnYxyycsBean entity) {
		super.insert("Dwownsydw.insertYxyycs", entity);
	}

	/**
	 * 
	 * @Title: updateYxyycs
	 * @Description:游戏游艺场所的行业特有信息更新
	 * @param @param entity 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public void updateYxyycs(DwOwnYxyycsBean entity) {
		super.update("Dwownsydw.updateYxyycs", entity);
	}

	/**
	 * 
	 * @Title: queryOwnSeal
	 * @Description: 印章信息查询
	 * @param @param map
	 * @param @return 设定文件
	 * @return DwOwnSealBean 返回类型
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	public DwOwnSealBean queryOwnSeal(Map<String, Object> map) {
		return (DwOwnSealBean) queryForObject("Dwownsydw.querySeal", map);
	}

	/**
	 * 
	 * @Title: queryYzByRyid
	 * @Description: 印章信息条件查询
	 * @param @param entity
	 * @param @return 设定文件
	 * @return DwOwnSealBean 返回类型
	 * @throws
	 */
	public DwOwnSealBean queryYzByRyid(DwOwnSealBean entity) {
		DwOwnSealBean returnValue = null;
		List<?> list = queryForList("Dwownsydw.querySealByRyid", entity);
		if (list != null && list.size() > 0) {
			returnValue = (DwOwnSealBean) list.get(0);
		}
		return returnValue;
	}

	/**
	 * 
	 * @Title: saveYz
	 * @Description:印章信息新增
	 * @param @param entity 设定文件
	 * @return void 返回类型
	 * @throws
	 */

	public void saveYz(DwOwnSealBean entity) {
		super.insert("Dwownsydw.insertSeal", entity);
	}

	/**
	 * 
	 * @Title: updateYz
	 * @Description: 印章信息更新
	 * @param @param entity 设定文件
	 * @return void 返回类型
	 * @throws
	 */

	public void updateYz(DwOwnSealBean entity) {
		super.update("Dwownsydw.updateSeal", entity);
	}

	/**
	 * 
	 * @Title: queryOwnMb
	 * @Description: 民爆单位基本信息查询
	 * @param @param map
	 * @param @return 设定文件
	 * @return DwOwnMbBean 返回类型
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	public DwOwnMbBean queryOwnMb(Map<String, Object> map) {
		return (DwOwnMbBean) queryForObject("Dwownsydw.queryMb", map);
	}

	/**
	 * @Title: queryMbByRyid
	 * @Description: 民爆单位基本信息条件查询
	 * @param @param entity
	 * @param @return 设定文件
	 * @return DwOwnMbBean 返回类型
	 * @throws
	 */
	public DwOwnMbBean queryMbByRyid(DwOwnMbBean entity) {
		DwOwnMbBean returnValue = null;
		List<?> list = queryForList("Dwownsydw.queryMbByRyid", entity);
		if (list != null && list.size() > 0) {
			returnValue = (DwOwnMbBean) list.get(0);
		}
		return returnValue;
	}

	/**
	 * @Title: saveMb
	 * @Description: 民爆单位基本信息新增
	 * @param @param entity 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public void saveMb(DwOwnMbBean entity) {
		super.insert("Dwownsydw.insertMb", entity);
	}

	/**
	 * @Title: updateMb
	 * @Description: 民爆单位基本信息更新
	 * @param @param entity 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public void updateMb(DwOwnMbBean entity) {
		super.update("Dwownsydw.updateMb", entity);
	}

	/**
	 * 
	 * @Title: mbsgxm_query_new
	 * @Description: 民爆项目基本信息查询10条
	 * @param @param dwid
	 * @param @return 设定文件
	 * @return List<DwOwnMbXmyjBean> 返回类型
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	public List<DwOwnMbXmyjBean> mbsgxm_query_new(String dwid) {
		List<DwOwnMbXmyjBean> list = queryForList("Dwownsydw.mbsgxm_query_new",
				dwid);
		return list;
	}

	/**
	 * 
	 * @Title: mbsgxm_query_all
	 * @Description:民爆项目基本信息分页查询
	 * @param @param page
	 * @param @param condition
	 * @param @param dwid
	 * @param @return 设定文件
	 * @return EasyUIPage 返回类型
	 * @throws
	 */
	public EasyUIPage mbsgxm_query_all(EasyUIPage page, String condition,
			String dwid) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("begin", page.getBegin());
		map.put("end", page.getEnd());
		String sort = page.getSort();
		String order = page.getOrder();
		if (StringUtils.isBlank(sort)) { // 默认排序
			order = "asc";
		}
		map.put("sort", sort);
		map.put("order", order);
		if (!StringUtils.isBlank(condition)) {
			map.put("condition", condition);
		}
		map.put("dwid", dwid);
		List<?> list = queryForList("Dwownsydw.mbsgxm_query_all", map);
		page.setTotal((int) mbsgxm_query_all_count(condition, dwid));
		page.setRows(list);
		return page;
	}

	/**
	 * 
	 * @Title: mbsgxm_query_all_count
	 * @Description: 民爆项目基本信息统计数目
	 * @param @param condition
	 * @param @param dwid
	 * @param @return 设定文件
	 * @return long 返回类型
	 * @throws
	 */

	public long mbsgxm_query_all_count(String condition, String dwid) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (!StringUtils.isBlank(condition)) {
			map.put("condition", condition);
		}
		map.put("dwid", dwid);
		return (Integer) queryForObject("Dwownsydw.mbsgxm_query_all_count", map);
	}

	/**
	 * 
	 * @Title: queryMbXmyjByRyid
	 * @Description: 民爆项目基本信息条件查询
	 * @param @param entity
	 * @param @return 设定文件
	 * @return DwOwnMbXmyjBean 返回类型
	 * @throws
	 */

	public DwOwnMbXmyjBean queryMbXmyjByRyid(DwOwnMbXmyjBean entity) {
		DwOwnMbXmyjBean returnValue = null;
		List<?> list = queryForList("Dwownsydw.queryMbXmyjByRyid", entity);
		if (list != null && list.size() > 0) {
			returnValue = (DwOwnMbXmyjBean) list.get(0);
		}
		return returnValue;
	}

	public void saveMbXmyj(DwOwnMbXmyjBean entity) {
		super.insert("Dwownsydw.insertMbXmyj", entity);
	}

	public void updateMbXmyj(DwOwnMbXmyjBean entity) {
		super.update("Dwownsydw.updateMbXmyj", entity);
	}

	public void deleteMbxmyj(DwOwnMbXmyjBean entity) {
		update("Dwownsydw.deleteMbxmyj", entity);
	}

	/**
	 * @Title: queryOwnMq
	 * @Description: 民枪配置单位信息查询
	 * @param @param map
	 * @param @return 设定文件
	 * @return DwOwnMqBean 返回类型
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	public DwOwnMqBean queryOwnMq(Map<String, Object> map) {
		return (DwOwnMqBean) queryForObject("Dwownsydw.queryMq", map);
	}

	/**
	 * @Title: queryMqByRyid
	 * @Description: 民枪配置单位信息条件查询
	 * @param @param entity
	 * @param @return 设定文件
	 * @return DwOwnMqBean 返回类型
	 * @throws
	 */

	public DwOwnMqBean queryMqByRyid(DwOwnMqBean entity) {
		DwOwnMqBean returnValue = null;
		List<?> list = queryForList("Dwownsydw.queryMqByRyid", entity);
		if (list != null && list.size() > 0) {
			returnValue = (DwOwnMqBean) list.get(0);
		}
		return returnValue;
	}

	/**
	 * @Title: saveMq
	 * @Description: 民枪配置单位信息新增
	 * @param @param entity 设定文件
	 * @return void 返回类型
	 * @throws
	 */

	public void saveMq(DwOwnMqBean entity) {
		super.insert("Dwownsydw.insertMq", entity);
	}

	/**
	 * 
	 * @Title: updateMq
	 * @Description:民枪配置单位信息更新
	 * @param @param entity 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public void updateMq(DwOwnMqBean entity) {
		super.update("Dwownsydw.updateMq", entity);
	}

	/**
	 * @Title: mqzgry_query_new
	 * @Description:民枪专管人员10条查询
	 * @param @param dwid
	 * @param @return 设定文件
	 * @return List<DwOwnMqZgryBean> 返回类型
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	public List<DwOwnMqZgryBean> mqzgry_query_new(String dwid) {
		List<DwOwnMqZgryBean> list = queryForList("Dwownsydw.mqzgry_query_new",
				dwid);
		return list;
	}

	/**
	 * @Title: mqzgry_query_all
	 * @Description: 民枪专管人员分页查询
	 * @param @param page
	 * @param @param condition
	 * @param @param dwid
	 * @param @return 设定文件
	 * @return EasyUIPage 返回类型
	 * @throws
	 */
	public EasyUIPage mqzgry_query_all(EasyUIPage page, String condition,
			String dwid) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("begin", page.getBegin());
		map.put("end", page.getEnd());
		String sort = page.getSort();
		String order = page.getOrder();
		if (StringUtils.isBlank(sort)) { // 默认排序
			order = "asc";
		}
		map.put("sort", sort);
		map.put("order", order);
		if (!StringUtils.isBlank(condition)) {
			map.put("condition", condition);
		}
		map.put("dwid", dwid);
		List<?> list = queryForList("Dwownsydw.mqzgry_query_all", map);
		page.setTotal((int) mqzgry_query_all_count(condition, dwid));
		page.setRows(list);
		return page;
	}

	/**
	 * @Title: mqzgry_query_all_count
	 * @Description: 民枪专管人员统计数目
	 * @param @param condition
	 * @param @param dwid
	 * @param @return 设定文件
	 * @return long 返回类型
	 * @throws
	 */
	public long mqzgry_query_all_count(String condition, String dwid) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (!StringUtils.isBlank(condition)) {
			map.put("condition", condition);
		}
		map.put("dwid", dwid);
		return (Integer) queryForObject("Dwownsydw.mqzgry_query_all_count", map);
	}

	/**
	 * @Title: queryMqzgryByRyid
	 * @Description: 民枪专管人员单挑查询
	 * @param @param entity
	 * @param @return 设定文件
	 * @return DwOwnMqZgryBean 返回类型
	 * @throws
	 */
	public DwOwnMqZgryBean queryMqzgryByRyid(DwOwnMqZgryBean entity) {
		DwOwnMqZgryBean returnValue = null;
		List<?> list = queryForList("Dwownsydw.queryMqzgryByRyid", entity);
		if (list != null && list.size() > 0) {
			returnValue = (DwOwnMqZgryBean) list.get(0);
		}
		return returnValue;
	}

	/**
	 * 
	 * @Title: saveMqzgry
	 * @Description: 民枪专管人员新增
	 * @param @param entity 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public void saveMqzgry(DwOwnMqZgryBean entity) {
		super.insert("Dwownsydw.insertMqzgry", entity);
	}

	/**
	 * 
	 * @Title: updateMqzgry
	 * @Description:民枪专管人员更新
	 * @param @param entity 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public void updateMqzgry(DwOwnMqZgryBean entity) {
		super.update("Dwownsydw.updateMqzgry", entity);
	}

	/**
	 * 
	 * @Title: deleteMqzgry
	 * @Description: 民枪专管人员删除
	 * @param @param entity 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public void deleteMqzgry(DwOwnMqZgryBean entity) {
		update("Dwownsydw.deleteMqzgry", entity);
	}

	/**
	 * 
	 * @Title: queryOwnYh
	 * @Description: 烟花配置单位信息查询
	 * @param @param map
	 * @param @return 设定文件
	 * @return DwOwnYhBean 返回类型
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	public DwOwnYhBean queryOwnYh(Map<String, Object> map) {
		return (DwOwnYhBean) queryForObject("Dwownsydw.queryYh", map);
	}

	/**
	 * 
	 * @Title: queryYhByRyid
	 * @Description: 烟花配置单位信息条件查询
	 * @param @param entity
	 * @param @return 设定文件
	 * @return DwOwnYhBean 返回类型
	 * @throws
	 */

	public DwOwnYhBean queryYhByRyid(DwOwnYhBean entity) {
		DwOwnYhBean returnValue = null;
		List<?> list = queryForList("Dwownsydw.queryYhByRyid", entity);
		if (list != null && list.size() > 0) {
			returnValue = (DwOwnYhBean) list.get(0);
		}
		return returnValue;
	}

	/**
	 * 
	 * @Title: saveYh
	 * @Description:烟花配置单位信息新增
	 * @param @param entity 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public void saveYh(DwOwnYhBean entity) {
		super.insert("Dwownsydw.insertYh", entity);
	}

	/**
	 * 
	 * @Title: updateYh
	 * @Description: 烟花配置单位信息更新
	 * @param @param entity 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public void updateYh(DwOwnYhBean entity) {
		super.update("Dwownsydw.updateYh", entity);
	}

	/**
	 * @Title: zzyh_query_all
	 * @Description: 自助银行分页
	 * @param @param page
	 * @param @param condition
	 * @param @param dwid
	 * @param @return 设定文件
	 * @return EasyUIPage 返回类型
	 * @throws
	 */
	public EasyUIPage zzyh_query_all(EasyUIPage page, String condition,String dwid) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("begin", page.getBegin());
		map.put("end", page.getEnd());
		String sort = page.getSort();
		String order = page.getOrder();
		if (StringUtils.isBlank(sort)) { // 默认排序
			order = "asc";
		}
		map.put("sort", sort);
		map.put("order", order);
		if (!StringUtils.isBlank(condition)) {
			map.put("condition", condition);
		}
		map.put("dwid", dwid);
		List<?> list = queryForList("Dwownsydw.zzyh_query_all", map);
		page.setTotal((int) zzyh_query_all_count(condition, dwid));
		page.setRows(list);
		return page;
	}

	/**
	 * 
	 * @Title: zzyh_query_all_count
	 * @Description: 自助银行统计数
	 * @param @param condition
	 * @param @param dwid
	 * @param @return 设定文件
	 * @return long 返回类型
	 * @throws
	 */
	public long zzyh_query_all_count(String condition, String dwid) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (!StringUtils.isBlank(condition)) {
			map.put("condition", condition);
		}
		map.put("dwid", dwid);
		return (Integer) queryForObject("Dwownsydw.zzyh_query_all_count", map);
	}

	/**
	 * @Title: xc_query_all
	 * @Description: 校车分页查询
	 * @param @param page
	 * @param @param condition
	 * @param @param xyid
	 * @param @return 设定文件
	 * @return EasyUIPage 返回类型
	 * @throws
	 */
	public EasyUIPage xc_query_all(EasyUIPage page, String condition,String xyid) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("begin", page.getBegin());
		map.put("end", page.getEnd());
		String sort = page.getSort();
		String order = page.getOrder();
		if (StringUtils.isBlank(sort)) { // 默认排序
			order = "asc";
		}
		map.put("sort", sort);
		map.put("order", order);
		if (!StringUtils.isBlank(condition)) {
			map.put("condition", condition);
		}
		map.put("xyid", xyid);
		List<?> list = queryForList("Dwownsydw.xc_query_all", map);
		page.setTotal((int) xc_query_all_count(condition, xyid));
		page.setRows(list);
		return page;
	}

	/**
	 * 
	 * @Title: xc_query_all_count
	 * @Description: 校车统计数
	 * @param @param condition
	 * @param @param xyid
	 * @param @return 设定文件
	 * @return long 返回类型
	 * @throws
	 */
	public long xc_query_all_count(String condition, String xyid) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (!StringUtils.isBlank(condition)) {
			map.put("condition", condition);
		}
		map.put("xyid", xyid);
		return (Integer) queryForObject("Dwownsydw.xc_query_all_count", map);
	}

	/**
	 * 
	 * @Title: hxd_query_all
	 * @Description: 护校队分页查询
	 * @param @param page
	 * @param @param condition
	 * @param @param xyid
	 * @param @return 设定文件
	 * @return EasyUIPage 返回类型
	 * @throws
	 */
	public EasyUIPage hxd_query_all(EasyUIPage page, String condition,
			String xyid) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("begin", page.getBegin());
		map.put("end", page.getEnd());
		String sort = page.getSort();
		String order = page.getOrder();
		if (StringUtils.isBlank(sort)) { // 默认排序
			order = "asc";
		}
		map.put("sort", sort);
		map.put("order", order);
		if (!StringUtils.isBlank(condition)) {
			map.put("condition", condition);
		}
		map.put("xyid", xyid);
		List<?> list = queryForList("Dwownsydw.hxd_query_all", map);
		page.setTotal((int) hxd_query_all_count(condition, xyid));
		page.setRows(list);
		return page;
	}

	/**
	 * @Title: hxd_query_all_count
	 * @Description: 护校队统计
	 * @param @param condition
	 * @param @param xyid
	 * @param @return 设定文件
	 * @return long 返回类型
	 * @throws
	 */
	public long hxd_query_all_count(String condition, String xyid) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (!StringUtils.isBlank(condition)) {
			map.put("condition", condition);
		}
		map.put("xyid", xyid);
		return (Integer) queryForObject("Dwownsydw.hxd_query_all_count", map);
	}

	/**
	 * 
	 * @Title: queryOwnZjbx
	 * @Description: 单位_证券/保险业信息查询
	 * @param @param map
	 * @param @return 设定文件
	 * @return DwOwnZjbxBean 返回类型
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	public DwOwnZjbxBean queryOwnZjbx(Map<String, Object> map) {
		return (DwOwnZjbxBean) queryForObject("Dwownsydw.queryZjbx", map);
	}

	/**
	 * @Title: queryZjbxyByRyid
	 * @Description: 单位_证券/保险业信息条件查询
	 * @param @param entity
	 * @param @return 设定文件
	 * @return DwOwnZjbxBean 返回类型
	 * @throws
	 */
	public DwOwnZjbxBean queryZjbxyByRyid(DwOwnZjbxBean entity) {
		DwOwnZjbxBean returnValue = null;
		List<?> list = queryForList("Dwownsydw.queryZjbxyByRyid", entity);
		if (list != null && list.size() > 0) {
			returnValue = (DwOwnZjbxBean) list.get(0);
		}
		return returnValue;
	}

	/**
	 * 
	 * @Title: saveZjbxy
	 * @Description: 单位_证券/保险业信息新增
	 * @param @param entity 设定文件
	 * @return void 返回类型
	 * @throws
	 */

	public void saveZjbxy(DwOwnZjbxBean entity) {
		super.insert("Dwownsydw.insertZjbxy", entity);
	}

	/**
	 * 
	 * @Title: updateZjbxy
	 * @Description:单位_证券/保险业信息更新
	 * @param @param entity 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public void updateZjbxy(DwOwnZjbxBean entity) {
		super.update("Dwownsydw.updateZjbxy", entity);
	}

	/**
	 * 
	 * @Title: queryOwnGqwb
	 * @Description: 单位_工企/文保单位信息查询
	 * @param @param map
	 * @param @return    设定文件
	 * @return DwOwnGqwbBean    返回类型
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	public DwOwnGqwbBean queryOwnGqwb(Map<String, Object> map) {
		return (DwOwnGqwbBean) queryForObject("Dwownsydw.queryGqwb", map);
	}

	/**
	 * @Title: queryGqwbByRyid
	 * @Description: 单位_工企/文保单位信息条件查询
	 * @param @param entity
	 * @param @return 设定文件
	 * @return DwOwnGqwbBean 返回类型
	 * @throws
	 */
	public DwOwnGqwbBean queryGqwbByRyid(DwOwnGqwbBean entity) {
		DwOwnGqwbBean returnValue = null;
		List<?> list = queryForList("Dwownsydw.queryGqwbByRyid", entity);
		if (list != null && list.size() > 0) {
			returnValue = (DwOwnGqwbBean) list.get(0);
		}
		return returnValue;
	}

	/**
	 * 
	 * @Title: saveGqwb
	 * @Description:单位_工企/文保单位信息新增
	 * @param @param entity 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public void saveGqwb(DwOwnGqwbBean entity) {
		super.insert("Dwownsydw.insertGqwb", entity);
	}

	/**
	 * @Title: updateGqwb
	 * @Description: 单位_工企/文保单位信息更新
	 * @param @param entity 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public void updateGqwb(DwOwnGqwbBean entity) {
		super.update("Dwownsydw.updateGqwb", entity);
	}


	/**
	 * @Title: queryOwnXf
	 * @Description:单位_消防查询
	 * @param @param map
	 * @param @return 设定文件
	 * @return DwOwnXFBean 返回类型
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	public DwOwnXFBean queryOwnXf(Map<String, Object> map) {
		return (DwOwnXFBean) queryForObject("Dwownsydw.queryXf", map);
	}

	/**
	 * 
	 * @Title: queryXfByRyid
	 * @Description: 单位_消防条件查询
	 * @param @param entity
	 * @param @return 设定文件
	 * @return DwOwnXFBean 返回类型
	 * @throws
	 */
	public DwOwnXFBean queryXfByRyid(DwOwnXFBean entity) {
		DwOwnXFBean returnValue = null;
		List<?> list = queryForList("Dwownsydw.queryXfByRyid", entity);
		if (list != null && list.size() > 0) {
			returnValue = (DwOwnXFBean) list.get(0);
		}
		return returnValue;
	}

	/**
	 * 
	 * @Title: saveXf
	 * @Description: 单位_消防新增
	 * @param @param entity 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public void saveXf(DwOwnXFBean entity) {
		super.insert("Dwownsydw.insertXf", entity);
	}

	/**
	 * 
	 * @Title: updateXf
	 * @Description:单位_消防更新
	 * @param @param entity 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public void updateXf(DwOwnXFBean entity) {
		super.update("Dwownsydw.updateXf", entity);
	}
}
