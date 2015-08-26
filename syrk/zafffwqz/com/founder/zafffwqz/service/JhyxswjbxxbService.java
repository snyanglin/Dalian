/**********************************************************************   
 * <p>文件名：JhyxswjbxxbService.java </p>
 * <p>文件描述：TODO(集会游行示威service接口) 
 * @project_name：syrk
 * @author tian_chengwei@founder.com.cn 
 * @date 2015-5-18 上午9:57:08 
 * @history
 * @department：研发部
 *
*/
package com.founder.zafffwqz.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.founder.framework.annotation.MethodAnnotation;
import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.annotation.MethodAnnotation.logType;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.EasyUIPage;
import com.founder.zafffwqz.bean.Jhyxswjbxxb;


/******************************************************************************
 * @Package:      [com.founder.zafffwqz.service.JhyxswjbxxbService.java]  
 * @ClassName:    [JhyxswjbxxbService]   
 * @Description:  [服务接口]   
 * @Author:       [tian_chengwei@founder.com.cn]  
 * @CreateDate:   [2015-5-21 下午4:00:11]   
 * @UpdateUser:   [lk(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-5-21 下午4:00:11，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 * 
 * @review      : wu.w@founder.com.cn
 * @reviewDate  : 20150604
 */
@TypeAnnotation("集会游行示威")
public interface JhyxswjbxxbService {
	/**
	 * 
	 * @Title: queryJhyxswjbxxb
	 * @Description: TODO(单条查询基本信息)
	 * @param entity
	 * @return
	 * @return Jhyxswjbxxb返回类型
	 * @throws
	 */
	@MethodAnnotation(value = "集会游行示威查询", type = logType.query)
	public Jhyxswjbxxb queryJhyxswjbxxb(Jhyxswjbxxb entity);
	/**
	 * 
	 * @Title: saveJhyxswjbxxb
	 * @Description: TODO(插入操作)
	 * @param entity
	 * @param sessionBean
	 * @return void返回类型
	 * @throws
	 */
	@MethodAnnotation(value = "新增集会游行示威", type = logType.insert)	
	public void saveJhyxswjbxxb(Jhyxswjbxxb entity,SessionBean sessionBean);
	/**
	 * 
	 * @Title: updateJhyxswjbxxb
	 * @Description: TODO(修改操作)
	 * @param entity
	 * @param sessionBean
	 * @return void返回类型
	 * @throws
	 */
	@MethodAnnotation(value = "修改集会游行示威", type = logType.update)
	public void updateJhyxswjbxxb(Jhyxswjbxxb entity,SessionBean sessionBean);
	/**
	 * 
	 * @Title: delete
	 * @Description: TODO(删除操作)
	 * @param entity
	 * @param sessionBean
	 * @return void返回类型
	 * @throws
	 */
	@MethodAnnotation(value = "删除集会游行示威", type = logType.delete)
	public void delete(Jhyxswjbxxb entity,SessionBean sessionBean);
	/**
	 * 
	 * @Title: queryList
	 * @Description: TODO(分页查询操作)
	 * @param page
	 * @param entity
	 * @return
	 * @return EasyUIPage返回类型
	 * @throws
	 */
	@MethodAnnotation(value = "集会游行示威列表查询")
	public EasyUIPage queryList(EasyUIPage page,Jhyxswjbxxb entity);

}
