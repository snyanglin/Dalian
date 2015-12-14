/**********************************************************************   
 * <p>文件名：DxqzxhdSplZbSycsxxbDao.java </p>
 * <p>文件描述：TODO(描述该文件做什么) 
 * @project_name：syrk
 * @author wu.w@founder.com.cn 
 * @date 2015-5-15 下午2:44:40 
 * @history
 * @department：研发部
 *
*/
package com.founder.zafffwqz.dao;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.zafffwqz.bean.DxqzxhdSplZbSycsxxb;

/******************************************************************************
 * @Package:      [com.founder.zafffwqz.dao.DxqzxhdSplZbSycsxxbDao.java]  
 * @ClassName:    [DxqzxhdSplZbSycsxxbDao]   
 * @Description:  [一句话描述该类的功能]   
 * @Author:       [wu.w@founder.com.cn]  
 * @CreateDate:   [2015-5-15 下午2:44:40]   
 * @UpdateUser:   [way(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-5-15 下午2:44:40，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 * @review      : tian_chengwei@founder.com.cn
 * @reviewDate  : 20150604
 */
@Repository("dxqzxhdSplZbSycsxxbDao")
public class DxqzxhdSplZbSycsxxbDao extends BaseDaoImpl{

	/**
	 * @Title: query
	 * @Description: query by id
	 * @param @param hdid
	 * @param @return    设定文件
	 * @return DxqzxhdSplZbSycsxxb    返回类型
	 * @throws
	 */
	public DxqzxhdSplZbSycsxxb query(String hdid){
		return (DxqzxhdSplZbSycsxxb)queryForObject("dxqzxhdsplzbsycsxxb.query", hdid);
	}
	
	/**
	 * @Title: saveSycs
	 * @Description: save
	 * @param @param entity    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public void saveSycs(DxqzxhdSplZbSycsxxb entity){
		insert("dxqzxhdsplzbsycsxxb.save",entity);
	}
	
	/**
	 * @Title: updateSycs
	 * @Description: update
	 * @param @param entity    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public void updateSycs(DxqzxhdSplZbSycsxxb entity){
		update("dxqzxhdsplzbsycsxxb.update",entity);
	}
	
	/**
	 * @Title: deleteSycs
	 * @Description: delete
	 * @param @param entity    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public void deleteSycs(DxqzxhdSplZbSycsxxb entity){
		update("dxqzxhdsplzbsycsxxb.delete",entity);
	}
}
