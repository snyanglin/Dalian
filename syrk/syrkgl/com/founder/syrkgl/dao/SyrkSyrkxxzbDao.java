package com.founder.syrkgl.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.syrkgl.bean.SyrkSyrkxxzb;
/**
 * ****************************************************************************
 * 
 * @Package: [com.founder.syrkgl.dao.SyrkSyrkxxzbDao.java]
 * @ClassName: [SyrkSyrkxxzbDao]
 * @Description: [实有人口总表DAO]
 * @Author: [weiwen]
 * @CreateDate: [2015-4-3 下午4:48:59]
 * @UpdateUser: [weiwen]
 * @UpdateDate: [2015-4-3 下午4:48:59，(如多次修改保留历史记录，增加修改记录)]
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]
 * @Version: [v1.0]
 */
@Repository("syrkSyrkxxzbDao")
public class SyrkSyrkxxzbDao extends BaseDaoImpl {

	public void save(SyrkSyrkxxzb entity) {
		insert("SyrkSyrkxxzb.save", entity);
	}

	public void update(SyrkSyrkxxzb entity) {
		update("SyrkSyrkxxzb.update", entity);
	}

	/**
	 * @Title: delete
	 * @描述: 实有人口注销【服务接口】
	 * @作者: zhang_guoliang@founder.com
	 * @参数: 传入参数定义
	 * @日期： 2015-4-15 下午5:16:15
	 * @返回值: void 返回类型
	 * @throws
	 */
	public void delete(SyrkSyrkxxzb entity) {
		update("SyrkSyrkxxzb.delete", entity);
	}

	/**
	 * 
	 * @Title: queryById
	 * @Description: TODO(根据ID查询实有人员)
	 * @param @param id
	 * @param @return 设定文件
	 * @return SyrkSyrkxxzb 返回类型
	 * @throws
	 */
	public SyrkSyrkxxzb queryById(String id) {
		if (StringUtils.isBlank(id)) {
			return null;
		} else {
			return (SyrkSyrkxxzb) queryForObject("SyrkSyrkxxzb.queryById", id);
		}
	}

	/**
	 * 
	 * @Title: queryListByRyid
	 * @Description: TODO(根据人员ID查询人员所有类型集合)
	 * @param @param ryid
	 * @param @return 设定文件
	 * @return List<SyrkSyrkxxzb> 返回类型
	 * @throws
	 */
	public List<SyrkSyrkxxzb> queryListByRyid(String ryid) {
		if (StringUtils.isBlank(ryid)) {
			return null;
		} else {
			return queryForList("SyrkSyrkxxzb.queryListByRyid", ryid);
		}
	}

