/**********************************************************************   
 * <p>文件名：serialNumberDao.java </p>
 * <p>文件描述：TODO(描述该文件做什么) 
 * @project_name：syrk
 * @author wu_chunhui@founder.com.cn 
 * @date 2014-12-18 上午11:18:18 
 * @history
 * @department：研发部
 *
*/
package com.founder.service.serialNumberService.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.service.serialNumberService.bean.GgYwgzxxb;

/******************************************************************************
 * @Package:      [com.founder.service.serialNumberService.dao.serialNumberDao.java]  
 * @ClassName:    [serialNumberDao]   
 * @Description:  [一句话描述该类的功能]   
 * @Author:       [wu_chunhui@founder.com.cn]  
 * @CreateDate:   [2014-12-18 上午11:18:18]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2014-12-18 上午11:18:18，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 */
@Repository("serialNumberDao")
public class SerialNumberDao extends BaseDaoImpl {
	
	
	/***
	 * 
	 * @Title: creatSequence
	 * @Description: TODO(动态生成序列)
	 * @param @param sequenceName    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public void creatSequence(String sequenceName) {
	// super.insert("dwbh.creatSequence",sequenceName);
	 String sql ="create sequence "+sequenceName+"  start with 1 increment by 1 nomaxvalue minvalue 0";
	 try {
		super.getSqlMapClient().getDataSource().getConnection().createStatement().execute(sql);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
	}
	
	/***
	 * 
	 * @Title: resetSequence
	 * @Description: TODO(重置sequence为重1开始)
	 * @param @param sequenceName    序列名称
	 * @return void    返回类型
	 * @throws
	 */
	public void resetSequence(String sequenceName){
		Map<String,String> pMap = new HashMap<String,String> ();
		pMap.put("sequenceName", sequenceName);
		super.update("dwbh.resetSequence", pMap);
	}
	
	
	public GgYwgzxxb queryYwgzxxb(String ywmc){
		return (GgYwgzxxb)super.queryForObject("dwbh.queryYwgzsj", ywmc);
	}
	
	
	public void saveYwgzxxb(GgYwgzxxb ggYwgzxxb){
		super.insert("dwbh.updateYwgzb", ggYwgzxxb);
	}
	
	public void updateYwgzxxb(GgYwgzxxb ggYwgzxxb){
		
		super.update("dwbh.updateYwgzb", ggYwgzxxb);
	}
	
}
