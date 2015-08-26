package com.founder.bzdz.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.bzdz.bean.DzContextCombo;
import com.founder.bzdz.bean.DzContextCondition;
import com.founder.bzdz.vo.BzdzxxbVO;
import com.founder.bzdz.vo.DzBuildingVO;
import com.founder.bzdz.vo.DzTjVO;
import com.founder.bzdz.vo.DzXxbVO;
import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.config.SystemConfig;
import com.founder.framework.utils.ContextSearchUtils;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.framework.utils.UUID;

/**
 * @类名: DzDao
 * @描述: 地址管理Dao
 * @作者: zhang_guoliang@founder.com
 * @日期: 2014-12-19 下午3:27:30
 */
@Repository("dzDao")
public class DzDao extends BaseDaoImpl {
	/**
	 * @Title: queryDzList
	 * @描述: 查询地址列表
	 * @作者: zhang_guoliang@founder.com
	 * @参数: 传入参数定义
	 * @日期： 2014-12-25 下午2:49:40
	 * @返回值: EasyUIPage 返回类型
	 * @throws
	 */
	public EasyUIPage queryDzList(EasyUIPage page, BzdzxxbVO entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("begin", page.getBegin());
		map.put("end", page.getEnd());
		String order = page.getOrder();
		if ("".equals(page.getOrder()) || page.getOrder() == null) {
			order = "MLPHQC";
		}
		map.put("order", order);
		if ("".equals(entity.getDzzt()) || entity.getDzzt() == null) {
			entity.setDzzt("01");
		}
		map.put("bzdzxxbvo", entity);
		if ("02".equals(entity.getDzzt()) || "03".equals(entity.getDzzt())) {
			map.put("tableName", "BZDZ_ADD_MLDZSHB T");
		} else {
			map.put("tableName", "BZDZ_ADD_MLDZDXB T");
		}
		page.setTotal((Integer) queryForObject(
				"com.founder.bzdz.sqlmap.Dz.queryDzCount", map));
		page.setRows(queryForList("com.founder.bzdz.sqlmap.Dz.queryDzList", map));
		return page;
	}

	/**
	 * @Title: queryMldzPd
	 * @描述: 判断门楼地址是否存在
	 * @作者: zhang_guoliang@founder.com
	 * @参数: 传入参数定义
	 * @日期： 2015-1-8 下午4:38:19
	 * @返回值: List<BzdzxxbVO> 返回类型
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	public List<BzdzxxbVO> queryMldzPd(BzdzxxbVO entity) {
		return queryForList("com.founder.bzdz.sqlmap.Dz.queryMldzPd", entity);
	}

	/**
	 * @Title: saveDzShb
	 * @描述: 保存地址_【门楼地址审核表】
	 * @作者: zhang_guoliang@founder.com
	 * @参数: 传入参数定义
	 * @日期： 2015-1-9 下午2:27:31
	 * @返回值: void 返回类型
	 * @throws
	 */
	public void saveDzShb(BzdzxxbVO entity) {
		insert("com.founder.bzdz.sqlmap.Dz.saveDzShb", entity);
	}

	/**
	 * @Title: saveDzDxb
	 * @描述: 保存地址_【门楼地址对象表】
	 * @作者: zhang_guoliang@founder.com
	 * @参数: 传入参数定义
	 * @日期： 2015-3-30 下午3:11:44
	 * @返回值: void 返回类型
	 * @throws
	 */
	public void saveDzDxb(BzdzxxbVO entity) {
		insert("com.founder.bzdz.sqlmap.Dz.saveDzDxb", entity);
	}
	
	/**
	 * @Title: saveDzDxbPT
	 * @描述: 保存地址_【门楼地址对象表_空间表】
	 * @作者: zhang_guoliang@founder.com
	 * @参数: 传入参数定义
	 * @日期： 2015-5-18 下午3:50:43
	 * @返回值: void 返回类型
	 * @throws
	 */
	public void saveDzDxbPT(Map<String, Object> params) {
		insert("com.founder.bzdz.sqlmap.Dz.saveDzDxbPT", params);
	}

	/**
	 * @Title: saveBm
	 * @描述: 保存别名_【门楼地址别名表】
	 * @作者: zhang_guoliang@founder.com
	 * @参数: 传入参数定义
	 * @日期： 2015-1-9 下午2:29:57
	 * @返回值: void 返回类型
	 * @throws
	 */
	public void saveBm(BzdzxxbVO entity) {
		insert("com.founder.bzdz.sqlmap.Dz.saveBm", entity);
	}

	/**
	 * @Title: saveJzw
	 * @描述: 保存建筑物_【建筑物信息表】
	 * @作者: zhang_guoliang@founder.com
	 * @参数: 传入参数定义
	 * @日期： 2015-1-16 上午11:12:19
	 * @返回值: void 返回类型
	 * @throws
	 */
	public void saveJzw(BzdzxxbVO entity) {
		insert("com.founder.bzdz.sqlmap.Dz.saveJzw", entity);
	}

