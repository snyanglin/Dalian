package com.founder.syrkgl.dao;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.syrkgl.bean.Jzzblxxb;

@Repository("jzzblxxbDao")
public class JzzblxxbDao extends BaseDaoImpl {
	
	
	
	//居住证重构部分开始
	  
	
	
	/**
	 * 
	 * @Title: saveJzzblxx
	 * @Description: TODO(保存居住证办理信息)
	 * @param @param entity    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public void saveJzzblxx(Jzzblxxb entity){
		insert("Jzzblxxb.save", entity);
	}
	
	
	/**
	 * 
	 * @Title: queryJzzblxxList
	 * @Description: TODO(通过)
	 * @param @param ryid
	 * @param @return    设定文件
	 * @return List<Jzzblxxb>    返回类型
	 * @throws
	 */
	public List<Jzzblxxb> queryJzzblxxList(String syrkid) {
		return queryForList("Jzzblxxb.queryJzzblxxList", syrkid);
	}
	/**
	 * 
	 * @Title: queryJzzblxxb
	 * @Description: TODO(通过ID查询居住证办理信息)
	 * @param @param id
	 * @param @return    设定文件
	 * @return Jzzblxxb    返回类型
	 * @throws
	 */
	public Jzzblxxb queryJzzblxxb(String  id) {
		return(Jzzblxxb) super.queryForObject("Jzzblxxb.queryJzzblxxb",id);
	}
	
	public Jzzblxxb queryJzzblxxbIgnoreXt_zxbz(String id) {
		return(Jzzblxxb) super.queryForObject("Jzzblxxb.queryJzzblxxbIgnoreXt_zxbz",id);
	}
	
	
	/**
	 * 
	 * @Title: queryJzzblList
	 * @Description: TODO(居住证列表查询)
	 * @param @param page
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	public EasyUIPage queryJzzblList(EasyUIPage page, Jzzblxxb entity) {
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
		if(StringUtils.isBlank(entity.getXt_zxbz())){//防止其他列表页面出错
			entity.setXt_zxbz("0");
		}
		map.put("jzzblxxb", entity);
		page.setTotal((Integer) queryForObject("Jzzblxxb.queryZzCount", map));
		List<Jzzblxxb> list =queryForList("Jzzblxxb.queryZzList", map);
		page.setRows(list);
		return page;
	}
	
	
	public List<Jzzblxxb> queryJzzblList(Jzzblxxb entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		if(StringUtils.isBlank(entity.getXt_zxbz())){//防止其他列表页面出错
			entity.setXt_zxbz("0");
		}
		map.put("jzzblxxb", entity);
		List<Jzzblxxb> list =(List<Jzzblxxb>)queryForList("Jzzblxxb.queryList", map);
		return list;
	}
	
	
	
	/**
	 * 查询最新已办理居住证信息
	 * @param ryid
	 * @return
	 */
	public Jzzblxxb queryLastYblJzzblxxByRyid(String ryid){
		return (Jzzblxxb)queryForObject("Jzzblxxb.queryLastYblJzzblxxByRyid", ryid);
	}
	
	/**
	 * 
	 * @Title: updateJzzblxxb
	 * @Description: TODO(修改居住证信息)
	 * @param @param entity
	 * @param @param sessionBean    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public void updateJzzblxxb(Jzzblxxb entity) {
		update("Jzzblxxb.updateJzzblxxb",entity);
	}
	
	//居住证重构部分结束
	
	/**
	 * @Title: queryDyBhSequence
	 * @Description:查询打印编号（居住证办理）。<br>每次查询后，DB中的Sequence会自动+1
	 * @Author:       [guo_tianlin@founder.com.cn]  
	 * @return: 返回类型
	 */
	public Long queryDyBhSequence(){
		return (Long) queryForObject("Jzzblxxb.queryDyBhSequence", null);
	}
	
	/**
	 * @Title: queryJzzBhSequence
	 * @Description:查询居住证编号（居住证办理）。<br>每次查询后，DB中的Sequence会自动+1
	 * @Author:       [guo_tianlin@founder.com.cn]  
	 * @return: 返回类型
	 */
	public Long queryJzzBhSequence(){
		return (Long) queryForObject("Jzzblxxb.queryJzzBhSequence", null);
	}
	
	/***
	 * 
	 * @Title: queryJzzblxxbByIds
	 * @Description: TODO(新增居住证批量导出)
	 * @Author:       [wu_chunhui@founder.com.cn]  
	 * @param @param ids
	 * @param @return    设定文件
	 * @return List<Jzzblxxb>    返回类型
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	public List<Jzzblxxb> queryJzzblxxbByIds(String ids){
		return queryForList("Jzzblxxb.queryJzzblxxbByIds",ids.split(","));
	}
	/***
	 * 
	 * @Title: queryMaxDybhJzzblxxb
	 * @Description: TODO(查询最大打印编号流水号)
	 * @param @return    设定文件
	 * @return Jzzblxxb    返回类型
	 * @throws
	 */
	public Jzzblxxb queryMaxDybhJzzblxxb(){
		return (Jzzblxxb)queryForObject("Jzzblxxb.queryMaxDybhJzzblxxb", "");
	}
	/***
	 * 
	 * @Title: queryMaxDybhJzzblxxb
	 * @Description: TODO(查询最大居住证流水号)
	 * @param @return    设定文件
	 * @return Jzzblxxb    返回类型
	 * @throws
	 */
	public Jzzblxxb queryMaxJzzbhJzzblxxb(){
		return (Jzzblxxb)queryForObject("Jzzblxxb.queryMaxJzzbhJzzblxxb", "");
	}
	
	/***
	 * 
	 * @Title: checkRyJzz
	 * @Description: TODO(查询此人在居住证内是否有有效期的申请和证件)
	 * @param @param ryid
	 * @param @return    设定文件
	 * @return int    返回类型
	 * @throws
	 */
	public Jzzblxxb checkRyJzz(String ryid){
		return (Jzzblxxb)queryForObject("Jzzblxxb.queryJzzblxxbByryidAndDate", ryid);
	}
	
	public Jzzblxxb queryJzzblxxbByJzd_dzxzAndSyrkid(String jzd_dzxz,String syrkid){
		Map<String,String> map = new HashMap<String, String>();
		map.put("jzd_dzxz", jzd_dzxz);
		map.put("syrkid", syrkid);
		return (Jzzblxxb)queryForObject("Jzzblxxb.queryJzzblxxbByJzd_dzxzAndSyrkid", map);
	}

	/***
	 * 
	 * @Title: queryIdsForPrint
	 * @Description: TODO(根据打印需求取得所有ID)
	 * @param @param ryid
	 * @param @return    设定文件
	 * @return int    返回类型
	 * @throws
	 */
	public List<Jzzblxxb> queryIdsForPrint(Jzzblxxb entity){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("jzzblxxb", entity);
		return (List<Jzzblxxb>)queryForList("Jzzblxxb.queryIdsForPrint", map);
	}
	
}
