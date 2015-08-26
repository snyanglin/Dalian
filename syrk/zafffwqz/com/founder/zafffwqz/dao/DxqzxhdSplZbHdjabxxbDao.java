/**********************************************************************   
 * <p>文件名：DxqzxhdSplZbHdjabxxbDao.java </p>
 * <p>文件描述：TODO(描述该文件做什么) 
 * @project_name：syrk
 * @author wu.w@founder.com.cn 
 * @date 2015-5-15 下午2:44:25 
 * @history
 * @department：研发部
 *
*/
package com.founder.zafffwqz.dao;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.zafffwqz.bean.DxqzxhdSplZbHdjabxxb;

/******************************************************************************
 * @Package:      [com.founder.zafffwqz.dao.DxqzxhdSplZbHdjabxxbDao.java]  
 * @ClassName:    [DxqzxhdSplZbHdjabxxbDao]   
 * @Description:  [一句话描述该类的功能]   
 * @Author:       [wu.w@founder.com.cn]  
 * @CreateDate:   [2015-5-15 下午2:44:25]   
 * @UpdateUser:   [way(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-5-15 下午2:44:25，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 * @review      : tian_chengwei@founder.com.cn
 * @reviewDate  : 20150604
 */
@Repository("dxqzxhdSplZbHdjabxxbDao")
public class DxqzxhdSplZbHdjabxxbDao extends BaseDaoImpl{

	/**
	 * @Title: query
	 * @Description: query by id
	 * @param @param hdid
	 * @param @return    设定文件
	 * @return DxqzxhdSplZbHdjabxxb    返回类型
	 * @throws
	 */
	public DxqzxhdSplZbHdjabxxb query(String hdid){
		return (DxqzxhdSplZbHdjabxxb)queryForObject("dxqzxhdsplzbhdjabxxb.query", hdid);
	}
	
	/**
	 * @Title: saveHdab
	 * @Description: save
	 * @param @param entity    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public void saveHdab(DxqzxhdSplZbHdjabxxb entity){
		insert("dxqzxhdsplzbhdjabxxb.save",entity);
	}
	
	/**
	 * @Title: updateHdab
	 * @Description: update
	 * @param @param entity    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public void updateHdab(DxqzxhdSplZbHdjabxxb entity){
		update("dxqzxhdsplzbhdjabxxb.update",entity);
	}
	
	/**
	 * @Title: deleteHdab
	 * @Description: delete by logic
	 * @param @param entity    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public void deleteHdab(DxqzxhdSplZbHdjabxxb entity){
		update("dxqzxhdsplzbhdjabxxb.delete",entity);
	}
}
