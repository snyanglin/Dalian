package com.founder.bzdz.dao;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.bzdz.vo.DmxxbVO;
import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.utils.ComboBox;
import com.founder.framework.utils.EasyUIPage;
/**
 * @类名: DmDao 
 * @描述: 地名管理Dao
 * @作者: zhang_guoliang@founder.com 
 * @日期: 2014-12-10 下午3:48:42 
 */
@Repository("dmDao")
public class DmDao extends BaseDaoImpl {
	/**
	 * @Title: queryDmList 
	 * @描述: 查询地名列表
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2014-12-10 下午3:50:40 
	 * @返回值: EasyUIPage    返回类型 
	 * @throws
	 */
	public EasyUIPage queryDmList(EasyUIPage page, DmxxbVO entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("begin", page.getBegin());
		map.put("end", page.getEnd());
		map.put("dmxxb", entity);
		List<?> list = queryForList("com.founder.bzdz.sqlmap.Dm.queryDmList", map);
		if(page.getBegin() == 0){
			if (list != null && list.size() > 0) {
				page.setTotal(list.size());
			} else {
				page.setTotal(0);
			}
		}else{
			if (page.getTotal() == 0) {
				if (list != null && list.size() > 0) {
					page.setTotal(list.size());
				}
			}
		}
		page.setRows(list);
		return page;
	}
	/**
	 * @Title: queryDmCount 
	 * @描述: 查询地名列表总数
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2014-12-10 下午4:04:39 
	 * @返回值: long    返回类型 
	 * @throws
	 */
	public long queryDmCount(DmxxbVO entity){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("dmxxb", entity);
		Integer count = 0;
		if((entity.getFxjdm()==null||"".equals(entity.getFxjdm()))&&(entity.getPcsdm()==null||"".equals(entity.getPcsdm()))&&(entity.getXzqhdm()==null||"".equals(entity.getXzqhdm()))){
			 count = (Integer) queryForObject("com.founder.bzdz.sqlmap.Dm.queryDmXxbCount",map);
		}else{
			 count = (Integer) queryForObject("com.founder.bzdz.sqlmap.Dm.queryDmCount",map);
		}
		return count.longValue();
	}
	/**
	 * @Title: queryDm 
	 * @描述: 获取地名信息
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2014-12-12 下午3:55:00 
	 * @返回值: DmxxbVO    返回类型 
	 * @throws
	 */
	public DmxxbVO queryDm(DmxxbVO entity){
		DmxxbVO returnValue = null;
		List<?> list = queryForList("com.founder.bzdz.sqlmap.Dm.queryDm", entity);
		if (list != null && list.size() > 0) {
			returnValue = (DmxxbVO) list.get(0);
		}
		return returnValue;
	}
	/**
	 * @Title: queryXzqh 
	 * @描述: 获取单位的行政区划
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2014-12-12 下午4:23:30 
	 * @返回值: List<DmxxbVO>    返回类型 
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	public List<DmxxbVO> queryXzqh(DmxxbVO entity) {
		List<DmxxbVO> returnList = queryForList("com.founder.bzdz.sqlmap.Dm.queryXzqh", entity);
		return returnList;
	}
	/**
	 * @Title: queryGxdw 
	 * @描述: 获取单位的管辖单位
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2014-12-12 下午4:23:33 
	 * @返回值: List<DmxxbVO>    返回类型 
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	public List<DmxxbVO> queryGxdw(DmxxbVO entity) {
		List<DmxxbVO> returnList = queryForList("com.founder.bzdz.sqlmap.Dm.queryGxdw", entity);
		return returnList;
	}
	/**
	 * @Title: queryDmPd 
	 * @描述: 判断地名是否重复
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2014-12-16 下午2:48:32 
	 * @返回值: List<DmxxbVO>    返回类型 
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	public List<DmxxbVO> queryDmPd(DmxxbVO entity) {
		List<DmxxbVO> returnList = queryForList("com.founder.bzdz.sqlmap.Dm.queryDmPd", entity);
		return returnList;
	}
	/**
	 * @Title: queryDmdm 
	 * @描述: 获取新增的地名代码
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2014-12-16 下午3:40:16 
	 * @返回值: String    返回类型 
	 * @throws
	 */
	public String queryDmdm(String xzqhdm){
		String count = (String) queryForObject("com.founder.bzdz.sqlmap.Dm.queryDmdm", xzqhdm);
		return count;
	}
	/**
	 * @Title: saveDm 
	 * @描述: 保存地名
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2014-12-16 下午5:53:27 
	 * @返回值: void    返回类型 
	 * @throws
	 */
	public void saveDm(DmxxbVO entity){
		entity.setDmpy(super.queryPy(entity.getDmmc()));
		entity.setDmwb(super.queryWb(entity.getDmmc()));
		insert("com.founder.bzdz.sqlmap.Dm.saveDm", entity);
	}
	/**
	 * @Title: saveXzqh 
	 * @描述: 保存到所属行政区划表
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2014-12-16 下午6:41:39 
	 * @返回值: void    返回类型 
	 * @throws
	 */
	public void saveXzqh(DmxxbVO entity){
		insert("com.founder.bzdz.sqlmap.Dm.saveXzqh", entity);
	}
	/**
	 * @Title: saveZzjg 
	 * @描述: 保存到所属管辖单位表
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2014-12-16 下午6:41:51 
	 * @返回值: void    返回类型 
	 * @throws
	 */
	public void saveZzjg(DmxxbVO entity){
		insert("com.founder.bzdz.sqlmap.Dm.saveZzjg", entity);
	}
	/**
	 * @Title: updateDm 
	 * @描述: 更新地名信息表
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2015-4-9 下午3:02:55 
	 * @返回值: void    返回类型 
	 * @throws
	 */
	public void updateDm(DmxxbVO entity){
		entity.setDmpy(super.queryPy(entity.getDmmc()));
		entity.setDmwb(super.queryWb(entity.getDmmc()));
		update("com.founder.bzdz.sqlmap.Dm.updateDm", entity);
	}
	/**
	 * @Title: crossouDm 
	 * @描述: 注销地名
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2014-12-17 下午7:00:50 
	 * @返回值: void    返回类型 
	 * @throws
	 */
	public void crossouDm(DmxxbVO entity){
		update("com.founder.bzdz.sqlmap.Dm.crossouDmxxb", entity);
		update("com.founder.bzdz.sqlmap.Dm.crossouDmzzjgb", entity);
		update("com.founder.bzdz.sqlmap.Dm.crossouDmxzqhb", entity);
	}
	/**
	 * @Title: queryMapLine 
	 * @描述: 查询地图图层
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2014-12-18 下午3:07:06 
	 * @返回值: List<DlstLineVO>    返回类型 
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	public List<DmxxbVO> queryMapLine(DmxxbVO entity) {
		List<DmxxbVO> list = queryForList("com.founder.bzdz.sqlmap.Dm.queryMapLine", entity);
		return list;
	}
	/**
	 * @Title: queryMldzPd 
	 * @描述: 判断门楼地址是否存在
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2014-12-18 下午5:30:41 
	 * @返回值: boolean    返回类型 
	 * @throws
	 */
	public boolean queryMldzPd(DmxxbVO entity) {
		boolean returnValue = false;
		Integer count = (Integer) queryForObject("com.founder.bzdz.sqlmap.Dm.queryMldzPd", entity);
		if (count > 0) {
			returnValue = true;
		}
		return returnValue;
	}
	/**
	 * @Title: queryDictDm 
	 * @描述: 获取地址下拉框字典
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: PCSDM 派出所代码
	 * @日期： 2015-1-7 上午11:00:36 
	 * @返回值: List<ComboBox>    返回类型 
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	public List<ComboBox> queryDictDm(String pcsdm) {
		return queryForList("com.founder.bzdz.sqlmap.Dm.queryDictDm",pcsdm);
	}
	/**
	 * @Title: queryDictSq 
	 * @描述: 获取社区下拉框字典
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: PCSDM 派出所代码
	 * @日期： 2015-1-7 下午4:03:42 
	 * @返回值: List<ComboBox>    返回类型 
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	public List<ComboBox> queryDictSq(String pcsdm) {
		return queryForList("com.founder.bzdz.sqlmap.Dm.queryDictSq",pcsdm);
	}
}