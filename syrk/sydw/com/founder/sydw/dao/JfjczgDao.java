package com.founder.sydw.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.base.entity.SessionBean;
import com.founder.sydw.bean.Dwlscftzs;
import com.founder.sydw.bean.Dwzdhzyhzgtzs;
import com.founder.sydw.bean.Dwzlzgtzs;
import com.founder.sydw.bean.JFDwzlzgtzs;
import com.founder.sydw.bean.JfFcyjs;
/**
 * ****************************************************************************
 * @Package:      [com.founder.sydw.dao.jfjczgDao.java]  
 * @ClassName:    [jfjczgDao]   
 * @Description:  技防检查整改
 * @Author:       [xu_haibo@founder.com.cn]  
 * @CreateDate:   [2015-6-29 下午1:39:16]   
 * @UpdateUser:   [xuhaibo(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-6-29 下午1:39:16，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Repository("jfjczgDao")
public class JfjczgDao extends BaseDaoImpl {
	/**
	 * 
	 * @Title: saveJFzlzgtzs
	 * @Description: 保存技防责令整改通知书
	 * @param @param entity
	 * @param @param sessionBean    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public void saveJFzlzgtzs(JFDwzlzgtzs entity, SessionBean sessionBean) {
		insert("JFjczgxx.saveJFzlzgtzs", entity);
	}
	/**
	 * 
	 * @Title: queryJFzlzgtzs
	 * @Description: 查询技防责令整改通知书
	 * @param @param param
	 * @param @return    设定文件
	 * @return JFDwzlzgtzs    返回类型
	 * @throws
	 */
	public JFDwzlzgtzs queryJFzlzgtzs(Map<String,Object> param) {
		JFDwzlzgtzs returnValue = null;
		List<?> list = queryForList("JFjczgxx.queryJFzlzgtzs", param);
		if (list != null && list.size() > 0) {
			returnValue = (JFDwzlzgtzs) list.get(0);
		}
		return returnValue;
	}
	/**
	 * 
	 * @Title: saveJFfcyjs
	 * @Description: 保存技防复查意见书
	 * @param @param entity
	 * @param @param sessionBean    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public void saveJFfcyjs(JfFcyjs entity, SessionBean sessionBean) {
		insert("JFjczgxx.saveJFfcyjs", entity);
	}
	/**
	 * 
	 * @Title: queryJFfcyjs
	 * @Description: 查询技防复查意见书
	 * @param @param param
	 * @param @return    设定文件
	 * @return JfFcyjs    返回类型
	 * @throws
	 */
	public JfFcyjs queryJFfcyjs(Map<String,Object> param) {
		JfFcyjs returnValue = null;
		List<?> list = queryForList("JFjczgxx.queryJFfcyjs", param);
		if (list != null && list.size() > 0) {
			returnValue = (JfFcyjs) list.get(0);
		}
		return returnValue;
	}
}
