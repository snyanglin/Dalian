package com.founder.sqjw.dao;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.utils.EasyUIPage;
import com.founder.sqjw.vo.CountMapVO;
import com.founder.sqjw.vo.MainVo;
import com.founder.sqjw.vo.ZdryCountVo;
import com.founder.sqjw.vo.ZzjgVo;
import com.founder.syfw.vo.SyfwListVo;
import com.founder.syrkgl.bean.SyrkSyrkxxzb;
/**
 * @类名: MainDao 
 * @描述: 主页Dao
 * @作者: zhang_guoliang@founder.com 
 * @日期: 2015-8-14 下午6:23:41
 */
@Repository("mainDao")
public class MainDao extends BaseDaoImpl{
	/**
	 * @Title: queryPcsXqgkTj 
	 * @描述: 查询派出所辖区概况统计
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @返回值: EasyUIPage    返回类型 
	 * @throws
	 */
	public EasyUIPage queryPcsXqgkTj(EasyUIPage page,MainVo entity) {
		page.setRows(queryForList("Main.queryPcsXqgkTj", entity));
		return page;
	}
	/**
	 * @Title: queryPcsXqgkXq 
	 * @描述: 查询派出所辖区概况详情
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @返回值: List<MainVo>    返回类型 
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	public List<MainVo> queryPcsXqgkXq(MainVo entity) {
		return queryForList("Main.queryPcsXqgkXq", entity);
	}
	@SuppressWarnings("unchecked")
	public List<SyfwListVo> queryListczf(Map<String, String> param) {
		// TODO Auto-generated method stub
		return queryForList("Main.queryListczf", param);
	}
	public List<SyfwListVo> queryListcheckczf(Map<String, String> param) {
		// TODO Auto-generated method stub
		return queryForList("Main.queryListcheckczf", param);
	}
	public List<SyfwListVo> queryListuncheckczf(Map<String, String> param) {
		// TODO Auto-generated method stub
		return queryForList("Main.queryListuncheckczf", param);
	}
	public List<CountMapVO> queryListzdry(Map<String, String> param) {
		// TODO Auto-generated method stub
		return queryForList("Main.queryListzdry", param);
	}
	public List<SyrkSyrkxxzb> queryListByRyidYwlx(SyrkSyrkxxzb entity) {
		// TODO Auto-generated method stub
		return queryForList("Main.queryListByRyidYwlx", entity);
	}
	public List<ZzjgVo> queryPcsTj(Map<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return queryForList("Main.queryPcsTj", paramMap);
	}
	public List<ZdryCountVo> queryZdryTj(Map<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return  queryForList("Main.queryZdryTj", paramMap);
	}
	public long queryCzfTj(Map<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return (long) queryForObject("Main.queryCzfTj", paramMap);
	}
	public long queryCheckTj(Map<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return (long) queryForObject("Main.queryCheckTj", paramMap);
	}
	public List<ZdryCountVo> queryDwtj(Map<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return  queryForList("Main.queryDwtj", paramMap);
	}
	public List<CountMapVO> queryListMap(Map<String, String> param) {
		// TODO Auto-generated method stub
		return queryForList("Main.queryListMapsyrk", param);
	}
	public long querySyfwTj(Map<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return (long) queryForObject("Main.querySyfwTj", paramMap);
	}
}