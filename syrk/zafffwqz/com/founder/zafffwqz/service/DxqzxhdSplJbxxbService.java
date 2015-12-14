/**********************************************************************   
 * <p>文件名：DxqzxhdSplJbxxbService.java </p>
 * <p>文件描述：TODO(描述该文件做什么) 
 * @project_name：syrk
 * @author wu.w@founder.com.cn 
 * @date 2015-5-15 下午2:53:07 
 * @history
 * @department：研发部
 *
*/
package com.founder.zafffwqz.service;

import com.founder.framework.annotation.MethodAnnotation;
import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.annotation.MethodAnnotation.logType;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.EasyUIPage;
import com.founder.zafffwqz.bean.DxqzxhdSplJbxxb;
import com.founder.zafffwqz.vo.DxqzxhdSplVo;

/******************************************************************************
 * @Package:      [com.founder.zafffwqz.service.DxqzxhdSplJbxxbService.java]  
 * @ClassName:    [DxqzxhdSplJbxxbService]   
 * @Description:  [大型群众审批服务接口]   
 * @Author:       [wu.w@founder.com.cn]  
 * @CreateDate:   [2015-5-15 下午2:53:07]   
 * @UpdateUser:   [way(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-5-15 下午2:53:07，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 * @review      : tian_chengwei@founder.com.cn
 * @reviewDate  : 20150604
 */
@TypeAnnotation("大型群众性活动审批类")
public interface DxqzxhdSplJbxxbService {
	
	/**
	 * @Title: queryList
	 * @Description: 查询大型活动
	 * @param @param page
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	public EasyUIPage queryList(EasyUIPage page,DxqzxhdSplJbxxb entity);
	
	/**
	 * @Title: queryById
	 * @Description: 根据活动id查询大型活动
	 * @param @param hdid
	 * @param @return    设定文件
	 * @return DxqzxhdSplVo    返回类型
	 * @throws
	 */
	public DxqzxhdSplVo queryById(String hdid);
	
	/**
	 * @Title: save
	 * @Description: 新增大型活动信息
	 * @param @param vo
	 * @param @param sessionBean    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	@MethodAnnotation(value = "新增大型群众性活动审批类", type = logType.insert)
	public void saveDxhdSpl(DxqzxhdSplVo vo, SessionBean sessionBean);
	
	/**
	 * @Title: modify
	 * @Description: 修改大型活动信息 
	 * 由于log拦截中的logservice无法解析包含bean的bean，所以对此更新不做记录，等到logservice方法完善后再记录日志
	 * @param @param vo
	 * @param @param sessionBean    设定文件
	 * @return void    返回类型
	 * @throws
	 */
//	@MethodAnnotation(value = "修改大型群众性活动审批类", type = logType.update)
	public void updateDxhdSpl(DxqzxhdSplVo vo, SessionBean sessionBean);
	
	/**
	 * @Title: delete
	 * @Description: 注销大型活动信息
	 * @param @param hdid
	 * @param @param sessionBean    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	@MethodAnnotation(value = "删除大型群众性活动审批类", type = logType.delete)
	public void deleteDxhdSpl(String hdid, SessionBean sessionBean);
	
	/**
	 * @Title: isExist
	 * @Description: 判断该活动id的大型活动是否存在
	 * @param @param hdid
	 * @param @return    设定文件
	 * @return boolean    返回类型
	 * @throws
	 */
	public boolean isExist(String hdid);
}
