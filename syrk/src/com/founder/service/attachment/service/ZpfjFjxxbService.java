package com.founder.service.attachment.service;

import java.util.List;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.founder.framework.annotation.MethodAnnotation;
import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.annotation.MethodAnnotation.logType;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.EasyUIPage;
import com.founder.service.attachment.bean.ZpfjFjxxb;
import com.founder.service.attachment.bean.ZpfjFjxzjlb;

@TypeAnnotation("附件照片管理")
public interface ZpfjFjxxbService {

	/**
	 * 查询列表<br>
	 * 
	 * @param page
	 * @param entity
	 * @return
	 */
	public EasyUIPage queryList(EasyUIPage page, ZpfjFjxxb entity);

	/**
	 * 查询单条<br>
	 * 
	 * @param entity
	 * @return
	 */
	public ZpfjFjxxb queryZpfjFjxxbById(String id);

	/**
	 * 新增<br>
	 * 
	 * @param entity
	 */
	@MethodAnnotation(value = "新增", type = logType.insert)
	public void saveZpfjFjxxb(List<ZpfjFjxxb> list, SessionBean sessionBean);

	/**
	 * 更新<br>
	 * 
	 * @param entity
	 */
	@MethodAnnotation(value = "更新", type = logType.insert)
	public void updateZpfjFjxxb(ZpfjFjxxb entity, SessionBean sessionBean);

	/**
	 * 删除<br>
	 * 
	 * @param entity
	 */
	@MethodAnnotation(value = "注销", type = logType.delete)
	public void deleteZpfjFjxxb(ZpfjFjxxb entity, SessionBean sessionBean);

	/**
	 * 下载单条<br>
	 * 
	 * @param entity
	 * @return
	 */
	public ZpfjFjxxb downloadZpfjFjxxbById(String id, SessionBean sessionBean);

	/**
	 * 新增下载记录 <br>
	 * 
	 * @param ZpfjFjxxb
	 */
	public void saveZpfjFjxzjlb(ZpfjFjxzjlb entity, SessionBean sessionBean);

	/**
	 * 
	 * @Title: showZpByLyid
	 * @Description: TODO(根据来源ID查询附件照片)
	 * @param @param lyid
	 * @param @return 设定文件
	 * @return ZpfjFjxxb 返回类型
	 * @throws
	 */
	public ZpfjFjxxb showZpByLyid(String lyid);

	/**
	 * 查询附件ID列表，多个时用（如多张图片时控制上一张、下一张显示） <br>
	 * 
	 * @param ZpfjFjxxb
	 */
	public String queryZpfjIdList(String lybm, String lyid);

	/***
	 * 
	 * @Title: saveFj
	 * @Description: 保存多个附件到系统附件表
	 * @author wu_chunhui@founder.com.cn
	 * @param @param sessionBean
	 * @param @param uploadFile
	 * @return void
	 * 
	 * @throws
	 */
	public void saveSystemFj(SessionBean sessionBean,
			CommonsMultipartFile[] uploadFile, String lybm, String lyid,
			String lyms);

}
