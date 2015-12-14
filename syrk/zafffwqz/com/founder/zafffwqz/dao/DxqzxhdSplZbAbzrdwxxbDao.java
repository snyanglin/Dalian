/**********************************************************************   
 * <p>文件名：DxqzxhdSplZbAbzrdwxxbDao.java </p>
 * <p>文件描述：TODO(描述该文件做什么) 
 * @project_name：syrk
 * @author wu.w@founder.com.cn 
 * @date 2015-5-15 下午2:43:57 
 * @history
 * @department：研发部
 *
*/
package com.founder.zafffwqz.dao;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.zafffwqz.bean.DxqzxhdSplZbAbzlxqxxb;
import com.founder.zafffwqz.bean.DxqzxhdSplZbAbzrdwxxb;

/******************************************************************************
 * @Package:      [com.founder.zafffwqz.dao.DxqzxhdSplZbAbzrdwxxbDao.java]  
 * @ClassName:    [DxqzxhdSplZbAbzrdwxxbDao]   
 * @Description:  [一句话描述该类的功能]   
 * @Author:       [wu.w@founder.com.cn]  
 * @CreateDate:   [2015-5-15 下午2:43:57]   
 * @UpdateUser:   [way(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-5-15 下午2:43:57，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 * @review      : tian_chengwei@founder.com.cn
 * @reviewDate  : 20150604
 */
@Repository("dxqzxhdSplZbAbzrdwxxbDao")
public class DxqzxhdSplZbAbzrdwxxbDao extends BaseDaoImpl{

	/**
	 * @Title: query
	 * @Description: query by id
	 * @param @param hdid
	 * @param @return    设定文件
	 * @return DxqzxhdSplZbAbzrdwxxb    返回类型
	 * @throws
	 */
	public DxqzxhdSplZbAbzrdwxxb query(String hdid){
		return (DxqzxhdSplZbAbzrdwxxb)queryForObject("dxqzxhdsplzbabzrdwxxb.query", hdid);
	}
	
	/**
	 * @Title: saveAbdw
	 * @Description: save
	 * @param @param entity    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public void saveAbdw(DxqzxhdSplZbAbzrdwxxb entity){
		insert("dxqzxhdsplzbabzrdwxxb.save",entity);
	}
	
	/**
	 * @Title: updateAbdw
	 * @Description: update
	 * @param @param entity    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public void updateAbdw(DxqzxhdSplZbAbzrdwxxb entity){
		update("dxqzxhdsplzbabzrdwxxb.update",entity);
	}
	
	/**
	 * @Title: deleteAbdw
	 * @Description: delete
	 * @param @param entity    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public void deleteAbdw(DxqzxhdSplZbAbzrdwxxb entity){
		update("dxqzxhdsplzbabzrdwxxb.delete",entity);
	}
	
	/**
	 * @Title: saveAbxq
	 * @Description:save abjlxx
	 * @param @param entity    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public void saveAbxq(DxqzxhdSplZbAbzlxqxxb entity){
		insert("dxqzxhdsplzbabzrdwxxb.saveAbxq",entity);
	}
	
	/**
	 * @Title: deleteAbxq
	 * @Description: 物理删除安保警力信息，作为主信息字段存储，不需要累计过往历史
	 * @param @param hdid    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public void deleteAbxq(String hdid){
		update("dxqzxhdsplzbabzrdwxxb.deleteAbxq",hdid);
	}
}
