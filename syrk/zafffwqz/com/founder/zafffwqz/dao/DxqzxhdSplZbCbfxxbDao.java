/**********************************************************************   
 * <p>文件名：DxqzxhdSplZbCbfxxbDao.java </p>
 * <p>文件描述：TODO(描述该文件做什么) 
 * @project_name：syrk
 * @author wu.w@founder.com.cn 
 * @date 2015-5-15 下午2:44:12 
 * @history
 * @department：研发部
 *
*/
package com.founder.zafffwqz.dao;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.zafffwqz.bean.DxqzxhdSplZbCbfxxb;

/******************************************************************************
 * @Package:      [com.founder.zafffwqz.dao.DxqzxhdSplZbCbfxxbDao.java]  
 * @ClassName:    [DxqzxhdSplZbCbfxxbDao]   
 * @Description:  [一句话描述该类的功能]   
 * @Author:       [wu.w@founder.com.cn]  
 * @CreateDate:   [2015-5-15 下午2:44:12]   
 * @UpdateUser:   [way(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-5-15 下午2:44:12，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 * @review      : tian_chengwei@founder.com.cn
 * @reviewDate  : 20150604
 */
@Repository("dxqzxhdSplZbCbfxxbDao")
public class DxqzxhdSplZbCbfxxbDao extends BaseDaoImpl{

	/**
	 * @Title: query
	 * @Description: query by id
	 * @param @param hdid
	 * @param @return    设定文件
	 * @return DxqzxhdSplZbCbfxxb    返回类型
	 * @throws
	 */
	public DxqzxhdSplZbCbfxxb query(String hdid){
		return (DxqzxhdSplZbCbfxxb)queryForObject("dxqzxhdsplzbcbfxxb.query", hdid);
	}
	
	/**
	 * @Title: saveCbf
	 * @Description: save
	 * @param @param entity    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public void saveCbf(DxqzxhdSplZbCbfxxb entity){
		insert("dxqzxhdsplzbcbfxxb.save",entity);
	}
	
	/**
	 * @Title: updateCbf
	 * @Description: update
	 * @param @param entity    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public void updateCbf(DxqzxhdSplZbCbfxxb entity){
		update("dxqzxhdsplzbcbfxxb.update",entity);
	}
	
	/**
	 * @Title: deleteCbf
	 * @Description: delete
	 * @param @param entity    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public void deleteCbf(DxqzxhdSplZbCbfxxb entity){
		update("dxqzxhdsplzbcbfxxb.delete",entity);
	}
}
