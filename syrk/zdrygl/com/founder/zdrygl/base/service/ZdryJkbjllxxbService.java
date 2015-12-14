package com.founder.zdrygl.base.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.DateUtils;
import com.founder.framework.utils.UUID;
import com.founder.zdrygl.base.dao.ZdryJkbjllxxbDao;
import com.founder.zdrygl.base.dao.ZdryZdryZbDao;
import com.founder.zdrygl.base.model.ZdryJkbjllxxb;
import com.founder.zdrygl.base.model.ZdryZb;



/**
* ****************************************************************************
* @Package:      [com.founder.zdrygl.service.ZdryJkbjllxxbService.java]  
* @ClassName:    [ZdryJkbjllxxbService]   
* @Description:  [监控帮教力量 服务类]   
* @Author:       [zhang.hai@founder.com.cn]  
* @CreateDate:   [2015年9月6日 下午3:29:01]   
* @UpdateUser:   [ZhangHai(如多次修改保留历史记录，增加修改记录)]   
* @UpdateDate:   [2015年9月6日 下午3:29:01，(如多次修改保留历史记录，增加修改记录)]   
* @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
* @Version:      [v1.0]
*/
@Service("zdryJkbjllxxbService")
@Transactional
public class ZdryJkbjllxxbService extends BaseService {

	@Resource(name = "zdryJkbjllxxbDao")
	private ZdryJkbjllxxbDao zdryJkbjllxxbDao;	
	@Resource(name="ZdryZdryZbDao")
	private ZdryZdryZbDao zdryZdryZbDao;

	/**
	 * @Title: queryById
	 * @Description: TODO(根据ID查询单条记录)
	 * @param @param id
	 * @param @return 设定文件
	 * @return ZdryJkbjllxxb 返回类型
	 * @throws
	 */	
	public ZdryJkbjllxxb queryById(String id) {
		return zdryJkbjllxxbDao.queryById(id);
	}

	
	public void save(ZdryJkbjllxxb entity, SessionBean sessionBean) {
		entity.setId(UUID.create()); // 生成主键
		BaseService.setSaveProperties(entity, sessionBean);
		zdryJkbjllxxbDao.save(entity);
	}

	
	public void update(ZdryJkbjllxxb entity, SessionBean sessionBean) {
		BaseService.setUpdateProperties(entity, sessionBean);
		zdryJkbjllxxbDao.update(entity, sessionBean);
	}	
	
	/**
	 * 
	 * @Title: saveFirst
	 * @Description: TODO(重点人员列管成功后，将录入员添加为 第一个帮教力量 相关人员)
	 * @param @param zdryId    设定文件
	 * @return void    返回类型
	 * @throws
	 *
	*/
	public void saveFirst(String zdryId){
		ZdryZb zdryZdryzb=(ZdryZb) zdryZdryZbDao.queryById(zdryId);		
		
		String systemDateTime = DateUtils.getSystemDateTimeString();
		
		ZdryJkbjllxxb entity = new ZdryJkbjllxxb();
		entity.setId(UUID.create()); // 生成主键
		entity.setJkbjry_xm(zdryZdryzb.getXt_lrrxm());
		entity.setJkbjry_gmsfhm(zdryZdryzb.getXt_lrrid());
		entity.setZdryid(zdryId);
		
		entity.setXt_cjsj(systemDateTime);
		entity.setXt_lrsj(systemDateTime);	
		entity.setXt_zxbz("0");
		entity.setXt_lrrxm("System");
		zdryJkbjllxxbDao.save(entity);
	}
}
