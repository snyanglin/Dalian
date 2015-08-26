package com.founder.sqjw.service;
import java.util.List;

import com.founder.framework.utils.EasyUIPage;
import com.founder.sqjw.vo.MainVo;
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
}