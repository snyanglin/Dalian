package com.founder.zdrygl.core.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;

/**
 * ****************************************************************************
 * @Package:      [com.founder.zdrygl.core.dao.ZdryUtilsDao.java]  
 * @ClassName:    [ZdryUtilsDao]   
 * @Description:  [重点人员核心功能初始化数据操作DAO]   
 * @Author:       [wei.wen@founder.com.cn]  
 * @CreateDate:   [2015年9月14日 下午9:02:49]   
 * @UpdateUser:   [wei.wen@founder.com.cn(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015年9月14日 下午9:02:49，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Repository
public class ZdryInitializeDao extends BaseDaoImpl{

	/**
	 * 
	 * @Title: queryZdrylxMap
	 * @Description: (根据区域代码取重点人员类别对应CLASS)
	 * @param @param qydm
	 * @param @return    设定文件
	 * @return List<Map<String,String>>    返回类型
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	public Map<String,String> queryZdrylxMap(String qydm){
		return queryForMap("ZdryInitialize.queryZdrylbMap", qydm, "key","value");
	}

	/**
	 * 
	 * @Title: queryZdryDict
	 * @Description: (根据区域代码取重点人员字典)
	 * @param @param string
	 * @param @return    设定文件
	 * @return Map<? extends String,? extends String>    返回类型
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	public Map<String,String> queryZdryDict(String qydm) {
		Map<String,String> map=new HashMap<String,String>();
		map.put("qydm", qydm);
		return queryForMap("ZdryInitialize.queryZdryDict", map, "key","value");
	}
	
	/**
	 * 
	 * @Title: queryZdryDict
	 * @Description: TODO(根据区域代码取重点人员字典)
	 * @param @param qydm
	 * @param @return    设定文件
	 * @return List    返回类型
	 * @throw
	 */
	public List<?> queryZdryDict(String lbdm_p,String qydm) {
		Map<String,String> map=new HashMap<String,String>();
		map.put("lbdm_p", lbdm_p);
		map.put("qydm", qydm);
		return queryForList("ZdryInitialize.queryZdryDict", map);
	}
}