	/**
	 * @Title: queryListByRyidYwlx
	 * @Description: TODO(根据ryid、实有人口业务类型查询列表)
	 * @param @param ryid
	 * @param @param syrkywlxdm
	 * @param @return 设定文件
	 * @return SyrkSyrkxxzb 返回类型
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	public List<SyrkSyrkxxzb> queryListByRyidYwlx(SyrkSyrkxxzb entity) {
		return queryForList("SyrkSyrkxxzb.queryListByRyidYwlx", entity);
	}

	/**
	 * @Title: queryPersonByDzDm
	 * @Description: TODO(根据地址查询相关实有人口)
	 * @param @param ryid
	 * @param @param syrkywlxdm
	 * @param @return 设定文件
	 * @return SyrkSyrkxxzb 返回类型
	 * @throws
	 */
	public List<SyrkSyrkxxzb> queryPersonByDzDm(String jzd_dzid, String gxzrqdm) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("jzd_dzid", jzd_dzid);
		map.put("gxzrqdm", gxzrqdm);
		return queryForList("SyrkSyrkxxzb.queryListByDzDm", map);
	}

	/**
	 * @Title: queryCzrkByRyid
	 * @Description: TODO(根据ryid查询实有人口业务类型为常住人口的对象)
	 * @param @param ryid
	 * @param @return 设定文件
	 * @return SyrkSyrkxxzb 返回类型
	 * @throws
	 */
	public SyrkSyrkxxzb queryCzrkByRyid(String ryid) {
		if (StringUtils.isBlank(ryid)) {
			return null;
		} else {
			return (SyrkSyrkxxzb) queryForObject(
					"SyrkSyrkxxzb.queryCzrkByRyid", ryid);
		}
	}

	/**
	 * @Title: queryList
	 * @描述: 查询实有人口管理列表数据【服务接口】
	 * @作者: zhang_guoliang@founder.com
	 * @参数: 传入参数定义
	 * @日期： 2015-4-14 上午11:25:05
	 * @返回值: EasyUIPage 返回类型
	 * @throws
	 */
	public EasyUIPage queryList(SyrkSyrkxxzb entity, EasyUIPage page) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("begin", page.getBegin());
		map.put("end", page.getEnd());
		String sort = page.getSort();
		String order = page.getOrder();
		if (StringUtils.isBlank(sort)) {
			sort = "id";
			order = "asc";
		}
		map.put("sort", sort);
		map.put("order", order);
		map.put("entity", entity);
		//修改人 wuchunhui@founder.com，需求变更redmine #2520
		
		
		page.setRows(queryForList("SyrkSyrkxxzb.query", map));
		page.setTotal((Integer) queryForObject("SyrkSyrkxxzb.queryCount", map));
		return page;
	}


	/**
	 * 
	 * @Title: isExist
	 * @Description: TODO(根据实有人口ID查询是否存在该记录)
	 * @param @param id
	 * @param @return 设定文件
	 * @return boolean 返回类型
	 * @throws
	 */
	public boolean isExist(String id) {
		return (Integer) queryForObject("SyrkSyrkxxzb.isExist", id) > 0 ? true
				: false;
	}

	/**
	 * @Title: isExistRyDz
	 * @Description: TODO(判断同一个人在同一个地址下不能重复)
	 * @param @param ryid
	 * @param @param jzd_dzid
	 * @param @return 设定文件
	 * @return boolean 返回类型
	 * @throws
	 */
	public boolean isExistRyDz(String ryid, String jzd_dzid) {
		boolean returnValue = false;
		if (!StringUtils.isBlank(ryid) && !StringUtils.isBlank(jzd_dzid)) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("ryid", ryid);
			map.put("jzd_dzid", jzd_dzid);
			Integer count = (Integer) queryForObject(
					"SyrkSyrkxxzb.isExistRyDz", map);
			if (count > 0) {
				returnValue = true;
			}
		}
		return returnValue;
	}

	/**
	 * @Title: queryRyGxzrq
	 * @Description: TODO(查询人员的管辖责任区)
	 * @param @param id
	 * @param @param zrqdm 当前责任区代码（有值时查询结果与zrqdm不重复）
	 * @param @return 设定文件
	 * @return String 返回类型（从个时用逗号分隔）
	 * @throws
	 */
	public String queryRyGxzrq(String ryid, String zrqdm) {
		String returnValue = "";
		if (!StringUtils.isBlank(ryid)) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("ryid", ryid);
			map.put("zrqdm", zrqdm);
			List<String> list = queryForList("SyrkSyrkxxzb.queryRyGxzrq", map);
			StringBuffer sb = new StringBuffer();
			if (list != null && list.size() > 0) {
				for (int i = 0; i < list.size(); i++) {
					sb.append(list.get(i));
					if (i < list.size() - 1) {
						sb.append(",");
					}
				}
				returnValue = sb.toString();
			}
		}
		return returnValue;
	}

	/**
	 * 
	 * @Title: queryListByRyid
	 * @Description: TODO(查询人员管辖责任区列表（实有人口新增时，向其他管辖责任区发送消息用） )
	 * @param @param ryid
	 * @param @return 设定文件
	 * @return List<SyrkSyrkxxzb> 返回类型
	 * @throws
	 */
	public List<SyrkSyrkxxzb> queryRyGxzrqList(String ryid) {
		if (StringUtils.isBlank(ryid)) {
			return null;
		} else {
			return queryForList("SyrkSyrkxxzb.queryRyGxzrqList", ryid);
		}
	}
	
	/***
	 * 
	 * @Title: queryHsbSyrkidByZjhm
	 * @Description: TODO(根据身份证和所属责任区查询实有人口ID)
	 * @param @param zjhm
	 * @param @param sessionBean    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public List<SyrkSyrkxxzb> queryHsbSyrkidByZjhm(Map<String,String> map){
		return queryForList("SyrkSyrkxxzb.querySyrkByZjhm", map);
	}
	
	/**
	 * @Title: querySyrk
	 * @描述: 查询实有人口查询列表数据【服务接口】
	 * @作者: zhang_guoliang@founder.com
	 * @参数: 传入参数定义
	 * @日期： 2015-4-15 上午10:08:34
	 * @返回值: EasyUIPage 返回类型
	 * @throws
	 */
	public EasyUIPage querySyrk(SyrkSyrkxxzb entity, EasyUIPage page) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("begin", page.getBegin());
		map.put("end", page.getEnd());
		map.put("entity", entity);
		if(!StringUtils.isBlank(entity.getDrawType())&&!StringUtils.isBlank(entity.getDrawZbz())){
			map.put("tableName", "SYRK_SYRKXXZB T, BZDZ_ADD_MLDZDXB_PT P");
		}else{
			map.put("tableName", "SYRK_SYRKXXZB T");
		}
		List<?> list = queryForList("SyrkSyrkxxzb.querySyrk", map);
		
	    int count = (Integer)queryForObject("SyrkSyrkxxzb.querySyrkCount", map);
	    
	    page.setTotal(count);
	    
		/*if (page.getBegin() == 0) {
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
		}*/
		page.setRows(list);
		return page;
	}

	/**
	 * @Title: querySyrkCount
	 * @描述: 查询实有人口查询列表数据总数【服务接口】
	 * @作者: zhang_guoliang@founder.com
	 * @参数: 传入参数定义
	 * @日期： 2015-4-15 上午10:15:19
	 * @返回值: long 返回类型
	 * @throws
	 */
	public long querySyrkCount(SyrkSyrkxxzb entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("entity", entity);
		if(!StringUtils.isBlank(entity.getDrawType())&&!StringUtils.isBlank(entity.getDrawZbz())){
			map.put("tableName", "SYRK_SYRKXXZB T, BZDZ_ADD_MLDZDXB_PT P");
		}else{
			map.put("tableName", "SYRK_SYRKXXZB T");
		}
		Integer count = (Integer) queryForObject("SyrkSyrkxxzb.querySyrkCount",map);
		return count.longValue();
	}
	
	
	public List<SyrkSyrkxxzb> queryList(SyrkSyrkxxzb entity){
		return (List<SyrkSyrkxxzb>)queryForList("SyrkSyrkxxzb.queryList", entity);
	}
}