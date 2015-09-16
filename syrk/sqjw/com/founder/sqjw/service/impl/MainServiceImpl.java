package com.founder.sqjw.service.impl;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.utils.EasyUIPage;
import com.founder.sqjw.dao.MainDao;
import com.founder.sqjw.service.MainService;
import com.founder.sqjw.vo.CountMapVO;
import com.founder.sqjw.vo.MainVo;
import com.founder.syfw.vo.SyfwListVo;
import com.founder.syrkgl.bean.SyrkSyrkxxzb;
/**
 * @类名: MainServiceImpl 
 * @描述: 主页ServiceImpl
 * @作者: zhang_guoliang@founder.com 
 * @日期: 2015-8-14 下午6:22:26
 */
@Transactional
@Service("mainService")
public class MainServiceImpl implements MainService{
	@Resource(name = "mainDao")
	private MainDao mainDao;
    /**
     * @Title: queryPcsXqgkTj 
     * @Description: 查询派出所辖区概况统计
     * @author zhang_guoliang@founder.com 
     * @param 传入参数定义 
     * @throws
     */
	public EasyUIPage queryPcsXqgkTj(EasyUIPage page,MainVo entity) {
		return mainDao.queryPcsXqgkTj(page,entity);
	}
	/**
	 * @Title: queryPcsXqgkXq 
	 * @Description: 查询派出所辖区概况详情
	 * @author zhang_guoliang@founder.com 
	 * @param 传入参数定义 
	 * @throws
	 */
	public List<MainVo> queryPcsXqgkXq(MainVo entity) {
		return mainDao.queryPcsXqgkXq(entity);
	}
	@Override
	public List<SyfwListVo> queryListczf(Map<String, String> param) {
		// TODO Auto-generated method stub
		return mainDao.queryListczf(param);
	}
	@Override
	public List<SyfwListVo> queryListcheckczf(Map<String, String> param) {
		// TODO Auto-generated method stub
		return mainDao.queryListcheckczf(param);
	}
	@Override
	public List<SyfwListVo> queryListuncheckczf(Map<String, String> param) {
		// TODO Auto-generated method stub
		return mainDao.queryListuncheckczf(param);
	}
	@Override
	public List<CountMapVO> queryListzdry(Map<String, String> param) {
		// TODO Auto-generated method stub
		return mainDao.queryListzdry(param);
	}
	@Override
	public List<SyrkSyrkxxzb> queryListByRyidYwlx(SyrkSyrkxxzb entity) {
		// TODO Auto-generated method stub
		return mainDao.queryListByRyidYwlx(entity);
	}
}