	/**
	 * @Title: saveJzwglb
	 * @描述: 保存建筑物_【建筑物关联表】
	 * @作者: zhang_guoliang@founder.com
	 * @参数: 传入参数定义
	 * @日期： 2015-1-16 下午1:49:39
	 * @返回值: void 返回类型
	 * @throws
	 */
	public void saveJzwglb(BzdzxxbVO entity) {
		insert("com.founder.bzdz.sqlmap.Dz.saveJzwglb", entity);
	}

	/**
	 * @Title: saveChdz
	 * @描述: 保存层户地址_【层户地址审核表】
	 * @作者: zhang_guoliang@founder.com
	 * @参数: 传入参数定义
	 * @日期： 2015-1-29 下午3:04:19
	 * @返回值: void 返回类型
	 * @throws
	 */
	public void saveChdz(BzdzxxbVO entity) {
		insert("com.founder.bzdz.sqlmap.Dz.saveChdz", entity);
	}

	/**
	 * @Title: saveChdzDxb
	 * @描述: 保存层户地址_【层户地址对象表】
	 * @作者: zhang_guoliang@founder.com
	 * @参数: 传入参数定义
	 * @日期： 2015-3-4 下午1:36:25
	 * @返回值: void 返回类型
	 * @throws
	 */
	public void saveChdzDxb(BzdzxxbVO entity) {
		insert("com.founder.bzdz.sqlmap.Dz.saveChdzDxb", entity);
	}

	/**
	 * @Title: saveJzwChjgb
	 * @描述: 保存建筑物层户结构_【建筑物层户结构表】
	 * @作者: zhang_guoliang@founder.com
	 * @参数: 传入参数定义
	 * @日期： 2015-1-30 上午10:44:14
	 * @返回值: void 返回类型
	 * @throws
	 */
	public void saveJzwChjgb(BzdzxxbVO entity) {
		insert("com.founder.bzdz.sqlmap.Dz.saveJzwChjgb", entity);
	}

	/**
	 * @Title: crossOutDsp
	 * @描述: 注销待审批或被回退地址数据
	 * @作者: zhang_guoliang@founder.com
	 * @参数: 传入参数定义
	 * @日期： 2015-2-4 下午6:33:34
	 * @返回值: void 返回类型
	 * @throws
	 */
	public void crossOutDsp(BzdzxxbVO entity) {
		// 注销待审批或被退回地址数据_【门楼地址审核表】
		update("com.founder.bzdz.sqlmap.Dz.crossOutMldzshb", entity);
		// 注销地址数据_【门楼地址别名表】
		update("com.founder.bzdz.sqlmap.Dz.crossOutMldzbmb", entity);
		// 注销待审批或被退回地址数据_【层户地址审核表】
		crossOutChdzshb(entity);
	}

	/**
	 * @Title: crossOutChdzshb
	 * @描述: 注销待审批或被退回地址数据_【层户地址审核表】
	 * @作者: zhang_guoliang@founder.com
	 * @参数: 传入参数定义
	 * @日期： 2015-4-7 下午3:12:11
	 * @返回值: void 返回类型
	 * @throws
	 */
	public void crossOutChdzshb(BzdzxxbVO entity) {
		// 注销待审批或被退回地址数据_【层户地址审核表】
		update("com.founder.bzdz.sqlmap.Dz.crossOutChdzshb", entity);
	}

	/**
	 * @Title: queryJzwid
	 * @描述: 查询门楼地址关联的JZWID
	 * @作者: zhang_guoliang@founder.com
	 * @参数: 传入参数定义
	 * @日期： 2015-2-4 下午7:09:03
	 * @返回值: List<BzdzxxbVO> 返回类型
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	public List<BzdzxxbVO> queryJzwid(BzdzxxbVO entity) {
		return queryForList("com.founder.bzdz.sqlmap.Dz.queryJzwid", entity);
	}

	/**
	 * @Title: queryJzwidBz
	 * @描述: 查询门楼地址关联的JZWID 查询bz等于null的
	 * @作者: zhang_guoliang@founder.com
	 * @参数: 传入参数定义
	 * @日期： 2015-4-8 下午6:17:00
	 * @返回值: List<BzdzxxbVO> 返回类型
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	public List<BzdzxxbVO> queryJzwidBz(BzdzxxbVO entity) {
		return queryForList("com.founder.bzdz.sqlmap.Dz.queryJzwidBz", entity);
	}

	/**
	 * @Title: crossOutJzwXx
	 * @描述: 注销关联建筑物ID的数据
	 * @作者: zhang_guoliang@founder.com
	 * @参数: 传入参数定义
	 * @日期： 2015-2-4 下午7:29:43
	 * @返回值: void 返回类型
	 * @throws
	 */
	public void crossOutJzwXx(BzdzxxbVO entity) {
		// 注销地址数据_【建筑物信息表】
		update("com.founder.bzdz.sqlmap.Dz.crossOutJzwxxb", entity);
		// 注销地址数据_【建筑物层户结构表】
		update("com.founder.bzdz.sqlmap.Dz.crossOutJzwchjgb", entity);
		// 注销待审批或被退回地址数据_【建筑物关联表】
		update("com.founder.bzdz.sqlmap.Dz.crossOutJzwglb", entity);
	}

