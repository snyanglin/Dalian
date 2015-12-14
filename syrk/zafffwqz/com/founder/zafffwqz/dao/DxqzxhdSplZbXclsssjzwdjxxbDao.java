/**********************************************************************   
 * <p>文件名：DxqzxhdSplZbXclsssjzwdjxxbDao.java </p>
 * <p>文件描述：TODO(描述该文件做什么) 
 * @project_name：syrk
 * @author wu.w@founder.com.cn 
 * @date 2015-5-15 下午2:44:58 
 * @history
 * @department：研发部
 *
*/
package com.founder.zafffwqz.dao;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.zafffwqz.bean.DxqzxhdSplZbXclsssjzwdjxxb;

/******************************************************************************
 * @Package:      [com.founder.zafffwqz.dao.DxqzxhdSplZbXclsssjzwdjxxbDao.java]  
 * @ClassName:    [DxqzxhdSplZbXclsssjzwdjxxbDao]   
 * @Description:  [一句话描述该类的功能]   
 * @Author:       [wu.w@founder.com.cn]  
 * @CreateDate:   [2015-5-15 下午2:44:58]   
 * @UpdateUser:   [way(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-5-15 下午2:44:58，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 * @review      : tian_chengwei@founder.com.cn
 * @reviewDate  : 20150604
 */
@Repository("dxqzxhdSplZbXclsssjzwdjxxbDao")
public class DxqzxhdSplZbXclsssjzwdjxxbDao extends BaseDaoImpl {

	/**
	 * @Title: query
	 * @Description: query by id
	 * @param @param hdid
	 * @param @return    设定文件
	 * @return DxqzxhdSplZbXclsssjzwdjxxb    返回类型
	 * @throws
	 */
	public DxqzxhdSplZbXclsssjzwdjxxb query(String hdid){
		return (DxqzxhdSplZbXclsssjzwdjxxb)queryForObject("dxqzxhdsplzbxclsssjzwdjxxb.query", hdid);
	}
	
	/**
	 * @Title: saveLsjz
	 * @Description: save
	 * @param @param entity    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public void saveLsjz(DxqzxhdSplZbXclsssjzwdjxxb entity){
		insert("dxqzxhdsplzbxclsssjzwdjxxb.save",entity);
	}
	
	/**
	 * @Title: updateLsjz
	 * @Description: update
	 * @param @param entity    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public void updateLsjz(DxqzxhdSplZbXclsssjzwdjxxb entity){
		update("dxqzxhdsplzbxclsssjzwdjxxb.update",entity);
	}
	
	/**
	 * @Title: deleteLsjz
	 * @Description: delete
	 * @param @param entity    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public void deleteLsjz(DxqzxhdSplZbXclsssjzwdjxxb entity){
		update("dxqzxhdsplzbxclsssjzwdjxxb.delete",entity);
	}
}
