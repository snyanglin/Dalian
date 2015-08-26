package com.founder.syfw.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.service.attachment.bean.ZpfjFjxxb;
import com.founder.syfw.bean.Czfwjcxxb;
import com.founder.syfw.bean.Czfwxxb;
import com.founder.syfw.bean.FwCzqkdjxxb;
import com.founder.syfw.bean.Fwjbxxb;
import com.founder.syfw.vo.SyfwgnVO;
import com.founder.syfw.vo.SyfwxxzsVO;

@Repository("syfwEditDao")
public class SyfwEditDao extends BaseDaoImpl{

	public Fwjbxxb queryFwjbxxbById(String id) {
		return (Fwjbxxb) queryForObject("Fwjbxxb.queryById", id);
	}

	public List<SyfwxxzsVO> queryFwzsxx(Map<String, Object> map) {
		return queryForList("Syfwglpz.queryZhxxzspz",map);
	}

	public List<SyfwgnVO> queryYwglgn(Map<String, Object> map) {
		return queryForList("Syfwglpz.queryYwglgn",map);
	}

	public void delete_xxzsnrb(Map<String, Object> map) {
		List<?> list = queryForList("Syfwglpz.queryxxzsnrbByxxdybm", map.get("url"));
		map.put("tablename", list.get(0).toString());
		if (list != null && list.size() > 0) {
			update("Syfwglpz.updateTableByxxdybm", map);
		} 
	}

	public void insertFwjbxxb(Fwjbxxb entity){
		insert("Fwjbxxb.save", entity);
	}

	public void updateFwjbxxb(Fwjbxxb entity){
		update("Fwjbxxb.update", entity);
	}

	public Czfwxxb czfwzb_query(Map<String, Object> map){
		return (Czfwxxb) queryForObject("Czfwxxb.czfwxxb_query",map);
	}

	public int getJzrs(Map<String, Object> map){
		return (Integer) queryForObject("Fwjbxxb.getJzrs", map);
	}

	public void insertCzfwxxb(Czfwxxb czfwxxb) {
		insert("Czfwxxb.save", czfwxxb);
	}

	public void updateCzfwxxb(Czfwxxb czfwxxb) {
		update("Czfwxxb.update", czfwxxb);
	}

	/**
	 * 
	 * @Title: checkDz
	 * @Description: TODO(根据DZDM 统计相关有效记录条数)
	 * @param @param dzdm
	 * @param @return    设定文件
	 * @return int    返回类型
	 * @throws
	 */
	public int checkDz(String dzdm) {
		return (Integer) queryForObject("Fwjbxxb.checkDz", dzdm);
	}

	/**
	 * 
	 * @Title: fjxx_query
	 * @Description: TODO(附件列表)
	 * @param @param map
	 * @param @return    设定文件
	 * @return List<ZpfjFjxxb>    返回类型
	 * @throws
	 */
	public List<ZpfjFjxxb> fjxx_query(Map<String, Object> map){
		map.put("id", map.get("fwid"));
		map.put("lybm","SYFW_FWJBXXB");
		return queryForList("ZpfjFjxxb.fjxx_query", map);
	}


	//重构
	/**
	 * queryByjcid查询单个出租房屋检查信息
	 * 
	 * @param id
	 * @return
	 */
	public Czfwjcxxb queryCzfwjcxxById(Czfwjcxxb entity) {
		return (Czfwjcxxb) super.queryForObject("Czfwzb.queryByJcId", entity);
	}


	/**
	 * 新增出租房屋检查信息
	 * @param entity
	 */
	public void saveCzfwjcxx(Czfwjcxxb entity) {
		super.insert("Czfwzb.insertCzfwJcxxInfo", entity);
	}
	/**
	 * 修改出租房屋检查信息
	 * @param entity
	 */
	public void updateCzfwjcxx(Czfwjcxxb entity) {
		super.insert("Czfwzb.updateCzfwjcxx", entity);
	}


	/**
	 * 查询多条出租房屋检查信息
	 * @param map
	 * @return
	 */
	public List<Czfwjcxxb> czfwjcxx_query(Map<String, Object> map){
		return queryForList("Czfwzb.czfwjcxx_query",map);
	} 

	/**
	 * 查询出租房屋
	 * @param entity
	 * @return
	 */
	public Czfwxxb queryCzfw(Czfwxxb entity) {
		Map<String,String> map = new HashMap<String,String>();
		map.put("fwid", entity.getFwid());
		return (Czfwxxb) super.queryForObject("Czfwxxb.czfwxxb_query", map);
	}

	/**
	 * 查询承租情况登记信息
	 * @param entity
	 * @return
	 */
	public FwCzqkdjxxb queryCzqk(FwCzqkdjxxb entity) {
		return (FwCzqkdjxxb) super.queryForObject("Czfwzb.queryByczId", entity);
	}

	/**
	 * 新增承租情况登记信息
	 * @param entity
	 */
	public void saveCzqkdjxx(FwCzqkdjxxb entity) {
		super.insert("Czfwzb.insertCzqk", entity);
	}

	/**
	 * 修改承租情况登记信息
	 * @param entity
	 */
	public void updateCzqkdjxx(FwCzqkdjxxb entity) {
		super.insert("Czfwzb.updateCzqkdjxx", entity);
	}

	/**
	 * 查询承租情况登记信息
	 * @param map
	 * @return
	 */
	public List<FwCzqkdjxxb> czqkdjxx_query(Map<String, Object> map){
		return queryForList("Czfwzb.czqkdjxx_query",map);
	} 

	/**
	 * 
	 * @Title: getCountRkjzdzzb
	 * @Description: TODO(通过人员ID和所属责任区代码查询本辖区这个人的数量)
	 * @param @param ryid
	 * @param @param sszrqdm
	 * @param @return    设定文件
	 * @return int    返回类型
	 * @throws
	 */
	public int getCountRkjzdzzb(String ryid, String sszrqdm){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ryid", ryid);
		map.put("gxzrqdm", sszrqdm);
		int returnValue=(Integer)queryForObject("Fwjbxxb.getCountRkjzdzzb", map);
		return returnValue;
	}

	public List<String> zpxx_query(Map<String, Object> map) {
		map.put("id", map.get("fwid"));
		map.put("lybm","SYFW_FWJBXXB");
		return queryForList("ZpfjFjxxb.zpxx_query", map);
	}

	/**
	 * 
	 * @Title: queryJzdzidByRyidAndZrqdm
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param czr_ryid
	 * @param @param gxzrqdm
	 * @param @return    设定文件
	 * @return boolean    返回类型
	 * @throws
	 */
	public List<String> queryJzdzidByRyidAndZrqdm(String czr_ryid, String gxzrqdm) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ryid", czr_ryid);
		map.put("gxzrqdm",gxzrqdm);
		return queryForList("SyrkSyrkxxzb.queryJzdzidByRyidAndZrqdm",map);
	}

}