	/**
	 * @Title: queryShDzList
	 * @描述: 查询地址审核列表
	 * @作者: zhang_guoliang@founder.com
	 * @参数: 传入参数定义
	 * @日期： 2015-2-5 下午2:37:25
	 * @返回值: EasyUIPage 返回类型
	 * @throws
	 */
	public EasyUIPage queryShDzList(EasyUIPage page, BzdzxxbVO entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("begin", page.getBegin());
		map.put("end", page.getEnd());
		if ("".equals(entity.getShztdm()) || entity.getShztdm() == null) {
			entity.setShztdm("01");
		}
		map.put("bzdzxxbvo", entity);
		List<?> list = queryForList("com.founder.bzdz.sqlmap.Dz.queryShDzList", map);
		if (page.getBegin() == 0) {
			if (list != null && list.size() > 0) {
				page.setTotal(list.size());
			} else {
				page.setTotal(0);
			}
		} else {
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
	 * @Title: queryShDzCount
	 * @描述: 查询地址审核列表总数
	 * @作者: zhang_guoliang@founder.com
	 * @参数: 传入参数定义
	 * @日期： 2015-2-5 下午2:40:57
	 * @返回值: long 返回类型
	 * @throws
	 */
	public long queryShDzCount(BzdzxxbVO entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("bzdzxxbvo", entity);
		Integer count = (Integer) queryForObject(
				"com.founder.bzdz.sqlmap.Dz.queryShDzCount", map);
		return count.longValue();
	}

	/**
	 * @Title: queryZzjg
	 * @描述: 查询组织机构信息（主要查询边界坐标，无公共方法）
	 * @作者: zhang_guoliang@founder.com
	 * @参数: 传入参数定义
	 * @日期： 2015-2-6 上午10:16:01
	 * @返回值: List<BzdzxxbVO> 返回类型
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	public List<BzdzxxbVO> queryZzjg(String zzjgdm) {
		return queryForList("com.founder.bzdz.sqlmap.Dz.queryZzjg", zzjgdm);
	}

	/**
	 * @Title: queryMldzShXx
	 * @描述: 查询单条门楼审核地址详情数据
	 * @作者: zhang_guoliang@founder.com
	 * @参数: 传入参数定义
	 * @日期： 2015-2-6 下午3:31:36
	 * @返回值: BzdzxxbVO 返回类型
	 * @throws
	 */
	public BzdzxxbVO queryMldzShXx(String mldzid) {
		BzdzxxbVO returnValue = null;
		List<?> list = queryForList("com.founder.bzdz.sqlmap.Dz.queryMldzShXx",
				mldzid);
		if (list != null && list.size() > 0) {
			returnValue = (BzdzxxbVO) list.get(0);
		}
		return returnValue;
	}

	/**
	 * @Title: queryDzbm
	 * @描述: 获取地址别名
	 * @作者: zhang_guoliang@founder.com
	 * @参数: 传入参数定义
	 * @日期： 2015-2-7 下午12:48:51
	 * @返回值: List<BzdzxxbVO> 返回类型
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	public List<BzdzxxbVO> queryDzbm(String mldzid) {
		return queryForList("com.founder.bzdz.sqlmap.Dz.queryDzbm", mldzid);
	}

	/**
	 * @Title: updateSh
	 * @描述: 更新审核地址
	 * @作者: zhang_guoliang@founder.com
	 * @参数: 传入参数定义
	 * @日期： 2015-2-7 下午2:38:16
	 * @返回值: void 返回类型
	 * @throws
	 */
	public void updateSh(BzdzxxbVO entity) {
		// 更新审核地址_【门楼地址审核表】
		update("com.founder.bzdz.sqlmap.Dz.updateShMldz", entity);
		// 更新审核地址_【层户地址审核表】
		update("com.founder.bzdz.sqlmap.Dz.updateShChdz", entity);
	}

	/**
	 * @Title: insertDzDxb
	 * @描述: 审核通过将数据插入到门楼地址、层户地址对象表里
	 * @作者: zhang_guoliang@founder.com
	 * @参数: 传入参数定义
	 * @日期： 2015-2-7 下午4:29:52
	 * @返回值: void 返回类型
	 * @throws
	 */
	public void insertDzDxb(BzdzxxbVO entity) {
		// 插入审核地址_【门楼地址对象表】
		insert("com.founder.bzdz.sqlmap.Dz.insertDzMldz", entity);
		// 插入审核地址_【层户地址对象表】
		insert("com.founder.bzdz.sqlmap.Dz.insertDzChdz", entity);
	}

	/**
	 * @Title: insertChdzShb
	 * @描述: 插入层户地址到_【层户地址审核表】
	 * @作者: zhang_guoliang@founder.com
	 * @参数: 传入参数定义
	 * @日期： 2015-3-9 下午7:18:23
	 * @返回值: void 返回类型
	 * @throws
	 */
	public void insertChdzShb(BzdzxxbVO entity) {
		// 插入审核地址到_【层户地址对象表】
		insert("com.founder.bzdz.sqlmap.Dz.insertChdzShb", entity);
	}

	/**
	 * @Title: updateDzChShdz
	 * @描述: 更新【层户地址审核表】
	 * @作者: zhang_guoliang@founder.com
	 * @参数: 传入参数定义
	 * @日期： 2015-3-9 下午7:23:34
	 * @返回值: void 返回类型
	 * @throws
	 */
	public void updateDzChShdz(BzdzxxbVO entity) {
		// 更新【层户地址审核表】
		update("com.founder.bzdz.sqlmap.Dz.updateShChdz", entity);
	}

	/**
	 * @Title: updateDxChdz
	 * @描述: 更新【层户地址对象表】
	 * @作者: zhang_guoliang@founder.com
	 * @参数: 传入参数定义
	 * @日期： 2015-3-30 下午4:16:13
	 * @返回值: void 返回类型
	 * @throws
	 */
	public void updateDxChdz(BzdzxxbVO entity) {
		// 更新【层户地址审核表】
		update("com.founder.bzdz.sqlmap.Dz.updateDxChdz", entity);
	}

	/**
	 * @Title: updateDzDxb
	 * @描述: 维护审核
	 * @作者: zhang_guoliang@founder.com
	 * @参数: 传入参数定义
	 * @日期： 2015-2-11 下午3:36:52
	 * @返回值: void 返回类型
	 * @throws
	 */
	public void updateDzDxb(BzdzxxbVO entity) {
		entity.setRzid(UUID.create());
		entity.setBz("");
		// 插入维护地址_【门楼地址日志表】
		insert("com.founder.bzdz.sqlmap.Dz.insertMldzRzb", entity);
		// 删除门楼对象地址_【门楼地址对象表】
		delete("com.founder.bzdz.sqlmap.Dz.deleteDzMldz", entity);
		// 插入审核地址到_【门楼地址对象表】
		insert("com.founder.bzdz.sqlmap.Dz.insertDzMldz", entity);
		// 更新审核地址_【门楼地址对象表】
		update("com.founder.bzdz.sqlmap.Dz.updateDzMldzBz", entity);
		// 插入维护地址_【层户地址日志表】
		insert("com.founder.bzdz.sqlmap.Dz.insertChdzRzb", entity);
		// 删除层户地址对象表_【层户地址对象表】
		delete("com.founder.bzdz.sqlmap.Dz.deleteChdzDxb", entity.getMldzid());
		// 插入层户地址对象_【层户地址对象表】
		insert("com.founder.bzdz.sqlmap.Dz.insertDzChdz", entity);
	}

	/**
	 * @Title: updateDzJzw
	 * @描述: 建筑物信息【维护】注销重建
	 * @作者: zhang_guoliang@founder.com
	 * @参数: 传入参数定义
	 * @日期： 2015-4-8 下午2:52:29
	 * @返回值: void 返回类型
	 * @throws
	 */
	public void updateDzJzw(BzdzxxbVO entity) {
		// 更新地址数据_【建筑物信息表】
		update("com.founder.bzdz.sqlmap.Dz.updateJzwxxbBz", entity);
		// 更新地址数据_【建筑物层户结构表】
		update("com.founder.bzdz.sqlmap.Dz.updateJzwchjgbBz", entity);
		// 更新待审批或被退回地址数据_【建筑物关联表】
		update("com.founder.bzdz.sqlmap.Dz.updateJzwglbBz", entity);
	}

	/**
	 * @Title: queryJzwChjg
	 * @描述: 获取建筑物层户机构_【建筑物层户结构表】
	 * @作者: zhang_guoliang@founder.com
	 * @参数: 传入参数定义
	 * @日期： 2015-2-7 下午5:44:22
	 * @返回值: List<BzdzxxbVO> 返回类型
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	public List<BzdzxxbVO> queryJzwChjg(BzdzxxbVO entity) {
		return queryForList("com.founder.bzdz.sqlmap.Dz.queryJzwChjg", entity);
	}

	/**
	 * @Title: queryChShdz
	 * @描述: 获取层户地址_【层户地址审核表】
	 * @作者: zhang_guoliang@founder.com
	 * @参数: 传入参数定义
	 * @日期： 2015-2-9 上午11:31:39
	 * @返回值: List<BzdzxxbVO> 返回类型
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	public List<BzdzxxbVO> queryChShdz(BzdzxxbVO entity) {
		return queryForList("com.founder.bzdz.sqlmap.Dz.queryChShdz", entity);
	}

	/**
	 * @Title: queryChdzdxb
	 * @描述: 获取层户地址_【层户地址对象表】
	 * @作者: zhang_guoliang@founder.com
	 * @参数: 传入参数定义
	 * @日期： 2015-3-3 下午2:11:12
	 * @返回值: List<BzdzxxbVO> 返回类型
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	public List<BzdzxxbVO> queryChdzdxb(BzdzxxbVO entity) {
		return queryForList("com.founder.bzdz.sqlmap.Dz.queryChdzdxb", entity);
	}

	/**
	 * @Title: crossOutYqy
	 * @描述: 注销已启用地址数据
	 * @作者: zhang_guoliang@founder.com
	 * @参数: 传入参数定义
	 * @日期： 2015-2-9 下午7:06:31
	 * @返回值: void 返回类型
	 * @throws
	 */
	public void crossOutYqy(BzdzxxbVO entity) {
		// 注销已启用地址数据_【门楼地址对象表】
		update("com.founder.bzdz.sqlmap.Dz.crossOutMldzdxb", entity);
		// 注销地址数据_【门楼地址别名表】
		update("com.founder.bzdz.sqlmap.Dz.crossOutMldzbmb", entity);
		// 注销已启用地址数据_【门楼地址对象表_空间表】
		crossOutMldzdxbPT(entity);
		// 注销已启用地址数据_【层户地址对象表】
		crossOutChdzdxb(entity);
	}
	/**
	 * @Title: crossOutMldzdxbPT 
	 * @描述: 注销已启用地址数据_【门楼地址对象表_空间表】
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2015-5-18 下午5:11:10 
	 * @返回值: void    返回类型 
	 * @throws
	 */
	public void crossOutMldzdxbPT(BzdzxxbVO entity) {
		//注销已启用地址数据_【门楼地址对象表_空间表】
		delete("com.founder.bzdz.sqlmap.Dz.crossOutMldzdxbPT", entity);
	}
	/**
	 * @Title: crossOutChdzdxb
	 * @描述: 注销已启用地址数据_【层户地址对象表】
	 * @作者: zhang_guoliang@founder.com
	 * @参数: 传入参数定义
	 * @日期： 2015-4-7 下午3:14:42
	 * @返回值: void 返回类型
	 * @throws
	 */
	public void crossOutChdzdxb(BzdzxxbVO entity) {
		// 注销已启用地址数据_【层户地址对象表】
		update("com.founder.bzdz.sqlmap.Dz.crossOutChdzdxb", entity);
	}

	/**
	 * @Title: queryMldzDx
	 * @描述: 查询单条门楼对象地址详情数据_【门楼地址对象表】
	 * @作者: zhang_guoliang@founder.com
	 * @参数: 传入参数定义
	 * @日期： 2015-2-9 下午7:54:32
	 * @返回值: BzdzxxbVO 返回类型
	 * @throws
	 */
	public BzdzxxbVO queryMldzDx(String mldzid) {
		BzdzxxbVO returnValue = null;
		List<?> list = queryForList("com.founder.bzdz.sqlmap.Dz.queryMldzDx", mldzid);
		if (list != null && list.size() > 0) {
			returnValue = (BzdzxxbVO) list.get(0);
		}
		return returnValue;
	}

	/**
	 * @Title: queryMldzShb
	 * @描述: 查询门楼地址审核表 _【门楼地址审核表】
	 * @作者: zhang_guoliang@founder.com
	 * @参数: 传入参数定义
	 * @日期： 2015-2-10 下午7:16:32
	 * @返回值: BzdzxxbVO 返回类型
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	public List<BzdzxxbVO> queryMldzShb(String mldzid) {
		return queryForList("com.founder.bzdz.sqlmap.Dz.queryMldzShb", mldzid);
	}

	/**
	 * @Title: updateMldzShb
	 * @描述: 更新门楼地址审核表 _【门楼地址审核表】
	 * @作者: zhang_guoliang@founder.com
	 * @参数: 传入参数定义
	 * @日期： 2015-2-10 下午7:31:00
	 * @返回值: void 返回类型
	 * @throws
	 */
	public void updateMldzShb(BzdzxxbVO entity) {
		update("com.founder.bzdz.sqlmap.Dz.updateMldzShb", entity);
	}

	/**
	 * @Title: deleteBm
	 * @描述: 删除【地址别名】
	 * @作者: zhang_guoliang@founder.com
	 * @参数: 传入参数定义
	 * @日期： 2015-2-10 下午7:57:10
	 * @返回值: void 返回类型
	 * @throws
	 */
	public void deleteBm(String mldzid) {
		delete("com.founder.bzdz.sqlmap.Dz.deleteBm", mldzid);
	}

	/**
	 * @Title: deleteChdzShb
	 * @描述: 删除【层户地址审核表】
	 * @作者: zhang_guoliang@founder.com
	 * @参数: 传入参数定义
	 * @日期： 2015-3-9 下午2:52:48
	 * @返回值: void 返回类型
	 * @throws
	 */
	public void deleteChdzShb(String mldzid) {
		delete("com.founder.bzdz.sqlmap.Dz.deleteChdzShb", mldzid);
	}

	/**
	 * @Title: insertMldzShb
	 * @描述: 插入维护地址_【门楼地址审核表】
	 * @作者: zhang_guoliang@founder.com
	 * @参数: 传入参数定义
	 * @日期： 2015-2-11 上午11:17:16
	 * @返回值: void 返回类型
	 * @throws
	 */
	public void insertMldzShb(BzdzxxbVO entity) {
		// 插入维护地址_【门楼地址审核表】
		insert("com.founder.bzdz.sqlmap.Dz.insertMldzShb", entity);
	}

	/**
	 * @Title: updateDzMldz
	 * @描述: 不合格退回对象表
	 * @作者: zhang_guoliang@founder.com
	 * @参数: 传入参数定义
	 * @日期： 2015-2-11 下午7:19:43
	 * @返回值: void 返回类型
	 * @throws
	 */
	public void updateDzMldz(BzdzxxbVO entity) {
		// 更新审核地址_【门楼地址对象表】
		update("com.founder.bzdz.sqlmap.Dz.updateDzMldzBz", entity);
	}

	/**
	 * @Title: updateMldz
	 * @描述: 维护地址_【门楼地址对象表】
	 * @作者: zhang_guoliang@founder.com
	 * @参数: 传入参数定义
	 * @日期： 2015-3-30 下午4:00:16
	 * @返回值: void 返回类型
	 * @throws
	 */
	public void updateMldz(BzdzxxbVO entity) {
		// 更新启用地址_【门楼地址对象表】
		update("com.founder.bzdz.sqlmap.Dz.updateMldz", entity);
	}

	/**
	 * @Title: updateDymc
	 * @描述: 修改单元名称_【层户地址对象表】
	 * @作者: zhang_guoliang@founder.com
	 * @参数: 传入参数定义
	 * @日期： 2015-3-3 上午10:51:36
	 * @返回值: void 返回类型
	 * @throws
	 */
	public void updateDymc(BzdzxxbVO entity) {
		// 修改单元名称_【层户地址对象表】
		update("com.founder.bzdz.sqlmap.Dz.updateDymc", entity);
	}

	/**
	 * @Title: updateJzwchjgb
	 * @描述: 修改单元名称_【建筑物层户结构表】
	 * @作者: zhang_guoliang@founder.com
	 * @参数: 传入参数定义
	 * @日期： 2015-3-3 下午3:33:09
	 * @返回值: void 返回类型
	 * @throws
	 */
	public void updateJzwchjgb(BzdzxxbVO entity) {
		// 修改单元名称_【建筑物层户结构表】
		update("com.founder.bzdz.sqlmap.Dz.updateJzwchjgb", entity);
	}

	/**
	 * @Title: queryDyChdz
	 * @描述: 获取某一单元层户地址_【层户地址对象表】
	 * @作者: zhang_guoliang@founder.com
	 * @参数: 传入参数定义
	 * @日期： 2015-3-3 下午2:29:47
	 * @返回值: List<BzdzxxbVO> 返回类型
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	public List<BzdzxxbVO> queryDyChdz(BzdzxxbVO entity) {
		return queryForList("com.founder.bzdz.sqlmap.Dz.queryDyChdz", entity);
	}

	/**
	 * @Title: crossChdxbLcs
	 * @描述: 修改单元层数注销楼层数_【层户地址对象表】
	 * @作者: zhang_guoliang@founder.com
	 * @参数: 传入参数定义
	 * @日期： 2015-3-4 下午2:22:40
	 * @返回值: void 返回类型
	 * @throws
	 */
	public void crossChdxbLcs(BzdzxxbVO entity) {
		// 修改单元层数注销楼层数_【层户地址对象表】
		update("com.founder.bzdz.sqlmap.Dz.crossChdxbLcs", entity);
	}

	/**
	 * @Title: crossChdxbhs
	 * @描述: 修改单元户数注销楼户数_【层户地址对象表】
	 * @作者: zhang_guoliang@founder.com
	 * @参数: 传入参数定义
	 * @日期： 2015-3-4 下午5:00:27
	 * @返回值: void 返回类型
	 * @throws
	 */
	public void crossChdxbhs(BzdzxxbVO entity) {
		// 修改单元户数注销楼户数_【层户地址对象表】
		update("com.founder.bzdz.sqlmap.Dz.crossChdxbhs", entity);
	}

	/**
	 * @Title: updateDyfjmc
	 * @描述: 修改房间名称
	 * @作者: zhang_guoliang@founder.com
	 * @参数: 传入参数定义
	 * @日期： 2015-3-5 下午3:32:15
	 * @返回值: void 返回类型
	 * @throws
	 */
	public void updateDyfjmc(BzdzxxbVO entity) {
		// 修改房间名称_【建筑物层户结构表】
		update("com.founder.bzdz.sqlmap.Dz.updateDyfjmc", entity);
	}

	/**
	 * @Title: queryHjdKgJt
	 * @描述: 查询户籍地空挂地址集体
	 * @作者: zhang_guoliang@founder.com
	 * @参数: 传入参数定义
	 * @日期： 2015-4-3 上午11:25:48
	 * @返回值: DzXxbVO 返回类型
	 * @throws
	 */
	public DzXxbVO queryHjdKgJt(String zrqdm) {
		DzXxbVO returnValue = null;
		List<?> list = queryForList("com.founder.bzdz.sqlmap.Dz.queryHjdKgJt", zrqdm);
		if (list != null && list.size() > 0) {
			returnValue = (DzXxbVO) list.get(0);
		}
		return returnValue;
	}

	/**
	 * @Title: queryHjdKgJm
	 * @描述: 查询户籍地空挂地址居民
	 * @作者: zhang_guoliang@founder.com
	 * @参数: 传入参数定义
	 * @日期： 2015-4-3 上午11:26:32
	 * @返回值: DzXxbVO 返回类型
	 * @throws
	 */
	public DzXxbVO queryHjdKgJm(String zrqdm) {
		DzXxbVO returnValue = null;
		List<?> list = queryForList("com.founder.bzdz.sqlmap.Dz.queryHjdKgJm", zrqdm);
		if (list != null && list.size() > 0) {
			returnValue = (DzXxbVO) list.get(0);
		}
		return returnValue;
	}

	/**
	 * @Title: queryChdzLcHs
	 * @描述: 获取层户地址楼层户数
	 * @作者: zhang_guoliang@founder.com
	 * @参数: 传入参数定义
	 * @日期： 2015-4-3 下午3:01:54
	 * @返回值: List<BzdzxxbVO> 返回类型
	 * @throws
	 */
	public String queryChdzLcHs(BzdzxxbVO entity) {
		String vo = (String) queryForObject(
				"com.founder.bzdz.sqlmap.Dz.queryChdzLcHs", entity);
		return vo;
	}

	/**
	 * @Title: updateMldzDxbDmmc
	 * @描述: 地名维护【更新服务】_门楼地址对象表
	 * @作者: zhang_guoliang@founder.com
	 * @参数: 传入参数定义
	 * @日期： 2015-4-9 下午3:25:11
	 * @返回值: void 返回类型
	 * @throws
	 */
	public void updateDxbDmmc(BzdzxxbVO entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("entity", entity);
		map.put("tableMlName", "BZDZ_ADD_MLDZDXB");
		map.put("tableChName", "BZDZ_ADD_CHDZDXB");
		// 门楼地址对象表
		update("com.founder.bzdz.sqlmap.Dz.updateMldzDmmc", map);
		// 层户地址对象表
		update("com.founder.bzdz.sqlmap.Dz.updateChdzDmmc", map);
	}

	/**
	 * @Title: updateShbDmmc
	 * @描述: 地名维护【更新服务】_门楼地址审核表
	 * @作者: zhang_guoliang@founder.com
	 * @参数: 传入参数定义
	 * @日期： 2015-4-9 下午4:44:17
	 * @返回值: void 返回类型
	 * @throws
	 */
	public void updateShbDmmc(BzdzxxbVO entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("entity", entity);
		map.put("tableMlName", "BZDZ_ADD_MLDZSHB");
		map.put("tableChName", "BZDZ_ADD_CHDZSHB");
		// 门楼地址审核表
		update("com.founder.bzdz.sqlmap.Dz.updateMldzDmmc", map);
		// 层户地址审核表
		update("com.founder.bzdz.sqlmap.Dz.updateChdzDmmc", map);
	}

	/**
	 * @Title: updateHouseHb
	 * @描述: 合并保存事件【层户地址对象表】
	 * @作者: zhang_guoliang@founder.com
	 * @参数: 传入参数定义
	 * @日期： 2015-4-10 下午4:00:58
	 * @返回值: void 返回类型
	 * @throws
	 */
	public void updateHouseHb(BzdzxxbVO entity) {
		// 层户地址对象表
		update("com.founder.bzdz.sqlmap.Dz.updateDymc", entity);
	}

	/**
	 * @Title: updateHouseQxHb
	 * @描述: 取消合并保存事件【层户地址对象表】
	 * @作者: zhang_guoliang@founder.com
	 * @参数: 传入参数定义
	 * @日期： 2015-4-11 下午5:09:03
	 * @返回值: void 返回类型
	 * @throws
	 */
	public void updateHouseQxHb(BzdzxxbVO entity) {
		// 层户地址对象表
		update("com.founder.bzdz.sqlmap.Dz.updateHouseQxHb", entity);
	}

	/**
	 * @Title: searchAddressMlph
	 * @描述:【门楼地址】全文检索
	 * @作者: zhang_guoliang@founder.com
	 * @参数: 传入参数定义
	 * @日期： 2015-4-13 上午10:23:05
	 * @返回值: List<DzContextCombo> 返回类型
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	public List<DzContextCombo> searchAddressMlph(DzContextCondition condition) {
		List<DzContextCombo> list = new ArrayList<DzContextCombo>();
		String searchKey = condition.getSearchKey();
		condition.setSearchKey(getCutSearchKey(searchKey));
		String queryExpression = getQueryExpression(condition);
		if (!StringUtils.isBlank(queryExpression)) {
			condition.setQueryExpression(queryExpression);
			list = queryForList("com.founder.bzdz.sqlmap.Dz.searchAddressMlph",
					condition);
		}
		return list;
	}

	/**
	 * @Title: searchAddressMlphXz
	 * @描述:【层户地址】全文检索
	 * @作者: zhang_guoliang@founder.com
	 * @参数: 传入参数定义
	 * @日期： 2015-4-13 上午10:32:16
	 * @返回值: List<DzContextCombo> 返回类型
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	public List<DzContextCombo> searchAddressMlphXz(DzContextCondition condition) {
		List<DzContextCombo> list = new ArrayList<DzContextCombo>();
		if (!StringUtils.isBlank(condition.getId())) {
			String searchKey = condition.getSearchKey();
			condition.setSearchKey(getCutSearchKey(searchKey));
			list = queryForList("com.founder.bzdz.sqlmap.Dz.searchAddressMlphXz",
					condition);
		}
		return list;
	}

	/**
	 * @Title: getCutSearchKey
	 * @描述: 取得截取后的地址检索关键词
	 * @作者: zhang_guoliang@founder.com
	 * @参数: 传入参数定义
	 * @日期： 2015-4-13 上午10:24:26
	 * @返回值: String 返回类型
	 * @throws
	 */
	private String getCutSearchKey(String searchKey) {
		String returnValue = "";
		if (!StringUtils.isBlank(searchKey)) {
			String addressPrefix = SystemConfig.getString("addressPrefix");
			if (!StringUtils.isBlank(addressPrefix)) { // 去掉省市的地址前辍
				String[] addressPrefixArray = addressPrefix.split(",");
				for (int i = 0; i < addressPrefixArray.length; i++) {
					searchKey = searchKey.replaceAll(addressPrefixArray[i], "");
				}
			}
			String subXzqhName = SystemConfig.getString("subXzqhName");
			if (!StringUtils.isBlank(subXzqhName)) { // 去掉行政区划名称的地址前辍
				String[] subXzqhNameArray = subXzqhName.split(",");
				for (int i = 0; i < subXzqhNameArray.length; i++) {
					searchKey = searchKey.replaceAll(subXzqhNameArray[i], "");
				}
			}
			returnValue = searchKey;
		}
		return returnValue;
	}

	/**
	 * @Title: getQueryExpression
	 * @描述: 取得地址全文检索的查询表达式
	 * @作者: zhang_guoliang@founder.com
	 * @参数: 传入参数定义
	 * @日期： 2015-4-13 上午10:24:37
	 * @返回值: String 返回类型
	 * @throws
	 */
	private String getQueryExpression(DzContextCondition condition) {
		String returnValue = "";
		String searchKey = condition.getSearchKey();
		searchKey = ContextSearchUtils.getRemoveSpecialString(searchKey);
		if (!StringUtils.isBlank(searchKey)) {
			String contextField = "";
			searchKey = searchKey.toUpperCase();
			searchKey = searchKey.replaceAll("'", "");
			searchKey = searchKey.replaceAll(" ", "");
			char firstChar = searchKey.charAt(0);
			if ((firstChar >= 'A' && firstChar <= 'Z')
					|| (firstChar >= '0' && firstChar <= '9')
					|| firstChar == '-') {
				contextField = "DZMCPYPWD";
			} else {
				contextField = "DZMCPWD";
			}
			String innerCondition = ""; // 全文内部条件（根据索引是否在内部注入条件）
			if (!StringUtils.isBlank(condition.getPcsdm())) {
				innerCondition = "PCSDM=''" + condition.getPcsdm() + "''";
			} else if (!StringUtils.isBlank(condition.getZrqdm())) {
				innerCondition = "ZRQDM=''" + condition.getZrqdm() + "''";
			} else if (!StringUtils.isBlank(condition.getFxjdm())) {
				innerCondition = "FXJDM=''" + condition.getFxjdm() + "''";
			}
			if ("".equals(innerCondition)) {
				innerCondition = "null";
			} else {
				innerCondition = "'" + innerCondition + "'";
			}
			searchKey = ContextSearchUtils.getPasswordString(searchKey);
			if (searchKey.length() >= 80) { // 最多80个汉字
				searchKey = searchKey.substring(0, 80);
			}
			returnValue = "catsearch(" + contextField + ",'" + searchKey + "',"
					+ innerCondition + ") > 0";
		}
		return returnValue;
	}
	/**
	 * @Title: queryChdzdxbShow 
	 * @描述: 获取层户地址信息展现内容【此方法有统计_人口、单位信息】
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: mldzid 【门楼地址ID】
	 * @日期： 2015-5-7 下午2:52:13 
	 * @返回值: List<DzBuildingVO>    返回类型 
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	public List<DzBuildingVO> queryChdzdxbShow(String mldzid) {
		return queryForList("com.founder.bzdz.sqlmap.Dz.queryChdzdxbShow", mldzid);
	}
	/**
	 * @Title: queryDzTjList 
	 * @描述: 标准地址统计
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2015-5-12 下午4:14:17 
	 * @返回值: EasyUIPage    返回类型 
	 * @throws
	 */
	public EasyUIPage queryDzTjList(EasyUIPage page, DzTjVO entity) {
		page.setRows(queryForList("com.founder.bzdz.sqlmap.Dz.queryDzTjList", entity));
		page.setTotal((Integer) queryForObject("com.founder.bzdz.sqlmap.Dz.queryDzTjCount", entity));
		return page;
	}
	/**
	 * @Title: queryDzTjList_export 
	 * @描述: 标准地址统计_导出
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2015-5-17 下午5:15:20 
	 * @返回值: List<Map<String,String>>    返回类型 
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	public List<Map<String, String>> queryDzTjList_export(DzTjVO entity){
		return queryForList("com.founder.bzdz.sqlmap.Dz.queryDzTjList", entity);
	}
}