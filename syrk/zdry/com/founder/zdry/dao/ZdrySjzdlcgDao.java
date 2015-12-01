/**********************************************************************   
 * <p>文件名：SjzdlcgDao.java </p>
 * <p>文件描述：上级指定列撤管
 * @project_name：syrk_1
 * @author xu_wenjun@founder.com.cn 
 * @date 2015-1-28 上午09:55:11 
 * @history
 * @department：研发部
 *
*/

package com.founder.zdry.dao;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.founder.syrkgl.dao.RyRyjbxxbDao;
import org.springframework.stereotype.Repository;
import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.syrkgl.bean.RyRyjbxxb;
import com.founder.zdry.bean.Sjzdlcg;
import com.founder.zdry.bean.ZdryZdryzb;

@Repository("zdrySjzdlcgDao")
public class ZdrySjzdlcgDao extends BaseDaoImpl {
	
	/**
	 * 
	 * @Title: queryLgZdryzdlb
	 * @Description: 上级指定列管   人员列表
	 * @param @param page
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	public EasyUIPage queryLgZdryzdlb(EasyUIPage page, RyRyjbxxb entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("begin", page.getBegin());
		map.put("end", page.getEnd());
		map.put("entity", entity);
		String sort = page.getSort();
		String order = page.getOrder();
		if (!StringUtils.isBlank(sort)) {
			map.put("sort", sort);
			map.put("order", order);
		}
		page.setTotal((Integer) queryForObject("ZdrySjzdlcg.queryLgZdryzdlbCount", map));
		page.setRows(queryForList("ZdrySjzdlcg.queryLgZdryzdlb", map));
		return page;
	}
	
	/**
	 * 
	 * @Title: queryCgZdryzdlb
	 * @Description: 上级指定撤管  人员列表
	 * @param @param page
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	public EasyUIPage queryCgZdryzdlb(EasyUIPage page, ZdryZdryzb entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("begin", page.getBegin());
		map.put("end", page.getEnd());
		map.put("entity", entity);
		String sort = page.getSort();
		String order = page.getOrder();
		if (!StringUtils.isBlank(sort)) {
			map.put("sort", sort);
			map.put("order", order);
		}
		page.setTotal((Integer) queryForObject("ZdrySjzdlcg.queryCgZdryzdlbCount", map));
		page.setRows(queryForList("ZdrySjzdlcg.queryCgZdryzdlb", map));
		return page;
	}
	
	/**
	 * 
	 * @Title: querySubList
	 * @Description: 重点人员指定列表二级列表查询
	 * @param @param ryid
	 * @param @return    设定文件
	 * @return List<Sjzdlcg>    返回类型
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	public List<ZdryZdryzb> querySubList(ZdryZdryzb entity){
		return (List<ZdryZdryzb>) queryForList("ZdrySjzdlcg.querySubList", entity);
	}
	
	/**
	 * 
	 * @Title: queryHjdzByRyid
	 * @Description: 根据人员id查询户籍地址
	 * @param @param ryid
	 * @param @return    设定文件
	 * @return List<Map<String,String>>    返回类型
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	public Map<String, String> queryHjdzByRyid(String ryid){
		return (Map<String, String>) queryForObject("ZdrySjzdlcg.queryHjdzByRyid", ryid);
	}
	
	/**
	 * 
	 * @Title: queryJzdzByRyid
	 * @Description: 根据人员id查询居住地址(不包括户籍地址)
	 * @param @param ryid
	 * @param @return    设定文件
	 * @return List<Map<String,String>>    返回类型
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	public List<Map<String, String>> queryJzdzByRyid(String ryid){
		return (List<Map<String, String>>) queryForList("ZdrySjzdlcg.queryJzdzByRyid", ryid);
	}
	
	/**
	 * 
	 * @Title: queryZdrylb
	 * @Description: 获取已列管重点人员类别
	 * @param @param ryid
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	public String queryZdrylb(String ryid){
		Object result = queryForObject("ZdrySjzdlcg.queryZdrylbLg", ryid);
		if(result != null){
			return result.toString();
		}else{
			return "未被列管为重点人员";
		}
	}
	
	@SuppressWarnings("unchecked")
	public Map<String, String> queryCgDzBySyrkid(String syrkid){
		List<Map<String, String>> list = queryForList("ZdrySjzdlcg.queryCgDzBySyrkid", syrkid);
		if(list != null && list.size() > 0){
			return list.get(0);
		}
		return null;
	}
	
	public String queryLcgidForCg(Sjzdlcg entity){
		Object result = queryForObject("ZdrySjzdlcg.queryLcgidForCg", entity);
		if(result != null){
			return result.toString();
		}else{
			return "";
		}
	}
	
	public String queryZdrylxdmByZdrylbdm(String zdrylbdm){
		Object result = queryForObject("ZdrySjzdlcg.queryZdrylxdmByZdrylbdm", zdrylbdm).toString();
		if(result != null){
			return result.toString();
		}else{
			return "";
		}
	}
	
}
