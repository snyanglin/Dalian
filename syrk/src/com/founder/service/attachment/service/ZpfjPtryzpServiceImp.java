package com.founder.service.attachment.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.UUID;
import com.founder.service.attachment.bean.ZpfjPtryzpglb;
import com.founder.service.attachment.bean.ZpfjPtryzpxxb;
import com.founder.service.attachment.dao.ZpfjPtryzpDao;

@Service("zpfjPtryzpService")
@Transactional
public class ZpfjPtryzpServiceImp implements ZpfjPtryzpService {

	@Resource(name = "zpfjPtryzpDao")
	private ZpfjPtryzpDao zpfjPtryzpDao;

	/**
	 * 统计人员照片<br>
	 * 
	 * @param entity
	 * @return
	 */
	public long queryPtryzpCount(ZpfjPtryzpglb entity) {
		return zpfjPtryzpDao.queryPtryzpCount(entity);

	}

	/**
	 * 查询人员最新的一张照片<br>
	 * 
	 * @param entity
	 * @return
	 */
	public ZpfjPtryzpxxb queryPtryzpSingle(ZpfjPtryzpglb entity) {
		return zpfjPtryzpDao.queryPtryzpSingle(entity);
	}

	/**
	 * 查询人员查询人员的多张照片<br>
	 * 
	 * @param entity
	 * @return
	 */
	public List<ZpfjPtryzpxxb> queryPtryzpList(ZpfjPtryzpglb entity) {
		return zpfjPtryzpDao.queryPtryzpList(entity);
	}

	/**
	 * 查询人员最新的一张照片缩略图<br>
	 * 
	 * @param entity
	 * @return
	 */
	public ZpfjPtryzpxxb queryPtryzpsltSingle(ZpfjPtryzpglb entity) {
		return zpfjPtryzpDao.queryPtryzpsltSingle(entity);
	}

	/**
	 * 查询人员查询人员的多张照片缩略图<br>
	 * 
	 * @param entity
	 * @return
	 */
	public List<ZpfjPtryzpxxb> queryPtryzpsltList(ZpfjPtryzpglb entity) {
		return zpfjPtryzpDao.queryPtryzpsltList(entity);
	}

	/**
	 * 新增照片关联表<br>
	 * 
	 * @param zpfjPtryzpglb
	 */
	public void savePtryzpglb(ZpfjPtryzpglb entity, SessionBean sessionBean) {
		entity.setId(UUID.create()); // 生成主键
		BaseService.setSaveProperties(entity, sessionBean);
		zpfjPtryzpDao.savePtryzpglb(entity, sessionBean);
	}

	/**
	 * 新增照片信息与照片关联表<br>
	 * 
	 * @param zpfjPtryzpglb
	 */
	public void savePtryzpxxb(ZpfjPtryzpglb zpfjPtryzpglb,
			ZpfjPtryzpxxb zpfjPtryzpxxb, SessionBean sessionBean) {
		zpfjPtryzpxxb.setId(UUID.create()); // 生成主键
		BaseService.setSaveProperties(zpfjPtryzpxxb, sessionBean);
		zpfjPtryzpDao.savePtryzpxxb(zpfjPtryzpxxb, sessionBean);
		zpfjPtryzpglb.setId(UUID.create()); // 生成主键
		zpfjPtryzpglb.setZpid(zpfjPtryzpxxb.getId());
		BaseService.setSaveProperties(zpfjPtryzpglb, sessionBean);
		zpfjPtryzpDao.savePtryzpglb(zpfjPtryzpglb, sessionBean);
	}

	/**
	 * 注销照片关联表<br>
	 * 
	 * @param entity
	 */
	public void deletePtryzpglb(ZpfjPtryzpglb entity, SessionBean sessionBean) {
		BaseService.setCrossoutProperties(entity, sessionBean);
		zpfjPtryzpDao.deletePtryzpglb(entity, sessionBean);
	}
	
	/**
	 * 根据照片id查询照片<br>
	 * 
	 * @param entity
	 * @return
	 */
	public ZpfjPtryzpxxb queryZpById(String id) {
		return zpfjPtryzpDao.queryZpById(id);
	}


	
}
