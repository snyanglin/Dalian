package com.founder.sydw.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.base.entity.SessionBean;
import com.founder.sydw.bean.Dwlscftzs;
import com.founder.sydw.bean.Dwzdhzyhzgtzs;
import com.founder.sydw.bean.Dwzlzgtzs;
/**
 * ****************************************************************************
 * @Package:      [com.founder.sydw.dao.DwjczgDao.java]  
 * @ClassName:    [DwjczgDao]   
 * @Description:  单位检查整改
 * @Author:       [yu_guangli@founder.com.cn]  
 * @CreateDate:   [2015-6-24 下午1:39:16]   
 * @UpdateUser:   [yuguangli(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-6-24 下午1:39:16，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Repository("dwjczgDao")
public class DwjczgDao extends BaseDaoImpl {
	/**
	 * 
	 * @Title: saveZlzgtzs
	 * @Description: 保存责令整改通知书
	 * @param @param entity
	 * @param @param sessionBean    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public void saveZlzgtzs(Dwzlzgtzs entity, SessionBean sessionBean) {
		insert("Dwjczgxx.saveZlzgtzs", entity);
	}
	/**
	 * 
	 * @Title: queryZlzgtzs
	 * @Description: 查询责令整改通知书
	 * @param @param param
	 * @param @return    设定文件
	 * @return Dwzlzgtzs    返回类型
	 * @throws
	 */
	public Dwzlzgtzs queryZlzgtzs(Map<String,Object> param) {
		Dwzlzgtzs returnValue = null;
		List<?> list = queryForList("Dwjczgxx.queryZlzgtzs", param);
		if (list != null && list.size() > 0) {
			returnValue = (Dwzlzgtzs) list.get(0);
		}
		return returnValue;
	}
	/**
	 * 
	 * @Title: saveLscftzs
	 * @Description: 保存临时查封通知书
	 * @param @param entity
	 * @param @param sessionBean    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public void saveLscftzs(Dwlscftzs entity, SessionBean sessionBean) {
		insert("Dwjczgxx.saveLscftzs", entity);
	}
	/**
	 * 
	 * @Title: queryLscftzs
	 * @Description: 查询临时查封通知书
	 * @param @param param
	 * @param @return    设定文件
	 * @return Dwlscftzs    返回类型
	 * @throws
	 */
	public Dwlscftzs queryLscftzs(Map<String,Object> param) {
		Dwlscftzs returnValue = null;
		List<?> list = queryForList("Dwjczgxx.queryLscftzs", param);
		if (list != null && list.size() > 0) {
			returnValue = (Dwlscftzs) list.get(0);
		}
		return returnValue;
	}
	/**
	 * 
	 * @Title: saveZdhzyhzgtzs
	 * @Description: 保存重大火灾隐患整改通知书
	 * @param @param entity
	 * @param @param sessionBean    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public void saveZdhzyhzgtzs(Dwzdhzyhzgtzs entity, SessionBean sessionBean) {
		insert("Dwjczgxx.saveZdhzyhzgtzs", entity);
	}
	/**
	 * 
	 * @Title: queryZdhzyhzgtzs
	 * @Description: 查询重大火灾隐患整改通知书
	 * @param @param param
	 * @param @return    设定文件
	 * @return Dwzdhzyhzgtzs    返回类型
	 * @throws
	 */
	public Dwzdhzyhzgtzs queryZdhzyhzgtzs(Map<String,Object> param) {
		Dwzdhzyhzgtzs returnValue = null;
		List<?> list = queryForList("Dwjczgxx.queryZdhzyhzgtzs", param);
		if (list != null && list.size() > 0) {
			returnValue = (Dwzdhzyhzgtzs) list.get(0);
		}
		return returnValue;
	}
	/**
	 * 
	 * @Title: queryXh
	 * @Description: 查询序号 
	 * @param @param param
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	public String queryXh(Map<String,Object> param){
		String xh =  (String)queryForObject("Dwjczgxx.queryXh", param);
		return xh;
	}
}
