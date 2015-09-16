package com.founder.sqjw.service;
import java.util.List;
import java.util.Map;

import com.founder.framework.utils.EasyUIPage;
import com.founder.sqjw.vo.CountMapVO;
import com.founder.sqjw.vo.MainVo;
import com.founder.syfw.vo.SyfwListVo;
import com.founder.syrkgl.bean.SyrkSyrkxxzb;
/**
 * @类名: MainService 
 * @描述: 主页Service
 * @作者: zhang_guoliang@founder.com 
 * @日期: 2015-8-14 下午6:21:55
 */
public interface MainService {
	/**
	 * @Title: queryPcsXqgkTj
	 * @描述: 查询派出所辖区概况统计
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @返回值: EasyUIPage    返回类型 
	 * @throws
	 */
	public EasyUIPage queryPcsXqgkTj(EasyUIPage page,MainVo entity);
	/**
	 * @Title: queryPcsXqgkXq 
	 * @描述: 查询派出所辖区概况详情
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @返回值: List<MainVo>    返回类型 
	 * @throws
	 */
	public List<MainVo> queryPcsXqgkXq(MainVo entity);
	public List<SyfwListVo> queryListczf(Map<String, String> param);
	public List<SyfwListVo> queryListcheckczf(Map<String, String> param);
	public List<SyfwListVo> queryListuncheckczf(Map<String, String> param);
	public List<CountMapVO> queryListzdry(Map<String, String> param);
	public List<SyrkSyrkxxzb> queryListByRyidYwlx(SyrkSyrkxxzb entity);
}