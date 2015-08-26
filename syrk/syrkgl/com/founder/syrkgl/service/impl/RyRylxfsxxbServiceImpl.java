package com.founder.syrkgl.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.UUID;
import com.founder.syrkgl.bean.RyRylxfsxxb;
import com.founder.syrkgl.dao.RyRylxfsxxbDao;
import com.founder.syrkgl.service.RyRylxfsxxbService;

/**
 * ****************************************************************************
 * @Package:      [com.founder.syrkgl.service.impl.RyRylxfsxxbServiceImpl.java]  
 * @ClassName:    [RyRylxfsxxbServiceImpl]   
 * @Description:  [实有人口附加信息-人员联系方式信息表]  
 * @Author:       [xu_wenjun@founder.com.cn]  
 * @CreateDate:   [2015-4-7 下午7:49:37]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-4-7 下午7:49:37，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Service("ryRylxfsxxbService")
@Transactional
public class RyRylxfsxxbServiceImpl implements RyRylxfsxxbService {

	@Resource(name = "ryRylxfsxxbDao")
	private RyRylxfsxxbDao ryRylxfsxxbDao;

	/**
	 * @Title: queryById
	 * @Description: TODO(根据ID查询单条记录)
	 * @param @param id
	 * @param @return 设定文件
	 * @return RyRylxfsxxb 返回类型
	 * @throws
	 */
	public RyRylxfsxxb queryById(String id) {
		return ryRylxfsxxbDao.queryById(id);
	}

	/**
	 * 新增<br>
	 * 
	 * @param entity
	 */
	public void save(RyRylxfsxxb entity, SessionBean sessionBean) {
		entity.setId(UUID.create()); // 生成主键
		BaseService.setSaveProperties(entity, sessionBean);
		ryRylxfsxxbDao.save(entity, sessionBean);
	}

	/**
	 * 更新<br>
	 * 
	 * @param entity
	 */
	public void update(RyRylxfsxxb entity, SessionBean sessionBean) {
		BaseService.setUpdateProperties(entity, sessionBean);
		ryRylxfsxxbDao.update(entity, sessionBean);
	}

	/**
	 * 删除<br>
	 * 
	 * @param entity
	 */
	public void delete(RyRylxfsxxb entity, SessionBean sessionBean) {
		BaseService.setCrossoutProperties(entity, sessionBean);
		ryRylxfsxxbDao.delete(entity, sessionBean);
	}

	/**
	 * @Title: queryCount
	 * @Description: TODO(根据条件查询记录数)
	 * @param @param entity
	 * @param @return 设定文件
	 * @return Integer 返回类型
	 * @throws
	 */
	@Override
	public Integer queryCount(RyRylxfsxxb entity) {
		return ryRylxfsxxbDao.queryCount(entity);
	}

	/**
	 * 查询最新联系方式
	 */
	@Override
	public String queryLastLxfs(String ryid) {
		return ryRylxfsxxbDao.queryLastLxfs(ryid);
	}

	/**
	 * 不存在则保存，否则返回
	 */
	@Override
	public void saveLxdh(String ryid, String lxfs, SessionBean sessionBean) {
		RyRylxfsxxb entity = new RyRylxfsxxb();
		entity.setRyid(ryid);
		entity.setLxfs(lxfs);
		entity.setLxfslxdm("1");
		int count = ryRylxfsxxbDao.queryCount(entity);
		if(count > 0){
			return;
		}else{
			save(entity, sessionBean);
		}
	}

	/**
	 * 验证联系方式是否与其他人重复(返回对象RyRylxfsxxb.getXm() ！= "" &&　！＝　ｎｕｌｌ 则该联系方式已被此人录入 )
	 */
	@Override
	public RyRylxfsxxb check(String ryid, String lxfs) {
		return ryRylxfsxxbDao.queryLxfsValidLs(ryid, lxfs);
	}

}
