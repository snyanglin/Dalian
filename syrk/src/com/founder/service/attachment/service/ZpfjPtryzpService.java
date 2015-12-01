package com.founder.service.attachment.service;

import java.util.List;

import com.founder.framework.annotation.MethodAnnotation;
import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.annotation.MethodAnnotation.logType;
import com.founder.framework.base.entity.SessionBean;
import com.founder.service.attachment.bean.ZpfjPtryzpglb;
import com.founder.service.attachment.bean.ZpfjPtryzpxxb;

@TypeAnnotation("普通人员照片管理")
public interface ZpfjPtryzpService {

	/**
	 * 统计人员照片<br>
	 * 
	 * @param entity
	 * @return
	 */
	public long queryPtryzpCount(ZpfjPtryzpglb entity);

	/**
	 * 查询人员最新的一张照片<br>
	 * 
	 * @param entity
	 * @return
	 */
	public ZpfjPtryzpxxb queryPtryzpSingle(ZpfjPtryzpglb entity);
	
	

	/**
	 * 查询人员查询人员的多张照片<br>
	 * 
	 * @param entity
	 * @return
	 */
	public List<ZpfjPtryzpxxb> queryPtryzpList(ZpfjPtryzpglb entity);

	/**
	 * 查询人员最新的一张照片缩略图<br>
	 * 
	 * @param entity
	 * @return
	 */
	public ZpfjPtryzpxxb queryPtryzpsltSingle(ZpfjPtryzpglb entity);

	/**
	 * 查询人员查询人员的多张照片缩略图<br>
	 * 
	 * @param entity
	 * @return
	 */
	public List<ZpfjPtryzpxxb> queryPtryzpsltList(ZpfjPtryzpglb entity);

	/**
	 * 新增照片关联表<br>
	 * 
	 * @param zpfjPtryzpglb
	 */
	@MethodAnnotation(value = "新增", type = logType.insert)
	public void savePtryzpglb(ZpfjPtryzpglb entity, SessionBean sessionBean);

	/**
	 * 新增照片信息与照片关联表<br>
	 * 
	 * @param zpfjPtryzpglb
	 */
	@MethodAnnotation(value = "新增", type = logType.insert)
	public void savePtryzpxxb(ZpfjPtryzpglb zpfjPtryzpglb,
			ZpfjPtryzpxxb zpfjPtryzpxxb, SessionBean sessionBean);

	/**
	 * 注销照片关联表<br>
	 * 
	 * @param entity
	 */
	@MethodAnnotation(value = "注销", type = logType.delete)
	public void deletePtryzpglb(ZpfjPtryzpglb entity, SessionBean sessionBean);
	
	/**
	 * 根据照片id查询照片<br>
	 * 
	 * @param entity
	 * @return
	 */
	public ZpfjPtryzpxxb queryZpById(String id);

}
