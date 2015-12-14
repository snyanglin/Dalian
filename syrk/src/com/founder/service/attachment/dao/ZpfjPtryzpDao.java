package com.founder.service.attachment.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.base.entity.SessionBean;
import com.founder.service.attachment.bean.ZpfjPtryzpglb;
import com.founder.service.attachment.bean.ZpfjPtryzpxxb;

@Repository("zpfjPtryzpDao")
public class ZpfjPtryzpDao extends BaseDaoImpl {

	/**
	 * 统计人员照片<br>
	 * 
	 * @param entity
	 * @return
	 */
	public long queryPtryzpCount(ZpfjPtryzpglb entity) {
		long returnValue = 0;
		returnValue = (Integer) queryForObject("ZpfjPtryzp.queryPtryzpCount",
				entity);
		return returnValue;
	}

	/**
	 * 查询人员最新的一张照片<br>
	 * 
	 * @param entity
	 * @return
	 */
	public ZpfjPtryzpxxb queryPtryzpSingle(ZpfjPtryzpglb entity) {
		return (ZpfjPtryzpxxb) queryForObject("ZpfjPtryzp.queryPtryzpSingle",
				entity);
	}

	/**
	 * 查询人员查询人员的多张照片<br>
	 * 
	 * @param entity
	 * @return
	 */
	public List<ZpfjPtryzpxxb> queryPtryzpList(ZpfjPtryzpglb entity) {
		return queryForList("ZpfjPtryzp.queryPtryzpList", entity);
	}

	/**
	 * 查询人员最新的一张照片缩略图<br>
	 * 
	 * @param entity
	 * @return
	 */
	public ZpfjPtryzpxxb queryPtryzpsltSingle(ZpfjPtryzpglb entity) {
		return (ZpfjPtryzpxxb) queryForObject(
				"ZpfjPtryzp.queryPtryzpsltSingle", entity);
	}

	/**
	 * 查询人员查询人员的多张照片缩略图<br>
	 * 
	 * @param entity
	 * @return
	 */
	public List<ZpfjPtryzpxxb> queryPtryzpsltList(ZpfjPtryzpglb entity) {
		return queryForList("ZpfjPtryzp.queryPtryzpsltList", entity);
	}

	/**
	 * 新增照片关联表<br>
	 * 
	 * @param zpfjPtryzpglb
	 */
	public void savePtryzpglb(ZpfjPtryzpglb entity, SessionBean sessionBean) {
		insert("ZpfjPtryzp.savePtryzpglb", entity);
	}

	/**
	 * 新增照片信息表<br>
	 * 
	 * @param zpfjPtryzpglb
	 */
	public void savePtryzpxxb(ZpfjPtryzpxxb entity, SessionBean sessionBean) {
		insert("ZpfjPtryzp.savePtryzpxxb", entity);
	}

	/**
	 * 注销照片关联表<br>
	 * 
	 * @param entity
	 */
	public void deletePtryzpglb(ZpfjPtryzpglb entity, SessionBean sessionBean) {
		update("ZpfjPtryzp.deletePtryzpglb", entity);
	}
	
	/**
	 * 根据照片id查询照片<br>
	 * 
	 * @param entity
	 * @return
	 */
	public ZpfjPtryzpxxb queryZpById(String	 id) {
		return (ZpfjPtryzpxxb) queryForObject("ZpfjPtryzp.queryZpById",
				id);
	}

}
